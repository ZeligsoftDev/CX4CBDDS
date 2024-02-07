/*****************************************************************************
 * Copyright (c) 2008, 2014 CEA LIST and others.
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
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.provider.DisplayedProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.DecoratedTreeComposite;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AppearanceStereotypeComposite manages the display of stereotype properties from appearance tab.
 *
 * when {@link TreeViewer#setSelection(ISelection)} runs the code could be changed
 */
public class AppearanceForAppliedStereotypeComposite extends org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeDisplayComposite implements IViewComposite {


	private final static String STEREOTYPE_DISPLAY_TOOLTIP = "Display selected stereotype for the element in the diagram";

	private final static String STEREOTYPE_QN_DISPLAY_TOOLTIP = "Display selected stereotypes with their qualified name for the element in the diagram";

	private final static String STEREOTYPE_DISPLAY_NON_GRAPHICAL_TOOLTIP = "Stereotypes can only be displayed for elements with graphical representation. " + "Currently edited element is a non graphical element. "
			+ "(example: an element selected in the outline is not a graphical element)";


	protected DisplayedProfileElementLabelProvider displayedProfileElementLabelProvider = new DisplayedProfileElementLabelProvider();

	protected StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	protected StereotypeDisplayCommandExecution commandhelper = StereotypeDisplayCommandExecution.getInstance();




	/**
	 * Listener for the Display Button Specific behavior is implemented in {@link DecoratedTreeComposite#downButtonPressed()}.
	 *
	 * @author Chokri Mraidha
	 */
	private class DisplayButtonListener implements MouseListener {



		/**
		 * Mouse double click.
		 *
		 * @param e
		 *            the e
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse down.
		 *
		 * @param e
		 *            the e
		 */
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		/**
		 * Mouse up.
		 *
		 * @param e
		 *            the e
		 */
		public void mouseUp(MouseEvent e) {
			boolean withQualifiedName = false;
			if (e.getSource().equals(displayButtonQN)) {
				withQualifiedName = true;
			}
			TreeItem[] selectedTreeItems = getTree().getSelection();
			displayButtonPressed(withQualifiedName);
			// Keep selection
			if (!getTree().isDisposed()) {
				getTree().setSelection(selectedTreeItems);
			}

		}
	}

	/**
	 * The diagram element.
	 */
	protected EModelElement diagramElement = null;

	/**
	 * button that displays the element.
	 */
	protected Button displayButton;

	/**
	 * button that displays the element.
	 */
	protected Button displayButtonQN;

	/**
	 * Listener for the display button.
	 */
	protected MouseListener displayButtonListener;

	/**
	 * The selection.
	 */
	protected ISelection selection;

	private Adapter elementListener;

	/**
	 * The Constructor.
	 *
	 * @param parent
	 *            the parent
	 */
	public AppearanceForAppliedStereotypeComposite(Composite parent) {
		super(parent);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
		this.displayButtonListener = new DisplayButtonListener();
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);

		FormData data;
		displayButton = factory.createButton(this, "", SWT.PUSH);
		displayButton.setVisible(true);
		displayButton.setImage(ImageManager.IMG_DISPLAY);
		displayButton.setToolTipText(STEREOTYPE_DISPLAY_TOOLTIP);
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		displayButton.setLayoutData(data);
		displayButton.addMouseListener(displayButtonListener);

		// button for qualifiedName
		displayButtonQN = factory.createButton(this, "", SWT.PUSH);
		displayButtonQN.setVisible(true);
		displayButtonQN.setImage(ImageManager.IMG_CONSOLEVIEW_WITH_QN);
		displayButtonQN.setToolTipText(STEREOTYPE_QN_DISPLAY_TOOLTIP);
		data = new FormData();
		// data.top = new FormAttachment(addButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(displayButton, -ITabbedPropertyConstants.HSPACE);
		displayButtonQN.setLayoutData(data);
		displayButtonQN.addMouseListener(displayButtonListener);

		// Create label
		label = factory.createCLabel(this, name + ":", SWT.NONE);
		label.setLayout(new FormLayout());
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(displayButtonQN, -ITabbedPropertyConstants.HSPACE - 30);
		data.top = new FormAttachment(0, 0);
		label.setLayoutData(data);

		// Create and place Table
		treeViewer.setLabelProvider(displayedProfileElementLabelProvider);
		tree = treeViewer.getTree();
		tree.setLayout(new FormLayout());
		tree.setVisible(true);

		data = new FormData(SWT.DEFAULT, 50);
		data.top = new FormAttachment(displayButton, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);

		tree.setLayoutData(data);

		// Replace label and content providers in treeViewers
		treeViewer.setContentProvider(new ProfileElementWithDisplayContentProvider(diagramElement));
		// treeViewer.setLabelProvider(new ProfileElementWithDisplayLabelProvider());

		refresh();
		// Update buttons
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				refreshButtons();
			}
		});
		return this;
	}

	@Override
	public boolean isReadOnly() {
		EModelElement element = getDiagramElement();
		return (element == null) || EMFHelper.isReadOnly(element);
	}

	/**
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Update buttons status when items have been selected from the tree.
	 * If no stereotype selected in Appearance, disable the buttons to apply.
	 */
	private void refreshButtons() {
		if (tree == null || tree.isDisposed()) {
			return;
		}
		boolean enabled = (getDiagramElement() != null && !treeViewer.getSelection().isEmpty()) && !isReadOnly();
		if (displayButton != null && !displayButton.isDisposed()) {
			displayButton.setEnabled(enabled);
		}
		if (displayButtonQN != null && !displayButtonQN.isDisposed()) {
			displayButtonQN.setEnabled(enabled);
		}
	}

	/**
	 * Display button pressed.
	 */
	public void displayButtonPressed(boolean withQualifiedName) {
		// If nothing selected : abort
		if (getTree().getSelection().length < 1) {
			return;
		}

		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (getDiagramElement() == null) {
			return;
		}

		TreeItem[] treeSelection = getTree().getSelection();
		for (int i = 0; i < treeSelection.length; i++) {
			// In case of Stereotype
			if (treeSelection[i].getData() instanceof AppliedStereotypeTreeObject) {
				Stereotype stereo = ((AppliedStereotypeTreeObject) treeSelection[i].getData()).getStereotype();
				// test the image to know if the selection is already visible
				if (treeSelection[i].getImage().equals(ImageManager.IMG_STEREOTYPE)) { // if not visible display it with the proper depth.
					displayStereotypeLabel(stereo);
					if (withQualifiedName) {
						commandhelper.setDepth(getDomain(), stereo, (View) diagramElement, StereotypeDisplayConstant.DEPTH_MAX, true);
						treeSelection[i].setImage(ImageManager.DISPLAYED_STEREOTYPE_QN);
					} else {
						commandhelper.setDepth(getDomain(), stereo, (View) diagramElement, StereotypeDisplayConstant.DEPTH_MIN, true);
						treeSelection[i].setImage(ImageManager.IMG_STEREOTYPEDISPLAYED);
					}

				} else {
					// if we remove the stereotype we have to remove its properties also
					hideStereotypeLabel(stereo);
					treeSelection[i].setImage(ImageManager.IMG_STEREOTYPE);
				}
				// In case of Stereotype Property
			} else if (treeSelection[i].getData() instanceof AppliedStereotypePropertyTreeObject) {

				Property property = ((AppliedStereotypePropertyTreeObject) treeSelection[i].getData()).getProperty();
				Stereotype stereotype = ((AppliedStereotypePropertyTreeObject) treeSelection[i].getData()).getStereotype();
				// test the image to know if the selection is already visible
				if (treeSelection[i].getImage().equals(ImageManager.IMG_DISPLAYEDPROPERTY)) {
					hideStereotypeProperty(stereotype, property);
					treeSelection[i].setImage(ImageManager.IMG_PROPERTY);
				} else {
					displayStereotypeProperty(stereotype, property);
					treeSelection[i].setImage(ImageManager.IMG_DISPLAYEDPROPERTY);
				}
			}


		}

	}


	/**
	 * {@inheritDoc}
	 */
	public void disposeListeners() {
		if (displayButton != null && !displayButton.isDisposed()) {
			displayButton.removeMouseListener(displayButtonListener);
		}
	}

	/**
	 * returns the selected DiagramElement.
	 *
	 * @return the diagram element
	 */
	public EModelElement getDiagramElement() {
		return diagramElement;
	}

	public TransactionalEditingDomain getDomain() {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(element);
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Element getSelected() {
		Object input = ((IStructuredSelection) selection).getFirstElement();
		return UMLUtil.resolveUMLElement(input);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		if (diagramElement != null) {

			displayedProfileElementLabelProvider.setMainView((View) diagramElement);
		}
		super.refresh();
		// Update ToolTip text according to the diagramElement Value
		if ((diagramElement == null) && (!displayButton.isDisposed())) {
			displayButton.setToolTipText(STEREOTYPE_DISPLAY_NON_GRAPHICAL_TOOLTIP);
		} else if (!displayButton.isDisposed()) {
			displayButton.setToolTipText(STEREOTYPE_DISPLAY_TOOLTIP);
		}
		refreshButtons();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if (event == null) {
			return;
		}
	}

	/** Stereotype display operations **/

	/**
	 * Sets the diagram element.
	 *
	 * @param diagramElement
	 *            the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement) {
		this.diagramElement = diagramElement;
		((ProfileElementWithDisplayContentProvider) treeViewer.getContentProvider()).setDiagramElement(diagramElement);
	}

	/**
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Add a listener for stereotypes changing.
	 *
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.AppearanceDecoratedTreeComposite#setElement(org.eclipse.uml2.uml.Element)
	 *
	 * @param element
	 */
	@Override
	public void setElement(Element element) {
		if (getElement() != null && elementListener != null) {
			getElement().eAdapters().remove(elementListener);
		}
		super.setElement(element);
		if (element != null) {
			if (elementListener == null) {
				elementListener = new AdapterImpl() {

					@Override
					public void notifyChanged(final Notification msg) {
						handleNotifyChanged(msg);
					}
				};
			}
			element.eAdapters().add(elementListener);
		}
	}

	/**
	 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417372
	 * Refresh if Stereotypes have been changed.
	 *
	 * Stereotypes list is empty in the Appearance after the application of Stereotype in Profile.
	 */
	protected void handleNotifyChanged(Notification msg) {
		final int eventType = msg.getEventType();
		if (msg instanceof StereotypeExtensionNotification && (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT || eventType == StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT)) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					if (tree != null && !tree.isDisposed() && treeViewer != null && getElement() != null) {
						treeViewer.setInput(new StereotypedElementTreeObject(getElement()));
					}
					refresh();
				}
			});
		}
	}

	/**
	 * Sets the selection.
	 *
	 * @param selection
	 *            the selection
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}


	/**
	 * Display the stereotype once it is applied
	 *
	 * @param stereotype
	 *            the stereotype to add
	 * @param prop
	 */
	protected void displayStereotypeProperty(final Stereotype stereotype, final Property propertyToDisplay) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement != null) {

			try {


				View nodeToDisplay = StereotypeDisplayUtil.getInstance().getStereotypeProperty((View) diagramElement, stereotype, propertyToDisplay);
				View compartment = helper.getStereotypeCompartment((View) diagramElement, stereotype);

				if (nodeToDisplay == null) {
					nodeToDisplay = StereotypeDisplayUtil.getInstance().getStereotypePropertyInBrace((View) diagramElement, stereotype, propertyToDisplay);
				}

				if (compartment == null) {
					compartment = helper.getStereotypeBraceCompartment((View) diagramElement, stereotype);
				}

				if (compartment != null && nodeToDisplay != null) {

					commandhelper.setPersistency(getDomain(), nodeToDisplay, true);
					commandhelper.setVisibility(getDomain(), nodeToDisplay, true, true);
					if (!compartment.isVisible()) {
						commandhelper.setPersistency(getDomain(), compartment, true);
						commandhelper.setVisibility(getDomain(), compartment, true, true);
						hideOtherProperties(compartment, nodeToDisplay);
					}
				}


			} catch (Exception e) {
				Activator.logException(e);
			}
		}

	}





	/**
	 * Display the stereotype once it is applied
	 *
	 * @param stereotype
	 *            the stereotype to add
	 * @param propertyToHide
	 */
	protected void hideStereotypeProperty(final Stereotype stereotype, final Property propertyToHide) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement != null) {

			try {
				if (stereotype != null && propertyToHide != null) {
					// Retrieve the Stereotype Property View in Notation Model then make it persistent and hide it.
					View nodeToDisplay = StereotypeDisplayUtil.getInstance().getStereotypeProperty((View) diagramElement, stereotype, propertyToHide);
					View compartment = helper.getStereotypeCompartment((View) diagramElement, stereotype);

					if (nodeToDisplay == null) {
						nodeToDisplay = StereotypeDisplayUtil.getInstance().getStereotypePropertyInBrace((View) diagramElement, stereotype, propertyToHide);
					}

					if (compartment == null) {
						compartment = helper.getStereotypeBraceCompartment((View) diagramElement, stereotype);
					}

					if (compartment != null && nodeToDisplay != null) {

						commandhelper.setPersistency(getDomain(), nodeToDisplay, true);
						commandhelper.setVisibility(getDomain(), nodeToDisplay, false, true);
						// Then update the Compartment Visibility Accordingly
						updateCompartmentVisibility(compartment);
					}
				}

			} catch (Exception e) {
				Activator.logException(e);
			}
		}

	}



	/**
	 * Display the stereotype once it is applied
	 *
	 * @param stereotype
	 *            the stereotype of the Label to display
	 */
	protected void displayStereotypeLabel(final Stereotype stereotype) {
		if (diagramElement != null) {

			try {

				// Retrieve the Stereotype Label View in Notation Model then make it persistent and show it.
				View nodeToDisplay = helper.getStereotypeLabel((View) diagramElement, stereotype);
				if (nodeToDisplay != null) {
					commandhelper.setPersistency(getDomain(), nodeToDisplay, true);
					commandhelper.setVisibility(getDomain(), nodeToDisplay, true, true);
				}

			} catch (Exception e) {
				Activator.logException(e);
			}
		}

	}

	/**
	 * Display the stereotype once it is applied
	 *
	 * @param st
	 *            the stereotype to add
	 */
	protected void hideStereotypeLabel(final Stereotype stereotype) {

		if (diagramElement != null) {

			try {
				// Retrieve the Stereotype Label View in Notation Model then make it persistent and hide it.
				View nodeToDisplay = helper.getStereotypeLabel((View) diagramElement, stereotype);
				commandhelper.setPersistency(getDomain(), nodeToDisplay, true);
				commandhelper.setVisibility(getDomain(), nodeToDisplay, false, true);

			} catch (Exception e) {
				Activator.logException(e);
			}
		}

	}


	/**
	 * If the display of the Compartment changed, make the Compartment Persistent.
	 * 
	 * @param stereotypeCompartment
	 */
	private void updateCompartmentVisibility(final View stereotypeCompartment) {
		// If any Children visible, set Visibility
		// Else hide the Compartment
		boolean display = stereotypeCompartment.isVisible();
		// if display change, make the node persistent.
		// if the compartment has visible properties but is not displayed then change the visibility
		// if the compartment doesn't have visible property but is displayed then change the visibility
		if (helper.hasVisibleProperties(stereotypeCompartment) != display) {
			commandhelper.setPersistency(getDomain(), stereotypeCompartment, true);
			commandhelper.setVisibility(getDomain(), stereotypeCompartment, helper.hasVisibleProperties(stereotypeCompartment), true);

		}
	}

	/**
	 * Make the Properties node not visible except one.
	 * 
	 * @param compartment
	 *            The Stereotype Compartment that contains the properties.
	 * @param propertyToDisplay
	 *            The StereotypeProperty Node to keep visible.
	 */
	private void hideOtherProperties(final View compartment, final View propertyToDisplay) {
		for (Object child : compartment.getChildren()) {
			if (((helper.isStereotypeProperty(child)) || (helper.isStereotypeBraceProperty(child))) && (propertyToDisplay != child)) {
				commandhelper.setVisibility(getDomain(), (View) child, false, true);
			}
		}

	}





}
