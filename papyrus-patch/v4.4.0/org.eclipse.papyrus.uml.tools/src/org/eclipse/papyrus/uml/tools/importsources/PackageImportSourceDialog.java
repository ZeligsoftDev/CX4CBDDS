/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 409555
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - extends by MultipleValueSelectionDialog
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectionDialog;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Package;

/**
 * Dialog for Package import source.
 */
public class PackageImportSourceDialog extends MultipleValueSelectionDialog {

	private IPackageImportSource source;

	private ResourceSet resourceSet;

	private List<Package> selectedPackages;


	protected Map<String, String> extensionFilters;

	/**
	 * Initializes me.
	 *
	 * @param parentShell
	 *            the shell to use as parent of the dialog
	 * @param title
	 *            the dialog title
	 */
	public PackageImportSourceDialog(Shell parentShell, String title) {
		super(parentShell, getPackageImportSourceSelector(), title, true, true);
	}

	/**
	 * Gets the package import source selector.
	 *
	 * @return the package import source selector
	 */
	private static IElementSelector getPackageImportSourceSelector() {
		return new PackageImportReferenceSelector();
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, IStructuredSelection selection) {
		return open(parentShell, title, selection.toList());
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, Collection<?> selection) {
		return open(parentShell, title, selection, null);
	}

	/**
	 * Opens a new {@code PackageImportSourceDialog} and returns the selected
	 * models, if any.
	 *
	 * @return the selected models from which to import, or {@code null} if the
	 *         user cancelled
	 */
	public static Collection<Package> open(Shell parentShell, String title, Collection<?> selection, Map<String, String> extensionFilters) {

		PackageImportSourceDialog dlg = new PackageImportSourceDialog(parentShell, title);
		dlg.setExtensionFilters(extensionFilters);
		dlg.initialize(selection);
		dlg.open();

		return dlg.getSelectedPackages();
	}

	protected void setExtensionFilters(Map<String, String> extensionFilters) {
		this.extensionFilters = extensionFilters;
	}

	public void initialize(Collection<?> selection) {
		IEvaluationService evaluationService = PlatformUI.getWorkbench().getService(IEvaluationService.class);
		source = new PackageImportSourceRegistry(evaluationService).createImportSourceFor(selection);
		source.initialize(selection);

		PackageImportReferenceSelector selector = (PackageImportReferenceSelector) getPackageImportSourceSelector();
		setSelector(selector);

		ILabelProvider labelProvider = source.getModelHierarchyLabelProvider();
		((PackageImportReferenceSelector) selector).setLabelProvider(labelProvider);
		((PackageImportReferenceSelector) selector).setContentProvider(source.getModelHierarchyContentProvider(extensionFilters));
		((PackageImportReferenceSelector) selector).setImportSource(source);

		setLabelProvider(labelProvider);

		resourceSet = Util.createTemporaryResourceSet();
	}

	/**
	 * Queries the packages selected by the user, if not cancelled.
	 *
	 * @return the selected packages, or {@code null} if the user cancelled
	 */
	public Collection<Package> getSelectedPackages() {
		return selectedPackages;
	}

	@Override
	public boolean close() {
		boolean result = super.close();

		if (result) {
			computePackages();

			dispose();
		}

		return result;
	}

	public void dispose() {
		if (source != null) {
			source.dispose();
			source = null;
		}

		if (resourceSet != null) {
			EMFHelper.unload(resourceSet);
			resourceSet = null;
		}
	}

	private void computePackages() {
		Object[] dlgResult = getResult();
		if (dlgResult != null) {
			selectedPackages = new java.util.ArrayList<Package>(dlgResult.length);

			for (Object selectedElement : dlgResult) {
				try {
					selectedPackages.addAll(source.getPackages(resourceSet, selectedElement));
				} catch (CoreException e) {
					StatusAdapter adapter = new StatusAdapter(e.getStatus());
					adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Invalid Model(s) Selected");
					adapter.setProperty(IStatusAdapterConstants.EXPLANATION_PROPERTY, "One or more of the models selected could not provide packages to import.");
					StatusManager.getManager().handle(adapter, StatusManager.SHOW);
				}
			}
		}

	}



}
