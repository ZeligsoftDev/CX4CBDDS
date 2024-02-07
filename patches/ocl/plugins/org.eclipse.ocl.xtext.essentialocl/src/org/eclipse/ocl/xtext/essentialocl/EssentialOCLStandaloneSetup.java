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

package org.eclipse.ocl.xtext.essentialocl;

import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.xtext.base.BaseStandaloneSetup;
import org.eclipse.ocl.xtext.essentialocl.scoping.EssentialOCLScoping;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLASResourceFactory;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class EssentialOCLStandaloneSetup extends EssentialOCLStandaloneSetupGenerated
{
	private static Injector injector = null;

	public static void doSetup() {
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;			// Enforces Bug 382058 fix
		if (injector == null) {
			new EssentialOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		BaseStandaloneSetup.doSetup();
		EssentialOCLScoping.init();
		EssentialOCLASResourceFactory.getInstance();
//		EssentialOCLCS2AS.FACTORY.getClass();
//		EssentialOCLAS2CS.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(EssentialOCLCSPackage.eNS_URI, EssentialOCLCSPackage.eINSTANCE);
//		EValidator.Registry.INSTANCE.put(EssentialOCLCSPackage.eINSTANCE, EssentialOCLCSValidator.INSTANCE);
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	@Override
	public Injector createInjector() {
		Map<String, Object> globalExtensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (globalExtensionToFactoryMap.containsKey("xmi"))
			globalExtensionToFactoryMap.remove("xmi");
		if (!globalExtensionToFactoryMap.containsKey(Resource.Factory.Registry.DEFAULT_EXTENSION))
			globalExtensionToFactoryMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		injector = super.createInjector();
		return injector;
	}

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		init();
		return super.createInjectorAndDoEMFRegistration();
	}
}

