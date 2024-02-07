/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.all;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.merge.ResourceChangeAdapter;
import org.eclipse.emf.compare.merge.ResourceChangeAdapter.IResourceChangeParticipant;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil;

/**
 * Implementation of {@link IResourceChangeParticipant} dedicated to papyrus, which makes sure that all
 * papyrus resources (di, notation, uml, ...) are deleted at the same time.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public final class PapyrusResourceChangeParticipant implements IResourceChangeParticipant {

	/**
	 * The ResourceChangeAdapter.
	 */
	private final ResourceChangeAdapter resourceChangeAdapter;

	/**
	 * Constructor.
	 * 
	 * @param adapter
	 *            The adapter, must not be <code>null</code>
	 */
	public PapyrusResourceChangeParticipant(ResourceChangeAdapter adapter) {
		this.resourceChangeAdapter = checkNotNull(adapter);
	}

	/**
	 * This participant is interested in all papyrus resources.
	 * 
	 * @param r
	 *            The resource
	 * @return <code>true</code> if r is a papyrus resource.
	 */
	public boolean interestedIn(Resource r) {
		return ModelExtensionUtil.getRegisteredFileExtensions().contains(r.getURI().fileExtension());
	}

	/**
	 * The URIs of the resources associated to a given resource are those with the same URI but a different
	 * file extension.
	 * 
	 * @param r
	 *            The resource
	 * @return a collection of URI, never <code>null</code> but possibly empty.
	 */
	public Collection<URI> associatedResourceURIs(Resource r) {
		URI trimmedURI = r.getURI().trimFileExtension();
		List<URI> result = Lists.newArrayList();
		for (String fileExtension : ModelExtensionUtil.getRegisteredFileExtensions()) {
			result.add(trimmedURI.appendFileExtension(fileExtension));
		}
		return result;
	}

	/**
	 * The resources associated to a given resource are those with the same URI but a different file
	 * extension.
	 * 
	 * @param r
	 *            The resource
	 * @return a collection of resources, never <code>null</code> but possibly empty.
	 */
	protected Collection<Resource> associatedResources(Resource r) {
		URI trimmedURI = r.getURI().trimFileExtension();
		List<Resource> result = Lists.newArrayList();
		for (String fileExtension : ModelExtensionUtil.getRegisteredFileExtensions()) {
			Resource other = r.getResourceSet().getResource(trimmedURI.appendFileExtension(fileExtension),
					false);
			if (other != null && other != r) {
				result.add(other);
			}
		}
		return result;
	}

	/**
	 * The deletion of a resource is accepted if all the associated resources can also be deleted.
	 * 
	 * @param r
	 *            The resource
	 * @return <code>true</code> if r can be deleted.
	 */
	public boolean acceptDelete(Resource r) {
		return all(associatedResources(r), canBeDeleted());
	}

	/**
	 * Predicate to check whether a resource can be deleted.
	 * 
	 * @return A predicate that returns <code>true</code> for resources that are empty and not matched on the
	 *         other side of the comparison.
	 */
	private Predicate<Resource> canBeDeleted() {
		return new Predicate<Resource>() {
			public boolean apply(Resource input) {
				return resourceChangeAdapter.isEmptyAndMissingOnOtherSide(input);
			}
		};
	}
}
