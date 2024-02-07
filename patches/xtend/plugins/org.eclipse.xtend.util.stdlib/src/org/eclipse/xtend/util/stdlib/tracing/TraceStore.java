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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"rawtypes","unchecked"})
public class TraceStore {

	private List traces = new ArrayList();
	private MapList tracesBySource = new MapList();
	private MapList tracesByTarget = new MapList();


	public void add(TraceElement t) {
		traces.add(t);
		for (Iterator iter = t.getSources().iterator(); iter.hasNext();) {
			Object source = iter.next();
			tracesBySource.add( source , t);
		}
		if ( t instanceof M2MTraceElement ) {
			M2MTraceElement m2m = (M2MTraceElement)t;
			for (Iterator iter = m2m.getTargets().iterator(); iter.hasNext();) {
				Object target = iter.next();
				tracesByTarget.add( target , t);
			}
		}
	}

	public void clear() {
		traces = new ArrayList();
		tracesBySource = new MapList();
		tracesByTarget = new MapList();
	}

	public List getTraces(Object from, String kind) {
		return filter( tracesBySource.get(from), kind );
	}

	public List getTraces( Object from ) {
		return tracesBySource.get(from);
	}


	private List filter(List list, String kind) {
		List res = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			TraceElement element = (TraceElement) iter.next();
			if ( !(element instanceof M2MTraceElement) ) continue;
			if ( ((M2MTraceElement)element).getKind().equals(kind)) res.add( element );
		}
		return res;
	}


	public Collection getAllTraces() {
		return traces;
	}

	public Set getTraceSources() {
		return tracesBySource.getKeys();
	}



}
