/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Debug assist. An instance of ToDebugString may be used to provide a debugger facility to provide a mult-line debug
 * of a ToDebugStringable as a string when the the instance is selected.
 */
public class ToDebugString
{
	public interface ToDebugStringable
	{
		void toDebugString(@NonNull StringBuilder s, int depth);
	}

	private final @NonNull ToDebugStringable toDebugString;

	public ToDebugString(@NonNull ToDebugStringable toDebugString) {
		this.toDebugString = toDebugString;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		toDebugString.toDebugString(s, 0);
		@SuppressWarnings("null")
		@NonNull String castString = s.toString();
		return castString;
	}
}