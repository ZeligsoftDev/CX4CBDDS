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
package com.zeligsoft.base.zdl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Tests the {@link ZDLUtil} class's support for redefinitions (of properties,
 * constraints, etc.).
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ZDLRedefinitionTest {

	static final String ZDL_NAME = "redef_attrs";

	static final String SEP = NamedElement.SEPARATOR;

	static final String REDEF_BLOCK = ZDL_NAME + SEP + "redef";

	static final String NODE = REDEF_BLOCK + SEP + "Node";

	static final String NODE__OTHER_NODE = "otherNode";

	static final String LINKED_LIST = REDEF_BLOCK + SEP + "LinkedList";

	static final String LINKED_LIST__NODE = "node";

	static final String LINKED_LIST__OTHER_LINKED_LIST = "otherLinkedList";

	static final String TREE = REDEF_BLOCK + SEP + "Tree";

	static final String TREE__OTHER_TREE = "otherTree";

	static final String THING = REDEF_BLOCK + SEP + "Thing";

	static final String THING__OTHER = "other";

	static final String OTHER = REDEF_BLOCK + SEP + "Other";

	static final String OTHER__THING = "thing";

	static final String MY_THING = REDEF_BLOCK + SEP + "MyThing";

	static final String MY_THING__OTHER = "other";

	static final String MY_OTHER = REDEF_BLOCK + SEP + "MyOther";

	static final String MY_OTHER__MY_THING = "myThing";

	private static ResourceSet rset = new ResourceSetImpl();

	private Package testPackage;

	private EObject aTree;

	private EObject aNode;

	private EObject aTreeNode;

	private EObject anotherTreeNode;

	private EObject anOtherTree;

	private EObject anotherOtherTree;

	private EObject aThing;

	private EObject anOther;

	private EObject anotherOther;

	private EObject aMyThing;

	private EObject aMyOther;

	private EObject anotherMyOther;

	private Class root;

	private Property a;

	private Class sub1;

	private Property a_;

	private Class sub2;

	private Property a__;

	private Class subSub1;

	private Class subSub2;

	private Property a___;

	private Class leaf;

	/**
	 * Tests the computation of the effective definition in a particular context
	 * of a named attribute from a general context.
	 */
	@Test
	public void test_ZDLUtil_getAttribute() {
		assertSame(a_, TestZDLUtil.getAttribute(root, "a", subSub1, null));
		assertSame(a__, TestZDLUtil.getAttribute(root, "a", sub2, null));
		assertSame(a___, TestZDLUtil.getAttribute(root, "a", subSub2, null));
		assertSame(a___, TestZDLUtil.getAttribute(root, "a", leaf, null));
	}

	/**
	 * Tests the query for whether a property has redefinitions.
	 */
	@Test
	public void test_ZDLUtil_hasRedefinitions() {
		assertTrue(TestZDLUtil.hasRedefinitions(a));
		assertFalse(TestZDLUtil.hasRedefinitions(a_));
		assertTrue(TestZDLUtil.hasRedefinitions(a__));
		assertFalse(TestZDLUtil.hasRedefinitions(a___));
	}
	
	/**
	 * Tests the ZDLUtil API for getting the redefinition of a particular
	 * property in some redefinition context.
	 */
	@Test
	public void test_ZDLUtil_getRedefinition() {
		assertSame(a_, TestZDLUtil.getRedefinition(a, sub1, null));
		assertSame(a_, TestZDLUtil.getRedefinition(a, subSub1, null));
		assertSame(a__, TestZDLUtil.getRedefinition(a, sub2, null));
		assertSame(a___, TestZDLUtil.getRedefinition(a, subSub2, null));
		assertSame(a___, TestZDLUtil.getRedefinition(a, leaf, null));
	}
	
	/**
	 * Tests the ZDLUtil API for quepying whether a property redefines another.
	 */
	@Test
	public void test_ZDLUtil_redefines() {
		assertTrue(TestZDLUtil.redefines(a_, a));
		assertFalse(TestZDLUtil.redefines(a, a_));
		assertTrue(TestZDLUtil.redefines(a___, a));
		assertFalse(TestZDLUtil.redefines(a___, a_));
		assertTrue(TestZDLUtil.redefines(a___, a__));
	}

	/**
	 * Tests that association ends that are not redefined are not perturbed by
	 * the redefinition of other ends in the same redefinition context.
	 */
	@Test
	public void test_unredefinedAssociationEnd_differentName() {
		@SuppressWarnings("unchecked")
		Collection<EObject> nodes = (Collection<EObject>) ZDLUtil.getValue(
			aTree, LINKED_LIST, LINKED_LIST__NODE);

		List<EObject> expected = Arrays.asList(aNode, aTreeNode,
			anotherTreeNode);
		assertEquals("Incorrect value of inherited end", expected, nodes);
	}

	/**
	 * Tests the case of association-end redefinition in which the redefining
	 * end has a different name than the redefined end. This also happens to be
	 * a case of an end redefining more than one general end.
	 */
	@Test
	public void test_redefineAssociationEnd_differentName() {
		@SuppressWarnings("unchecked")
		Collection<EObject> otherTrees = (Collection<EObject>) ZDLUtil
			.getValue(aTree, TREE, TREE__OTHER_TREE);

		List<EObject> expected = Arrays.asList(anOtherTree, anotherOtherTree);
		assertEquals("Incorrect value of redefinition", expected, otherTrees);

		@SuppressWarnings("unchecked")
		Collection<EObject> otherNodes = (Collection<EObject>) ZDLUtil
			.getValue(aTree, NODE, NODE__OTHER_NODE);

		assertEquals("Incorrect redefinition of end", expected, otherNodes);

		@SuppressWarnings("unchecked")
		Collection<EObject> otherLinkedLists = (Collection<EObject>) ZDLUtil
			.getValue(aTree, LINKED_LIST, LINKED_LIST__OTHER_LINKED_LIST);

		assertEquals("Incorrect redefinition of end", expected,
			otherLinkedLists);
	}

	/**
	 * Tests the case of association-end redefinition in which the redefining
	 * end has the same name as the redefined end.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void test_redefineAssociationEnd_sameName() {
		// nice non-redifinition case

		Collection<EObject> others = (Collection<EObject>) ZDLUtil.getValue(
			aThing, THING, THING__OTHER);

		List<EObject> expected = Arrays.asList(anOther, anotherOther);
		assertEquals("Incorrect value", expected, others);

		others = (Collection<EObject>) ZDLUtil.getValue(anOther, OTHER,
			OTHER__THING);
		expected = Collections.singletonList(aThing);
		assertEquals("Incorrect value", expected, others);

		// redefinition case

		others = (Collection<EObject>) ZDLUtil.getValue(aMyThing, MY_THING,
			MY_THING__OTHER);

		expected = Arrays.asList(aMyOther, anotherMyOther);
		assertEquals("Incorrect value", expected, others);

		// try the redefined end
		others = (Collection<EObject>) ZDLUtil.getValue(aMyThing, THING,
			THING__OTHER);
		assertEquals("Incorrect redefinition", expected, others);

		// the other direction

		others = (Collection<EObject>) ZDLUtil.getValue(aMyOther, MY_OTHER,
			MY_OTHER__MY_THING);
		expected = Collections.singletonList(aMyThing);
		assertEquals("Incorrect value", expected, others);

		// try the redefined end
		others = (Collection<EObject>) ZDLUtil.getValue(aMyOther, OTHER,
			OTHER__THING);
		assertEquals("Incorrect redefinition", expected, others);
	}

	//
	// Framework methods
	//

	@Before
	public void setUp()
			throws Exception {

		Resource modelRes = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.base.zdl.test/models/redef_test.uml", true), true);

		assertNotNull("Test model resource not available", modelRes);
		assertTrue("Test model resource not loaded", modelRes.isLoaded());

		testPackage = (Package) EcoreUtil.getObjectByType(modelRes
			.getContents(), UMLPackage.Literals.PACKAGE);

		aTree = getNamedElement("redef_test::aTree", TREE);
		aNode = getNamedElement("redef_test::aTree::aNode", NODE);
		aTreeNode = getNamedElement("redef_test::aTree::aTreeNode", TREE);
		anotherTreeNode = getNamedElement("redef_test::aTree::anotherTreeNode",
			TREE);
		anOtherTree = getNamedElement("redef_test::aTree::anOtherTree", TREE);
		anotherOtherTree = getNamedElement(
			"redef_test::aTree::anotherOtherTree", TREE);

		aThing = getNamedElement("redef_test::aThing", THING);
		anOther = getNamedElement("redef_test::anOther", OTHER);
		anotherOther = getNamedElement("redef_test::anotherOther", OTHER);
		aMyThing = getNamedElement("redef_test::aMyThing", MY_THING);
		aMyOther = getNamedElement("redef_test::aMyOther", MY_OTHER);
		anotherMyOther = getNamedElement("redef_test::anotherMyOther", MY_OTHER);

		root = testPackage.createOwnedClass("Root", false);
		a = root.createOwnedAttribute("a", root);

		sub1 = testPackage.createOwnedClass("Sub1", false);
		sub1.createGeneralization(root);
		a_ = sub1.createOwnedAttribute("a", sub1);
		a_.getRedefinedProperties().add(a);

		sub2 = testPackage.createOwnedClass("Sub2", false);
		sub2.createGeneralization(root);
		a__ = sub2.createOwnedAttribute("a", sub2);
		a__.getRedefinedProperties().add(a);

		subSub1 = testPackage.createOwnedClass("SubSub1", false);
		subSub1.createGeneralization(sub1);

		subSub2 = testPackage.createOwnedClass("SubSub2", false);
		subSub2.createGeneralization(sub2);
		a___ = subSub2.createOwnedAttribute("a", subSub2);
		a___.getRedefinedProperties().add(a__);

		leaf = testPackage.createOwnedClass("Leaf", false);
		leaf.createGeneralization(subSub1);
		leaf.createGeneralization(subSub2);
	}

	@After
	public void tearDown()
			throws Exception {

		Resource res = testPackage.eResource();

		res.unload();
		res.eAdapters().clear();
		rset.getResources().remove(res);
	}

	protected Class getConcept(String qualifiedName) {
		return (Class) UMLUtil.findNamedElements(rset, qualifiedName)
			.iterator().next();
	}

	protected NamedElement getNamedElement(String qualifiedName, String concept) {
		Collection<NamedElement> found = UMLUtil.findNamedElements(rset,
			qualifiedName);

		assertEquals("Multiple copies of the test resource were loaded", 1,
			found.size());

		NamedElement result = found.iterator().next();

		assertTrue("Not the correct domain concept", ZDLUtil.isZDLConcept(
			result, concept));

		return result;
	}

	/**
	 * Test fixture, providing access to protected API of {@link ZDLUtil}.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private static class TestZDLUtil
			extends ZDLUtil {

		protected static Property getAttribute(Classifier classifier,
				String name, Classifier redefContext, Type type) {

			return ZDLUtil.getAttribute(classifier, name, redefContext, type);
		}

		protected static boolean hasRedefinitions(Property property) {
			return ZDLUtil.hasRedefinitions(property);
		}

		protected static Property getRedefinition(Property property,
				Classifier redefContext, Type type) {

			return ZDLUtil.getRedefinition(property, redefContext, type);
		}

		protected static boolean redefines(Property property,
				Property definition) {
			return ZDLUtil.redefines(property, definition);
		}

	}
}
