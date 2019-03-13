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
package com.zeligsoft.domain.zml.ui.viewcustomizers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.ui.viewcustomizers.BaseViewCustomizer;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class ZMLClassViewCustomizer extends BaseViewCustomizer {
	
	/**
	 * The only instance of <code>ClassViewCustomizer</code>
	 */
	public static ZMLClassViewCustomizer INSTANCE = new ZMLClassViewCustomizer();

	protected ZMLClassViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Hides the attribute and operation compartments for 
	 * Class views that are of ZDL concept PORT_TYPE.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void customizeView(View view) {
		
		super.customizeView(view);
		
		//Hides the attribute and operation compartments for 
		//Class views that are of ZDL concept PORT_TYPE.
		if (ZDLUtil.isZDLConcept(view.getElement(), ZMLMMNames.PORT_TYPE)){			
			EList<View> children = view.getChildren();
			for (View childView : children) {
				if (ATTRIBUTE_LIST_VIEW_NAME.equals(childView.getType()))
					childView.setVisible(false);
				
				else if (OPERATION_LIST_VIEW_NAME.equals(childView.getType()))
					childView.setVisible(false);				
			}			
		}
		
	}
	
}
