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
package com.zeligsoft.cx.codegen.internal;

public class OawDebug {

	public static boolean isDebugEnabled() {
		return false;
	}

	public static void inspect( Long condition, Object obj ) {
		System.out.println( "[" + condition + "] inspecting " + obj );  //$NON-NLS-1$//$NON-NLS-2$
		condition.intValue();
	}

	public static Object debug(Object ret, String msg) {
		System.out.println(msg);
		return ret;
	}
}
