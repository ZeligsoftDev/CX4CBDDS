/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that provides
 * adduitional UML-specific functionality.
 * 
 * @see OCL
 */
@Deprecated // Adds no value to OCL
public class UMLOCL extends OCL
{
	/**
	 * Initialize registries to support OCL and Ecore usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied. 
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify a specific package registry.
	 *<p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.
	 *
	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 */
	public static String initialize(@Nullable ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		return null;
	}
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     */
	public static @NonNull UMLOCL newInstance() {	
		return newInstance((ProjectManager)null);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore package registry.
     * This automatically creates an new EnvironmentFactory and MetamodelManager.
     */
	public static @NonNull UMLOCL newInstance(@Nullable ProjectManager projectManager) {	
		if (projectManager == null) {
			projectManager = BasicProjectManager.createDefaultProjectManager();
		}
		return newInstance(ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager, null));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     */
	public static @NonNull UMLOCL newInstance(@NonNull EnvironmentFactory environmentFactory) {	
		return new UMLOCL((EnvironmentFactoryInternal) environmentFactory);
	}

	protected UMLOCL(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}
}
