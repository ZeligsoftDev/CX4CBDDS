/**
 * Copyright 2022 Luminex/Zeligsoft Limited.
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
package com.zeligsoft.domain.dds4ccm.snippets;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.IModelSnippet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Model Snippet to initialize UML Models.
 * 
 * <p>
 * This snippet updates the model's default save options so that it doesn't save
 * redundant 'xmi:type' annotations.
 * 
 * @author Ernesto Posse
 */
public class CXUMLModelSnippet implements IModelSnippet {

	protected static XMLTypeInfo xmlTypeInfo = new XMLTypeInfo() {

		public boolean shouldSaveType(EClass objectType, EClassifier featureType, EStructuralFeature feature) {
			return objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;
		}

		public boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {
			return objectType != featureType;
		}

	};

	@Override
	public void start(IModel startingModel) {
		if (startingModel instanceof UmlModel) {
			UmlModel umlModel = (UmlModel) startingModel;
			Resource resource = umlModel.getResource();
			if (resource instanceof UMLResource) {
				UMLResource umlResource = (UMLResource) resource;
				umlResource.getDefaultSaveOptions().put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, xmlTypeInfo);
			}
		}
	}

	@Override
	public void dispose(IModel stoppingModel) {
		// Nothing to do here
	}

}
