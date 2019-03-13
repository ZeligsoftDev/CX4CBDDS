package com.zeligsoft.base.rsm.tooling.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * Tests the RSM tooling plug-in API.
 * 
 * @since Christian W. Damus (cdamus)
 */
public class AllTests
		extends TestSuite {

	/**
	 * Main entrypoint.
	 * 
	 * @param args program arguments
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * Creates the test suite.
	 * 
	 * @return my test suite
	 */
	public static Test suite() {
		TestSuite suite = new AllTests("RSM Tooling Base Tests"); //$NON-NLS-1$
		
		suite.addTest(RSMUtilTest.suite());
		
		return suite;
	}

	/**
	 * Initializes me with a name.
	 * 
	 * @param name my name
	 */
	public AllTests(String name) {
		super(name);
	}

} //AllTests
