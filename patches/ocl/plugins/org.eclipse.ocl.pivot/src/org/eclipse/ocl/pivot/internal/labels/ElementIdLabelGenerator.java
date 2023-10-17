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
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class ElementIdLabelGenerator extends AbstractLabelGenerator<ElementId>
{
	public static void initialize(Registry registry) {
		registry.install(ElementId.class, new ElementIdLabelGenerator());		
	}
	
	public ElementIdLabelGenerator() {
		super(ElementId.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull ElementId object) {
		String name = object.getDisplayName();
		labelBuilder.appendString(name);
	}
}