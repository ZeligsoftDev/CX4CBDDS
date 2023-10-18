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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractOCLinEcoreCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLinEcoreCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements OCLinEcoreCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractOCLinEcoreCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitOCLinEcoreConstraintCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull OCLinEcoreConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	@Override
	public @Nullable Element visitSysMLCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull SysMLCS csElement) {
		return visitAnnotationElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTopLevelCS(org.eclipse.ocl.xtext.oclinecorecs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}
