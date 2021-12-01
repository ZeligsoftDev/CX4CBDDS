/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenFactory
 * @model kind="package"
 * @generated
 */
public interface ZDLGenPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "zdlgen"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.zeligsoft.com/zdl/2008/ZDLGen"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "zdlgen"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ZDLGenPackage eINSTANCE = com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainClassifierImpl <em>Gen Domain Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainClassifierImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainClassifier()
	 * @generated
	 */
	int GEN_DOMAIN_CLASSIFIER = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl <em>Gen Domain Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainConcept()
	 * @generated
	 */
	int GEN_DOMAIN_CONCEPT = 22;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl <em>Gen Domain Structural Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainStructuralFeature()
	 * @generated
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE = 24;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl <em>Gen Domain Generalization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainGeneralization()
	 * @generated
	 */
	int GEN_DOMAIN_GENERALIZATION = 21;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl <em>Gen Domain Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainObject()
	 * @generated
	 */
	int GEN_DOMAIN_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_OBJECT__GEN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_OBJECT__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_OBJECT__OWNED_OBJECT = 2;

	/**
	 * The number of structural features of the '<em>Gen Domain Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_OBJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainNamedElementImpl <em>Gen Domain Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainNamedElementImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainNamedElement()
	 * @generated
	 */
	int GEN_DOMAIN_NAMED_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl <em>Gen Domain Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlock()
	 * @generated
	 */
	int GEN_DOMAIN_BLOCK = 17;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl <em>Gen Domain Block Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockRelation()
	 * @generated
	 */
	int GEN_DOMAIN_BLOCK_RELATION = 18;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributeImpl <em>Gen Domain Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributeImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttribute()
	 * @generated
	 */
	int GEN_DOMAIN_ATTRIBUTE = 27;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainDataTypeImpl <em>Gen Domain Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainDataTypeImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainDataType()
	 * @generated
	 */
	int GEN_DOMAIN_DATA_TYPE = 28;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImportImpl <em>Gen Domain Block Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImportImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockImport()
	 * @generated
	 */
	int GEN_DOMAIN_BLOCK_IMPORT = 19;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockMergeImpl <em>Gen Domain Block Merge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockMergeImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockMerge()
	 * @generated
	 */
	int GEN_DOMAIN_BLOCK_MERGE = 20;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl <em>Gen Domain Block Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockReference()
	 * @generated
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE = 30;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumImpl <em>Gen Domain Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainEnum()
	 * @generated
	 */
	int GEN_DOMAIN_ENUM = 34;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl <em>Gen Domain Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainEnumLiteral()
	 * @generated
	 */
	int GEN_DOMAIN_ENUM_LITERAL = 35;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl <em>Gen Domain Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainReference()
	 * @generated
	 */
	int GEN_DOMAIN_REFERENCE = 26;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageableElementImpl <em>Gen Domain Packageable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageableElementImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPackageableElement()
	 * @generated
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT = 6;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl <em>Gen Domain Specialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainSpecialization()
	 * @generated
	 */
	int GEN_DOMAIN_SPECIALIZATION = 31;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageImpl <em>Gen Domain Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPackage()
	 * @generated
	 */
	int GEN_DOMAIN_PACKAGE = 5;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl <em>Gen Domain Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModel()
	 * @generated
	 */
	int GEN_DOMAIN_MODEL = 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl <em>Gen Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenModel()
	 * @generated
	 */
	int GEN_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT__NAME = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Domain Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__GEN_MODEL = GEN_DOMAIN_NAMED_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__OWNER = GEN_DOMAIN_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__OWNED_OBJECT = GEN_DOMAIN_NAMED_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__NAME = GEN_DOMAIN_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__DOMAIN_ELEMENT = GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER__BLOCK = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Owned Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__OWNED_MODEL = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__DOMAIN_MODEL = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__REFERENCED_MODEL = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__GEN_MODEL = GEN_DOMAIN_NAMED_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNER = GEN_DOMAIN_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNED_OBJECT = GEN_DOMAIN_NAMED_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__NAME = GEN_DOMAIN_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__DOMAIN_ELEMENT = GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__GEN_MODEL = GEN_DOMAIN_PACKAGEABLE_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__OWNER = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__OWNED_OBJECT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__DOMAIN_ELEMENT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__ELEMENT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE__DOMAIN_PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Domain Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_PACKAGE_FEATURE_COUNT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__GEN_MODEL = GEN_DOMAIN_PACKAGE__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__OWNER = GEN_DOMAIN_PACKAGE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__OWNED_OBJECT = GEN_DOMAIN_PACKAGE__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__NAME = GEN_DOMAIN_PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__DOMAIN_ELEMENT = GEN_DOMAIN_PACKAGE__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__PACKAGE = GEN_DOMAIN_PACKAGE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__ELEMENT = GEN_DOMAIN_PACKAGE__ELEMENT;

	/**
	 * The feature id for the '<em><b>Domain Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__DOMAIN_PACKAGE = GEN_DOMAIN_PACKAGE__DOMAIN_PACKAGE;

	/**
	 * The feature id for the '<em><b>Domain Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__DOMAIN_MODEL = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__NS_URI = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__ROOT_PACKAGE = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implementation Sub Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Impl Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__IMPL_SUFFIX = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Api Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__API_PROJECT = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Palette</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__PALETTE = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Menu Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__MENU_MODEL = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owning Gen Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL__OWNING_GEN_MODEL = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Gen Domain Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_FEATURE_COUNT = GEN_DOMAIN_PACKAGE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl <em>Gen Palette</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPalette()
	 * @generated
	 */
	int GEN_PALETTE = 7;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl <em>Gen Palette Tool Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteToolContainer()
	 * @generated
	 */
	int GEN_PALETTE_TOOL_CONTAINER = 10;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl <em>Gen Palette Drawer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteDrawer()
	 * @generated
	 */
	int GEN_PALETTE_DRAWER = 9;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolImpl <em>Gen Palette Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteTool()
	 * @generated
	 */
	int GEN_PALETTE_TOOL = 11;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteItemImpl <em>Gen Palette Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteItemImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteItem()
	 * @generated
	 */
	int GEN_PALETTE_ITEM = 8;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPalettableImpl <em>Gen Palettable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPalettableImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPalettable()
	 * @generated
	 */
	int GEN_PALETTABLE = 23;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM__NAME = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM__DESCRIPTION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Palette Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_ITEM_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__GEN_MODEL = GEN_PALETTE_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__OWNER = GEN_PALETTE_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__OWNED_OBJECT = GEN_PALETTE_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__NAME = GEN_PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__DESCRIPTION = GEN_PALETTE_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Drawer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__OWNED_DRAWER = GEN_PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Drawer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE__DRAWER = GEN_PALETTE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Palette</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_FEATURE_COUNT = GEN_PALETTE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__GEN_MODEL = GEN_PALETTE_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__OWNER = GEN_PALETTE_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT = GEN_PALETTE_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__NAME = GEN_PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__DESCRIPTION = GEN_PALETTE_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL = GEN_PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__TOOL = GEN_PALETTE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM = GEN_PALETTE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Palette Tool Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT = GEN_PALETTE_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__GEN_MODEL = GEN_PALETTE_TOOL_CONTAINER__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__OWNER = GEN_PALETTE_TOOL_CONTAINER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__OWNED_OBJECT = GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__NAME = GEN_PALETTE_TOOL_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__DESCRIPTION = GEN_PALETTE_TOOL_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__OWNED_TOOL = GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__TOOL = GEN_PALETTE_TOOL_CONTAINER__TOOL;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__TARGET_DIAGRAM = GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM;

	/**
	 * The feature id for the '<em><b>Specializes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__SPECIALIZES = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Palette</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER__PALETTE = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Palette Drawer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_DRAWER_FEATURE_COUNT = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__GEN_MODEL = GEN_PALETTE_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__OWNER = GEN_PALETTE_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__OWNED_OBJECT = GEN_PALETTE_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__NAME = GEN_PALETTE_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__DESCRIPTION = GEN_PALETTE_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__OVERRIDES = GEN_PALETTE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL__CONTAINER = GEN_PALETTE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Palette Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_TOOL_FEATURE_COUNT = GEN_PALETTE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl <em>Gen Menu Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuModel()
	 * @generated
	 */
	int GEN_MENU_MODEL = 12;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL__ITEMS = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uml Menus</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL__UML_MENUS = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Menu Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_MODEL_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl <em>Gen Domain Attribute Presentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttributePresentation()
	 * @generated
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION = 25;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl <em>Gen Attribute Override</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenAttributeOverride()
	 * @generated
	 */
	int GEN_ATTRIBUTE_OVERRIDE = 29;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl <em>Gen Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuItem()
	 * @generated
	 */
	int GEN_MENU_ITEM = 13;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__DESCRIPTION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__NAME = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM__OVERRIDES = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ITEM_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl <em>Gen UML Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenUMLMenu()
	 * @generated
	 */
	int GEN_UML_MENU = 14;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU__MENU = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uml Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU__UML_METACLASS = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen UML Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_UML_MENU_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuTargetImpl <em>Gen Menu Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuTargetImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuTarget()
	 * @generated
	 */
	int GEN_MENU_TARGET = 15;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_TARGET__MENU = 0;

	/**
	 * The number of structural features of the '<em>Gen Menu Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_TARGET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuImpl <em>Gen Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenu()
	 * @generated
	 */
	int GEN_MENU = 16;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__GEN_MODEL = GEN_MENU_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__OWNER = GEN_MENU_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__OWNED_OBJECT = GEN_MENU_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__DESCRIPTION = GEN_MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__NAME = GEN_MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__OVERRIDES = GEN_MENU_ITEM__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__EXTENDS = GEN_MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU__ITEM = GEN_MENU_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_FEATURE_COUNT = GEN_MENU_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__GEN_MODEL = GEN_DOMAIN_PACKAGEABLE_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__OWNER = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__OWNED_OBJECT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__DOMAIN_ELEMENT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__CLASSIFIER = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__RELATION = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__DOMAIN_BLOCK = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__IMPORT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__MERGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rsm Stereotypes Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Rsm Stereotypes UI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Rsm Stereotypes Properties UI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Gen Domain Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_FEATURE_COUNT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__TARGET = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Block Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION__SOURCE = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Domain Block Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_RELATION_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__GEN_MODEL = GEN_DOMAIN_BLOCK_RELATION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__OWNER = GEN_DOMAIN_BLOCK_RELATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__OWNED_OBJECT = GEN_DOMAIN_BLOCK_RELATION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__TARGET = GEN_DOMAIN_BLOCK_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Domain Block Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__DOMAIN_BLOCK_RELATION = GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT__SOURCE = GEN_DOMAIN_BLOCK_RELATION__SOURCE;

	/**
	 * The number of structural features of the '<em>Gen Domain Block Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_IMPORT_FEATURE_COUNT = GEN_DOMAIN_BLOCK_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__GEN_MODEL = GEN_DOMAIN_BLOCK_RELATION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__OWNER = GEN_DOMAIN_BLOCK_RELATION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__OWNED_OBJECT = GEN_DOMAIN_BLOCK_RELATION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__TARGET = GEN_DOMAIN_BLOCK_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Domain Block Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__DOMAIN_BLOCK_RELATION = GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE__SOURCE = GEN_DOMAIN_BLOCK_RELATION__SOURCE;

	/**
	 * The number of structural features of the '<em>Gen Domain Block Merge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_MERGE_FEATURE_COUNT = GEN_DOMAIN_BLOCK_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Specific</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__SPECIFIC = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__GENERAL = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain Generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Domain Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_GENERALIZATION_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__GEN_MODEL = GEN_DOMAIN_CLASSIFIER__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__OWNER = GEN_DOMAIN_CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__OWNED_OBJECT = GEN_DOMAIN_CLASSIFIER__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__NAME = GEN_DOMAIN_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__DOMAIN_ELEMENT = GEN_DOMAIN_CLASSIFIER__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__BLOCK = GEN_DOMAIN_CLASSIFIER__BLOCK;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__MENU = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__CATEGORY = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__FEATURE = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uml Metaclass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__UML_METACLASS = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__GENERAL = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__REFERENCE = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__ATTRIBUTE = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__ICON_URI = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is RSM Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is RSMUI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is RSM Properties UI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Rhapsody Metaclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Rhapsody Stereotype Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Rhapsody Add New</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Rhapsody Add New Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Rhapsody Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Rhapsody To Add New</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Override</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__OVERRIDE = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT__GENERALIZATION = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Gen Domain Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_CONCEPT_FEATURE_COUNT = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Gen Palettable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTABLE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__GEN_MODEL = GEN_DOMAIN_NAMED_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__OWNER = GEN_DOMAIN_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__OWNED_OBJECT = GEN_DOMAIN_NAMED_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__NAME = GEN_DOMAIN_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ELEMENT = GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Presentation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Presentation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Uml Metaattribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Domain Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Concept</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Gen Domain Structural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE = 0;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY = 1;

	/**
	 * The feature id for the '<em><b>Presentation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT = 2;

	/**
	 * The feature id for the '<em><b>Presentation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND = 3;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER = 5;

	/**
	 * The number of structural features of the '<em>Gen Domain Attribute Presentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__GEN_MODEL = GEN_DOMAIN_STRUCTURAL_FEATURE__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__OWNER = GEN_DOMAIN_STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__OWNED_OBJECT = GEN_DOMAIN_STRUCTURAL_FEATURE__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__NAME = GEN_DOMAIN_STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__DOMAIN_ELEMENT = GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__VISIBLE = GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__READ_ONLY = GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Presentation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__PRESENTATION_HINT = GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT;

	/**
	 * The feature id for the '<em><b>Presentation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__PRESENTATION_KIND = GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__VISIBLE_MODEL_TYPE = GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__ORDER = GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER;

	/**
	 * The feature id for the '<em><b>Uml Metaattribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__UML_METAATTRIBUTE = GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Domain Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__DOMAIN_ATTRIBUTE = GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__IS_RHAPSODY_SUPPRESSED = GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED;

	/**
	 * The feature id for the '<em><b>Concept</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__CONCEPT = GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__TARGET = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__SOURCE = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Domain Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_REFERENCE_FEATURE_COUNT = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__GEN_MODEL = GEN_DOMAIN_STRUCTURAL_FEATURE__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__OWNER = GEN_DOMAIN_STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__OWNED_OBJECT = GEN_DOMAIN_STRUCTURAL_FEATURE__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__NAME = GEN_DOMAIN_STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__DOMAIN_ELEMENT = GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__VISIBLE = GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__READ_ONLY = GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Presentation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__PRESENTATION_HINT = GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT;

	/**
	 * The feature id for the '<em><b>Presentation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__PRESENTATION_KIND = GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__VISIBLE_MODEL_TYPE = GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__ORDER = GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER;

	/**
	 * The feature id for the '<em><b>Uml Metaattribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__UML_METAATTRIBUTE = GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Domain Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__DOMAIN_ATTRIBUTE = GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__IS_RHAPSODY_SUPPRESSED = GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED;

	/**
	 * The feature id for the '<em><b>Concept</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__CONCEPT = GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE__TYPE = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ATTRIBUTE_FEATURE_COUNT = GEN_DOMAIN_STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__GEN_MODEL = GEN_DOMAIN_CLASSIFIER__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__OWNER = GEN_DOMAIN_CLASSIFIER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__OWNED_OBJECT = GEN_DOMAIN_CLASSIFIER__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__NAME = GEN_DOMAIN_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__DOMAIN_ELEMENT = GEN_DOMAIN_CLASSIFIER__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__BLOCK = GEN_DOMAIN_CLASSIFIER__BLOCK;

	/**
	 * The feature id for the '<em><b>Domain Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE__DOMAIN_DATA_TYPE = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_DATA_TYPE_FEATURE_COUNT = GEN_DOMAIN_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__VISIBLE = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__READ_ONLY = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Presentation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__PRESENTATION_HINT = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT;

	/**
	 * The feature id for the '<em><b>Presentation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__PRESENTATION_KIND = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND;

	/**
	 * The feature id for the '<em><b>Visible Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__VISIBLE_MODEL_TYPE = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__ORDER = GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__GEN_MODEL = GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__OWNER = GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__OWNED_OBJECT = GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE__NAME = GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Gen Attribute Override</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_ATTRIBUTE_OVERRIDE_FEATURE_COUNT = GEN_DOMAIN_ATTRIBUTE_PRESENTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__TARGET = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Block Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain Specialization</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Domain Block Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_BLOCK_REFERENCE_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__GEN_MODEL = GEN_DOMAIN_PACKAGEABLE_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__OWNER = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__OWNED_OBJECT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__DOMAIN_ELEMENT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Domain Specialization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Plugin Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Domain Model Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Model Library Names Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Model Library Source Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Menu Model Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__VERSION = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Code Gen Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Rhapsody Java Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Rhapsody JDT Java Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Excluded Palette Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Included UML Menus</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Domain Block</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Elementtype Configuration Container Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT
			+ 15;

	/**
	 * The number of structural features of the '<em>Gen Domain Specialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_SPECIALIZATION_FEATURE_COUNT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl <em>Gen Domain Model Library Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModelLibraryReference()
	 * @generated
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE = 32;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Model Library Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain Specialization</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Gen Domain Model Library Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_REFERENCE_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl <em>Gen Domain Model Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModelLibrary()
	 * @generated
	 */
	int GEN_DOMAIN_MODEL_LIBRARY = 33;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__GEN_MODEL = GEN_DOMAIN_PACKAGEABLE_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__OWNER = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__OWNED_OBJECT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__NAME = GEN_DOMAIN_PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_ELEMENT = GEN_DOMAIN_PACKAGEABLE_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__PACKAGE = GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Domain Model Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Model Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_MODEL_LIBRARY_FEATURE_COUNT = GEN_DOMAIN_PACKAGEABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__GEN_MODEL = GEN_DOMAIN_DATA_TYPE__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__OWNER = GEN_DOMAIN_DATA_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__OWNED_OBJECT = GEN_DOMAIN_DATA_TYPE__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__NAME = GEN_DOMAIN_DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__DOMAIN_ELEMENT = GEN_DOMAIN_DATA_TYPE__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__BLOCK = GEN_DOMAIN_DATA_TYPE__BLOCK;

	/**
	 * The feature id for the '<em><b>Domain Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__DOMAIN_DATA_TYPE = GEN_DOMAIN_DATA_TYPE__DOMAIN_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM__LITERAL = GEN_DOMAIN_DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Domain Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_FEATURE_COUNT = GEN_DOMAIN_DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__GEN_MODEL = GEN_DOMAIN_NAMED_ELEMENT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__OWNER = GEN_DOMAIN_NAMED_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__OWNED_OBJECT = GEN_DOMAIN_NAMED_ELEMENT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__NAME = GEN_DOMAIN_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ELEMENT = GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Domain Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL__ENUMERATION = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Domain Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_DOMAIN_ENUM_LITERAL_FEATURE_COUNT = GEN_DOMAIN_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl <em>Gen Palette Creation Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteCreationTool()
	 * @generated
	 */
	int GEN_PALETTE_CREATION_TOOL = 36;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__GEN_MODEL = GEN_PALETTE_TOOL__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__OWNER = GEN_PALETTE_TOOL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__OWNED_OBJECT = GEN_PALETTE_TOOL__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__NAME = GEN_PALETTE_TOOL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__DESCRIPTION = GEN_PALETTE_TOOL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__OVERRIDES = GEN_PALETTE_TOOL__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__CONTAINER = GEN_PALETTE_TOOL__CONTAINER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__TYPE = GEN_PALETTE_TOOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT = GEN_PALETTE_TOOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL__EXPRESSION = GEN_PALETTE_TOOL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Palette Creation Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_CREATION_TOOL_FEATURE_COUNT = GEN_PALETTE_TOOL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ExpressionImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__GEN_MODEL = GEN_DOMAIN_OBJECT__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OWNER = GEN_DOMAIN_OBJECT__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OWNED_OBJECT = GEN_DOMAIN_OBJECT__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = GEN_DOMAIN_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl <em>Gen Palette Stack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteStack()
	 * @generated
	 */
	int GEN_PALETTE_STACK = 38;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__GEN_MODEL = GEN_PALETTE_TOOL_CONTAINER__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__OWNER = GEN_PALETTE_TOOL_CONTAINER__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__OWNED_OBJECT = GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__NAME = GEN_PALETTE_TOOL_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__DESCRIPTION = GEN_PALETTE_TOOL_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__OWNED_TOOL = GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__TOOL = GEN_PALETTE_TOOL_CONTAINER__TOOL;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__TARGET_DIAGRAM = GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__OVERRIDES = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__CONTAINER = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Active Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK__ACTIVE_TOOL = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Palette Stack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PALETTE_STACK_FEATURE_COUNT = GEN_PALETTE_TOOL_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawExpressionImpl <em>Oaw Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawExpressionImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getOawExpression()
	 * @generated
	 */
	int OAW_EXPRESSION = 39;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__GEN_MODEL = EXPRESSION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__OWNER = EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__OWNED_OBJECT = EXPRESSION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__EXPRESSION = EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION__VARIABLE_NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Oaw Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawXtendImpl <em>Oaw Xtend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawXtendImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getOawXtend()
	 * @generated
	 */
	int OAW_XTEND = 40;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__GEN_MODEL = EXPRESSION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__OWNER = EXPRESSION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__OWNED_OBJECT = EXPRESSION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__EXPRESSION = EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Extension File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND__EXTENSION_FILE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Oaw Xtend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAW_XTEND_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuActionImpl <em>Gen Menu Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuActionImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuAction()
	 * @generated
	 */
	int GEN_MENU_ACTION = 41;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__GEN_MODEL = GEN_MENU_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__OWNER = GEN_MENU_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__OWNED_OBJECT = GEN_MENU_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__DESCRIPTION = GEN_MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__NAME = GEN_MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION__OVERRIDES = GEN_MENU_ITEM__OVERRIDES;

	/**
	 * The number of structural features of the '<em>Gen Menu Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_ACTION_FEATURE_COUNT = GEN_MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl <em>Gen Menu Delegate Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuDelegateAction()
	 * @generated
	 */
	int GEN_MENU_DELEGATE_ACTION = 42;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__GEN_MODEL = GEN_MENU_ACTION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__OWNER = GEN_MENU_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__OWNED_OBJECT = GEN_MENU_ACTION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__DESCRIPTION = GEN_MENU_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__NAME = GEN_MENU_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__OVERRIDES = GEN_MENU_ACTION__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Host Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE = GEN_MENU_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION__CLASS_NAME = GEN_MENU_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Menu Delegate Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_DELEGATE_ACTION_FEATURE_COUNT = GEN_MENU_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl <em>Gen Menu Create Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuCreateAction()
	 * @generated
	 */
	int GEN_MENU_CREATE_ACTION = 43;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__GEN_MODEL = GEN_MENU_ACTION__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__OWNER = GEN_MENU_ACTION__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__OWNED_OBJECT = GEN_MENU_ACTION__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__DESCRIPTION = GEN_MENU_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__NAME = GEN_MENU_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__OVERRIDES = GEN_MENU_ACTION__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__TYPE_HINT = GEN_MENU_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Create Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__CREATE_CONCEPT = GEN_MENU_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION__EXPRESSION = GEN_MENU_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gen Menu Create Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_CREATE_ACTION_FEATURE_COUNT = GEN_MENU_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuSeparatorImpl <em>Gen Menu Separator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuSeparatorImpl
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuSeparator()
	 * @generated
	 */
	int GEN_MENU_SEPARATOR = 44;

	/**
	 * The feature id for the '<em><b>Gen Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__GEN_MODEL = GEN_MENU_ITEM__GEN_MODEL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__OWNER = GEN_MENU_ITEM__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__OWNED_OBJECT = GEN_MENU_ITEM__OWNED_OBJECT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__DESCRIPTION = GEN_MENU_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__NAME = GEN_MENU_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR__OVERRIDES = GEN_MENU_ITEM__OVERRIDES;

	/**
	 * The number of structural features of the '<em>Gen Menu Separator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MENU_SEPARATOR_FEATURE_COUNT = GEN_MENU_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind <em>Gen Palette Diagram Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteDiagramKind()
	 * @generated
	 */
	int GEN_PALETTE_DIAGRAM_KIND = 45;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory <em>Gen Domain Concept Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainConceptCategory()
	 * @generated
	 */
	int GEN_DOMAIN_CONCEPT_CATEGORY = 47;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind <em>Gen Domain Attribute Presentation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttributePresentationKind()
	 * @generated
	 */
	int GEN_DOMAIN_ATTRIBUTE_PRESENTATION_KIND = 48;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind <em>Gen Domain Presentation Model Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPresentationModelKind()
	 * @generated
	 */
	int GEN_DOMAIN_PRESENTATION_MODEL_KIND = 49;

	/**
	 * The meta object id for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode <em>Gen All Domain Cassifiers Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode
	 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenAllDomainCassifiersMode()
	 * @generated
	 */
	int GEN_ALL_DOMAIN_CASSIFIERS_MODE = 46;

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept <em>Gen Domain Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept
	 * @generated
	 */
	EClass getGenDomainConcept();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getCategory()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_Category();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getFeatures <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getFeatures()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_Feature();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalettable <em>Gen Palettable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palettable</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalettable
	 * @generated
	 */
	EClass getGenPalettable();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem <em>Gen Palette Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Item</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem
	 * @generated
	 */
	EClass getGenPaletteItem();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem#getName()
	 * @see #getGenPaletteItem()
	 * @generated
	 */
	EAttribute getGenPaletteItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem#getDescription()
	 * @see #getGenPaletteItem()
	 * @generated
	 */
	EAttribute getGenPaletteItem_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGeneralizations <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generalization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGeneralizations()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_Generalization();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getDomainConcept <em>Domain Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getDomainConcept()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_DomainConcept();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getUmlMetaclasses <em>Uml Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uml Metaclass</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getUmlMetaclasses()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_UmlMetaclass();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGenerals <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>General</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGenerals()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_General();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getReferences <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getReferences()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_Reference();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getAttributes <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getAttributes()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getIconUri <em>Icon Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Uri</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getIconUri()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_IconUri();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed <em>Is RSM Suppressed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is RSM Suppressed</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_IsRSMSuppressed();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is RSMUI Read Only</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_IsRSMUIReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is RSM Properties UI Read Only</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_IsRSMPropertiesUIReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Rhapsody Suppressed</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRhapsodySuppressed()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_IsRhapsodySuppressed();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyMetaclass <em>Rhapsody Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rhapsody Metaclass</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyMetaclass()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_RhapsodyMetaclass();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyStereotypeName <em>Rhapsody Stereotype Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rhapsody Stereotype Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyStereotypeName()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_RhapsodyStereotypeName();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNews <em>Rhapsody Add New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Rhapsody Add New</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNews()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_RhapsodyAddNew();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNewConcepts <em>Rhapsody Add New Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rhapsody Add New Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNewConcepts()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_RhapsodyAddNewConcept();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyDisplayName <em>Rhapsody Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rhapsody Display Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyDisplayName()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EAttribute getGenDomainConcept_RhapsodyDisplayName();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyToAddNews <em>Rhapsody To Add New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rhapsody To Add New</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyToAddNews()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_RhapsodyToAddNew();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getOverrides <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Override</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getOverrides()
	 * @see #getGenDomainConcept()
	 * @generated
	 */
	EReference getGenDomainConcept_Override();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier <em>Gen Domain Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Classifier</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier
	 * @generated
	 */
	EClass getGenDomainClassifier();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier#getBlock()
	 * @see #getGenDomainClassifier()
	 * @generated
	 */
	EReference getGenDomainClassifier_Block();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement <em>Gen Domain Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Named Element</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement
	 * @generated
	 */
	EClass getGenDomainNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getName()
	 * @see #getGenDomainNamedElement()
	 * @generated
	 */
	EAttribute getGenDomainNamedElement_Name();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement <em>Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Element</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement()
	 * @see #getGenDomainNamedElement()
	 * @generated
	 */
	EReference getGenDomainNamedElement_DomainElement();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature <em>Gen Domain Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Structural Feature</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature
	 * @generated
	 */
	EClass getGenDomainStructuralFeature();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getUmlMetaattribute <em>Uml Metaattribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Metaattribute</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getUmlMetaattribute()
	 * @see #getGenDomainStructuralFeature()
	 * @generated
	 */
	EReference getGenDomainStructuralFeature_UmlMetaattribute();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getDomainAttribute <em>Domain Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Attribute</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getDomainAttribute()
	 * @see #getGenDomainStructuralFeature()
	 * @generated
	 */
	EReference getGenDomainStructuralFeature_DomainAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Rhapsody Suppressed</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#isRhapsodySuppressed()
	 * @see #getGenDomainStructuralFeature()
	 * @generated
	 */
	EAttribute getGenDomainStructuralFeature_IsRhapsodySuppressed();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getConcept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getConcept()
	 * @see #getGenDomainStructuralFeature()
	 * @generated
	 */
	EReference getGenDomainStructuralFeature_Concept();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization <em>Gen Domain Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Generalization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization
	 * @generated
	 */
	EClass getGenDomainGeneralization();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>General</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getGeneral()
	 * @see #getGenDomainGeneralization()
	 * @generated
	 */
	EReference getGenDomainGeneralization_General();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getDomainGeneralization <em>Domain Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Generalization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getDomainGeneralization()
	 * @see #getGenDomainGeneralization()
	 * @generated
	 */
	EReference getGenDomainGeneralization_DomainGeneralization();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getSpecific <em>Specific</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specific</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization#getSpecific()
	 * @see #getGenDomainGeneralization()
	 * @generated
	 */
	EReference getGenDomainGeneralization_Specific();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock <em>Gen Domain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Block</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock
	 * @generated
	 */
	EClass getGenDomainBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getClassifiers <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifier</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getClassifiers()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EReference getGenDomainBlock_Classifier();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getRelations <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relation</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getRelations()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EReference getGenDomainBlock_Relation();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getDomainBlock <em>Domain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Block</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getDomainBlock()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EReference getGenDomainBlock_DomainBlock();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getImports <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Import</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getImports()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EReference getGenDomainBlock_Import();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getMerges <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Merge</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getMerges()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EReference getGenDomainBlock_Merge();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesSuppressed <em>Rsm Stereotypes Suppressed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rsm Stereotypes Suppressed</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesSuppressed()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EAttribute getGenDomainBlock_RsmStereotypesSuppressed();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesUIReadOnly <em>Rsm Stereotypes UI Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rsm Stereotypes UI Read Only</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesUIReadOnly()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EAttribute getGenDomainBlock_RsmStereotypesUIReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesPropertiesUIReadOnly <em>Rsm Stereotypes Properties UI Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rsm Stereotypes Properties UI Read Only</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesPropertiesUIReadOnly()
	 * @see #getGenDomainBlock()
	 * @generated
	 */
	EAttribute getGenDomainBlock_RsmStereotypesPropertiesUIReadOnly();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject <em>Gen Domain Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Object</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject
	 * @generated
	 */
	EClass getGenDomainObject();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwner()
	 * @see #getGenDomainObject()
	 * @generated
	 */
	EReference getGenDomainObject_Owner();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects <em>Owned Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Object</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects()
	 * @see #getGenDomainObject()
	 * @generated
	 */
	EReference getGenDomainObject_OwnedObject();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getGenModel <em>Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gen Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getGenModel()
	 * @see #getGenDomainObject()
	 * @generated
	 */
	EReference getGenDomainObject_GenModel();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation <em>Gen Domain Block Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Block Relation</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation
	 * @generated
	 */
	EClass getGenDomainBlockRelation();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getSource()
	 * @see #getGenDomainBlockRelation()
	 * @generated
	 */
	EReference getGenDomainBlockRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getTarget()
	 * @see #getGenDomainBlockRelation()
	 * @generated
	 */
	EReference getGenDomainBlockRelation_Target();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getDomainBlockRelation <em>Domain Block Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Block Relation</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation#getDomainBlockRelation()
	 * @see #getGenDomainBlockRelation()
	 * @generated
	 */
	EReference getGenDomainBlockRelation_DomainBlockRelation();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute <em>Gen Domain Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Attribute</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute
	 * @generated
	 */
	EClass getGenDomainAttribute();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute#getType()
	 * @see #getGenDomainAttribute()
	 * @generated
	 */
	EReference getGenDomainAttribute_Type();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType <em>Gen Domain Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Data Type</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType
	 * @generated
	 */
	EClass getGenDomainDataType();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType#getDomainDataType <em>Domain Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Data Type</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType#getDomainDataType()
	 * @see #getGenDomainDataType()
	 * @generated
	 */
	EReference getGenDomainDataType_DomainDataType();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride <em>Gen Attribute Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Attribute Override</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride
	 * @generated
	 */
	EClass getGenAttributeOverride();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride#getName()
	 * @see #getGenAttributeOverride()
	 * @generated
	 */
	EAttribute getGenAttributeOverride_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu <em>Gen Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenu
	 * @generated
	 */
	EClass getGenMenu();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getItems <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Item</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getItems()
	 * @see #getGenMenu()
	 * @generated
	 */
	EReference getGenMenu_Item();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extends</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getExtends()
	 * @see #getGenMenu()
	 * @generated
	 */
	EReference getGenMenu_Extends();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem <em>Gen Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Item</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem
	 * @generated
	 */
	EClass getGenMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getDescription()
	 * @see #getGenMenuItem()
	 * @generated
	 */
	EAttribute getGenMenuItem_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getName()
	 * @see #getGenMenuItem()
	 * @generated
	 */
	EAttribute getGenMenuItem_Name();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overrides</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#getOverrides()
	 * @see #getGenMenuItem()
	 * @generated
	 */
	EReference getGenMenuItem_Overrides();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu <em>Gen UML Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen UML Menu</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu
	 * @generated
	 */
	EClass getGenUMLMenu();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu#getUmlMetaclass <em>Uml Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Metaclass</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu#getUmlMetaclass()
	 * @see #getGenUMLMenu()
	 * @generated
	 */
	EReference getGenUMLMenu_UmlMetaclass();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget <em>Gen Menu Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget
	 * @generated
	 */
	EClass getGenMenuTarget();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget#getMenu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Menu</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget#getMenu()
	 * @see #getGenMenuTarget()
	 * @generated
	 */
	EReference getGenMenuTarget_Menu();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport <em>Gen Domain Block Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Block Import</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport
	 * @generated
	 */
	EClass getGenDomainBlockImport();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge <em>Gen Domain Block Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Block Merge</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge
	 * @generated
	 */
	EClass getGenDomainBlockMerge();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette <em>Gen Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalette
	 * @generated
	 */
	EClass getGenPalette();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getOwnedDrawers <em>Owned Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Drawer</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getOwnedDrawers()
	 * @see #getGenPalette()
	 * @generated
	 */
	EReference getGenPalette_OwnedDrawer();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getDrawers <em>Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Drawer</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getDrawers()
	 * @see #getGenPalette()
	 * @generated
	 */
	EReference getGenPalette_Drawer();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer <em>Gen Palette Drawer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Drawer</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer
	 * @generated
	 */
	EClass getGenPaletteDrawer();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer#getSpecializes <em>Specializes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specializes</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer#getSpecializes()
	 * @see #getGenPaletteDrawer()
	 * @generated
	 */
	EReference getGenPaletteDrawer_Specializes();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer#getPalette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Palette</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer#getPalette()
	 * @see #getGenPaletteDrawer()
	 * @generated
	 */
	EReference getGenPaletteDrawer_Palette();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer <em>Gen Palette Tool Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Tool Container</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer
	 * @generated
	 */
	EClass getGenPaletteToolContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getOwnedTools <em>Owned Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tool</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getOwnedTools()
	 * @see #getGenPaletteToolContainer()
	 * @generated
	 */
	EReference getGenPaletteToolContainer_OwnedTool();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTools <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tool</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTools()
	 * @see #getGenPaletteToolContainer()
	 * @generated
	 */
	EReference getGenPaletteToolContainer_Tool();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTargetDiagrams <em>Target Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Target Diagram</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTargetDiagrams()
	 * @see #getGenPaletteToolContainer()
	 * @generated
	 */
	EAttribute getGenPaletteToolContainer_TargetDiagram();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool <em>Gen Palette Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Tool</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool
	 * @generated
	 */
	EClass getGenPaletteTool();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overrides</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool#getOverrides()
	 * @see #getGenPaletteTool()
	 * @generated
	 */
	EReference getGenPaletteTool_Overrides();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool#getContainer()
	 * @see #getGenPaletteTool()
	 * @generated
	 */
	EReference getGenPaletteTool_Container();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel <em>Gen Menu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel
	 * @generated
	 */
	EClass getGenMenuModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getItems()
	 * @see #getGenMenuModel()
	 * @generated
	 */
	EReference getGenMenuModel_Items();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getUmlMeni <em>Uml Menus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uml Menus</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getUmlMeni()
	 * @see #getGenMenuModel()
	 * @generated
	 */
	EReference getGenMenuModel_UmlMenus();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference <em>Gen Domain Block Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Block Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference
	 * @generated
	 */
	EClass getGenDomainBlockReference();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getTarget()
	 * @see #getGenDomainBlockReference()
	 * @generated
	 */
	EReference getGenDomainBlockReference_Target();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainBlockReference <em>Domain Block Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Block Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainBlockReference()
	 * @see #getGenDomainBlockReference()
	 * @generated
	 */
	EReference getGenDomainBlockReference_DomainBlockReference();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainSpecialization <em>Domain Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Domain Specialization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainSpecialization()
	 * @see #getGenDomainBlockReference()
	 * @generated
	 */
	EReference getGenDomainBlockReference_DomainSpecialization();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum <em>Gen Domain Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Enum</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum
	 * @generated
	 */
	EClass getGenDomainEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum#getLiterals <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum#getLiterals()
	 * @see #getGenDomainEnum()
	 * @generated
	 */
	EReference getGenDomainEnum_Literal();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral <em>Gen Domain Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Enum Literal</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral
	 * @generated
	 */
	EClass getGenDomainEnumLiteral();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getDomainEnumLiteral <em>Domain Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Enum Literal</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getDomainEnumLiteral()
	 * @see #getGenDomainEnumLiteral()
	 * @generated
	 */
	EReference getGenDomainEnumLiteral_DomainEnumLiteral();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getEnumeration()
	 * @see #getGenDomainEnumLiteral()
	 * @generated
	 */
	EReference getGenDomainEnumLiteral_Enumeration();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool <em>Gen Palette Creation Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Creation Tool</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool
	 * @generated
	 */
	EClass getGenPaletteCreationTool();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getType()
	 * @see #getGenPaletteCreationTool()
	 * @generated
	 */
	EReference getGenPaletteCreationTool_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getElementTypeHint <em>Element Type Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type Hint</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getElementTypeHint()
	 * @see #getGenPaletteCreationTool()
	 * @generated
	 */
	EAttribute getGenPaletteCreationTool_ElementTypeHint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getExpressions <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getExpressions()
	 * @see #getGenPaletteCreationTool()
	 * @generated
	 */
	EReference getGenPaletteCreationTool_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.Expression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.Expression#getName()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.Expression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.Expression#getExpression()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack <em>Gen Palette Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Palette Stack</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack
	 * @generated
	 */
	EClass getGenPaletteStack();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack#getActiveTool <em>Active Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Tool</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack#getActiveTool()
	 * @see #getGenPaletteStack()
	 * @generated
	 */
	EReference getGenPaletteStack_ActiveTool();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.OawExpression <em>Oaw Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oaw Expression</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawExpression
	 * @generated
	 */
	EClass getOawExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.OawExpression#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawExpression#getVariableName()
	 * @see #getOawExpression()
	 * @generated
	 */
	EAttribute getOawExpression_VariableName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.OawXtend <em>Oaw Xtend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oaw Xtend</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawXtend
	 * @generated
	 */
	EClass getOawXtend();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.OawXtend#getExtensionFile <em>Extension File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension File</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.OawXtend#getExtensionFile()
	 * @see #getOawXtend()
	 * @generated
	 */
	EAttribute getOawXtend_ExtensionFile();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuAction <em>Gen Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Action</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuAction
	 * @generated
	 */
	EClass getGenMenuAction();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction <em>Gen Menu Delegate Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Delegate Action</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction
	 * @generated
	 */
	EClass getGenMenuDelegateAction();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction#getHostBundle <em>Host Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host Bundle</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction#getHostBundle()
	 * @see #getGenMenuDelegateAction()
	 * @generated
	 */
	EAttribute getGenMenuDelegateAction_HostBundle();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuDelegateAction#getClassName()
	 * @see #getGenMenuDelegateAction()
	 * @generated
	 */
	EAttribute getGenMenuDelegateAction_ClassName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction <em>Gen Menu Create Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Create Action</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction
	 * @generated
	 */
	EClass getGenMenuCreateAction();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getTypeHint <em>Type Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Hint</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getTypeHint()
	 * @see #getGenMenuCreateAction()
	 * @generated
	 */
	EAttribute getGenMenuCreateAction_TypeHint();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getCreateConcept <em>Create Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Create Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getCreateConcept()
	 * @see #getGenMenuCreateAction()
	 * @generated
	 */
	EReference getGenMenuCreateAction_CreateConcept();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getExpressions <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expression</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getExpressions()
	 * @see #getGenMenuCreateAction()
	 * @generated
	 */
	EReference getGenMenuCreateAction_Expression();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator <em>Gen Menu Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Menu Separator</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenMenuSeparator
	 * @generated
	 */
	EClass getGenMenuSeparator();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind <em>Gen Palette Diagram Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gen Palette Diagram Kind</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind
	 * @generated
	 */
	EEnum getGenPaletteDiagramKind();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference <em>Gen Domain Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference
	 * @generated
	 */
	EClass getGenDomainReference();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getTarget()
	 * @see #getGenDomainReference()
	 * @generated
	 */
	EReference getGenDomainReference_Target();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getSource()
	 * @see #getGenDomainReference()
	 * @generated
	 */
	EReference getGenDomainReference_Source();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getDomainReference <em>Domain Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getDomainReference()
	 * @see #getGenDomainReference()
	 * @generated
	 */
	EReference getGenDomainReference_DomainReference();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation <em>Gen Domain Attribute Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Attribute Presentation</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation
	 * @generated
	 */
	EClass getGenDomainAttributePresentation();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#isVisible()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_Visible();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#isReadOnly()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getPresentationHint <em>Presentation Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Hint</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getPresentationHint()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_PresentationHint();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getPresentationKind <em>Presentation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Kind</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getPresentationKind()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_PresentationKind();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getVisibleModelType <em>Visible Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible Model Type</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getVisibleModelType()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_VisibleModelType();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation#getOrder()
	 * @see #getGenDomainAttributePresentation()
	 * @generated
	 */
	EAttribute getGenDomainAttributePresentation_Order();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization <em>Gen Domain Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Specialization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization
	 * @generated
	 */
	EClass getGenDomainSpecialization();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainBlocks <em>Domain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Block</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainBlocks()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_DomainBlock();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getElementtypeConfigurationContainerUri <em>Elementtype Configuration Container Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Elementtype Configuration Container Uri</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getElementtypeConfigurationContainerUri()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_ElementtypeConfigurationContainerUri();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference <em>Gen Domain Model Library Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Model Library Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference
	 * @generated
	 */
	EClass getGenDomainModelLibraryReference();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getTarget()
	 * @see #getGenDomainModelLibraryReference()
	 * @generated
	 */
	EReference getGenDomainModelLibraryReference_Target();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getDomainModelLibraryReference <em>Domain Model Library Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Model Library Reference</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getDomainModelLibraryReference()
	 * @see #getGenDomainModelLibraryReference()
	 * @generated
	 */
	EReference getGenDomainModelLibraryReference_DomainModelLibraryReference();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getResourceName <em>Resource Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getResourceName()
	 * @see #getGenDomainModelLibraryReference()
	 * @generated
	 */
	EAttribute getGenDomainModelLibraryReference_ResourceName();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getDomainSpecialization <em>Domain Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Domain Specialization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference#getDomainSpecialization()
	 * @see #getGenDomainModelLibraryReference()
	 * @generated
	 */
	EReference getGenDomainModelLibraryReference_DomainSpecialization();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary <em>Gen Domain Model Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Model Library</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary
	 * @generated
	 */
	EClass getGenDomainModelLibrary();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary#getDomainModelLibrary <em>Domain Model Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Model Library</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary#getDomainModelLibrary()
	 * @see #getGenDomainModelLibrary()
	 * @generated
	 */
	EReference getGenDomainModelLibrary_DomainModelLibrary();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainSpecialization <em>Domain Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Specialization</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainSpecialization()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_DomainSpecialization();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainConcepts <em>Domain Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain Concept</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainConcepts()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_DomainConcept();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getPluginName <em>Plugin Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getPluginName()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_PluginName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getResourceName <em>Resource Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Name</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getResourceName()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_ResourceName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainModelLibraries <em>Domain Model Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Model Library</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainModelLibraries()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_DomainModelLibrary();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibraryNamesPackage <em>Model Library Names Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Library Names Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibraryNamesPackage()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_ModelLibraryNamesPackage();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibrarySourceFolder <em>Model Library Source Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Library Source Folder</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibrarySourceFolder()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_ModelLibrarySourceFolder();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getMenuModelResource <em>Menu Model Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Menu Model Resource</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getMenuModelResource()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_MenuModelResource();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getVersion()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getCodeGenTarget <em>Code Gen Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code Gen Target</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getCodeGenTarget()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_CodeGenTarget();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJavaProject <em>Rhapsody Java Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rhapsody Java Project</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJavaProject()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_RhapsodyJavaProject();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJDTJavaLibrary <em>Rhapsody JDT Java Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rhapsody JDT Java Library</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJDTJavaLibrary()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EAttribute getGenDomainSpecialization_RhapsodyJDTJavaLibrary();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getExcludedPaletteItems <em>Excluded Palette Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excluded Palette Item</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getExcludedPaletteItems()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_ExcludedPaletteItem();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getIncludedUMLMeni <em>Included UML Menus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Included UML Menus</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getIncludedUMLMeni()
	 * @see #getGenDomainSpecialization()
	 * @generated
	 */
	EReference getGenDomainSpecialization_IncludedUMLMenus();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel <em>Gen Domain Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel
	 * @generated
	 */
	EClass getGenDomainModel();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getDomainModel <em>Domain Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getDomainModel()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EReference getGenDomainModel_DomainModel();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getNsURI()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EAttribute getGenDomainModel_NsURI();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getRootPackage <em>Root Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getRootPackage()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EAttribute getGenDomainModel_RootPackage();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getImplementationSubPackage <em>Implementation Sub Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Sub Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getImplementationSubPackage()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EAttribute getGenDomainModel_ImplementationSubPackage();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getImplSuffix <em>Impl Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Impl Suffix</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getImplSuffix()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EAttribute getGenDomainModel_ImplSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getApiProject <em>Api Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Project</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getApiProject()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EAttribute getGenDomainModel_ApiProject();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getPalette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Palette</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getPalette()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EReference getGenDomainModel_Palette();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getMenuModel <em>Menu Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Menu Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getMenuModel()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EReference getGenDomainModel_MenuModel();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getOwningGenModel <em>Owning Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Gen Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getOwningGenModel()
	 * @see #getGenDomainModel()
	 * @generated
	 */
	EReference getGenDomainModel_OwningGenModel();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel <em>Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenModel
	 * @generated
	 */
	EClass getGenModel();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getReferencedModels <em>Referenced Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenModel#getReferencedModels()
	 * @see #getGenModel()
	 * @generated
	 */
	EReference getGenModel_ReferencedModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getOwnedModels <em>Owned Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenModel#getOwnedModels()
	 * @see #getGenModel()
	 * @generated
	 */
	EReference getGenModel_OwnedModel();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels <em>Domain Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain Model</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels()
	 * @see #getGenModel()
	 * @generated
	 */
	EReference getGenModel_DomainModel();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement <em>Gen Domain Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Packageable Element</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement
	 * @generated
	 */
	EClass getGenDomainPackageableElement();

	/**
	 * Returns the meta object for the container reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement#getPackage()
	 * @see #getGenDomainPackageableElement()
	 * @generated
	 */
	EReference getGenDomainPackageableElement_Package();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage <em>Gen Domain Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Domain Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage
	 * @generated
	 */
	EClass getGenDomainPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getElements <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getElements()
	 * @see #getGenDomainPackage()
	 * @generated
	 */
	EReference getGenDomainPackage_Element();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getDomainPackage <em>Domain Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Package</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getDomainPackage()
	 * @see #getGenDomainPackage()
	 * @generated
	 */
	EReference getGenDomainPackage_DomainPackage();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory <em>Gen Domain Concept Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gen Domain Concept Category</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory
	 * @generated
	 */
	EEnum getGenDomainConceptCategory();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind <em>Gen Domain Attribute Presentation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gen Domain Attribute Presentation Kind</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind
	 * @generated
	 */
	EEnum getGenDomainAttributePresentationKind();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind <em>Gen Domain Presentation Model Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gen Domain Presentation Model Kind</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind
	 * @generated
	 */
	EEnum getGenDomainPresentationModelKind();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode <em>Gen All Domain Cassifiers Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gen All Domain Cassifiers Mode</em>'.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode
	 * @generated
	 */
	EEnum getGenAllDomainCassifiersMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ZDLGenFactory getZDLGenFactory();

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
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl <em>Gen Domain Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainConcept()
		 * @generated
		 */
		EClass GEN_DOMAIN_CONCEPT = eINSTANCE.getGenDomainConcept();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__CATEGORY = eINSTANCE.getGenDomainConcept_Category();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__FEATURE = eINSTANCE.getGenDomainConcept_Feature();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPalettableImpl <em>Gen Palettable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPalettableImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPalettable()
		 * @generated
		 */
		EClass GEN_PALETTABLE = eINSTANCE.getGenPalettable();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteItemImpl <em>Gen Palette Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteItemImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteItem()
		 * @generated
		 */
		EClass GEN_PALETTE_ITEM = eINSTANCE.getGenPaletteItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_PALETTE_ITEM__NAME = eINSTANCE.getGenPaletteItem_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_PALETTE_ITEM__DESCRIPTION = eINSTANCE.getGenPaletteItem_Description();

		/**
		 * The meta object literal for the '<em><b>Generalization</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__GENERALIZATION = eINSTANCE.getGenDomainConcept_Generalization();

		/**
		 * The meta object literal for the '<em><b>Domain Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT = eINSTANCE.getGenDomainConcept_DomainConcept();

		/**
		 * The meta object literal for the '<em><b>Uml Metaclass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__UML_METACLASS = eINSTANCE.getGenDomainConcept_UmlMetaclass();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__GENERAL = eINSTANCE.getGenDomainConcept_General();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__REFERENCE = eINSTANCE.getGenDomainConcept_Reference();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__ATTRIBUTE = eINSTANCE.getGenDomainConcept_Attribute();

		/**
		 * The meta object literal for the '<em><b>Icon Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__ICON_URI = eINSTANCE.getGenDomainConcept_IconUri();

		/**
		 * The meta object literal for the '<em><b>Is RSM Suppressed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED = eINSTANCE.getGenDomainConcept_IsRSMSuppressed();

		/**
		 * The meta object literal for the '<em><b>Is RSMUI Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY = eINSTANCE.getGenDomainConcept_IsRSMUIReadOnly();

		/**
		 * The meta object literal for the '<em><b>Is RSM Properties UI Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY = eINSTANCE
				.getGenDomainConcept_IsRSMPropertiesUIReadOnly();

		/**
		 * The meta object literal for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED = eINSTANCE.getGenDomainConcept_IsRhapsodySuppressed();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Metaclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS = eINSTANCE.getGenDomainConcept_RhapsodyMetaclass();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Stereotype Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME = eINSTANCE
				.getGenDomainConcept_RhapsodyStereotypeName();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Add New</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW = eINSTANCE.getGenDomainConcept_RhapsodyAddNew();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Add New Concept</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT = eINSTANCE.getGenDomainConcept_RhapsodyAddNewConcept();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME = eINSTANCE.getGenDomainConcept_RhapsodyDisplayName();

		/**
		 * The meta object literal for the '<em><b>Rhapsody To Add New</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW = eINSTANCE.getGenDomainConcept_RhapsodyToAddNew();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CONCEPT__OVERRIDE = eINSTANCE.getGenDomainConcept_Override();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainClassifierImpl <em>Gen Domain Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainClassifierImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainClassifier()
		 * @generated
		 */
		EClass GEN_DOMAIN_CLASSIFIER = eINSTANCE.getGenDomainClassifier();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_CLASSIFIER__BLOCK = eINSTANCE.getGenDomainClassifier_Block();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainNamedElementImpl <em>Gen Domain Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainNamedElementImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainNamedElement()
		 * @generated
		 */
		EClass GEN_DOMAIN_NAMED_ELEMENT = eINSTANCE.getGenDomainNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_NAMED_ELEMENT__NAME = eINSTANCE.getGenDomainNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Domain Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_NAMED_ELEMENT__DOMAIN_ELEMENT = eINSTANCE.getGenDomainNamedElement_DomainElement();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl <em>Gen Domain Structural Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainStructuralFeature()
		 * @generated
		 */
		EClass GEN_DOMAIN_STRUCTURAL_FEATURE = eINSTANCE.getGenDomainStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Uml Metaattribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE = eINSTANCE
				.getGenDomainStructuralFeature_UmlMetaattribute();

		/**
		 * The meta object literal for the '<em><b>Domain Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE = eINSTANCE
				.getGenDomainStructuralFeature_DomainAttribute();

		/**
		 * The meta object literal for the '<em><b>Is Rhapsody Suppressed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED = eINSTANCE
				.getGenDomainStructuralFeature_IsRhapsodySuppressed();

		/**
		 * The meta object literal for the '<em><b>Concept</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT = eINSTANCE.getGenDomainStructuralFeature_Concept();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl <em>Gen Domain Generalization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainGeneralizationImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainGeneralization()
		 * @generated
		 */
		EClass GEN_DOMAIN_GENERALIZATION = eINSTANCE.getGenDomainGeneralization();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_GENERALIZATION__GENERAL = eINSTANCE.getGenDomainGeneralization_General();

		/**
		 * The meta object literal for the '<em><b>Domain Generalization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_GENERALIZATION__DOMAIN_GENERALIZATION = eINSTANCE
				.getGenDomainGeneralization_DomainGeneralization();

		/**
		 * The meta object literal for the '<em><b>Specific</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_GENERALIZATION__SPECIFIC = eINSTANCE.getGenDomainGeneralization_Specific();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl <em>Gen Domain Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlock()
		 * @generated
		 */
		EClass GEN_DOMAIN_BLOCK = eINSTANCE.getGenDomainBlock();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK__CLASSIFIER = eINSTANCE.getGenDomainBlock_Classifier();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK__RELATION = eINSTANCE.getGenDomainBlock_Relation();

		/**
		 * The meta object literal for the '<em><b>Domain Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK__DOMAIN_BLOCK = eINSTANCE.getGenDomainBlock_DomainBlock();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK__IMPORT = eINSTANCE.getGenDomainBlock_Import();

		/**
		 * The meta object literal for the '<em><b>Merge</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK__MERGE = eINSTANCE.getGenDomainBlock_Merge();

		/**
		 * The meta object literal for the '<em><b>Rsm Stereotypes Suppressed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED = eINSTANCE
				.getGenDomainBlock_RsmStereotypesSuppressed();

		/**
		 * The meta object literal for the '<em><b>Rsm Stereotypes UI Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY = eINSTANCE
				.getGenDomainBlock_RsmStereotypesUIReadOnly();

		/**
		 * The meta object literal for the '<em><b>Rsm Stereotypes Properties UI Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY = eINSTANCE
				.getGenDomainBlock_RsmStereotypesPropertiesUIReadOnly();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl <em>Gen Domain Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainObjectImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainObject()
		 * @generated
		 */
		EClass GEN_DOMAIN_OBJECT = eINSTANCE.getGenDomainObject();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_OBJECT__OWNER = eINSTANCE.getGenDomainObject_Owner();

		/**
		 * The meta object literal for the '<em><b>Owned Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_OBJECT__OWNED_OBJECT = eINSTANCE.getGenDomainObject_OwnedObject();

		/**
		 * The meta object literal for the '<em><b>Gen Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_OBJECT__GEN_MODEL = eINSTANCE.getGenDomainObject_GenModel();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl <em>Gen Domain Block Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockRelationImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockRelation()
		 * @generated
		 */
		EClass GEN_DOMAIN_BLOCK_RELATION = eINSTANCE.getGenDomainBlockRelation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_RELATION__SOURCE = eINSTANCE.getGenDomainBlockRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_RELATION__TARGET = eINSTANCE.getGenDomainBlockRelation_Target();

		/**
		 * The meta object literal for the '<em><b>Domain Block Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_RELATION__DOMAIN_BLOCK_RELATION = eINSTANCE
				.getGenDomainBlockRelation_DomainBlockRelation();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributeImpl <em>Gen Domain Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributeImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttribute()
		 * @generated
		 */
		EClass GEN_DOMAIN_ATTRIBUTE = eINSTANCE.getGenDomainAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_ATTRIBUTE__TYPE = eINSTANCE.getGenDomainAttribute_Type();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainDataTypeImpl <em>Gen Domain Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainDataTypeImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainDataType()
		 * @generated
		 */
		EClass GEN_DOMAIN_DATA_TYPE = eINSTANCE.getGenDomainDataType();

		/**
		 * The meta object literal for the '<em><b>Domain Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_DATA_TYPE__DOMAIN_DATA_TYPE = eINSTANCE.getGenDomainDataType_DomainDataType();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl <em>Gen Attribute Override</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenAttributeOverrideImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenAttributeOverride()
		 * @generated
		 */
		EClass GEN_ATTRIBUTE_OVERRIDE = eINSTANCE.getGenAttributeOverride();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_ATTRIBUTE_OVERRIDE__NAME = eINSTANCE.getGenAttributeOverride_Name();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuImpl <em>Gen Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenu()
		 * @generated
		 */
		EClass GEN_MENU = eINSTANCE.getGenMenu();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU__ITEM = eINSTANCE.getGenMenu_Item();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU__EXTENDS = eINSTANCE.getGenMenu_Extends();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl <em>Gen Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuItemImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuItem()
		 * @generated
		 */
		EClass GEN_MENU_ITEM = eINSTANCE.getGenMenuItem();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MENU_ITEM__DESCRIPTION = eINSTANCE.getGenMenuItem_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MENU_ITEM__NAME = eINSTANCE.getGenMenuItem_Name();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_ITEM__OVERRIDES = eINSTANCE.getGenMenuItem_Overrides();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl <em>Gen UML Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenUMLMenu()
		 * @generated
		 */
		EClass GEN_UML_MENU = eINSTANCE.getGenUMLMenu();

		/**
		 * The meta object literal for the '<em><b>Uml Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_UML_MENU__UML_METACLASS = eINSTANCE.getGenUMLMenu_UmlMetaclass();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuTargetImpl <em>Gen Menu Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuTargetImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuTarget()
		 * @generated
		 */
		EClass GEN_MENU_TARGET = eINSTANCE.getGenMenuTarget();

		/**
		 * The meta object literal for the '<em><b>Menu</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_TARGET__MENU = eINSTANCE.getGenMenuTarget_Menu();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImportImpl <em>Gen Domain Block Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImportImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockImport()
		 * @generated
		 */
		EClass GEN_DOMAIN_BLOCK_IMPORT = eINSTANCE.getGenDomainBlockImport();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockMergeImpl <em>Gen Domain Block Merge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockMergeImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockMerge()
		 * @generated
		 */
		EClass GEN_DOMAIN_BLOCK_MERGE = eINSTANCE.getGenDomainBlockMerge();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl <em>Gen Palette</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPalette()
		 * @generated
		 */
		EClass GEN_PALETTE = eINSTANCE.getGenPalette();

		/**
		 * The meta object literal for the '<em><b>Owned Drawer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE__OWNED_DRAWER = eINSTANCE.getGenPalette_OwnedDrawer();

		/**
		 * The meta object literal for the '<em><b>Drawer</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE__DRAWER = eINSTANCE.getGenPalette_Drawer();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl <em>Gen Palette Drawer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteDrawer()
		 * @generated
		 */
		EClass GEN_PALETTE_DRAWER = eINSTANCE.getGenPaletteDrawer();

		/**
		 * The meta object literal for the '<em><b>Specializes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_DRAWER__SPECIALIZES = eINSTANCE.getGenPaletteDrawer_Specializes();

		/**
		 * The meta object literal for the '<em><b>Palette</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_DRAWER__PALETTE = eINSTANCE.getGenPaletteDrawer_Palette();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl <em>Gen Palette Tool Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteToolContainer()
		 * @generated
		 */
		EClass GEN_PALETTE_TOOL_CONTAINER = eINSTANCE.getGenPaletteToolContainer();

		/**
		 * The meta object literal for the '<em><b>Owned Tool</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL = eINSTANCE.getGenPaletteToolContainer_OwnedTool();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_TOOL_CONTAINER__TOOL = eINSTANCE.getGenPaletteToolContainer_Tool();

		/**
		 * The meta object literal for the '<em><b>Target Diagram</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM = eINSTANCE.getGenPaletteToolContainer_TargetDiagram();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolImpl <em>Gen Palette Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteTool()
		 * @generated
		 */
		EClass GEN_PALETTE_TOOL = eINSTANCE.getGenPaletteTool();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_TOOL__OVERRIDES = eINSTANCE.getGenPaletteTool_Overrides();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_TOOL__CONTAINER = eINSTANCE.getGenPaletteTool_Container();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl <em>Gen Menu Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuModel()
		 * @generated
		 */
		EClass GEN_MENU_MODEL = eINSTANCE.getGenMenuModel();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_MODEL__ITEMS = eINSTANCE.getGenMenuModel_Items();

		/**
		 * The meta object literal for the '<em><b>Uml Menus</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_MODEL__UML_MENUS = eINSTANCE.getGenMenuModel_UmlMenus();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl <em>Gen Domain Block Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockReferenceImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainBlockReference()
		 * @generated
		 */
		EClass GEN_DOMAIN_BLOCK_REFERENCE = eINSTANCE.getGenDomainBlockReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_REFERENCE__TARGET = eINSTANCE.getGenDomainBlockReference_Target();

		/**
		 * The meta object literal for the '<em><b>Domain Block Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_BLOCK_REFERENCE = eINSTANCE
				.getGenDomainBlockReference_DomainBlockReference();

		/**
		 * The meta object literal for the '<em><b>Domain Specialization</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION = eINSTANCE
				.getGenDomainBlockReference_DomainSpecialization();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumImpl <em>Gen Domain Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainEnum()
		 * @generated
		 */
		EClass GEN_DOMAIN_ENUM = eINSTANCE.getGenDomainEnum();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_ENUM__LITERAL = eINSTANCE.getGenDomainEnum_Literal();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl <em>Gen Domain Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainEnumLiteral()
		 * @generated
		 */
		EClass GEN_DOMAIN_ENUM_LITERAL = eINSTANCE.getGenDomainEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Domain Enum Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL = eINSTANCE.getGenDomainEnumLiteral_DomainEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_ENUM_LITERAL__ENUMERATION = eINSTANCE.getGenDomainEnumLiteral_Enumeration();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl <em>Gen Palette Creation Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteCreationTool()
		 * @generated
		 */
		EClass GEN_PALETTE_CREATION_TOOL = eINSTANCE.getGenPaletteCreationTool();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_CREATION_TOOL__TYPE = eINSTANCE.getGenPaletteCreationTool_Type();

		/**
		 * The meta object literal for the '<em><b>Element Type Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT = eINSTANCE.getGenPaletteCreationTool_ElementTypeHint();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_CREATION_TOOL__EXPRESSION = eINSTANCE.getGenPaletteCreationTool_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ExpressionImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__NAME = eINSTANCE.getExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl <em>Gen Palette Stack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteStack()
		 * @generated
		 */
		EClass GEN_PALETTE_STACK = eINSTANCE.getGenPaletteStack();

		/**
		 * The meta object literal for the '<em><b>Active Tool</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PALETTE_STACK__ACTIVE_TOOL = eINSTANCE.getGenPaletteStack_ActiveTool();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawExpressionImpl <em>Oaw Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawExpressionImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getOawExpression()
		 * @generated
		 */
		EClass OAW_EXPRESSION = eINSTANCE.getOawExpression();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAW_EXPRESSION__VARIABLE_NAME = eINSTANCE.getOawExpression_VariableName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawXtendImpl <em>Oaw Xtend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.OawXtendImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getOawXtend()
		 * @generated
		 */
		EClass OAW_XTEND = eINSTANCE.getOawXtend();

		/**
		 * The meta object literal for the '<em><b>Extension File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAW_XTEND__EXTENSION_FILE = eINSTANCE.getOawXtend_ExtensionFile();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuActionImpl <em>Gen Menu Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuActionImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuAction()
		 * @generated
		 */
		EClass GEN_MENU_ACTION = eINSTANCE.getGenMenuAction();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl <em>Gen Menu Delegate Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuDelegateActionImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuDelegateAction()
		 * @generated
		 */
		EClass GEN_MENU_DELEGATE_ACTION = eINSTANCE.getGenMenuDelegateAction();

		/**
		 * The meta object literal for the '<em><b>Host Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MENU_DELEGATE_ACTION__HOST_BUNDLE = eINSTANCE.getGenMenuDelegateAction_HostBundle();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MENU_DELEGATE_ACTION__CLASS_NAME = eINSTANCE.getGenMenuDelegateAction_ClassName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl <em>Gen Menu Create Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuCreateAction()
		 * @generated
		 */
		EClass GEN_MENU_CREATE_ACTION = eINSTANCE.getGenMenuCreateAction();

		/**
		 * The meta object literal for the '<em><b>Type Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MENU_CREATE_ACTION__TYPE_HINT = eINSTANCE.getGenMenuCreateAction_TypeHint();

		/**
		 * The meta object literal for the '<em><b>Create Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_CREATE_ACTION__CREATE_CONCEPT = eINSTANCE.getGenMenuCreateAction_CreateConcept();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MENU_CREATE_ACTION__EXPRESSION = eINSTANCE.getGenMenuCreateAction_Expression();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuSeparatorImpl <em>Gen Menu Separator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuSeparatorImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenMenuSeparator()
		 * @generated
		 */
		EClass GEN_MENU_SEPARATOR = eINSTANCE.getGenMenuSeparator();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind <em>Gen Palette Diagram Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenPaletteDiagramKind()
		 * @generated
		 */
		EEnum GEN_PALETTE_DIAGRAM_KIND = eINSTANCE.getGenPaletteDiagramKind();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl <em>Gen Domain Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainReference()
		 * @generated
		 */
		EClass GEN_DOMAIN_REFERENCE = eINSTANCE.getGenDomainReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_REFERENCE__TARGET = eINSTANCE.getGenDomainReference_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_REFERENCE__SOURCE = eINSTANCE.getGenDomainReference_Source();

		/**
		 * The meta object literal for the '<em><b>Domain Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE = eINSTANCE.getGenDomainReference_DomainReference();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl <em>Gen Domain Attribute Presentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttributePresentation()
		 * @generated
		 */
		EClass GEN_DOMAIN_ATTRIBUTE_PRESENTATION = eINSTANCE.getGenDomainAttributePresentation();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE = eINSTANCE.getGenDomainAttributePresentation_Visible();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY = eINSTANCE
				.getGenDomainAttributePresentation_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Presentation Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT = eINSTANCE
				.getGenDomainAttributePresentation_PresentationHint();

		/**
		 * The meta object literal for the '<em><b>Presentation Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND = eINSTANCE
				.getGenDomainAttributePresentation_PresentationKind();

		/**
		 * The meta object literal for the '<em><b>Visible Model Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE = eINSTANCE
				.getGenDomainAttributePresentation_VisibleModelType();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER = eINSTANCE.getGenDomainAttributePresentation_Order();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl <em>Gen Domain Specialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainSpecialization()
		 * @generated
		 */
		EClass GEN_DOMAIN_SPECIALIZATION = eINSTANCE.getGenDomainSpecialization();

		/**
		 * The meta object literal for the '<em><b>Domain Block</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK = eINSTANCE.getGenDomainSpecialization_DomainBlock();

		/**
		 * The meta object literal for the '<em><b>Elementtype Configuration Container Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI = eINSTANCE
				.getGenDomainSpecialization_ElementtypeConfigurationContainerUri();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl <em>Gen Domain Model Library Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModelLibraryReference()
		 * @generated
		 */
		EClass GEN_DOMAIN_MODEL_LIBRARY_REFERENCE = eINSTANCE.getGenDomainModelLibraryReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET = eINSTANCE.getGenDomainModelLibraryReference_Target();

		/**
		 * The meta object literal for the '<em><b>Domain Model Library Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE = eINSTANCE
				.getGenDomainModelLibraryReference_DomainModelLibraryReference();

		/**
		 * The meta object literal for the '<em><b>Resource Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME = eINSTANCE
				.getGenDomainModelLibraryReference_ResourceName();

		/**
		 * The meta object literal for the '<em><b>Domain Specialization</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION = eINSTANCE
				.getGenDomainModelLibraryReference_DomainSpecialization();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl <em>Gen Domain Model Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModelLibrary()
		 * @generated
		 */
		EClass GEN_DOMAIN_MODEL_LIBRARY = eINSTANCE.getGenDomainModelLibrary();

		/**
		 * The meta object literal for the '<em><b>Domain Model Library</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY = eINSTANCE
				.getGenDomainModelLibrary_DomainModelLibrary();

		/**
		 * The meta object literal for the '<em><b>Domain Specialization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION = eINSTANCE
				.getGenDomainSpecialization_DomainSpecialization();

		/**
		 * The meta object literal for the '<em><b>Domain Concept</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT = eINSTANCE.getGenDomainSpecialization_DomainConcept();

		/**
		 * The meta object literal for the '<em><b>Plugin Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME = eINSTANCE.getGenDomainSpecialization_PluginName();

		/**
		 * The meta object literal for the '<em><b>Resource Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME = eINSTANCE.getGenDomainSpecialization_ResourceName();

		/**
		 * The meta object literal for the '<em><b>Domain Model Library</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY = eINSTANCE
				.getGenDomainSpecialization_DomainModelLibrary();

		/**
		 * The meta object literal for the '<em><b>Model Library Names Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE = eINSTANCE
				.getGenDomainSpecialization_ModelLibraryNamesPackage();

		/**
		 * The meta object literal for the '<em><b>Model Library Source Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER = eINSTANCE
				.getGenDomainSpecialization_ModelLibrarySourceFolder();

		/**
		 * The meta object literal for the '<em><b>Menu Model Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE = eINSTANCE
				.getGenDomainSpecialization_MenuModelResource();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__VERSION = eINSTANCE.getGenDomainSpecialization_Version();

		/**
		 * The meta object literal for the '<em><b>Code Gen Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET = eINSTANCE.getGenDomainSpecialization_CodeGenTarget();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Java Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT = eINSTANCE
				.getGenDomainSpecialization_RhapsodyJavaProject();

		/**
		 * The meta object literal for the '<em><b>Rhapsody JDT Java Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY = eINSTANCE
				.getGenDomainSpecialization_RhapsodyJDTJavaLibrary();

		/**
		 * The meta object literal for the '<em><b>Excluded Palette Item</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM = eINSTANCE
				.getGenDomainSpecialization_ExcludedPaletteItem();

		/**
		 * The meta object literal for the '<em><b>Included UML Menus</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS = eINSTANCE
				.getGenDomainSpecialization_IncludedUMLMenus();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl <em>Gen Domain Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainModel()
		 * @generated
		 */
		EClass GEN_DOMAIN_MODEL = eINSTANCE.getGenDomainModel();

		/**
		 * The meta object literal for the '<em><b>Domain Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL__DOMAIN_MODEL = eINSTANCE.getGenDomainModel_DomainModel();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL__NS_URI = eINSTANCE.getGenDomainModel_NsURI();

		/**
		 * The meta object literal for the '<em><b>Root Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL__ROOT_PACKAGE = eINSTANCE.getGenDomainModel_RootPackage();

		/**
		 * The meta object literal for the '<em><b>Implementation Sub Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL__IMPLEMENTATION_SUB_PACKAGE = eINSTANCE
				.getGenDomainModel_ImplementationSubPackage();

		/**
		 * The meta object literal for the '<em><b>Impl Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL__IMPL_SUFFIX = eINSTANCE.getGenDomainModel_ImplSuffix();

		/**
		 * The meta object literal for the '<em><b>Api Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_DOMAIN_MODEL__API_PROJECT = eINSTANCE.getGenDomainModel_ApiProject();

		/**
		 * The meta object literal for the '<em><b>Palette</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL__PALETTE = eINSTANCE.getGenDomainModel_Palette();

		/**
		 * The meta object literal for the '<em><b>Menu Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL__MENU_MODEL = eINSTANCE.getGenDomainModel_MenuModel();

		/**
		 * The meta object literal for the '<em><b>Owning Gen Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_MODEL__OWNING_GEN_MODEL = eINSTANCE.getGenDomainModel_OwningGenModel();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl <em>Gen Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenModelImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenModel()
		 * @generated
		 */
		EClass GEN_MODEL = eINSTANCE.getGenModel();

		/**
		 * The meta object literal for the '<em><b>Referenced Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MODEL__REFERENCED_MODEL = eINSTANCE.getGenModel_ReferencedModel();

		/**
		 * The meta object literal for the '<em><b>Owned Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MODEL__OWNED_MODEL = eINSTANCE.getGenModel_OwnedModel();

		/**
		 * The meta object literal for the '<em><b>Domain Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MODEL__DOMAIN_MODEL = eINSTANCE.getGenModel_DomainModel();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageableElementImpl <em>Gen Domain Packageable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageableElementImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPackageableElement()
		 * @generated
		 */
		EClass GEN_DOMAIN_PACKAGEABLE_ELEMENT = eINSTANCE.getGenDomainPackageableElement();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_PACKAGEABLE_ELEMENT__PACKAGE = eINSTANCE.getGenDomainPackageableElement_Package();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageImpl <em>Gen Domain Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainPackageImpl
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPackage()
		 * @generated
		 */
		EClass GEN_DOMAIN_PACKAGE = eINSTANCE.getGenDomainPackage();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_PACKAGE__ELEMENT = eINSTANCE.getGenDomainPackage_Element();

		/**
		 * The meta object literal for the '<em><b>Domain Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_DOMAIN_PACKAGE__DOMAIN_PACKAGE = eINSTANCE.getGenDomainPackage_DomainPackage();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory <em>Gen Domain Concept Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainConceptCategory()
		 * @generated
		 */
		EEnum GEN_DOMAIN_CONCEPT_CATEGORY = eINSTANCE.getGenDomainConceptCategory();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind <em>Gen Domain Attribute Presentation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainAttributePresentationKind()
		 * @generated
		 */
		EEnum GEN_DOMAIN_ATTRIBUTE_PRESENTATION_KIND = eINSTANCE.getGenDomainAttributePresentationKind();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind <em>Gen Domain Presentation Model Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenDomainPresentationModelKind()
		 * @generated
		 */
		EEnum GEN_DOMAIN_PRESENTATION_MODEL_KIND = eINSTANCE.getGenDomainPresentationModelKind();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode <em>Gen All Domain Cassifiers Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode
		 * @see com.zeligsoft.ddk.zdl.zdlgen.internal.impl.ZDLGenPackageImpl#getGenAllDomainCassifiersMode()
		 * @generated
		 */
		EEnum GEN_ALL_DOMAIN_CASSIFIERS_MODE = eINSTANCE.getGenAllDomainCassifiersMode();

	}

} //ZDLGenPackage
