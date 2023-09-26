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
package org.eclipse.papyrus.uml.properties.profile.ui.section;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class AppliedStereotypeKindAppearanceSection extends AbstractPropertySection {

	/** constant for stereotype text alignement */
	private static final String VERTICAL = "Vertical";

	/** constant for stereotype text alignement */
	private static final String HORIZONTAL = "Horizontal";

	/** constant for stereotype appearance section. Style: text and icon */
	private static final String TEXT_AND_ICON = "Text and Icon";

	/** constant for stereotype appearance section. Style: shape */
	private static final String SHAPE = "Shape";

	/** constant for stereotype appearance section. Style: icon */
	private static final String ICON = "Icon";

	/** constant for stereotype appearance section. Style: text */
	private static final String TEXT = "Text";

	/** current presentation for stereotype */
	private String stereotypePlacePresentation = UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION;

	private EModelElement diagramElement;

	/**
	 * The stereotype appearance.
	 */
	private CLabel stereotypeAppearance;

	/**
	 * The stereotype text alignment.
	 */
	private CLabel stereotypeTextAlignement;

	/**
	 * The combo stereotype appearance.
	 */
	private CCombo comboStereotypeAppearance;

	/**
	 * The combo stereotype alignment.
	 */
	private CCombo comboStereotypeAlignement;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener comboStereotypeAppearanceListener;

	/**
	 * The combo stereotype alignment listener.
	 */
	private SelectionListener comboStereotypeAlignementListener;

	private TransactionalEditingDomain domain;

	private CLabel stereotypeDisplayPlace;

	private CCombo comboStereotypeDisplayPlace;

	private SelectionListener comboStereotypeDisplayListener;

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

		stereotypeAppearance = getWidgetFactory().createCLabel(composite, "Stereotype Display:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		stereotypeAppearance.setLayoutData(data);

		comboStereotypeAppearance = getWidgetFactory().createCCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		comboStereotypeAppearance.add(TEXT);
		comboStereotypeAppearance.add(ICON);
		comboStereotypeAppearance.add(TEXT_AND_ICON);
		comboStereotypeAppearance.add(SHAPE);
		data = new FormData();
		data.left = new FormAttachment(0, 135);
		data.top = new FormAttachment(0, 0);
		comboStereotypeAppearance.setLayoutData(data);

		comboStereotypeAppearanceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (diagramElement != null) {
					if (((View) (diagramElement)).getElement() != null) {

						org.eclipse.uml2.uml.Element elt = (Element) ((View) (diagramElement)).getElement();

						// get the first displayed stereotype
						Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, elt);

						boolean hasIcons = ElementUtil.hasIcons(elt, stereotype);
						boolean hasShapes = ElementUtil.hasShapes(elt, stereotype);
						String appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
						String stereotypeAppearance = comboStereotypeAppearance.getText();
						if (stereotypeAppearance.equals(TEXT)) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
						} else if (stereotypeAppearance.equals(ICON) && hasIcons) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION;
						} else if (stereotypeAppearance.equals(TEXT_AND_ICON) && hasIcons) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION;
						} else if (stereotypeAppearance.equals(SHAPE) && hasShapes) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION;
						}
						String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
						RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
						domain.getCommandStack().execute(command);
						refresh();
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		comboStereotypeAppearance.addSelectionListener(comboStereotypeAppearanceListener);

		stereotypeTextAlignement = getWidgetFactory().createCLabel(composite, "Text Alignement:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(comboStereotypeAppearance, 40);
		data.top = new FormAttachment(comboStereotypeAppearance, 1, SWT.CENTER);
		stereotypeTextAlignement.setLayoutData(data);

		comboStereotypeAlignement = getWidgetFactory().createCCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		comboStereotypeAlignement.add(HORIZONTAL);
		comboStereotypeAlignement.add(VERTICAL);
		data = new FormData();
		data.left = new FormAttachment(stereotypeTextAlignement, 0);
		data.top = new FormAttachment(0, 0);
		comboStereotypeAlignement.setLayoutData(data);

		comboStereotypeAlignementListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (diagramElement != null) {
					if (((View) (diagramElement)).getElement() != null) {

						String appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
						if (comboStereotypeAlignement.getText().equals(HORIZONTAL)) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
						} else if (comboStereotypeAlignement.getText().equals(VERTICAL)) {
							appliedStereotypeKind = UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION;
						}
						String stereotypetoDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
						RecordingCommand command = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(domain, diagramElement, stereotypetoDisplay, appliedStereotypeKind);
						domain.getCommandStack().execute(command);
						refresh();
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		comboStereotypeAlignement.addSelectionListener(comboStereotypeAlignementListener);

		// combo for display place choice
		stereotypeDisplayPlace = getWidgetFactory().createCLabel(composite, "Display Place:");
		data = new FormData();
		data.left = new FormAttachment(comboStereotypeAlignement, 40);
		data.top = new FormAttachment(comboStereotypeAlignement, 1, SWT.CENTER);
		stereotypeDisplayPlace.setLayoutData(data);

		comboStereotypeDisplayPlace = getWidgetFactory().createCCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		comboStereotypeDisplayPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION);
		comboStereotypeDisplayPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		comboStereotypeDisplayPlace.add(UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);

		data = new FormData();
		data.left = new FormAttachment(stereotypeDisplayPlace, 0);
		data.top = new FormAttachment(0, 0);
		comboStereotypeDisplayPlace.setLayoutData(data);

		comboStereotypeDisplayListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (diagramElement != null) {
					stereotypePlacePresentation = comboStereotypeDisplayPlace.getText();

					RecordingCommand command = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, diagramElement, stereotypePlacePresentation);
					domain.getCommandStack().execute(command);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		comboStereotypeDisplayPlace.addSelectionListener(comboStereotypeDisplayListener);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection) selection).getFirstElement();

			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				diagramElement = (EModelElement) ((GraphicalEditPart) input).getModel();
			} else {
				// re-init the diagram element. Else, could cause a bug,
				// when the user selects a diagram element, then a non diagram element.
				// If display button is pressed, the "Toggle Display" button does not work correctly
				diagramElement = null;
			}
			// When the selection is computed from the outline, get the associated editor
			if (part instanceof ContentOutline) {
				IContributedContentsView contributedView = ((IContributedContentsView) ((ContentOutline) part).getAdapter(IContributedContentsView.class));
				if (contributedView != null) {
					part = contributedView.getContributingPart();
				}
			}

			if (part instanceof IAdaptable) {
				domain = (TransactionalEditingDomain) ((IAdaptable) part).getAdapter(TransactionalEditingDomain.class);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		refreshStereotypeAppearance();
		refreshStereotypeAlignment();
		refreshStereotypeDisplayLocation();
	}

	private void refreshStereotypeDisplayLocation() {
		if (comboStereotypeDisplayPlace != null && !comboStereotypeDisplayPlace.isDisposed()) {
			comboStereotypeDisplayPlace.removeSelectionListener(comboStereotypeDisplayListener);

			if (diagramElement != null) {
				if (isComboEnabled()) {
					comboStereotypeDisplayPlace.setEnabled(true);
					stereotypePlacePresentation = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement);
					comboStereotypeDisplayPlace.setText(stereotypePlacePresentation);
				} else {
					comboStereotypeDisplayPlace.setEnabled(false);
					comboStereotypeDisplayPlace.setText(stereotypePlacePresentation);
				}
			}
			comboStereotypeDisplayPlace.addSelectionListener(comboStereotypeDisplayListener);
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
	 * Refresh Stereotype Alignement combo.
	 */
	private void refreshStereotypeAlignment() {
		if (!comboStereotypeAlignement.isDisposed()) {

			comboStereotypeAlignement.removeSelectionListener(comboStereotypeAlignementListener);

			if (diagramElement != null) {
				if (((View) (diagramElement)).getElement() != null && ((Element) ((View) (diagramElement)).getElement()).getAppliedStereotypes().size() != 0) {
					comboStereotypeAlignement.setEnabled(true);

					final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

					if (stereotypePresentation != null) {

						org.eclipse.uml2.uml.Element elt = (Element) ((View) (diagramElement)).getElement();
						// get the first displayed stereotype
						Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, elt);

						boolean hasIcons = ElementUtil.hasIcons(elt, stereotype);
						boolean hasShapes = ElementUtil.hasShapes(elt, stereotype);

						if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
							comboStereotypeAlignement.setEnabled(false);
						} else if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
							comboStereotypeAlignement.setEnabled(true);
						} else if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShapes) {
							comboStereotypeAlignement.setEnabled(false);
						} else {
							comboStereotypeAlignement.setEnabled(true);
						}

						if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION)) {
							comboStereotypeAlignement.setText(HORIZONTAL);
						} else if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION)) {
							comboStereotypeAlignement.setText(VERTICAL);
						} else {
							comboStereotypeAlignement.setText(HORIZONTAL);
						}

					} else {
						comboStereotypeAlignement.setText(HORIZONTAL);
					}

				} else {
					comboStereotypeAlignement.setText("");
					comboStereotypeAlignement.setEnabled(false);
				}
			}
			comboStereotypeAlignement.addSelectionListener(comboStereotypeAlignementListener);
		}
	}

	/**
	 * Refresh Stereotype appearance combo.
	 */
	private void refreshStereotypeAppearance() {
		if (!comboStereotypeAppearance.isDisposed()) {
			comboStereotypeAppearance.removeSelectionListener(comboStereotypeAppearanceListener);

			if (diagramElement != null) {
				if (((View) (diagramElement)).getElement() != null && ((Element) ((View) (diagramElement)).getElement()).getAppliedStereotypes().size() != 0) {
					comboStereotypeAppearance.setEnabled(true);

					final String stereotypePresentation = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

					if (stereotypePresentation != null) {

						org.eclipse.uml2.uml.Element elt = (Element) ((View) (diagramElement)).getElement();
						// get the first displayed stereotype
						Stereotype stereotype = AppliedStereotypeHelper.getFirstDisplayedStereotype(diagramElement, elt);

						boolean hasIcons = ElementUtil.hasIcons(elt, stereotype);
						boolean hasShapes = ElementUtil.hasShapes(elt, stereotype);
						if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
							comboStereotypeAppearance.setText(ICON);
						} else if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION) && hasIcons) {
							comboStereotypeAppearance.setText(TEXT_AND_ICON);
						} else if (stereotypePresentation.equals(UMLVisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION) && hasShapes) {
							comboStereotypeAppearance.setText(SHAPE);
						} else {
							comboStereotypeAppearance.setText(TEXT);
						}

					} else {
						comboStereotypeAppearance.setText(TEXT);
					}

				} else {
					comboStereotypeAppearance.setText("");
					comboStereotypeAppearance.setEnabled(false);
				}
			}

			comboStereotypeAppearance.addSelectionListener(comboStereotypeAppearanceListener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if (comboStereotypeAppearance != null && !comboStereotypeAppearance.isDisposed()) {
			comboStereotypeAppearance.removeSelectionListener(comboStereotypeAppearanceListener);
		}
		if (comboStereotypeAlignement != null && !comboStereotypeAlignement.isDisposed()) {
			comboStereotypeAlignement.removeSelectionListener(comboStereotypeAlignementListener);
		}
		if (comboStereotypeDisplayPlace != null && !comboStereotypeDisplayPlace.isDisposed()) {
			comboStereotypeDisplayPlace.removeSelectionListener(comboStereotypeDisplayListener);
		}
		if (diagramElement != null) {
			diagramElement.eAdapters().remove(this);
		}
		super.dispose();
	}
}
