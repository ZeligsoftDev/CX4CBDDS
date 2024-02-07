/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html

 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xpand2.output;

import java.io.IOException;

/**
 * This output implementation avoids writing of unnecessary blank lines.
 *
 * @author Karsten Thoms
 */
public class BlankLineSkippingOutput extends OutputImpl {
	private final static String NEWLINE = "\n";

	@Override
	public void write(final String bytes) {
		if (current() != null && bytes != null && bytes.length() > 0) {
			CharSequence outputBuffer = current().getBuffer();
			int idxNL = bytes.indexOf(NEWLINE);
			if (idxNL < 0) {
				try {
					((Appendable)outputBuffer).append(bytes);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return;
			}

			String s = new String(bytes);
			if (isNewLine(s.charAt(0)) && outputBuffer.length() > 0
					&& isNewLine(outputBuffer.charAt(outputBuffer.length() - 1))) {
				int i;
				for (i = 1; i < s.length(); i++) {
					if (!isNewLine(s.charAt(i)))
						break;
				}
				s = s.substring(i);
				idxNL = s.indexOf(NEWLINE);
			}
			try {
				((Appendable)outputBuffer).append((idxNL < s.length() - 1) ? s.substring(0, idxNL + 1) : s);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			if (idxNL + 1 < s.length()) {
				write(s.substring(idxNL + 1));
			}
		}
	}

}
