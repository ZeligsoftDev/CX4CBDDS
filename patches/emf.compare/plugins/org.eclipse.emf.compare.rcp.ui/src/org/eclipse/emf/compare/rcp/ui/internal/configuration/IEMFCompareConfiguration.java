/*******************************************************************************
 * Copyright (c) 2013, 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 514079
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration;

import com.google.common.eventbus.EventBus;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.merge.IDiffRelationshipComputer;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.StructureMergeViewerFilter;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.StructureMergeViewerGrouper;
import org.eclipse.emf.compare.scope.IComparisonScope;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public interface IEMFCompareConfiguration {

	EventBus getEventBus();

	ICompareEditingDomain getEditingDomain();

	void setEditingDomain(ICompareEditingDomain editingDomain);

	StructureMergeViewerGrouper getStructureMergeViewerGrouper();

	StructureMergeViewerFilter getStructureMergeViewerFilter();

	AdapterFactory getAdapterFactory();

	void setAdapterFactory(AdapterFactory adapterFactory);

	boolean isLeftEditable();

	boolean isRightEditable();

	Comparison getComparison();

	void setComparisonAndScope(Comparison comparison, IComparisonScope comparisonScope);

	IComparisonScope getComparisonScope();

	EMFCompare getEMFComparator();

	void setEMFComparator(EMFCompare comparator);

	MergeMode getMergePreviewMode();

	void setMergePreviewMode(MergeMode mergePreviewMode);

	IDiffRelationshipComputer getDiffRelationshipComputer();

	void setDiffRelationshipComputer(IDiffRelationshipComputer diffRelationshipComputer);

	boolean getBooleanProperty(String key, boolean dflt);

	boolean isMirrored();
}
