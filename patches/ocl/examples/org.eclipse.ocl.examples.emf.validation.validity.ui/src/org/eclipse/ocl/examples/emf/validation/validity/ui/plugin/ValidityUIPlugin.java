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
package org.eclipse.ocl.examples.emf.validation.validity.ui.plugin;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.osgi.framework.BundleContext;

/**
 * The <b>Plugin</b> for the model Validation UI. EMF must run within an
 * Eclipse workbench, within a headless Eclipse workspace, or just stand-alone
 * as part of some other application. To support this, all resource access
 * should be directed to the resource locator, which can redirect the service as
 * appropriate to the runtime. During stand-alone invocation no plugin
 * initialization takes place. In this case, emf.edit.resources.jar must be on
 * the CLASSPATH.
 * 
 * @see #INSTANCE
 */
public final class ValidityUIPlugin extends EMFPlugin
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.emf.validation.validity.ui"; //$NON-NLS-1$
	/**
	 * The singleton instance of the plugin.
	 */
	public static final ValidityUIPlugin INSTANCE = new ValidityUIPlugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

//	public static final String QUERY_DELEGATE_TEXT_VIEWER_FACTORIES_PPID = "queryDelegateTextViewerFactories";

	/**
	 * Creates the singleton instance.
	 */
	private ValidityUIPlugin() {
		super(new ResourceLocator[] {});
	}

	/*
	 * Javadoc copied from base class.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		/**
		 * Starts up this plugin by reading some extensions and populating the
		 * relevant registries.
		 * <p>
		 * 
		 * @throws Exception
		 *             if there is a show stopping problem.
		 */
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			IDEValidityManager.stopValidation();
			super.stop(context);
		}
	}
}
