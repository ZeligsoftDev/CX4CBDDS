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
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import static com.google.common.base.Predicates.alwaysTrue;

import com.google.common.collect.ImmutableList;

import java.util.Collection;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.AbstractDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;

/**
 * This implementation of a
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider} will be used as
 * the default group provider.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class DefaultGroupProvider extends AbstractDifferenceGroupProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.AbstractBuildingDifferenceGroupProvider#buildGroups(org.eclipse.emf.compare.Comparison)
	 */
	@Override
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison comparison2) {
		BasicDifferenceGroupImpl group = new BasicDifferenceGroupImpl(getComparison(), alwaysTrue(),
				getCrossReferenceAdapter());

		group.buildSubTree();
		return ImmutableList.of(group);
	}
}
