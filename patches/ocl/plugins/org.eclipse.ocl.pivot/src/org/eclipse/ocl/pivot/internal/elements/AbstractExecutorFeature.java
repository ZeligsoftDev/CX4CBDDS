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
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.LibraryFeature;

public class AbstractExecutorFeature extends AbstractExecutorTypedElement implements Feature
{
	public AbstractExecutorFeature(@NonNull String name, @NonNull Type executorType) {
		super(name, executorType);
	}

	@Override
	public LibraryFeature getImplementation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getImplementationClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class getOwningClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIsStatic() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setImplementation(LibraryFeature value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setImplementationClass(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsStatic(boolean value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean validateNameIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public boolean validateTypeIsNotNull(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	@Override
	public boolean validateTypeIsNotInvalid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}
}