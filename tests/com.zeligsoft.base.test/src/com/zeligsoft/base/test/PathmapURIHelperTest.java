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

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.util.PathmapURIHelper;

/**
 * Tests the {@link PathmapURIHelper} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class PathmapURIHelperTest {

	private URIConverter fixture;

	private ResourceSet rset;

	/**
	 * @param name
	 */
	public PathmapURIHelperTest() {
		// Default constructor
	}

	/**
	 * Tests that denormalizing a non-platform URI has no effect.
	 */
	@Test
	public void test_nonPlatformURI() {
		assertMapping("file:///com.foo/models/my.uml",
			"file:///com.foo/models/my.uml");
		assertMapping("pathmap://FOO/../models/my.profile.uml",
			"pathmap://FOO/../models/my.profile.uml");
	}

	/**
	 * Tests that denormalizing a platform URI has no effect when it is not
	 * covered by a pathmap.
	 */
	@Test
	public void test_platformURINotCoveredByPathmap() {
		assertMapping("platform:/resource/com.foo/models/my.uml",
			"platform:/resource/com.foo/models/my.uml");

		// we don't use relative URIs to navigate between plug-ins or
		// between projects
		assertMapping("platform:/plugin/com.foz/models/my.uml",
			"platform:/plugin/com.foz/models/my.uml");
	}

	/**
	 * Tests denormalizing a platform URI that is covered by a pathmap.
	 */
	@Test
	public void test_platformURICoveredByAPathmap() {
		assertMapping("pathmap://FOO/my.uml",
			"platform:/plugin/com.foo/models/my.uml");
		assertMapping("pathmap://FOO/a/my.uml",
			"platform:/plugin/com.foo/models/a/my.uml");
		assertMapping("pathmap://FOO_AB/my.uml",
			"platform:/plugin/com.foo/models/a/b/my.uml");
		assertMapping("pathmap://FOO_AB/c/my.uml",
			"platform:/plugin/com.foo/models/a/b/c/my.uml");
	}

	/**
	 * Tests the updating of a resource's URI when it is added to the resource
	 * set.
	 */
	@Test
	public void test_addResourceToResourceSet() {
		Resource res = new ResourceImpl(URI
			.createURI("platform:/plugin/com.foo/models/a/b/c/my.uml"));

		rset.getResources().add(res);

		assertURI("pathmap://FOO_AB/c/my.uml", res);
	}

	/**
	 * Tests the updating of a resource's URI when it is changed while already
	 * in a resource set.
	 */
	@Test
	public void test_changeResourceURI() {
		Resource res = new ResourceImpl(URI
			.createURI("platform:/resource/com.foo/models/a/b/c/my.uml"));

		rset.getResources().add(res);

		// no mapping for this URI
		assertURI("platform:/resource/com.foo/models/a/b/c/my.uml", res);

		res.setURI(URI
			.createURI("platform:/plugin/com.foo/models/a/b/c/my.uml"));

		assertURI("pathmap://FOO_AB/c/my.uml", res);
	}

	/**
	 * Tests the loading/creation of a resource based on a mapped URI.
	 */
	@Test
	public void test_createResource() {
		Resource res = rset.createResource(URI
			.createURI("platform:/plugin/com.foo/models/a/b/c/my.uml"));

		assertURI("pathmap://FOO_AB/c/my.uml", res);
	}

	//
	// Test framework
	//

	@Before
	public void setUp()
			throws Exception {

		fixture = new ExtensibleURIConverterImpl();
		Map<URI, URI> map = fixture.getURIMap();

		map.put(URI.createURI("pathmap://FOO/"), URI.createPlatformPluginURI(
			"com.foo/models/", true));
		map.put(URI.createURI("pathmap://FOO_AB/"), URI
			.createPlatformPluginURI("com.foo/models/a/b/", true));
		map.put(URI.createURI("pathmap://BAR/"), URI.createPlatformPluginURI(
			"com.bar/models/", true));
		map.put(URI.createURI("pathmap://BAZ/"), URI.createPlatformPluginURI(
			"com.baz/models/a/b/", true));

		rset = new ResourceSetImpl();
		rset.setURIConverter(fixture);
		
		PathmapURIHelper.install(rset);
	}

	private void assertMapping(String expected, String original) {
		URI expectedURI = URI.createURI(expected);
		URI originalURI = URI.createURI(original);

		URI denormalized = PathmapURIHelper
			.denormalizeURI(fixture, originalURI);

		assertEquals("Unexpected denormalization", expectedURI, denormalized);
	}

	private void assertURI(String expected, Resource resource) {
		URI expectedURI = URI.createURI(expected);
		assertEquals("Unexpected denormalization", expectedURI, resource
			.getURI());
	}
}
