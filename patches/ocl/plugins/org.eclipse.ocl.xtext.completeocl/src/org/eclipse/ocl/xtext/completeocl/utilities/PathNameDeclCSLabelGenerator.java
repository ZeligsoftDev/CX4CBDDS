/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS;

public final class PathNameDeclCSLabelGenerator extends AbstractLabelGenerator<PathNameDeclCS>
{
	public static void initialize(Registry registry) {
		registry.install(PathNameDeclCS.class, new PathNameDeclCSLabelGenerator());
	}

	public PathNameDeclCSLabelGenerator() {
		super(PathNameDeclCS.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull PathNameDeclCS object) {
		String name = null;
		Element element = object.getPivot();
		if (element instanceof Nameable) {
			name = ((Nameable)element).getName();
		}
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-pivoted-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}