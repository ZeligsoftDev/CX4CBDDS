package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.PrimitiveType;
import com.zeligsoft.cx.langc.SizeofExpr;
import com.zeligsoft.cx.langc.SizeofType;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug13926 {

	@Test
	public void testSizeofInt() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofInt()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	@Test
	public void testSizeofStruct() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofStruct()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	@Test
	public void testSizeofPtr() {

		SizeofType sizeof = LangCTestRunner.run("regression::bug13926::sizeofPtr()");
		assertNotNull(sizeof);

		Element typeofExpr = sizeof.getType().getElement();
		assertTrue( typeofExpr instanceof BuiltInType );
		BuiltInType builtInTypeofExpr = (BuiltInType)typeofExpr;
		assertEquals( PrimitiveType.INT32, builtInTypeofExpr.getType() );
	}

	@Test
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
