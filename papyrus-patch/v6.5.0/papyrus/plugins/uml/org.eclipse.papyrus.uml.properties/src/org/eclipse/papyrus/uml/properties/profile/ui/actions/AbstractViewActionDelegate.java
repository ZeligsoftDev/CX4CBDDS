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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Element;

/**
 * Action delegate default implementation for this plugin. Is is based on a
 * selection of a {@link Element}.
 */
public abstract class AbstractViewActionDelegate implements IViewActionDelegate {

	/** current selection */
	protected Element selectedElement;

	/**
	 * {@inheritDoc}
	 */
	public void init(IViewPart view) {
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void run(IAction action);

	/**
	 * Returns <code>true</code> if the element is a selectableElement, i.e. if the action
	 * should be enabled
	 *
	 * @param element
	 *            the element to test
	 * @return <code>true</code> if the element can be selected
	 */
	protected boolean isSelectableElement(Object o) {
		return (o instanceof Element);
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		IStructuredSelection structSelection = null;
		if (selection instanceof IStructuredSelection) {
			structSelection = (IStructuredSelection) selection;
			// iterate the selection to update the selected element
			@SuppressWarnings("unchecked")
			Iterator<Object> it = structSelection.iterator();
			while (it.hasNext()) {
				Object o = it.next();
				if (o instanceof IAdaptable) {
					EObject eObject = EMFHelper.getEObject(o);
					if (eObject != null) {
						setSelectedElement(eObject);
					}
				}
				if (isSelectableElement(o)) {
					setSelectedElement(o);
					return;
				}
			}
		}
	}

	/**
	 * Sets the current selected element
	 *
	 * @param selectedElement
	 *            the new selected element
	 */
	protected void setSelectedElement(Object selectedElement) {
		if (selectedElement instanceof Element) {
			this.selectedElement = (Element) selectedElement;
		}
	}

	/**
	 * Returns current selected element
	 *
	 * @return current selected element may be null
	 */
	protected Element getSelectedElement() {
		return selectedElement;
	}

}
