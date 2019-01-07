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
package com.zeligsoft.base.rsm.tooling.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.rsm.tooling.utils.RSMUtil;

/**
 * Test cases for the {@link RSMUtil} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class RSMUtilTest
		extends TestCase {

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public RSMUtilTest(String name) {
		super(name);
	}

	/**
	 * Creates my test suite.
	 * 
	 * @return my test suite
	 */
	public static Test suite() {
		return new TestSuite(RSMUtilTest.class, "RSMUtil misc utility tests");
	}

	/**
	 * Tests the loading of packages of the model kind.
	 */
	public void test_loadPackage_model() {
		ResourceSet rset = new ResourceSetImpl();

		Model model = RSMUtil.loadPackage(rset, URI
			.createURI(UMLResource.JAVA_PRIMITIVE_TYPES_LIBRARY_URI));

		assertNotNull(model);
		assertNotNull(model.getOwnedType("boolean"));

		// try loading again; make sure we don't somehow load a second instance
		Model another = RSMUtil.loadPackage(rset, URI
			.createURI(UMLResource.JAVA_PRIMITIVE_TYPES_LIBRARY_URI));
		assertSame(model, another);
	}

	/**
	 * Tests the loading of packages of the profile kind.
	 */
	public void test_loadPackage_profile() {
		ResourceSet rset = new ResourceSetImpl();

		Profile profile = RSMUtil.loadPackage(rset, URI
			.createURI(UMLResource.ECORE_PROFILE_URI));

		assertNotNull(profile);
		assertNotNull(profile.getOwnedType("EClass"));

		// try loading again; make sure we don't somehow load a second instance
		Profile another = RSMUtil.loadPackage(rset, URI
			.createURI(UMLResource.ECORE_PROFILE_URI));
		assertSame(profile, another);
	}
}
