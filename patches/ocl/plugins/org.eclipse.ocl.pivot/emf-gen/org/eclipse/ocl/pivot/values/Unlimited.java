/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Unlimited represents the unlimited value as a distinct java.lang.Number derived class that can be identified by instanceof.
 *
 * FIXME Unify with UnlimitedValueImpl
 */
public class Unlimited extends Number
{
	private static final long serialVersionUID = 1L;

	public static @NonNull Unlimited INSTANCE = new Unlimited();

	private Unlimited() {}

	@Override
	public double doubleValue() {
		throw new UnsupportedOperationException("Unlimited has no doubleValue()");
	}

	@Override
	public float floatValue() {
		throw new UnsupportedOperationException("Unlimited has no floatValue()");
	}

	@Override
	public int intValue() {
		throw new UnsupportedOperationException("Unlimited has no intValue()");
	}

	@Override
	public long longValue() {
		throw new UnsupportedOperationException("Unlimited has no longValue()");
	}

	@Override
	public String toString() {
		return "*";
	}
}
