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
package com.zeligsoft.domain.omg.corba.test;

import java.util.ArrayList;

import org.junit.Test;

import com.zeligsoft.base.testsupport.annotations.ValidationTestSuite;
import com.zeligsoft.base.testsupport.annotations.ValidationUnitTest;



/**
 * @author tmcguire
 * 
 */
@ValidationTestSuite(domainModel = "com.zeligsoft.domain.omg.corba/models/CORBADomain.emx")
public class OnewayOperationValidationTests extends CORBABaseValidationTestCase {

	private static final String VALIDATION_MODEL = "/models/OnewayOperationTests.emx"; //$NON-NLS-1$
	private static final String ID_PREFIX = "com.zeligsoft.domain.omg.corba."; //$NON-NLS-1$
	
	private static final String ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID = ID_PREFIX
			+ "CORBAOperation.oneway_parameters_constraint"; //$NON-NLS-1$
	
	private static final String ONEWAY_OPERATION_IN_RAISES_CONSTRAINT_ID = ID_PREFIX
			+ "CORBAOperation.oneway_raises_exception_constraint"; //$NON-NLS-1$
	
	private static final String ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID = ID_PREFIX
			+ "CORBAOperation.oneway_return_parameter_constraint"; //$NON-NLS-1$

	/**
	 * constructor
	 */
	public OnewayOperationValidationTests() {
		super();
	}

	
	/**
	 *  Operations that are not oneway should pass
	 */
	@Test
	@ValidationUnitTest( constraintVerified = {ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID, ONEWAY_OPERATION_IN_RAISES_CONSTRAINT_ID, ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID } )
	public void test_nonOnewayOperation() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		String validOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::validNonOnewayOperationWithException"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID, validOperation));
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONEWAY_OPERATION_IN_RAISES_CONSTRAINT_ID, validOperation));
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID, validOperation));
		
		validateModel(VALIDATION_MODEL, validOperation, expectedResults);
	}
		
		
	/**
	 *  Test oneway operations for in, inout and out parameters
	 *  Only in parameters are allowed
	 */
	@Test
	@ValidationUnitTest( constraintVerified = {ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID } )
	public void test_onewayOperationParameters() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		String validOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::validOnewayOperation"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID, validOperation));
		validateModel(VALIDATION_MODEL, validOperation, expectedResults);
		expectedResults.clear();

		String invalidOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::invalidOnewayOperationWith_In_InOut_Params"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				ONEWAY_OPERATION_IN_PARAM_CONSTRAINT_ID, invalidOperation));
		validateModel(VALIDATION_MODEL, invalidOperation, expectedResults);
	}

	
	/**
	 *  Test oneway operations for return parameters
	 *  Only CORBAVoid parameters are allowed
	 */
	@Test
	@ValidationUnitTest( constraintVerified = {ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID } )
	public void test_onewayOperationReturnParameters() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		String validOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::validOnewayOperation"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID, validOperation));
		validateModel(VALIDATION_MODEL, validOperation, expectedResults);
		expectedResults.clear();

		String invalidOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::invalidOneWayOperationWithReturnType"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				ONEWAY_OPERATION_RETURN_PARAM_CONSTRAINT_ID, invalidOperation));
		validateModel(VALIDATION_MODEL, invalidOperation, expectedResults);
	}
	
	/**
	 *  Oneway operations are not allowed to specify raised exceptions
	 */
	@Test
	public void test_invalidOneWayWithException() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		String validOperation = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::validOnewayOperation"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				ONEWAY_OPERATION_IN_RAISES_CONSTRAINT_ID, validOperation));
		validateModel(VALIDATION_MODEL, validOperation, expectedResults);
		expectedResults.clear();
		
		String invalidOperationWithException = "OnewayOperationTests::Interfaces::CORBAInterfaceFile::CORBAInterface::invalidOneWayWithException"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				ONEWAY_OPERATION_IN_RAISES_CONSTRAINT_ID,
				invalidOperationWithException));
		validateModel(VALIDATION_MODEL, invalidOperationWithException, expectedResults);
	}

}
