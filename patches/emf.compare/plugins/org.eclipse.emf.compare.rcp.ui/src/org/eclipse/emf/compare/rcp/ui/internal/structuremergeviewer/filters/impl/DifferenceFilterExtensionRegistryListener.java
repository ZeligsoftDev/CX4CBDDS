/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDeactivableDiffFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;

/**
 * Utility class to listen to the {@link IDifferenceFilter.Registry}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class DifferenceFilterExtensionRegistryListener extends AbstractRegistryEventListener {

	/** TAG_FILTER_ACTION. */
	static final String TAG_FILTER_ACTION = "filter"; //$NON-NLS-1$

	/** ATT_CLASS. */
	static final String ATT_CLASS = "class"; //$NON-NLS-1$

	/** ATT_LABEL. */
	static final String ATT_LABEL = "label"; //$NON-NLS-1$

	/** ATT_LABEL. */
	static final String ATT_DESCRIPTION = "description"; //$NON-NLS-1$

	/** ATT_ACTIVE. */
	static final String ATT_ACTIVE = "activeByDefault"; //$NON-NLS-1$

	/** The DifferenceFilterManager in charge of managing filters. */
	private final DifferenceFilterManager filterRegistry;

	/**
	 * Default constructor.
	 * 
	 * @param pluginID
	 *            The namespace of the extension point to be monitored.
	 * @param extensionPointID
	 *            The extension point ID to be monitored.
	 * @param log
	 *            The log object to be used to log error and/or warning.
	 * @param filterManager
	 *            The {@link DifferenceFilterManager} used to add/remove filter.
	 */
	public DifferenceFilterExtensionRegistryListener(String pluginID, String extensionPointID, ILog log,
			DifferenceFilterManager filterManager) {
		super(pluginID, extensionPointID, log);
		this.filterRegistry = filterManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#validateExtensionElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean validateExtensionElement(IConfigurationElement element) {
		final boolean valid;
		if (element.getName().equals(TAG_FILTER_ACTION)) {
			if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
				valid = false;
			} else if (element.getAttribute(ATT_LABEL) == null) {
				logMissingAttribute(element, ATT_LABEL);
				valid = false;
			} else if (element.getAttribute(ATT_ACTIVE) == null) {
				logMissingAttribute(element, ATT_ACTIVE);
				valid = false;
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
		try {
			IDifferenceFilter filter = (IDifferenceFilter)element.createExecutableExtension(ATT_CLASS);
			filter.setLabel(element.getAttribute(ATT_LABEL));
			filter.setDescription(element.getAttribute(ATT_DESCRIPTION));
			if (Boolean.valueOf(element.getAttribute(ATT_ACTIVE)).booleanValue()) {
				filter.setDefaultSelected(true);
			} else {
				filter.setDefaultSelected(false);
			}
			if (filter instanceof IDeactivableDiffFilter) {
				((IDeactivableDiffFilter)filter).setActive(true);
			}
			IDifferenceFilter previous = filterRegistry.add(filter);
			if (previous != null) {
				log(IStatus.WARNING, element, "The filter '" + filter.getClass().getName() //$NON-NLS-1$
						+ "' is registered twice."); //$NON-NLS-1$
			}
		} catch (CoreException e) {
			log(element, e);
			return false;
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
		filterRegistry.remove(element.getAttribute(ATT_CLASS));
		return true;
	}
}
