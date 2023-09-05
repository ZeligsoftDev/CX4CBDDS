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
package org.eclipse.papyrus.uml.properties.profile.ui.listeners;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.ValueTreeObject;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;



/**
 * The Class DoubleClickListener.
 */
public class DoubleClickListener implements Listener {

	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;

	/**
	 *
	 */
	public DoubleClickListener() {
		super();
	}

	/**
	 * Handle event.
	 *
	 * @param e
	 *            the e
	 */
	public void handleEvent(Event e) {
		if ((e.widget != null) && (e.widget.getData() != null) && (e.widget.getData() instanceof AppliedStereotypePropertyTreeObject)) {
			AppliedStereotypePropertyTreeObject pto = (AppliedStereotypePropertyTreeObject) e.widget.getData();
			if ((pto.getProperty() != null) && pto.getProperty().isReadOnly()) {
				return;
			}
		}
		int index = getSelectionIndex();
		TreeItem item = getSelection();
		if (item != null) {
			itemDClicked(item, index);
		}
	}

	/**
	 * When doubleclicked : opens a dialog to allow edition of a new PrimitiveType.
	 *
	 * @param item
	 *            the item
	 * @param index
	 *            the index
	 * @param selectedElt
	 *            the element that owns the stereotype
	 * @param value
	 *            the current value or list of values of the property if isMultivalued
	 * @param isMultivalued
	 *            is the property multivalued or not
	 * @param selectedProp
	 *            the selected property
	 * @param currentStereotype
	 *            the stereotype associated to selectedProp
	 */
	protected void itemDClicked(TreeItem item, int index) {
		if (!(item.getData() instanceof ValueTreeObject)) {
			return;
		}
		ValueTreeObject object = (ValueTreeObject) item.getData();

		if (object instanceof ValueTreeObject) {
			object.editMe();
		}
	}

	/**
	 * Gets the selection index.
	 *
	 * @return the selection index
	 */
	private int getSelectionIndex() {
		int index = -1;

		TreeItem selectedItem = getSelection();
		if (selectedItem != null) {
			index = treeViewer.getTree().indexOf(selectedItem);
		}
		return index;
	}

	/**
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	private TreeItem getSelection() {
		TreeItem item = null;

		if (treeViewer != null) {
			TreeItem[] selectedItems = treeViewer.getTree().getSelection();
			if ((selectedItems != null) && (selectedItems.length == 1)) {
				item = selectedItems[0];
			}
		}
		return item;
	}
}
