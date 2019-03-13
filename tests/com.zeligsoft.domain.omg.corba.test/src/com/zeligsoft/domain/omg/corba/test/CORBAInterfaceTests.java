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
 * @author Tim McGuire (tmcguire)
 * 
 */
@ValidationTestSuite(domainModel = "com.zeligsoft.domain.omg.corba/models/CORBADomain.emx")
public class CORBAInterfaceTests extends CORBABaseValidationTestCase {

	private static final String VALIDATION_MODEL = "/models/CORBAInterfaceTests.emx"; //$NON-NLS-1$
	private static final String ID_PREFIX = "com.zeligsoft.domain.omg.corba."; //$NON-NLS-1$
	private static final String INTERFACE_NOT_BOTH_LOCAL_AND_ABSTRACT = ID_PREFIX + "CORBAInterface.not_both_local_and_abstract"; //$NON-NLS-1$
	private static final String UNIQUE_OPERATION_NAMES = ID_PREFIX + "CORBAInterface.unique_operation_names"; //$NON-NLS-1$
	private static final String UNIQUE_ATTRIBUTE_NAMES = ID_PREFIX + "CORBAInterface.unique_attribute_names"; //$NON-NLS-1$
	private static final String ONLY_INHERITED_FROM_ABSTRACT = ID_PREFIX + "CORBAInterface.only_inherit_from_abstract"; //$NON-NLS-1$
	private static final String ONLY_INHERITED_FROM_LOCAL = ID_PREFIX + "CORBAInterface.only_inherit_from_local"; //$NON-NLS-1$
	private static final String UNIQUE_INHERITED_OPERAION_NAMES = ID_PREFIX + "CORBAInterface.unique_inherited_operation_names"; //$NON-NLS-1$
	private static final String DONT_OVERRIDE_FEATURE = ID_PREFIX + "CORBAInterface.dont_override_feature"; //$NON-NLS-1$
	private static final String ONLY_CORBA_OPERATIONS = ID_PREFIX + "CORBAInterface.OnlyCORBAOperations"; //$NON-NLS-1$
	private static final String ONLY_CORBA_ATTRIBUTES = ID_PREFIX + "CORBAInterface.OnlyCORBAAttributes"; //$NON-NLS-1$


	/**
	 * constructor
	 */
	public CORBAInterfaceTests() {
		super();
	}

	
	/**
	 *  CORBA Interfaces cannot be both local and abstract
	 */
	@Test
	@ValidationUnitTest( constraintVerified = { INTERFACE_NOT_BOTH_LOCAL_AND_ABSTRACT } )
	public void test_interfaceNotBothLocalAndAbstract() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String ABSTRACT_INTERFACE = IDLFILE + "::CORBAModule::AbstractInterface"; //$NON-NLS-1$
		final String LOCAL_INTERFACE = IDLFILE + "::CORBAModule::LocalInterface"; //$NON-NLS-1$
		final String INVALID_INTERFACE = IDLFILE + "::CORBAModule::InvalidInterface"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, INTERFACE_NOT_BOTH_LOCAL_AND_ABSTRACT, ABSTRACT_INTERFACE ));
		expectedResults.add(new ExpectedResult(TestResult.PASS, INTERFACE_NOT_BOTH_LOCAL_AND_ABSTRACT, LOCAL_INTERFACE)); 
		expectedResults.add(new ExpectedResult(TestResult.FAIL, INTERFACE_NOT_BOTH_LOCAL_AND_ABSTRACT, INVALID_INTERFACE));
		
		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
		
	@Test
	@ValidationUnitTest( constraintVerified = { UNIQUE_OPERATION_NAMES } )
	public void test_unique_operation_names() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String uniqueOperationNames = IDLFILE + "::CORBAModule::CORBAModule_1"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNIQUE_OPERATION_NAMES, uniqueOperationNames + "::unique_interface" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNIQUE_OPERATION_NAMES, uniqueOperationNames + "::non_unique_interface" )); //$NON-NLS-1$
	
		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
		
	@Test
	@ValidationUnitTest( constraintVerified = { UNIQUE_ATTRIBUTE_NAMES } )
	public void test_unique_attribute_names() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String uniqueOperationNames = IDLFILE + "::CORBAModule::CORBAModule_1"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNIQUE_ATTRIBUTE_NAMES, uniqueOperationNames + "::unique_interface" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNIQUE_ATTRIBUTE_NAMES, uniqueOperationNames + "::non_unique_interface" )); //$NON-NLS-1$
	
		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { ONLY_INHERITED_FROM_ABSTRACT } )
	public void test_only_inherit_from_abstract() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::inherit"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_abstract" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_local" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_none" )); //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_abstract1" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_local1" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_none1" )); //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_abstract2" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_local2" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_ABSTRACT, packQName + "::derived_none2" )); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { ONLY_INHERITED_FROM_LOCAL } )
	public void test_only_inherit_from_local() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::inherit"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_abstract" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_local" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_none" )); //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_abstract1" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_local1" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_none1" )); //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_abstract2" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_local2" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, ONLY_INHERITED_FROM_LOCAL, packQName + "::derived_none2" )); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { UNIQUE_INHERITED_OPERAION_NAMES } )
	public void test_unique_inherited_operation_names() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::inherit"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNIQUE_INHERITED_OPERAION_NAMES, packQName + "::derived" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNIQUE_INHERITED_OPERAION_NAMES, packQName + "::derived1" )); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { DONT_OVERRIDE_FEATURE } )
	public void test_dont_override_feature() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::inherit"; //$NON-NLS-1$
		// operation and attribute
		expectedResults.add(new ExpectedResult(TestResult.FAIL, DONT_OVERRIDE_FEATURE, packQName + "::derived1" )); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, DONT_OVERRIDE_FEATURE, packQName + "::derived2" )); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { ONLY_CORBA_OPERATIONS } )
	public void test_only_corba_operations() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::CORBAModule::CORBAModule_1"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_CORBA_OPERATIONS, packQName + "::unique_interface" )); //$NON-NLS-1$
	
		// missing fail case
		
		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { ONLY_CORBA_ATTRIBUTES } )
	public void test_only_corba_attributes() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();
		
		final String IDLFILE = "CORBAInterfaceTests::IDLFile"; //$NON-NLS-1$

		final String packQName = IDLFILE + "::CORBAModule::CORBAModule_1"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_CORBA_ATTRIBUTES, packQName + "::unique_interface" )); //$NON-NLS-1$
	
		// missing fail case
		
		validateModel(VALIDATION_MODEL, IDLFILE, expectedResults);
	}
}
