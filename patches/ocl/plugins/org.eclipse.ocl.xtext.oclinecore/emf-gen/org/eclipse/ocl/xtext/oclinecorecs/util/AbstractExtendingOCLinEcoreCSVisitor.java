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
 * An AbstractExtendingOCLinEcoreCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLinEcoreCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements OCLinEcoreCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingOCLinEcoreCSVisitor(C context) {
		super(context);
	}

	@Override
	public R visitOCLinEcoreConstraintCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull OCLinEcoreConstraintCS object) {
		return visitConstraintCS(object);
	}

	@Override
	public R visitSysMLCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull SysMLCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull TopLevelCS object) {
		return visitRootPackageCS(object);
	}
}
