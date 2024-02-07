/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.plugin.ASResourceFactoryRegistryReader;
import org.eclipse.ocl.pivot.internal.plugin.StandardLibraryRegistryReader;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Pivot model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class PivotPlugin extends EMFPlugin
{
	// The plug-in ID
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.pivot";

	public static final @NonNull String AS_RESOURCE_FACTORY_PPID = "as_resource_factory";
	public static final @NonNull String LABEL_GENERATOR_PPID = "label_generator";
	public static final @NonNull String STANDARD_LIBRARY_PPID = "standard_library";
	public static final @NonNull String COMPLETE_OCL_REGISTRY_PID = "complete_ocl_registry";
	public static final @NonNull String COMPLETE_OCL_REGISTRY_QPID = PLUGIN_ID + "." + COMPLETE_OCL_REGISTRY_PID;
	/**
	 * @since 1.15
	 */
	public static final @NonNull String THREAD_LOCAL_PID = "thread_local";
	/**
	 * @since 1.15
	 */
	public static final @NonNull String THREAD_LOCAL_QPID = PLUGIN_ID + "." + THREAD_LOCAL_PID;

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotPlugin INSTANCE = new PivotPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PivotPlugin()
	{
		super(new ResourceLocator [] {});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	public static void logError(String string, Throwable e) {
		if (plugin != null)
			plugin.logError(string, e);
		else
			System.err.println(string);
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation()
		{
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		public void logError(String string, Throwable e) {
			logException(newError(string, e));
		}

		public void logException(Throwable e) {
			if (e instanceof InvocationTargetException) {
				e = ((InvocationTargetException) e).getTargetException();
			}
			IStatus status = null;
			if (e instanceof CoreException) {
				status = ((CoreException) e).getStatus();
			} else {
				String message = e.getMessage();
				if (message == null)
					message = e.toString();
				status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
			}
			log(status);
		}

	    /**
	     * Return a CoreException with Error severity containing a text description and optionally
	     * wrapping a further exception.
	     * @param text description of exception
	     * @param exception optional wrapped exception
	     */
	    public CoreException newError(String text, Throwable exception) {
	        return new CoreException(new Status(IStatus.ERROR,
					PLUGIN_ID, IStatus.ERROR, "ERROR -- " + text, exception));
	    }

		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			new ASResourceFactoryRegistryReader().readRegistry();
			new StandardLibraryRegistryReader().readRegistry();
			PivotStandaloneSetup.doSetup();
		}
	}
}
