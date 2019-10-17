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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

/**
 * Repair all worker functions at model level with options of project and
 * workspace level as well
 * 
 * @author parmvirs
 * 
 */
public class RepairAllWorkerFunctionsAction implements IViewActionDelegate {

	private ISelection selection = null;
	private final static String REPAIR_ALL_WORKER_FUNCTIONS = "Repair All Worker Functions"; //$NON-NLS-1$

	@Override
	public void run(final IAction action) {

		if (selection == null) {
			return;
		}

		final EObject eobject = BaseUIUtil.getEObjectFromSelection(selection);

		Job job = new Job(REPAIR_ALL_WORKER_FUNCTIONS) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				if (monitor == null) {
					monitor = (IProgressMonitor) new NullProgressMonitor();
				}

				monitor.beginTask(REPAIR_ALL_WORKER_FUNCTIONS, IProgressMonitor.UNKNOWN);

				ICommand command = null;
				if (eobject != null && ZDLUtil.isZDLConcept(eobject, DDS4CCMNames.DDS4_CCMMODEL)) {

					if ("ModelLevel".equals(action.getId())) { //$NON-NLS-1$
						command = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eobject),
								REPAIR_ALL_WORKER_FUNCTIONS, null) {

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1)
									throws ExecutionException {
								DDS4CCMMigrationUtil.repairAllWorkerfunctions((Model) eobject);
								return CommandResult.newOKCommandResult();
							}
						};
					} else if ("ProjectLevel".equals(action.getId())) { //$NON-NLS-1$
						final IProject project = WorkspaceSynchronizer.getFile(eobject.eResource()).getProject();

						if (project != null) {

							command = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eobject),
									REPAIR_ALL_WORKER_FUNCTIONS, null) {

								@Override
								protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1)
										throws ExecutionException {
									repairAllWorkerFunctionsInProject(project,
											TransactionUtil.getEditingDomain(eobject));
									return CommandResult.newOKCommandResult();
								}
							};
						}
					} else if ("WorkspaceLevel".equals(action.getId())) { //$NON-NLS-1$
						final IWorkspace workspace = ResourcesPlugin.getWorkspace();

						if (workspace != null) {

							command = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eobject),
									REPAIR_ALL_WORKER_FUNCTIONS, null) {

								@Override
								protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1)
										throws ExecutionException {
									for (IProject project : workspace.getRoot().getProjects()) {
										repairAllWorkerFunctionsInProject(project,
												TransactionUtil.getEditingDomain(eobject));
									}
									return CommandResult.newOKCommandResult();
								}
							};
						}
					}

					if (command != null) {
						try {
							OperationHistoryFactory.getOperationHistory().execute(command, null, null);
						} catch (Exception e) {
							Activator.getDefault().error(Messages.Migrate_Error, e);
							MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.Migrate_Error,
									e.getMessage());
						}
					}
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}

	/**
	 * Searches for all models in a project and repairs their worker functions then
	 * 
	 * @param project
	 */
	private void repairAllWorkerFunctionsInProject(IProject project, TransactionalEditingDomain editingDomain) {
		List<IResource> files = getModelFiles(project);

		for (IResource file : files) {
			Model model = loadDDS4CCMModel(file, editingDomain);
			if (model != null) {
				DDS4CCMMigrationUtil.repairAllWorkerfunctions(model);
			}
		}
	}

	/**
	 * Searches for all models in a project and returns a list of found models.
	 * 
	 * @param res
	 * @return
	 */
	private List<IResource> getModelFiles(IResource res) {
		List<IResource> result = new ArrayList<IResource>();

		if (res instanceof IFile && "emx".equals(((IFile) res).getFileExtension())) { //$NON-NLS-1$
			result.add(res);
		} else if (res instanceof IContainer) {
			try {
				for (IResource resFolderMember : ((IContainer) res).members()) {
					result.addAll(getModelFiles(resFolderMember));
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e.getMessage(), e);
			}
		}
		return result;
	}

	/**
	 * loads DDS4CCM model and returns it or returns null.
	 * 
	 * @param res
	 * @return
	 */
	private Model loadDDS4CCMModel(IResource res, TransactionalEditingDomain editingDomain) {
		String uriJava = res.getLocationURI().toString();
		URI uri = org.eclipse.emf.common.util.URI.createURI(uriJava, true);
		Resource loadedRes = editingDomain.getResourceSet().getResource(uri, true);
		EObject foundModel = (EObject) EcoreUtil.getObjectByType(loadedRes.getContents(), UMLPackage.Literals.PACKAGE);

		if (ZDLUtil.isZDLConcept(foundModel, DDS4CCMNames.DDS4_CCMMODEL)) {
			return (Model) foundModel;
		}
		return null;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}

}
