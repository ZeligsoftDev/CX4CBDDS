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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSPreOrderVisitor;

/**
 * An AbstractOCLinEcoreCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLinEcoreCSPreOrderVisitor
	extends EssentialOCLCSPreOrderVisitor
	implements OCLinEcoreCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractOCLinEcoreCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitOCLinEcoreConstraintCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull OCLinEcoreConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSysMLCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull SysMLCS csElement) {
		return visitAnnotationElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTopLevelCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}
