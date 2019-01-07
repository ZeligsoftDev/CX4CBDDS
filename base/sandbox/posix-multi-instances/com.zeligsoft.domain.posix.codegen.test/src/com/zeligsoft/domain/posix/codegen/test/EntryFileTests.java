package com.zeligsoft.domain.posix.codegen.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.AddressOfExpr;
import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.CastExpr;
import com.zeligsoft.base.langc.CodeBlock;
import com.zeligsoft.base.langc.ElementAccess;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Enumerator;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.IndexExpr;
import com.zeligsoft.base.langc.LabeledClause;
import com.zeligsoft.base.langc.PrimitiveType;
import com.zeligsoft.base.langc.ReturnStatement;
import com.zeligsoft.base.langc.Statement;
import com.zeligsoft.base.langc.Struct;
import com.zeligsoft.base.langc.SwitchClause;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.domain.posix.codegen.test.util.PosixCodeGenTestRunner;
import com.zeligsoft.domain.posix.codegen.test.util.TokenRingClusterElements;

public class EntryFileTests extends TestCase {

	/**
	 * Components with user attributes (like Consumer) should be declared using the generated
	 * type.  Those without attributes (like Producer) should be declared as uint8, so that
	 * the instance will have a unique address.
	 */
	public void testComponentInstanceVariable() throws Exception {
		VariableDeclaration var
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_storageVariable",
					TokenRingClusterElements.producer,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( var );
		ElementReference ref = var.getElement();
		assertTrue( ref.getElement() instanceof BuiltInType );
		BuiltInType type = (BuiltInType)ref.getElement();
		assertEquals( PrimitiveType.UINT8, type.getType() );

		var = PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_storageVariable",
					TokenRingClusterElements.consumer,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( var );
		ref = var.getElement();
		assertTrue( ref.getElement() instanceof Struct );
	}

	/**
	 * Components with user attributes (like Consumer) should be initialized with a pointer to
	 * a component instance.  Those without attributes (like Producer) should be initialized with
	 * a pointer to a character, that has been cast to the proper type.
	 */
	public void testComponentInstanceInitialization() throws Exception {

		Expression expr
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_storageAddress",
					TokenRingClusterElements.producer,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( expr );
		assertTrue( expr instanceof CastExpr );

		expr = PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_storageAddress",
					TokenRingClusterElements.consumer,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( expr );
		assertTrue( expr instanceof AddressOfExpr );
	}

	/**
	 * Port instances are replicated based on the replication factor of the component instance as
	 * well as the replication factor on the port's type in the ComponentInterface.
	 */
	public void testPortInstanceReplication() throws Exception {

		List<Enumerator> nonRepPort
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_portInstances",
					TokenRingClusterElements.Producer_out,
					TokenRingClusterElements.producer,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( nonRepPort );
		assertEquals( 1, nonRepPort.size() );

		List<Enumerator> repPort
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_portInstances",
					TokenRingClusterElements.TokenOwner_out,
					TokenRingClusterElements.client_a,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( repPort );
		assertEquals( 2, repPort.size() );

		List<Enumerator> repComp
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_portInstances",
					TokenRingClusterElements.TokenOwner_in,
					TokenRingClusterElements.client_b,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( repComp );
		assertEquals( 2, repComp.size() );

		List<Enumerator> repPortAndComp
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_portInstances",
					TokenRingClusterElements.TokenOwner_out,
					TokenRingClusterElements.client_b,
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( repPortAndComp );
		assertEquals( 4, repPortAndComp.size() );
	}

	// Util method to return the string content of the name of the clauses first access
	// expression label.
	private static String getLabelString( LabeledClause clause )
	{
		for( Expression label : clause.getLabels() )
			if( label instanceof ElementAccess )
				return ( (ElementAccess)label ).getName().getName();
		return "";
	}

	// Util method to return the string content of the name of the element returned
	// in the argument block.
	private static String getBodyString( CodeBlock block )
	{
		for( Statement stmt : block.getStatements() )
		{
			if( ! ( stmt instanceof ReturnStatement ) )
				continue;

			Expression expr1 = ( (ReturnStatement)stmt ).getExpr();
			if( ! ( expr1 instanceof AddressOfExpr ) )
				continue;

			Expression expr2 = ( (AddressOfExpr)expr1 ).getExpr();
			if( ! ( expr2 instanceof IndexExpr ) )
				continue;

			Expression expr3 = ( (IndexExpr)expr2 ).getIndex();
			if( ! ( expr3 instanceof ElementAccess ) )
				continue;

			return ( (ElementAccess)expr3 ).getName().getName();
		}

		return "";
	}

	/**
	 * The port iterator function needs to map from every out-going port instance to the
	 * following port instance.
	 */
	public void testPortIterator() throws Exception
	{
		com.zeligsoft.base.langc.SwitchStatement aSwitch
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::junit_portIteratorSwitch",
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process2,
					TokenRingClusterElements.client_a,
					TokenRingClusterElements.client_b
			);
		assertNotNull( aSwitch );

		// build a map of case label -> index of next port
		Map<String, String> nextInstance = new HashMap<String, String>();
		for( SwitchClause clause : aSwitch.getClauses() )
			if( clause instanceof LabeledClause )
			{
				LabeledClause labeled = (LabeledClause)clause;
				nextInstance.put( getLabelString( labeled ), getBodyString( labeled ) ); 
			}

		// there should be no input ports in the iterator, and the output should all
		// point to the next instance or null (empty string)
		assertNull( nextInstance.get( "Process2_CLIENT_A_IN_0" ) );
		assertEquals( "Process2_CLIENT_A_OUT_1", nextInstance.get( "Process2_CLIENT_A_OUT_0" ) );
		assertEquals( "", nextInstance.get( "Process2_CLIENT_A_OUT_1" ) );
		assertNull( nextInstance.get( "Process2_CLIENT_B_IN_0" ) );
		assertNull( nextInstance.get( "Process2_CLIENT_B_IN_1" ) );
		assertEquals( "Process2_CLIENT_B_OUT_1", nextInstance.get( "Process2_CLIENT_B_OUT_0" ) );
		assertEquals( "Process2_CLIENT_B_OUT_2", nextInstance.get( "Process2_CLIENT_B_OUT_1" ) );
		assertEquals( "Process2_CLIENT_B_OUT_3", nextInstance.get( "Process2_CLIENT_B_OUT_2" ) );
    	assertEquals( "", nextInstance.get( "Process2_CLIENT_B_OUT_3" ) );
	}

	public void testEntryFunction() throws Exception
	{
		FunctionImplementation impl
			= PosixCodeGenTestRunner.run(
					"structure::posixelement::entryImpl",
					TokenRingClusterElements.Deployment,
					TokenRingClusterElements.process1 );
		assertNotNull( impl );

		impl.getBody();
	}
}
