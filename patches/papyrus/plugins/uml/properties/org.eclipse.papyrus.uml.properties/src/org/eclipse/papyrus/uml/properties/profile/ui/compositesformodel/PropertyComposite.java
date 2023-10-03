/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - modification, clean-up
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.profile.Message;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.ValueTreeObject;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The goal of this composite is make properties of applied stereotype editable see class AppliedStereotypeEditor
 */
public class PropertyComposite extends DecoratedTreeComposite {

	public TransactionalEditingDomain getEditingDomain(EModelElement context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * Creates a new PropertyComposite.
	 *
	 * @param parent
	 *            the composite parent
	 */
	public PropertyComposite(Composite parent) {
		super(parent, SWT.NONE, "Property values", false);
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.composites.DecoratedTableComposite#createContent(org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory)
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createPropTree();

		return this;
	}

	/**
	 * Creates the prop tree.
	 */
	protected void createPropTree() {

		// List of applied profiles
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());
	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {

		if (treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.refresh();

			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
			if (pTO == null) {
				this.setVisible(false);
			} else if ((pTO.getProperty() != null) && pTO.getProperty().isReadOnly()) {
				upButton.setEnabled(false);
				downButton.setEnabled(false);
				removeButton.setEnabled(false);
				addButton.setEnabled(false);
			} else {
				upButton.setEnabled(true);
				downButton.setEnabled(true);
				removeButton.setEnabled(true);
				addButton.setEnabled(true);

				// If the property is Multivalued show Up - Down
				if ((pTO.getChildren() != null) && (pTO.getChildren().length > 1)) {
					upButton.setEnabled(true);
					downButton.setEnabled(true);
				} else {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				}

				if ((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getLower())) {
					removeButton.setEnabled(false);
				} else {
					removeButton.setEnabled(true);
				}

				if ((pTO.getChildren() != null) && (pTO.getChildren().length == pTO.getProperty().getUpper())) {
					addButton.setEnabled(false);
				} else {
					addButton.setEnabled(true);
				}

				this.setVisible(true);
			}
		}

	}

	public void itemDClicked() {
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		// re-initialize value tree objects (model is already updated, value in tree object is not)
		pTO.reInitChilds();
	}

	/**
	 * Action triggered when the add button is pressed.
	 */
	@Override
	public void addButtonPressed() {

		// Retrieve selections
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		Property property = pTO.getProperty();
		Stereotype selectedSt = ((AppliedStereotypeTreeObject) pTO.getParent()).getStereotype();
		Element selectedElt = ((StereotypedElementTreeObject) pTO.getParent().getParent()).getElement();

		if ((property == null) || (selectedSt == null) || (selectedElt == null)) {
			// Nothing selected
			return;
		}

		// Retrieve property related info
		int lower = property.getLower();
		int upper = property.getUpper();

		// if lower multiplicity is equal to upper multiplicity : cannot add
		if (lower == upper && pTO.getValue() != null) {
			if (pTO.getValue() instanceof EList) {
				@SuppressWarnings("unchecked")
				EList<Object> currentValues = (EList<Object>) pTO.getValue();
				if (currentValues.size() >= upper) {
					Message.warning("Multiplicity of this property is " + property.getLower() + ".." + property.getUpper() + "\n" + "Impossible to add a new value.");
					return;
				}
			} else {
				Message.warning("Multiplicity of this property is " + property.getLower() + ".." + property.getUpper() + "\n" + "Impossible to add a new value.");
				return;
			}
		}

		// Retrieve current value
		ArrayList<Object> currentPropertyValues = new ArrayList<Object>();
		Object currentValue = pTO.getValue();
		if (currentValue != null) {

			if (upper == 1) {
				currentPropertyValues.add(currentValue);

			} else { // if (upper != 1) {

				@SuppressWarnings("unchecked")
				EList<Object> currentValues = (EList<Object>) currentValue;
				for (int i = 0; i < currentValues.size(); i++) {
					currentPropertyValues.add(currentValues.get(i));
				}
			}
		}

		if (property.isMultivalued() || (currentPropertyValues.size() < upper)) {
			ValueTreeObject.createInstance(pTO, null).editMe();
		} else {
			Message.warning("Upper multiplicity of " + UMLLabelInternationalization.getInstance().getLabel(property) + " is " + property.getUpper());
		}
		// Update value tree objects
		pTO.reInitChilds();
	}

	/**
	 * Action triggered when the remove button is pressed.
	 */
	@Override
	public void removeButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection == 0) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[i].getData();
			AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
			Property property = pTO.getProperty();

			int lower = property.getLower();
			int upper = property.getUpper();

			// if lower multiplicity is equal to upper multiplicity
			if (lower == upper) {
				Message.warning("Multiplicity of this property is" + lower + ".." + upper + "\n" + "Impossible to remove a value.");
				return;
			}

			Object currentVal = pTO.getValue();
			ArrayList<Object> tempValues = new ArrayList<Object>();

			if (upper != 1) {
				@SuppressWarnings("unchecked")
				EList<Object> currentValues = (EList<Object>) currentVal;
				tempValues.addAll(currentValues);

				if (tempValues.size() > lower) {
					tempValues.remove(vTO.getValue());
				}
			}

			if (property.isMultivalued()) {
				// setPropertiesValue(selectedElt, stereotype, property, tempValues);
				pTO.updateValue(tempValues);
			} else {
				pTO.updateValue(null);
			}

			// Update value tree objects
			pTO.reInitChilds();
		}
	}

	/**
	 * Action triggered when the up button is pressed.
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if (indexFirst == 0) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[i].getData();
			int index = getTree().indexOf(items[i]);
			vTO.moveMeUp(index);
		}
	}

	/**
	 * Action triggered when the down button is pressed.
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		// Get last value index
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject) treeViewer.getInput();
		int indexLastValue = -1;
		if (pTO.getChildren() != null) {
			indexLastValue = pTO.getChildren().length - 1;
		}
		// Get last selection index
		int indexLastSelection = getTree().indexOf(items[nbrOfSelection - 1]);
		if ((indexLastValue == -1) || (indexLastSelection == indexLastValue)) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			ValueTreeObject vTO = (ValueTreeObject) items[nbrOfSelection - 1 - i].getData();
			int index = getTree().indexOf(items[nbrOfSelection - 1 - i]);
			vTO.moveMeDown(index);
		}
	}

	/**
	 * Sets the input.
	 *
	 * @param element
	 *            the element
	 */
	public void setInput(AppliedStereotypePropertyTreeObject element) {
		treeViewer.setInput(element);
		if (element != null) {
			element.reInitChilds();
		}
		refresh();
	}

	/**
	 * Gets the tree.
	 *
	 * @return the tree
	 */
	public Tree getTree() {
		return treeViewer.getTree();
	}

	/**
	 *
	 *
	 * @param item
	 */
	@Override
	public void editItem(TreeItem item) {
		// do nothing
	}
}
