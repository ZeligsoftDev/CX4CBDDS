/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Céline Janssens (ALL4TEC) Celine.Janssens@all4tec.net - Bug 420593
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 447025
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.commands.MoveOpenableCommand;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;

/**
 * This class manage the drop inside the model explorer.
 */
public class CommonDropAdapterAssistant extends org.eclipse.ui.navigator.CommonDropAdapterAssistant {

	/** The Constant CHANGE_OF_RESOURCE_COMMAND. */
	private static final String CHANGE_OF_RESOURCE_COMMAND = "Change of Resource";

	/** The Constant REORDER_COMMAND_LABEL. */
	private static final String REORDER_COMMAND_LABEL = "Move Selected Elements in Model Explorer";


	/**
	 * Instantiates a new common drop adapter assistant.
	 */
	public CommonDropAdapterAssistant() {
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#handleDrop(org.eclipse.ui.navigator.CommonDropAdapter, org.eclipse.swt.dnd.DropTargetEvent, java.lang.Object)
	 *
	 * @param dropAdapter
	 * @param dropTargetEvent
	 * @param dropTarget
	 * @return
	 */
	@Override
	public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent, Object dropTarget) {
		EObject targetElement = EMFHelper.getEObject(dropTarget);

		execute(getEditingDomain(targetElement), getDrop(dropTarget));
		return null;
	}

	/**
	 * Get the list of command to put an eobject into another EObject,
	 * if the parameter eref is null,It will look for the good role of the child eobject.
	 *
	 * @param domain
	 *            the Transactional Domain , cannot be null
	 * @param targetOwner
	 *            the eobject that will contain the drop object, cannot be null
	 * @param childElement
	 *            that we want to move, cannot be null
	 * @param eref
	 *            role where the child element must be drop if eref is not null
	 * @return the list of commands to to the drop
	 */
	protected List<Command> getDropIntoCommand(TransactionalEditingDomain domain, EObject targetOwner, EObject childElement, EReference eref) {
		ArrayList<Command> commandList = new ArrayList<Command>();
		MoveRequest moveRequest = new MoveRequest(targetOwner, childElement);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand command = provider.getEditCommand(moveRequest);

			if (command != null) {
				commandList.add(new GMFtoEMFCommandWrapper(command));
			}
		}
		return commandList;
	}


	/**
	 * get a list that contains command to move a view into a new element.
	 *
	 * @param domain
	 *            the transactionnal edit domain, cannot be null
	 * @param target
	 *            the target of the drop, cannot be null
	 * @param view
	 *            the diagram that will move, cannot be null
	 * @return a list that contains one command to move the diagram
	 */
	protected Command getDropViewCommands(TransactionalEditingDomain domain, EObject target, EObject view) {


		ViewPrototype proto = ViewPrototype.get(view);

		// Check if diagram can exist in new location or the target object is a proxy
		if (!proto.isOwnerReassignable() || PolicyChecker.getFor(target).getOwningRuleFor(proto, target) == null || target.eIsProxy()) {
			// Stop here with unexecutable command
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve reassignment command from the Element Edit service
		Command command = proto.getCommandChangeOwner(view, target);

		if (command != null) {
			Resource targetNotationResource = getTargetNotationResource(target);
			if (targetNotationResource != null) {
				if (!targetNotationResource.equals(view.eResource())) {
					List<Command> list = new ArrayList<Command>();
					list.add(command);
					list.add(new GMFtoEMFCommandWrapper(new MoveOpenableCommand(domain, CHANGE_OF_RESOURCE_COMMAND, view, targetNotationResource)));
					return new CompoundCommand(list);
				} else { // diagram stays in the same resource. Only execute the set command
					return command;
				}
			}
		}

		// Failed : stop here with unexecutable command
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the target notation resource.
	 *
	 * @param targetOwner
	 *            the target owner
	 * @return the target notation resource
	 */
	protected Resource getTargetNotationResource(EObject targetOwner) {
		if (targetOwner.eResource() != null && targetOwner.eResource().getResourceSet() instanceof ModelSet) {
			ModelSet modelSet = (ModelSet) targetOwner.eResource().getResourceSet();
			return modelSet.getAssociatedResource(targetOwner, NotationModel.NOTATION_FILE_EXTENSION, true);
		}
		return null;
	}

	/**
	 * get the list of command to put an eobject before or after another EObject
	 * It will look for the good role of the child eobject.
	 *
	 * @param domain
	 *            the Transactional Domain, cannot be null
	 * @param targetOwner
	 *            the eobject that will contain the drop object , cannot be null
	 * @param objectLocation
	 *            the object where we want to drop the object
	 * @param newElement
	 *            that we want to move, cannot be null
	 * @param before
	 *            flag to know if the element have to put before the drop target
	 * @return the list of commands to to the drop
	 */
	protected List<Command> getOrderChangeCommand(TransactionalEditingDomain domain, EObject targetOwner, EObject objectLocation, EObject newElement, boolean before) {
		ArrayList<Command> commandList = new ArrayList<Command>();


		// Abort when trying to change order moving the element in one of its children
		if (EcoreUtil.isAncestor(newElement, targetOwner)) {
			return Collections.emptyList();
		}

		// Sequencing eOject
		commandList.addAll(handleEObject(targetOwner, objectLocation, newElement, before));

		return commandList;
	}

	/**
	 * Handle EObjects.
	 *
	 * @param targetOwner
	 *            the target owner
	 * @param objectLocation
	 *            the object location
	 * @param newElement
	 *            the new element
	 * @param before
	 *            flag to know if the selection have to put before the object location
	 * @return the list
	 */
	private List<Command> handleEObject(final EObject targetOwner, final EObject objectLocation, final EObject newElement, boolean before) {

		// Ordered EObject of the model
		ArrayList<EStructuralFeature> possibleEFeatures = new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList = targetOwner.eClass().getEAllStructuralFeatures();
		List<Command> commandList = new ArrayList<Command>();

		// Find the feature between children and owner
		Iterator<EStructuralFeature> iterator = featureList.iterator();
		while (iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = iterator.next();

			if (eStructuralFeature instanceof EReference) {
				EReference ref = (EReference) eStructuralFeature;

				if (ref.isContainment()) {

					if (isSubClass(ref.getEType(), newElement.eClass())) {
						possibleEFeatures.add(eStructuralFeature);
					}

				}
			}
		}

		// Create the command
		Iterator<EStructuralFeature> iteratorFeature = possibleEFeatures.iterator();
		while (iteratorFeature.hasNext()) {
			EStructuralFeature eStructuralFeature = iteratorFeature.next();
			List<EObject> tmp = new ArrayList<EObject>();

			if (eStructuralFeature.isMany()) {

				// Get all element of this EStructuralFeature
				tmp.addAll((Collection<EObject>) targetOwner.eGet(eStructuralFeature));

				if (!newElement.equals(objectLocation)) {
					tmp.remove(newElement);
					// normally tmp.indexOf(objectLocation)!= -1
					// if this the case objectLocation=new element and
					// it has been removed
					int indexObject = tmp.indexOf(objectLocation);
					if (before && indexObject != -1) {
						tmp.add(indexObject, newElement);
					} else if (!before && indexObject != -1) {
						tmp.add(indexObject + 1, newElement);
					}
				}
			} else {
				tmp.add(newElement);
			}

			// Get the command from Edit service
			SetRequest setRequest = new SetRequest(targetOwner, eStructuralFeature, tmp);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if (provider != null) {
				// Retrieve delete command from the Element Edit service
				ICommand command = provider.getEditCommand(setRequest);

				/*
				 * Add only the executable command because, if the command cannot be executed,
				 * it was a bad possible EStructuralFeature which was selected before.
				 */
				if (command != null && command.canExecute()) {

					commandList.add(new GMFtoEMFCommandWrapper(command));
				}
			}
		}

		return commandList;
	}

	/**
	 * Execute.
	 *
	 * @param domain
	 *            the domain
	 * @param dropCommand
	 *            the drop command
	 */
	protected void execute(EditingDomain domain, Command dropCommand) {
		domain.getCommandStack().execute(dropCommand);
	}

	/**
	 * get the list of good command by taking in account if this is a change order or a drop into.
	 *
	 * @param target
	 *            the target object of the drop
	 * @return the list of command
	 */
	public CompoundCommand getDrop(Object target) {
		CommonDropAdapter dropAdapter = getCommonDropAdapter();
		List<Command> commandList = new ArrayList<Command>();
		boolean before;
		switch (dropAdapter.getCurrentOperation()) {
		case DND.DROP_MOVE:
			if (dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_BEFORE) {
				before = true;
				if (target instanceof EObjectTreeElement) {
					commandList.addAll(getOrderChangeCommand(target, before));

				}
			} else if (dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_AFTER) {
				before = false;
				if (target instanceof EObjectTreeElement) {
					commandList.addAll(getOrderChangeCommand(target, before));

				}
			} else if (dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_ON) {
				if (target instanceof EObjectTreeElement) {
					commandList.addAll(getDropIntoCommand(target, null));
				}
				if (target instanceof EReferenceTreeElement) {
					commandList.addAll(getDropIntoCommand(((EReferenceTreeElement) target).getParent(), ((EReferenceTreeElement) target).getEReference()));
				}
			}

			else if (dropAdapter.getCurrentLocation() == ViewerDropAdapter.LOCATION_NONE) {
			}
			break;
		}
		return new CompoundCommand(commandList);
	}

	/**
	 * Test if a possibleSub eclass is a sub eclass.
	 *
	 * @param aclass
	 *            , cannot be null
	 * @param possibleSubClasse
	 *            , cannot be null
	 * @return true if possible eclass is a subtype of a eclass or false
	 */
	public boolean isSubClass(EClassifier aclass, EClass possibleSubClasse) {
		if (aclass.equals(possibleSubClasse)) {
			return true;
		}
		EList<EClass> superTypeList = possibleSubClasse.getEAllSuperTypes();
		if (superTypeList.contains(aclass)) {
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validateDrop(java.lang.Object, int, org.eclipse.swt.dnd.TransferData)
	 *
	 * @param target
	 * @param operation
	 * @param transferType
	 * @return
	 */
	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		Command dropCommand = getDrop(target);
		if (dropCommand.canExecute()) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * get the list of commands to drop an element.
	 *
	 * @param target
	 *            , can be null but do nothing
	 * @param eref
	 *            role where there is a drop ( can be null)
	 * @return the list of the commands
	 */
	protected List<Command> getDropIntoCommand(final Object target, EReference eref) {

		// Initialise
		List<Command> result = new ArrayList<Command>();
		EObject targetEObject = null;

		targetEObject = EMFHelper.getEObject(target);
		if (targetEObject == null) {
			return result;
		}

		// get Command from the selection
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) selection).toList();
			Iterator<?> it = selectedElements.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				EObject eObjectchild = EMFHelper.getEObject(object);

				if (eObjectchild == null) {
					continue;
				}

				if (ViewPrototype.isViewObject(eObjectchild) && getEditors(targetEObject).contains(eObjectchild)) {
					result.add(getDropViewCommands(getEditingDomain(targetEObject), targetEObject, eObjectchild));
				}
				// test if object is an eobject
				else {
					result.addAll(getDropIntoCommand(getEditingDomain(targetEObject), targetEObject, eObjectchild, eref));
				}

			}
		}

		return result;
	}

	/**
	 * Gets the editors.
	 *
	 * @param context
	 *            the context
	 * @return the list of the editors
	 */
	private List<Object> getEditors(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getService(IPageManager.class, context).allPages();
		} catch (ServiceException ex) {
			return Collections.emptyList();
		}
	}

	/**
	 * get the list of commands to drop an element.
	 *
	 * @param target
	 *            , can be null but do nothing
	 * @param before
	 *            flag to know if the selection have to put before the target
	 * @return the list of the commands
	 */
	protected List<Command> getOrderChangeCommand(final Object target, boolean before) {

		// Initialise
		List<Command> result = new ArrayList<Command>();

		// Get EObject of the Target
		EObject dropTarget = EMFHelper.getEObject(target);
		if (dropTarget == null) {
			return result;
		}

		// list of commands required to add the selection to the Target place
		Collection<? extends Command> orderCommandList = getSelectionOrderCommand(dropTarget, before);
		result.addAll(orderCommandList);


		return result;
	}

	/**
	 * Gets the e object selection.
	 *
	 * @return List of Selected EObjects
	 */
	private List<EObject> geEObjectSelection() {
		List<EObject> selection = new ArrayList<EObject>();
		ISelection select = LocalSelectionTransfer.getTransfer().getSelection();
		if (select instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) select).toList();
			Iterator<?> it = selectedElements.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				EObject eObjectchild = EMFHelper.getEObject(object);
				// test if object is an eObject
				if (eObjectchild != null && eObjectchild.eContainer() != null) {

					selection.add(eObjectchild);
				}
			}
		}

		return selection;
	}


	/**
	 * Gets the selection order command.
	 *
	 * @param dropTarget
	 *            the drop target
	 * @param before
	 *            flag to know if the selection have to put before the drop target
	 * @return the selection order command
	 */
	private List<Command> getSelectionOrderCommand(EObject dropTarget, boolean before) {

		// Get selection
		List<EObject> selection = geEObjectSelection();

		// Build list of commands according of the selection
		List<Command> commandList = null;
		if (isSelectionReorderAllowed(dropTarget, selection)) {
			commandList = getReorderCommands(dropTarget, before, selection);
		} else {
			commandList = Collections.emptyList();
		}

		return commandList;

	}

	/**
	 * Gets the reorder commands.
	 *
	 * @param dropTarget
	 *            the drop target
	 * @param before
	 *            flag to know if the selection have to put before the drop target
	 * @param selection
	 *            the selection
	 * @return the reorder commands
	 */
	private List<Command> getReorderCommands(EObject dropTarget, boolean before, List<EObject> selection) {

		// List of Command to drop the selection to the Target place
		List<Command> separateCommand = new ArrayList<Command>();

		// Target Container
		EObject targetContainer = dropTarget.eContainer();

		List<EObject> treatedSelection = new ArrayList<EObject>();
		Iterator<EObject> selectionIterator = selection.iterator();

		while (selectionIterator.hasNext()) {

			// Current item
			EObject currentItem = selectionIterator.next();

			if (!treatedSelection.contains(currentItem)) {

				List<EObject> subSelection = getSameTypeSubSelection(currentItem, selection);
				treatedSelection.addAll(subSelection);

				if (!subSelection.isEmpty()) {


					// Get list of the feature with the same type as the selected item into the target container
					// List of structural Feature of the selection type.
					// Possible Features

					List<EStructuralFeature> possibleFeatures = getStructuralFeatureList(targetContainer, currentItem.eClass());
					for (EStructuralFeature eStructuralFeature : possibleFeatures) {
						// List of all Reference into TargetContainer of type eStructuralFeature
						Object targetStructuralFeatureOld = targetContainer.eGet(eStructuralFeature);

						SetRequest setRequest = null;
						// Check if targetStructuralFeatureOld is a List or a single EStructuralFeature
						if (eStructuralFeature.isMany()) {
							// Cast Check
							if (targetStructuralFeatureOld instanceof EList) {

								// Build new feature list with correct order of features to be set
								List<EObject> targetStructuralFeatureNewList = new ArrayList<EObject>();
								targetStructuralFeatureNewList.addAll(getNewFeatureList(dropTarget, (EList<EObject>) targetStructuralFeatureOld, subSelection, before));

								// Create Set Request for the new feature list
								setRequest = new SetRequest(targetContainer, eStructuralFeature, targetStructuralFeatureNewList);
							}

						} else {
							// if only one instance possible, replace the actual one
							// Cast Check
							if (targetStructuralFeatureOld instanceof EStructuralFeature) {
								setRequest = new SetRequest(targetContainer, eStructuralFeature, subSelection.get(0));

							}
						}
						if (setRequest == null) {
							continue;
						}
						Command requestCommand = getRequestCommand(targetContainer, setRequest);
						if (requestCommand != null) {
							separateCommand.add(requestCommand);
						}
					}
				}
			}
		}


		return separateCommand;
	}

	/**
	 * Gets the request command.
	 *
	 * @param container
	 *            the container
	 * @param setRequest
	 *            the set request
	 * @return the request command
	 */
	private Command getRequestCommand(EObject container, SetRequest setRequest) {

		// List of Command to drop the selection to the Target place
		Command separateCommand = null;

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);


		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand command = provider.getEditCommand(setRequest);

			if (command != null && command.canExecute()) {
				command.setLabel(REORDER_COMMAND_LABEL);
				separateCommand = GMFtoEMFCommandWrapper.wrap(command);
			}
		}
		return separateCommand;
	}

	/**
	 * Gets sub selection of elements which have same type as item in selection.
	 *
	 * @param item
	 *            the item
	 * @param selection
	 *            the selection
	 * @return the item sublist
	 */
	private List<EObject> getSameTypeSubSelection(EObject item, List<EObject> selection) {
		List<EObject> subSelection = new ArrayList<EObject>();

		// Get item type
		EClass itemType = item.eClass();
		Iterator<EObject> selectionIterator = selection.iterator();

		// Define a sub list from the selection of the same type
		while (selectionIterator.hasNext()) {

			// Current item
			EObject current = selectionIterator.next();
			EClass currentType = current.eClass();
			if (currentType.equals(itemType)) {
				subSelection.add(current);
			}
		}

		return subSelection;

	}

	/**
	 * Gets the new feature list.
	 *
	 * @param dropTarget
	 *            the e target
	 * @param oldList
	 *            the old list
	 * @param subSelection
	 *            the sub selection
	 * @param before
	 *            flag to know if the sub selection have to put before the drop target
	 * @return the new feature list
	 */
	private EList<EObject> getNewFeatureList(EObject dropTarget, EList<EObject> oldList, List<EObject> subSelection, boolean before) {

		EList<EObject> newFeatureList = new BasicEList<EObject>(oldList);

		for (EObject subItem : subSelection) {

			if (!subItem.equals(dropTarget)) {


				// Get index of drop target
				int indexObject = newFeatureList.indexOf(dropTarget);

				if (indexObject != -1) {

					// Remove sub item of the list
					newFeatureList.remove(subItem);
					if (before) {
						// Add subItem to index of dorpTarget
						newFeatureList.add(indexObject, subItem);
					} else {
						// Add subItem after dropTarget position according to the index of subItem in subselection
						int behindPosition = indexObject + 1 + subSelection.indexOf(subItem);
						if (behindPosition < newFeatureList.size()) {
							newFeatureList.add(behindPosition, subItem);
						} else {
							newFeatureList.add(subItem);
						}
					}
				}

			} else {
				newFeatureList.add(subItem);
			}

		}


		return newFeatureList;

	}


	/**
	 * Checks if is selection reorder allowed.
	 *
	 * @param dropTarget
	 *            the drop target
	 * @param selection
	 *            Selection list to be tested
	 * @return <code>true</code> if the selection is not empty and the Drop target is contained, otherwise <code>false</code>
	 */
	private boolean isSelectionReorderAllowed(EObject dropTarget, List<EObject> selection) {
		// Check selection
		return !selection.isEmpty() && dropTarget.eContainer() != null;
	}

	/**
	 * Gets the structural feature list.
	 *
	 * @param targetOwner
	 *            the target owner
	 * @param itemSelected
	 *            the item selected
	 * @return the structural feature list
	 */
	private List<EStructuralFeature> getStructuralFeatureList(EObject targetOwner, EClass itemSelected) {

		// List of possible target feature to drop selection
		List<EStructuralFeature> possibleFeaturesList = new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> targetFeaturesList = targetOwner.eClass().getEAllStructuralFeatures();

		// Find the feature between children and owner
		Iterator<EStructuralFeature> featuresIterator = targetFeaturesList.iterator();

		while (featuresIterator.hasNext()) {
			EStructuralFeature currentFeature = featuresIterator.next();

			// Only Reference type of feature that can be a container should be taken into account
			if (currentFeature instanceof EReference) {
				EReference reference = (EReference) currentFeature;
				if (reference.isContainment()) {
					// In case of the selected item is a sub class of the current fetaure, it is considered as part of the feature list
					if (isSubClass(reference.getEType(), itemSelected)) {
						possibleFeaturesList.add(currentFeature);
					}

				}
			}
		}

		return possibleFeaturesList;

	}


	/**
	 * Gets the editing domain.
	 *
	 * @param context
	 *            the context
	 * @return the editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
