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
 * from: org.eclipse.ocl.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLstdlibCSVisitor<R, C, @NonNull D extends OCLstdlibCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R>
{
	protected AbstractDelegatingOCLstdlibCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitJavaClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaClassCS object) {
		return delegate.visitJavaClassCS(object);
	}

	@Override
	public R visitJavaImplementationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaImplementationCS object) {
		return delegate.visitJavaImplementationCS(object);
	}

	@Override
	public R visitLibClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibClassCS object) {
		return delegate.visitLibClassCS(object);
	}

	@Override
	public R visitLibCoercionCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibCoercionCS object) {
		return delegate.visitLibCoercionCS(object);
	}

	@Override
	public R visitLibConstraintCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibConstraintCS object) {
		return delegate.visitLibConstraintCS(object);
	}

	@Override
	public R visitLibIterationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibIterationCS object) {
		return delegate.visitLibIterationCS(object);
	}

	@Override
	public R visitLibOperationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOperationCS object) {
		return delegate.visitLibOperationCS(object);
	}

	@Override
	public R visitLibOppositeCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOppositeCS object) {
		return delegate.visitLibOppositeCS(object);
	}

	@Override
	public R visitLibPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPackageCS object) {
		return delegate.visitLibPackageCS(object);
	}

	@Override
	public R visitLibPropertyCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPropertyCS object) {
		return delegate.visitLibPropertyCS(object);
	}

	@Override
	public R visitLibRootPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibRootPackageCS object) {
		return delegate.visitLibRootPackageCS(object);
	}

	@Override
	public R visitMetaclassNameCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull MetaclassNameCS object) {
		return delegate.visitMetaclassNameCS(object);
	}

	@Override
	public R visitPrecedenceCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull PrecedenceCS object) {
		return delegate.visitPrecedenceCS(object);
	}
}
