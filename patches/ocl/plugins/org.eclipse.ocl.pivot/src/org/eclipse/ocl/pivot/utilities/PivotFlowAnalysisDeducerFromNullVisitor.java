/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysisDeducerFromNullVisitor;

/**
 * @since 1.7
 */
public class PivotFlowAnalysisDeducerFromNullVisitor extends FlowAnalysisDeducerFromNullVisitor
{
	public PivotFlowAnalysisDeducerFromNullVisitor(@NonNull FlowAnalysis flowAnalysis, boolean isNull) {
		super(flowAnalysis, isNull);
	}
}