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
 * An AbstractExtendingCompleteOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCompleteOCLCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements CompleteOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingCompleteOCLCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitClassifierContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ClassifierContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	@Override
	public R visitCompleteOCLDocumentCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull CompleteOCLDocumentCS object) {
		return visitNamespaceCS(object);
	}

	@Override
	public R visitContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ContextDeclCS object) {
		return visitPathNameDeclCS(object);
	}

	@Override
	public R visitDefCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitDefOperationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefOperationCS object) {
		return visitDefCS(object);
	}

	@Override
	public R visitDefPropertyCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefPropertyCS object) {
		return visitDefCS(object);
	}

	@Override
	public R visitFeatureContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull FeatureContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	@Override
	public R visitOCLMessageArgCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OCLMessageArgCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitOperationContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OperationContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}

	@Override
	public R visitPackageDeclarationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PackageDeclarationCS object) {
		return visitPathNameDeclCS(object);
	}

	@Override
	public R visitPathNameDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PathNameDeclCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitPropertyContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PropertyContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}
}
