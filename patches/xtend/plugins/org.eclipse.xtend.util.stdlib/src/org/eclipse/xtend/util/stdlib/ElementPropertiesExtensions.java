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

import java.util.HashMap;
import java.util.Map;

/**
 * Java helper class for Stdlib extension <tt>org::eclipse::xtend::util::stdlib::elementprops</tt>.
 * 
 * @author Karsten Thoms - Bug#310361
 */
public class ElementPropertiesExtensions extends AbstractStatefulExtensions<Map<String,Object>> {
	private static Map<Object, Map<String,Object>> outerMap;
	/**
	 * As reported with Bug#310361 this extension was causing memory leaks due to holding the
	 * properties in a static map. This was refactored by deriving from {@link AbstractStatefulExtensions},
	 * which stores properties in the {@link org.eclipse.xtend.expression.ExecutionContext ExecutionContext}.
	 * But since there are known Xpand generators that rely on the static nature of these properties, which
	 * needs to be preserved over workflow executions, the old implementation is preserved. By setting
	 * legacy mode, the properties will again be stored in a static map.
	 * Unsetting legacy mode will remove the static map and thus free memory again.
	 * @deprecated This feature is only for backward compatibility and will be removed in future versions
	 */
	@Deprecated
	public static void setLegacyMode (boolean enable) {
		if (enable) {
			outerMap = new HashMap<Object, Map<String,Object>>();
		} else{
			outerMap = null;
		}
	}
	
	@Override
	protected Map<String,Object> getDefault(Object o) {
		return new HashMap<String, Object>();
	}

	public void setProperty( Object element, String name, Object value ) {
		final Map<String,Object> innerMap = getInnerMap(element);
		if (value != null) {
			innerMap.put( name , value );
		} else {
			innerMap.remove( name );
		}
		if (outerMap == null) {
			set(element,innerMap); // only in non-legacy mode
		}
	}

	public Object getProperty( Object element, String name ) {
		final Map<String,Object> innerMap = getInnerMap(element);
		return innerMap.get( name );
	}
	
	private Map<String,Object> getInnerMap (Object element) {
		if (outerMap == null) {
			return this.get(element);
		} else {
			// legacy
			Map<String,Object> innerMap = outerMap.get(element);
			if ( innerMap == null ) {
				innerMap = new HashMap<String, Object>();
				outerMap.put(element, innerMap);
			}
			return innerMap;
		}
	}
	
}
