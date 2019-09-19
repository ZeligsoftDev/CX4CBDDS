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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.FilteringList;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Manually remove references to model libraries that are deleted or not in the
 * model.
 * 
 * @author parmvirs
 * 
 */

public class CleanReferencesAction implements IViewActionDelegate {

	private ISelection selection;
	final EObject selObject = BaseUIUtil.getEObjectFromSelection(selection);
	private boolean refactorCount = false;
	private ICommand changeCommand;

	@Override
	public void run(IAction action) {

		if (selection == null) {
			return;
		}

		final EObject selObject = BaseUIUtil.getEObjectFromSelection(selection);
		if (selObject == null) {
			return;
		}

		cleanModelLibraryReferences(selObject);

	}

	/**
	 * Searches for references to model libraries no longer valid and adds
	 * commands to CompositeCommand then executes all the commands at once for
	 * cleaning them
	 * 
	 * @param model
	 */
	protected void cleanModelLibraryReferences(EObject model) {
		TreeIterator<EObject> itor = model.eAllContents();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
		CompositeCommand compositeCommand = new CompositeCommand(
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel);
		EObject next = null;

		while (itor.hasNext()) {
			next = itor.next();

			if (!(next instanceof Element)) {
				itor.prune();
				continue;
			} else if (next instanceof Slot) {
				itor.prune();
				continue;
			} else if (ZDLUtil.isZDLConcept(next, ZMLMMNames.WORKER_FUNCTION)) {
				itor.prune();
			} else if (next instanceof TemplateBinding) {
				itor.prune();
				continue;
			} else if (ZDLUtil.isZDLConcept(next, CCMNames.DEPLOYMENT_PLAN)) {
				itor.prune();
				continue;
			} else if (ZDLUtil.isZDLConcept(next,
					CORBADomainNames.CORBAATTRIBUTE)) {

				@SuppressWarnings("rawtypes")
				List attribute = (List) ZDLUtil.getValue(next,
						CORBADomainNames.CORBAATTRIBUTE,
						CORBADomainNames.CORBAATTRIBUTE__SETRAISES);

				for (Object attributeObj : attribute) {
					boolean setNull = false;

					if (attributeObj instanceof EObject) {
						Resource resource = ((EObject) attributeObj)
								.eResource();

						if (resource != null) {

							setNull = !checkImportPackage(resource.getURI(),
									false, model);
						}

						if (setNull || resource == null) {
							changeCommand = getChangedZDLTypeCommand(domain,
									next, CORBADomainNames.CORBAATTRIBUTE,
									CORBADomainNames.CORBAATTRIBUTE__SETRAISES);
							compositeCommand.compose(changeCommand);
						}
					}
				}
			} else if (next instanceof Generalization
					&& ((Generalization) next).getGeneral() != null) {
				Generalization gen = (Generalization) next;
				boolean setNull = false;
				Resource resource = gen.getGeneral().eResource();

				if (resource != null) {
					setNull = !checkImportPackage(resource.getURI(), false,
							model);
				}

				if (setNull || resource == null) {
					changeCommand = getChangedGeneralizationTypeCommand(domain,
							gen);
					compositeCommand.compose(changeCommand);
				}
			} else if (next instanceof InterfaceRealization) {
				InterfaceRealization interfaceRealization = (InterfaceRealization) next;
				int index = 0;

				for (NamedElement supplier : interfaceRealization
						.getSuppliers()) {

					boolean setNull = false;
					Resource resourceSupplier = supplier.eResource();

					if (resourceSupplier != null) {

						setNull = !checkImportPackage(
								resourceSupplier.getURI(), false, model);
					}

					if (setNull || resourceSupplier == null) {

						changeCommand = getChangedSupplierTypeCommand(domain,
								interfaceRealization, index);
						compositeCommand.compose(changeCommand);
					}
					index++;
				}

				if (interfaceRealization.getContract() != null) {
					boolean setNull = false;
					Resource resourceContract = interfaceRealization
							.getContract().eResource();

					if (resourceContract != null) {
						setNull = !checkImportPackage(
								resourceContract.getURI(), false, model);
					}

					if (setNull || resourceContract == null) {
						changeCommand = getChangedContractTypeCommand(domain,
								interfaceRealization);
						compositeCommand.compose(changeCommand);
					}
				}
			} else if (next instanceof Usage
					&& ((Usage) next).getSuppliers() != null) {
				Usage usage = (Usage) next;
				int index = 0;

				for (NamedElement supplier : usage.getSuppliers()) {
					boolean setNull = false;
					Resource resource = supplier.eResource();

					if (resource != null) {
						setNull = !checkImportPackage(resource.getURI(), false,
								model);
					}

					if (setNull || resource == null) {
						changeCommand = getChangedUsageTypeCommand(domain,
								usage, index);
						compositeCommand.compose(changeCommand);
					}
					index++;
				}
			} else if (ZDLUtil.isZDLConcept(next,
					CORBADomainNames.CORBAOPERATION)) {
				EObject idl = ZDLUtil.getEValue(next,
						CORBADomainNames.CORBAOPERATION,
						CORBADomainNames.CORBAOPERATION__IDL_TYPE);
				boolean setNull = false;

				if (idl != null) {
					Resource resourceIdl = idl.eResource();

					if (resourceIdl != null) {
						setNull = !checkImportPackage(resourceIdl.getURI(),
								false, model);
					}

					if (setNull || resourceIdl == null) {
						changeCommand = getChangedZDLTypeCommand(domain, next,
								CORBADomainNames.CORBAOPERATION,
								CORBADomainNames.CORBAOPERATION__IDL_TYPE);
						compositeCommand.compose(changeCommand);
					}
				}
				Object ownedParameter = ZDLUtil.getValue(next,
						CORBADomainNames.CORBAOPERATION,
						CORBADomainNames.CORBAOPERATION__OWNED_PARAMETER);

				for (Object ownedParameterObj : ((FilteringList<?>) ownedParameter)) {
					setNull = false;

					if (ownedParameterObj instanceof EObject) {
						Resource resourceOwnedParameter = ((EObject) ownedParameterObj)
								.eResource();

						if (resourceOwnedParameter != null) {
							setNull = !checkImportPackage(
									resourceOwnedParameter.getURI(), false,
									model);
						}

						if (setNull || resourceOwnedParameter == null) {
							changeCommand = getChangedZDLTypeCommand(
									domain,
									next,
									CORBADomainNames.CORBAOPERATION,
									CORBADomainNames.CORBAOPERATION__OWNED_PARAMETER);
							compositeCommand.compose(changeCommand);
						}
					}
				}
				Object raisedException = ZDLUtil.getValue(next,
						CORBADomainNames.CORBAOPERATION,
						CORBADomainNames.CORBAOPERATION__EXCEPTION_DEF);

				for (Object raisedExceptionObj : ((FilteringList<?>) raisedException)) {
					setNull = false;

					if (raisedExceptionObj instanceof EObject) {
						Resource resourceRaisedException = ((EObject) raisedExceptionObj)
								.eResource();

						if (resourceRaisedException != null) {
							setNull = !checkImportPackage(
									resourceRaisedException.getURI(), false,
									model);
						}

						if (setNull || resourceRaisedException == null) {
							changeCommand = getChangedZDLTypeCommand(
									domain,
									next,
									CORBADomainNames.CORBAOPERATION,
									CORBADomainNames.CORBAOPERATION__EXCEPTION_DEF);
							compositeCommand.compose(changeCommand);
						}
					}
				}
			}

			if (next instanceof TypedElement
					&& ((TypedElement) next).getType() != null) {
				TypedElement typedElement = ((TypedElement) next);
				boolean setNull = false;
				Resource resource = typedElement.getType().eResource();

				if (resource != null) {
					setNull = !checkImportPackage(resource.getURI(), false,
							model);
				}

				if (setNull || resource == null) {
					changeCommand = getChangedTypedElementTypeCommand(domain,
							typedElement);
					compositeCommand.compose(changeCommand);
				}
			}
		}

		try {
			OperationHistoryFactory.getOperationHistory().execute(
					compositeCommand, null, null);
		} catch (Exception e) {
			Activator.getDefault().error(Messages.Migrate_Error, e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(),
					Messages.Migrate_Error, e.getMessage());
		}

		if (refactorCount) {
			refactorCount = false;
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.RefactorCleanCommentsAction_ActionTitle,
					Messages.CleanReferences_OK);
		} else {
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					Messages.RefactorCleanReferenceAction_DialogTitle,
					Messages.CleanReferences_Noop);
		}
	}

	/**
	 * Removes all ZDL type elements which reference a model library that is
	 * removed or deleted. Adds command to composite command and then deletes
	 * everything together
	 * 
	 * @param domain
	 * @param eObject
	 * @param concept
	 * @param property
	 * @return command
	 */
	protected ICommand getChangedZDLTypeCommand(
			final TransactionalEditingDomain domain, final EObject eObject,
			final String concept, final String property) {

		AbstractTransactionalCommand changeZDLTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				ZDLUtil.setValue(eObject, concept, property, null);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeZDLTypeCommand;
	}

	/**
	 * Removes all typed elements which reference a model library that is
	 * removed or deleted. Adds command to composite command and then deletes
	 * everything together
	 * 
	 * @param domain
	 * @param typedElement
	 * @return command
	 */
	protected ICommand getChangedTypedElementTypeCommand(
			final TransactionalEditingDomain domain,
			final TypedElement typedElement) {

		AbstractTransactionalCommand changeTypedElementTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				typedElement.setType(null);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeTypedElementTypeCommand;
	}

	/**
	 * Removes all generalization ends which reference a model library that is
	 * removed or deleted. Adds command to composite command and then deletes
	 * everything together
	 * 
	 * @param domain
	 * @param gen
	 * @return command
	 */
	protected ICommand getChangedGeneralizationTypeCommand(
			final TransactionalEditingDomain domain, final Generalization gen) {

		AbstractTransactionalCommand changeGeneralizationTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				gen.setGeneral(null);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeGeneralizationTypeCommand;
	}

	/**
	 * Removes all suppliers of usage type which reference a model library that
	 * is removed or deleted. Adds command to composite command and then deletes
	 * everything together
	 * 
	 * @param domain
	 * @param usage
	 * @param index
	 * @return
	 */
	protected ICommand getChangedUsageTypeCommand(
			final TransactionalEditingDomain domain, final Usage usage,
			final int index) {

		AbstractTransactionalCommand changeSignatureTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				usage.getSuppliers().remove(index);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeSignatureTypeCommand;
	}

	/**
	 * Removes all suppliers of InterfaceRealization type which reference a
	 * model library that is removed or deleted. Adds command to composite
	 * command and then deletes everything together
	 * 
	 * @param domain
	 * @param interfaceRealization
	 * @param index
	 * @return command
	 */
	protected ICommand getChangedSupplierTypeCommand(
			final TransactionalEditingDomain domain,
			final InterfaceRealization interfaceRealization, final int index) {

		AbstractTransactionalCommand changeSignatureTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				interfaceRealization.getSuppliers().remove(index);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeSignatureTypeCommand;
	}

	/**
	 * Removes all contracts of interfaceRealization type which reference a
	 * model library that is removed or deleted. Adds command to composite
	 * command and then deletes everything together
	 * 
	 * @param domain
	 * @param interfaceRealization
	 * @return
	 */
	protected ICommand getChangedContractTypeCommand(
			final TransactionalEditingDomain domain,
			final InterfaceRealization interfaceRealization) {

		AbstractTransactionalCommand changeContractTypeCommand = new AbstractTransactionalCommand(
				domain,
				Messages.RefactorCleanModelReferencesNoLongerValid_CommandLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)

			throws ExecutionException {
				interfaceRealization.setContract(null);
				refactorCount = true;
				return CommandResult.newOKCommandResult();
			}
		};
		return changeContractTypeCommand;
	}

	/**
	 * checks if element references to a imported model library or model itself
	 * or not.
	 * 
	 * @param uri
	 * @param foundImportPackage
	 * @param model
	 * @return boolean
	 */
	private boolean checkImportPackage(URI uri, boolean foundImportPackage,
			EObject pkg) {

		Model model = ((Package)pkg).getModel();
		for (org.eclipse.uml2.uml.Package packge : model.getImportedPackages()) {

			if (packge.eResource() != null) {

				if (uri == packge.eResource().getURI()
						|| uri == model.eResource().getURI()) {
					foundImportPackage = true;
					break;
				}
			}
		}
		return foundImportPackage;
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
