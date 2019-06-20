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
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

/**
 * Duplicate interface name already in the tool, but in different scope, does
 * not block import.
 * 
 * @author Toby McClean
 * 
 */
@SuppressWarnings("nls")
public class IDLImport_2730 extends IDLImportTestCase {

	@Test
	public void test2730() {
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/interface.idl");
		idlFiles.add("idl/interface-module2.idl");

		final boolean importOk = importIDL(idlFiles);

		// make sure that there were no issues
		assertTrue(importOk);

		// make sure that there is only two elements under the root
		// model element
		assertTrue(this.model.getPackagedElements().size() == 2);

		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME;

		// find all of the elements that were supposed to be created
		// during the import action
		String interface1 = qualifiedPath.concat("::interface"); // ::interface

		EObject idlFileElement = lookup(interface1);
		EObject intfGlobal = lookup(interface1 + "::intfGlobal");
		EObject junkmodule = lookup(interface1 + "::junkmodule");
		EObject intfB = lookup(interface1 + "::junkmodule::intfB");
		EObject intfA = lookup(interface1 + "::junkmodule::intfA");

		String interface2 = qualifiedPath.concat("::interface-module2"); // ::interface-module2
		EObject idlFileElement2 = this.lookup(interface2);
		EObject intfGlobal2 = lookup(interface2 + "::intfGlobal");
		EObject junkmodule2 = lookup(interface2 + "::junkmodule2");
		EObject intfB2 = lookup(interface2 + "::junkmodule2::intfB");
		EObject intfA2 = lookup(interface2 + "::junkmodule2::intfA");

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

		assertIDLFile(idlFileElement2);
		assertInterface(intfGlobal2);
		assertInterfaceHasNoFeatures(intfGlobal2);
		assertGeneralizationCount(intfGlobal2, 0);
		assertModule(junkmodule2);
		assertModuleMemberCount(junkmodule2, 2);
		assertInterface(intfB2);
		assertInterfaceHasNoFeatures(intfB2);
		assertGeneralizationCount(intfB2, 0);
		assertInterface(intfA2);
		assertInterfaceHasNoFeatures(intfA2);
		assertGeneralizationCount(intfA2, 1);
		assertGeneralization(intfA2, intfB2);
	}
}
