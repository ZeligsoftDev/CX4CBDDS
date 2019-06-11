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
 * @author Zheng Li
 * 
 * This class would test CORBA constraints that are not interface or attribute.
 * 
 */
@ValidationTestSuite(domainModel = "pathmap://CORBA_MODEL_LIBRARIES/CORBADomain.emx")
public class CORBAOthersTests extends CORBABaseValidationTestCase {

	private static final String VALIDATION_MODEL = "/models/CORBAOthersTest.emx"; //$NON-NLS-1$
	private static final String ID_PREFIX = "com.zeligsoft.domain.omg.corba."; //$NON-NLS-1$
	private static final String SEQUENCE_MUST_HAVE_TYPE = ID_PREFIX + "CORBASequence.must_have_type"; //$NON-NLS-1$
	private static final String LEGAL_CORBA_NAME = ID_PREFIX + "CORBANamedElement.legal_corba_name"; //$NON-NLS-1$
	private static final String CONTAINED_NAME_CONSTRAINT = ID_PREFIX + "CORBANamedElement.contained_name_constraint"; //$NON-NLS-1$
	private static final String CONSTANT_TYPE_IS_PRIMITIVE = ID_PREFIX + "CORBAConstant.type_is_primitive"; //$NON-NLS-1$
	private static final String PARAMETER_TYPE_IS_SET = ID_PREFIX + "CORBATyped.parameter_type_is_set"; //$NON-NLS-1$
	private static final String UNION_MUST_HAVE_SWITCHTYPE = ID_PREFIX + "CORBAUnion.must_have_switchType"; //$NON-NLS-1$	
	private static final String ONLY_CORBA_PARAMETERS = ID_PREFIX + "CORBAOperation.only_corba_parameters"; //$NON-NLS-1$
	private static final String ARRAY_MUST_HAVE_TYPE = ID_PREFIX + "CORBAArray.must_have_type"; //$NON-NLS-1$	
	private static final String ENUM_MUST_HAVE_LITERALS = ID_PREFIX + "CORBAEnum.enumeration_must_have_literals"; //$NON-NLS-1$	
	private static final String NO_RETURN_PARAMETER = ID_PREFIX + "CORBAParameter.no_return_direction"; //$NON-NLS-1$	
	private static final String ARRAY_BOUNDS_VALUE = ID_PREFIX + "CORBAArray.bound_value_constraint"; //$NON-NLS-1$	
	private static final String FIELD_BOUNDS_VALUE = ID_PREFIX + "CORBAField.bound_value_constraint"; //$NON-NLS-1$		
	private static final String TYPEDEF_HAS_TYPE = ID_PREFIX + "CORBATypeDef.has_generalization"; //$NON-NLS-1$		
	private static final String BOUND_VALUE_CONSTRAINT = ID_PREFIX + "CORBAArray.bound_value_constraint"; //$NON-NLS-1$
	private static final String BOUND_VALUE_CONSTRAINT_FIELD = ID_PREFIX + "CORBAField.bound_value_constraint"; //$NON-NLS-1$
	private static final String CHECK_BOUND_VALUE_CONSTRAINT_SEQUENCE = ID_PREFIX + "CORBASequence.check_bound_value_constraint"; //$NON-NLS-1$
	private static final String CHECK_BOUND_VALUE_CONSTRAINT_STRING = ID_PREFIX + "CORBAString.check_bound_value_constraint"; //$NON-NLS-1$
	private static final String CHECK_BOUND_VALUE_CONSTRAINT_WSTRING = ID_PREFIX + "CORBAWString.check_bound_value_constraint"; //$NON-NLS-1$
	private static final String IDLFILE_NOT_IN_IDLFILE_OR_IDLMODULE = ID_PREFIX
			+ "IDLFile.idlfile_not_in_idlfile_or_idlmodule"; //$NON-NLS-1$
	/**
	 * constructor
	 */
	public CORBAOthersTests() {
		super();
	}

	@Test
	@ValidationUnitTest( constraintVerified = { SEQUENCE_MUST_HAVE_TYPE } )
	public void test_sequence_must_have_type() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		String packageQName = "CORBAOthersTest::sequence::CORBAInterface"; //$NON-NLS-1$
		// Interface
		expectedResults.add(new ExpectedResult(TestResult.PASS, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence_no_type")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();
		
		// Module
		packageQName = "CORBAOthersTest::sequence::CORBAModule"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence_no_type")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();
		
		// IDLFile
		packageQName = "CORBAOthersTest::sequence::IDLFile"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, SEQUENCE_MUST_HAVE_TYPE, packageQName + "::Sequence_no_type")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);	
	}	
	
	@Test
	@ValidationUnitTest( constraintVerified = { LEGAL_CORBA_NAME } )
	public void test_legal_corba_name() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::NamedElement"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc::_")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc::_::CORBAAttribute")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc::_::CORBAOperation")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc::_::CORBAOperation::CORBAParameter")); //$NON-NLS-1$
		//expectedResults.add(new ExpectedResult(TestResult.PASS, LEGAL_CORBA_NAME, packageQName + "::CORBAModule::123_abc::_::CORBAOperation::ReturnParameter")); //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, LEGAL_CORBA_NAME, packageQName + "::^InvaliadModulePack")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, LEGAL_CORBA_NAME, packageQName + "::^InvaliadModulePack::--+")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, LEGAL_CORBA_NAME, packageQName + "::^InvaliadModulePack::--+::ui?")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, LEGAL_CORBA_NAME, packageQName + "::^InvaliadModulePack::--+::C&ORBAOperation")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, LEGAL_CORBA_NAME, packageQName + "::^InvaliadModulePack::--+::C&ORBAOperation::CORBA Parameter")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { CONTAINED_NAME_CONSTRAINT } )
	public void test_contained_name_constraint() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::NamedElement"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule2")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAModule")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface::CORBAAttribute")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface::CORBAOperation")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface::CORBAOperation::CORBAParameter")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface::CORBAInterface")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAInterface::CORBAOperation::CORBAOperation")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONTAINED_NAME_CONSTRAINT, packageQName + "::containerName::CORBAModule::CORBAModule::CORBAModule::CORBAModule")); //$NON-NLS-1$
			
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { CONSTANT_TYPE_IS_PRIMITIVE } )
	public void test_constant_type_is_primitive() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::constant"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_any")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_boolean")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_char")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_double")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_float")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_long")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_longdouble")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_longlong")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_Object")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_octet")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_short")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_string")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_typecode")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_unsignedlong")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_unsignedlonglong")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_unsignedshort")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_void")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_wchar")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::primitive::CORBAConstant_wstring")); //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::non-primitive::CORBAConstant_cx")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, CONSTANT_TYPE_IS_PRIMITIVE, packageQName + "::non-primitive::CORBAConstant_no_type")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { PARAMETER_TYPE_IS_SET } )
	public void test_parameter_type_is_set() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::Parameter::CORBAInterface::CORBAOperation"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, PARAMETER_TYPE_IS_SET, packageQName + "::p1_typed")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, PARAMETER_TYPE_IS_SET, packageQName + "::p2_no_type")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}	
	
	// failed since bug#1096 is not fixed
	@Test
	@ValidationUnitTest( constraintVerified = { UNION_MUST_HAVE_SWITCHTYPE } )
	public void test_union_must_have_switchtype() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::union"; //$NON-NLS-1$
		
		// IDL File
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::IDLFile::CORBAUnion")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::IDLFile::CORBAUnion_no_switchtype")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();
		
		// Module
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::CORBAModule::CORBAUnion")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::CORBAModule::CORBAUnion_no_switchtype")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();	
		
		// Interface
		expectedResults.add(new ExpectedResult(TestResult.PASS, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::CORBAInterface::CORBAUnion")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, UNION_MUST_HAVE_SWITCHTYPE, packageQName + "::CORBAInterface::CORBAUnion_no_switchtype")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}
	
	@Test
	@ValidationUnitTest(constraintVerified = { ARRAY_MUST_HAVE_TYPE })
	public void test_array_must_have_type() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::CORBAModule"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS,
				ARRAY_MUST_HAVE_TYPE, packageQName + "::GoodArray")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				ARRAY_MUST_HAVE_TYPE, packageQName + "::BadArray")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();
	}

	@Test
	@ValidationUnitTest(constraintVerified = { ENUM_MUST_HAVE_LITERALS })
	public void test_enum_must_have_literals() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::CORBAModule"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS,
				ENUM_MUST_HAVE_LITERALS, packageQName + "::GoodEnum")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				ENUM_MUST_HAVE_LITERALS, packageQName + "::BadEnum")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
		expectedResults.clear();
	}

	@Test
	@ValidationUnitTest(constraintVerified = { NO_RETURN_PARAMETER })
	public void test_no_return_parameter() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String elementName = "CORBAOthersTest::CORBAModule::Intf::op::badParam"; //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				NO_RETURN_PARAMETER, elementName));

		validateModel(VALIDATION_MODEL, elementName, expectedResults);
		expectedResults.clear();
		return;
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { ONLY_CORBA_PARAMETERS } )
	public void test_only_corba_parameters() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::Parameter::CORBAInterface::CORBAOperation"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.PASS, ONLY_CORBA_PARAMETERS, packageQName));

		// missing fail case
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}	
	
	@Test
	@ValidationUnitTest( constraintVerified = { ARRAY_BOUNDS_VALUE } )
	public void test_array_bound() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::CX3.5_array_field_bound_typedef::IDLFile"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, ARRAY_BOUNDS_VALUE, packageQName + "::CORBAArray_nobounds"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ARRAY_BOUNDS_VALUE, packageQName + "::CORBAArray_number"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ARRAY_BOUNDS_VALUE, packageQName + "::CORBAArray_const"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, ARRAY_BOUNDS_VALUE, packageQName + "::CORBAArray_both"));  //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { FIELD_BOUNDS_VALUE } )
	public void test_field_bound() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::CX3.5_array_field_bound_typedef::IDLFile::CORBAException"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, FIELD_BOUNDS_VALUE, packageQName + "::CORBAField_nobounds"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, FIELD_BOUNDS_VALUE, packageQName + "::CORBAField_numbers"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, FIELD_BOUNDS_VALUE, packageQName + "::CORBAField_consts"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, FIELD_BOUNDS_VALUE, packageQName + "::CORBAField_consts_number_together"));  //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}	
	
	@Test
	@ValidationUnitTest( constraintVerified = { TYPEDEF_HAS_TYPE } )
	public void test_typedef() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "CORBAOthersTest::CX3.5_array_field_bound_typedef::IDLFile"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL, TYPEDEF_HAS_TYPE, packageQName + "::CORBATypeDef_notype"));  //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, TYPEDEF_HAS_TYPE, packageQName + "::CORBATypeDef"));  //$NON-NLS-1$
	
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}
	
	@Test
	@ValidationUnitTest(constraintVerified = { IDLFILE_NOT_IN_IDLFILE_OR_IDLMODULE })
	public void testIDLFileContainment() {

		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String PackageQName = "CORBAOthersTest::IDLFileContainment"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				IDLFILE_NOT_IN_IDLFILE_OR_IDLMODULE, PackageQName
						+ "::parentFile::package::failFile")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				IDLFILE_NOT_IN_IDLFILE_OR_IDLMODULE, PackageQName
						+ "::passFile")); //$NON-NLS-1$

		validateModel(VALIDATION_MODEL, PackageQName, expectedResults);
	}
	
	@Test
	@ValidationUnitTest(constraintVerified = { BOUND_VALUE_CONSTRAINT })
	public void testBoundValueConstraintAndCheckBoundValueConstraint() {

		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String PackageQName = "CORBAOthersTest::checkboundvalueconstraint::Module"; //$NON-NLS-1$

		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				BOUND_VALUE_CONSTRAINT, PackageQName
						+ "::failArray")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				BOUND_VALUE_CONSTRAINT, PackageQName
						+ "::passArray")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				BOUND_VALUE_CONSTRAINT_FIELD, PackageQName
						+ "::failstruct::failfield")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				BOUND_VALUE_CONSTRAINT_FIELD, PackageQName
						+ "::failstruct::failfield2")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				CHECK_BOUND_VALUE_CONSTRAINT_SEQUENCE, PackageQName
						+ "::failSequence")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				CHECK_BOUND_VALUE_CONSTRAINT_SEQUENCE, PackageQName
						+ "::passSequence")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				CHECK_BOUND_VALUE_CONSTRAINT_WSTRING , PackageQName
						+ "::failWstring")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				CHECK_BOUND_VALUE_CONSTRAINT_WSTRING , PackageQName
						+ "::faillwString")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL,
				CHECK_BOUND_VALUE_CONSTRAINT_STRING , PackageQName
						+ "::failString")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS,
				CHECK_BOUND_VALUE_CONSTRAINT_STRING, PackageQName
						+ "::passString")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, PackageQName, expectedResults);
	}
}
