/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.AlfPackage
 * @generated
 */
public interface AlfFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlfFactory eINSTANCE = org.eclipse.papyrus.uml.alf.impl.AlfFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Assigned Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assigned Source</em>'.
	 * @generated
	 */
	AssignedSource createAssignedSource();

	/**
	 * Returns a new object of class '<em>Internal Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Element Reference</em>'.
	 * @generated
	 */
	InternalElementReference createInternalElementReference();

	/**
	 * Returns a new object of class '<em>External Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Element Reference</em>'.
	 * @generated
	 */
	ExternalElementReference createExternalElementReference();

	/**
	 * Returns a new object of class '<em>External Enumeration Literal Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Enumeration Literal Reference</em>'.
	 * @generated
	 */
	ExternalEnumerationLiteralReference createExternalEnumerationLiteralReference();

	/**
	 * Returns a new object of class '<em>Bound Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Element Reference</em>'.
	 * @generated
	 */
	BoundElementReference createBoundElementReference();

	/**
	 * Returns a new object of class '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Expansion Expression</em>'.
	 * @generated
	 */
	SequenceExpansionExpression createSequenceExpansionExpression();

	/**
	 * Returns a new object of class '<em>Assignable Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignable Element Reference</em>'.
	 * @generated
	 */
	AssignableElementReference createAssignableElementReference();

	/**
	 * Returns a new object of class '<em>Expression Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Reference</em>'.
	 * @generated
	 */
	ExpressionReference createExpressionReference();

	/**
	 * Returns a new object of class '<em>Extent Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extent Or Expression</em>'.
	 * @generated
	 */
	ExtentOrExpression createExtentOrExpression();

	/**
	 * Returns a new object of class '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Name</em>'.
	 * @generated
	 */
	QualifiedName createQualifiedName();

	/**
	 * Returns a new object of class '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Reference</em>'.
	 * @generated
	 */
	FeatureReference createFeatureReference();

	/**
	 * Returns a new object of class '<em>Name Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Binding</em>'.
	 * @generated
	 */
	NameBinding createNameBinding();

	/**
	 * Returns a new object of class '<em>Named Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Template Binding</em>'.
	 * @generated
	 */
	NamedTemplateBinding createNamedTemplateBinding();

	/**
	 * Returns a new object of class '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Substitution</em>'.
	 * @generated
	 */
	TemplateParameterSubstitution createTemplateParameterSubstitution();

	/**
	 * Returns a new object of class '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Unary Expression</em>'.
	 * @generated
	 */
	NumericUnaryExpression createNumericUnaryExpression();

	/**
	 * Returns a new object of class '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For All Or Exists Or One Expression</em>'.
	 * @generated
	 */
	ForAllOrExistsOrOneExpression createForAllOrExistsOrOneExpression();

	/**
	 * Returns a new object of class '<em>Isolation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Isolation Expression</em>'.
	 * @generated
	 */
	IsolationExpression createIsolationExpression();

	/**
	 * Returns a new object of class '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Unary Expression</em>'.
	 * @generated
	 */
	BooleanUnaryExpression createBooleanUnaryExpression();

	/**
	 * Returns a new object of class '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cast Expression</em>'.
	 * @generated
	 */
	CastExpression createCastExpression();

	/**
	 * Returns a new object of class '<em>Positional Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Positional Tuple</em>'.
	 * @generated
	 */
	PositionalTuple createPositionalTuple();

	/**
	 * Returns a new object of class '<em>Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Expression</em>'.
	 * @generated
	 */
	NamedExpression createNamedExpression();

	/**
	 * Returns a new object of class '<em>Input Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Named Expression</em>'.
	 * @generated
	 */
	InputNamedExpression createInputNamedExpression();

	/**
	 * Returns a new object of class '<em>Output Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Named Expression</em>'.
	 * @generated
	 */
	OutputNamedExpression createOutputNamedExpression();

	/**
	 * Returns a new object of class '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Access Expression</em>'.
	 * @generated
	 */
	SequenceAccessExpression createSequenceAccessExpression();

	/**
	 * Returns a new object of class '<em>String Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Expression</em>'.
	 * @generated
	 */
	StringLiteralExpression createStringLiteralExpression();

	/**
	 * Returns a new object of class '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Operation Expression</em>'.
	 * @generated
	 */
	SequenceOperationExpression createSequenceOperationExpression();

	/**
	 * Returns a new object of class '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Or Reject Expression</em>'.
	 * @generated
	 */
	SelectOrRejectExpression createSelectOrRejectExpression();

	/**
	 * Returns a new object of class '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Extent Expression</em>'.
	 * @generated
	 */
	ClassExtentExpression createClassExtentExpression();

	/**
	 * Returns a new object of class '<em>Positional Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Positional Template Binding</em>'.
	 * @generated
	 */
	PositionalTemplateBinding createPositionalTemplateBinding();

	/**
	 * Returns a new object of class '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Logical Expression</em>'.
	 * @generated
	 */
	ConditionalLogicalExpression createConditionalLogicalExpression();

	/**
	 * Returns a new object of class '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Operation Expression</em>'.
	 * @generated
	 */
	LinkOperationExpression createLinkOperationExpression();

	/**
	 * Returns a new object of class '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Expression</em>'.
	 * @generated
	 */
	EqualityExpression createEqualityExpression();

	/**
	 * Returns a new object of class '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment Expression</em>'.
	 * @generated
	 */
	AssignmentExpression createAssignmentExpression();

	/**
	 * Returns a new object of class '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Expression</em>'.
	 * @generated
	 */
	LogicalExpression createLogicalExpression();

	/**
	 * Returns a new object of class '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Construction Expression</em>'.
	 * @generated
	 */
	SequenceConstructionExpression createSequenceConstructionExpression();

	/**
	 * Returns a new object of class '<em>Collect Or Iterate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collect Or Iterate Expression</em>'.
	 * @generated
	 */
	CollectOrIterateExpression createCollectOrIterateExpression();

	/**
	 * Returns a new object of class '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Unique Expression</em>'.
	 * @generated
	 */
	IsUniqueExpression createIsUniqueExpression();

	/**
	 * Returns a new object of class '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arithmetic Expression</em>'.
	 * @generated
	 */
	ArithmeticExpression createArithmeticExpression();

	/**
	 * Returns a new object of class '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Left Hand Side</em>'.
	 * @generated
	 */
	FeatureLeftHandSide createFeatureLeftHandSide();

	/**
	 * Returns a new object of class '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Test Expression</em>'.
	 * @generated
	 */
	ConditionalTestExpression createConditionalTestExpression();

	/**
	 * Returns a new object of class '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Creation Expression</em>'.
	 * @generated
	 */
	InstanceCreationExpression createInstanceCreationExpression();

	/**
	 * Returns a new object of class '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Access Expression</em>'.
	 * @generated
	 */
	PropertyAccessExpression createPropertyAccessExpression();

	/**
	 * Returns a new object of class '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Expression</em>'.
	 * @generated
	 */
	NameExpression createNameExpression();

	/**
	 * Returns a new object of class '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bit String Unary Expression</em>'.
	 * @generated
	 */
	BitStringUnaryExpression createBitStringUnaryExpression();

	/**
	 * Returns a new object of class '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Invocation Expression</em>'.
	 * @generated
	 */
	FeatureInvocationExpression createFeatureInvocationExpression();

	/**
	 * Returns a new object of class '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Invocation Expression</em>'.
	 * @generated
	 */
	BehaviorInvocationExpression createBehaviorInvocationExpression();

	/**
	 * Returns a new object of class '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shift Expression</em>'.
	 * @generated
	 */
	ShiftExpression createShiftExpression();

	/**
	 * Returns a new object of class '<em>Unbounded Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unbounded Literal Expression</em>'.
	 * @generated
	 */
	UnboundedLiteralExpression createUnboundedLiteralExpression();

	/**
	 * Returns a new object of class '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Expression</em>'.
	 * @generated
	 */
	ThisExpression createThisExpression();

	/**
	 * Returns a new object of class '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classification Expression</em>'.
	 * @generated
	 */
	ClassificationExpression createClassificationExpression();

	/**
	 * Returns a new object of class '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Invocation Expression</em>'.
	 * @generated
	 */
	SuperInvocationExpression createSuperInvocationExpression();

	/**
	 * Returns a new object of class '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Increment Or Decrement Expression</em>'.
	 * @generated
	 */
	IncrementOrDecrementExpression createIncrementOrDecrementExpression();

	/**
	 * Returns a new object of class '<em>Boolean Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Expression</em>'.
	 * @generated
	 */
	BooleanLiteralExpression createBooleanLiteralExpression();

	/**
	 * Returns a new object of class '<em>Named Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Tuple</em>'.
	 * @generated
	 */
	NamedTuple createNamedTuple();

	/**
	 * Returns a new object of class '<em>Natural Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Natural Literal Expression</em>'.
	 * @generated
	 */
	NaturalLiteralExpression createNaturalLiteralExpression();

	/**
	 * Returns a new object of class '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Range</em>'.
	 * @generated
	 */
	SequenceRange createSequenceRange();

	/**
	 * Returns a new object of class '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Left Hand Side</em>'.
	 * @generated
	 */
	NameLeftHandSide createNameLeftHandSide();

	/**
	 * Returns a new object of class '<em>Effective Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Effective Left Hand Side</em>'.
	 * @generated
	 */
	EffectiveLeftHandSide createEffectiveLeftHandSide();

	/**
	 * Returns a new object of class '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Reduction Expression</em>'.
	 * @generated
	 */
	SequenceReductionExpression createSequenceReductionExpression();

	/**
	 * Returns a new object of class '<em>Sequence Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Expression List</em>'.
	 * @generated
	 */
	SequenceExpressionList createSequenceExpressionList();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Name Declaration Statement</em>'.
	 * @generated
	 */
	LocalNameDeclarationStatement createLocalNameDeclarationStatement();

	/**
	 * Returns a new object of class '<em>Assignable Local Name Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignable Local Name Declaration</em>'.
	 * @generated
	 */
	AssignableLocalNameDeclaration createAssignableLocalNameDeclaration();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Qualified Name List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Name List</em>'.
	 * @generated
	 */
	QualifiedNameList createQualifiedNameList();

	/**
	 * Returns a new object of class '<em>Non Final Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Final Clause</em>'.
	 * @generated
	 */
	NonFinalClause createNonFinalClause();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Statement</em>'.
	 * @generated
	 */
	BlockStatement createBlockStatement();

	/**
	 * Returns a new object of class '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do Statement</em>'.
	 * @generated
	 */
	DoStatement createDoStatement();

	/**
	 * Returns a new object of class '<em>Concurrent Clauses</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concurrent Clauses</em>'.
	 * @generated
	 */
	ConcurrentClauses createConcurrentClauses();

	/**
	 * Returns a new object of class '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Statement</em>'.
	 * @generated
	 */
	BreakStatement createBreakStatement();

	/**
	 * Returns a new object of class '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Statement</em>'.
	 * @generated
	 */
	ExpressionStatement createExpressionStatement();

	/**
	 * Returns a new object of class '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classify Statement</em>'.
	 * @generated
	 */
	ClassifyStatement createClassifyStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Variable Definition</em>'.
	 * @generated
	 */
	LoopVariableDefinition createLoopVariableDefinition();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Statement</em>'.
	 * @generated
	 */
	SwitchStatement createSwitchStatement();

	/**
	 * Returns a new object of class '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Clause</em>'.
	 * @generated
	 */
	SwitchClause createSwitchClause();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

	/**
	 * Returns a new object of class '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Statement</em>'.
	 * @generated
	 */
	ReturnStatement createReturnStatement();

	/**
	 * Returns a new object of class '<em>In Line Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Line Statement</em>'.
	 * @generated
	 */
	InLineStatement createInLineStatement();

	/**
	 * Returns a new object of class '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Accept Statement</em>'.
	 * @generated
	 */
	AcceptStatement createAcceptStatement();

	/**
	 * Returns a new object of class '<em>Accept Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Accept Block</em>'.
	 * @generated
	 */
	AcceptBlock createAcceptBlock();

	/**
	 * Returns a new object of class '<em>Empty Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Statement</em>'.
	 * @generated
	 */
	EmptyStatement createEmptyStatement();

	/**
	 * Returns a new object of class '<em>Model Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Namespace</em>'.
	 * @generated
	 */
	ModelNamespace createModelNamespace();

	/**
	 * Returns a new object of class '<em>Namespace Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Namespace Definition</em>'.
	 * @generated
	 */
	NamespaceDefinition createNamespaceDefinition();

	/**
	 * Returns a new object of class '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Annotation</em>'.
	 * @generated
	 */
	StereotypeAnnotation createStereotypeAnnotation();

	/**
	 * Returns a new object of class '<em>Tagged Value List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Value List</em>'.
	 * @generated
	 */
	TaggedValueList createTaggedValueList();

	/**
	 * Returns a new object of class '<em>Tagged Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Value</em>'.
	 * @generated
	 */
	TaggedValue createTaggedValue();

	/**
	 * Returns a new object of class '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Definition</em>'.
	 * @generated
	 */
	UnitDefinition createUnitDefinition();

	/**
	 * Returns a new object of class '<em>Imported Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imported Member</em>'.
	 * @generated
	 */
	ImportedMember createImportedMember();

	/**
	 * Returns a new object of class '<em>Enumeration Literal Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal Name</em>'.
	 * @generated
	 */
	EnumerationLiteralName createEnumerationLiteralName();

	/**
	 * Returns a new object of class '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Definition</em>'.
	 * @generated
	 */
	OperationDefinition createOperationDefinition();

	/**
	 * Returns a new object of class '<em>Association Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Definition</em>'.
	 * @generated
	 */
	AssociationDefinition createAssociationDefinition();

	/**
	 * Returns a new object of class '<em>Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Definition</em>'.
	 * @generated
	 */
	ClassDefinition createClassDefinition();

	/**
	 * Returns a new object of class '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Element Definition</em>'.
	 * @generated
	 */
	TypedElementDefinition createTypedElementDefinition();

	/**
	 * Returns a new object of class '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Definition</em>'.
	 * @generated
	 */
	DataTypeDefinition createDataTypeDefinition();

	/**
	 * Returns a new object of class '<em>Package Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Definition</em>'.
	 * @generated
	 */
	PackageDefinition createPackageDefinition();

	/**
	 * Returns a new object of class '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Definition</em>'.
	 * @generated
	 */
	PropertyDefinition createPropertyDefinition();

	/**
	 * Returns a new object of class '<em>Signal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal Definition</em>'.
	 * @generated
	 */
	SignalDefinition createSignalDefinition();

	/**
	 * Returns a new object of class '<em>Active Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Class Definition</em>'.
	 * @generated
	 */
	ActiveClassDefinition createActiveClassDefinition();

	/**
	 * Returns a new object of class '<em>Activity Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Definition</em>'.
	 * @generated
	 */
	ActivityDefinition createActivityDefinition();

	/**
	 * Returns a new object of class '<em>Element Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Import Reference</em>'.
	 * @generated
	 */
	ElementImportReference createElementImportReference();

	/**
	 * Returns a new object of class '<em>Signal Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal Reception Definition</em>'.
	 * @generated
	 */
	SignalReceptionDefinition createSignalReceptionDefinition();

	/**
	 * Returns a new object of class '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Definition</em>'.
	 * @generated
	 */
	EnumerationDefinition createEnumerationDefinition();

	/**
	 * Returns a new object of class '<em>Package Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Import Reference</em>'.
	 * @generated
	 */
	PackageImportReference createPackageImportReference();

	/**
	 * Returns a new object of class '<em>Classifier Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Template Parameter</em>'.
	 * @generated
	 */
	ClassifierTemplateParameter createClassifierTemplateParameter();

	/**
	 * Returns a new object of class '<em>Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Formal Parameter</em>'.
	 * @generated
	 */
	FormalParameter createFormalParameter();

	/**
	 * Returns a new object of class '<em>Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reception Definition</em>'.
	 * @generated
	 */
	ReceptionDefinition createReceptionDefinition();

	/**
	 * Returns a new object of class '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member</em>'.
	 * @generated
	 */
	Member createMember();

	/**
	 * Returns a new object of class '<em>Annotated Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotated Statement</em>'.
	 * @generated
	 */
	AnnotatedStatement createAnnotatedStatement();

	/**
	 * Returns a new object of class '<em>Bound Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Classifier</em>'.
	 * @generated
	 */
	BoundClassifier createBoundClassifier();

	/**
	 * Returns a new object of class '<em>Return Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Parameter</em>'.
	 * @generated
	 */
	ReturnParameter createReturnParameter();

	/**
	 * Returns a new object of class '<em>Non Return Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Return Parameter</em>'.
	 * @generated
	 */
	NonReturnParameter createNonReturnParameter();

	/**
	 * Returns a new object of class '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Type</em>'.
	 * @generated
	 */
	AnyType createAnyType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AlfPackage getAlfPackage();

} // AlfFactory
