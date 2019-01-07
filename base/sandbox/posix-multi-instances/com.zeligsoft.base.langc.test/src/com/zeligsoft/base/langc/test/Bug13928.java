package com.zeligsoft.base.langc.test;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.CodeBlock;
import com.zeligsoft.base.langc.ElementAccess;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.ExpressionStatement;
import com.zeligsoft.base.langc.Function;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.MemberAccess;
import com.zeligsoft.base.langc.Name;
import com.zeligsoft.base.langc.Statement;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug13928 extends TestCase {

	public void testSimpleVariables() {

		ElementList elementList = LangCTestRunner.run("regression::bug13928::simpleVariables()");
		assertNotNull(elementList);

		assertNotNull(elementList.getElements());
		assertEquals(3, elementList.getElements().size());

		assertTrue( elementList.getElements().get( 0 ) instanceof VariableDeclaration );
		VariableDeclaration var1 = (VariableDeclaration)elementList.getElements().get( 0 );
		assertNotNull( var1 );

		Name var1Name = var1.getName();
		assertNotNull( var1Name );

		assertTrue( elementList.getElements().get( 1 ) instanceof VariableDeclaration );
		VariableDeclaration var2 = (VariableDeclaration)elementList.getElements().get( 1 );
		assertNotNull( var2 );

		Name var2Name = var2.getName();
		assertNotNull( var2Name );

		assertEquals( var1Name.getParent(), var2Name.getParent() );

		ElementReference type1 = var1.getElement();
		ElementReference type2 = var2.getElement();

		assertEquals( type1.getElement(), type2.getElement() );
	}

	public void testCreateVariables() {

		ElementList elementList = LangCTestRunner.run("regression::bug13928::createVariables()");
		assertNotNull(elementList);

		assertNotNull(elementList.getElements());
		assertEquals(4, elementList.getElements().size());
	}

	public void testCreateFunctions() {

		ElementList elementList = LangCTestRunner.run("regression::bug13928::createFunctions()");
		assertNotNull(elementList);

		assertNotNull(elementList.getElements());
		assertEquals(4, elementList.getElements().size());
	}

	public void testCreateStructs() {

		ElementList elementList = LangCTestRunner.run("regression::bug13928::createStructs()");
		assertNotNull(elementList);

		assertNotNull(elementList.getElements());
		assertEquals(4, elementList.getElements().size());
	}

	public void testSimpleAccess() {

		ElementList elementList = LangCTestRunner.run("regression::bug13928::simpleAccess()");
		assertNotNull(elementList);

		assertNotNull(elementList.getElements());
		assertTrue(elementList.getElements().size() >= 3);

		assertTrue( elementList.getElements().get( 1 ) instanceof VariableDeclaration );
		VariableDeclaration var1 = (VariableDeclaration)elementList.getElements().get( 1 );
		assertNotNull( var1 );

		Name var1Name = var1.getName();
		assertNotNull( var1Name );

		assertTrue( elementList.getElements().get( 2 ) instanceof VariableDeclaration );
		VariableDeclaration var2 = (VariableDeclaration)elementList.getElements().get( 2 );
		assertNotNull( var2 );

		Name var2Name = var2.getName();
		assertNotNull( var2Name );

		assertTrue( elementList.getElements().get( 3 ) instanceof Function );
		Function function = (Function)elementList.getElements().get( 3 );
		assertNotNull( function );

		// impl is expected to be null, since the body was added to the ElementList
		FunctionImplementation impl = function.getDefaultImpl();
		assertNull( impl );

		impl = (FunctionImplementation)elementList.getElements().get( 4 );
		assertNotNull( impl );

		CodeBlock body = impl.getBody();
		assertNotNull( body );

		Statement stmt1 = body.getStatements().get(0);
		assertTrue( stmt1 instanceof ExpressionStatement );
		ExpressionStatement exprStmt1 = (ExpressionStatement)stmt1;
		Expression expr1 = exprStmt1.getExpr();
		assertNotNull( expr1 );

		assertTrue( expr1 instanceof MemberAccess );
		MemberAccess memberAccess1 = (MemberAccess)expr1;
		Expression containerExpr1 = memberAccess1.getContainer();
		Name fieldAccess1Name = memberAccess1.getName();
		assertNotNull(fieldAccess1Name);
		assertEquals("field1", fieldAccess1Name.getName());

		assertTrue( containerExpr1 instanceof ElementAccess );
		ElementAccess containersAccess1 = (ElementAccess)containerExpr1;
		Name container1Name = containersAccess1.getName();
		assertNotNull( container1Name );
		assertNotNull( container1Name.getParent() );
		assertNotNull( container1Name.getName() );
		assertEquals( var1Name, container1Name );

		Statement stmt2 = body.getStatements().get(1);
		assertTrue( stmt2 instanceof ExpressionStatement );
		ExpressionStatement exprStmt2 = (ExpressionStatement)stmt2;
		Expression expr2 = exprStmt2.getExpr();
		assertNotNull( expr2 );

		assertTrue( expr2 instanceof MemberAccess );
		MemberAccess memberAccess2 = (MemberAccess)expr2;
		Expression containerExpr2 = memberAccess2.getContainer();
		Name fieldAccess2Name = memberAccess2.getName();
		assertNotNull(fieldAccess2Name);
		assertEquals("field2", fieldAccess2Name.getName());

		assertTrue( containerExpr2 instanceof ElementAccess );
		ElementAccess containersAccess2 = (ElementAccess)containerExpr2;
		Name container2Name = containersAccess2.getName();
		assertNotNull( container2Name );
		assertNotNull( container2Name.getParent() );
		assertNotNull( container2Name.getName() );
		assertEquals( var2Name, container2Name );
	}
}
