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
 *  Camille Letavernier (CEA LIST) Camille.letavernier@cea.fr - refactoring. Use standard Papyrus helpers. Remove a few GMF dependencies
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.section;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppearanceForAppliedStereotypeComposite;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;

/**
 * The Class StereotypePropertiesAppearanceSection manages the display of stereotype properties in Appearance Tab.
 */
public class AppliedStereotypeDisplaySection extends AbstractPropertySection {

	private AppearanceForAppliedStereotypeComposite appearanceForAppliedStereotype;

	private EModelElement diagramElement;

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		appearanceForAppliedStereotype = new AppearanceForAppliedStereotypeComposite(parent);
		appearanceForAppliedStereotype.createContent(parent, getWidgetFactory());

	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		appearanceForAppliedStereotype.refresh();
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

			diagramElement = NotationHelper.findView(input);
			Element semanticElement = UMLUtil.resolveUMLElement(input);
			if (diagramElement != null && semanticElement != null) {
				appearanceForAppliedStereotype.setSelection(selection);

				appearanceForAppliedStereotype.setElement(semanticElement);
				appearanceForAppliedStereotype.setInput(new StereotypedElementTreeObject(semanticElement));

				appearanceForAppliedStereotype.setDiagramElement(diagramElement);
			} else {
				// re-init the diagram element. Else, could cause a bug,
				// when the user selects a diagram element, then a non diagram element.
				// If display button is pressed, the "Toggle Display" button does not work correctly
				diagramElement = null;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.core.ui.properties.tabbed.PropertyViewSection#dispose()
	 */
	/**
	 *
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (appearanceForAppliedStereotype != null) {
			appearanceForAppliedStereotype.disposeListeners();
		}
	}
}
