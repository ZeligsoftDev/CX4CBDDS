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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoFactory
 * @model kind="package"
 * @generated
 */
public interface CodetaginfoPackage extends EPackage {
    /**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "codetaginfo";

    /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.zeligsoft.com/2012/codetaginfo";

    /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "codetaginfo";

    /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    CodetaginfoPackage eINSTANCE = com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl.init();

    /**
	 * The meta object id for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl <em>Code Tag</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTag()
	 * @generated
	 */
    int CODE_TAG = 0;

    /**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__GROUP = 0;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__NAME = 1;

    /**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_TAG__UUID = 2;

				/**
	 * The feature id for the '<em><b>Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__TYPE = 3;

    /**
	 * The feature id for the '<em><b>Tag begin</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__TAG_BEGIN = 4;

    /**
	 * The feature id for the '<em><b>Contents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__CONTENTS = 5;

    /**
	 * The feature id for the '<em><b>Tag end</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__TAG_END = 6;

    /**
	 * The feature id for the '<em><b>Contextinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG__CONTEXTINFO = 7;

    /**
	 * The number of structural features of the '<em>Code Tag</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_FEATURE_COUNT = 8;

    /**
	 * The meta object id for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl <em>Code Tag Context</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagContext()
	 * @generated
	 */
    int CODE_TAG_CONTEXT = 1;

    /**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_CONTEXT__GROUP = 0;

    /**
	 * The feature id for the '<em><b>Component name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_CONTEXT__COMPONENT_NAME = 1;

    /**
	 * The feature id for the '<em><b>Class name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_CONTEXT__CLASS_NAME = 2;

    /**
	 * The feature id for the '<em><b>Operation name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_CONTEXT__OPERATION_NAME = 3;

    /**
	 * The number of structural features of the '<em>Code Tag Context</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_CONTEXT_FEATURE_COUNT = 4;

    /**
	 * The meta object id for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl <em>Code Tag Info</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagInfo()
	 * @generated
	 */
    int CODE_TAG_INFO = 2;

    /**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_INFO__GROUP = 0;

    /**
	 * The feature id for the '<em><b>Filename</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_INFO__FILENAME = 1;

    /**
	 * The feature id for the '<em><b>Codetag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_INFO__CODETAG = 2;

    /**
	 * The number of structural features of the '<em>Code Tag Info</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CODE_TAG_INFO_FEATURE_COUNT = 3;

    /**
	 * The meta object id for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.DocumentRootImpl
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getDocumentRoot()
	 * @generated
	 */
    int DOCUMENT_ROOT = 3;

    /**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
	 * The feature id for the '<em><b>Code Tag Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOCUMENT_ROOT__CODE_TAG_INFO = 3;

    /**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DOCUMENT_ROOT_FEATURE_COUNT = 4;

    /**
	 * The meta object id for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType <em>Code Tag Type</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagType()
	 * @generated
	 */
    int CODE_TAG_TYPE = 4;

    /**
	 * The meta object id for the '<em>Code Tag Type Object</em>' data type.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagTypeObject()
	 * @generated
	 */
    int CODE_TAG_TYPE_OBJECT = 5;


    /**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag <em>Code Tag</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Tag</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag
	 * @generated
	 */
    EClass getCodeTag();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getGroup()
	 * @see #getCodeTag()
	 * @generated
	 */
    EAttribute getCodeTag_Group();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getName()
	 * @see #getCodeTag()
	 * @generated
	 */
    EAttribute getCodeTag_Name();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uuid</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getUuid()
	 * @see #getCodeTag()
	 * @generated
	 */
	EAttribute getCodeTag_Uuid();

				/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Type</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getType()
	 * @see #getCodeTag()
	 * @generated
	 */
    EAttribute getCodeTag_Type();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_begin <em>Tag begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tag begin</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_begin()
	 * @see #getCodeTag()
	 * @generated
	 */
	EAttribute getCodeTag_Tag_begin();

				/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contents</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContents()
	 * @see #getCodeTag()
	 * @generated
	 */
    EAttribute getCodeTag_Contents();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_end <em>Tag end</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tag end</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getTag_end()
	 * @see #getCodeTag()
	 * @generated
	 */
	EAttribute getCodeTag_Tag_end();

				/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContextinfo <em>Contextinfo</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contextinfo</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag#getContextinfo()
	 * @see #getCodeTag()
	 * @generated
	 */
    EReference getCodeTag_Contextinfo();

    /**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext <em>Code Tag Context</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Tag Context</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext
	 * @generated
	 */
    EClass getCodeTagContext();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getGroup()
	 * @see #getCodeTagContext()
	 * @generated
	 */
    EAttribute getCodeTagContext_Group();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getComponent_name <em>Component name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Component name</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getComponent_name()
	 * @see #getCodeTagContext()
	 * @generated
	 */
	EAttribute getCodeTagContext_Component_name();

				/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getClass_name <em>Class name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Class name</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getClass_name()
	 * @see #getCodeTagContext()
	 * @generated
	 */
	EAttribute getCodeTagContext_Class_name();

				/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getOperation_name <em>Operation name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operation name</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext#getOperation_name()
	 * @see #getCodeTagContext()
	 * @generated
	 */
	EAttribute getCodeTagContext_Operation_name();

				/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo <em>Code Tag Info</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Tag Info</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo
	 * @generated
	 */
    EClass getCodeTagInfo();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getGroup()
	 * @see #getCodeTagInfo()
	 * @generated
	 */
    EAttribute getCodeTagInfo_Group();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Filename</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getFilename()
	 * @see #getCodeTagInfo()
	 * @generated
	 */
    EAttribute getCodeTagInfo_Filename();

    /**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getCodetag <em>Codetag</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Codetag</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo#getCodetag()
	 * @see #getCodeTagInfo()
	 * @generated
	 */
    EReference getCodeTagInfo_Codetag();

    /**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot
	 * @generated
	 */
    EClass getDocumentRoot();

    /**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
    EAttribute getDocumentRoot_Mixed();

    /**
	 * Returns the meta object for the map '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
	 * Returns the meta object for the map '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getCodeTagInfo <em>Code Tag Info</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Code Tag Info</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot#getCodeTagInfo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
    EReference getDocumentRoot_CodeTagInfo();

    /**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType <em>Code Tag Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Code Tag Type</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
	 * @generated
	 */
    EEnum getCodeTagType();

    /**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType <em>Code Tag Type Object</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Code Tag Type Object</em>'.
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
	 * @model instanceClass="com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType"
	 *        extendedMetaData="name='CodeTagType:Object' baseType='CodeTagType'"
	 * @generated
	 */
    EDataType getCodeTagTypeObject();

    /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    CodetaginfoFactory getCodetaginfoFactory();

    /**
	 * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
	 * @generated
	 */
    interface Literals {
        /**
		 * The meta object literal for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl <em>Code Tag</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTag()
		 * @generated
		 */
        EClass CODE_TAG = eINSTANCE.getCodeTag();

        /**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__GROUP = eINSTANCE.getCodeTag_Group();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__NAME = eINSTANCE.getCodeTag_Name();

        /**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_TAG__UUID = eINSTANCE.getCodeTag_Uuid();

								/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__TYPE = eINSTANCE.getCodeTag_Type();

        /**
		 * The meta object literal for the '<em><b>Tag begin</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__TAG_BEGIN = eINSTANCE.getCodeTag_Tag_begin();

        /**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__CONTENTS = eINSTANCE.getCodeTag_Contents();

        /**
		 * The meta object literal for the '<em><b>Tag end</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG__TAG_END = eINSTANCE.getCodeTag_Tag_end();

        /**
		 * The meta object literal for the '<em><b>Contextinfo</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference CODE_TAG__CONTEXTINFO = eINSTANCE.getCodeTag_Contextinfo();

        /**
		 * The meta object literal for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl <em>Code Tag Context</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagContext()
		 * @generated
		 */
        EClass CODE_TAG_CONTEXT = eINSTANCE.getCodeTagContext();

        /**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_CONTEXT__GROUP = eINSTANCE.getCodeTagContext_Group();

        /**
		 * The meta object literal for the '<em><b>Component name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_CONTEXT__COMPONENT_NAME = eINSTANCE.getCodeTagContext_Component_name();

        /**
		 * The meta object literal for the '<em><b>Class name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_CONTEXT__CLASS_NAME = eINSTANCE.getCodeTagContext_Class_name();

        /**
		 * The meta object literal for the '<em><b>Operation name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_CONTEXT__OPERATION_NAME = eINSTANCE.getCodeTagContext_Operation_name();

        /**
		 * The meta object literal for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl <em>Code Tag Info</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagInfo()
		 * @generated
		 */
        EClass CODE_TAG_INFO = eINSTANCE.getCodeTagInfo();

        /**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_INFO__GROUP = eINSTANCE.getCodeTagInfo_Group();

        /**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute CODE_TAG_INFO__FILENAME = eINSTANCE.getCodeTagInfo_Filename();

        /**
		 * The meta object literal for the '<em><b>Codetag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference CODE_TAG_INFO__CODETAG = eINSTANCE.getCodeTagInfo_Codetag();

        /**
		 * The meta object literal for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.DocumentRootImpl
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getDocumentRoot()
		 * @generated
		 */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

        /**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

        /**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

        /**
		 * The meta object literal for the '<em><b>Code Tag Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference DOCUMENT_ROOT__CODE_TAG_INFO = eINSTANCE.getDocumentRoot_CodeTagInfo();

        /**
		 * The meta object literal for the '{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType <em>Code Tag Type</em>}' enum.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagType()
		 * @generated
		 */
        EEnum CODE_TAG_TYPE = eINSTANCE.getCodeTagType();

        /**
		 * The meta object literal for the '<em>Code Tag Type Object</em>' data type.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType
		 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodetaginfoPackageImpl#getCodeTagTypeObject()
		 * @generated
		 */
        EDataType CODE_TAG_TYPE_OBJECT = eINSTANCE.getCodeTagTypeObject();

    }

} //CodetaginfoPackage
