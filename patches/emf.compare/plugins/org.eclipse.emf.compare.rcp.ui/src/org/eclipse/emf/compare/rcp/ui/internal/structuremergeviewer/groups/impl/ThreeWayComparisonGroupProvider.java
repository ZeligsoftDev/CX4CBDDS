/*******************************************************************************
 * Copyright (c) 2013, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Stefan Dirix - bug 488941
 *     Simon Delisle, Edgar Mueller - bug 486923
 *     Tanja Mayerhofer - bug 501864
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterators.concat;
import static com.google.common.collect.Iterators.filter;
import static com.google.common.collect.Iterators.transform;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.unmodifiableSet;
import static org.eclipse.emf.compare.ConflictKind.PSEUDO;
import static org.eclipse.emf.compare.ConflictKind.REAL;
import static org.eclipse.emf.compare.internal.utils.DiffUtil.getRootRefinedDiffs;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.allAtomicRefining;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.anyRefining;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.containsConflictOfTypes;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.fromSide;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.hasConflict;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.hasState;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.ConflictKind;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.impl.ConflictImpl;
import org.eclipse.emf.compare.provider.utils.ComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.IComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.Style;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.SideLabelProvider;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.ConflictNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.DiffNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchNode;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.AbstractDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This implementation of a
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider} will be used to
 * group the differences by their {@link DifferenceSource side} : left, right and conflicts.
 * <p>
 * The table below describes the location of a diff depending on its status and that of its refining diffs
 * (whether all or some of them are in a real/pseudo conflict). <br/>
 * <br/>
 * <table style="border-collapse:collapse;">
 * <thead>
 * <tr>
 * <th rowspan="2"></th>
 * <th colspan="2" style="border:1px solid;">Real Conflicts</th>
 * <th colspan="2" style="border:1px solid;">Pseudo-Conflicts</th>
 * <th style="border:1px solid;">No Conflict</th>
 * </tr>
 * <tr>
 * <th style="border:1px solid;">All</th>
 * <th style="border:1px solid;">Some</th>
 * <th style="border:1px solid;">All</th>
 * <th style="border:1px solid;">Some</th>
 * <th style="border:1px solid;">All</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td style="border:1px solid; padding:0 2px;">Tech. filter ON</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict (hidden)</td>
 * <td style="border:1px solid; padding:0 2px;">Side</td>
 * <td style="border:1px solid; padding:0 2px;">Side</td>
 * </tr>
 * <tr>
 * <td style="border:1px solid; padding:0 2px;">Tech. filter OFF</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict</td>
 * <td style="border:1px solid; padding:0 2px;">Conflict</td>
 * <td style="border:1px solid; padding:0 2px;">Side</td>
 * <td style="border:1px solid; padding:0 2px;">Side</td>
 * </tr>
 * </tbody>
 * </table>
 * </p>
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class ThreeWayComparisonGroupProvider extends AbstractDifferenceGroupProvider {

	/**
	 * The default predicate used to filter differences in difference groups. The predicate returns true for
	 * diffs that do not have a direct or indirect real conflict and that do not have only pseudo conflicts.
	 */
	public static final Predicate<? super Diff> DEFAULT_DIFF_GROUP_FILTER_PREDICATE = and(
			not(hasConflict(REAL, PSEUDO)),
			not(or(anyRefining(hasConflict(REAL)), allAtomicRefining(hasConflict(PSEUDO)))));

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#isEnabled(org
	 *      .eclipse.emf.compare.scope.IComparisonScope, org.eclipse.emf.compare.Comparison)
	 */
	@Override
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		if (comparison != null && comparison.isThreeWay()) {
			return true;
		}
		return false;
	}

	/**
	 * Specialized {@link BasicDifferenceGroupImpl} for Conflicts.
	 * 
	 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
	 */
	public static class ConflictsGroupImpl extends BasicDifferenceGroupImpl {

		/**
		 * The default predicate used to filter differences.
		 */
		private static final Predicate<? super Diff> DEFAULT_CONFLICT_GROUP_FILTER_PREDICATE = hasConflict(
				ConflictKind.REAL, ConflictKind.PSEUDO);

		/**
		 * Conflict groups to show in SMV.
		 */
		private final List<CompositeConflict> compositeConflicts = newArrayList();

		/**
		 * Maps conflicting differences to their composite conflicts.
		 */
		private final Map<Diff, CompositeConflict> diffToCompositeConflictMap = newHashMap();

		/**
		 * {@inheritDoc}.
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl#BasicDifferenceGroupImpl(org.eclipse.emf.compare.Comparison,
		 *      java.lang.Iterable, com.google.common.base.Predicate, java.lang.String)
		 */
		public ConflictsGroupImpl(Comparison comparison, Predicate<? super Diff> filter, String name,
				ECrossReferenceAdapter crossReferenceAdapter) {
			super(comparison, filter, name, crossReferenceAdapter);
		}

		/**
		 * Instantiates this group given the comparison. It will use the default filter to determine its list
		 * of differences. It will be displayed in the UI with the default icon and the given name.
		 * 
		 * @param comparison
		 *            The comparison that is the parent of this group.
		 * @param name
		 *            The name that the EMF Compare UI will display for this group.
		 * @param crossReferenceAdapter
		 *            The cross reference adapter that will be added to this group's children.
		 */
		public ConflictsGroupImpl(Comparison comparison, String name,
				ECrossReferenceAdapter crossReferenceAdapter) {
			super(comparison, DEFAULT_CONFLICT_GROUP_FILTER_PREDICATE, name, crossReferenceAdapter);
		}

		/**
		 * In conflicts, a special case must be handled for refining diffs: If they are not part of the same
		 * conflict then they should not be in the same group as the refined diff.
		 * 
		 * @param diff
		 *            The difference
		 * @return <code>true</code> if the diff refines nothing or if its conflict does not contain all the
		 *         diffs it refines.
		 */
		@Override
		protected boolean mustDisplayAsDirectChildOfMatch(Diff diff) {
			return diff.getRefines().isEmpty() || (diff.getConflict() != null
					&& !diff.getConflict().getDifferences().containsAll(diff.getRefines()));
		}

		@Override
		protected void doBuildSubTrees() {
			for (Conflict conflict : getComparison().getConflicts()) {
				final CompositeConflict compositeConflict = new CompositeConflict(conflict);
				compositeConflicts.add(compositeConflict);
				joinOverlappingCompositeConflicts(compositeConflict);
				updateDiffToCompositeConflictMap(compositeConflict);
			}

			for (CompositeConflict conflict : compositeConflicts) {
				final ConflictNodeBuilder builder = new ConflictNodeBuilder(conflict, this);
				final ConflictNode conflictNode = builder.buildNode();
				children.add(conflictNode);
			}
		}

		/**
		 * Joins the given composite conflict with existing overlapping composite conflicts.
		 * 
		 * @param compositeConflict
		 *            The composite conflict into which overlapping composite conflicts should be joined
		 */
		private void joinOverlappingCompositeConflicts(final CompositeConflict compositeConflict) {
			// determine composite conflicts to join
			final Set<CompositeConflict> compositeConflictsToJoin = new HashSet<CompositeConflict>();
			for (Diff diff : compositeConflict.getDifferences()) {
				if (diffToCompositeConflictMap.containsKey(diff)) {
					compositeConflictsToJoin.add(diffToCompositeConflictMap.get(diff));
				}
			}
			// join conflict groups
			for (CompositeConflict conflictGroupToJoin : compositeConflictsToJoin) {
				compositeConflict.join(conflictGroupToJoin);
				compositeConflicts.remove(conflictGroupToJoin);
			}
		}

		/**
		 * Updates the diff to composite conflict map with the given composite conflict.
		 * 
		 * @param compositeConflict
		 *            The composite conflict that should be added to the diff to composite conflict map
		 */
		private void updateDiffToCompositeConflictMap(final CompositeConflict compositeConflict) {
			for (Diff diff : compositeConflict.getDifferences()) {
				diffToCompositeConflictMap.put(diff, compositeConflict);
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl#getStyledName()
		 */
		@Override
		public IComposedStyledString getStyledName() {
			final IStyledString.IComposedStyledString ret = new ComposedStyledString();
			Iterator<EObject> eAllContents = concat(transform(getChildren().iterator(), E_ALL_CONTENTS));
			Iterator<EObject> eAllData = transform(eAllContents, TREE_NODE_DATA);
			UnmodifiableIterator<Diff> eAllDiffData = filter(eAllData, Diff.class);
			Collection<Diff> diffs = Sets.newHashSet(eAllDiffData);
			boolean unresolvedDiffs = any(diffs, and(hasState(DifferenceState.UNRESOLVED),
					hasConflict(ConflictKind.REAL, ConflictKind.PSEUDO)));
			if (unresolvedDiffs) {
				ret.append("> ", Style.DECORATIONS_STYLER); //$NON-NLS-1$
			}
			ret.append(getName());
			return ret;
		}

		/**
		 * In the conflicts group, we want to be able to see the ResourceAttachmentChanges.
		 * 
		 * @param matchNode
		 *            The given match node
		 * @param diff
		 *            The diff to add
		 */
		@Override
		protected void addDiffNode(MatchNode matchNode, Diff diff) {
			DiffNode diffNode = createDiffNode(diff);
			handleRefiningDiffs(diffNode);
			matchNode.addDiffNode(diffNode);
		}
	}

	/**
	 * This extension of {@link Conflict} is used to handle {@link Diff#getRefinedBy() refined} diffs and to
	 * join conflicts for the SMV. If refining diffs are part of a conflict, we show their refined diffs
	 * instead. As we show refined diffs instead of the refining diffs, multiple conflicts may consequently
	 * include the same refined diffs. To avoid that, this extension of a conflict also joins such overlapping
	 * conflicts.
	 * 
	 * @author <a href="mailto:tmayerhofer@eclipsesource.com">Tanja Mayerhofer</a>
	 */
	public static class CompositeConflict extends ConflictImpl {

		/** The joined conflicts. */
		private Set<Conflict> conflicts = new LinkedHashSet<Conflict>();

		/** The diffs of all composed conflicts. */
		private EList<Diff> diffs = new BasicEList<Diff>();

		/** The conflict kind of this composite conflict. */
		private ConflictKind conflictKind = ConflictKind.REAL;

		/**
		 * Creates a new composite conflict for the given conflict.
		 * 
		 * @param conflict
		 *            The conflict to create a composite conflict for, must not be <code>null</code> and must
		 *            have a non-<code>null</code> {@link Conflict#getKind() kind}.
		 */
		public CompositeConflict(Conflict conflict) {
			conflicts.add(checkNotNull(conflict));
			conflictKind = checkNotNull(conflict.getKind());
			diffs.addAll(computeRefinedDiffs(conflict));
		}

		/**
		 * Computes the refined diffs of the conflict. In particular, refining diffs are replaced by refined
		 * diffs.
		 * 
		 * @param conflict
		 *            The conflict to compute its refined diffs for.
		 * @return The set of refined diffs of the conflict
		 */
		private Set<Diff> computeRefinedDiffs(Conflict conflict) {
			Set<Diff> computedDiffs = new LinkedHashSet<Diff>();
			for (Diff diff : conflict.getDifferences()) {
				if (diff.getRefines().isEmpty()) {
					computedDiffs.add(diff);
				} else {
					computedDiffs.addAll(getRootRefinedDiffs(diff));
				}
			}
			return computedDiffs;
		}

		@Override
		public ConflictKind getKind() {
			return conflictKind;
		}

		/**
		 * Returns an EList built by aggregating the diffs of all the aggregated conflicts.
		 * <p>
		 * <b>This list is not supposed to be used for update, since modifying this list will not modify the
		 * underlying conflicts.</b>
		 * </p>
		 */
		@Override
		public EList<Diff> getDifferences() {
			return diffs;
		}

		/**
		 * Returns an unmodifiable view of the joined conflicts.
		 * 
		 * @return An unmodifiable view of the joined conflicts, never <code>null</code> nor empty.
		 */
		public Set<Conflict> getConflicts() {
			return unmodifiableSet(conflicts);
		}

		/**
		 * Joins the provided composite conflict with this composite conflict.
		 * 
		 * @param conflict
		 *            The conflict to be joined with this composite conflict
		 */
		public void join(CompositeConflict conflict) {
			Set<Diff> currentDiffSet = new LinkedHashSet<Diff>(diffs);
			Set<Diff> otherDiffSet = new LinkedHashSet<Diff>(conflict.getDifferences());
			SetView<Diff> newDiffs = Sets.difference(otherDiffSet, currentDiffSet);
			diffs.addAll(newDiffs);
			if (conflicts.addAll(conflict.getConflicts()) && conflictKind != REAL) {
				if (any(conflicts, containsConflictOfTypes(REAL))) {
					conflictKind = REAL;
				} else {
					conflictKind = PSEUDO;
				}
			}
		}
	}

	@Override
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison comparison2) {
		Adapter adapter = EcoreUtil.getAdapter(getComparison().eAdapters(), SideLabelProvider.class);

		final String leftLabel;
		final String rightLabel;

		if (adapter instanceof SideLabelProvider) {
			SideLabelProvider labelProvider = (SideLabelProvider)adapter;
			leftLabel = labelProvider.getLeftLabel();
			rightLabel = labelProvider.getRightLabel();
		} else {
			leftLabel = EMFCompareRCPUIMessages.getString("ThreeWayComparisonGroupProvider.left.label"); //$NON-NLS-1$
			rightLabel = EMFCompareRCPUIMessages.getString("ThreeWayComparisonGroupProvider.right.label"); //$NON-NLS-1$
		}

		final ConflictsGroupImpl conflicts = new ConflictsGroupImpl(getComparison(),
				EMFCompareRCPUIMessages.getString("ThreeWayComparisonGroupProvider.conflicts.label"), //$NON-NLS-1$
				getCrossReferenceAdapter());
		conflicts.buildSubTree();

		final BasicDifferenceGroupImpl leftSide = new BasicDifferenceGroupImpl(getComparison(),
				and(fromSide(DifferenceSource.LEFT), DEFAULT_DIFF_GROUP_FILTER_PREDICATE), leftLabel,
				getCrossReferenceAdapter());
		leftSide.buildSubTree();

		final BasicDifferenceGroupImpl rightSide = new BasicDifferenceGroupImpl(getComparison(),
				and(fromSide(DifferenceSource.RIGHT), DEFAULT_DIFF_GROUP_FILTER_PREDICATE), rightLabel,
				getCrossReferenceAdapter());
		rightSide.buildSubTree();

		return ImmutableList.of(conflicts, leftSide, rightSide);
	}
}
