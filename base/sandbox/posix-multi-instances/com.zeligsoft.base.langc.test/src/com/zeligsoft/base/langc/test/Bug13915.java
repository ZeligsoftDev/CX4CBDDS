package com.zeligsoft.base.langc.test;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;

import com.zeligsoft.base.langc.Dependency;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.FileDependency;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug13915 extends TestCase {

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

	public void testDuplicateIncludes() {

		ElementList elementList = LangCTestRunner.run("regression::bug13915::duplicateIncludesElementList()");
		assertNotNull(elementList);

		EList<Dependency> deps = elementList.getDeclIncludes().getDependencies();
		assertEquals(1, deps.size());
		assertTrue( deps.get(0) instanceof FileDependency );
		assertEquals("dep_1", ( (FileDependency)deps.get(0) ).getFilename().getName());
	}

	public void testTwoElementDep() {

		ElementList elementList = LangCTestRunner.run("regression::bug13915::twoElementDepElementList()");
		assertNotNull(elementList);

		EList<Dependency> deps = elementList.getDeclIncludes().getDependencies();
		assertEquals(1, deps.size());
	}
}
