/**
 * Copyright (c) 2017, 2020 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bugs 518789, 569357
 *
 *
 */
package org.eclipse.papyrus.infra.architecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.osgi.service.prefs.BackingStoreException;

/**
 * This class reads/writes the architecture domain preferences
 *
 * @since 1.0
 */
public class ArchitectureDomainPreferences implements Cloneable {

	/**
	 * The addedModels preference property name
	 */
	public static final String ADDED_MODELS = "addedModels"; //$NON-NLS-1$

	/**
	 * The excludedContexts preference property name
	 */
	public static final String EXCLUDED_CONTEXTS = "excludedContexts"; //$NON-NLS-1$

	/**
	 * The defaultContext preference property name
	 */
	public static final String DEFAULT_CONTEXT = "defaultContext"; //$NON-NLS-1$

	/**
	 * The default value of the default context when not set
	 */
	static final String DEFAULT_DEFAULT_CONTEXT_ID = TypeContext.getDefaultContextId();

	/**
	 * The list of added architecture model URIs in the preferences
	 */
	private List<String> addedModelURIs = new ArrayList<>();

	/**
	 * The set of excluded architecture context ids in the preferences
	 */
	private Set<String> excludedContextIds = new HashSet<>();

	/**
	 * The id of the default context id in the preferences
	 */
	private String defaultContextId = DEFAULT_DEFAULT_CONTEXT_ID;

	/**
	 * Constructor
	 */
	public ArchitectureDomainPreferences() {
		read();
	}

	/*
	 * Gets the preferences node
	 */
	private static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
	}

	/**
	 * Reads the state of the preferences
	 */
	public void read() {
		String value;
		value = getPreferences().get(ArchitectureDomainPreferences.ADDED_MODELS, "");
		addedModelURIs = value.equals("") ? new ArrayList<>() : Stream.of(value.split(" ")).collect(Collectors.toList());
		value = getPreferences().get(ArchitectureDomainPreferences.EXCLUDED_CONTEXTS, "");
		excludedContextIds = value.equals("") ? new HashSet<>() : Stream.of(value.split(",")).collect(Collectors.toSet());
		value = getPreferences().get(ArchitectureDomainPreferences.DEFAULT_CONTEXT, DEFAULT_DEFAULT_CONTEXT_ID);
		defaultContextId = value;
	}

	/**
	 * Writes the state of the preferences
	 */
	public void write() {
		getPreferences().put(ArchitectureDomainPreferences.ADDED_MODELS, String.join(" ", addedModelURIs));
		getPreferences().put(ArchitectureDomainPreferences.EXCLUDED_CONTEXTS, String.join(",", excludedContextIds));
		getPreferences().put(ArchitectureDomainPreferences.DEFAULT_CONTEXT, defaultContextId);
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Resets the state of this class to default
	 */
	public void reset() {
		addedModelURIs.clear();
		excludedContextIds.clear();
		defaultContextId = DEFAULT_DEFAULT_CONTEXT_ID;
	}

	/**
	 * Adds the given preference change listener
	 *
	 * @param listener
	 */
	static void addListener(IPreferenceChangeListener listener) {
		getPreferences().addPreferenceChangeListener(listener);
	}

	/**
	 * @return the added model URIs
	 */
	public List<String> getAddedModelURIs() {
		return addedModelURIs;
	}

	/**
	 * @return the excluded context ids
	 */
	public Set<String> getExcludedContextIds() {
		return excludedContextIds;
	}

	/**
	 * @return the default context id
	 */
	public String getDefaultContextId() {
		return defaultContextId;
	}

	/**
	 * Sets the default context id
	 *
	 * @param defaultContextId
	 *            the default context id
	 */
	public void setDefaultContextId(String defaultContextId) {
		this.defaultContextId = defaultContextId;
	}

	@Override
	public ArchitectureDomainPreferences clone() {
		ArchitectureDomainPreferences clone = new ArchitectureDomainPreferences();
		clone.addedModelURIs = new ArrayList<>(getAddedModelURIs());
		clone.excludedContextIds = new HashSet<>(getExcludedContextIds());
		clone.setDefaultContextId(getDefaultContextId());
		return clone;
	}

}
