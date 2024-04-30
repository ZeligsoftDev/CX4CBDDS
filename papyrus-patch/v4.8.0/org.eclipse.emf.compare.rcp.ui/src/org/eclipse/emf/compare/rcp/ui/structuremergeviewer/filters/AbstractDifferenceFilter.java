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
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;

/**
 * An abstract filter implementation.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public abstract class AbstractDifferenceFilter implements IDeactivableDiffFilter {

	/** A human-readable label for this filter. This will be displayed in the EMF Compare UI. */
	protected String label;

	/** {@link IDifferenceFilter#getDescription()} */
	protected String description;

	/** The initial activation state of the filter. */
	protected boolean activeByDefault;

	/**
	 * Whether this filter is active. A filter that is not active will not be used at all nor displayed in the
	 * compare editor.
	 */
	private boolean active;

	/**
	 * Constructs the filter with the appropriate predicate.
	 */
	public AbstractDifferenceFilter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getPredicateWhenSelected()
	 */
	public abstract Predicate<? super EObject> getPredicateWhenSelected();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getPredicateWhenUnselected()
	 */
	public Predicate<? super EObject> getPredicateWhenUnselected() {
		return Predicates.alwaysFalse();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#setLabel(java.lang.String)
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#defaultSelected()
	 */
	public boolean defaultSelected() {
		return activeByDefault;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDeactivableDiffFilter#isActive()
	 * @since 4.3
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#setDefaultSelected(boolean)
	 */
	public void setDefaultSelected(boolean active) {
		this.activeByDefault = active;
	}

	/**
	 * @since 4.3
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter#isEnabled(org.eclipse.emf.compare.scope.IComparisonScope,
	 *      org.eclipse.emf.compare.Comparison)
	 */
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return true;
	}

}
