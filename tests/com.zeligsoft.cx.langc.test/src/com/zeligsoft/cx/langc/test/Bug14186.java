package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zeligsoft.cx.langc.Dependency;
import com.zeligsoft.cx.langc.DependencyList;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.FileDependency;
import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.SubSystem;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14186 {

	@Test
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
