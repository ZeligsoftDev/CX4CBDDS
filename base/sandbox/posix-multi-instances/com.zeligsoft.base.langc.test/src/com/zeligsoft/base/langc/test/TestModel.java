package com.zeligsoft.base.langc.test;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.LangCFactory;
import com.zeligsoft.base.langc.NamedReference;
import com.zeligsoft.base.langc.Struct;
import com.zeligsoft.base.langc.Union;
import com.zeligsoft.base.langc.test.util.Factory;

@SuppressWarnings("nls")
public class TestModel extends TestCase {

	private static final Factory F = new Factory();

	public void testSimpleUnion()
	{
		NamedReference field = LangCFactory.eINSTANCE.createNamedReference();
		field.setType(F.createChar());
		field.setName(F.createName("c"));

		Union union = LangCFactory.eINSTANCE.createUnion();
		union.setName(F.createName("U"));
		union.getMembers().add(field);
	}

	public void testSimpleStruct()
	{
		NamedReference field = LangCFactory.eINSTANCE.createNamedReference();
		field.setType(F.createInt());
		field.setName(F.createName("i"));

		Struct struct = LangCFactory.eINSTANCE.createStruct();
		struct.setName(F.createName("S"));
		struct.getMembers().add(field);
	}
}
