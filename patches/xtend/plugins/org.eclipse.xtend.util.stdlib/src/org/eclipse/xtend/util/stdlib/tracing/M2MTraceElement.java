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

public class M2MTraceElement extends TraceElement {

	private List<EObject> targets = new ArrayList<EObject>();
	
	public M2MTraceElement( String kind, EObject from, EObject to ) {
		super(from, kind);
		targets.add( to );
	}
	
	public M2MTraceElement( String kind, EObject from, Collection<EObject> to ) {
		super(from, kind);
		targets.addAll( to );
	}
	
	public M2MTraceElement( String kind, Collection<EObject> from, EObject to ) {
		super(from, kind);
		targets.add( to );
	}

	public List<EObject> getTargets() {
		return targets;
	}
	
	public boolean isSingleTarget() {
		return targets.size() == 1;
	}
	
	
}
