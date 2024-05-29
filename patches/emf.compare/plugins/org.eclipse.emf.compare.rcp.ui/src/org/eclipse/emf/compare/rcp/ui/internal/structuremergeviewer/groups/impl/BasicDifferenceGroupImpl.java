/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Iterators.any;
import static com.google.common.collect.Iterators.concat;
import static com.google.common.collect.Iterators.transform;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.hasState;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.provider.utils.ComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.Style;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.ConflictNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.DiffNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchResourceNode;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.swt.graphics.Image;

/**
 * This implementation of a {@link IDifferenceGroup} uses a predicate to filter the whole list of differences.
 * <p>
 * This can be subclasses or used directly instead of {@link IDifferenceGroup}.
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class BasicDifferenceGroupImpl extends AdapterImpl implements IDifferenceGroup {

	/**
	 * Function that returns all contents of the given EObject.
	 */
	protected static final Function<EObject, Iterator<EObject>> E_ALL_CONTENTS = new Function<EObject, Iterator<EObject>>() {
		public Iterator<EObject> apply(EObject eObject) {
			return eObject.eAllContents();
		}
	};

	/** The filter we'll use in order to filter the differences that are part of this group. */
	protected final Predicate<? super Diff> filter;

	/** The name that the EMF Compare UI will display for this group. */
	protected final String name;

	/** The icon that the EMF Compare UI will display for this group. */
	protected final Image image;

	/** The list of children of this group. */
	protected List<TreeNode> children;

	/** The comparison that is the parent of this group. */
	private final Comparison comparison;

	/** The registry of difference group extenders. */
	private final IDifferenceGroupExtender.Registry registry = EMFCompareRCPUIPlugin.getDefault()
			.getDifferenceGroupExtenderRegistry();

	/** The cross reference adapter that will be added to this group's children. */
	private final ECrossReferenceAdapter crossReferenceAdapter;

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences.
	 * <p>
	 * This will use the default name and icon for the group.
	 * </p>
	 * 
	 * @param comparison
	 *            The comparison that is the parent of this group.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 * @param crossReferenceAdapter
	 *            The cross reference adapter that will be added to this group's children.
	 */
	public BasicDifferenceGroupImpl(Comparison comparison, Predicate<? super Diff> filter,
			ECrossReferenceAdapter crossReferenceAdapter) {
		this(comparison, filter, EMFCompareRCPUIMessages.getString("BasicDifferenceGroup.name"), //$NON-NLS-1$
				EMFCompareRCPUIPlugin.getImage("icons/full/toolb16/group.gif"), //$NON-NLS-1$
				crossReferenceAdapter);
	}

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences. It will be displayed in the UI with the default icon and the given name.
	 * 
	 * @param comparison
	 *            The comparison that is the parent of this group.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 * @param name
	 *            The name that the EMF Compare UI will display for this group.
	 * @param crossReferenceAdapter
	 *            The cross reference adapter that will be added to this group's children.
	 */
	public BasicDifferenceGroupImpl(Comparison comparison, Predicate<? super Diff> filter, String name,
			ECrossReferenceAdapter crossReferenceAdapter) {
		this(comparison, filter, name, EMFCompareRCPUIPlugin.getImage("icons/full/toolb16/group.gif"), //$NON-NLS-1$
				crossReferenceAdapter);
	}

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences. It will be displayed in the UI with the given icon and name.
	 * 
	 * @param comparison
	 *            The comparison that is the parent of this group.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 * @param name
	 *            The name that the EMF Compare UI will display for this group.
	 * @param image
	 *            The icon that the EMF Compare UI will display for this group.
	 * @param crossReferenceAdapter
	 *            Updated upstream The cross reference adapter that will be added to this group's children.
	 */
	public BasicDifferenceGroupImpl(Comparison comparison, Predicate<? super Diff> filter, String name,
			Image image, ECrossReferenceAdapter crossReferenceAdapter) {
		this.comparison = comparison;
		this.filter = filter;
		this.name = name;
		this.image = image;
		this.crossReferenceAdapter = crossReferenceAdapter;
	}

	/**
	 * Returns the comparison object.
	 * 
	 * @return the comparison object.
	 */
	protected final Comparison getComparison() {
		return comparison;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == IDifferenceGroup.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup#getStyledName()
	 */
	public IStyledString.IComposedStyledString getStyledName() {
		final IStyledString.IComposedStyledString ret = new ComposedStyledString();
		Iterator<EObject> eAllContents = concat(transform(getChildren().iterator(), E_ALL_CONTENTS));
		Iterator<EObject> eAllData = transform(eAllContents, TREE_NODE_DATA);
		boolean unresolvedDiffs = any(Iterators.filter(eAllData, Diff.class),
				hasState(DifferenceState.UNRESOLVED));
		if (unresolvedDiffs) {
			ret.append("> ", Style.DECORATIONS_STYLER); //$NON-NLS-1$
		}
		ret.append(getName());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup#getImage()
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup#getChildren()
	 */
	public List<? extends TreeNode> getChildren() {
		if (children == null) {
			buildSubTree();
		}
		return children;
	}

	/**
	 * Registers the CrossReferenceAdapter to all given notifiers.
	 * 
	 * @param notifiers
	 *            the list of notifiers.
	 */
	protected final void registerCrossReferenceAdapter(List<? extends Notifier> notifiers) {
		for (Notifier notifier : notifiers) {
			// this cross referencer has to live as long as the objects on which it is installed.
			notifier.eAdapters().add(crossReferenceAdapter);
		}
	}

	/**
	 * Unregisters the CrossReferenceAdapter from all given notifiers.
	 * 
	 * @param notifiers
	 *            the list of notifiers.
	 */
	protected final void unregisterCrossReferenceAdapter(List<? extends Notifier> notifiers) {
		for (Notifier notifier : notifiers) {
			// this cross referencer has to live as long as the objects on which it is installed.
			notifier.eAdapters().remove(crossReferenceAdapter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup#dispose()
	 */
	public void dispose() {
		if (children != null) {
			unregisterCrossReferenceAdapter(children);
			children = null;
		}
	}

	/**
	 * Builds the sub tree for this group.
	 */
	public void buildSubTree() {
		children = createChildren();
		doBuildSubTrees();
		customize(children);
		registerCrossReferenceAdapter(children);
		setTarget(comparison);
	}

	/**
	 * Perform the creation of the sub-trees of the group.
	 */
	protected void doBuildSubTrees() {
		children.addAll(buildMatchTrees());
		children.addAll(buildMatchResourceTrees());
	}

	/**
	 * This creates the root-level children of the group.
	 * 
	 * @return This default implementation returns a new ArrayList. It may be overridden by sub-classes.
	 */
	protected List<TreeNode> createChildren() {
		return newArrayList();
	}

	/**
	 * Compute a subTree for each root match of the comparison.
	 * 
	 * @return the list of matchSubTrees
	 */
	protected List<TreeNode> buildMatchTrees() {
		final List<TreeNode> matchTrees = new ArrayList<TreeNode>();
		for (Match match : getComparison().getMatches()) {
			MatchNode matchNode = buildTree(match);
			if (matchNode != null) {
				matchTrees.add(matchNode);
			}
		}
		return matchTrees;
	}

	/**
	 * Compute a tree for the given match.
	 * 
	 * @param match
	 *            The given match
	 * @return a list of subTree for this match, must not be <code>null</code>
	 */
	protected MatchNode buildTree(Match match) {
		MatchNode result = null;
		MatchNode matchNode = createMatchNode(match);
		populateMatchNode(matchNode);
		if (!matchNode.getChildren().isEmpty()) {
			result = matchNode;
		}
		return result;
	}

	/**
	 * Build the subtree for the given match.
	 * 
	 * @param matchNode
	 *            The root matchNode
	 * @return the computed matchNode
	 */
	protected void populateMatchNode(MatchNode matchNode) {
		Match match = matchNode.getMatch();
		Multimap<Match, Diff> diffsBySubMatch = LinkedHashMultimap.create();
		for (Diff diff : filter(match.getDifferences(), filter)) {
			// If a diff is part of a larger diff (is refined by), we don't want to add it to the tree. It
			// will be added by the algorithm in a second step. This way we avoid duplication and all diffs
			// that are part of a 'master' diff are grouped as children of this 'master' diff
			if (mustDisplayAsDirectChildOfMatch(diff)) {
				Match targetMatch = getTargetMatch(diff);
				if (match == targetMatch) {
					addDiffNode(matchNode, diff);
				} else if (match.getSubmatches().contains(targetMatch)) {
					diffsBySubMatch.put(targetMatch, diff);
				} else if (targetMatch != null) {
					MatchNode targetMatchNode = createMatchNode(targetMatch);
					matchNode.addSubMatchNode(targetMatchNode);
					addDiffNode(targetMatchNode, diff);
				}
			}
		}
		for (Match subMatch : match.getSubmatches()) {
			MatchNode subMatchNode = createMatchNode(subMatch);
			for (Diff subMatchDiff : diffsBySubMatch.get(subMatch)) {
				addDiffNode(subMatchNode, subMatchDiff);
			}
			diffsBySubMatch.removeAll(subMatch);
			populateMatchNode(subMatchNode);
			if (!subMatchNode.getChildren().isEmpty()) {
				matchNode.addSubMatchNode(subMatchNode);
			}
		}
	}

	/**
	 * Provide the Match that should directly contain the given diff. If the given diff should not be a direct
	 * child of a Match, the method must return <code>null</code>. For a given strategy, a diff should only be
	 * displayed in the same Match (i.e. the {@link DiffNode}s that represent the diff should always be
	 * children of the {@link MatchNode}s that represent the returned Match.
	 * 
	 * @param diff
	 *            The difference
	 * @return The Match that is a direct parent of the given diff, can be <code>null</code>.
	 */
	protected Match getTargetMatch(Diff diff) {
		if (mustDisplayAsDirectChildOfMatch(diff)) {
			if (isContainmentRefChange(diff)) {
				Match valueMatch = diff.getMatch().getComparison()
						.getMatch(((ReferenceChange)diff).getValue());
				return valueMatch; // This match may not be a sub-match because the child may have moved
			} else if (isContainmentRefChange(diff.getPrimeRefining())) {
				Match valueMatch = diff.getMatch().getComparison()
						.getMatch(((ReferenceChange)diff.getPrimeRefining()).getValue());
				return valueMatch; // This match may not be a sub-match because the child may have moved
			}
			return diff.getMatch();
		}
		return null;
	}

	/**
	 * Does the given difference have to be displayed as direct child of a Match?
	 * 
	 * @param diff
	 *            The diff
	 * @return <code>true</code> if the diff's node should be a child of a MatchNode.
	 */
	protected boolean mustDisplayAsDirectChildOfMatch(Diff diff) {
		return diff.getRefines().isEmpty();
	}

	/**
	 * Is it a containment reference change?
	 * 
	 * @param diff
	 *            The diff
	 * @return <code>true</code> if the diff is a {@link ReferenceChange} whose {@link EReference} is a
	 *         containment reference.
	 */
	protected boolean isContainmentRefChange(Diff diff) {
		return diff instanceof ReferenceChange && ((ReferenceChange)diff).getReference().isContainment();
	}

	protected List<TreeNode> buildMatchResourceTrees() {
		final List<TreeNode> matchResourceTrees = new ArrayList<TreeNode>();
		if (getComparison().getMatchedResources().isEmpty()) {
			return matchResourceTrees;
		}

		final Iterable<ResourceAttachmentChange> attachmentChanges = Iterables
				.filter(getComparison().getDifferences(), ResourceAttachmentChange.class);

		final Multimap<String, ResourceAttachmentChange> uriToRAC = LinkedHashMultimap.create();
		for (ResourceAttachmentChange attachmentChange : attachmentChanges) {
			uriToRAC.put(attachmentChange.getResourceURI(), attachmentChange);
		}
		for (MatchResource matchResource : getComparison().getMatchedResources()) {
			final Collection<ResourceAttachmentChange> leftRAC = uriToRAC.get(matchResource.getLeftURI());
			final Collection<ResourceAttachmentChange> rightRAC = uriToRAC.get(matchResource.getRightURI());
			final Collection<ResourceAttachmentChange> originRAC = uriToRAC.get(matchResource.getOriginURI());
			final LinkedHashSet<ResourceAttachmentChange> racForMatchResource = Sets.newLinkedHashSet();
			racForMatchResource.addAll(leftRAC);
			racForMatchResource.addAll(rightRAC);
			racForMatchResource.addAll(originRAC);

			MatchResourceNode matchNode = buildSubTree(matchResource, racForMatchResource);
			if (matchNode != null) {
				matchResourceTrees.add(matchNode);
			}

		}
		return matchResourceTrees;
	}

	/**
	 * Build the sub tree of the given {@link MatchResource}.
	 * 
	 * @param matchResource
	 *            the given MatchResource.
	 * @return the sub tree of the given MatchResource.
	 */
	protected MatchResourceNode buildSubTree(MatchResource matchResource,
			Set<ResourceAttachmentChange> attachmentChanges) {
		MatchResourceNode matchResourceNode = createMatchResourceNode(matchResource);
		Collection<ResourceAttachmentChange> filteredChanges = filter(attachmentChanges, filter);
		for (ResourceAttachmentChange attachmentChange : filteredChanges) {
			DiffNode diffNode = createDiffNode(attachmentChange);
			matchResourceNode.addDiffNode(diffNode);
		}
		return matchResourceNode;
	}

	/**
	 * Add the diff in the given match. This method handles refined diffs and allows to customize the result.
	 * 
	 * @param matchNode
	 *            The given match node
	 * @param diff
	 *            The diff to add
	 */
	protected void addDiffNode(MatchNode matchNode, Diff diff) {
		if (!(diff instanceof ResourceAttachmentChange)) {
			DiffNode diffNode = createDiffNode(diff);
			handleRefiningDiffs(diffNode);
			matchNode.addDiffNode(diffNode);
		}
	}

	/**
	 * Create a diff node.
	 * 
	 * @param diff
	 *            The given diff
	 * @return the DiffNode
	 */
	protected DiffNode createDiffNode(Diff diff) {
		DiffNode diffNode = new DiffNode(diff);
		diffNode.eAdapters().add(this);
		return diffNode;
	}

	/**
	 * Create a match node.
	 * 
	 * @param match
	 *            The given match
	 * @return the MatchNode
	 */
	protected MatchNode createMatchNode(Match match) {
		MatchNode matchNode = new MatchNode(match);
		matchNode.eAdapters().add(this);
		return matchNode;
	}

	/**
	 * Create a conflict node.
	 * 
	 * @param conflict
	 *            The given conflict
	 * @return the ConflictNode
	 */
	protected ConflictNode createConflictNode(Conflict conflict) {
		ConflictNode conflictNode = new ConflictNode(conflict);
		conflictNode.eAdapters().add(this);
		return conflictNode;
	}

	/**
	 * Create a matchResource node.
	 * 
	 * @param matchResource
	 *            The given matchResource
	 * @return the MatchResourceNode
	 */
	protected MatchResourceNode createMatchResourceNode(MatchResource matchResource) {
		MatchResourceNode matchResourceNode = new MatchResourceNode(matchResource);
		matchResourceNode.eAdapters().add(this);
		return matchResourceNode;
	}

	/**
	 * Walk the given trees and customize each node in the tree, starting by the deeper nodes all the way up
	 * to the root nodes. This method calls itself recursively.
	 * 
	 * @param nodes
	 *            The list of nodes to customize.
	 */
	protected void customize(List<? extends TreeNode> nodes) {
		for (TreeNode node : nodes) {
			customize(node.getChildren());
			customize(node);
		}
	}

	/**
	 * Allow extenders to customize a TreeNode.
	 * 
	 * @param treeNode
	 *            the TreeNode to customize.
	 */
	protected void customize(TreeNode treeNode) {
		for (IDifferenceGroupExtender ext : registry.getExtenders()) {
			if (ext.handle(treeNode)) {
				ext.addChildren(treeNode);
			}
		}
	}

	/**
	 * Handle the diffs that refine the given diff. Refining diffs are added as children of the given diff,
	 * and so on recursively.
	 * 
	 * @param diffNode
	 *            The diff node to handle, which is not necessarily a child of a MatchNode since this method
	 *            is called recursively.
	 */
	protected void handleRefiningDiffs(DiffNode diffNode) {
		Diff diff = diffNode.getDiff();
		for (Diff refiningDiff : diff.getRefinedBy()) {
			DiffNode refinedDiffNode = createDiffNode(refiningDiff);
			diffNode.addRefinedDiffNode(refinedDiffNode);
			handleRefiningDiffs(refinedDiffNode);
		}
	}

}
