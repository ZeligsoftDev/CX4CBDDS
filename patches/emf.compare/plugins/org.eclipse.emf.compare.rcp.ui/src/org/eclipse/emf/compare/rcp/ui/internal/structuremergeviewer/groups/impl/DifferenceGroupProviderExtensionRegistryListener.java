/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.ComparisonType;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;

/**
 * Utility class to listen to the {@link IDifferenceGroupProvider.Descriptor.Registry}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class DifferenceGroupProviderExtensionRegistryListener extends AbstractRegistryEventListener {

	/** Default value for the rank attribute if not specified. */
	private static final int DEFAULT_RANK_VALUE = 0;

	/** TAG_GROUP_PROVIDER. */
	static final String TAG_GROUP_PROVIDER = "group"; //$NON-NLS-1$

	/** ATT_LABEL. */
	static final String ATT_LABEL = "label"; //$NON-NLS-1$

	/** ATT_DESCRIPTION. */
	static final String ATT_DESCRIPTION = "description"; //$NON-NLS-1$

	/** ATT_COMPARISON_TYPE. */
	static final String ATT_COMPARISON_TYPE = "type"; //$NON-NLS-1$

	/** ATT_RANK. */
	static final String ATT_RANK = "rank"; //$NON-NLS-1$

	/** ATT_CLASS. */
	static final String ATT_CLASS = "class"; //$NON-NLS-1$

	/** The IDifferenceGroupProvider.Descriptor.Registry to listen. */
	private final IItemRegistry<IDifferenceGroupProvider.Descriptor> groupProviderRegistry;

	/**
	 * Default constructor.
	 * 
	 * @param pluginID
	 *            The namespace of the extension point to be monitored.
	 * @param extensionPointID
	 *            The extension point ID to be monitored.
	 * @param log
	 *            The log object to be used to log error and/or warning.
	 * @param registry
	 *            The {@link IDifferenceGroupProvider.Descriptor.Registry} to listen.
	 */
	public DifferenceGroupProviderExtensionRegistryListener(String pluginID, String extensionPointID,
			ILog log, IItemRegistry<IDifferenceGroupProvider.Descriptor> registry) {
		super(pluginID, extensionPointID, log);
		this.groupProviderRegistry = registry;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#validateExtensionElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean validateExtensionElement(IConfigurationElement element) {
		final boolean valid;
		if (element.getName().equals(TAG_GROUP_PROVIDER)) {
			if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
				valid = false;
			} else if (element.getAttribute(ATT_LABEL) == null) {
				logMissingAttribute(element, ATT_LABEL);
				valid = false;
			} else if (element.getAttribute(ATT_RANK) != null) {
				try {
					Integer.valueOf(element.getAttribute(ATT_RANK));
				} catch (NumberFormatException e) {
					log(element, e);
					return false;
				}
				valid = true;
			} else if (element.getAttribute(ATT_COMPARISON_TYPE) != null) {
				try {
					ComparisonType.valueOf(element.getAttribute(ATT_COMPARISON_TYPE));
					valid = true;
				} catch (IllegalArgumentException e) {
					log(element, e);
					return false;
				}
			} else {
				valid = true;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#addedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean addedValid(IConfigurationElement element) {
		String rankValue = element.getAttribute(ATT_RANK);
		final int rank;
		if (rankValue == null) {
			rank = DEFAULT_RANK_VALUE;
		} else {
			rank = Integer.valueOf(rankValue).intValue();
		}
		String typeAttribute = element.getAttribute(ATT_COMPARISON_TYPE);
		final ComparisonType type;
		if (typeAttribute != null) {
			type = ComparisonType.valueOf(typeAttribute);
		} else {
			type = ComparisonType.BOTH;
		}
		String label = element.getAttribute(ATT_LABEL);
		String description = element.getAttribute(ATT_DESCRIPTION);
		DifferenceGroupDescriptorWrapper itemDescriptor = new DifferenceGroupDescriptorWrapper(label,
				description, element, rank, type);

		IItemDescriptor<Descriptor> previous = groupProviderRegistry.add(itemDescriptor);
		if (previous != null) {
			log(IStatus.WARNING, element, "The group provider descriptor'" + element.getAttribute(ATT_CLASS) //$NON-NLS-1$
					+ "' is registered twice."); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#removedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean removedValid(IConfigurationElement element) {
		groupProviderRegistry.remove(element.getAttribute(ATT_CLASS));
		return true;
	}
}
