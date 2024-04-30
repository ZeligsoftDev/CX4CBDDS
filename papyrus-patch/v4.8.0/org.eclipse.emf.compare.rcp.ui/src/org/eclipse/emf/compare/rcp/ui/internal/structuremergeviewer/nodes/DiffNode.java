/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes;

import com.google.common.collect.Iterables;

import org.eclipse.emf.compare.Diff;

/**
 * This class is wrapper for TreeNode used to represent a diff TreeNode.
 * 
 * @author <a href="mailto:mathieu.cartaud@obeo.fr">Mathieu Cartaud</a>
 * @since 4.3
 */
public class DiffNode extends TreeNodeImpl {

	/**
	 * Constructor.
	 * 
	 * @param diff
	 *            The diff represented by this TreeNode
	 */
	public DiffNode(Diff diff) {
		setData(diff);
	}

	/**
	 * Add the given DiffNode to the children of this DiffNode. This is intended to be used only for refined
	 * diffs.
	 * 
	 * @param diffNode
	 *            The DiffNode to add
	 * @return <code>true</code> if the DiffNode has been added
	 */
	public boolean addRefinedDiffNode(DiffNode diffNode) {
		return getChildren().add(diffNode);
	}

	/**
	 * Remove the given DiffNode of the children of this DiffNode. This is intended to be used only for
	 * refined diffs.
	 * 
	 * @param diffNode
	 *            The DiffNode to remove
	 * @return <code>true</code> if the DiffNode has been removed
	 */
	public boolean removeRefinedDiffNode(DiffNode diffNode) {
		return getChildren().remove(diffNode);
	}

	/**
	 * Getter for the diff represented by this TreeNode.
	 * 
	 * @return the diff
	 */
	public Diff getDiff() {
		return (Diff)getData();
	}

	/**
	 * Get all the refined DiffNode that are part of this DiffNode.
	 * 
	 * @return an iterable of all refined DiffNode of this diff
	 */
	public Iterable<DiffNode> getRefinedDiffs() {
		return Iterables.filter(getChildren(), DiffNode.class);
	}

}
