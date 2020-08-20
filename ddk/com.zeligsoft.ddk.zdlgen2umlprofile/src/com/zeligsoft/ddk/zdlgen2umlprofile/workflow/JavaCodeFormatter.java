/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.workflow;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.internal.corext.fix.CleanUpRefactoring;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.jdt.internal.ui.fix.ImportsCleanUp;
import org.eclipse.jdt.ui.cleanup.ICleanUp;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.TextEdit;

import com.google.common.collect.Lists;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;

public class JavaCodeFormatter {
    
    public static void format(String projectName) throws CoreException {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        
        IProject project = root.getProject(projectName);
        
        if(null != project) {
            format(project);
        }
    }
    
    public static void format(IProject project) throws CoreException {
        if(project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
            IJavaProject javaProject = JavaCore.create(project);
            format(javaProject);
        }
    }
    
    public static void cleanup(IProject project) throws CoreException {
        if(project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
            IJavaProject javaProject = JavaCore.create(project);
            cleanup(javaProject);
        }
    }

    public static void format(IJavaProject javaProject) throws JavaModelException {
        IPackageFragment[] packages = javaProject.getPackageFragments();
        for(IPackageFragment pkgFrag : packages) {
            if(pkgFrag.getKind() == IPackageFragmentRoot.K_SOURCE) {
                format(pkgFrag);
            }
        }
    }
    
    public static void cleanup(IJavaProject javaProject) throws CoreException {
        IPackageFragment[] packages = javaProject.getPackageFragments();
        List<ICompilationUnit> unitsToClean = newArrayList();
        for(IPackageFragment pkgFrag : packages) {
            if(pkgFrag.getKind() == IPackageFragmentRoot.K_SOURCE) {
                List<ICompilationUnit> pkgUnitsList = newArrayList(pkgFrag.getCompilationUnits()); 
                unitsToClean.addAll(pkgUnitsList);
            }
        }
        
        cleanup(unitsToClean);
    }

    @SuppressWarnings("deprecation")
    public static void format(IPackageFragment pkgFrag) throws JavaModelException {
        for(ICompilationUnit unit : pkgFrag.getCompilationUnits()) {
            System.out.println("Formatting: " + unit.getElementName());
            CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
            ISourceRange range = unit.getSourceRange();
            TextEdit indentEdit = formatter.format(CodeFormatter.K_COMPILATION_UNIT,
                    unit.getSource(), range.getOffset(), range.getLength(),
                    0, null);
            if(indentEdit != null) {
            	unit.applyTextEdit(indentEdit, null);
            }
            
            unit.reconcile(ICompilationUnit.NO_AST, true, null, null);
            //unit.save(null, true);
//            try {
//                //cleanup(unit);
//                
//            } catch (CoreException e) {
//                Activator.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error cleaninup", e));
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            unit.save(null, true);
            //unit.close();
        }
    }
    
    public static void cleanup(IPackageFragment pkgFrag) throws CoreException {
        List<ICompilationUnit> unitsToClean = newArrayList();
        for(ICompilationUnit unit : pkgFrag.getCompilationUnits()) {
            unitsToClean.add(unit);
        }
    }
    
    protected static final RefactoringStatus cleanup(List<ICompilationUnit> cus) throws CoreException {
        final CleanUpRefactoring ref= new CleanUpRefactoring();
        ref.setUseOptionsFromProfile(true);
        ICleanUp[] cleanUps= JavaPlugin.getDefault().getCleanUpRegistry().createCleanUps();

        return performRefactoring(ref, cus, cleanUps);
    }

    protected static RefactoringStatus performRefactoring(final CleanUpRefactoring ref, List<ICompilationUnit> cus, ICleanUp[] cleanUps) throws CoreException {
        for(ICompilationUnit cu : cus) {
            ref.addCompilationUnit(cu);
        }

        for (int i= 0; i < cleanUps.length; i++) {
            ref.addCleanUp(cleanUps[i]);
        }

        //IUndoManager undoManager= getUndoManager();
        final CreateChangeOperation create= new CreateChangeOperation(
            new CheckConditionsOperation(ref, CheckConditionsOperation.ALL_CONDITIONS),
            RefactoringStatus.FATAL);

        final PerformChangeOperation perform= new PerformChangeOperation(create);
        //perform.setUndoManager(undoManager, ref.getName());

        IWorkspace workspace= ResourcesPlugin.getWorkspace();
        executePerformOperation(perform, workspace);

        RefactoringStatus status= create.getConditionCheckingStatus();
        if (status.hasFatalError()) {
            throw new CoreException(new StatusInfo(status.getSeverity(), status.getMessageMatchingSeverity(status.getSeverity())));
        }

        //assertTrue("Change wasn't executed", perform.changeExecuted());

        //Change undo= perform.getUndoChange();
        //assertNotNull("Undo doesn't exist", undo);
        //assertTrue("Undo manager is empty", undoManager.anythingToUndo());

        return status;
    }

    private static void executePerformOperation(final PerformChangeOperation perform, IWorkspace workspace) throws CoreException {
        workspace.run(perform, new NullProgressMonitor());
    }
}
