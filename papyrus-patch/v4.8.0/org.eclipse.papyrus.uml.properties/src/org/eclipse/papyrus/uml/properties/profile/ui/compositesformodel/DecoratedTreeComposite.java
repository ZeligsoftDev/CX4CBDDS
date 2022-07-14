/*****************************************************************************
 * Copyright (c) 2008, 2014, 2017 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 323802
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 522564
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewer;
import org.eclipse.papyrus.uml.profile.tree.PropertyValueTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;


/**
 * Base class for a complex section composite. This composite has a label, a
 * tree that describes a tree structure, and four buttons on the side of the
 * table to add an element into the tree, remove selected element(s), move up
 * or down the selected element.
 *
 * @author Remi SCHNEKENBURGER
 */
public abstract class DecoratedTreeComposite extends Composite implements ISectionComposite {

	// child composites for the table composite

	// /** main composite of this complex composite */
	// protected Composite composite;
	/**
	 * Label above the table.
	 */
	protected CLabel label;

	/**
	 * Table that displays a property for the current element.
	 */
	protected Tree tree;

	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;

	/**
	 * Button that adds an element.
	 */
	protected Button addButton;

	/**
	 * Button that removes an element.
	 */
	protected Button removeButton;

	/**
	 * button that moves the element up.
	 */
	protected Button upButton;

	/**
	 * button that moves the element down.
	 */
	protected Button downButton;

	// listeners for buttons
	/**
	 * Listener for the add button.
	 */
	protected MouseListener addButtonlistener;

	/**
	 * Listener for the delete button.
	 */
	protected MouseListener removeButtonlistener;

	/**
	 * Listener for the up button.
	 */
	protected MouseListener upButtonlistener;

	/**
	 * Listener for the down button.
	 */
	protected MouseListener downButtonlistener;
	
	/**
	 * DisposeListener registered for the composite parent
	 */
	protected DisposeListener parentDisposeListener;

	/**
	 *
	 */
	protected Listener treeListener;

	/**
	 * Element selected in the Papyrus modeler.
	 */
	protected Element element;


	// Construction parameters for the composite
	/**
	 * text of the label.
	 */
	protected String name;

	/**
	 * returns the element that is selected in Papyrus tool, for which
	 * properties are displayed in the property section.
	 *
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * Sets the element that holds property displyed in property section.
	 *
	 * @param element
	 *            the element to set
	 */
	public void setElement(Element element) {
		this.element = element;

		updateEnablement();
	}

	/**
	 * Constructor.
	 *
	 * @param style
	 * @param isStereotypeTree
	 * @param name
	 *            text of the Label on the top left of this composite
	 * @param parent
	 */
	public DecoratedTreeComposite(Composite parent, int style, String name, boolean isStereotypeTree) {
		super(parent, style);
		
		//we register a dispose listener on the parent because the dispose method is never called during the dispose
		//see https://stackoverflow.com/questions/25717036/why-swt-ctabitem-doesnt-dispose-child-widget-recursively 
		parent.addDisposeListener(this.parentDisposeListener = new LocalDisposeListener());
		
		this.name = name;
		this.setLayout(new FormLayout());

		this.addButtonlistener = new AddButtonlistener();
		this.removeButtonlistener = new RemoveButtonlistener();
		this.upButtonlistener = new UpButtonlistener();
		this.downButtonlistener = new DownButtonlistener();

		if (isStereotypeTree) {
			treeViewer = new ProfileElementTreeViewer(this);
		} else {
			// Property tree
			treeViewer = new PropertyValueTreeViewer(this);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.composites.ISectionComposite#createContent(org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory)
	 */
	/**
	 *
	 *
	 * @param factory
	 * @param parent
	 *
	 * @return
	 */
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {

		FormData data;

		// ///////////////////////////////////////////////////////////////////////////
		// Create and place button vertically on the left side
		// Button : Add Element
		// Button Delete Element
		removeButton = factory.createButton(this, "", SWT.PUSH);
		removeButton.setVisible(true);
		removeButton.setImage(ImageManager.IMG_DELETE);
		removeButton.setToolTipText("Delete selected element(s)");
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		removeButton.setLayoutData(data);
		removeButton.addMouseListener(removeButtonlistener);

		addButton = factory.createButton(this, "", SWT.PUSH);
		addButton.setVisible(true);
		addButton.setImage(ImageManager.IMG_ADD);
		addButton.setToolTipText("Add a new element");

		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(removeButton, -ITabbedPropertyConstants.HSPACE);
		addButton.setLayoutData(data);
		addButton.addMouseListener(addButtonlistener);

		// Button Up
		upButton = factory.createButton(this, "", SWT.PUSH);
		upButton.setVisible(true);
		upButton.setImage(ImageManager.IMG_UP);
		upButton.setToolTipText("Up");

		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(addButton, -ITabbedPropertyConstants.HSPACE);
		upButton.setLayoutData(data);
		upButton.addMouseListener(upButtonlistener);


		// Button Down
		downButton = factory.createButton(this, "", SWT.PUSH);
		downButton.setVisible(true);
		downButton.setImage(ImageManager.IMG_DOWN);
		downButton.setToolTipText("Down");

		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(upButton, -ITabbedPropertyConstants.HSPACE);
		downButton.setLayoutData(data);
		downButton.addMouseListener(downButtonlistener);

		// Create label
		label = factory.createCLabel(this, name + ":", SWT.NONE);
		label.setLayout(new FormLayout());
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(downButton, -ITabbedPropertyConstants.HSPACE - 30);
		data.top = new FormAttachment(0, 0);
		label.setLayoutData(data);

		// ///////////////////////////////////////////////////////////////////////////
		// Create and place Table
		tree = treeViewer.getTree();
		tree.setLayout(new FormLayout());
		tree.setVisible(true);
		tree.addListener(SWT.MouseDoubleClick, treeListener = new EditItemListener());

		data = new FormData();
		data.top = new FormAttachment(addButton, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);

		tree.setLayoutData(data);

		// initialize enablement of controls
		updateEnablement();

		return this;
	}

	public void refresh() {
		updateEnablement();
	}

	protected boolean isEditable() {
		return (element != null) && !EMFHelper.isReadOnly(element);
	}

	protected void updateEnablement() {
		boolean isEditable = isEditable();

		if ((addButton != null) && !addButton.isDisposed()) {
			addButton.setEnabled(isEditable);
			removeButton.setEnabled(isEditable);
			upButton.setEnabled(isEditable);
			downButton.setEnabled(isEditable);
		}
	}

	// /**
	// * Sets the layout data to the main composite of this complex element
	// * @param data the new LayoutData
	// */
	// public void setLayoutData(Object data) {
	// composite.setLayoutData(data);
	// }
	//
	// public Composite getMainComposite() {
	// return composite;
	// }

	/**
	 * Returns the CommmandStack of the current editor.
	 *
	 * @return the CommmandStack of the current editor
	 */
	public CommandStack getCommandStack() {
		if (getActiveEditor() != null) {
			return (CommandStack) getActiveEditor().getAdapter(CommandStack.class);
		}
		return null;
	}

	/**
	 * Returns the current Editor.
	 *
	 * @return the current editor
	 */
	public IEditorPart getActiveEditor() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	/**
	 * action executed when the add button is pressed.
	 */
	public void addButtonPressed() {
	}

	/**
	 * @param pSelection
	 */
	public void keepSelection(ISelection pSelection) {

	}

	/**
	 * action executed when the remove button is pressed.
	 */
	public abstract void removeButtonPressed();

	/**
	 * action executed when the up button is pressed.
	 */
	public abstract void upButtonPressed();

	/**
	 * action executed when the down button is pressed.
	 */
	public abstract void downButtonPressed();

	/**
	 * action executed when a table item is edited.
	 *
	 * @param item
	 */
	public abstract void editItem(TreeItem item);

	/**
	 * Listener for the Add Button
	 * Specific behavior is implemented in {@link DecoratedTreeComposite#addButtonPressed()}.
	 *
	 * @author Remi SCHNEKENBURGER
	 */
	private class AddButtonlistener implements MouseListener {

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseUp(MouseEvent e) {
			addButtonPressed();
			refresh();
		}
	}

	/**
	 * Listener for the Remove Button
	 * Specific behavior is implemented in {@link DecoratedTreeComposite#removeButtonPressed()}.
	 *
	 * @author Remi SCHNEKENBURGER
	 */
	private class RemoveButtonlistener implements MouseListener {

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseUp(MouseEvent e) {
			removeButtonPressed();
			refresh();
		}
	}

	/**
	 * Listener for the Up Button
	 * Specific behavior is implemented in {@link DecoratedTreeComposite#upButtonPressed()}.
	 *
	 * @author Remi SCHNEKENBURGER
	 */
	private class UpButtonlistener implements MouseListener {

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseUp(MouseEvent e) {
			ISelection selection = treeViewer.getSelection();
			upButtonPressed();
			refresh();
			// Keep selection
			keepSelection(selection);
		}
	}

	/**
	 * Listener for the Down Button
	 * Specific behavior is implemented in {@link DecoratedTreeComposite#downButtonPressed()}.
	 *
	 * @author Remi SCHNEKENBURGER
	 */
	private class DownButtonlistener implements MouseListener {

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 *
		 *
		 * @param e
		 */
		public void mouseUp(MouseEvent e) {
			ISelection vSelection = treeViewer.getSelection();

			downButtonPressed();
			refresh();
			// Keep selection
			keepSelection(vSelection);

		}
	}

	/**
	 *
	 */
	private class EditItemListener implements Listener {

		/**
		 *
		 *
		 * @param event
		 */
		public void handleEvent(Event event) {
			if (tree.getSelection().length > 0) {
				TreeItem item = tree.getSelection()[0];
				editItem(item);
			}
		}
	}

	/**
	 * Dipose listeners.
	 */
	public void disposeListeners() {
		if(!getParent().isDisposed()){
			getParent().removeDisposeListener(this.parentDisposeListener);
		}
		if (addButton != null && !addButton.isDisposed()) {
			addButton.removeMouseListener(addButtonlistener);
		}
		if (removeButton != null && !removeButton.isDisposed()) {
			removeButton.removeMouseListener(removeButtonlistener);
		}
		if (upButton != null && !upButton.isDisposed()) {
			upButton.removeMouseListener(upButtonlistener);
		}
		if (downButton != null && !downButton.isDisposed()) {
			downButton.removeMouseListener(downButtonlistener);
		}
		if (tree != null && !tree.isDisposed()) {
			tree.removeListener(SWT.MouseDoubleClick, treeListener);
		}
	}
	
	/**
	 * DisposeListener used to listen the parent composite
	 */
	private class LocalDisposeListener implements DisposeListener{

		/**
		 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
		 *
		 * @param e
		 */
		@Override
		public void widgetDisposed(DisposeEvent e) {
			dispose();
		}
		
	}
	
	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 *
	 */
	@Override
	public void dispose() {
		disposeListeners();
		super.dispose();
	}
}
