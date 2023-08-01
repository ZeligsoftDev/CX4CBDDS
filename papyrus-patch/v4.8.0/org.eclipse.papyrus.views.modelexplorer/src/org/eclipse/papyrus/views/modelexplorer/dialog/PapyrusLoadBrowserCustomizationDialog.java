/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.dialog;

import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Papyrus implementation of the EMF Facet LoadBrowserCustomization
 *
 * Adds a "restore default configuration" button
 *
 * @author Camille Letavernier
 *
 */
// We still rely on EMF Facet 0.1 API, which is restricted and deprecated
@SuppressWarnings({ "deprecation", "restriction" })
public class PapyrusLoadBrowserCustomizationDialog extends MultipleValueSelectorDialog {

	public PapyrusLoadBrowserCustomizationDialog(Shell parentShell, IElementSelector selector) {
		super(parentShell, selector);
		
	}

	// /** protected final Collection<EPackage> ePackages;
	//
	// /**
	// * Creates a new dialog to select the EMF Facet uiCustom (Browser customizations) to apply
	// *
	// * @param parentShell
	// * The parent shell for this dialog
	// * @param initialSelection
	// * The list of browser customization currently applied
	// * @param ePackages
	// * The list of EPackages used to filter the Browser Customizations to display. Only compatible browser customizations will be displayed to
	// * the user.
	// * This filter is only graphical (i.e. customizations which do not match these EPackages might still be returned by this dialog)
	// * @param manager
	// * The Customization
	// */
	// public PapyrusLoadBrowserCustomizationDialog(Shell parentShell, List<MetamodelView> initialSelection, Collection<EPackage> ePackages) {
	// this(parentShell, getElementSelector(ePackages), initialSelection, ePackages);
	// }
	//
	// protected PapyrusLoadBrowserCustomizationDialog(Shell parentShell, IElementSelector selector, List<MetamodelView> initialSelection, Collection<EPackage> ePackages) {
	// super(parentShell, selector);
	//
	// this.ePackages = ePackages;
	//
	// setInitialElementSelections(initialSelection);
	//
	// setOrdered(true);
	// setLabelProvider(createLabelProvider());
	// setTitle("Select browser customizations");
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * Adds the EMF Facet UICustom icon to the dialog
	// */
	// @Override
	// protected void configureShell(Shell shell) {
	// super.configureShell(shell);
	// shell.setImage(ImageProvider.getInstance().getUiCustomIcon());
	// }
	//
	// /**
	// * The IElementSelector used for the left panel of this dialog. This is a simple ReferenceSelector for available UICustoms
	// *
	// * @param ePackages
	// * The EPackages used to filter the compatible UICustom to display to the user
	// * @return
	// */
	// protected static IElementSelector getElementSelector(final Collection<EPackage> ePackages) {
	// ReferenceSelector selector = new ReferenceSelector(true) {
	//
	// @Override
	// public void createControls(Composite parent) {
	// super.createControls(parent);
	// installCompatibleCustomizationViewerFilter(treeViewer, ePackages);
	// }
	// };
	//
	// List<MetamodelView> registryAllCustomizations = CustomizationsCatalog.getInstance().getRegistryCustomizations();
	//
	// IStaticContentProvider semanticProvider = new StaticContentProvider(registryAllCustomizations.toArray());
	// IStaticContentProvider filteredProvider = new FilteredContentProvider(semanticProvider);
	//
	// selector.setContentProvider(filteredProvider);
	// selector.setLabelProvider(createLabelProvider());
	//
	// return selector;
	// }
	//
	// /**
	// * The ID of the "Restore defaults" button
	// */
	// public static final int RESTORE_ID = IDialogConstants.CLIENT_ID + 1;
	//
	// /**
	// * {@inheritDoc}
	// *
	// * Adds a "restore defaults" button
	// */
	// @Override
	// protected void createButtonsForButtonBar(Composite parent) {
	// createButton(parent, RESTORE_ID, "Restore defaults", false);
	// super.createButtonsForButtonBar(parent);
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * Adds support for the Restore Default button/action
	// */
	// @Override
	// protected void buttonPressed(int buttonId) {
	// if(buttonId == RESTORE_ID) {
	// restorePressed();
	// } else {
	// super.buttonPressed(buttonId);
	// }
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * Installs a filter for the compatible UICustom models to display to the user
	// */
	// @Override
	// public void create() {
	// super.create();
	// installCompatibleCustomizationViewerFilter(selectedElementsViewer, ePackages);
	// getShell().pack();
	// }
	//
	// /**
	// * Install the compatible UICustom filter to the given viewer
	// *
	// * @param viewer
	// * The viewer to filter
	// * @param ePackages
	// * The UICustom models will be displayed if they are compatible with one of these EPackages
	// */
	// protected static void installCompatibleCustomizationViewerFilter(StructuredViewer viewer, Collection<EPackage> ePackages) {
	// List<ViewerFilter> currentFilters = ListHelper.asList(viewer.getFilters());
	// currentFilters.add(createCompatibleCustomizationViewerFilter(ePackages));
	// viewer.setFilters(currentFilters.toArray(new ViewerFilter[currentFilters.size()]));
	// }
	//
	// /**
	// * Creates a filter for the compatible UICustom
	// *
	// * @param ePackages
	// * The UICustom models will be displayed if they are compatible with one of these EPackages
	// */
	// protected static ViewerFilter createCompatibleCustomizationViewerFilter(Collection<EPackage> ePackages) {
	// final Set<String> ePackageURIs = new HashSet<String>();
	//
	// for(EPackage ePackage : ePackages) {
	// ePackageURIs.add(ePackage.getNsURI());
	// final Set<EPackage> referencedPackages = ModelUtils.computeReferencedPackages(ePackage);
	// for(EPackage referencedEPackage : referencedPackages) {
	// ePackageURIs.add(referencedEPackage.getNsURI());
	// }
	// }
	//
	// return new ViewerFilter() {
	//
	// @Override
	// public boolean select(Viewer viewer, Object parentElement, Object element) {
	// if(element instanceof MetamodelView) {
	// MetamodelView customization = (MetamodelView)element;
	//
	// String nsURI = customization.getMetamodelURI();
	//
	// if(ePackageURIs.contains(nsURI)) {
	// return true;
	// }
	//
	// EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
	// while(ePackage != null) {
	// if(ePackageURIs.contains(ePackage.getNsURI())) {
	// return true;
	// }
	//
	// // allow customizations on Facets
	// if(ePackage instanceof FacetSet) {
	// FacetSet facetSet = (FacetSet)ePackage;
	// ePackage = facetSet.getExtendedPackage();
	// } else {
	// // allow customizations on sub-packages
	// ePackage = ePackage.getESuperPackage();
	// }
	// }
	//
	// return false;
	// }
	//
	// return true;
	// }
	//
	// };
	// }
	//
	// /**
	// * The "restore defaults" action
	// */
	// protected void restorePressed() {
	// List<MetamodelView> defaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
	// Object[] filteredCustomizations = defaultCustomizations.toArray();
	//
	// removeAllAction();
	// addElements(filteredCustomizations);
	// selector.setSelectedElements(allElements.toArray());
	// }
	//
	// /**
	// * Returns the list of selected customizations (including the ones hidden by the compatible EPackage filter)
	// *
	// * @return
	// */
	// public List<MetamodelView> getSelectedCustomizations() {
	// Object[] result = super.getResult();
	// List<MetamodelView> customizations = new ArrayList<MetamodelView>();
	// for(Object element : result) {
	// if(element instanceof MetamodelView) {
	// customizations.add((MetamodelView)element);
	// }
	// }
	//
	// return customizations;
	// }
	//
	// //Copied from {@link org.eclipse.papyrus.emf.facet.infra.browser.custom.ui.dialogs.LoadCustomizationsDialog#createLabelProvider()}
	// /**
	// * Creates a LabelProvider for EMF Facet MetamodelView elements
	// *
	// * @return the label provider for the Dialog
	// */
	// protected static ILabelProvider createLabelProvider() {
	// return new LabelProvider() {
	//
	// @Override
	// public String getText(final Object element) {
	// final MetamodelView metamodelView = (MetamodelView)element;
	// return metamodelView.getName();
	// }
	//
	// @Override
	// public Image getImage(final Object element) {
	// return ImageProvider.getInstance().getUiCustomIcon();
	// }
	// };
	// }

}
