/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;

/**
 * IndentingLogger formats messages by applying applying the prevailing indentation depth to new lines.
 * The depth in changed by push/popIndentation(). Complete lines are passed to print().
 * close() should be called to flush the final line.
 * @since 1.1
 */
public abstract class IndentingLogger extends AbstractLogger
{
	/**
	 * Static instance that logs to System.out.
	 */
	public static final @NonNull EvaluationLogger OUT = new IndentingLogger()
	{
		@Override
		protected void print(@NonNull String string) {
			System.out.print(string);
		}
	};

	private int indentationLevel = 0;
	private final @NonNull StringBuilder s = new StringBuilder();
	
	@Override
	public void append(@NonNull String message) {
		for (int i = 0; i < message.length(); i++) {
			if (s.length() == 0) {
				indent(indentationLevel);
			}
			char c = message.charAt(i);
			s.append(c);
			if (c == '\n') {
				print(s.toString());
				s.setLength(0);
			}
		}
	}

	@Override
	public void close() {
		if (s.length() > 0) {
			print(s.toString());
			s.setLength(0);
		}
	}

	protected void indent(int depth) {
		for (int k = 0; k < depth; k++) {
			s.append(k%5 == 0 ? ". " : "  ");
		}
	}

	@Override
	public void popIndentation() {
		if (indentationLevel > 0) {
			--indentationLevel;
		}
	}

	@Override
	public void pushIndentation() {
		indentationLevel++;
	}
}