/*******************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal.structuremergeviewer.filters;

import static com.google.common.base.Predicates.notNull;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.Arrays;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.AbstractDifferenceFilter;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;

/**
 * <p>
 * A filter that excludes technical elements peculiar to Papyrus diagrams. These are, at least
 * </p>
 * <ul>
 * <li>addition of, deletion of, and changes in the applied stereotype comment shapes and links for
 * stereotypes that do not use them (in which case those views exist but are hidden from view)</li>
 * </ul>
 * 
 * @author Christian W. Damus
 */
public class PapyrusDiagramTechnicalElementsFilter extends AbstractDifferenceFilter {

	/**
	 * A predicate matching a hidden applied-stereotype comment shape or the link tethering such shape to the
	 * base element shape.
	 */
	private static final Predicate<EObject> IS_HIDDEN_STEREOTYPE_COMMENT_VIEW = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			if (!(input instanceof View)) {
				return false;
			}

			View view = (View)input;
			if (view.getType() == null) {
				return false;
			}

			boolean result;

			switch (view.getType()) {
				case "StereotypeCommentLink": //$NON-NLS-1$
					Edge edge = (Edge)view;
					View source = edge.getSource();
					View target = edge.getTarget();

					// Visibility is always implied by the connected nodes
					result = (source == null) || !isCSSVisible(source) //
							|| (target == null) || !isCSSVisible(target);
					break;
				case "StereotypeComment": //$NON-NLS-1$
					result = !isCSSVisible(view);
					break;
				default:
					result = false;
					break;
			}

			return result;
		}

		/**
		 * Determines a {@code view}'s visibility according to Papyrus's CSS-based scheme and the assumption
		 * that the default CSS styles for these applied-stereotype views are active that override the GMF
		 * default visibility from {@code true} to {@code false}.
		 * 
		 * @param view
		 *            a CSS-managed applied-stereotype view
		 * @return whether the {@code view} is CSSly visible
		 */
		private boolean isCSSVisible(View view) {
			// The view appears to be visible
			return view.isVisible()
					// and not by accident
					&& ForceValueHelper.isSet(view, NotationPackage.Literals.VIEW__VISIBLE, Boolean.TRUE);
		}
	};

	/**
	 * The predicate provided by this filter when it is selected.
	 */
	private static final Predicate<EObject> SELECTED_PREDICATE = new Predicate<EObject>() {
		public boolean apply(EObject input) {
			EObject data = input;
			if (input instanceof TreeNode) {
				data = ((TreeNode)input).getData();
			}

			Match match = null;
			if (data instanceof Match) {
				match = (Match)data;
			} else if (data instanceof Diff) {
				match = ((Diff)data).getMatch();
			}

			if (match != null) {
				// We don't show diffs where the view is hidden on all sides
				// where it exists
				return Iterables.all(getMatchedObjects(match), IS_HIDDEN_STEREOTYPE_COMMENT_VIEW);
			}

			return false;
		}
	};

	/**
	 * A predicate matching namespace URIs of Papyrus that we key on for the likely presence of
	 * applied-stereotype comments.
	 */
	private static final Predicate<String> IS_PAPYRUS_NAMESPACE = new Predicate<String>() {
		public boolean apply(String input) {
			// For example, the http://www.eclipse.org/papyrus/infra/gmfdiag/style namespace
			// for styles that always are instantiated in the applied-stereotype comments
			return input.startsWith("http://www.eclipse.org/papyrus/infra/gmfdiag/"); //$NON-NLS-1$
		}
	};

	/**
	 * Initializes me.
	 */
	public PapyrusDiagramTechnicalElementsFilter() {
		super();
	}

	@Override
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return (scope != null) && Iterables.any(scope.getNsURIs(), IS_PAPYRUS_NAMESPACE);
	}

	@Override
	public Predicate<? super EObject> getPredicateWhenSelected() {
		return SELECTED_PREDICATE;
	}

	/**
	 * Obtains an iterable over all of the objects matched by a {@code match}.
	 * 
	 * @param match
	 *            a match
	 * @return the one to three objects that it matches, in order the left (if any), then the right (if any),
	 *         and finally the ancestor (if any)
	 */
	static Iterable<EObject> getMatchedObjects(Match match) {
		return Iterables.filter(Arrays.asList(match.getLeft(), match.getRight(), match.getOrigin()),
				notNull());
	}

}
