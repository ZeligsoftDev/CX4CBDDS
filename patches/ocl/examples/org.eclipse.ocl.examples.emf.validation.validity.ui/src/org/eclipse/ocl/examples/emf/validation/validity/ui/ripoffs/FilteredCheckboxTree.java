/*******************************************************************************
 * Copyright (c) 2008, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Ian Bull <irbull@cs.uvic.ca> - bug 207064
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.ripoffs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * A FilteredChecboxTree.  This tree stores all the tree elements internally, and keeps the
 * check state in sync.  This way, even if an element is filtered, the caller can get and set the
 * checked state.
 *
 * The internal representation is additive.  That is, elements are never removed from the internal
 * representation.  This is OK since the PDE launch Dialog never changes the elements once
 * the view is opened.  If any other tree is based on this code, they may want to address this issue.
 *
 * <p>
 * This has been copy/pasted and adapted from org.eclipse.pde.internal.ui.launcher.FilteredCheckboxTree.
 * </p>
 */
public class FilteredCheckboxTree extends FilteredTree {

	/**
	 * A CheckboxTreeViewer that maintains an internal representation of all the nodes.
	 */
	public class FilterableCheckboxTreeViewer extends CheckboxTreeViewer {
		static final String NONE = "none"; //$NON-NLS-1$
		static final String CHECKED = "checked"; //$NON-NLS-1$
		static final String GRAYED = "greyed"; //$NON-NLS-1$
		static final String CHECKED_GRAYED = "checked_greyed"; //$NON-NLS-1$

		/**
		 * The internal node for the FilterableCheckboxTreeViewer
		 */
		class FilteredCheckboxTreeItem {
			Object data; // Data element
			String state; // Checked State
			List<FilteredCheckboxTreeItem> children = new ArrayList<FilteredCheckboxTreeItem>();

			public FilteredCheckboxTreeItem(Object data, String state, Map<Object, FilteredCheckboxTreeItem> itemCache, FilteredCheckboxTreeItem parent) {
				this.data = data;
				this.state = state;
				itemCache.put(data, this);
				if (parent != null) {
					parent.children.add(this);
				}
			}
		}

		/* A cache of all the nodes */
		Map<Object, FilteredCheckboxTreeItem> itemCache = new HashMap<Object, FilteredCheckboxTreeItem>();

		@Override
		protected void unmapAllElements() {
			itemCache = new HashMap<Object, FilteredCheckboxTreeItem>();
			super.unmapAllElements();
		}

		/**
		 * FilterableCheckboxTreeViewer constructor. This creates the tree part of the filtered tree.
		 */
		public FilterableCheckboxTreeViewer(Composite parent, int style) {
			super(parent, style);
			addCheckStateListener(new ICheckStateListener() {

				@Override
				public void checkStateChanged(CheckStateChangedEvent event) {
					FilteredCheckboxTreeItem item = itemCache.get(event.getElement());
					if (item != null) {
						item.state = event.getChecked() ? CHECKED : NONE;
					}
				}
			});
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#getChecked(java.lang.Object)
		 */
		@Override
		public boolean getChecked(Object element) {
			Widget testFindItem = getViewer().testFindItem(element);
			if (testFindItem == null) {
				if (itemCache.containsKey(element)) {
					FilteredCheckboxTreeItem item = itemCache.get(element);
					assert item != null;
					if (item.state.equals(CHECKED))
						return true;
					if (item.state.equals(CHECKED_GRAYED))
						return true;
					if (item.state.equals(GRAYED))
						return true;
					else if (item.state.equals(NONE))
						return false;
				}
			}
			return super.getChecked(element);
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#getCheckedElements()
		 */
		@Override
		public Object[] getCheckedElements() {
			Iterator<FilteredCheckboxTreeItem> iterator = itemCache.values().iterator();
			List<Object> checkedElements = new LinkedList<Object>();
			while (iterator.hasNext()) {
				FilteredCheckboxTreeItem item = iterator.next();
				Widget testFindItem = getViewer().testFindItem(item.data);
				if (testFindItem == null) {
					if (item.state.equals(CHECKED) || item.state.equals(CHECKED_GRAYED) || item.state.equals(GRAYED)) {
						checkedElements.add(item.data);
					}
				} else {
					if (((TreeItem) testFindItem).getChecked()) {
						checkedElements.add(testFindItem.getData());
					}
				}
			}
			return checkedElements.toArray();
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#setChecked(java.lang.Object, boolean)
		 */
		@Override
		public boolean setChecked(Object element, boolean state) {
			if (itemCache.containsKey(element)) {
				FilteredCheckboxTreeItem item = itemCache.get(element);
				assert item != null;
				item.state = state ? CHECKED : NONE;
			}
			return super.setChecked(element, state);
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#setCheckedElements(java.lang.Object[])
		 */
		@Override
		public void setCheckedElements(Object[] elements) {
			Set<Object> s = new HashSet<Object>(itemCache.keySet());
			s.removeAll(new HashSet<Object>(Arrays.asList(elements)));
			for (int i = 0; i < elements.length; i++) {
				FilteredCheckboxTreeItem item = itemCache.get(elements[i]);
				if (item != null) {
					item.state = CHECKED;
				}
			}
			for (Iterator<Object> iterator = s.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				FilteredCheckboxTreeItem item = itemCache.get(object);
				if (item != null) {
					item.state = NONE;
				}
			}
			super.setCheckedElements(elements);
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#setSubtreeChecked(java.lang.Object, boolean)
		 */
		@Override
		public boolean setSubtreeChecked(Object element, boolean state) {
			String newState = state ? CHECKED : NONE;
			TreeItem item = (TreeItem) testFindItem(element);
			FilteredCheckboxTreeItem filteredCheckboxTreeItem = itemCache.get(element);
			if (item != null && filteredCheckboxTreeItem != null) {
				filteredCheckboxTreeItem.state = newState;
				TreeItem[] items = item.getItems();
				for (int i = 0; i < items.length; i++) {
					item = items[i];
					if (item != null) {
						filteredCheckboxTreeItem = itemCache.get(item.getData());
						if (filteredCheckboxTreeItem != null) {
							filteredCheckboxTreeItem.state = newState;
						}
					}
				}
			}
			return super.setSubtreeChecked(element, state);
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#preservingSelection(java.lang.Runnable)
		 */
		@Override
		protected void preservingSelection(Runnable updateCode) {
			super.preservingSelection(updateCode);

			// Re-apply the checked state
			ArrayList<TreeItem> allTreeItems = getAllTreeItems(treeViewer.getTree().getItems());
			for (Iterator<TreeItem> iterator = allTreeItems.iterator(); iterator.hasNext();) {
				TreeItem item = iterator.next();
				if (item.getData() != null) {
					doApplyCheckedState(item, item.getData());
				}
			}
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.jface.viewers.AbstractTreeViewer#internalRefresh(java.lang.Object, boolean)
		 */
		@Override
		protected void internalRefresh(Object element, boolean updateLabels) {
			saveCheckedState();
			super.internalRefresh(element, updateLabels);
			//			treeViewer.expandAll();
		}

		/*
		 * Set the checked state
		 */
		private void doApplyCheckedState(Item item, Object element) {
			// update the item first
			super.doUpdateItem(item, element);

			// Update the checked state
			TreeItem treeItem = (TreeItem) item;
			if (itemCache.containsKey(element)) {
				FilteredCheckboxTreeItem filteredCheckboxTreeItem = itemCache.get(element);
				assert filteredCheckboxTreeItem != null;
				String state = filteredCheckboxTreeItem.state;
				if (state.equals(CHECKED_GRAYED)) {
					treeItem.setGrayed(true);
					treeItem.setChecked(true);
				} else if (state.equals(CHECKED)) {
					treeItem.setChecked(true);
					treeItem.setGrayed(false);
				} else if (state.equals(GRAYED)) {
					treeItem.setGrayed(true);
					treeItem.setChecked(false);
				} else {
					treeItem.setGrayed(false);
					treeItem.setChecked(false);
				}
			}
		}

		/*
		 * A helper method to get all the items in the tree
		 */
		private ArrayList<TreeItem> getAllTreeItems(TreeItem[] roots) {
			ArrayList<TreeItem> list = new ArrayList<TreeItem>();
			for (int i = 0; i < roots.length; i++) {
				TreeItem item = roots[i];
				list.add(item);
				list.addAll(getAllTreeItems(item.getItems()));
			}
			return list;
		}

		/**
		 * Saves the checked state of all the elements in the tree
		 */
		private void saveCheckedState() {
			TreeItem[] items = treeViewer.getTree().getItems();
			for (int i = 0; i < items.length; i++) {
				TreeItem item = items[i];
				if (!itemCache.containsKey(item.getData())) {
					new FilteredCheckboxTreeItem(item.getData(), getItemState(item), itemCache, null);
				}
				FilteredCheckboxTreeItem filteredCheckboxTreeItem = itemCache.get(item.getData());
				assert filteredCheckboxTreeItem != null;
				filteredCheckboxTreeItem.state = getItemState(item);
				saveCheckedState(filteredCheckboxTreeItem, item);
			}
		}

		/**
		 * Saves the checked state of an item and all its children
		 */
		private void saveCheckedState(FilteredCheckboxTreeItem parent, TreeItem parentItem) {
			TreeItem[] items = parentItem.getItems();
			for (int i = 0; i < items.length; i++) {
				TreeItem item = items[i];
				if (!itemCache.containsKey(item.getData())) {
					new FilteredCheckboxTreeItem(item.getData(), getItemState(item), itemCache, parent);
				}
				FilteredCheckboxTreeItem filteredCheckboxTreeItem = itemCache.get(item.getData());
				assert filteredCheckboxTreeItem != null;
				filteredCheckboxTreeItem.state = getItemState(item);
				saveCheckedState(filteredCheckboxTreeItem, item);
			}
		}

		/**
		 * Computes the checked state from a tree item
		 */
		private String getItemState(TreeItem item) {
			if (item.getChecked() && item.getGrayed()) {
				return CHECKED_GRAYED;
			} else if (item.getChecked()) {
				return CHECKED;
			} else if (item.getGrayed()) {
				return GRAYED;
			} else {
				return NONE;
			}
		}

	} // end of FilterableCheckboxTreeViewer

	private WorkbenchJob refreshJob;

	/**
	 * The FilteredCheckboxTree Constructor.
	 * @param parent The parent composite where this Tree will be placed.
	 * @param treeStyle Tree styles
	 * @param filter The pattern filter that will be used to filter elements
	 */
	public FilteredCheckboxTree(Composite parent, int treeStyle, PatternFilter filter) {
		super(parent, treeStyle, filter, true);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredTree#doCreateTreeViewer(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		return new FilterableCheckboxTreeViewer(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.FilteredTree#doCreateRefreshJob()
	 */
	@Override
	protected WorkbenchJob doCreateRefreshJob() {
		// Since refresh job is private, we have to get a handle to it
		// when it is created, and store it locally.
		//
		// See: 218903: [Viewers] support extensibility of the refresh job in FilteredTree
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=218903
		WorkbenchJob job = super.doCreateRefreshJob();
		refreshJob = job;
		return job;
	}

	/**
	 * Resets the filter and returns when the refresh is complete
	 */
	public void resetFilter() {
		// Set the next to the initial Text, stop any outstanding jobs
		// and call the refresh job to run synchronously.
		Text filterText = getFilterControl();
		if (filterText != null) {
			filterText.setText(String.valueOf(this.initialText));
		}
		refreshJob.cancel();
		refreshJob.runInUIThread(new NullProgressMonitor());
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (!isDisposed()) {
			if ((filterText.getStyle() & SWT.ICON_CANCEL) == 0) { // filter uses FilteredTree new look, not native
				int filterColor = enabled ? SWT.COLOR_LIST_BACKGROUND : SWT.COLOR_WIDGET_BACKGROUND;
				filterComposite.setBackground(getDisplay().getSystemColor(filterColor));
			}
			filterText.setEnabled(enabled);
			treeViewer.getTree().setEnabled(enabled);
		}
	}

	public void disableTextWidget() {
		filterComposite.setVisible(false);
	}

	public void enableTextWidget() {
		filterComposite.setVisible(true);
	}

}