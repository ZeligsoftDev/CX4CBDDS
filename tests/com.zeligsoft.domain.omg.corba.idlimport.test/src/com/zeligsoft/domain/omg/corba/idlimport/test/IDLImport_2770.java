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
 *         Summary: Operations - parameter direction Action: 1. Import artifact
 *         test1054.idl Expected Results: 1. The interface "int1054" comes into
 *         the tool with three operations each with a single parameter for the
 *         directions "in", "out", and "inout".
 */
@SuppressWarnings("nls")
public class IDLImport_2770 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test1054";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	private static final String IDL_FILE_QN = DEAULT_MODEL_NAME + "::" + IMPORTED_PACKAGE_NAME + "::" + IDL_FILE_NAME;

	private static final String INT1054_QN = IDL_FILE_QN + "::int1054";

	private static final String OPERATION_INPARAM_QN = INT1054_QN + "::inparam";

	private static final String PARAM_PAR1_QN = OPERATION_INPARAM_QN + "::par1";

	private static final String OPERATION_OUTPARAM_QN = INT1054_QN + "::outparam";

	private static final String PARAM_PAR2_QN = OPERATION_OUTPARAM_QN + "::par2";

	private static final String OPERATION_INOUTPARAM_QN = INT1054_QN + "::inoutparam";

	private static final String PARAM_PAR3_QN = OPERATION_INOUTPARAM_QN + "::par3";

	@Test
	public void test2770() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertTrue(importOk);
		//assertModelPackagedElementCount(1);

		// make sure that there is only one element under the root
		// model element
		EObject idlFile = lookup(IDL_FILE_QN);
		EObject int1054 = lookup(INT1054_QN);
		EObject inparam = lookup(OPERATION_INPARAM_QN);
		EObject par1 = lookup(PARAM_PAR1_QN);
		EObject outparam = lookup(OPERATION_OUTPARAM_QN);
		EObject par2 = lookup(PARAM_PAR2_QN);
		EObject inoutparam = lookup(OPERATION_INOUTPARAM_QN);
		EObject par3 = lookup(PARAM_PAR3_QN);

		assertIDLFile(idlFile);
		assertIDLFileMemberCount(idlFile, 1);

		assertInterfaceOperationCount(int1054, 3);
		assertOperation(inparam);
		assertOperationParamCount(inparam, 1);
		assertParameter(par1);
		assertInParameter(par1);
		assertOperation(outparam);
		assertOperationParamCount(outparam, 1);
		assertParameter(par2);
		assertOutParameter(par2);
		assertOperation(inoutparam);
		assertOperationParamCount(inoutparam, 1);
		assertParameter(par3);
		assertInOutParameter(par3);
	}
}
