/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 515967
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IndirectMaskLabelEditPolicy;
import org.eclipse.papyrus.infra.properties.ui.modelelement.CompositeModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.providers.XWTCompliantMaskProvider;
import org.eclipse.papyrus.infra.properties.ui.providers.XWTCompliantMaskProviderListener;
import org.eclipse.papyrus.infra.properties.ui.providers.XWTCompliantMaskProviderUpdater;
import org.eclipse.papyrus.uml.diagram.common.editparts.FloatingLabelEditPart;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;


/**
 * A MaskProvider for the labelCustomization property
 *
 * @author Camille Letavernier
 */
public class LabelCustomizationMaskProvider implements XWTCompliantMaskProvider, XWTCompliantMaskProviderUpdater {

	private IMaskManagedLabelEditPolicy editPolicy;

	private DataSource input;

	private String propertyPath;

	private final Set<XWTCompliantMaskProviderListener> listeners = new HashSet<>();

	public LabelCustomizationMaskProvider() {
	}

	@Override
	public Map<String, String> getMasks() {
		return editPolicy.getMasks();
	}

	public void setProperty(String propertyPath) {
		this.propertyPath = propertyPath;
		checkInput();
	}

	public String getProperty() {
		return propertyPath;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.properties.ui.providers.XWTCompliantMaskProviderUpdater#setInput(org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource)
	 */
	@Override
	public void setInput(final DataSource input) {
		this.input = input;
		checkInput();
	}

	public DataSource getInput() {
		return input;
	}

	protected void checkInput() {
		if (input != null && propertyPath != null) {
			ModelElement element = input.getModelElement(propertyPath);
			if (element instanceof UMLNotationModelElement) {
				UMLNotationModelElement modelElement = (UMLNotationModelElement) element;
				editPolicy = (IMaskManagedLabelEditPolicy) modelElement.getEditPart().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
				if (editPolicy != null) {
					notifyListeners();
				}
			} else if (input.getSelection().getFirstElement() instanceof FloatingLabelEditPart) {
				EditPart editpart = (EditPart) input.getSelection().getFirstElement();
				editPolicy = (IMaskManagedLabelEditPolicy) editpart.getEditPolicy(IndirectMaskLabelEditPolicy.INDRIRECT_MASK_MANAGED_LABEL);
				if (editPolicy != null) {
					notifyListeners();
				}
			} else if (element instanceof CompositeModelElement) {
				editPolicy = null;
				IMaskManagedLabelEditPolicy currentEditPolicy = null;
				// Check that all elements have the same edit policy
				for (ModelElement subElement : ((CompositeModelElement) element).getSubElements()) {
					if (subElement instanceof UMLNotationModelElement) {
						UMLNotationModelElement modelElement = (UMLNotationModelElement) subElement;
						currentEditPolicy = (IMaskManagedLabelEditPolicy) modelElement.getEditPart().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
						if (currentEditPolicy == null) {
							editPolicy = null;
							break;
						}
						if (editPolicy != null && !editPolicy.getMasks().equals(currentEditPolicy.getMasks())) {
							editPolicy = null;
							break;
						}
						if (editPolicy == null) {
							editPolicy = currentEditPolicy;
							continue;
						}
					}
				}
				if (editPolicy != null) {
					notifyListeners();
				}
			}
		}
	}

	private void notifyListeners() {
		for (XWTCompliantMaskProviderListener listener : listeners) {
			listener.notifyReady(this);
		}
	}

	@Override
	public void addMaskProviderListener(XWTCompliantMaskProviderListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeMaskProviderListener(XWTCompliantMaskProviderListener listener) {
		listeners.remove(listener);
	}

}
