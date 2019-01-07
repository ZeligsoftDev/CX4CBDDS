package com.zeligsoft.base.langc.test;

import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.Element;
import com.zeligsoft.base.langc.PrimitiveType;
import com.zeligsoft.base.langc.SizeofExpr;
import com.zeligsoft.base.langc.SizeofType;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

import junit.framework.TestCase;

@SuppressWarnings("nls")
public class Bug13926 extends TestCase {

	public void testSizeofInt() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofInt()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	public void testSizeofStruct() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofStruct()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	public void testSizeofPtr() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofPtr()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	public void testSizeofExpression() {

		SizeofExpr sizeof = LangCTestRunner.run("regression::bug13926::sizeofExpression()");
		assertNotNull(sizeof);

		// TODO this should only allow expressions that lookup something, e.g.,
		//      sizeof( *var ) and sizeof( arr[6] ) are ok, sizeof( 4 ) is not

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}
}
