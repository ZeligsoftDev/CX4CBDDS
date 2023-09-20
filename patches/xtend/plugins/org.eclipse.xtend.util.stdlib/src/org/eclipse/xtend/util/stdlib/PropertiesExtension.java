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
package org.eclipse.xtend.util.stdlib;

import java.util.Map.Entry;
import java.util.Properties;

/**
 * Java helper class for Stdlib extension <tt>org::openarchitectureware::util::stdlib::properties</tt>.
 */
public class PropertiesExtension {

	private static final Properties p = new Properties();
	
	public static void setProperties(Properties p) {
		for (Entry<Object, Object> entry : p.entrySet()) {
			PropertiesExtension.p.put(entry.getKey(), entry.getValue());
		}
	}

	public static String getProperty(String key) {
		if (key == null) {
			key = "";
		}
		return p.getProperty(key);
	}
	
	public static Properties getProperties() {
		return p;
	}

}
