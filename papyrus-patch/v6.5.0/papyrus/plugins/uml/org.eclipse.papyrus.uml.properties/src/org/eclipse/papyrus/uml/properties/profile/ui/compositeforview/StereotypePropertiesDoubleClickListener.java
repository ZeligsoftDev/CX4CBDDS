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
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.uml.properties.profile.ui.listeners.DoubleClickListener;
import org.eclipse.swt.widgets.TreeItem;


/**
 * The Class StereotypePropertiesDoubleClickListener.
 */
public class StereotypePropertiesDoubleClickListener extends DoubleClickListener {

	/**
	 * The stereotype composite.
	 */
	protected AppliedStereotypeCompositeWithView stereotypeComposite;

	/**
	 * The property composite.
	 */
	protected AppliedStereotypePropertyCompositeWithView propertyComposite;

	/**
	 * The Constructor.
	 *
	 * @param propertyComposite
	 *            the property composite
	 * @param stereotypeComposite
	 *            the stereotype composite
	 * @param treeViewer
	 *            the tree viewer
	 * @param parent
	 *            the parent
	 */
	public StereotypePropertiesDoubleClickListener(TreeViewer treeViewer, AppliedStereotypeCompositeWithView stereotypeComposite,
			AppliedStereotypePropertyCompositeWithView propertyComposite) {
		super();
		this.treeViewer = treeViewer;
		this.stereotypeComposite = stereotypeComposite;
		this.propertyComposite = propertyComposite;
	}

	/**
	 * Item D clicked.
	 *
	 * @param item
	 *            the item
	 * @param index
	 *            the index
	 */
	@Override
	protected void itemDClicked(TreeItem item, int index) {
		super.itemDClicked(item, index);
		stereotypeComposite.refreshTreeViewer();
		propertyComposite.itemDClicked();
		propertyComposite.touchModel();
		propertyComposite.refresh();
	}
}
