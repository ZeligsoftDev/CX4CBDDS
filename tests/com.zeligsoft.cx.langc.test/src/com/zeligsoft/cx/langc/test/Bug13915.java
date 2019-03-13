package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.zeligsoft.cx.langc.Dependency;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.FileDependency;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug13915 {

	@Test
	public void testUniqueIncludes() {

		ElementList elementList = LangCTestRunner.run("regression::bug13915::uniqueIncludesElementList()");
		assertNotNull(elementList);

		EList<Dependency> deps = elementList.getDeclIncludes().getDependencies();
		assertEquals(2, deps.size());
		assertTrue( deps.get(0) instanceof FileDependency );
		assertTrue( deps.get(1) instanceof FileDependency );
		assertEquals("dep_1", ( (FileDependency)deps.get(0) ).getFilename().getName());
		assertEquals("dep_2", ( (FileDependency)deps.get(1) ).getFilename().getName());
	}

	@Test
	public void testDuplicateIncludes() {

		ElementList elementList = LangCTestRunner.run("regression::bug13915::duplicateIncludesElementList()");
		assertNotNull(elementList);

		EList<Dependency> deps = elementList.getDeclIncludes().getDependencies();
		assertEquals(1, deps.size());
		assertTrue( deps.get(0) instanceof FileDependency );
		assertEquals("dep_1", ( (FileDependency)deps.get(0) ).getFilename().getName());
	}

	@Test
	public void testTwoElementDep() {

		ElementList elementList = LangCTestRunner.run("regression::bug13915::twoElementDepElementList()");
		assertNotNull(elementList);

		EList<Dependency> deps = elementList.getDeclIncludes().getDependencies();
		assertEquals(1, deps.size());
	}
}
