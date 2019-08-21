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

package com.zeligsoft.base.ui.viewcustomizers;

import org.eclipse.gmf.runtime.notation.View;

/**
 * View customizer for UML Class views. 
 * 
 * 
 * @author schafe
 */

public class ClassViewCustomizer extends BaseViewCustomizer {
	
	/**
	 * The only instance of <code>ClassViewCustomizer</code>
	 */
	public static ClassViewCustomizer INSTANCE = new ClassViewCustomizer();

	protected ClassViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Hides the attribute and operation compartments for 
	 * Class views that are of ZDL concept PORT_TYPE.
	 */
	@Override
	public void customizeView(View view) {		
		super.customizeView(view);		
	}
	
}
