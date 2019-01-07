package com.zeligsoft.base.validation.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BatchJavaConstraintsTestCase.class, ConstraintRedefinitionTest.class, 
	FreeStandingConstraintsTestCase.class, MultiplicityConstraintTest.class, 
	OCLConstraintsTestCase.class, OCLLinkConstraintsTestCase.class})
public class AllTests {
	// nothing to do since this is a JUnit 4 Test Suite
}
