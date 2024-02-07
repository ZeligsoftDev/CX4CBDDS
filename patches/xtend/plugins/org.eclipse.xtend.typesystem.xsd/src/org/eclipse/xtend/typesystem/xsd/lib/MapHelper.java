/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.lib;

import java.util.Map;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MapHelper {
	private static class SimpleMapEntry implements Map.Entry<Object, Object> {

		private Object key;

		private Object value;

		public SimpleMapEntry(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public Object setValue(Object value) {
			Object old = this.value;
			this.value = value;
			return old;
		}

	}

	public static Map.Entry<Object, Object> createMapEntry(Object key,
			Object value) {
		return new SimpleMapEntry(key, value);
	}

}
