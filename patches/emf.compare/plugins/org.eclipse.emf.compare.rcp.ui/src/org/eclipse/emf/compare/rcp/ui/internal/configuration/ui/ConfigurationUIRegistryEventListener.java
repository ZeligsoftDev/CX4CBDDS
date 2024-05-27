/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.ui;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;

/**
 * Registry event listener used for {@link IConfiguratorUIRegistry}
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class ConfigurationUIRegistryEventListener extends AbstractRegistryEventListener {

	private static final String ELEMENT_TAG = "configurator"; //$NON-NLS-1$

	private static final String ITEM_TO_CONFIGURE_ATTR = "itemToConfigure"; //$NON-NLS-1$

	private static final String UI_PROVIDER_ATTR = "uiProvider"; //$NON-NLS-1$

	/** Storage for {@link IConfiguratorUIRegistry}. */
	private final Map<String, IConfigurationUIFactory> registry;

	/** Mirror registry holding item to configure. */
	private final IItemRegistry<?> registryOfConfiguredItem;

	/**
	 * Constructor.
	 * 
	 * @param namespace
	 *            The namespace of the extension point to be monitored.
	 * @param extensionPointID
	 *            The extension point ID to be monitored
	 * @param log
	 *            The log object to be used to log error and/or warning.
	 * @param registry
	 *            that will be filled
	 * @param registryOfConfiguredItem
	 *            Mirror registry holding item to configure.
	 */
	public ConfigurationUIRegistryEventListener(String namespace, String extensionPointID, ILog log,
			Map<String, IConfigurationUIFactory> registry, IItemRegistry<?> registryOfConfiguredItem) {
		super(namespace, extensionPointID, log);
		this.registry = registry;
		this.registryOfConfiguredItem = registryOfConfiguredItem;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#validateExtensionElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean validateExtensionElement(IConfigurationElement element) {
		final boolean ret;
		if (ELEMENT_TAG.equals(element.getName())) {
			if (element.getAttribute(ITEM_TO_CONFIGURE_ATTR) == null) {
				logMissingAttribute(element, ITEM_TO_CONFIGURE_ATTR);
				ret = false;
			} else if (element.getAttribute(ITEM_TO_CONFIGURE_ATTR) != null) {
				Object itemToConfigure = registryOfConfiguredItem
						.getItemDescriptor(element.getAttribute(ITEM_TO_CONFIGURE_ATTR));
				if (itemToConfigure == null) {
					log(IStatus.WARNING, element, EMFCompareRCPUIMessages
							.getString("ConfigurationUIRegistryEventListener.incorrectIdParameter.message")); //$NON-NLS-1$
					ret = false;
				} else {
					ret = true;
				}
			} else if (element.getAttribute(UI_PROVIDER_ATTR) == null) {
				logMissingAttribute(element, UI_PROVIDER_ATTR);
				ret = false;
			} else {
				ret = true;
			}
		} else {
			ret = false;
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#addedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean addedValid(IConfigurationElement element) {
		try {
			Object configurator = element.createExecutableExtension(UI_PROVIDER_ATTR);
			if (configurator instanceof IConfigurationUIFactory) {
				IConfigurationUIFactory configurationFactory = (IConfigurationUIFactory)configurator;
				String itemToConfigureID = element.getAttribute(ITEM_TO_CONFIGURE_ATTR);
				IConfigurationUIFactory previous = registry.put(itemToConfigureID, configurationFactory);
				if (previous != null) {
					log(IStatus.WARNING, element, EMFCompareRCPUIMessages.getString("duplicate.extension", //$NON-NLS-1$
							registry.getClass().getName()));
				}
			} else {
				log(IStatus.WARNING, element, EMFCompareRCPUIMessages.getString(
						"ConfigurationUIRegistryEventListener.incorrectConfiguratorParameter.message")); //$NON-NLS-1$
			}
		} catch (CoreException e) {
			log(element, e);
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
		return registry.remove(element.getAttribute(ITEM_TO_CONFIGURE_ATTR)) != null;
	}

}
