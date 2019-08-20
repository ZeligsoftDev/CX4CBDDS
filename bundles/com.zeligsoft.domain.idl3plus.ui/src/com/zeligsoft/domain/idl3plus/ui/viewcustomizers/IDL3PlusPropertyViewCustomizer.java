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
package com.zeligsoft.domain.idl3plus.ui.viewcustomizers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.zml.ui.viewcustomizers.ZMLComponentViewCustomizer;

/**
 * View customizer for DataSpace
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusPropertyViewCustomizer extends ZMLComponentViewCustomizer {

	/**
	 * The only instance of <code>SCAComponentViewCustomizer</code>
	 */
	public static IDL3PlusPropertyViewCustomizer INSTANCE = new IDL3PlusPropertyViewCustomizer();

	private IDL3PlusPropertyViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Sets the visible property for various compartments.
	 * 
	 * @param view
	 *            the <code>Node</code> view for a <code>Component</code>.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void customizeView(View view) {

		super.customizeView(view);

		EObject element = view.getElement();
		if (element != null && ZDLUtil.isZDLConcept(element, IDL3PlusNames.DATA_SPACE)) {

			EList<View> children = view.getChildren();
			for (View childView : children) {
				childView.setVisible(false);
			}
		}
	}
}
