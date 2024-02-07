/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;

public final class NamedElementCSLabelGenerator extends AbstractLabelGenerator<NamedElementCS>
{
	public static void initialize(Registry registry) {
		registry.install(NamedElementCS.class, new NamedElementCSLabelGenerator());
	}

	public NamedElementCSLabelGenerator() {
		super(NamedElementCS.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull NamedElementCS object) {
		String name = object.getName();
		if (name == null) {
			Element element = object.getPivot();
			if (element instanceof Nameable) {
				name = ((Nameable)element).getName();
			}
		}
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-named-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}