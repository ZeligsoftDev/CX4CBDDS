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
import org.eclipse.uml2.uml.Slot;

public final class SlotLabelGenerator extends AbstractLabelGenerator<Slot>
{
	public static void initialize(Registry registry) {
		registry.install(Slot.class, new SlotLabelGenerator());		
	}
	
	public SlotLabelGenerator() {
		super(Slot.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Slot object) {
		String name = object.getDefiningFeature().getName();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-featured-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}