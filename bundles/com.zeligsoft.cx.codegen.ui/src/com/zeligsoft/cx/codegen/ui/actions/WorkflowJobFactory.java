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

import java.util.Collections;
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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.cx.codegen.CodeGenWorkflowConstants;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;

public class WorkflowJobFactory {
	
	public interface IElementLocator {
		public EObject getElement();
	}
	
	public interface IWorkflowsLocator {
		public List<WorkflowEntry> getWorkflows();
	}

	private final IElementLocator elementLocator;
	private IWorkflowsLocator workflowLocator;

	public WorkflowJobFactory(IElementLocator elementLocator, IWorkflowsLocator workflowLocator) {
		this.elementLocator = elementLocator;
		this.workflowLocator = workflowLocator;
	}
	
	public WorkflowJobFactory(final EObject element, final WorkflowEntry workflow) {
		this( new IElementLocator() {
			
			@Override
			public EObject getElement() {
				return element;
			}
		}, new IWorkflowsLocator() {
			
			@Override
			public List<WorkflowEntry> getWorkflows() {
				return Collections.singletonList(workflow);
			}
		});
	}

	public WorkflowJobFactory(final EObject element,
			final List<WorkflowEntry> workflows) {
		this(new IElementLocator() {
			
			@Override
			public EObject getElement() {
				return element;
			}
		}, new IWorkflowsLocator() {
			
			@Override
			public List<WorkflowEntry> getWorkflows() {
				return workflows;
			}
		});
	}

	public Job createJob() {
		WorkspaceJob transformJob = new WorkspaceJob("") { //$NON-NLS-1$
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) {

				final EObject element = elementLocator.getElement();
				final List<WorkflowEntry> workflows = workflowLocator.getWorkflows();

				this.setName(workflows.size() == 1 ? Messages.GenerateJob_RunOne
						: Messages.GenerateJob_RunNonOne);
//				ZeligsoftURIConverter.install(TransactionUtil.getEditingDomain(element)
//						.getResourceSet());
				
				MultiStatus resultStatus = new MultiStatus(
						CodeGenUIPlugin.PLUGIN_ID, 0, NLS.bind(
								Messages.GenerateJob_ResultMessage, null), null);
				boolean b_abort = false;

				Map<String, String> genProperties = new HashMap<String, String>();

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				String location = root.getLocation().toOSString();
				genProperties.put(CodeGenWorkflowConstants.PLATFORM_URI,
						location);

				Resource res = element.eResource();
				genProperties.put(CodeGenWorkflowConstants.MODEL_URI_STRING,
						res.getURI().toString());

				// IncrementalCache.C.reset(res);

				// where we want to look for a build environment
				if (element instanceof NamedElement) {
					genProperties.put(CodeGenWorkflowConstants.BUILD_ELEMENT,
							((NamedElement) element).getQualifiedName());
				}

				HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
				externalSlotContents.put(
						CodeGenWorkflowConstants.ELEMENT_STRING, element);
				externalSlotContents.put(
						CodeGenWorkflowConstants.PROGRESS_MONITOR, monitor);

				IProject project = ProjectFactory.getProject(element, monitor,
						ProjectFactory.MODE_CREATE_BASIC);
				if (project != null) {

					// save the project name
					genProperties.put(
							CodeGenWorkflowConstants.GENERATED_PROJECT,
							project.getName());

					String srcGen = project.getLocation().makeAbsolute()
							.toOSString();
					genProperties.put(CodeGenWorkflowConstants.SRC_GEN, srcGen);

					try {
						Iterator<WorkflowEntry> i = workflows.iterator();
						while (i.hasNext()) {

							WorkflowEntry entry = i.next();

							if (entry.getValidationFactory() != null) {
								IBatchValidator validator = entry
										.getValidationFactory()
										.createValidator();
								// rc.add( validator.validate(
								// this.selectedElement, monitor ) );
								IStatus result = validator.validate(element,
										monitor);
								if (result.getSeverity() == IStatus.CANCEL) {
									// we've cancelled the operation, skip the
									// codegen workflow, pass along the
									// OperationCanceledException
									throw new OperationCanceledException();
								} else if (result.getSeverity() == IStatus.ERROR) {
									if (entry.doesValidationErrorCancel()) {
										resultStatus
												.add(createStatus(
														result.getSeverity(),
														"Plug-in Vendor: " + entry.getDiagnosticInfo().getBundleVendor())); //$NON-NLS-1$
										resultStatus
												.add(createStatus(
														result.getSeverity(),
														"Plug-in Name: " + entry.getDiagnosticInfo().getBundleName())); //$NON-NLS-1$
										resultStatus
												.add(createStatus(
														result.getSeverity(),
														"Plug-in ID: " + entry.getDiagnosticInfo().getSymbolicName())); //$NON-NLS-1$
										resultStatus
												.add(createStatus(
														result.getSeverity(),
														"Version: " + entry.getDiagnosticInfo().getBundleVersion())); //$NON-NLS-1$
										resultStatus.add(result);
										b_abort = true;
									}
								}
							}

							if (!b_abort) {
								IStatus status = WorkflowUtil.executeWorkflow(
										entry.getWorkflowURL(), monitor,
										genProperties, externalSlotContents);
								if (status.isOK() == false) {
									resultStatus
											.add(createStatus(
													status.getSeverity(),
													"Plug-in Vendor: " + entry.getDiagnosticInfo().getBundleVendor())); //$NON-NLS-1$
									resultStatus
											.add(createStatus(
													status.getSeverity(),
													"Plug-in Name: " + entry.getDiagnosticInfo().getBundleName())); //$NON-NLS-1$
									resultStatus
											.add(createStatus(
													status.getSeverity(),
													"Plug-in ID: " + entry.getDiagnosticInfo().getSymbolicName())); //$NON-NLS-1$
									resultStatus
											.add(createStatus(
													status.getSeverity(),
													"Version: " + entry.getDiagnosticInfo().getBundleVersion())); //$NON-NLS-1$
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
									.error(Messages.TransformAction_ProjectRefreshFailedLog,
											e);
						}
					}
				}

				// codegen has just completed, mark everything clean
				// CodeGenerationDirtyElementTable.getInstance().clearTableForResource(res);

				return resultStatus;
			}

		};

		transformJob.setUser(true);

		return transformJob;
	}

	protected Status createStatus(int severity, String msg) {
		Status status = new Status(severity, CodeGenUIPlugin.PLUGIN_ID,
				IStatus.OK, msg, null);
		return status;
	}

}
