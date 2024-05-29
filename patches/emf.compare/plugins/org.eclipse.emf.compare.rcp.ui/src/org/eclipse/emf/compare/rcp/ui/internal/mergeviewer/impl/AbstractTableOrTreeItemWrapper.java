/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 527567
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;

/**
 * A wrapper of Table Item or Tree Item.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractTableOrTreeItemWrapper {

	/**
	 * Create an ItemWrapper from an Item.
	 * 
	 * @param item
	 *            the given Item.
	 * @return the wrapped Item.
	 */
	public static AbstractTableOrTreeItemWrapper create(Item item) {
		final AbstractTableOrTreeItemWrapper wrapper;
		if (item instanceof TreeItem) {
			wrapper = new TreeItemWrapper((TreeItem)item);
		} else if (item instanceof TableItem) {
			wrapper = new TableItemWrapper((TableItem)item);
		} else if (item == null) {
			wrapper = null;
		} else {
			throw new IllegalArgumentException("Item must be instance of TreeItem or TableItem"); //$NON-NLS-1$
		}
		return wrapper;
	}

	/**
	 * Returns the wrapped Item.
	 * 
	 * @return the wrapped Item.
	 */
	protected abstract Item getItem();

	/**
	 * returns the bounds (as Rectangle) of the Item.
	 * 
	 * @return the bounds (as Rectangle) of the Item.
	 */
	public abstract Rectangle getBounds();

	/**
	 * Returns the parent of the Item.
	 * 
	 * @return the parent of the Item.
	 */
	public abstract Scrollable getParent();

	/**
	 * Returns the number of columns contained in the receiver.
	 * 
	 * @return the number of columns contained in the receiver.
	 */
	public abstract int getParentColumnCount();

	/**
	 * Returns a rectangle describing the size and location relative to its parent of an image at a column in
	 * the tree or the table.
	 * 
	 * @param index
	 *            the index that specifies the column.
	 * @return a rectangle describing the size and location relative to its parent of an image at a column in
	 *         the tree or the table.
	 */
	public abstract Rectangle getImageBounds(int index);

	/**
	 * Returns a rectangle describing the size and location relative to its parent of the text at a column in
	 * the tree or the table.
	 * 
	 * @param index
	 *            the index that specifies the column.
	 * @return a rectangle describing the size and location relative to its parent of the text at a column in
	 *         the tree or the table.
	 */
	public abstract Rectangle getTextBounds(int index);

	/**
	 * Returns the text stored at the given column index in the receiver, or empty string if the text has not
	 * been set.
	 * 
	 * @param index
	 *            the index that specifies the column.
	 * @return the text stored at the given column index in the receiver, or empty string if the text has not
	 *         been set.
	 */
	public abstract String getText(int index);

	/**
	 * Returns the image stored at the given column index in the receiver, or null if the image has not been
	 * set or if the column does not exist.
	 * 
	 * @param index
	 *            the index that specifies the column.
	 * @return the image stored at the given column index in the receiver, or null if the image has not been
	 *         set or if the column does not exist.
	 */
	public abstract Image getImage(int index);

	/**
	 * Returns the parent Item of the receiver.
	 * 
	 * @return the parent Item of the receiver.
	 */
	public abstract AbstractTableOrTreeItemWrapper getParentItem();

	/**
	 * Returns the height of the area which would be used to display the parent item of an Item of the tree or
	 * the table.
	 * 
	 * @return the height of the area which would be used to display the parent item of an Item of the tree or
	 *         the table.
	 */
	public abstract int getParentItemHeight();

	/**
	 * Returns whether the receiver can be expanded to show children.
	 * 
	 * @return whether the receiver can be expanded to show children.
	 */
	public boolean isExpandable() {
		return false;
	}

	/**
	 * Returns the data associated to the Item.
	 * 
	 * @return the data associated to the Item.
	 */
	public Object getData() {
		return getItem().getData();
	}

	/**
	 * A wrapper of Tree Item.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	private static class TreeItemWrapper extends AbstractTableOrTreeItemWrapper {

		/**
		 * The wrapped Tree Item.
		 */
		private final TreeItem fItem;

		/**
		 * Default constructor.
		 * 
		 * @param item
		 *            the TreeItem to wrap.
		 */
		public TreeItemWrapper(TreeItem item) {
			fItem = item;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getItem()
		 */
		@Override
		protected Item getItem() {
			return fItem;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getBounds()
		 */
		@Override
		public Rectangle getBounds() {
			return fItem.getBounds();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParent()
		 */
		@Override
		public Scrollable getParent() {
			return fItem.getParent();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentColumnCount()
		 */
		@Override
		public int getParentColumnCount() {
			return fItem.getParent().getColumnCount();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getImageBounds(int)
		 */
		@Override
		public Rectangle getImageBounds(int index) {
			return fItem.getImageBounds(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentItem()
		 */
		@Override
		public AbstractTableOrTreeItemWrapper getParentItem() {
			return AbstractTableOrTreeItemWrapper.create(fItem.getParentItem());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentItemHeight()
		 */
		@Override
		public int getParentItemHeight() {
			return fItem.getParent().getItemHeight();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#isExpandable()
		 */
		@Override
		public boolean isExpandable() {
			return fItem.getItemCount() > 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getTextBounds(int)
		 */
		@Override
		public Rectangle getTextBounds(int index) {
			return fItem.getTextBounds(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getText(int)
		 */
		@Override
		public String getText(int index) {
			return fItem.getText(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getImage(int)
		 */
		@Override
		public Image getImage(int index) {
			return fItem.getImage(index);
		}

	}

	/**
	 * A wrapper of Table Item.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	private static class TableItemWrapper extends AbstractTableOrTreeItemWrapper {

		/**
		 * The wrapped Table Item.
		 */
		private final TableItem fItem;

		/**
		 * Default constructor.
		 * 
		 * @param item
		 *            the TableItem to wrap.
		 */
		public TableItemWrapper(TableItem item) {
			fItem = item;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getItem()
		 */
		@Override
		protected Item getItem() {
			return fItem;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getBounds()
		 */
		@Override
		public Rectangle getBounds() {
			return fItem.getBounds();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParent()
		 */
		@Override
		public Scrollable getParent() {
			return fItem.getParent();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentColumnCount()
		 */
		@Override
		public int getParentColumnCount() {
			return fItem.getParent().getColumnCount();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getImageBounds(int)
		 */
		@Override
		public Rectangle getImageBounds(int index) {
			return fItem.getImageBounds(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentItem()
		 */
		@Override
		public AbstractTableOrTreeItemWrapper getParentItem() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getParentItemHeight()
		 */
		@Override
		public int getParentItemHeight() {
			return fItem.getParent().getItemHeight();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getTextBounds(int)
		 */
		@Override
		public Rectangle getTextBounds(int index) {
			return fItem.getTextBounds(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getText(int)
		 */
		@Override
		public String getText(int index) {
			return fItem.getText(index);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeItemWrapper#getImage(int)
		 */
		@Override
		public Image getImage(int index) {
			return fItem.getImage(index);
		}
	}
}
