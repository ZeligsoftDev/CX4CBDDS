package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zeligsoft.cx.langc.BreakStatement;
import com.zeligsoft.cx.langc.Statement;
import com.zeligsoft.cx.langc.SwitchClause;
import com.zeligsoft.cx.langc.SwitchStatement;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14150  {

	@Test
	public void testAddBreakToClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testAddBreakToClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 2, stmts.size() );
		assertTrue( stmts.get( stmts.size() - 1 ) instanceof BreakStatement );
	}

	@Test
	public void testAddBreakToEmptyClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testAddBreakToEmptyClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 1, stmts.size() );
		assertTrue( stmts.get( stmts.size() - 1 ) instanceof BreakStatement );
	}

	@Test
	public void testNoBreakForFallthroughClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testNoBreakForFallthroughClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 0, stmts.size() );
	}

	@Test
	public void testNoBreakAfterReturn() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testNoBreakAfterReturn()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 1, stmts.size() );
		assertTrue( ! ( stmts.get( 0 ) instanceof BreakStatement ) );
	}

	@Test
	public void testListOfClauses() {
		
		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testListOfClauses()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertEquals( 3, clauses.size() );
	}
}
