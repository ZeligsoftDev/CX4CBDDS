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
package com.zeligsoft.base.zdl.ocl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.ocl.ZDLToProfileTransformation;
import com.zeligsoft.base.zdl.ocl.test.util.TestOCLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Tests the {@link ZDLToProfileTransformation} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings({"nls", "unused"})
public class ZDLToProfileTransformationTest
		extends AbstractTestCase {

	private static final String COMPONENT__NON_MONOLITH_REQUIRES_PORTS = "non_monolith_requires_ports";

	private static final String COMPONENT__ABSTRACT_HAS_NO_IMPLEMENTATIONS = "abstract_has_no_implementations";

	private static final String COMPONENT__UNIQUE_IMPLEMENTATIONS = "unique_implementations";

	private static final String COMPONENT__MONOLITH_REQUIRES_IMPLEMENTATIONS = "monolith_requires_implementations";

	private static final String COMPONENT__ABSTRACT_HAS_EXTERNAL_PORTS = "abstract_has_external_ports";

	private static final String COMPONENT__PORTS_HAVE_INTERFACES = "ports_have_interfaces";

	private static final String COMPONENT__OPEN_HAS_PUBLIC_PORTS = "open_has_public_ports";

	private static final String IMPLEMENTATION__NOT_ABSTRACT = "not_abstract";

	private static final String PORT__REQUIRED_NOT_OCLINTERFACE = "required_not_oclInterface";

	private ZDLToProfileTransformation fixture;

	private Class oclComponent;

	private Class oclAssembly;

	private Class oclImplementation;

	private Class oclPort;

	private Class oclInterface;

	private Class oclProperty;

	private Enumeration availability;

	private Enumeration synchronization;

	private Profile profile;

	private Stereotype oclComponentStereotype;

	private Stereotype oclAssemblyStereotype;

	private Stereotype oclImplementationStereotype;

	private Stereotype oclPortStereotype;

	private Stereotype oclInterfaceStereotype;

	private Stereotype oclPropertyStereotype;

	private Enumeration availabilityProfileEnum;

	private Enumeration synchronizationProfileEnum;

	private Package testPackage;

	private Component component;

	private Component component2;

	private Component component3;

	private Interface propType1;

	private Artifact implementation;

	/**
	 * Tests transformation of a property-call expression that navigates from a
	 * stereotype to another stereotype via a property owned by the source
	 * stereotype.
	 */
	@Test
	public void test_reference_stereotypePropertyToStereotype() {
		Constraint zdl = parse(oclComponent,
			COMPONENT__MONOLITH_REQUIRES_IMPLEMENTATIONS);
		Constraint uml = transform(zdl);

		List<?> impls = (List<?>) ZDLUtil.getValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__IMPLEMENTATION);
		impls.remove(implementation);

		assertTrue(component, uml);

		ZDLUtil.setValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__IS_MONOLITHIC, true);

		assertFalse(component, uml);
	}

	/**
	 * Tests transformation of a property-call expression that navigates from a
	 * stereotype to another stereotype via a property owned by the extended
	 * metaclass.
	 */
	@Test
	public void test_reference_metaclassPropertyToStereotype() {
		Constraint zdl = parse(oclComponent,
			COMPONENT__NON_MONOLITH_REQUIRES_PORTS);
		Constraint uml = transform(zdl);

		assertTrue(component, uml);

		// no ports
		component.getOwnedPorts().get(0).destroy();

		assertFalse(component, uml);

		ZDLUtil.setValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__IS_MONOLITHIC, true);

		assertTrue(component, uml);
	}

	/**
	 * Tests transformation of a property-call expression that navigates from an
	 * element to a property of its applied stereotype.
	 */
	@Test
	public void test_reference_metaclassToStereotypeProperty() {
		Constraint zdl = parse(oclComponent,
			COMPONENT__ABSTRACT_HAS_EXTERNAL_PORTS);
		Constraint uml = transform(zdl);

		assertTrue(component, uml);

		// make it abstract
		ZDLUtil.setValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__IS_ABSTRACT, true);

		assertFalse(component, uml);

		// make the port external
		ZDLUtil.setValue(component.getOwnedPorts().get(0), oclPort,
			TestOCLNames.OCLPORT__IS_EXTERNAL, true);

		assertTrue(component, uml);
	}

	/**
	 * Tests a somewhat more complex series of implicit collect expressions.
	 */
	@Test
	public void test_reference_seriesOfImplicitCollects() {
		Constraint zdl = parse(oclComponent, COMPONENT__PORTS_HAVE_INTERFACES);
		Constraint uml = transform(zdl);

		assertFalse(component2, uml);

		// delete portX
		component2.getOwnedPort("portX", null).destroy();

		assertTrue(component2, uml);

		// remove the PortType's provided interface
		((Class) testPackage.getOwnedType("PortType"))
			.getInterfaceRealizations().get(0).destroy();

		assertFalse(component2, uml);

		// if none of the ports has any interfaces, then we're OK again by the
		// nature of the implication expression
		testPackage.getOwnedType("PortType~").getClientDependencies().get(0)
			.destroy();

		assertTrue(component2, uml);
	}

	/**
	 * Tests oclIsKindOf with a type argument that generates a stereotype.
	 */
	@Test
	public void test_oclIsKindOf_stereotype() {
		Constraint zdl = parse(oclPort, PORT__REQUIRED_NOT_OCLINTERFACE);
		Constraint uml = transform(zdl);

		Port port2 = component2.getOwnedPort("port2", null);

		assertTrue(port2, uml);

		// apply the <<OCLInterface>> stereotype to the Req interface
		Interface req = (Interface) testPackage.getOwnedType("Req");
		req.applyStereotype(oclInterfaceStereotype);

		assertFalse(port2, uml);
	}

	/**
	 * Tests oclIsKindOf with a type argument that is a metaclass, invoked on a
	 * stereotype application.
	 */
	@Test
	public void test_oclIsKindOf_metaclass_13553() {
		OCLExpression<Classifier> zdl = parseQuery(oclComponent,
			"self.oclIsKindOf(uml::StructuredClassifier)");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		// evaluate on the stereotype application explicitly just to be sure
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		assertEval(Boolean.TRUE, uml, component
			.getStereotypeApplication(stereo));

		zdl = parseQuery(oclComponent, "self.oclIsKindOf(uml::Feature)");
		uml = transform(oclComponent, zdl);

		assertEval(Boolean.FALSE, uml, component
			.getStereotypeApplication(stereo));
	}

	/**
	 * Tests oclIsKindOf with a type argument that is a metaclass, invoked on a
	 * UML element.
	 */
	@Test
	public void test_oclIsKindOf_element_13553() {
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		Class umlComponent = stereo.getExtendedMetaclasses().get(0);

		OCLExpression<Classifier> uml = parseQuery(umlComponent,
			"self.oclIsKindOf(StructuredClassifier)");
		// nothing to transform for ZDL concerns

		assertEval(Boolean.TRUE, uml, component);

		uml = parseQuery(umlComponent, "self.oclIsKindOf(Feature)");

		assertEval(Boolean.FALSE, uml, component);
	}

	/**
	 * Tests the <tt>allInstances()</tt> operation on a stereotype.
	 */
	@Test
	public void test_allInstances_stereotype() {
		Constraint zdl = parse(oclComponent, COMPONENT__UNIQUE_IMPLEMENTATIONS);
		Constraint uml = transform(zdl);

		// ensure that isMonolithic is true
		ZDLUtil.setValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__IS_MONOLITHIC, true);

		assertTrue(component, uml);

		// add the implementation to Comp2
		@SuppressWarnings("unchecked")
		List<Artifact> impls = (List<Artifact>) ZDLUtil.getValue(component2,
			oclComponent, TestOCLNames.OCLCOMPONENT__IMPLEMENTATION);
		impls.add(implementation);

		assertFalse(component, uml);

		assertTrue(component2, uml);
	}

	/**
	 * Tests transformation of enumeration-literal expressions with enumerations
	 * from the domain and from the UML metamodel.
	 */
	@Test
	public void test_enumerationLiterals() {
		Constraint zdl = parse(oclComponent, COMPONENT__OPEN_HAS_PUBLIC_PORTS);
		Constraint uml = transform(zdl);

		// constraint passes because we are closed
		assertTrue(component, uml);

		// set the component to open availability
		ZDLUtil.setValue(component, oclComponent,
			TestOCLNames.OCLCOMPONENT__AVAILABILITY, availability
				.getOwnedLiteral("open"));

		// still OK
		assertTrue(component2, uml);

		// make a port private
		ZDLUtil.setValue(component.getOwnedPorts().get(0),
			TestOCLNames.OCLPORT, TestOCLNames.OCLPORT__VISIBILITY,
			VisibilityKind.PRIVATE_LITERAL);

		assertFalse(component, uml);
	}

	/**
	 * Tests transformation of operation-call expressions that call additional
	 * operations defined for OCL Standard Library types.
	 */
	@Test
	public void test_additionalOperationOnStdlibType_13546() {
		OCLExpression<Classifier> zdl = parseQuery(oclComponent,
			"'Bob'.matches('([Bb]).*\\1')");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		assertEval(Boolean.FALSE, uml, component);

		zdl = parseQuery(oclComponent, "'bob'.matches('([Bb]).*\\1')");
		uml = transform(oclComponent, zdl);

		assertEval(Boolean.TRUE, uml, component);
	}

	/**
	 * Tests oclIsTypeOf with a type argument that generates a stereotype.
	 */
	@Test
	public void test_oclIsTypeOf_stereotype_13553() {
		Stereotype stereo = component2
			.getAppliedStereotype("test_ocl::OCLAssembly");
		Class umlComponent = stereo.getAllExtendedMetaclasses().get(0);

		OCLExpression<Classifier> zdl = parseQuery(umlComponent,
			"self.oclIsTypeOf(test_ocl::OCLTest::OCLAssembly)");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		assertEval(Boolean.TRUE, uml, component2);

		zdl = parseQuery(umlComponent,
			"self.oclIsTypeOf(test_ocl::OCLTest::OCLComponent)");
		uml = transform(oclComponent, zdl);

		assertEval(Boolean.FALSE, uml, component2
			.getStereotypeApplication(stereo));
	}

	/**
	 * Tests oclIsTypeOf with a type argument that is a metaclass, invoked on a
	 * stereotype application.
	 */
	@Test
	public void test_oclIsTypeOf_metaclass_13553() {
		OCLExpression<Classifier> zdl = parseQuery(oclComponent,
			"self.oclIsTypeOf(uml::Component)");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		// evaluate on the stereotype application explicitly just to be sure
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		assertEval(Boolean.TRUE, uml, component
			.getStereotypeApplication(stereo));

		zdl = parseQuery(oclComponent,
			"self.oclIsTypeOf(uml::StructuredClassifier)");
		uml = transform(oclComponent, zdl);

		assertEval(Boolean.FALSE, uml, component
			.getStereotypeApplication(stereo));
	}

	/**
	 * Tests oclIsTypeOf with a type argument that is a metaclass, invoked on a
	 * UML element.
	 */
	@Test
	public void test_oclIsTypeOf_element_13553() {
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		Class umlComponent = stereo.getExtendedMetaclasses().get(0);

		OCLExpression<Classifier> uml = parseQuery(umlComponent,
			"self.oclIsTypeOf(Component)");
		// nothing to transform for ZDL concerns

		assertEval(Boolean.TRUE, uml, component);

		uml = parseQuery(umlComponent, "self.oclIsTypeOf(StructuredClassifier)");

		assertEval(Boolean.FALSE, uml, component);
	}

	/**
	 * Tests the coercion of a stereotype application to its base element using
	 * the <tt>oclAsType</tt> operation.
	 */
	@Test
	public void test_oclAsType_metaclass_13553() {
		OCLExpression<Classifier> zdl = parseQuery(oclComponent,
			"self.oclAsType(uml::StructuredClassifier)");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		// evaluate on the stereotype application explicitly just to be sure
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		assertEval(component, uml, component.getStereotypeApplication(stereo));

		zdl = parseQuery(oclComponent, "self.oclAsType(uml::Feature)");
		uml = transform(oclComponent, zdl);

		assertEval(null, uml, component.getStereotypeApplication(stereo));
	}

	/**
	 * Tests the coercion of an element to its stereotype application using the
	 * <tt>oclAsType</tt> operation.
	 */
	@Test
	public void test_oclAsType_stereotype_13553() {
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		Class umlComponent = stereo.getExtendedMetaclasses().get(0);

		OCLExpression<Classifier> zdl = parseQuery(umlComponent,
			"self.oclAsType(test_ocl::OCLTest::OCLComponent)");
		OCLExpression<Classifier> uml = transform(oclComponent, zdl);

		assertEval(component.getStereotypeApplication(stereo), uml, component);

		zdl = parseQuery(umlComponent,
			"self.oclAsType(test_ocl::OCLTest::OCLImplementation)");
		uml = transform(oclComponent, zdl);

		assertEval(null, uml, component);
	}

	/**
	 * Tests the coercion of an element to another metaclass (UML semantics
	 * only) using the <tt>oclAsType</tt> operation.
	 */
	@Test
	public void test_oclAsType_umlSemantics_13553() {
		Stereotype stereo = component
			.getAppliedStereotype("test_ocl::OCLComponent");
		Class umlComponent = stereo.getExtendedMetaclasses().get(0);

		OCLExpression<Classifier> uml = parseQuery(umlComponent,
			"self.oclAsType(StructuredClassifier)");
		// no need for any ZDL transformations

		assertEval(component, uml, component);

		uml = parseQuery(umlComponent, "self.oclAsType(Feature)");

		assertEval(null, uml, component);
	}

	/**
	 * Tests the navigation through a sequence of properties via a UML
	 * meta-attribute mapping back to a stereotype attribute.
	 */
	@Test
	public void test_metaclassToStereotypeAttribute_13578() {
		Property prop1 = component3.getOwnedAttribute("prop1", null);

		OCLExpression<Classifier> zdl = parseQuery(oclProperty,
			"self.type.synchronization <> SynchronizationKind::unspecified");
		OCLExpression<Classifier> uml = transform(oclProperty, zdl);

		assertEval(Boolean.FALSE, uml, prop1);

		ZDLUtil.setValue(propType1, oclInterface,
			TestOCLNames.OCLINTERFACE__SYNCHRONIZATION, synchronization
				.getOwnedLiteral("synchronous"));

		assertEval(true, uml, prop1);
	}

	/**
	 * Tests navigation from a stereotype, through two profile classes, to
	 * another stereotype and to a metaclass.
	 */
	@Test
	public void test_profileClassNavigation_13578() {
		OCLExpression<Classifier> zdl = parseQuery(
			oclAssembly,
			"self.configuration.port->collect(p |"
				+ "  Tuple{interface=p.interface.name, file=p.selectedImplementation.fileName})");
		OCLExpression<Classifier> uml = transform(oclProperty, zdl);

		// evaluate the expression on the stereotype application (which
		// validation does for constraints in a stereotype context)
		@SuppressWarnings("unchecked")
		Collection<Tuple<?, ?>> result = (Collection<Tuple<?, ?>>) ocl.evaluate(
			component2.getStereotypeApplication(oclAssemblyStereotype), uml);

		assertEquals("Not enough tuples", 2, result.size());

		Map<String, String> map = mapTuples(result, "interface", "file");
		Map<String, String> expected = map("Prov", "/usr/lib/impl1.so",
			"PropType1", "/usr/shared/lib/impl-alt.so");

		assertEquals("Wrong tuple values", expected, map);
	}

	//
	// Framework methods
	//

	@Override
	@Before
	public void setUp()
			throws Exception {

		super.setUp();

		Resource profileRes = rset.getResource(URI
			.createPlatformPluginURI(
				"com.zeligsoft.base.zdl.ocl.test/models/test_ocl.profile.uml",
				true), true);

		assertNotNull("Test profile resource not available", profileRes);
		org.junit.Assert.assertTrue("Test profile resource not loaded", profileRes.isLoaded());

		profile = (Profile) EcoreUtil.getObjectByType(profileRes.getContents(),
			UMLPackage.Literals.PROFILE);

		fixture = new ZDLToProfileTransformation(env, profile);

		oclComponentStereotype = profile.getOwnedStereotype("OCLComponent");
		oclAssemblyStereotype = profile.getOwnedStereotype("OCLAssembly");
		oclImplementationStereotype = profile
			.getOwnedStereotype("OCLImplementation");
		oclPortStereotype = profile.getOwnedStereotype("OCLPort");
		oclInterfaceStereotype = profile.getOwnedStereotype("OCLInterface");
		oclPropertyStereotype = profile.getOwnedStereotype("OCLProperty");
		availabilityProfileEnum = (Enumeration) profile
			.getOwnedType("AvailabilityKind");
		synchronizationProfileEnum = (Enumeration) profile
			.getOwnedType("SynchronizationKind");

		oclComponent = getConcept(oclComponentStereotype);
		oclAssembly = getConcept(oclAssemblyStereotype);
		oclImplementation = getConcept(oclImplementationStereotype);
		oclPort = getConcept(oclPortStereotype);
		oclInterface = getConcept(oclInterfaceStereotype);
		oclProperty = getConcept(oclPropertyStereotype);
		availability = getConcept(availabilityProfileEnum);
		synchronization = getConcept(synchronizationProfileEnum);

		Resource packageRes = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.base.zdl.ocl.test/models/test_model.emx", true),
			true);

		assertNotNull("Test model resource not available", packageRes);
		org.junit.Assert.assertTrue("Test model resource not loaded", packageRes.isLoaded());

		testPackage = (Package) EcoreUtil.getObjectByType(packageRes
			.getContents(), UMLPackage.Literals.PACKAGE);

		component = (Component) testPackage.getOwnedMember("Comp1", false,
			UMLPackage.Literals.COMPONENT);

		component2 = (Component) testPackage.getOwnedMember("Comp2", false,
			UMLPackage.Literals.COMPONENT);

		component3 = (Component) testPackage.getOwnedMember("Comp3", false,
			UMLPackage.Literals.COMPONENT);

		implementation = (Artifact) testPackage.getOwnedMember("Impl1", false,
			UMLPackage.Literals.ARTIFACT);

		propType1 = (Interface) testPackage.getOwnedMember("PropType1", false,
			UMLPackage.Literals.INTERFACE);
	}

	@Override
	@After
	public void tearDown()
			throws Exception {

		fixture = null;

		super.tearDown();
	}

	protected Constraint transform(Constraint zdl) {
		// first, copy the constraint so that we do not modify the original
		return fixture.toProfileConstraint(EcoreUtil.copy(zdl));
	}

	protected OCLExpression<Classifier> transform(Classifier context,
			OCLExpression<Classifier> zdl) {
		// first, copy the expression so that we do not modify the original
		OCLExpression<Classifier> result = EcoreUtil.copy(zdl);

		// pack the expression into a constraint
		Constraint cons = env.getUMLReflection().createConstraint();
		ExpressionInOCL<Classifier, Parameter> spec = env.getUMLReflection()
			.createExpressionInOCL();
		Variable<Classifier, Parameter> self = env.getOCLFactory()
			.createVariable();
		self.setName("self");
		self.setType(context);
		spec.setContextVariable(self);
		spec.setBodyExpression(result);
		env.getUMLReflection().setSpecification(cons, spec);

		cons = fixture.toProfileConstraint(cons);

		// unpack the expression and disconnect it from the constraint
		spec = env.getUMLReflection().getSpecification(cons);
		result = spec.getBodyExpression();
		spec.setBodyExpression(null);

		return result;
	}

	/**
	 * Extracts the values of tuple parts into a map for easy access, especially
	 * for comparison against other maps in assertions.
	 * 
	 * @param <K>
	 *            the map's key type
	 * @param <V>
	 *            the map's value type
	 * @param tuples
	 *            the collection of tuples to map
	 * @param keyPart
	 *            the name of the tuple part to extract into keys
	 * @param valuePart
	 *            the name of the tuple part to extract into values
	 * 
	 * @return the resulting map
	 */
	@SuppressWarnings("unchecked")
	protected <K, V> Map<K, V> mapTuples(Collection<Tuple<?, ?>> tuples,
			String keyPart, String valuePart) {
		Map<K, V> result = new java.util.HashMap<K, V>();

		for (Tuple<?, ?> next : tuples) {
			result
				.put((K) next.getValue(keyPart), (V) next.getValue(valuePart));
		}

		return result;
	}

	/**
	 * Constructs a map from the specified keys and values, taken pairwise as an
	 * array of (key, value, key, value, ...).
	 * 
	 * @param <K>
	 *            the map's key type
	 * @param <V>
	 *            the map's value type
	 * @param pairwiseKeysAndValues
	 *            the pair-wise keys and values
	 * 
	 * @return the resulting map
	 */
	@SuppressWarnings("unchecked")
	protected <K, V> Map<K, V> map(Object... pairwiseKeysAndValues) {
		Map<K, V> result = new java.util.HashMap<K, V>();

		for (int i = 0; i < pairwiseKeysAndValues.length; i += 2) {
			result.put((K) pairwiseKeysAndValues[i],
				(V) pairwiseKeysAndValues[i + 1]);
		}

		return result;
	}
}
