/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana, Obeo . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Francisco Javier Cano Muñoz (Prodevelop) – Initial API implementation.
 *  Obeo
 *
 ******************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.actionprovider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * Specialization of <CommonActionProvider> to be used as Papyrus action
 * provider.
 *
 * @author fjcano
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractCommonActionProvider extends CommonActionProvider {

	/**
	 * Gets the ID of the <CommonViewer> this <MOSKittCommonActionProvider> is
	 * associated to.
	 *
	 * @return the viewer id
	 */
	// @unused
	protected String getViewerID() {
		return getActionSite().getViewSite().getId();
	}

	/**
	 * Gets the <MOSKittCommonNavigator> this <MOSKittCommonActionProvider> is
	 * associated with, via the viewerID.
	 *
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {

		return ((CommonViewer) getActionSite().getStructuredViewer()).getCommonNavigator();
		// IViewPart part = org.eclipse.papyrus.views.modelexplorer.NavigatorUtils
		// .findViewPart(getViewerID());
		// if (part instanceof CommonNavigator) {
		// return ((CommonNavigator) part);
		// }
		// return null;
	}

	/**
	 * Gets the current context's selection.
	 *
	 * @return the selection
	 */
	// @unused
	protected ISelection getSelection() {
		ActionContext context = getContext();
		return (context != null) ? context.getSelection() : null;
	}

	/**
	 * Gets the first element of the current context's selection.
	 *
	 * @return the first selected element
	 */
	protected Object getFirstSelectedElement() {
		ISelection selection = getSelection();
		if (selection instanceof StructuredSelection) {
			return ((StructuredSelection) selection).getFirstElement();
		}
		return null;
	}

	/**
	 * Resolve semantic element
	 *
	 * @param object
	 *            the object to resolve
	 * @return <code>null</code> or the semantic element associated to the
	 *         specified object
	 */
	protected EObject resolveSemanticObject(Object object) {
		return EMFHelper.getEObject(object);
	}
}
