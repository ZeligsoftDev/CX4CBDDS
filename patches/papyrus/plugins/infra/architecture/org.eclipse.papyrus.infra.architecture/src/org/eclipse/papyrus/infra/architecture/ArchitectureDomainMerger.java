/**
 * Copyright (c) 2017, 2021 CEA LIST, Christian W. Damus, and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  Christian W. Damus - bugs 569357, 570486
 *
 *
 */
package org.eclipse.papyrus.infra.architecture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.util.FormattableADElement;
import org.eclipse.papyrus.infra.core.internal.architecture.merger.InternalArchitectureDomainMerger;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;

import com.google.common.collect.Iterables;

/**
 * A merger for architecture domains read from extensions or preferences or contributed
 * dynamically (programmatically)
 *
 * It produces a collection of {@link org.eclipse.papyrus.infra.core.architecture.
 * merged.MergedDomain}s by merging a collection of {@link org.eclipse.papyrus.infra.
 * core.architecture.ArchitectureDomain}s.
 *
 * @since 1.0
 */
public class ArchitectureDomainMerger implements Cloneable {

	/**
	 * A resource set used to load architecture models
	 */
	private ResourceSet resourceSet;

	/**
	 * A resource set used to store merged architecture models
	 */
	private ResourceSet mergedResourceSet;

	/**
	 * a collection of architecture models coming from extensions
	 */
	private Collection<URI> extensionModels;

	/**
	 * a collection of architecture models coming from preferences
	 */
	private Collection<URI> preferenceModels;

	/**
	 * a collection of architecture domains contributed dynamically (programmatically)
	 */
	private Collection<ArchitectureDomain> dynamicDomains;

	/**
	 * A collection of loaded source domains
	 */
	private Collection<ArchitectureDomain> loadedDomains;

	/**
	 * A collection of merged domains
	 */
	private Collection<MergedArchitectureDomain> mergedDomains;

	/**
	 * a cached mapping from id to ADElement
	 */
	private Map<String, Object> idCache;

	/**
	 * Constructs a new instance of the class
	 */
	ArchitectureDomainMerger() {
	}

	/**
	 * Gets the extension model URIs
	 *
	 * @return the collection of extension model URIs
	 */
	Collection<URI> getExtensionModels() {
		return this.extensionModels;
	}

	/**
	 * Sets the collection of architecture models URIs read from extensions
	 *
	 * @param models
	 *            a collection of architecture model URIs
	 */
	public void setExtensionModels(Collection<URI> models) {
		logf("Extension Architecture Domain models changed: %s.", models); //$NON-NLS-1$
		this.extensionModels = models;
		reset();
	}

	/**
	 * Gets the preference model URIs
	 *
	 * @return the collection of preference model URIs
	 */
	Collection<URI> getPrefereceModels() {
		return this.preferenceModels;
	}

	/**
	 * Sets the collection of architecture model URIs read from preferences
	 *
	 * @param models
	 *            a collection of architecture model URIS
	 */
	public void setPreferenceModels(Collection<URI> models) {
		logf("Preference Architecture Domain models changed: %s.", models); //$NON-NLS-1$
		this.preferenceModels = models;
		reset();
	}

	/**
	 * Gets the dynamic model domains
	 *
	 * @return the collection of dynamic domains
	 */
	Collection<ArchitectureDomain> getDynamicDomains() {
		return this.dynamicDomains;
	}

	/**
	 * Sets the collection of architecture domains contributed dynamically
	 *
	 * @param domains
	 *            a collection of architecture domains
	 */
	public void setDynamicDomains(Collection<ArchitectureDomain> domains) {
		logf("Dynamic Architecture Domains changed: %s.", FormattableADElement.wrap(domains)); //$NON-NLS-1$
		this.dynamicDomains = domains;
		reset();
	}

	/**
	 * Gets the collection of merged architecture domains
	 *
	 * @return the collection of merged architecture domains
	 */
	public Collection<MergedArchitectureDomain> getDomains() {
		init();
		return Collections.unmodifiableCollection(mergedDomains);
	}

	/**
	 * Gets an architecture context given its id
	 *
	 * @param id
	 *            an id for an architecture context
	 * @return an architecture context
	 */
	public MergedArchitectureContext getArchitectureContextById(String id) {
		init();
		Object found = idCache.get(id);
		return (found instanceof MergedArchitectureContext) ? (MergedArchitectureContext) found : null;
	}

	/**
	 * Gets an architecture viewpoint given its id
	 *
	 * @param id
	 *            an id for an architecture viewpoint
	 * @return an architecture viewpoint
	 */
	public MergedArchitectureViewpoint getArchitectureViewpointById(String id) {
		init();
		Object found = idCache.get(id);
		return (found instanceof MergedArchitectureViewpoint) ? (MergedArchitectureViewpoint) found : null;
	}

	/**
	 * Gets a representation kind given its id
	 *
	 * @param id
	 *            an id for an representation kind
	 * @return a representation kind
	 */
	public RepresentationKind getRepresentationKindById(String id) {
		init();
		Object found = idCache.get(id);
		return (found instanceof RepresentationKind) ? (RepresentationKind) found : null;
	}

	@Override
	public ArchitectureDomainMerger clone() {
		ArchitectureDomainMerger clone = new ArchitectureDomainMerger();
		clone.setExtensionModels(extensionModels);
		clone.setPreferenceModels(preferenceModels);
		return clone;
	}

	/*
	 * Resets the merger's state
	 */
	private synchronized void reset() {
		log("Resetting the Architecture Domains."); //$NON-NLS-1$

		// UML models can be cross-referenced, which may leak stuff via the CacheAdapter
		if (resourceSet != null) {
			EMFHelper.unload(resourceSet);
		}
		if (mergedResourceSet != null) {
			EMFHelper.unload(mergedResourceSet);
		}

		resourceSet = null;
		mergedResourceSet = null;
		loadedDomains = null;
		mergedDomains = null;
		idCache = null;
	}

	/** Log a model tracing message. */
	static void log(String message) {
		Activator.log.trace(Activator.DEBUG_MODELS, message);
	}

	/** Log a model tracing message. */
	static void logf(String pattern, Object arg) {
		if (Activator.log.isTraceEnabled(Activator.DEBUG_MODELS)) {
			Activator.log.trace(Activator.DEBUG_MODELS, String.format(pattern, FormattableADElement.wrap(arg)));
		}
	}

	/** Log a model tracing message. */
	static void logf(String pattern, Object arg1, Object arg2) {
		if (Activator.log.isTraceEnabled(Activator.DEBUG_MODELS)) {
			Activator.log.trace(Activator.DEBUG_MODELS, String.format(pattern, FormattableADElement.wrap(arg1), FormattableADElement.wrap(arg2)));
		}
	}

	/**
	 * Initializes this instance of the merger
	 */
	synchronized void init() {
		if (mergedDomains != null) {
			return; // Already initialized
		}

		log("Initializing the Architecture Domains."); //$NON-NLS-1$

		Collection<ArchitectureDomain> domains = getLoadedArchitectureDomains();

		mergedDomains = new ArrayList<>();

		log("Merging the Architecture Domains."); //$NON-NLS-1$

		InternalArchitectureDomainMerger merger = InternalArchitectureDomainMerger.newInstance();
		Iterables.addAll(mergedDomains, merger.mergeDomains(domains));
		if (!mergedDomains.isEmpty()) {
			mergedResourceSet = mergedDomains.iterator().next().getAdapter(ResourceSet.class);

			// Purge unneeded resources from domains that were merged into other domains
			mergedResourceSet.getResources().removeIf(res -> !res.isLoaded() || res.getContents().isEmpty());
		}

		log("Indexing the Architecture Domains."); //$NON-NLS-1$

		buildCache();
	}

	private synchronized void initResourceSet() {
		if (loadedDomains != null) {
			return; // Already initialized
		}

		log("Loading the Architecture Domains from source models."); //$NON-NLS-1$

		resourceSet = new ResourceSetImpl();
		resourceSet.setURIConverter(ResourceUtils.createWorkspaceAwareURIConverter());
		resourceSet.setPackageRegistry(ResourceUtils.createWorkspaceAwarePackageRegistry());

		loadedDomains = new ArrayList<>();

		Stream<URI> modelURIs = Stream.empty();
		if (extensionModels != null) {
			modelURIs = Stream.concat(modelURIs, extensionModels.stream());
		}
		if (preferenceModels != null) {
			modelURIs = Stream.concat(modelURIs, preferenceModels.stream());
		}

		// In case of preference registrations that are redundant, don't repeat any models
		modelURIs.map(resourceSet.getURIConverter()::normalize).distinct().forEach(model -> {
			ArchitectureDomain domain = loadDomain(resourceSet.createResource(model));
			if (domain != null) {
				loadedDomains.add(domain);
			}
		});

		// And then there's the ones that we don't know where they came from because we didn't load them
		if (dynamicDomains != null) {
			for (ArchitectureDomain domain : dynamicDomains) {
				if (domain != null) {
					loadedDomains.add(domain);
				}
			}
		}
	}

	/*
	 * Read an architecture domain from the given architecture model resource
	 */
	private ArchitectureDomain loadDomain(Resource resource) {
		try {
			logf("Loading Architecture resource %s.", resource.getURI()); //$NON-NLS-1$
			resource.load(null);
		} catch (IOException e) {
			// Don't log the error yet; we're trying several options
			logf("Exception loading Architecture resource %s: %s", resource.getURI(), e.getMessage()); //$NON-NLS-1$
			return null;
		}
		EObject content = resource.getContents().get(0);
		if (content instanceof ArchitectureDomain) {
			return (ArchitectureDomain) content;
		} else {
			Activator.log.warn("file " + resource.getURI() + " is not an architecture model");
		}
		return null;
	}

	/*
	 * builds a id to element cache for faster lookup
	 */
	private void buildCache() {
		idCache = new HashMap<>();
		for (MergedArchitectureDomain domain : mergedDomains) {
			for (MergedArchitectureContext context : domain.getContexts()) {
				idCache.put(context.getId(), context);
				for (MergedArchitectureViewpoint viewpoint : context.getViewpoints()) {
					idCache.put(viewpoint.getId(), viewpoint);
				}
				if (context instanceof MergedArchitectureDescriptionLanguage) {
					MergedArchitectureDescriptionLanguage language = (MergedArchitectureDescriptionLanguage) context;
					for (RepresentationKind representationKind : language.getRepresentationKinds()) {
						idCache.put(representationKind.getId(), representationKind);
					}
				}
			}
		}
	}

	/**
	 * Obtain the architecture domains that are the source models for my merged architecture domains.
	 *
	 * @return the original registered architecture domains
	 * @since 3.1
	 */
	Collection<ArchitectureDomain> getLoadedArchitectureDomains() {
		initResourceSet();
		return Collections.unmodifiableCollection(loadedDomains);
	}

}
