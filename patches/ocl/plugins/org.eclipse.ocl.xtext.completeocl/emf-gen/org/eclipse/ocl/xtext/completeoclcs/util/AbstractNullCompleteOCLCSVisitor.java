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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullCompleteOCLCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullCompleteOCLCSVisitor<@Nullable R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractNullEssentialOCLCSVisitor<R, C> implements CompleteOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullCompleteOCLCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitClassifierContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ClassifierContextDeclCS object) {
		return null;
	}

	@Override
	public R visitCompleteOCLDocumentCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull CompleteOCLDocumentCS object) {
		return null;
	}

	@Override
	public R visitContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ContextDeclCS object) {
		return null;
	}

	@Override
	public R visitDefCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefCS object) {
		return null;
	}

	@Override
	public R visitDefOperationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefOperationCS object) {
		return null;
	}

	@Override
	public R visitDefPropertyCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefPropertyCS object) {
		return null;
	}

	@Override
	public R visitFeatureContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull FeatureContextDeclCS object) {
		return null;
	}

	@Override
	public R visitOCLMessageArgCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OCLMessageArgCS object) {
		return null;
	}

	@Override
	public R visitOperationContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OperationContextDeclCS object) {
		return null;
	}

	@Override
	public R visitPackageDeclarationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PackageDeclarationCS object) {
		return null;
	}

	@Override
	public R visitPathNameDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PathNameDeclCS object) {
		return null;
	}

	@Override
	public R visitPropertyContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PropertyContextDeclCS object) {
		return null;
	}
}
