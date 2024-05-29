/*******************************************************************************
 * Copyright (c) 2014, 2106 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemUtil;
import org.eclipse.emf.compare.rcp.internal.tracer.TracingConstant;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDeactivableDiffFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Manager of filters.
 * <p>
 * This manager handle addition and removal of filters
 * </p>
 * <p>
 * It also allow to override registered filters with preferences.
 * </p>
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class DifferenceFilterManager {

	/** Preference key for by default disabled filters. */
	private static final String BY_DEFAULT_DISABLED_FILTER = "org.eclipse.emf.compare.rcp.ui.filters.disabled"; //$NON-NLS-1$

	/** Preference key for inactive (fully ignored) filters. */
	private static final String INACTIVE_FILTERS_PREF_KEY = "org.eclipse.emf.compare.rcp.ui.filters.inactive"; //$NON-NLS-1$

	/** A map that associates the class name to their {@link IDifferenceFilter}s. */
	private final Map<String, DifferenceFilterDefaultConfiguration> map;

	/** The {@link IPreferenceStore} holding the value for filter preferences. */
	private final IPreferenceStore preferenceStore;

	/**
	 * Predicate use to transform {@link DifferenceFilterDefaultConfiguration} to {@link IDifferenceFilter}.
	 */
	private final static Function<DifferenceFilterDefaultConfiguration, IDifferenceFilter> TO_FILTER = new Function<DifferenceFilterManager.DifferenceFilterDefaultConfiguration, IDifferenceFilter>() {

		public IDifferenceFilter apply(DifferenceFilterDefaultConfiguration arg0) {
			if (arg0 != null) {
				return arg0.getFilter();
			}
			return null;
		}
	};

	/**
	 * Constructor.
	 * 
	 * @param preferenceStore
	 *            The {@link IPreferenceStore} holding the value for filter preferences.
	 */
	public DifferenceFilterManager(IPreferenceStore preferenceStore) {
		map = Collections.synchronizedMap(new LinkedHashMap<String, DifferenceFilterDefaultConfiguration>());
		this.preferenceStore = preferenceStore;
	}

	/**
	 * Add a new filter.
	 * 
	 * @param filter
	 *            {@link IDifferenceFilter}
	 * @return The old {@link IDifferenceFilter} register with the same key.
	 */
	IDifferenceFilter add(IDifferenceFilter filter) {
		Preconditions.checkNotNull(filter);
		DifferenceFilterDefaultConfiguration oldValue = map.put(filter.getClass().getName(),
				new DifferenceFilterDefaultConfiguration(filter, filter.defaultSelected()));
		if (oldValue != null) {
			return oldValue.getFilter();
		}
		return null;
	}

	/**
	 * Remove a filter.
	 * 
	 * @param className
	 *            The class name of the filter.
	 * @return The {@link IDifferenceFilter} that has been removed or <code>null</code> if none.
	 */
	IDifferenceFilter remove(String className) {
		DifferenceFilterDefaultConfiguration oldValue = map.remove(className);
		if (oldValue != null) {
			return oldValue.getFilter();
		}
		return null;
	}

	/**
	 * Get all {@link IDifferenceFilter} that should be used by default for next comparison.
	 * 
	 * @return A {@link Collection} of {@link IDifferenceFilter} that should be used by default for next
	 *         comparison.
	 */
	public Set<IDifferenceFilter> getCurrentByDefaultFilters() {
		Set<IDifferenceFilter> storedFilter = getDisabledFilters();
		if (storedFilter == null) {
			return getInitialByDefaultFilters();
		}
		return Sets.difference(getAllFilters(), storedFilter);
	}

	/**
	 * Get all {@link IDifferenceFilter} that should be disabled for next comparison.
	 * 
	 * @return A {@link Collection} of {@link IDifferenceFilter} that should be disabled for next comparison.
	 */
	public Collection<IDeactivableDiffFilter> getCurrentInactiveFilters() {
		Set<IDeactivableDiffFilter> inactiveFilters = getInactiveFilters();
		if (inactiveFilters == null) {
			return Collections.emptyList();
		}
		return inactiveFilters;
	}

	/**
	 * {@link Set} of {@link IDifferenceFilter} that are initially enabled by default.
	 * <p>
	 * During the first addiction in the registry of these {@link IDifferenceFilter},
	 * {@link IDifferenceFilter#defaultSelected()} was equal to true
	 * </p>
	 * 
	 * @return {@link Set} of {@link IDifferenceFilter} that are original enabled by default.
	 */
	public Set<IDifferenceFilter> getInitialByDefaultFilters() {
		Set<IDifferenceFilter> result = Sets.newLinkedHashSet();
		for (DifferenceFilterDefaultConfiguration f : map.values()) {
			if (f.isDefaultSelectedInitialValue()) {
				result.add(f.getFilter());
			}
		}
		return result;
	}

	/**
	 * Set the filters that should be used by default for next comparison.
	 * 
	 * @param enabledFilter
	 *            {@link Set} of {@link IDifferenceFilter} to set.
	 */
	public void setCurrentByDefaultFilters(Set<IDifferenceFilter> enabledFilter) {
		final Set<IDifferenceFilter> disabledFilter;
		if (enabledFilter == null) {
			disabledFilter = getAllFilters();
		} else {
			disabledFilter = Sets.difference(getAllFilters(), enabledFilter);
		}
		SetView<IDifferenceFilter> initialDisabledFilter = Sets.difference(getAllFilters(),
				getInitialByDefaultFilters());
		storeInPreferences(disabledFilter, initialDisabledFilter, BY_DEFAULT_DISABLED_FILTER);
		// Trace preferences values
		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder builder = new StringBuilder();
			// Print each preferences
			builder.append("Preference ").append(BY_DEFAULT_DISABLED_FILTER).append(":\n"); //$NON-NLS-1$ //$NON-NLS-2$
			String preferenceValue = preferenceStore.getString(BY_DEFAULT_DISABLED_FILTER);
			String[] groups = preferenceValue.split(ItemUtil.PREFERENCE_DELIMITER);
			for (int rank = 0; rank < groups.length; rank++) {
				builder.append(rank).append(". ").append(groups[rank]).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			builder.append("\n\n"); //$NON-NLS-1$
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.INFO, builder.toString());
		}
	}

	/**
	 * Set the filters that should be active for the next comparison.
	 * 
	 * @param activeFilters
	 *            {@link Set} of {@link IDifferenceFilter} to set.
	 */
	public void setCurrentActiveFilters(Set<IDifferenceFilter> activeFilters) {
		final Set<IDeactivableDiffFilter> inactiveFilters;
		Set<IDeactivableDiffFilter> deactivableFilters = Sets
				.newLinkedHashSet(Iterables.filter(getAllFilters(), IDeactivableDiffFilter.class));
		if (activeFilters == null) {
			inactiveFilters = deactivableFilters;
		} else {
			inactiveFilters = Sets.difference(deactivableFilters, activeFilters);
		}
		storeInPreferences(inactiveFilters, Collections.<IDifferenceFilter> emptySet(),
				INACTIVE_FILTERS_PREF_KEY);
		// Trace preferences values
		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder builder = new StringBuilder();
			// Print each preferences
			builder.append("Preference ").append(INACTIVE_FILTERS_PREF_KEY).append(":\n"); //$NON-NLS-1$ //$NON-NLS-2$
			String preferenceValue = preferenceStore.getString(INACTIVE_FILTERS_PREF_KEY);
			String[] groups = preferenceValue.split(ItemUtil.PREFERENCE_DELIMITER);
			for (int rank = 0; rank < groups.length; rank++) {
				builder.append(rank).append(". ").append(groups[rank]).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			builder.append("\n\n"); //$NON-NLS-1$
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.INFO, builder.toString());
		}
	}

	/**
	 * Get all registered filter.
	 * 
	 * @return {@link Set} of all filter.
	 */
	public Set<IDifferenceFilter> getAllFilters() {
		return Sets.newLinkedHashSet(Collections2.transform(map.values(), TO_FILTER));
	}

	/**
	 * A {@link Set} of disabled by default {@link IDifferenceFilter} from preferences.
	 * <p>
	 * Those filter will not be activated by default for next comparison
	 * </p>
	 * 
	 * @return A {@link Set} of disabled by default {@link IDifferenceFilter} from preferences.
	 */
	private Set<IDifferenceFilter> getDisabledFilters() {
		String diffEngineKey = preferenceStore.getString(BY_DEFAULT_DISABLED_FILTER);
		Set<IDifferenceFilter> result = null;
		if (diffEngineKey != null && !diffEngineKey.isEmpty()) {
			String[] diffEngineKeys = diffEngineKey.split(ItemUtil.PREFERENCE_DELIMITER);
			for (String nonTrimedKey : diffEngineKeys) {
				String key = nonTrimedKey.trim();
				DifferenceFilterDefaultConfiguration descriptor = map.get(key);
				if (descriptor != null) {
					if (result == null) {
						result = new LinkedHashSet<IDifferenceFilter>();
					}
					result.add(descriptor.getFilter());
				}
			}
		}
		return result;
	}

	/**
	 * A {@link Set} of deactivated {@link IDeactivableDiffFilter} from preferences.
	 * <p>
	 * Those filters will be totally inactive for next comparisons.
	 * </p>
	 * 
	 * @return A {@link Set} of deactivated {@link IDeactivableDiffFilter} from preferences (Filters that do
	 *         not implement {@link IDeactivableDiffFilter} cannot be deactivated).
	 */
	private Set<IDeactivableDiffFilter> getInactiveFilters() {
		String diffEngineKey = preferenceStore.getString(INACTIVE_FILTERS_PREF_KEY);
		Set<IDeactivableDiffFilter> result = null;
		if (diffEngineKey != null && !diffEngineKey.isEmpty()) {
			String[] diffEngineKeys = diffEngineKey.split(ItemUtil.PREFERENCE_DELIMITER);
			for (String nonTrimedKey : diffEngineKeys) {
				String key = nonTrimedKey.trim();
				DifferenceFilterDefaultConfiguration descriptor = map.get(key);
				if (descriptor != null) {
					IDifferenceFilter filter = descriptor.getFilter();
					if (filter instanceof IDeactivableDiffFilter) {
						if (result == null) {
							result = new LinkedHashSet<IDeactivableDiffFilter>();
						}
						result.add((IDeactivableDiffFilter)filter);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Store value in preferences.
	 * 
	 * @param currentValue
	 *            Value to store.
	 * @param defaultConf
	 *            Default value.
	 */
	private void storeInPreferences(Set<? extends IDifferenceFilter> currentValue,
			Set<? extends IDifferenceFilter> defaultConf, String prefKey) {
		if (currentValue != null && !currentValue.equals(defaultConf)) {
			Map<String, IDifferenceFilter> toStore = Maps.filterValues(Maps.transformValues(map, TO_FILTER),
					Predicates.in(currentValue));
			String preferenceValue = Joiner.on(ItemUtil.PREFERENCE_DELIMITER).join(toStore.keySet());
			preferenceStore.putValue(prefKey, preferenceValue);
		} else {
			preferenceStore.setToDefault(prefKey);
		}
	}

	/**
	 * Clear all registered {@link IDifferenceFilter}.
	 */
	public void clear() {
		map.clear();
	}

	/**
	 * Wrapper of {@link IDifferenceFilter} used to keep track of the initial value of
	 * {@link IDifferenceFilter#defaultSelected()} to be able to restore it.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private static class DifferenceFilterDefaultConfiguration {

		/** Base {@link IDifferenceFilter} */
		private IDifferenceFilter filter;

		/** Initial value of {@link IDifferenceFilter#defaultSelected()} during first addition. */
		private boolean isDefaultSelectedInitialValue;

		/**
		 * Constructor.
		 * 
		 * @param filter
		 *            Base filter
		 * @param isByDefaultSelected
		 *            Initial value of {@link IDifferenceFilter#defaultSelected()} during first addition.
		 */
		public DifferenceFilterDefaultConfiguration(IDifferenceFilter filter, boolean isByDefaultSelected) {
			super();
			this.filter = filter;
			this.isDefaultSelectedInitialValue = isByDefaultSelected;
		}

		/**
		 * @return Base filter.
		 */
		public IDifferenceFilter getFilter() {
			return filter;
		}

		/**
		 * @return Initial value of {@link IDifferenceFilter#defaultSelected()} during first addition.
		 */
		public boolean isDefaultSelectedInitialValue() {
			return isDefaultSelectedInitialValue;
		}

	}
}
