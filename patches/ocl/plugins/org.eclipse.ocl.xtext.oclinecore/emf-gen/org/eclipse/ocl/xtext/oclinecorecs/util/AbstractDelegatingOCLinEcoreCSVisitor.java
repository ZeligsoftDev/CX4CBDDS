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
 * from: org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLinEcoreCSVisitor<R, C, @NonNull D extends OCLinEcoreCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R>
{
	protected AbstractDelegatingOCLinEcoreCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitOCLinEcoreConstraintCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull OCLinEcoreConstraintCS object) {
		return delegate.visitOCLinEcoreConstraintCS(object);
	}

	@Override
	public R visitSysMLCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull SysMLCS object) {
		return delegate.visitSysMLCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}
}
