/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.AnnotationElementCS;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ElementRefCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.FeatureCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LambdaTypeCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementRefCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage
 * @generated
 */
public class BaseCSValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final BaseCSValidator INSTANCE = new BaseCSValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.xtext.basecs"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return BaseCSPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case BaseCSPackage.ANNOTATION_CS:
				return validateAnnotationCS((AnnotationCS)value, diagnostics, context);
			case BaseCSPackage.ANNOTATION_ELEMENT_CS:
				return validateAnnotationElementCS((AnnotationElementCS)value, diagnostics, context);
			case BaseCSPackage.ATTRIBUTE_CS:
				return validateAttributeCS((AttributeCS)value, diagnostics, context);
			case BaseCSPackage.CLASS_CS:
				return validateClassCS((ClassCS)value, diagnostics, context);
			case BaseCSPackage.CONSTRAINT_CS:
				return validateConstraintCS((ConstraintCS)value, diagnostics, context);
			case BaseCSPackage.CONTEXT_LESS_ELEMENT_CS:
				return validateContextLessElementCS((ContextLessElementCS)value, diagnostics, context);
			case BaseCSPackage.DATA_TYPE_CS:
				return validateDataTypeCS((DataTypeCS)value, diagnostics, context);
			case BaseCSPackage.DETAIL_CS:
				return validateDetailCS((DetailCS)value, diagnostics, context);
			case BaseCSPackage.DOCUMENTATION_CS:
				return validateDocumentationCS((DocumentationCS)value, diagnostics, context);
			case BaseCSPackage.ELEMENT_CS:
				return validateElementCS((ElementCS)value, diagnostics, context);
			case BaseCSPackage.ELEMENT_REF_CS:
				return validateElementRefCS((ElementRefCS)value, diagnostics, context);
			case BaseCSPackage.ENUMERATION_CS:
				return validateEnumerationCS((EnumerationCS)value, diagnostics, context);
			case BaseCSPackage.ENUMERATION_LITERAL_CS:
				return validateEnumerationLiteralCS((EnumerationLiteralCS)value, diagnostics, context);
			case BaseCSPackage.FEATURE_CS:
				return validateFeatureCS((FeatureCS)value, diagnostics, context);
			case BaseCSPackage.IMPORT_CS:
				return validateImportCS((ImportCS)value, diagnostics, context);
			case BaseCSPackage.LAMBDA_TYPE_CS:
				return validateLambdaTypeCS((LambdaTypeCS)value, diagnostics, context);
			case BaseCSPackage.MODEL_ELEMENT_CS:
				return validateModelElementCS((ModelElementCS)value, diagnostics, context);
			case BaseCSPackage.MODEL_ELEMENT_REF_CS:
				return validateModelElementRefCS((ModelElementRefCS)value, diagnostics, context);
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				return validateMultiplicityBoundsCS((MultiplicityBoundsCS)value, diagnostics, context);
			case BaseCSPackage.MULTIPLICITY_CS:
				return validateMultiplicityCS((MultiplicityCS)value, diagnostics, context);
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				return validateMultiplicityStringCS((MultiplicityStringCS)value, diagnostics, context);
			case BaseCSPackage.NAMED_ELEMENT_CS:
				return validateNamedElementCS((NamedElementCS)value, diagnostics, context);
			case BaseCSPackage.NAMESPACE_CS:
				return validateNamespaceCS((NamespaceCS)value, diagnostics, context);
			case BaseCSPackage.OPERATION_CS:
				return validateOperationCS((OperationCS)value, diagnostics, context);
			case BaseCSPackage.PACKAGE_CS:
				return validatePackageCS((PackageCS)value, diagnostics, context);
			case BaseCSPackage.PACKAGE_OWNER_CS:
				return validatePackageOwnerCS((PackageOwnerCS)value, diagnostics, context);
			case BaseCSPackage.PARAMETER_CS:
				return validateParameterCS((ParameterCS)value, diagnostics, context);
			case BaseCSPackage.PATH_ELEMENT_CS:
				return validatePathElementCS((PathElementCS)value, diagnostics, context);
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				return validatePathElementWithURICS((PathElementWithURICS)value, diagnostics, context);
			case BaseCSPackage.PATH_NAME_CS:
				return validatePathNameCS((PathNameCS)value, diagnostics, context);
			case BaseCSPackage.PIVOTABLE_ELEMENT_CS:
				return validatePivotableElementCS((PivotableElementCS)value, diagnostics, context);
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				return validatePrimitiveTypeRefCS((PrimitiveTypeRefCS)value, diagnostics, context);
			case BaseCSPackage.REFERENCE_CS:
				return validateReferenceCS((ReferenceCS)value, diagnostics, context);
			case BaseCSPackage.ROOT_CS:
				return validateRootCS((RootCS)value, diagnostics, context);
			case BaseCSPackage.ROOT_PACKAGE_CS:
				return validateRootPackageCS((RootPackageCS)value, diagnostics, context);
			case BaseCSPackage.SPECIFICATION_CS:
				return validateSpecificationCS((SpecificationCS)value, diagnostics, context);
			case BaseCSPackage.STRUCTURAL_FEATURE_CS:
				return validateStructuralFeatureCS((StructuralFeatureCS)value, diagnostics, context);
			case BaseCSPackage.STRUCTURED_CLASS_CS:
				return validateStructuredClassCS((StructuredClassCS)value, diagnostics, context);
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				return validateTemplateBindingCS((TemplateBindingCS)value, diagnostics, context);
			case BaseCSPackage.TEMPLATE_PARAMETER_CS:
				return validateTemplateParameterCS((TemplateParameterCS)value, diagnostics, context);
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				return validateTemplateParameterSubstitutionCS((TemplateParameterSubstitutionCS)value, diagnostics, context);
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				return validateTemplateSignatureCS((TemplateSignatureCS)value, diagnostics, context);
			case BaseCSPackage.TEMPLATEABLE_ELEMENT_CS:
				return validateTemplateableElementCS((TemplateableElementCS)value, diagnostics, context);
			case BaseCSPackage.TUPLE_PART_CS:
				return validateTuplePartCS((TuplePartCS)value, diagnostics, context);
			case BaseCSPackage.TUPLE_TYPE_CS:
				return validateTupleTypeCS((TupleTypeCS)value, diagnostics, context);
			case BaseCSPackage.TYPE_CS:
				return validateTypeCS((TypeCS)value, diagnostics, context);
			case BaseCSPackage.TYPE_PARAMETER_CS:
				return validateTypeParameterCS((TypeParameterCS)value, diagnostics, context);
			case BaseCSPackage.TYPE_REF_CS:
				return validateTypeRefCS((TypeRefCS)value, diagnostics, context);
			case BaseCSPackage.TYPED_ELEMENT_CS:
				return validateTypedElementCS((TypedElementCS)value, diagnostics, context);
			case BaseCSPackage.TYPED_REF_CS:
				return validateTypedRefCS((TypedRefCS)value, diagnostics, context);
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				return validateTypedTypeRefCS((TypedTypeRefCS)value, diagnostics, context);
			case BaseCSPackage.VISITABLE_CS:
				return validateVisitableCS((VisitableCS)value, diagnostics, context);
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				return validateWildcardTypeRefCS((WildcardTypeRefCS)value, diagnostics, context);
			case BaseCSPackage.BIG_NUMBER:
				return validateBigNumber((Number)value, diagnostics, context);
			case BaseCSPackage.SCOPE_FILTER:
				return validateScopeFilter((ScopeFilter)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationCS(AnnotationCS annotationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(annotationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotationElementCS(AnnotationElementCS annotationElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(annotationElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeCS(AttributeCS attributeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(attributeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassCS(ClassCS classCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(classCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraintCS(ConstraintCS constraintCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(constraintCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContextLessElementCS(ContextLessElementCS contextLessElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(contextLessElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeCS(DataTypeCS dataTypeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dataTypeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetailCS(DetailCS detailCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(detailCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentationCS(DocumentationCS documentationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(documentationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementCS(ElementCS elementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(elementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementRefCS(ElementRefCS elementRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(elementRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationCS(EnumerationCS enumerationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumerationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteralCS(EnumerationLiteralCS enumerationLiteralCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumerationLiteralCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCS(FeatureCS featureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(featureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportCS(ImportCS importCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(importCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLambdaTypeCS(LambdaTypeCS lambdaTypeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(lambdaTypeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementCS(ModelElementCS modelElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(modelElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementRefCS(ModelElementRefCS modelElementRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(modelElementRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityBoundsCS(MultiplicityBoundsCS multiplicityBoundsCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(multiplicityBoundsCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityCS(MultiplicityCS multiplicityCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(multiplicityCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityStringCS(MultiplicityStringCS multiplicityStringCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(multiplicityStringCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElementCS(NamedElementCS namedElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(namedElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespaceCS(NamespaceCS namespaceCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(namespaceCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCS(OperationCS operationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(operationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageCS(PackageCS packageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(packageCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageOwnerCS(PackageOwnerCS packageOwnerCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(packageOwnerCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterCS(ParameterCS parameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(parameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePathElementCS(PathElementCS pathElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(pathElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePathElementWithURICS(PathElementWithURICS pathElementWithURICS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(pathElementWithURICS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePathNameCS(PathNameCS pathNameCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(pathNameCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePivotableElementCS(PivotableElementCS pivotableElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(pivotableElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveTypeRefCS(PrimitiveTypeRefCS primitiveTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(primitiveTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReferenceCS(ReferenceCS referenceCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(referenceCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootCS(RootCS rootCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(rootCS, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rootCS, diagnostics, context);
		if (result || diagnostics != null) result &= validateRootCS_TestConstraint(rootCS, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the TestConstraint constraint of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROOT_CS__TEST_CONSTRAINT__EEXPRESSION = "true"; //$NON-NLS-1$

	/**
	 * Validates the TestConstraint constraint of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootCS_TestConstraint(RootCS rootCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(BaseCSPackage.Literals.ROOT_CS,
				 rootCS,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
				 "TestConstraint", //$NON-NLS-1$
				 ROOT_CS__TEST_CONSTRAINT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRootPackageCS(RootPackageCS rootPackageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(rootPackageCS, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rootPackageCS, diagnostics, context);
		if (result || diagnostics != null) result &= validateRootCS_TestConstraint(rootPackageCS, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecificationCS(SpecificationCS specificationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(specificationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredClassCS(StructuredClassCS structuredClassCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(structuredClassCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureCS(StructuralFeatureCS structuralFeatureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(structuralFeatureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBindingCS(TemplateBindingCS templateBindingCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateBindingCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterCS(TemplateParameterCS templateParameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateParameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS templateParameterSubstitutionCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateParameterSubstitutionCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignatureCS(TemplateSignatureCS templateSignatureCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateSignatureCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElementCS(TemplateableElementCS templateableElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(templateableElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTuplePartCS(TuplePartCS tuplePartCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(tuplePartCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleTypeCS(TupleTypeCS tupleTypeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(tupleTypeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeCS(TypeCS typeCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeParameterCS(TypeParameterCS typeParameterCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeParameterCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeRefCS(TypeRefCS typeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementCS(TypedElementCS typedElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedRefCS(TypedRefCS typedRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedTypeRefCS(TypedTypeRefCS typedTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(typedTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitableCS(VisitableCS visitableCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)visitableCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWildcardTypeRefCS(WildcardTypeRefCS wildcardTypeRefCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(wildcardTypeRefCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBigNumber(Number bigNumber, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScopeFilter(ScopeFilter scopeFilter, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	@Override
	public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		// don't check, we have our own implementation, which creates nicer messages
		return true;
	}
} //BaseCSValidator
