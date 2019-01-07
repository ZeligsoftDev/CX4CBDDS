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

package com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl;

import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodetaginfoFactoryImpl extends EFactoryImpl implements CodetaginfoFactory {
    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static CodetaginfoFactory init() {
		try {
			CodetaginfoFactory theCodetaginfoFactory = (CodetaginfoFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.zeligsoft.com/2012/codetaginfo"); 
			if (theCodetaginfoFactory != null) {
				return theCodetaginfoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CodetaginfoFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodetaginfoFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CodetaginfoPackage.CODE_TAG: return createCodeTag();
			case CodetaginfoPackage.CODE_TAG_CONTEXT: return createCodeTagContext();
			case CodetaginfoPackage.CODE_TAG_INFO: return createCodeTagInfo();
			case CodetaginfoPackage.DOCUMENT_ROOT: return createDocumentRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CodetaginfoPackage.CODE_TAG_TYPE:
				return createCodeTagTypeFromString(eDataType, initialValue);
			case CodetaginfoPackage.CODE_TAG_TYPE_OBJECT:
				return createCodeTagTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CodetaginfoPackage.CODE_TAG_TYPE:
				return convertCodeTagTypeToString(eDataType, instanceValue);
			case CodetaginfoPackage.CODE_TAG_TYPE_OBJECT:
				return convertCodeTagTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodeTag createCodeTag() {
		CodeTagImpl codeTag = new CodeTagImpl();
		return codeTag;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodeTagContext createCodeTagContext() {
		CodeTagContextImpl codeTagContext = new CodeTagContextImpl();
		return codeTagContext;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodeTagInfo createCodeTagInfo() {
		CodeTagInfoImpl codeTagInfo = new CodeTagInfoImpl();
		return codeTagInfo;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodeTagType createCodeTagTypeFromString(EDataType eDataType, String initialValue) {
		CodeTagType result = CodeTagType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertCodeTagTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodeTagType createCodeTagTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createCodeTagTypeFromString(CodetaginfoPackage.Literals.CODE_TAG_TYPE, initialValue);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertCodeTagTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertCodeTagTypeToString(CodetaginfoPackage.Literals.CODE_TAG_TYPE, instanceValue);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodetaginfoPackage getCodetaginfoPackage() {
		return (CodetaginfoPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static CodetaginfoPackage getPackage() {
		return CodetaginfoPackage.eINSTANCE;
	}

} //CodetaginfoFactoryImpl
