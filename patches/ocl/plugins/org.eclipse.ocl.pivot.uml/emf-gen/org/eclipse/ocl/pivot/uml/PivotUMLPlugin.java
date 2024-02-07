/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.resource.UMLASResourceFactory;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the OCLforUML model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class PivotUMLPlugin
		extends EMFPlugin {

	public static final String PLUGIN_ID = "org.eclipse.ocl.pivot.uml"; //$NON-NLS-1$

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotUMLPlugin INSTANCE = new PivotUMLPlugin();

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
	public PivotUMLPlugin() {
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
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
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

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation
			extends EclipsePlugin {

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
		public void start(BundleContext context)
				throws Exception {
			OCLforUMLPackage.eINSTANCE.getName(); // Bug 469609 An NPE occurs in here when installed on Juno (UML2 4.0.0)	
			UMLASResourceFactory.getInstance(); //  and so we must not register the UML2ASResource factory
			UML2AS.initialize();
			super.start(context);
		}

		@Override
		public void stop(BundleContext context)
				throws Exception {
			super.stop(context);
		}
	}

}
