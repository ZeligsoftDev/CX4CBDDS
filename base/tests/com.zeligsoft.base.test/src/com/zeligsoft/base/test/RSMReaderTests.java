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


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Profile;
import org.junit.Before;
import org.junit.Test;

import com.ibm.xtools.emf.core.resource.IRMPResource;
import com.zeligsoft.base.workflow.RSMReader;
import com.zeligsoft.base.workflow.SetupResourceSet;

/**
 * Tests for the RSMReader workflow component.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class RSMReaderTests
		extends AbstractWorkflowComponentTest<RSMReader> {

	private static final String BASE_PROFILE = "pathmap://UML2_MSL_PROFILES/ProfileBase.epx";

	private static final String MODEL_SLOT = "testModel";

	protected ResourceSet rset;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public RSMReaderTests() {
		// Default constructor
	}

	/**
	 * Tests the reading of an EPX file.
	 */
	@Test
	public void test_readEPXFile() {
		configureFixture();
		invokeFixture();

		Object root = getSlot(MODEL_SLOT);

		assertNotNull("Nothing loaded", root);
		assertTrue("Not a profile", root instanceof Profile);

		Profile profile = (Profile) root;

		assertNotNull("Profile corrupt", profile
			.getOwnedStereotype("ProfileConstraint"));

		assertTrue("Wrong resource factory used",
			profile.eResource() instanceof IRMPResource);
	}

	//
	// Test framework methods
	//
	@Before
	@Override
	public void setUp()
			throws Exception {
		
		super.setUp();

		rset = new ResourceSetImpl();
		SetupResourceSet.enablePathmaps(rset);
	}

	@Override
	protected RSMReader createFixture() {
		return new RSMReader();
	}

	/**
	 * Sets the inputs required by the RSMReader.
	 */
	protected void configureFixture() {
		setProperty(RSMReader.URI_PROPERTY, BASE_PROFILE);
		setProperty("modelSlot", MODEL_SLOT);
		setProperty("resourceSetSlot", "rset");
		setSlot("rset", rset);
	}
}
