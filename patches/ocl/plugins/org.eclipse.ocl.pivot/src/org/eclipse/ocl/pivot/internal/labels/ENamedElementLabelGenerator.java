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

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class ENamedElementLabelGenerator extends AbstractLabelGenerator<ENamedElement>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(ENamedElement.class, new ENamedElementLabelGenerator());		
	}
	
	public ENamedElementLabelGenerator() {
		super(ENamedElement.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ENamedElement object) {
		if (!labelBuilder.hasOption(Builder.SHOW_QUALIFIER))	{		// Legacy behavior
			EObject eContainer = object.eContainer();
			if (eContainer != null) {
				labelBuilder.getRegistry().buildSubLabelFor(labelBuilder, eContainer);
				labelBuilder.appendString("/");
			}
		}
		String name = object.getName();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-named-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}