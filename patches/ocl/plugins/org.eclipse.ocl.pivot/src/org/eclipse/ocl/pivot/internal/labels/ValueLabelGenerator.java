/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.ocl.pivot.values.Value;

public final class ValueLabelGenerator extends AbstractLabelGenerator<Value>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(Value.class, new ValueLabelGenerator());		
	}
	
	public ValueLabelGenerator() {
		super(Value.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull Value object) {
		labelBuilder.appendString(object.toString());
	}
}