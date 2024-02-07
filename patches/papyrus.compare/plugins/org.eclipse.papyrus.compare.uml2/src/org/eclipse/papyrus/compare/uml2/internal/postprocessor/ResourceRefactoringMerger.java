/*******************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.postprocessor;

import static org.eclipse.emf.compare.utils.MatchUtil.getMatchedObject;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.PapyrusResourceIndex.index;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.ResourceRefactoringChange.isResourceRefactoringChange;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.merge.AbstractMerger;
import org.eclipse.emf.compare.merge.ResourceChangeAdapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.compare.uml2.internal.UMLPapyrusComparePlugin;

/**
 * A specialized merger for the {@link ResourceRefactoringChange}s in matches of root objects of resources
 * that are refactored (URIs changed by rename or move) and which, therefore, are not actually logically
 * moving those root objects. These changes therefore replace {@code ResourceAttachmentChange}s computed by
 * the diff engine.
 *
 * @author Christian W. Damus
 */
public class ResourceRefactoringMerger extends AbstractMerger {

	/**
	 * Initializes me.
	 */
	public ResourceRefactoringMerger() {
		super();
	}

	@Override
	public boolean isMergerFor(Diff target) {
		return isResourceRefactoringChange(target);
	}

	@Override
	protected void accept(Diff diff, boolean rightToLeft) {
		refactorResource(ResourceRefactoringChange.get(diff), rightToLeft);
	}

	@Override
	protected void reject(Diff diff, boolean rightToLeft) {
		refactorResource(ResourceRefactoringChange.get(diff), !rightToLeft);
	}

	protected void refactorResource(ResourceRefactoringChange diff, boolean rightToLeft) {
		Resource newResource = diff.getNewResource();
		Resource oldResource = diff.getOldResource();

		if (oldResource != null) {
			Match match = diff.getMatch();
			DifferenceSource side = rightToLeft ? DifferenceSource.LEFT : DifferenceSource.RIGHT;
			ResourceSet rset = newResource.getResourceSet();

			PapyrusResourceIndex index = index(match);
			MatchResource newMatch = index.getMatch(getMatchedObject(match, side).eResource());

			// We've implicitly moved the UML content. Bring along anything that other
			// RACs moved into the old resource and then delete it
			newResource.getContents().addAll(oldResource.getContents());
			markForDeletion(oldResource);

			// And process the other resources in the same group, to ensure their refactoring
			for (Map.Entry<String, MatchResource> next : index.getGroup(newMatch, side).entrySet()) {
				if (next.getValue() != newMatch) {
					newResource = demandResource(companion(diff.getNewURI(), next.getKey()), rset, true);
					oldResource = demandResource(companion(diff.getOldURI(), next.getKey()), rset, false);

					if (oldResource != null) {
						newResource.getContents().addAll(oldResource.getContents());
						markForDeletion(oldResource);
					}
				}
			}
		}
	}

	/**
	 * Add a {@code resource} the collection of resources to be deleted when the merge result is saved.
	 *
	 * @param resource
	 *            a resource to be deleted on save of the merge
	 */
	protected void markForDeletion(Resource resource) {
		ResourceChangeAdapter rca = (ResourceChangeAdapter)EcoreUtil.getExistingAdapter(resource,
				ResourceChangeAdapter.class);
		if (rca != null) {
			try {
				Field resourcesToDelete = rca.getClass().getDeclaredField("resourcesToDelete"); //$NON-NLS-1$
				resourcesToDelete.setAccessible(true);

				@SuppressWarnings("unchecked")
				Collection<? super Resource> resourcesToDeleteValue = (Collection<? super Resource>)resourcesToDelete
						.get(rca);
				resourcesToDeleteValue.add(resource);
			} catch (Exception e) {
				UMLPapyrusComparePlugin.getDefault().getLog()
						.log(new Status(IStatus.ERROR, UMLPapyrusComparePlugin.PLUGIN_ID,
								"Failed to mark resource for deletion: " + resource.getURI(), //$NON-NLS-1$
								e));
			}
		}
	}

	/**
	 * Obtains the specified resource on the given {@code side} of the match.
	 * 
	 * @param uri
	 *            the resource URI to get
	 * @param rset
	 *            the resource set on the merge target side in which to get the resource
	 * @param create
	 *            whether to create the resource if it doesn't exist (e.g., for merging into it)
	 * @return the resource, or {@code null} if it doesn't exist and is not {@code create}d
	 */
	protected Resource demandResource(URI uri, ResourceSet rset, boolean create) {
		Resource result = rset.getResource(uri, false);
		if (result == null) {
			if (rset.getURIConverter().exists(uri, null)) {
				result = rset.getResource(uri, true);
			} else if (create) {
				result = rset.createResource(uri);
			}
		}

		return result;
	}

	/**
	 * Compute the companion resource URI of a URI that has the given file extension.
	 * 
	 * @param uri
	 *            the base URI
	 * @param fileExtension
	 *            the file extension of the companion
	 * @return the companion URI
	 */
	static URI companion(URI uri, String fileExtension) {
		return uri.trimFileExtension().appendFileExtension(fileExtension);
	}
}
