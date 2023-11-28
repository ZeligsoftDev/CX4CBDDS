/*******************************************************************************
 * Copyright (c) 2016, 2017 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *     Martin Fleck - bug 518957
 *     Philip Langer - Fix NPE
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * Couples the Papyrus Facet mechanism with the AdapterFactory approach of EMFCompare.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class PapyrusFacetContentProviderWrapperAdapterFactory extends UMLItemProviderAdapterFactory {

	/**
	 * Collects and disposes associated adapters.
	 */
	private Disposable disposable = new Disposable();

	/**
	 * Associates resource sets with their semantic content providers.
	 */
	private final Map<ResourceSet, SemanticUMLContentProvider> semanticUMLContentProviders = new HashMap<>();

	/**
	 * Constructor.
	 */
	public PapyrusFacetContentProviderWrapperAdapterFactory() {
		super();
		// Only support content types
		supportedTypes.clear();
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
	}

	@Override
	public Adapter createAdapter(Notifier target) {
		ResourceSet resourceSet = getResourceSet(target);
		if (resourceSet != null) {
			SemanticUMLContentProvider semanticUMLContentProvider = semanticUMLContentProviders
					.get(resourceSet);
			if (semanticUMLContentProvider == null) {
				semanticUMLContentProvider = new SemanticUMLContentProvider(resourceSet);
				semanticUMLContentProviders.put(resourceSet, semanticUMLContentProvider);
			}
			return new PapyrusFacetContentProviderWrapper(this, resourceSet, semanticUMLContentProvider);
		}
		return super.createAdapter(target);
	}

	/**
	 * Determines the {@link ResourceSet} of the given {@code target}.
	 * 
	 * @param target
	 *            The {@Notifier} for which a {@link ResourceSet} is to be determined.
	 * @return The {@link ResourceSet} for the given {@code target} if there is one, {@code null} otherwise.
	 */
	private ResourceSet getResourceSet(Notifier target) {
		if (target instanceof EObject) {
			EObject object = (EObject)target;
			Resource resource = object.eResource();
			if (resource != null) {
				return resource.getResourceSet();
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see NotationItemProviderAdapterFactory#dispose()
	 */
	@Override
	public void dispose() {
		disposable.dispose();
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see NotationItemProviderAdapterFactory#associate(Adapter adapter, Notifier target)
	 */
	@Override
	protected void associate(Adapter adapter, Notifier target) {
		super.associate(adapter, target);
		if (adapter != null) {
			disposable.add(adapter);
		}
	}
}
