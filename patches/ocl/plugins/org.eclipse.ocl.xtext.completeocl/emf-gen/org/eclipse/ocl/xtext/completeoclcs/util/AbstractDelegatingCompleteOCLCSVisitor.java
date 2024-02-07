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
 * from: org.eclipse.ocl.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingCompleteOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingCompleteOCLCSVisitor<R, C, @NonNull D extends CompleteOCLCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements CompleteOCLCSVisitor<R>
{
	protected AbstractDelegatingCompleteOCLCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitClassifierContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ClassifierContextDeclCS object) {
		return delegate.visitClassifierContextDeclCS(object);
	}

	@Override
	public R visitCompleteOCLDocumentCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull CompleteOCLDocumentCS object) {
		return delegate.visitCompleteOCLDocumentCS(object);
	}

	@Override
	public R visitContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ContextDeclCS object) {
		return delegate.visitContextDeclCS(object);
	}

	@Override
	public R visitDefCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefCS object) {
		return delegate.visitDefCS(object);
	}

	@Override
	public R visitDefOperationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefOperationCS object) {
		return delegate.visitDefOperationCS(object);
	}

	@Override
	public R visitDefPropertyCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefPropertyCS object) {
		return delegate.visitDefPropertyCS(object);
	}

	@Override
	public R visitFeatureContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull FeatureContextDeclCS object) {
		return delegate.visitFeatureContextDeclCS(object);
	}

	@Override
	public R visitOCLMessageArgCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OCLMessageArgCS object) {
		return delegate.visitOCLMessageArgCS(object);
	}

	@Override
	public R visitOperationContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OperationContextDeclCS object) {
		return delegate.visitOperationContextDeclCS(object);
	}

	@Override
	public R visitPackageDeclarationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PackageDeclarationCS object) {
		return delegate.visitPackageDeclarationCS(object);
	}

	@Override
	public R visitPathNameDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PathNameDeclCS object) {
		return delegate.visitPathNameDeclCS(object);
	}

	@Override
	public R visitPropertyContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PropertyContextDeclCS object) {
		return delegate.visitPropertyContextDeclCS(object);
	}
}
