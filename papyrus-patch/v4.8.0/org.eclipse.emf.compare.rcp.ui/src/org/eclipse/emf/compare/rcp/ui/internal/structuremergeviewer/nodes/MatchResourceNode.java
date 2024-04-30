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

import org.eclipse.emf.compare.MatchResource;

/**
 * This class is wrapper for TreeNode used to represent a match resource TreeNode.
 * 
 * @author <a href="mailto:mathieu.cartaud@obeo.fr">Mathieu Cartaud</a>
 * @since 4.3
 */
public class MatchResourceNode extends TreeNodeImpl {

	/**
	 * Constructor.
	 * 
	 * @param matchResource
	 *            The matchResource represented by this TreeNode
	 */
	public MatchResourceNode(MatchResource matchResource) {
		setData(matchResource);
	}

	/**
	 * Add the given DiffNode to the direct children of this MatchResourceNode.
	 * 
	 * @param diffNode
	 *            The DiffNode to add
	 * @return <code>true</code> if the MatchNode has been added
	 */
	public boolean addDiffNode(DiffNode diffNode) {
		return getChildren().add(diffNode);
	}

	/**
	 * Add the given MatchNode to the children of this MatchResourceNode.
	 * 
	 * @param matchNode
	 *            The MatchNode to add
	 * @return <code>true</code> if the MatchNode has been added
	 */
	public boolean addMatchNode(MatchNode matchNode) {
		return getChildren().add(matchNode);
	}

	/**
	 * Remove the given DiffNode of the direct children of this MatchResourceNode.
	 * 
	 * @param diffNode
	 *            The DiffNode to remove
	 * @return <code>true</code> if the DiffNode has been removed
	 */
	public boolean removeDiffNode(DiffNode diffNode) {
		return getChildren().remove(diffNode);
	}

	/**
	 * Remove the given MatchNode of the children of this MatchResourceNode.
	 * 
	 * @param matchNode
	 *            The MatchNode to remove
	 * @return <code>true</code> if the MatchNode has been removed
	 */
	public boolean removeMatchNode(MatchNode matchNode) {
		return getChildren().remove(matchNode);
	}

	/**
	 * Getter for the match resource represented by this TreeNode.
	 * 
	 * @return the matchResource
	 */
	public MatchResource getMatchResource() {
		return (MatchResource)getData();
	}

	/**
	 * Get all the match trees that are part of the MatchResource
	 * 
	 * @return an iterable of all MatchNode that are part of the MatchResource
	 */
	public Iterable<MatchNode> getMatches() {
		return Iterables.filter(getChildren(), MatchNode.class);
	}

}
