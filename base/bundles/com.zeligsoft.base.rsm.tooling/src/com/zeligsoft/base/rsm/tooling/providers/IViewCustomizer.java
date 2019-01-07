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

package com.zeligsoft.base.rsm.tooling.providers;

import org.eclipse.gmf.runtime.notation.View;

/**
* An Interface for customizing org.eclipse.gmf.runtime.notation.View
* elements.
* 
* @author jcorchis
* 
*/
public interface IViewCustomizer {
	/**
	 * Customize the provided view by setting it's <code>Style</code>s.
	 * 
	 * @param view
	 *            the View to customize
	 * @see org.eclipse.gmf.runtime.notation.Style
	 */
	public void customizeView(View view);
}
