/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.internal.emf;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.common.core.util.Log;

import com.zeligsoft.domain.dds4ccm.tools.Activator;

/**
 * Dynamic pathmap descriptor.
 * 
 * @author Young-Soo Roh
 *
 */
public class CXPathmapDescriptor {

	private final String id;
	private final IProject project;
	private final URI pathmap;
	private final URI originalMapping;
	private final URI mapping;
	private boolean isEnabled;

	public CXPathmapDescriptor(URI sourceURI, URI targetURI) {
		id = "pathmap." + targetURI.authority();

		originalMapping = URIConverter.URI_MAP.get(sourceURI);
		pathmap = sourceURI;
		mapping = targetURI;

		// segment 0 is "resource"
		String projName = targetURI.segment(1);
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projName);

		isEnabled = !Activator.getBooleanPreference(id + ".disabled");
	}

	static boolean isPathmapScheme(URI uri) {
		return "pathmap".equals(uri.scheme());
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
			Activator.setPreference(id + ".disabled", !isEnabled);
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
				Log.info(Activator.getDefault(), 0, "Workspace URI Mapping: " + pathmap);
				URIConverter.URI_MAP.put(pathmap, mapping);
			}
		} else {
			Log.info(Activator.getDefault(), 0, "Removing workspace URI Mapping: " + pathmap);
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
		final CXPathmapDescriptor other = (CXPathmapDescriptor) obj;
		if (pathmap == null) {
			if (other.pathmap != null) {
				return false;
			}
		} else if (!pathmap.equals(other.pathmap)) {
			return false;
		}
		return true;
	}
}