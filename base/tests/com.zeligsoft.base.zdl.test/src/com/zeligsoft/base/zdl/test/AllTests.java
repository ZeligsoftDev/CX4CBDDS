package com.zeligsoft.base.zdl.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ZDLElementTypeTests.class, ZDLMetamodelInWorkflowTests.class, ZDLRedefinitionTest.class, 
	ZDLUtilTest.class})
public class AllTests {
	// do nothing since this is a JUnit 4 test suite
}
