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

import static com.google.common.collect.Iterables.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.provider.CompareAccessorMergeViewerItemProvider;
import org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProviderConfiguration;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet.FacetUtil;
import org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.facet.PapyrusFacetContentProviderWrapper;

/**
 * Responsible for filtering unwanted root elements.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class PapyrusCompareAccessorMergeViewerItemProvider extends CompareAccessorMergeViewerItemProvider {

	@Override
	public List<Object> getMergeViewerItems(Object object,
			final IMergeViewerItemProviderConfiguration configuration) {
		if (!ICompareAccessor.class.isInstance(object)) {
			return super.getMergeViewerItems(object, configuration);
		}

		final List<Object> papyrusRootElements = getModelExplorerRootElements(configuration);
		final List<Object> mergeViewerItems = super.getMergeViewerItems(object, configuration);

		Iterable<Object> filtered = filter(mergeViewerItems, new Predicate<Object>() {
			public boolean apply(Object input) {
				if (IMergeViewerItem.class.isInstance(input)) {
					final IMergeViewerItem item = IMergeViewerItem.class.cast(input);
					Object sideValue = item.getSideValue(configuration.getSide());
					if (NotLoadedFragmentMatch.class.isInstance(sideValue)) {
						// extract value
						Match matchChild = NotLoadedFragmentMatch.class.cast(sideValue).getFirstMatchChild();
						sideValue = getSide(matchChild, configuration.getSide());
					}
					return papyrusRootElements.contains(sideValue);
				}
				return false;
			}
		});
		return Lists.newArrayList(filtered);
	}

	/**
	 * Uses the Papyrus Facet mechanism to determine the root elements in the ModelExplorer.
	 * 
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return the root elements as displayed in the ModelExplorer.
	 */
	private List<Object> getModelExplorerRootElements(IMergeViewerItemProviderConfiguration configuration) {
		final ResourceSet resourceSet = getResourceSet(configuration.getComparison(),
				configuration.getSide());
		PapyrusFacetContentProviderWrapper wrapper = new PapyrusFacetContentProviderWrapper(
				configuration.getAdapterFactory(), resourceSet);
		Collection<?> elements = wrapper.getElements(resourceSet);
		wrapper.dispose();
		return Lists.newArrayList(Iterables.transform(elements, FacetUtil.UN_WRAP));
	}

	/**
	 * Determines the {@link ResourceSet} for the given {@code side}.
	 * 
	 * @param comparison
	 *            the {@link Comparison}.
	 * @param side
	 *            the {@link MergeViewerSide}.
	 * @return the determined {@link ResourceSet}, {@code null} if there is none.
	 */
	private ResourceSet getResourceSet(Comparison comparison, MergeViewerSide side) {
		for (MatchResource matchResource : comparison.getMatchedResources()) {
			Resource resource = getResource(matchResource, side);
			if (resource != null) {
				return resource.getResourceSet();
			}
		}
		return null;
	}

	/**
	 * Determines the resource of the given match and side.
	 * 
	 * @param matchResource
	 *            the {@link MatchResource}.
	 * @param side
	 *            the {@link MergeViewerSide}.
	 * @return the determined {@link Resource}, may be {@code null}.
	 */
	private Resource getResource(MatchResource matchResource, MergeViewerSide side) {
		if (side == MergeViewerSide.LEFT) {
			return matchResource.getLeft();
		}
		if (side == MergeViewerSide.RIGHT) {
			return matchResource.getRight();
		}
		if (side == MergeViewerSide.ANCESTOR) {
			return matchResource.getOrigin();
		}
		return null;
	}

	/**
	 * Determines the object of the given match and side.
	 * 
	 * @param match
	 *            the {@link Match}.
	 * @param side
	 *            the {@link MergeViewerSide}.
	 * @return the determined {@link Object}, may be {@code null}.
	 */
	private Object getSide(Match match, MergeViewerSide side) {
		if (side == MergeViewerSide.LEFT) {
			return match.getLeft();
		}
		if (side == MergeViewerSide.RIGHT) {
			return match.getRight();
		}
		if (side == MergeViewerSide.ANCESTOR) {
			return match.getOrigin();
		}
		return null;
	}
}
