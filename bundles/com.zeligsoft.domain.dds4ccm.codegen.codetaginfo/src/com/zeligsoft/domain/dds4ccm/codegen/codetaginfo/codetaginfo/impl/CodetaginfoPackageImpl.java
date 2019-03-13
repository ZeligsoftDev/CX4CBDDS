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

import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoFactory;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.DocumentRoot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodetaginfoPackageImpl extends EPackageImpl implements CodetaginfoPackage {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass codeTagEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass codeTagContextEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass codeTagInfoEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass documentRootEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum codeTagTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EDataType codeTagTypeObjectEDataType = null;

    /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
    private CodetaginfoPackageImpl() {
		super(eNS_URI, CodetaginfoFactory.eINSTANCE);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static boolean isInited = false;

    /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CodetaginfoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
    public static CodetaginfoPackage init() {
		if (isInited) return (CodetaginfoPackage)EPackage.Registry.INSTANCE.getEPackage(CodetaginfoPackage.eNS_URI);

		// Obtain or create and register package
		CodetaginfoPackageImpl theCodetaginfoPackage = (CodetaginfoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CodetaginfoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CodetaginfoPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCodetaginfoPackage.createPackageContents();

		// Initialize created meta-data
		theCodetaginfoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCodetaginfoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CodetaginfoPackage.eNS_URI, theCodetaginfoPackage);
		return theCodetaginfoPackage;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCodeTag() {
		return codeTagEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTag_Group() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTag_Name() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTag_Uuid() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTag_Type() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTag_Tag_begin() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTag_Contents() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTag_Tag_end() {
		return (EAttribute)codeTagEClass.getEStructuralFeatures().get(6);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCodeTag_Contextinfo() {
		return (EReference)codeTagEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCodeTagContext() {
		return codeTagContextEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTagContext_Group() {
		return (EAttribute)codeTagContextEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTagContext_Component_name() {
		return (EAttribute)codeTagContextEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTagContext_Class_name() {
		return (EAttribute)codeTagContextEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeTagContext_Operation_name() {
		return (EAttribute)codeTagContextEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCodeTagInfo() {
		return codeTagInfoEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTagInfo_Group() {
		return (EAttribute)codeTagInfoEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCodeTagInfo_Filename() {
		return (EAttribute)codeTagInfoEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCodeTagInfo_Codetag() {
		return (EReference)codeTagInfoEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getDocumentRoot() {
		return documentRootEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getDocumentRoot_CodeTagInfo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getCodeTagType() {
		return codeTagTypeEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EDataType getCodeTagTypeObject() {
		return codeTagTypeObjectEDataType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CodetaginfoFactory getCodetaginfoFactory() {
		return (CodetaginfoFactory)getEFactoryInstance();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isCreated = false;

    /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		codeTagEClass = createEClass(CODE_TAG);
		createEAttribute(codeTagEClass, CODE_TAG__GROUP);
		createEAttribute(codeTagEClass, CODE_TAG__NAME);
		createEAttribute(codeTagEClass, CODE_TAG__UUID);
		createEAttribute(codeTagEClass, CODE_TAG__TYPE);
		createEAttribute(codeTagEClass, CODE_TAG__TAG_BEGIN);
		createEAttribute(codeTagEClass, CODE_TAG__CONTENTS);
		createEAttribute(codeTagEClass, CODE_TAG__TAG_END);
		createEReference(codeTagEClass, CODE_TAG__CONTEXTINFO);

		codeTagContextEClass = createEClass(CODE_TAG_CONTEXT);
		createEAttribute(codeTagContextEClass, CODE_TAG_CONTEXT__GROUP);
		createEAttribute(codeTagContextEClass, CODE_TAG_CONTEXT__COMPONENT_NAME);
		createEAttribute(codeTagContextEClass, CODE_TAG_CONTEXT__CLASS_NAME);
		createEAttribute(codeTagContextEClass, CODE_TAG_CONTEXT__OPERATION_NAME);

		codeTagInfoEClass = createEClass(CODE_TAG_INFO);
		createEAttribute(codeTagInfoEClass, CODE_TAG_INFO__GROUP);
		createEAttribute(codeTagInfoEClass, CODE_TAG_INFO__FILENAME);
		createEReference(codeTagInfoEClass, CODE_TAG_INFO__CODETAG);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CODE_TAG_INFO);

		// Create enums
		codeTagTypeEEnum = createEEnum(CODE_TAG_TYPE);

		// Create data types
		codeTagTypeObjectEDataType = createEDataType(CODE_TAG_TYPE_OBJECT);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isInitialized = false;

    /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(codeTagEClass, CodeTag.class, "CodeTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeTag_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, CodeTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Name(), theXMLTypePackage.getString(), "name", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Uuid(), theXMLTypePackage.getString(), "uuid", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Type(), this.getCodeTagType(), "type", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Tag_begin(), theXMLTypePackage.getString(), "tag_begin", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Contents(), theXMLTypePackage.getString(), "contents", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTag_Tag_end(), theXMLTypePackage.getString(), "tag_end", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCodeTag_Contextinfo(), this.getCodeTagContext(), null, "contextinfo", null, 0, -1, CodeTag.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(codeTagContextEClass, CodeTagContext.class, "CodeTagContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeTagContext_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, CodeTagContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTagContext_Component_name(), theXMLTypePackage.getString(), "component_name", null, 0, -1, CodeTagContext.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTagContext_Class_name(), theXMLTypePackage.getString(), "class_name", null, 0, -1, CodeTagContext.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTagContext_Operation_name(), theXMLTypePackage.getString(), "operation_name", null, 0, -1, CodeTagContext.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(codeTagInfoEClass, CodeTagInfo.class, "CodeTagInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeTagInfo_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, CodeTagInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeTagInfo_Filename(), theXMLTypePackage.getString(), "filename", null, 0, -1, CodeTagInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCodeTagInfo_Codetag(), this.getCodeTag(), null, "codetag", null, 0, -1, CodeTagInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CodeTagInfo(), this.getCodeTagInfo(), null, "codeTagInfo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(codeTagTypeEEnum, CodeTagType.class, "CodeTagType");
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEHEADERH);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEHEADERCPP);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEFOOTERH);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEFOOTERCPP);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEINCLUDESH);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.FILEINCLUDESCPP);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CONSTRUCTORINITLIST);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSGENERATEDOPERATIONIMPL);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSGENERATEDATTRIBUTEGET);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSGENERATEDATTRIBUTESET);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSPUBLICMETHODSSECTIONDECLARE);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSPUBLICMETHODSSECTIONIMPL);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSPRIVATEMETHODSSECTIONDECLARE);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSPRIVATEMETHODSSECTIONIMPL);
		addEEnumLiteral(codeTagTypeEEnum, CodeTagType.CLASSPRIVATEMEMBERSSECTIONDECLARE);

		// Initialize data types
		initEDataType(codeTagTypeObjectEDataType, CodeTagType.class, "CodeTagTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

    /**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (codeTagEClass, 
		   source, 
		   new String[] {
			 "name", "CodeTag",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCodeTag_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getCodeTag_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Uuid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "uuid",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Tag_begin(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tag_begin",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Contents(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "contents",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Tag_end(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tag_end",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTag_Contextinfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "contextinfo",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (codeTagContextEClass, 
		   source, 
		   new String[] {
			 "name", "CodeTagContext",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCodeTagContext_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getCodeTagContext_Component_name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component_name",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTagContext_Class_name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "class_name",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTagContext_Operation_name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation_name",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (codeTagInfoEClass, 
		   source, 
		   new String[] {
			 "name", "CodeTagInfo",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCodeTagInfo_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getCodeTagInfo_Filename(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "filename",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getCodeTagInfo_Codetag(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "codetag",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (codeTagTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "CodeTagType"
		   });		
		addAnnotation
		  (codeTagTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "CodeTagType:Object",
			 "baseType", "CodeTagType"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_CodeTagInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CodeTagInfo",
			 "namespace", "##targetNamespace"
		   });
	}

} //CodetaginfoPackageImpl
