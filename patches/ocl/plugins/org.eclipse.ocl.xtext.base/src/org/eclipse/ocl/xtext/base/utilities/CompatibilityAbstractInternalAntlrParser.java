/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

/**
 * CompatibilityAbstractInternalAntlrParser provides backward compatibility for parsers compiled on Xtext >= 2.22
 * but executing on Xtext < 2.22
 *
 * Xtext 2.22 added the overload method setWithLastConsumed(EObject, String, boolean, String) avoiding the
 * need for callers to box the boolean argument. However on earlier platforms the missing new method gives a
 * NoSuchMethodError. CompatibilityAbstractInternalAntlrParser should therefore be inserted as the super class
 * to provide the missing signature.
 */
public abstract class CompatibilityAbstractInternalAntlrParser extends AbstractInternalAntlrParser {

	protected CompatibilityAbstractInternalAntlrParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected CompatibilityAbstractInternalAntlrParser(TokenStream input) {
		super(input);
	}

	@Override
	protected void setWithLastConsumed(EObject _this, String feature, Object value, String lexerRule) {
 		super.setWithLastConsumed(_this, feature, value, lexerRule);
	}

	// @Override -- this is an Override on Xtext >= 2.22, but not on Xtext < 2.22
	protected void setWithLastConsumed(EObject _this, String feature, boolean value, String lexerRule) {
		super.setWithLastConsumed(_this, feature, Boolean.valueOf(value), lexerRule);
	}
}
