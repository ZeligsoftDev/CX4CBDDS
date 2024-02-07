/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.section;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * The Class StereotypePropertiesPlaceSection allows users to select the way to display stereotype properties.
 *
 */
public class AppliedStereotypePropertiesPlaceSection extends AbstractPropertySection implements Adapter {

	/**
	 * The stereotype appearance.
	 */
	private CLabel stereotypePropertiesPlace;

	/**
	 * The combo stereotype appearance.
	 */
	private CCombo comboStereotypePropertiesPlace;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener comboStereotypePropertiesPlaceListener;

	private String stereotypePlacePresentation = UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION;

	private EModelElement diagramElement;

	private TransactionalEditingDomain domain;

	/**
	 * Creates the controls.
	 *
	 * @param tabbedPropertySheetPage
	 *            the tabbed property sheet page
	 * @param parent
	 *            the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		comboStereotypePropertiesPlace = getWidgetFactory().createCCombo(composite, SWT.BORDER);
		comboStereotypePropertiesPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION);
		comboStereotypePropertiesPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		comboStereotypePropertiesPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);

		data = new FormData();
		data.left = new FormAttachment(0, 200);
		data.top = new FormAttachment(0, 0);
		comboStereotypePropertiesPlace.setLayoutData(data);

		stereotypePropertiesPlace = getWidgetFactory().createCLabel(composite, "Place of applied stereotype properties:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(comboStereotypePropertiesPlace, 0);
		data.top = new FormAttachment(comboStereotypePropertiesPlace, 1, SWT.CENTER);
		stereotypePropertiesPlace.setLayoutData(data);

		comboStereotypePropertiesPlaceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (diagramElement != null) {
					stereotypePlacePresentation = comboStereotypePropertiesPlace.getText();

					RecordingCommand command = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, diagramElement, stereotypePlacePresentation);
					domain.getCommandStack().execute(command);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		comboStereotypePropertiesPlace.addSelectionListener(comboStereotypePropertiesPlaceListener);

	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if ((!comboStereotypePropertiesPlace.isDisposed())) {

			comboStereotypePropertiesPlace.removeSelectionListener(comboStereotypePropertiesPlaceListener);

			if (diagramElement != null) {
				if (isComboEnabled()) {
					comboStereotypePropertiesPlace.setEnabled(true);
					stereotypePlacePresentation = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement);
					comboStereotypePropertiesPlace.setText(stereotypePlacePresentation);
				} else {
					comboStereotypePropertiesPlace.setEnabled(false);
					comboStereotypePropertiesPlace.setText(stereotypePlacePresentation);
				}
			}
			comboStereotypePropertiesPlace.addSelectionListener(comboStereotypePropertiesPlaceListener);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {

		super.dispose();
		diagramElement.eAdapters().remove(this);
		if (comboStereotypePropertiesPlace != null && !comboStereotypePropertiesPlace.isDisposed()) {
			comboStereotypePropertiesPlace.removeSelectionListener(comboStereotypePropertiesPlaceListener);
		}
	}

	/**
	 * Helper method to indicate whether comboStereotypePropertiesPlace is enabled or not. The combo is enabled only within class and requirement
	 * diagram
	 */

	private boolean isComboEnabled() {
		if (!AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(diagramElement).equals("")) {
			return true;
		}
		return false;
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

			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				diagramElement = (EModelElement) ((GraphicalEditPart) input).getModel();
				diagramElement.eAdapters().add(this);
			} else {
				// re-init the diagram element. Else, could cause a bug,
				// when the user selects a diagram element, then a non diagram element.
				// If display button is pressed, the "Toggle Display" button does not work correctly
				diagramElement = null;
			}
			// When the selection is computed from the outline, get the associated editor
			if (part instanceof ContentOutline) {
				IContributedContentsView contributedView = (((ContentOutline) part).getAdapter(IContributedContentsView.class));
				if (contributedView != null) {
					part = contributedView.getContributingPart();
				}
			}

			if (part instanceof IAdaptable) {
				domain = ((IAdaptable) part).getAdapter(TransactionalEditingDomain.class);
			}
		}
	}

	public void notifyChanged(Notification notification) {
		refresh();

	}

	public Notifier getTarget() {
		
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return type.equals(diagramElement.getClass());
	}

	public void setTarget(Notifier newTarget) {
		

	}
}
