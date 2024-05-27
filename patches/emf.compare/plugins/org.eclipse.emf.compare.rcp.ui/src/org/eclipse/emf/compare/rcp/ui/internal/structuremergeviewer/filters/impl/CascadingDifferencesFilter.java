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
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl;

import static org.eclipse.emf.compare.ConflictKind.REAL;
import static org.eclipse.emf.compare.DifferenceKind.ADD;
import static org.eclipse.emf.compare.DifferenceKind.DELETE;
import static org.eclipse.emf.compare.DifferenceKind.MOVE;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.CONTAINMENT_REFERENCE_CHANGE;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.fromSide;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.hasNoDirectOrIndirectConflict;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.ofKind;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.match.MatchOfContainmentReferenceChangeAdapter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * A filter used by default that filters out cascading differences (differences located under a Match that is
 * either ADDed or DELETEd on the diff's side). The MOVE differences are not hidden by this filter.
 * Differences hidden are all those that match the following criteria:
 * <ul>
 * <li>this.kind != MOVE</li>
 * <li>this.conflict == null && this.'indirect real conflicts' is empty</li>
 * <li>this.refines is empty</li>
 * <li>this is located inside a TreeNode that represents a Match that is either ADDed or DELETEd, and for
 * which the diff that represents this addition or deletion is not refined by this.</li>
 * </ul>
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class CascadingDifferencesFilter extends AbstractDifferenceFilter {

	/**
	 * The predicate used by this filter when it is selected.
	 */
	private static final Predicate<? super EObject> PREDICATE_WHEN_SELECTED = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			boolean ret = false;
			if (input instanceof TreeNode) {
				TreeNode treeNode = (TreeNode)input;
				EObject data = treeNode.getData();
				if (data instanceof Diff && !(data instanceof ResourceAttachmentChange)) {
					Diff diff = (Diff)data;
					if (diff.getKind() != MOVE && hasNoDirectOrIndirectConflict(REAL).apply(diff)
							&& diff.getRefines().isEmpty()) {
						TreeNode parent = treeNode.getParent();
						if (parent != null && parent.getData() instanceof Match) {
							Match parentMatch = (Match)parent.getData();
							ret = isInsideAddOrDeleteTreeNode(diff, parent);
							if (!ret && isAddOrDeleteMatch(parentMatch, diff.getSource())) {
								ret = !Predicates
										.and(Predicates.or(CONTAINMENT_REFERENCE_CHANGE,
												REFINED_BY_CONTAINMENT_REF_CHANGE), ofKind(ADD, DELETE))
										.apply(diff);
							}
						}
					}
				}
			}
			return ret;
		}

		private boolean isInsideAddOrDeleteTreeNode(Diff diff, TreeNode parent) {
			boolean ret = false;
			DifferenceSource side = diff.getSource();
			TreeNode grandParent = parent.getParent();
			Match grandParentMatch = null;
			if (grandParent != null && grandParent.getData() instanceof Match) {
				grandParentMatch = (Match)grandParent.getData();
			}
			if (isAddOrDeleteMatch(grandParentMatch, side)) {
				// The ancestor has been added/deleted, we must filter the current diff
				// _unless_ it is refined by the diff that represents the grand-parent
				// add/delete
				Diff addOrDeleteDiff = findAddOrDeleteDiff(grandParentMatch, side);
				if (addOrDeleteDiff != null) {
					if (diff.getRefinedBy().contains(addOrDeleteDiff)) {
						// recurse
						ret = isInsideAddOrDeleteTreeNode(diff, grandParent);
					} else {
						ret = true;
					}
				}
			}
			return ret;
		}

		private Diff findAddOrDeleteDiff(Match match, DifferenceSource side) {
			final Iterable<Diff> addOrDeleteContainmentDiffs = MatchUtil
					.findAddOrDeleteContainmentDiffs(match);
			if (addOrDeleteContainmentDiffs != null) {
				final UnmodifiableIterator<Diff> sideChanges = Iterators
						.filter(addOrDeleteContainmentDiffs.iterator(), fromSide(side));
				if (sideChanges.hasNext()) {
					return sideChanges.next();
				}
			}
			return null;
		}

		/**
		 * Indicate whether a Match is that of an object that was either added or deleted on the given side.
		 * 
		 * @param match
		 *            The match
		 * @param side
		 *            The side
		 * @return <code>true</code> if the matched object is present on side but not on origin or vice-versa.
		 *         <code>false</code> if match is <code>null</code>.
		 */
		protected boolean isAddOrDeleteMatch(Match match, DifferenceSource side) {
			if (match == null) {
				return false;
			}
			Adapter adapter = EcoreUtil.getAdapter(match.eAdapters(),
					MatchOfContainmentReferenceChangeAdapter.class);
			return adapter != null;
		}
	};

	private static final Predicate<Diff> REFINED_BY_CONTAINMENT_REF_CHANGE = new Predicate<Diff>() {
		public boolean apply(Diff input) {
			return Iterables.any(input.getRefinedBy(), CONTAINMENT_REFERENCE_CHANGE);
		}
	};

	@Override
	public Predicate<? super EObject> getPredicateWhenSelected() {
		return PREDICATE_WHEN_SELECTED;
	}
}
