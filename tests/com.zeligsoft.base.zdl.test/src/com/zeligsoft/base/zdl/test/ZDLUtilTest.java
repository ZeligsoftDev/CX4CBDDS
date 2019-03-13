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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Tests the {@link ZDLUtil} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ZDLUtilTest {

	static final String ZDL_NAME = "test";

	static final String SEP = NamedElement.SEPARATOR;

	static final String BLOCK1 = ZDL_NAME + SEP + "block1";

	static final String BLOCK2 = ZDL_NAME + SEP + "block2";

	static final String CXCOMPONENT = BLOCK2 + SEP + "CXComponent";

	static final String CXCOMPONENT__PORT = "port";

	static final String PORT = BLOCK2 + SEP + "Port";

	static final String PORT__IS_EXTERNAL = "isExternal";

	static final String COMPONENT_INTERFACE = BLOCK1 + SEP
		+ "ComponentInterface";

	static final String COMPONENT_INTERFACE__REALIZATION = "realization";

	static final String STRUCTURAL_REALIZATION = BLOCK1 + SEP
		+ "StructuralRealization";

	static final String STRUCTURAL_REALIZATION__IS_DEFAULT = "isDefault";

	static final String STRUCTURAL_REALIZATION__INTERFACE = "interface";

	static final String STRUCTURAL_REALIZATION__IMPLEMENTATION = "implementation";

	static final String STRUCTURAL_REALIZATION__BINARY = "binary";

	static final String IMPLEMENTATION = BLOCK1 + SEP + "Implementation";

	static final String CLASSIFIER = BLOCK1 + SEP + "Classifier";
	
	static final String CLASSIFYING_COMPONENT = BLOCK1 + SEP + "ClassifyingComponent";

	static final String BINARY = BLOCK1 + SEP + "Binary";

	static final String BINARY__NAME = "name";

	static final String BINARY__TAG = "tag";

	static final String BINARY__LINKAGE = "linkage";

	static final String BINARY__VISIBILITY = "visibility";

	static final String TAG = BLOCK1 + SEP + "Tag";

	static final String TAG__NAME = "name";

	static final String TAG__VALUE = "value";

	static final String LINKAGE = BLOCK1 + SEP + "Linkage";

	static final String LINKAGE__STATIC = "static";

	static final String LINKAGE__DYNAMIC = "dynamic";

	static final String TEST_PROFILE_NAME = "test";

	static final String SCA_PROFILE_NAME = "SCADomain";

	private static final String STRUCTURED_CLASSIFIER = BLOCK1 + SEP + "StructuredClassifier";

	private static ResourceSet rset = new ResourceSetImpl();

	private Package testPackage;

	private Component comp1;

	private Port port1;

	private Component comp2;

	private Port port2;

	private Component comp3;

	private Artifact impl;
	
	private Component comp4;

	/**
	 * Tests querying whether a UML element is a direct "instance of" some
	 * domain concept.
	 */
	@Test
	public void test_isZDLConcept_direct() {
		assertTrue("Comp1 not a ComponentInterface", ZDLUtil.isZDLConcept(
			comp1, COMPONENT_INTERFACE));
		assertTrue("Comp2 not a StructuralRealization", ZDLUtil.isZDLConcept(
			comp2, STRUCTURAL_REALIZATION));

		assertFalse("Comp1 is a ComponentInterface", ZDLUtil.isZDLConcept(
			comp1, STRUCTURAL_REALIZATION));
	}

	/**
	 * Tests querying whether a UML element is an indirect "instance of" some
	 * domain concept.
	 */
	@Test
	public void test_isZDLConcept_indirect() {
		assertTrue("Comp1 not a CXComponent", ZDLUtil.isZDLConcept(comp1,
			CXCOMPONENT));
		assertTrue("Comp2 not a CXComponent", ZDLUtil.isZDLConcept(comp2,
			CXCOMPONENT));

		assertFalse("port1 is a CXComponent", ZDLUtil.isZDLConcept(port1,
			CXCOMPONENT));
	}

	/**
	 * Tests querying whether a UML element is an indirect "instance of" some
	 * domain concept.
	 */
	@Test
	public void test_isZDLProfile() {
		assertTrue("Comp1 don't have " + TEST_PROFILE_NAME + " Profile",
			ZDLUtil.isZDLProfile(comp1, TEST_PROFILE_NAME));
		assertFalse("Comp2 has " + SCA_PROFILE_NAME + " Profile", ZDLUtil
			.isZDLProfile(comp2, SCA_PROFILE_NAME));

	}

	/**
	 * Tests access to a stereotype property that is a stereotype reference.
	 */
	@Test
	public void test_getStereotypeProperty_reference() {
		Object value = ZDLUtil.getValue(comp1, COMPONENT_INTERFACE,
			COMPONENT_INTERFACE__REALIZATION);

		assertTrue("Value of realizations not a list",
			value instanceof EList<?>);
		EList<?> realizations = (EList<?>) value;

		assertTrue("Comp2 not in realizations", realizations.contains(comp2));
		assertTrue("Comp3 not in realizations", realizations.contains(comp3));
	}

	/**
	 * Tests access to a stereotype property that is a data-type attribute.
	 */
	@Test
	public void test_getStereotypeProperty_attribute() {
		Object value = ZDLUtil.getValue(comp2, STRUCTURAL_REALIZATION,
			STRUCTURAL_REALIZATION__IS_DEFAULT);
		assertTrue("Not a Boolean", value instanceof Boolean);
		assertTrue((Boolean) value);

		value = ZDLUtil.getValue(comp3, STRUCTURAL_REALIZATION,
			STRUCTURAL_REALIZATION__IS_DEFAULT);
		assertTrue("Not a Boolean", value instanceof Boolean);
		assertFalse((Boolean) value);
	}

	/**
	 * Tests access to a metaclass property that is a reference (mapped from a
	 * domain reference).
	 */
	@Test
	public void test_getMetaclassProperty_reference() {
		Object value = ZDLUtil.getValue(comp1, COMPONENT_INTERFACE,
			CXCOMPONENT__PORT);

		assertTrue("Value of ports not a list", value instanceof EList<?>);
		EList<?> ports = (EList<?>) value;

		assertTrue("port1 not in ports", ports.contains(port1));
	}

	/**
	 * Tests access to a metaclass property that is a data-type attribute
	 * (mapped from a domain attribute).
	 */
	@Test
	public void test_getMetaclassProperty_attribute() {
		Object value = ZDLUtil.getValue(port1, PORT, PORT__IS_EXTERNAL);

		assertTrue("Value of isExternal not a Boolean",
			value instanceof Boolean);
		Boolean isExternal = (Boolean) value;

		assertTrue("isExternal should be true", isExternal);

		value = ZDLUtil.getValue(port2, PORT, PORT__IS_EXTERNAL);

		assertTrue("Value of isExternal not a Boolean",
			value instanceof Boolean);
		isExternal = (Boolean) value;

		assertFalse("isExternal should be false", isExternal);
	}

	/**
	 * Tests modification of a stereotype property that is a stereotype
	 * reference.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void test_setStereotypeProperty_reference() {
		Component newComponent = (Component) testPackage.createOwnedType(
			"NewComponent", UMLPackage.Literals.COMPONENT);
		Stereotype strucRealz = newComponent
			.getApplicableStereotype("test::StructuralRealization");
		newComponent.applyStereotype(strucRealz);

		Object value = ZDLUtil.getValue(comp1, COMPONENT_INTERFACE,
			COMPONENT_INTERFACE__REALIZATION);

		assertTrue("Value of realizations not a list",
			value instanceof EList<?>);
		EList<EObject> realizations = (EList<EObject>) value;

		// add the UML component
		realizations.add(newComponent);

		// check that the stereotype references the component's stereotype
		EObject appl = newComponent.getStereotypeApplication(strucRealz);
		realizations = (EList<EObject>) comp1.getValue(comp1
			.getAppliedStereotype("test::ComponentInterface"),
			COMPONENT_INTERFACE__REALIZATION);
		assertTrue("NewComponent not in realizations", realizations
			.contains(appl));
	}

	/**
	 * Tests modification of a stereotype property that is a data-type
	 * attribute.
	 */
	@Test
	public void test_setStereotypeProperty_attribute() {
		Stereotype strucRealz = comp2
			.getAppliedStereotype("test::StructuralRealization");

		ZDLUtil.setValue(comp2, STRUCTURAL_REALIZATION,
			STRUCTURAL_REALIZATION__IS_DEFAULT, Boolean.FALSE);
		Object value = comp2.getValue(strucRealz,
			STRUCTURAL_REALIZATION__IS_DEFAULT);
		assertTrue("Not a Boolean", value instanceof Boolean);
		assertFalse((Boolean) value);

		ZDLUtil.setValue(comp3, STRUCTURAL_REALIZATION,
			STRUCTURAL_REALIZATION__IS_DEFAULT, Boolean.TRUE);
		value = comp3.getValue(strucRealz, STRUCTURAL_REALIZATION__IS_DEFAULT);
		assertTrue("Not a Boolean", value instanceof Boolean);
		assertTrue((Boolean) value);
	}

	/**
	 * Tests modification of a metaclass property that is a reference (mapped
	 * from a domain reference).
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void test_setMetaclassProperty_reference() {
		Port newPort = comp3.createOwnedPort("newPort", null);
		Stereotype stereo = newPort.getApplicableStereotype("test::Port");
		newPort.applyStereotype(stereo);

		Object value = ZDLUtil.getValue(comp1, COMPONENT_INTERFACE,
			CXCOMPONENT__PORT);

		assertTrue("Value of ports not a list", value instanceof EList<?>);
		EList<EObject> ports = (EList<EObject>) value;

		ports.add(newPort);

		assertTrue("newPort not in ownedPort", comp1.getOwnedPorts().contains(
			newPort));
	}

	/**
	 * Tests access to a metaclass property that is a data-type attribute
	 * (mapped from a domain attribute).
	 */
	@Test
	public void test_setMetaclassProperty_attribute() {
		ZDLUtil.setValue(port1, PORT, PORT__IS_EXTERNAL, Boolean.FALSE);

		assertFalse("isService should be false", port1.isService());

		ZDLUtil.setValue(port2, PORT, PORT__IS_EXTERNAL, Boolean.TRUE);

		assertTrue("isService should be true", port2.isService());
	}

	/**
	 * Tests the handling of abstract concepts (which map to UML metaclasses).
	 */
	@Test
	public void test_abstractConcept() {
		assertTrue("impl is not an Implementation", ZDLUtil.isZDLConcept(impl,
			IMPLEMENTATION));

		Class implementationConcept = getConcept(IMPLEMENTATION);
		assertTrue("impl is not an Implementation", ZDLUtil.isZDLConcept(impl,
			implementationConcept));

		List<?> impls = (List<?>) ZDLUtil.getValue(comp3,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__IMPLEMENTATION);
		assertTrue("Comp3 not implemented by impl", impls.contains(impl));
	}

	/**
	 * Tests the <tt>getConcepts()</tt> method on an element that has a firm
	 * concept and also matches an abstract concept.
	 */
	@Test
	public void test_getConcepts_firmAndAbstract() {
		List<Class> concepts = ZDLUtil.getZDLConcepts(comp1);

		assertEquals("Wrong number of concepts", 3, concepts.size());
		assertTrue("Missing ComponentInterface", concepts
			.contains(getConcept(COMPONENT_INTERFACE)));
		assertTrue("Missing AbstractComponent", concepts
			.contains(getConcept(CLASSIFIER)));
		assertTrue("Missing AbstractComponent", concepts
				.contains(getConcept(STRUCTURED_CLASSIFIER)));
		
	}
	
	/**
	 * Tests the <tt>getConcepts()</tt> method on an element that has a firm
	 * concept that specializes an abstract concept.
	 */
	@Test
	public void test_getConcepts_firmSpecializesAbstract() {
		List<Class> concepts = ZDLUtil.getZDLConcepts(comp4);
		
		assertEquals("Wrong number of concepts", 2, concepts.size());
		assertTrue("Missing ClassifyingComponent", concepts
				.contains(getConcept(CLASSIFYING_COMPONENT)));
		assertTrue("Missing AbstractComponent", concepts
				.contains(getConcept(STRUCTURED_CLASSIFIER)));
		
	}
	
	/**
	 * Tests the <tt>getConcepts()</tt> method on an element that has only
	 * abstract concepts.
	 */
	@Test
	public void test_getConcepts_abstractOnly() {
		List<Class> concepts = ZDLUtil.getZDLConcepts(impl);

		assertEquals("Wrong number of concepts", 2, concepts.size());
		assertTrue("Missing Implementation", concepts
			.contains(getConcept(IMPLEMENTATION)));
		assertTrue("Missing AbstractComponent", concepts
			.contains(getConcept(CLASSIFIER)));
	}

	/**
	 * Tests the <tt>isConcept()</tt> method on an element that has a firm and
	 * abstract concept.
	 */
	@Test
	public void test_isConcept_firmAndAbstract() {
		assertTrue("Not a CXComponent", ZDLUtil
			.isZDLConcept(comp1, CXCOMPONENT));
		assertTrue("Not a ComponentInterface", ZDLUtil.isZDLConcept(comp1,
			COMPONENT_INTERFACE));
		assertTrue("Not a Classifier", ZDLUtil.isZDLConcept(comp1, CLASSIFIER));

		assertFalse("Should not be an Implementation", ZDLUtil.isZDLConcept(
			comp1, IMPLEMENTATION));
	}

	/**
	 * Tests the <tt>isConcept()</tt> method on an element that has a only
	 * abstract concepts.
	 */
	@Test
	public void test_isConcept_abstractOnly() {
		assertTrue("Not an Implementation", ZDLUtil.isZDLConcept(impl,
			IMPLEMENTATION));
		assertTrue("Not a Classifier", ZDLUtil.isZDLConcept(impl, CLASSIFIER));

		assertFalse("Should not be a ComponentInterface", ZDLUtil.isZDLConcept(
			impl, COMPONENT_INTERFACE));
	}
	
	/**
	 * Tests the <tt>isConcept()</tt> method on an element that is a firm concept
	 * that specializes an abstract concept.
	 */
	@Test
	public void test_isConcept_firmSpecializesAbstract() {
		assertTrue("Not a ClassifyingComponent", ZDLUtil.isZDLConcept(comp4, CLASSIFYING_COMPONENT));
		assertTrue("Not a Classifier", ZDLUtil.isZDLConcept(comp4, CLASSIFIER));
		assertTrue("Not a StructuredClassifier", ZDLUtil.isZDLConcept(comp4, STRUCTURED_CLASSIFIER));
	}
	
	/**
	 * Tests the attempt to add a firm concept.
	 */
	@Test
	public void test_addZDLConcept_firm() {
		Component newComponent = (Component) testPackage.createOwnedType(
			"NewComponent", UMLPackage.Literals.COMPONENT);

		try {
			ZDLUtil.addZDLConcept(newComponent, COMPONENT_INTERFACE);
		} catch (Exception e) {
			fail("Failed to add concept: " + e.getLocalizedMessage());
		}

		assertTrue("Concept did not stick", ZDLUtil.isZDLConcept(newComponent,
			COMPONENT_INTERFACE));
	}

	/**
	 * Tests the attempt to add a firm concept when it is already added.
	 */
	@Test
	public void test_addZDLConcept_firm_present() {
		try {
			ZDLUtil.addZDLConcept(comp1, COMPONENT_INTERFACE);
			fail("Should have failed to add concept");
		} catch (Exception e) {
			// success
			System.out.println("Got expected exception: "
				+ e.getLocalizedMessage());
		}
	}

	/**
	 * Tests the attempt to add a firm concept that is inapplicable.
	 */
	@Test
	public void test_addZDLConcept_firm_inapplicable() {
		try {
			ZDLUtil.addZDLConcept(impl, COMPONENT_INTERFACE);
			fail("Should have failed to add concept");
		} catch (Exception e) {
			// success
			System.out.println("Got expected exception: "
				+ e.getLocalizedMessage());
		}
	}

	/**
	 * Tests the attempt to add an abstract concept. This should never work.
	 */
	@Test
	public void test_addZDLConcept_abstract() {
		try {
			ZDLUtil.addZDLConcept(impl, IMPLEMENTATION);
			fail("Should have failed to add concept");
		} catch (Exception e) {
			// success
			System.out.println("Got expected exception: "
				+ e.getLocalizedMessage());
		}

		try {
			ZDLUtil.addZDLConcept(comp1, IMPLEMENTATION);
			fail("Should have failed to add concept");
		} catch (Exception e) {
			// success
			System.out.println("Got expected exception: "
				+ e.getLocalizedMessage());
		}
	}

	/**
	 * Tests instantiating a concept that maps to a profile class.
	 */
	@Test
	public void test_createZDLConcept_profileClass() {
		EObject binary1 = ZDLUtil.createZDLConcept(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__BINARY, BINARY);
		EObject binary2 = ZDLUtil.createZDLConcept(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__BINARY, BINARY);

		assertTrue("Not a Binary", ZDLUtil.isZDLConcept(binary1, BINARY));
		assertTrue("Not a Binary", ZDLUtil.isZDLConcept(binary2, BINARY));

		ZDLUtil.setValue(binary1, BINARY, BINARY__NAME, "a.out");
		assertEquals("Wrong binary name", "a.out", ZDLUtil.getValue(binary1,
			BINARY, BINARY__NAME));

		List<?> binaries = (List<?>) ZDLUtil.getValue(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__BINARY);
		assertEquals("Wrong number of binaries", 2, binaries.size());
		assertSame("binary1 not found", binary1, binaries.get(0));
		assertSame("binary2 not found", binary2, binaries.get(1));

		// nesting classes
		EObject tag1 = ZDLUtil.createZDLConcept(binary2, BINARY, BINARY__TAG,
			TAG);
		EObject tag2 = ZDLUtil.createZDLConcept(binary2, BINARY, BINARY__TAG,
			TAG);

		assertTrue("Not a Tag", ZDLUtil.isZDLConcept(tag1, TAG));
		assertTrue("Not a Tag", ZDLUtil.isZDLConcept(tag2, TAG));

		List<?> tags = (List<?>) ZDLUtil.getValue(binary2, BINARY, BINARY__TAG);
		assertEquals("Wrong number of tags", 2, tags.size());
		assertSame("tag1 not found", tag1, tags.get(0));
		assertSame("tag2 not found", tag2, tags.get(1));

		ZDLUtil.setValue(tag2, TAG, TAG__NAME, "version");
		ZDLUtil.setValue(tag2, TAG, TAG__VALUE, "1.0");

		assertEquals("Wrong tag name", "version", ZDLUtil.getValue(tag2, TAG,
			TAG__NAME));
		assertEquals("Wrong tag value", "1.0", ZDLUtil.getValue(tag2, TAG,
			TAG__VALUE));
	}

	/**
	 * Tests creating a concept that maps to a UML metaclass.
	 */
	@Test
	public void test_createZDLConcept_metaclass() {
		EObject implementation = ZDLUtil.createZDLConcept(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__IMPLEMENTATION,
			IMPLEMENTATION);
		assertNotNull("No implementation created", implementation);
		assertSame("Wrong metaclass", UMLPackage.Literals.ARTIFACT,
			implementation.eClass());

		List<?> impls = (List<?>) ZDLUtil.getValue(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__IMPLEMENTATION);
		assertTrue("New implementation not found", impls
			.contains(implementation));
	}

	/**
	 * Tests creating a concept that maps to a stereotype.
	 */
	@Test
	public void test_createZDLConcept_stereotype() {
		EObject port = ZDLUtil.createZDLConcept(comp1, CXCOMPONENT,
			CXCOMPONENT__PORT, PORT);
		assertNotNull("No port created", port);
		assertSame("Wrong metaclass", UMLPackage.Literals.PORT, port.eClass());
		assertTrue("Stereotype not applied", ZDLUtil.isZDLConcept(port, PORT));

		List<?> ports = (List<?>) ZDLUtil.getValue(comp1, CXCOMPONENT,
			CXCOMPONENT__PORT);
		assertTrue("New port not found", ports.contains(port));
	}

	/**
	 * Tests the inverse referencing.
	 */
	@Test
	public void test_getInverseReferences() {
		List<EObject> referencers = ZDLUtil.getInverseReferences(comp2,
			COMPONENT_INTERFACE, COMPONENT_INTERFACE__REALIZATION);

		assertEquals("Wrong number of referencers", 1, referencers.size());

		assertSame("Wrong referencer", comp1, referencers.get(0));
	}

	/**
	 * Tests the reflection on properties of enumeration literal type.
	 */
	@Test
	public void test_getZDLEnumLiteral() {
		EObject binary = ZDLUtil.createZDLConcept(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__BINARY, BINARY);

		// make sure that we can get these from any element context
		EnumerationLiteral statik = ZDLUtil.getZDLEnumLiteral(binary, LINKAGE,
			LINKAGE__STATIC);
		EnumerationLiteral dynamic = ZDLUtil.getZDLEnumLiteral(comp2, LINKAGE,
			LINKAGE__DYNAMIC);

		// default value
		assertSame("Wrong linkage", statik, ZDLUtil.getValue(binary, BINARY,
			BINARY__LINKAGE));

		ZDLUtil.setValue(binary, BINARY, BINARY__LINKAGE, dynamic);

		assertSame("Wrong linkage", dynamic, ZDLUtil.getValue(binary, BINARY,
			BINARY__LINKAGE));

		// enumeration defined by the UML metamodel
		assertSame("Wrong visibility", VisibilityKind.PUBLIC_LITERAL, ZDLUtil
			.getValue(binary, BINARY, BINARY__VISIBILITY));

		ZDLUtil.setValue(binary, BINARY, BINARY__VISIBILITY,
			VisibilityKind.PRIVATE_LITERAL);

		assertSame("Wrong visibility", VisibilityKind.PRIVATE_LITERAL, ZDLUtil
			.getValue(binary, BINARY, BINARY__VISIBILITY));
	}

	/**
	 * Tests the mapping of a scalar ZDL property to a multivalued UML property.
	 */
	@Test
	public void test_mapScalarZDLToMultivaluedUML_13730() {
		// assign the scalar "implementation" attribute
		ZDLUtil.setValue(comp2, STRUCTURAL_REALIZATION,
			STRUCTURAL_REALIZATION__INTERFACE, comp1);

		// check that we get the value back
		assertSame("Wrong implementation", comp1, ZDLUtil.getValue(comp2,
			STRUCTURAL_REALIZATION, STRUCTURAL_REALIZATION__INTERFACE));

		// double-check the UML
		assertEquals("Wrong number of superclasses", 1, comp2.getSuperClasses()
			.size());
		assertSame("Wrong superclass", comp1, comp2.getSuperClasses().get(0));
	}

	/**
	 * Tests that changing the stereotype applied to an object causes its
	 * concepts to be recalculated.
	 */
	@Test
	public void test_changeStereotype_13835() {
		Stereotype stereo = comp1.getAppliedStereotypes().get(0);

		Element newComponent = testPackage.createOwnedType("NewComponent",
			UMLPackage.Literals.COMPONENT);

		assertFalse("Shouldn't be a ComponentInterface, yet", ZDLUtil
			.isZDLConcept(newComponent, COMPONENT_INTERFACE));

		newComponent.applyStereotype(stereo);

		assertTrue("Should be a ComponentInterface", ZDLUtil.isZDLConcept(
			newComponent, COMPONENT_INTERFACE));
	}

	/**
	 * Tests the mapping of domain attributes to UML meta-attributes for
	 * concepts that are, themselves, abstract mappings to UML metaclasses.
	 */
	@Test
	public void test_attrMappingsOfAbstractConcepts() {
		Resource modelRes = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.base.zdl.test/models/my_model.emx", true), true);

		assertNotNull("Test model resource not available", modelRes);
		assertTrue("Test model resource not loaded", modelRes.isLoaded());

		testPackage = (Package) EcoreUtil.getObjectByType(modelRes
			.getContents(), UMLPackage.Literals.PACKAGE);

		EObject application = ZDLUtil.getObjectByConcept(testPackage
			.getOwnedMembers(), "MyDomain::MyBlock::Application");
		assertNotNull("Application not found", application);

		Collection<EObject> connectors = ZDLUtil.getObjectsByConcept(
			application.eContents(), ZMLMMNames.ASSEMBLY_CONNECTOR);
		assertEquals("Wrong number of connectors", 3, connectors.size());
		for (EObject next : connectors) {
			// access the connector ends, which are abstract concept mappings
			@SuppressWarnings("unchecked")
			Collection<EObject> ends = (Collection<EObject>) ZDLUtil.getValue(
				next, ZMLMMNames.ASSEMBLY_CONNECTOR,
				ZMLMMNames.ASSEMBLY_CONNECTOR__END);

			assertEquals("Wrong number of ends", 2, ends.size());

			for (EObject end : ends) {
				// these first two attributes actually map to the same UML
				// meta-attribute 'role'
				assertNotNull("Should be connecting a port", ZDLUtil.getValue(
					end, ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PORT));
				assertNull("Should not be connecting a part", ZDLUtil.getValue(
					end, ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PART));

				assertNotNull("Should be connecting a port on a part", ZDLUtil
					.getValue(end, ZMLMMNames.CONNECTOR_END,
						ZMLMMNames.CONNECTOR_END__PART_WITH_PORT));
			}
		}
	}

	//
	// Framework methods
	//

	@Before
	public void setUp()
			throws Exception {

		Resource modelRes = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.base.zdl.test/models/application.emx", true), true);

		assertNotNull("Test model resource not available", modelRes);
		assertTrue("Test model resource not loaded", modelRes.isLoaded());

		testPackage = (Package) EcoreUtil.getObjectByType(modelRes
			.getContents(), UMLPackage.Literals.PACKAGE);

		comp1 = (Component) testPackage.getOwnedType("Comp1");
		port1 = comp1.getOwnedPorts().get(0);
		comp2 = (Component) testPackage.getOwnedType("Comp2");
		port2 = comp2.getOwnedPorts().get(0);
		comp3 = (Component) testPackage.getOwnedType("Comp3");
		impl = (Artifact) testPackage.getOwnedType("impl");
		comp4 = (Component) testPackage.getOwnedType("Comp4");
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
}
