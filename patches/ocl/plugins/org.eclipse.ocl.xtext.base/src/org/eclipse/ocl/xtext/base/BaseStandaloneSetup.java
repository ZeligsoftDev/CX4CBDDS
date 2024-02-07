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

package org.eclipse.ocl.xtext.base;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.xtext.base.scoping.BaseScoping;
import org.eclipse.ocl.xtext.base.utilities.NamedElementCSLabelGenerator;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.util.BaseCSValidator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Base models without equinox extension registry
 */
public class BaseStandaloneSetup //implements ISetup
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new BaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		PivotStandaloneSetup.doSetup();
		BaseScoping.init();
		EPackage.Registry.INSTANCE.put(BaseCSPackage.eNS_URI, BaseCSPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(BaseCSPackage.eINSTANCE, BaseCSValidator.INSTANCE);
		NamedElementCSLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	public Injector createInjector() {
		if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("xmi");
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(Resource.Factory.Registry.DEFAULT_EXTENSION))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		injector = Guice.createInjector(/*new BaseRuntimeModule()*/);
		return injector;
	}

	public Injector createInjectorAndDoEMFRegistration() {
		init();
		// register default ePackages
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		if (!EPackage.Registry.INSTANCE.containsKey(BaseCSPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(BaseCSPackage.eNS_URI, BaseCSPackage.eINSTANCE);

		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	public void register(Injector injector) {
//		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
//		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", resourceFactory);
//		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", serviceProvider);
	}
}

