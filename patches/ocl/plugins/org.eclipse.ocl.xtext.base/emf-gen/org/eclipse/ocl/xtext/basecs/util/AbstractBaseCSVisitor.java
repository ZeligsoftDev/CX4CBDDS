/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.basecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/*
 * An AbstractBaseCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	/**
	 * Context for the AST visitation.
	 */
	protected final C context;

	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractBaseCSVisitor(C context) {
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A> @Nullable A getAdapter(@NonNull Class<A> adapter) {
		if (adapter.isAssignableFrom(getClass())) {
			return (A) this;
		}
		else {
			return null;
		}
	}

	/**
	 * A null-safe visitation of the specified visitable.
	 *
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public @Nullable R safeVisit(org.eclipse.ocl.xtext.basecs.util.@Nullable VisitableCS v) {
		return (v == null) ? null : v.accept(this);
	}

	/**
	 * Perform a visit to the specified visitable.
	 *
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public R visit(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS v) {
		return v.accept(this);
	}

	//	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
	//		return null;
	//	}
}
