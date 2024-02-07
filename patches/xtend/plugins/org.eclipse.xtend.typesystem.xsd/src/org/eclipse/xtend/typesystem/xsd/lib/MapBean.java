/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.lib;

import java.util.HashMap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MapBean extends HashMap<Object, Object> {
	private static final long serialVersionUID = 2345498520162959364L;

	public static class MapEntryBean {
		private Object from;
		private Object to;

		public Object getFrom() {
			return from;
		}

		public Object getTo() {
			return to;
		}

		public void setFrom(Object from) {
			this.from = from;
		}

		public void setTo(Object to) {
			this.to = to;
		}
	}

	public void addMapping(MapEntryBean entry) {
		put(entry.getFrom(), entry.getTo());
	}

}
