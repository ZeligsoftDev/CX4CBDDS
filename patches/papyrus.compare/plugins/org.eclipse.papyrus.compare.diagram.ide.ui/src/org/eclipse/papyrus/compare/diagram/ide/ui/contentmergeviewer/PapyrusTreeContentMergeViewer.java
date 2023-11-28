/*******************************************************************************
 * Copyright (c) 2016, 2018 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *     Philip Langer - introduce caching and improve selection, bug 527567
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.TreeContentMergeViewer;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.provider.MergeViewerItemProviderConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.structuremergeviewer.actions.MergeAction;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractTableOrTreeMergeViewer.ElementComparer;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.TreeMergeViewer;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProviderConfiguration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet.PapyrusFacetContentProviderWrapperAdapterFactory;
import org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.provider.PapyrusTreeContentMergeViewerItemLabelProvider;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;

/**
 * Specialized Tree Content Merge Viewer for Papyrus.
 * 
 * @author Stefan Dirix
 */
@SuppressWarnings("restriction")
public class PapyrusTreeContentMergeViewer extends TreeContentMergeViewer {

	/**
	 * Since Papyrus trees could in theory be infinite, we need a maximum search level.
	 */
	private static final int MAX_SEARCH_LEVEL = 20;

	/**
	 * Map of objects to {@link PapyrusContentProviderMergeViewerItem Papyrus merge viewer items} used when
	 * changing the selection in order to find the merge viewer item to be selected when a specific object
	 * (model element or diff) is to be revealed.
	 */
	private Map<Object, IMergeViewerItem> cachedMapForSelection;

	/**
	 * A queue of computations for computing the content tree items in the {@linked #getLeftMergeViewer()
	 * right merge viewer}.
	 */
	private LinkedList<AbstractContentFunction> leftContentComputations;

	/**
	 * A queue of computations for computing the content tree items in the {@linked #getRightMergeViewer()
	 * left merge viewer}.
	 */
	private LinkedList<AbstractContentFunction> rightContentComputations;

	/**
	 * Constructor.
	 * 
	 * @param style
	 *            the style parameter
	 * @param bundle
	 *            the {@link ResourceBundle}
	 * @param parent
	 *            the {@link Composite} parent
	 * @param config
	 *            the {@link EMFCompareConfiguration}
	 */
	public PapyrusTreeContentMergeViewer(int style, ResourceBundle bundle, Composite parent,
			EMFCompareConfiguration config) {
		super(style, bundle, parent, config);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.EMFCompareContentMergeViewer#createMergeViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected AbstractMergeViewer createMergeViewer(final Composite parent, final MergeViewerSide side) {
		final TreeMergeViewer mergeTreeViewer = new TreeMergeViewer(parent, side, this,
				getCompareConfiguration()) {
			@Override
			protected IAction createAction(MergeMode mode, Diff diff) {
				return new MergeAction(getCompareConfiguration(),
						EMFCompareRCPPlugin.getDefault().getMergerRegistry(), mode, null,
						new StructuredSelection(diff));
			}
		};
		final IContentProvider contentProvider = createMergeViewerContentProvider(side);
		mergeTreeViewer.setContentProvider(contentProvider);

		final IBaseLabelProvider labelProvider = new PapyrusTreeContentMergeViewerItemLabelProvider(
				getResourceBundle(), getAdapterFactory(), side);
		mergeTreeViewer.setLabelProvider(labelProvider);

		hookListeners(mergeTreeViewer);

		return mergeTreeViewer;
	}

	@Override
	protected IMergeViewerItemProviderConfiguration createMergeViewerItemProviderConfiguration(
			MergeViewerSide side) {
		ComposedAdapterFactory factory = new ComposedAdapterFactory(new AdapterFactory[] {
				new PapyrusFacetContentProviderWrapperAdapterFactory(), getAdapterFactory(), });
		return new MergeViewerItemProviderConfiguration(factory, getDifferenceGroupProvider(),
				getDifferenceFilterPredicate(), getCompareConfiguration().getComparison(), side);
	}

	/**
	 * Check whether the given input is an instance of {@link ICompareAccessor}.
	 * 
	 * @param input
	 *            the given input to check
	 * @return {@code true}, if the input is an instance of {@link ICompareAccessor}, {@code false} otherwise
	 */
	private static boolean isCompareAccessor(Object input) {
		return input instanceof ICompareAccessor;
	}

	/**
	 * Check whether the current input of the given side differs from the given one.
	 * 
	 * @param side
	 *            the side to be checked, either {@link MergeViewerSide#LEFT} or {@link MergeViewerSide#RIGHT}
	 * @param input
	 *            the input to check against
	 * @return {@code true}, if the input is different, {@code false} otherwise
	 */
	private boolean isDifferentInput(MergeViewerSide side, Object input) {
		TreeMergeViewer viewer = getMergeViewer(side);
		if (!isCompareAccessor(input) || !isCompareAccessor(viewer.getInput())) {
			return true;
		}
		ImmutableList<? extends IMergeViewerItem> inputItems = ICompareAccessor.class.cast(input).getItems();
		ImmutableList<? extends IMergeViewerItem> vieweritems = ICompareAccessor.class.cast(viewer.getInput())
				.getItems();
		if (inputItems.size() != vieweritems.size()) {
			return true;
		}
		ElementComparer comparer = new ElementComparer();
		for (int i = 0; i < vieweritems.size(); i++) {
			if (!comparer.equals(inputItems.get(i), vieweritems.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the {@link TreeMergeViewer} of the given side.
	 * 
	 * @param side
	 *            the side for which to return the {@link TreeMergeViewer}
	 * @return the {@link TreeMergeViewer} of the respective side
	 */
	public TreeMergeViewer getMergeViewer(MergeViewerSide side) {
		if (side == MergeViewerSide.LEFT) {
			return getLeftMergeViewer();
		} else if (side == MergeViewerSide.RIGHT) {
			return getRightMergeViewer();
		}
		return getAncestorMergeViewer();
	}

	@Override
	protected void updateContent(Object ancestor, Object left, Object right) {
		// Modify selection so it works with the Papyrus Merge Viewer Items

		// first check whether the input on any side has changed
		if (isDifferentInput(MergeViewerSide.LEFT, left) || isDifferentInput(MergeViewerSide.RIGHT, right)) {
			getAncestorMergeViewer().setInput(ancestor);
			getLeftMergeViewer().setInput(left);
			getRightMergeViewer().setInput(right);

			leftContentComputations = null;
			rightContentComputations = null;
			cachedMapForSelection = null;
		} else {
			getLeftMergeViewer().refresh();
			getRightMergeViewer().refresh();
		}

		IMergeViewerItem leftInitialItem = null;
		if (left instanceof ICompareAccessor) {
			leftInitialItem = ((ICompareAccessor)left).getInitialItem();
		}

		// Bug 458818: In some cases, the left initial item is null because
		// the item that should be selected has been deleted on the right
		// and this delete is part of a conflict
		if (leftInitialItem == null || leftInitialItem.getLeft() == null) {
			if (right instanceof ICompareAccessor) {
				IMergeViewerItem rightInitialItem = ((ICompareAccessor)right).getInitialItem();
				if (rightInitialItem == null) {
					getLeftMergeViewer().setSelection(StructuredSelection.EMPTY, true);
				} else {
					setSelection((ICompareAccessor)right);
				}
			} else {
				// Strange case: left is an ICompareAccessor but right is not?
				getLeftMergeViewer().setSelection(StructuredSelection.EMPTY, true);
			}
		} else {
			// others will synchronize on this one :)
			setSelection((ICompareAccessor)left);
		}
		redrawCenterControl();
	}

	/**
	 * Sets the selection according to the accessor.
	 * 
	 * @param accessor
	 *            The {@link ICompareAccessor} which contains the root tree elements and the initial
	 *            selection.
	 */
	private void setSelection(ICompareAccessor accessor) {
		// First try to set the initial item directly
		final IMergeViewerItem initialItem = accessor.getInitialItem();
		TreeMergeViewer viewer = getMergeViewer(initialItem.getSide());
		viewer.setSelection(new StructuredSelection(initialItem), true);

		// if that didn't work (empty selection), use cache to find correct merge viewer item
		if (viewer.getSelection().isEmpty()) {
			IMergeViewerItem itemToBeSelected = getItemToBeSelected(initialItem, viewer);
			if (itemToBeSelected != null) {
				viewer.setSelection(new StructuredSelection(itemToBeSelected), true);
			} else {
				viewer.setSelection(new StructuredSelection(), true);
			}
		}
	}

	/**
	 * Determines the item to select from the corresponding side viewer, given an input item.
	 * 
	 * @param item
	 *            the input item.
	 * @param viewer
	 *            the viewer in which to select the item.
	 * @return the item to be selected.
	 */
	private IMergeViewerItem getItemToBeSelected(IMergeViewerItem item, TreeMergeViewer viewer) {
		MergeViewerSide side = viewer.getSide();
		Object itemValue = item.getSideValue(side);
		IMergeViewerItem result;
		if (cachedMapForSelection == null) {
			cachedMapForSelection = Maps.newHashMap();
			result = null;
		} else {
			result = cachedMapForSelection.get(itemValue);
		}

		if (result == null && itemValue != null) {
			LinkedList<AbstractContentFunction> contentComputations;

			switch (side) {
				case LEFT:
					if (leftContentComputations == null) {
						leftContentComputations = Lists.newLinkedList();
						leftContentComputations.add(new ElementFunction(side, viewer, leftContentComputations,
								cachedMapForSelection));
					}
					contentComputations = leftContentComputations;
					break;

				case RIGHT:
					if (rightContentComputations == null) {
						rightContentComputations = Lists.newLinkedList();
						rightContentComputations.add(new ElementFunction(side, viewer,
								rightContentComputations, cachedMapForSelection));
					}
					contentComputations = rightContentComputations;
					break;

				default:
					throw new IllegalArgumentException();
			}

			Collection<Object> containers = getContainers(itemValue);
			if (!containers.isEmpty()) {
				// move necessary computations to the front
				List<AbstractContentFunction> containerComputations = extractComputations(contentComputations,
						containers);
				contentComputations.addAll(0, containerComputations);
			}

			result = computeItemToBeSelected(itemValue, containers, contentComputations);
		}

		return result;
	}

	/**
	 * Computes the item to be selected for the given item value, taking into account the containers, using
	 * the content computations.
	 * 
	 * @param itemValue
	 *            the item for which to base the selection.
	 * @param containers
	 *            the containers for that item.
	 * @param contentComputations
	 *            the computations for computing content.
	 * @return the item to be selected.
	 */
	private IMergeViewerItem computeItemToBeSelected(Object itemValue, Collection<Object> containers,
			LinkedList<AbstractContentFunction> contentComputations) {
		// We try to limit the amount of time we spend looking for selection.
		// Sometimes the object will not be present in the tree at all,
		// causing the whole tree to be visited.
		// So we keep track of which of the contains have not been visited,
		// removing any containers for which there is already a selection computed.
		IMergeViewerItem result = null;
		Collection<Object> unvistedContainers = Sets.newHashSet(containers);
		unvistedContainers.removeAll(cachedMapForSelection.keySet());
		long start = System.currentTimeMillis();
		while (!contentComputations.isEmpty()) {
			AbstractContentFunction contentFunction = contentComputations.removeFirst();

			// If we've visited all the containers and have been computing for more the 2 seconds,
			// stop looking and select the container instead.
			unvistedContainers.remove(contentFunction.getValue());
			if (unvistedContainers.isEmpty() && (System.currentTimeMillis() - start) > 2 * 1000) {
				break;
			}

			result = contentFunction.apply(itemValue, containers);
			if (result != null) {
				break;
			}
		}

		// If we haven't found the selection, try to find a selection for the nearest container.
		if (result == null) {
			for (Object container : containers) {
				result = cachedMapForSelection.get(container);
				if (result != null) {
					break;
				}
			}
		}

		return result;
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		if (cachedMapForSelection != null) {
			cachedMapForSelection = null;
		}

		super.handleDispose(event);
	}

	/**
	 * Extracts all content functions for the given objects from the computation list.
	 * 
	 * @param computations
	 *            computation list from which functions are extracted.
	 * @param values
	 *            values specifying which functions should be extracted.
	 * @return Non-null list of computations covering the given objects.
	 */
	private List<AbstractContentFunction> extractComputations(
			LinkedList<AbstractContentFunction> computations, Collection<Object> values) {
		List<AbstractContentFunction> extractedComputations = new ArrayList<>();
		Iterator<AbstractContentFunction> computationsIterator = computations.iterator();
		while (computationsIterator.hasNext()) {
			AbstractContentFunction contentFuction = computationsIterator.next();
			if (values.contains(contentFuction.getValue())) {
				computationsIterator.remove();
				extractedComputations.add(contentFuction);
			}
		}
		return extractedComputations;
	}

	/**
	 * Returns all EObject containers for the given value, if the given object is an EObject.
	 * 
	 * @param eObject
	 *            eObject value.
	 * @return Non-null collection of containers.
	 */
	private Collection<Object> getContainers(Object eObject) {
		Collection<Object> containers;
		if (eObject instanceof EObject) {
			containers = Sets.newLinkedHashSet();
			for (EObject container = ((EObject)eObject).eContainer(); container != null; container = container
					.eContainer()) {
				containers.add(container);
			}
		} else {
			containers = Collections.emptySet();
		}
		return containers;
	}

	/**
	 * A function for computing the items in the content tree induced by an item provider. Instances are
	 * managed in a {@link #contentComputations} queue and are processed to update the {@linked #selections
	 * selections} cache.
	 * 
	 * @see PapyrusTreeContentMergeViewer#getItemToBeSelected(IMergeViewerItem)
	 */
	private abstract static class AbstractContentFunction {
		/**
		 * The side for which the computation is being done.
		 */
		protected final MergeViewerSide side;

		/**
		 * The tree content provider which induces the content tree.
		 */
		protected final ITreeContentProvider provider;

		/**
		 * The queue of computations being managed.
		 * 
		 * @see PapyrusTreeContentMergeViewer#leftContentComputations
		 * @see PapyrusTreeContentMergeViewer#rightContentComputations
		 */
		protected final LinkedList<AbstractContentFunction> contentComputations;

		/**
		 * The selections being cached.
		 * 
		 * @see PapyrusTreeContentMergeViewer#cachedMapForSelection
		 */
		protected final Map<Object, IMergeViewerItem> selections;

		/**
		 * Creates and instance for a given side that induces content based on the given providers and manages
		 * the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            the side for which the content is being computed.
		 * @param provider
		 *            the provider used to induce content.
		 * @param contentComputations
		 *            the queue of computations being managed.
		 * @param selections
		 *            the selection cache being managed.
		 */
		protected AbstractContentFunction(MergeViewerSide side, ITreeContentProvider provider,
				LinkedList<AbstractContentFunction> contentComputations,
				Map<Object, IMergeViewerItem> selections) {
			this.side = side;
			this.provider = provider;
			this.contentComputations = contentComputations;
			this.selections = selections;
		}

		/**
		 * Computes new content and if any of the new content item matches the given value, returns the
		 * corresponding item from the side viewer. The {@link #contentComputations queue} is updated with
		 * functions for the new content items. Any new item with a value that matches one of the containers
		 * is placed at the front of the queue, rather than the back.
		 * 
		 * @param matchValue
		 *            the value to match.
		 * @param containers
		 *            the items that are of high priority to process first.
		 * @return the corresponding side viewer item for the match value, or null.
		 */
		public abstract IMergeViewerItem apply(Object matchValue, Collection<?> containers);

		/**
		 * Returns the value for which content will be computed.
		 * 
		 * @return the value for which content will be computed.
		 */
		public abstract Object getValue();

		/**
		 * A base helper method that does the computation needed by {@link #apply(Object, Collection)}.
		 * 
		 * @param matchValue
		 *            the value to be matched.
		 * @param containers
		 *            the items that are of high priority to process first.
		 * @param values
		 *            the new content items to be processed.
		 * @param depth
		 *            the current tree depth of the traversal.
		 * @return the corresponding side viewer item for the match value, or null.
		 */
		protected IMergeViewerItem apply(Object matchValue, Collection<?> containers, Object[] values,
				int depth) {
			IMergeViewerItem result = null;
			for (Object element : values) {
				if (element instanceof IMergeViewerItem) {
					final IMergeViewerItem item = (IMergeViewerItem)element;
					Object sideValue = item.getSideValue(side);

					// If we don't yet have a result, and the new value is equal to the matching value, then
					// cache it as the result.
					if (result == null) {
						if (sideValue != null && sideValue.equals(matchValue)) {
							result = item;
						}
					}

					// Create a new child function for the given item and add it to the front or the back of
					// the queue depending on whether the high priority containers include the item's side
					// value. So in general the content is build breadth first, but the subtree of the
					// containers is processed depth first.
					ChildFunction childFunction = new ChildFunction(side, provider, item, depth,
							contentComputations, selections);
					if (containers.contains(sideValue)) {
						contentComputations.addFirst(childFunction);
					} else {
						contentComputations.addLast(childFunction);

					}
				}
			}
			return result;
		}
	}

	/**
	 * A content function that computes the root elements of a side viewer.
	 */
	private static final class ElementFunction extends AbstractContentFunction {
		/**
		 * The input object of the side viewer.
		 */
		private final Object input;

		/**
		 * Creates and instance for a given side viewer that induces content based on the viewer's provider
		 * and manages the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            the side for which the content is being computed.
		 * @param viewer
		 *            the side viewer for which to induce content.
		 * @param contentComputations
		 *            the queue of computations being managed.
		 * @param selections
		 *            the selection cache being managed.
		 */
		private ElementFunction(MergeViewerSide side, TreeMergeViewer viewer,
				LinkedList<AbstractContentFunction> contentComputations,
				Map<Object, IMergeViewerItem> selections) {
			super(side, (ITreeContentProvider)viewer.getContentProvider(), contentComputations, selections);
			this.input = viewer.getInput();
		}

		@Override
		public Object getValue() {
			return input;
		}

		@Override
		public IMergeViewerItem apply(Object matchValue, Collection<?> containers) {
			return apply(matchValue, containers, provider.getElements(input), 0);
		}
	}

	/**
	 * A content function that computes the child elements of a side viewer.
	 */
	private static final class ChildFunction extends AbstractContentFunction {

		/**
		 * The item for which to induce child content.
		 */
		private final IMergeViewerItem item;

		/**
		 * The depth of the item.
		 */
		private final int depth;

		/**
		 * Creates and instance for a given side viewer's content provider that induces for the given item and
		 * the given depth and manages the queue of content computations, updating the selections.
		 * 
		 * @param side
		 *            the side for which the content is being computed.
		 * @param provider
		 *            the content provider of the side viewer.
		 * @param item
		 *            the item for which to induce child content.
		 * @param depth
		 *            the depth of the item.
		 * @param contentComputations
		 *            the queue of computations being managed.
		 * @param selections
		 *            the selection cache being managed.
		 */
		private ChildFunction(MergeViewerSide side, ITreeContentProvider provider, IMergeViewerItem item,
				int depth, LinkedList<AbstractContentFunction> contentComputations,
				Map<Object, IMergeViewerItem> selections) {
			super(side, provider, contentComputations, selections);
			this.item = item;
			this.depth = depth;

			Object value = item.getSideValue(side);
			if (value != null) {
				selections.put(value, item);
			}
		}

		@Override
		public Object getValue() {
			return item.getSideValue(side);
		}

		@Override
		public IMergeViewerItem apply(Object matchValue, Collection<?> containers) {
			if (depth == MAX_SEARCH_LEVEL) {
				return null;
			} else {
				return apply(matchValue, containers, provider.getChildren(item), depth + 1);
			}
		}
	}
}
