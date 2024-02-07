/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.tree.provider.TreeMergeViewerItemContentProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProviderConfiguration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Modifies the {@link TreeMergeViewerItemContentProvider} for the Papyrus Facet mechanism.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class PapyrusMergeViewerItemContentProvider extends TreeMergeViewerItemContentProvider {

	@Override
	public boolean hasChildren(Object object, IMergeViewerItemProviderConfiguration configuration) {
		// Filter children of diagrams
		if (object instanceof IMergeViewerItem) {
			Object bestSideObject = getBestSideValue(IMergeViewerItem.class.cast(object),
					configuration.getSide());
			if (Diagram.class.isInstance(bestSideObject)) {
				return false;
			}
		}
		return super.hasChildren(object, configuration);
	}

	@Override
	protected IMergeViewerItem createMergeViewerItemFrom(EObject eObject, IMergeViewerItem parent,
			IMergeViewerItemProviderConfiguration configuration) {
		IMergeViewerItem createdItem = super.createMergeViewerItemFrom(eObject, parent, configuration);
		if (PapyrusMergeViewerItem.class.isInstance(createdItem)) {
			PapyrusMergeViewerItem.class.cast(createdItem).setPapyrusParent(parent);
		}
		return createdItem;
	}

	@Override
	protected IMergeViewerItem createMergeViewerItem(Comparison comparison, Diff diff, Object left,
			Object right, Object ancestor, MergeViewerSide side, AdapterFactory adapterFactory) {
		return new PapyrusMergeViewerItem(comparison, diff, left, right, ancestor, side, adapterFactory);
	}

	@Override
	public Object getParent(Object object, IMergeViewerItemProviderConfiguration configuration) {
		// Mimic Facet mechanism
		if (PapyrusMergeViewerItem.class.isInstance(object)) {
			PapyrusMergeViewerItem item = PapyrusMergeViewerItem.class.cast(object);
			if (item.getPapyrusParent() != null) {
				return item.getPapyrusParent();
			}
		}

		IMergeViewerItem mergeViewerItem = (IMergeViewerItem)object;
		if (mergeViewerItem.getDiff() instanceof ResourceAttachmentChange) {
			// fallback to parent in special case
			return super.getParent(object, configuration);
		}

		// Try to get the parent but do not return a parent which could be filtered away
		Object sideValue = getBestSideValue(mergeViewerItem, configuration.getSide());
		if (sideValue != null) {
			Object parent = getUnfilteredParent(sideValue, configuration);
			if (parent != null) {
				return parent;
			}
		}

		// fallback
		return super.getParent(object, configuration);
	}

	/**
	 * Determines the parent of the given object but 'skips' parent elements which are filtered away.
	 * 
	 * @param object
	 *            the {@link Object} whose parent is to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return the unfiltered parent if one could be determined, {@code null} otherwise.
	 */
	protected Object getUnfilteredParent(Object object, IMergeViewerItemProviderConfiguration configuration) {
		List<Object> pathToRoot = getPathToRoot(object, configuration);
		Set<Object> alreadyLookedAt = new HashSet<Object>();
		int currentIndex = pathToRoot.size() - 1;
		while (true) {
			Object nextObject = pathToRoot.get(currentIndex);
			if (alreadyLookedAt.contains(nextObject)) {
				// there is a containment circle
				return null;
			}
			alreadyLookedAt.add(nextObject);
			List<Object> childrenFromContentProvider = getChildrenFromContentProvider(nextObject,
					configuration.getAdapterFactory());
			childrenFromContentProvider.retainAll(pathToRoot);
			if (childrenFromContentProvider.isEmpty()) {
				// break in the chain
				return null;
			}
			if (childrenFromContentProvider.get(0) == object) {
				// found the parent that returns the given object
				return nextObject;
			}
			currentIndex = pathToRoot.lastIndexOf(childrenFromContentProvider.get(0));
		}
	}

	/**
	 * Determines all the parents of the given object up to the root.
	 * 
	 * @param object
	 *            the {@link Object} whose parents are to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}
	 * @return A list starting from the given {@code object} and ending with the root element.
	 */
	private List<Object> getPathToRoot(Object object, IMergeViewerItemProviderConfiguration configuration) {
		List<Object> path = new ArrayList<Object>();
		Object currentObject = object;
		while (currentObject != null) {
			path.add(currentObject);
			ITreeItemContentProvider treeItemContentProvider = (ITreeItemContentProvider)configuration
					.getAdapterFactory().adapt(currentObject, ITreeItemContentProvider.class);
			if (treeItemContentProvider == null) {
				break;
			}
			currentObject = treeItemContentProvider.getParent(currentObject);
		}
		return path;
	}
}
