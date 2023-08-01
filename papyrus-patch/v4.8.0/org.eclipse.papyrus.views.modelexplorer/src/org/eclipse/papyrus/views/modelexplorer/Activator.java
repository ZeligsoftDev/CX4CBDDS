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
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.views.modelexplorer.handler.CollapseAllHandler;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.modelexplorer"; //$NON-NLS-1$

	/** The plug-in shared instance */
	private static Activator plugin;

	/** The log service */
	public static LogHelper log;

	/** Default constructor */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		System.out.println("[DEBUG][EPP] Model Explorer patch for Issue #466");
		plugin = this;
		log = new LogHelper(plugin);
		EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry();

		// FIXME Workaround for Bug 467000 (Eclipse Platform), Bug 463564 (ModelExplorer)
		String workaround = "eclipse.workaround.bug467000"; //$NON-NLS-1$
		if (System.getProperty(workaround) == null) { // Only change the value if it is not explicitly set already (Don't override user-defined value)
			System.setProperty(workaround, Boolean.toString(true));
		}

		//Replace collapseHandler in handler service
		IHandlerService handlerService = PlatformUI.getWorkbench().getService(IHandlerService.class);
		handlerService.activateHandler(org.eclipse.ui.handlers.CollapseAllHandler.COMMAND_ID, new CollapseAllHandler());
	}

	/**
	 * get the image descriptor from a string path
	 *
	 * @param pathString
	 *            path of the image
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String pathString) {

		IPath path = new Path(pathString);
		URL uri = FileLocator.find(Activator.plugin.getBundle(), path, null);
		if (uri == null) {
			return null;
		}
		return ImageDescriptor.createFromURL(uri);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 *
	 * @return the customization manager in charge to adapt element in modisco
	 */
	public ICustomizationManager getCustomizationManager() {
		return ProviderHelper.getCustomizationManager();
	}

	/**
	 * @return the qualified name of the given metaclass
	 */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
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

}
