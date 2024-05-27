/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl;

import com.google.common.base.Predicate;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilterChange;
import org.eclipse.emf.ecore.EObject;

/**
 * The default implementation of {@link IDifferenceFilterChange}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class DifferenceFilterChange implements IDifferenceFilterChange {

	/**
	 * The predicate that aggregates the selected state predicates of selected filters and the unselected
	 * state predicates of unselected filters.
	 */
	private final Predicate<? super EObject> predicate;

	/**
	 * The list of selected filters.
	 */
	private final Set<IDifferenceFilter> selectedDifferenceFilters;

	/**
	 * The list of unselected filters.
	 */
	private final Set<IDifferenceFilter> unselectedDifferenceFilters;

	/**
	 * Default Constructor.
	 * 
	 * @param predicate
	 *            a predicate that aggregates the selected state predicates of selected filters and the
	 *            unselected state predicates of unselected filters.
	 * @param selectedDifferenceFilters
	 *            the list of selected filters.
	 * @param unselectedDifferenceFilters
	 *            the list of unselected filters.
	 */
	public DifferenceFilterChange(Predicate<? super EObject> predicate,
			Set<IDifferenceFilter> selectedDifferenceFilters,
			Set<IDifferenceFilter> unselectedDifferenceFilters) {
		this.predicate = predicate;
		this.selectedDifferenceFilters = selectedDifferenceFilters;
		this.unselectedDifferenceFilters = unselectedDifferenceFilters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilterChange#getPredicate()
	 */
	public Predicate<? super EObject> getPredicate() {
		return predicate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilterChange#getSelectedDifferenceFilters()
	 */
	public Collection<IDifferenceFilter> getSelectedDifferenceFilters() {
		return selectedDifferenceFilters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilterChange#getUnselectedDifferenceFilters()
	 */
	public Collection<IDifferenceFilter> getUnselectedDifferenceFilters() {
		return unselectedDifferenceFilters;
	}

}
