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
package com.zeligsoft.cx.problem.navigation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.cdt.core.model.ICModelMarker;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.zeligsoft.cx.codegen.UserEditableRegion;

/**
 * This utility class allows callers to create a source tag for a given marker
 * as well as create the actual string tag given the appropriate information
 * 
 * @author tniro
 */
public class SourceTagUtility {

	// indexes into the tag
	private static final int INDEX_URI = 1;
	private static final int INDEX_PROPERTY = 2;
	private static final int INDEX_CONCEPT = 3;
	private static final int MIN_ELEMENTS = 4;

	// fields
	private URI uri = null;
	private String concept = null;
	private String property = null;

	/**
	 * hidden constructor
	 */
	private SourceTagUtility(URI uri, String concept, String property) {
		this.uri = uri;
		this.concept = concept;
		this.property = property;
	}

	/**
	 * get uri
	 */
	public URI getURI() {
		return uri;
	}

	/**
	 * get concept
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * get property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * get corresponding resource
	 */
	public IResource getResource() {
		String [] segments = uri.segments();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < segments.length; i++) {
			sb.append('/');
			sb.append(segments[i]);
		}

		IPath path = new Path(sb.toString());

		return ResourcesPlugin.getWorkspace().getRoot().findMember(path);		
	}

	/**
	 * Find the tag corresponding to the given CDT marker.
	 */
	public static SourceTagUtility findTag(IMarker marker) {

		try {
			// make sure we have a valid marker
			if (marker == null || !marker.isSubtypeOf(ICModelMarker.C_MODEL_PROBLEM_MARKER)) {
				return null;
			}
		} catch (CoreException ce) {
			return null;
		}

		// find the tag 
		String tag = findTag(marker.getResource(),marker.getAttribute(IMarker.LINE_NUMBER,0));
		if (tag == null) {
			return null;
		}

		// extract tag fields
		String [] elements = tag.trim().split(" "); //$NON-NLS-1$
		if ( elements == null || elements.length < MIN_ELEMENTS) {
			return null;
		}

		// get the URI
		URI uri = URI.createURI(elements[INDEX_URI]);
		if (uri == null) {
			return null;
		}

		return new SourceTagUtility(uri, elements[INDEX_CONCEPT], elements[INDEX_PROPERTY]);
	}

	/**
	 * Find the tag in the given file at the give location.
	 */
	private static String findTag(IResource resource, int line_no) {
		if (resource == null || line_no <= 0) {
			return null;
		}

		File file = resource.getLocation().toFile();
		if (!file.isFile() || !file.exists()) {
			return null;
		}

		String tag = null;
		FileReader fr = null;
		BufferedReader reader = null;

		try {
			fr = new FileReader(file);
			reader = new BufferedReader(fr);

			for(int i = 0; i < line_no; i++) {
				String line = reader.readLine();
				if (line == null) {
					// hit end of file before getting to give line
					break;
				}

				if (line.trim().startsWith(UserEditableRegion.UserRegionTag)) {
					// save the last tag
					tag = line;
				}
			}
		} catch (IOException ioe) {
			tag = null;
		} finally {
			try {
				reader.close();
				fr.close();
			} catch (IOException e) {
				// do nothing..
			}
		}

		return tag;
	}
}
