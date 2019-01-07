package com.zeligsoft.base.langc.test;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.ElementAccess;
import com.zeligsoft.base.langc.LinkableArtifact;
import com.zeligsoft.base.langc.Struct;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class AccessTests extends TestCase {

	public void testSimple() {

		List<Object> results = LangCTestRunner.run("langcmodel::access::testSimple");
		assertNotNull( results );
		assertTrue( results.size() >= 2 );

		Object obj01 = results.get( 0 );
		Object obj02 = results.get( 1 );

		assertTrue( obj01 instanceof Struct );
		Struct struct = (Struct)obj01;

		assertTrue( obj02 instanceof ElementAccess );
		ElementAccess access = (ElementAccess)obj02;

		assertEquals( struct, access.getName().eContainer() );
	}

	public void testTransitiveClosureFindingReferencedVariable() {

		LinkableArtifact la = LangCTestRunner.run("langcmodel::access::testLA");
		assertNotNull( la );

		assertEquals( 1, la.getRootElements().size() );

		Collection<UserElement> tc = LangCTestRunner.run("generator::systempartitioner::transitiveClosure", la);
		assertNotNull( tc );

		assertEquals( 3, tc.size() );
	}
}
