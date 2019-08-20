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
package com.zeligsoft.base.zdl.oaw;

import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.XtendResourceParser;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.expression.ResourceParser;

/**
 * A custom {@link ResourceManager} which adds additional caching that the default
 * one doesn't. When the ResourceLoaderFactory.createResourceLoader().
 * getResourceAsStream(resourceName) is null it caches this result which wasn't being
 * cached before. Within the same generation it won't find it all of the sudden.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class ZResourceManager extends ResourceManagerDefaultImpl {
	private final Map<String, Resource> resources = new HashMap<String, Resource>();

	public ZResourceManager() {
		XtendResourceParser xtendResourceParser = new XtendResourceParser();
		registeredParsers.put(XtendFile.FILE_EXTENSION,
				xtendResourceParser);
	}

	@Override
	public Resource loadResource(final String fullyQualifiedName,
			final String extension) {
		final String resourceName = fullyQualifiedName.replace(
				SyntaxConstants.NS_DELIM, "/")
				+ "." + extension;
		
		if (resources.containsKey(resourceName)) {
			return resources.get(resourceName);
		}
		
		final InputStream in = ResourceLoaderFactory.createResourceLoader()
				.getResourceAsStream(resourceName);

		if (in == null) {
			resources.put(resourceName, null);
			return null;
		}
		else {
			Reader reader = createReader(in);
			final ResourceParser parser = registeredParsers.get(extension);
			if (parser == null)
				throw new RuntimeException(
						"No Parser registered for extension '" + extension
								+ "'! Known extensions are '"
								+ registeredParsers.keySet() + "'");
			final Resource res = parser.parse(reader, resourceName);
			res.setFullyQualifiedName(fullyQualifiedName);
			resources.put(resourceName, res);
			return res;
		}
	}
}
