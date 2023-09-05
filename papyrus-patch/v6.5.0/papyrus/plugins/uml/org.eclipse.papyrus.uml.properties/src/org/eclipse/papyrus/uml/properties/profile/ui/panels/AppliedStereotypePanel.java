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
package org.eclipse.papyrus.uml.properties.profile.ui.panels;

import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.PropertyComposite;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;


/**
 * The Class StereotypePanel.
 */
public class AppliedStereotypePanel extends AbstractPanel {

	/**
     *
     */
	public TabbedPropertySheetWidgetFactory factory;

	/**
     *
     */
	protected Composite parent;

	/**
	 * The property composite.
	 */
	protected PropertyComposite propertyComposite;

	/**
	 * The selected.
	 */
	protected Element selected;

	/**
	 * The stereotype composite.
	 */
	protected AppliedStereotypeCompositeOnModel stereotypeComposite;

	/**
	 * The default constructor.
	 *
	 * @param style
	 *            the style of this panel
	 * @param parent
	 *            the parent Composite for this panel
	 */
	public AppliedStereotypePanel(Composite parent, int style) {
		super(parent, style);
		factory = new TabbedPropertySheetWidgetFactory();
		this.parent = parent;
	}

	/**
	 * A constructor parameterized by a factory.
	 *
	 * @param style
	 * @param factory
	 * @param parent
	 */
	public AppliedStereotypePanel(Composite parent, TabbedPropertySheetWidgetFactory factory, int style) {
		super(parent, style);
		this.factory = factory;
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.odf.platform.uml2.ui.panels.AbstractPanel#createContent()
	 */
	/**
	 * Creates the content.
	 *
	 * @return the control
	 */
	@Override
	public Control createContent() {

		this.setLayout(new FormLayout());

		// Create profile composite
		stereotypeComposite = new AppliedStereotypeCompositeOnModel(this);
		stereotypeComposite.createContent(this, factory);

		propertyComposite = new PropertyComposite(this);
		propertyComposite.createContent(this, factory);

		FormData data;

		// stereotypeComposite placement
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(50);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);

		stereotypeComposite.setLayoutData(data);

		// propertyComposite placement
		data = new FormData();
		data.left = new FormAttachment(stereotypeComposite, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);

		propertyComposite.setLayoutData(data);
		return this;
	}

	/**
	 * Gets the control.
	 *
	 * @return the control for this panel
	 */
	public Control getControl() {
		return this;
	}

	/**
	 * Gets the selected.
	 *
	 * @return Returns the selected.
	 */
	public Element getSelected() {
		return selected;
	}

	/**
	 * Refresh the composites.
	 */
	@Override
	public void refresh() {
		// Refresh stereotypes and property values
		stereotypeComposite.refresh();
		propertyComposite.refresh();
	}

	/**
	 * Sets the selected.
	 *
	 * @param selected
	 *            The selected to set.
	 * @param elt
	 *            the elt
	 */
	public void setSelected(Element elt) {

		if (stereotypeComposite != null) {
			selected = elt;
			stereotypeComposite.setInput(new StereotypedElementTreeObject(elt));
			refresh();
		}
	}

	/**
	 * Sets the selected property.
	 *
	 * @param selected
	 *            The selected to set.
	 * @param elt
	 *            the elt
	 */
	public void setSelectedProperty(AppliedStereotypePropertyTreeObject elt) {
		propertyComposite.setInput(elt);
	}
}
