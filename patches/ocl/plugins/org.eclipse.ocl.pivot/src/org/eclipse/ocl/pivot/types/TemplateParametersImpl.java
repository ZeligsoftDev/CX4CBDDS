/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.types;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;

/**
 * TemplateParameters provides a hashable list of type
 * parameters suitable for use when indexing specializations.
 */
public class TemplateParametersImpl implements TemplateParameters
{
	
	private final @NonNull Type @NonNull [] typeParameters;
	private final int hashCode;

	public TemplateParametersImpl(@NonNull TemplateParameter... typeParameters) {
		this.typeParameters = new @NonNull Type[typeParameters.length];
		int hash = 0;
		for (int i = 0; i < typeParameters.length; i++) {
			Type parameter = typeParameters[i];
			hash = 111 * hash + parameter.hashCode();
			this.typeParameters[i] = parameter;
		}
		hashCode = hash;
	}
	
	public TemplateParametersImpl(@NonNull List<@NonNull ? extends Type> parameters) {
		typeParameters = new @NonNull Type[parameters.size()];
		int hash = 0;
		for (int i = 0; i < typeParameters.length; i++) {
			Type parameter = parameters.get(i);
			hash = 111 * hash + parameter.hashCode();
			this.typeParameters[i] = parameter;
		}
		hashCode = hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TemplateParametersImpl)) {
			return false;
		}
		TemplateParametersImpl that = (TemplateParametersImpl)o;
		if (this.hashCode != that.hashCode){
			return false;
		}
		int iMax = typeParameters.length;
		if (iMax != that.typeParameters.length) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			@NonNull Type thisParameter = this.typeParameters[i];
			@NonNull Type thatParameter = that.typeParameters[i];
			if (!thisParameter.equals(thatParameter)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull Type get(int i) {
		return typeParameters[i];
	}		

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public int parametersSize() {
		return typeParameters.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < typeParameters.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(String.valueOf(typeParameters[i]));
		}
		s.append(')');
		return s.toString();
	}
}
