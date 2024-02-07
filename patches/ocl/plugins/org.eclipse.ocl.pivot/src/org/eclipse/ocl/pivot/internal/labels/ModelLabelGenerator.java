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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

public final class ModelLabelGenerator extends AbstractLabelGenerator<Model>
{
	public static void initialize(Registry registry) {
		registry.install(Model.class, new ModelLabelGenerator());		
	}
	
	public ModelLabelGenerator() {
		super(Model.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Model object) {
		if (object == labelBuilder.getLabelledObject()) {
			String name = object.getExternalURI();
			if (name != null)
				labelBuilder.appendString(name);
			else {
				labelBuilder.appendString("<null-uri-");
				labelBuilder.appendString(object.getClass().getSimpleName());
				labelBuilder.appendString(">");
			}
		}
	}
}