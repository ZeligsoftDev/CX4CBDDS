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
package com.zeligsoft.domain.omg.corba.ui.viewcustomizers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.ui.viewcustomizers.BaseViewCustomizer;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * 
 * @author ysroh
 *
 */
public class CORBAInterfaceViewCustomizer extends BaseViewCustomizer {

	/**
	 * The only instance of <code>CORBAInterfaceViewCustomizer</code>
	 */
	public static CORBAInterfaceViewCustomizer INSTANCE = new CORBAInterfaceViewCustomizer();

	private CORBAInterfaceViewCustomizer() {
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
		if (ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBAINTERFACE) == true) {

			EList<View> children = view.getChildren();
			for (View childView : children) {
				String childViewType = childView.getType();

				if (ATTRIBUTE_LIST_VIEW_NAME.equals(childViewType)) {
					childView.setVisible(true);
				}
			}
		}
	}

}
