/*******************************************************************************
 * Copyright (c) 2014, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Simon Delisle - bug 495753
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences.impl;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * Interactive content used for {@link IDifferenceGroupProvider} preferences.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class GroupsInteractiveContent {

	/** Height hint for the description label. */
	private static final int DESCRIPTION_LABEL_HEIGHT_HINT = 40;

	/** Width hint for configuration composite. */
	private static final int DESCRIPTION_LABEL_WIDTH_HINT = 400;

	/** Down icon picture. */
	private static final String ENABLE_DOWN_IMG = "icons/full/pref16/down.gif"; //$NON-NLS-1$

	/** Up icon picture. */
	private static final String ENABLE_UP_IMG = "icons/full/pref16/up.gif"; //$NON-NLS-1$

	/** Label that will display the viewer's description. */
	private final Label descriptionText;

	/** List of descriptors. */
	private ArrayList<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> descriptors;

	/** Button to decrease the rank of a item. */
	private Button downButton;

	/** Button to increase the rank of an item. */
	private Button upButton;

	/** Viewer of {@link IItemDescriptor}. */
	private ListViewer viewer;

	/** Composite holding the viewer. */
	private final Composite viewerCompsite;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            Main composite holding this group interactive content.
	 */
	public GroupsInteractiveContent(Composite parent) {
		super();
		Composite containerComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(containerComposite);
		containerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite interactiveComposite = new Composite(containerComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(interactiveComposite);
		interactiveComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label introductionText = new Label(interactiveComposite, SWT.WRAP);
		introductionText
				.setText(EMFCompareRCPUIMessages.getString("GroupsPreferencePage.viewerDescription.label")); //$NON-NLS-1$
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(introductionText);
		// Engine chooser composite
		this.viewerCompsite = new Composite(interactiveComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(viewerCompsite);
		viewerCompsite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// Descriptor engine Label
		createButtonComposite(interactiveComposite);
		this.descriptionText = createDescriptionComposite(interactiveComposite);
	}

	/**
	 * Creates the composite for up and down button.
	 * 
	 * @param parent
	 *            {@link Composite}
	 */
	private void createButtonComposite(Composite parent) {
		Composite buttonComposite = new Composite(parent, SWT.NONE);
		GridData layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		buttonComposite.setLayoutData(layoutData);
		buttonComposite.setLayout(new RowLayout(SWT.VERTICAL));
		upButton = new Button(buttonComposite, SWT.NONE);
		upButton.setImage(EMFCompareRCPUIPlugin.getImage(ENABLE_UP_IMG));
		upButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (upButton.equals(e.getSource())) {
					IItemDescriptor<Descriptor> selection = getCurrentSelection();
					int index = descriptors.indexOf(selection);
					descriptors.remove(selection);
					int newIndex = index - 1;
					if (newIndex <= descriptors.size()) {
						descriptors.add(newIndex, selection);
						setViewerInput(descriptors);
						select(selection);
					}
				}
			}
		});
		downButton = new Button(buttonComposite, SWT.NONE);
		downButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (downButton.equals(e.getSource())) {
					IItemDescriptor<Descriptor> selection = getCurrentSelection();
					int index = descriptors.indexOf(selection);
					descriptors.remove(selection);
					int newIndex = index + 1;
					if (newIndex <= descriptors.size()) {
						descriptors.add(newIndex, selection);
						setViewerInput(descriptors);
						select(selection);
					}
				}
			}
		});

		downButton.setImage(EMFCompareRCPUIPlugin.getImage(ENABLE_DOWN_IMG));

	}

	/**
	 * Composite for description. This composite holds the text widget that will update with the current
	 * selection
	 * 
	 * @param composite
	 *            Parent Composite.
	 * @return Label holding the description.
	 */
	private Label createDescriptionComposite(Composite composite) {
		Group descriptionComposite = new Group(composite, SWT.NONE);
		descriptionComposite.setText(
				EMFCompareRCPUIMessages.getString("InteractiveUIContent.descriptionComposite.label")); //$NON-NLS-1$
		GridLayoutFactory.swtDefaults().applyTo(descriptionComposite);
		descriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		Label engineDescriptionLabel = new Label(descriptionComposite, SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, false)
				.hint(DESCRIPTION_LABEL_WIDTH_HINT, DESCRIPTION_LABEL_HEIGHT_HINT)
				.applyTo(engineDescriptionLabel);
		return engineDescriptionLabel;
	}

	/**
	 * Gets the current selected descriptor.
	 * 
	 * @return current selected descriptor.
	 */
	@SuppressWarnings("unchecked")
	private IItemDescriptor<IDifferenceGroupProvider.Descriptor> getCurrentSelection() {
		final ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structSelection = (IStructuredSelection)selection;
			final Object first = structSelection.getFirstElement();
			if (first instanceof IItemDescriptor<?>) {
				return (IItemDescriptor<IDifferenceGroupProvider.Descriptor>)first;
			}
		}
		return null;
	}

	/**
	 * Gets {@link IItemDescriptor} of {IDifferenceGroupProvider.@link Descriptor} ordered by user.
	 * 
	 * @return The ordered list of {@link IItemDescriptor}.
	 */
	public List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> getOrderedItems() {
		return descriptors;
	}

	/**
	 * The composite holding the viewer.
	 * 
	 * @return Compsite
	 */
	public Composite getViewerComposite() {
		return viewerCompsite;
	}

	/**
	 * Returns true if o is the first object of descriptors, false otherwise.
	 * 
	 * @param o
	 *            Object to test
	 * @return True if is first.
	 */
	private boolean isFirst(Object o) {
		if (descriptors != null && !descriptors.isEmpty()) {
			return descriptors.get(0).equals(o);
		}
		return false;
	}

	/**
	 * Returns true if o is the last object of descriptor, false otherwise.
	 * 
	 * @param o
	 *            Object to test
	 * @return True if is last.
	 */
	private boolean isLast(Object o) {
		if (descriptors != null && !descriptors.isEmpty()) {
			return descriptors.get(descriptors.size() - 1).equals(o);
		}
		return false;
	}

	/**
	 * Handles a selection in the viewer. Updates related components.
	 * 
	 * @param descriptor
	 *            The descriptor to select.
	 */
	public void select(IItemDescriptor<IDifferenceGroupProvider.Descriptor> descriptor) {
		// Update viewer
		viewer.setSelection(new StructuredSelection(descriptor), true);
		updateLinkedElements(descriptor);
	}

	/**
	 * Sets the input for interactive content.
	 * 
	 * @param input
	 *            Input of the viewsr.
	 */
	public void setViewerInput(List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> input) {
		if (viewer != null) {
			this.descriptors = Lists.newArrayList(input);
			viewer.setInput(descriptors);
		} else {
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.ERROR,
					"Please initialize the viewer before setting input"); //$NON-NLS-1$
		}
	}

	/**
	 * Set the viewer.
	 * 
	 * @param inputViewer
	 *            A {@link ListViewer} of {@link IItemDescriptor}
	 */
	public void setViewer(ListViewer inputViewer) {
		this.viewer = inputViewer;
		viewer.addSelectionChangedListener(new DescriptionListener());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IItemDescriptor<?> selection = getCurrentSelection();
				if (selection == null) {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				} else {
					upButton.setEnabled(!isFirst(selection));
					downButton.setEnabled(!isLast(selection));
				}
			}

		});
	}

	/**
	 * Updates linked elements.
	 * 
	 * @param descriptor
	 *            Newly selected descriptor.
	 */
	private void updateLinkedElements(IItemDescriptor<IDifferenceGroupProvider.Descriptor> descriptor) {
		// Update description
		descriptionText.setText(descriptor.getDescription());
	}

	/**
	 * Listener to update description text.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private final class DescriptionListener implements ISelectionChangedListener {

		/**
		 * {@inheritDoc}
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structSelection = (IStructuredSelection)selection;
				Object selected = structSelection.getFirstElement();
				if (selected instanceof IItemDescriptor<?>) {
					IItemDescriptor<?> desc = (IItemDescriptor<?>)selected;
					String description = desc.getDescription();
					descriptionText.setText(description);
				}
			}

		}
	}
}
