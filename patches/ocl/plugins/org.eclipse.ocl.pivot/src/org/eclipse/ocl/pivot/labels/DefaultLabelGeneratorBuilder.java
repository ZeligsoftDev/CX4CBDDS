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
package org.eclipse.ocl.pivot.labels;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * DefaultLabelGeneratorBuilder builds the label on behalf of a
 * ILabelGenerator.Registry using a StringBuilder.
 */
public class DefaultLabelGeneratorBuilder extends AbstractLabelGeneratorBuilder
{	
	protected final @NonNull StringBuilder s = new StringBuilder();
	
	public DefaultLabelGeneratorBuilder(ILabelGenerator.@NonNull Registry registry, @Nullable Object labelledObject, @Nullable Map<ILabelGenerator.Option<?>, Object> options) {
		super(registry, labelledObject, options);
	}

	@Override
	public void appendString(@Nullable String string) {
		if (string != null) {
			s.append(string);
		}
	}

	@Override
	public @NonNull String toString() {
		return s.toString();
	}
}