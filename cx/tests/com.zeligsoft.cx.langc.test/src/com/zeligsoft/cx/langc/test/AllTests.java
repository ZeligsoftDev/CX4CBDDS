package com.zeligsoft.cx.langc.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Bug13915.class, Bug13926.class, Bug13928.class, Bug14150.class,
	Bug14177.class, Bug14186.class, Bug14228.class, Bug14296.class, Bug14336.class,
	FormattingTests.class, NamespaceTests.class})
public class AllTests {
	// nothing to do since it is a JUnit 4 test cases
}
