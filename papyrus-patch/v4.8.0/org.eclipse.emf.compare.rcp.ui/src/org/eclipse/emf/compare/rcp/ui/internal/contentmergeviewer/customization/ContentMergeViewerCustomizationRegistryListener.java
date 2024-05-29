/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.customization;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemContentProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProvider;

/**
 * The listener responsible for handling registration events regarding content merge viewer customizations.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class ContentMergeViewerCustomizationRegistryListener extends AbstractRegistryEventListener {

	/** The content customization tag of our extension point. */
	private static final String TAG_CONTENT_CUSTOMIZATION = "contentCustomization"; //$NON-NLS-1$

	/** The tree content customization tag of our extension point. */
	private static final String TAG_TREE_CONTENT_CUSTOMIZATION = "treeContentCustomization"; //$NON-NLS-1$

	/** The "contentProvider" attribute of the tree content customization tag. */
	private static final String ATTRIBUTE_CONTENTPROVIDER = "contentProvider"; //$NON-NLS-1$

	/** The "mergeViewerItemProvider" attribute of the tree content customization tag. */
	private static final String ATTRIBUTE_MERGEVIEWERITEMPROVIDER = "mergeViewerItemProvider"; //$NON-NLS-1$

	/** The "context" attribute of the tree content customization tag. */
	private static final String ATTRIBUTE_CONTEXT = "context"; //$NON-NLS-1$

	/** The "ranking" attribute of the tree content customization tag. */
	private static final String ATTRIBUTE_RANKING = "ranking"; //$NON-NLS-1$

	/** The actual registry this listener will alter. */
	private final ContentMergeViewerCustomizationRegistry registry;

	/**
	 * Initialize a registry event listener for our handlers.
	 * 
	 * @param pluginID
	 *            ID of the plugin contributing the extension point to monitor.
	 * @param extensionPointID
	 *            Actual id of the extension point to monitor.
	 * @param log
	 *            Log in which errors/warning should be logged.
	 * @param contentMergeViewerCustomizationRegistry
	 *            The actual store of handlers this registry will alter.
	 */
	public ContentMergeViewerCustomizationRegistryListener(String pluginID, String extensionPointID, ILog log,
			ContentMergeViewerCustomizationRegistry contentMergeViewerCustomizationRegistry) {
		super(pluginID, extensionPointID, log);
		this.registry = contentMergeViewerCustomizationRegistry;
	}

	@Override
	protected boolean addedValid(IConfigurationElement element) {
		if (element.getName().equals(TAG_CONTENT_CUSTOMIZATION)) {
			final String mergeViewerItemProvider = element.getAttribute(ATTRIBUTE_MERGEVIEWERITEMPROVIDER);

			final String context = element.getAttribute(ATTRIBUTE_CONTEXT);

			final String rankingStr = element.getAttribute(ATTRIBUTE_RANKING);
			int ranking = -1;
			try {
				ranking = Integer.parseInt(rankingStr);
			} catch (NumberFormatException e) {
				log(IStatus.ERROR, element, EMFCompareRCPUIMessages.getString(
						"ContentCustomizationRegistry.invalidRanking", mergeViewerItemProvider, rankingStr)); //$NON-NLS-1$
			}

			final ContentMergeViewerCustomizationDescriptor<IMergeViewerItemProvider> descriptor = new ContentMergeViewerCustomizationDescriptor<IMergeViewerItemProvider>(
					element, mergeViewerItemProvider, ATTRIBUTE_MERGEVIEWERITEMPROVIDER, context,
					ATTRIBUTE_CONTEXT, ranking);
			registry.addCustomization(mergeViewerItemProvider, descriptor);
			return true;
		}
		if (element.getName().equals(TAG_TREE_CONTENT_CUSTOMIZATION)) {
			final String contentProvider = element.getAttribute(ATTRIBUTE_CONTENTPROVIDER);

			final String context = element.getAttribute(ATTRIBUTE_CONTEXT);

			final String rankingStr = element.getAttribute(ATTRIBUTE_RANKING);
			int ranking = -1;
			try {
				ranking = Integer.parseInt(rankingStr);
			} catch (NumberFormatException e) {
				log(IStatus.ERROR, element, EMFCompareRCPUIMessages.getString(
						"ContentCustomizationRegistry.invalidRanking", contentProvider, rankingStr)); //$NON-NLS-1$
			}

			final ContentMergeViewerCustomizationDescriptor<IMergeViewerItemContentProvider> descriptor = new ContentMergeViewerCustomizationDescriptor<IMergeViewerItemContentProvider>(
					element, contentProvider, ATTRIBUTE_CONTENTPROVIDER, context, ATTRIBUTE_CONTEXT, ranking);
			registry.addTreeCustomization(contentProvider, descriptor);
			return true;
		}
		return false;
	}

	/**
	 * Returns the attribute with the {@code attributeName} from the given {@code element}.
	 * 
	 * @param element
	 *            the {@link IConfigurationElement}.
	 * @param attributeName
	 *            the name of the attribute which's value is to be determined.
	 * @param defaultResult
	 *            the result of this method if the attribute does not exist.
	 * @return The determined value of the attribute if it exists, {@code defaultResult} otherwise.
	 */
	protected String getAttribute(IConfigurationElement element, String attributeName, String defaultResult) {
		String attribute = element.getAttribute(attributeName);
		if (attribute != null) {
			return attribute;
		}
		return defaultResult;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#removedValid(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean removedValid(IConfigurationElement element) {
		final String className;
		if (element.getName().equals(TAG_CONTENT_CUSTOMIZATION)) {
			className = element.getAttribute(ATTRIBUTE_MERGEVIEWERITEMPROVIDER);
		} else {
			className = element.getAttribute(ATTRIBUTE_CONTENTPROVIDER);
		}
		registry.removeDescriptor(className);
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener#validateExtensionElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean validateExtensionElement(IConfigurationElement element) {
		// Don't work twice as much, validate as we add.
		// Removing cannot fail.
		return true;
	}
}
