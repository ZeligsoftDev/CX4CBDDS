/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.parser.antlr;

import java.io.InputStream;

import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class UmlPortAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.tokens");
	}
}
