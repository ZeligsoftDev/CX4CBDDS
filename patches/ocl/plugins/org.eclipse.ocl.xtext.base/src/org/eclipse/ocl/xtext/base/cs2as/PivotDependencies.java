/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

public class PivotDependencies extends AbstractDependency<@NonNull Collection<@NonNull ? extends ModelElementCS>>
{
	public PivotDependencies(@NonNull Collection<@NonNull ? extends ModelElementCS> csElements) {
		super(csElements);
	}

	@Override
	public boolean canExecute() {
		for (@NonNull ModelElementCS csElement : element) {
			if (csElement.getPivot() == null) {
				return false;
			}
		}
		return true;
	}
}