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


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.uml2.uml.Class;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests support for constraint redefinition in ZDL.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ConstraintRedefinitionTest
		extends AbstractTestCase<EObject> {

	private static final String ROOT_CONSTRAINT = "com.zeligsoft.base.validation.test.ConstraintRedef0.redefRoot";

	private static final String INTERMEDIATE_CONSTRAINT = "com.zeligsoft.base.validation.test.ConstraintRedef1.redefInter";

	private static final String LEAF_CONSTRAINT = "com.zeligsoft.base.validation.test.ConstraintRedef2.redefLeaf";

	protected Class redef0;

	protected Class redef1;

	protected Class redef2;
	
	/**
	 * Initializes me with my name.
	 * 
	 * @param name my name
	 */
	public ConstraintRedefinitionTest() {
		// Default constructor
	}

	
	/**
	 * Tests that a redefined constraint is applied to direct instances of its
	 * context class.
	 */
	@Test
	public void test_redefinition_zeroLevels() {
		validate(redef0);
		assertConstraintFailed(redef0, ROOT_CONSTRAINT);
		assertConstraintNotEvaluated(redef0, INTERMEDIATE_CONSTRAINT);
		assertConstraintNotEvaluated(redef0, LEAF_CONSTRAINT);
	}
	
	/**
	 * Tests that a redefined constraint is not applied to direct instances of
	 * an immediate subclass of its context class.
	 */
	@Test
	public void test_redefinition_oneLevel() {
		validate(redef1);
		assertConstraintNotEvaluated(redef1, ROOT_CONSTRAINT);
		assertConstraintFailed(redef1, INTERMEDIATE_CONSTRAINT);
		assertConstraintNotEvaluated(redef1, LEAF_CONSTRAINT);
	}
	
	/**
	 * Tests that a redefined constraint is not applied to instances of a remote
	 * subclass of its context class.
	 */
	@Test
	public void test_redefinition_nLevels() {
		validate(redef2);
		assertConstraintNotEvaluated(redef2, ROOT_CONSTRAINT);
		assertConstraintNotEvaluated(redef2, INTERMEDIATE_CONSTRAINT);
		assertConstraintPassed(redef2, LEAF_CONSTRAINT);
	}

	//
	// Test framework
	//
	
	@Override
	@Before
	public void setUp()
			throws Exception {

		super.setUp();

		redef0 = (Class) testModel.getOwnedType("ConstraintRedef0");
		redef1 = (Class) testModel.getOwnedType("ConstraintRedef1");
		redef2 = (Class) testModel.getOwnedType("ConstraintRedef2");
	}

	@Override
	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

}
