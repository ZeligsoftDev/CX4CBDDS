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
import org.eclipse.jdt.annotation.Nullable;

public abstract class GrammarRuleValue implements Indexed, Nameable
{
	protected final int ruleIndex;
	protected final @NonNull String name;
	private @Nullable Integer hashCode = null;

	protected GrammarRuleValue(int ruleIndex, @NonNull String name) {
		this.ruleIndex = ruleIndex;
		this.name = name;
	}

	@Override
	public int getIndex() {
		return ruleIndex;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull String getRuleName() {		// FIXME not distinct
		return name;
	}

	@Override
	public final int hashCode() {
		Integer hashCode2 = hashCode;
		if (hashCode2 == null) {
			hashCode = hashCode2 = getClass().hashCode() + name.hashCode();
		}
		return hashCode2.intValue();
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}