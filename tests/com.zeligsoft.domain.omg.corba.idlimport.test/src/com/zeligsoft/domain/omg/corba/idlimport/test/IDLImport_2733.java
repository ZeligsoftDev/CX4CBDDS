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
 * Resolved forward declaration
 * 
 * Action: 1. Import artifact: test22.idl. It contains a forward declaration of
 * an interface that is defined later in the global scope, and a forward
 * declaration of an interface that is defined later in the module of the
 * declaration. In order to test namespacing, the same names have been used for
 * interfaces, relying on correct scope lookup to make everything work.
 * 
 * Expected Results:
 * 
 * 1. Import succeeds and all four interfaces are brought into the tool. 2. Each
 * of the deriving interfaces correctly identifies the interface it inherits
 * from; the global interface from the other global interface, the module
 * interface from the other module interface. 3. Open the file in the import UI.
 * Note that the forward declaration was allowed to be entered numerous times.
 * 
 * @author Toby McClean
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2733 extends IDLImportTestCase {

	private static final String IDL_FILE = "idl/test22.idl";

	private static final String MODEL_NAME = "IDLImport_2733";

	private static final String IDL_FILE_QUALIFIED_NAME = MODEL_NAME + "::test22";

	private static final String MODULEA_QUALIFIED_NAME = IDL_FILE_QUALIFIED_NAME + "::A";

	private static final String INTFA_QUALIFIED_NAME = MODULEA_QUALIFIED_NAME + "::intfA";

	private static final String INTFB_QUALIFIED_NAME = MODULEA_QUALIFIED_NAME + "::intfB";

	@Test
	public void test2733() {
		String idlFile = IDL_FILE;

		final boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue(importOk);

		// make sure that there is only one element under the root
		// model element
		assertModelPackagedElementCount(1);

		// verify that the structure of the created model is correct

		EObject moduleA = lookup(MODULEA_QUALIFIED_NAME);
		EObject intfB = lookup(INTFB_QUALIFIED_NAME);
		EObject intfA = lookup(INTFA_QUALIFIED_NAME);

		assertModule(moduleA);
		assertModelPackagedElementCount(2);

		assertInterface(intfB);
		assertInterfaceHasNoFeatures(intfB);

		assertInterface(intfA);
		assertInterfaceHasNoFeatures(intfA);

		assertGeneralization(intfA, intfB);
		assertGeneralizationCount(intfA, 1);
		assertGeneralizationCount(intfB, 0);
	}
}
