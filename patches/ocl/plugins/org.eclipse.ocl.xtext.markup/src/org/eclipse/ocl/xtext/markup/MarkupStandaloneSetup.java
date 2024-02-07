/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.markupcs.MarkupPackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class MarkupStandaloneSetup extends MarkupStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new MarkupStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static Injector getInjector() {
		if (injector == null) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				doSetup();
			}
			else {
				injector = Guice.createInjector(new MarkupRuntimeModule());
			}
		}
		return injector;
	}

	public static void init() {
		EPackage.Registry.INSTANCE.put(MarkupPackage.eNS_URI, MarkupPackage.eINSTANCE);
	}

	@Override
	public Injector createInjector() {
		init();
		injector = super.createInjector();
		return injector;
	}
}

