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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractCompleteOCLCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCompleteOCLCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements CompleteOCLCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractCompleteOCLCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitClassifierContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ClassifierContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	@Override
	public @Nullable Element visitCompleteOCLDocumentCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull CompleteOCLDocumentCS csElement) {
		return visitNamespaceCS(csElement);
	}

	@Override
	public @Nullable Element visitContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull ContextDeclCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	@Override
	public @Nullable Element visitDefCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitDefOperationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefOperationCS csElement) {
		return visitDefCS(csElement);
	}

	@Override
	public @Nullable Element visitDefPropertyCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull DefPropertyCS csElement) {
		return visitDefCS(csElement);
	}

	@Override
	public @Nullable Element visitFeatureContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull FeatureContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	@Override
	public @Nullable Element visitOCLMessageArgCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OCLMessageArgCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Element visitOperationContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull OperationContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}

	@Override
	public @Nullable Element visitPackageDeclarationCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PackageDeclarationCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	@Override
	public @Nullable Element visitPathNameDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PathNameDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPropertyContextDeclCS(org.eclipse.ocl.xtext.completeoclcs.@NonNull PropertyContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}
}
