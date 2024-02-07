/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

/**
 * A StringBuilder that assists in production of valid HTML.
 */
public class HTMLBuffer
{
	protected final StringBuilder s = new StringBuilder();
	private boolean inPara = false;

	public void append(String string) {
		for (int i = 0; i < string.length(); i++) {
			append(string.charAt(i));
		}		
	}
	
	public void append(char c) {
		switch (c) {
		case '&': s.append("&amp;"); break;
		case '<': s.append("&lt;"); break;
		case '>': s.append("&gt;"); break;
		default: s.append(c); break;
		}
	}

	public void appendFigure(String src, String alt, String width, String height) {
		s.append("<img");
		appendValue("src", src);
		appendValue("alt", alt);
		appendValue("width", width);
		appendValue("height", height);
		s.append(">");		
	}

	public void appendLabelDef(String value) {
		s.append("<a");
		appendValue("name", value);
		s.append("></a>");
	}

	public void appendLabelRef(String value) {
		s.append("<a");
		appendValue("href", "#" + value);
		s.append("></a>");
	}

	protected void appendTag(String tag) {
		s.append("<");
		s.append(tag);
		s.append(">");
	}

	protected void appendUntag(String tag) {
		s.append("</");
		s.append(tag);
		s.append(">");
	}

	protected void appendValue(String name, String value) {
		if (value != null) {
			s.append(" ");
			s.append(name);
			s.append("=\"");
			s.append(value);
			s.append("\"");
		}
	}

	public void endBulletLevel(Integer level) {
		appendUntag("li"); 
		appendUntag("ul"); 
	}
	
	/**
	 * End a colored font by emitting a &lt;/font&gt; tag.
	 */
	public void endFontColor() {
		appendUntag("font"); 
	}
	
	/**
	 * End a tagged font by emitting a &lt;/fontName&gt; tag.
	 */
	public void endFontName(String fontName) {
		appendUntag(fontName); 
	}

	public void endFootnote() {
		appendUntag("footnote"); 
	}

	public void endHeadingLevel(String level) {
		appendUntag("h" + level); 
	}
	
	/**
	 * End a paragraph by emitting a &lt;/p&gt; tag, unless no paragraph is active.
	 */
	public void endParagraph() {
		if (inPara) {
			appendUntag("p");
			inPara = false;
		}
	}

	/**
	 * End underlining by emitting a &lt;/u&gt; tag.
	 */
	public void endUnderline() {
		appendUntag("u");
	}

	public void startBulletLevel(Integer level) {
		appendTag("ul"); 
		appendTag("li"); 
	}
	
	/**
	 * Start a colored font by emitting a &lt;font color="colorName"&gt; tag.
	 */
	public void startFontColor(String colorName) {
		appendTag("font color=\"" + colorName + "\""); 
	}
	
	/**
	 * Start a tagged font by emitting a &lt;fontName&gt; tag.
	 */
	public void startFontName(String fontName) {
		appendTag(fontName); 
	}

	public void startFootnote() {
		appendTag("footnote"); 
	}

	public void startHeadingLevel(String level) {
		appendTag("h" + level); 
	}
	
	/**
	 * Start a paragraph by emitting a &lt;p&gt; tag, unless a paragraph is already active.
	 */
	public void startParagraph() {
		if (!inPara) {
			appendTag("p");
			inPara = true;
		}
	}

	/**
	 * Start underlining by emitting a &lt;u&gt; tag.
	 */
	public void startUnderline() {
		appendTag("u");
	}
	
	@Override
	public String toString() {
		return s.toString();
	}
}