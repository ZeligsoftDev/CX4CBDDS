package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.IntegralLiteral;
import com.zeligsoft.cx.langc.VariableDeclaration;
import com.zeligsoft.cx.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class Bug14228 {

	@Test
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
