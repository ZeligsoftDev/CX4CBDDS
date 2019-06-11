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
package com.zeligsoft.domain.omg.corba.idlimport.test;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

/**
 * @author Toby McClean
 * 
 *         Summary: Operation with exception - positive Action: 1. Import
 *         artifact test1049.idl Expected Results: 1. Interface "int1049" comes
 *         into the tool with an operation raising a single exception and an
 *         operation raising two exceptions.
 */
@SuppressWarnings("nls")
public class IDLImport_2765 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test1049";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	private static final String IDL_FILE_QN = DEAULT_MODEL_NAME + "::" + IMPORTED_PACKAGE_NAME + "::" + IDL_FILE_NAME;

	private static final String GLOBAL_EXCEPTION_QN = IDL_FILE_QN + "::GlobalException";

	private static final String INT1049_QN = IDL_FILE_QN + "::int1049";

	private static final String EXCEPTION1_QN = INT1049_QN + "::Exception1";

	private static final String FUNC1_QN = INT1049_QN + "::func1";

	private static final String FUNC2_QN = INT1049_QN + "::func2";

	@Test
	public void test2765() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertTrue(importOk);
		//assertModelPackagedElementCount(1);

		// make sure that there is only one element under the root
		// model element
		EObject idlFile = lookup(IDL_FILE_QN);
		EObject globalException = lookup(GLOBAL_EXCEPTION_QN);
		EObject int1049 = lookup(INT1049_QN);
		EObject exception1 = lookup(EXCEPTION1_QN);
		EObject func1 = lookup(FUNC1_QN);
		EObject func2 = lookup(FUNC2_QN);

		assertIDLFile(idlFile);
		assertIDLFileMemberCount(idlFile, 2);

		assertException(globalException);
		assertException(exception1);

		assertInterface(int1049);
		assertInterfaceOperationCount(int1049, 2);

		assertOperation(func1);
		assertOperationParamCount(func1, 0);
		assertOperationIsNotOneway(func1);
		assertOperation(func2);
		assertOperationParamCount(func2, 0);
		assertOperationIsNotOneway(func2);

		assertOperationRaises(func1, exception1);
		assertOperationRaises(func2, exception1);
		assertOperationRaises(func2, globalException);

		assertOperationRaisesCount(func1, 1);
		assertOperationRaisesCount(func2, 2);
	}
}
