/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.oclinecorecs.SysMLCS;
import org.eclipse.ocl.xtext.oclinecorecs.util.AbstractOCLinEcoreCSContainmentVisitor;

public class OCLinEcoreCSContainmentVisitor extends AbstractOCLinEcoreCSContainmentVisitor
{
	public OCLinEcoreCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitSysMLCS(@NonNull SysMLCS csElement) {
		@NonNull Annotation pivotElement = context.refreshModelElement(Annotation.class, PivotPackage.Literals.ANNOTATION, csElement);
		helper.refreshName(pivotElement, PivotConstants.SYSML_ANNOTATION_SOURCE);
		context.refreshComments(pivotElement, csElement);
		return null;
	}
}
