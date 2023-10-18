/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.plugin;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.export.ValidityExporterListener;
import org.eclipse.ocl.examples.emf.validation.validity.export.ValidityExporterRegistry;
import org.osgi.framework.BundleContext;

public class ValidityPlugin extends EMFPlugin
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.examples.emf.validation.validity";
	public static final @NonNull String CONSTRAINT_LOCATOR_PPID = "constraint_locator";
	public static final @NonNull String VALIDITY_EXPORTER_PPID = "validity_exporter";

	/**
	 * The singleton instance of the plugin.
	 */
	public static final @NonNull ValidityPlugin INSTANCE = new ValidityPlugin();

	/**
	 * Creates the singleton instance.
	 */
	private ValidityPlugin() {
		super(new ResourceLocator[] {});
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the Eclipse plugin singleton.
	 * 
	 * @return the plugin singleton.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The plugin singleton
	 */
	private static Implementation plugin;

	/**
	 * A plugin implementation that handles Ecore plugin registration.
	 * 
	 * @see #startup()
	 */
	static public class Implementation extends EclipsePlugin {
		/**
		 * The registry listener that will be used to listen to Ocl Exporter
		 * extension changes.
		 */
		private ValidityExporterListener registryListener = new ValidityExporterListener();
		
		/**
		 * Creates the singleton instance.
		 */
		public Implementation() {
			super();
			plugin = this;
		}

		/**
		 * Starts up this plugin by reading some extensions and populating the
		 * relevant registries.
		 * 
		 * @throws Exception
		 *             if there is a show stopping problem.
		 */
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			new ConstraintLocatorRegistryReader().readRegistry();
			
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			registry.addListener(registryListener, PLUGIN_ID + "." + VALIDITY_EXPORTER_PPID);
			registryListener.parseInitialContributions();
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			registry.removeListener(registryListener);
			ValidityExporterRegistry.INSTANCE.clearRegistry();
			
			super.stop(context);
			plugin = null;
		}
	}
}
