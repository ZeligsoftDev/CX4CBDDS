package com.zeligsoft.base.langc.test;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.SubSystem;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;
import com.zeligsoft.base.langc.util.Namespace;

@SuppressWarnings("nls")
public class Bug14296 extends TestCase {

	public void testLookupFieldInWhile() {
		Namespace.reset();
		ElementList file = LangCTestRunner.run("regression::bug14296a::lookupFieldInWhile()");
		assertNotNull(file);
	}

	public void testNestedNames() {
		Namespace.reset();
		SubSystem subsystem = LangCTestRunner.run("regression::bug14296b::nestedNames()");
		assertNotNull(subsystem);
	}
}
