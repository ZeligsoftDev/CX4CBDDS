/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.response;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;

public class VMVariableResponse extends VMResponse
{
	private static final long serialVersionUID = -8851333069785318138L;

	public final @NonNull VMVariableData variable;
	public final @NonNull VMVariableData @Nullable [] childVariables;
	
	public VMVariableResponse(@NonNull VMVariableData variable, @NonNull VMVariableData @Nullable [] childVariables) {
		this.variable = variable;
		this.childVariables = childVariables;
	}
	
	public VMVariableResponse(@NonNull VMVariableData variable) {
		this(variable, null);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		s.append(", ");
		s.append(variable);
		@NonNull VMVariableData @Nullable [] childVariables2 = childVariables;
		if (childVariables2 != null) {
			s.append(", {");
			for (int i = 0; i < childVariables2.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(childVariables2[i]);
			}
			s.append("}");
		}
		return s.toString();
	}
}