/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib.tracing;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public class M2CTraceElement extends TraceElement {

	private String fileName;
	private String token;

	public M2CTraceElement( String kind, EObject from, String fileName, String token) {
		super( from, kind );
		this.fileName = fileName;
		this.token = token;
	}
	
	public M2CTraceElement( String kind, Collection<EObject> from, String fileName,String token ) {
		super( from, kind );
		this.fileName = fileName;
		this.token = token;
	}

	public String getFileName() {
		return fileName;
	}

	public String getToken() {
		return token;
	}
	
}
