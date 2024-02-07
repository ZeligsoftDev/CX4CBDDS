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

package org.eclipse.ocl.xtext.basecs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage
 * @generated
 */
public class BaseCSAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BaseCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = BaseCSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseCSSwitch<@Nullable Adapter> modelSwitch =
		new BaseCSSwitch<@Nullable Adapter>()
		{
			@Override
			public Adapter caseAnnotationCS(AnnotationCS object)
			{
				return createAnnotationCSAdapter();
			}
			@Override
			public Adapter caseAnnotationElementCS(AnnotationElementCS object)
			{
				return createAnnotationElementCSAdapter();
			}
			@Override
			public Adapter caseAttributeCS(AttributeCS object)
			{
				return createAttributeCSAdapter();
			}
			@Override
			public Adapter caseClassCS(ClassCS object)
			{
				return createClassCSAdapter();
			}
			@Override
			public Adapter caseConstraintCS(ConstraintCS object)
			{
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter caseContextLessElementCS(ContextLessElementCS object)
			{
				return createContextLessElementCSAdapter();
			}
			@Override
			public Adapter caseDataTypeCS(DataTypeCS object)
			{
				return createDataTypeCSAdapter();
			}
			@Override
			public Adapter caseDetailCS(DetailCS object)
			{
				return createDetailCSAdapter();
			}
			@Override
			public Adapter caseDocumentationCS(DocumentationCS object)
			{
				return createDocumentationCSAdapter();
			}
			@Override
			public Adapter caseElementCS(ElementCS object)
			{
				return createElementCSAdapter();
			}
			@Override
			public Adapter caseElementRefCS(ElementRefCS object)
			{
				return createElementRefCSAdapter();
			}
			@Override
			public Adapter caseEnumerationCS(EnumerationCS object)
			{
				return createEnumerationCSAdapter();
			}
			@Override
			public Adapter caseEnumerationLiteralCS(EnumerationLiteralCS object)
			{
				return createEnumerationLiteralCSAdapter();
			}
			@Override
			public Adapter caseFeatureCS(FeatureCS object)
			{
				return createFeatureCSAdapter();
			}
			@Override
			public Adapter caseImplicitOppositeCS(ImplicitOppositeCS object)
			{
				return createImplicitOppositeCSAdapter();
			}
			@Override
			public Adapter caseImportCS(ImportCS object)
			{
				return createImportCSAdapter();
			}
			@Override
			public Adapter caseLambdaTypeCS(LambdaTypeCS object)
			{
				return createLambdaTypeCSAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object)
			{
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter caseModelElementRefCS(ModelElementRefCS object)
			{
				return createModelElementRefCSAdapter();
			}
			@Override
			public Adapter caseMultiplicityBoundsCS(MultiplicityBoundsCS object)
			{
				return createMultiplicityBoundsCSAdapter();
			}
			@Override
			public Adapter caseMultiplicityCS(MultiplicityCS object)
			{
				return createMultiplicityCSAdapter();
			}
			@Override
			public Adapter caseMultiplicityStringCS(MultiplicityStringCS object)
			{
				return createMultiplicityStringCSAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object)
			{
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseNamespaceCS(NamespaceCS object)
			{
				return createNamespaceCSAdapter();
			}
			@Override
			public Adapter caseOperationCS(OperationCS object)
			{
				return createOperationCSAdapter();
			}
			@Override
			public Adapter casePackageCS(PackageCS object)
			{
				return createPackageCSAdapter();
			}
			@Override
			public Adapter casePackageOwnerCS(PackageOwnerCS object)
			{
				return createPackageOwnerCSAdapter();
			}
			@Override
			public Adapter caseParameterCS(ParameterCS object)
			{
				return createParameterCSAdapter();
			}
			@Override
			public Adapter casePathElementCS(PathElementCS object)
			{
				return createPathElementCSAdapter();
			}
			@Override
			public Adapter casePathElementWithURICS(PathElementWithURICS object)
			{
				return createPathElementWithURICSAdapter();
			}
			@Override
			public Adapter casePathNameCS(PathNameCS object)
			{
				return createPathNameCSAdapter();
			}
			@Override
			public Adapter casePivotableElementCS(PivotableElementCS object)
			{
				return createPivotableElementCSAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeRefCS(PrimitiveTypeRefCS object)
			{
				return createPrimitiveTypeRefCSAdapter();
			}
			@Override
			public Adapter caseReferenceCS(ReferenceCS object)
			{
				return createReferenceCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object)
			{
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseRootPackageCS(RootPackageCS object)
			{
				return createRootPackageCSAdapter();
			}
			@Override
			public Adapter caseSpecificationCS(SpecificationCS object)
			{
				return createSpecificationCSAdapter();
			}
			@Override
			public Adapter caseStructuralFeatureCS(StructuralFeatureCS object)
			{
				return createStructuralFeatureCSAdapter();
			}
			@Override
			public Adapter caseStructuredClassCS(StructuredClassCS object)
			{
				return createStructuredClassCSAdapter();
			}
			@Override
			public Adapter caseTemplateBindingCS(TemplateBindingCS object)
			{
				return createTemplateBindingCSAdapter();
			}
			@Override
			public Adapter caseTemplateParameterCS(TemplateParameterCS object)
			{
				return createTemplateParameterCSAdapter();
			}
			@Override
			public Adapter caseTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS object)
			{
				return createTemplateParameterSubstitutionCSAdapter();
			}
			@Override
			public Adapter caseTemplateSignatureCS(TemplateSignatureCS object)
			{
				return createTemplateSignatureCSAdapter();
			}
			@Override
			public Adapter caseTemplateableElementCS(TemplateableElementCS object)
			{
				return createTemplateableElementCSAdapter();
			}
			@Override
			public Adapter caseTuplePartCS(TuplePartCS object)
			{
				return createTuplePartCSAdapter();
			}
			@Override
			public Adapter caseTupleTypeCS(TupleTypeCS object)
			{
				return createTupleTypeCSAdapter();
			}
			@Override
			public Adapter caseTypeCS(TypeCS object)
			{
				return createTypeCSAdapter();
			}
			@Override
			public Adapter caseTypeParameterCS(TypeParameterCS object)
			{
				return createTypeParameterCSAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object)
			{
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedElementCS(TypedElementCS object)
			{
				return createTypedElementCSAdapter();
			}
			@Override
			public Adapter caseTypedRefCS(TypedRefCS object)
			{
				return createTypedRefCSAdapter();
			}
			@Override
			public Adapter caseTypedTypeRefCS(TypedTypeRefCS object)
			{
				return createTypedTypeRefCSAdapter();
			}
			@Override
			public Adapter caseVisitableCS(VisitableCS object)
			{
				return createVisitableCSAdapter();
			}
			@Override
			public Adapter caseWildcardTypeRefCS(WildcardTypeRefCS object)
			{
				return createWildcardTypeRefCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationCS
	 * @generated
	 */
	public Adapter createAnnotationCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.AnnotationElementCS
	 * @generated
	 */
	public Adapter createAnnotationElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.AttributeCS
	 * @generated
	 */
	public Adapter createAttributeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ClassCS
	 * @generated
	 */
	public Adapter createClassCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ConstraintCS
	 * @generated
	 */
	public Adapter createConstraintCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ContextLessElementCS <em>Context Less Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ContextLessElementCS
	 * @generated
	 */
	public Adapter createContextLessElementCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.DataTypeCS
	 * @generated
	 */
	public Adapter createDataTypeCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.DetailCS
	 * @generated
	 */
	public Adapter createDetailCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.DocumentationCS
	 * @generated
	 */
	public Adapter createDocumentationCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ElementCS
	 * @generated
	 */
	public Adapter createElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ElementRefCS
	 * @generated
	 */
	public Adapter createElementRefCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.EnumerationCS <em>Enumeration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationCS
	 * @generated
	 */
	public Adapter createEnumerationCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS <em>Enumeration Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS
	 * @generated
	 */
	public Adapter createEnumerationLiteralCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.FeatureCS <em>Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.FeatureCS
	 * @generated
	 */
	public Adapter createFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS <em>Implicit Opposite CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS
	 * @generated
	 */
	public Adapter createImplicitOppositeCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS <em>Lambda Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.LambdaTypeCS
	 * @generated
	 */
	public Adapter createLambdaTypeCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementCS
	 * @generated
	 */
	public Adapter createModelElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ModelElementRefCS <em>Model Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ModelElementRefCS
	 * @generated
	 */
	public Adapter createModelElementRefCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS <em>Multiplicity Bounds CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS
	 * @generated
	 */
	public Adapter createMultiplicityBoundsCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityCS <em>Multiplicity CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityCS
	 * @generated
	 */
	public Adapter createMultiplicityCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.MultiplicityStringCS <em>Multiplicity String CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.MultiplicityStringCS
	 * @generated
	 */
	public Adapter createMultiplicityStringCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.NamedElementCS
	 * @generated
	 */
	public Adapter createNamedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.NamespaceCS
	 * @generated
	 */
	public Adapter createNamespaceCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS
	 * @generated
	 */
	public Adapter createOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PackageCS
	 * @generated
	 */
	public Adapter createPackageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PackageOwnerCS <em>Package Owner CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PackageOwnerCS
	 * @generated
	 */
	public Adapter createPackageOwnerCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ParameterCS
	 * @generated
	 */
	public Adapter createParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementCS
	 * @generated
	 */
	public Adapter createPathElementCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PathElementWithURICS <em>Path Element With URICS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PathElementWithURICS
	 * @generated
	 */
	public Adapter createPathElementWithURICSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS
	 * @generated
	 */
	public Adapter createPathNameCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PivotableElementCS
	 * @generated
	 */
	public Adapter createPivotableElementCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS <em>Primitive Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS
	 * @generated
	 */
	public Adapter createPrimitiveTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.ReferenceCS
	 * @generated
	 */
	public Adapter createReferenceCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.RootPackageCS <em>Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.RootPackageCS
	 * @generated
	 */
	public Adapter createRootPackageCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.SpecificationCS <em>Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.SpecificationCS
	 * @generated
	 */
	public Adapter createSpecificationCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS <em>Structured Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS
	 * @generated
	 */
	public Adapter createStructuredClassCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS
	 * @generated
	 */
	public Adapter createStructuralFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS <em>Template Binding CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS
	 * @generated
	 */
	public Adapter createTemplateBindingCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS <em>Template Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterCS
	 * @generated
	 */
	public Adapter createTemplateParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS <em>Template Parameter Substitution CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS
	 * @generated
	 */
	public Adapter createTemplateParameterSubstitutionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS <em>Template Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateSignatureCS
	 * @generated
	 */
	public Adapter createTemplateSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TemplateableElementCS
	 * @generated
	 */
	public Adapter createTemplateableElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TuplePartCS <em>Tuple Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TuplePartCS
	 * @generated
	 */
	public Adapter createTuplePartCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TupleTypeCS
	 * @generated
	 */
	public Adapter createTupleTypeCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypeCS
	 * @generated
	 */
	public Adapter createTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypeParameterCS
	 * @generated
	 */
	public Adapter createTypeParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypedElementCS
	 * @generated
	 */
	public Adapter createTypedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypedRefCS
	 * @generated
	 */
	public Adapter createTypedRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS
	 * @generated
	 */
	public Adapter createTypedTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.util.VisitableCS
	 * @generated
	 */
	public Adapter createVisitableCSAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS
	 * @generated
	 */
	public Adapter createWildcardTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BaseCSAdapterFactory
