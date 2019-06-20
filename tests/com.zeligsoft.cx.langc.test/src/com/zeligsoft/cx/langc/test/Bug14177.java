package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.zeligsoft.cx.langc.AddressOfExpr;
import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.CodeBlock;
import com.zeligsoft.cx.langc.DereferenceExpr;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.Pointer;
import com.zeligsoft.cx.langc.PrimitiveType;
import com.zeligsoft.cx.langc.ReturnStatement;
import com.zeligsoft.cx.langc.Statement;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14177 {

	@Test
	public void testAddressOfInt() {
		Function func = LangCTestRunner.run("regression::bug14177::testAddressOfInt()");
		assertNotNull(func);

		FunctionImplementation impl = func.getDefaultImpl();
		assertNotNull( impl );

		CodeBlock body = impl.getBody();
		assertNotNull( body );

		EList<Statement> stmts = body.getStatements();
		assertEquals( 1, stmts.size() );

		Statement stmt = stmts.get( 0 );
		assertTrue( stmt instanceof ReturnStatement );
		ReturnStatement retStmt = (ReturnStatement)stmt;

		Expression expr = retStmt.getExpr();
		assertTrue( expr instanceof AddressOfExpr );
		AddressOfExpr addrOf = (AddressOfExpr)expr;

		ElementReference type = addrOf.getType();
		assertNotNull( type );

		EList<Pointer> ptrSpec = type.getPointerSpec();
		assertEquals( 1, ptrSpec.size() );
		assertEquals( Pointer.POINTER, ptrSpec.get( 0 ) );
		assertTrue( type.getElement() instanceof BuiltInType );
		BuiltInType builtIn = (BuiltInType)type.getElement();

		assertEquals( PrimitiveType.INT32, builtIn.getType() );
	}

	@Test
	public void testDereferencePtr() {
		DereferenceExpr deref = LangCTestRunner.run("regression::bug14177::testDereferencePtr()");
		assertNotNull(deref);

		ElementReference type = deref.getType();
		assertNotNull( type );

		EList<Pointer> ptrSpec = type.getPointerSpec();
		assertEquals( 0, ptrSpec.size() );
		assertTrue( type.getElement() instanceof BuiltInType );
		BuiltInType builtIn = (BuiltInType)type.getElement();

		assertEquals( PrimitiveType.INT32, builtIn.getType() );
	}
}
