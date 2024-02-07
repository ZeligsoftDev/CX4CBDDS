/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.xtext.oclinecorecs.SysMLCS;
import org.eclipse.ocl.xtext.oclinecorecs.util.AbstractOCLinEcoreCSPostOrderVisitor;

public class OCLinEcoreCSPostOrderVisitor extends AbstractOCLinEcoreCSPostOrderVisitor
{
	public OCLinEcoreCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitOCLinEcoreConstraintCS(@NonNull OCLinEcoreConstraintCS csConstraint) {
		Continuation<?> continuation = super.visitOCLinEcoreConstraintCS(csConstraint);
		Constraint pivotElement = PivotUtil.getPivot(Constraint.class, csConstraint);
		if (pivotElement != null) {
			pivotElement.setIsCallable(csConstraint.isIsCallable());
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitSysMLCS(@NonNull SysMLCS csSysML) {
		Annotation pivotElement = PivotUtil.getPivot(Annotation.class, csSysML);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csSysML, pivotElement);
			context.refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csSysML.getOwnedDetails());
		}
		return null;
	}
}