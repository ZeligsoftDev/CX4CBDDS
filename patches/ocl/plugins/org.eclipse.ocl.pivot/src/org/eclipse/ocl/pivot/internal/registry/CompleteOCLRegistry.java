/**
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 */
package org.eclipse.ocl.pivot.internal.registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.plugin.CompleteOCLRegistryReader;

/**
 * This registry will be used to hold all complete ocl resources that have been
 * made available through the extension point.
 * 
 * @author <a href="mailto:marwa.rostren@obeo.fr">Marwa Rostren</a>
 */
public class CompleteOCLRegistry
{
	public static final @NonNull CompleteOCLRegistry INSTANCE = new CompleteOCLRegistry(null);
	
	/**
	 * A Registration identifies a contribution to a Registry enabling the registry to be rebuilt if a registration is removed.
	 */
	public static class Registration
	{
		private @NonNull URI resourceURI;
		private @NonNull Set<String> nsURIs;
		
		public Registration(@NonNull URI resourceURI, @NonNull Iterable<String> nsURIs) {
			this.resourceURI = resourceURI;
			this.nsURIs = new HashSet<String>();
			for (String nsURI : nsURIs) {
				this.nsURIs.add(nsURI);
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Registration)) {
				return  false;
			}
			Registration that = (Registration)obj;
			return resourceURI.equals(that.resourceURI) && nsURIs.equals(that.nsURIs);
		}

		@Override
		public int hashCode() {
			int hash = resourceURI.hashCode();
			for (String nsURI : nsURIs) {
				hash += nsURI.hashCode();
			}
			return hash;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(resourceURI);
			s.append(" : ");
			boolean isFirst = true;
			for (String nsURI : nsURIs) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(nsURI);
				isFirst = false;
			}
			return s.toString();
		}
	}

	private final @NonNull Map<String, Set<URI>> nsURI2resourceURIs = new HashMap<String, Set<URI>>();
	private @Nullable Map<Registration, Integer> registrations = null;

	public CompleteOCLRegistry() {
		this(new HashMap<Registration, Integer>());
	}

	protected CompleteOCLRegistry(@Nullable Map<Registration, Integer> registrations) {
		this.registrations = registrations;
	}

	public synchronized void addRegistration(@NonNull Registration registration) {
		Map<Registration, Integer> registrations2 = registrations;
		if (registrations2 == null) {
			registrations = registrations2 = new HashMap<Registration, Integer>();
		}
		Integer count = registrations2.get(registration);
		if (count == null) {
			count = 1;
		}
		else {
			count++;
		}
		registrations2.put(registration, count);
		if (count == 1) {
			addRegistrationInternal(registration);
		}
	}

	private void addRegistrationInternal(@NonNull Registration registration) {
		for (String nsURI : registration.nsURIs) {
			Set<URI> resourceURIs = nsURI2resourceURIs.get(nsURI);
			if (resourceURIs == null) {
				resourceURIs = new HashSet<URI>();
				nsURI2resourceURIs.put(nsURI, resourceURIs);
			}
			resourceURIs.add(registration.resourceURI);
		}
	}

	public synchronized void clear() {
		Map<Registration, Integer> registrations2 = registrations;
		if (registrations2 != null) {
			registrations2.clear();
			rebuild();
		}
	}

	/**
	 * Returns all document resource URIs that provide content for any EPackege nsURI in resourceSet
	 */
	public @NonNull Set<URI> getResourceURIs(@NonNull ResourceSet resourceSet) {
		if (registrations == null) {
			registrations = new HashMap<Registration, Integer>();
			new CompleteOCLRegistryReader(this).readRegistry();
		}
		Set<String> nsURIs = new HashSet<String>();
		for (Resource resource : resourceSet.getResources()) {
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				EPackage ePackage = eObject.eClass().getEPackage();
				String nsURI = ePackage.getNsURI();
				nsURIs.add(nsURI);
			}
		}
		return getResourceURIs(nsURIs);
	}

	/**
	 * Returns all document resource URIs that provide content for any of the nsURIs
	 */
	public @NonNull Set<URI> getResourceURIs(@NonNull Iterable<String> nsURIs) {
		Set<URI> documentURIs = new HashSet<URI>();
		for (String nsURI : nsURIs) {
			if (nsURI != null) {
				Set<URI> resourceURIs = nsURI2resourceURIs.get(nsURI);
				if (resourceURIs != null) {
					documentURIs.addAll(resourceURIs);
				}
			}
		}
		return documentURIs;
	}

	private void rebuild() {
		nsURI2resourceURIs.clear();
		Map<Registration, Integer> registrations2 = registrations;
		if (registrations2 != null) {
			for (@SuppressWarnings("null")@NonNull Registration registration : registrations2.keySet()) {
				addRegistrationInternal(registration);
			}
		}
	}
	
	public synchronized void removeRegistration(@NonNull Registration registration) {
		Map<Registration, Integer> registrations2 = registrations;
		if (registrations2 != null) {
			Integer count = registrations2.get(registration);
			if (count != null) {
				if (--count <= 0) {
					registrations2.remove(registration);
					rebuild();
				}
				else {
					registrations2.put(registration, count);
				}
			}
		}
	}
}
