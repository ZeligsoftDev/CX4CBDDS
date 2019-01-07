package com.zeligsoft.base.langc.test;

import java.util.List;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.Dependency;
import com.zeligsoft.base.langc.FileDependency;
import com.zeligsoft.base.langc.DependencyList;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.SubSystem;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14186 extends TestCase {

	public void testEnumeratorBinding() {

		SubSystem subSystem = LangCTestRunner.run("regression::bug14186::bug14186()");
		assertNotNull(subSystem);

		List<ElementList> files = subSystem.getFiles();
		assertNotNull( files );
		assertEquals( 2, files.size() );

		ElementList funcFile = files.get( 1 );
		assertEquals( "func_file", funcFile.getName().getName() );

		DependencyList defnDeps = funcFile.getDefnIncludes();
		assertNotNull( defnDeps.getDependencies() );
		List<Dependency> deps = defnDeps.getDependencies();
		assertNotNull( deps );
		assertEquals( 1, deps.size() );

		assertTrue( deps.get( 0 ) instanceof FileDependency );
		FileDependency dep = (FileDependency)deps.get( 0 );
		FileName targFile = dep.getFilename();
		assertEquals( "enum_file", targFile.getName() );
	}
}
