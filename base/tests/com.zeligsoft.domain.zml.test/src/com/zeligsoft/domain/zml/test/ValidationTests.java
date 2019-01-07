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

package com.zeligsoft.domain.zml.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Tests the constraints defined in the SCA domain model.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ValidationTests {

	static final String ID_PREFIX = "com.zeligsoft.domain.zml.";

	private static final String PORT__TYPE_IS_PORTTYPE = ID_PREFIX
		+ "Port.type_is_portType";

	private final String PORT_TYPE__PORT_TYPE_INVERSE = ID_PREFIX
		+ "PortType.port_type_inverse";

	private final String STRUCTURAL_REALIZATION__INTERFACE_METATYPE = ID_PREFIX
		+ "StructuralRealization.interface_metatype";

	protected ResourceSet rset;

	protected Model testModel;

	protected Component component1;

	protected Component component2;

	protected Port port1;
	
	protected Port port2;
	
	protected Component realization1;
	
	protected Component realization2;

	protected IStatus status;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public ValidationTests() {
		// Default constructor
	}

	/**
	 * Tests the <tt>Port__type_is_portType</tt> constraint
	 */
	@Test
	public void test_Port__type_is_portType() {
		validate();
		assertConstraintPassed(port1, PORT__TYPE_IS_PORTTYPE);
		assertConstraintPassed(port2, PORT__TYPE_IS_PORTTYPE);

		// remove the <<portType>> stereotype from port1's type
		for (Stereotype stereo : port1.getType().getAppliedStereotypes()) {
			port1.getType().unapplyStereotype(stereo);
		}
		
		// clear port2's type altogether
		port2.setType(null);

		validate();
		assertConstraintFailed(port1, PORT__TYPE_IS_PORTTYPE);
		assertConstraintFailed(port2, PORT__TYPE_IS_PORTTYPE);
	}
	
	/**
	 * Tests the <tt>PortType__port_type_inverse</tt> constraint
	 */
	@Test
	public void test_PortType__port_type_inverse() {
		validate();
		assertConstraintPassed(port1.getType(), PORT_TYPE__PORT_TYPE_INVERSE);
		assertConstraintPassed(port2.getType(), PORT_TYPE__PORT_TYPE_INVERSE);

		ZDLUtil.setValue(port1.getType(), ZMLMMNames.PORT_TYPE,
			ZMLMMNames.PORT_TYPE__INVERSE, null);

		validate();
		assertConstraintFailed(port1.getType(), PORT_TYPE__PORT_TYPE_INVERSE);
		assertConstraintFailed(port2.getType(), PORT_TYPE__PORT_TYPE_INVERSE);
	}
	
	/**
	 * Tests the <tt>StructuralRealization__interface_metatype</tt> constraint
	 */
	@Test
	public void test_StructuralRealization__interface_metatype() {
		validate();
		assertConstraintPassed(realization1,
			STRUCTURAL_REALIZATION__INTERFACE_METATYPE);
		assertConstraintPassed(realization2,
			STRUCTURAL_REALIZATION__INTERFACE_METATYPE);

		// remove a realization's interface
		ZDLUtil.setValue(realization2, ZMLMMNames.STRUCTURAL_REALIZATION,
			ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE, null);

		validate();
		assertConstraintFailed(realization2,
			STRUCTURAL_REALIZATION__INTERFACE_METATYPE);
	}

	//
	// Framework methods
	//
	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();

		testModel = (Model) loadPackage("/models/test_model.emx");

		component1 = (Component) testModel.getOwnedType("Comp1");
		component2 = (Component) testModel.getOwnedType("Comp2");
		port1 = component1.getOwnedPort("port1", null);
		port2 = component2.getOwnedPort("port2", null);
		realization1 = (Component) testModel.getOwnedType("Realz1");
		realization2 = (Component) testModel.getOwnedType("Realz2");
		
		TestClientContext.isEnabled = true;
	}

	protected Package loadPackage(String path) {
		Resource res = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.domain.zml.test" + path, true), true);
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

		realization2 = null;
		realization1 = null;
		port2 = null;
		port1 = null;
		component2 = null;
		component1 = null;

		testModel = null;

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;
	}

	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

	protected final IStatus validate() {
		return validate(testModel);
	}

	protected final IStatus validate(EObject element) {
		IValidator<EObject> validator = ModelValidationService.getInstance()
			.newValidator(getEvaluationMode());

		// need to report success statuses to assert that constraints were
		// evaluated in the first place
		validator.setReportSuccesses(true);
		
		if (validator.getEvaluationMode() == EvaluationMode.BATCH) {
			// we'll test these in the batch mode
			((IBatchValidator) validator).setIncludeLiveConstraints(true);
		}
		
		status = validator.validate(element);

		return status;
	}

	protected void assertConstraintPassed(EObject target, String id) {
		assertConstraintStatus(target, id, IStatus.OK);
	}

	protected void assertConstraintFailed(EObject target, String id) {
		assertConstraintStatus(target, id, IStatus.INFO | IStatus.WARNING
			| IStatus.ERROR | IStatus.CANCEL);
	}

	protected void assertConstraintStatus(EObject target, String id, int mask) {
		IStatus specific = assertStatus(target, id);

		if (mask == IStatus.OK) {
			if (!specific.isOK()) {
				fail(String.format("Constraint %s failed for %s", id, target));
			}
		} else if (specific.isOK()) {
			fail(String.format("Constraint %s passed for %s", id, target));
		} else if ((specific.getSeverity() & mask) == 0) {
			fail(String.format("Constraint %s has wrong status for %s", id,
				target));
		}
	}

	protected IStatus assertStatus(EObject target, String id) {
		IStatus result = findStatus(status, target, id);

		if (result == null) {
			fail(String
				.format("Constraint %s not evaluated for %s", id, target));
		}

		return result;
	}

	private IStatus findStatus(IStatus status, EObject target, String id) {
		IStatus result = null;

		if (status instanceof IConstraintStatus) {
			IConstraintStatus cstatus = (IConstraintStatus) status;

			if ((cstatus.getTarget() == target)
				&& id.equals(cstatus.getConstraint().getDescriptor().getId())) {
				result = cstatus;
			}
		}

		if ((result == null) && status.isMultiStatus()) {
			for (IStatus next : status.getChildren()) {
				result = findStatus(next, target, id);
				if (result != null) {
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Simple toggle context for testing purposes.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static class TestClientContext
			implements IClientSelector {

		/** Set enabled during validation tests to ensure constraint evaluation. */
		public static boolean isEnabled = false;

		/**
		 * Initializes me.
		 */
		public TestClientContext() {
			super();
		}

		@Override
		public boolean selects(Object object) {
			return isEnabled;
		}

	}
}
