/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.xtend.typesystem.emf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;

/**
 * Provides useful functions for usage of EMF.
 *
 * @since 4.0
 */
@SuppressWarnings("unchecked")
public class EcoreUtil2 {

	private final static Logger log = LogManager.getLogger(EcoreUtil2.class);

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
	}

	public final static EPackage getEPackage(final String pathToEcoreFile) {
		EPackage topLevelPackage = null;
		final URI fileURI = getURI(pathToEcoreFile);
		if (fileURI == null)
			throw new RuntimeException("cannot resolve EPackage for " + pathToEcoreFile
					+ ". Probably cannot find the .ecore file.");
		try {
			final Resource res = new ResourceSetImpl().createResource(fileURI);
			if (res == null)
				throw new ConfigurationException("No ecore model file '" + pathToEcoreFile + "' found! ("
						+ fileURI.toString() + ")");
			res.load(new HashMap<Object,Object>());
			topLevelPackage = (EPackage) res.getContents().get(0);
			registerPackage(topLevelPackage, fileURI);
			registerSubPackages(topLevelPackage, fileURI);
			return topLevelPackage;
		}
		catch (final IOException e) {
			throw new ConfigurationException(e);
		}
		finally {
			logPackages();
		}
	}

	private static void registerSubPackages(EPackage ePackage, URI fileURI) {
		if (ePackage == null || fileURI == null)
			throw new IllegalArgumentException();

		for (TreeIterator<EObject> it = ePackage.eAllContents(); it.hasNext();) {
			EObject obj = it.next();
			if (obj instanceof EPackage) {
				EPackage p = (EPackage) obj;
				registerPackage(p, fileURI);
			}
		}

	}

	private static void registerPackage(EPackage ePackage, final URI fileURI) {
		if (ePackage != null && fileURI != null && ePackage.getNsURI() != null) {
			if (!EPackage.Registry.INSTANCE.containsKey(ePackage.getNsURI())) {
				EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
				URIConverter.URI_MAP.put(URI.createURI(ePackage.getNsURI()), fileURI);
			}
		}
	}

	private static void logPackages() {
		// if (log.isDebugEnabled()) {
		// Set s = EPackage.Registry.INSTANCE.keySet();
		// log.debug("registered EPackages:");
		// List l = new ArrayList(s);
		// for (int i = 0, x = l.size(); i < x; i++) {
		// Object o = l.get(i);
		// log.debug((i + 1) + ") " + o + " : " + ((EPackage)
		// EPackage.Registry.INSTANCE.get(o)).getName());
		// }
		// }
	}

	/**
	 * Finds all elements within a collection of a specific type.
	 *
	 * @param iter
	 *            An iterator over the source collection.
	 * @param type
	 *            The type which should be selected.
	 * @return A set with all elements of the specified type.
	 */
	public static Set<EObject> findAllByType(final Iterator<?> iter, final Class<?> type) {
		final Set<EObject> result = new HashSet<EObject>();
		while (iter.hasNext()) {
			final EObject curr = (EObject) iter.next();
			if (type.isInstance(curr)) {
				result.add(curr);
			}
		}
		return result;
	}

	/**
	 * Clones a list.
	 *
	 * @param list
	 *            The list that should be cloned.
	 * @return A copy of the original list
	 */
	@SuppressWarnings("rawtypes")
	public static List clone(final EList list) {
		if (list == null)
			return null;
		final List res = new ArrayList();
		res.addAll(list);
		return res;
	}

	/**
	 * Finds an EMF EPackage instance by its class name. The EPackage class must
	 * be loadable by the ResourceLoader
	 *
	 * @param ePackage
	 *            The class name of the EPackage interface
	 * @return The EPackage instance. Returns <code>null</code> if any exception
	 *         occurs after the class was successfully loaded.
	 * @throws ConfigurationException
	 *             If the class specified by <tt>ePackage</tt> cannot be loaded.
	 */
	public static EPackage getEPackageByClassName(final String ePackage) throws ConfigurationException {
		Class<?> clazz;
		try {
			// try to load the EPackage class with the ResourceLoader
			clazz = ResourceLoaderFactory.createResourceLoader().loadClass(ePackage);
			if (clazz == null)
				throw new ConfigurationException("Couldn't find class " + ePackage);
			// each EPackage class has an 'eINSTANCE' field which holds the
			// implementation instance
			final Field f = clazz.getField("eINSTANCE");
			// retrieve the EPackage instance from the eINSTANCE field
			final EPackage result = (EPackage) f.get(null);
			// register the EPackage instance in the EPackage Registry
			EPackage.Registry.INSTANCE.put(result.getNsURI(), result);
			return result;
		}
		catch (final SecurityException e) {
			log.error(e);
			return null;
		}
		catch (final NoSuchFieldException e) {
			log.error(e);
			return null;
		}
		catch (final IllegalArgumentException e) {
			log.error(e);
			return null;
		}
		catch (final IllegalAccessException e) {
			log.error(e);
			return null;
		}
		finally {
			logPackages();
		}
	}

	/**
	 * Finds an EPackage by the class name of the Package Descriptor.
	 *
	 * @param ePackageDescriptor
	 *            The Package Descriptor's classname
	 * @return The EPackage instance. Returns <code>null</code> on any exception
	 *         occuring while retrieval.
	 */
	public static EPackage getEPackageByDescriptorClassName(final String ePackageDescriptor) {
		Class<?> clazz;
		try {
			clazz = ResourceLoaderFactory.createResourceLoader().loadClass(ePackageDescriptor);
			final EPackage.Descriptor descriptor = (EPackage.Descriptor) clazz.newInstance();
			final Field f = clazz.getField("eNS_URI");
			final String uri = (String) f.get(null);
			EPackage.Registry.INSTANCE.put(uri, descriptor);
			return EPackage.Registry.INSTANCE.getEPackage(uri);
		}
		catch (final Exception e) {
			log.error("Couldn't load ePackage '" + ePackageDescriptor, e);
			return null;
		}
		finally {
			logPackages();
		}
	}

	/**
	 * Creates an URI from a file name.
	 *
	 * @param file
	 *            The file's path
	 * @return The URI representing the file
	 */
	public static URI getURI(final String file) {
		// try to load the resource specified by 'file'
		final URL url = ResourceLoaderFactory.createResourceLoader().getResource(file);
		URI uri = null;

		try {
			// if the ResourceLoader cannot locate this file create a URI from
			// the file
			if (url == null) {
				uri = URI.createURI(file);
			}
			else {
				// the ResourceLoader has successfully located the file. Return
				// the external form of the path

				uri = URI.createURI(url.toExternalForm());

				// this is the old implementation of this block, but it caused errors:
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=256833
				// I'm leaving this here for a while to make sure unforeseen side effects can be understood
				// if (url.getProtocol().equals("file")) {
				// uri = URI.createFileURI(url.getFile());
				// }
				// else {
				// uri = URI.createURI(url.toString());
				// }
			}
		}
		catch (IllegalArgumentException e) {
			if (url != null) {
				uri = URI.createFileURI(url.getFile());
			}
		}

		return uri;
	}

	public static Collection<EObject> allContents(EObject modelElement) {
		List<EObject> all = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = modelElement.eAllContents();
		while (iterator.hasNext()) {
			all.add(iterator.next());
		}
		return all;
	}

}
