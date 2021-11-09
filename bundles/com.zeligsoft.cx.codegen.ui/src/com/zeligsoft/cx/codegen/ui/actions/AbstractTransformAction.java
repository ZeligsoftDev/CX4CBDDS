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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
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
import com.zeligsoft.cx.codegen.ui.filecollector.FileCollector;
import com.zeligsoft.cx.codegen.ui.filecollector.FileCollector.FileCollectionException;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;

public abstract class AbstractTransformAction extends Action {
	
	class TransformJob extends WorkspaceJob {
		
		private final WorkflowEntry workflowEntry;
		private IProject project;

		TransformJob(String name, WorkflowEntry workflowEntry) {
			super(name);
			this.workflowEntry = workflowEntry;
		}
		
		public WorkflowEntry getWorkflowEntry() {
			return workflowEntry;
		}
		
		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) {

			MultiStatus resultStatus = new MultiStatus(
				CodeGenUIPlugin.PLUGIN_ID, 0, NLS.bind(
					Messages.GenerateJob_ResultMessage, null), null);
			boolean abortTransformJob = false;

			project = ProjectFactory.getProject(element, monitor,
					ProjectFactory.MODE_CREATE_BASIC);

			Map<String, String> genProperties = createGenProperties();

			Map<String, Object> externalSlotContents = createExternalSlotContents(monitor);

			if (project != null) {
				try {
					if (workflowEntry.getValidationFactory() != null) {
						abortTransformJob = validateElement(workflowEntry, abortTransformJob, monitor, resultStatus);
					}
					
					if (!abortTransformJob) {
						IStatus status = WorkflowUtil.executeWorkflow(
							workflowEntry.getWorkflowURL(), monitor, genProperties,
							externalSlotContents);
						createResultStatus(resultStatus, workflowEntry, status);
					}
				} finally {
					FileCollector.refreshWorkspace(project, monitor);
				}
			}

			return resultStatus;
		}

		/**
		 * @return A Map<String, String> - The genProperties map to pass to the workflow.
		 */
		private Map<String, String> createGenProperties() {
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
			
			if (project != null) {
				// save the project name
				genProperties.put(CodeGenWorkflowConstants.GENERATED_PROJECT,
					project.getName());
	
				String srcGen = project.getLocation().makeAbsolute()
					.toOSString();
				genProperties.put(CodeGenWorkflowConstants.SRC_GEN, srcGen);
			}

			return genProperties;
		}

		/**
		 * @param monitor - and {@link IProgressMonitor}
		 * @return A Map<String, Object> - the externalSlotContents map to pass to the workflow.
		 */
		private Map<String, Object> createExternalSlotContents(IProgressMonitor monitor) {
			HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
			externalSlotContents.put( CodeGenWorkflowConstants.ELEMENT_STRING, element );
			externalSlotContents.put( CodeGenWorkflowConstants.PROGRESS_MONITOR, monitor );
			return externalSlotContents;
		}

		/**
		 * @param entry
		 * @param abortTransform
		 * @param monitor
		 * @param resultStatus
		 * @return
		 * @throws OperationCanceledException
		 */
		private boolean validateElement(WorkflowEntry entry, boolean abortTransform, IProgressMonitor monitor,
				MultiStatus resultStatus) throws OperationCanceledException {
			IBatchValidator validator = entry.getValidationFactory().createValidator();
			IStatus result = validator.validate(element, monitor);
			if (result.getSeverity() == IStatus.CANCEL){
				//we've cancelled the operation, skip the codegen workflow, pass along the OperationCanceledException
				throw new OperationCanceledException();
			} else if( result.getSeverity() == IStatus.ERROR ) {
				if( entry.doesValidationErrorCancel() ) {
					createResultStatus(resultStatus, entry, result);
					abortTransform = true;
				}
			}
			return abortTransform;
		}
	}

	class TransformJobFinishListener extends JobChangeAdapter {
		
		private final TransformJob currentJob;
		private final TransformJob nextJob;
		private final IProject project;

		private TransformJobFinishListener(TransformJob currentJob, TransformJob nextJob, IProject project) {
			this.currentJob = currentJob;
			this.nextJob = nextJob;
			this.project = project;
		}

		@Override
		public void done(IJobChangeEvent event) {
			// When the job is done, we stop collecting files
			fileCollector.end();
			// Add and report the results
			workflowResultReporter.addResult(new WorkflowResult(currentJob.getWorkflowEntry(), element, project, event.getResult(), fileCollector.getFileCollection()));
			workflowResultReporter.reportAll();
			// If there is a next job, start it.
			if (nextJob != null) {
				beginTransformJob(nextJob);
			}
		}
	}


	protected List<WorkflowEntry> workflows = null;

	protected EObject element = null;
	
	protected FileCollector fileCollector = new FileCollector();
	
	protected WorkflowResultReporter workflowResultReporter = new WorkflowResultConsoleReporter();

	/**
	 * Create an Eclipse Job to run the specified workflows.
	 */
	protected void doTransform() {
		IProject project = ProjectFactory.getProject(getEObject(), null,
				ProjectFactory.MODE_NO_CREATE);
		fileCollector.setProject(project);
		TransformJob[] jobs = new TransformJob[workflows.size() + 1];
		int i = 0;
		for (WorkflowEntry workflowEntry : workflows) {
			TransformJob transformJob
				= new TransformJob(NLS.bind(Messages.TransformAction_TransformJobName, workflowEntry.getDisplayLabel()), workflowEntry);
			transformJob.setUser(true);
			// We set the scheduling rule of the job to be the project to ensure that the project is locked.
			// This is essential, since the workflows will all produce resourceChange events on the same
			// project, so the notifications would go to all ResourceChangeListeners rather than the one
			// for the specific workflow.
			//   Note that this loops schedules all jobs, and therefore they may run concurrently, which
			// means that each of them may trigger resourceChange notifications, and therefore these notifications
			// might be delivered to all ResourceChangeListeners, but by setting this rule, any requests by
			// other threads (including other jobs) to modify the project will be blocked until the job
			// finishes, so the first job generating a resourceChange will block others until it finishes.
			transformJob.setRule(project); 
			jobs[i] = transformJob;
			i++;
		}
		jobs[workflows.size()] = null;
		// Rather than schedule all jobs simultaneously, we chain them, ensuring that a job is scheduled only
		// when the previous job has finished (see {@link TransformJobFinishListener}), that way we can be sure
		// that the file collector will be notified by the changes of only the currently running job.
		for (int j = 0; j < jobs.length - 1; j++) {
			TransformJob job = jobs[j];
			TransformJob nextJob = jobs[j + 1];
			job.addJobChangeListener(new TransformJobFinishListener(job, nextJob, project));
		}
		beginTransformJob(jobs[0]);
	}
	
	/**
	 * Starts file collection and then schedules the given transformation job.
	 */
	private void beginTransformJob(TransformJob nextJob) {
		workflowResultReporter.reset();
		try {
			fileCollector.setFilter(new Predicate<IFile>() {
				@Override
				public boolean test(IFile file) {
					Collection<String> extensions = nextJob.getWorkflowEntry().getFileExtensions();
					if (extensions != null) {
						return extensions.contains(file.getFileExtension());

					}
					return false;
				}
			});
			fileCollector.begin();
			nextJob.schedule();
			joinThread(nextJob);
		} catch (FileCollectionException e) {
			// It is impossible to get here because the fileCollector's project is set
			// before we begin collecting.
			// But if more exceptions are added to the FileCollector, we should catch them
			// here.
			CodeGenUIPlugin.getDefault().error(Messages.AbstractTransformAction_NullProject, e);
		} catch (InterruptedException e) {
			CodeGenUIPlugin.getDefault().error(Messages.TransformAction_ThreadJoinFailedLog, e);
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

	private void createResultStatus(MultiStatus resultStatus, WorkflowEntry entry, IStatus result) {
		resultStatus.add(createStatus(result.getSeverity(), "Plug-in Vendor: " + entry.getDiagnosticInfo().getBundleVendor())); //$NON-NLS-1$
		resultStatus.add(createStatus(result.getSeverity(), "Plug-in Name: " + entry.getDiagnosticInfo().getBundleName())); //$NON-NLS-1$
		resultStatus.add(createStatus(result.getSeverity(), "Plug-in ID: " + entry.getDiagnosticInfo().getSymbolicName())); //$NON-NLS-1$
		resultStatus.add(createStatus(result.getSeverity(), "Version: " + entry.getDiagnosticInfo().getBundleVersion())); //$NON-NLS-1$
		resultStatus.add(result);
		ILog logger = Platform.getLog(entry.getDiagnosticInfo().getBundle());
		logger.log(resultStatus);
	}

}
