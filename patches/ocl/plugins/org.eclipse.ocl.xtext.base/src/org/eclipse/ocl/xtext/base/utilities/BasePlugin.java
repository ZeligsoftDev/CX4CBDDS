/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.ocl.xtext.base.BaseStandaloneSetup;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Pivot model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class BasePlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final BasePlugin INSTANCE = new BasePlugin();

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
	public BasePlugin() {
		super(new ResourceLocator[] {});
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *
	 */
	public static void error(int code, String message) {
		error(code, message, null);
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *
	 */
	public static void error(int code, String message, Throwable throwable) {
		log(Diagnostic.ERROR, code, message, throwable);
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	public static String getPluginId() {
		if (getPlugin() != null) {
			return getPlugin().getBundle().getSymbolicName();
		}
		else {
			String packageName = BasePlugin.class.getPackage().getName();
			return packageName.substring(0, packageName.lastIndexOf('.'));
		}
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	public static void log(int severity, int code, String message, Throwable throwable) {
		//
		// Status ctor requires a non-null message
		String msg = message == null
			? "" //$NON-NLS-1$
			: message;

		try {
			if (getPlugin() != null) {
				// Eclipse environment
				getPlugin().log(
					new Status(severity, getPluginId(), code, msg, throwable));
			} else {
				// not in the Eclipse environment
//				if (shouldTrace(OCLDebugOptions.DEBUG)) {
					StringBuilder s = new StringBuilder();
					switch (code) {
						case Diagnostic.WARNING :
							s.append("WARNING "); //$NON-NLS-1$
							break;
						case Diagnostic.ERROR :
						case Diagnostic.CANCEL :
							s.append("ERROR "); //$NON-NLS-1$
							break;
						default :
							// don't output INFO or OK messages
							return;
					}

					s.append(code);
					s.append(": "); //$NON-NLS-1$
					s.append(message);
					System.err.println(s.toString());
					if (throwable != null) {
						throwable.printStackTrace(System.err);
					}
				}
//			}
		} catch (IllegalArgumentException iae) {
//			catching(OCLPlugin.class, "log", iae);//$NON-NLS-1$
		}
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		@Override
		public void start(BundleContext context) throws Exception {
			BaseStandaloneSetup.doSetup();
			super.start(context);
		}
	}

}
