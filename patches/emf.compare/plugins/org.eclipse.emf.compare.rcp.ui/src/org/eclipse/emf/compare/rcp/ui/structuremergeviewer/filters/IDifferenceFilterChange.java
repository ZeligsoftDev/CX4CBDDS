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
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters;

import com.google.common.base.Predicate;

import java.util.Collection;

import org.eclipse.emf.compare.rcp.ui.configuration.ICompareEvent;
import org.eclipse.emf.ecore.EObject;

/**
 * Stores selected and unselected filters, and a predicate that aggregates the selected state predicates of
 * selected filters and the unselected state predicates of unselected filters. It will be used when a change
 * of selected filters occurs.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public interface IDifferenceFilterChange extends ICompareEvent {

	/**
	 * Returns a {@link Predicate} that aggregates the selected state predicates of selected filters and the
	 * unselected state predicates of unselected filters.
	 * 
	 * @return a predicate that aggregates the selected state predicates of selected filters and the
	 *         unselected state predicates of unselected filters.
	 */

	Predicate<? super EObject> getPredicate();

	/**
	 * Returns the list of selected {@link IDifferenceFilter}.
	 * 
	 * @return the list of selected filters.
	 */
	Collection<IDifferenceFilter> getSelectedDifferenceFilters();

	/**
	 * Returns the list of unselected {@link IDifferenceFilter}.
	 * 
	 * @return the list of unselected filters.
	 */
	Collection<IDifferenceFilter> getUnselectedDifferenceFilters();

}
