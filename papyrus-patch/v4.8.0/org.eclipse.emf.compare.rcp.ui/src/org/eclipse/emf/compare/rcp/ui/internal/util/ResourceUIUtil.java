/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.util;

import static com.google.common.collect.Iterables.filter;
import static java.util.Collections.emptyList;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.graph.IGraphView;
import org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * This class will be used to provide various utilities aimed at NotLoadedFragment manipulation.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 */
public class ResourceUIUtil {

	/** ID of the graph of EMF resources used by EMFCompare to compute the logical model. */
	public static final String RESOURCES_GRAPH_ID = "org.eclipse.emf.compare.resources.graph"; //$NON-NLS-1$

	/**
	 * Function that retrieve the data of the given TreeNode.
	 */
	private static Function<EObject, EObject> TREE_NODE_DATA = new Function<EObject, EObject>() {
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
	 * Get the graph of resources' URI for the models involved in the current comparison.
	 * 
	 * @return the graph if it exists, <code>null</code> otherwise.
	 */
	public static IGraphView<URI> getResourcesURIGraph() {
		return EMFCompareRCPPlugin.getDefault().getGraphView(RESOURCES_GRAPH_ID);
	}

	/**
	 * Check if the given URI correspond to the root resource of a model. In this case a root resource is a
	 * piece of a whole model that is not a fragment of the model.
	 * 
	 * @param uri
	 *            the given URI.
	 * @return <code>true</code> if the given URI is root resource of a model, <code>false</code> otherwise.
	 */
	public static boolean isRootResource(URI uri) {
		return !isFragment(uri);
	}

	/**
	 * Check if the given URI correspond to a fragment of model. In this case a fragment is a piece of a whole
	 * model that is not the root resource of the model.
	 * 
	 * @param uri
	 *            the given URI.
	 * @return <code>true</code> if the given URI is a fragment of a model, <code>false</code> otherwise.
	 */
	public static boolean isFragment(URI uri) {
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (uri != null && graph != null) {
			URI parentData = graph.getParentData(uri);
			if (parentData != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the given match is a root match of its comparison model and is a fragment. In this case a
	 * fragment is a piece of a whole model that is not the root resource of the model.
	 * 
	 * @param rootMatch
	 *            the given match.
	 * @param side
	 *            the side for which we want to know if it is a fragment or not.
	 * @return <code>true</code> if the given match is a root match of its comparison model and is a fragment,
	 *         <code>false</code> otherwise.
	 */
	public static boolean isFragment(Match rootMatch, MergeViewerSide side) {
		if (rootMatch != null && rootMatch.eContainer() instanceof Comparison) {
			URI uri = getDataURI(rootMatch, side);
			return isFragment(uri);
		}
		return false;
	}

	/**
	 * Check if the given URI corresponds to a fragment of model that is at the first level of the model, in
	 * other words a fragment that is directly under a root resource. In this case a fragment is a piece of a
	 * whole model that is not the root resource of the model.
	 * <p>
	 * If the given fragment (represented by the given URI) has several parents, this method will return
	 * <code>false</code>.
	 * </p>
	 * 
	 * @param uri
	 *            the given URI.
	 * @return <code>true</code> if the given URI is a fragment of a model, <code>false</code> otherwise.
	 */
	public static boolean isFirstLevelFragment(URI uri) {
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (uri != null && graph != null) {
			URI parentData = graph.getParentData(uri);
			if (parentData != null) {
				URI parent = parentData.trimFragment();
				return !isFragment(parent);
			}
		}
		return false;
	}

	/**
	 * Get the root resource of the whole model that contains the given fragment (represented by its uri).
	 * <p>
	 * If at some point of the process a fragment has several parents, this method will return
	 * <code>null</code>.
	 * </p>
	 * 
	 * @param uri
	 *            the given URI.
	 * @return the root resource of the whole model that contains the given fragment if found,
	 *         <code>null</code> otherwise.
	 */
	public static URI getRootResourceURI(URI uri) {
		final URI uriRoot;
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (uri != null && graph != null) {
			URI parentData = graph.getParentData(uri);
			if (parentData == null) {
				uriRoot = uri;
			} else {
				URI parent = parentData.trimFragment();
				uriRoot = getRootResourceURI(parent);
			}
		} else {
			uriRoot = null;
		}
		return uriRoot;
	}

	/**
	 * Get the first loaded parent resource URI of the given resource (represented by its URI) contained in
	 * the given ResourceSet.
	 * <p>
	 * If at some point of the process the current resource (represented by its URI) has several parents, this
	 * method will return <code>null</code>.
	 * 
	 * @param rs
	 *            the ResourceSet in which the first loaded parent must be found.
	 * @param uri
	 *            the URI of the resource for which we want to get its first loaded parent.
	 * @return the URI of the first loaded resource parent if found, <code>null</code> otherwise.
	 */
	public static URI getParentResourceURI(ResourceSet rs, URI uri) {
		final URI parentURI;
		final Entry<URI, Resource> entry = getResourceParent(rs, uri);
		if (entry != null) {
			final Resource resource = entry.getValue();
			if (resource != null) {
				parentURI = entry.getKey().trimFragment();
			} else {
				parentURI = null;
			}
		} else {
			parentURI = null;
		}
		return parentURI;
	}

	/**
	 * Get the parent of the given resource (represented by its URI) contained in the given ResourceSet.
	 * <p>
	 * If the given resource (represented by its URI) has several parents, this method will return
	 * <code>null</code>.
	 * </p>
	 * 
	 * @param rs
	 *            the ResourceSet in which the parent must be found.
	 * @param uri
	 *            the URI of the resource for which we want to get its parent.
	 * @return the parent of the given resource (represented by its URI) if found, <code>null</code>
	 *         otherwise.
	 */
	public static Resource getParent(ResourceSet rs, URI uri) {
		final Resource resource;
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (uri != null && graph != null) {
			URI parentData = graph.getParentData(uri);
			if (parentData != null) {
				resource = rs.getResource(parentData.trimFragment(), false);
			} else {
				resource = null;
			}
		} else {
			resource = null;
		}
		return resource;
	}

	/**
	 * Get the first loaded EObject parent of the given resource (represented by its URI) contained in the
	 * given ResourceSet.
	 * <p>
	 * If at some point of the process the current resource (represented by its URI) has several parents, this
	 * method will return <code>null</code>.
	 * 
	 * @param rs
	 *            the ResourceSet in which the first loaded parent must be found.
	 * @param uri
	 *            the URI of the resource for which we want to get its first loaded parent.
	 * @return the first loaded EObject parent of the given resource (represented by its URI) if found,
	 *         <code>null</code> otherwise.
	 */
	public static EObject getEObjectParent(ResourceSet rs, URI uri) {
		final EObject eObject;
		final Entry<URI, Resource> entry = getResourceParent(rs, uri);
		if (entry != null) {
			final Resource resource = entry.getValue();
			if (resource != null) {
				eObject = resource.getEObject(entry.getKey().fragment());
			} else {
				eObject = null;
			}
		} else {
			eObject = null;
		}
		return eObject;
	}

	/**
	 * Get the first loaded parent of the given resource (represented by its URI) contained in the given
	 * ResourceSet.
	 * <p>
	 * If at some point of the process the current resource (represented by its URI) has several parents, this
	 * method will return <code>null</code>.
	 * 
	 * @param rs
	 *            the ResourceSet in which the first loaded parent must be found.
	 * @param uri
	 *            the URI of the resource for which we want to get its first loaded parent.
	 * @return an entry composed with the first loaded EObject parent of the given resource (represented by
	 *         its URI) and the Resource associated if found, <code>null</code> otherwise.
	 */
	private static Entry<URI, Resource> getResourceParent(ResourceSet rs, URI uri) {
		Entry<URI, Resource> entry = null;
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (uri != null && graph != null) {
			URI parentData = graph.getParentData(uri);
			if (parentData != null) {
				URI parent = parentData.trimFragment();
				Resource resourceParent = rs.getResource(parent, false);
				if (resourceParent != null) {
					entry = Maps.immutableEntry(parentData, resourceParent);
				} else {
					entry = getResourceParent(rs, parent);
				}
			}
		}
		return entry;
	}

	/**
	 * Search from the given list of TreeNodes (and recursively on its children), the one that is associated
	 * to the given Match.
	 * 
	 * @param nodes
	 *            the given list of TreeNodes.
	 * @param match
	 *            the given Match.
	 * @return the TreeNode that is associated to the given Match.
	 */
	public static TreeNode getTreeNode(Collection<TreeNode> nodes, Match match) {
		for (TreeNode treeNode : nodes) {
			EObject data = TREE_NODE_DATA.apply(treeNode);
			if (data.equals(match)) {
				return treeNode;
			}
		}
		for (TreeNode treeNode : nodes) {
			TreeNode treeNode2 = getTreeNode(treeNode.getChildren(), match);
			if (treeNode2 != null) {
				return treeNode2;
			}
		}
		return null;
	}

	/**
	 * Get from the given list of TreeNodes, the one that has its data's resource's URI (TreeNode -> Match ->
	 * EObject -> Resource -> URI) corresponding to the given URI.
	 * 
	 * @param nodes
	 *            the given list of TreeNodes.
	 * @param uri
	 *            the given URI.
	 * @return the TreeNode that has its data's resource's URI corresponding to the given URI, or null if no
	 *         one match.
	 */
	public static TreeNode getTreeNodeFromURI(Collection<TreeNode> nodes, URI uri) {
		for (TreeNode treeNode : nodes) {
			EObject data = TREE_NODE_DATA.apply(treeNode);
			URI dataURI = getDataURI((Match)data);
			if (uri.equals(dataURI)) {
				return treeNode;
			}
		}
		return null;
	}

	/**
	 * Get the Resource's URI of the data associated to the given Match
	 * 
	 * @param match
	 *            the given Match.
	 * @return the Resource's URI of the data associated to the given Match.
	 */
	public static URI getDataURI(Match match) {
		final URI uri;
		final Resource resource;
		if (match.getLeft() != null) {
			resource = match.getLeft().eResource();
		} else if (match.getRight() != null) {
			resource = match.getRight().eResource();
		} else if (match.getOrigin() != null) {
			resource = match.getOrigin().eResource();
		} else {
			resource = null;
		}
		if (resource != null) {
			uri = resource.getURI();
		} else {
			uri = null;
		}
		return uri;
	}

	/**
	 * Get the Resource's URIs of the data associated to the given list of Matches.
	 * 
	 * @param matches
	 *            the given list of Matches.
	 * @param side
	 *            the given side of the comparison.
	 * @return the Resource's URIs of the data associated to the given list of Matches.
	 */
	public static Collection<URI> getDataURIs(Collection<Match> matches, MergeViewerSide side) {
		final Collection<URI> uris = Lists.newArrayList();
		for (Match match : matches) {
			URI dataURI = getDataURI(match, side);
			if (dataURI != null) {
				uris.add(dataURI);
			}
		}
		return uris;
	}

	/**
	 * Get the Resource's URI of the data associated to the given Match, and for the given side of the
	 * comparison. .
	 * 
	 * @param match
	 *            the given Match.
	 * @param side
	 *            the given side of the comparison.
	 * @return the Resource's URI of the data associated to the given Match.
	 */
	public static URI getDataURI(Match match, MergeViewerSide side) {
		final URI uri;
		final Resource resource;
		if (MergeViewerSide.LEFT == side && match.getLeft() != null) {
			resource = match.getLeft().eResource();
		} else if (MergeViewerSide.RIGHT == side && match.getRight() != null) {
			resource = match.getRight().eResource();
		} else if (MergeViewerSide.ANCESTOR == side && match.getOrigin() != null) {
			resource = match.getOrigin().eResource();
		} else {
			resource = null;
		}
		if (resource != null) {
			uri = resource.getURI();
		} else {
			uri = null;
		}
		return uri;
	}

	/**
	 * Get the Resource's ResourceSet of the data associated to the given Match.
	 * 
	 * @param match
	 *            the given Match.
	 * @return the Resource's ResourceSet of the data associated to the given Match.
	 */
	public static ResourceSet getDataResourceSet(Match match) {
		final ResourceSet rs;
		final Resource resource;
		if (match.getLeft() != null) {
			resource = match.getLeft().eResource();
		} else if (match.getRight() != null) {
			resource = match.getRight().eResource();
		} else if (match.getOrigin() != null) {
			resource = match.getOrigin().eResource();
		} else {
			resource = null;
		}
		if (resource != null) {
			rs = resource.getResourceSet();
		} else {
			rs = null;
		}
		return rs;
	}

	/**
	 * Get the Resource's ResourceSet of the data associated to the given Match, and for the given side of the
	 * comparison.
	 * 
	 * @param match
	 *            the given Match.
	 * @param side
	 *            the given side of the comparison.
	 * @return the Resource's ResourceSet of the data associated to the given Match.
	 */
	public static ResourceSet getDataResourceSet(Match match, MergeViewerSide side) {
		final ResourceSet rs;
		final Resource resource;
		if (MergeViewerSide.LEFT == side && match != null && match.getLeft() != null) {
			resource = match.getLeft().eResource();
		} else if (MergeViewerSide.RIGHT == side && match != null && match.getRight() != null) {
			resource = match.getRight().eResource();
		} else if (MergeViewerSide.ANCESTOR == side && match != null && match.getOrigin() != null) {
			resource = match.getOrigin().eResource();
		} else {
			resource = null;
		}
		if (resource != null) {
			rs = resource.getResourceSet();
		} else {
			rs = null;
		}
		return rs;
	}

	/**
	 * Check if the given list of TreeNodes contains at least two nodes that have NotLoadedFragmentMatch for
	 * data.
	 * 
	 * @param nodes
	 *            the given list of TreeNodes.
	 * @return <code>true</code> if the given list of TreeNodes contains at least two nodes that have
	 *         NotLoadedFragmentMatch for data, false otherwise.
	 */
	public static boolean containsNotLoadedFragmentNodes(Collection<TreeNode> nodes) {
		int notLoadedFragments = 0;
		for (TreeNode node : nodes) {
			EObject data = TREE_NODE_DATA.apply(node);
			if (data instanceof NotLoadedFragmentMatch) {
				notLoadedFragments++;
			}
		}
		return notLoadedFragments > 1;
	}

	/**
	 * Get from the given list of {@link IMergeViewerItem}s, the NotLoadedFragmentMatchs.
	 * 
	 * @param items
	 *            the given list of IMergeViewerItems.
	 * @return a list of Match.
	 */
	public static Collection<Match> getNotLoadedFragmentMatches(Collection<IMergeViewerItem> items) {
		final Collection<Match> notLoadedFragmentMatches = Lists.newArrayList();
		for (IMergeViewerItem item : items) {
			// If an IMergeViewerItem contains NotLoadedFragmentMatch, this is the same NotLoadedFragmentMatch
			// on left, right and ancestor sides.
			Object left = item.getLeft();
			if (left instanceof NotLoadedFragmentMatch) {
				notLoadedFragmentMatches.add((NotLoadedFragmentMatch)left);
			}
		}
		return notLoadedFragmentMatches;
	}

	/**
	 * Get the resource's name associated with the data of the given NotLoadedFragmentMatch. If it is a
	 * NotLoadedFragmentMatch containing others NotLoadedFragmentMatch, then it returns an empty string.
	 * 
	 * @param match
	 *            the given NotLoadedFragmentMatch.
	 * @return the resource's name associated with the data of the given NotLoadedFragmentMatch.
	 */
	public static String getResourceName(NotLoadedFragmentMatch match) {
		final String name;
		Collection<? extends Match> children = match.getChildren();
		if (Iterables.size(children) == 1) {
			URI uri = getDataURI(children.iterator().next());
			name = uri.lastSegment();
		} else {
			name = ""; //$NON-NLS-1$
		}
		return name;
	}

	/**
	 * Filters, from the root matches of the given comparison, those who will children matches of the given
	 * match if all fragments of the whole models involved in comparison had been loaded, for the given side
	 * of the comparison.
	 * 
	 * @param comparison
	 *            the given comparison, cannot be <code>null</code>.
	 * @param match
	 *            the given match, can be <code>null</code>.
	 * @param side
	 *            the given side of the comparison.
	 * @return a list of Matches.
	 */
	public static Collection<Match> getChildrenMatchWithNotLoadedParent(Comparison comparison, Match match,
			MergeViewerSide side) {
		if (match == null) {
			return emptyList();
		}
		final Collection<Match> childrenMatches = Sets.newLinkedHashSet();
		final Collection<Match> matches = comparison.getMatches();
		final IGraphView<URI> graph = getResourcesURIGraph();
		if (graph == null) {
			return childrenMatches;
		}
		ResourceSet rs = getDataResourceSet(match, side);
		if (rs == null) {
			return childrenMatches;
		}
		for (Match rootMatch : matches) {
			if (isFragment(rootMatch, side)) {
				URI uri = getDataURI(rootMatch, side);
				Resource resourceParent = getParent(rs, uri);
				URI parentData = graph.getParentData(uri);
				boolean _continue = true;
				while (resourceParent == null && _continue == true) {
					if (parentData != null) {
						resourceParent = getParent(rs, parentData.trimFragment());
						parentData = graph.getParentData(parentData.trimFragment());
					} else {
						_continue = false;
					}
				}
				if (resourceParent != null && parentData != null) {
					EObject eObjectParent = resourceParent.getEObject(parentData.fragment());
					Match matchParent = match.getComparison().getMatch(eObjectParent);
					if (matchParent != null && matchParent.equals(match)) {
						childrenMatches.add(rootMatch);
					}
				}
			}
		}
		return childrenMatches;
	}

	/**
	 * Check if the given URI is a child (directly or not) of one of the given list of URIs.
	 * 
	 * @param uri
	 *            the given URI.
	 * @param uris
	 *            the given list of URIs.
	 * @return true if the given URI is a child (directly or not) of one of the given list of URIs, false
	 *         otherwise.
	 */
	public static boolean isChildOf(URI uri, Collection<URI> uris) {
		final IGraphView<URI> graph = getResourcesURIGraph();
		URI parentData = graph.getParentData(uri);
		while (parentData != null) {
			URI parent = parentData.trimFragment();
			if (uris.contains(parent)) {
				return true;
			}
			parentData = graph.getParentData(parent);
		}
		return false;
	}

	/**
	 * Constructs a {@link org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch} from the given
	 * {@link org.eclipse.emf.compare.Match} and then return the
	 * {@link org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem} corresponding to this
	 * NotLoadedFragmentMatch.
	 * 
	 * @param match
	 *            the given Match.
	 * @param side
	 *            the side of the Match.
	 * @param comparison
	 *            the comparison object that contains the Match.
	 * @param adapterFactory
	 *            the adapter factory used to create the merge viewer item.
	 * @return an IMergeViewerItem.
	 */
	public static IMergeViewerItem createItemForNotLoadedFragmentMatch(Match match, MergeViewerSide side,
			Comparison comparison, AdapterFactory adapterFactory) {
		final MergeViewerItem.Container container;
		ResourceSet rs = getDataResourceSet(match, side);
		URI uri = getDataURI(match, side);
		EObject firstLoadedParent = getEObjectParent(rs, uri);
		if (firstLoadedParent == null) {
			NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(match);
			container = new MergeViewerItem.Container(comparison, null, notLoadedFragmentMatch,
					notLoadedFragmentMatch, notLoadedFragmentMatch, side, adapterFactory);
		} else if (isRootResource(firstLoadedParent.eResource().getURI())) {
			Match matchParent = comparison.getMatch(firstLoadedParent);
			if (matchParent != null) {
				if (!comparison.getMatches().contains(matchParent)) {
					container = new MergeViewerItem.Container(comparison, null, match.getLeft(),
							match.getRight(), match.getOrigin(), side, adapterFactory);
				} else {
					container = null;
				}
			} else {
				NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(match);
				container = new MergeViewerItem.Container(comparison, null, notLoadedFragmentMatch,
						notLoadedFragmentMatch, notLoadedFragmentMatch, side, adapterFactory);
			}
		} else {
			container = null;
		}
		return container;
	}

	/**
	 * Adds a new parent container to the given list of IMergeViewerItems if needed and returns it. If the
	 * given items don't need a new parent, return null.
	 * 
	 * @param items
	 *            the given IMergeViewerItems.
	 * @param side
	 *            the side of the Match.
	 * @param comparison
	 *            the comparison object that contains the Match.
	 * @param adapterFactory
	 *            the adapter factory used to create the merge viewer item.
	 * @return an IMergeViewerItem, or null.
	 */
	public static IMergeViewerItem addNewContainerForNotLoadedFragmentMatches(
			Collection<IMergeViewerItem> items, MergeViewerSide side, Comparison comparison,
			AdapterFactory adapterFactory) {
		final MergeViewerItem.Container newContainer;
		final Collection<Match> notLoadedFragmentMatches = getNotLoadedFragmentMatches(items);
		if (notLoadedFragmentMatches.size() > 1) {
			// Need to replace by top-container NotLoadedFragment item
			NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(
					notLoadedFragmentMatches);
			for (NotLoadedFragmentMatch match : filter(notLoadedFragmentMatches,
					NotLoadedFragmentMatch.class)) {
				match.setName(getResourceName(match));
			}
			newContainer = new MergeViewerItem.Container(comparison, null, notLoadedFragmentMatch,
					notLoadedFragmentMatch, notLoadedFragmentMatch, side, adapterFactory);
		} else {
			newContainer = null;
		}
		return newContainer;
	}
}
