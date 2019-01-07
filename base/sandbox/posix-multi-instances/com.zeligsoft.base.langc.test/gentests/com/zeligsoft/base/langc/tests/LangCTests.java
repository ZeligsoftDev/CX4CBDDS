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

package com.zeligsoft.base.langc.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>langc</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("nls")
public class LangCTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new LangCTests("langc Tests");
		suite.addTestSuite(ExpressionTest.class);
		suite.addTestSuite(FunctionCallTest.class);
		suite.addTestSuite(ElementAccessTest.class);
		suite.addTestSuite(IntegralLiteralTest.class);
		suite.addTestSuite(CharacterLiteralTest.class);
		suite.addTestSuite(FloatingLiteralTest.class);
		suite.addTestSuite(BinaryOperationTest.class);
		suite.addTestSuite(FunctionAddressTest.class);
		suite.addTestSuite(MemberAccessTest.class);
		suite.addTestSuite(ExpressionBlobTest.class);
		suite.addTestSuite(CastExprTest.class);
		suite.addTestSuite(SizeofTypeTest.class);
		suite.addTestSuite(AddressOfExprTest.class);
		suite.addTestSuite(DereferenceExprTest.class);
		suite.addTestSuite(StringLiteralTest.class);
		suite.addTestSuite(BlockInitializerTest.class);
		suite.addTestSuite(IndexExprTest.class);
		suite.addTestSuite(LogicalComparisonTest.class);
		suite.addTestSuite(SizeofExprTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LangCTests(String name) {
		super(name);
	}

} //LangCTests
