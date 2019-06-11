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

import static com.zeligsoft.base.validation.test.TestValidationNames.SOURCE;
import static com.zeligsoft.base.validation.test.TestValidationNames.SOURCE__AT_LEAST_ONE;
import static com.zeligsoft.base.validation.test.TestValidationNames.SOURCE__AT_MOST_TWO;
import static com.zeligsoft.base.validation.test.TestValidationNames.SOURCE__BETWEEN_TWO_AND_FIVE;
import static com.zeligsoft.base.validation.test.TestValidationNames.SOURCE__EXACTLY_ONE;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.uml2.uml.DataType;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Tests the generic multiplicity constraint.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class MultiplicityConstraintTest
		extends AbstractTestCase<EObject> {

	private static final String ID_PREFIX = "com.zeligsoft.base.validation.test.zdl." + SOURCE + "::";

	private static final String ID_EXACTLY_ONE = ID_PREFIX
		+ SOURCE__EXACTLY_ONE;

	private static final String ID_AT_LEAST_ONE = ID_PREFIX
		+ SOURCE__AT_LEAST_ONE;

	private static final String ID_AT_MOST_TWO = ID_PREFIX
		+ SOURCE__AT_MOST_TWO;

	private static final String ID_BETWEEN_TWO_AND_FIVE = ID_PREFIX
		+ SOURCE__BETWEEN_TWO_AND_FIVE;
	
	protected DataType source;

	protected DataType target1;

	protected DataType target2;

	protected DataType target3;

	protected DataType target4;

	protected DataType target5;

	protected DataType target6;


	/**
	 * Tests that the constraint is found and passes when it should.
	 */
	@Test
	public void test_constraintPasses() {
		validate();

		assertConstraintPassed(source, ID_EXACTLY_ONE);
		assertConstraintPassed(source, ID_AT_LEAST_ONE);
		assertConstraintPassed(source, ID_AT_MOST_TWO);
		assertConstraintPassed(source, ID_BETWEEN_TWO_AND_FIVE);
	}

	/**
	 * Tests that an exactly-one violation is caught (a boundary case).
	 */
	@Test
	public void test_exactlyOne() {
		ZDLUtil.setValue(source, SOURCE,
			SOURCE__EXACTLY_ONE, null);

		validate();

		assertConstraintFailed(source, ID_EXACTLY_ONE);
	}

	/**
	 * Tests that an at-least-one violation is caught (a boundary case).
	 */
	@Test
	public void test_atLeastOne() {
		@SuppressWarnings("unchecked")
		EList<DataType> values = (EList<DataType>) ZDLUtil.getValue(source, SOURCE,
			SOURCE__AT_LEAST_ONE);

		values.clear();
		
		validate();

		assertConstraintFailed(source, ID_AT_LEAST_ONE);
	}

	/**
	 * Tests that an at-most-(something-more-than-one) violation is caught
	 * (a boundary case).
	 */
	@Test
	public void test_atMostTwo() {
		@SuppressWarnings("unchecked")
		EList<DataType> values = (EList<DataType>) ZDLUtil.getValue(source, SOURCE,
			SOURCE__AT_MOST_TWO);

		values.add(target2);
		
		validate();

		// two are not too many
		assertConstraintPassed(source, ID_AT_MOST_TWO);
		
		values.add(target3);
		
		validate();

		// three are too many
		assertConstraintFailed(source, ID_AT_MOST_TWO);
	}

	/**
	 * Tests that a between-bounds-both-greater-than-one underflow violation is 
	 * caught (a boundary case).
	 */
	@Test
	public void test_betweenTwoAndFive_under() {
		@SuppressWarnings("unchecked")
		EList<DataType> values = (EList<DataType>) ZDLUtil.getValue(source, SOURCE,
			SOURCE__BETWEEN_TWO_AND_FIVE);

		values.remove(target3);
		
		validate();

		// two are not too few
		assertConstraintPassed(source, ID_BETWEEN_TWO_AND_FIVE);
		
		values.remove(target2);
		
		validate();

		// one is too few
		assertConstraintFailed(source, ID_BETWEEN_TWO_AND_FIVE);
	}

	/**
	 * Tests that a between-bounds-both-greater-than-one overflow violation is 
	 * caught (a boundary case).
	 */
	@Test
	public void test_betweenTwoAndFive_over() {
		@SuppressWarnings("unchecked")
		EList<DataType> values = (EList<DataType>) ZDLUtil.getValue(source, SOURCE,
			SOURCE__BETWEEN_TWO_AND_FIVE);

		values.add(target4);
		values.add(target5);
		
		validate();

		// five are not too many
		assertConstraintPassed(source, ID_BETWEEN_TWO_AND_FIVE);
		
		values.add(target6);
		
		validate();

		// six are too many
		assertConstraintFailed(source, ID_BETWEEN_TWO_AND_FIVE);
	}

	//
	// Test framework methods
	//

	@Override
	@Before
	public void setUp()
			throws Exception {

		super.setUp();

		source = (DataType) testModel.getOwnedType("Source");
		target1 = (DataType) testModel.getOwnedType("Target1");
		target2 = (DataType) testModel.getOwnedType("Target2");
		target3 = (DataType) testModel.getOwnedType("Target3");
		target4 = (DataType) testModel.getOwnedType("Target4");
		target5 = (DataType) testModel.getOwnedType("Target5");
		target6 = (DataType) testModel.getOwnedType("Target6");
	}

	@Override
	protected EvaluationMode<EObject> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}
}
