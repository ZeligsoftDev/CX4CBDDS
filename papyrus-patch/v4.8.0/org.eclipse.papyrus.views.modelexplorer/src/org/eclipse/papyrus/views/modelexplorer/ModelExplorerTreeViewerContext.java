/*
 * Copyright (c) 2010, 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - adapted from ModelExplorerView::reveal(...) API
 *
 */
package org.eclipse.papyrus.views.modelexplorer;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.additional.AdditionalResourcesModel;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.editor.reload.EMFTreeViewerContext;
import org.eclipse.papyrus.views.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.LinkItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ReferencableMatchingItem;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * A specialization of the editor re-load tree viewer context that knows how to expand and select nodes
 * in the EMF Facet-based Model Explorer view.
 */
class ModelExplorerTreeViewerContext extends EMFTreeViewerContext {

	public ModelExplorerTreeViewerContext(AbstractTreeViewer viewer) {
		super(viewer);
	}

	@Override
	public Object deresolveSelectableElement(Object selectableElement) {
		return EMFHelper.getEObject(selectableElement);
	}

	@Override
	public Object resolveSelectableElement(Object object) {
		return new ModelElementItemMatchingItemWithElement((EObject) object);
	}

	@Override
	protected void setExpandedElements(AbstractTreeViewer viewer, Collection<?> toExpand) {
		// EMF Facet makes expanding tree elements very complicated
		if (viewer.getContentProvider() != null) {
			for (ModelElementItemMatchingItemWithElement next : Iterables.filter(toExpand, ModelElementItemMatchingItemWithElement.class)) {

				// retrieve the ancestors to reveal them
				// and allow the selection of the object
				EObject currentEObject = next.element();
				ArrayList<EObject> parents = new ArrayList<EObject>();
				EObject tmp = currentEObject.eContainer();
				while (tmp != null) {
					parents.add(tmp);
					tmp = tmp.eContainer();
				}

				Iterable<EObject> reverseParents = Lists.reverse(parents);

				// reveal the resource if necessary
				Resource r = null;
				if (!parents.isEmpty()) {
					r = parents.get(parents.size() - 1).eResource();
				} else {
					r = currentEObject.eResource();
				}

				if (r != null) {
					final ResourceSet rs = r.getResourceSet();
					final Resource resource = r;
					if (rs instanceof ModelSet && AdditionalResourcesModel.isAdditionalResource((ModelSet) rs, r.getURI())) {
						viewer.expandToLevel(new ReferencableMatchingItem(rs), 1);
						viewer.expandToLevel(new ReferencableMatchingItem(resource), 1);
					}
				}

				/*
				 * reveal the ancestors tree using expandToLevel on each of them
				 * in the good order. This is a lot faster than going through the whole tree
				 * using getChildren of the ContentProvider since our Viewer uses a Hashtable
				 * to keep track of the revealed elements.
				 *
				 * However we need to use a dedicated MatchingItem to do the matching,
				 * and a specific comparer in our viewer so than the equals of MatchingItem is
				 * used in priority.
				 *
				 * Please refer to MatchingItem for more infos.
				 */
				EObject previousParent = null;
				for (EObject parent : reverseParents) {
					if (parent.eContainingFeature() != null && previousParent != null) {
						viewer.expandToLevel(new LinkItemMatchingItem(previousParent, parent.eContainmentFeature()), 1);
					}

					final IMatchingItem itemToExpand = new ModelElementItemMatchingItem(parent);
					viewer.expandToLevel(itemToExpand, 1);

					previousParent = parent;
				}

				// expand a reference-link item, if necessary
				final IMatchingItem linkItem = new LinkItemMatchingItem(currentEObject.eContainer(), currentEObject.eContainmentFeature());
				viewer.expandToLevel(linkItem, 1);

				// and the actual element
				viewer.expandToLevel(next, 1);
			}
		}
	}

	//
	// Nested types
	//

	static class ModelElementItemMatchingItemWithElement extends ModelElementItemMatchingItem {

		private EObject element;

		ModelElementItemMatchingItemWithElement(EObject element) {
			super(element);

			this.element = element;
		}

		EObject element() {
			return element;
		}
	}
}
