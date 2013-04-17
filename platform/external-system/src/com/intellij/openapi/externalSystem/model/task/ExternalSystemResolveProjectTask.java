package com.intellij.openapi.externalSystem.model.task;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.externalSystem.model.DataNode;
import com.intellij.openapi.externalSystem.model.ProjectSystemId;
import com.intellij.openapi.externalSystem.model.project.ProjectData;
import com.intellij.openapi.externalSystem.service.ExternalSystemFacadeManager;
import com.intellij.openapi.externalSystem.service.project.change.ProjectStructureChangesModel;
import com.intellij.openapi.externalSystem.service.remote.ExternalSystemExecutionSettings;
import com.intellij.openapi.externalSystem.service.remote.RemoteExternalSystemProjectResolver;
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsManager;
import com.intellij.openapi.externalSystem.util.ExternalSystemBundle;
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Thread-safe.
 * 
 * @author Denis Zhdanov
 * @since 1/24/12 7:21 AM
 */
public class ExternalSystemResolveProjectTask extends AbstractExternalSystemTask {

  private final AtomicReference<DataNode<ProjectData>> myExternalProject = new AtomicReference<DataNode<ProjectData>>();

  @NotNull private final String  myProjectPath;
  private final          boolean myResolveLibraries;

  public ExternalSystemResolveProjectTask(@NotNull ProjectSystemId externalSystemId,
                                          @NotNull Project project,
                                          @NotNull String projectPath,
                                          boolean resolveLibraries)
  {
    super(externalSystemId, ExternalSystemTaskType.RESOLVE_PROJECT, project);
    myProjectPath = projectPath;
    myResolveLibraries = resolveLibraries;
  }

  @SuppressWarnings("unchecked")
  protected void doExecute() throws Exception {
    final ExternalSystemFacadeManager manager = ServiceManager.getService(ExternalSystemFacadeManager.class);
    Project ideProject = getIdeProject();
    RemoteExternalSystemProjectResolver resolver = manager.getFacade(ideProject, getExternalSystemId()).getResolver();
    setState(ExternalSystemTaskState.IN_PROGRESS);

    ExternalSystemSettingsManager settingsManager = ServiceManager.getService(ExternalSystemSettingsManager.class);
    ProjectStructureChangesModel model = null;
    if (!ideProject.isDisposed()) {
      model = ServiceManager.getService(ProjectStructureChangesModel.class);
    }
    ExternalSystemExecutionSettings settings = settingsManager.getExecutionSettings(ideProject, getExternalSystemId());
    DataNode<ProjectData> project = resolver.resolveProjectInfo(getId(), myProjectPath, myResolveLibraries, settings);
    
    if (project == null) {
      return;
    }
    myExternalProject.set(project);
    setState(ExternalSystemTaskState.FINISHED);
    
    if (model != null) {
      // This task may be called during the 'import from gradle' processing, hence, no project-level IoC is up.
      // Model update is necessary for the correct tool window project structure diff showing but we don't have
      // gradle tool window on this stage.
      model.update(project, ideProject, false);
    }
  }

  @Nullable
  public DataNode<ProjectData> getExternalProject() {
    return myExternalProject.get();
  }

  @Override
  @NotNull
  protected String wrapProgressText(@NotNull String text) {
    return ExternalSystemBundle.message("progress.update.text", ExternalSystemUtil.toReadableName(getExternalSystemId()), text);
  }
}
