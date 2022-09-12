/**
 * Copyright 2020-2022 Northrop Grumman Systems Corporation.
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
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.Activator;

/**
 * Dynamic pathmap descriptor.
 * 
 * @author Young-Soo Roh
 *
 */
public class PathmapDescriptor {

	private final String id;
	private final IProject project;
	private final URI pathmap;
	private final URI originalMapping;
	private List<String> registeredModels = new ArrayList<String>();
	private final URI mapping;
	private boolean isEnabled;
	private IEclipsePreferences store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

	public PathmapDescriptor(URI sourceURI, URI targetURI, String modelName) {
		id = "pathmap." + targetURI.toString(); //$NON-NLS-1$
		registeredModels.add(modelName);
		originalMapping = URIConverter.URI_MAP.get(sourceURI);
		pathmap = sourceURI;
		mapping = targetURI;

		// segment 0 is "resource"
		String projName = targetURI.segment(1);
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projName);

		isEnabled = !store.getBoolean(id + ".disabled", true); //$NON-NLS-1$
	}

	public void addRegisteredModel(String modelName) {
		registeredModels.add(modelName);
	}

	public void removeRegisteredModel(String modelName) {
		registeredModels.remove(modelName);
	}

	public List<String> getRegisteredModels() {
		return registeredModels;
	}

	static boolean isPathmapScheme(URI uri) {
		return "pathmap".equals(uri.scheme()); //$NON-NLS-1$
	}

	static boolean isEligible(URI source, URI target) {
		return isPathmapScheme(source) && target.isPlatformPlugin();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		boolean oldEnabled = this.isEnabled;

		this.isEnabled = isEnabled;

		if (oldEnabled != isEnabled) {
			store.putBoolean(id + ".disabled", !isEnabled); //$NON-NLS-1$
			try {
				store.flush();
			} catch (BackingStoreException e) {
				// do nothing
			}
		}
	}

	public String getId() {
		return id;
	}

	public IProject getProject() {
		return project;
	}

	public URI getPathmap() {
		return pathmap;
	}

	public URI getOriginalMapping() {
		return originalMapping;
	}

	public URI getMapping() {
		return mapping;
	}

	public void apply() {
		URI current = URIConverter.URI_MAP.get(pathmap);

		if (isEnabled()) {
			if (!mapping.equals(current) && project.exists()) {
				Log.info(Activator.getDefault(), 0, "Workspace URI Mapping: " + pathmap); //$NON-NLS-1$
				URIConverter.URI_MAP.put(pathmap, mapping);
			}
		} else {
			Log.info(Activator.getDefault(), 0, "Removing workspace URI Mapping: " + pathmap); //$NON-NLS-1$
			if (originalMapping != null) {
				URIConverter.URI_MAP.put(pathmap, originalMapping);
			} else {
				URIConverter.URI_MAP.remove(pathmap);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		if (pathmap != null) {
			result += pathmap.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PathmapDescriptor other = (PathmapDescriptor) obj;
		if (pathmap != other.pathmap) {
			return false;
		}
		if (mapping != other.mapping) {
			return false;
		}
		return true;
	}
}