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
import org.eclipse.xtext.AbstractElement;

/**
 * GrammarCardinality enacodes the alternative multiplicities in an Xtext grammar as an enumeration value.
 */
public enum GrammarCardinality
{
	ONE("1", 0),
	ZERO_OR_ONE("?", 1),
	ZERO_OR_MORE("*", 3),
	ONE_OR_MORE("+", 2);

	public static @NonNull GrammarCardinality toEnum(@NonNull AbstractElement abstractElement) {
		String cardinality = abstractElement.getCardinality();
		if ("*".equals(cardinality)) {
			return ZERO_OR_MORE;
		}
		else if ("+".equals(cardinality)) {
			return ONE_OR_MORE;
		}
		else if ("?".equals(cardinality)) {
			return ZERO_OR_ONE;
		}
		else if ("1".equals(cardinality)) {
			return ONE;
		}
		else if (cardinality == null) {
			return ONE;
		}
		else {
			throw new UnsupportedOperationException("Grammar cardinality '" + cardinality + "'");
		}
	}

	public static @NonNull GrammarCardinality max(@NonNull GrammarCardinality grammarCardinality1, @NonNull GrammarCardinality grammarCardinality2) {
		int newState = grammarCardinality1.state | grammarCardinality2.state;
		return valueOf(newState);
	}

	public static @NonNull GrammarCardinality valueOf(int enumValue) {
		switch (enumValue) {
			case 0: return ONE;
			case 1: return ZERO_OR_ONE;
			case 2: return ONE_OR_MORE;
			case 3: return ZERO_OR_MORE;
			default: throw new IllegalStateException();
		}
	}

	private final @NonNull String name;
	private final int state;

	private GrammarCardinality(@NonNull String name, int state) {
		this.name = name;
		this.state = state;
	}

	public boolean isOne() {
		return (state & 3) == ONE.state;
	}

	public boolean isOneOrMore() {
		return (state & 3) == ONE_OR_MORE.state;
	}

	public boolean isZeroOrMore() {
		return (state & 3) == ZERO_OR_MORE.state;
	}

	public boolean isZeroOrOne() {
		return (state & 3) == ZERO_OR_ONE.state;
	}

	public boolean mayBeMany() {
		return (state & 2) != 0;
	}

	public boolean mayBeZero() {
		return (state & 1) != 0;
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}