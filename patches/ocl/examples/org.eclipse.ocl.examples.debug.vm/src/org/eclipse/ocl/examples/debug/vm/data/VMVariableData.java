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
package org.eclipse.ocl.examples.debug.vm.data;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class VMVariableData implements Serializable
{
	private static final long serialVersionUID = 1038270932235501034L;

	public static final int LOCAL = 0;
	public static final int ATTRIBUTE = 1;
	public static final int REFERENCE = 2;
	public static final int PREDEFINED_VAR = 3;
	public static final int MODEL_PARAMETER = 4;
	public static final int INTERM_PROPERTY = 5;
	public static final int COLLECTION_ELEMENT = 6;

	public static @NonNull String toKindString(int kind) {
		switch (kind) {
		case LOCAL: return "LOCAL";
		case ATTRIBUTE: return "ATTRIBUTE";
		case REFERENCE: return "REFERENCE";
		case PREDEFINED_VAR: return "PREDEFINED_VAR";
		case MODEL_PARAMETER: return "MODEL_PARAMETER";
		case INTERM_PROPERTY: return "INTERM_PROPERTY";
		case COLLECTION_ELEMENT: return "COLLECTION_ELEMENT";
		}
		return "???";
	}
	
	public final @NonNull String name;
	public final @Nullable String variableURI;
	public VMValueData value;
	public Object valueObject;
	public VMTypeData type;
	public int kind;
	
	public VMVariableData(@NonNull String name, @Nullable String variableURI) {
		this.name = name;
		this.variableURI = variableURI;
	}
	
	public boolean isRootVariable() {
		return variableURI == null;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(").append(toKindString(kind));
		s.append(",").append(variableURI);
		s.append(",").append(name);
		s.append(":").append(type);
		s.append("=").append(valueObject);
		s.append(")");
		return s.toString();
	}
}