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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullOCLstdlibCSVisitor<@Nullable R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractNullEssentialOCLCSVisitor<R, C> implements OCLstdlibCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullOCLstdlibCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitJavaClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaClassCS object) {
		return null;
	}

	@Override
	public R visitJavaImplementationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaImplementationCS object) {
		return null;
	}

	@Override
	public R visitLibClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibClassCS object) {
		return null;
	}

	@Override
	public R visitLibCoercionCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibCoercionCS object) {
		return null;
	}

	@Override
	public R visitLibConstraintCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibConstraintCS object) {
		return null;
	}

	@Override
	public R visitLibIterationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibIterationCS object) {
		return null;
	}

	@Override
	public R visitLibOperationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOperationCS object) {
		return null;
	}

	@Override
	public R visitLibOppositeCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOppositeCS object) {
		return null;
	}

	@Override
	public R visitLibPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPackageCS object) {
		return null;
	}

	@Override
	public R visitLibPropertyCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPropertyCS object) {
		return null;
	}

	@Override
	public R visitLibRootPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibRootPackageCS object) {
		return null;
	}

	@Override
	public R visitMetaclassNameCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull MetaclassNameCS object) {
		return null;
	}

	@Override
	public R visitPrecedenceCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull PrecedenceCS object) {
		return null;
	}
}
