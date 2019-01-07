package com.zeligsoft.base.langc.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test suite for com.zeligsoft.base.langc"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(Bug13915.class);
		suite.addTestSuite(Bug13926.class);
		suite.addTestSuite(Bug13928.class);
		suite.addTestSuite(Bug14150.class);
		suite.addTestSuite(Bug14177.class);
		suite.addTestSuite(Bug14186.class);
		suite.addTestSuite(Bug14228.class);
		suite.addTestSuite(Bug14296.class);
		suite.addTestSuite(Bug14336.class);
		suite.addTestSuite(NamespaceTests.class);
		suite.addTestSuite(CodeStreamTests.class);
		//$JUnit-END$
		return suite;
	}
}
