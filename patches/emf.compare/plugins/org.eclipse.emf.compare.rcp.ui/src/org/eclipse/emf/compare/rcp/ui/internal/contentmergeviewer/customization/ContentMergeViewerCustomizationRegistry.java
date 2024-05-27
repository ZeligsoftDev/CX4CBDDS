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

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.IContextTester;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemContentProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IOptionalProvider;

/**
 * The registry responsible for managing the content merge viewer customizations.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class ContentMergeViewerCustomizationRegistry {
	/** Keeps track of the extensions providing {@link IMergeViewerItemProvider}s. */
	private final Map<String, ContentMergeViewerCustomizationDescriptor<IMergeViewerItemProvider>> registeredDescriptors;

	/** Keeps track of the extensions providing {@link IMergeViewerItemContentProvider}s. */
	private final Map<String, ContentMergeViewerCustomizationDescriptor<IMergeViewerItemContentProvider>> registeredTreeDescriptors;

	/**
	 * Constructs and initialized this registry.
	 */
	public ContentMergeViewerCustomizationRegistry() {
		registeredDescriptors = new LinkedHashMap<String, ContentMergeViewerCustomizationDescriptor<IMergeViewerItemProvider>>();
		registeredTreeDescriptors = new LinkedHashMap<String, ContentMergeViewerCustomizationDescriptor<IMergeViewerItemContentProvider>>();
	}

	/**
	 * Adds the given {@link ContentMergeViewerCustomizationDescriptor} to this registry, using the given
	 * {@code className} as the identifier.
	 * 
	 * @param className
	 *            The identifier for the given {@link ContentMergeViewerCustomizationDescriptor}.
	 * @param descriptor
	 *            The {@link ContentMergeViewerCustomizationDescriptor} which is to be added to this registry.
	 */
	public void addCustomization(String className,
			ContentMergeViewerCustomizationDescriptor<IMergeViewerItemProvider> descriptor) {
		registeredDescriptors.put(className, descriptor);
	}

	/**
	 * Adds the given {@link ContentMergeViewerCustomizationDescriptor} to this registry, using the given
	 * {@code className} as the identifier.
	 * 
	 * @param className
	 *            The identifier for the given {@link ContentMergeViewerCustomizationDescriptor}.
	 * @param descriptor
	 *            The {@link ContentMergeViewerCustomizationDescriptor} which is to be added to this registry.
	 */
	public void addTreeCustomization(String className,
			ContentMergeViewerCustomizationDescriptor<IMergeViewerItemContentProvider> descriptor) {
		registeredTreeDescriptors.put(className, descriptor);
	}

	/**
	 * Removes the {@link ContentMergeViewerCustomizationDescriptor} and its managed
	 * {@link IDependencyProvider} identified by the given {@code className} from this registry.
	 * 
	 * @param className
	 *            Identifier of the provider we are to remove from this registry.
	 */
	public void removeDescriptor(String className) {
		registeredDescriptors.remove(className);
		registeredTreeDescriptors.remove(className);
	}

	/** Clears out all registered listeners from this registry. */
	public void clear() {
		registeredDescriptors.clear();
		registeredTreeDescriptors.clear();
	}

	private <T extends IOptionalProvider> T getBestFittingProvider(
			Collection<ContentMergeViewerCustomizationDescriptor<T>> descriptors, Comparison comparison,
			Object object) {
		ContentMergeViewerCustomizationDescriptor<T> bestDescriptor = null;
		final Map<Object, Object> context = createContext(comparison);

		for (ContentMergeViewerCustomizationDescriptor<T> descriptor : descriptors) {
			IContextTester contextTester = descriptor.getContextTester();
			// check context
			if (contextTester != null && !contextTester.apply(context)) {
				continue;
			}
			// check ranking
			if (bestDescriptor != null && bestDescriptor.getRanking() > descriptor.getRanking()) {
				continue;
			}
			// check provider
			if (descriptor.getProvider().canHandle(object)) {
				bestDescriptor = descriptor;
			}
		}

		if (bestDescriptor != null) {
			return bestDescriptor.getProvider();
		}

		return null;
	}

	/**
	 * Creates the context for the {@link IContextTester}s.
	 * 
	 * @param comparison
	 *            the {@link Comparison}.
	 * @return the created context.
	 */
	private Map<Object, Object> createContext(Comparison comparison) {
		final Map<Object, Object> context = new HashMap<Object, Object>();
		context.put(IContextTester.CTX_COMPARISON, comparison);
		return context;
	}

	/**
	 * Returns the best fitting {@link IMergeViewerItemProvider}.
	 * 
	 * @param comparison
	 *            the {@link Comparison} is used to check the context.
	 * @param object
	 *            the {@link Object} for which the {@link IMergeViewerItemProvider} is responsible.
	 * @return the determined {@link IMergeViewerItemProvider} if one exists, {@code null} otherwise.
	 */
	public IMergeViewerItemProvider getBestFittingMergeViewerItemProvider(Comparison comparison,
			Object object) {
		return getBestFittingProvider(registeredDescriptors.values(), comparison, object);
	}

	/**
	 * Returns the best fitting {@link IMergeViewerItemContentProvider}.
	 * 
	 * @param comparison
	 *            the {@link Comparison} is used to check the context.
	 * @param object
	 *            the {@link Object} for which the {@link IMergeViewerItemContentProvider} is responsible.
	 * @return the determined {@link IMergeViewerItemContentProvider} if one exists, {@code null} otherwise.
	 */
	public IMergeViewerItemContentProvider getBestFittingMergeViewerItemContentProvider(Comparison comparison,
			Object object) {
		return getBestFittingProvider(registeredTreeDescriptors.values(), comparison, object);
	}
}
