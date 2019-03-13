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
package com.zeligsoft.base.test;


import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import com.zeligsoft.base.util.ZeligsoftURIConverter;

/**
 * Tests the {@link ZeligsoftURIConverter} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ZeligsoftURIConverterTest {

	/**
	 * @param name
	 */
	public ZeligsoftURIConverterTest() {
		// Default constructor
	}

	/**
	 * Tests the URI converter's correction of multiple occurrences of
	 * <tt>..</tt> segments originating from resolution of relative URIs.
	 */
	@Test
	public void test_multipleParentSegments_13690() {
		ResourceSet rset = new ResourceSetImpl();

		rset.getURIConverter().getURIMap().put(
			URI.createURI("zelig://ZMODELS/"),
			URI.createURI("platform:/plugin/com.zeligsoft.foo/models/a/"));
		rset.getURIConverter().getURIMap().put(
			URI.createURI("zelig://ZPROFILES/"),
			URI.createURI("platform:/plugin/com.zeligsoft.foo/profiles/b/"));

		URI base = URI.createURI("zelig://ZMODELS/a.uml");
		URI relative = URI.createURI("../.././profiles/b/b.profile.uml");
		URI logical = relative.resolve(base);

		assertEquals("zelig://ZMODELS/../../profiles/b/b.profile.uml", logical
			.toString());

		ZeligsoftURIConverter.install(rset);
		URI physical = rset.getURIConverter().normalize(logical);

		assertEquals(
			"platform:/plugin/com.zeligsoft.foo/profiles/b/b.profile.uml",
			physical.toString());
	}

}
