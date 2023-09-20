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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapList {

	private Map<Object, List<Object>> map = new HashMap<Object, List<Object>>();

	public void add( Object key, Object content ) {
		getList(key).add(content);
	}

	private List<Object> getList(Object key) {
		List<Object> l = map.get(key);
		if ( l == null ) {
			l = new ArrayList<Object>();
			map.put(key, l);
		}
		return l;
	}

	public List<Object> get(Object key) {
		return getList(key);
	}

	public Set<Object> getKeys() {
		return map.keySet();
	}

}
