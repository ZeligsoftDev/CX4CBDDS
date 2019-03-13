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
package com.zeligsoft.cx.codegen.ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.jface.action.Action;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.cx.codegen.CodeGenWorkflowConstants;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;

public abstract class AbstractTransformAction extends Action{
	
	protected List<WorkflowEntry> workflows = null;

	protected EObject element = null;
	
	/**
	 * Create an Eclipse Job to run the specified workflows.
	 */
	protected void doTransform() {
		WorkspaceJob transformJob
			= new WorkspaceJob(
					workflows.size() == 1
						? Messages.GenerateJob_RunOne
						: Messages.GenerateJob_RunNonOne )
		{
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) {

				MultiStatus resultStatus = new MultiStatus(
					CodeGenUIPlugin.PLUGIN_ID, 0, NLS.bind(
						Messages.GenerateJob_ResultMessage, null), null);
				boolean b_abort = false;

				Map<String, String> genProperties = new HashMap<String, String>();

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				String location = root.getLocation().toOSString();
				genProperties.put(CodeGenWorkflowConstants.PLATFORM_URI, location);

				Resource res = element.eResource();
				genProperties.put(CodeGenWorkflowConstants.MODEL_URI_STRING, res
					.getURI().toString());

				// where we want to look for a build environment
				if (element instanceof NamedElement) {
					genProperties.put(CodeGenWorkflowConstants.BUILD_ELEMENT,
						((NamedElement) element).getQualifiedName());
				}

				HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
				externalSlotContents.put( CodeGenWorkflowConstants.ELEMENT_STRING, element );
				externalSlotContents.put( CodeGenWorkflowConstants.PROGRESS_MONITOR, monitor );

				IProject project = ProjectFactory.getProject(element, monitor,
					ProjectFactory.MODE_CREATE_BASIC);
				if (project != null) {

					// save the project name
					genProperties.put(CodeGenWorkflowConstants.GENERATED_PROJECT,
						project.getName());

					String srcGen = project.getLocation().makeAbsolute()
						.toOSString();
					genProperties.put(CodeGenWorkflowConstants.SRC_GEN, srcGen);

					try {
						Iterator<WorkflowEntry> i = workflows.iterator();
						while (i.hasNext()) {
							
							WorkflowEntry entry = i.next();
							
							if( entry.getValidationFactory() != null )
							{
								IBatchValidator validator = entry.getValidationFactory().createValidator();
								//rc.add( validator.validate( this.selectedElement, monitor ) );
								//if(PlatformUI.isWorkbenchRunning()){
									IStatus result = validator.validate(element, monitor);
									if (result.getSeverity() == IStatus.CANCEL){
										//we've cancelled the operation, skip the codegen workflow, pass along the OperationCanceledException
										throw new OperationCanceledException();
									} else if( result.getSeverity() == IStatus.ERROR ) {
										if( entry.doesValidationErrorCancel() ) {
											resultStatus.add(createStatus(result.getSeverity(), "Plug-in Vendor: " + entry.getDiagnosticInfo().getBundleVendor())); //$NON-NLS-1$
										    resultStatus.add(createStatus(result.getSeverity(), "Plug-in Name: " + entry.getDiagnosticInfo().getBundleName())); //$NON-NLS-1$
										    resultStatus.add(createStatus(result.getSeverity(), "Plug-in ID: " + entry.getDiagnosticInfo().getSymbolicName())); //$NON-NLS-1$
										    resultStatus.add(createStatus(result.getSeverity(), "Version: " + entry.getDiagnosticInfo().getBundleVersion())); //$NON-NLS-1$
										    resultStatus.add(result);
										    b_abort = true;
										}
									}
								//}
							}
							
							if( !b_abort ) {
								IStatus status = WorkflowUtil.executeWorkflow(
									entry.getWorkflowURL(), monitor, genProperties,
									externalSlotContents);
								if( status.isOK() == false) {
								    resultStatus.add(createStatus(status.getSeverity(), "Plug-in Vendor: " + entry.getDiagnosticInfo().getBundleVendor())); //$NON-NLS-1$
								    resultStatus.add(createStatus(status.getSeverity(), "Plug-in Name: " + entry.getDiagnosticInfo().getBundleName())); //$NON-NLS-1$
								    resultStatus.add(createStatus(status.getSeverity(), "Plug-in ID: " + entry.getDiagnosticInfo().getSymbolicName())); //$NON-NLS-1$
								    resultStatus.add(createStatus(status.getSeverity(), "Version: " + entry.getDiagnosticInfo().getBundleVersion())); //$NON-NLS-1$
								}
								resultStatus.add(status);
							}
						}
					} finally {
						try {
							project.refreshLocal(IResource.DEPTH_INFINITE,
								monitor);
						} catch (CoreException e) {
							CodeGenUIPlugin
								.getDefault()
								.error(
									Messages.TransformAction_ProjectRefreshFailedLog,
									e);
						}
					}
				}

				// codegen has just completed, mark everything clean
//				CodeGenerationDirtyElementTable.getInstance().clearTableForResource(res);

				return resultStatus;
			}

		};

		transformJob.setUser(true);
		transformJob.schedule();
		try{
			joinThread(transformJob);
			
		} catch (InterruptedException e) {
			CodeGenUIPlugin
			.getDefault()
			.error(
				Messages.TransformAction_ThreadJoinFailedLog,
				e);
		}
	}

	protected Status createStatus(int severity, String msg) {
	    Status status = new Status(severity, CodeGenUIPlugin.PLUGIN_ID, IStatus.OK, msg, null);
	    return status;
	}
	
	/**
	 * Sets the model element specified with the workflow(s). This model
	 * element's Resource URI string will be passed to the Workflow.
	 * 
	 * @param eObject
	 * @see com.zeligsoft.cx.codegen.operations.GenerateOperation#
	 */
	public void setEObject(EObject eObject) {
		this.element = eObject;
	}

	/**
	 * Sets the list of WorkflowEntry objects to execute
	 * when the action is invoked.
	 * 
	 * @param workflows
	 */
	public void setWorkflow(List<WorkflowEntry> workflows) {
		this.workflows = workflows;
	}

	/**
	 * Set a single WorkflowEntry for this Action.
	 * 
	 * @param workflow
	 */
	public void setWorkflow(WorkflowEntry workflow) {
		List<WorkflowEntry> newList = new ArrayList<WorkflowEntry>();
		newList.add(workflow);
		this.setWorkflow(newList);
	}
	
	public EObject getEObject(){
		return element;
	}
	
	public List<WorkflowEntry> getWorkflows(){
		return workflows;
	}
	
	public abstract void joinThread(WorkspaceJob transformJob) throws InterruptedException;

}
