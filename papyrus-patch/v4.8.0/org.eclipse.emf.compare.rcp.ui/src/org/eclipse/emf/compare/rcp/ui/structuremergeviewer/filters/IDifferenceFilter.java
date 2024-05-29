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

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;

/**
 * Instances of this class will be used by EMF Compare in order to provide difference filter facilities to the
 * structural differences view.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public interface IDifferenceFilter {

	/**
	 * Returns the predicate that will filter out objects in the structural differences view when this filter
	 * will be selected.
	 * 
	 * @return the predicate that will filter out objects in the structural differences view when this filter
	 *         will be selected.
	 */
	Predicate<? super EObject> getPredicateWhenSelected();

	/**
	 * Returns the predicate that will filter out objects in the structural differences view when this filter
	 * will be unselected.
	 * 
	 * @return the predicate that will filter out objects in the structural differences view when this filter
	 *         will be unselected.
	 */
	Predicate<? super EObject> getPredicateWhenUnselected();

	/**
	 * A human-readable label for this filter. This will be displayed in the EMF Compare UI.
	 * 
	 * @return The label for this filter.
	 */
	String getLabel();

	/**
	 * Set the label for this filter. This will be displayed in the EMF Compare UI.
	 * 
	 * @param label
	 *            A human-readable label for this filter.
	 */
	void setLabel(String label);

	/**
	 * A human-readable description for this filter. This will be displayed in the EMF Compare UI.
	 * 
	 * @return Description or <code>null</code>
	 */
	String getDescription();

	/**
	 * Set the description for this filter. This will be displayed in the EMF Compare UI.
	 * 
	 * @param description
	 *            A human-readable description for this filter.
	 */
	void setDescription(String description);

	/**
	 * Returns the initial activation state that the filter should have.
	 * 
	 * @return The initial activation state that the filter should have.
	 */
	boolean defaultSelected();

	/**
	 * Set the initial activation state that the filter should have.
	 * 
	 * @param defaultSelected
	 *            The initial activation state that the filter should have (true if the filter should be
	 *            active by default).
	 */
	void setDefaultSelected(boolean defaultSelected);

	/**
	 * Returns the activation condition based on the scope and comparison objects.
	 * 
	 * @param scope
	 *            The scope on which the filter will be applied.
	 * @param comparison
	 *            The comparison which is to be displayed in the structural view.
	 * @return The activation condition based on the scope and comparison objects.
	 */
	boolean isEnabled(IComparisonScope scope, Comparison comparison);

	/**
	 * A registry of {@link IDifferenceFilter}.
	 * 
	 * @since 4.0
	 */
	interface Registry {

		/**
		 * Returns the list of {@link IDifferenceFilter} contained in the registry.
		 * 
		 * @param scope
		 *            The scope on which the filters will be applied.
		 * @param comparison
		 *            The comparison which is to be displayed in the structural view.
		 * @return The list of {@link IDifferenceFilter} contained in the registry.
		 */
		Collection<IDifferenceFilter> getFilters(IComparisonScope scope, Comparison comparison);

		/**
		 * Add to the registry the given {@link IDifferenceFilter}.
		 * 
		 * @param filter
		 *            The given {@link IDifferenceFilter}.
		 * @return The previous value associated with the class name of the given {@link IDifferenceFilter},
		 *         or null if there was no entry in the registry for the class name.
		 */
		IDifferenceFilter add(IDifferenceFilter filter);

		/**
		 * Remove from the registry the {@link IDifferenceFilter} designated by the given {@link String} .
		 * 
		 * @param className
		 *            The given {@link String} representing a {@link IDifferenceFilter}.
		 * @return The {@link IDifferenceFilter} designated by the given {@link String}.
		 */
		IDifferenceFilter remove(String className);

		/**
		 * Clear the registry.
		 */
		void clear();
	}

}
