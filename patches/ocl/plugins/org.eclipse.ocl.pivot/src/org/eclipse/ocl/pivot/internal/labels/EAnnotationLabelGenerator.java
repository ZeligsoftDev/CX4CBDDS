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
package org.eclipse.ocl.pivot.internal.labels;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class EAnnotationLabelGenerator extends AbstractLabelGenerator<EAnnotation>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(EAnnotation.class, new EAnnotationLabelGenerator());		
	}
	
	public EAnnotationLabelGenerator() {
		super(EAnnotation.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull EAnnotation object) {
		String name = object.getSource();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-sourced-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}