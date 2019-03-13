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
 *         Summary: Inheritance in another module with relative scope lookup
 *         Action: 1. Import artifact: test29-b.idl Expected Results: 1. Import
 *         is successful. Interface E is brought into the tool inheriting from
 *         interface C.
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2735 extends IDLImportTestCase {

	private static final String IDL_FILE = "idl/test29-b.idl";

	private static final String IDL_FILE_QN = DEAULT_MODEL_NAME + "::" + IMPORTED_PACKAGE_NAME + "::test29-b";

	private static final String MODULE_A_QN = IDL_FILE_QN + "::A";

	private static final String MODULE_B_QN = MODULE_A_QN + "::B";

	private static final String INTERFACE_C_QN = MODULE_B_QN + "::C";

	private static final String MODULE_D_QN = MODULE_A_QN + "::D";

	private static final String INTERFACE_E_QN = MODULE_D_QN + "::E";

	/**
	 * 
	 */

	@Test
	public void test2735() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertTrue(importOk);

		// make sure that there is only one element under the root
		// model element
		EObject idlFile = lookup(IDL_FILE_QN);
		EObject moduleA = lookup(MODULE_A_QN);
		EObject moduleB = lookup(MODULE_B_QN);
		EObject moduleD = lookup(MODULE_D_QN);
		EObject interfaceC = lookup(INTERFACE_C_QN);
		EObject interfaceE = lookup(INTERFACE_E_QN);

		assertIDLFile(idlFile);
		assertIDLFileMemberCount(idlFile, 1);

		assertModule(moduleA);
		assertModuleMemberCount(moduleA, 2);
		assertModule(moduleB);
		assertModuleMemberCount(moduleB, 1);
		assertModule(moduleD);
		assertModuleMemberCount(moduleD, 1);

		assertInterface(interfaceC);
		assertInterfaceHasNoFeatures(interfaceC);

		assertInterface(interfaceE);
		assertInterfaceHasNoFeatures(interfaceE);

		assertGeneralization(interfaceE, interfaceC);
		assertGeneralizationCount(interfaceE, 1);
		assertGeneralizationCount(interfaceC, 0);
	}
}
