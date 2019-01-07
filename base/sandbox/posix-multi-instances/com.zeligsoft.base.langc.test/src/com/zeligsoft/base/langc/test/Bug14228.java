package com.zeligsoft.base.langc.test;

import java.util.List;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.Expression;
import com.zeligsoft.base.langc.IntegralLiteral;
import com.zeligsoft.base.langc.VariableDeclaration;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14228 extends TestCase {

	public void testCharArray() {
		VariableDeclaration var = LangCTestRunner.run("regression::bug14228::testCharArray()");
		assertNotNull( var );

		ElementReference type = var.getElement();
		assertNotNull( type );

		List<Expression> bounds = type.getArrayBounds();
		assertEquals( 1, bounds.size() );

		IntegralLiteral literal = (IntegralLiteral)bounds.get(0);
		assertEquals( 5, literal.getValue() );
	}
}
