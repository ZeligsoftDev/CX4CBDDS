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

import static com.zeligsoft.base.validation.test.TestValidationNames.OTHER;
import static com.zeligsoft.base.validation.test.TestValidationNames.OTHER__NAME;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__IS_ENABLED;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__OTHER;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Tests validation constraints implemented in OCL.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class OCLConstraintsTestCase
		extends AbstractTestCase<EObject> {

	private static final String CONSTRAINT_ID = "test.validation.ocl.1";

	/**
	 * Tests that a relatively straight-forward constraint is found and passes.
	 */
	@Test
	public void test_constraintPasses() {
		validate();

		// passes because isEnabled is false
		assertConstraintPassed(joe, CONSTRAINT_ID);

		ZDLUtil.setValue(joe, THING, THING__IS_ENABLED, true);

		validate();

		// passes because joe has bob
		assertConstraintPassed(joe, CONSTRAINT_ID);

		validate();

		// passes because isEnabled is false
		assertConstraintPassed(amy, CONSTRAINT_ID);
	}

	/**
	 * Tests that a relatively straight-forward constraint is found and fails.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_constraintFails() {
		ZDLUtil.setValue(joe, THING, THING__IS_ENABLED, true);
		ZDLUtil.setValue(amy, THING, THING__IS_ENABLED, true);

		validate();

		assertConstraintFailed(amy, CONSTRAINT_ID);

		((List<Actor>) ZDLUtil.getValue(amy, THING, THING__OTHER)).add(bob);

		validate();

		// now it passes
		assertConstraintPassed(amy, CONSTRAINT_ID);

		assertConstraintPassed(joe, CONSTRAINT_ID);

		((List<?>) ZDLUtil.getValue(joe, THING, THING__OTHER)).remove(bob);

		validate();

		// now it fails
		assertConstraintFailed(joe, CONSTRAINT_ID);
	}

	/**
	 * Tests that different mappings (to profiles) of the same ZDL concepts
	 * result in different constraints that both evaluate as expected
	 */
	@Test
	public void test_oneZDL_differentProfileMappings() {
		// in the same resource set, load a model that has the other
		// profile applied with different mappings of the same concepts
		Package otherPackage = loadPackage("/models/ocl_test_model.emx");
		Class otherAmy = (Class) otherPackage.getOwnedType("Amy");
		Class otherJoe = (Class) otherPackage.getOwnedType("Joe");

		// the same model as before
		ZDLUtil.setValue(joe, THING, THING__IS_ENABLED, true);
		ZDLUtil.setValue(amy, THING, THING__IS_ENABLED, true);

		validate();

		assertConstraintFailed(amy, CONSTRAINT_ID);
		assertConstraintPassed(joe, CONSTRAINT_ID);

		// the other model
		ZDLUtil.setValue(otherJoe, THING, THING__IS_ENABLED, true);
		ZDLUtil.setValue(otherAmy, THING, THING__IS_ENABLED, true);

		validate(otherPackage);

		assertConstraintFailed(otherAmy, CONSTRAINT_ID);
		assertConstraintPassed(otherJoe, CONSTRAINT_ID);
	}

	/**
	 * Tests that constraints are correctly inherited by specializing concepts.
	 */
	@Test
	public void test_constraintInheritance_13542() {
		// in the same resource set, load a model that has the other
		// profile applied with different mappings of the same concepts
		Package testPackage = loadPackage("/models/ocl_test_model.emx");
		
		Class zoe = (Class) testPackage.getOwnedType("Zoe");
		Property bill = zoe.getOwnedAttribute("Bill", null);

		validate(testPackage);
		assertConstraintFailed(zoe, CONSTRAINT_ID);

		ZDLUtil.setValue(bill, OTHER, OTHER__NAME, "Bob");

		validate(testPackage);
		assertConstraintPassed(zoe, CONSTRAINT_ID);
	}

	//
	// Test framework methods
	//

	@Override
	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}
}
