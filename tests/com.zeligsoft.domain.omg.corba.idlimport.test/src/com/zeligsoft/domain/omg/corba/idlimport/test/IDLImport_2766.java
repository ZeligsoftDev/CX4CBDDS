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
import org.junit.Test;

/**
 * @author Toby McClean
 * 
 *         Summary: Operation with exception - not found Action: 1. Import
 *         artifact test1050.idl Expected Results: 1. Import fails because all
 *         operations in the interface "int1050" raise exceptions with names
 *         that cannot be resolved.
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2766 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test1050";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	public IDLImport_2766() {
		modelName = DEAULT_EMPTY_MODEL_NAME;
		modelfilePath = DEAULT_EMPTY_MODEL_FILE_PATH;
	}

	@Test
	public void test2766() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertFalse(importOk);
		assertModelPackagedElementCount(0);
	}
}
