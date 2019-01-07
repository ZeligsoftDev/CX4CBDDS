/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.domain.sca.datasoft.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;

import com.zeligsoft.base.ui.utils.BaseUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.domain.sca.datasoft.DSDomainNames;

/**
 * CCCC Report generation action.
 * 
 * @author smcfee
 *
 */
public class CCCCReportAction implements IObjectActionDelegate {
	
	protected IWorkbenchPart myPart;
	
	private ISelection selection;
	
	private String srcGen = "";
	
	
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {		
		

		try {
			
			IRunnableWithProgress op = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					
					monitor.setTaskName("Running code analysis.");
					
					Map<String, String> properties = new HashMap<String, String>();
					String defaultFlow = "workflow/parseCCCCProject.oaw";
					WorkflowRunner workflow = new WorkflowRunner();
					Issues issues = new IssuesImpl();
					
					srcGen = "";
					IProject project = ProjectFactory.getProject(BaseUtil.getEObjectFromSelection(selection), monitor,
							ProjectFactory.CREATE);
					if( project != null) {
						srcGen = project.getLocation().makeAbsolute()
						.toOSString();
						properties.put("src-gen", srcGen);
					}
					
					String location = null;
					Model dsModel = (Model)((Component)BaseUtil.getEObjectFromSelection(selection)).getModel();
					if( ZDLUtil.isZDLConcept(dsModel, DSDomainNames.DSMODEL)) {
						location = ZDLUtil.getValue(dsModel, DSDomainNames.DSMODEL, DSDomainNames.DSMODEL__LOCATION).toString();
						if( location == null ) {
							throw new IllegalArgumentException("The location property on the model element must be set prior to generating this report.");
						}
						location += "/" + ((NamedElement)BaseUtil.getEObjectFromSelection(selection)).getName() + ".cccc.xml";
					}
					properties.put("modelFile", location);
					
					HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();		
						
					final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
					if( !configOK ) {
						//throw new Exception("Failed preparing the workflow.");
					}
					final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
					if( !(executeOK && issues.getErrors().length == 0) ) {
						//throw new Exception("Workflow failed due to issues: " + issues.toString());
					}
					
					Thread.sleep(1000);
					monitor.setTaskName("Showing results.");
					Thread.sleep(1000);
				}
				
			};
			new ProgressMonitorDialog(myPart.getSite().getShell()).run(true, true, op);
		} catch (InvocationTargetException e) {
			return;
		} catch (InterruptedException e) {
			// The user canceled.
		}
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		Path path = new Path(srcGen + "/cccc/cccc.html");
		final IFile targetFile = root.getFileForLocation(path);
		

		try {
			IWorkbenchPage page2 = myPart.getSite().getPage();
			IEditorRegistry reg = myPart.getSite().getWorkbenchWindow().getWorkbench().getEditorRegistry();
			String editorID = reg.getDefaultEditor(targetFile.toString()).getId();
			
			page2.openEditor(
					new FileEditorInput(targetFile),
					editorID);
			
		} catch( Exception e ) {
			//return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to open generated report.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
