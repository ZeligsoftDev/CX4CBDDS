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
package com.zeligsoft.base.zdl.oaw;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModelBase;

/**
 * Copy of {@link UML2MetaModelBase} changing the inheritance hierarchy.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class ZUML2MetaModelBase extends ZEmfRegistryMetaModel {

	private static enum PrimitiveType {

		BOOLEAN("uml::Boolean", "UMLPrimitiveTypes::Boolean", "types::Boolean", "EcorePrimitiveTypes::EBoolean", "EcorePrimitiveTypes::EBooleanObject"),
		INTEGER("uml::Integer", "uml::UnlimitedNatural", "UMLPrimitiveTypes::Integer", "UMLPrimitiveTypes::UnlimitedNatural", "types::Integer", "types::UnlimitedNatural", "EcorePrimitiveTypes::EIntegerObject", "EcorePrimitiveTypes::EInt"),
		STRING("uml::String", "UMLPrimitiveTypes::String", "types::String", "EcorePrimitiveTypes::EString"),
		REAL("uml::Real", "UMLPrimitiveTypes::Real", "types::Real", "EcorePrimitiveTypes::EDouble", "EcorePrimitiveTypes::EDoubleObject", "EcorePrimitiveTypes::EFloat", "EcorePrimitiveTypes::EFloatObject");

		private String[] supportedTypeNames;

		private PrimitiveType(String... supportedTypeNames) {
			this.supportedTypeNames = supportedTypeNames;
		}

		public boolean isSupported(String typeName) {
			for (String supportedTypeName : supportedTypeNames) {
				if(supportedTypeName.equalsIgnoreCase(typeName)) {
					return true;
				}
			}
			return false;
		}

	}
    // Needed to avoid 'Couldn't resolve type for EObject/EClass...' messages
    // see FeatureRequest#199318
    private ZEmfMetaModel ecoreMetaModel;

    public ZUML2MetaModelBase() {
    	ecoreMetaModel = new ZEmfMetaModel();
    	ecoreMetaModel.setMetaModelPackage(EcorePackage.class.getName());
    }

    public ZUML2MetaModelBase(EPackage metamodel) {
        super();
    	ecoreMetaModel = new ZEmfMetaModel();
    	ecoreMetaModel.setMetaModelPackage(EcorePackage.class.getName());
    	EPackage.Registry.INSTANCE.put(metamodel.getNsURI(), metamodel);
    }

    @Override
    public Type getTypeForName(String typeName) {
		if (typeName == null || typeName.length() == 0)
			return null;
		if (typeName.startsWith("UML::")) {
			typeName = "uml::" + typeName.substring(5);
		}
        Type result = getPrimitive(typeName);
        if (result != null)
            return result;
        result = super.getTypeForName(typeName);
        if (result != null)
            return result;
        result = ecoreMetaModel.getTypeForName(typeName);
        return result;
    }

    @Override
    public Type getTypeForEClassifier(EClassifier element) {
        Type result = getPrimitive(getFullyQualifiedName(element));
        if (result != null)
            return result;
        result = super.getTypeForEClassifier(element);
        if (result != null)
            return result;
        result = ecoreMetaModel.getTypeForEClassifier(element);
        return result;
    }

	private Type getPrimitive(String typeName) {
		if (PrimitiveType.STRING.isSupported(typeName)) {
			return getTypeSystem().getStringType();
		} else if (PrimitiveType.BOOLEAN.isSupported(typeName)) {
			return getTypeSystem().getBooleanType();
		} else if (PrimitiveType.INTEGER.isSupported(typeName)) {
			return getTypeSystem().getIntegerType();
		} else if (PrimitiveType.REAL.isSupported(typeName)) {
			return getTypeSystem().getRealType();
		} else {
			return null;
		}
	}

	@Override
	public void setTypeSystem(TypeSystem typeSystem) {
		super.setTypeSystem(typeSystem);
    	ecoreMetaModel.setTypeSystem(typeSystem);
	}
    
    

}
