/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups;

import com.google.common.base.Function;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.provider.utils.IStyledString;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.BasicDifferenceGroupImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.swt.graphics.Image;

/**
 * This interface represents an EMF Compare "group" of differences that can be displayed in the structural
 * differences viewer of the UI.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @see BasicDifferenceGroupImpl
 * @since 4.0
 */
public interface IDifferenceGroup extends Adapter {

	/**
	 * Function that retrieve the data of the given TreeNode.
	 */
	Function<EObject, EObject> TREE_NODE_DATA = new Function<EObject, EObject>() {
		public EObject apply(EObject node) {
			final EObject data;
			if (node instanceof TreeNode) {
				data = ((TreeNode)node).getData();
			} else {
				data = node;
			}
			return data;
		}
	};

	/**
	 * A human-readable label for this group.
	 * 
	 * @return A human-readable label for this group that can be displayed to the user.
	 */
	String getName();

	/**
	 * The styled label for the this group. This will be displayed in the EMF Compare UI.
	 * 
	 * @return A human-readable styled label for this group that can be displayed to the user.
	 */
	IStyledString.IComposedStyledString getStyledName();

	/**
	 * The icon that is to be used for this group in the compare UI.
	 * 
	 * @return Icon that is to be used for this group in the compare UI. If {@code null}, a default image will
	 *         be used instead.
	 */
	Image getImage();

	/**
	 * The list of TreeNode containded in this group.
	 * 
	 * @return the list of TreeNode containded in this group.
	 */
	List<? extends TreeNode> getChildren();

	/**
	 * Dispose this group provider.
	 */
	void dispose();
}
