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

import static com.zeligsoft.base.validation.test.TestValidationNames.THING;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__IS_ENABLED;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__OTHER;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.validation.test.constraints.TestClientContext;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A suite of tests to verify the functionality of a constraint that is not
 * owned by a Domain Concept.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class FreeStandingConstraintsTestCase extends AbstractTestCase<EObject> {

	private static final String CONSTRAINT_ID = 
		"com.zeligsoft.base.validation.test.FSConstraint.target.1"; //$NON-NLS-1$
	private static final String TEST2_PROFESSIONAL_ID = 
		"com.zeligsoft.base.validation.test.FSConstraint2.ProfessionalConstraint"; //$NON-NLS-1$
	private static final String TEST2_PERSON_ID = 
		"com.zeligsoft.base.validation.test.FSConstraint2.PersonConstraint"; //$NON-NLS-1$
	private static final String TEST2_STUDENT_ID = 
		"com.zeligsoft.base.validation.test.FSConstraint2.StudentConstraint"; //$NON-NLS-1$
	
	private static final String TEST2_PRIME_PROFESSIONAL_ID = 
		"com.zeligsoft.base.validation.test.FSConstraint2Prime.ProfessionalPrimeConstraint"; //$NON-NLS-1$
	
	protected Model test2Model;
	protected Model test2PrimeModel;
	
	protected Actor toby;
	protected Actor francis;
	protected Actor tobyPrime;
	protected Actor francisPrime;
	
	@Override
	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}
	
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		
		TestClientContext.isEnabled = false;
		
		test2Model = 
			(Model) loadPackage("/models/fsconstraint2_model.emx"); //$NON-NLS-1$
		toby = (Actor) test2Model.getOwnedType("Sean"); //$NON-NLS-1$
		francis = (Actor) test2Model.getOwnedType("Simon"); //$NON-NLS-1$
		
		test2PrimeModel = (Model) loadPackage("/models/fsconstraint2prime_model.emx"); //$NON-NLS-1$
		tobyPrime = (Actor) test2PrimeModel.getOwnedType("Sean"); //$NON-NLS-1$
		francisPrime = (Actor) test2PrimeModel.getOwnedType("Simon"); //$NON-NLS-1$
		
		TestClientContext.isEnabled = true;
		
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		TestClientContext.isEnabled = false;
		francis = null;
		toby = null;
		francisPrime = null;
		tobyPrime = null;
		
		test2Model = null;
		test2PrimeModel = null;
		
		super.tearDown();
	}
	
	/**
	 * Run model validation on the model stored in the member variable
	 * <tt>test2Model</tt>.
	 * 
	 * @return
	 * 		The status that is a result of running the test.
	 */
	@SuppressWarnings("cast")
	protected final IStatus validateTest2Model() {
		return validate((EObject) test2Model);
	}
	
	/**
	 * Run model validation on the model stored in the member variable
	 * <tt>test2PrimeModel</tt>
	 * 
	 * @return
	 * 		The result of running the validation.
	 */
	@SuppressWarnings("cast")
	protected final IStatus validateTest2PrimeModel() {
		return validate((EObject) test2PrimeModel);
	}

	/**
	 * Tests that ensure that a constraint defined outside of
	 * the concepts works.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test_constraintPasses() {
		ZDLUtil.setValue(joe, THING, THING__IS_ENABLED, true);
		ZDLUtil.setValue(amy, THING, THING__IS_ENABLED, true);

		validate();

		assertConstraintFailed(amy, CONSTRAINT_ID);

		((List<Actor>) ZDLUtil.getValue(amy, THING, THING__OTHER)).add(bob);

		validate();

		// now it passes
		assertConstraintPassed(amy, CONSTRAINT_ID);
	}
	
	/**
	 * Tests that ensure that only the constraints included through
	 * domain block references are run on an element. That is if the
	 * domain specialization does not include the domain block then
	 * the validation constraint will not be evaluated on the elements.
	 */
	@Test
	public void test_test2Model() {
		validateTest2Model();
		
		assertConstraintPassed(toby, TEST2_PERSON_ID);
		assertConstraintPassed(francis, TEST2_PERSON_ID);
		
		assertConstraintPassed(toby, TEST2_STUDENT_ID);
		assertConstraintPassed(francis, TEST2_PROFESSIONAL_ID);
		
		validateTest2PrimeModel();
		
		assertConstraintPassed(francisPrime, TEST2_PRIME_PROFESSIONAL_ID);
		assertConstraintNotEvaluated(francisPrime, TEST2_PERSON_ID);
		assertConstraintNotEvaluated(francisPrime, TEST2_PROFESSIONAL_ID);
		
		assertConstraintNotEvaluated(tobyPrime, TEST2_PERSON_ID);
		assertConstraintNotEvaluated(tobyPrime, TEST2_STUDENT_ID);
		
		
	}
}
