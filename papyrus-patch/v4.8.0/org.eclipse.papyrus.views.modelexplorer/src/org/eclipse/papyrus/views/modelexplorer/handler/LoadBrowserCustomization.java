/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  Benoit Maggi - Bug 509346
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialog;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.semantic.service.SemanticService;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This is a class that launches the button load Customization. this code comes
 * from the {@link LoadCustomizationsDialog}
 */
public class LoadBrowserCustomization extends AbstractHandler {

	/**
	 *
	 *
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.views.modelexplorer.NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		// the part is only a book, retrieving correct page
		if (part instanceof ModelExplorerPageBookView) {
			IViewPart page = ((ModelExplorerPageBookView) part).getActiveView();
			if (page instanceof CommonNavigator) {
				return (CommonNavigator) page;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().getCustomizationManager() != null) {
			ICustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
			final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet()).getRegisteredCustomizations();

			Shell shell = HandlerUtil.getActiveShell(event);
			IDialogCallbackWithPreCommit<List<Customization>, Boolean, Dialog> dialogCallBack = new IDialogCallbackWithPreCommit<List<Customization>, Boolean, Dialog>() {

				@Override
				public void committed(List<Customization> result, Boolean precommitResult) {
				}

				@Override
				public Dialog openPrecommitDialog(List<Customization> result, IDialogCallback<Boolean> precommitCallback) {
					return null;
				}
			};
			ILoadCustomizationsDialog dialog = ILoadCustomizationsDialogFactory.DEFAULT.createLoadCustomizationDialog(shell, registeredCustomizations, customizationManager.getManagedCustomizations(), dialogCallBack);

			if (Window.OK == dialog.open()) {
				if( customizationManager.getManagedCustomizations().size()>0) {
					customizationManager.getManagedCustomizations().clear();
				}
				customizationManager.getManagedCustomizations().addAll(dialog.getSelectedCustomizations());
				// Save the current state of the customizations
				org.eclipse.papyrus.infra.ui.internal.emf.Activator.getDefault().saveCustomizationManagerState();
			}

			// load customizations defined as default through the customization extension
			if (getCommonNavigator() != null) {
				getCommonNavigator().getCommonViewer().refresh();
			}
		}

		return null;
	}

	/** @return the qualified name of the given metaclass */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while (ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for (int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

	/**
	 * Get the metmodel URI
	 **/
	protected List<EPackage> getMetamodels(ServicesRegistry serviceRegistry) {
		List<EPackage> ePackages = new ArrayList<>();

		/*
		 * we look for the current editors, because their are represented in the model explorer
		 * using specific facet and uiCustom. (see bug 359692)
		 */
		IPageManager pageMngr = null;
		try {
			pageMngr = ServiceUtils.getInstance().getService(IPageManager.class, serviceRegistry);
			List<Object> pages = pageMngr.allPages();
			for (int i = 0; i < pages.size(); i++) {
				if (pages.get(i) instanceof EObject) {
					EPackage ePackage = ((EObject) pages.get(i)).eClass().getEPackage();
					if (!ePackages.contains(ePackage)) {
						ePackages.add(ePackage);
					}
				}
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		try {
			SemanticService semantic = serviceRegistry.getService(SemanticService.class);
			for (EObject rootElement : semantic.getSemanticRoots()) {
				EClass eClass = rootElement.eClass();
				if (eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if (!ePackages.contains(ePackage)) {
						ePackages.add(eClass.getEPackage());
					}
				}
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return ePackages;
	}

}
