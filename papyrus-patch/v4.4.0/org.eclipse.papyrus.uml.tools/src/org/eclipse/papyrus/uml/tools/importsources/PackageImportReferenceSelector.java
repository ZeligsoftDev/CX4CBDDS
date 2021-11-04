/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	 CEA LIST - Initial API and implementation
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 409555
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.swt.widgets.Composite;

/**
 * Selector for Package import source.
 */
class PackageImportReferenceSelector extends ReferenceSelector {

	/** The source. */
	private IPackageImportSource source;


	/**
	 * Instantiates a new package import reference selector.
	 */
	public PackageImportReferenceSelector() {
		super();
	}

	/**
	 * Sets the import source.
	 *
	 * @param source
	 *            the new import source
	 */
	void setImportSource(IPackageImportSource source) {
		this.source = source;
	}


	/**
	 * Gets the elements to move.
	 *
	 * @param selection
	 *            the selection
	 * @return the elements to move
	 * @see org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector#getElementsToMove(java.lang.Object[])
	 */
	@Override
	protected Object[] getElementsToMove(Object[] selection) {

		final List<Object> elementsToMove = new LinkedList<Object>();

		// Parse all selected elements
		for (Object element : selection) {

			// Case 1 : element is a folder
			if (element instanceof IFolder || element instanceof IProject) {

				// Try to visit containing of folder to find elements to move
				elementsToMove.addAll(extractFiltered((IResource) element));

			} else if (contentProvider.isValidValue(element)) {

				elementsToMove.add(element);
			}
		}

		notifyCommitListeners();

		return elementsToMove.toArray();
	}


	/**
	 * Extract filtered.
	 *
	 * @param element
	 *            the element
	 * @return the collection<? extends object>
	 */
	private Collection<? extends Object> extractFiltered(IResource element) {
		FilteredChildrenResourceVisitor childrenVisitor = new FilteredChildrenResourceVisitor(contentProvider);

		try {
			element.accept(childrenVisitor);
		} catch (CoreException e) {
			Activator.log.error(e);
		}
		return childrenVisitor.getResult();
	}



	/**
	 * Creates the controls.
	 *
	 * @param parent
	 *            the parent
	 * @see org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector#createControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControls(Composite parent) {
		super.createControls(parent);

		if (source instanceof CompositePackageImportSource) {
			// expand to the second level to show projects in the workspace
			// and whatever is contributed by other sources
			treeViewer.expandToLevel(2);
		}

	}

	/**
	 * The Class FilteredChildrenResourceVisitor.
	 */
	private class FilteredChildrenResourceVisitor implements IResourceVisitor {

		/** The content provider. */
		private EncapsulatedContentProvider contentProvider;

		/** The elements list. */
		private List<Object> elementsList = new LinkedList<Object>();

		/**
		 * Instantiates a new filtered children resource visitor.
		 *
		 * @param contentProvider
		 *            the content provider
		 */
		public FilteredChildrenResourceVisitor(EncapsulatedContentProvider contentProvider) {
			this.contentProvider = contentProvider;
		}

		/**
		 * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
		 *
		 * @param resource
		 * @return
		 * @throws CoreException
		 */

		public boolean visit(IResource resource) throws CoreException {

			if (resource instanceof IFile) {

				// Check before with the content provider
				if (contentProvider.isValidValue(resource)) {

					/*
					 * Initialise element to filter the resource with
					 * tree viewer filters.
					 */
					boolean filtered = true;
					ViewerFilter[] filtersArray = treeViewer.getFilters();
					int amountFilters = filtersArray.length;

					int i = 0;
					while (filtered && i < amountFilters) {
						// Check if the visited resource passes all filters
						filtered = filtersArray[i].select(treeViewer, resource.getParent(), resource);
						i++;
					}

					if (filtered) {
						elementsList.add(resource);
					}
				}

				return false;
			}

			return true;

		}

		/**
		 * Gets the result.
		 *
		 * @return the result
		 */
		public Collection<? extends Object> getResult() {
			return elementsList;
		}
	}



}
