/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.PivotFactory
 * @generated
 */
public interface PivotPackage
extends EPackage
{

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "pivot"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/ocl/2015/Pivot"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "pivot"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.ocl.oclas"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull PivotPackage eINSTANCE = org.eclipse.ocl.pivot.internal.PivotPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.eclipse.ocl.pivot.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Annotation#getOwnedContents <em>Owned Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Contents</em>'.
	 * @see org.eclipse.ocl.pivot.Annotation#getOwnedContents()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedContents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Annotation#getOwnedDetails <em>Owned Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Details</em>'.
	 * @see org.eclipse.ocl.pivot.Annotation#getOwnedDetails()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_OwnedDetails();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Annotation#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see org.eclipse.ocl.pivot.Annotation#getReferences()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_References();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.ocl.pivot.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.pivot.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.ocl.pivot.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Element#getAnnotatingComments <em>Annotating Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotating Comments</em>'.
	 * @see org.eclipse.ocl.pivot.Element#getAnnotatingComments()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_AnnotatingComments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Element#getOwnedAnnotations <em>Owned Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Annotations</em>'.
	 * @see org.eclipse.ocl.pivot.Element#getOwnedAnnotations()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedAnnotations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Element#getOwnedComments <em>Owned Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Comments</em>'.
	 * @see org.eclipse.ocl.pivot.Element#getOwnedComments()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedComments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Element#getOwnedExtensions <em>Owned Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extensions</em>'.
	 * @see org.eclipse.ocl.pivot.Element#getOwnedExtensions()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OwnedExtensions();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Element#allOwnedElements() <em>All Owned Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Owned Elements</em>' operation.
	 * @see org.eclipse.ocl.pivot.Element#allOwnedElements()
	 * @generated
	 */
	EOperation getElement__AllOwnedElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Element#getValue(org.eclipse.ocl.pivot.Type, java.lang.String) <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see org.eclipse.ocl.pivot.Element#getValue(org.eclipse.ocl.pivot.Type, java.lang.String)
	 * @generated
	 */
	EOperation getElement__GetValue__Type_String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ElementExtension <em>Element Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Extension</em>'.
	 * @see org.eclipse.ocl.pivot.ElementExtension
	 * @generated
	 */
	EClass getElementExtension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.ElementExtension#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.pivot.ElementExtension#getStereotype()
	 * @see #getElementExtension()
	 * @generated
	 */
	EReference getElementExtension_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ElementLiteralExp <em>Element Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.ElementLiteralExp
	 * @generated
	 */
	EClass getElementLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.ElementLiteralExp#getReferredElement <em>Referred Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Element</em>'.
	 * @see org.eclipse.ocl.pivot.ElementLiteralExp#getReferredElement()
	 * @see #getElementLiteralExp()
	 * @generated
	 */
	EAttribute getElementLiteralExp_ReferredElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.ElementExtension#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Base</em>'.
	 * @see org.eclipse.ocl.pivot.ElementExtension#getBase()
	 * @see #getElementExtension()
	 * @generated
	 */
	EReference getElementExtension_Base();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.ElementExtension#isIsApplied <em>Is Applied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Applied</em>'.
	 * @see org.eclipse.ocl.pivot.ElementExtension#isIsApplied()
	 * @see #getElementExtension()
	 * @generated
	 */
	EAttribute getElementExtension_IsApplied();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.ElementExtension#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.pivot.ElementExtension#isIsRequired()
	 * @see #getElementExtension()
	 * @generated
	 */
	EAttribute getElementExtension_IsRequired();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.ocl.pivot.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.ocl.pivot.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Behavior#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transition</em>'.
	 * @see org.eclipse.ocl.pivot.Behavior#getOwningTransition()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_OwningTransition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.CollectionType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CollectionType#isIsNullFree <em>Is Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Null Free</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionType#isIsNullFree()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_IsNullFree();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CollectionType#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionType#getLower()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CollectionType#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionType#getUpper()
	 * @see #getCollectionType()
	 * @generated
	 */
	EAttribute getCollectionType_Upper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.ocl.pivot.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.DataType#getBehavioralClass <em>Behavioral Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavioral Class</em>'.
	 * @see org.eclipse.ocl.pivot.DataType#getBehavioralClass()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_BehavioralClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.DataType#isIsSerializable <em>Is Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Serializable</em>'.
	 * @see org.eclipse.ocl.pivot.DataType#isIsSerializable()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_IsSerializable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.DataType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.pivot.DataType#getValue()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.DataType#validateBehavioralClassHasDistinctName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Behavioral Class Has Distinct Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Behavioral Class Has Distinct Name</em>' operation.
	 * @see org.eclipse.ocl.pivot.DataType#validateBehavioralClassHasDistinctName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataType__ValidateBehavioralClassHasDistinctName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.DataType#validateBehavioralClassIsPrimitiveType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Behavioral Class Is Primitive Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Behavioral Class Is Primitive Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.DataType#validateBehavioralClassIsPrimitiveType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataType__ValidateBehavioralClassIsPrimitiveType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.DataType#validateBehavioralClassIsSuperClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Behavioral Class Is Super Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Behavioral Class Is Super Class</em>' operation.
	 * @see org.eclipse.ocl.pivot.DataType#validateBehavioralClassIsSuperClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataType__ValidateBehavioralClassIsSuperClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.eclipse.ocl.pivot.BooleanLiteralExp#isBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.BooleanLiteralExp#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.pivot.BooleanLiteralExp#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBooleanLiteralExp__ValidateTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.ocl.pivot.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.PrimitiveLiteralExp
	 * @generated
	 */
	EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CallOperationAction <em>Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Operation Action</em>'.
	 * @see org.eclipse.ocl.pivot.CallOperationAction
	 * @generated
	 */
	EClass getCallOperationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.CallOperationAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.pivot.CallOperationAction#getOperation()
	 * @see #getCallOperationAction()
	 * @generated
	 */
	EReference getCallOperationAction_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CollectionItem#getOwnedItem <em>Owned Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Item</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionItem#getOwnedItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
	EReference getCollectionItem_OwnedItem();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionItem#validateTypeIsItemType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Item Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Item Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionItem#validateTypeIsItemType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionItem__ValidateTypeIsItemType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#getOwnedParts()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_OwnedParts();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#validateCollectionKindIsConcrete(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collection Kind Is Concrete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collection Kind Is Concrete</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#validateCollectionKindIsConcrete(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateCollectionKindIsConcrete__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#validateSetKindIsSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Set Kind Is Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Set Kind Is Set</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#validateSetKindIsSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateSetKindIsSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#validateOrderedSetKindIsOrderedSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Ordered Set Kind Is Ordered Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Ordered Set Kind Is Ordered Set</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#validateOrderedSetKindIsOrderedSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateOrderedSetKindIsOrderedSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#validateSequenceKindIsSequence(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sequence Kind Is Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sequence Kind Is Sequence</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#validateSequenceKindIsSequence(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateSequenceKindIsSequence__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CollectionLiteralExp#validateBagKindIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Bag Kind Is Bag</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Bag Kind Is Bag</em>' operation.
	 * @see org.eclipse.ocl.pivot.CollectionLiteralExp#validateBagKindIsBag(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollectionLiteralExp__ValidateBagKindIsBag__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedFirst <em>Owned First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned First</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionRange#getOwnedFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_OwnedFirst();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CollectionRange#getOwnedLast <em>Owned Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Last</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionRange#getOwnedLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_OwnedLast();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.EnumLiteralExp#getReferredLiteral <em>Referred Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Literal</em>'.
	 * @see org.eclipse.ocl.pivot.EnumLiteralExp#getReferredLiteral()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_ReferredLiteral();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.EnumLiteralExp#validateTypeIsEnumerationType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Enumeration Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Enumeration Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.EnumLiteralExp#validateTypeIsEnumerationType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getEnumLiteralExp__ValidateTypeIsEnumerationType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.ocl.pivot.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.EnumerationLiteral#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.eclipse.ocl.pivot.EnumerationLiteral#getLiteral()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Literal();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.EnumerationLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Enumeration</em>'.
	 * @see org.eclipse.ocl.pivot.EnumerationLiteral#getOwningEnumeration()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_OwningEnumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.EnumerationLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.pivot.EnumerationLiteral#getValue()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In OCL</em>'.
	 * @see org.eclipse.ocl.pivot.ExpressionInOCL
	 * @generated
	 */
	EClass getExpressionInOCL();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedBody()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedBody();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedContext <em>Owned Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Context</em>'.
	 * @see org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedContext()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedParameters()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedResult <em>Owned Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result</em>'.
	 * @see org.eclipse.ocl.pivot.ExpressionInOCL#getOwnedResult()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipse.ocl.pivot.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Enumeration#getOwnedLiterals <em>Owned Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literals</em>'.
	 * @see org.eclipse.ocl.pivot.Enumeration#getOwnedLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_OwnedLiterals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.ocl.pivot.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Feature#getImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class</em>'.
	 * @see org.eclipse.ocl.pivot.Feature#getImplementationClass()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ImplementationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Feature#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.pivot.Feature#isIsStatic()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IsStatic();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Feature#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.Feature#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFeature__ValidateNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Feature#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.Feature#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFeature__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Feature#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.Feature#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFeature__ValidateTypeIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Feature#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.pivot.Feature#getImplementation()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.ocl.pivot.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Variable#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.pivot.Variable#isIsImplicit()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_IsImplicit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Parameter</em>'.
	 * @see org.eclipse.ocl.pivot.Variable#getRepresentedParameter()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_RepresentedParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Variable#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Initialiser Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.Variable#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariable__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Variable#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.ocl.pivot.Variable#getOwnedInit()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_OwnedInit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp</em>'.
	 * @see org.eclipse.ocl.pivot.IfExp
	 * @generated
	 */
	EClass getIfExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.IfExp#isIsElseIf <em>Is Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Else If</em>'.
	 * @see org.eclipse.ocl.pivot.IfExp#isIsElseIf()
	 * @see #getIfExp()
	 * @generated
	 */
	EAttribute getIfExp_IsElseIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.IfExp#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.ocl.pivot.IfExp#getOwnedCondition()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.IfExp#getOwnedElse <em>Owned Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Else</em>'.
	 * @see org.eclipse.ocl.pivot.IfExp#getOwnedElse()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_OwnedElse();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.IfExp#getOwnedThen <em>Owned Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Then</em>'.
	 * @see org.eclipse.ocl.pivot.IfExp#getOwnedThen()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_OwnedThen();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IfExp#validateConditionTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Condition Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Condition Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.pivot.IfExp#validateConditionTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIfExp__ValidateConditionTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IfExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.IfExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIfExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.ocl.pivot.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Import#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Namespace</em>'.
	 * @see org.eclipse.ocl.pivot.Import#getImportedNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ImportedNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Import#getXmiidVersion <em>Xmiid Version</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmiid Version</em>'.
	 * @see org.eclipse.ocl.pivot.Import#getXmiidVersion()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_XmiidVersion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.InstanceSpecification <em>Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Specification</em>'.
	 * @see org.eclipse.ocl.pivot.InstanceSpecification
	 * @generated
	 */
	EClass getInstanceSpecification();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.InstanceSpecification#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Classes</em>'.
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getClasses()
	 * @see #getInstanceSpecification()
	 * @generated
	 */
	EReference getInstanceSpecification_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSlots <em>Owned Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Slots</em>'.
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSlots()
	 * @see #getInstanceSpecification()
	 * @generated
	 */
	EReference getInstanceSpecification_OwnedSlots();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSpecification()
	 * @see #getInstanceSpecification()
	 * @generated
	 */
	EReference getInstanceSpecification_OwnedSpecification();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage()
	 * @see #getInstanceSpecification()
	 * @generated
	 */
	EReference getInstanceSpecification_OwningPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.ocl.pivot.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IntegerLiteralExp#validateTypeIsInteger(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Integer</em>' operation.
	 * @see org.eclipse.ocl.pivot.IntegerLiteralExp#validateTypeIsInteger(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIntegerLiteralExp__ValidateTypeIsInteger__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.NumericLiteralExp
	 * @generated
	 */
	EClass getNumericLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Expression</em>'.
	 * @see org.eclipse.ocl.pivot.OCLExpression
	 * @generated
	 */
	EClass getOCLExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.OCLExpression#getTypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Value</em>'.
	 * @see org.eclipse.ocl.pivot.OCLExpression#getTypeValue()
	 * @see #getOCLExpression()
	 * @generated
	 */
	EReference getOCLExpression_TypeValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OCLExpression#isNonNull() <em>Is Non Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Non Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OCLExpression#isNonNull()
	 * @generated
	 */
	EOperation getOCLExpression__IsNonNull();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OCLExpression#isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OCLExpression#isNull()
	 * @generated
	 */
	EOperation getOCLExpression__IsNull();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OCLExpression#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OCLExpression#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOCLExpression__ValidateTypeIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.InvalidLiteralExp
	 * @generated
	 */
	EClass getInvalidLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.InvalidType <em>Invalid Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Type</em>'.
	 * @see org.eclipse.ocl.pivot.InvalidType
	 * @generated
	 */
	EClass getInvalidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IterableType <em>Iterable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterable Type</em>'.
	 * @see org.eclipse.ocl.pivot.IterableType
	 * @generated
	 */
	EClass getIterableType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.eclipse.ocl.pivot.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.IterateExp#getOwnedResult <em>Owned Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result</em>'.
	 * @see org.eclipse.ocl.pivot.IterateExp#getOwnedResult()
	 * @see #getIterateExp()
	 * @generated
	 */
	EReference getIterateExp_OwnedResult();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateTypeIsResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Result Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateTypeIsResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateTypeIsResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unsafe Source Can Not Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unsafe Source Can Not Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateBodyTypeConformsToResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Body Type Conforms To Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Body Type Conforms To Result Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateBodyTypeConformsToResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateBodyTypeConformsToResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateOneInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateOneInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateOneInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateSafeIteratorIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Iterator Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Iterator Is Required</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateSafeIteratorIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateSafeIteratorIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IterateExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.IterateExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIterateExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see org.eclipse.ocl.pivot.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Iteration#getOwnedAccumulators <em>Owned Accumulators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulators</em>'.
	 * @see org.eclipse.ocl.pivot.Iteration#getOwnedAccumulators()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedAccumulators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Iteration#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterators</em>'.
	 * @see org.eclipse.ocl.pivot.Iteration#getOwnedIterators()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_OwnedIterators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.eclipse.ocl.pivot.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureBodyTypeIsConformanttoIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Body Type Is Conformantto Iterator Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Body Type Is Conformantto Iterator Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureBodyTypeIsConformanttoIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureBodyTypeIsConformanttoIteratorType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateSortedByIteratorTypeIsComparable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Iterator Type Is Comparable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Iterator Type Is Comparable</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateSortedByIteratorTypeIsComparable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByIteratorTypeIsComparable__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unsafe Source Can Not Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unsafe Source Can Not Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.IteratorVariable <em>Iterator Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Variable</em>'.
	 * @see org.eclipse.ocl.pivot.IteratorVariable
	 * @generated
	 */
	EClass getIteratorVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorVariable#validateHasNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has No Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Has No Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorVariable#validateHasNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorVariable__ValidateHasNoInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateAnyHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateAnyHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateAnyTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateAnyTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureBodyElementTypeIsIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Body Element Type Is Iterator Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Body Element Type Is Iterator Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureBodyElementTypeIsIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureBodyElementTypeIsIteratorType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateAnyBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Any Body Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Any Body Type Is Boolean</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateAnyBodyTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateAnyBodyTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Has One Iterator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Has One Iterator</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureHasOneIterator(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureHasOneIterator__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureResultElementTypeIsIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Result Element Type Is Iterator Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Result Element Type Is Iterator Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureResultElementTypeIsIteratorType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureResultElementTypeIsIteratorType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureTypeIsUniqueCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Type Is Unique Collection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Type Is Unique Collection</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureTypeIsUniqueCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureTypeIsUniqueCollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateCollectElementTypeIsFlattenedBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Element Type Is Flattened Body Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Element Type Is Flattened Body Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateCollectElementTypeIsFlattenedBodyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectElementTypeIsFlattenedBodyType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureSourceElementTypeIsBodyElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Source Element Type Is Body Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Source Element Type Is Body Element Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureSourceElementTypeIsBodyElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureSourceElementTypeIsBodyElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateClosureElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Closure Element Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Closure Element Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateClosureElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateClosureElementTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateCollectTypeIsUnordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Collect Type Is Unordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Collect Type Is Unordered</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateCollectTypeIsUnordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateCollectTypeIsUnordered__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateSortedByIsOrderedIfSourceIsOrdered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Is Ordered If Source Is Ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Is Ordered If Source Is Ordered</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateSortedByIsOrderedIfSourceIsOrdered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByIsOrderedIfSourceIsOrdered__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateSortedByElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sorted By Element Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Sorted By Element Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateSortedByElementTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSortedByElementTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateIteratorTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Iterator Type Is Source Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Iterator Type Is Source Element Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateIteratorTypeIsSourceElementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateIteratorTypeIsSourceElementType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateIteratorTypeIsSourceKeyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Iterator Type Is Source Key Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Iterator Type Is Source Key Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateIteratorTypeIsSourceKeyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateIteratorTypeIsSourceKeyType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateSafeIteratorIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Iterator Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Iterator Is Required</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateSafeIteratorIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSafeIteratorIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.IteratorExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.IteratorExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getIteratorExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LambdaType <em>Lambda Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lambda Type</em>'.
	 * @see org.eclipse.ocl.pivot.LambdaType
	 * @generated
	 */
	EClass getLambdaType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.LambdaType#getContextType <em>Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Type</em>'.
	 * @see org.eclipse.ocl.pivot.LambdaType#getContextType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ContextType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.LambdaType#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Type</em>'.
	 * @see org.eclipse.ocl.pivot.LambdaType#getParameterType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ParameterType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.LambdaType#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Type</em>'.
	 * @see org.eclipse.ocl.pivot.LambdaType#getResultType()
	 * @see #getLambdaType()
	 * @generated
	 */
	EReference getLambdaType_ResultType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LanguageExpression <em>Language Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Expression</em>'.
	 * @see org.eclipse.ocl.pivot.LanguageExpression
	 * @generated
	 */
	EClass getLanguageExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.LanguageExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.ocl.pivot.LanguageExpression#getBody()
	 * @see #getLanguageExpression()
	 * @generated
	 */
	EAttribute getLanguageExpression_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.LanguageExpression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.ocl.pivot.LanguageExpression#getLanguage()
	 * @see #getLanguageExpression()
	 * @generated
	 */
	EAttribute getLanguageExpression_Language();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint <em>Owning Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Constraint</em>'.
	 * @see org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint()
	 * @see #getLanguageExpression()
	 * @generated
	 */
	EReference getLanguageExpression_OwningConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.eclipse.ocl.pivot.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.LetExp#getOwnedIn <em>Owned In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In</em>'.
	 * @see org.eclipse.ocl.pivot.LetExp#getOwnedIn()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_OwnedIn();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.LetExp#getOwnedVariable <em>Owned Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Variable</em>'.
	 * @see org.eclipse.ocl.pivot.LetExp#getOwnedVariable()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_OwnedVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetExp#validateCompatibleNullityForIn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Nullity For In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Nullity For In</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetExp#validateCompatibleNullityForIn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetExp__ValidateCompatibleNullityForIn__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetExp#validateTypeIsInType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is In Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is In Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetExp#validateTypeIsInType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetExp__ValidateTypeIsInType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LetVariable <em>Let Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Variable</em>'.
	 * @see org.eclipse.ocl.pivot.LetVariable
	 * @generated
	 */
	EClass getLetVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Nullity For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Nullity For Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LetVariable#validateHasInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Has Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.LetVariable#validateHasInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLetVariable__ValidateHasInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.ocl.pivot.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Library#getOwnedPrecedences <em>Owned Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedences</em>'.
	 * @see org.eclipse.ocl.pivot.Library#getOwnedPrecedences()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_OwnedPrecedences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.eclipse.ocl.pivot.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.LoopExp#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.ocl.pivot.LoopExp#getOwnedBody()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_OwnedBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.LoopExp#getOwnedCoIterators <em>Owned Co Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Co Iterators</em>'.
	 * @see org.eclipse.ocl.pivot.LoopExp#getOwnedCoIterators()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_OwnedCoIterators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.LoopExp#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterators</em>'.
	 * @see org.eclipse.ocl.pivot.LoopExp#getOwnedIterators()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_OwnedIterators();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.LoopExp#getReferredIteration <em>Referred Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Iteration</em>'.
	 * @see org.eclipse.ocl.pivot.LoopExp#getReferredIteration()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_ReferredIteration();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateMatchingMapCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Matching Map Co Iterators</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Matching Map Co Iterators</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateMatchingMapCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateMatchingMapCoIterators__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateMatchingOrderedCollectionCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Matching Ordered Collection Co Iterators</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Matching Ordered Collection Co Iterators</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateMatchingOrderedCollectionCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateMatchingOrderedCollectionCoIterators__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateNoCoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Co Initializers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Co Initializers</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateNoCoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateNoCoInitializers__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateSourceIsCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Is Collection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Is Collection</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateSourceIsCollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateSourceIsCollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateSourceIsIterable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Is Iterable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Is Iterable</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateSourceIsIterable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateSourceIsIterable__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.MapLiteralExp <em>Map Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.MapLiteralExp
	 * @generated
	 */
	EClass getMapLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.MapLiteralExp#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.pivot.MapLiteralExp#getOwnedParts()
	 * @see #getMapLiteralExp()
	 * @generated
	 */
	EReference getMapLiteralExp_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.MapLiteralPart <em>Map Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Part</em>'.
	 * @see org.eclipse.ocl.pivot.MapLiteralPart
	 * @generated
	 */
	EClass getMapLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Key</em>'.
	 * @see org.eclipse.ocl.pivot.MapLiteralPart#getOwnedKey()
	 * @see #getMapLiteralPart()
	 * @generated
	 */
	EReference getMapLiteralPart_OwnedKey();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.MapLiteralPart#getOwnedValue <em>Owned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value</em>'.
	 * @see org.eclipse.ocl.pivot.MapLiteralPart#getOwnedValue()
	 * @see #getMapLiteralPart()
	 * @generated
	 */
	EReference getMapLiteralPart_OwnedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.MapType <em>Map Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Type</em>'.
	 * @see org.eclipse.ocl.pivot.MapType
	 * @generated
	 */
	EClass getMapType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.MapType#getEntryClass <em>Entry Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entry Class</em>'.
	 * @see org.eclipse.ocl.pivot.MapType#getEntryClass()
	 * @see #getMapType()
	 * @generated
	 */
	EReference getMapType_EntryClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.MapType#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key Type</em>'.
	 * @see org.eclipse.ocl.pivot.MapType#getKeyType()
	 * @see #getMapType()
	 * @generated
	 */
	EReference getMapType_KeyType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.MapType#isKeysAreNullFree <em>Keys Are Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keys Are Null Free</em>'.
	 * @see org.eclipse.ocl.pivot.MapType#isKeysAreNullFree()
	 * @see #getMapType()
	 * @generated
	 */
	EAttribute getMapType_KeysAreNullFree();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.MapType#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Type</em>'.
	 * @see org.eclipse.ocl.pivot.MapType#getValueType()
	 * @see #getMapType()
	 * @generated
	 */
	EReference getMapType_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.MapType#isValuesAreNullFree <em>Values Are Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values Are Null Free</em>'.
	 * @see org.eclipse.ocl.pivot.MapType#isValuesAreNullFree()
	 * @see #getMapType()
	 * @generated
	 */
	EAttribute getMapType_ValuesAreNullFree();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateNoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Initializers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Initializers</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateNoInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateNoInitializers__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.LoopExp#validateNoNotOrderedCollectionCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Not Ordered Collection Co Iterators</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Not Ordered Collection Co Iterators</em>' operation.
	 * @see org.eclipse.ocl.pivot.LoopExp#validateNoNotOrderedCollectionCoIterators(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLoopExp__ValidateNoNotOrderedCollectionCoIterators__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Exp</em>'.
	 * @see org.eclipse.ocl.pivot.MessageExp
	 * @generated
	 */
	EClass getMessageExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.ocl.pivot.MessageExp#getOwnedArguments()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_OwnedArguments();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedCalledOperation <em>Owned Called Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Called Operation</em>'.
	 * @see org.eclipse.ocl.pivot.MessageExp#getOwnedCalledOperation()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_OwnedCalledOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedSentSignal <em>Owned Sent Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Sent Signal</em>'.
	 * @see org.eclipse.ocl.pivot.MessageExp#getOwnedSentSignal()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_OwnedSentSignal();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.MessageExp#getOwnedTarget <em>Owned Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Target</em>'.
	 * @see org.eclipse.ocl.pivot.MessageExp#getOwnedTarget()
	 * @see #getMessageExp()
	 * @generated
	 */
	EReference getMessageExp_OwnedTarget();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.MessageExp#validateOneCallOrOneSend(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate One Call Or One Send</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate One Call Or One Send</em>' operation.
	 * @see org.eclipse.ocl.pivot.MessageExp#validateOneCallOrOneSend(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageExp__ValidateOneCallOrOneSend__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.MessageExp#validateTargetIsNotACollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Is Not ACollection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Is Not ACollection</em>' operation.
	 * @see org.eclipse.ocl.pivot.MessageExp#validateTargetIsNotACollection(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageExp__ValidateTargetIsNotACollection__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.SendSignalAction <em>Send Signal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Signal Action</em>'.
	 * @see org.eclipse.ocl.pivot.SendSignalAction
	 * @generated
	 */
	EClass getSendSignalAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.SendSignalAction#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see org.eclipse.ocl.pivot.SendSignalAction#getSignal()
	 * @see #getSendSignalAction()
	 * @generated
	 */
	EReference getSendSignalAction_Signal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see org.eclipse.ocl.pivot.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Slot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot</em>'.
	 * @see org.eclipse.ocl.pivot.Slot
	 * @generated
	 */
	EClass getSlot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Slot#getDefiningProperty <em>Defining Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defining Property</em>'.
	 * @see org.eclipse.ocl.pivot.Slot#getDefiningProperty()
	 * @see #getSlot()
	 * @generated
	 */
	EReference getSlot_DefiningProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Slot#getOwnedValues <em>Owned Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Values</em>'.
	 * @see org.eclipse.ocl.pivot.Slot#getOwnedValues()
	 * @see #getSlot()
	 * @generated
	 */
	EReference getSlot_OwnedValues();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Slot#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Instance</em>'.
	 * @see org.eclipse.ocl.pivot.Slot#getOwningInstance()
	 * @see #getSlot()
	 * @generated
	 */
	EReference getSlot_OwningInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.StandardLibrary <em>Standard Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Library</em>'.
	 * @see org.eclipse.ocl.pivot.StandardLibrary
	 * @generated
	 */
	EClass getStandardLibrary();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.StandardLibrary#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Complete Environment</em>'.
	 * @see org.eclipse.ocl.pivot.StandardLibrary#getOwningCompleteEnvironment()
	 * @see #getStandardLibrary()
	 * @generated
	 */
	EReference getStandardLibrary_OwningCompleteEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see org.eclipse.ocl.pivot.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Signal</em>'.
	 * @see org.eclipse.ocl.pivot.MessageType#getReferredSignal()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.ocl.pivot.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Model#getExternalURI <em>External URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External URI</em>'.
	 * @see org.eclipse.ocl.pivot.Model#getExternalURI()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ExternalURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Model#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Imports</em>'.
	 * @see org.eclipse.ocl.pivot.Model#getOwnedImports()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_OwnedImports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Model#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.ocl.pivot.Model#getOwnedPackages()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_OwnedPackages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Model#getXmiidVersion <em>Xmiid Version</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmiid Version</em>'.
	 * @see org.eclipse.ocl.pivot.Model#getXmiidVersion()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_XmiidVersion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.pivot.MessageType#getReferredOperation()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.utilities.MorePivotable <em>More Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>More Pivotable</em>'.
	 * @see org.eclipse.ocl.pivot.utilities.MorePivotable
	 * @generated
	 */
	EClass getMorePivotable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.NullLiteralExp
	 * @generated
	 */
	EClass getNullLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.OperationCallExp#isIsVirtual <em>Is Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Virtual</em>'.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#isIsVirtual()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EAttribute getOperationCallExp_IsVirtual();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.OperationCallExp#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#getOwnedArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_OwnedArguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OperationCallExp#hasOclVoidOverload() <em>Has Ocl Void Overload</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Ocl Void Overload</em>' operation.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#hasOclVoidOverload()
	 * @generated
	 */
	EOperation getOperationCallExp__HasOclVoidOverload();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OperationCallExp#validateArgumentTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Argument Type Is Conformant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Argument Type Is Conformant</em>' operation.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#validateArgumentTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateArgumentTypeIsConformant__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OperationCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OperationCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unsafe Source Can Not Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unsafe Source Can Not Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OperationCallExp#validateArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Argument Count</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Argument Count</em>' operation.
	 * @see org.eclipse.ocl.pivot.OperationCallExp#validateArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperationCallExp__ValidateArgumentCount__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.ocl.pivot.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.OrphanCompletePackage <em>Orphan Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Orphan Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.OrphanCompletePackage
	 * @generated
	 */
	EClass getOrphanCompletePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.ocl.pivot.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.PrimitiveType#getCoercions <em>Coercions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Coercions</em>'.
	 * @see org.eclipse.ocl.pivot.PrimitiveType#getCoercions()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EReference getPrimitiveType_Coercions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Profile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile</em>'.
	 * @see org.eclipse.ocl.pivot.Profile
	 * @generated
	 */
	EClass getProfile();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Profile#getProfileApplications <em>Profile Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Profile Applications</em>'.
	 * @see org.eclipse.ocl.pivot.Profile#getProfileApplications()
	 * @see #getProfile()
	 * @generated
	 */
	EReference getProfile_ProfileApplications();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ProfileApplication <em>Profile Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Application</em>'.
	 * @see org.eclipse.ocl.pivot.ProfileApplication
	 * @generated
	 */
	EClass getProfileApplication();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Applied Profile</em>'.
	 * @see org.eclipse.ocl.pivot.ProfileApplication#getAppliedProfile()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EReference getProfileApplication_AppliedProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.ProfileApplication#isIsStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.ocl.pivot.ProfileApplication#isIsStrict()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EAttribute getProfileApplication_IsStrict();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see org.eclipse.ocl.pivot.ProfileApplication#getOwningPackage()
	 * @see #getProfileApplication()
	 * @generated
	 */
	EReference getProfileApplication_OwningPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#getSpecializedReferredPropertyOwningType() <em>Get Specialized Referred Property Owning Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Specialized Referred Property Owning Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#getSpecializedReferredPropertyOwningType()
	 * @generated
	 */
	EOperation getPropertyCallExp__GetSpecializedReferredPropertyOwningType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#getSpecializedReferredPropertyType() <em>Get Specialized Referred Property Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Specialized Referred Property Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#getSpecializedReferredPropertyType()
	 * @generated
	 */
	EOperation getPropertyCallExp__GetSpecializedReferredPropertyType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#validateNonStaticSourceTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Non Static Source Type Is Conformant</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Non Static Source Type Is Conformant</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#validateNonStaticSourceTypeIsConformant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateNonStaticSourceTypeIsConformant__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unsafe Source Can Not Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unsafe Source Can Not Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.PropertyCallExp#validateCompatibleResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Result Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Result Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.PropertyCallExp#validateCompatibleResultType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyCallExp__ValidateCompatibleResultType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Pseudostate <em>Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudostate</em>'.
	 * @see org.eclipse.ocl.pivot.Pseudostate
	 * @generated
	 */
	EClass getPseudostate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Pseudostate#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.pivot.Pseudostate#getKind()
	 * @see #getPseudostate()
	 * @generated
	 */
	EAttribute getPseudostate_Kind();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Pseudostate#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.pivot.Pseudostate#getOwningState()
	 * @see #getPseudostate()
	 * @generated
	 */
	EReference getPseudostate_OwningState();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Pseudostate#getOwningStateMachine <em>Owning State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State Machine</em>'.
	 * @see org.eclipse.ocl.pivot.Pseudostate#getOwningStateMachine()
	 * @see #getPseudostate()
	 * @generated
	 */
	EReference getPseudostate_OwningStateMachine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.eclipse.ocl.pivot.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ReferringElement <em>Referring Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referring Element</em>'.
	 * @see org.eclipse.ocl.pivot.ReferringElement
	 * @generated
	 */
	EClass getReferringElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ReferringElement#getReferredElement() <em>Get Referred Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Element</em>' operation.
	 * @see org.eclipse.ocl.pivot.ReferringElement#getReferredElement()
	 * @generated
	 */
	EOperation getReferringElement__GetReferredElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.eclipse.ocl.pivot.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Region#getExtendedRegion <em>Extended Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Region</em>'.
	 * @see org.eclipse.ocl.pivot.Region#getExtendedRegion()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_ExtendedRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Region#getOwnedSubvertexes <em>Owned Subvertexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Subvertexes</em>'.
	 * @see org.eclipse.ocl.pivot.Region#getOwnedSubvertexes()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedSubvertexes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Region#getOwnedTransitions <em>Owned Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transitions</em>'.
	 * @see org.eclipse.ocl.pivot.Region#getOwnedTransitions()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedTransitions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Region#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.pivot.Region#getOwningState()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwningState();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Region#getOwningStateMachine <em>Owning State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State Machine</em>'.
	 * @see org.eclipse.ocl.pivot.Region#getOwningStateMachine()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwningStateMachine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ResultVariable <em>Result Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Variable</em>'.
	 * @see org.eclipse.ocl.pivot.ResultVariable
	 * @generated
	 */
	EClass getResultVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ResultVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Nullity For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Nullity For Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ResultVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResultVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ResultVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ResultVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResultVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ResultVariable#validateHasInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Has Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ResultVariable#validateHasInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResultVariable__ValidateHasInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.SelfType <em>Self Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Type</em>'.
	 * @see org.eclipse.ocl.pivot.SelfType
	 * @generated
	 */
	EClass getSelfType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.SelfType#specializeIn(org.eclipse.ocl.pivot.CallExp, org.eclipse.ocl.pivot.Type) <em>Specialize In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Specialize In</em>' operation.
	 * @see org.eclipse.ocl.pivot.SelfType#specializeIn(org.eclipse.ocl.pivot.CallExp, org.eclipse.ocl.pivot.Type)
	 * @generated
	 */
	EOperation getSelfType__SpecializeIn__CallExp_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.ocl.pivot.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.ocl.pivot.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ShadowExp <em>Shadow Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Exp</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowExp
	 * @generated
	 */
	EClass getShadowExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.ShadowExp#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowExp#getOwnedParts()
	 * @see #getShadowExp()
	 * @generated
	 */
	EReference getShadowExp_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.ShadowExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowExp#getValue()
	 * @see #getShadowExp()
	 * @generated
	 */
	EAttribute getShadowExp_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateClassHasNoStringValueInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Class Has No String Value Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Class Has No String Value Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateClassHasNoStringValueInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateClassHasNoStringValueInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasNoPartInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Data Type Has No Part Initializers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Data Type Has No Part Initializers</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasNoPartInitializers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateDataTypeHasNoPartInitializers__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasOnePartInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Data Type Has One Part Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Data Type Has One Part Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasOnePartInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateDataTypeHasOnePartInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasStringValueInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Data Type Has String Value Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Data Type Has String Value Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateDataTypeHasStringValueInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateDataTypeHasStringValueInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateInitializesAllClassProperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Initializes All Class Properties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Initializes All Class Properties</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateInitializesAllClassProperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateInitializesAllClassProperties__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ShadowPart <em>Shadow Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Part</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowPart
	 * @generated
	 */
	EClass getShadowPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.ShadowPart#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowPart#getOwnedInit()
	 * @see #getShadowPart()
	 * @generated
	 */
	EReference getShadowPart_OwnedInit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.ShadowPart#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.pivot.ShadowPart#getReferredProperty()
	 * @see #getShadowPart()
	 * @generated
	 */
	EReference getShadowPart_ReferredProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowPart#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Initialiser Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowPart#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowPart__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ShadowPart#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.ShadowPart#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getShadowPart__ValidateTypeIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.ocl.pivot.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.State#isIsComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.eclipse.ocl.pivot.State#isIsComposite()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.State#isIsOrthogonal <em>Is Orthogonal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Orthogonal</em>'.
	 * @see org.eclipse.ocl.pivot.State#isIsOrthogonal()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsOrthogonal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.State#isIsSimple <em>Is Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Simple</em>'.
	 * @see org.eclipse.ocl.pivot.State#isIsSimple()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsSimple();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.State#isIsSubmachineState <em>Is Submachine State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Submachine State</em>'.
	 * @see org.eclipse.ocl.pivot.State#isIsSubmachineState()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsSubmachineState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.State#getOwnedConnectionPoints <em>Owned Connection Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connection Points</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedConnectionPoints()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedConnectionPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.State#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connections</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedConnections()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.State#getOwnedDeferrableTriggers <em>Owned Deferrable Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Deferrable Triggers</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedDeferrableTriggers()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedDeferrableTriggers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.State#getOwnedDoActivity <em>Owned Do Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Do Activity</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedDoActivity()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedDoActivity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.State#getOwnedEntry <em>Owned Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Entry</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedEntry()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.State#getOwnedExit <em>Owned Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Exit</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedExit()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedExit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.State#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Regions</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedRegions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedRegions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.State#getOwnedStateInvariant <em>Owned State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned State Invariant</em>'.
	 * @see org.eclipse.ocl.pivot.State#getOwnedStateInvariant()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwnedStateInvariant();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.State#getRedefinedState <em>Redefined State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Redefined State</em>'.
	 * @see org.eclipse.ocl.pivot.State#getRedefinedState()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_RedefinedState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.State#getSubmachines <em>Submachines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Submachines</em>'.
	 * @see org.eclipse.ocl.pivot.State#getSubmachines()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Submachines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Exp</em>'.
	 * @see org.eclipse.ocl.pivot.StateExp
	 * @generated
	 */
	EClass getStateExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.StateExp#getReferredState <em>Referred State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred State</em>'.
	 * @see org.eclipse.ocl.pivot.StateExp#getReferredState()
	 * @see #getStateExp()
	 * @generated
	 */
	EReference getStateExp_ReferredState();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.StateExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.StateExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getStateExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see org.eclipse.ocl.pivot.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.StateMachine#getExtendedStateMachines <em>Extended State Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended State Machines</em>'.
	 * @see org.eclipse.ocl.pivot.StateMachine#getExtendedStateMachines()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_ExtendedStateMachines();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.StateMachine#getOwnedConnectionPoints <em>Owned Connection Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connection Points</em>'.
	 * @see org.eclipse.ocl.pivot.StateMachine#getOwnedConnectionPoints()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_OwnedConnectionPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.StateMachine#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Regions</em>'.
	 * @see org.eclipse.ocl.pivot.StateMachine#getOwnedRegions()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_OwnedRegions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.StateMachine#getSubmachineStates <em>Submachine States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Submachine States</em>'.
	 * @see org.eclipse.ocl.pivot.StateMachine#getSubmachineStates()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_SubmachineStates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype</em>'.
	 * @see org.eclipse.ocl.pivot.Stereotype
	 * @generated
	 */
	EClass getStereotype();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Stereotype#getOwnedExtenders <em>Owned Extenders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extenders</em>'.
	 * @see org.eclipse.ocl.pivot.Stereotype#getOwnedExtenders()
	 * @see #getStereotype()
	 * @generated
	 */
	EReference getStereotype_OwnedExtenders();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.StereotypeExtender <em>Stereotype Extender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Extender</em>'.
	 * @see org.eclipse.ocl.pivot.StereotypeExtender
	 * @generated
	 */
	EClass getStereotypeExtender();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.StereotypeExtender#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.eclipse.ocl.pivot.StereotypeExtender#getClass_()
	 * @see #getStereotypeExtender()
	 * @generated
	 */
	EReference getStereotypeExtender_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.StereotypeExtender#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.pivot.StereotypeExtender#isIsRequired()
	 * @see #getStereotypeExtender()
	 * @generated
	 */
	EAttribute getStereotypeExtender_IsRequired();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.StereotypeExtender#getOwningStereotype <em>Owning Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Stereotype</em>'.
	 * @see org.eclipse.ocl.pivot.StereotypeExtender#getOwningStereotype()
	 * @see #getStereotypeExtender()
	 * @generated
	 */
	EReference getStereotypeExtender_OwningStereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.StringLiteralExp#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see org.eclipse.ocl.pivot.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.TupleLiteralExp
	 * @generated
	 */
	EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.TupleLiteralExp#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.pivot.TupleLiteralExp#getOwnedParts()
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	EReference getTupleLiteralExp_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part</em>'.
	 * @see org.eclipse.ocl.pivot.TupleLiteralPart
	 * @generated
	 */
	EClass getTupleLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.TupleLiteralPart#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.ocl.pivot.TupleLiteralPart#getOwnedInit()
	 * @see #getTupleLiteralPart()
	 * @generated
	 */
	EReference getTupleLiteralPart_OwnedInit();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.TupleLiteralPart#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Initialiser Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.TupleLiteralPart#validateCompatibleInitialiserType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTupleLiteralPart__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.TupleLiteralPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.TupleLiteralPart#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTupleLiteralPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.ocl.pivot.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Exp</em>'.
	 * @see org.eclipse.ocl.pivot.TypeExp
	 * @generated
	 */
	EClass getTypeExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TypeExp#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.ocl.pivot.TypeExp#getReferredType()
	 * @see #getTypeExp()
	 * @generated
	 */
	EReference getTypeExp_ReferredType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
	 * @see org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unlimited Natural Symbol</em>'.
	 * @see org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol()
	 * @see #getUnlimitedNaturalLiteralExp()
	 * @generated
	 */
	EAttribute getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.eclipse.ocl.pivot.UnspecifiedValueExp
	 * @generated
	 */
	EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.ocl.pivot.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.VariableExp#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.pivot.VariableExp#isIsImplicit()
	 * @see #getVariableExp()
	 * @generated
	 */
	EAttribute getVariableExp_IsImplicit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.ocl.pivot.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.VariableExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.VariableExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.eclipse.ocl.pivot.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see org.eclipse.ocl.pivot.Vertex#getIncomingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see org.eclipse.ocl.pivot.Vertex#getOutgoingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_OutgoingTransitions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Vertex#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.ocl.pivot.Vertex#getOwningRegion()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_OwningRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.ocl.pivot.util.Visitable
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.ocl.pivot.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.WildcardType <em>Wildcard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Type</em>'.
	 * @see org.eclipse.ocl.pivot.WildcardType
	 * @generated
	 */
	EClass getWildcardType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.WildcardType#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.ocl.pivot.WildcardType#getLowerBound()
	 * @see #getWildcardType()
	 * @generated
	 */
	EReference getWildcardType_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.WildcardType#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.ocl.pivot.WildcardType#getUpperBound()
	 * @see #getWildcardType()
	 * @generated
	 */
	EReference getWildcardType_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.utilities.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pivotable</em>'.
	 * @see org.eclipse.ocl.pivot.utilities.Pivotable
	 * @generated
	 */
	EClass getPivotable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.ocl.pivot.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Class#getExtenders <em>Extenders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extenders</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getExtenders()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Extenders();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Class#getInstanceClassName <em>Instance Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Class Name</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getInstanceClassName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_InstanceClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Class#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.ocl.pivot.Class#isIsAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Class#isIsActive <em>Is Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Active</em>'.
	 * @see org.eclipse.ocl.pivot.Class#isIsActive()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsActive();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Class#getOwnedInvariants <em>Owned Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Invariants</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getOwnedInvariants()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedInvariants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Class#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Properties</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getOwnedProperties()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedProperties();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Class#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getOwningPackage()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwningPackage();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Class#getSuperClasses <em>Super Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Classes</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getSuperClasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SuperClasses();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Class#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.Class#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClass__ValidateNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Class#validateUniqueInvariantName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Invariant Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Invariant Name</em>' operation.
	 * @see org.eclipse.ocl.pivot.Class#validateUniqueInvariantName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getClass__ValidateUniqueInvariantName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Class#isIsInterface <em>Is Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Interface</em>'.
	 * @see org.eclipse.ocl.pivot.Class#isIsInterface()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Class#getOwnedBehaviors <em>Owned Behaviors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Behaviors</em>'.
	 * @see org.eclipse.ocl.pivot.Class#getOwnedBehaviors()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedBehaviors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.ocl.pivot.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Type#flattenedType() <em>Flattened Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Flattened Type</em>' operation.
	 * @see org.eclipse.ocl.pivot.Type#flattenedType()
	 * @generated
	 */
	EOperation getType__FlattenedType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Type#isClass() <em>Is Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Class</em>' operation.
	 * @see org.eclipse.ocl.pivot.Type#isClass()
	 * @generated
	 */
	EOperation getType__IsClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Type#isTemplateParameter() <em>Is Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Template Parameter</em>' operation.
	 * @see org.eclipse.ocl.pivot.Type#isTemplateParameter()
	 * @generated
	 */
	EOperation getType__IsTemplateParameter();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Type#specializeIn(org.eclipse.ocl.pivot.CallExp, org.eclipse.ocl.pivot.Type) <em>Specialize In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Specialize In</em>' operation.
	 * @see org.eclipse.ocl.pivot.Type#specializeIn(org.eclipse.ocl.pivot.CallExp, org.eclipse.ocl.pivot.Type)
	 * @generated
	 */
	EOperation getType__SpecializeIn__CallExp_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TemplateableElement <em>Templateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templateable Element</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateableElement
	 * @generated
	 */
	EClass getTemplateableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.TemplateableElement#getOwnedBindings <em>Owned Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Bindings</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getOwnedBindings()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_OwnedBindings();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.TemplateableElement#getOwnedSignature <em>Owned Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Signature</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getOwnedSignature()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_OwnedSignature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TemplateableElement#getUnspecializedElement <em>Unspecialized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unspecialized Element</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getUnspecializedElement()
	 * @see #getTemplateableElement()
	 * @generated
	 */
	EReference getTemplateableElement_UnspecializedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.ocl.pivot.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Transition#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getKind()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Kind();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Transition#getOwnedEffect <em>Owned Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Effect</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getOwnedEffect()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwnedEffect();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Transition#getOwnedGuard <em>Owned Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Guard</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getOwnedGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwnedGuard();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Transition#getOwnedTriggers <em>Owned Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Triggers</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getOwnedTriggers()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwnedTriggers();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Transition#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getOwningRegion()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwningRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.ocl.pivot.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.eclipse.ocl.pivot.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Trigger#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.pivot.Trigger#getOwningState()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_OwningState();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Trigger#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transition</em>'.
	 * @see org.eclipse.ocl.pivot.Trigger#getOwningTransition()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_OwningTransition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Binding</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateBinding
	 * @generated
	 */
	EClass getTemplateBinding();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.TemplateBinding#getOwnedSubstitutions <em>Owned Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Substitutions</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateBinding#getOwnedSubstitutions()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_OwnedSubstitutions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.TemplateBinding#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateBinding#getOwningElement()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_OwningElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TemplateBinding#getTemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template Signature</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateBinding#getTemplateSignature()
	 * @see #getTemplateBinding()
	 * @generated
	 */
	EReference getTemplateBinding_TemplateSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateSignature
	 * @generated
	 */
	EClass getTemplateSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.TemplateSignature#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateSignature#getOwnedParameters()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_OwnedParameters();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.TemplateSignature#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateSignature#getOwningElement()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_OwningElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameter
	 * @generated
	 */
	EClass getTemplateParameter();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.TemplateParameter#getConstrainingClasses <em>Constraining Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraining Classes</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameter#getConstrainingClasses()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_ConstrainingClasses();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature <em>Owning Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Signature</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature()
	 * @see #getTemplateParameter()
	 * @generated
	 */
	EReference getTemplateParameter_OwningSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution <em>Template Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Substitution</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution
	 * @generated
	 */
	EClass getTemplateParameterSubstitution();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formal</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Formal();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard <em>Owned Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Wildcard</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_OwnedWildcard();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding <em>Owning Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Binding</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_OwningBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual</em>'.
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual()
	 * @see #getTemplateParameterSubstitution()
	 * @generated
	 */
	EReference getTemplateParameterSubstitution_Actual();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.ocl.pivot.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Package#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getURI()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_URI();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Package#getImportedPackages <em>Imported Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imported Packages</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getImportedPackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_ImportedPackages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Package#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getNsPrefix()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Package#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Classes</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getOwnedClasses()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Package#getOwnedInstances <em>Owned Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Instances</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getOwnedInstances()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Package#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getOwnedPackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedPackages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Package#getOwnedProfileApplications <em>Owned Profile Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Profile Applications</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getOwnedProfileApplications()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedProfileApplications();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see org.eclipse.ocl.pivot.Package#getOwningPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwningPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.pivot.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Namespace#getOwnedConstraints <em>Owned Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraints</em>'.
	 * @see org.eclipse.ocl.pivot.Namespace#getOwnedConstraints()
	 * @see #getNamespace()
	 * @generated
	 */
	EReference getNamespace_OwnedConstraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Precedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.pivot.Precedence
	 * @generated
	 */
	EClass getPrecedence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Precedence#getAssociativity <em>Associativity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Associativity</em>'.
	 * @see org.eclipse.ocl.pivot.Precedence#getAssociativity()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Associativity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Precedence#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.eclipse.ocl.pivot.Precedence#getOrder()
	 * @see #getPrecedence()
	 * @generated
	 */
	EAttribute getPrecedence_Order();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.PrimitiveCompletePackage <em>Primitive Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.PrimitiveCompletePackage
	 * @generated
	 */
	EClass getPrimitiveCompletePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.ocl.pivot.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Property#getAssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association Class</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getAssociationClass()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_AssociationClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsReadOnly <em>Is Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Read Only</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsReadOnly()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsComposite <em>Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Composite</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsComposite()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsDerived()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDerived();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Property#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getOpposite()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Opposite();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Property#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getOwnedExpression()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_OwnedExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Property#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getOwningClass()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_OwningClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Property#getRedefinedProperties <em>Redefined Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Properties</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getRedefinedProperties()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_RedefinedProperties();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getDefaultValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#getDefaultValueString <em>Default Value String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value String</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getDefaultValueString()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_DefaultValueString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsID <em>Is ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is ID</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsID()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsImplicit()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsImplicit();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Property#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Keys</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getKeys()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Keys();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsResolveProxies <em>Is Resolve Proxies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Resolve Proxies</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsResolveProxies()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsResolveProxies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsTransient()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsUnsettable <em>Is Unsettable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unsettable</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsUnsettable()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsUnsettable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Property#isIsVolatile <em>Is Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Volatile</em>'.
	 * @see org.eclipse.ocl.pivot.Property#isIsVolatile()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsVolatile();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Property#getSubsettedProperty <em>Subsetted Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsetted Property</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getSubsettedProperty()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_SubsettedProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Property#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.pivot.Property#getReferredProperty()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_ReferredProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Property#isAttribute(org.eclipse.ocl.pivot.Property) <em>Is Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Attribute</em>' operation.
	 * @see org.eclipse.ocl.pivot.Property#isAttribute(org.eclipse.ocl.pivot.Property)
	 * @generated
	 */
	EOperation getProperty__IsAttribute__Property();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Property#validateCompatibleDefaultExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Default Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Default Expression</em>' operation.
	 * @see org.eclipse.ocl.pivot.Property#validateCompatibleDefaultExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getProperty__ValidateCompatibleDefaultExpression__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.ocl.pivot.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.TypedElement#isIsMany <em>Is Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Many</em>'.
	 * @see org.eclipse.ocl.pivot.TypedElement#isIsMany()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_IsMany();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.pivot.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.TypedElement#CompatibleBody(org.eclipse.ocl.pivot.ValueSpecification) <em>Compatible Body</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compatible Body</em>' operation.
	 * @see org.eclipse.ocl.pivot.TypedElement#CompatibleBody(org.eclipse.ocl.pivot.ValueSpecification)
	 * @generated
	 */
	EOperation getTypedElement__CompatibleBody__ValueSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.TypedElement#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.ocl.pivot.TypedElement#isIsRequired()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_IsRequired();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.AssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class</em>'.
	 * @see org.eclipse.ocl.pivot.AssociationClass
	 * @generated
	 */
	EClass getAssociationClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unowned Attributes</em>'.
	 * @see org.eclipse.ocl.pivot.AssociationClass#getUnownedAttributes()
	 * @see #getAssociationClass()
	 * @generated
	 */
	EReference getAssociationClass_UnownedAttributes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.ocl.pivot.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getOwningClass()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwningClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Operation#getRaisedExceptions <em>Raised Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raised Exceptions</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getRaisedExceptions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_RaisedExceptions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Operation#getRedefinedOperations <em>Redefined Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Operations</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getRedefinedOperations()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_RedefinedOperations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Operation#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getBodyExpression()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_BodyExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Operation#isIsInvalidating <em>Is Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invalidating</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#isIsInvalidating()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsInvalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Operation#isIsTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#isIsTransient()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsTransient();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Operation#isIsTypeof <em>Is Typeof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Typeof</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#isIsTypeof()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsTypeof();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Operation#isIsValidating <em>Is Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Validating</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#isIsValidating()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_IsValidating();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Operation#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Operation#getOwnedPostconditions <em>Owned Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Postconditions</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedPostconditions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedPostconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.Operation#getOwnedPreconditions <em>Owned Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Preconditions</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedPreconditions()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedPreconditions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Operation#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.pivot.Operation#getPrecedence()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Precedence();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Operation#validateCompatibleReturn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Return</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Return</em>' operation.
	 * @see org.eclipse.ocl.pivot.Operation#validateCompatibleReturn(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateCompatibleReturn__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Operation#validateLoadableImplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Loadable Implementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Loadable Implementation</em>' operation.
	 * @see org.eclipse.ocl.pivot.Operation#validateLoadableImplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateLoadableImplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Operation#validateUniquePreconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Precondition Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Precondition Name</em>' operation.
	 * @see org.eclipse.ocl.pivot.Operation#validateUniquePreconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateUniquePreconditionName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Operation#validateUniquePostconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Postcondition Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Postcondition Name</em>' operation.
	 * @see org.eclipse.ocl.pivot.Operation#validateUniquePostconditionName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOperation__ValidateUniquePostconditionName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.ocl.pivot.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Parameter#isIsTypeof <em>Is Typeof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Typeof</em>'.
	 * @see org.eclipse.ocl.pivot.Parameter#isIsTypeof()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_IsTypeof();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Parameter#getOwningOperation <em>Owning Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Operation</em>'.
	 * @see org.eclipse.ocl.pivot.Parameter#getOwningOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_OwningOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ParameterVariable <em>Parameter Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Variable</em>'.
	 * @see org.eclipse.ocl.pivot.ParameterVariable
	 * @generated
	 */
	EClass getParameterVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ParameterVariable#validateHasNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Has No Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Has No Initializer</em>' operation.
	 * @see org.eclipse.ocl.pivot.ParameterVariable#validateHasNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParameterVariable__ValidateHasNoInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.ocl.pivot.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.VariableDeclaration#getTypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Value</em>'.
	 * @see org.eclipse.ocl.pivot.VariableDeclaration#getTypeValue()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_TypeValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.VariableDeclaration#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.VariableDeclaration#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableDeclaration__ValidateNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.VariableDeclaration#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.VariableDeclaration#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableDeclaration__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.VariableDeclaration#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.VariableDeclaration#validateTypeIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableDeclaration__ValidateTypeIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.OppositePropertyCallExp <em>Opposite Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.OppositePropertyCallExp
	 * @generated
	 */
	EClass getOppositePropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.OppositePropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.pivot.OppositePropertyCallExp#getReferredProperty()
	 * @see #getOppositePropertyCallExp()
	 * @generated
	 */
	EReference getOppositePropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OppositePropertyCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OppositePropertyCallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.OppositePropertyCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unsafe Source Can Not Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unsafe Source Can Not Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.OppositePropertyCallExp#validateUnsafeSourceCanNotBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.ocl.pivot.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Comment#getAnnotatedElements <em>Annotated Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotated Elements</em>'.
	 * @see org.eclipse.ocl.pivot.Comment#getAnnotatedElements()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_AnnotatedElements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Comment#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.ocl.pivot.Comment#getBody()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Body();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Comment#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Element</em>'.
	 * @see org.eclipse.ocl.pivot.Comment#getOwningElement()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_OwningElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CompleteClass <em>Complete Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Class</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteClass
	 * @generated
	 */
	EClass getCompleteClass();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage()
	 * @see #getCompleteClass()
	 * @generated
	 */
	EReference getCompleteClass_OwningCompletePackage();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.CompleteClass#getPartialClasses <em>Partial Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partial Classes</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteClass#getPartialClasses()
	 * @see #getCompleteClass()
	 * @generated
	 */
	EReference getCompleteClass_PartialClasses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CompleteEnvironment <em>Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Environment</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteEnvironment
	 * @generated
	 */
	EClass getCompleteEnvironment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedCompleteModel <em>Owned Complete Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Complete Model</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedCompleteModel()
	 * @see #getCompleteEnvironment()
	 * @generated
	 */
	EReference getCompleteEnvironment_OwnedCompleteModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedStandardLibrary <em>Owned Standard Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Standard Library</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteEnvironment#getOwnedStandardLibrary()
	 * @see #getCompleteEnvironment()
	 * @generated
	 */
	EReference getCompleteEnvironment_OwnedStandardLibrary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CompleteModel <em>Complete Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Model</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel
	 * @generated
	 */
	EClass getCompleteModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.CompleteModel#getOrphanCompletePackage <em>Orphan Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Orphan Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOrphanCompletePackage()
	 * @see #getCompleteModel()
	 * @generated
	 */
	EReference getCompleteModel_OrphanCompletePackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Complete Packages</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackages()
	 * @see #getCompleteModel()
	 * @generated
	 */
	EReference getCompleteModel_OwnedCompletePackages();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.CompleteModel#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Complete Environment</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOwningCompleteEnvironment()
	 * @see #getCompleteModel()
	 * @generated
	 */
	EReference getCompleteModel_OwningCompleteEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.CompleteModel#getPartialModels <em>Partial Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partial Models</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getPartialModels()
	 * @see #getCompleteModel()
	 * @generated
	 */
	EReference getCompleteModel_PartialModels();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.CompleteModel#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getPrimitiveCompletePackage()
	 * @see #getCompleteModel()
	 * @generated
	 */
	EReference getCompleteModel_PrimitiveCompletePackage();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackage(java.lang.String) <em>Get Owned Complete Package</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Owned Complete Package</em>' operation.
	 * @see org.eclipse.ocl.pivot.CompleteModel#getOwnedCompletePackage(java.lang.String)
	 * @generated
	 */
	EOperation getCompleteModel__GetOwnedCompletePackage__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CompletePackage <em>Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage
	 * @generated
	 */
	EClass getCompletePackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Complete Classes</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClasses()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_OwnedCompleteClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Complete Packages</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwnedCompletePackages()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_OwnedCompletePackages();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Complete Model</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwningCompleteModel()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_OwningCompleteModel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Complete Package</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwningCompletePackage()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_OwningCompletePackage();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.CompletePackage#getPartialPackages <em>Partial Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partial Packages</em>'.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getPartialPackages()
	 * @see #getCompletePackage()
	 * @generated
	 */
	EReference getCompletePackage_PartialPackages();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClass(java.lang.String) <em>Get Owned Complete Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Owned Complete Class</em>' operation.
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClass(java.lang.String)
	 * @generated
	 */
	EOperation getCompletePackage__GetOwnedCompleteClass__String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ConnectionPointReference <em>Connection Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Point Reference</em>'.
	 * @see org.eclipse.ocl.pivot.ConnectionPointReference
	 * @generated
	 */
	EClass getConnectionPointReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.ConnectionPointReference#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entries</em>'.
	 * @see org.eclipse.ocl.pivot.ConnectionPointReference#getEntries()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_Entries();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.ConnectionPointReference#getExits <em>Exits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exits</em>'.
	 * @see org.eclipse.ocl.pivot.ConnectionPointReference#getExits()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_Exits();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState()
	 * @see #getConnectionPointReference()
	 * @generated
	 */
	EReference getConnectionPointReference_OwningState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Constraint#getConstrainedElements <em>Constrained Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constrained Elements</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getConstrainedElements()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_ConstrainedElements();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.Constraint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.Constraint#isIsCallable <em>Is Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Callable</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#isIsCallable()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_IsCallable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.Constraint#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getOwnedSpecification()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwnedSpecification();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Constraint#getOwningPostContext <em>Owning Post Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Post Context</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningPostContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwningPostContext();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Constraint#getOwningPreContext <em>Owning Pre Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Pre Context</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningPreContext()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwningPreContext();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Constraint#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning State</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningState()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwningState();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.pivot.Constraint#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transition</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningTransition()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwningTransition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.Constraint#getRedefinedConstraints <em>Redefined Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefined Constraints</em>'.
	 * @see org.eclipse.ocl.pivot.Constraint#getRedefinedConstraints()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_RedefinedConstraints();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Constraint#validateBooleanValued(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Boolean Valued</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Boolean Valued</em>' operation.
	 * @see org.eclipse.ocl.pivot.Constraint#validateBooleanValued(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateBooleanValued__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.Constraint#validateUniqueName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Name</em>' operation.
	 * @see org.eclipse.ocl.pivot.Constraint#validateUniqueName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConstraint__ValidateUniqueName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see org.eclipse.ocl.pivot.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#isComputable() <em>Is Computable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Computable</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#isComputable()
	 * @generated
	 */
	EOperation getValueSpecification__IsComputable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#integerValue() <em>Integer Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Integer Value</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#integerValue()
	 * @generated
	 */
	EOperation getValueSpecification__IntegerValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#booleanValue() <em>Boolean Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Boolean Value</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#booleanValue()
	 * @generated
	 */
	EOperation getValueSpecification__BooleanValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#stringValue()
	 * @generated
	 */
	EOperation getValueSpecification__StringValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#unlimitedValue() <em>Unlimited Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unlimited Value</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#unlimitedValue()
	 * @generated
	 */
	EOperation getValueSpecification__UnlimitedValue();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.ValueSpecification#isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.ValueSpecification#isNull()
	 * @generated
	 */
	EOperation getValueSpecification__IsNull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.utilities.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.eclipse.ocl.pivot.utilities.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.Detail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail</em>'.
	 * @see org.eclipse.ocl.pivot.Detail
	 * @generated
	 */
	EClass getDetail();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.pivot.Detail#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.ocl.pivot.Detail#getValues()
	 * @see #getDetail()
	 * @generated
	 */
	EAttribute getDetail_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DynamicBehavior <em>Dynamic Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Behavior</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicBehavior
	 * @generated
	 */
	EClass getDynamicBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DynamicElement <em>Dynamic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Element</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicElement
	 * @generated
	 */
	EClass getDynamicElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.DynamicElement#getMetaType <em>Meta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Type</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicElement#getMetaType()
	 * @see #getDynamicElement()
	 * @generated
	 */
	EReference getDynamicElement_MetaType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DynamicProperty <em>Dynamic Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Property</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicProperty
	 * @generated
	 */
	EClass getDynamicProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.DynamicProperty#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicProperty#getReferredProperty()
	 * @see #getDynamicProperty()
	 * @generated
	 */
	EReference getDynamicProperty_ReferredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.DynamicProperty#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicProperty#getDefault()
	 * @see #getDynamicProperty()
	 * @generated
	 */
	EAttribute getDynamicProperty_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DynamicType <em>Dynamic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Type</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicType
	 * @generated
	 */
	EClass getDynamicType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.pivot.DynamicType#getOwnedDynamicProperties <em>Owned Dynamic Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Dynamic Properties</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicType#getOwnedDynamicProperties()
	 * @see #getDynamicType()
	 * @generated
	 */
	EReference getDynamicType_OwnedDynamicProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.DynamicValueSpecification <em>Dynamic Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Value Specification</em>'.
	 * @see org.eclipse.ocl.pivot.DynamicValueSpecification
	 * @generated
	 */
	EClass getDynamicValueSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.ocl.pivot.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.AssociationClassCallExp
	 * @generated
	 */
	EClass getAssociationClassCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Association Class</em>'.
	 * @see org.eclipse.ocl.pivot.AssociationClassCallExp#getReferredAssociationClass()
	 * @see #getAssociationClassCallExp()
	 * @generated
	 */
	EReference getAssociationClassCallExp_ReferredAssociationClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.NavigationCallExp
	 * @generated
	 */
	EClass getNavigationCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Navigation Source</em>'.
	 * @see org.eclipse.ocl.pivot.NavigationCallExp#getNavigationSource()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_NavigationSource();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.NavigationCallExp#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Qualifiers</em>'.
	 * @see org.eclipse.ocl.pivot.NavigationCallExp#getQualifiers()
	 * @see #getNavigationCallExp()
	 * @generated
	 */
	EReference getNavigationCallExp_Qualifiers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.FeatureCallExp
	 * @generated
	 */
	EClass getFeatureCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.FeatureCallExp#isIsPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.eclipse.ocl.pivot.FeatureCallExp#isIsPre()
	 * @see #getFeatureCallExp()
	 * @generated
	 */
	EAttribute getFeatureCallExp_IsPre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.eclipse.ocl.pivot.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.ocl.pivot.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CallExp#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.ocl.pivot.CallExp#isIsImplicit()
	 * @see #getCallExp()
	 * @generated
	 */
	EAttribute getCallExp_IsImplicit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.pivot.CallExp#isIsSafe <em>Is Safe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Safe</em>'.
	 * @see org.eclipse.ocl.pivot.CallExp#isIsSafe()
	 * @see #getCallExp()
	 * @generated
	 */
	EAttribute getCallExp_IsSafe();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.pivot.CallExp#getOwnedSource <em>Owned Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Source</em>'.
	 * @see org.eclipse.ocl.pivot.CallExp#getOwnedSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_OwnedSource();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Can Be Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Can Be Null</em>' operation.
	 * @see org.eclipse.ocl.pivot.CallExp#validateSafeSourceCanBeNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CallExp#validateSafeSourceCannotBeMap(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Safe Source Cannot Be Map</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Safe Source Cannot Be Map</em>' operation.
	 * @see org.eclipse.ocl.pivot.CallExp#validateSafeSourceCannotBeMap(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallExp__ValidateSafeSourceCannotBeMap__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.CallExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Not Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * @see org.eclipse.ocl.pivot.CallExp#validateTypeIsNotInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.AssociativityKind <em>Associativity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Associativity Kind</em>'.
	 * @see org.eclipse.ocl.pivot.AssociativityKind
	 * @generated
	 */
	EEnum getAssociativityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.ocl.pivot.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.PseudostateKind <em>Pseudostate Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pseudostate Kind</em>'.
	 * @see org.eclipse.ocl.pivot.PseudostateKind
	 * @generated
	 */
	EEnum getPseudostateKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.pivot.TransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Kind</em>'.
	 * @see org.eclipse.ocl.pivot.TransitionKind
	 * @generated
	 */
	EEnum getTransitionKind();

	/**
	 * Returns the meta object for data type '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Boolean is used for logical expressions, consisting of the predefined values true and false.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @generated
	 */
	EDataType getBoolean();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EObject <em>Ecore Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ecore Object</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @generated
	 */
	EDataType getEcoreObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Integer is a primitive type representing integer values.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.pivot.library.LibraryFeature <em>Library Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Library Feature</em>'.
	 * @see org.eclipse.ocl.pivot.library.LibraryFeature
	 * @generated
	 */
	EDataType getLibraryFeature();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Real is a primitive type representing the mathematical concept of real.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Real</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getReal();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * String is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Unlimited Natural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * UnlimitedNatural is a primitive type representing unlimited natural values.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Unlimited Natural</em>'.
	 * @see java.lang.Number
	 * @generated
	 */
	EDataType getUnlimitedNatural();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PivotFactory getPivotFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.AnnotationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Owned Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_CONTENTS = eINSTANCE.getAnnotation_OwnedContents();

		/**
		 * The meta object literal for the '<em><b>Owned Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__OWNED_DETAILS = eINSTANCE.getAnnotation_OwnedDetails();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__REFERENCES = eINSTANCE.getAnnotation_References();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.NamedElementImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ElementImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Annotating Comments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ANNOTATING_COMMENTS = eINSTANCE.getElement_AnnotatingComments();

		/**
		 * The meta object literal for the '<em><b>Owned Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_ANNOTATIONS = eINSTANCE.getElement_OwnedAnnotations();

		/**
		 * The meta object literal for the '<em><b>Owned Comments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_COMMENTS = eINSTANCE.getElement_OwnedComments();

		/**
		 * The meta object literal for the '<em><b>Owned Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OWNED_EXTENSIONS = eINSTANCE.getElement_OwnedExtensions();

		/**
		 * The meta object literal for the '<em><b>All Owned Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___ALL_OWNED_ELEMENTS = eINSTANCE.getElement__AllOwnedElements();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___GET_VALUE__TYPE_STRING = eINSTANCE.getElement__GetValue__Type_String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ElementExtensionImpl <em>Element Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ElementExtensionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getElementExtension()
		 * @generated
		 */
		EClass ELEMENT_EXTENSION = eINSTANCE.getElementExtension();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_EXTENSION__STEREOTYPE = eINSTANCE.getElementExtension_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ElementLiteralExpImpl <em>Element Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ElementLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getElementLiteralExp()
		 * @generated
		 */
		EClass ELEMENT_LITERAL_EXP = eINSTANCE.getElementLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Referred Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_LITERAL_EXP__REFERRED_ELEMENT = eINSTANCE.getElementLiteralExp_ReferredElement();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_EXTENSION__BASE = eINSTANCE.getElementExtension_Base();

		/**
		 * The meta object literal for the '<em><b>Is Applied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_EXTENSION__IS_APPLIED = eINSTANCE.getElementExtension_IsApplied();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_EXTENSION__IS_REQUIRED = eINSTANCE.getElementExtension_IsRequired();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OCLExpressionImpl <em>OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OCLExpressionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOCLExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
		 * The meta object literal for the '<em><b>Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_EXPRESSION__TYPE_VALUE = eINSTANCE.getOCLExpression_TypeValue();

		/**
		 * The meta object literal for the '<em><b>Is Non Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OCL_EXPRESSION___IS_NON_NULL = eINSTANCE.getOCLExpression__IsNonNull();

		/**
		 * The meta object literal for the '<em><b>Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OCL_EXPRESSION___IS_NULL = eINSTANCE.getOCLExpression__IsNull();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OCL_EXPRESSION___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOCLExpression__ValidateTypeIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.BagTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.BehaviorImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Owning Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__OWNING_TRANSITION = eINSTANCE.getBehavior_OwningTransition();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CollectionTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
		 * The meta object literal for the '<em><b>Is Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__IS_NULL_FREE = eINSTANCE.getCollectionType_IsNullFree();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__LOWER = eINSTANCE.getCollectionType_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_TYPE__UPPER = eINSTANCE.getCollectionType_Upper();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DataTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Behavioral Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__BEHAVIORAL_CLASS = eINSTANCE.getDataType_BehavioralClass();

		/**
		 * The meta object literal for the '<em><b>Is Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__IS_SERIALIZABLE = eINSTANCE.getDataType_IsSerializable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__VALUE = eINSTANCE.getDataType_Value();

		/**
		 * The meta object literal for the '<em><b>Validate Behavioral Class Has Distinct Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_HAS_DISTINCT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDataType__ValidateBehavioralClassHasDistinctName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Behavioral Class Is Primitive Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_IS_PRIMITIVE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDataType__ValidateBehavioralClassIsPrimitiveType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Behavioral Class Is Super Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_IS_SUPER_CLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDataType__ValidateBehavioralClassIsSuperClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.BooleanLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL_EXP___VALIDATE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBooleanLiteralExp__ValidateTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.BooleanTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PrimitiveLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPrimitiveLiteralExp()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CallOperationActionImpl <em>Call Operation Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CallOperationActionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCallOperationAction()
		 * @generated
		 */
		EClass CALL_OPERATION_ACTION = eINSTANCE.getCallOperationAction();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_OPERATION_ACTION__OPERATION = eINSTANCE.getCallOperationAction_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CollectionItemImpl <em>Collection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CollectionItemImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '<em><b>Owned Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITEM__OWNED_ITEM = eINSTANCE.getCollectionItem_OwnedItem();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Item Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_ITEM___VALIDATE_TYPE_IS_ITEM_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionItem__ValidateTypeIsItemType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CollectionLiteralPartImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_PART___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__OWNED_PARTS = eINSTANCE.getCollectionLiteralExp_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Validate Collection Kind Is Concrete</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateCollectionKindIsConcrete__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Set Kind Is Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateSetKindIsSet__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Ordered Set Kind Is Ordered Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateOrderedSetKindIsOrderedSet__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sequence Kind Is Sequence</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateSequenceKindIsSequence__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Bag Kind Is Bag</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollectionLiteralExp__ValidateBagKindIsBag__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CollectionRangeImpl <em>Collection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CollectionRangeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '<em><b>Owned First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__OWNED_FIRST = eINSTANCE.getCollectionRange_OwnedFirst();

		/**
		 * The meta object literal for the '<em><b>Owned Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__OWNED_LAST = eINSTANCE.getCollectionRange_OwnedLast();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.EnumLiteralExpImpl <em>Enum Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.EnumLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Referred Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__REFERRED_LITERAL = eINSTANCE.getEnumLiteralExp_ReferredLiteral();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Enumeration Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENUM_LITERAL_EXP___VALIDATE_TYPE_IS_ENUMERATION_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getEnumLiteralExp__ValidateTypeIsEnumerationType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.EnumerationLiteralImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * @since 1.4
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__LITERAL = eINSTANCE.getEnumerationLiteral_Literal();

		/**
		 * The meta object literal for the '<em><b>Owning Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__OWNING_ENUMERATION = eINSTANCE.getEnumerationLiteral_OwningEnumeration();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__VALUE = eINSTANCE.getEnumerationLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.EnumerationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__OWNED_LITERALS = eINSTANCE.getEnumeration_OwnedLiterals();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ExpressionInOCLImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getExpressionInOCL()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_BODY = eINSTANCE.getExpressionInOCL_OwnedBody();

		/**
		 * The meta object literal for the '<em><b>Owned Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_CONTEXT = eINSTANCE.getExpressionInOCL_OwnedContext();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_PARAMETERS = eINSTANCE.getExpressionInOCL_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_RESULT = eINSTANCE.getExpressionInOCL_OwnedResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.FeatureImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Implementation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION_CLASS = eINSTANCE.getFeature_ImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IS_STATIC = eINSTANCE.getFeature_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getFeature__ValidateNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getFeature__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getFeature__ValidateTypeIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IMPLEMENTATION = eINSTANCE.getFeature_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.VariableImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__IS_IMPLICIT = eINSTANCE.getVariable_IsImplicit();

		/**
		 * The meta object literal for the '<em><b>Represented Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__REPRESENTED_PARAMETER = eINSTANCE.getVariable_RepresentedParameter();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Initialiser Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariable__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__OWNED_INIT = eINSTANCE.getVariable_OwnedInit();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IfExpImpl <em>If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IfExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIfExp()
		 * @generated
		 */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
		 * The meta object literal for the '<em><b>Is Else If</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_EXP__IS_ELSE_IF = eINSTANCE.getIfExp_IsElseIf();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__OWNED_CONDITION = eINSTANCE.getIfExp_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__OWNED_ELSE = eINSTANCE.getIfExp_OwnedElse();

		/**
		 * The meta object literal for the '<em><b>Owned Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP__OWNED_THEN = eINSTANCE.getIfExp_OwnedThen();

		/**
		 * The meta object literal for the '<em><b>Validate Condition Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IF_EXP___VALIDATE_CONDITION_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIfExp__ValidateConditionTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IF_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIfExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ImportImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

		/**
		 * The meta object literal for the '<em><b>Xmiid Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * @since 1.4
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__XMIID_VERSION = eINSTANCE.getImport_XmiidVersion();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.InstanceSpecificationImpl <em>Instance Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.InstanceSpecificationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getInstanceSpecification()
		 * @generated
		 */
		EClass INSTANCE_SPECIFICATION = eINSTANCE.getInstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SPECIFICATION__CLASSES = eINSTANCE.getInstanceSpecification_Classes();

		/**
		 * The meta object literal for the '<em><b>Owned Slots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SPECIFICATION__OWNED_SLOTS = eINSTANCE.getInstanceSpecification_OwnedSlots();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SPECIFICATION__OWNED_SPECIFICATION = eINSTANCE.getInstanceSpecification_OwnedSpecification();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SPECIFICATION__OWNING_PACKAGE = eINSTANCE.getInstanceSpecification_OwningPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IntegerLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTEGER_LITERAL_EXP___VALIDATE_TYPE_IS_INTEGER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIntegerLiteralExp__ValidateTypeIsInteger__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.NumericLiteralExpImpl <em>Numeric Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.NumericLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNumericLiteralExp()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.InvalidLiteralExpImpl <em>Invalid Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.InvalidLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getInvalidLiteralExp()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.InvalidTypeImpl <em>Invalid Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.InvalidTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getInvalidType()
		 * @generated
		 */
		EClass INVALID_TYPE = eINSTANCE.getInvalidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IterableTypeImpl <em>Iterable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IterableTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIterableType()
		 * @generated
		 */
		EClass ITERABLE_TYPE = eINSTANCE.getIterableType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IterateExpImpl <em>Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IterateExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '<em><b>Owned Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_EXP__OWNED_RESULT = eINSTANCE.getIterateExp_OwnedResult();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_TYPE_IS_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateTypeIsResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unsafe Source Can Not Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Body Type Conforms To Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_BODY_TYPE_CONFORMS_TO_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateBodyTypeConformsToResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate One Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_ONE_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateOneInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Iterator Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_SAFE_ITERATOR_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateSafeIteratorIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATE_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIterateExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IterationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ACCUMULATORS = eINSTANCE.getIteration_OwnedAccumulators();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__OWNED_ITERATORS = eINSTANCE.getIteration_OwnedIterators();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IteratorExpImpl <em>Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IteratorExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Body Type Is Conformantto Iterator Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureBodyTypeIsConformanttoIteratorType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Iterator Type Is Comparable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByIteratorTypeIsComparable__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unsafe Source Can Not Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.IteratorVariableImpl <em>Iterator Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.3
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.IteratorVariableImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getIteratorVariable()
		 * @generated
		 */
		EClass ITERATOR_VARIABLE = eINSTANCE.getIteratorVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Has No Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_VARIABLE___VALIDATE_HAS_NO_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorVariable__ValidateHasNoInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Body Element Type Is Iterator Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_BODY_ELEMENT_TYPE_IS_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureBodyElementTypeIsIteratorType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Any Body Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateAnyBodyTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Has One Iterator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureHasOneIterator__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Result Element Type Is Iterator Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_RESULT_ELEMENT_TYPE_IS_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureResultElementTypeIsIteratorType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Type Is Unique Collection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureTypeIsUniqueCollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Element Type Is Flattened Body Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_FLATTENED_BODY_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectElementTypeIsFlattenedBodyType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Source Element Type Is Body Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureSourceElementTypeIsBodyElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Closure Element Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateClosureElementTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Collect Type Is Unordered</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_COLLECT_TYPE_IS_UNORDERED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateCollectTypeIsUnordered__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Is Ordered If Source Is Ordered</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByIsOrderedIfSourceIsOrdered__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Sorted By Element Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSortedByElementTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Iterator Type Is Source Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateIteratorTypeIsSourceElementType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Iterator Type Is Source Key Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_KEY_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateIteratorTypeIsSourceKeyType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Iterator Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SAFE_ITERATOR_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSafeIteratorIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITERATOR_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getIteratorExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl <em>Lambda Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LambdaTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLambdaType()
		 * @generated
		 */
		EClass LAMBDA_TYPE = eINSTANCE.getLambdaType();

		/**
		 * The meta object literal for the '<em><b>Context Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__CONTEXT_TYPE = eINSTANCE.getLambdaType_ContextType();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__PARAMETER_TYPE = eINSTANCE.getLambdaType_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAMBDA_TYPE__RESULT_TYPE = eINSTANCE.getLambdaType_ResultType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LanguageExpressionImpl <em>Language Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LanguageExpressionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLanguageExpression()
		 * @generated
		 */
		EClass LANGUAGE_EXPRESSION = eINSTANCE.getLanguageExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_EXPRESSION__BODY = eINSTANCE.getLanguageExpression_Body();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_EXPRESSION__LANGUAGE = eINSTANCE.getLanguageExpression_Language();

		/**
		 * The meta object literal for the '<em><b>Owning Constraint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_EXPRESSION__OWNING_CONSTRAINT = eINSTANCE.getLanguageExpression_OwningConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LetExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>Owned In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__OWNED_IN = eINSTANCE.getLetExp_OwnedIn();

		/**
		 * The meta object literal for the '<em><b>Owned Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__OWNED_VARIABLE = eINSTANCE.getLetExp_OwnedVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Nullity For In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_EXP___VALIDATE_COMPATIBLE_NULLITY_FOR_IN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetExp__ValidateCompatibleNullityForIn__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is In Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_EXP___VALIDATE_TYPE_IS_IN_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetExp__ValidateTypeIsInType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LetVariableImpl <em>Let Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.3
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LetVariableImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLetVariable()
		 * @generated
		 */
		EClass LET_VARIABLE = eINSTANCE.getLetVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Nullity For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_VARIABLE___VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Has Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LET_VARIABLE___VALIDATE_HAS_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLetVariable__ValidateHasInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LibraryImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Owned Precedences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__OWNED_PRECEDENCES = eINSTANCE.getLibrary_OwnedPrecedences();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.LoopExpImpl <em>Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.LoopExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__OWNED_BODY = eINSTANCE.getLoopExp_OwnedBody();

		/**
		 * The meta object literal for the '<em><b>Owned Co Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__OWNED_CO_ITERATORS = eINSTANCE.getLoopExp_OwnedCoIterators();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__OWNED_ITERATORS = eINSTANCE.getLoopExp_OwnedIterators();

		/**
		 * The meta object literal for the '<em><b>Referred Iteration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__REFERRED_ITERATION = eINSTANCE.getLoopExp_ReferredIteration();

		/**
		 * The meta object literal for the '<em><b>Validate Matching Map Co Iterators</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_MATCHING_MAP_CO_ITERATORS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateMatchingMapCoIterators__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Matching Ordered Collection Co Iterators</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_MATCHING_ORDERED_COLLECTION_CO_ITERATORS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateMatchingOrderedCollectionCoIterators__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Co Initializers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_NO_CO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateNoCoInitializers__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Source Is Collection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateSourceIsCollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Source Is Iterable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_SOURCE_IS_ITERABLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateSourceIsIterable__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.MapLiteralExpImpl <em>Map Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.MapLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMapLiteralExp()
		 * @generated
		 */
		EClass MAP_LITERAL_EXP = eINSTANCE.getMapLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_EXP__OWNED_PARTS = eINSTANCE.getMapLiteralExp_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.MapLiteralPartImpl <em>Map Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.MapLiteralPartImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMapLiteralPart()
		 * @generated
		 */
		EClass MAP_LITERAL_PART = eINSTANCE.getMapLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Owned Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_PART__OWNED_KEY = eINSTANCE.getMapLiteralPart_OwnedKey();

		/**
		 * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_LITERAL_PART__OWNED_VALUE = eINSTANCE.getMapLiteralPart_OwnedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.MapTypeImpl <em>Map Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.MapTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMapType()
		 * @generated
		 */
		EClass MAP_TYPE = eINSTANCE.getMapType();

		/**
		 * The meta object literal for the '<em><b>Entry Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TYPE__ENTRY_CLASS = eINSTANCE.getMapType_EntryClass();

		/**
		 * The meta object literal for the '<em><b>Key Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TYPE__KEY_TYPE = eINSTANCE.getMapType_KeyType();

		/**
		 * The meta object literal for the '<em><b>Keys Are Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_TYPE__KEYS_ARE_NULL_FREE = eINSTANCE.getMapType_KeysAreNullFree();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_TYPE__VALUE_TYPE = eINSTANCE.getMapType_ValueType();

		/**
		 * The meta object literal for the '<em><b>Values Are Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_TYPE__VALUES_ARE_NULL_FREE = eINSTANCE.getMapType_ValuesAreNullFree();

		/**
		 * The meta object literal for the '<em><b>Validate No Initializers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateNoInitializers__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Not Ordered Collection Co Iterators</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOP_EXP___VALIDATE_NO_NOT_ORDERED_COLLECTION_CO_ITERATORS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getLoopExp__ValidateNoNotOrderedCollectionCoIterators__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.MessageExpImpl <em>Message Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.MessageExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMessageExp()
		 * @generated
		 */
		EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__OWNED_ARGUMENTS = eINSTANCE.getMessageExp_OwnedArguments();

		/**
		 * The meta object literal for the '<em><b>Owned Called Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__OWNED_CALLED_OPERATION = eINSTANCE.getMessageExp_OwnedCalledOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Sent Signal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__OWNED_SENT_SIGNAL = eINSTANCE.getMessageExp_OwnedSentSignal();

		/**
		 * The meta object literal for the '<em><b>Owned Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EXP__OWNED_TARGET = eINSTANCE.getMessageExp_OwnedTarget();

		/**
		 * The meta object literal for the '<em><b>Validate One Call Or One Send</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_EXP___VALIDATE_ONE_CALL_OR_ONE_SEND__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageExp__ValidateOneCallOrOneSend__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Is Not ACollection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_EXP___VALIDATE_TARGET_IS_NOT_ACOLLECTION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageExp__ValidateTargetIsNotACollection__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SendSignalActionImpl <em>Send Signal Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SendSignalActionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSendSignalAction()
		 * @generated
		 */
		EClass SEND_SIGNAL_ACTION = eINSTANCE.getSendSignalAction();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_SIGNAL_ACTION__SIGNAL = eINSTANCE.getSendSignalAction_Signal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SignalImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SlotImpl <em>Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SlotImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSlot()
		 * @generated
		 */
		EClass SLOT = eINSTANCE.getSlot();

		/**
		 * The meta object literal for the '<em><b>Defining Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT__DEFINING_PROPERTY = eINSTANCE.getSlot_DefiningProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT__OWNED_VALUES = eINSTANCE.getSlot_OwnedValues();

		/**
		 * The meta object literal for the '<em><b>Owning Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT__OWNING_INSTANCE = eINSTANCE.getSlot_OwningInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StandardLibraryImpl <em>Standard Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StandardLibraryImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStandardLibrary()
		 * @generated
		 */
		EClass STANDARD_LIBRARY = eINSTANCE.getStandardLibrary();

		/**
		 * The meta object literal for the '<em><b>Owning Complete Environment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_LIBRARY__OWNING_COMPLETE_ENVIRONMENT = eINSTANCE.getStandardLibrary_OwningCompleteEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.MessageTypeImpl <em>Message Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.MessageTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMessageType()
		 * @generated
		 */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
		 * The meta object literal for the '<em><b>Referred Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_SIGNAL = eINSTANCE.getMessageType_ReferredSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ModelImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>External URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__EXTERNAL_URI = eINSTANCE.getModel_ExternalURI();

		/**
		 * The meta object literal for the '<em><b>Owned Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__OWNED_IMPORTS = eINSTANCE.getModel_OwnedImports();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__OWNED_PACKAGES = eINSTANCE.getModel_OwnedPackages();

		/**
		 * The meta object literal for the '<em><b>Xmiid Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * @since 1.4
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__XMIID_VERSION = eINSTANCE.getModel_XmiidVersion();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__REFERRED_OPERATION = eINSTANCE.getMessageType_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.utilities.MorePivotable <em>More Pivotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.utilities.MorePivotable
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getMorePivotable()
		 * @generated
		 */
		EClass MORE_PIVOTABLE = eINSTANCE.getMorePivotable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.NullLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNullLiteralExp()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OperationCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_CALL_EXP__IS_VIRTUAL = eINSTANCE.getOperationCallExp_IsVirtual();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__OWNED_ARGUMENTS = eINSTANCE.getOperationCallExp_OwnedArguments();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Has Ocl Void Overload</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___HAS_OCL_VOID_OVERLOAD = eINSTANCE.getOperationCallExp__HasOclVoidOverload();

		/**
		 * The meta object literal for the '<em><b>Validate Argument Type Is Conformant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_ARGUMENT_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateArgumentTypeIsConformant__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unsafe Source Can Not Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Argument Count</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION_CALL_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperationCallExp__ValidateArgumentCount__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OrderedSetTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OrphanCompletePackageImpl <em>Orphan Complete Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OrphanCompletePackageImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOrphanCompletePackage()
		 * @generated
		 */
		EClass ORPHAN_COMPLETE_PACKAGE = eINSTANCE.getOrphanCompletePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PrimitiveTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Coercions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE__COERCIONS = eINSTANCE.getPrimitiveType_Coercions();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ProfileImpl <em>Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ProfileImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getProfile()
		 * @generated
		 */
		EClass PROFILE = eINSTANCE.getProfile();

		/**
		 * The meta object literal for the '<em><b>Profile Applications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE__PROFILE_APPLICATIONS = eINSTANCE.getProfile_ProfileApplications();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ProfileApplicationImpl <em>Profile Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ProfileApplicationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getProfileApplication()
		 * @generated
		 */
		EClass PROFILE_APPLICATION = eINSTANCE.getProfileApplication();

		/**
		 * The meta object literal for the '<em><b>Applied Profile</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_APPLICATION__APPLIED_PROFILE = eINSTANCE.getProfileApplication_AppliedProfile();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_APPLICATION__IS_STRICT = eINSTANCE.getProfileApplication_IsStrict();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_APPLICATION__OWNING_PACKAGE = eINSTANCE.getProfileApplication_OwningPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PropertyCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Get Specialized Referred Property Owning Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_OWNING_TYPE = eINSTANCE.getPropertyCallExp__GetSpecializedReferredPropertyOwningType();

		/**
		 * The meta object literal for the '<em><b>Get Specialized Referred Property Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_TYPE = eINSTANCE.getPropertyCallExp__GetSpecializedReferredPropertyType();

		/**
		 * The meta object literal for the '<em><b>Validate Non Static Source Type Is Conformant</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateNonStaticSourceTypeIsConformant__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unsafe Source Can Not Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Result Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_CALL_EXP___VALIDATE_COMPATIBLE_RESULT_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyCallExp__ValidateCompatibleResultType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PseudostateImpl <em>Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PseudostateImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPseudostate()
		 * @generated
		 */
		EClass PSEUDOSTATE = eINSTANCE.getPseudostate();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PSEUDOSTATE__KIND = eINSTANCE.getPseudostate_Kind();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDOSTATE__OWNING_STATE = eINSTANCE.getPseudostate_OwningState();

		/**
		 * The meta object literal for the '<em><b>Owning State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDOSTATE__OWNING_STATE_MACHINE = eINSTANCE.getPseudostate_OwningStateMachine();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.RealLiteralExpImpl <em>Real Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.RealLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.ReferringElement <em>Referring Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.ReferringElement
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getReferringElement()
		 * @generated
		 */
		EClass REFERRING_ELEMENT = eINSTANCE.getReferringElement();

		/**
		 * The meta object literal for the '<em><b>Get Referred Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REFERRING_ELEMENT___GET_REFERRED_ELEMENT = eINSTANCE.getReferringElement__GetReferredElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.RegionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Extended Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__EXTENDED_REGION = eINSTANCE.getRegion_ExtendedRegion();

		/**
		 * The meta object literal for the '<em><b>Owned Subvertexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_SUBVERTEXES = eINSTANCE.getRegion_OwnedSubvertexes();

		/**
		 * The meta object literal for the '<em><b>Owned Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_TRANSITIONS = eINSTANCE.getRegion_OwnedTransitions();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNING_STATE = eINSTANCE.getRegion_OwningState();

		/**
		 * The meta object literal for the '<em><b>Owning State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNING_STATE_MACHINE = eINSTANCE.getRegion_OwningStateMachine();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ResultVariableImpl <em>Result Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.3
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ResultVariableImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getResultVariable()
		 * @generated
		 */
		EClass RESULT_VARIABLE = eINSTANCE.getResultVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Nullity For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESULT_VARIABLE___VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getResultVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESULT_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getResultVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Has Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESULT_VARIABLE___VALIDATE_HAS_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getResultVariable__ValidateHasInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SelfTypeImpl <em>Self Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SelfTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSelfType()
		 * @generated
		 */
		EClass SELF_TYPE = eINSTANCE.getSelfType();

		/**
		 * The meta object literal for the '<em><b>Specialize In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SELF_TYPE___SPECIALIZE_IN__CALLEXP_TYPE = eINSTANCE.getSelfType__SpecializeIn__CallExp_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SequenceTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.SetTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ShadowExpImpl <em>Shadow Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ShadowExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getShadowExp()
		 * @generated
		 */
		EClass SHADOW_EXP = eINSTANCE.getShadowExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_EXP__OWNED_PARTS = eINSTANCE.getShadowExp_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHADOW_EXP__VALUE = eINSTANCE.getShadowExp_Value();

		/**
		 * The meta object literal for the '<em><b>Validate Class Has No String Value Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_CLASS_HAS_NO_STRING_VALUE_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateClassHasNoStringValueInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Data Type Has No Part Initializers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_DATA_TYPE_HAS_NO_PART_INITIALIZERS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateDataTypeHasNoPartInitializers__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Data Type Has One Part Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_DATA_TYPE_HAS_ONE_PART_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateDataTypeHasOnePartInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Data Type Has String Value Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_DATA_TYPE_HAS_STRING_VALUE_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateDataTypeHasStringValueInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Initializes All Class Properties</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_INITIALIZES_ALL_CLASS_PROPERTIES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateInitializesAllClassProperties__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ShadowPartImpl <em>Shadow Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ShadowPartImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getShadowPart()
		 * @generated
		 */
		EClass SHADOW_PART = eINSTANCE.getShadowPart();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART__OWNED_INIT = eINSTANCE.getShadowPart_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART__REFERRED_PROPERTY = eINSTANCE.getShadowPart_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Initialiser Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_PART___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowPart__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_PART___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHADOW_PART___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getShadowPart__ValidateTypeIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StateImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_COMPOSITE = eINSTANCE.getState_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Is Orthogonal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_ORTHOGONAL = eINSTANCE.getState_IsOrthogonal();

		/**
		 * The meta object literal for the '<em><b>Is Simple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_SIMPLE = eINSTANCE.getState_IsSimple();

		/**
		 * The meta object literal for the '<em><b>Is Submachine State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_SUBMACHINE_STATE = eINSTANCE.getState_IsSubmachineState();

		/**
		 * The meta object literal for the '<em><b>Owned Connection Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_CONNECTION_POINTS = eINSTANCE.getState_OwnedConnectionPoints();

		/**
		 * The meta object literal for the '<em><b>Owned Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_CONNECTIONS = eINSTANCE.getState_OwnedConnections();

		/**
		 * The meta object literal for the '<em><b>Owned Deferrable Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_DEFERRABLE_TRIGGERS = eINSTANCE.getState_OwnedDeferrableTriggers();

		/**
		 * The meta object literal for the '<em><b>Owned Do Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_DO_ACTIVITY = eINSTANCE.getState_OwnedDoActivity();

		/**
		 * The meta object literal for the '<em><b>Owned Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_ENTRY = eINSTANCE.getState_OwnedEntry();

		/**
		 * The meta object literal for the '<em><b>Owned Exit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_EXIT = eINSTANCE.getState_OwnedExit();

		/**
		 * The meta object literal for the '<em><b>Owned Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_REGIONS = eINSTANCE.getState_OwnedRegions();

		/**
		 * The meta object literal for the '<em><b>Owned State Invariant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNED_STATE_INVARIANT = eINSTANCE.getState_OwnedStateInvariant();

		/**
		 * The meta object literal for the '<em><b>Redefined State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__REDEFINED_STATE = eINSTANCE.getState_RedefinedState();

		/**
		 * The meta object literal for the '<em><b>Submachines</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUBMACHINES = eINSTANCE.getState_Submachines();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StateExpImpl <em>State Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StateExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStateExp()
		 * @generated
		 */
		EClass STATE_EXP = eINSTANCE.getStateExp();

		/**
		 * The meta object literal for the '<em><b>Referred State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_EXP__REFERRED_STATE = eINSTANCE.getStateExp_ReferredState();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATE_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getStateExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StateMachineImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>Extended State Machines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__EXTENDED_STATE_MACHINES = eINSTANCE.getStateMachine_ExtendedStateMachines();

		/**
		 * The meta object literal for the '<em><b>Owned Connection Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__OWNED_CONNECTION_POINTS = eINSTANCE.getStateMachine_OwnedConnectionPoints();

		/**
		 * The meta object literal for the '<em><b>Owned Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__OWNED_REGIONS = eINSTANCE.getStateMachine_OwnedRegions();

		/**
		 * The meta object literal for the '<em><b>Submachine States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__SUBMACHINE_STATES = eINSTANCE.getStateMachine_SubmachineStates();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StereotypeImpl <em>Stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StereotypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getStereotype();

		/**
		 * The meta object literal for the '<em><b>Owned Extenders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE__OWNED_EXTENDERS = eINSTANCE.getStereotype_OwnedExtenders();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StereotypeExtenderImpl <em>Stereotype Extender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StereotypeExtenderImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStereotypeExtender()
		 * @generated
		 */
		EClass STEREOTYPE_EXTENDER = eINSTANCE.getStereotypeExtender();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE_EXTENDER__CLASS = eINSTANCE.getStereotypeExtender_Class();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_EXTENDER__IS_REQUIRED = eINSTANCE.getStereotypeExtender_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Owning Stereotype</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE_EXTENDER__OWNING_STEREOTYPE = eINSTANCE.getStereotypeExtender_OwningStereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.StringLiteralExpImpl <em>String Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.StringLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TupleLiteralExpImpl <em>Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TupleLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTupleLiteralExp()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP__OWNED_PARTS = eINSTANCE.getTupleLiteralExp_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TupleLiteralPartImpl <em>Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TupleLiteralPartImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTupleLiteralPart()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_PART__OWNED_INIT = eINSTANCE.getTupleLiteralPart_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Initialiser Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TUPLE_LITERAL_PART___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTupleLiteralPart__ValidateCompatibleInitialiserType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TUPLE_LITERAL_PART___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTupleLiteralPart__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TupleTypeImpl <em>Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TupleTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TypeExpImpl <em>Type Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TypeExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTypeExp()
		 * @generated
		 */
		EClass TYPE_EXP = eINSTANCE.getTypeExp();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_EXP__REFERRED_TYPE = eINSTANCE.getTypeExp_ReferredType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.UnlimitedNaturalLiteralExpImpl <em>Unlimited Natural Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.UnlimitedNaturalLiteralExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getUnlimitedNaturalLiteralExp()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Unlimited Natural Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL = eINSTANCE.getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.UnspecifiedValueExpImpl <em>Unspecified Value Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.UnspecifiedValueExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getUnspecifiedValueExp()
		 * @generated
		 */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.VariableExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXP__IS_IMPLICIT = eINSTANCE.getVariableExp_IsImplicit();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.VertexImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__INCOMING_TRANSITIONS = eINSTANCE.getVertex_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__OUTGOING_TRANSITIONS = eINSTANCE.getVertex_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__OWNING_REGION = eINSTANCE.getVertex_OwningRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.util.Visitable
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.VoidTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.WildcardTypeImpl <em>Wildcard Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.WildcardTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getWildcardType()
		 * @generated
		 */
		EClass WILDCARD_TYPE = eINSTANCE.getWildcardType();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE__LOWER_BOUND = eINSTANCE.getWildcardType_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WILDCARD_TYPE__UPPER_BOUND = eINSTANCE.getWildcardType_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.utilities.Pivotable <em>Pivotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.utilities.Pivotable
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPivotable()
		 * @generated
		 */
		EClass PIVOTABLE = eINSTANCE.getPivotable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ClassImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Extenders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__EXTENDERS = eINSTANCE.getClass_Extenders();

		/**
		 * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__INSTANCE_CLASS_NAME = eINSTANCE.getClass_InstanceClassName();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ACTIVE = eINSTANCE.getClass_IsActive();

		/**
		 * The meta object literal for the '<em><b>Owned Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_INVARIANTS = eINSTANCE.getClass_OwnedInvariants();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_OPERATIONS = eINSTANCE.getClass_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Owned Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_PROPERTIES = eINSTANCE.getClass_OwnedProperties();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNING_PACKAGE = eINSTANCE.getClass_OwningPackage();

		/**
		 * The meta object literal for the '<em><b>Super Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER_CLASSES = eINSTANCE.getClass_SuperClasses();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClass__ValidateNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Invariant Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getClass__ValidateUniqueInvariantName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Is Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_INTERFACE = eINSTANCE.getClass_IsInterface();

		/**
		 * The meta object literal for the '<em><b>Owned Behaviors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_BEHAVIORS = eINSTANCE.getClass_OwnedBehaviors();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Flattened Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___FLATTENED_TYPE = eINSTANCE.getType__FlattenedType();

		/**
		 * The meta object literal for the '<em><b>Is Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_CLASS = eINSTANCE.getType__IsClass();

		/**
		 * The meta object literal for the '<em><b>Is Template Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___IS_TEMPLATE_PARAMETER = eINSTANCE.getType__IsTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Specialize In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___SPECIALIZE_IN__CALLEXP_TYPE = eINSTANCE.getType__SpecializeIn__CallExp_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TemplateableElementImpl <em>Templateable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TemplateableElementImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTemplateableElement()
		 * @generated
		 */
		EClass TEMPLATEABLE_ELEMENT = eINSTANCE.getTemplateableElement();

		/**
		 * The meta object literal for the '<em><b>Owned Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__OWNED_BINDINGS = eINSTANCE.getTemplateableElement_OwnedBindings();

		/**
		 * The meta object literal for the '<em><b>Owned Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__OWNED_SIGNATURE = eINSTANCE.getTemplateableElement_OwnedSignature();

		/**
		 * The meta object literal for the '<em><b>Unspecialized Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT = eINSTANCE.getTemplateableElement_UnspecializedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TransitionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__KIND = eINSTANCE.getTransition_Kind();

		/**
		 * The meta object literal for the '<em><b>Owned Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNED_EFFECT = eINSTANCE.getTransition_OwnedEffect();

		/**
		 * The meta object literal for the '<em><b>Owned Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNED_GUARD = eINSTANCE.getTransition_OwnedGuard();

		/**
		 * The meta object literal for the '<em><b>Owned Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNED_TRIGGERS = eINSTANCE.getTransition_OwnedTriggers();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNING_REGION = eINSTANCE.getTransition_OwningRegion();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TriggerImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__OWNING_STATE = eINSTANCE.getTrigger_OwningState();

		/**
		 * The meta object literal for the '<em><b>Owning Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__OWNING_TRANSITION = eINSTANCE.getTrigger_OwningTransition();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TemplateBindingImpl <em>Template Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TemplateBindingImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTemplateBinding()
		 * @generated
		 */
		EClass TEMPLATE_BINDING = eINSTANCE.getTemplateBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Substitutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__OWNED_SUBSTITUTIONS = eINSTANCE.getTemplateBinding_OwnedSubstitutions();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__OWNING_ELEMENT = eINSTANCE.getTemplateBinding_OwningElement();

		/**
		 * The meta object literal for the '<em><b>Template Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_BINDING__TEMPLATE_SIGNATURE = eINSTANCE.getTemplateBinding_TemplateSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TemplateSignatureImpl <em>Template Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TemplateSignatureImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTemplateSignature()
		 * @generated
		 */
		EClass TEMPLATE_SIGNATURE = eINSTANCE.getTemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__OWNED_PARAMETERS = eINSTANCE.getTemplateSignature_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SIGNATURE__OWNING_ELEMENT = eINSTANCE.getTemplateSignature_OwningElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TemplateParameterImpl <em>Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TemplateParameterImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTemplateParameter()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER = eINSTANCE.getTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Constraining Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__CONSTRAINING_CLASSES = eINSTANCE.getTemplateParameter_ConstrainingClasses();

		/**
		 * The meta object literal for the '<em><b>Owning Signature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER__OWNING_SIGNATURE = eINSTANCE.getTemplateParameter_OwningSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TemplateParameterSubstitutionImpl <em>Template Parameter Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TemplateParameterSubstitutionImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTemplateParameterSubstitution()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_SUBSTITUTION = eINSTANCE.getTemplateParameterSubstitution();

		/**
		 * The meta object literal for the '<em><b>Formal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL = eINSTANCE.getTemplateParameterSubstitution_Formal();

		/**
		 * The meta object literal for the '<em><b>Owned Wildcard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_WILDCARD = eINSTANCE.getTemplateParameterSubstitution_OwnedWildcard();

		/**
		 * The meta object literal for the '<em><b>Owning Binding</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__OWNING_BINDING = eINSTANCE.getTemplateParameterSubstitution_OwningBinding();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL = eINSTANCE.getTemplateParameterSubstitution_Actual();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PackageImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__URI = eINSTANCE.getPackage_URI();

		/**
		 * The meta object literal for the '<em><b>Imported Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__IMPORTED_PACKAGES = eINSTANCE.getPackage_ImportedPackages();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_PREFIX = eINSTANCE.getPackage_NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Owned Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_CLASSES = eINSTANCE.getPackage_OwnedClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_INSTANCES = eINSTANCE.getPackage_OwnedInstances();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_PACKAGES = eINSTANCE.getPackage_OwnedPackages();

		/**
		 * The meta object literal for the '<em><b>Owned Profile Applications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_PROFILE_APPLICATIONS = eINSTANCE.getPackage_OwnedProfileApplications();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNING_PACKAGE = eINSTANCE.getPackage_OwningPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.NamespaceImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '<em><b>Owned Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE__OWNED_CONSTRAINTS = eINSTANCE.getNamespace_OwnedConstraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PrecedenceImpl <em>Precedence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PrecedenceImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPrecedence()
		 * @generated
		 */
		EClass PRECEDENCE = eINSTANCE.getPrecedence();

		/**
		 * The meta object literal for the '<em><b>Associativity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ASSOCIATIVITY = eINSTANCE.getPrecedence_Associativity();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE__ORDER = eINSTANCE.getPrecedence_Order();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PrimitiveCompletePackageImpl <em>Primitive Complete Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PrimitiveCompletePackageImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPrimitiveCompletePackage()
		 * @generated
		 */
		EClass PRIMITIVE_COMPLETE_PACKAGE = eINSTANCE.getPrimitiveCompletePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PropertyImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__ASSOCIATION_CLASS = eINSTANCE.getProperty_AssociationClass();

		/**
		 * The meta object literal for the '<em><b>Is Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_READ_ONLY = eINSTANCE.getProperty_IsReadOnly();

		/**
		 * The meta object literal for the '<em><b>Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_COMPOSITE = eINSTANCE.getProperty_IsComposite();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DERIVED = eINSTANCE.getProperty_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OPPOSITE = eINSTANCE.getProperty_Opposite();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNED_EXPRESSION = eINSTANCE.getProperty_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNING_CLASS = eINSTANCE.getProperty_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Redefined Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__REDEFINED_PROPERTIES = eINSTANCE.getProperty_RedefinedProperties();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DEFAULT_VALUE = eINSTANCE.getProperty_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Default Value String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__DEFAULT_VALUE_STRING = eINSTANCE.getProperty_DefaultValueString();

		/**
		 * The meta object literal for the '<em><b>Is ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_ID = eINSTANCE.getProperty_IsID();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_IMPLICIT = eINSTANCE.getProperty_IsImplicit();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__KEYS = eINSTANCE.getProperty_Keys();

		/**
		 * The meta object literal for the '<em><b>Is Resolve Proxies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_RESOLVE_PROXIES = eINSTANCE.getProperty_IsResolveProxies();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_TRANSIENT = eINSTANCE.getProperty_IsTransient();

		/**
		 * The meta object literal for the '<em><b>Is Unsettable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_UNSETTABLE = eINSTANCE.getProperty_IsUnsettable();

		/**
		 * The meta object literal for the '<em><b>Is Volatile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_VOLATILE = eINSTANCE.getProperty_IsVolatile();

		/**
		 * The meta object literal for the '<em><b>Subsetted Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__SUBSETTED_PROPERTY = eINSTANCE.getProperty_SubsettedProperty();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__REFERRED_PROPERTY = eINSTANCE.getProperty_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Is Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___IS_ATTRIBUTE__PROPERTY = eINSTANCE.getProperty__IsAttribute__Property();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Default Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getProperty__ValidateCompatibleDefaultExpression__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.TypedElementImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Is Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__IS_MANY = eINSTANCE.getTypedElement_IsMany();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '<em><b>Compatible Body</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPED_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION = eINSTANCE.getTypedElement__CompatibleBody__ValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__IS_REQUIRED = eINSTANCE.getTypedElement_IsRequired();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.AssociationClassImpl <em>Association Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.AssociationClassImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getAssociationClass()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS = eINSTANCE.getAssociationClass();

		/**
		 * The meta object literal for the '<em><b>Unowned Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS__UNOWNED_ATTRIBUTES = eINSTANCE.getAssociationClass_UnownedAttributes();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OperationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNING_CLASS = eINSTANCE.getOperation_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Raised Exceptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__RAISED_EXCEPTIONS = eINSTANCE.getOperation_RaisedExceptions();

		/**
		 * The meta object literal for the '<em><b>Redefined Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__REDEFINED_OPERATIONS = eINSTANCE.getOperation_RedefinedOperations();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__BODY_EXPRESSION = eINSTANCE.getOperation_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Is Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_INVALIDATING = eINSTANCE.getOperation_IsInvalidating();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * @since 1.3
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_TRANSIENT = eINSTANCE.getOperation_IsTransient();

		/**
		 * The meta object literal for the '<em><b>Is Typeof</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_TYPEOF = eINSTANCE.getOperation_IsTypeof();

		/**
		 * The meta object literal for the '<em><b>Is Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__IS_VALIDATING = eINSTANCE.getOperation_IsValidating();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETERS = eINSTANCE.getOperation_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_POSTCONDITIONS = eINSTANCE.getOperation_OwnedPostconditions();

		/**
		 * The meta object literal for the '<em><b>Owned Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PRECONDITIONS = eINSTANCE.getOperation_OwnedPreconditions();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PRECEDENCE = eINSTANCE.getOperation_Precedence();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Return</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateCompatibleReturn__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Loadable Implementation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateLoadableImplementation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Precondition Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateUniquePreconditionName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Postcondition Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOperation__ValidateUniquePostconditionName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ParameterImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Is Typeof</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IS_TYPEOF = eINSTANCE.getParameter_IsTypeof();

		/**
		 * The meta object literal for the '<em><b>Owning Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OWNING_OPERATION = eINSTANCE.getParameter_OwningOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ParameterVariableImpl <em>Parameter Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.3
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ParameterVariableImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getParameterVariable()
		 * @generated
		 */
		EClass PARAMETER_VARIABLE = eINSTANCE.getParameterVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Has No Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER_VARIABLE___VALIDATE_HAS_NO_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getParameterVariable__ValidateHasNoInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.VariableDeclarationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE_VALUE = eINSTANCE.getVariableDeclaration_TypeValue();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_DECLARATION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableDeclaration__ValidateNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_DECLARATION___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableDeclaration__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_DECLARATION___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableDeclaration__ValidateTypeIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.OppositePropertyCallExpImpl <em>Opposite Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.OppositePropertyCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getOppositePropertyCallExp()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_CALL_EXP = eINSTANCE.getOppositePropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getOppositePropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unsafe Source Can Not Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_CALL_EXP___VALIDATE_UNSAFE_SOURCE_CAN_NOT_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyCallExp__ValidateUnsafeSourceCanNotBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CommentImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Annotated Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__ANNOTATED_ELEMENTS = eINSTANCE.getComment_AnnotatedElements();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__BODY = eINSTANCE.getComment_Body();

		/**
		 * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__OWNING_ELEMENT = eINSTANCE.getComment_OwningElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CompleteClassImpl <em>Complete Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CompleteClassImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCompleteClass()
		 * @generated
		 */
		EClass COMPLETE_CLASS = eINSTANCE.getCompleteClass();

		/**
		 * The meta object literal for the '<em><b>Owning Complete Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_CLASS__OWNING_COMPLETE_PACKAGE = eINSTANCE.getCompleteClass_OwningCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Partial Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_CLASS__PARTIAL_CLASSES = eINSTANCE.getCompleteClass_PartialClasses();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CompleteEnvironmentImpl <em>Complete Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CompleteEnvironmentImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCompleteEnvironment()
		 * @generated
		 */
		EClass COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Owned Complete Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ENVIRONMENT__OWNED_COMPLETE_MODEL = eINSTANCE.getCompleteEnvironment_OwnedCompleteModel();

		/**
		 * The meta object literal for the '<em><b>Owned Standard Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_ENVIRONMENT__OWNED_STANDARD_LIBRARY = eINSTANCE.getCompleteEnvironment_OwnedStandardLibrary();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl <em>Complete Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CompleteModelImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCompleteModel()
		 * @generated
		 */
		EClass COMPLETE_MODEL = eINSTANCE.getCompleteModel();

		/**
		 * The meta object literal for the '<em><b>Orphan Complete Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_MODEL__ORPHAN_COMPLETE_PACKAGE = eINSTANCE.getCompleteModel_OrphanCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Owned Complete Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES = eINSTANCE.getCompleteModel_OwnedCompletePackages();

		/**
		 * The meta object literal for the '<em><b>Owning Complete Environment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_MODEL__OWNING_COMPLETE_ENVIRONMENT = eINSTANCE.getCompleteModel_OwningCompleteEnvironment();

		/**
		 * The meta object literal for the '<em><b>Partial Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_MODEL__PARTIAL_MODELS = eINSTANCE.getCompleteModel_PartialModels();

		/**
		 * The meta object literal for the '<em><b>Primitive Complete Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_MODEL__PRIMITIVE_COMPLETE_PACKAGE = eINSTANCE.getCompleteModel_PrimitiveCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Get Owned Complete Package</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_MODEL___GET_OWNED_COMPLETE_PACKAGE__STRING = eINSTANCE.getCompleteModel__GetOwnedCompletePackage__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl <em>Complete Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CompletePackageImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCompletePackage()
		 * @generated
		 */
		EClass COMPLETE_PACKAGE = eINSTANCE.getCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Owned Complete Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__OWNED_COMPLETE_CLASSES = eINSTANCE.getCompletePackage_OwnedCompleteClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Complete Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES = eINSTANCE.getCompletePackage_OwnedCompletePackages();

		/**
		 * The meta object literal for the '<em><b>Owning Complete Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__OWNING_COMPLETE_MODEL = eINSTANCE.getCompletePackage_OwningCompleteModel();

		/**
		 * The meta object literal for the '<em><b>Owning Complete Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE = eINSTANCE.getCompletePackage_OwningCompletePackage();

		/**
		 * The meta object literal for the '<em><b>Partial Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_PACKAGE__PARTIAL_PACKAGES = eINSTANCE.getCompletePackage_PartialPackages();

		/**
		 * The meta object literal for the '<em><b>Get Owned Complete Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLETE_PACKAGE___GET_OWNED_COMPLETE_CLASS__STRING = eINSTANCE.getCompletePackage__GetOwnedCompleteClass__String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ConnectionPointReferenceImpl <em>Connection Point Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ConnectionPointReferenceImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getConnectionPointReference()
		 * @generated
		 */
		EClass CONNECTION_POINT_REFERENCE = eINSTANCE.getConnectionPointReference();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__ENTRIES = eINSTANCE.getConnectionPointReference_Entries();

		/**
		 * The meta object literal for the '<em><b>Exits</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__EXITS = eINSTANCE.getConnectionPointReference_Exits();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE__OWNING_STATE = eINSTANCE.getConnectionPointReference_OwningState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ConstraintImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Constrained Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONSTRAINED_ELEMENTS = eINSTANCE.getConstraint_ConstrainedElements();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONTEXT = eINSTANCE.getConstraint_Context();

		/**
		 * The meta object literal for the '<em><b>Is Callable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__IS_CALLABLE = eINSTANCE.getConstraint_IsCallable();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNED_SPECIFICATION = eINSTANCE.getConstraint_OwnedSpecification();

		/**
		 * The meta object literal for the '<em><b>Owning Post Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNING_POST_CONTEXT = eINSTANCE.getConstraint_OwningPostContext();

		/**
		 * The meta object literal for the '<em><b>Owning Pre Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNING_PRE_CONTEXT = eINSTANCE.getConstraint_OwningPreContext();

		/**
		 * The meta object literal for the '<em><b>Owning State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNING_STATE = eINSTANCE.getConstraint_OwningState();

		/**
		 * The meta object literal for the '<em><b>Owning Transition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNING_TRANSITION = eINSTANCE.getConstraint_OwningTransition();

		/**
		 * The meta object literal for the '<em><b>Redefined Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__REDEFINED_CONSTRAINTS = eINSTANCE.getConstraint_RedefinedConstraints();

		/**
		 * The meta object literal for the '<em><b>Validate Boolean Valued</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_BOOLEAN_VALUED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateBooleanValued__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT___VALIDATE_UNIQUE_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getConstraint__ValidateUniqueName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.ValueSpecificationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getValueSpecification()
		 * @generated
		 */
		EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Is Computable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_COMPUTABLE = eINSTANCE.getValueSpecification__IsComputable();

		/**
		 * The meta object literal for the '<em><b>Integer Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___INTEGER_VALUE = eINSTANCE.getValueSpecification__IntegerValue();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___BOOLEAN_VALUE = eINSTANCE.getValueSpecification__BooleanValue();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___STRING_VALUE = eINSTANCE.getValueSpecification__StringValue();

		/**
		 * The meta object literal for the '<em><b>Unlimited Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___UNLIMITED_VALUE = eINSTANCE.getValueSpecification__UnlimitedValue();

		/**
		 * The meta object literal for the '<em><b>Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SPECIFICATION___IS_NULL = eINSTANCE.getValueSpecification__IsNull();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.utilities.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.utilities.Nameable
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DetailImpl <em>Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DetailImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDetail()
		 * @generated
		 */
		EClass DETAIL = eINSTANCE.getDetail();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAIL__VALUES = eINSTANCE.getDetail_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DynamicBehaviorImpl <em>Dynamic Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DynamicBehaviorImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDynamicBehavior()
		 * @generated
		 */
		EClass DYNAMIC_BEHAVIOR = eINSTANCE.getDynamicBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DynamicElementImpl <em>Dynamic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DynamicElementImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDynamicElement()
		 * @generated
		 */
		EClass DYNAMIC_ELEMENT = eINSTANCE.getDynamicElement();

		/**
		 * The meta object literal for the '<em><b>Meta Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_ELEMENT__META_TYPE = eINSTANCE.getDynamicElement_MetaType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DynamicPropertyImpl <em>Dynamic Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DynamicPropertyImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDynamicProperty()
		 * @generated
		 */
		EClass DYNAMIC_PROPERTY = eINSTANCE.getDynamicProperty();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_PROPERTY__REFERRED_PROPERTY = eINSTANCE.getDynamicProperty_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PROPERTY__DEFAULT = eINSTANCE.getDynamicProperty_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DynamicTypeImpl <em>Dynamic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DynamicTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDynamicType()
		 * @generated
		 */
		EClass DYNAMIC_TYPE = eINSTANCE.getDynamicType();

		/**
		 * The meta object literal for the '<em><b>Owned Dynamic Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE__OWNED_DYNAMIC_PROPERTIES = eINSTANCE.getDynamicType_OwnedDynamicProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.DynamicValueSpecificationImpl <em>Dynamic Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.DynamicValueSpecificationImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getDynamicValueSpecification()
		 * @generated
		 */
		EClass DYNAMIC_VALUE_SPECIFICATION = eINSTANCE.getDynamicValueSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.AnyTypeImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.AssociationClassCallExpImpl <em>Association Class Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.AssociationClassCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getAssociationClassCallExp()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS_CALL_EXP = eINSTANCE.getAssociationClassCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS = eINSTANCE.getAssociationClassCallExp_ReferredAssociationClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.NavigationCallExpImpl <em>Navigation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.NavigationCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getNavigationCallExp()
		 * @generated
		 */
		EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

		/**
		 * The meta object literal for the '<em><b>Navigation Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = eINSTANCE.getNavigationCallExp_NavigationSource();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_CALL_EXP__QUALIFIERS = eINSTANCE.getNavigationCallExp_Qualifiers();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.FeatureCallExpImpl <em>Feature Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.FeatureCallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getFeatureCallExp()
		 * @generated
		 */
		EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CALL_EXP__IS_PRE = eINSTANCE.getFeatureCallExp_IsPre();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.FinalStateImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.CallExpImpl
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_EXP__IS_IMPLICIT = eINSTANCE.getCallExp_IsImplicit();

		/**
		 * The meta object literal for the '<em><b>Is Safe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_EXP__IS_SAFE = eINSTANCE.getCallExp_IsSafe();

		/**
		 * The meta object literal for the '<em><b>Owned Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__OWNED_SOURCE = eINSTANCE.getCallExp_OwnedSource();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Can Be Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CALL_EXP___VALIDATE_SAFE_SOURCE_CAN_BE_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCallExp__ValidateSafeSourceCanBeNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Safe Source Cannot Be Map</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CALL_EXP___VALIDATE_SAFE_SOURCE_CANNOT_BE_MAP__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCallExp__ValidateSafeSourceCannotBeMap__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Not Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CALL_EXP___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCallExp__ValidateTypeIsNotInvalid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.AssociativityKind <em>Associativity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.AssociativityKind
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getAssociativityKind()
		 * @generated
		 */
		EEnum ASSOCIATIVITY_KIND = eINSTANCE.getAssociativityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.CollectionKind <em>Collection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.CollectionKind
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.PseudostateKind <em>Pseudostate Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.PseudostateKind
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getPseudostateKind()
		 * @generated
		 */
		EEnum PSEUDOSTATE_KIND = eINSTANCE.getPseudostateKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.TransitionKind <em>Transition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.TransitionKind
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getTransitionKind()
		 * @generated
		 */
		EEnum TRANSITION_KIND = eINSTANCE.getTransitionKind();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '<em>Ecore Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.EObject
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getEcoreObject()
		 * @generated
		 */
		EDataType ECORE_OBJECT = eINSTANCE.getEcoreObject();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>Library Feature</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.library.LibraryFeature
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getLibraryFeature()
		 * @generated
		 */
		EDataType LIBRARY_FEATURE = eINSTANCE.getLibraryFeature();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getReal()
		 * @generated
		 */
		EDataType REAL = eINSTANCE.getReal();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em>Unlimited Natural</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.pivot.internal.PivotPackageImpl#getUnlimitedNatural()
		 * @generated
		 */
		EDataType UNLIMITED_NATURAL = eINSTANCE.getUnlimitedNatural();

	}

} //PivotPackage
