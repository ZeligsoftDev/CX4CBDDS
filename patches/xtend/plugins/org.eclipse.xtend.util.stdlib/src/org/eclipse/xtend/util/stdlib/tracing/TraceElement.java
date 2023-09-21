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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class TraceElement {

	private List<EObject> sources = new ArrayList<EObject>();
	private String kind;
	
	public TraceElement( EObject from, String kind ) {
		sources.add( from );
		this.kind = kind;
	}
	
	public TraceElement( Collection<EObject> from, String kind ) {
		sources.addAll( from );
		this.kind = kind;
	}

	public List<EObject> getSources() {
		return sources;
	}

	public boolean isSingleSource() {
		return sources.size() == 1;
	}
	

	public String getKind() {
		return kind;
	}
	
	
}