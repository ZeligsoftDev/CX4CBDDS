/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import static org.eclipse.emf.compare.utils.EMFComparePredicates.ofKind;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.AbstractDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;

/**
 * This implementation of a
 * {@link org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider} will be used to
 * group the differences by their {@link DifferenceKind kind} : additions, deletions, changes and moves.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class KindGroupProvider extends AbstractDifferenceGroupProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.AbstractBuildingDifferenceGroupProvider#buildGroups(org.eclipse.emf.compare.Comparison)
	 */
	@Override
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison comparison2) {
		final BasicDifferenceGroupImpl additions = new BasicDifferenceGroupImpl(getComparison(),
				ofKind(DifferenceKind.ADD),
				EMFCompareRCPUIMessages.getString("KindGroupProvider.addition.label"), //$NON-NLS-1$
				getCrossReferenceAdapter());
		additions.buildSubTree();
		final BasicDifferenceGroupImpl deletions = new BasicDifferenceGroupImpl(getComparison(),
				ofKind(DifferenceKind.DELETE),
				EMFCompareRCPUIMessages.getString("KindGroupProvider.deletion.label"), //$NON-NLS-1$
				getCrossReferenceAdapter());
		deletions.buildSubTree();
		final BasicDifferenceGroupImpl changes = new BasicDifferenceGroupImpl(getComparison(),
				ofKind(DifferenceKind.CHANGE),
				EMFCompareRCPUIMessages.getString("KindGroupProvider.change.label"), //$NON-NLS-1$
				getCrossReferenceAdapter());
		changes.buildSubTree();
		final BasicDifferenceGroupImpl moves = new BasicDifferenceGroupImpl(getComparison(),
				ofKind(DifferenceKind.MOVE),
				EMFCompareRCPUIMessages.getString("KindGroupProvider.move.label"), //$NON-NLS-1$
				getCrossReferenceAdapter());
		moves.buildSubTree();

		Collection<IDifferenceGroup> groups = Lists.newArrayList();
		if (!additions.getChildren().isEmpty()) {
			groups.add(additions);
		}
		if (!deletions.getChildren().isEmpty()) {
			groups.add(deletions);
		}
		if (!changes.getChildren().isEmpty()) {
			groups.add(changes);
		}
		if (!moves.getChildren().isEmpty()) {
			groups.add(moves);
		}
		return ImmutableList.copyOf(groups);
	}
}
