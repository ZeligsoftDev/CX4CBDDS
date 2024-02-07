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
package org.eclipse.papyrus.uml.properties.profile.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AbstractPanel;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedProfilePanel;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.DefaultPanel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


/**
 * This view displays different panels, given a selected element. For a package (and model),
 * it displays all profiles applied to this package. For an UML element, it displays
 * stereotypes applied to this element.
 * <p>
 * Panels are created using a factory, which should be overloaded when using a new selection manager.
 *
 */
public class ProfilePanelView extends ViewPart implements ISelectionListener, IPartListener {

	/** The parent. */
	protected Composite parent;

	/** The current target. */
	protected Object currentTarget;

	// keeps the reference to the panel (abstract class)
	/** The panel. */
	protected AbstractPanel panel;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the part control.
	 *
	 * @param parent
	 *            the parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		getViewSite().getPage().addSelectionListener(this);
		getViewSite().getPage().addPartListener(this);
		this.parent = parent;
		panel = new DefaultPanel(parent, 0);
		panel.createContent();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		panel.setFocus();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	/**
	 * Selection changed.
	 *
	 * @param part
	 *            the part
	 * @param selection
	 *            the selection
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (!selection.isEmpty()) {

			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Object previousTarget = currentTarget;
			currentTarget = null;

			// If more or less than 1 element is selected then nothing is active
			if (sSelection.size() == 1) {
				// Retrieve selected object
				Object object = sSelection.getFirstElement();
				// If the object is an edit part, try to get semantic bridge
				if (object instanceof Package) {
					currentTarget = object;
				} else if (object instanceof Element) {
					currentTarget = object;
				} else {
					currentTarget = null;
				}
			}
			if (previousTarget != currentTarget) {
				switchUI();
			}
		} else {
			currentTarget = null;
			switchUI();
		}
	}

	// IPartListener methods implementation
	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
	 */
	/**
	 * Part activated.
	 *
	 * @param part
	 *            the part
	 */
	public void partActivated(IWorkbenchPart part) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
	 */
	/**
	 * Part deactivated.
	 *
	 * @param part
	 *            the part
	 */
	public void partDeactivated(IWorkbenchPart part) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
	 */
	/**
	 * Part brought to top.
	 *
	 * @param part
	 *            the part
	 */
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
	 */
	/**
	 * Part opened.
	 *
	 * @param part
	 *            the part
	 */
	public void partOpened(IWorkbenchPart part) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
	 */
	/**
	 * Part closed.
	 *
	 * @param part
	 *            the part
	 */
	public void partClosed(IWorkbenchPart part) {
		switchUIDefault();
	}

	/**
	 * Changes the panel displayed in the view, depending on the type of the
	 * newly selected element.
	 */
	protected void switchUI() {
		if ((currentTarget != null) && (currentTarget instanceof Element)) {

			/*
			 * test to check if the panel is not disposed.
			 * Closing the panel view and open it again creates a second
			 * instance of panel, one of it is disposed, the new one is active
			 */
			if (!panel.isDisposed()) {
				panel.exitAction();
				panel.dispose();

				if (currentTarget instanceof Package) {
					panel = new AppliedProfilePanel(this.parent, 0);
					panel.createContent();
					((AppliedProfilePanel) panel).setSelected((Package) currentTarget);
				} else if (currentTarget instanceof Element) {
					panel = new AppliedStereotypePanel(this.parent, 0);
					panel.createContent();
					((AppliedStereotypePanel) panel).setSelected((Element) currentTarget);
				} else {
					panel = new DefaultPanel(this.parent, 0);
					panel.createContent();
				}
				panel.setBounds(panel.getParent().getBounds());
				panel.entryAction();
			}
		} else { // Something selected out of the model ???
			switchUIDefault();
		}
	}

	/**
	 * Replace current panel with default.
	 */
	private void switchUIDefault() {
		if (!panel.isDisposed()) {
			// Flush previous
			panel.exitAction();
			panel.dispose();
			// Create default
			panel = new DefaultPanel(this.parent, 0);
			panel.createContent();
			// SetBounds
			panel.setBounds(panel.getParent().getBounds());
			panel.entryAction();
		}
	}
}
