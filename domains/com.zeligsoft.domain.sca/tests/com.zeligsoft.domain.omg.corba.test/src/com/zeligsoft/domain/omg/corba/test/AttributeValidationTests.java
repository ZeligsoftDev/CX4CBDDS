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
@ValidationTestSuite(domainModel = "pathmap://CORBA_MODEL_LIBRARIES/CORBADomain.emx")
public class AttributeValidationTests extends CORBABaseValidationTestCase {

	private static final String VALIDATION_MODEL = "/models/AttributeTypeSetValidation.emx"; //$NON-NLS-1$
	private static final String ID_PREFIX = "com.zeligsoft.domain.omg.corba."; //$NON-NLS-1$
	private static final String READ_ONLY_EXCEPTIONS = ID_PREFIX + "CORBAAttribute.read_only_exceptions"; //$NON-NLS-1$

	/**
	 * constructor
	 */
	public AttributeValidationTests() {
		super();
	}
	
	@Test
	@ValidationUnitTest( constraintVerified = { READ_ONLY_EXCEPTIONS } )
	public void test_read_only_exceptions() {
		ArrayList<ExpectedResult> expectedResults = new ArrayList<ExpectedResult>();

		final String packageQName = "AttributeTypeSetValidation::readonly::CORBAInterface"; //$NON-NLS-1$
		
		expectedResults.add(new ExpectedResult(TestResult.PASS, READ_ONLY_EXCEPTIONS, packageQName + "::nonreadonly_setraise")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.PASS, READ_ONLY_EXCEPTIONS, packageQName + "::readonly_nosetraise")); //$NON-NLS-1$
		expectedResults.add(new ExpectedResult(TestResult.FAIL, READ_ONLY_EXCEPTIONS, packageQName + "::readonly_setraise")); //$NON-NLS-1$
		
		validateModel(VALIDATION_MODEL, packageQName, expectedResults);
	}	
	
}
