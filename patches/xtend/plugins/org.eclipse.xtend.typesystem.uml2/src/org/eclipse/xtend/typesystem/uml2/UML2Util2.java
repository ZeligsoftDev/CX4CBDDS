/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.typesystem.uml2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;

public class UML2Util2 {
	private final static Map<URI, Profile> profiles = new HashMap<URI, Profile>();

	public final static Profile loadProfile(String pathToProfile) {
		if (isBlank(pathToProfile)) {
			throw new RuntimeException("No profile specified. Check the configuration.");
		}
		URI uri = EcoreUtil2.getURI(pathToProfile);
		if (uri == null) {
			throw new RuntimeException("cannot resolve Profile for " + pathToProfile + ". Probably cannot find the .profile.uml2 file.");
		}
		return loadProfile(uri);
	}

	public synchronized final static Profile loadProfile(URI uri) {
		if (profiles.containsKey(uri))
			return profiles.get(uri);
		Resource r = new ResourceSetImpl().createResource(uri);
		try {
			r.load(new HashMap<Object,Object>());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		List<EObject> c = r.getContents();
		if (c.isEmpty()) {
			return null;
		}
		if (c.get(0) instanceof Profile) {
			Profile p = (Profile) c.get(0);
			profiles.put(uri, p);
			return p;
		}
		return null;
	}

	/**
	 * Retrieves an object's identifier. The object must be read from a
	 * XMLResource.
	 * 
	 * @param obj
	 * @return The object's id.
	 * @since 4.2
	 */
	public static String getXmiId(Element obj) {
		return (obj.eResource() != null && obj.eResource() instanceof XMLResource) ? ((XMLResource) obj.eResource()).getID(obj) : null;
	}

	private static boolean isBlank(String string) {
		if (string == null || string.trim().equals("")) {
			return true;
		}
		return false;
	}
}
