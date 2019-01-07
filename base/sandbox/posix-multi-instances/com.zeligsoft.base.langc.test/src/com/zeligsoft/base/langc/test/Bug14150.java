package com.zeligsoft.base.langc.test;

import java.util.List;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.BreakStatement;
import com.zeligsoft.base.langc.Statement;
import com.zeligsoft.base.langc.SwitchClause;
import com.zeligsoft.base.langc.SwitchStatement;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14150 extends TestCase {

	public void testAddBreakToClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testAddBreakToClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 2, stmts.size() );
		assertTrue( stmts.get( stmts.size() - 1 ) instanceof BreakStatement );
	}

	public void testAddBreakToEmptyClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testAddBreakToEmptyClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 1, stmts.size() );
		assertTrue( stmts.get( stmts.size() - 1 ) instanceof BreakStatement );
	}

	public void testNoBreakForFallthroughClause() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testNoBreakForFallthroughClause()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 0, stmts.size() );
	}

	public void testNoBreakAfterReturn() {

		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testNoBreakAfterReturn()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertFalse( clauses.isEmpty() );

		List<Statement> stmts = clauses.get( 0 ).getStatements();
		assertEquals( 1, stmts.size() );
		assertTrue( ! ( stmts.get( 0 ) instanceof BreakStatement ) );
	}

	public void testListOfClauses() {
		
		SwitchStatement switchStmt = LangCTestRunner.run("regression::bug14150::testListOfClauses()");
		assertNotNull(switchStmt);

		List<SwitchClause> clauses = switchStmt.getClauses();
		assertEquals( 3, clauses.size() );
	}
}
