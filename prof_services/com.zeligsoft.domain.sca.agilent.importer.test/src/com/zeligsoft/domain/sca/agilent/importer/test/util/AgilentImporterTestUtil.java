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
package com.zeligsoft.domain.sca.agilent.importer.test.util;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class AgilentImporterTestUtil {

	public static String PLUGIN_ID = "com.zeligsoft.domain.sca.agilent.importer.test";

	// The tests must be run as a Plugin-test because the EMF resource loading
	// code needs extensions to be loaded. Since that's the case, it doesn't
	// hurt to use the bundle locator stuff.
	public static URL getLocalURL(String path) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		return FileLocator.find(bundle, new Path(path), null);
	}
}
