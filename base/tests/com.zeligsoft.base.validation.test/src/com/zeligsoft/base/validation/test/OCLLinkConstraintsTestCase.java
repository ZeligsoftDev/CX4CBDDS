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
package com.zeligsoft.base.validation.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.validation.test.constraints.TestClientContext;
import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * Tests link constraints implemented in OCL.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class OCLLinkConstraintsTestCase {

	protected ResourceSet rset;

	protected Package testModel;

	protected Actor dragSource;

	protected UseCase dropTarget1;

	protected UseCase dropTarget2;

	protected Class refSource;

	protected UseCase refTarget1;

	protected UseCase refTarget2;

	protected Class actor1Class;

	protected Class actor2Class;


	/**
	 * Tests the simplest case of objects that can be linked in the deployment
	 * context.
	 */
	@Test
	public void test_canLink_deployment() {
		assertCanDrop(dragSource, dropTarget2);
	}

	/**
	 * Tests the simplest case of objects that can be linked in the deployment
	 * context.
	 */
	@Test
	public void test_cannotLink_deployment() {
		assertCannotDrop(dragSource, dropTarget1);
	}

	/**
	 * Tests the case of a reference-owned constraint, in which the source and
	 * target concepts are implicit. Also diagram context and inheritance of
	 * constraints.
	 */
	@Test
	public void test_canLink_diagram_referenceConstraint() {
		assertCanLink(LinkConstraintContext.DIAGRAM, refSource, refTarget1);
	}

	/**
	 * Tests the case of a reference-owned constraint, in which the source and
	 * target concepts are implicit. Also diagram context and inheritance of
	 * constraints.
	 */
	@Test
	public void test_cannotLink_diagram_referenceConstraint() {
		assertCannotLink(LinkConstraintContext.DIAGRAM, refSource, refTarget2);
	}
	
	/**
	 * Tests the case of a linked constraint owned by a package, not by a
	 * domain concept or a domain reference.
	 */
	@Test
	public void test_canLink_deployment_packageConstraint() {
		assertCanDrop(actor1Class, dragSource);
	}
	
	/**
	 * Tests the case of a linked constraint owned by a package, not by a
	 * domain concept or a domain reference.
	 */
	@Test
	public void test_cannotLink_deployment_packageConstraint() {
		assertCannotDrop(actor2Class, dragSource);
	}
	
	/**
	 * Tests that we only include link constraints that are defined in
	 * domain blocks that are (transitively) referenced by the domain
	 * specialization that generated the profile.
	 */
	@Test
	public void test_applicableDomainBlockFiltering_14424() {
		testModel = loadPackage("/models/link_constraint_packaging_test_package.emx");

		dragSource = (Actor) testModel.getOwnedType("Actor1", false,
			UMLPackage.Literals.ACTOR, false);
		actor1Class = (Class) testModel.getOwnedType("Actor1", false,
			UMLPackage.Literals.CLASS, false);
		
		// this would be OK because the names match, but the constraint is not
		// in a domain-block of the context domain, so it's not permitted
		assertCannotDrop(actor1Class, dragSource);
	}
	
	//
	// Test framework methods
	//
	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();

		testModel = loadPackage("/models/link_constraints_test_package.emx");

		dragSource = (Actor) testModel.getOwnedType("Actor1", false,
			UMLPackage.Literals.ACTOR, false);
		dropTarget1 = (UseCase) testModel.getOwnedType("UseCase1");
		dropTarget2 = (UseCase) testModel.getOwnedType("UseCase2");
		refSource = (Class) testModel.getOwnedType("RefSource");
		refTarget1 = (UseCase) testModel.getOwnedType("RefTarget1");
		refTarget2 = (UseCase) testModel.getOwnedType("RefTarget2");
		actor1Class = (Class) testModel.getOwnedType("Actor1", false,
			UMLPackage.Literals.CLASS, false);
		actor2Class = (Class) testModel.getOwnedType("Actor2", false,
			UMLPackage.Literals.CLASS, false);
	}

	protected Package loadPackage(String path) {
		Resource res = rset.getResource(URI.createPlatformPluginURI(
			"/com.zeligsoft.base.validation.test" + path, true), true);
		assertTrue("Test resource not loaded", res.isLoaded());

		Package result = (Package) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PACKAGE);
		assertNotNull("No test package", result);

		return result;
	}

	@After
	public void tearDown()
			throws Exception {

		TestClientContext.isEnabled = false;

		dragSource = null;
		dropTarget1 = null;
		dropTarget2 = null;
		refSource = null;
		refTarget1 = null;
		refTarget2 = null;
		actor1Class = null;
		actor2Class = null;

		testModel = null;

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;

	}

	protected void assertCanDrop(EObject source, EObject target) {
		assertCanLink(LinkConstraintContext.DEPLOYMENT, source, target);
	}

	protected void assertCannotDrop(EObject source, EObject target) {
		assertCannotLink(LinkConstraintContext.DEPLOYMENT, source, target);
	}

	protected void assertCanLink(LinkConstraintContext ctx, EObject source,
			EObject target) {
		if (!ValidationUtil.canLink(ctx, source, target)) {
			fail(String.format("Cannot link in %s context", ctx));
		}
	}

	protected void assertCannotLink(LinkConstraintContext ctx, EObject source,
			EObject target) {
		if (ValidationUtil.canLink(ctx, source, target)) {
			fail(String.format("Can link in %s context", ctx));
		}
	}
}
