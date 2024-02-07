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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.ids.TypeId;

public class AbstractExecutorTypedElement extends AbstractExecutorNamedElement implements TypedElement
{
	protected final @NonNull Type type;

	public AbstractExecutorTypedElement(@NonNull String name, @NonNull Type executorType) {
		super(name);
		this.type = executorType;
	}

	@Override
	public boolean CompatibleBody(ValueSpecification bodySpecification) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return type.getTypeId();
	}

	@Override
	public boolean isIsMany() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsRequired() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsRequired(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setType(Type value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(type); //$NON-NLS-1$
	}
}