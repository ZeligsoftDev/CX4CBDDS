/*****************************************************************************
 * Copyright (c) 2008, 2017 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 522564
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.section;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;

/**
 * This section is used to apply stereotype on uml Element.
 */
public class AppliedStereotypeSectionWithView extends AbstractPropertySection {

	/** The stereotype composite. */
	private AppliedStereotypeCompositeWithView appliedStereotypeComposite;
	private MultipleReferenceEditor editor;

	/** The property composite. */
	// private AppliedStereotypePropertyCompositeWithView propertyComposite;

	/**
	 * Creates the controls.
	 *
	 * @param tabbedPropertySheetPage
	 *            the tabbed property sheet page
	 * @param parent
	 *            the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		appliedStereotypeComposite = new AppliedStereotypeCompositeWithView(parent);
		appliedStereotypeComposite.createContent(parent, getWidgetFactory());

		editor = new MultipleReferenceEditor(parent, 0);
		// propertyComposite = new AppliedStereotypePropertyCompositeWithView(parent, appliedStereotypeComposite);
		// propertyComposite.createContent(parent, getWidgetFactory());

		// appliedStereotypeComposite.setPropertyComposite(propertyComposite);
	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		appliedStereotypeComposite.refresh();
		editor.refreshValue();
	}

	/**
	 * Should use extra space.
	 *
	 * @return true, if successful
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
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection) selection).getFirstElement();

			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) input;
				View view = (View) graphicalEditPart.getModel();
				Element UMLElement = (Element) view.getElement();
				if (UMLElement != null) {
					appliedStereotypeComposite.setDiagramElement(view);
					// propertyComposite.setDiagramElement(view);
					appliedStereotypeComposite.setElement(UMLElement);
					appliedStereotypeComposite.setInput(new StereotypedElementTreeObject(UMLElement));
				}
			} else {
				EObject eobject = resolveSemanticObject(input);

				if (eobject instanceof Element) {
					Element UMLElement = (Element) eobject;
					appliedStereotypeComposite.setDiagramElement(null);
					appliedStereotypeComposite.setElement(UMLElement);
					appliedStereotypeComposite.setInput(new StereotypedElementTreeObject(UMLElement));
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
	 * @Override
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 *
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (appliedStereotypeComposite != null) {
			appliedStereotypeComposite.dispose();
		}
	}
}
