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

import com.ibm.xtools.umlnotation.UMLStereotypeDisplay;
import com.ibm.xtools.umlnotation.UMLStereotypeStyle;
import com.ibm.xtools.umlnotation.UmlnotationPackage;
import com.zeligsoft.base.ui.IViewCustomizer;

/**
 * The base view customizer.
 * 
 * @author schafe
 * 
 */
public class BaseViewCustomizer
		implements IViewCustomizer {

	protected static final String ATTRIBUTE_LIST_VIEW_NAME = "AttributeCompartment";//$NON-NLS-1$

	protected static final String OPERATION_LIST_VIEW_NAME = "OperationCompartment";//$NON-NLS-1$

	protected static final String PROVIDES_LIST_VIEW_NAME = "ProvidedInterfaceListCompartment";//$NON-NLS-1$

	protected static final String REQUIRES_LIST_VIEW_NAME = "RequiredInterfaceListCompartment";//$NON-NLS-1$

	protected static final String STRUCTURE_COMPARTMENT_VIEW_NAME = "StructureCompartment";//$NON-NLS-1$

	/**
	 * The only instance of <code>BaseViewCustomizer</code>
	 */
	public static BaseViewCustomizer INSTANCE = new BaseViewCustomizer();

	protected BaseViewCustomizer() {
		// do not instantiate
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.rsm.tooling.providers.IViewCustomizer#customizeView
	 * (org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
	public void customizeView(View view) {
		// stereotype style
		// Set to show only the decoration "ICON".
		UMLStereotypeStyle stereotypeShowStyle = (UMLStereotypeStyle) view
			.getStyle(UmlnotationPackage.Literals.UML_STEREOTYPE_STYLE);
		if (stereotypeShowStyle != null) {
			stereotypeShowStyle
				.setShowStereotype(UMLStereotypeDisplay.ICON_LITERAL);
		}
	}

}
