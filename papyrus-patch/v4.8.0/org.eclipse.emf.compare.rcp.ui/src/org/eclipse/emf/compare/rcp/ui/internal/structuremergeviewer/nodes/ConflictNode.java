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

import org.eclipse.emf.compare.Conflict;

/**
 * This class is wrapper for TreeNode used to represent a conflict TreeNode.
 * 
 * @author <a href="mailto:mathieu.cartaud@obeo.fr">Mathieu Cartaud</a>
 * @since 4.3
 */
public class ConflictNode extends TreeNodeImpl {

	/**
	 * Constructor.
	 * 
	 * @param conflict
	 *            The conflict represented by this TreeNode
	 */
	public ConflictNode(Conflict conflict) {
		setData(conflict);
	}

	/**
	 * Add the given MatchNode to the children of this ConflictNode.
	 * 
	 * @param matchNode
	 *            The MatchNode to add
	 * @return <code>true</code> if the MatchNode has been added
	 */
	public boolean addConflictingTree(MatchNode matchNode) {
		return getChildren().add(matchNode);
	}

	/**
	 * Remove the given MatchNode of the children of this ConflictNode.
	 * 
	 * @param matchNode
	 *            The MatchNode to remove
	 * @return <code>true</code> if the MatchNode has been removed
	 */
	public boolean removeConflictingTree(MatchNode matchNode) {
		return getChildren().remove(matchNode);
	}

	/**
	 * Getter for the conflict represented by this TreeNode.
	 * 
	 * @return the conflict
	 */
	public Conflict getConflict() {
		return (Conflict)getData();
	}

	/**
	 * Get all the match trees that are part of the conflict
	 * 
	 * @return an iterable of all MatchNode that are part of the conflict
	 */
	public Iterable<MatchNode> getConflictingTrees() {
		return Iterables.filter(getChildren(), MatchNode.class);
	}

}
