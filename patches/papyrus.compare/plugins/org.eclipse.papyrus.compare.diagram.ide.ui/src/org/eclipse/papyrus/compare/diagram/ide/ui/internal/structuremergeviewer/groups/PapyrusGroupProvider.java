/*******************************************************************************
 * Copyright (c) 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Tobias Ortmayr - initial API and implementation
 *      Christian W. Damus - bug 516257
 *******************************************************************************/

package org.eclipse.papyrus.compare.diagram.ide.ui.internal.structuremergeviewer.groups;

import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Collections2.filter;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchNode;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.AbstractDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.tree.TreeFactory;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet.PapyrusFacetContentProviderWrapper;
import org.eclipse.papyrus.compare.diagram.ide.ui.internal.context.PapyrusContextUtil;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;

/**
 * This implementation of a
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider} will be used to
 * group the differences of Papyrus models.
 * 
 * @author Tobias Ortmayr <tortmayr.ext@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class PapyrusGroupProvider extends AbstractDifferenceGroupProvider {

	/**
	 * Predicate testing whether a {@link MatchResource} is a UML resource (file extension is .uml).
	 */
	private static final Predicate<? super MatchResource> IS_UML_RESOURCE = new Predicate<MatchResource>() {
		private final Predicate<Resource> isUML = PapyrusContextUtil.isUMLResource();

		public boolean apply(MatchResource input) {
			return input != null //
					&& (isUML.apply(input.getLeft()) || isUML.apply(input.getRight())
							|| isUML.apply(input.getOrigin()));
		}
	};

	/**
	 * Specialized {@link BasicDifferenceGroupImpl} for Papyrus models.
	 * 
	 * @author Tobias Ortmayr <tortmayr.ext@eclipsesource.com>
	 */
	public static class PapyrusDifferenceGroup extends BasicDifferenceGroupImpl {

		/** Map for retrieving the corresponding TreeNode of a model element. **/
		private Map<EObject, TreeNode> valueToMatchNode;

		/** Map for retrieving the context UML element of a notation (Diagram/Table/etc.). **/
		private HashMap<EObject, EObject> notationToContextualParent;

		/** A predicate testing whether a match matches notations (Diagrams/Tables/etc.). **/
		private final Predicate<Match> matchValueNotationPredicate = new Predicate<Match>() {
			public boolean apply(Match match) {
				EObject matchValue = getMatchValue(match);
				return (matchValue != null) && ViewPrototype.isViewObject(matchValue);
			}
		};

		/**
		 * Initializes me with my comparison and cross-referencer.
		 * 
		 * @param comparison
		 *            the comparison being presented
		 * @param crossReferenceAdapter
		 *            a cross-reference adapter to propagate down the tree
		 */
		public PapyrusDifferenceGroup(Comparison comparison, ECrossReferenceAdapter crossReferenceAdapter) {
			super(comparison, Predicates.<Diff> alwaysTrue(), crossReferenceAdapter);
			valueToMatchNode = new HashMap<>();
			notationToContextualParent = new HashMap<>();
			retrieveContextualNotationParents(MergeViewerSide.LEFT);
			retrieveContextualNotationParents(MergeViewerSide.RIGHT);
		}

		/**
		 * Makes use of the PapyrusFacetContentProviderWrapper to retrieve the contextual UML element for each
		 * notation of the Comparison.
		 * 
		 * @param side
		 *            Defines the comparison side for retrieving the elements
		 */
		private void retrieveContextualNotationParents(MergeViewerSide side) {
			ResourceSet resourceSet = getResourceSet(getComparison(), side);
			if (resourceSet != null) {
				SemanticUMLContentProvider contentProvider = new SemanticUMLContentProvider(resourceSet);
				try {
					for (Object root : contentProvider.getElements(null)) {
						retrieveNotationParents(root, contentProvider);
					}
				} finally {
					contentProvider.dispose();
				}
			}
		}

		/**
		 * Recursively traverses the UML mode tree and maps all notations and their contextual parent.
		 * 
		 * @param object
		 *            the child Object
		 * @param facetContentProviderWrapper
		 *            the {@link PapyrusFacetContentProviderWrapper}
		 */
		private void retrieveNotationParents(Object object, SemanticUMLContentProvider contentProvider) {
			Function<Object, EObject> asEObject = adapt(EObject.class);

			// These children are EMF Facet TreeObjects
			for (Object child : contentProvider.getChildren(object)) {
				// Get the encapsulated model object
				EObject eObjectChild = asEObject.apply(child);
				if (eObjectChild != null) {
					// This is a legitimate case
					EObject eObjectParent = asEObject.apply(object);
					if (eObjectParent != null && ViewPrototype.isViewObject(eObjectChild)) {
						if (!notationToContextualParent.containsKey(eObjectChild)) {
							notationToContextualParent.put(eObjectChild, eObjectParent);
						}
					}
					retrieveNotationParents(child, contentProvider);
				}
			}
		}

		static <T> Function<Object, T> adapt(final Class<T> adapterType) {
			return new Function<Object, T>() {
				public T apply(Object input) {
					if (adapterType.isInstance(input)) {
						return adapterType.cast(input);
					} else if (input instanceof IAdaptable) {
						return ((IAdaptable)input).getAdapter(adapterType);
					} else {
						return null;
					}
				}
			};
		}

		@Override
		protected List<TreeNode> buildMatchTrees() {
			final List<TreeNode> matchTrees = new ArrayList<TreeNode>();

			final Collection<Match> matches = getComparison().getMatches();

			/*
			 * Notation matches rely on information of other match trees for proper grouping (valueToMatchNode
			 * map needs to be populated ). So first all match trees for non-notation matches are built and
			 * the notation match sub trees are built separately in a second iteration.
			 */
			for (Match match : filter(matches, not(isMatchValueANotation()))) {
				MatchNode matchNode = buildTree(match);
				if (matchNode != null) {
					matchTrees.add(matchNode);
				}
			}

			// But, we still want to present all notation views first as in the Model Explorer
			List<TreeNode> nodesToSort = Lists.newArrayList();
			for (Match match : filter(matches, isMatchValueANotation())) {
				TreeNode notationNode = buildTree(match);
				if (notationNode != null) {
					TreeNode parentNode = retrieveParentNode(notationNode, getParent(getMatchValue(match)));
					parentNode.getChildren().add(notationNode);
					notationNode.setParent(parentNode);
					nodesToSort.add(parentNode); // This needs sorting
				}
			}

			if (!nodesToSort.isEmpty()) {
				Comparator<TreeNode> sortBy = treeNodeOrdering();
				for (TreeNode next : nodesToSort) {
					ECollections.sort(next.getChildren(), sortBy);
				}
			}

			return matchTrees;
		}

		/**
		 * Obtain a comparator for sorting tree nodes by kind:
		 * <ol>
		 * <li>diffs of the object represented by the parent node (its own details) should come before
		 * anything to do with child objects</li>
		 * <li>notation views (diagrams, tables, etc.)</li>
		 * <li>all other children</li>
		 * </ol>
		 * 
		 * @return the tree node comparator
		 */
		protected Comparator<TreeNode> treeNodeOrdering() {
			return new Comparator<TreeNode>() {
				public int compare(TreeNode o1, TreeNode o2) {
					int key1 = computeSortKey(o1);
					int key2 = computeSortKey(o2);
					return key1 - key2;
				}

				private int computeSortKey(TreeNode node) {
					EObject object = node.getData();
					if (object instanceof Diff) {
						// Diffs of the object should come before anything about children
						return -2;
					}

					if (object instanceof Match //
							&& isMatchValueANotation().apply((Match)object)) {

						// These come next
						return -1;
					}

					// Everything else follows
					return 0;
				}
			};
		}

		/**
		 * Creates a predicate for determining if the associated EObject of a Match is an instance of the
		 * given class.
		 * 
		 * @param clazz
		 *            the Class
		 * @return the created Predicate
		 */
		private Predicate<Match> isMatchValueANotation() {
			return matchValueNotationPredicate;
		}

		/**
		 * Creates a new TreeNode.
		 * 
		 * @param data
		 *            data object of the node
		 * @return created TreeNode
		 */
		private TreeNode createTreeNode(EObject data) {
			TreeNode node = TreeFactory.eINSTANCE.createTreeNode();
			node.setData(data);
			return node;
		}

		/**
		 * Determines the parent node of the given TreeNode. If the parent node doesn't exist yet the
		 * corresponding node and (sub) tree is created and merged into the match tree.
		 * 
		 * @param childNode
		 *            the child TreeNode
		 * @param parentObject
		 *            the data object of the parent node
		 * @return (new) parent TreeNode
		 */
		private TreeNode retrieveParentNode(TreeNode childNode, EObject parentObject) {
			TreeNode parentNode = getOrCreateParentNode(childNode, parentObject);
			if (!(parentNode instanceof MatchNode)) {
				// the parent node is a newly created node -> the corresponding subtree has to be created
				createSubTree(parentNode, getParent(parentObject));
			}
			return parentNode;

		}

		/**
		 * Retrieves the parent node of given TreeNode. If no matching node exists in the match tree a new
		 * node is created
		 * 
		 * @param childNode
		 *            the child TreeNode
		 * @param parentObject
		 *            (new) parent TreeNode
		 * @return (new) parent TreeNode
		 */
		private TreeNode getOrCreateParentNode(TreeNode childNode, EObject parentObject) {
			if (parentObject == null) {
				// we have no parent to add this childNode; this may happen if a notation has no context;
				// thus,
				// we add it as root node (childNode is the parent without any parent)
				return childNode;
			}

			TreeNode parentNode = valueToMatchNode.get(parentObject);
			if (parentNode == null) {
				parentNode = createTreeNode(parentObject);
			}

			childNode.setParent(parentNode);
			parentNode.getChildren().add(childNode);
			return parentNode;
		}

		/**
		 * Retrieves the contextual parent of the given EObject.
		 * 
		 * @param value
		 *            the child EObject
		 * @return parent EObject
		 */
		private EObject getParent(EObject value) {
			EObject result = notationToContextualParent.get(value);
			if (result == null && value != null) {
				result = value.eContainer();
			}
			return result;
		}

		/**
		 * Creates the subtree for the given tree node with a recursive bottom-up approach.
		 *
		 * @param treeNode
		 *            the TreeNode
		 * @param parentObject
		 *            the parent EObject
		 */
		private void createSubTree(TreeNode treeNode, EObject parentObject) {
			if (parentObject == null) {
				children.add(treeNode);
				return;
			}
			TreeNode parentNode = getOrCreateParentNode(treeNode, parentObject);
			treeNode.setParent(parentNode);
			parentNode.getChildren().add(treeNode);
			if (parentNode instanceof MatchNode) {
				return;
			}
			createSubTree(parentNode, getParent(parentObject));
		}

		@Override
		protected void populateMatchNode(MatchNode matchNode) {
			super.populateMatchNode(matchNode);
			if (!matchNode.getChildren().isEmpty()) {
				valueToMatchNode.put(getMatchValue(matchNode.getMatch()), matchNode);
			}
		}

		/**
		 * Returns the corresponding EObject for the given Match.
		 * 
		 * @param match
		 *            the Match
		 * @return the corresponding EObject
		 */
		private EObject getMatchValue(Match match) {
			if (match.getLeft() != null) {
				return match.getLeft();
			}
			if (match.getRight() != null) {
				return match.getRight();
			}
			return match.getOrigin();
		}

		/**
		 * Determines the object of the given match and side.
		 * 
		 * @param comparison
		 *            the {@link Comparison}.
		 * @param side
		 *            the {@link MergeViewerSide}.
		 * @return the determined {@link Object}, may be {@code null}.
		 */
		private ResourceSet getResourceSet(Comparison comparison, MergeViewerSide side) {
			for (MatchResource matchResource : comparison.getMatchedResources()) {
				Resource resource = getResource(matchResource, side);
				if (resource != null) {
					return resource.getResourceSet();
				}
			}
			return null;
		}

		/**
		 * Determines the resource of the given match and side.
		 * 
		 * @param matchResource
		 *            the {@link MatchResource}.
		 * @param side
		 *            the {@link MergeViewerSide}.
		 * @return the determined {@link Resource}, may be {@code null}.
		 */
		private Resource getResource(MatchResource matchResource, MergeViewerSide side) {
			if (side != null) {
				switch (side) {
					case LEFT:
						return matchResource.getLeft();
					case RIGHT:
						return matchResource.getRight();
					case ANCESTOR:
						return matchResource.getOrigin();
				}
			}
			return null;
		}

	}

	@Override
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison comparison) {
		PapyrusDifferenceGroup group = new PapyrusDifferenceGroup(getComparison(),
				getCrossReferenceAdapter());
		group.buildSubTree();
		return ImmutableList.of(group);
	}

	@Override
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return super.isEnabled(scope, comparison) && PapyrusContextUtil.isPapyrusContext(comparison)
				&& hasAtLeastOneUMLResource(comparison);
	}

	/**
	 * Specifies whether the given comparison has at least one UML resource in its matched resources.
	 * 
	 * @param comparison
	 *            The comparison to test.
	 * @return <code>true</code> if it has at least one {@link MatchResource} of a UML resource,
	 *         <code>false</code> otherwise.
	 */
	private boolean hasAtLeastOneUMLResource(Comparison comparison) {
		return Iterables.any(comparison.getMatchedResources(), IS_UML_RESOURCE);
	}

}
