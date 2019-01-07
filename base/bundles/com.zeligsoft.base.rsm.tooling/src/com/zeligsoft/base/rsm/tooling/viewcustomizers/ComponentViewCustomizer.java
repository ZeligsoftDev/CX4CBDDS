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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.xtools.umlnotation.UMLComponentStyle;
import com.ibm.xtools.umlnotation.UMLListStereotypeDisplay;
import com.ibm.xtools.umlnotation.UmlnotationFactory;
import com.ibm.xtools.umlnotation.UmlnotationPackage;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * View customizer for UML Component views.
 * 
 * @author jcorchis
 * 
 */
public class ComponentViewCustomizer
		extends BaseViewCustomizer {	
	
	public static final String PORT_OPERATIONS_VIEW_TYPE = "PortOperationsListCompartment";//$NON-NLS-1$

	/**
	 * The only instance of <code>ComponentViewCustomizer</code>
	 */
	public static ComponentViewCustomizer INSTANCE = new ComponentViewCustomizer();



	protected ComponentViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Sets the Component View style so that the External View is shown when
	 * visualized. The list compartments are not visible.
	 * 
	 * @param view
	 *            the <code>Node</code> view for a <code>Component</code>.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void customizeView(View view) {
		
		// Do not customize the view if the context of the Component is RSMs
		// Struture diagram, the defaults are sufficient.
		if (view.eContainer() instanceof Diagram
			&& "Structure".equals(((Diagram) view.eContainer()).getType())) {//$NON-NLS-1$
			return;
		}
		
		super.customizeView(view);

		//component style 
		UMLComponentStyle componentStyle = (UMLComponentStyle) view
				.getStyle(UmlnotationPackage.Literals.UML_COMPONENT_STYLE);
		if (componentStyle == null) {
			componentStyle = UmlnotationFactory.eINSTANCE
				.createUMLComponentStyle();
			view.getStyles().add(componentStyle);
		}
		componentStyle.setShowWhiteBox(true);
		
		// For structural realization and implementations add the
		// PortOperations list compartment
		if (hasPortOperations(view.getElement())) {
			ViewService.createNode(view, view.getElement(),
				PORT_OPERATIONS_VIEW_TYPE, PreferencesHint.USE_DEFAULTS);

			// To hide the <<workerfunction>> stereotype on operations
			componentStyle
				.setShowListStereotype(UMLListStereotypeDisplay.NONE_LITERAL);
		}			

		// Hide the Provided and Required Interface list compartments.
		EList<View> children = view.getChildren();
		for (View childView : children) {
			String childViewType = childView.getType();
			if (REQUIRES_LIST_VIEW_NAME.equals(childViewType)
				|| PROVIDES_LIST_VIEW_NAME.equals(childViewType)) {
				childView.setVisible(false);
			}

			if ((STRUCTURE_COMPARTMENT_VIEW_NAME.equals(childViewType) || PORT_OPERATIONS_VIEW_TYPE
				.equals(childViewType))
				&& ZDLUtil.isZDLConcept(childView.getElement(),
					ZMLMMNames.STRUCTURAL_REALIZATION)) {
				childView.setVisible(true);
			}
		}
	}
	
	/**
	 * StructuralRealization and Implementations support Port Operations.
	 * 
	 * @param element
	 * @return
	 */
	private boolean hasPortOperations(EObject element) {
		return element != null
			&& ZDLUtil.isZDLConcept(element, ZMLMMNames.STRUCTURAL_REALIZATION);
		// TODO: Add PortOperations on Implementations.
	}	
}
