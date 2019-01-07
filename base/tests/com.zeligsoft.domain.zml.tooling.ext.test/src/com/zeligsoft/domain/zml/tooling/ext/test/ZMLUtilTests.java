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
package com.zeligsoft.domain.zml.tooling.ext.test;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.tooling.ext.ZMLUtil;

import junit.framework.TestCase;

/**
 * Tests the {@link ZMLUtil} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ZMLUtilTests
		extends TestCase {

	private ResourceSet rset;

	private Profile zml;

	private Resource testResource;

	private Package testPackage;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public ZMLUtilTests(String name) {
		super(name);
	}

	/**
	 * Tests access to the realizations of a component interface.
	 */
	public void test_getRealizations_13406() {
		Component interfase = (Component) testPackage.createOwnedType("I",
			UMLPackage.Literals.COMPONENT);
		// don't apply the <<componentInterface>> stereotype, yet
		
		Component real1 = (Component) testPackage.createOwnedType("R1",
			UMLPackage.Literals.COMPONENT);
		real1.createGeneralization(interfase);
		Component real2 = (Component) testPackage.createOwnedType("R2",
			UMLPackage.Literals.COMPONENT);
		real2.createGeneralization(interfase);

		// none of the components have the required stereotype
		assertEquals(0, ZMLUtil.getStructuralRealizations(interfase).size());

		ZDLUtil.addZDLConcept(real1, ZMLMMNames.STRUCTURAL_REALIZATION);		

		// the interface is not stereotyped
		assertEquals(0, ZMLUtil.getStructuralRealizations(interfase).size());

		ZDLUtil.addZDLConcept(interfase, ZMLMMNames.COMPONENT_INTERFACE);

		// the real2 component is not stereotyped
		List<Component> reals = ZMLUtil.getStructuralRealizations(interfase);
		assertEquals(1, reals.size());
		assertTrue(reals.contains(real1));

		//real2.applyStereotype(sr);
		ZDLUtil.addZDLConcept(real2, ZMLMMNames.STRUCTURAL_REALIZATION);

		// all components are stereotyped
		reals = ZMLUtil.getStructuralRealizations(interfase);
		assertEquals(2, reals.size());
		assertTrue(reals.contains(real1));
		assertTrue(reals.contains(real2));
	}

	//
	// Test framework methods
	//

	@Override
	protected void setUp()
			throws Exception {

		super.setUp();

		rset = new ResourceSetImpl();

		Resource profile = rset.getResource(
			com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLUtil.PROFILE_URI,
			true);
		zml = (Profile) EcoreUtil.getObjectByType(profile.getContents(),
			UMLPackage.Literals.PROFILE);
		assertNotNull("No ZML profile", zml);

		testResource = rset.createResource(URI.createURI("http:///test.emx"));
		testPackage = UMLFactory.eINSTANCE.createPackage();
		testPackage.setName("test");
		testResource.getContents().add(testPackage);
		testPackage.applyProfile(zml);
	}
}
