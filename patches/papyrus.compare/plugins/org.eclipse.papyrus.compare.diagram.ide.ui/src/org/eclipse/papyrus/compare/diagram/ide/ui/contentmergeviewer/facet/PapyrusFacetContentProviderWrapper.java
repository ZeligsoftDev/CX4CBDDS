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
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Collections2.filter;
import static org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet.FacetUtil.UN_WRAP;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Wraps the Papyrus Facet content provider in an EMF {@link ItemProviderAdapter}.
 * 
 * @author Stefan Dirix
 */
public class PapyrusFacetContentProviderWrapper extends ItemProviderAdapter implements ITreeItemContentProvider {

	/**
	 * The Papyrus Facet Content Provider.
	 */
	private SemanticUMLContentProvider facetContentProvider;

	/**
	 * The ResourceSet.
	 */
	private ResourceSet resourceSet;

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}.
	 * @param resourceSet
	 *            the {@ResourceSet} for Papyrus Facet.
	 */
	public PapyrusFacetContentProviderWrapper(AdapterFactory adapterFactory, ResourceSet resourceSet) {
		this(adapterFactory, resourceSet, new SemanticUMLContentProvider(resourceSet));
	}

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}.
	 * @param facetContentProvider
	 *            the content provider to which to delegate.
	 * @param resourceSet
	 *            the {@ResourceSet} for Papyrus Facet.
	 */
	public PapyrusFacetContentProviderWrapper(AdapterFactory adapterFactory, ResourceSet resourceSet,
			SemanticUMLContentProvider facetContentProvider) {
		super(adapterFactory);
		this.facetContentProvider = facetContentProvider;
		this.resourceSet = resourceSet;
	}

	@Override
	public Collection<?> getElements(Object object) {
		// The SemanticUMLContentProvider has problems determining the root elements. Papyrus usually
		// uses its own ResourceSet implementation and uses its UMLModel to determine the root elements. In
		// other types of ResourceSets it tries to determine them manually. This fails here since the URIs of
		// our UML model can for example contain git fragments. This implementation is similar to the one if
		// the SemanticUMLContentProvider but fixed for our use cases.
		EObject rootElement = getRootElement();

		List<EObject> rootElements = new LinkedList<EObject>();
		for (Resource resource : resourceSet.getResources()) {
			if (MySemanticUMLContentProvider.isUMLModel(resource, rootElement)) {
				for (EObject rootEObject : resource.getContents()) {
					if (Element.class.isInstance(rootEObject)) {
						rootElements.add(rootEObject);
					}
				}
			}
		}
		return rootElements;
	}

	/**
	 * Same behavior as in "getRoots" of the SemanticUMLContentProvider but fixed for our use cases.
	 * 
	 * @return the determined root element.
	 */
	private EObject getRootElement() {
		EObject rootElement = null;
		EObject rootProfile = null;
		for (Resource resource : resourceSet.getResources()) {
			if (MySemanticUMLContentProvider.isUMLResource(resource) && !resource.getContents().isEmpty()) {
				EObject resourceElement = resource.getContents().get(0);
				if (Profile.class.isInstance(resourceElement)) {
					if (rootProfile == null) {
						rootProfile = resourceElement;
					}
				} else if (Element.class.isInstance(resourceElement)) {
					if (rootElement == null) {
						rootElement = resourceElement;
					}
				}
			}
		}
		if (rootElement != null) {
			return rootElement;
		}
		return rootProfile;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		// we need to remove duplicates since the facet mechanism sometimes introduces them
		// additionally we also need to remove diagram elements
		return filter(removeDuplicates(unwrapFacet(facetContentProvider.getChildren(object))),
				not(instanceOf(Diagram.class)));
	}

	@Override
	public boolean hasChildren(Object object) {
		return facetContentProvider.hasChildren(object);
	}

	@Override
	public Object getParent(Object object) {
		return UN_WRAP.apply(facetContentProvider.getParent(object));
	}

	/**
	 * Removed duplicates from the given objects.
	 * 
	 * @param objects
	 *            the objects.
	 * @return the objects in same order but with duplicates removed.
	 */
	private List<Object> removeDuplicates(Iterable<Object> objects) {
		return ImmutableSet.copyOf(objects).asList();
	}

	/**
	 * The Papyrus ModelExplorer tree consists of special Papyrus objects. To use them in EMFCompare they have
	 * to be unwrapped.
	 * 
	 * @param elements
	 *            The elements to unwrap
	 * @return The collection of unwrapped objects.
	 */
	private List<Object> unwrapFacet(Object[] elements) {
		return Lists.newArrayList(Iterables.transform(Arrays.asList(elements), UN_WRAP));
	}

	@Override
	public void dispose() {
		facetContentProvider.dispose();
		super.dispose();
	}

	/**
	 * Subclassed to gain access to protected static method.
	 */
	private static class MySemanticUMLContentProvider extends SemanticUMLContentProvider {
		/**
		 * Copied from SemanticUMLContentProvider but calling our implementation of isUMLResource.
		 * 
		 * @param resource
		 *            the {@link Resource}.
		 * @param rootElement
		 *            the {@link EObject}.
		 * @return whether the given resource is an UMLModel resource.
		 */
		public static boolean isUMLModel(Resource resource, EObject rootElement) {
			if (!isUMLResource(resource)) {
				return false;
			}

			for (URI uri : excludedModels) {
				if (uri.equals(resource.getURI())) {
					return false;
				}
			}

			for (EObject rootObject : resource.getContents()) {
				if (rootObject.eIsProxy()) {
					continue;
				}

				if (rootObject.eContainer() != null
						|| rootObject instanceof Profile && !(rootElement instanceof Profile)) {
					return false;
				}
			}

			return true;
		}

		/**
		 * Copied from SemanticUMLContentProvider and fixed for our use cases.
		 * 
		 * @param resource
		 *            the {@link Resource}.
		 * @return whether the given resource is an {@link UMLResource}.
		 */
		public static boolean isUMLResource(Resource resource) {
			if (resource == null) {
				return false;
			}

			if (resource instanceof UMLResource) {
				return true;
			}

			URI uri = resource.getURI();
			if (uri == null) {
				return false;
			}
			final String extension = uri.fileExtension();
			// check beginning of file extension instead of equals
			return extension != null && extension.startsWith(UMLResource.FILE_EXTENSION);
		}
	}

}
