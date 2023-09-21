package org.eclipse.xtend.typesystem.uml2;
/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

public abstract class UML2MetaModelBase extends EmfRegistryMetaModel {

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
    private EmfMetaModel ecoreMetaModel;

    public UML2MetaModelBase() {
    	ecoreMetaModel = new EmfMetaModel();
    	ecoreMetaModel.setMetaModelPackage(EcorePackage.class.getName());
    }

    public UML2MetaModelBase(EPackage metamodel) {
        super();
    	ecoreMetaModel = new EmfMetaModel();
    	ecoreMetaModel.setMetaModelPackage(EcorePackage.class.getName());
    	EPackage.Registry.INSTANCE.put(metamodel.getNsURI(), metamodel);
    }

    @Override
    public Type getTypeForName(String typeName) {
    	if (typeName==null || typeName.length()==0)
    		return null;
    	if (typeName.startsWith("UML::")) {
    		typeName = "uml::"+typeName.substring(5);
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
