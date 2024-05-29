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
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender;

import java.util.Collection;

import org.eclipse.emf.edit.tree.TreeNode;

/**
 * Instances of this class will be used by EMF Compare in order to extend the children of TreeNodes containing
 * in the structure merge viewer.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public interface IDifferenceGroupExtender {

	/**
	 * Checks if the given TreeNode have to be handled by the extender.
	 * 
	 * @param treeNode
	 *            the given TreeNode.
	 * @return true if the TreeNode have to be handled, false otherwise.
	 */
	boolean handle(TreeNode treeNode);

	/**
	 * Add children to the given TreeNode.
	 * 
	 * @param treeNode
	 *            the given TreeNode.
	 */
	void addChildren(TreeNode treeNode);

	/**
	 * A registry of {@link IDifferenceGroupExtender}.
	 */
	interface Registry {

		/**
		 * Returns the list of {@link IDifferenceGroupExtender} contained in the registry.
		 * 
		 * @return The list of {@link IDifferenceGroupExtender} contained in the registry.
		 */
		Collection<IDifferenceGroupExtender> getExtenders();

		/**
		 * Add to the registry the given {@link IDifferenceGroupExtender}.
		 * 
		 * @param extender
		 *            The given {@link IDifferenceGroupExtender}.
		 * @return The previous value associated with the class name of the given
		 *         {@link IDifferenceGroupExtender}, or null if there was no entry in the registry for the
		 *         class name.
		 */
		IDifferenceGroupExtender add(IDifferenceGroupExtender extender);

		/**
		 * Remove from the registry the {@link IDifferenceGroupExtender} designated by the given
		 * {@link String} .
		 * 
		 * @param className
		 *            The given {@link String} representing a {@link IDifferenceGroupExtender}.
		 * @return The {@link IDifferenceGroupExtender} designated by the given {@link String}.
		 */
		IDifferenceGroupExtender remove(String className);

		/**
		 * Clear the registry.
		 */
		void clear();
	}
}
