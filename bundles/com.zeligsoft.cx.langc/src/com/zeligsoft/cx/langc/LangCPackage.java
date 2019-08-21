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
package com.zeligsoft.cx.langc;

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
 * @see com.zeligsoft.cx.langc.LangCFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("nls")
public interface LangCPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "langc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.zeligsoft.com/2008/LangC-02";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "langc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LangCPackage eINSTANCE = com.zeligsoft.cx.langc.impl.LangCPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ElementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 25;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.UserElementImpl <em>User Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.UserElementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUserElement()
	 * @generated
	 */
	int USER_ELEMENT = 38;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ELEMENT__KIND = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ELEMENT__DEFN = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.NamedElementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__KIND = USER_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DEFN = USER_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = USER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = USER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.BuiltInTypeImpl <em>Built In Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.BuiltInTypeImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBuiltInType()
	 * @generated
	 */
	int BUILT_IN_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE__TYPE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Built In Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILT_IN_TYPE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.NameImpl <em>Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.NameImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getName_()
	 * @generated
	 */
	int NAME = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__PARENT = 1;

	/**
	 * The number of structural features of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.StructureImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 21;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__KIND = NAMED_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__DEFN = NAMED_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__MEMBERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.StructImpl <em>Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.StructImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStruct()
	 * @generated
	 */
	int STRUCT = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__KIND = STRUCTURE__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__DEFN = STRUCTURE__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NAME = STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__MEMBERS = STRUCTURE__MEMBERS;

	/**
	 * The number of structural features of the '<em>Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_FEATURE_COUNT = STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.UnionImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUnion()
	 * @generated
	 */
	int UNION = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__KIND = STRUCTURE__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__DEFN = STRUCTURE__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__NAME = STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__MEMBERS = STRUCTURE__MEMBERS;

	/**
	 * The number of structural features of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_FEATURE_COUNT = STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FunctionImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__KIND = NAMED_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DEFN = NAMED_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETURN_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Linkage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__LINKAGE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DEFAULT_IMPL = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.BindableValueImpl <em>Bindable Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.BindableValueImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBindableValue()
	 * @generated
	 */
	int BINDABLE_VALUE = 41;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.NamedReferenceImpl <em>Named Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.NamedReferenceImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getNamedReference()
	 * @generated
	 */
	int NAMED_REFERENCE = 6;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl <em>Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ElementReferenceImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementReference()
	 * @generated
	 */
	int ELEMENT_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_REFERENCE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Named Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Bindable Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDABLE_VALUE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE__ELEMENT = BINDABLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cv Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE__CV_QUALIFIER = BINDABLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pointer Spec</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE__POINTER_SPEC = BINDABLE_VALUE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE__ARRAY_BOUNDS = BINDABLE_VALUE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_FEATURE_COUNT = BINDABLE_VALUE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ExpressionImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__PRECENDENCE = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FunctionCallImpl <em>Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FunctionCallImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionCall()
	 * @generated
	 */
	int FUNCTION_CALL = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__FUNCTION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ElementAccessImpl <em>Element Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ElementAccessImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementAccess()
	 * @generated
	 */
	int ELEMENT_ACCESS = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ElementListImpl <em>Element List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ElementListImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementList()
	 * @generated
	 */
	int ELEMENT_LIST = 11;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__NAME = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__TYPES = 2;

	/**
	 * The feature id for the '<em><b>Decl Includes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__DECL_INCLUDES = 3;

	/**
	 * The feature id for the '<em><b>Defn Includes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__DEFN_INCLUDES = 4;

	/**
	 * The feature id for the '<em><b>Public Directives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__PUBLIC_DIRECTIVES = 5;

	/**
	 * The feature id for the '<em><b>Private Directives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST__PRIVATE_DIRECTIVES = 6;

	/**
	 * The number of structural features of the '<em>Element List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIST_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.LiteralImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__PRIMITIVE_TYPE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.IntegralLiteralImpl <em>Integral Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.IntegralLiteralImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getIntegralLiteral()
	 * @generated
	 */
	int INTEGRAL_LITERAL = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__TYPE = LITERAL__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__PRECENDENCE = LITERAL__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__PRIMITIVE_TYPE = LITERAL__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__BYTES = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL__SIGNED = LITERAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Integral Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.CharacterLiteralImpl <em>Character Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.CharacterLiteralImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCharacterLiteral()
	 * @generated
	 */
	int CHARACTER_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_LITERAL__TYPE = LITERAL__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_LITERAL__PRECENDENCE = LITERAL__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_LITERAL__PRIMITIVE_TYPE = LITERAL__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Character Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FloatingLiteralImpl <em>Floating Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FloatingLiteralImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFloatingLiteral()
	 * @generated
	 */
	int FLOATING_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_LITERAL__TYPE = LITERAL__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_LITERAL__PRECENDENCE = LITERAL__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_LITERAL__PRIMITIVE_TYPE = LITERAL__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Floating Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.StatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 16;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ExpressionStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 17;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ReturnStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getReturnStatement()
	 * @generated
	 */
	int RETURN_STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__EXPR = EXPRESSION_STATEMENT__EXPR;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT_FEATURE_COUNT = EXPRESSION_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.CodeBlockImpl <em>Code Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.CodeBlockImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCodeBlock()
	 * @generated
	 */
	int CODE_BLOCK = 19;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__FORCE_BRACES = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Code Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.BinaryOperationImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBinaryOperation()
	 * @generated
	 */
	int BINARY_OPERATION = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION__LHS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION__RHS = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FunctionPointerImpl <em>Function Pointer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FunctionPointerImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionPointer()
	 * @generated
	 */
	int FUNCTION_POINTER = 22;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POINTER__KIND = USER_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POINTER__DEFN = USER_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POINTER__RETURN_TYPE = USER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POINTER__PARAMETERS = USER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Pointer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_POINTER_FEATURE_COUNT = USER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FunctionAddressImpl <em>Function Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FunctionAddressImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionAddress()
	 * @generated
	 */
	int FUNCTION_ADDRESS = 23;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ADDRESS__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ADDRESS__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ADDRESS__FUNCTION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ADDRESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.VariableDeclarationImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 24;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__KIND = NAMED_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__DEFN = NAMED_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Linkage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__LINKAGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIALIZER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.TypedefImpl <em>Typedef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.TypedefImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getTypedef()
	 * @generated
	 */
	int TYPEDEF = 26;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__KIND = NAMED_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__DEFN = NAMED_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typedef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.MemberAccessImpl <em>Member Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.MemberAccessImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getMemberAccess()
	 * @generated
	 */
	int MEMBER_ACCESS = 27;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_ACCESS__TYPE = ELEMENT_ACCESS__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_ACCESS__PRECENDENCE = ELEMENT_ACCESS__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_ACCESS__NAME = ELEMENT_ACCESS__NAME;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_ACCESS__CONTAINER = ELEMENT_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Member Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_ACCESS_FEATURE_COUNT = ELEMENT_ACCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ExpressionBlobImpl <em>Expression Blob</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ExpressionBlobImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpressionBlob()
	 * @generated
	 */
	int EXPRESSION_BLOB = 28;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOB__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOB__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOB__TEXT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Blob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_BLOB_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SubSystemImpl <em>Sub System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SubSystemImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSubSystem()
	 * @generated
	 */
	int SUB_SYSTEM = 29;

	/**
	 * The feature id for the '<em><b>Files</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__FILES = 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__FOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__NAME = 2;

	/**
	 * The feature id for the '<em><b>Public Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PUBLIC_FOLDERS = 3;

	/**
	 * The number of structural features of the '<em>Sub System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.EnumImpl <em>Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.EnumImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getEnum()
	 * @generated
	 */
	int ENUM = 30;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__KIND = NAMED_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__DEFN = NAMED_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Enumerators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__ENUMERATORS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.EnumeratorImpl <em>Enumerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.EnumeratorImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getEnumerator()
	 * @generated
	 */
	int ENUMERATOR = 31;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__VALUE = BINDABLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__NAME = BINDABLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_FEATURE_COUNT = BINDABLE_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.DependencyImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 62;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FileDependencyImpl <em>File Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FileDependencyImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFileDependency()
	 * @generated
	 */
	int FILE_DEPENDENCY = 32;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DEPENDENCY__FILENAME = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DEPENDENCY_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SystemIncludeImpl <em>System Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SystemIncludeImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystemInclude()
	 * @generated
	 */
	int SYSTEM_INCLUDE = 33;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INCLUDE__FILENAME = FILE_DEPENDENCY__FILENAME;

	/**
	 * The number of structural features of the '<em>System Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INCLUDE_FEATURE_COUNT = FILE_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.UserIncludeImpl <em>User Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.UserIncludeImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUserInclude()
	 * @generated
	 */
	int USER_INCLUDE = 34;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INCLUDE__FILENAME = FILE_DEPENDENCY__FILENAME;

	/**
	 * The number of structural features of the '<em>User Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INCLUDE_FEATURE_COUNT = FILE_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FileNameImpl <em>File Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FileNameImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFileName()
	 * @generated
	 */
	int FILE_NAME = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__NAME = NAME__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__PARENT = NAME__PARENT;

	/**
	 * The feature id for the '<em><b>Has Object Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__HAS_OBJECT_CODE = NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME_FEATURE_COUNT = NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FolderNameImpl <em>Folder Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FolderNameImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFolderName()
	 * @generated
	 */
	int FOLDER_NAME = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_NAME__NAME = NAME__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_NAME__PARENT = NAME__PARENT;

	/**
	 * The feature id for the '<em><b>Api</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_NAME__API = NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Folder Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_NAME_FEATURE_COUNT = NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.CastExprImpl <em>Cast Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.CastExprImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCastExpr()
	 * @generated
	 */
	int CAST_EXPR = 37;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPR__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPR__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPR__TARGET_TYPE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPR__EXPR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cast Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.DependencyListImpl <em>Dependency List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.DependencyListImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependencyList()
	 * @generated
	 */
	int DEPENDENCY_LIST = 39;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LIST__DEPENDENCIES = 0;

	/**
	 * The number of structural features of the '<em>Dependency List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SizeofImpl <em>Sizeof</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SizeofImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeof()
	 * @generated
	 */
	int SIZEOF = 58;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The number of structural features of the '<em>Sizeof</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SizeofTypeImpl <em>Sizeof Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SizeofTypeImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeofType()
	 * @generated
	 */
	int SIZEOF_TYPE = 40;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_TYPE__TYPE = SIZEOF__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_TYPE__PRECENDENCE = SIZEOF__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_TYPE__ELEMENT = SIZEOF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sizeof Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_TYPE_FEATURE_COUNT = SIZEOF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SystemFileNameImpl <em>System File Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SystemFileNameImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystemFileName()
	 * @generated
	 */
	int SYSTEM_FILE_NAME = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FILE_NAME__NAME = FILE_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FILE_NAME__PARENT = FILE_NAME__PARENT;

	/**
	 * The feature id for the '<em><b>Has Object Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FILE_NAME__HAS_OBJECT_CODE = FILE_NAME__HAS_OBJECT_CODE;

	/**
	 * The number of structural features of the '<em>System File Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FILE_NAME_FEATURE_COUNT = FILE_NAME_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SwitchClauseImpl <em>Switch Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SwitchClauseImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSwitchClause()
	 * @generated
	 */
	int SWITCH_CLAUSE = 43;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CLAUSE__STATEMENTS = CODE_BLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CLAUSE__FORCE_BRACES = CODE_BLOCK__FORCE_BRACES;

	/**
	 * The feature id for the '<em><b>Fallthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CLAUSE__FALLTHROUGH = CODE_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CLAUSE_FEATURE_COUNT = CODE_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.LabeledClauseImpl <em>Labeled Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.LabeledClauseImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLabeledClause()
	 * @generated
	 */
	int LABELED_CLAUSE = 44;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_CLAUSE__STATEMENTS = SWITCH_CLAUSE__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_CLAUSE__FORCE_BRACES = SWITCH_CLAUSE__FORCE_BRACES;

	/**
	 * The feature id for the '<em><b>Fallthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_CLAUSE__FALLTHROUGH = SWITCH_CLAUSE__FALLTHROUGH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_CLAUSE__LABELS = SWITCH_CLAUSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Labeled Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_CLAUSE_FEATURE_COUNT = SWITCH_CLAUSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SwitchStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CLAUSES = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.BreakStatementImpl <em>Break Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.BreakStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBreakStatement()
	 * @generated
	 */
	int BREAK_STATEMENT = 46;

	/**
	 * The number of structural features of the '<em>Break Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.AddressOfExprImpl <em>Address Of Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.AddressOfExprImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getAddressOfExpr()
	 * @generated
	 */
	int ADDRESS_OF_EXPR = 47;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OF_EXPR__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OF_EXPR__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OF_EXPR__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Address Of Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OF_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.DereferenceExprImpl <em>Dereference Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.DereferenceExprImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDereferenceExpr()
	 * @generated
	 */
	int DEREFERENCE_EXPR = 48;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREFERENCE_EXPR__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREFERENCE_EXPR__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREFERENCE_EXPR__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dereference Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREFERENCE_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.WhileStatementImpl <em>While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.WhileStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getWhileStatement()
	 * @generated
	 */
	int WHILE_STATEMENT = 49;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__STATEMENTS = CODE_BLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__FORCE_BRACES = CODE_BLOCK__FORCE_BRACES;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONDITION = CODE_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT_FEATURE_COUNT = CODE_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.DirectiveImpl <em>Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.DirectiveImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDirective()
	 * @generated
	 */
	int DIRECTIVE = 52;

	/**
	 * The number of structural features of the '<em>Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.MacroImpl <em>Macro</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.MacroImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getMacro()
	 * @generated
	 */
	int MACRO = 50;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO__PARAMETERS = DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO__REPLACEMENT = DIRECTIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO__NAME = DIRECTIVE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO_FEATURE_COUNT = DIRECTIVE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.StringLiteralImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 51;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.VariableDeclarationStatementImpl <em>Variable Declaration Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.VariableDeclarationStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getVariableDeclarationStatement()
	 * @generated
	 */
	int VARIABLE_DECLARATION_STATEMENT = 53;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_STATEMENT__VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.BlockInitializerImpl <em>Block Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.BlockInitializerImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBlockInitializer()
	 * @generated
	 */
	int BLOCK_INITIALIZER = 54;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INITIALIZER__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INITIALIZER__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INITIALIZER__EXPRS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INITIALIZER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.IndexExprImpl <em>Index Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.IndexExprImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getIndexExpr()
	 * @generated
	 */
	int INDEX_EXPR = 55;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPR__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPR__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPR__INDEX = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPR__ARRAY = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Index Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.LogicalComparisonImpl <em>Logical Comparison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.LogicalComparisonImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLogicalComparison()
	 * @generated
	 */
	int LOGICAL_COMPARISON = 56;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON__TYPE = EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON__PRECENDENCE = EXPRESSION__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON__LHS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON__RHS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON__OPERATOR = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Logical Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SizeofExprImpl <em>Sizeof Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SizeofExprImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeofExpr()
	 * @generated
	 */
	int SIZEOF_EXPR = 57;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_EXPR__TYPE = SIZEOF__TYPE;

	/**
	 * The feature id for the '<em><b>Precendence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_EXPR__PRECENDENCE = SIZEOF__PRECENDENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_EXPR__EXPR = SIZEOF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sizeof Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZEOF_EXPR_FEATURE_COUNT = SIZEOF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.FunctionImplementationImpl <em>Function Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.FunctionImplementationImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionImplementation()
	 * @generated
	 */
	int FUNCTION_IMPLEMENTATION = 59;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_IMPLEMENTATION__KIND = USER_ELEMENT__KIND;

	/**
	 * The feature id for the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_IMPLEMENTATION__DEFN = USER_ELEMENT__DEFN;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_IMPLEMENTATION__BODY = USER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_IMPLEMENTATION__FUNCTION = USER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_IMPLEMENTATION_FEATURE_COUNT = USER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.SystemImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 60;

	/**
	 * The feature id for the '<em><b>Sub Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SUB_SYSTEMS = 0;

	/**
	 * The feature id for the '<em><b>Public Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PUBLIC_FOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ARTIFACTS = 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.CodeBlobImpl <em>Code Blob</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.CodeBlobImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCodeBlob()
	 * @generated
	 */
	int CODE_BLOB = 61;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB__STATEMENTS = CODE_BLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB__FORCE_BRACES = CODE_BLOCK__FORCE_BRACES;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB__TEXT = CODE_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB__DEPENDENCIES = CODE_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Marker Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB__MARKER_COMMENT = CODE_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Code Blob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOB_FEATURE_COUNT = CODE_BLOCK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.DependencyBlobImpl <em>Dependency Blob</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.DependencyBlobImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependencyBlob()
	 * @generated
	 */
	int DEPENDENCY_BLOB = 63;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_BLOB__TEXT = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Marker Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_BLOB__MARKER_COMMENT = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dependency Blob</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_BLOB_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.LinkableArtifactImpl <em>Linkable Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.LinkableArtifactImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLinkableArtifact()
	 * @generated
	 */
	int LINKABLE_ARTIFACT = 64;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKABLE_ARTIFACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Function Implementations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS = 1;

	/**
	 * The feature id for the '<em><b>Root Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKABLE_ARTIFACT__ROOT_ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Linkable Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKABLE_ARTIFACT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.impl.ConditionalStatementImpl <em>Conditional Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.impl.ConditionalStatementImpl
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getConditionalStatement()
	 * @generated
	 */
	int CONDITIONAL_STATEMENT = 65;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STATEMENT__STATEMENTS = CODE_BLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STATEMENT__FORCE_BRACES = CODE_BLOCK__FORCE_BRACES;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STATEMENT__CONDITION = CODE_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conditional Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_STATEMENT_FEATURE_COUNT = CODE_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.CVQualifier <em>CV Qualifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.CVQualifier
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCVQualifier()
	 * @generated
	 */
	int CV_QUALIFIER = 66;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.PrimitiveType <em>Primitive Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.PrimitiveType
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 67;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.LinkageSpec <em>Linkage Spec</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.LinkageSpec
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLinkageSpec()
	 * @generated
	 */
	int LINKAGE_SPEC = 68;


	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.Operator
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 69;


	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.Pointer <em>Pointer</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.Pointer
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getPointer()
	 * @generated
	 */
	int POINTER = 70;


	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.ElementKind <em>Element Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.ElementKind
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementKind()
	 * @generated
	 */
	int ELEMENT_KIND = 71;

	/**
	 * The meta object id for the '{@link com.zeligsoft.cx.langc.BooleanOperator <em>Boolean Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.cx.langc.BooleanOperator
	 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBooleanOperator()
	 * @generated
	 */
	int BOOLEAN_OPERATOR = 72;

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see com.zeligsoft.cx.langc.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.BuiltInType <em>Built In Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Built In Type</em>'.
	 * @see com.zeligsoft.cx.langc.BuiltInType
	 * @generated
	 */
	EClass getBuiltInType();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.BuiltInType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.zeligsoft.cx.langc.BuiltInType#getType()
	 * @see #getBuiltInType()
	 * @generated
	 */
	EAttribute getBuiltInType_Type();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.Name
	 * @generated
	 */
	EClass getName_();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.Name#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.Name#getName()
	 * @see #getName_()
	 * @generated
	 */
	EAttribute getName_Name();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.Name#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see com.zeligsoft.cx.langc.Name#getParent()
	 * @see #getName_()
	 * @generated
	 */
	EReference getName_Parent();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct</em>'.
	 * @see com.zeligsoft.cx.langc.Struct
	 * @generated
	 */
	EClass getStruct();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see com.zeligsoft.cx.langc.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see com.zeligsoft.cx.langc.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Function#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see com.zeligsoft.cx.langc.Function#getReturnType()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.zeligsoft.cx.langc.Function#getParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.Function#getLinkage <em>Linkage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linkage</em>'.
	 * @see com.zeligsoft.cx.langc.Function#getLinkage()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Linkage();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Function#getDefaultImpl <em>Default Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Impl</em>'.
	 * @see com.zeligsoft.cx.langc.Function#getDefaultImpl()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_DefaultImpl();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.NamedReference <em>Named Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Reference</em>'.
	 * @see com.zeligsoft.cx.langc.NamedReference
	 * @generated
	 */
	EClass getNamedReference();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.NamedReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.NamedReference#getName()
	 * @see #getNamedReference()
	 * @generated
	 */
	EReference getNamedReference_Name();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.NamedReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see com.zeligsoft.cx.langc.NamedReference#getType()
	 * @see #getNamedReference()
	 * @generated
	 */
	EReference getNamedReference_Type();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ElementReference <em>Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Reference</em>'.
	 * @see com.zeligsoft.cx.langc.ElementReference
	 * @generated
	 */
	EClass getElementReference();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.ElementReference#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see com.zeligsoft.cx.langc.ElementReference#getElement()
	 * @see #getElementReference()
	 * @generated
	 */
	EReference getElementReference_Element();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.ElementReference#getCvQualifier <em>Cv Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cv Qualifier</em>'.
	 * @see com.zeligsoft.cx.langc.ElementReference#getCvQualifier()
	 * @see #getElementReference()
	 * @generated
	 */
	EAttribute getElementReference_CvQualifier();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.cx.langc.ElementReference#getPointerSpec <em>Pointer Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pointer Spec</em>'.
	 * @see com.zeligsoft.cx.langc.ElementReference#getPointerSpec()
	 * @see #getElementReference()
	 * @generated
	 */
	EAttribute getElementReference_PointerSpec();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.ElementReference#getArrayBounds <em>Array Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Bounds</em>'.
	 * @see com.zeligsoft.cx.langc.ElementReference#getArrayBounds()
	 * @see #getElementReference()
	 * @generated
	 */
	EReference getElementReference_ArrayBounds();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see com.zeligsoft.cx.langc.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.Expression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.zeligsoft.cx.langc.Expression#getType()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.Expression#getPrecendence <em>Precendence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precendence</em>'.
	 * @see com.zeligsoft.cx.langc.Expression#getPrecendence()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Precendence();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionCall
	 * @generated
	 */
	EClass getFunctionCall();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.FunctionCall#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionCall#getFunction()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.FunctionCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionCall#getArguments()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_Arguments();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ElementAccess <em>Element Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Access</em>'.
	 * @see com.zeligsoft.cx.langc.ElementAccess
	 * @generated
	 */
	EClass getElementAccess();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.ElementAccess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.ElementAccess#getName()
	 * @see #getElementAccess()
	 * @generated
	 */
	EReference getElementAccess_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ElementList <em>Element List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element List</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList
	 * @generated
	 */
	EClass getElementList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.ElementList#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getElements()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.ElementList#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getName()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.ElementList#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getTypes()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_Types();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.ElementList#getDeclIncludes <em>Decl Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Decl Includes</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getDeclIncludes()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_DeclIncludes();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.ElementList#getDefnIncludes <em>Defn Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defn Includes</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getDefnIncludes()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_DefnIncludes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.ElementList#getPublicDirectives <em>Public Directives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Public Directives</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getPublicDirectives()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_PublicDirectives();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.ElementList#getPrivateDirectives <em>Private Directives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Private Directives</em>'.
	 * @see com.zeligsoft.cx.langc.ElementList#getPrivateDirectives()
	 * @see #getElementList()
	 * @generated
	 */
	EReference getElementList_PrivateDirectives();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see com.zeligsoft.cx.langc.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.Literal#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Type</em>'.
	 * @see com.zeligsoft.cx.langc.Literal#getPrimitiveType()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_PrimitiveType();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.IntegralLiteral <em>Integral Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integral Literal</em>'.
	 * @see com.zeligsoft.cx.langc.IntegralLiteral
	 * @generated
	 */
	EClass getIntegralLiteral();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.IntegralLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.zeligsoft.cx.langc.IntegralLiteral#getValue()
	 * @see #getIntegralLiteral()
	 * @generated
	 */
	EAttribute getIntegralLiteral_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.IntegralLiteral#getBytes <em>Bytes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bytes</em>'.
	 * @see com.zeligsoft.cx.langc.IntegralLiteral#getBytes()
	 * @see #getIntegralLiteral()
	 * @generated
	 */
	EAttribute getIntegralLiteral_Bytes();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.IntegralLiteral#isSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see com.zeligsoft.cx.langc.IntegralLiteral#isSigned()
	 * @see #getIntegralLiteral()
	 * @generated
	 */
	EAttribute getIntegralLiteral_Signed();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.CharacterLiteral <em>Character Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Character Literal</em>'.
	 * @see com.zeligsoft.cx.langc.CharacterLiteral
	 * @generated
	 */
	EClass getCharacterLiteral();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.CharacterLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.zeligsoft.cx.langc.CharacterLiteral#getValue()
	 * @see #getCharacterLiteral()
	 * @generated
	 */
	EAttribute getCharacterLiteral_Value();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FloatingLiteral <em>Floating Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floating Literal</em>'.
	 * @see com.zeligsoft.cx.langc.FloatingLiteral
	 * @generated
	 */
	EClass getFloatingLiteral();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.FloatingLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.zeligsoft.cx.langc.FloatingLiteral#getValue()
	 * @see #getFloatingLiteral()
	 * @generated
	 */
	EAttribute getFloatingLiteral_Value();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see com.zeligsoft.cx.langc.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement</em>'.
	 * @see com.zeligsoft.cx.langc.ExpressionStatement
	 * @generated
	 */
	EClass getExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.ExpressionStatement#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see com.zeligsoft.cx.langc.ExpressionStatement#getExpr()
	 * @see #getExpressionStatement()
	 * @generated
	 */
	EReference getExpressionStatement_Expr();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see com.zeligsoft.cx.langc.ReturnStatement
	 * @generated
	 */
	EClass getReturnStatement();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Block</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlock
	 * @generated
	 */
	EClass getCodeBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.CodeBlock#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlock#getStatements()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_Statements();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.CodeBlock#isForceBraces <em>Force Braces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Force Braces</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlock#isForceBraces()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_ForceBraces();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.BinaryOperation <em>Binary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operation</em>'.
	 * @see com.zeligsoft.cx.langc.BinaryOperation
	 * @generated
	 */
	EClass getBinaryOperation();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.BinaryOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see com.zeligsoft.cx.langc.BinaryOperation#getOperator()
	 * @see #getBinaryOperation()
	 * @generated
	 */
	EAttribute getBinaryOperation_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.BinaryOperation#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see com.zeligsoft.cx.langc.BinaryOperation#getLhs()
	 * @see #getBinaryOperation()
	 * @generated
	 */
	EReference getBinaryOperation_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.BinaryOperation#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see com.zeligsoft.cx.langc.BinaryOperation#getRhs()
	 * @see #getBinaryOperation()
	 * @generated
	 */
	EReference getBinaryOperation_Rhs();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see com.zeligsoft.cx.langc.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.Structure#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see com.zeligsoft.cx.langc.Structure#getMembers()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Members();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FunctionPointer <em>Function Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Pointer</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionPointer
	 * @generated
	 */
	EClass getFunctionPointer();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.FunctionPointer#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionPointer#getReturnType()
	 * @see #getFunctionPointer()
	 * @generated
	 */
	EReference getFunctionPointer_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.FunctionPointer#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionPointer#getParameters()
	 * @see #getFunctionPointer()
	 * @generated
	 */
	EReference getFunctionPointer_Parameters();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FunctionAddress <em>Function Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Address</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionAddress
	 * @generated
	 */
	EClass getFunctionAddress();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.FunctionAddress#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionAddress#getFunction()
	 * @see #getFunctionAddress()
	 * @generated
	 */
	EReference getFunctionAddress_Function();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.VariableDeclaration#getLinkage <em>Linkage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linkage</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclaration#getLinkage()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Linkage();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.VariableDeclaration#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclaration#getElement()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Element();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.VariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclaration#getInitializer()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Initializer();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see com.zeligsoft.cx.langc.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typedef</em>'.
	 * @see com.zeligsoft.cx.langc.Typedef
	 * @generated
	 */
	EClass getTypedef();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Typedef#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see com.zeligsoft.cx.langc.Typedef#getElement()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Element();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.MemberAccess <em>Member Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Access</em>'.
	 * @see com.zeligsoft.cx.langc.MemberAccess
	 * @generated
	 */
	EClass getMemberAccess();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.MemberAccess#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see com.zeligsoft.cx.langc.MemberAccess#getContainer()
	 * @see #getMemberAccess()
	 * @generated
	 */
	EReference getMemberAccess_Container();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ExpressionBlob <em>Expression Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Blob</em>'.
	 * @see com.zeligsoft.cx.langc.ExpressionBlob
	 * @generated
	 */
	EClass getExpressionBlob();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.ExpressionBlob#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.zeligsoft.cx.langc.ExpressionBlob#getText()
	 * @see #getExpressionBlob()
	 * @generated
	 */
	EAttribute getExpressionBlob_Text();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub System</em>'.
	 * @see com.zeligsoft.cx.langc.SubSystem
	 * @generated
	 */
	EClass getSubSystem();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.cx.langc.SubSystem#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Files</em>'.
	 * @see com.zeligsoft.cx.langc.SubSystem#getFiles()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_Files();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.SubSystem#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see com.zeligsoft.cx.langc.SubSystem#getFolders()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_Folders();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.SubSystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.SubSystem#getName()
	 * @see #getSubSystem()
	 * @generated
	 */
	EAttribute getSubSystem_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.SubSystem#getPublicFolders <em>Public Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Public Folders</em>'.
	 * @see com.zeligsoft.cx.langc.SubSystem#getPublicFolders()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_PublicFolders();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Enum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum</em>'.
	 * @see com.zeligsoft.cx.langc.Enum
	 * @generated
	 */
	EClass getEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.Enum#getEnumerators <em>Enumerators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumerators</em>'.
	 * @see com.zeligsoft.cx.langc.Enum#getEnumerators()
	 * @see #getEnum()
	 * @generated
	 */
	EReference getEnum_Enumerators();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Enumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator</em>'.
	 * @see com.zeligsoft.cx.langc.Enumerator
	 * @generated
	 */
	EClass getEnumerator();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Enumerator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.zeligsoft.cx.langc.Enumerator#getValue()
	 * @see #getEnumerator()
	 * @generated
	 */
	EReference getEnumerator_Value();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Enumerator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.Enumerator#getName()
	 * @see #getEnumerator()
	 * @generated
	 */
	EReference getEnumerator_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FileDependency <em>File Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Dependency</em>'.
	 * @see com.zeligsoft.cx.langc.FileDependency
	 * @generated
	 */
	EClass getFileDependency();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.FileDependency#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filename</em>'.
	 * @see com.zeligsoft.cx.langc.FileDependency#getFilename()
	 * @see #getFileDependency()
	 * @generated
	 */
	EReference getFileDependency_Filename();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SystemInclude <em>System Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Include</em>'.
	 * @see com.zeligsoft.cx.langc.SystemInclude
	 * @generated
	 */
	EClass getSystemInclude();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.UserInclude <em>User Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Include</em>'.
	 * @see com.zeligsoft.cx.langc.UserInclude
	 * @generated
	 */
	EClass getUserInclude();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Name</em>'.
	 * @see com.zeligsoft.cx.langc.FileName
	 * @generated
	 */
	EClass getFileName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.FileName#isHasObjectCode <em>Has Object Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Object Code</em>'.
	 * @see com.zeligsoft.cx.langc.FileName#isHasObjectCode()
	 * @see #getFileName()
	 * @generated
	 */
	EAttribute getFileName_HasObjectCode();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FolderName <em>Folder Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder Name</em>'.
	 * @see com.zeligsoft.cx.langc.FolderName
	 * @generated
	 */
	EClass getFolderName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.FolderName#isApi <em>Api</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api</em>'.
	 * @see com.zeligsoft.cx.langc.FolderName#isApi()
	 * @see #getFolderName()
	 * @generated
	 */
	EAttribute getFolderName_Api();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.CastExpr <em>Cast Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast Expr</em>'.
	 * @see com.zeligsoft.cx.langc.CastExpr
	 * @generated
	 */
	EClass getCastExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.CastExpr#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Type</em>'.
	 * @see com.zeligsoft.cx.langc.CastExpr#getTargetType()
	 * @see #getCastExpr()
	 * @generated
	 */
	EReference getCastExpr_TargetType();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.CastExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see com.zeligsoft.cx.langc.CastExpr#getExpr()
	 * @see #getCastExpr()
	 * @generated
	 */
	EReference getCastExpr_Expr();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.UserElement <em>User Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Element</em>'.
	 * @see com.zeligsoft.cx.langc.UserElement
	 * @generated
	 */
	EClass getUserElement();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.UserElement#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.zeligsoft.cx.langc.UserElement#getKind()
	 * @see #getUserElement()
	 * @generated
	 */
	EAttribute getUserElement_Kind();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.UserElement#getDefn <em>Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defn</em>'.
	 * @see com.zeligsoft.cx.langc.UserElement#getDefn()
	 * @see #getUserElement()
	 * @generated
	 */
	EReference getUserElement_Defn();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.DependencyList <em>Dependency List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency List</em>'.
	 * @see com.zeligsoft.cx.langc.DependencyList
	 * @generated
	 */
	EClass getDependencyList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.DependencyList#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see com.zeligsoft.cx.langc.DependencyList#getDependencies()
	 * @see #getDependencyList()
	 * @generated
	 */
	EReference getDependencyList_Dependencies();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SizeofType <em>Sizeof Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sizeof Type</em>'.
	 * @see com.zeligsoft.cx.langc.SizeofType
	 * @generated
	 */
	EClass getSizeofType();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.SizeofType#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see com.zeligsoft.cx.langc.SizeofType#getElement()
	 * @see #getSizeofType()
	 * @generated
	 */
	EReference getSizeofType_Element();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.BindableValue <em>Bindable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bindable Value</em>'.
	 * @see com.zeligsoft.cx.langc.BindableValue
	 * @generated
	 */
	EClass getBindableValue();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SystemFileName <em>System File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System File Name</em>'.
	 * @see com.zeligsoft.cx.langc.SystemFileName
	 * @generated
	 */
	EClass getSystemFileName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SwitchClause <em>Switch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Clause</em>'.
	 * @see com.zeligsoft.cx.langc.SwitchClause
	 * @generated
	 */
	EClass getSwitchClause();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.SwitchClause#isFallthrough <em>Fallthrough</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fallthrough</em>'.
	 * @see com.zeligsoft.cx.langc.SwitchClause#isFallthrough()
	 * @see #getSwitchClause()
	 * @generated
	 */
	EAttribute getSwitchClause_Fallthrough();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.LabeledClause <em>Labeled Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Clause</em>'.
	 * @see com.zeligsoft.cx.langc.LabeledClause
	 * @generated
	 */
	EClass getLabeledClause();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.LabeledClause#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see com.zeligsoft.cx.langc.LabeledClause#getLabels()
	 * @see #getLabeledClause()
	 * @generated
	 */
	EReference getLabeledClause_Labels();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see com.zeligsoft.cx.langc.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.SwitchStatement#getClauses <em>Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clauses</em>'.
	 * @see com.zeligsoft.cx.langc.SwitchStatement#getClauses()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Clauses();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.SwitchStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see com.zeligsoft.cx.langc.SwitchStatement#getCondition()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Condition();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Statement</em>'.
	 * @see com.zeligsoft.cx.langc.BreakStatement
	 * @generated
	 */
	EClass getBreakStatement();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.AddressOfExpr <em>Address Of Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Of Expr</em>'.
	 * @see com.zeligsoft.cx.langc.AddressOfExpr
	 * @generated
	 */
	EClass getAddressOfExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.AddressOfExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see com.zeligsoft.cx.langc.AddressOfExpr#getExpr()
	 * @see #getAddressOfExpr()
	 * @generated
	 */
	EReference getAddressOfExpr_Expr();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.DereferenceExpr <em>Dereference Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dereference Expr</em>'.
	 * @see com.zeligsoft.cx.langc.DereferenceExpr
	 * @generated
	 */
	EClass getDereferenceExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.DereferenceExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see com.zeligsoft.cx.langc.DereferenceExpr#getExpr()
	 * @see #getDereferenceExpr()
	 * @generated
	 */
	EReference getDereferenceExpr_Expr();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Statement</em>'.
	 * @see com.zeligsoft.cx.langc.WhileStatement
	 * @generated
	 */
	EClass getWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.WhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see com.zeligsoft.cx.langc.WhileStatement#getCondition()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Condition();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Macro <em>Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Macro</em>'.
	 * @see com.zeligsoft.cx.langc.Macro
	 * @generated
	 */
	EClass getMacro();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.Macro#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.zeligsoft.cx.langc.Macro#getParameters()
	 * @see #getMacro()
	 * @generated
	 */
	EReference getMacro_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Macro#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Replacement</em>'.
	 * @see com.zeligsoft.cx.langc.Macro#getReplacement()
	 * @see #getMacro()
	 * @generated
	 */
	EReference getMacro_Replacement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.Macro#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.Macro#getName()
	 * @see #getMacro()
	 * @generated
	 */
	EReference getMacro_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see com.zeligsoft.cx.langc.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.zeligsoft.cx.langc.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Directive <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive</em>'.
	 * @see com.zeligsoft.cx.langc.Directive
	 * @generated
	 */
	EClass getDirective();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.VariableDeclarationStatement <em>Variable Declaration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration Statement</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclarationStatement
	 * @generated
	 */
	EClass getVariableDeclarationStatement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.VariableDeclarationStatement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see com.zeligsoft.cx.langc.VariableDeclarationStatement#getVariable()
	 * @see #getVariableDeclarationStatement()
	 * @generated
	 */
	EReference getVariableDeclarationStatement_Variable();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.BlockInitializer <em>Block Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Initializer</em>'.
	 * @see com.zeligsoft.cx.langc.BlockInitializer
	 * @generated
	 */
	EClass getBlockInitializer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.BlockInitializer#getExprs <em>Exprs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exprs</em>'.
	 * @see com.zeligsoft.cx.langc.BlockInitializer#getExprs()
	 * @see #getBlockInitializer()
	 * @generated
	 */
	EReference getBlockInitializer_Exprs();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.IndexExpr <em>Index Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Expr</em>'.
	 * @see com.zeligsoft.cx.langc.IndexExpr
	 * @generated
	 */
	EClass getIndexExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.IndexExpr#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see com.zeligsoft.cx.langc.IndexExpr#getIndex()
	 * @see #getIndexExpr()
	 * @generated
	 */
	EReference getIndexExpr_Index();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.IndexExpr#getArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array</em>'.
	 * @see com.zeligsoft.cx.langc.IndexExpr#getArray()
	 * @see #getIndexExpr()
	 * @generated
	 */
	EReference getIndexExpr_Array();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.LogicalComparison <em>Logical Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Comparison</em>'.
	 * @see com.zeligsoft.cx.langc.LogicalComparison
	 * @generated
	 */
	EClass getLogicalComparison();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.LogicalComparison#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see com.zeligsoft.cx.langc.LogicalComparison#getLhs()
	 * @see #getLogicalComparison()
	 * @generated
	 */
	EReference getLogicalComparison_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.LogicalComparison#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see com.zeligsoft.cx.langc.LogicalComparison#getRhs()
	 * @see #getLogicalComparison()
	 * @generated
	 */
	EReference getLogicalComparison_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.LogicalComparison#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see com.zeligsoft.cx.langc.LogicalComparison#getOperator()
	 * @see #getLogicalComparison()
	 * @generated
	 */
	EAttribute getLogicalComparison_Operator();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.SizeofExpr <em>Sizeof Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sizeof Expr</em>'.
	 * @see com.zeligsoft.cx.langc.SizeofExpr
	 * @generated
	 */
	EClass getSizeofExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.SizeofExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see com.zeligsoft.cx.langc.SizeofExpr#getExpr()
	 * @see #getSizeofExpr()
	 * @generated
	 */
	EReference getSizeofExpr_Expr();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Sizeof <em>Sizeof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sizeof</em>'.
	 * @see com.zeligsoft.cx.langc.Sizeof
	 * @generated
	 */
	EClass getSizeof();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.FunctionImplementation <em>Function Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Implementation</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionImplementation
	 * @generated
	 */
	EClass getFunctionImplementation();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.FunctionImplementation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionImplementation#getBody()
	 * @see #getFunctionImplementation()
	 * @generated
	 */
	EReference getFunctionImplementation_Body();

	/**
	 * Returns the meta object for the reference '{@link com.zeligsoft.cx.langc.FunctionImplementation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see com.zeligsoft.cx.langc.FunctionImplementation#getFunction()
	 * @see #getFunctionImplementation()
	 * @generated
	 */
	EReference getFunctionImplementation_Function();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see com.zeligsoft.cx.langc.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.System#getSubSystems <em>Sub Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Systems</em>'.
	 * @see com.zeligsoft.cx.langc.System#getSubSystems()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_SubSystems();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.System#getPublicFolders <em>Public Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Public Folders</em>'.
	 * @see com.zeligsoft.cx.langc.System#getPublicFolders()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_PublicFolders();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.cx.langc.System#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Artifacts</em>'.
	 * @see com.zeligsoft.cx.langc.System#getArtifacts()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Artifacts();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.CodeBlob <em>Code Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Blob</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlob
	 * @generated
	 */
	EClass getCodeBlob();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.CodeBlob#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependencies</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlob#getDependencies()
	 * @see #getCodeBlob()
	 * @generated
	 */
	EReference getCodeBlob_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.CodeBlob#getMarkerComment <em>Marker Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marker Comment</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlob#getMarkerComment()
	 * @see #getCodeBlob()
	 * @generated
	 */
	EAttribute getCodeBlob_MarkerComment();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see com.zeligsoft.cx.langc.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.DependencyBlob <em>Dependency Blob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Blob</em>'.
	 * @see com.zeligsoft.cx.langc.DependencyBlob
	 * @generated
	 */
	EClass getDependencyBlob();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.DependencyBlob#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.zeligsoft.cx.langc.DependencyBlob#getText()
	 * @see #getDependencyBlob()
	 * @generated
	 */
	EAttribute getDependencyBlob_Text();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.DependencyBlob#getMarkerComment <em>Marker Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marker Comment</em>'.
	 * @see com.zeligsoft.cx.langc.DependencyBlob#getMarkerComment()
	 * @see #getDependencyBlob()
	 * @generated
	 */
	EAttribute getDependencyBlob_MarkerComment();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.LinkableArtifact <em>Linkable Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linkable Artifact</em>'.
	 * @see com.zeligsoft.cx.langc.LinkableArtifact
	 * @generated
	 */
	EClass getLinkableArtifact();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.LinkableArtifact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.cx.langc.LinkableArtifact#getName()
	 * @see #getLinkableArtifact()
	 * @generated
	 */
	EAttribute getLinkableArtifact_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.cx.langc.LinkableArtifact#getFunctionImplementations <em>Function Implementations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Implementations</em>'.
	 * @see com.zeligsoft.cx.langc.LinkableArtifact#getFunctionImplementations()
	 * @see #getLinkableArtifact()
	 * @generated
	 */
	EReference getLinkableArtifact_FunctionImplementations();

	/**
	 * Returns the meta object for the reference list '{@link com.zeligsoft.cx.langc.LinkableArtifact#getRootElements <em>Root Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Elements</em>'.
	 * @see com.zeligsoft.cx.langc.LinkableArtifact#getRootElements()
	 * @see #getLinkableArtifact()
	 * @generated
	 */
	EReference getLinkableArtifact_RootElements();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.cx.langc.ConditionalStatement <em>Conditional Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Statement</em>'.
	 * @see com.zeligsoft.cx.langc.ConditionalStatement
	 * @generated
	 */
	EClass getConditionalStatement();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.cx.langc.ConditionalStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see com.zeligsoft.cx.langc.ConditionalStatement#getCondition()
	 * @see #getConditionalStatement()
	 * @generated
	 */
	EReference getConditionalStatement_Condition();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.cx.langc.CodeBlob#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.zeligsoft.cx.langc.CodeBlob#getText()
	 * @see #getCodeBlob()
	 * @generated
	 */
	EAttribute getCodeBlob_Text();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.CVQualifier <em>CV Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>CV Qualifier</em>'.
	 * @see com.zeligsoft.cx.langc.CVQualifier
	 * @generated
	 */
	EEnum getCVQualifier();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type</em>'.
	 * @see com.zeligsoft.cx.langc.PrimitiveType
	 * @generated
	 */
	EEnum getPrimitiveType();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.LinkageSpec <em>Linkage Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Linkage Spec</em>'.
	 * @see com.zeligsoft.cx.langc.LinkageSpec
	 * @generated
	 */
	EEnum getLinkageSpec();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see com.zeligsoft.cx.langc.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.Pointer <em>Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pointer</em>'.
	 * @see com.zeligsoft.cx.langc.Pointer
	 * @generated
	 */
	EEnum getPointer();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.ElementKind <em>Element Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Element Kind</em>'.
	 * @see com.zeligsoft.cx.langc.ElementKind
	 * @generated
	 */
	EEnum getElementKind();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.cx.langc.BooleanOperator <em>Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boolean Operator</em>'.
	 * @see com.zeligsoft.cx.langc.BooleanOperator
	 * @generated
	 */
	EEnum getBooleanOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LangCFactory getLangCFactory();

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
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.NamedElementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.BuiltInTypeImpl <em>Built In Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.BuiltInTypeImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBuiltInType()
		 * @generated
		 */
		EClass BUILT_IN_TYPE = eINSTANCE.getBuiltInType();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUILT_IN_TYPE__TYPE = eINSTANCE.getBuiltInType_Type();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.NameImpl <em>Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.NameImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getName_()
		 * @generated
		 */
		EClass NAME = eINSTANCE.getName_();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME__NAME = eINSTANCE.getName_Name();
		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME__PARENT = eINSTANCE.getName_Parent();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.StructImpl <em>Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.StructImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStruct()
		 * @generated
		 */
		EClass STRUCT = eINSTANCE.getStruct();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.UnionImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUnion()
		 * @generated
		 */
		EClass UNION = eINSTANCE.getUnion();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FunctionImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();
		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__RETURN_TYPE = eINSTANCE.getFunction_ReturnType();
		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETERS = eINSTANCE.getFunction_Parameters();
		/**
		 * The meta object literal for the '<em><b>Linkage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__LINKAGE = eINSTANCE.getFunction_Linkage();
		/**
		 * The meta object literal for the '<em><b>Default Impl</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__DEFAULT_IMPL = eINSTANCE.getFunction_DefaultImpl();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.NamedReferenceImpl <em>Named Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.NamedReferenceImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getNamedReference()
		 * @generated
		 */
		EClass NAMED_REFERENCE = eINSTANCE.getNamedReference();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_REFERENCE__NAME = eINSTANCE.getNamedReference_Name();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_REFERENCE__TYPE = eINSTANCE.getNamedReference_Type();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl <em>Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ElementReferenceImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementReference()
		 * @generated
		 */
		EClass ELEMENT_REFERENCE = eINSTANCE.getElementReference();
		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_REFERENCE__ELEMENT = eINSTANCE.getElementReference_Element();
		/**
		 * The meta object literal for the '<em><b>Cv Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_REFERENCE__CV_QUALIFIER = eINSTANCE.getElementReference_CvQualifier();
		/**
		 * The meta object literal for the '<em><b>Pointer Spec</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_REFERENCE__POINTER_SPEC = eINSTANCE.getElementReference_PointerSpec();
		/**
		 * The meta object literal for the '<em><b>Array Bounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_REFERENCE__ARRAY_BOUNDS = eINSTANCE.getElementReference_ArrayBounds();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ExpressionImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__TYPE = eINSTANCE.getExpression_Type();
		/**
		 * The meta object literal for the '<em><b>Precendence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__PRECENDENCE = eINSTANCE.getExpression_Precendence();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FunctionCallImpl <em>Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FunctionCallImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionCall()
		 * @generated
		 */
		EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();
		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__FUNCTION = eINSTANCE.getFunctionCall_Function();
		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__ARGUMENTS = eINSTANCE.getFunctionCall_Arguments();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ElementAccessImpl <em>Element Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ElementAccessImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementAccess()
		 * @generated
		 */
		EClass ELEMENT_ACCESS = eINSTANCE.getElementAccess();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_ACCESS__NAME = eINSTANCE.getElementAccess_Name();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ElementListImpl <em>Element List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ElementListImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementList()
		 * @generated
		 */
		EClass ELEMENT_LIST = eINSTANCE.getElementList();
		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__ELEMENTS = eINSTANCE.getElementList_Elements();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__NAME = eINSTANCE.getElementList_Name();
		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__TYPES = eINSTANCE.getElementList_Types();
		/**
		 * The meta object literal for the '<em><b>Decl Includes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__DECL_INCLUDES = eINSTANCE.getElementList_DeclIncludes();
		/**
		 * The meta object literal for the '<em><b>Defn Includes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__DEFN_INCLUDES = eINSTANCE.getElementList_DefnIncludes();
		/**
		 * The meta object literal for the '<em><b>Public Directives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__PUBLIC_DIRECTIVES = eINSTANCE.getElementList_PublicDirectives();
		/**
		 * The meta object literal for the '<em><b>Private Directives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIST__PRIVATE_DIRECTIVES = eINSTANCE.getElementList_PrivateDirectives();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.LiteralImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();
		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__PRIMITIVE_TYPE = eINSTANCE.getLiteral_PrimitiveType();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.IntegralLiteralImpl <em>Integral Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.IntegralLiteralImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getIntegralLiteral()
		 * @generated
		 */
		EClass INTEGRAL_LITERAL = eINSTANCE.getIntegralLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRAL_LITERAL__VALUE = eINSTANCE.getIntegralLiteral_Value();
		/**
		 * The meta object literal for the '<em><b>Bytes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRAL_LITERAL__BYTES = eINSTANCE.getIntegralLiteral_Bytes();
		/**
		 * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRAL_LITERAL__SIGNED = eINSTANCE.getIntegralLiteral_Signed();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.CharacterLiteralImpl <em>Character Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.CharacterLiteralImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCharacterLiteral()
		 * @generated
		 */
		EClass CHARACTER_LITERAL = eINSTANCE.getCharacterLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARACTER_LITERAL__VALUE = eINSTANCE.getCharacterLiteral_Value();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FloatingLiteralImpl <em>Floating Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FloatingLiteralImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFloatingLiteral()
		 * @generated
		 */
		EClass FLOATING_LITERAL = eINSTANCE.getFloatingLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_LITERAL__VALUE = eINSTANCE.getFloatingLiteral_Value();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.StatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ExpressionStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpressionStatement()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();
		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT__EXPR = eINSTANCE.getExpressionStatement_Expr();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ReturnStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getReturnStatement()
		 * @generated
		 */
		EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.CodeBlockImpl <em>Code Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.CodeBlockImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCodeBlock()
		 * @generated
		 */
		EClass CODE_BLOCK = eINSTANCE.getCodeBlock();
		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__STATEMENTS = eINSTANCE.getCodeBlock_Statements();
		/**
		 * The meta object literal for the '<em><b>Force Braces</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__FORCE_BRACES = eINSTANCE.getCodeBlock_ForceBraces();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.BinaryOperationImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBinaryOperation()
		 * @generated
		 */
		EClass BINARY_OPERATION = eINSTANCE.getBinaryOperation();
		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_OPERATION__OPERATOR = eINSTANCE.getBinaryOperation_Operator();
		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATION__LHS = eINSTANCE.getBinaryOperation_Lhs();
		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATION__RHS = eINSTANCE.getBinaryOperation_Rhs();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.StructureImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();
		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__MEMBERS = eINSTANCE.getStructure_Members();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FunctionPointerImpl <em>Function Pointer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FunctionPointerImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionPointer()
		 * @generated
		 */
		EClass FUNCTION_POINTER = eINSTANCE.getFunctionPointer();
		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_POINTER__RETURN_TYPE = eINSTANCE.getFunctionPointer_ReturnType();
		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_POINTER__PARAMETERS = eINSTANCE.getFunctionPointer_Parameters();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FunctionAddressImpl <em>Function Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FunctionAddressImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionAddress()
		 * @generated
		 */
		EClass FUNCTION_ADDRESS = eINSTANCE.getFunctionAddress();
		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_ADDRESS__FUNCTION = eINSTANCE.getFunctionAddress_Function();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.VariableDeclarationImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();
		/**
		 * The meta object literal for the '<em><b>Linkage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__LINKAGE = eINSTANCE.getVariableDeclaration_Linkage();
		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__ELEMENT = eINSTANCE.getVariableDeclaration_Element();
		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIALIZER = eINSTANCE.getVariableDeclaration_Initializer();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ElementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.TypedefImpl <em>Typedef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.TypedefImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getTypedef()
		 * @generated
		 */
		EClass TYPEDEF = eINSTANCE.getTypedef();
		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__ELEMENT = eINSTANCE.getTypedef_Element();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.MemberAccessImpl <em>Member Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.MemberAccessImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getMemberAccess()
		 * @generated
		 */
		EClass MEMBER_ACCESS = eINSTANCE.getMemberAccess();
		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_ACCESS__CONTAINER = eINSTANCE.getMemberAccess_Container();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ExpressionBlobImpl <em>Expression Blob</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ExpressionBlobImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getExpressionBlob()
		 * @generated
		 */
		EClass EXPRESSION_BLOB = eINSTANCE.getExpressionBlob();
		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_BLOB__TEXT = eINSTANCE.getExpressionBlob_Text();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SubSystemImpl <em>Sub System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SubSystemImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSubSystem()
		 * @generated
		 */
		EClass SUB_SYSTEM = eINSTANCE.getSubSystem();
		/**
		 * The meta object literal for the '<em><b>Files</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__FILES = eINSTANCE.getSubSystem_Files();
		/**
		 * The meta object literal for the '<em><b>Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__FOLDERS = eINSTANCE.getSubSystem_Folders();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_SYSTEM__NAME = eINSTANCE.getSubSystem_Name();
		/**
		 * The meta object literal for the '<em><b>Public Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__PUBLIC_FOLDERS = eINSTANCE.getSubSystem_PublicFolders();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.EnumImpl <em>Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.EnumImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getEnum()
		 * @generated
		 */
		EClass ENUM = eINSTANCE.getEnum();
		/**
		 * The meta object literal for the '<em><b>Enumerators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM__ENUMERATORS = eINSTANCE.getEnum_Enumerators();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.EnumeratorImpl <em>Enumerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.EnumeratorImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getEnumerator()
		 * @generated
		 */
		EClass ENUMERATOR = eINSTANCE.getEnumerator();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR__VALUE = eINSTANCE.getEnumerator_Value();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR__NAME = eINSTANCE.getEnumerator_Name();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FileDependencyImpl <em>File Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FileDependencyImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFileDependency()
		 * @generated
		 */
		EClass FILE_DEPENDENCY = eINSTANCE.getFileDependency();
		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_DEPENDENCY__FILENAME = eINSTANCE.getFileDependency_Filename();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SystemIncludeImpl <em>System Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SystemIncludeImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystemInclude()
		 * @generated
		 */
		EClass SYSTEM_INCLUDE = eINSTANCE.getSystemInclude();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.UserIncludeImpl <em>User Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.UserIncludeImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUserInclude()
		 * @generated
		 */
		EClass USER_INCLUDE = eINSTANCE.getUserInclude();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FileNameImpl <em>File Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FileNameImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFileName()
		 * @generated
		 */
		EClass FILE_NAME = eINSTANCE.getFileName();
		/**
		 * The meta object literal for the '<em><b>Has Object Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_NAME__HAS_OBJECT_CODE = eINSTANCE.getFileName_HasObjectCode();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FolderNameImpl <em>Folder Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FolderNameImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFolderName()
		 * @generated
		 */
		EClass FOLDER_NAME = eINSTANCE.getFolderName();
		/**
		 * The meta object literal for the '<em><b>Api</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOLDER_NAME__API = eINSTANCE.getFolderName_Api();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.CastExprImpl <em>Cast Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.CastExprImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCastExpr()
		 * @generated
		 */
		EClass CAST_EXPR = eINSTANCE.getCastExpr();
		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EXPR__TARGET_TYPE = eINSTANCE.getCastExpr_TargetType();
		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EXPR__EXPR = eINSTANCE.getCastExpr_Expr();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.UserElementImpl <em>User Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.UserElementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getUserElement()
		 * @generated
		 */
		EClass USER_ELEMENT = eINSTANCE.getUserElement();
		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ELEMENT__KIND = eINSTANCE.getUserElement_Kind();
		/**
		 * The meta object literal for the '<em><b>Defn</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ELEMENT__DEFN = eINSTANCE.getUserElement_Defn();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.DependencyListImpl <em>Dependency List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.DependencyListImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependencyList()
		 * @generated
		 */
		EClass DEPENDENCY_LIST = eINSTANCE.getDependencyList();
		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_LIST__DEPENDENCIES = eINSTANCE.getDependencyList_Dependencies();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SizeofTypeImpl <em>Sizeof Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SizeofTypeImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeofType()
		 * @generated
		 */
		EClass SIZEOF_TYPE = eINSTANCE.getSizeofType();
		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIZEOF_TYPE__ELEMENT = eINSTANCE.getSizeofType_Element();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.BindableValueImpl <em>Bindable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.BindableValueImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBindableValue()
		 * @generated
		 */
		EClass BINDABLE_VALUE = eINSTANCE.getBindableValue();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SystemFileNameImpl <em>System File Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SystemFileNameImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystemFileName()
		 * @generated
		 */
		EClass SYSTEM_FILE_NAME = eINSTANCE.getSystemFileName();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SwitchClauseImpl <em>Switch Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SwitchClauseImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSwitchClause()
		 * @generated
		 */
		EClass SWITCH_CLAUSE = eINSTANCE.getSwitchClause();
		/**
		 * The meta object literal for the '<em><b>Fallthrough</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH_CLAUSE__FALLTHROUGH = eINSTANCE.getSwitchClause_Fallthrough();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.LabeledClauseImpl <em>Labeled Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.LabeledClauseImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLabeledClause()
		 * @generated
		 */
		EClass LABELED_CLAUSE = eINSTANCE.getLabeledClause();
		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELED_CLAUSE__LABELS = eINSTANCE.getLabeledClause_Labels();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SwitchStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();
		/**
		 * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CLAUSES = eINSTANCE.getSwitchStatement_Clauses();
		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CONDITION = eINSTANCE.getSwitchStatement_Condition();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.BreakStatementImpl <em>Break Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.BreakStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBreakStatement()
		 * @generated
		 */
		EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.AddressOfExprImpl <em>Address Of Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.AddressOfExprImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getAddressOfExpr()
		 * @generated
		 */
		EClass ADDRESS_OF_EXPR = eINSTANCE.getAddressOfExpr();
		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDRESS_OF_EXPR__EXPR = eINSTANCE.getAddressOfExpr_Expr();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.DereferenceExprImpl <em>Dereference Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.DereferenceExprImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDereferenceExpr()
		 * @generated
		 */
		EClass DEREFERENCE_EXPR = eINSTANCE.getDereferenceExpr();
		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEREFERENCE_EXPR__EXPR = eINSTANCE.getDereferenceExpr_Expr();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.WhileStatementImpl <em>While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.WhileStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getWhileStatement()
		 * @generated
		 */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();
		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.MacroImpl <em>Macro</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.MacroImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getMacro()
		 * @generated
		 */
		EClass MACRO = eINSTANCE.getMacro();
		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACRO__PARAMETERS = eINSTANCE.getMacro_Parameters();
		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACRO__REPLACEMENT = eINSTANCE.getMacro_Replacement();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACRO__NAME = eINSTANCE.getMacro_Name();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.StringLiteralImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.DirectiveImpl <em>Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.DirectiveImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDirective()
		 * @generated
		 */
		EClass DIRECTIVE = eINSTANCE.getDirective();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.VariableDeclarationStatementImpl <em>Variable Declaration Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.VariableDeclarationStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getVariableDeclarationStatement()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION_STATEMENT = eINSTANCE.getVariableDeclarationStatement();
		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_STATEMENT__VARIABLE = eINSTANCE.getVariableDeclarationStatement_Variable();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.BlockInitializerImpl <em>Block Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.BlockInitializerImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBlockInitializer()
		 * @generated
		 */
		EClass BLOCK_INITIALIZER = eINSTANCE.getBlockInitializer();
		/**
		 * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_INITIALIZER__EXPRS = eINSTANCE.getBlockInitializer_Exprs();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.IndexExprImpl <em>Index Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.IndexExprImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getIndexExpr()
		 * @generated
		 */
		EClass INDEX_EXPR = eINSTANCE.getIndexExpr();
		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_EXPR__INDEX = eINSTANCE.getIndexExpr_Index();
		/**
		 * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_EXPR__ARRAY = eINSTANCE.getIndexExpr_Array();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.LogicalComparisonImpl <em>Logical Comparison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.LogicalComparisonImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLogicalComparison()
		 * @generated
		 */
		EClass LOGICAL_COMPARISON = eINSTANCE.getLogicalComparison();
		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_COMPARISON__LHS = eINSTANCE.getLogicalComparison_Lhs();
		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_COMPARISON__RHS = eINSTANCE.getLogicalComparison_Rhs();
		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_COMPARISON__OPERATOR = eINSTANCE.getLogicalComparison_Operator();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SizeofExprImpl <em>Sizeof Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SizeofExprImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeofExpr()
		 * @generated
		 */
		EClass SIZEOF_EXPR = eINSTANCE.getSizeofExpr();
		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIZEOF_EXPR__EXPR = eINSTANCE.getSizeofExpr_Expr();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SizeofImpl <em>Sizeof</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SizeofImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSizeof()
		 * @generated
		 */
		EClass SIZEOF = eINSTANCE.getSizeof();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.FunctionImplementationImpl <em>Function Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.FunctionImplementationImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getFunctionImplementation()
		 * @generated
		 */
		EClass FUNCTION_IMPLEMENTATION = eINSTANCE.getFunctionImplementation();
		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_IMPLEMENTATION__BODY = eINSTANCE.getFunctionImplementation_Body();
		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_IMPLEMENTATION__FUNCTION = eINSTANCE.getFunctionImplementation_Function();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.SystemImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();
		/**
		 * The meta object literal for the '<em><b>Sub Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SUB_SYSTEMS = eINSTANCE.getSystem_SubSystems();
		/**
		 * The meta object literal for the '<em><b>Public Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PUBLIC_FOLDERS = eINSTANCE.getSystem_PublicFolders();
		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ARTIFACTS = eINSTANCE.getSystem_Artifacts();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.CodeBlobImpl <em>Code Blob</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.CodeBlobImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCodeBlob()
		 * @generated
		 */
		EClass CODE_BLOB = eINSTANCE.getCodeBlob();
		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOB__DEPENDENCIES = eINSTANCE.getCodeBlob_Dependencies();
		/**
		 * The meta object literal for the '<em><b>Marker Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOB__MARKER_COMMENT = eINSTANCE.getCodeBlob_MarkerComment();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.DependencyImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.DependencyBlobImpl <em>Dependency Blob</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.DependencyBlobImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getDependencyBlob()
		 * @generated
		 */
		EClass DEPENDENCY_BLOB = eINSTANCE.getDependencyBlob();
		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_BLOB__TEXT = eINSTANCE.getDependencyBlob_Text();
		/**
		 * The meta object literal for the '<em><b>Marker Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_BLOB__MARKER_COMMENT = eINSTANCE.getDependencyBlob_MarkerComment();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.LinkableArtifactImpl <em>Linkable Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.LinkableArtifactImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLinkableArtifact()
		 * @generated
		 */
		EClass LINKABLE_ARTIFACT = eINSTANCE.getLinkableArtifact();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINKABLE_ARTIFACT__NAME = eINSTANCE.getLinkableArtifact_Name();
		/**
		 * The meta object literal for the '<em><b>Function Implementations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS = eINSTANCE.getLinkableArtifact_FunctionImplementations();
		/**
		 * The meta object literal for the '<em><b>Root Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKABLE_ARTIFACT__ROOT_ELEMENTS = eINSTANCE.getLinkableArtifact_RootElements();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.impl.ConditionalStatementImpl <em>Conditional Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.impl.ConditionalStatementImpl
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getConditionalStatement()
		 * @generated
		 */
		EClass CONDITIONAL_STATEMENT = eINSTANCE.getConditionalStatement();
		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_STATEMENT__CONDITION = eINSTANCE.getConditionalStatement_Condition();
		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOB__TEXT = eINSTANCE.getCodeBlob_Text();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.CVQualifier <em>CV Qualifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.CVQualifier
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getCVQualifier()
		 * @generated
		 */
		EEnum CV_QUALIFIER = eINSTANCE.getCVQualifier();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.PrimitiveType <em>Primitive Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.PrimitiveType
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.LinkageSpec <em>Linkage Spec</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.LinkageSpec
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getLinkageSpec()
		 * @generated
		 */
		EEnum LINKAGE_SPEC = eINSTANCE.getLinkageSpec();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.Operator
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.Pointer <em>Pointer</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.Pointer
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getPointer()
		 * @generated
		 */
		EEnum POINTER = eINSTANCE.getPointer();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.ElementKind <em>Element Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.ElementKind
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getElementKind()
		 * @generated
		 */
		EEnum ELEMENT_KIND = eINSTANCE.getElementKind();
		/**
		 * The meta object literal for the '{@link com.zeligsoft.cx.langc.BooleanOperator <em>Boolean Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.cx.langc.BooleanOperator
		 * @see com.zeligsoft.cx.langc.impl.LangCPackageImpl#getBooleanOperator()
		 * @generated
		 */
		EEnum BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

	}

} //LangCPackage
