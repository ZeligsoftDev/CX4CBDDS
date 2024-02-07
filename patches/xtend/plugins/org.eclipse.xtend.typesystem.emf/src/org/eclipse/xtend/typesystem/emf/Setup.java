/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.typesystem.emf;

import java.lang.reflect.Field;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;

/**
 * Initializes EMF support. Allows to register additional Packages.
 */
public class Setup {
	/**
	 * Default Constructor. Registers the Ecore Package.
	 *
	 */
	public Setup() {
		addEPackageClass(EcorePackage.eINSTANCE.getClass().getName());
	}

	public void addEPackageDescriptor(final String descr) {
		EcoreUtil2.getEPackageByDescriptorClassName(descr);
	}

	public void addEPackageFile(final String descr) {
		EcoreUtil2.getEPackage(descr);
	}

	public void addEPackageClass(final String clazz) {
		EcoreUtil2.getEPackageByClassName(clazz);
	}

	public void addUriMap(final Mapping uriMap) {
		final URI baseUri = URI.createURI(uriMap.getFrom());
		final URI mappedUri = EcoreUtil2.getURI(uriMap.getTo());
		if (mappedUri == null)
			throw new ConfigurationException("cannot make URI out of " + uriMap.getTo());
		else {
			URIConverter.URI_MAP.put(baseUri, mappedUri);
		}
	}

	/**
	 * Adds an extension
	 * @param m <tt>from</tt>: extension name, <tt>to</tt> factory classname
	 * @throws ConfigurationException 
	 * <ul>
	 * <li> The factory class for the extension cannot be found
	 * <li> The inner factory class for the extension cannot be found
	 * </ul>
	 */
	public void addExtensionMap(final Mapping m) throws ConfigurationException {
		try {
			// locate the factory class of the extension
			Class<?> factoryClass = ResourceLoaderFactory.createResourceLoader().loadClass(m.getTo());
			if (factoryClass == null)
				throw new ConfigurationException("cannot find class " + m.getTo() + " for extension " + m.getFrom());
			Object factoryInstance = null;
			if (factoryClass.isInterface()) {
				final Class<?>[] innerClasses = factoryClass.getDeclaredClasses();
				factoryClass = null;
				for (int j = 0; j < innerClasses.length; j++) {
					if (Resource.Factory.class.isAssignableFrom(innerClasses[j])) {
						factoryClass = innerClasses[j];
					}
				}
				if (factoryClass == null)
					throw new ConfigurationException("cannot find inner factory class " + m.getTo() + " for extension " + m.getFrom());
				final Field instanceField = factoryClass.getField("INSTANCE");
				factoryInstance = instanceField.get(null);
			} else {
				factoryInstance = factoryClass.newInstance();
			}
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(m.getFrom(), factoryInstance);
		} catch (final Exception e) {
			throw new ConfigurationException(e);
		}
	}

}
