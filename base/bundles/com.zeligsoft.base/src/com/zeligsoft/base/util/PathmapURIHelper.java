/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl.URIMap;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * An adapter for {@link ResourceSet}s that proactively ensures that
 * {@link Resource}s use "pathmap" URIs whenever possible. This is similar to
 * GMF's <tt>PathmapManager</tt> class except that it is applied to all
 * resources, regardless of whether they are <tt>GMFResource</tt>s.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class PathmapURIHelper
		extends AdapterImpl {

	private ResourceSet resourceSet;

	/**
	 * Not instantiable by clients.
	 */
	private PathmapURIHelper(ResourceSet rset) {
		super();

		this.resourceSet = rset;
	}

	/**
	 * Ensures that a <tt>PathmapURIHelper</tt> is installed on the specified
	 * resource set. If one is already installed, then this method has no
	 * effect.
	 * 
	 * @param rset
	 *            a resource set on which to install the URI helper
	 */
	public static void install(ResourceSet rset) {
		if (EcoreUtil.getExistingAdapter(rset, PathmapURIHelper.class) == null) {
			rset.eAdapters().add(new PathmapURIHelper(rset));
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// don't call super because we don't need to track a target
		if (newTarget == resourceSet) {
			// propagate to the existing resources
			for (Resource next : resourceSet.getResources()) {
				handleResourceAdded(next);
			}
		} else if (newTarget instanceof Resource) {
			updateURI((Resource) newTarget);
		}
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		// don't call super because we don't need to track a target
		if (oldTarget == resourceSet) {
			// remove from the existing resources
			for (Resource next : resourceSet.getResources()) {
				handleResourceRemoved(next);
			}
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		Object notifier = msg.getNotifier();

		if (notifier == resourceSet) {
			handleResourceSetChange(msg);
		} else if (notifier instanceof Resource) {
			handleResourceChange(msg);
		}
	}

	private void handleResourceSetChange(Notification msg) {
		if (msg.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES) {
			switch (msg.getEventType()) {
				case Notification.ADD :
					handleResourceAdded((Resource) msg.getNewValue());
					break;
				case Notification.REMOVE :
					handleResourceRemoved((Resource) msg.getOldValue());
					break;
				case Notification.SET :
					handleResourceAdded((Resource) msg.getNewValue());
					handleResourceRemoved((Resource) msg.getOldValue());
					break;
				case Notification.ADD_MANY :
					@SuppressWarnings("unchecked")
					Collection<Resource> newResources = (Collection<Resource>) msg
						.getNewValue();
					for (Resource next : newResources) {
						handleResourceAdded(next);
					}
					break;
				case Notification.REMOVE_MANY :
					@SuppressWarnings("unchecked")
					Collection<Resource> oldResources = (Collection<Resource>) msg
						.getOldValue();
					for (Resource next : oldResources) {
						handleResourceRemoved(next);
					}
					break;
			}
		}
	}

	private void handleResourceAdded(Resource resource) {
		if (!resource.eAdapters().contains(this)) {
			resource.eAdapters().add(this);
			updateURI(resource);
		}
	}

	private void handleResourceRemoved(Resource resource) {
		resource.eAdapters().remove(this);
	}

	private void handleResourceChange(Notification msg) {
		if (msg.getFeatureID(Resource.class) == Resource.RESOURCE__URI) {
			updateURI((Resource) msg.getNotifier());
		}
	}

	/**
	 * Updates the given resource's URI to the denormalized <tt>pathmap</tt>
	 * scheme URI that covers it, if any.
	 * 
	 * @param resource
	 *            a resource to update
	 */
	private void updateURI(Resource resource) {
		URI uri = resource.getURI();
		URI denorm = denormalizeURI(resourceSet.getURIConverter(), uri);

		if (!uri.equals(denorm)) {
			resource.setURI(denorm);
			denorm = denormalizeURI(resourceSet.getURIConverter(), uri);
		}
	}

	/**
	 * A <i>Foreign Method</i> for the {@link URIConverter} interface, that
	 * denormalizes a <tt>platform</tt> scheme {@link URI} to <tt>pathmap</tt>
	 * scheme.
	 * 
	 * @param self
	 *            the target URI converter
	 * @param uri
	 *            the URI to denormalize
	 * 
	 * @return the denormalized <tt>pathmap</tt> URI, or the original URI as is
	 *         if either it wasn't a <tt>platform</tt> URI or it wasn't covered
	 *         by a <tt>pathmap</tt> URI mapping
	 */
	public static URI denormalizeURI(URIConverter self, URI uri) {
		URI result = uri;

		if (uri.isPlatform()) {
			URIMap map = (URIMap) self.getURIMap();
			Set<URI> pathmaps = getAllPathmaps(map);

			// search the URI map for the longest match
			int longest = 0;

			URI resultPrefix = null; // the resulting longest-match URI prefix
			URI resultPathmap = null; // the pathmap for the result prefix

			for (URI next : pathmaps) {
				URI key = next;

				for (;;) {
					URI candidate = map.getURI(key);
					if (candidate.isPlatform() && candidate.isPrefix()) {
						int len = getPrefixLength(candidate, uri);

						if (longest < len) {
							longest = len;
							resultPrefix = candidate;
							resultPathmap = next;
						}
						break;
					} else if (!candidate.isPrefix() || candidate.equals(key)) {
						break;
					} else {
						// iterate the resolution on this prefix
						key = candidate;
					}
				}
			}

			if (resultPathmap != null) {
				// swap prefixes
				result = uri.replacePrefix(resultPrefix, resultPathmap);
			}
		}

		return result;
	}

	/**
	 * Obtains the number of segments that the specified prefix has in common,
	 * contiguously from the first segment, with the given URI. At least two
	 * common segments are required for a match, because the inputs are both
	 * expected to be <tt>platform</tt> scheme URIs and we don't want to cross
	 * between the <tt>resource</tt> and <tt>plugin</tt> domains.
	 * 
	 * @param prefix
	 *            a <tt>platform</tt> scheme URI prefix
	 * @param uri
	 *            a <tt>platform</tt> scheme URI against which to match the
	 *            prefix
	 * 
	 * @return the number of common initial segments, or zero if the
	 *         <tt>prefix</tt> is not a prefix of the given URI
	 */
	private static int getPrefixLength(URI prefix, URI uri) {
		String[] prefixSegs = prefix.segments();
		String[] uriSegs = uri.segments();

		// trailing empty segment always matches because it denotes prefix URI
		int limit = prefixSegs.length - 1;
		int result = 0;

		for (int i = 0; i < limit; i++) {
			if (!prefixSegs[i].equals(uriSegs[i])) {
				break;
			}

			result++;
		}

		// must match the entire prefix
		return (result >= limit)
			? result
			: 0;
	}

	/**
	 * <p>
	 * Gets all of the URI mapping keys in the specified URI map that match the
	 * following conditions:
	 * </p>
	 * <ul>
	 * <li>the URI is a <tt>pathmap</tt> scheme</li>
	 * <li>the URI is a "prefix", meaning that it has a trailing slash. All
	 * pathmap URI registrations are expected to be prefixes because they are
	 * used to identify folders in plug-ins, rather than individual resources.
	 * This is also a requirement of certain {@link URI} APIs for substituting
	 * prefixes in the URI normalization algorithm</li>
	 * </ul>
	 * <p>
	 * This method accounts for the fact that the URI map ordinary delegates to
	 * the shared {@linkplain URIConverter#URI_MAP registry} for mappings that
	 * it does not maintain, itself.
	 * </p>
	 * 
	 * @param uriMap
	 *            the URI map of a resource set's {@link URIConverter}
	 * @return the set of all eligible <tt>pathmap</tt> URI prefixes
	 */
	private static Set<URI> getAllPathmaps(Map<URI, URI> uriMap) {
		Set<URI> result = new java.util.HashSet<URI>();

		for (URI next : uriMap.keySet()) {
			// we only want pathmap scheme that maps to a folder, not to a file
			if ("pathmap".equals(next.scheme()) && next.isPrefix()) { //$NON-NLS-1$
				result.add(next);
			}
		}

		// the map also delegates to the shared registry, unless it is the
		// shared registry
		if (uriMap != URIConverter.URI_MAP) {
			result.addAll(getAllPathmaps(URIConverter.URI_MAP));
		}

		return result;
	}
}
