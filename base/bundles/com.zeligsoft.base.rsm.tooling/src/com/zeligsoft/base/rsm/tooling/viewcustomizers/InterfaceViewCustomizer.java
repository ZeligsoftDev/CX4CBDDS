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

package com.zeligsoft.base.rsm.tooling.viewcustomizers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;

/**
 * View customizer for UML Interface views. Sets the Operations
 * compartment as visible and hides the Attributes list compartment.
 * 
 * @author jcorchis
 * 
 */
public class InterfaceViewCustomizer extends BaseViewCustomizer {

	/**
	 * The only instance of <code>InterfaceViewCustomizer</code>
	 */
	public static InterfaceViewCustomizer INSTANCE = new InterfaceViewCustomizer();

	protected InterfaceViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Enables the visibility of the Operation compartment and hides the 
	 * Attribute compartment for Interface based views.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void customizeView(View view) {
		
		super.customizeView(view);
	
		EList<View> children = view.getChildren();
		for (View childView : children) {
			if (ATTRIBUTE_LIST_VIEW_NAME.equals(childView.getType()))
				childView.setVisible(false);
			
			if (OPERATION_LIST_VIEW_NAME.equals(childView.getType()))
				childView.setVisible(true);			

		}

	}

}
