/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.ocl.xtext.basecs.BaseCSFactory
 * @model kind="package"
 * @generated
 */
public interface BaseCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "basecs"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/BaseCS"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "basecs"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseCSPackage eINSTANCE = org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.util.VisitableCS <em>Visitable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.util.VisitableCS
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getVisitableCS()
	 * @generated
	 */
	int VISITABLE_CS = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl <em>Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getElementCS()
	 * @generated
	 */
	int ELEMENT_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PivotableElementCSImpl <em>Pivotable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PivotableElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPivotableElementCS()
	 * @generated
	 */
	int PIVOTABLE_ELEMENT_CS = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getModelElementCS()
	 * @generated
	 */
	int MODEL_ELEMENT_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.AnnotationElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAnnotationElementCS()
	 * @generated
	 */
	int ANNOTATION_ELEMENT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.DetailCSImpl <em>Detail CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.DetailCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDetailCS()
	 * @generated
	 */
	int DETAIL_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ImportCSImpl <em>Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ImportCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getImportCS()
	 * @generated
	 */
	int IMPORT_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getNamedElementCS()
	 * @generated
	 */
	int NAMED_ELEMENT_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedElementCS()
	 * @generated
	 */
	int TYPED_ELEMENT_CS = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.FeatureCSImpl <em>Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.FeatureCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getFeatureCS()
	 * @generated
	 */
	int FEATURE_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getStructuralFeatureCS()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_CS = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAttributeCS()
	 * @generated
	 */
	int ATTRIBUTE_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.NamespaceCSImpl <em>Namespace CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.NamespaceCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getNamespaceCS()
	 * @generated
	 */
	int NAMESPACE_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl <em>Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getOperationCS()
	 * @generated
	 */
	int OPERATION_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PackageCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ParameterCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PrimitiveTypeRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPrimitiveTypeRefCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_REF_CS = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getReferenceCS()
	 * @generated
	 */
	int REFERENCE_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeCSImpl <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeParameterCS()
	 * @generated
	 */
	int TYPE_PARAMETER_CS = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypedTypeRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedTypeRefCS()
	 * @generated
	 */
	int TYPED_TYPE_REF_CS = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.WildcardTypeRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getWildcardTypeRefCS()
	 * @generated
	 */
	int WILDCARD_TYPE_REF_CS = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypeRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeRefCS()
	 * @generated
	 */
	int TYPE_REF_CS = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedRefCS()
	 * @generated
	 */
	int TYPED_REF_CS = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.AnnotationCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAnnotationCS()
	 * @generated
	 */
	int ANNOTATION_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateBindingCS()
	 * @generated
	 */
	int TEMPLATE_BINDING_CS = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateParameterCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateParameterCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_CS = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_SUBSTITUTION_CS = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateSignatureCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateSignatureCS()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE_CS = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateableElementCSImpl <em>Templateable Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateableElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateableElementCS()
	 * @generated
	 */
	int TEMPLATEABLE_ELEMENT_CS = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDataTypeCS()
	 * @generated
	 */
	int DATA_TYPE_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.DocumentationCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDocumentationCS()
	 * @generated
	 */
	int DOCUMENTATION_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.EnumerationCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getEnumerationCS()
	 * @generated
	 */
	int ENUMERATION_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.EnumerationLiteralCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getEnumerationLiteralCS()
	 * @generated
	 */
	int ENUMERATION_LITERAL_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ImplicitOppositeCSImpl <em>Implicit Opposite CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ImplicitOppositeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getImplicitOppositeCS()
	 * @generated
	 */
	int IMPLICIT_OPPOSITE_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ElementRefCSImpl <em>Element Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ElementRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getElementRefCS()
	 * @generated
	 */
	int ELEMENT_REF_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.LambdaTypeCSImpl <em>Lambda Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.LambdaTypeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getLambdaTypeCS()
	 * @generated
	 */
	int LAMBDA_TYPE_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ModelElementRefCSImpl <em>Model Element Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ModelElementRefCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getModelElementRefCS()
	 * @generated
	 */
	int MODEL_ELEMENT_REF_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl <em>Context Less Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getContextLessElementCS()
	 * @generated
	 */
	int CONTEXT_LESS_ELEMENT_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityCS()
	 * @generated
	 */
	int MULTIPLICITY_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityBoundsCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityBoundsCS()
	 * @generated
	 */
	int MULTIPLICITY_BOUNDS_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityStringCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityStringCS()
	 * @generated
	 */
	int MULTIPLICITY_STRING_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PackageOwnerCSImpl <em>Package Owner CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PackageOwnerCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPackageOwnerCS()
	 * @generated
	 */
	int PACKAGE_OWNER_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PathElementCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathElementCS()
	 * @generated
	 */
	int PATH_ELEMENT_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathElementWithURICSImpl <em>Path Element With URICS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PathElementWithURICSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathElementWithURICS()
	 * @generated
	 */
	int PATH_ELEMENT_WITH_URICS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathNameCS()
	 * @generated
	 */
	int PATH_NAME_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.RootCSImpl <em>Root CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.RootCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getRootCS()
	 * @generated
	 */
	int ROOT_CS = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getRootPackageCS()
	 * @generated
	 */
	int ROOT_PACKAGE_CS = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.SpecificationCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getSpecificationCS()
	 * @generated
	 */
	int SPECIFICATION_CS = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl <em>Structured Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getStructuredClassCS()
	 * @generated
	 */
	int STRUCTURED_CLASS_CS = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TuplePartCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTuplePartCS()
	 * @generated
	 */
	int TUPLE_PART_CS = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.basecs.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.basecs.impl.TupleTypeCSImpl
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTupleTypeCS()
	 * @generated
	 */
	int TUPLE_TYPE_CS = 45;

	/**
	 * The meta object id for the '<em>Big Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getBigNumber()
	 * @generated
	 */
	int BIG_NUMBER = 54;

	/**
	 * The meta object id for the '<em>CSI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.base.utilities.CSI
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getCSI()
	 * @generated
	 */
	int CSI = 55;

	/**
	 * The meta object id for the '<em>Scope Filter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.internal.scoping.ScopeFilter
	 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getScopeFilter()
	 * @generated
	 */
	int SCOPE_FILTER = 56;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationCS
	 * @generated
	 */
	EClass getAnnotationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.AnnotationCS#getOwnedContents <em>Owned Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Contents</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationCS#getOwnedContents()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_OwnedContents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.AnnotationCS#getOwnedReferences <em>Owned References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned References</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationCS#getOwnedReferences()
	 * @see #getAnnotationCS()
	 * @generated
	 */
	EReference getAnnotationCS_OwnedReferences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationElementCS
	 * @generated
	 */
	EClass getAnnotationElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.AnnotationElementCS#getOwnedDetails <em>Owned Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Details</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationElementCS#getOwnedDetails()
	 * @see #getAnnotationElementCS()
	 * @generated
	 */
	EReference getAnnotationElementCS_OwnedDetails();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.AttributeCS
	 * @generated
	 */
	EClass getAttributeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.ClassCS#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS#getOwningPackage()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwningPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.ClassCS#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS#getInstanceClassName()
	 * @see #getClassCS()
	 * @generated
	 */
	EAttribute getClassCS_InstanceClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.ClassCS#getOwnedConstraints <em>Owned Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraints</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS#getOwnedConstraints()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_OwnedConstraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ConstraintCS#getStereotype()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EAttribute getConstraintCS_Stereotype();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedSpecification()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_OwnedSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedMessageSpecification <em>Owned Message Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Message Specification</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedMessageSpecification()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_OwnedMessageSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ContextLessElementCS <em>Context Less Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Less Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ContextLessElementCS
	 * @generated
	 */
	EClass getContextLessElementCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DataTypeCS
	 * @generated
	 */
	EClass getDataTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.DataTypeCS#isIsPrimitive <em>Is Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primitive</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DataTypeCS#isIsPrimitive()
	 * @see #getDataTypeCS()
	 * @generated
	 */
	EAttribute getDataTypeCS_IsPrimitive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.DataTypeCS#isIsSerializable <em>Is Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Serializable</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DataTypeCS#isIsSerializable()
	 * @see #getDataTypeCS()
	 * @generated
	 */
	EAttribute getDataTypeCS_IsSerializable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DetailCS
	 * @generated
	 */
	EClass getDetailCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.xtext.basecs.DetailCS#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DetailCS#getValues()
	 * @see #getDetailCS()
	 * @generated
	 */
	EAttribute getDetailCS_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DocumentationCS
	 * @generated
	 */
	EClass getDocumentationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.DocumentationCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.DocumentationCS#getValue()
	 * @see #getDocumentationCS()
	 * @generated
	 */
	EAttribute getDocumentationCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ElementCS
	 * @generated
	 */
	EClass getElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.ElementCS#getCsi <em>Csi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Csi</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ElementCS#getCsi()
	 * @see #getElementCS()
	 * @generated
	 */
	EAttribute getElementCS_Csi();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.ElementCS#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ElementCS#getParent()
	 * @see #getElementCS()
	 * @generated
	 */
	EReference getElementCS_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ElementRefCS
	 * @generated
	 */
	EClass getElementRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.EnumerationCS <em>Enumeration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationCS
	 * @generated
	 */
	EClass getEnumerationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.EnumerationCS#isIsSerializable <em>Is Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Serializable</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationCS#isIsSerializable()
	 * @see #getEnumerationCS()
	 * @generated
	 */
	EAttribute getEnumerationCS_IsSerializable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.EnumerationCS#getOwnedLiterals <em>Owned Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literals</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationCS#getOwnedLiterals()
	 * @see #getEnumerationCS()
	 * @generated
	 */
	EReference getEnumerationCS_OwnedLiterals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS <em>Enumeration Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS
	 * @generated
	 */
	EClass getEnumerationLiteralCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS#getLiteral()
	 * @see #getEnumerationLiteralCS()
	 * @generated
	 */
	EAttribute getEnumerationLiteralCS_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS#getValue()
	 * @see #getEnumerationLiteralCS()
	 * @generated
	 */
	EAttribute getEnumerationLiteralCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.FeatureCS <em>Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.FeatureCS
	 * @generated
	 */
	EClass getFeatureCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS <em>Implicit Opposite CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implicit Opposite CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS
	 * @generated
	 */
	EClass getImplicitOppositeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ImportCS
	 * @generated
	 */
	EClass getImportCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.ImportCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ImportCS#getOwnedPathName()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.ImportCS#getReferredNamespace <em>Referred Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Namespace</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ImportCS#getReferredNamespace()
	 * @see #getImportCS()
	 * @generated
	 */
	EReference getImportCS_ReferredNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.ImportCS#isIsAll <em>Is All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is All</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ImportCS#isIsAll()
	 * @see #getImportCS()
	 * @generated
	 */
	EAttribute getImportCS_IsAll();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS <em>Lambda Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS
	 * @generated
	 */
	EClass getLambdaTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getName()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EAttribute getLambdaTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Context Type</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedContextType()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedContextType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedParameterTypes <em>Owned Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameter Types</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedParameterTypes()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedParameterTypes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result Type</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedResultType()
	 * @see #getLambdaTypeCS()
	 * @generated
	 */
	EReference getLambdaTypeCS_OwnedResultType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementCS
	 * @generated
	 */
	EClass getModelElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotations</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementCS#getOwnedAnnotations()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EReference getModelElementCS_OwnedAnnotations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Xmi Id</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementCS#getOriginalXmiId()
	 * @see #getModelElementCS()
	 * @generated
	 */
	EAttribute getModelElementCS_OriginalXmiId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ModelElementRefCS <em>Model Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementRefCS
	 * @generated
	 */
	EClass getModelElementRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.ModelElementRefCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementRefCS#getOwnedPathName()
	 * @see #getModelElementRefCS()
	 * @generated
	 */
	EReference getModelElementRefCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.ModelElementRefCS#getReferredElement <em>Referred Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Element</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementRefCS#getReferredElement()
	 * @see #getModelElementRefCS()
	 * @generated
	 */
	EReference getModelElementRefCS_ReferredElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS <em>Multiplicity Bounds CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Bounds CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS
	 * @generated
	 */
	EClass getMultiplicityBoundsCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS#getLowerBound()
	 * @see #getMultiplicityBoundsCS()
	 * @generated
	 */
	EAttribute getMultiplicityBoundsCS_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS#getUpperBound()
	 * @see #getMultiplicityBoundsCS()
	 * @generated
	 */
	EAttribute getMultiplicityBoundsCS_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityCS <em>Multiplicity CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityCS
	 * @generated
	 */
	EClass getMultiplicityCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.MultiplicityCS#isIsNullFree <em>Is Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Null Free</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityCS#isIsNullFree()
	 * @see #getMultiplicityCS()
	 * @generated
	 */
	EAttribute getMultiplicityCS_IsNullFree();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityStringCS <em>Multiplicity String CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity String CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityStringCS
	 * @generated
	 */
	EClass getMultiplicityStringCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.MultiplicityStringCS#getStringBounds <em>String Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Bounds</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityStringCS#getStringBounds()
	 * @see #getMultiplicityStringCS()
	 * @generated
	 */
	EAttribute getMultiplicityStringCS_StringBounds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.NamedElementCS
	 * @generated
	 */
	EClass getNamedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.NamedElementCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.NamedElementCS#getName()
	 * @see #getNamedElementCS()
	 * @generated
	 */
	EAttribute getNamedElementCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.NamespaceCS
	 * @generated
	 */
	EClass getNamespaceCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS
	 * @generated
	 */
	EClass getOperationCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwningClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedParameters()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedExceptions <em>Owned Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Exceptions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedExceptions()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedExceptions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPreconditions <em>Owned Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Preconditions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPreconditions()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedPreconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPostconditions <em>Owned Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Postconditions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPostconditions()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedPostconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedBodyExpressions <em>Owned Body Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Body Expressions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedBodyExpressions()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_OwnedBodyExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.PackageCS#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Classes</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageCS#getOwnedClasses()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_OwnedClasses();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageCS#getNsPrefix()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.PackageCS#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageCS#getNsURI()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_NsURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PackageOwnerCS <em>Package Owner CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Owner CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageOwnerCS
	 * @generated
	 */
	EClass getPackageOwnerCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.PackageOwnerCS#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PackageOwnerCS#getOwnedPackages()
	 * @see #getPackageOwnerCS()
	 * @generated
	 */
	EReference getPackageOwnerCS_OwnedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ParameterCS
	 * @generated
	 */
	EClass getParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation <em>Owning Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Operation</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation()
	 * @see #getParameterCS()
	 * @generated
	 */
	EReference getParameterCS_OwningOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementCS
	 * @generated
	 */
	EClass getPathElementCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getOwningPathName <em>Owning Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementCS#getOwningPathName()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_OwningPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getReferredElement <em>Referred Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Element</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementCS#getReferredElement()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_ReferredElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementCS#getElementType()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PathElementWithURICS <em>Path Element With URICS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element With URICS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementWithURICS
	 * @generated
	 */
	EClass getPathElementWithURICS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.PathElementWithURICS#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementWithURICS#getUri()
	 * @see #getPathElementWithURICS()
	 * @generated
	 */
	EAttribute getPathElementWithURICS_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS
	 * @generated
	 */
	EClass getPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.PathNameCS#getOwnedPathElements <em>Owned Path Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Path Elements</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS#getOwnedPathElements()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_OwnedPathElements();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.PathNameCS#getReferredElement <em>Referred Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Element</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS#getReferredElement()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_ReferredElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.PathNameCS#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS#getContext()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.PathNameCS#getScopeFilter <em>Scope Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope Filter</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS#getScopeFilter()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EAttribute getPathNameCS_ScopeFilter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pivotable Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PivotableElementCS
	 * @generated
	 */
	EClass getPivotableElementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.PivotableElementCS#getPivot <em>Pivot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pivot</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PivotableElementCS#getPivot()
	 * @see #getPivotableElementCS()
	 * @generated
	 */
	EReference getPivotableElementCS_Pivot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS <em>Primitive Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS
	 * @generated
	 */
	EClass getPrimitiveTypeRefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS#getName()
	 * @see #getPrimitiveTypeRefCS()
	 * @generated
	 */
	EAttribute getPrimitiveTypeRefCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ReferenceCS
	 * @generated
	 */
	EClass getReferenceCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.ReferenceCS#getReferredOpposite <em>Referred Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Opposite</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ReferenceCS#getReferredOpposite()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_ReferredOpposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.ReferenceCS#getOwnedImplicitOpposites <em>Owned Implicit Opposites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Implicit Opposites</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ReferenceCS#getOwnedImplicitOpposites()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_OwnedImplicitOpposites();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.xtext.basecs.ReferenceCS#getReferredKeys <em>Referred Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referred Keys</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.ReferenceCS#getReferredKeys()
	 * @see #getReferenceCS()
	 * @generated
	 */
	EReference getReferenceCS_ReferredKeys();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.RootCS
	 * @generated
	 */
	EClass getRootCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.RootCS#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Imports</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.RootCS#getOwnedImports()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedImports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.RootPackageCS <em>Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Package CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.RootPackageCS
	 * @generated
	 */
	EClass getRootPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.SpecificationCS <em>Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.SpecificationCS
	 * @generated
	 */
	EClass getSpecificationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.SpecificationCS#getExprString <em>Expr String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr String</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.SpecificationCS#getExprString()
	 * @see #getSpecificationCS()
	 * @generated
	 */
	EAttribute getSpecificationCS_ExprString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS <em>Structured Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Class CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS
	 * @generated
	 */
	EClass getStructuredClassCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsAbstract()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EAttribute getStructuredClassCS_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsInterface <em>Is Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Interface</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsInterface()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EAttribute getStructuredClassCS_IsInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedSuperTypes <em>Owned Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Super Types</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedSuperTypes()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EReference getStructuredClassCS_OwnedSuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedOperations()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EReference getStructuredClassCS_OwnedOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Properties</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedProperties()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EReference getStructuredClassCS_OwnedProperties();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedMetaclass <em>Owned Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Metaclass</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedMetaclass()
	 * @see #getStructuredClassCS()
	 * @generated
	 */
	EReference getStructuredClassCS_OwnedMetaclass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS
	 * @generated
	 */
	EClass getStructuralFeatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_OwningClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getDefault()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EAttribute getStructuralFeatureCS_Default();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwnedDefaultExpressions <em>Owned Default Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Default Expressions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwnedDefaultExpressions()
	 * @see #getStructuralFeatureCS()
	 * @generated
	 */
	EReference getStructuralFeatureCS_OwnedDefaultExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS <em>Template Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS
	 * @generated
	 */
	EClass getTemplateBindingCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Multiplicity</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedMultiplicity()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwnedMultiplicity();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwningElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedSubstitutions <em>Owned Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Substitutions</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedSubstitutions()
	 * @see #getTemplateBindingCS()
	 * @generated
	 */
	EReference getTemplateBindingCS_OwnedSubstitutions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS <em>Template Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterCS
	 * @generated
	 */
	EClass getTemplateParameterCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature <em>Owning Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Signature</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature()
	 * @see #getTemplateParameterCS()
	 * @generated
	 */
	EReference getTemplateParameterCS_OwningSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS <em>Template Parameter Substitution CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS
	 * @generated
	 */
	EClass getTemplateParameterSubstitutionCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding <em>Owning Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Binding</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwningBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Actual Parameter</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter()
	 * @see #getTemplateParameterSubstitutionCS()
	 * @generated
	 */
	EReference getTemplateParameterSubstitutionCS_OwnedActualParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS <em>Template Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateSignatureCS
	 * @generated
	 */
	EClass getTemplateSignatureCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwningElement()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwningElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwnedParameters()
	 * @see #getTemplateSignatureCS()
	 * @generated
	 */
	EReference getTemplateSignatureCS_OwnedParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateableElementCS
	 * @generated
	 */
	EClass getTemplateableElementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TemplateableElementCS#getOwnedSignature <em>Owned Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Signature</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateableElementCS#getOwnedSignature()
	 * @see #getTemplateableElementCS()
	 * @generated
	 */
	EReference getTemplateableElementCS_OwnedSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TuplePartCS <em>Tuple Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Part CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TuplePartCS
	 * @generated
	 */
	EClass getTuplePartCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TupleTypeCS
	 * @generated
	 */
	EClass getTupleTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.TupleTypeCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TupleTypeCS#getName()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EAttribute getTupleTypeCS_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.TupleTypeCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TupleTypeCS#getOwnedParts()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EReference getTupleTypeCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypeCS
	 * @generated
	 */
	EClass getTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypeParameterCS
	 * @generated
	 */
	EClass getTypeParameterCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS#getOwnedExtends <em>Owned Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extends</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypeParameterCS#getOwnedExtends()
	 * @see #getTypeParameterCS()
	 * @generated
	 */
	EReference getTypeParameterCS_OwnedExtends();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypeRefCS
	 * @generated
	 */
	EClass getTypeRefCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS
	 * @generated
	 */
	EClass getTypedElementCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS#getOwnedType()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EReference getTypedElementCS_OwnedType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS#getQualifiers()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_Qualifiers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOptional <em>Is Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Optional</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOptional()
	 * @see #getTypedElementCS()
	 * @generated
	 */
	EAttribute getTypedElementCS_IsOptional();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedRefCS
	 * @generated
	 */
	EClass getTypedRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TypedRefCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Multiplicity</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedRefCS#getOwnedMultiplicity()
	 * @see #getTypedRefCS()
	 * @generated
	 */
	EReference getTypedRefCS_OwnedMultiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Type Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS
	 * @generated
	 */
	EClass getTypedTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedPathName()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getReferredType()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_ReferredType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding <em>Owned Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Binding</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EReference getTypedTypeRefCS_OwnedBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#isIsTypeof <em>Is Typeof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Typeof</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#isIsTypeof()
	 * @see #getTypedTypeRefCS()
	 * @generated
	 */
	EAttribute getTypedTypeRefCS_IsTypeof();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.util.VisitableCS
	 * @model instanceClass="org.eclipse.ocl.xtext.basecs.util.VisitableCS"
	 * @generated
	 */
	EClass getVisitableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type Ref CS</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS
	 * @generated
	 */
	EClass getWildcardTypeRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedExtends <em>Owned Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Extends</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedExtends()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_OwnedExtends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedSuper <em>Owned Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Super</em>'.
	 * @see org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS#getOwnedSuper()
	 * @see #getWildcardTypeRefCS()
	 * @generated
	 */
	EReference getWildcardTypeRefCS_OwnedSuper();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Big Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Big Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getBigNumber();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.xtext.base.utilities.CSI <em>CSI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSI</em>'.
	 * @see org.eclipse.ocl.xtext.base.utilities.CSI
	 * @model instanceClass="org.eclipse.ocl.xtext.base.utilities.CSI" serializeable="false"
	 * @generated
	 */
	EDataType getCSI();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.internal.scoping.ScopeFilter <em>Scope Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Scope Filter</em>'.
	 * @see org.eclipse.ocl.pivot.internal.scoping.ScopeFilter
	 * @model instanceClass="org.eclipse.ocl.pivot.internal.scoping.ScopeFilter"
	 * @generated
	 */
	EDataType getScopeFilter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseCSFactory getBaseCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.AnnotationCSImpl <em>Annotation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.AnnotationCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAnnotationCS()
		 * @generated
		 */
		EClass ANNOTATION_CS = eINSTANCE.getAnnotationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__OWNED_CONTENTS = eINSTANCE.getAnnotationCS_OwnedContents();

		/**
		 * The meta object literal for the '<em><b>Owned References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_CS__OWNED_REFERENCES = eINSTANCE.getAnnotationCS_OwnedReferences();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.AnnotationElementCSImpl <em>Annotation Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.AnnotationElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAnnotationElementCS()
		 * @generated
		 */
		EClass ANNOTATION_ELEMENT_CS = eINSTANCE.getAnnotationElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_ELEMENT_CS__OWNED_DETAILS = eINSTANCE.getAnnotationElementCS_OwnedDetails();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl <em>Attribute CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getAttributeCS()
		 * @generated
		 */
		EClass ATTRIBUTE_CS = eINSTANCE.getAttributeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNING_PACKAGE = eINSTANCE.getClassCS_OwningPackage();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_CS__INSTANCE_CLASS_NAME = eINSTANCE.getClassCS_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Owned Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OWNED_CONSTRAINTS = eINSTANCE.getClassCS_OwnedConstraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getConstraintCS()
		 * @generated
		 */
		EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_CS__STEREOTYPE = eINSTANCE.getConstraintCS_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__OWNED_SPECIFICATION = eINSTANCE.getConstraintCS_OwnedSpecification();

		/**
		 * The meta object literal for the '<em><b>Owned Message Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__OWNED_MESSAGE_SPECIFICATION = eINSTANCE.getConstraintCS_OwnedMessageSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl <em>Context Less Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getContextLessElementCS()
		 * @generated
		 */
		EClass CONTEXT_LESS_ELEMENT_CS = eINSTANCE.getContextLessElementCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl <em>Data Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDataTypeCS()
		 * @generated
		 */
		EClass DATA_TYPE_CS = eINSTANCE.getDataTypeCS();

		/**
		 * The meta object literal for the '<em><b>Is Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_CS__IS_PRIMITIVE = eINSTANCE.getDataTypeCS_IsPrimitive();

		/**
		 * The meta object literal for the '<em><b>Is Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_CS__IS_SERIALIZABLE = eINSTANCE.getDataTypeCS_IsSerializable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.DetailCSImpl <em>Detail CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.DetailCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDetailCS()
		 * @generated
		 */
		EClass DETAIL_CS = eINSTANCE.getDetailCS();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL_CS__VALUES = eINSTANCE.getDetailCS_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.DocumentationCSImpl <em>Documentation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.DocumentationCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getDocumentationCS()
		 * @generated
		 */
		EClass DOCUMENTATION_CS = eINSTANCE.getDocumentationCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION_CS__VALUE = eINSTANCE.getDocumentationCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl <em>Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getElementCS()
		 * @generated
		 */
		EClass ELEMENT_CS = eINSTANCE.getElementCS();

		/**
		 * The meta object literal for the '<em><b>Csi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_CS__CSI = eINSTANCE.getElementCS_Csi();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_CS__PARENT = eINSTANCE.getElementCS_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ElementRefCSImpl <em>Element Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ElementRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getElementRefCS()
		 * @generated
		 */
		EClass ELEMENT_REF_CS = eINSTANCE.getElementRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.EnumerationCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getEnumerationCS()
		 * @generated
		 */
		EClass ENUMERATION_CS = eINSTANCE.getEnumerationCS();

		/**
		 * The meta object literal for the '<em><b>Is Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_CS__IS_SERIALIZABLE = eINSTANCE.getEnumerationCS_IsSerializable();

		/**
		 * The meta object literal for the '<em><b>Owned Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_CS__OWNED_LITERALS = eINSTANCE.getEnumerationCS_OwnedLiterals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.EnumerationLiteralCSImpl <em>Enumeration Literal CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.EnumerationLiteralCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getEnumerationLiteralCS()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_CS = eINSTANCE.getEnumerationLiteralCS();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL_CS__LITERAL = eINSTANCE.getEnumerationLiteralCS_Literal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL_CS__VALUE = eINSTANCE.getEnumerationLiteralCS_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.FeatureCSImpl <em>Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.FeatureCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getFeatureCS()
		 * @generated
		 */
		EClass FEATURE_CS = eINSTANCE.getFeatureCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ImplicitOppositeCSImpl <em>Implicit Opposite CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ImplicitOppositeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getImplicitOppositeCS()
		 * @generated
		 */
		EClass IMPLICIT_OPPOSITE_CS = eINSTANCE.getImplicitOppositeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ImportCSImpl <em>Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ImportCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getImportCS()
		 * @generated
		 */
		EClass IMPORT_CS = eINSTANCE.getImportCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__OWNED_PATH_NAME = eINSTANCE.getImportCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Referred Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_CS__REFERRED_NAMESPACE = eINSTANCE.getImportCS_ReferredNamespace();

		/**
		 * The meta object literal for the '<em><b>Is All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_CS__IS_ALL = eINSTANCE.getImportCS_IsAll();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.LambdaTypeCSImpl <em>Lambda Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.LambdaTypeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getLambdaTypeCS()
		 * @generated
		 */
		EClass LAMBDA_TYPE_CS = eINSTANCE.getLambdaTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAMBDA_TYPE_CS__NAME = eINSTANCE.getLambdaTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Context Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_CONTEXT_TYPE = eINSTANCE.getLambdaTypeCS_OwnedContextType();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_PARAMETER_TYPES = eINSTANCE.getLambdaTypeCS_OwnedParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Owned Result Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE_CS__OWNED_RESULT_TYPE = eINSTANCE.getLambdaTypeCS_OwnedResultType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl <em>Model Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getModelElementCS()
		 * @generated
		 */
		EClass MODEL_ELEMENT_CS = eINSTANCE.getModelElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_CS__OWNED_ANNOTATIONS = eINSTANCE.getModelElementCS_OwnedAnnotations();

		/**
		 * The meta object literal for the '<em><b>Original Xmi Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_CS__ORIGINAL_XMI_ID = eINSTANCE.getModelElementCS_OriginalXmiId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ModelElementRefCSImpl <em>Model Element Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ModelElementRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getModelElementRefCS()
		 * @generated
		 */
		EClass MODEL_ELEMENT_REF_CS = eINSTANCE.getModelElementRefCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REF_CS__OWNED_PATH_NAME = eINSTANCE.getModelElementRefCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Referred Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REF_CS__REFERRED_ELEMENT = eINSTANCE.getModelElementRefCS_ReferredElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityBoundsCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityBoundsCS()
		 * @generated
		 */
		EClass MULTIPLICITY_BOUNDS_CS = eINSTANCE.getMultiplicityBoundsCS();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_BOUNDS_CS__LOWER_BOUND = eINSTANCE.getMultiplicityBoundsCS_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_BOUNDS_CS__UPPER_BOUND = eINSTANCE.getMultiplicityBoundsCS_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityCS()
		 * @generated
		 */
		EClass MULTIPLICITY_CS = eINSTANCE.getMultiplicityCS();

		/**
		 * The meta object literal for the '<em><b>Is Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_CS__IS_NULL_FREE = eINSTANCE.getMultiplicityCS_IsNullFree();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.MultiplicityStringCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getMultiplicityStringCS()
		 * @generated
		 */
		EClass MULTIPLICITY_STRING_CS = eINSTANCE.getMultiplicityStringCS();

		/**
		 * The meta object literal for the '<em><b>String Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY_STRING_CS__STRING_BOUNDS = eINSTANCE.getMultiplicityStringCS_StringBounds();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getNamedElementCS()
		 * @generated
		 */
		EClass NAMED_ELEMENT_CS = eINSTANCE.getNamedElementCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT_CS__NAME = eINSTANCE.getNamedElementCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.NamespaceCSImpl <em>Namespace CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.NamespaceCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getNamespaceCS()
		 * @generated
		 */
		EClass NAMESPACE_CS = eINSTANCE.getNamespaceCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl <em>Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getOperationCS()
		 * @generated
		 */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNING_CLASS = eINSTANCE.getOperationCS_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_PARAMETERS = eINSTANCE.getOperationCS_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_EXCEPTIONS = eINSTANCE.getOperationCS_OwnedExceptions();

		/**
		 * The meta object literal for the '<em><b>Owned Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_PRECONDITIONS = eINSTANCE.getOperationCS_OwnedPreconditions();

		/**
		 * The meta object literal for the '<em><b>Owned Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_POSTCONDITIONS = eINSTANCE.getOperationCS_OwnedPostconditions();

		/**
		 * The meta object literal for the '<em><b>Owned Body Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__OWNED_BODY_EXPRESSIONS = eINSTANCE.getOperationCS_OwnedBodyExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PackageCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPackageCS()
		 * @generated
		 */
		EClass PACKAGE_CS = eINSTANCE.getPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__OWNED_CLASSES = eINSTANCE.getPackageCS_OwnedClasses();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_PREFIX = eINSTANCE.getPackageCS_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NS_URI = eINSTANCE.getPackageCS_NsURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PackageOwnerCSImpl <em>Package Owner CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PackageOwnerCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPackageOwnerCS()
		 * @generated
		 */
		EClass PACKAGE_OWNER_CS = eINSTANCE.getPackageOwnerCS();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_OWNER_CS__OWNED_PACKAGES = eINSTANCE.getPackageOwnerCS_OwnedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ParameterCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getParameterCS()
		 * @generated
		 */
		EClass PARAMETER_CS = eINSTANCE.getParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owning Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_CS__OWNING_OPERATION = eINSTANCE.getParameterCS_OwningOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PathElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathElementCS()
		 * @generated
		 */
		EClass PATH_ELEMENT_CS = eINSTANCE.getPathElementCS();

		/**
		 * The meta object literal for the '<em><b>Owning Path Name</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__OWNING_PATH_NAME = eINSTANCE.getPathElementCS_OwningPathName();

		/**
		 * The meta object literal for the '<em><b>Referred Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__REFERRED_ELEMENT = eINSTANCE.getPathElementCS_ReferredElement();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__ELEMENT_TYPE = eINSTANCE.getPathElementCS_ElementType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathElementWithURICSImpl <em>Path Element With URICS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PathElementWithURICSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathElementWithURICS()
		 * @generated
		 */
		EClass PATH_ELEMENT_WITH_URICS = eINSTANCE.getPathElementWithURICS();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_ELEMENT_WITH_URICS__URI = eINSTANCE.getPathElementWithURICS_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPathNameCS()
		 * @generated
		 */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__OWNED_PATH_ELEMENTS = eINSTANCE.getPathNameCS_OwnedPathElements();

		/**
		 * The meta object literal for the '<em><b>Referred Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__REFERRED_ELEMENT = eINSTANCE.getPathNameCS_ReferredElement();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__CONTEXT = eINSTANCE.getPathNameCS_Context();

		/**
		 * The meta object literal for the '<em><b>Scope Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_NAME_CS__SCOPE_FILTER = eINSTANCE.getPathNameCS_ScopeFilter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PivotableElementCSImpl <em>Pivotable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PivotableElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPivotableElementCS()
		 * @generated
		 */
		EClass PIVOTABLE_ELEMENT_CS = eINSTANCE.getPivotableElementCS();

		/**
		 * The meta object literal for the '<em><b>Pivot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIVOTABLE_ELEMENT_CS__PIVOT = eINSTANCE.getPivotableElementCS_Pivot();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.PrimitiveTypeRefCSImpl <em>Primitive Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.PrimitiveTypeRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getPrimitiveTypeRefCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_REF_CS = eINSTANCE.getPrimitiveTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_REF_CS__NAME = eINSTANCE.getPrimitiveTypeRefCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl <em>Reference CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getReferenceCS()
		 * @generated
		 */
		EClass REFERENCE_CS = eINSTANCE.getReferenceCS();

		/**
		 * The meta object literal for the '<em><b>Referred Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__REFERRED_OPPOSITE = eINSTANCE.getReferenceCS_ReferredOpposite();

		/**
		 * The meta object literal for the '<em><b>Owned Implicit Opposites</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__OWNED_IMPLICIT_OPPOSITES = eINSTANCE.getReferenceCS_OwnedImplicitOpposites();

		/**
		 * The meta object literal for the '<em><b>Referred Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CS__REFERRED_KEYS = eINSTANCE.getReferenceCS_ReferredKeys();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.RootCSImpl <em>Root CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.RootCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getRootCS()
		 * @generated
		 */
		EClass ROOT_CS = eINSTANCE.getRootCS();

		/**
		 * The meta object literal for the '<em><b>Owned Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_IMPORTS = eINSTANCE.getRootCS_OwnedImports();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl <em>Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getRootPackageCS()
		 * @generated
		 */
		EClass ROOT_PACKAGE_CS = eINSTANCE.getRootPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.SpecificationCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getSpecificationCS()
		 * @generated
		 */
		EClass SPECIFICATION_CS = eINSTANCE.getSpecificationCS();

		/**
		 * The meta object literal for the '<em><b>Expr String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION_CS__EXPR_STRING = eINSTANCE.getSpecificationCS_ExprString();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl <em>Structured Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getStructuredClassCS()
		 * @generated
		 */
		EClass STRUCTURED_CLASS_CS = eINSTANCE.getStructuredClassCS();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURED_CLASS_CS__IS_ABSTRACT = eINSTANCE.getStructuredClassCS_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURED_CLASS_CS__IS_INTERFACE = eINSTANCE.getStructuredClassCS_IsInterface();

		/**
		 * The meta object literal for the '<em><b>Owned Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES = eINSTANCE.getStructuredClassCS_OwnedSuperTypes();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_CLASS_CS__OWNED_OPERATIONS = eINSTANCE.getStructuredClassCS_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Owned Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_CLASS_CS__OWNED_PROPERTIES = eINSTANCE.getStructuredClassCS_OwnedProperties();

		/**
		 * The meta object literal for the '<em><b>Owned Metaclass</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_CLASS_CS__OWNED_METACLASS = eINSTANCE.getStructuredClassCS_OwnedMetaclass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl <em>Structural Feature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.StructuralFeatureCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getStructuralFeatureCS()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_CS = eINSTANCE.getStructuralFeatureCS();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__OWNING_CLASS = eINSTANCE.getStructuralFeatureCS_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_FEATURE_CS__DEFAULT = eINSTANCE.getStructuralFeatureCS_Default();

		/**
		 * The meta object literal for the '<em><b>Owned Default Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS = eINSTANCE.getStructuralFeatureCS_OwnedDefaultExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl <em>Template Binding CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateBindingCS()
		 * @generated
		 */
		EClass TEMPLATE_BINDING_CS = eINSTANCE.getTemplateBindingCS();

		/**
		 * The meta object literal for the '<em><b>Owned Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY = eINSTANCE.getTemplateBindingCS_OwnedMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNING_ELEMENT = eINSTANCE.getTemplateBindingCS_OwningElement();

		/**
		 * The meta object literal for the '<em><b>Owned Substitutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS = eINSTANCE.getTemplateBindingCS_OwnedSubstitutions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterCSImpl <em>Template Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateParameterCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateParameterCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_CS = eINSTANCE.getTemplateParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owning Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_CS__OWNING_SIGNATURE = eINSTANCE.getTemplateParameterCS_OwningSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl <em>Template Parameter Substitution CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateParameterSubstitutionCS()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION_CS = eINSTANCE.getTemplateParameterSubstitutionCS();

		/**
		 * The meta object literal for the '<em><b>Owning Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_BINDING = eINSTANCE.getTemplateParameterSubstitutionCS_OwningBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Actual Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER = eINSTANCE.getTemplateParameterSubstitutionCS_OwnedActualParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateSignatureCSImpl <em>Template Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateSignatureCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateSignatureCS()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE_CS = eINSTANCE.getTemplateSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNING_ELEMENT = eINSTANCE.getTemplateSignatureCS_OwningElement();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS = eINSTANCE.getTemplateSignatureCS_OwnedParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TemplateableElementCSImpl <em>Templateable Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TemplateableElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTemplateableElementCS()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT_CS = eINSTANCE.getTemplateableElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE = eINSTANCE.getTemplateableElementCS_OwnedSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TuplePartCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTuplePartCS()
		 * @generated
		 */
		EClass TUPLE_PART_CS = eINSTANCE.getTuplePartCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TupleTypeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTupleTypeCS()
		 * @generated
		 */
		EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUPLE_TYPE_CS__NAME = eINSTANCE.getTupleTypeCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_CS__OWNED_PARTS = eINSTANCE.getTupleTypeCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeCSImpl <em>Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypeCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeCS()
		 * @generated
		 */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl <em>Type Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypeParameterCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeParameterCS()
		 * @generated
		 */
		EClass TYPE_PARAMETER_CS = eINSTANCE.getTypeParameterCS();

		/**
		 * The meta object literal for the '<em><b>Owned Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PARAMETER_CS__OWNED_EXTENDS = eINSTANCE.getTypeParameterCS_OwnedExtends();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypeRefCSImpl <em>Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypeRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypeRefCS()
		 * @generated
		 */
		EClass TYPE_REF_CS = eINSTANCE.getTypeRefCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl <em>Typed Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedElementCS()
		 * @generated
		 */
		EClass TYPED_ELEMENT_CS = eINSTANCE.getTypedElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_CS__OWNED_TYPE = eINSTANCE.getTypedElementCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__QUALIFIERS = eINSTANCE.getTypedElementCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Is Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_CS__IS_OPTIONAL = eINSTANCE.getTypedElementCS_IsOptional();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedRefCS()
		 * @generated
		 */
		EClass TYPED_REF_CS = eINSTANCE.getTypedRefCS();

		/**
		 * The meta object literal for the '<em><b>Owned Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_REF_CS__OWNED_MULTIPLICITY = eINSTANCE.getTypedRefCS_OwnedMultiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.TypedTypeRefCSImpl <em>Typed Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.TypedTypeRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getTypedTypeRefCS()
		 * @generated
		 */
		EClass TYPED_TYPE_REF_CS = eINSTANCE.getTypedTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__OWNED_PATH_NAME = eINSTANCE.getTypedTypeRefCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__REFERRED_TYPE = eINSTANCE.getTypedTypeRefCS_ReferredType();

		/**
		 * The meta object literal for the '<em><b>Owned Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TYPE_REF_CS__OWNED_BINDING = eINSTANCE.getTypedTypeRefCS_OwnedBinding();

		/**
		 * The meta object literal for the '<em><b>Is Typeof</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_TYPE_REF_CS__IS_TYPEOF = eINSTANCE.getTypedTypeRefCS_IsTypeof();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.util.VisitableCS <em>Visitable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.util.VisitableCS
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getVisitableCS()
		 * @generated
		 */
		EClass VISITABLE_CS = eINSTANCE.getVisitableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.basecs.impl.WildcardTypeRefCSImpl <em>Wildcard Type Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.basecs.impl.WildcardTypeRefCSImpl
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getWildcardTypeRefCS()
		 * @generated
		 */
		EClass WILDCARD_TYPE_REF_CS = eINSTANCE.getWildcardTypeRefCS();

		/**
		 * The meta object literal for the '<em><b>Owned Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__OWNED_EXTENDS = eINSTANCE.getWildcardTypeRefCS_OwnedExtends();

		/**
		 * The meta object literal for the '<em><b>Owned Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE_REF_CS__OWNED_SUPER = eINSTANCE.getWildcardTypeRefCS_OwnedSuper();

		/**
		 * The meta object literal for the '<em>Big Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getBigNumber()
		 * @generated
		 */
		EDataType BIG_NUMBER = eINSTANCE.getBigNumber();

		/**
		 * The meta object literal for the '<em>CSI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.base.utilities.CSI
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getCSI()
		 * @generated
		 */
		EDataType CSI = eINSTANCE.getCSI();

		/**
		 * The meta object literal for the '<em>Scope Filter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.scoping.ScopeFilter
		 * @see org.eclipse.ocl.xtext.basecs.impl.BaseCSPackageImpl#getScopeFilter()
		 * @generated
		 */
		EDataType SCOPE_FILTER = eINSTANCE.getScopeFilter();

	}

} //BaseCSPackage
