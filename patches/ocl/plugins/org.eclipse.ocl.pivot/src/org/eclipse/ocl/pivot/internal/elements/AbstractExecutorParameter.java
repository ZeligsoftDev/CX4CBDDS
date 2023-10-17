/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;

public final class AbstractExecutorParameter extends AbstractExecutorTypedElement implements Parameter
{
	protected final boolean typeof;

	public AbstractExecutorParameter(@NonNull String name, @NonNull Type type, boolean typeof) {
		super(name, type);
		this.typeof = typeof;
	}

	@Override
	public boolean isIsTypeof() {
		return typeof;
	}

	@Override
	public Type getTypeValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTypeValue(Type value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsTypeof(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Operation getOwningOperation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningOperation(Operation value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	@Override
	public boolean validateTypeIsNotInvalid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean validateTypeIsNotNull(DiagnosticChain diagnostics,Map<Object, Object> context) {
		return true;
	}
}