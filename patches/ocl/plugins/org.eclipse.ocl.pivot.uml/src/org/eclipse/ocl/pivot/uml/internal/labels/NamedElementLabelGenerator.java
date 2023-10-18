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
package org.eclipse.ocl.pivot.uml.internal.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.uml2.uml.NamedElement;

public final class NamedElementLabelGenerator extends AbstractLabelGenerator<NamedElement>
{
	public static void initialize(Registry registry) {
		registry.install(NamedElement.class, new NamedElementLabelGenerator());		
	}
	
	public NamedElementLabelGenerator() {
		super(NamedElement.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull NamedElement object) {
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