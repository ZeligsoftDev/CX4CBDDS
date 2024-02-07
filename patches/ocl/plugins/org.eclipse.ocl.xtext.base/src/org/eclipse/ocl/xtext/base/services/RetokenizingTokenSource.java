/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.services;

import java.util.LinkedList;
import java.util.Map;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

/**
 * RetokenizingTokenSource accomodates backtracking limitations in the ANTRL lexer when used from Xtext.
 *
 * The problem is the three overlapping syntaxes
 * INT.INT leading to a Floating Point lteral
 * INT..INT leading to a Collection range
 * INT.ID leading to a numeric navigation
 *
 * ANTLR proceeds to INT. but won't backup when the character after the . is bad.
 *
 * The code here allows the basic lexer to be ignorant of floating point syntax so that it correctly parses
 * INT.INT as INT DOT INT
 * INT..INT as INT DOTDOT INT
 * INT.INTe+INT as INT DOT INT ID PLUS INT
 * so the code here recognises the floating point literal and reconsttructs. As an additional benefit 'e' and 'E' are not keywords.
 */
public class RetokenizingTokenSource implements TokenSource
{
	protected final TokenSource tokenSource;
	protected final Map<Integer, String> tokenDefMap;
	protected final LinkedList<Token> queue = new LinkedList<Token>();
	private int tINT = -1;
	private int tDOT = -1;
	private int tID = -1;
	private int tPLUS = -1;
	private int tMINUS = -1;

	public RetokenizingTokenSource(TokenSource tokenSource, Map<Integer, String> tokenDefMap) {
		this.tokenSource = tokenSource;
		this.tokenDefMap = tokenDefMap;
		for (Map.Entry<Integer, String> entry : tokenDefMap.entrySet()) {
			Integer tokenNumber = entry.getKey();
			String tokenName = entry.getValue();
			if ("RULE_SIMPLE_ID".equals(tokenName)) {
				tID = tokenNumber;
			}
			else if ("'.'".equals(tokenName)) {
				tDOT = tokenNumber;
			}
			else if ("RULE_INT".equals(tokenName)) {
				tINT = tokenNumber;
			}
			else if ("'+'".equals(tokenName)) {
				tPLUS = tokenNumber;
			}
			else if ("'-'".equals(tokenName)) {
				tMINUS = tokenNumber;
			}
		}
	}

	@Override
	public String getSourceName() {
		return tokenSource.getSourceName();
	}

	protected boolean isInteger(String text) {
		int iMax = text.length();
		if (iMax <= 0) {
			return true;
		}
		char c = text.charAt(0);
		if ((c < '1') || ('9' < c)) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			c = text.charAt(i);
			if ((c < '0') || ('9' < c)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Token nextToken() {
		Token firstToken = peek(0);
		int firstType = firstToken.getType();
		if (firstType != tINT) {
			return queue.remove();
		}
		Token lastToken = firstToken;
		int index = 0;
		Token nextToken = peek(++index);
		int nextType = nextToken.getType();
		if (nextType == tDOT) {
			nextToken = peek(++index);
			nextType = nextToken.getType();
			if (nextType != tINT) {
				return queue.remove();
			}
			lastToken = nextToken;
			nextToken = peek(++index);
			nextType = nextToken.getType();
		}
		if (nextType == tID) {
			String text = nextToken.getText();
			if (text.startsWith("E") || text.startsWith("e")) {
				if (text.length() == 1) {
					nextToken = peek(++index);
					nextType = nextToken.getType();
					if ((nextType == tPLUS) || (nextType == tMINUS)) {
						nextToken = peek(++index);
						nextType = nextToken.getType();
					}
					if (nextType == tINT) {
						lastToken = nextToken;
					}
				}
				else if (isInteger(text.substring(1))) {
					lastToken = nextToken;
				}
			}
		}
		if (firstToken == lastToken) {
			return queue.remove();
		}
		StringBuilder s = new StringBuilder();
		while ((nextToken = queue.remove()) != lastToken) {
			s.append(nextToken.getText());
		}
		s.append(nextToken.getText());
		String text = s.toString();
		CommonToken commonToken = new CommonToken(firstToken);
		commonToken.setStopIndex(commonToken.getStartIndex() + text.length() -1);
		commonToken.setText(text);
		return commonToken;
	}

	/**
	 * Return the token index positions ahead of the next token.
	 *
	 * Returns EOF_TOKEN if no such token or if a hidden token interleaves.
	 */
	protected Token peek(int index) {
		while (queue.size() <= index) {
			Token nextToken = tokenSource.nextToken();
			if (nextToken == null) {
				return Token.EOF_TOKEN;
			}
			queue.add(nextToken);
		}
		Token thisToken = queue.get(index);
		if (index > 0) {
			Token prevToken = queue.get(index-1);
			int prevLine = prevToken.getLine();
			int thisLine = thisToken.getLine();
			if (prevLine != thisLine) {
				return Token.EOF_TOKEN;
			}
			String prevText = prevToken.getText();
			int prevCharPositionInLine = prevToken.getCharPositionInLine();
			int thisCharPositionInLine = thisToken.getCharPositionInLine();
			if (prevCharPositionInLine+prevText.length() != thisCharPositionInLine) {
				return Token.EOF_TOKEN;
			}
		}
		return thisToken;
	}
}
