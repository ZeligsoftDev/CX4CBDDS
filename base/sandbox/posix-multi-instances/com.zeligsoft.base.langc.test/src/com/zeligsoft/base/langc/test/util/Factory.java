package com.zeligsoft.base.langc.test.util;

import java.util.LinkedList;
import java.util.List;

import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.Element;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.IntegralLiteral;
import com.zeligsoft.base.langc.LangCFactory;
import com.zeligsoft.base.langc.Literal;
import com.zeligsoft.base.langc.Name;
import com.zeligsoft.base.langc.PrimitiveType;

@SuppressWarnings("nls")
public class Factory {

	public static BuiltInType builtInChar;
	public static BuiltInType builtInInt;
	public static final List<Name> folders = new LinkedList<Name>();

	public Element getChar() {
		if (builtInChar == null) {
			Name name = LangCFactory.eINSTANCE.createName();
			name.setName("char");

			builtInChar = LangCFactory.eINSTANCE.createBuiltInType();
			builtInChar.setType(PrimitiveType.CHAR);
		}

		return builtInChar;
	}

	public Element getInt() {
		if (builtInInt == null) {
			Name name = LangCFactory.eINSTANCE.createName();
			name.setName("int");

			builtInInt = LangCFactory.eINSTANCE.createBuiltInType();
			builtInInt.setType(PrimitiveType.INT32);
		}

		return builtInInt;
	}

	public ElementReference createChar() {
		ElementReference elementRef = LangCFactory.eINSTANCE.createElementReference();
		elementRef.setElement(getChar());
		return elementRef;
	}

	public ElementReference createInt() {
		ElementReference elementRef = LangCFactory.eINSTANCE.createElementReference();
		elementRef.setElement(getInt());
		return elementRef;
	}

	public Literal literalS(int value) {
		IntegralLiteral literal = LangCFactory.eINSTANCE.createIntegralLiteral();
		literal.setValue(value);
		literal.setBytes((byte) 4);
		literal.setSigned(true);
		return literal;
	}

	public Name createName(String name) {
		Name n = LangCFactory.eINSTANCE.createName();
		n.setName(name);
		return n;
	}

	public FileName createFileName(String name) {
		FileName n = LangCFactory.eINSTANCE.createFileName();
		n.setName(name);
		return n;
	}
}
