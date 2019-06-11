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
package com.zeligsoft.cx.langc.test;



import static org.junit.Assert.*;

import org.junit.Test;

import com.zeligsoft.cx.langc.BindableValue;
import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.CodeBlock;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.Name;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.Pointer;
import com.zeligsoft.cx.langc.PrimitiveType;
import com.zeligsoft.cx.langc.Struct;
import com.zeligsoft.cx.langc.VariableDeclaration;
import com.zeligsoft.cx.langc.VariableDeclarationStatement;
import com.zeligsoft.cx.langc.WhileStatement;
import com.zeligsoft.cx.langc.util.Namespace;

@SuppressWarnings("nls")
public class NamespaceTests  {

	private static final BuiltInType builtInInt = LangCFactory.eINSTANCE.createBuiltInType();
	private static final ElementReference Int32 =  LangCFactory.eINSTANCE.createElementReference();
	static {
		builtInInt.setType(PrimitiveType.INT32);
		Int32.setElement(builtInInt);
	}

	private static FileName filename(String identifier) {
		FileName name = LangCFactory.eINSTANCE.createFileName();
		name.setName(identifier);
		return name;
	}

	private static Name name(String identifier) {
		Name name = LangCFactory.eINSTANCE.createName();
		name.setName(identifier);
		return name;
	}

	private static Name name(Name parent, String identifier) {
		Name name = LangCFactory.eINSTANCE.createName();
		name.setParent(parent);
		name.setName(identifier);
		return name;
	}

	@Test
	public void testBindingAndLookup() {
		Namespace.reset();

		FileName fileName = filename("root");
		Name struct1Name = name(fileName, "struct1");
		Name struct2Name = name(fileName, "struct2");
		Name struct2fieldaName = name(struct2Name, "field2a");
		Name struct2fieldbName = name(struct2Name, "field2b");
		Name unboundName = name(struct2Name, "field2c");

		ElementList file = LangCFactory.eINSTANCE.createElementList();
		file.setName(fileName);

		Struct struct1 = LangCFactory.eINSTANCE.createStruct();
		struct1.setName(struct1Name);
		Namespace.bind(struct1Name, struct1);

		BuiltInType builtInInt = LangCFactory.eINSTANCE.createBuiltInType();
		builtInInt.setType(PrimitiveType.INT32);

		ElementReference intRef = LangCFactory.eINSTANCE.createElementReference();
		intRef.setElement(builtInInt);

		ElementReference intPtrRef = LangCFactory.eINSTANCE.createElementReference();
		intRef.getPointerSpec().add(Pointer.POINTER);
		intRef.setElement(builtInInt);

		NamedReference field2a = LangCFactory.eINSTANCE.createNamedReference();
		field2a.setType(intRef);
		field2a.setName(struct2fieldaName);
		Namespace.bind(struct2fieldaName, field2a.getType());

		NamedReference field2b = LangCFactory.eINSTANCE.createNamedReference();
		field2b.setType(intPtrRef);
		field2b.setName(struct2fieldbName);
		Namespace.bind(struct2Name, "field2b", field2b.getType());

		Struct struct2 = LangCFactory.eINSTANCE.createStruct();
		struct2.setName(struct2Name);
		Namespace.bind(fileName, struct2Name.getName(), struct2);

		BindableValue value1 = Namespace.lookup(fileName, struct1Name.getName());
		assertNotNull(value1);
		assertEquals(struct1, value1);

		BindableValue value2 = Namespace.lookup(fileName, struct2Name.getName());
		assertNotNull(value2);
		assertEquals(struct2, value2);

		BindableValue value2a = Namespace.lookup(struct2Name, struct2fieldaName.getName());
		assertNotNull(value2a);
		assertEquals(field2a.getType(), value2a);

		BindableValue value2b = Namespace.lookup(struct2fieldbName);
		assertNotNull(value2b);
		assertEquals(field2b.getType(), value2b);

		BindableValue unboundValue = Namespace.lookup(unboundName);
		assertNull(unboundValue);
	}

	@Test
	public void testVarBinding() {
		Namespace.reset();

		Name filename = name( "bug14296" );
		Name structName = name( filename, "AType" );
		Name fieldName = name( structName, "field" );
		Name functionName = name( filename, "function" );

	    //let v = variable( struct().ptr(), 'varName', NULL() ) :
		NamedReference member = LangCFactory.eINSTANCE.createNamedReference();
		member.setType(Int32);
		member.setName(fieldName);

		Struct struct = LangCFactory.eINSTANCE.createStruct();
		struct.setName(structName);
		struct.getMembers().add(member);
		Namespace.bind(fieldName, member.getType());
		Namespace.bind(structName, struct);

		ElementReference structPtr = LangCFactory.eINSTANCE.createElementReference();
		structPtr.setElement(struct);
		structPtr.getPointerSpec().add(Pointer.POINTER);

		Name varName1 = LangCFactory.eINSTANCE.createName();
		varName1.setName( "varName1" );
		VariableDeclaration v1 = LangCFactory.eINSTANCE.createVariableDeclaration();
		v1.setElement(structPtr);
		v1.setName(varName1);
		Namespace.bind(varName1, v1);

		Name varName2 = LangCFactory.eINSTANCE.createName();
		varName2.setName( "varName2" );
		VariableDeclaration v2 = LangCFactory.eINSTANCE.createVariableDeclaration();
		v2.setElement(structPtr);
		v2.setName(varName2);
		Namespace.bind(varName2, v2);

		// let f = function( int32(), functionName() ) :
		Function f = LangCFactory.eINSTANCE.createFunction();
		f.setReturnType(Int32);
		f.setName(functionName);
		Namespace.bind(functionName, f);

		FunctionImplementation impl = LangCFactory.eINSTANCE.createFunctionImplementation();
		f.setDefaultImpl(impl);

		CodeBlock fBody = LangCFactory.eINSTANCE.createCodeBlock();
		impl.setBody(fBody);

		VariableDeclarationStatement v1Stmt = LangCFactory.eINSTANCE.createVariableDeclarationStatement();
		v1Stmt.setVariable(v1);
		fBody.getStatements().add(v1Stmt);
		Namespace.rebind(varName1, functionName, v1);

		WhileStatement whileStmt = LangCFactory.eINSTANCE.createWhileStatement();
		fBody.getStatements().add(whileStmt);

		VariableDeclarationStatement v2Stmt = LangCFactory.eINSTANCE.createVariableDeclarationStatement();
		v2Stmt.setVariable(v2);
		whileStmt.getStatements().add(v2Stmt);

		// TODO complete this test and use for the lookup reimplementation
		// ...

/*
Binding 'AType' within 'bug14296'
Binding 'varName1' within '<null>'
Binding 'varName2' within '<null>'
Binding 'function' within 'bug14296'
Rebinding 'varName1' within 'bug14296::function'
Binding 'varName1' within 'bug14296::function'

Binding 'AType' within 'bug14296'
Binding 'varName1' within '<null>'
Binding 'varName2' within '<null>'
Binding 'function' within 'bug14296'
Rebinding 'varName1' within 'bug14296::function'
Binding 'varName1' within 'bug14296::function'
Lookup 'field' within 'bug14296::AType'
Lookup 'field' within 'bug14296::AType'

 */
	}
}

/*
create ElementList lookupFieldInWhile() :
    setName( filename() )
 -> addElement( struct() )
;

private cached Struct struct() :
    let s = struct( structName() ) :
        s.addMember( int32(), fieldName() )
     -> s
;

ElementReference accessInWhile() :
    let v = variable( struct().ptr(), 'varName', NULL() ) :
    let f = function( int32(), functionName() ) :
    let w = while( 1.literal() ) :
        f.addStatement( w )
     -> f.addStatement( v )
     -> v.name.field( fieldName() ).type
;
*/
