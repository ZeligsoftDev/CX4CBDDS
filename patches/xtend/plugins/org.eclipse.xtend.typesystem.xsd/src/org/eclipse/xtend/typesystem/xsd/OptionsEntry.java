/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OptionsEntry {

	public OptionsEntry() {
		super();
	}

	public String key;
	public Object value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setVal(Object value) {
		this.value = value;
	}

	public OptionsEntry(String key, Object value) {
		this.key = key;
		this.value = value;
	}

}
