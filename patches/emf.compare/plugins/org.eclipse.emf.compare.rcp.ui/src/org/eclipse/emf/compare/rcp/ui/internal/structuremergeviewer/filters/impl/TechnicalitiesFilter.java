/*******************************************************************************
 * Copyright (c) 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 501864
 *     Tanja Mayerhofer - bug 501864
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Iterators.any;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.canBeConsideredAsPseudoConflicting;

import com.google.common.base.Predicate;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * <p>
 * A filter used by default that rejects all 'technical' differences. The technical differences are the diffs
 * that apply on empty {@link MatchResource}s, on {@link FeatureMap} diffs, on identical elements and on
 * pseudo-conflicts.
 * </p>
 * This filter aggregates the former 4 corresponding filters.
 * 
 * @author <a href="mailto:mathieu.cartaud@obeo.fr">Mathieu Cartaud</a>
 */
public class TechnicalitiesFilter extends AbstractDifferenceFilter {

	/**
	 * The predicate use to filter empty match resources.
	 */
	private static final Predicate<? super EObject> PREDICATE_EMPTY_MATCH_RESOURCES = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			boolean ret = false;
			if (input instanceof TreeNode) {
				TreeNode treeNode = (TreeNode)input;
				if (treeNode.getData() instanceof MatchResource) {
					ret = treeNode.getChildren().isEmpty();
				}
			}
			return ret;
		}
	};

	/**
	 * The predicate use to filter feature maps.
	 */
	private static final Predicate<? super EObject> PREDICATE_FEATURE_MAP = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			boolean ret = false;
			if (input instanceof TreeNode) {
				EObject data = ((TreeNode)input).getData();
				if (data instanceof FeatureMapChange) {
					ret = ((FeatureMapChange)data).getEquivalence() != null;
				}
			}
			return ret;
		}
	};

	/**
	 * The predicate use to filter pseudo conflicts.
	 */
	private static final Predicate<? super EObject> PREDICATE_PSEUDO_CONFLICT = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			boolean ret = false;
			if (input instanceof TreeNode) {
				TreeNode treeNode = (TreeNode)input;
				EObject data = treeNode.getData();
				if (data instanceof Diff) {
					Diff diff = (Diff)data;
					if (diff.getMatch().getComparison().isThreeWay()) {
						ret = canBeConsideredAsPseudoConflicting().apply(diff);
					}
				}
			}
			return ret;
		}
	};

	/**
	 * The predicate use to filter identical elements.
	 */
	private static final Predicate<? super EObject> PREDICATE_IDENTICAL_ELEMENTS = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			if (input instanceof TreeNode) {
				TreeNode treeNode = (TreeNode)input;
				EObject data = treeNode.getData();
				if (data instanceof Match) {
					return !any(treeNode.eAllContents(), DATA_IS_DIFF);
				}
			}
			return false;
		}
	};

	/**
	 * The predicate use by this filter when it is selected.
	 */
	@SuppressWarnings("unchecked")
	private static final Predicate<? super EObject> PREDICATE_WHEN_SELECTED = or(
			PREDICATE_EMPTY_MATCH_RESOURCES, PREDICATE_FEATURE_MAP, PREDICATE_IDENTICAL_ELEMENTS,
			PREDICATE_PSEUDO_CONFLICT);

	/**
	 * Predicate to know if the given TreeNode is a diff.
	 */
	private static final Predicate<EObject> DATA_IS_DIFF = new Predicate<EObject>() {
		public boolean apply(EObject treeNode) {
			return treeNode instanceof TreeNode && ((TreeNode)treeNode).getData() instanceof Diff;
		}
	};

	@Override
	public Predicate<? super EObject> getPredicateWhenSelected() {
		return PREDICATE_WHEN_SELECTED;
	}

}
