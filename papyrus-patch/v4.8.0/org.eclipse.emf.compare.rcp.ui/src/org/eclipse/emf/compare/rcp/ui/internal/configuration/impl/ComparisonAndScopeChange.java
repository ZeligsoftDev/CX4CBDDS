/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.impl;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.configuration.ICompareEvent;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange;
import org.eclipse.emf.compare.scope.IComparisonScope;

public class ComparisonAndScopeChange implements ICompareEvent, IComparisonAndScopeChange {
	private Comparison oldComparison;

	private Comparison newComparison;

	private IComparisonScope oldScope;

	private IComparisonScope newScope;

	public ComparisonAndScopeChange(Comparison oldComparison, Comparison newComparison,
			IComparisonScope oldPredicate, IComparisonScope newScope) {
		this.oldComparison = oldComparison;
		this.newComparison = newComparison;
		this.oldScope = oldPredicate;
		this.newScope = newScope;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange#getOldComparison()
	 */
	public Comparison getOldComparison() {
		return oldComparison;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange#getNewComparison()
	 */
	public Comparison getNewComparison() {
		return newComparison;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange#getOldScope()
	 */
	public IComparisonScope getOldScope() {
		return oldScope;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange#getNewScope()
	 */
	public IComparisonScope getNewScope() {
		return newScope;
	}

}
