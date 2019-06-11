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

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * @author Toby McClean
 * 
 *         Summary: Operations - parameter direction not specified Action: 1.
 *         Import artifact test1055.idl Expected Results: 1. Import fails
 *         because of an operation containing a parameter with direction not
 *         specified. Navigation is to the line with the operation.
 */
@SuppressWarnings("nls")
public class IDLImport_Bug395 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test_bug395";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	@Test
	public void test2771() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertTrue(importOk);
		
		String qualifiedPath = modelName + "::" + IMPORTED_PACKAGE_NAME + "::" + IDL_FILE_NAME;
		
		// find all of the elements that were supposed to be created
		// during the import action
		String definitionA = qualifiedPath.concat("::structDefinitionA");
		String definitionB = qualifiedPath.concat("::structDefinitionB");

		EObject structDefinitionA = lookup(definitionA);
/*		EObject fieldA1 = lookup(definitionA + "::fieldA1");
		EObject fieldA2 = lookup(definitionA + "::fieldA2");
		EObject fieldA3 = lookup(definitionA + "::fieldA3");
		EObject fieldA4 = lookup(definitionA + "::fieldA4");*/
		
		EObject structDefinitionB = lookup(definitionB);
		EObject fieldB1 = lookup(definitionB + "::fieldB1");
		EObject fieldB2 = lookup(definitionB + "::fieldB2");
	
	
		assertStruct(structDefinitionB);
		assertField(fieldB1);
		assertField(fieldB2);
		assertFieldType(fieldB2, structDefinitionA);
		
		String bound = (String)ZDLUtil.getValue(fieldB2, CORBADomainNames.CORBAFIELD, CORBADomainNames.CORBABOUNDED__BOUND);
		// ensure that the bound on fieldB2 is "6"
		assertEquals("6", bound);
		
	}
}
