/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclinecore;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.oclinecore.utilities.OCLinEcoreASResourceFactory;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class OCLinEcoreStandaloneSetup extends OCLinEcoreStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new OCLinEcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		OCLinEcoreASResourceFactory.getInstance();
//		OCLinEcoreAS2CS.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(OCLinEcoreCSPackage.eNS_URI, OCLinEcoreCSPackage.eINSTANCE);
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	@Override
	public Injector createInjector() {
		init();
		injector = super.createInjector();
		return injector;
	}
}

