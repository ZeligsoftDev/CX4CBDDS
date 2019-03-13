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
 * View customizer for CORBA Class views in the CORBADomain.
 * 
 * @author ysroh
 * 
 */
public class CORBAClassViewCustomizer extends BaseViewCustomizer {

	protected static final String OPERATION_COMPARTMENT_NAME = "OperationCompartment";//$NON-NLS-1$

	/**
	 * The only instance of <code>CORBAClassViewCustomizer</code>
	 */
	public static CORBAClassViewCustomizer INSTANCE = new CORBAClassViewCustomizer();

	private CORBAClassViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Hide operation compartment if the data type is CORBAConstants
	 * 
	 * @param view
	 *            the <code>Node</code> view for a <code>Class</code>.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void customizeView(View view) {

		super.customizeView(view);

		EObject element = view.getElement();

		if (ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBACONSTANTS)) {
			EList<View> children = view.getChildren();
			for (View childView : children) {
				if (OPERATION_COMPARTMENT_NAME.equals(childView.getType())) {
					childView.setVisible(false);
				}
			}
		}
	}
}
