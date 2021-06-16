/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.custom.canonical.PropertyPartCompartmentSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * 
 * @author Young-Soo Roh
 *
 */
public class ComponentPartCompartmentChildrenStrategy extends PropertyPartCompartmentSemanticChildrenStrategy {

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {

		List<? extends EObject> result = super.getCanonicalSemanticChildren(semanticFromEditPart, viewFromEditPart);

		Property property = (semanticFromEditPart instanceof Property) ? (Property) semanticFromEditPart : null;
		if ((property != null) && !(property instanceof Port)) {
			Type type = property.getType();
			if (type != null) {
				if (result != null && ZDLUtil.isZDLConcept(property, CCMNames.CCMPART)) {
					for (Property p : ((Component) type).getOwnedAttributes()) {
						if (p instanceof Property && !(p instanceof Port)) {
							if (result.contains(p)) {
								result.remove(p);
							}
						}
					}
					for (Comment c : ((Component) type).getOwnedComments()) {
						if (result.contains(c)) {
							result.remove(c);
						}
					}
				}
			}
		}

		return result;
	}
}
