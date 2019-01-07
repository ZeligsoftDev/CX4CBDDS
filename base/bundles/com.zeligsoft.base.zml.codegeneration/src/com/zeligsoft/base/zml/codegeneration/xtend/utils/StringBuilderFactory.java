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

package com.zeligsoft.base.zml.codegeneration.xtend.utils;

import java.util.HashMap;

public class StringBuilderFactory {

	private static HashMap<String, String> mymap = null;

	public static void Init() {
		mymap = new HashMap<String, String>();
	}

	public static void CreateStringBuilder(String name) {
		if (mymap == null) {
			Init();
		}

		mymap.put(name, ""); //$NON-NLS-1$
	}

	public static void StringBuilderConcat(String name, String add) {
		if (mymap.containsKey(name) == true) {
			mymap.put(name, mymap.get(name) + add);
		}
		return;
	}

	public static String StringBuilderGet(String name) {
		if (mymap.containsKey(name) == true) {
			return mymap.get(name);
		} else {
			return ""; //$NON-NLS-1$
		}
	}
}
