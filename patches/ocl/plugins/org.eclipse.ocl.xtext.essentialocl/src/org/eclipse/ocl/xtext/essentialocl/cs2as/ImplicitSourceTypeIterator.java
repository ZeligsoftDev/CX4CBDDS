/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.xtext.basecs.ElementCS;

/**
 * An Iterator over the types of implicit source variables (most nested first).
 */
public class ImplicitSourceTypeIterator extends AbstractImplicitSourceNamedElementIterator<Type>
{
	protected @Nullable Type nextValue;

	public ImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
		super(csElement);
	}

	public @Nullable Type nextValue() {
		return nextValue;
	}

	@Override
	protected void setNext(@NonNull VariableDeclaration asVariable) {
		next = asVariable.getType();
		nextValue = asVariable.getTypeValue();
	}
}