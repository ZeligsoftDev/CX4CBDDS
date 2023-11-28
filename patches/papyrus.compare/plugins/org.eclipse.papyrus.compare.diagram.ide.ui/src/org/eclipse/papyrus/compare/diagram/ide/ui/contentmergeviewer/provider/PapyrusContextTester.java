/*******************************************************************************
 * Copyright (c) 2016, 2017 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.provider;

import static org.eclipse.papyrus.compare.diagram.ide.ui.internal.context.PapyrusContextUtil.isPapyrusContext;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.AbstractContextTester;

/**
 * Indicates whether we are in a Papyrus context.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class PapyrusContextTester extends AbstractContextTester {

	/**
	 * A weak cache of comparisons that have been already been tested.
	 */
	private final Map<Comparison, Boolean> cache = new WeakHashMap<>();

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(Map<Object, Object> context) {
		Comparison comparison = getComparison(context);
		if (comparison != null) {
			Boolean result = cache.get(comparison);
			if (result == null) {
				result = Boolean.valueOf(isPapyrusContext(comparison));
				cache.put(comparison, result);
			}
			return result.booleanValue();
		}
		return false;
	}

}
