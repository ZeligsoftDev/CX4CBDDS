/*****************************************************************************
 * Copyright (c) 2008 CEA LIST, Obeo.
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
 *  Jerome BENOIS (Obeo) jerome.benois@obeo.fr - improve to deal with EEF based properties view and model explorer
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.section;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedProfileCompositeWithView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * This section is used to apply a profile on packages or model
 *
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class AppliedProfileSection extends AbstractPropertySection {

	private AppliedProfileCompositeWithView appliedProfileComposite;

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		appliedProfileComposite = new AppliedProfileCompositeWithView(parent, getWidgetFactory());
		appliedProfileComposite.createContent();
	}

	/**
	 *
	 *
	 * @return
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		appliedProfileComposite.refresh();
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection) selection).getFirstElement();
			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) input;
				View view = (View) graphicalEditPart.getModel();
				if (view.getElement() != null) {
					appliedProfileComposite.setSelection(selection);
				}
			} else {
				EObject eObject = resolveSemanticObject(input);
				if (eObject != null && eObject instanceof EObject) {
					appliedProfileComposite.setSelection(selection);
				}
			}
		}
	}

	/**
	 * Resolve semantic element
	 *
	 * @param object
	 *            the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (EMFHelper.getEObject(adaptable) != null) {
				return EMFHelper.getEObject(adaptable);
			}
		}
		return null;
	}

	/**
	 *
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (appliedProfileComposite != null) {
			appliedProfileComposite.disposeListeners();
		}
	}
}
