/*******************************************************************************
 * Copyright (c) 2013, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.DiffNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchResourceNode;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.AbstractDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * This implementation of a
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider} will be used to
 * group the differences by their Resource.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class ByResourceGroupProvider extends AbstractDifferenceGroupProvider {

	/**
	 * Specialized {@link BasicDifferenceGroupImpl} for Resources.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 */
	public static class ResourceGroup extends BasicDifferenceGroupImpl {
		private Set<Match> roots;

		/**
		 * {@inheritDoc}.
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl#BasicDifferenceGroupImpl(org.eclipse.emf.compare.Comparison)
		 */
		public ResourceGroup(Comparison comparison, ECrossReferenceAdapter crossReferenceAdapter) {
			super(comparison, Predicates.<Diff> alwaysTrue(), crossReferenceAdapter);
		}

		@Override
		public void buildSubTree() {
			// Prepare our "roots" list
			roots = new LinkedHashSet<Match>();
			for (Match match : getComparison().getMatches()) {
				recursiveFindRoots(match);
			}
			super.buildSubTree();
		}

		private void recursiveFindRoots(Match match) {
			if (hasRootSide(match)) {
				roots.add(match);
			}
			for (Match subMatch : match.getSubmatches()) {
				recursiveFindRoots(subMatch);
			}
		}

		/**
		 * Checks if the given match has a side which is the root of its resource.
		 * 
		 * @param match
		 *            The match.
		 * @return <code>true</code> if this match has a "root" side (even if its the root of a fragment),
		 *         <code>false</code> otherwise.
		 */
		private boolean hasRootSide(Match match) {
			boolean hasRoot = match.getLeft() instanceof InternalEObject
					&& ((InternalEObject)match.getLeft()).eDirectResource() != null;
			hasRoot = hasRoot || match.getRight() instanceof InternalEObject
					&& ((InternalEObject)match.getRight()).eDirectResource() != null;
			hasRoot = hasRoot || match.getOrigin() instanceof InternalEObject
					&& ((InternalEObject)match.getOrigin()).eDirectResource() != null;
			return hasRoot;
		}

		/** {@inheritDoc} */
		@Override
		protected List<TreeNode> buildMatchTrees() {
			// All of our nodes will be under MatchResources for this group.
			return new ArrayList<TreeNode>();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl#buildSubTree(MatchResource,
		 *      Set)
		 */
		@Override
		protected MatchResourceNode buildSubTree(MatchResource matchResource,
				Set<ResourceAttachmentChange> attachmentChanges) {
			MatchResourceNode matchResourceNode = createMatchResourceNode(matchResource);

			for (ResourceAttachmentChange attachmentChange : attachmentChanges) {
				DiffNode diffNode = createDiffNode(attachmentChange);
				matchResourceNode.addDiffNode(diffNode);
			}

			for (Match match : roots) {
				if (isUnderResourceWithURI(match.getLeft(), matchResource.getLeftURI())
						|| isUnderResourceWithURI(match.getRight(), matchResource.getRightURI())
						|| isUnderResourceWithURI(match.getOrigin(), matchResource.getOriginURI())) {
					MatchNode matchNode = createMatchNode(match);
					populateMatchNode(matchNode);
					if (!matchNode.getChildren().isEmpty()) {
						matchResourceNode.addMatchNode(matchNode);
					}
				}
			}

			return matchResourceNode;
		}

		/**
		 * Check if the resource of the given object as the same uri as the given uri.
		 * 
		 * @param eObject
		 *            the given object.
		 * @param uri
		 *            the given uri.
		 * @return true if the resource of the given object as the same uri as the given uri, false otherwise.
		 */
		private boolean isUnderResourceWithURI(EObject eObject, String uri) {
			if (eObject != null && uri != null) {
				final Resource resource = eObject.eResource();
				return resource != null && uri.equals(resource.getURI().toString());
			}
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.AbstractBuildingDifferenceGroupProvider#buildGroups(org.eclipse.emf.compare.Comparison)
	 */
	@Override
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison comparison2) {
		ResourceGroup group = new ResourceGroup(comparison2, getCrossReferenceAdapter());
		group.buildSubTree();
		return ImmutableList.of(group);
	}
}
