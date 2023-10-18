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
package org.eclipse.ocl.xtext.completeocl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.xtext.completeocl.scoping.CompleteOCLScoping;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLASResourceFactory;
import org.eclipse.ocl.xtext.completeocl.utilities.PathNameDeclCSLabelGenerator;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class CompleteOCLStandaloneSetup extends CompleteOCLStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new CompleteOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		CompleteOCLScoping.init();
		CompleteOCLASResourceFactory.getInstance();
		EPackage.Registry.INSTANCE.put(CompleteOCLCSPackage.eNS_URI, CompleteOCLCSPackage.eINSTANCE);
		PathNameDeclCSLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
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

