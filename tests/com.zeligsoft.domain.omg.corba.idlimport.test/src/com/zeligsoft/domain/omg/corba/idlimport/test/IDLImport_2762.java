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
 *         Summary: Operations - typedef complex return types Action: 1. Import
 *         artifact test1046.idl Expected Results: 1. The interface "int1046"
 *         comes into the tool with four operations, each with a different
 *         return type. The type field of each operation is the assigned name of
 *         the complex type (StructType, UnionType), while the base type field
 *         is set to the IDL keyword representing the complex type (struct,
 *         enum, union). No typedef information is brought into the tool.
 */
@SuppressWarnings("nls")
public class IDLImport_2762 extends IDLImportTestCase {

	private static final String IDL_FILE_NAME = "test1046";

	private static final String IDL_FILE = "idl/" + IDL_FILE_NAME + ".idl";

	private static final String IDL_FILE_QN = DEAULT_MODEL_NAME + "::" + IMPORTED_PACKAGE_NAME + "::" + IDL_FILE_NAME;

	private static final String INT1046_QN = IDL_FILE_QN + "::int1046";

	private static final String STRUCTTYPE_QN = INT1046_QN + "::StructType";

	private static final String ENUMTYPE_QN = INT1046_QN + "::EnumType";

	private static final String UNIONTYPE_QN = INT1046_QN + "::UnionType";

	private static final String STRUCTTYPETYPE_QN = INT1046_QN + "::StructTypeType";

	private static final String ENUMTYPETYPE_QN = INT1046_QN + "::EnumTypeType";

	private static final String UNIONTYPETYPE_QN = INT1046_QN + "::UnionTypeType";

	private static final String UNIONTYPETYPETYPE_QN = INT1046_QN + "::UnionTypeTypeType";

	private static final String RETURNSTRUCT_QN = INT1046_QN + "::returnStruct";

	private static final String RETURNENUM_QN = INT1046_QN + "::returnEnum";

	private static final String RETURNUNION_QN = INT1046_QN + "::returnUnion";

	private static final String RETURNUNION2_QN = INT1046_QN + "::returnUnion2";

	@Test
	public void test2762() {
		boolean importOk = importIDL(IDL_FILE);

		// make sure that there were no issues
		assertTrue(importOk);
		//assertModelPackagedElementCount(1);

		// make sure that there is only one element under the root
		// model element
		EObject idlFile = lookup(IDL_FILE_QN);
		EObject int1046 = lookup(INT1046_QN);
		EObject enumType = lookup(ENUMTYPE_QN);
		EObject unionType = lookup(UNIONTYPE_QN);
		EObject structType = lookup(STRUCTTYPE_QN);
		EObject enumTypeType = lookup(ENUMTYPETYPE_QN);
		EObject unionTypeType = lookup(UNIONTYPETYPE_QN);
		EObject structTypeType = lookup(STRUCTTYPETYPE_QN);
		EObject unionTypeTypeType = lookup(UNIONTYPETYPETYPE_QN);
		EObject returnStruct = lookup(RETURNSTRUCT_QN);
		EObject returnEnum = lookup(RETURNENUM_QN);
		EObject returnUnion = lookup(RETURNUNION_QN);
		EObject returnUnion2 = lookup(RETURNUNION2_QN);

		assertIDLFile(idlFile);
		assertIDLFileMemberCount(idlFile, 1);

		assertInterface(int1046);
		assertEnum(enumType);
		assertEnumLiteralCount(enumType, 1);
		assertUnion(unionType);
		assertUnionFieldCount(unionType, 2);
		assertStruct(structType);
		assertStructFieldCount(structType, 1);

		assertTypedef(enumTypeType);
		assertTypedef(unionTypeType);
		assertTypedef(structTypeType);
		assertTypedef(unionTypeTypeType);

		assertOperation(returnStruct);
		assertOperationReturnType(returnStruct, structTypeType);
		assertOperation(returnEnum);
		assertOperationReturnType(returnEnum, enumTypeType);
		assertOperation(returnUnion);
		assertOperationReturnType(returnUnion, unionTypeType);
		assertOperation(returnUnion2);
		assertOperationReturnType(returnUnion2, unionTypeTypeType);
	}
}
