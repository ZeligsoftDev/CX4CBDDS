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

public class VMTypeData implements Serializable
{		
	private static final long serialVersionUID = -966391641921455730L;
	
	public static final int DATATYPE = 0;
	public static final int EOBJECT = 1;		
	public static final int COLLECTION = 2;
	public static final int RESOURCE = 3;

	public static @NonNull String toTypeString(int status) {
		switch (status) {
		case DATATYPE: return "DATATYPE";
		case EOBJECT: return "EOBJECT";
		case COLLECTION: return "COLLECTION";
		case RESOURCE: return "RESOURCE";
		}
		return "???";
	}
	
	public final int kind;
	public final @NonNull String actualType;
	public final @Nullable String declaringType;
	
	public VMTypeData(int kind, @NonNull String actualType, @Nullable String declaringType) {
		this.kind = kind;
		this.declaringType = declaringType;
		this.actualType = actualType;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toTypeString(kind) + ", " + declaringType + ", " + actualType + ")";
	}	
}