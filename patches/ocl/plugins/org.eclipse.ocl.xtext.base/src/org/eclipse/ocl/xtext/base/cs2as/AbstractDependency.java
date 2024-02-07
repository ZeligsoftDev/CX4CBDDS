/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;

public abstract class AbstractDependency<@NonNull T> implements Dependency
{
	protected final T element;

	public AbstractDependency(T element) {
		this.element = element;
		//		assert element != null; -- happens for references to unresolved proxy types
	}

	@Override
	public abstract boolean canExecute();

	public T getElement() {
		return element;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + '(' + element + ')';
	}

	public static AbstractDependency<@NonNull ?>[] combine(AbstractDependency<@NonNull ?> dependency1, AbstractDependency<@NonNull ?> dependency2) {
		if (dependency1 != null) {
			if (dependency2 != null) {
				return new AbstractDependency<@NonNull ?>[] {dependency1, dependency2};
			}
			else {
				return new AbstractDependency<@NonNull ?>[] {dependency1};
			}
		}
		else {
			if (dependency2 != null) {
				return new AbstractDependency<@NonNull ?>[] {dependency2};
			}
			else {
				return new AbstractDependency<@NonNull ?>[] {};
			}
		}
	}
}