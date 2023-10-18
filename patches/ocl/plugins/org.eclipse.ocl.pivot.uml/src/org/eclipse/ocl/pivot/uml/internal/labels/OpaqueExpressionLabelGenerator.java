/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.labels;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.uml2.uml.OpaqueExpression;

public class OpaqueExpressionLabelGenerator extends AbstractLabelGenerator<OpaqueExpression>
{
	public static void initialize(Registry registry) {
		registry.install(OpaqueExpression.class, new OpaqueExpressionLabelGenerator());		
	}
	
	public OpaqueExpressionLabelGenerator() {
		super(OpaqueExpression.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull OpaqueExpression object) {
		List<String> bodies = object.getBodies();
		if (bodies.size() < 1) {
			labelBuilder.appendString("<null-body>");
		}
		else {
			labelBuilder.appendString(bodies.get(0));
		}
	}
}