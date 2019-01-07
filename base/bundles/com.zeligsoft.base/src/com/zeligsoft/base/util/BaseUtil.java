/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

/**
 * Utility class
 * 
 * @author ysroh
 * 
 */
public class BaseUtil {

	/**
	 * Return sorted list of give EObjects
	 * 
	 * @param elements
	 * @return
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("rawtypes")
	public static List sortEObjectsByName(Collection elements)
			throws IllegalArgumentException {
		Map<String, EObject> map = new HashMap<String, EObject>();
		for (Object o : elements) {
			if (o instanceof EObject) {
				map.put(EMFCoreUtil.getName((EObject) o), (EObject) o);
			} else {
				throw new IllegalArgumentException();
			}
		}
		Object[] keyArray = map.keySet().toArray();
		Arrays.sort(keyArray);
		List<EObject> result = new ArrayList<EObject>();
		for (Object key : keyArray) {
			result.add(map.get(key));
		}
		return result;
	}
}