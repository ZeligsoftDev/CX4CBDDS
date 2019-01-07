package test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.zeligsoft.domain.sca.corbabridge");
		suite.addTest(CXCorbaBridgeTest.suite());
		return suite;
	}

	public static void main(String[] args) {
		TestRunner.run(suite());
	}
}
