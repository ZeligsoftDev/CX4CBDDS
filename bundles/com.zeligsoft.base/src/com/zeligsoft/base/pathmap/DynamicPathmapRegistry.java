/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.base.pathmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.Activator;

/**
 * CX Dynamic Pathmap URI converter
 * 
 * @author Young-Soo Roh
 *
 */
public class DynamicPathmapRegistry {

	private Map<URI, List<PathmapDescriptor>> PATHMAPS = new HashMap<URI, List<PathmapDescriptor>>();

	private List<PathmapChangeListener> listeners = new ArrayList<PathmapChangeListener>();

	public static final DynamicPathmapRegistry INSTANCE = new DynamicPathmapRegistry();

	private DynamicPathmapRegistry() {
		super();
	}

	public void addChangeListener(PathmapChangeListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeChangeListener(PathmapChangeListener listener) {
		listeners.remove(listener);
	}

	/**
	 * clear all registered pathmaps
	 * 
	 * @return
	 */
	public void reset() {
		for (URI uri : PATHMAPS.keySet()) {
			List<PathmapDescriptor> mappings = getPathmapDescriptors(uri);
			mappings.clear();
		}
		PATHMAPS.clear();
	}
	
	/**
	 * Return active pathmap descriptor
	 * 
	 * @param uri
	 * @return
	 */
	public PathmapDescriptor getPathmapDescriptor(URI uri) {
		List<PathmapDescriptor> mappings = PATHMAPS.get(uri);
		if (mappings == null) {
			return null;
		}
		List<PathmapDescriptor> enabledPathmap = mappings.stream().filter(p -> p.isEnabled())
				.collect(Collectors.toList());
		return enabledPathmap.isEmpty() ? mappings.get(0) : enabledPathmap.get(0);
	}

	/**
	 * Return all pathmap descriptors
	 * 
	 * @param uri
	 * @return
	 */
	public List<PathmapDescriptor> getPathmapDescriptors(URI uri) {
		List<PathmapDescriptor> results = new ArrayList<PathmapDescriptor>();
		if (PATHMAPS.containsKey(uri)) {
			results.addAll(PATHMAPS.get(uri));
		}
		return results;
	}

	/**
	 * Return all pathmaps
	 * 
	 * @return
	 */
	public List<PathmapDescriptor> getPathmaps() {

		List<PathmapDescriptor> result = new java.util.ArrayList<PathmapDescriptor>();
		for (URI uri : PATHMAPS.keySet()) {
			result.add(getPathmapDescriptor(uri));
		}
		return result;
	}

	/**
	 * Return all Pathmaps with multiple mappings
	 * 
	 * @return
	 */
	public Map<URI, List<PathmapDescriptor>> getConflictPathmaps() {
		Map<URI, List<PathmapDescriptor>> results = new HashMap<URI, List<PathmapDescriptor>>();
		for (java.util.Map.Entry<URI, List<PathmapDescriptor>> entry : PATHMAPS.entrySet()) {
			if (entry.getValue() != null && entry.getValue().size() > 1) {
				results.put(entry.getKey(), entry.getValue());
			}
		}
		return results;
	}

	/**
	 * Enable given pathmap mapping and disable other mappings
	 * 
	 * @param desc
	 */
	@SuppressWarnings("nls")
	public void enablePathmapMapping(PathmapDescriptor desc, int eventType) {
		if (desc.isEnabled()) {
			// already enabled
			return;
		}
		PathmapDescriptor oldValue = getPathmapDescriptor(desc.getPathmap());
		List<PathmapDescriptor> mappings = getPathmapDescriptors(desc.getPathmap());
		for (PathmapDescriptor d : mappings) {
			if (d != desc && d.isEnabled()) {
				d.setEnabled(false);
				d.apply();
			}
		}
		Activator.getDefault().info("Dynamic library " + desc.getPathmap().toString() + "("
				+ desc.getMapping().toString() + ")" + " activated");
		desc.setEnabled(true);
		desc.apply();
		for (PathmapChangeListener listener : listeners) {
			listener.handlePathmapChange(desc, oldValue, eventType);
		}
	}

	public List<PathmapDescriptor> getEnabledPathmaps() {

		List<PathmapDescriptor> pathmaps = getPathmaps();
		List<PathmapDescriptor> result = new java.util.ArrayList<PathmapDescriptor>(pathmaps.size());

		for (PathmapDescriptor next : pathmaps) {
			if (next.isEnabled()) {
				result.add(next);
			}
		}

		return result;
	}

	private boolean isLinked(IResource resource) {
		IResource r = resource;

		while (r != null && !(r instanceof IProject)) {
			if (r.isLinked()) {
				return true;
			}
			r = r.getParent();
		}
		return false;
	}

	@SuppressWarnings("nls")
	public PathmapDescriptor addMapping(URI pathmapUri, URI modelUri) {
		String modelName = modelUri.lastSegment();
		URI targetURI = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$

		PathmapDescriptor desc = getPathmapDescriptor(pathmapUri);

		if (desc != null && desc.getMapping().equals(targetURI)) {
			// same mapping exist possibly from different model
			// so add the model name to the existing descriptor
			if (!desc.getRegisteredModels().contains(modelName)) {
				desc.addRegisteredModel(modelName);
			}
			return desc;
		} else {
			if (desc != null) {

				// See if this is a link
				URI normalizedUri = URIConverter.INSTANCE.normalize(modelUri);
				String path = normalizedUri.toPlatformString(true);
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
				if (isLinked(file)) {
					// If this is a link and there is alreay a mapping, then ignore it
					return desc;
				}

				String mappedPath = desc.getMapping().toString();
				IResource folder = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(mappedPath));
				// Silently override mapping over linked resource.
				if (isLinked(folder)) {
					// There is already registered pathmap to a different location
					// It means the model library is either moved or a new model library
					// is trying to register to the same pathmap URI
					// Remove existing mapping in this case.
					List<PathmapDescriptor> mappings = PATHMAPS.get(pathmapUri);
					mappings.remove(desc);
				}
			}
			desc = new PathmapDescriptor(pathmapUri, targetURI, modelName);
			if (!PATHMAPS.containsKey(pathmapUri)) {
				desc.setEnabled(true);
				desc.apply();
				PATHMAPS.put(pathmapUri, new ArrayList<PathmapDescriptor>());
			} else {
				// pathmap was previously enabled so disable current mapping and
				// enable this new mapping
				if (desc.isEnabled()) {
					for (PathmapDescriptor d : getPathmapDescriptors(desc.getPathmap())) {
						d.setEnabled(false);
						d.apply();
					}
					// always enable after disable
					desc.apply();
				}
			}
			List<PathmapDescriptor> mappings = PATHMAPS.get(pathmapUri);
			mappings.add(desc);

			if (desc.isEnabled()) {
				Activator.getDefault().info("New dynamic library " + desc.getPathmap().toString() + "("
						+ desc.getMapping().toString() + ")" + " activated");
			}

			for (PathmapChangeListener listener : listeners) {
				listener.handlePathmapChange(desc, null, PathmapChangeListener.ADD);
			}
		}
		return desc;
	}

	@SuppressWarnings("nls")
	public URI removeMapping(URI modelUri) {
		// Find possible entry from PATHMAP and remove it
		URI uri = URIConverter.INSTANCE.normalize(modelUri);
		String modelName = uri.lastSegment();
		URI targetURI = uri.trimSegments(1).appendSegment(UML2Util.EMPTY_STRING);
		URI pathmapURI = null;
		PathmapDescriptor desc = null;
		for (URI key : PATHMAPS.keySet()) {
			for (PathmapDescriptor d : getPathmapDescriptors(key)) {
				if (d.getMapping().equals(targetURI) && d.getRegisteredModels().contains(modelName)) {
					desc = d;
					pathmapURI = key;
					break;
				}
			}
			if (desc != null) {
				break;
			}
		}
		if (desc == null) {
			return null;
		}

		if (desc.isEnabled()) {
			Activator.getDefault().info("Active dynamic library " + desc.getPathmap().toString() + "("
					+ desc.getMapping().toString() + ")" + " removed");
		}

		if (desc.getRegisteredModels().size() == 1) {
			// remove this mapping from the pathmap mapping list
			PATHMAPS.get(pathmapURI).remove(desc);

			if (PATHMAPS.get(pathmapURI).isEmpty()) {
				PATHMAPS.remove(pathmapURI);
				// mappings are empty so remove this pathmap
				// and fire REMOVE event
				if (desc.isEnabled()) {
					desc.setEnabled(false);
					desc.apply();
					for (PathmapChangeListener listener : listeners) {
						listener.handlePathmapChange(null, desc, PathmapChangeListener.REMOVE);
					}
				}

			} else if (desc.isEnabled()) {
				// mappings are not empty and the pathmap is enabled
				desc.setEnabled(false);
				desc.apply();

				PathmapDescriptor newDesc = PATHMAPS.get(pathmapURI).get(0);
				newDesc.setEnabled(true);
				newDesc.apply();

				// enable mapping from one of the mapping list
				// this should fire FALLBACK event
				for (PathmapChangeListener listener : listeners) {
					listener.handlePathmapChange(newDesc, desc, PathmapChangeListener.FALLBACK);
				}
			}
		} else {
			// just remove the registered model
			if (desc.getRegisteredModels().contains(modelName)) {
				desc.getRegisteredModels().remove(modelName);
			}
		}
		return pathmapURI;
	}

	/**
	 * Return pathmapped URI if exists
	 * 
	 * @param modelUri
	 * @return
	 */
	public URI denormalizeURI(URI modelUri) {
		URI targetUri = modelUri.trimSegments(1).appendSegment(""); //$NON-NLS-1$
		String modelName = modelUri.lastSegment();
		String umlModelName = modelUri.trimFileExtension().appendFileExtension("uml").lastSegment(); //$NON-NLS-1$
		for (URI pathmapUri : PATHMAPS.keySet()) {
			PathmapDescriptor desc = getPathmapDescriptor(pathmapUri);
			if (targetUri.equals(desc.getMapping()) && desc.getRegisteredModels().contains(umlModelName)) {
				if (desc.isEnabled()) {
					URI result = URI.createURI(pathmapUri.toString() + modelName);
					return result;
				}
				break;
			}
		}
		return modelUri;
	}

}