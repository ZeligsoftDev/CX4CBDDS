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
package com.zeligsoft.domain.zml.rsm.tooling.viewfactories;

import com.zeligsoft.base.rsm.tooling.providers.IViewCustomizer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @generated
 */
public class ImplementationArtifactViewCustomizer implements IViewCustomizer {

	/**
	 * @generated
	 */
	public static ImplementationArtifactViewCustomizer INSTANCE = new ImplementationArtifactViewCustomizer();
	
	/**
	 * @generated
	 */
	private ImplementationArtifactViewCustomizer() {
		// private constructor
	}
	
	/**
	 * @generated
	 */
	public void customizeView(View view) {
		EPackage umlnotationEPackage = EPackage.Registry.INSTANCE.getEPackage("http://www.ibm.com/xtools/1.5.2/Umlnotation"); //$NON-NLS-1$
		EFactory umlnotationEFactory = umlnotationEPackage.getEFactoryInstance();
			
		EClass umlshapestyleEClass = (EClass)umlnotationEPackage.getEClassifier("UMLShapeStyle"); //$NON-NLS-1$
		if(umlshapestyleEClass != null) {
			Style style = view.getStyle(umlshapestyleEClass);
			if(style == null) {
				style = (Style)umlnotationEFactory.create(umlshapestyleEClass);
				view.getStyles().add(style);
			}
			EStructuralFeature showStereotypeFeature = umlshapestyleEClass.getEStructuralFeature("showStereotype"); //$NON-NLS-1$
			if(showStereotypeFeature != null && showStereotypeFeature.getEType() instanceof EDataType) {
				EDataType showStereotypeFeatureType = (EDataType)showStereotypeFeature.getEType();
				style.eSet(showStereotypeFeature, showStereotypeFeatureType.getEPackage().getEFactoryInstance().createFromString(showStereotypeFeatureType, "Image")); //$NON-NLS-1$
			}
		}
		
	}
}