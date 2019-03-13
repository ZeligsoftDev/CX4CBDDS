package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.SubSystem;
import com.zeligsoft.cx.langc.UserElement;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;
import com.zeligsoft.cx.langc.util.Namespace;

public class Bug14336 {

	@Test
	public void testGenerateTwoBodies() {
		Namespace.reset();
		SubSystem subSystem = LangCTestRunner.run("regression::bug14336::createFiles()"); //$NON-NLS-1$
		assertNotNull( subSystem );

		assertEquals( 3, subSystem.getFiles().size() );

		ElementList header = subSystem.getFiles().get( 0 );
		ElementList impl1 = subSystem.getFiles().get( 1 );
		ElementList impl2 = subSystem.getFiles().get( 2 );

		assertEquals( 1, header.getElements().size() );
		assertEquals( 1, impl1.getElements().size() );
		assertEquals( 1, impl2.getElements().size() );

		UserElement decl = header.getElements().get(0);
		UserElement defn1 = impl1.getElements().get(0);
		UserElement defn2 = impl2.getElements().get(0);

		assertTrue( decl instanceof Function );
		assertTrue( defn1 instanceof FunctionImplementation );
		assertTrue( defn2 instanceof FunctionImplementation );
	}
}
