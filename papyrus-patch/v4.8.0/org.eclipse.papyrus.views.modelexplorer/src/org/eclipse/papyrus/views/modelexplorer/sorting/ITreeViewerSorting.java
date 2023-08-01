/*
 * Copyright (c) 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.views.modelexplorer.sorting;


/**
 * An optional adapter interface for sorting of the tree view of a workbench view.
 */
public interface ITreeViewerSorting {

	/** Sets whether the part's tree is sorted (whatever that means to the part). */
	void setSorted(boolean sorted);

	/** Queries whether the part's tree is sorted. */
	boolean isSorted();
}
