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

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.PivotPackage
 * @generated
 */
public interface PivotFactory
extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PivotFactory eINSTANCE = org.eclipse.ocl.pivot.internal.PivotFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	@NonNull Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	@NonNull Class createClass();

	/**
	 * Returns a new object of class '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Binding</em>'.
	 * @generated
	 */
	@NonNull TemplateBinding createTemplateBinding();

	/**
	 * Returns a new object of class '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Signature</em>'.
	 * @generated
	 */
	@NonNull TemplateSignature createTemplateSignature();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	@NonNull Transition createTransition();

	/**
	 * Returns a new object of class '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trigger</em>'.
	 * @generated
	 */
	@NonNull Trigger createTrigger();

	/**
	 * Returns a new object of class '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter</em>'.
	 * @generated
	 */
	@NonNull TemplateParameter createTemplateParameter();

	/**
	 * Returns a new object of class '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Substitution</em>'.
	 * @generated
	 */
	@NonNull TemplateParameterSubstitution createTemplateParameterSubstitution();

	/**
	 * Returns a new object of class '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
	@NonNull Package createPackage();

	/**
	 * Returns a new object of class '<em>Precedence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedence</em>'.
	 * @generated
	 */
	@NonNull Precedence createPrecedence();

	/**
	 * Returns a new object of class '<em>Primitive Complete Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Complete Package</em>'.
	 * @generated
	 */
	@NonNull PrimitiveCompletePackage createPrimitiveCompletePackage();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	@NonNull Property createProperty();

	/**
	 * Returns a new object of class '<em>Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Class</em>'.
	 * @generated
	 */
	@NonNull AssociationClass createAssociationClass();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	@NonNull Operation createOperation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	@NonNull Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Parameter Variable</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Variable</em>'.
	 * @generated
	 */
	@NonNull ParameterVariable createParameterVariable();

	/**
	 * Returns a new object of class '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Call Exp</em>'.
	 * @generated
	 */
	@NonNull OppositePropertyCallExp createOppositePropertyCallExp();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	@NonNull Comment createComment();

	/**
	 * Returns a new object of class '<em>Complete Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Class</em>'.
	 * @generated
	 */
	@NonNull CompleteClass createCompleteClass();

	/**
	 * Returns a new object of class '<em>Complete Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Environment</em>'.
	 * @generated
	 */
	@NonNull CompleteEnvironment createCompleteEnvironment();

	/**
	 * Returns a new object of class '<em>Complete Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Model</em>'.
	 * @generated
	 */
	@NonNull CompleteModel createCompleteModel();

	/**
	 * Returns a new object of class '<em>Complete Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Package</em>'.
	 * @generated
	 */
	@NonNull CompletePackage createCompletePackage();

	/**
	 * Returns a new object of class '<em>Connection Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Point Reference</em>'.
	 * @generated
	 */
	@NonNull ConnectionPointReference createConnectionPointReference();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	@NonNull Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detail</em>'.
	 * @generated
	 */
	@NonNull Detail createDetail();

	/**
	 * Returns a new object of class '<em>Dynamic Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Behavior</em>'.
	 * @generated
	 */
	@NonNull DynamicBehavior createDynamicBehavior();

	/**
	 * Returns a new object of class '<em>Dynamic Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Element</em>'.
	 * @generated
	 */
	@NonNull DynamicElement createDynamicElement();

	/**
	 * Returns a new object of class '<em>Dynamic Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Property</em>'.
	 * @generated
	 */
	@NonNull DynamicProperty createDynamicProperty();

	/**
	 * Returns a new object of class '<em>Dynamic Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Type</em>'.
	 * @generated
	 */
	@NonNull DynamicType createDynamicType();

	/**
	 * Returns a new object of class '<em>Dynamic Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Value Specification</em>'.
	 * @generated
	 */
	@NonNull DynamicValueSpecification createDynamicValueSpecification();

	/**
	 * Returns a new object of class '<em>Element Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Extension</em>'.
	 * @generated
	 */
	@NonNull ElementExtension createElementExtension();

	/**
	 * Returns a new object of class '<em>Element Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Literal Exp</em>'.
	 * @generated
	 */
	@NonNull ElementLiteralExp createElementLiteralExp();

	/**
	 * Returns a new object of class '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Type</em>'.
	 * @generated
	 */
	@NonNull AnyType createAnyType();

	/**
	 * Returns a new object of class '<em>Association Class Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Class Call Exp</em>'.
	 * @generated
	 */
	@NonNull AssociationClassCallExp createAssociationClassCallExp();

	/**
	 * Returns a new object of class '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type</em>'.
	 * @generated
	 */
	@NonNull BagType createBagType();

	/**
	 * Returns a new object of class '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type</em>'.
	 * @generated
	 */
	@NonNull CollectionType createCollectionType();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	@NonNull DataType createDataType();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp</em>'.
	 * @generated
	 */
	@NonNull BooleanLiteralExp createBooleanLiteralExp();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	@NonNull BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Operation Action</em>'.
	 * @generated
	 */
	@NonNull CallOperationAction createCallOperationAction();

	/**
	 * Returns a new object of class '<em>Collection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Item</em>'.
	 * @generated
	 */
	@NonNull CollectionItem createCollectionItem();

	/**
	 * Returns a new object of class '<em>Collection Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Literal Exp</em>'.
	 * @generated
	 */
	@NonNull CollectionLiteralExp createCollectionLiteralExp();

	/**
	 * Returns a new object of class '<em>Collection Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Range</em>'.
	 * @generated
	 */
	@NonNull CollectionRange createCollectionRange();

	/**
	 * Returns a new object of class '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Exp</em>'.
	 * @generated
	 */
	@NonNull EnumLiteralExp createEnumLiteralExp();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	@NonNull EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Expression In OCL</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression In OCL</em>'.
	 * @generated
	 */
	@NonNull ExpressionInOCL createExpressionInOCL();

	/**
	 * Returns a new object of class '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final State</em>'.
	 * @generated
	 */
	@NonNull FinalState createFinalState();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	@NonNull Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	@NonNull Variable createVariable();

	/**
	 * Returns a new object of class '<em>If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Exp</em>'.
	 * @generated
	 */
	@NonNull IfExp createIfExp();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	@NonNull Import createImport();

	/**
	 * Returns a new object of class '<em>Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Specification</em>'.
	 * @generated
	 */
	@NonNull InstanceSpecification createInstanceSpecification();

	/**
	 * Returns a new object of class '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal Exp</em>'.
	 * @generated
	 */
	@NonNull IntegerLiteralExp createIntegerLiteralExp();

	/**
	 * Returns a new object of class '<em>Invalid Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Literal Exp</em>'.
	 * @generated
	 */
	@NonNull InvalidLiteralExp createInvalidLiteralExp();

	/**
	 * Returns a new object of class '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Type</em>'.
	 * @generated
	 */
	@NonNull InvalidType createInvalidType();

	/**
	 * Returns a new object of class '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Exp</em>'.
	 * @generated
	 */
	@NonNull IterateExp createIterateExp();

	/**
	 * Returns a new object of class '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration</em>'.
	 * @generated
	 */
	@NonNull Iteration createIteration();

	/**
	 * Returns a new object of class '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Exp</em>'.
	 * @generated
	 */
	@NonNull IteratorExp createIteratorExp();

	/**
	 * Returns a new object of class '<em>Iterator Variable</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Variable</em>'.
	 * @generated
	 */
	@NonNull IteratorVariable createIteratorVariable();

	/**
	 * Returns a new object of class '<em>Lambda Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lambda Type</em>'.
	 * @generated
	 */
	@NonNull LambdaType createLambdaType();

	/**
	 * Returns a new object of class '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Exp</em>'.
	 * @generated
	 */
	@NonNull LetExp createLetExp();

	/**
	 * Returns a new object of class '<em>Let Variable</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Variable</em>'.
	 * @generated
	 */
	@NonNull LetVariable createLetVariable();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	@NonNull Library createLibrary();

	/**
	 * Returns a new object of class '<em>Map Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Literal Exp</em>'.
	 * @generated
	 */
	@NonNull MapLiteralExp createMapLiteralExp();

	/**
	 * Returns a new object of class '<em>Map Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Literal Part</em>'.
	 * @generated
	 */
	@NonNull MapLiteralPart createMapLiteralPart();

	/**
	 * Returns a new object of class '<em>Map Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Type</em>'.
	 * @generated
	 */
	@NonNull MapType createMapType();

	/**
	 * Returns a new object of class '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Exp</em>'.
	 * @generated
	 */
	@NonNull MessageExp createMessageExp();

	/**
	 * Returns a new object of class '<em>Send Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Signal Action</em>'.
	 * @generated
	 */
	@NonNull SendSignalAction createSendSignalAction();

	/**
	 * Returns a new object of class '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal</em>'.
	 * @generated
	 */
	@NonNull Signal createSignal();

	/**
	 * Returns a new object of class '<em>Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slot</em>'.
	 * @generated
	 */
	@NonNull Slot createSlot();

	/**
	 * Returns a new object of class '<em>Standard Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Standard Library</em>'.
	 * @generated
	 */
	@NonNull StandardLibrary createStandardLibrary();

	/**
	 * Returns a new object of class '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Type</em>'.
	 * @generated
	 */
	@NonNull MessageType createMessageType();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	@NonNull Model createModel();

	/**
	 * Returns a new object of class '<em>Null Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal Exp</em>'.
	 * @generated
	 */
	@NonNull NullLiteralExp createNullLiteralExp();

	/**
	 * Returns a new object of class '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Call Exp</em>'.
	 * @generated
	 */
	@NonNull OperationCallExp createOperationCallExp();

	/**
	 * Returns a new object of class '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type</em>'.
	 * @generated
	 */
	@NonNull OrderedSetType createOrderedSetType();

	/**
	 * Returns a new object of class '<em>Orphan Complete Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Orphan Complete Package</em>'.
	 * @generated
	 */
	@NonNull OrphanCompletePackage createOrphanCompletePackage();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	@NonNull PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile</em>'.
	 * @generated
	 */
	@NonNull Profile createProfile();

	/**
	 * Returns a new object of class '<em>Profile Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile Application</em>'.
	 * @generated
	 */
	@NonNull ProfileApplication createProfileApplication();

	/**
	 * Returns a new object of class '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Call Exp</em>'.
	 * @generated
	 */
	@NonNull PropertyCallExp createPropertyCallExp();

	/**
	 * Returns a new object of class '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pseudostate</em>'.
	 * @generated
	 */
	@NonNull Pseudostate createPseudostate();

	/**
	 * Returns a new object of class '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal Exp</em>'.
	 * @generated
	 */
	@NonNull RealLiteralExp createRealLiteralExp();

	/**
	 * Returns a new object of class '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Region</em>'.
	 * @generated
	 */
	@NonNull Region createRegion();

	/**
	 * Returns a new object of class '<em>Result Variable</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Variable</em>'.
	 * @generated
	 */
	@NonNull ResultVariable createResultVariable();

	/**
	 * Returns a new object of class '<em>Self Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Self Type</em>'.
	 * @generated
	 */
	@NonNull SelfType createSelfType();

	/**
	 * Returns a new object of class '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type</em>'.
	 * @generated
	 */
	@NonNull SequenceType createSequenceType();

	/**
	 * Returns a new object of class '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type</em>'.
	 * @generated
	 */
	@NonNull SetType createSetType();

	/**
	 * Returns a new object of class '<em>Shadow Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shadow Exp</em>'.
	 * @generated
	 */
	@NonNull ShadowExp createShadowExp();

	/**
	 * Returns a new object of class '<em>Shadow Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shadow Part</em>'.
	 * @generated
	 */
	@NonNull ShadowPart createShadowPart();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	@NonNull State createState();

	/**
	 * Returns a new object of class '<em>State Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Exp</em>'.
	 * @generated
	 */
	@NonNull StateExp createStateExp();

	/**
	 * Returns a new object of class '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine</em>'.
	 * @generated
	 */
	@NonNull StateMachine createStateMachine();

	/**
	 * Returns a new object of class '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype</em>'.
	 * @generated
	 */
	@NonNull Stereotype createStereotype();

	/**
	 * Returns a new object of class '<em>Stereotype Extender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Extender</em>'.
	 * @generated
	 */
	@NonNull StereotypeExtender createStereotypeExtender();

	/**
	 * Returns a new object of class '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Exp</em>'.
	 * @generated
	 */
	@NonNull StringLiteralExp createStringLiteralExp();

	/**
	 * Returns a new object of class '<em>Tuple Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Exp</em>'.
	 * @generated
	 */
	@NonNull TupleLiteralExp createTupleLiteralExp();

	/**
	 * Returns a new object of class '<em>Tuple Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Literal Part</em>'.
	 * @generated
	 */
	@NonNull TupleLiteralPart createTupleLiteralPart();

	/**
	 * Returns a new object of class '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type</em>'.
	 * @generated
	 */
	@NonNull TupleType createTupleType();

	/**
	 * Returns a new object of class '<em>Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Exp</em>'.
	 * @generated
	 */
	@NonNull TypeExp createTypeExp();

	/**
	 * Returns a new object of class '<em>Unlimited Natural Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlimited Natural Literal Exp</em>'.
	 * @generated
	 */
	@NonNull UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp();

	/**
	 * Returns a new object of class '<em>Unspecified Value Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unspecified Value Exp</em>'.
	 * @generated
	 */
	@NonNull UnspecifiedValueExp createUnspecifiedValueExp();

	/**
	 * Returns a new object of class '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Exp</em>'.
	 * @generated
	 */
	@NonNull VariableExp createVariableExp();

	/**
	 * Returns a new object of class '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Void Type</em>'.
	 * @generated
	 */
	@NonNull VoidType createVoidType();

	/**
	 * Returns a new object of class '<em>Wildcard Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Type</em>'.
	 * @generated
	 */
	@NonNull WildcardType createWildcardType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PivotPackage getPivotPackage();

} //PivotFactory
