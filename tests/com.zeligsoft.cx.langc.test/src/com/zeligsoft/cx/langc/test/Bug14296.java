package com.zeligsoft.cx.langc.test;


import static org.junit.Assert.*;

import org.junit.Test;

import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.SubSystem;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;
import com.zeligsoft.cx.langc.util.Namespace;

@SuppressWarnings("nls")
public class Bug14296  {

	@Test
	public void testLookupFieldInWhile() {
		Namespace.reset();
		ElementList file = LangCTestRunner.run("regression::bug14296a::lookupFieldInWhile()");
		assertNotNull(file);
	}

	@Test
	public void testNestedNames() {
		Namespace.reset();
		SubSystem subsystem = LangCTestRunner.run("regression::bug14296b::nestedNames()");
		assertNotNull(subsystem);
	}
}
