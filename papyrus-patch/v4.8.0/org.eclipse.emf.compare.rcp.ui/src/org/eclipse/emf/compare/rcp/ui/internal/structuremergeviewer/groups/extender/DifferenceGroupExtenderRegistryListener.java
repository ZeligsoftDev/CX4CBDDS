/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.extender;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender;

/**
 * Utility class to listen to the
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor.Registry}
 * .
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class DifferenceGroupExtenderRegistryListener extends AbstractRegistryEventListener {

	/** TAG_GROUP_PROVIDER. */
	static final String TAG_GROUP_PROVIDER = "differenceGroupExtender"; //$NON-NLS-1$

	/** ATT_CLASS. */
	static final String ATT_CLASS = "class"; //$NON-NLS-1$

	/** The registry. */
	private final IDifferenceGroupExtender.Registry extendersRegistry;

	/**
	 * Default Constructor.
	 * 
	 * @param pluginID
	 *            The namespace of the extension point to be monitored.
	 * @param extensionPointID
	 *            The extension point ID to be monitored
	 * @param log
	 *            The log object to be used to log error and/or warning.
	 * @param registry
	 *            The registry to listen.
	 */
	public DifferenceGroupExtenderRegistryListener(String pluginID, String extensionPointID, ILog log,
			IDifferenceGroupExtender.Registry registry) {
		super(pluginID, extensionPointID, log);
		this.extendersRegistry = registry;
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
			IDifferenceGroupExtender extender = (IDifferenceGroupExtender)element
					.createExecutableExtension(ATT_CLASS);
			IDifferenceGroupExtender previous = extendersRegistry.add(extender);
			if (previous != null) {
				log(IStatus.WARNING, element, "The difference group extender '" //$NON-NLS-1$
						+ extender.getClass().getName() + "' is registered twice."); //$NON-NLS-1$
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
		extendersRegistry.remove(element.getAttribute(ATT_CLASS));
		return true;
	}
}
