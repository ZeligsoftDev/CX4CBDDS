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
 *  Christian W. Damus - bugs 570097, 570486
 *
 *
 */
package org.eclipse.papyrus.infra.architecture;

import static org.eclipse.papyrus.infra.architecture.ArchitectureDomainMerger.log;
import static org.eclipse.papyrus.infra.architecture.ArchitectureDomainMerger.logf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;

/**
 * The main API for reading architecture domains information
 *
 * It reads architecture domain models registered in extensions and preferences
 *
 * @since 1.0
 */
public class ArchitectureDomainManager implements IPreferenceChangeListener {

	/**
	 * The extension point for architecture models
	 */
	private static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".models";

	/**
	 * The name pf the path attribute
	 */
	private static final String PATH = "path"; //$NON-NLS-1$

	/**
	 * The singleton instance of this class
	 */
	private static final ArchitectureDomainManager INSTANCE = new ArchitectureDomainManager();

	/**
	 * Gets the singleton instance of this class
	 *
	 * @return the singleton instance of this class
	 */
	public static ArchitectureDomainManager getInstance() {
		return INSTANCE;
	}

	/**
	 * An interface for listening to changes to architectural domains
	 */
	public static interface Listener {
		public void domainManagerChanged();
	}

	/**
	 * An abstract class for listening to specific changes to architectural domains
	 */
	public abstract static class SpecificListener implements Listener {
		@Override
		public void domainManagerChanged() {
		}

		/** the set of excluded contexts in the preferences have changed */
		public void excludedContextsChanged() {
		}

		/** the set of architecture models added through preferences has changed */
		public void addedModelsChanged() {
		}

		/** the default architecture context set in preferences has changed */
		public void defaultContextChanged() {
		}
	}

	/**
	 * The architecture domain preferences
	 */
	private final ArchitectureDomainPreferences preferences;

	/**
	 * The architecture domain merger
	 */
	private final ArchitectureDomainMerger merger;

	/**
	 * A collection of listeners to architecture domain changes
	 */
	private Collection<Listener> listeners;

	/**
	 * Constructs a new instance of this class
	 */
	private ArchitectureDomainManager() {
		listeners = new HashSet<>();
		merger = new ArchitectureDomainMerger();
		preferences = new ArchitectureDomainPreferences();
		ArchitectureDomainPreferences.addListener(this);
		initializeFromExtensions();
		initializeFromPreferences();
		merger.init(); // init as early as possible
	}

	/**
	 * initialize the architecture domain merger from the registered extensions
	 */
	private void initializeFromExtensions() {
		List<URI> models = new ArrayList<>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT);
		for (IConfigurationElement element : elements) {
			String path = element.getAttribute(PATH);
			String bundleId = element.getContributor().getName();
			String modelPath = bundleId + IPath.SEPARATOR + path;
			models.add(URI.createPlatformPluginURI(modelPath, true));
		}
		merger.setExtensionModels(models);
	}

	/**
	 * initialize the architecture domain merger from the preferences
	 */
	private void initializeFromPreferences() {
		List<URI> models = new ArrayList<>();
		for (String value : preferences.getAddedModelURIs()) {
			if (value.length() > 0) {
				models.add(URI.createURI(value, true));
			}
		}
		merger.setPreferenceModels(models);
	}

	/**
	 * Gets the registered architecture models
	 *
	 * @return a collection of registered architecture model URIs
	 * @since 2.0
	 */
	public Collection<URI> getRegisteredArchitectureModels() {
		UniqueEList<URI> result = new UniqueEList<>(merger.getExtensionModels());
		result.addAll(merger.getPrefereceModels());
		return result;
	}

	/**
	 * Obtain the architecture domains that are the source models for my merged architecture domains.
	 *
	 * @return the original registered architecture domains
	 * @since 3.1
	 */
	public Collection<ArchitectureDomain> getRegisteredArchitectureDomains() {
		return merger.getLoadedArchitectureDomains();
	}

	/**
	 * Add the given listener to the domain changes
	 *
	 * @param listener
	 *            a given domain change listener
	 */
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	/**
	 * Remove the given listener to the domain changes
	 *
	 * @param listener
	 *            a given domain change listener
	 */
	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	/**
	 * React to the preferences changing by reinitializing from them; notify listeners
	 *
	 * @see org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener#preferenceChange(org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent)
	 *
	 * @param event
	 *            a preference change event
	 */
	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		logf("Architecture preference changed: %s => %s.", event.getKey(), event.getNewValue()); //$NON-NLS-1$
		preferences.read();

		if (event.getKey().equals(ArchitectureDomainPreferences.ADDED_MODELS)) {
			initializeFromPreferences();
		}

		log("Notifying listeners."); //$NON-NLS-1$
		for (Listener listener : listeners) {
			if (listener instanceof SpecificListener) {
				SpecificListener specificListener = (SpecificListener) listener;
				if (event.getKey().equals(ArchitectureDomainPreferences.ADDED_MODELS)) {
					specificListener.addedModelsChanged();
				} else if (event.getKey().equals(ArchitectureDomainPreferences.DEFAULT_CONTEXT)) {
					specificListener.defaultContextChanged();
				} else if (event.getKey().equals(ArchitectureDomainPreferences.EXCLUDED_CONTEXTS)) {
					specificListener.excludedContextsChanged();
				}
			}
			listener.domainManagerChanged();
		}
	}

	/**
	 * Gets the architecture domain preferences
	 *
	 * @deprecated Deprecate the public API ArchitectureDomainManager.getPreferences()
	 *             method to avoid changing the preferences through the object only as
	 *             opposed to the preference store
	 * @return the architecture domain preferences
	 */
	@Deprecated
	public ArchitectureDomainPreferences getPreferences() {
		return preferences;
	}

	/**
	 * Get the architecture domain merger
	 *
	 * @return the architecture domain merger
	 */
	public ArchitectureDomainMerger getMerger() {
		return merger;
	}

	/**
	 * Gets the collection of architecture contexts that are visible based on preferences
	 *
	 * @return a list of architecture contexts
	 */
	public Collection<MergedArchitectureContext> getVisibleArchitectureContexts() {
		Collection<MergedArchitectureContext> contexts = new ArrayList<>();
		for (MergedArchitectureDomain domain : merger.getDomains()) {
			for (MergedArchitectureContext context : domain.getContexts()) {
				if (!preferences.getExcludedContextIds().contains(context.getId())) {
					contexts.add(context);
				}
			}
		}
		return contexts;
	}

	/**
	 * Gets the id of the default architecture context
	 *
	 * @return the default architecture context id
	 */
	public String getDefaultArchitectureContextId() {
		return preferences.getDefaultContextId();
	}

	/**
	 * Gets the default architecture context
	 *
	 * @return the default architecture context
	 */
	public MergedArchitectureContext getDefaultArchitectureContext() {
		return getArchitectureContextById(getDefaultArchitectureContextId());
	}

	/**
	 * Gets an architecture context by the given id
	 *
	 * @param id
	 *            a given id of an architecture context
	 * @return the architecture context with the given id
	 */
	public MergedArchitectureContext getArchitectureContextById(String id) {
		return merger.getArchitectureContextById(id);
	}

	/**
	 * Gets an architecture viewpoint by the given id
	 *
	 * @param id
	 *            a given id of an architecture viewpoint
	 * @return the architecture viewpoint with the given id
	 */
	public MergedArchitectureViewpoint getArchitectureViewpointById(String id) {
		return merger.getArchitectureViewpointById(id);
	}

	/**
	 * Gets a representation kind by the given id
	 *
	 * @param id
	 *            a given id of a representation kind
	 * @return the representation kind with the given id
	 */
	public RepresentationKind getRepresentationKindById(String id) {
		return merger.getRepresentationKindById(id);
	}

}
