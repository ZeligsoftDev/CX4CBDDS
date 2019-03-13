package com.zeligsoft.cx.langc.test;


import org.junit.Test;

import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.Struct;
import com.zeligsoft.cx.langc.Union;
import com.zeligsoft.cx.langc.test.util.Factory;

@SuppressWarnings("nls")
public class TestModel  {

	private static final Factory F = new Factory();

	@Test
	public void testSimpleUnion()
	{
		NamedReference field = LangCFactory.eINSTANCE.createNamedReference();
		field.setType(F.createChar());
		field.setName(F.createName("c"));

		Union union = LangCFactory.eINSTANCE.createUnion();
		union.setName(F.createName("U"));
		union.getMembers().add(field);
	}

	@Test
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
