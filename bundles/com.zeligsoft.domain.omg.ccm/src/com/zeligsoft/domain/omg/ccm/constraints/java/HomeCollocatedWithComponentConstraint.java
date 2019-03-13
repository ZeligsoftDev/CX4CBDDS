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
package com.zeligsoft.domain.omg.ccm.constraints.java;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class HomeCollocatedWithComponentConstraint extends AbstractModelConstraint {

	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();
		
		if( ZDLUtil.isZDLConcept(objToVerify, ZMLMMNames.DEPLOYMENT_PART)) {
			EObject modelElement = ZDLUtil.getEValue(objToVerify, ZMLMMNames.DEPLOYMENT_PART, ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if(modelElement == null){
				return null;
			}
			if( ZDLUtil.isZDLConcept(modelElement, CCMNames.CCMPART)) {
				
				EObject component = ZDLUtil.getEValue(modelElement, ZMLMMNames.PART, ZMLMMNames.PART__DEFINITION);
				if( component != null && ZDLUtil.isZDLConcept(component, CCMNames.CCMCOMPONENT)) {
					EObject home = null;
					for( Setting s : UML2Util.getInverseReferences(component)) {
						if( s.getEObject() != null &&
								ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
							home = ZDLUtil.getEValue(s.getEObject(), CCMNames.MANAGES, CCMNames.MANAGES__HOME);
						}
					}
					if( home != null ) {
						// Component is managed by a home, so the parts must be collocated.
						Property componentDeploymentPart = (Property)objToVerify;
						Property targetPart = ZDeploymentUtil.getDeploymentTargetPart(componentDeploymentPart);
						if( targetPart != null) {
							Property parentPart = ZDeploymentUtil.getParentPart(componentDeploymentPart);
							for( Property nestedPart : (List<Property>)ZDLUtil.getValue(parentPart, ZMLMMNames.DEPLOYMENT_PART, ZMLMMNames.DEPLOYMENT_PART__NESTED_PART)) {
								EObject nestedPartModelElement = ZDLUtil.getEValue(nestedPart, ZMLMMNames.DEPLOYMENT_PART, ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
								if( ZDLUtil.isZDLConcept(nestedPartModelElement, CCMNames.HOME_INSTANCE)
									&& ZDLUtil.getValue(nestedPartModelElement, CCMNames.HOME_INSTANCE, CCMNames.HOME_INSTANCE__DEFINITION) == home) {
									Property targetHomePart = ZDeploymentUtil.getDeploymentTargetPart(nestedPart);
									if( targetHomePart == targetPart) {
										return ctx.createSuccessStatus();
									}
								}
							}
							// Component part is deployed but its home is not collocated.
							return ctx.createFailureStatus(componentDeploymentPart.getName(), ZDLUtil.getValue(home, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME));
						}
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();		
	}

}
