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
 * A representation of the model object '<em><b>Code Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getUuid <em>Uuid</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_begin <em>Tag begin</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContents <em>Contents</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_end <em>Tag end</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContextinfo <em>Contextinfo</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag()
 * @model extendedMetaData="name='CodeTag' kind='elementOnly'"
 * @generated
 */
public interface CodeTag extends EObject {
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
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
    FeatureMap getGroup();

    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='name' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
    EList<String> getName();

    /**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Uuid()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='uuid' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getUuid();

				/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute list.
	 * The list contents are of type {@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType}.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Type()
	 * @model unique="false" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
    EList<CodeTagType> getType();

    /**
	 * Returns the value of the '<em><b>Tag begin</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag begin</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag begin</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Tag_begin()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tag_begin' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getTag_begin();

				/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contents</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Contents()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='contents' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
    EList<String> getContents();

    /**
	 * Returns the value of the '<em><b>Tag end</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag end</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag end</em>' attribute list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Tag_end()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tag_end' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getTag_end();

				/**
	 * Returns the value of the '<em><b>Contextinfo</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contextinfo</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Contextinfo</em>' containment reference list.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#getCodeTag_Contextinfo()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='contextinfo' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
    EList<CodeTagContext> getContextinfo();

} // CodeTag
