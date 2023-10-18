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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractOCLstdlibCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLstdlibCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements OCLstdlibCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractOCLstdlibCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitJavaClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaClassCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitJavaImplementationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull JavaImplementationCS csElement) {
		return visitElementCS(csElement);
	}

	@Override
	public @Nullable Element visitLibClassCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibClassCS csElement) {
		return visitStructuredClassCS(csElement);
	}

	@Override
	public @Nullable Element visitLibCoercionCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibCoercionCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibConstraintCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	@Override
	public @Nullable Element visitLibIterationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibIterationCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibOperationCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibOppositeCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibOppositeCS csElement) {
		return visitFeatureCS(csElement);
	}

	@Override
	public @Nullable Element visitLibPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPackageCS csElement) {
		return visitPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitLibPropertyCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibPropertyCS csElement) {
		return visitAttributeCS(csElement);
	}

	@Override
	public @Nullable Element visitLibRootPackageCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull LibRootPackageCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitMetaclassNameCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull MetaclassNameCS csElement) {
		return visitElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPrecedenceCS(org.eclipse.ocl.xtext.oclstdlibcs.@NonNull PrecedenceCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
