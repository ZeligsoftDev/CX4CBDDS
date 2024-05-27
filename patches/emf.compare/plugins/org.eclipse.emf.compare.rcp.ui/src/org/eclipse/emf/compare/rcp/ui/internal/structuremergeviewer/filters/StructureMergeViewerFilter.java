/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - cache result
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters;

import static com.google.common.base.Predicates.alwaysFalse;
import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newLinkedHashSet;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.eventbus.EventBus;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.DifferenceFilterChange;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.provider.GroupItemProviderAdapter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.progress.PendingUpdateAdapter;

/**
 * This will be used by the structure viewer to filter out its list of differences according to a number of
 * provided predicates.
 * <p>
 * <b>Note</b> that this filter acts as an "OR" predicate between all provided ones, and that filters are
 * "exclude" filters. Basically, that means if the user selects two filters, any difference that applies for
 * any of these two filters will be <i>hidden</i> from the view, contrarily to "classic" {@link ViewerFilter}
 * that act as "AND" predicates for "include" filters, forcing any displayed element to meet the criterion of
 * all provided filters.
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class StructureMergeViewerFilter extends ViewerFilter {

	/** A predicate use by default that always returns false. */
	public static final Predicate<? super EObject> DEFAULT_PREDICATE = alwaysFalse();

	/** The set of predicates known by this filter. */
	private final Set<Predicate<? super EObject>> predicates;

	/** The set of selected filters known by this filter. */
	private final Set<IDifferenceFilter> selectedDifferenceFilters;

	/** The set of unselected filters known by this filter. */
	private final Set<IDifferenceFilter> unselectedDifferenceFilters;

	/** The set of active filters known by this filter. */
	private final Set<IDifferenceFilter> activeDifferenceFilters;

	/** The {@link EventBus} associated with this filter. */
	private final EventBus eventBus;

	/** The cached values for {@link #select(Viewer, Object, Object)}. */
	private final Map<Object, Boolean> selectedObjects;

	/**
	 * The predicate used by this StructureMergeViewerFilter.
	 */
	private final Predicate<? super EObject> viewerPredicate = new Predicate<EObject>() {
		public boolean apply(EObject eObject) {
			final boolean ret;
			if (aggregatedPredicate.apply(eObject)) {
				Collection<EObject> eContents = eObject.eContents();
				if (!eContents.isEmpty() && eObject instanceof TreeNode) {
					EObject data = ((TreeNode)eObject).getData();
					if (data instanceof Match || data instanceof Conflict || data instanceof MatchResource) {
						ret = any(eContents, viewerPredicate);
					} else {
						ret = true;
					}
				} else {
					ret = true;
				}
			} else {
				ret = false;
			}
			return ret;
		}
	};

	/**
	 * A predicate that aggregates the selected state predicates of selected filters and the unselected state
	 * predicates of unselected filters.
	 */
	private Predicate<? super EObject> aggregatedPredicate;

	/**
	 * Constructs the difference filter.
	 * 
	 * @param eventBus
	 *            The {@link EventBus} which will be associated with this filter.
	 */
	public StructureMergeViewerFilter(EventBus eventBus) {
		this.eventBus = eventBus;
		this.predicates = newLinkedHashSet();
		this.selectedDifferenceFilters = newLinkedHashSet();
		this.unselectedDifferenceFilters = newLinkedHashSet();
		this.activeDifferenceFilters = newLinkedHashSet();
		this.aggregatedPredicate = DEFAULT_PREDICATE;
		this.selectedObjects = newHashMap();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (predicates.isEmpty()) {
			return true;
		}

		Boolean cachedResult = selectedObjects.get(element);
		if (cachedResult != null) {
			return cachedResult.booleanValue();
		}

		final boolean result;
		if (element instanceof GroupItemProviderAdapter) {
			Collection<?> children = ((GroupItemProviderAdapter)element).getChildren(element);
			result = any(Iterables.filter(children, EObject.class), viewerPredicate);
		} else if (element instanceof PendingUpdateAdapter) {
			result = true;
		} else if (element instanceof Adapter) {
			Notifier notifier = ((Adapter)element).getTarget();
			if (notifier instanceof EObject) {
				EObject eObject = (EObject)notifier;
				result = viewerPredicate.apply(eObject);
			} else {
				result = true;
			}
		} else if (element instanceof EObject) {
			result = viewerPredicate.apply((EObject)element);
		} else {
			result = true;
		}

		selectedObjects.put(element, Boolean.valueOf(result));
		return result;
	}

	/**
	 * Add the predicate of the given {@link IDifferenceFilter}.
	 * 
	 * @param filter
	 *            The given {@link IDifferenceFilter}.
	 */
	public void addFilter(IDifferenceFilter filter) {
		boolean changed = predicates.remove(filter.getPredicateWhenUnselected());
		changed = predicates.add(filter.getPredicateWhenSelected()) || changed;

		changed = selectedDifferenceFilters.add(filter) || changed;
		changed = unselectedDifferenceFilters.remove(filter) || changed;

		if (changed) {
			clearCache();
			aggregatedPredicate = computeAggregatedPredicate();
			eventBus.post(new DifferenceFilterChange(aggregatedPredicate, selectedDifferenceFilters,
					unselectedDifferenceFilters));
		}
	}

	/**
	 * Computes the aggregated predicates composed of selected state predicates of selected filters and
	 * unselected state predicates of unselected filters.
	 * 
	 * @return an aggregated predicates composed of selected state predicates of selected filters and
	 *         unselected state predicates of unselected filters.
	 */
	private Predicate<? super EObject> computeAggregatedPredicate() {
		clearCache();
		return not(or(predicates));
	}

	/**
	 * Clears the cached results.
	 */
	private void clearCache() {
		selectedObjects.clear();
	}

	/**
	 * Remove the predicate of the given {@link IDifferenceFilter}.
	 * 
	 * @param filter
	 *            The given {@link IDifferenceFilter}.
	 */
	public void removeFilter(IDifferenceFilter filter) {
		boolean changed = predicates.add(filter.getPredicateWhenUnselected());
		changed |= predicates.remove(filter.getPredicateWhenSelected());

		changed |= unselectedDifferenceFilters.add(filter);
		changed |= selectedDifferenceFilters.remove(filter);

		if (changed) {
			clearCache();
			aggregatedPredicate = computeAggregatedPredicate();
			eventBus.post(new DifferenceFilterChange(aggregatedPredicate, selectedDifferenceFilters,
					unselectedDifferenceFilters));
		}
	}

	/**
	 * Init this StructureMergeViewerFilter.
	 * 
	 * @param selectedFilters
	 *            the set of selected filters known by this filter.
	 * @param unselectedFilters
	 *            the set of unselected filters known by this filter.
	 * @param activeFilters
	 *            the set of activated filters known by this filter.
	 */
	public void init(Collection<IDifferenceFilter> selectedFilters,
			Collection<IDifferenceFilter> unselectedFilters, Collection<IDifferenceFilter> activeFilters) {
		boolean changed = false;

		if (!predicates.isEmpty()) {
			predicates.clear();
			changed = true;
		}

		activeDifferenceFilters.addAll(activeFilters);

		for (IDifferenceFilter filter : selectedFilters) {
			changed = predicates.add(filter.getPredicateWhenSelected()) || changed;
			changed = selectedDifferenceFilters.add(filter) || changed;
		}
		for (IDifferenceFilter filter : unselectedFilters) {
			changed = predicates.add(filter.getPredicateWhenUnselected()) || changed;
			changed = unselectedDifferenceFilters.add(filter) || changed;
		}

		if (changed) {
			aggregatedPredicate = computeAggregatedPredicate();
			eventBus.post(new DifferenceFilterChange(aggregatedPredicate, selectedDifferenceFilters,
					unselectedDifferenceFilters));
		}
	}

	/**
	 * Returns the set of selected filters known by this filter.
	 * 
	 * @return the selectedDifferenceFilters the set of selected filters known by this filter.
	 */
	public Set<IDifferenceFilter> getSelectedDifferenceFilters() {
		return selectedDifferenceFilters;
	}

	/**
	 * Returns the set of activated filters known by this filter.
	 * 
	 * @return the activatedDifferenceFilters the set of activated filters known by this filter.
	 */
	public Set<IDifferenceFilter> getActiveDifferenceFilters() {
		return activeDifferenceFilters;
	}

	/**
	 * Returns the set of unselected filters known by this viewer.
	 * 
	 * @return the unselectedDifferenceFilters the set of unselected filters known by this viewer.
	 */
	public Set<IDifferenceFilter> getUnSelectedDifferenceFilters() {
		return ImmutableSet.copyOf(unselectedDifferenceFilters);
	}

	/**
	 * Returns the predicate that aggregates the selected state predicates of selected filters and the
	 * unselected state predicates of unselected filters.
	 * 
	 * @return the predicate that aggregates the selected state predicates of selected filters and the
	 *         unselected state predicates of unselected filters.
	 */
	public Predicate<? super EObject> getAggregatedPredicate() {
		return aggregatedPredicate;
	}
}
