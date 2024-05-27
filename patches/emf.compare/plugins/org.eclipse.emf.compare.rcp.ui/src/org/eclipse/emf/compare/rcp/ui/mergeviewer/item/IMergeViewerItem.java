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
package org.eclipse.emf.compare.rcp.ui.mergeviewer.item;

import com.google.common.base.Predicate;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.ecore.EObject;

/**
 * An IMergeViewerItem associate a Diff and its left side, right side and ancestor side values. An
 * IMergeViewerItem also known its parent.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public interface IMergeViewerItem extends Adapter {

	/**
	 * A predicate to know if the given Item is an insertion point.
	 */
	Predicate<IMergeViewerItem> IS_INSERTION_POINT = new Predicate<IMergeViewerItem>() {
		public boolean apply(IMergeViewerItem item) {
			return item.isInsertionPoint();
		}
	};

	/**
	 * The Diff associated with the Item.
	 * 
	 * @return the Diff associated with the Item.
	 */
	Diff getDiff();

	/**
	 * Returns the left side value of the Diff.
	 * 
	 * @return the left side value of the Diff.
	 */
	Object getLeft();

	/**
	 * Returns the right side value of the Diff.
	 * 
	 * @return the right side value of the Diff.
	 */
	Object getRight();

	/**
	 * Returns the ancestor side value of the Diff.
	 * 
	 * @return the ancestor side value of the Diff.
	 */
	Object getAncestor();

	/**
	 * Returns the appropriate value according to the given side.
	 * 
	 * @param side
	 *            the given side.
	 * @return the appropriate value according to the given side.
	 */
	Object getSideValue(MergeViewerSide side);

	/**
	 * Returns the side of the Diff.
	 * 
	 * @return the side of the Diff.
	 */
	MergeViewerSide getSide();

	/**
	 * Returns true if the Item is an insertion point, false otherwise.
	 * 
	 * @return true if the Item is an insertion point, false otherwise.
	 */
	boolean isInsertionPoint();

	/**
	 * Returns the parent of this element. If the object is the root of a hierarchy <code>null</code> is
	 * returned.
	 * 
	 * @return the parent of this element, or <code>null</code> if the element has no parent
	 */
	Container getParent();

	/**
	 * An IMergeViewerItem.Container knows its children.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 * @deprecated IMergeViewerItem.Container is no longer needed since its functionality is now provided by
	 *             {@link org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemContentProvider
	 *             IMergeViewerItemContentProvider}. Use an {@link IMergeViewerItem} instead.
	 */
	@Deprecated
	interface Container extends IMergeViewerItem {
		/**
		 * Returns whether this container has at least one child. In some cases this methods avoids having to
		 * call the potential more costly <code>getChildren</code> method.
		 * 
		 * @param group
		 *            the active group provider.
		 * @param predicate
		 *            the active predicate.
		 * @return <code>true</code> if this container has at least one child
		 */
		boolean hasChildren(IDifferenceGroupProvider group, Predicate<? super EObject> predicate);

		/**
		 * Returns the children of this container. If this container has no children an empty array is
		 * returned (not <code>null</code>).
		 * 
		 * @param group
		 *            the active group provider.
		 * @param predicate
		 *            the active predicate.
		 * @return the children of this container as an array
		 */
		IMergeViewerItem[] getChildren(IDifferenceGroupProvider group, Predicate<? super EObject> predicate);
	}
}
