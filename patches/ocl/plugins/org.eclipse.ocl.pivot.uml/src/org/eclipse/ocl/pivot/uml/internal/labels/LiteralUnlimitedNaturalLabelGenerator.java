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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

public class LiteralUnlimitedNaturalLabelGenerator extends AbstractLabelGenerator<LiteralUnlimitedNatural>
{
	public static void initialize(Registry registry) {
		registry.install(LiteralUnlimitedNatural.class, new LiteralUnlimitedNaturalLabelGenerator());		
	}
	
	public LiteralUnlimitedNaturalLabelGenerator() {
		super(LiteralUnlimitedNatural.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull LiteralUnlimitedNatural object) {
		int value = object.getValue();
		labelBuilder.appendString(value >= 0 ? Integer.toString(value) : "*");
	}
}