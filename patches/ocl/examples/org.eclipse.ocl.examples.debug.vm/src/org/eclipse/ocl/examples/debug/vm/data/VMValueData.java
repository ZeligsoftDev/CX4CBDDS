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

public class VMValueData implements Serializable
{
	private static final long serialVersionUID = 875965513717520820L;

	public static final int PRIMITIVE = 0;		
	public static final int OBJECT_REF = 1;
	public static final int COLLECTION_REF = 2;
	public static final int INVALID = 3;
	public static final int RESOURCE = 4;

	public static @NonNull VMValueData invalid() {
		return new VMValueData(INVALID, "OclInvalid"); //$NON-NLS-1$
	}

	public static @NonNull String toValueString(int status) {
		switch (status) {
		case PRIMITIVE: return "PRIMITIVE";
		case OBJECT_REF: return "OBJECT_REF";
		case COLLECTION_REF: return "COLLECTION_REF";
		case INVALID: return "INVALID";
		case RESOURCE: return "RESOURCE";
		}
		return "???";
	}
	
	public final int kind;
	public final @NonNull String value;
	public final boolean hasVariables;
	
	public VMValueData(int kind, @NonNull String value) {
		this(kind, value, false);
	}
	
	public VMValueData(int kind, @NonNull String value, boolean hasVariables) {
		this.kind = kind;
		this.value = value;
		this.hasVariables = hasVariables;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toValueString(kind) + ", " + value + ")";
	}	
}