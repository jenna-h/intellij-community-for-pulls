// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package com.intellij.packageDependencies.ui;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.module.ModuleGrouperKt;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.NlsActions;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.scope.packageSet.PackageSet;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Set;

public abstract class PatternDialectProvider {
  public static final ExtensionPointName<PatternDialectProvider> EP_NAME = ExtensionPointName.create("com.intellij.patternDialectProvider");

  public static PatternDialectProvider getInstance(String shortName) {
    for (PatternDialectProvider provider : EP_NAME.getExtensionList()) {
      if (Comparing.strEqual(provider.getShortName(), shortName)) return provider;
    }
    return ProjectPatternProvider.FILE.equals(shortName) ? null : getInstance(ProjectPatternProvider.FILE);
  }

  public abstract TreeModel createTreeModel(Project project, Marker marker);

  public abstract TreeModel createTreeModel(Project project, Set<? extends PsiFile> deps, Marker marker,
                                            final DependenciesPanel.DependencyPanelSettings settings);

  @Contract(pure = true)
  public abstract @NlsActions.ActionText String getDisplayName();

  @Contract(pure = true)
  public abstract @NonNls @NotNull String getShortName();

  public abstract AnAction[] createActions(Project project, final Runnable update);

  public abstract @Nullable PackageSet createPackageSet(final PackageDependenciesNode node, final boolean recursively);

  protected static @Nullable String getModulePattern(final PackageDependenciesNode node) {
    final ModuleNode moduleParent = getModuleParent(node);
    return moduleParent != null ? moduleParent.getModuleName() : null;
  }

  protected static @Nullable ModuleNode getModuleParent(PackageDependenciesNode node) {
    if (node instanceof ModuleNode) return (ModuleNode)node;
    if (node == null || node instanceof RootNode) return null;
    return getModuleParent((PackageDependenciesNode)node.getParent());
  }

  public abstract Icon getIcon();

  public @Nls @NotNull String getHintMessage() {
    return "";
  }

  protected static @NotNull String getGroupModulePattern(ModuleGroupNode node) {
    if (ModuleGrouperKt.isQualifiedModuleNamesEnabled(node.getProject())) {
      return node.getModuleGroup().getQualifiedName() + "*";
    }
    else {
      return "group:" + node.getModuleGroup().toString();
    }
  }
}
