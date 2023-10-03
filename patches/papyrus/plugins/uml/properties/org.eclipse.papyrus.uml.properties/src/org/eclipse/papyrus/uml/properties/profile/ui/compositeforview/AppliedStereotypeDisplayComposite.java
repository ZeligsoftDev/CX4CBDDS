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

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.preference.ProfilePreferenceConstants;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppearanceDecoratedTreeComposite;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;

/**
 * The Class StereotypeComposite.
 */
public class AppliedStereotypeDisplayComposite extends AppearanceDecoratedTreeComposite implements ISelectionChangedListener {

	// the parent panel instance
	/**
	 * The parent panel.
	 */
	private AppliedStereotypePanel parentPanel;

	// GUI related declarations
	/**
	 * The label.
	 */
	protected CLabel label;

	/**
	 * The default constructor.
	 *
	 * @param style
	 *            the style of this panel
	 * @param parent
	 *            the parent Composite for this panel
	 */
	public AppliedStereotypeDisplayComposite(AppliedStereotypePanel parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);

		parentPanel = parent;
	}

	/**
	 *
	 *
	 * @param parent
	 */
	public AppliedStereotypeDisplayComposite(Composite parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);
	}

	/**
	 *
	 *
	 * @param factory
	 * @param parent
	 *
	 * @return
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createStereotypesTree();

		return this;
	}

	/**
	 * Gets the selected.
	 *
	 * @return Returns the selected element.
	 */
	public Element getSelected() {
		return parentPanel.getSelected();
	}

	/**
	 * Gets the tree.
	 *
	 * @return the tree
	 */
	public Tree getTree() {
		return treeViewer.getTree();
	}

	/**
	 * Sets the input.
	 *
	 * @param element
	 *            the element
	 */
	public void setInput(StereotypedElementTreeObject element) {
		treeViewer.setInput(element);
		// boolean toto = Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STERETOYPES_TREE);
		if (Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STEREOTYPES_TREE)) {
			treeViewer.expandAll();
		}
	}

	/**
	 * Refresh the content of applied the applied stereotype tree.
	 */
	@Override
	public void refresh() {

		if (treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			treeViewer.refresh();
		}
	}

	/**
	 * Creates the stereotypes tree.
	 *
	 * @return the tree of applied stereotypes and properties
	 */
	private void createStereotypesTree() {
		// Tree viewer shows applied stereotypes
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());
		treeViewer.addFilter(new ProfileElementTreeViewerFilter());
		treeViewer.addSelectionChangedListener(this);
	}

	/**
	 *
	 *
	 * @param event
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if (parentPanel != null) {
			if (event == null) {
				parentPanel.setSelectedProperty(null);
				return;
			}

			IStructuredSelection structSelection = (IStructuredSelection) event.getSelection();
			Object selection = structSelection.getFirstElement();
			if (selection instanceof AppliedStereotypePropertyTreeObject) {
				parentPanel.setSelectedProperty((AppliedStereotypePropertyTreeObject) selection);
			} else {
				parentPanel.setSelectedProperty(null);
			}
		}
	}
}
