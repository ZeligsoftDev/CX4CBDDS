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

package org.eclipse.ocl.xtext.oclstdlib;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ocl.xtext.oclstdlib.utilities.OCLstdlibASResourceFactory;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSValidator;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class OCLstdlibStandaloneSetup extends OCLstdlibStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new OCLstdlibStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		OCLstdlibCSPackage.eINSTANCE.getName();
		OCLstdlibASResourceFactory.getInstance();
//		OCLstdlibCS2AS.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(OCLstdlibCSPackage.eNS_URI, OCLstdlibCSPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(OCLstdlibCSPackage.eINSTANCE, OCLstdlibCSValidator.INSTANCE);
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

