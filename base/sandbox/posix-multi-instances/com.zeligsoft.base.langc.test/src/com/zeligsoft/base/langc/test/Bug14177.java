package com.zeligsoft.base.langc.test;

import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.AddressOfExpr;
import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.CodeBlock;
import com.zeligsoft.base.langc.DereferenceExpr;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.Function;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.Pointer;
import com.zeligsoft.base.langc.PrimitiveType;
import com.zeligsoft.base.langc.ReturnStatement;
import com.zeligsoft.base.langc.Statement;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14177 extends TestCase {

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
