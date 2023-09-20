/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.codeassist;

public class CharacterScanner {
	public final static int BOUNDS = -1;

	private final String internal;

	private int offset = 0;

	public CharacterScanner(final String internal) {
		this.internal = internal;
	}

	@SuppressWarnings("hiding")
	public boolean goTo(final int offset) {
		if ((offset < 0) || (offset >= internal.length())) {
			return false;
		}
		this.offset = offset;
		return true;
	}

	public int read() {
		if (offset >= internal.length()) {
			return BOUNDS;
		}
		return internal.charAt(offset++);
	}

	public int unread() {
		if (offset > 0) {
			return BOUNDS;
		}
		return internal.charAt(offset--);
	}

	public String getString() {
		return internal;
	}

	public int offset() {
		return offset;
	}

	public char currentChar() {
		return internal.charAt(offset);
	}

}
