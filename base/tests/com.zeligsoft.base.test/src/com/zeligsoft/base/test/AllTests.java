package com.zeligsoft.base.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ModelMergerTest.class, PathmapURIHelperTest.class, RSMReaderTests.class, 
	RSMUtilTest.class, RSMWriterTests.class, SetupResourceSetTest.class, StringDependencyGraphTest.class, 
	ZeligsoftURIConverterTest.class})
public class AllTests {
	// nothing to do since this is for a test suite
}
