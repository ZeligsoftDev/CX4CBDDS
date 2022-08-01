/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.cx.ui.pathmap;

/**
 * Pathmap change listener
 * 
 * @author Young-Soo Roh
 *
 */
public interface PathmapChangeListener {
	public static int ADD = 1;
	public static int CHANGE = 2;
	public static int REMOVE = 3;
	public static int FALLBACK = 4;

	public void handlePathmapChange(CXPathmapDescriptor newValue, CXPathmapDescriptor oldValue, int eventType);

}
