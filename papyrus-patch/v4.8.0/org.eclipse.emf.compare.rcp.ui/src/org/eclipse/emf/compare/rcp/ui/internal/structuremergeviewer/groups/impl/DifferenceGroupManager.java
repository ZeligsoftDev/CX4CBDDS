/******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemUtil;
import org.eclipse.emf.compare.rcp.internal.tracer.TracingConstant;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.ComparisonType;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This manager can be used to modify EMF Compare UI behavior regarding groups.
 * <p>
 * This manager can override the rank of groups. For example, it can be used to define a default group that
 * will be used by EMF Compare UI.
 * </p>
 * <p>
 * This manager can define a synchronization behavior between a user selection of group in EMF Compare UI and
 * the default group that is used by EMF Compare UI.
 * </p>
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class DifferenceGroupManager {

	/** Predicate for 2-way {@link IDifferenceGroupProvider.Descriptor}. */
	private static final Predicate<IItemDescriptor<Descriptor>> TWO_WAY_FILTER = new Predicate<IItemDescriptor<Descriptor>>() {

		public boolean apply(IItemDescriptor<Descriptor> descriptor) {
			if (descriptor == null) {
				return false;
			}
			ComparisonType type = descriptor.getItem().getType();
			return type == ComparisonType.BOTH || type == ComparisonType.TWO_WAY;
		}
	};

	/** Predicate for 3-way {@link IDifferenceGroupProvider.Descriptor}. */
	private static final Predicate<IItemDescriptor<Descriptor>> THREE_WAY_FILTER = new Predicate<IItemDescriptor<Descriptor>>() {

		public boolean apply(IItemDescriptor<Descriptor> descriptor) {
			if (descriptor == null) {
				return false;
			}
			ComparisonType type = descriptor.getItem().getType();
			return type == ComparisonType.BOTH || type == ComparisonType.THREE_WAY;
		}
	};

	/** Ordered list of groups for two way comparison. */
	private static final String TWO_WAY_GROUP_RANKING = "org.eclipse.emf.compare.rcp.ui.groups.2way.ranking"; //$NON-NLS-1$

	/** Ordered list of groups for three way comparison. */
	private static final String THREE_WAY_GROUP_RANKING = "org.eclipse.emf.compare.rcp.ui.groups.3way.ranking"; //$NON-NLS-1$

	/** Registry of {@link IDifferenceGroupProvider.Descriptor}. */
	private final IItemRegistry<IDifferenceGroupProvider.Descriptor> registry;

	/** The {@link IPreferenceStore} holding the value for group preferences. */
	private final IPreferenceStore preferenceStore;

	/**
	 * Constructor.
	 * 
	 * @param registry
	 *            Registry of {@link IDifferenceGroupProvider.Descriptor}.
	 * @param preferenceStore
	 *            The {@link IPreferenceStore} holding the value for group preferences.
	 */
	public DifferenceGroupManager(IItemRegistry<IDifferenceGroupProvider.Descriptor> registry,
			IPreferenceStore preferenceStore) {
		this.registry = registry;
		this.preferenceStore = preferenceStore;
	}

	/**
	 * Gets the current value of the group ranking.
	 * 
	 * @param preferenceKey
	 *            Preference key use to retrieve the value in preferences.
	 * @param defaultOrder
	 *            The default ranking.
	 * @return A ordered {@link List} of {@link IItemDescriptor}.
	 */
	private List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> getCurrent(String preferenceKey,
			List<IItemDescriptor<Descriptor>> defaultOrder) {
		return getOrderedItems(defaultOrder, registry, preferenceKey);
	}

	/**
	 * Gets the current group order.
	 * 
	 * @param isThreeWay
	 *            True if three way comparison, false otherwise.
	 * @return Ordered {@link List} of {@link IDifferenceGroupProvider.Descriptor}.
	 */
	public List<IItemDescriptor<Descriptor>> getCurrentGroupRanking(boolean isThreeWay) {
		return getCurrent(getGroupPreferenceKey(isThreeWay), getDefaultRankingConfiguration(isThreeWay));
	}

	/**
	 * Gets the default groups order.
	 * 
	 * @param isThreeWay
	 *            True if three way comparison, false otherwise.
	 * @return Ordered {@link List} of {@link IDifferenceGroupProvider.Descriptor}.
	 */
	public List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> getDefaultRankingConfiguration(
			boolean isThreeWay) {
		final Iterable<IItemDescriptor<Descriptor>> groups;
		if (isThreeWay) {
			groups = Iterables.filter(registry.getItemDescriptors(), THREE_WAY_FILTER);
		} else {

			groups = Iterables.filter(registry.getItemDescriptors(), TWO_WAY_FILTER);
		}
		List<IItemDescriptor<Descriptor>> result = Lists.newArrayList(groups);
		Collections.sort(result);
		return result;
	}

	/**
	 * Gets the preference key for group ranking.
	 * 
	 * @param isThreeWay
	 *            True if three way comparison.
	 * @return They key of the group ranking preference for this type of comparison.
	 */
	private String getGroupPreferenceKey(boolean isThreeWay) {
		if (isThreeWay) {
			return THREE_WAY_GROUP_RANKING;
		} else {
			return TWO_WAY_GROUP_RANKING;
		}
	}

	/**
	 * Returns an ordered list of {@link IItemDescriptor}. The order of the list is either defined by the rank
	 * in the registry or from preference if the rank has been overloaded. If any descriptor has been added or
	 * removed since last modification of the preference, this method will merge the modification.
	 * 
	 * @param orderedDefaultDescriptor
	 *            List of ordered default {@link IItemDescriptor}.
	 * @param descriptorRegistry
	 *            Registry of descriptor.
	 * @param orderedItemPreferenceKey
	 *            Key in preferences where are stored the new order of descriptor
	 * @return Ordered list of descriptor.
	 * @param <T>
	 *            Descriptor type.
	 */
	private <T> List<IItemDescriptor<T>> getOrderedItems(List<IItemDescriptor<T>> orderedDefaultDescriptor,
			IItemRegistry<T> descriptorRegistry, String orderedItemPreferenceKey) {
		List<IItemDescriptor<T>> itemsDescriptor = ItemUtil.getItemsDescriptor(descriptorRegistry,
				EMFCompareRCPUIPlugin.PLUGIN_ID, orderedItemPreferenceKey);

		if (itemsDescriptor == null) {
			itemsDescriptor = orderedDefaultDescriptor;
		} else {
			HashSet<IItemDescriptor<T>> descriptorFromPrefSet = Sets.newLinkedHashSet(itemsDescriptor);
			HashSet<IItemDescriptor<T>> defaultDescriptorSet = Sets
					.newLinkedHashSet(orderedDefaultDescriptor);

			// Remove descriptor
			SetView<IItemDescriptor<T>> descriptorToRemove = Sets.difference(descriptorFromPrefSet,
					defaultDescriptorSet);
			Iterables.removeAll(itemsDescriptor, descriptorToRemove);

			// Add new descriptor
			SetView<IItemDescriptor<T>> descriptorToAdd = Sets.difference(defaultDescriptorSet,
					descriptorFromPrefSet);
			Iterables.addAll(itemsDescriptor, descriptorToAdd);

		}
		return itemsDescriptor;
	}

	/**
	 * Sets the ranking of Difference group provider.
	 * 
	 * @param descriptors
	 *            An ordered list of {@link IItemDescriptor}.
	 * @param isThreeWay
	 *            True if three way comparison.
	 */
	public void setCurrentGroupRanking(List<IItemDescriptor<Descriptor>> descriptors, boolean isThreeWay) {
		storeInPreferences(getGroupPreferenceKey(isThreeWay), descriptors,
				getDefaultRankingConfiguration(isThreeWay));

		// Trace preferences values
		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder builder = new StringBuilder();
			// Print each preferences
			builder.append("Preference ").append(getGroupPreferenceKey(isThreeWay)).append(":\n"); //$NON-NLS-1$ //$NON-NLS-2$
			String preferenceValue = preferenceStore.getString(getGroupPreferenceKey(isThreeWay));
			String[] groups = preferenceValue.split(ItemUtil.PREFERENCE_DELIMITER);
			for (int rank = 0; rank < groups.length; rank++) {
				builder.append(rank).append(". ").append(groups[rank]).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			builder.append("\n\n"); //$NON-NLS-1$
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.INFO, builder.toString());
		}
	}

	/**
	 * Stores the value into preferences.
	 * 
	 * @param preferenceKey
	 *            Key of the preference
	 * @param currentValue
	 *            Current value to store
	 * @param defaultConf
	 *            Default value
	 */
	private void storeInPreferences(String preferenceKey,
			List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> currentValue,
			List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> defaultConf) {
		if (currentValue != null && !currentValue.equals(defaultConf)) {
			Iterable<String> currentIDs = Iterables.transform(currentValue,
					new Function<IItemDescriptor<IDifferenceGroupProvider.Descriptor>, String>() {

						public String apply(IItemDescriptor<IDifferenceGroupProvider.Descriptor> arg0) {
							return arg0.getID();
						}
					});
			String preferenceValue = Joiner.on(ItemUtil.PREFERENCE_DELIMITER).join(currentIDs);
			preferenceStore.putValue(preferenceKey, preferenceValue);
		} else {
			preferenceStore.setToDefault(preferenceKey);
		}
	}

}
