/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public class ExpressionInOCLLabelGenerator extends AbstractLabelGenerator<ExpressionInOCL>
{
	public static void initialize(Registry registry) {
		registry.install(ExpressionInOCL.class, new ExpressionInOCLLabelGenerator());		
	}
	
	public ExpressionInOCLLabelGenerator() {
		super(ExpressionInOCL.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ExpressionInOCL object) {
		labelBuilder.appendString(PivotUtilInternal.getSpecificationRole(object));
	}
}