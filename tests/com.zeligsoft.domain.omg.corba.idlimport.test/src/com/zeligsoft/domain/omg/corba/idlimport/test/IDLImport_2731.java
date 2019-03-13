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
 * 
 * Import an IDL file containing three trivial interfaces.
 * 
 * Expected Results:
 * 
 * 1. Import proceeds without errors or warnings. 2. Three interfaces are
 * brought into the tool. 3. The repository IDs of the interfaces reflect their
 * origin in the global scope or module as appropriate. 4. The interface
 * properties display "false" for Abstract and Local. 5. For the two interfaces
 * in the module, the inheritance structure below is preserved in the tool
 * (verify in properties):
 * 
 * module junkmodule { interface intfB { };
 * 
 * interface intfA: intfB { }; };
 * 
 * @author Toby McClean
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2731 extends IDLImportTestCase {

	@Test
	public void testTrivialInterfaces() {
		String idlFile = "idl/interface.idl";
		final boolean importOk = importIDL(idlFile);

		// make sure that there were no issues
		assertTrue(importOk);
		// find all of the elements that were supposed to be created
		// during the import action
		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		EObject idlFileElement = this.lookup(qualifiedPath + "::interface");
		EObject intfGlobal = lookup(qualifiedPath + "::interface::intfGlobal");
		EObject junkmodule = lookup(qualifiedPath + "::interface::junkmodule");
		EObject intfB = lookup(qualifiedPath + "::interface::junkmodule::intfB");
		EObject intfA = lookup(qualifiedPath + "::interface::junkmodule::intfA");

		// verify that all of the elements that were supposed to be created
		// are in fact created and constructed correctly
		assertIDLFile(idlFileElement);
		assertInterface(intfGlobal);
		assertInterfaceHasNoFeatures(intfGlobal);
		assertGeneralizationCount(intfGlobal, 0);
		assertModule(junkmodule);
		assertModuleMemberCount(junkmodule, 2);
		assertInterface(intfB);
		assertInterfaceHasNoFeatures(intfB);
		assertGeneralizationCount(intfB, 0);
		assertInterface(intfA);
		assertInterfaceHasNoFeatures(intfA);
		assertGeneralizationCount(intfA, 1);
		assertGeneralization(intfA, intfB);

	}
}
