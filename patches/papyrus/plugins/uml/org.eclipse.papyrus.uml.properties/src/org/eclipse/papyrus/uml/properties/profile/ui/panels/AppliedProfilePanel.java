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

import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedProfileCompositeOnModel;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.PropertyComposite;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Package;


/**
 * The Class ProfilePanel.
 *
 * @deprecated
 */
@Deprecated
public class AppliedProfilePanel extends AppliedStereotypePanel {

	/**
	 * The profile composite.
	 */
	protected AppliedProfileCompositeOnModel profileComposite;

	/**
	 * The default constructor.
	 *
	 * @param style
	 *            the style of this panel
	 * @param parent
	 *            the parent Composite for this panel
	 */
	public AppliedProfilePanel(Composite parent, int style) {
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
	public AppliedProfilePanel(Composite parent, TabbedPropertySheetWidgetFactory factory, int style) {
		super(parent, style);
		this.parent = parent;
		this.factory = factory;
	}

	/**
	 *
	 *
	 * @return the factory
	 */
	public TabbedPropertySheetWidgetFactory getFactory() {
		return factory;
	}

	/**
	 * Sets the selected.
	 *
	 * @param selected
	 *            The selected to set.
	 * @param pkg
	 *            the pkg
	 */
	public void setSelected(Package pkg) {
		super.setSelected(pkg);
		if (profileComposite != null) {
			selected = pkg;
			profileComposite.refresh();
		}

		super.setSelected(pkg);
	}

	/**
	 * Gets the control.
	 *
	 * @return the control for this panel
	 */
	@Override
	public Control getControl() {
		return this;
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

		FormLayout panelLayout = new FormLayout();
		this.setLayout(panelLayout);

		// Create profile composite
		profileComposite = new AppliedProfileCompositeOnModel(this);
		profileComposite.createContent();

		FormData data = new FormData();

		// Composite placement
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(50, 0);

		profileComposite.setLayoutData(data);

		// Create profile composite
		stereotypeComposite = new AppliedStereotypeCompositeOnModel(this);
		stereotypeComposite.createContent(this, factory);

		propertyComposite = new PropertyComposite(this);
		propertyComposite.createContent(this, factory);

		// stereotypeComposite placement
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(50);
		data.top = new FormAttachment(profileComposite, 0);
		data.bottom = new FormAttachment(100, 0);
		data.height = 80;
		stereotypeComposite.setLayoutData(data);

		// propertyComposite placement
		data = new FormData();
		data.left = new FormAttachment(stereotypeComposite, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(profileComposite, 0);
		data.bottom = new FormAttachment(100, 0);

		propertyComposite.setLayoutData(data);

		return this;
	}

	/**
	 * Refresh the content of applied the profile list.
	 */
	@Override
	public void refresh() {
		// Refresh stereotypes
		profileComposite.refresh();
		super.refresh();
	}
}
