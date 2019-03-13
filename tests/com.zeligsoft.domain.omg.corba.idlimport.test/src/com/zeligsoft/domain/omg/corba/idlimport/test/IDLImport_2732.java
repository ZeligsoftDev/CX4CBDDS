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

/**
 * Unresolved forward declaration
 * 
 * Expected Results:
 * 
 * 1. Import of test21.idl fails because there is a forward declaration of an
 * interface that is not defined later in the file. 2. Import of test23.idl
 * fails because there is a forward declaration of an interface that is not
 * defined later in the file. 3. Import of test24.idl fails because there is a
 * forward declaration of an interface that is not defined in the current scope
 * later in the file. 4. Navigation for all three files is to the line
 * containing the unsatisfied forward declaration.
 * 
 * @author Toby McClean
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2732 extends IDLImportTestCase {

	public void test2732__test21_idl() {
		String idlFile = "idl/test21.idl";
		final boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue("Expecting for the test to complete ok, with an error in the issues.",
				importOk);
	}

	public void test2732__test24_idl() {
		String idlFile = "idl/test24.idl";
		final boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue("Expecting for the test to complete ok, with an error in the issues.",
				importOk);
	}

	public void test2732__test23_idl() {
		String idlFile = "idl/test23.idl";
		final boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue("Expecting for the test to complete ok, with an error in the issues.",
				importOk);

		assertTrue(String.format(
				"Expecting the model to be empty but it contains %s packaged elements.",
				model.getPackagedElements().size()),
				model.getPackagedElements().size() == 0);
	}
}
