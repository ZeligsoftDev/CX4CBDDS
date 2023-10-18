/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.export;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.plugin.ValidityPlugin;

/**
 * 
 * This listener will allow us to be aware of contribution changes against the
 * exporter extension point.
 */
public class ValidityExporterListener implements IRegistryEventListener
{
	/** Name of the extension point to parse for extensions. */
	public static final String VALIDITY_EXPORTER_EXTENSION_POINT = ValidityPlugin.PLUGIN_ID + "." + ValidityPlugin.VALIDITY_EXPORTER_PPID; //$NON-NLS-1$

	/** Name of the extension point's "EXPORTEXTENSION" tag. */
	private static final @NonNull String VALIDITY_EXPORTER_TAG_EXTENSION = "exporter"; //$NON-NLS-1$
	private static final @NonNull String VALIDITY_EXPORTER_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	private static final @NonNull String VALIDITY_EXPORTER_NAME_ATTRIBUTE = "name"; //$NON-NLS-1$
	private static final @NonNull String VALIDITY_EXPORTER_TYPE_ATTRIBUTE = "type"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#added(org.eclipse.core.runtime.IExtension[])
	 */
	public void added(IExtension[] extensions) {
		for (IExtension extension : extensions) {
			parseExtension(extension);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#added(org.eclipse.core.runtime.IExtensionPoint[])
	 */
	public void added(IExtensionPoint[] extensionPoints) {
		// no need to listen to this event
	}

	/**
	 * Logs the error in the desktop log using the provided text and the
	 * information in the configuration element.
	 */
	protected void logError(IConfigurationElement element, String text) {
		IExtension extension = element.getDeclaringExtension();
		System.err.println("Plugin " + extension.getContributor().getName() + ", extension " + extension.getExtensionPointUniqueIdentifier());
		System.err.println(text);
	}

	/**
	 * Logs a very common registry error when a required attribute is missing.
	 */
	protected void logMissingAttribute(IConfigurationElement element, String attributeName) {
		logError(element, "The required attribute '" + attributeName + "' not defined");
	}

	/**
	 * Parses a single extension contribution.
	 * 
	 * @param extension
	 *            Parses the given extension and adds its contribution to the
	 *            registry.
	 */
	private void parseExtension(IExtension extension) {
		final IConfigurationElement[] configElements = extension.getConfigurationElements();
		for (IConfigurationElement elem : configElements) {
			String name = elem.getName();
			if (VALIDITY_EXPORTER_TAG_EXTENSION.equals(name)) {
				String exporterType = elem.getAttribute(VALIDITY_EXPORTER_TYPE_ATTRIBUTE);
				String exporterName = elem.getAttribute(VALIDITY_EXPORTER_NAME_ATTRIBUTE);
				if (exporterType == null) {
					logMissingAttribute(elem, VALIDITY_EXPORTER_TYPE_ATTRIBUTE);
				}
				else if (exporterName == null) {
					logMissingAttribute(elem, VALIDITY_EXPORTER_NAME_ATTRIBUTE);
				}
				else {
					ValidityExporterRegistry.INSTANCE.addExporter(new ValidityExporterDescriptor(elem, VALIDITY_EXPORTER_CLASS_ATTRIBUTE, exporterType, exporterName));
				}
			}
		}
	}

	/**
	 * Though this listener reacts to the extension point changes, there could
	 * have been contributions before it's been registered. This will parse
	 * these initial contributions.
	 */
	public void parseInitialContributions() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(VALIDITY_EXPORTER_EXTENSION_POINT);
		for (IExtension extension : extensionPoint.getExtensions()) {
			parseExtension(extension);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#removed(org.eclipse.core.runtime.IExtension[])
	 */
	public void removed(IExtension[] extensions) {
		for (IExtension extension : extensions) {
			final IConfigurationElement[] configElements = extension.getConfigurationElements();
			for (IConfigurationElement elem : configElements) {
				String name = elem.getName();
				if (VALIDITY_EXPORTER_TAG_EXTENSION.equals(name)) {
					String exporterType = elem.getAttribute(VALIDITY_EXPORTER_TYPE_ATTRIBUTE);
					if (exporterType == null) {
						logMissingAttribute(elem, VALIDITY_EXPORTER_TYPE_ATTRIBUTE);
					}
					else {
						ValidityExporterRegistry.INSTANCE.removeExtension(exporterType);
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IRegistryEventListener#removed(org.eclipse.core.runtime.IExtensionPoint[])
	 */
	public void removed(IExtensionPoint[] extensionPoints) {
		// no need to listen to this event
	}
}
