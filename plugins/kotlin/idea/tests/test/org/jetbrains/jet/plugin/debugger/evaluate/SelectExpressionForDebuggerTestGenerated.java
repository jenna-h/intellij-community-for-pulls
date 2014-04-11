/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.plugin.debugger.evaluate;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.plugin.debugger.evaluate.AbstractSelectExpressionForDebuggerTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/debugger/selectExpression")
public class SelectExpressionForDebuggerTestGenerated extends AbstractSelectExpressionForDebuggerTest {
    public void testAllFilesPresentInSelectExpression() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("idea/testData/debugger/selectExpression"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("binaryExpression.kt")
    public void testBinaryExpression() throws Exception {
        doTest("idea/testData/debugger/selectExpression/binaryExpression.kt");
    }
    
    @TestMetadata("call.kt")
    public void testCall() throws Exception {
        doTest("idea/testData/debugger/selectExpression/call.kt");
    }
    
    @TestMetadata("expressionInPropertyInitializer.kt")
    public void testExpressionInPropertyInitializer() throws Exception {
        doTest("idea/testData/debugger/selectExpression/expressionInPropertyInitializer.kt");
    }
    
    @TestMetadata("extensionFun.kt")
    public void testExtensionFun() throws Exception {
        doTest("idea/testData/debugger/selectExpression/extensionFun.kt");
    }
    
    @TestMetadata("funArgument.kt")
    public void testFunArgument() throws Exception {
        doTest("idea/testData/debugger/selectExpression/funArgument.kt");
    }
    
    @TestMetadata("functionLiteral.kt")
    public void testFunctionLiteral() throws Exception {
        doTest("idea/testData/debugger/selectExpression/functionLiteral.kt");
    }
    
    @TestMetadata("getConvention.kt")
    public void testGetConvention() throws Exception {
        doTest("idea/testData/debugger/selectExpression/getConvention.kt");
    }
    
    @TestMetadata("infixCall.kt")
    public void testInfixCall() throws Exception {
        doTest("idea/testData/debugger/selectExpression/infixCall.kt");
    }
    
    @TestMetadata("infixCallArgument.kt")
    public void testInfixCallArgument() throws Exception {
        doTest("idea/testData/debugger/selectExpression/infixCallArgument.kt");
    }
    
    @TestMetadata("isExpression.kt")
    public void testIsExpression() throws Exception {
        doTest("idea/testData/debugger/selectExpression/isExpression.kt");
    }
    
    @TestMetadata("keyword.kt")
    public void testKeyword() throws Exception {
        doTest("idea/testData/debugger/selectExpression/keyword.kt");
    }
    
    @TestMetadata("modifier.kt")
    public void testModifier() throws Exception {
        doTest("idea/testData/debugger/selectExpression/modifier.kt");
    }
    
    @TestMetadata("param.kt")
    public void testParam() throws Exception {
        doTest("idea/testData/debugger/selectExpression/param.kt");
    }
    
    @TestMetadata("propertyCall.kt")
    public void testPropertyCall() throws Exception {
        doTest("idea/testData/debugger/selectExpression/propertyCall.kt");
    }
    
    @TestMetadata("propertyDeclaration.kt")
    public void testPropertyDeclaration() throws Exception {
        doTest("idea/testData/debugger/selectExpression/propertyDeclaration.kt");
    }
    
    @TestMetadata("qualifiedExpressionProperty.kt")
    public void testQualifiedExpressionProperty() throws Exception {
        doTest("idea/testData/debugger/selectExpression/qualifiedExpressionProperty.kt");
    }
    
    @TestMetadata("qualifiedExpressionReceiver.kt")
    public void testQualifiedExpressionReceiver() throws Exception {
        doTest("idea/testData/debugger/selectExpression/qualifiedExpressionReceiver.kt");
    }
    
    @TestMetadata("qualifiedExpressionSelector.kt")
    public void testQualifiedExpressionSelector() throws Exception {
        doTest("idea/testData/debugger/selectExpression/qualifiedExpressionSelector.kt");
    }
    
    @TestMetadata("super.kt")
    public void testSuper() throws Exception {
        doTest("idea/testData/debugger/selectExpression/super.kt");
    }
    
    @TestMetadata("this.kt")
    public void testThis() throws Exception {
        doTest("idea/testData/debugger/selectExpression/this.kt");
    }
    
    @TestMetadata("thisWithLabel.kt")
    public void testThisWithLabel() throws Exception {
        doTest("idea/testData/debugger/selectExpression/thisWithLabel.kt");
    }
    
    @TestMetadata("unaryExpression.kt")
    public void testUnaryExpression() throws Exception {
        doTest("idea/testData/debugger/selectExpression/unaryExpression.kt");
    }
    
}
