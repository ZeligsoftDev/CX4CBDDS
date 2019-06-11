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
 * @author Toby McClean
 * 
 *         Summary: Operation namespace conflict Action: 1. Import artifacts
 *         test1052-1.idl, test1052-2.idl, test1052-3.idl Expected Results: 1.
 *         All imports fail due to namespace conflicts in operations in the
 *         respective interfaces. 2. Navigation is to the line with the
 *         duplicate name.
 */
@SuppressWarnings("nls")
public class IDLImport_2768 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test1052-1";

	private static final String IDL_FILE_2_NAME = "test1052-2";

	private static final String IDL_FILE_3_NAME = "test1052-3";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	private static final String IDL_FILE_2 = "idl/" + IDL_FILE_2_NAME + ".idl";

	private static final String IDL_FILE_3 = "idl/" + IDL_FILE_3_NAME + ".idl";

	public IDLImport_2768() {
		modelName = DEAULT_EMPTY_MODEL_NAME;
		modelfilePath = DEAULT_EMPTY_MODEL_FILE_PATH;
	}

	public void test2768_1() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertFalse(importOk);
		assertModelPackagedElementCount(0);
	}

	public void test2768_2() {
		boolean importOk = importIDL(IDL_FILE_2);

		// make sure that there were no issues
		assertFalse(importOk);
		assertModelPackagedElementCount(0);
	}

	public void test2768_3() {
		boolean importOk = importIDL(IDL_FILE_3);

		// make sure that there were no issues
		assertFalse(importOk);
		assertModelPackagedElementCount(0);
	}
}
