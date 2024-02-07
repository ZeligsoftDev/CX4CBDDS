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

public class TerminalRuleValue extends GrammarRuleValue
{
	public TerminalRuleValue(int ruleIndex, @NonNull String name) {
		super(ruleIndex, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TerminalRuleValue)) {
			return false;
		}
		TerminalRuleValue that = (TerminalRuleValue)obj;
		return (this.ruleIndex == that.ruleIndex) && this.name.equals(that.name);
	}
}