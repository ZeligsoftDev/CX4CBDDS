/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.internal.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.scoping.PivotScoping;
import org.eclipse.ocl.pivot.internal.validation.PivotEAnnotationValidator;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.LabelGeneratorRegistry;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.PivotValidator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Pivot models without equinox extension registry
 */
public class PivotStandaloneSetup //implements ISetup
{
	private static Injector injector = null;

	public static void doSetup() {
		if (injector == null) {
			new PivotStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		OCLDelegateDomain.lazyInitializeGlobals(PivotConstants.OCL_DELEGATE_URI_PIVOT, false);
		OCLASResourceFactory theOCLASResourceFactory = OCLASResourceFactory.getInstance();
		OCLstdlib.lazyInstall();
		OCLmetamodel.lazyInstall();
		EcoreASResourceFactory.getInstance();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ASResource.FILE_EXTENSION, theOCLASResourceFactory);
			PivotEAnnotationValidator.initializePivotEAnnotationValidators();
		}
		EcorePackage.eINSTANCE.getClass();
		PivotScoping.init();
		ToStringVisitor.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(PivotPackage.eINSTANCE, PivotValidator.INSTANCE);
		LabelGeneratorRegistry.initialize(ILabelGenerator.Registry.INSTANCE);
	}

	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	public Injector createInjector() {
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (extensionToFactoryMap.containsKey("xmi"))
			extensionToFactoryMap.remove("xmi");
		String defaultExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		if (!extensionToFactoryMap.containsKey(defaultExtension))
			extensionToFactoryMap.put(defaultExtension, new XMIResourceFactoryImpl());
		injector = Guice.createInjector(/*new PivotRuntimeModule()*/);
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
		if (!EPackage.Registry.INSTANCE.containsKey(PivotPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);

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

