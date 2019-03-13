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

package com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Tag Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getComponent_name <em>Component name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getClass_name <em>Class name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getOperation_name <em>Operation name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagContext()
 * @model extendedMetaData="name='CodeTagContext' kind='elementOnly'"
 * @generated
 */
public interface CodeTagContext extends EObject {
    /**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagContext_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
    FeatureMap getGroup();

    /**
	 * Returns the value of the '<em><b>Component name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component name</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagContext_Component_name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component_name' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getComponent_name();

				/**
	 * Returns the value of the '<em><b>Class name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class name</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagContext_Class_name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='class_name' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getClass_name();

				/**
	 * Returns the value of the '<em><b>Operation name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation name</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTagContext_Operation_name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='operation_name' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getOperation_name();

} // CodeTagContext
