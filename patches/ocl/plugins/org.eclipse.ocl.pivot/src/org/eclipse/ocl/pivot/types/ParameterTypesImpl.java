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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorParameter;

/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public class ParameterTypesImpl implements ParameterTypes
{
	public static final @NonNull ParameterTypesImpl EMPTY_LIST = new ParameterTypesImpl();
	
	private final @NonNull ParametersId parametersId;
	private final @NonNull Type @NonNull [] parameterTypes;
	private final int hashCode;
	private /*@LazyNonNull*/ List<Parameter> parameters = null;
	
	public ParameterTypesImpl(@NonNull Type @NonNull ... parameterTypes) {
		this.parametersId = IdManager.getParametersId(parameterTypes);
		this.parameterTypes = parameterTypes;
		hashCode = parametersId.hashCode() + 0x999;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ParameterTypesImpl)) {
			return false;
		}
		ParameterTypesImpl that = (ParameterTypesImpl)obj;
		if (hashCode() != that.hashCode()) {
			return false;
		}
		Type[] thoseParameters = that.parameterTypes;
		if (parameterTypes.length != thoseParameters.length) {
			return false;
		}
		for (int i = 0; i < parameterTypes.length; i++) {
			if (!parameterTypes[i].equals(thoseParameters[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull Type get(int index) {
		Type parameterType = parameterTypes[index];
		assert parameterType != null;
		return parameterType;
	}

	@Override
	public @NonNull Type @NonNull [] get() {
		return parameterTypes;
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}
	
	@Override
	public @NonNull List<Parameter> getParameters() {
		List<Parameter> parameters2 = parameters;
		if (parameters2 == null) {
			parameters = parameters2 = new ArrayList<Parameter>();
			for (int i = 0; i < parameterTypes.length; i++) {
				Type type = parameterTypes[i];
				parameters2.add(new AbstractExecutorParameter("_" + i, type, false));
			}
		}
		return parameters2;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public int size() {
		return parameterTypes.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(parameterTypes[i].toString());
		}
		s.append(')');
		return s.toString();
	}
}