/**
 */
package org.eclipse.papyrus.uml.alf.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.uml.alf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.AlfPackage
 * @generated
 */
public class AlfSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AlfPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlfSwitch() {
		if (modelPackage == null) {
			modelPackage = AlfPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AlfPackage.ASSIGNED_SOURCE: {
				AssignedSource assignedSource = (AssignedSource)theEObject;
				T result = caseAssignedSource(assignedSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SYNTAX_ELEMENT: {
				SyntaxElement syntaxElement = (SyntaxElement)theEObject;
				T result = caseSyntaxElement(syntaxElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ELEMENT_REFERENCE: {
				ElementReference elementReference = (ElementReference)theEObject;
				T result = caseElementReference(elementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE: {
				InternalElementReference internalElementReference = (InternalElementReference)theEObject;
				T result = caseInternalElementReference(internalElementReference);
				if (result == null) result = caseElementReference(internalElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXTERNAL_ELEMENT_REFERENCE: {
				ExternalElementReference externalElementReference = (ExternalElementReference)theEObject;
				T result = caseExternalElementReference(externalElementReference);
				if (result == null) result = caseElementReference(externalElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXTERNAL_ENUMERATION_LITERAL_REFERENCE: {
				ExternalEnumerationLiteralReference externalEnumerationLiteralReference = (ExternalEnumerationLiteralReference)theEObject;
				T result = caseExternalEnumerationLiteralReference(externalEnumerationLiteralReference);
				if (result == null) result = caseExternalElementReference(externalEnumerationLiteralReference);
				if (result == null) result = caseElementReference(externalEnumerationLiteralReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BOUND_ELEMENT_REFERENCE: {
				BoundElementReference boundElementReference = (BoundElementReference)theEObject;
				T result = caseBoundElementReference(boundElementReference);
				if (result == null) result = caseElementReference(boundElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.DOCUMENTED_ELEMENT: {
				DocumentedElement documentedElement = (DocumentedElement)theEObject;
				T result = caseDocumentedElement(documentedElement);
				if (result == null) result = caseSyntaxElement(documentedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION: {
				SequenceExpansionExpression sequenceExpansionExpression = (SequenceExpansionExpression)theEObject;
				T result = caseSequenceExpansionExpression(sequenceExpansionExpression);
				if (result == null) result = caseExpression(sequenceExpansionExpression);
				if (result == null) result = caseAssignableElement(sequenceExpansionExpression);
				if (result == null) result = caseSyntaxElement(sequenceExpansionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ASSIGNABLE_ELEMENT: {
				AssignableElement assignableElement = (AssignableElement)theEObject;
				T result = caseAssignableElement(assignableElement);
				if (result == null) result = caseSyntaxElement(assignableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ASSIGNABLE_ELEMENT_REFERENCE: {
				AssignableElementReference assignableElementReference = (AssignableElementReference)theEObject;
				T result = caseAssignableElementReference(assignableElementReference);
				if (result == null) result = caseAssignableElement(assignableElementReference);
				if (result == null) result = caseSyntaxElement(assignableElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseAssignableElement(expression);
				if (result == null) result = caseSyntaxElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXPRESSION_REFERENCE: {
				ExpressionReference expressionReference = (ExpressionReference)theEObject;
				T result = caseExpressionReference(expressionReference);
				if (result == null) result = caseExpression(expressionReference);
				if (result == null) result = caseAssignableElement(expressionReference);
				if (result == null) result = caseSyntaxElement(expressionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXTENT_OR_EXPRESSION: {
				ExtentOrExpression extentOrExpression = (ExtentOrExpression)theEObject;
				T result = caseExtentOrExpression(extentOrExpression);
				if (result == null) result = caseExpression(extentOrExpression);
				if (result == null) result = caseAssignableElement(extentOrExpression);
				if (result == null) result = caseSyntaxElement(extentOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.QUALIFIED_NAME: {
				QualifiedName qualifiedName = (QualifiedName)theEObject;
				T result = caseQualifiedName(qualifiedName);
				if (result == null) result = caseSyntaxElement(qualifiedName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FEATURE_REFERENCE: {
				FeatureReference featureReference = (FeatureReference)theEObject;
				T result = caseFeatureReference(featureReference);
				if (result == null) result = caseExpression(featureReference);
				if (result == null) result = caseAssignableElement(featureReference);
				if (result == null) result = caseSyntaxElement(featureReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAME_BINDING: {
				NameBinding nameBinding = (NameBinding)theEObject;
				T result = caseNameBinding(nameBinding);
				if (result == null) result = caseSyntaxElement(nameBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TEMPLATE_BINDING: {
				TemplateBinding templateBinding = (TemplateBinding)theEObject;
				T result = caseTemplateBinding(templateBinding);
				if (result == null) result = caseSyntaxElement(templateBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAMED_TEMPLATE_BINDING: {
				NamedTemplateBinding namedTemplateBinding = (NamedTemplateBinding)theEObject;
				T result = caseNamedTemplateBinding(namedTemplateBinding);
				if (result == null) result = caseTemplateBinding(namedTemplateBinding);
				if (result == null) result = caseSyntaxElement(namedTemplateBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION: {
				TemplateParameterSubstitution templateParameterSubstitution = (TemplateParameterSubstitution)theEObject;
				T result = caseTemplateParameterSubstitution(templateParameterSubstitution);
				if (result == null) result = caseSyntaxElement(templateParameterSubstitution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NUMERIC_UNARY_EXPRESSION: {
				NumericUnaryExpression numericUnaryExpression = (NumericUnaryExpression)theEObject;
				T result = caseNumericUnaryExpression(numericUnaryExpression);
				if (result == null) result = caseUnaryExpression(numericUnaryExpression);
				if (result == null) result = caseExpression(numericUnaryExpression);
				if (result == null) result = caseAssignableElement(numericUnaryExpression);
				if (result == null) result = caseSyntaxElement(numericUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = caseAssignableElement(unaryExpression);
				if (result == null) result = caseSyntaxElement(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION: {
				ForAllOrExistsOrOneExpression forAllOrExistsOrOneExpression = (ForAllOrExistsOrOneExpression)theEObject;
				T result = caseForAllOrExistsOrOneExpression(forAllOrExistsOrOneExpression);
				if (result == null) result = caseSequenceExpansionExpression(forAllOrExistsOrOneExpression);
				if (result == null) result = caseExpression(forAllOrExistsOrOneExpression);
				if (result == null) result = caseAssignableElement(forAllOrExistsOrOneExpression);
				if (result == null) result = caseSyntaxElement(forAllOrExistsOrOneExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ISOLATION_EXPRESSION: {
				IsolationExpression isolationExpression = (IsolationExpression)theEObject;
				T result = caseIsolationExpression(isolationExpression);
				if (result == null) result = caseUnaryExpression(isolationExpression);
				if (result == null) result = caseExpression(isolationExpression);
				if (result == null) result = caseAssignableElement(isolationExpression);
				if (result == null) result = caseSyntaxElement(isolationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = caseExpression(binaryExpression);
				if (result == null) result = caseAssignableElement(binaryExpression);
				if (result == null) result = caseSyntaxElement(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BOOLEAN_UNARY_EXPRESSION: {
				BooleanUnaryExpression booleanUnaryExpression = (BooleanUnaryExpression)theEObject;
				T result = caseBooleanUnaryExpression(booleanUnaryExpression);
				if (result == null) result = caseUnaryExpression(booleanUnaryExpression);
				if (result == null) result = caseExpression(booleanUnaryExpression);
				if (result == null) result = caseAssignableElement(booleanUnaryExpression);
				if (result == null) result = caseSyntaxElement(booleanUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CAST_EXPRESSION: {
				CastExpression castExpression = (CastExpression)theEObject;
				T result = caseCastExpression(castExpression);
				if (result == null) result = caseExpression(castExpression);
				if (result == null) result = caseAssignableElement(castExpression);
				if (result == null) result = caseSyntaxElement(castExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.POSITIONAL_TUPLE: {
				PositionalTuple positionalTuple = (PositionalTuple)theEObject;
				T result = casePositionalTuple(positionalTuple);
				if (result == null) result = caseTuple(positionalTuple);
				if (result == null) result = caseSyntaxElement(positionalTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TUPLE: {
				Tuple tuple = (Tuple)theEObject;
				T result = caseTuple(tuple);
				if (result == null) result = caseSyntaxElement(tuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAMED_EXPRESSION: {
				NamedExpression namedExpression = (NamedExpression)theEObject;
				T result = caseNamedExpression(namedExpression);
				if (result == null) result = caseSyntaxElement(namedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.INPUT_NAMED_EXPRESSION: {
				InputNamedExpression inputNamedExpression = (InputNamedExpression)theEObject;
				T result = caseInputNamedExpression(inputNamedExpression);
				if (result == null) result = caseSyntaxElement(inputNamedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.INVOCATION_EXPRESSION: {
				InvocationExpression invocationExpression = (InvocationExpression)theEObject;
				T result = caseInvocationExpression(invocationExpression);
				if (result == null) result = caseExpression(invocationExpression);
				if (result == null) result = caseAssignableElement(invocationExpression);
				if (result == null) result = caseSyntaxElement(invocationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.OUTPUT_NAMED_EXPRESSION: {
				OutputNamedExpression outputNamedExpression = (OutputNamedExpression)theEObject;
				T result = caseOutputNamedExpression(outputNamedExpression);
				if (result == null) result = caseInputNamedExpression(outputNamedExpression);
				if (result == null) result = caseSyntaxElement(outputNamedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LEFT_HAND_SIDE: {
				LeftHandSide leftHandSide = (LeftHandSide)theEObject;
				T result = caseLeftHandSide(leftHandSide);
				if (result == null) result = caseAssignableElement(leftHandSide);
				if (result == null) result = caseSyntaxElement(leftHandSide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION: {
				SequenceAccessExpression sequenceAccessExpression = (SequenceAccessExpression)theEObject;
				T result = caseSequenceAccessExpression(sequenceAccessExpression);
				if (result == null) result = caseExpression(sequenceAccessExpression);
				if (result == null) result = caseAssignableElement(sequenceAccessExpression);
				if (result == null) result = caseSyntaxElement(sequenceAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.STRING_LITERAL_EXPRESSION: {
				StringLiteralExpression stringLiteralExpression = (StringLiteralExpression)theEObject;
				T result = caseStringLiteralExpression(stringLiteralExpression);
				if (result == null) result = caseLiteralExpression(stringLiteralExpression);
				if (result == null) result = caseExpression(stringLiteralExpression);
				if (result == null) result = caseAssignableElement(stringLiteralExpression);
				if (result == null) result = caseSyntaxElement(stringLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LITERAL_EXPRESSION: {
				LiteralExpression literalExpression = (LiteralExpression)theEObject;
				T result = caseLiteralExpression(literalExpression);
				if (result == null) result = caseExpression(literalExpression);
				if (result == null) result = caseAssignableElement(literalExpression);
				if (result == null) result = caseSyntaxElement(literalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION: {
				SequenceOperationExpression sequenceOperationExpression = (SequenceOperationExpression)theEObject;
				T result = caseSequenceOperationExpression(sequenceOperationExpression);
				if (result == null) result = caseInvocationExpression(sequenceOperationExpression);
				if (result == null) result = caseExpression(sequenceOperationExpression);
				if (result == null) result = caseAssignableElement(sequenceOperationExpression);
				if (result == null) result = caseSyntaxElement(sequenceOperationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SELECT_OR_REJECT_EXPRESSION: {
				SelectOrRejectExpression selectOrRejectExpression = (SelectOrRejectExpression)theEObject;
				T result = caseSelectOrRejectExpression(selectOrRejectExpression);
				if (result == null) result = caseSequenceExpansionExpression(selectOrRejectExpression);
				if (result == null) result = caseExpression(selectOrRejectExpression);
				if (result == null) result = caseAssignableElement(selectOrRejectExpression);
				if (result == null) result = caseSyntaxElement(selectOrRejectExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASS_EXTENT_EXPRESSION: {
				ClassExtentExpression classExtentExpression = (ClassExtentExpression)theEObject;
				T result = caseClassExtentExpression(classExtentExpression);
				if (result == null) result = caseExpression(classExtentExpression);
				if (result == null) result = caseAssignableElement(classExtentExpression);
				if (result == null) result = caseSyntaxElement(classExtentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING: {
				PositionalTemplateBinding positionalTemplateBinding = (PositionalTemplateBinding)theEObject;
				T result = casePositionalTemplateBinding(positionalTemplateBinding);
				if (result == null) result = caseTemplateBinding(positionalTemplateBinding);
				if (result == null) result = caseSyntaxElement(positionalTemplateBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CONDITIONAL_LOGICAL_EXPRESSION: {
				ConditionalLogicalExpression conditionalLogicalExpression = (ConditionalLogicalExpression)theEObject;
				T result = caseConditionalLogicalExpression(conditionalLogicalExpression);
				if (result == null) result = caseBinaryExpression(conditionalLogicalExpression);
				if (result == null) result = caseExpression(conditionalLogicalExpression);
				if (result == null) result = caseAssignableElement(conditionalLogicalExpression);
				if (result == null) result = caseSyntaxElement(conditionalLogicalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LINK_OPERATION_EXPRESSION: {
				LinkOperationExpression linkOperationExpression = (LinkOperationExpression)theEObject;
				T result = caseLinkOperationExpression(linkOperationExpression);
				if (result == null) result = caseInvocationExpression(linkOperationExpression);
				if (result == null) result = caseExpression(linkOperationExpression);
				if (result == null) result = caseAssignableElement(linkOperationExpression);
				if (result == null) result = caseSyntaxElement(linkOperationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EQUALITY_EXPRESSION: {
				EqualityExpression equalityExpression = (EqualityExpression)theEObject;
				T result = caseEqualityExpression(equalityExpression);
				if (result == null) result = caseBinaryExpression(equalityExpression);
				if (result == null) result = caseExpression(equalityExpression);
				if (result == null) result = caseAssignableElement(equalityExpression);
				if (result == null) result = caseSyntaxElement(equalityExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ASSIGNMENT_EXPRESSION: {
				AssignmentExpression assignmentExpression = (AssignmentExpression)theEObject;
				T result = caseAssignmentExpression(assignmentExpression);
				if (result == null) result = caseExpression(assignmentExpression);
				if (result == null) result = caseAssignableElement(assignmentExpression);
				if (result == null) result = caseSyntaxElement(assignmentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LOGICAL_EXPRESSION: {
				LogicalExpression logicalExpression = (LogicalExpression)theEObject;
				T result = caseLogicalExpression(logicalExpression);
				if (result == null) result = caseBinaryExpression(logicalExpression);
				if (result == null) result = caseExpression(logicalExpression);
				if (result == null) result = caseAssignableElement(logicalExpression);
				if (result == null) result = caseSyntaxElement(logicalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION: {
				SequenceConstructionExpression sequenceConstructionExpression = (SequenceConstructionExpression)theEObject;
				T result = caseSequenceConstructionExpression(sequenceConstructionExpression);
				if (result == null) result = caseExpression(sequenceConstructionExpression);
				if (result == null) result = caseAssignableElement(sequenceConstructionExpression);
				if (result == null) result = caseSyntaxElement(sequenceConstructionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_ELEMENTS: {
				SequenceElements sequenceElements = (SequenceElements)theEObject;
				T result = caseSequenceElements(sequenceElements);
				if (result == null) result = caseSyntaxElement(sequenceElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.COLLECT_OR_ITERATE_EXPRESSION: {
				CollectOrIterateExpression collectOrIterateExpression = (CollectOrIterateExpression)theEObject;
				T result = caseCollectOrIterateExpression(collectOrIterateExpression);
				if (result == null) result = caseSequenceExpansionExpression(collectOrIterateExpression);
				if (result == null) result = caseExpression(collectOrIterateExpression);
				if (result == null) result = caseAssignableElement(collectOrIterateExpression);
				if (result == null) result = caseSyntaxElement(collectOrIterateExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.IS_UNIQUE_EXPRESSION: {
				IsUniqueExpression isUniqueExpression = (IsUniqueExpression)theEObject;
				T result = caseIsUniqueExpression(isUniqueExpression);
				if (result == null) result = caseSequenceExpansionExpression(isUniqueExpression);
				if (result == null) result = caseExpression(isUniqueExpression);
				if (result == null) result = caseAssignableElement(isUniqueExpression);
				if (result == null) result = caseSyntaxElement(isUniqueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ARITHMETIC_EXPRESSION: {
				ArithmeticExpression arithmeticExpression = (ArithmeticExpression)theEObject;
				T result = caseArithmeticExpression(arithmeticExpression);
				if (result == null) result = caseBinaryExpression(arithmeticExpression);
				if (result == null) result = caseExpression(arithmeticExpression);
				if (result == null) result = caseAssignableElement(arithmeticExpression);
				if (result == null) result = caseSyntaxElement(arithmeticExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FEATURE_LEFT_HAND_SIDE: {
				FeatureLeftHandSide featureLeftHandSide = (FeatureLeftHandSide)theEObject;
				T result = caseFeatureLeftHandSide(featureLeftHandSide);
				if (result == null) result = caseLeftHandSide(featureLeftHandSide);
				if (result == null) result = caseAssignableElement(featureLeftHandSide);
				if (result == null) result = caseSyntaxElement(featureLeftHandSide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CONDITIONAL_TEST_EXPRESSION: {
				ConditionalTestExpression conditionalTestExpression = (ConditionalTestExpression)theEObject;
				T result = caseConditionalTestExpression(conditionalTestExpression);
				if (result == null) result = caseExpression(conditionalTestExpression);
				if (result == null) result = caseAssignableElement(conditionalTestExpression);
				if (result == null) result = caseSyntaxElement(conditionalTestExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.INSTANCE_CREATION_EXPRESSION: {
				InstanceCreationExpression instanceCreationExpression = (InstanceCreationExpression)theEObject;
				T result = caseInstanceCreationExpression(instanceCreationExpression);
				if (result == null) result = caseInvocationExpression(instanceCreationExpression);
				if (result == null) result = caseExpression(instanceCreationExpression);
				if (result == null) result = caseAssignableElement(instanceCreationExpression);
				if (result == null) result = caseSyntaxElement(instanceCreationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION: {
				PropertyAccessExpression propertyAccessExpression = (PropertyAccessExpression)theEObject;
				T result = casePropertyAccessExpression(propertyAccessExpression);
				if (result == null) result = caseExpression(propertyAccessExpression);
				if (result == null) result = caseAssignableElement(propertyAccessExpression);
				if (result == null) result = caseSyntaxElement(propertyAccessExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAME_EXPRESSION: {
				NameExpression nameExpression = (NameExpression)theEObject;
				T result = caseNameExpression(nameExpression);
				if (result == null) result = caseExpression(nameExpression);
				if (result == null) result = caseAssignableElement(nameExpression);
				if (result == null) result = caseSyntaxElement(nameExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BIT_STRING_UNARY_EXPRESSION: {
				BitStringUnaryExpression bitStringUnaryExpression = (BitStringUnaryExpression)theEObject;
				T result = caseBitStringUnaryExpression(bitStringUnaryExpression);
				if (result == null) result = caseUnaryExpression(bitStringUnaryExpression);
				if (result == null) result = caseExpression(bitStringUnaryExpression);
				if (result == null) result = caseAssignableElement(bitStringUnaryExpression);
				if (result == null) result = caseSyntaxElement(bitStringUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION: {
				FeatureInvocationExpression featureInvocationExpression = (FeatureInvocationExpression)theEObject;
				T result = caseFeatureInvocationExpression(featureInvocationExpression);
				if (result == null) result = caseInvocationExpression(featureInvocationExpression);
				if (result == null) result = caseExpression(featureInvocationExpression);
				if (result == null) result = caseAssignableElement(featureInvocationExpression);
				if (result == null) result = caseSyntaxElement(featureInvocationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION: {
				BehaviorInvocationExpression behaviorInvocationExpression = (BehaviorInvocationExpression)theEObject;
				T result = caseBehaviorInvocationExpression(behaviorInvocationExpression);
				if (result == null) result = caseInvocationExpression(behaviorInvocationExpression);
				if (result == null) result = caseExpression(behaviorInvocationExpression);
				if (result == null) result = caseAssignableElement(behaviorInvocationExpression);
				if (result == null) result = caseSyntaxElement(behaviorInvocationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SHIFT_EXPRESSION: {
				ShiftExpression shiftExpression = (ShiftExpression)theEObject;
				T result = caseShiftExpression(shiftExpression);
				if (result == null) result = caseBinaryExpression(shiftExpression);
				if (result == null) result = caseExpression(shiftExpression);
				if (result == null) result = caseAssignableElement(shiftExpression);
				if (result == null) result = caseSyntaxElement(shiftExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.UNBOUNDED_LITERAL_EXPRESSION: {
				UnboundedLiteralExpression unboundedLiteralExpression = (UnboundedLiteralExpression)theEObject;
				T result = caseUnboundedLiteralExpression(unboundedLiteralExpression);
				if (result == null) result = caseLiteralExpression(unboundedLiteralExpression);
				if (result == null) result = caseExpression(unboundedLiteralExpression);
				if (result == null) result = caseAssignableElement(unboundedLiteralExpression);
				if (result == null) result = caseSyntaxElement(unboundedLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.THIS_EXPRESSION: {
				ThisExpression thisExpression = (ThisExpression)theEObject;
				T result = caseThisExpression(thisExpression);
				if (result == null) result = caseExpression(thisExpression);
				if (result == null) result = caseAssignableElement(thisExpression);
				if (result == null) result = caseSyntaxElement(thisExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASSIFICATION_EXPRESSION: {
				ClassificationExpression classificationExpression = (ClassificationExpression)theEObject;
				T result = caseClassificationExpression(classificationExpression);
				if (result == null) result = caseUnaryExpression(classificationExpression);
				if (result == null) result = caseExpression(classificationExpression);
				if (result == null) result = caseAssignableElement(classificationExpression);
				if (result == null) result = caseSyntaxElement(classificationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SUPER_INVOCATION_EXPRESSION: {
				SuperInvocationExpression superInvocationExpression = (SuperInvocationExpression)theEObject;
				T result = caseSuperInvocationExpression(superInvocationExpression);
				if (result == null) result = caseInvocationExpression(superInvocationExpression);
				if (result == null) result = caseExpression(superInvocationExpression);
				if (result == null) result = caseAssignableElement(superInvocationExpression);
				if (result == null) result = caseSyntaxElement(superInvocationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION: {
				IncrementOrDecrementExpression incrementOrDecrementExpression = (IncrementOrDecrementExpression)theEObject;
				T result = caseIncrementOrDecrementExpression(incrementOrDecrementExpression);
				if (result == null) result = caseExpression(incrementOrDecrementExpression);
				if (result == null) result = caseAssignableElement(incrementOrDecrementExpression);
				if (result == null) result = caseSyntaxElement(incrementOrDecrementExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BOOLEAN_LITERAL_EXPRESSION: {
				BooleanLiteralExpression booleanLiteralExpression = (BooleanLiteralExpression)theEObject;
				T result = caseBooleanLiteralExpression(booleanLiteralExpression);
				if (result == null) result = caseLiteralExpression(booleanLiteralExpression);
				if (result == null) result = caseExpression(booleanLiteralExpression);
				if (result == null) result = caseAssignableElement(booleanLiteralExpression);
				if (result == null) result = caseSyntaxElement(booleanLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAMED_TUPLE: {
				NamedTuple namedTuple = (NamedTuple)theEObject;
				T result = caseNamedTuple(namedTuple);
				if (result == null) result = caseTuple(namedTuple);
				if (result == null) result = caseSyntaxElement(namedTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NATURAL_LITERAL_EXPRESSION: {
				NaturalLiteralExpression naturalLiteralExpression = (NaturalLiteralExpression)theEObject;
				T result = caseNaturalLiteralExpression(naturalLiteralExpression);
				if (result == null) result = caseLiteralExpression(naturalLiteralExpression);
				if (result == null) result = caseExpression(naturalLiteralExpression);
				if (result == null) result = caseAssignableElement(naturalLiteralExpression);
				if (result == null) result = caseSyntaxElement(naturalLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_RANGE: {
				SequenceRange sequenceRange = (SequenceRange)theEObject;
				T result = caseSequenceRange(sequenceRange);
				if (result == null) result = caseSequenceElements(sequenceRange);
				if (result == null) result = caseSyntaxElement(sequenceRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAME_LEFT_HAND_SIDE: {
				NameLeftHandSide nameLeftHandSide = (NameLeftHandSide)theEObject;
				T result = caseNameLeftHandSide(nameLeftHandSide);
				if (result == null) result = caseLeftHandSide(nameLeftHandSide);
				if (result == null) result = caseAssignableElement(nameLeftHandSide);
				if (result == null) result = caseSyntaxElement(nameLeftHandSide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE: {
				EffectiveLeftHandSide effectiveLeftHandSide = (EffectiveLeftHandSide)theEObject;
				T result = caseEffectiveLeftHandSide(effectiveLeftHandSide);
				if (result == null) result = caseNameLeftHandSide(effectiveLeftHandSide);
				if (result == null) result = caseLeftHandSide(effectiveLeftHandSide);
				if (result == null) result = caseAssignableElement(effectiveLeftHandSide);
				if (result == null) result = caseSyntaxElement(effectiveLeftHandSide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION: {
				SequenceReductionExpression sequenceReductionExpression = (SequenceReductionExpression)theEObject;
				T result = caseSequenceReductionExpression(sequenceReductionExpression);
				if (result == null) result = caseExpression(sequenceReductionExpression);
				if (result == null) result = caseAssignableElement(sequenceReductionExpression);
				if (result == null) result = caseSyntaxElement(sequenceReductionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SEQUENCE_EXPRESSION_LIST: {
				SequenceExpressionList sequenceExpressionList = (SequenceExpressionList)theEObject;
				T result = caseSequenceExpressionList(sequenceExpressionList);
				if (result == null) result = caseSequenceElements(sequenceExpressionList);
				if (result == null) result = caseSyntaxElement(sequenceExpressionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.RELATIONAL_EXPRESSION: {
				RelationalExpression relationalExpression = (RelationalExpression)theEObject;
				T result = caseRelationalExpression(relationalExpression);
				if (result == null) result = caseBinaryExpression(relationalExpression);
				if (result == null) result = caseExpression(relationalExpression);
				if (result == null) result = caseAssignableElement(relationalExpression);
				if (result == null) result = caseSyntaxElement(relationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT: {
				LocalNameDeclarationStatement localNameDeclarationStatement = (LocalNameDeclarationStatement)theEObject;
				T result = caseLocalNameDeclarationStatement(localNameDeclarationStatement);
				if (result == null) result = caseStatement(localNameDeclarationStatement);
				if (result == null) result = caseSyntaxElement(localNameDeclarationStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ASSIGNABLE_LOCAL_NAME_DECLARATION: {
				AssignableLocalNameDeclaration assignableLocalNameDeclaration = (AssignableLocalNameDeclaration)theEObject;
				T result = caseAssignableLocalNameDeclaration(assignableLocalNameDeclaration);
				if (result == null) result = caseAssignableElement(assignableLocalNameDeclaration);
				if (result == null) result = caseSyntaxElement(assignableLocalNameDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseSyntaxElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseSyntaxElement(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.QUALIFIED_NAME_LIST: {
				QualifiedNameList qualifiedNameList = (QualifiedNameList)theEObject;
				T result = caseQualifiedNameList(qualifiedNameList);
				if (result == null) result = caseSyntaxElement(qualifiedNameList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NON_FINAL_CLAUSE: {
				NonFinalClause nonFinalClause = (NonFinalClause)theEObject;
				T result = caseNonFinalClause(nonFinalClause);
				if (result == null) result = caseSyntaxElement(nonFinalClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseSyntaxElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = caseSyntaxElement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.DO_STATEMENT: {
				DoStatement doStatement = (DoStatement)theEObject;
				T result = caseDoStatement(doStatement);
				if (result == null) result = caseStatement(doStatement);
				if (result == null) result = caseSyntaxElement(doStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CONCURRENT_CLAUSES: {
				ConcurrentClauses concurrentClauses = (ConcurrentClauses)theEObject;
				T result = caseConcurrentClauses(concurrentClauses);
				if (result == null) result = caseSyntaxElement(concurrentClauses);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = caseSyntaxElement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseSyntaxElement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASSIFY_STATEMENT: {
				ClassifyStatement classifyStatement = (ClassifyStatement)theEObject;
				T result = caseClassifyStatement(classifyStatement);
				if (result == null) result = caseStatement(classifyStatement);
				if (result == null) result = caseSyntaxElement(classifyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = caseSyntaxElement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.LOOP_VARIABLE_DEFINITION: {
				LoopVariableDefinition loopVariableDefinition = (LoopVariableDefinition)theEObject;
				T result = caseLoopVariableDefinition(loopVariableDefinition);
				if (result == null) result = caseSyntaxElement(loopVariableDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseSyntaxElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = caseSyntaxElement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SWITCH_CLAUSE: {
				SwitchClause switchClause = (SwitchClause)theEObject;
				T result = caseSwitchClause(switchClause);
				if (result == null) result = caseSyntaxElement(switchClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = caseSyntaxElement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = caseSyntaxElement(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.IN_LINE_STATEMENT: {
				InLineStatement inLineStatement = (InLineStatement)theEObject;
				T result = caseInLineStatement(inLineStatement);
				if (result == null) result = caseStatement(inLineStatement);
				if (result == null) result = caseSyntaxElement(inLineStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ACCEPT_STATEMENT: {
				AcceptStatement acceptStatement = (AcceptStatement)theEObject;
				T result = caseAcceptStatement(acceptStatement);
				if (result == null) result = caseStatement(acceptStatement);
				if (result == null) result = caseSyntaxElement(acceptStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ACCEPT_BLOCK: {
				AcceptBlock acceptBlock = (AcceptBlock)theEObject;
				T result = caseAcceptBlock(acceptBlock);
				if (result == null) result = caseSyntaxElement(acceptBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.EMPTY_STATEMENT: {
				EmptyStatement emptyStatement = (EmptyStatement)theEObject;
				T result = caseEmptyStatement(emptyStatement);
				if (result == null) result = caseStatement(emptyStatement);
				if (result == null) result = caseSyntaxElement(emptyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.MODEL_NAMESPACE: {
				ModelNamespace modelNamespace = (ModelNamespace)theEObject;
				T result = caseModelNamespace(modelNamespace);
				if (result == null) result = casePackageDefinition(modelNamespace);
				if (result == null) result = caseNamespaceDefinition(modelNamespace);
				if (result == null) result = caseMemberDefinition(modelNamespace);
				if (result == null) result = caseSyntaxElement(modelNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NAMESPACE_DEFINITION: {
				NamespaceDefinition namespaceDefinition = (NamespaceDefinition)theEObject;
				T result = caseNamespaceDefinition(namespaceDefinition);
				if (result == null) result = caseMemberDefinition(namespaceDefinition);
				if (result == null) result = caseSyntaxElement(namespaceDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.MEMBER_DEFINITION: {
				MemberDefinition memberDefinition = (MemberDefinition)theEObject;
				T result = caseMemberDefinition(memberDefinition);
				if (result == null) result = caseSyntaxElement(memberDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.STEREOTYPE_ANNOTATION: {
				StereotypeAnnotation stereotypeAnnotation = (StereotypeAnnotation)theEObject;
				T result = caseStereotypeAnnotation(stereotypeAnnotation);
				if (result == null) result = caseSyntaxElement(stereotypeAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TAGGED_VALUE_LIST: {
				TaggedValueList taggedValueList = (TaggedValueList)theEObject;
				T result = caseTaggedValueList(taggedValueList);
				if (result == null) result = caseSyntaxElement(taggedValueList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TAGGED_VALUE: {
				TaggedValue taggedValue = (TaggedValue)theEObject;
				T result = caseTaggedValue(taggedValue);
				if (result == null) result = caseSyntaxElement(taggedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.UNIT_DEFINITION: {
				UnitDefinition unitDefinition = (UnitDefinition)theEObject;
				T result = caseUnitDefinition(unitDefinition);
				if (result == null) result = caseDocumentedElement(unitDefinition);
				if (result == null) result = caseSyntaxElement(unitDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.IMPORT_REFERENCE: {
				ImportReference importReference = (ImportReference)theEObject;
				T result = caseImportReference(importReference);
				if (result == null) result = caseSyntaxElement(importReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.IMPORTED_MEMBER: {
				ImportedMember importedMember = (ImportedMember)theEObject;
				T result = caseImportedMember(importedMember);
				if (result == null) result = caseMemberDefinition(importedMember);
				if (result == null) result = caseSyntaxElement(importedMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ENUMERATION_LITERAL_NAME: {
				EnumerationLiteralName enumerationLiteralName = (EnumerationLiteralName)theEObject;
				T result = caseEnumerationLiteralName(enumerationLiteralName);
				if (result == null) result = caseMemberDefinition(enumerationLiteralName);
				if (result == null) result = caseSyntaxElement(enumerationLiteralName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.OPERATION_DEFINITION: {
				OperationDefinition operationDefinition = (OperationDefinition)theEObject;
				T result = caseOperationDefinition(operationDefinition);
				if (result == null) result = caseNamespaceDefinition(operationDefinition);
				if (result == null) result = caseMemberDefinition(operationDefinition);
				if (result == null) result = caseSyntaxElement(operationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ASSOCIATION_DEFINITION: {
				AssociationDefinition associationDefinition = (AssociationDefinition)theEObject;
				T result = caseAssociationDefinition(associationDefinition);
				if (result == null) result = caseClassifierDefinition(associationDefinition);
				if (result == null) result = caseNamespaceDefinition(associationDefinition);
				if (result == null) result = caseMemberDefinition(associationDefinition);
				if (result == null) result = caseSyntaxElement(associationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASSIFIER_DEFINITION: {
				ClassifierDefinition classifierDefinition = (ClassifierDefinition)theEObject;
				T result = caseClassifierDefinition(classifierDefinition);
				if (result == null) result = caseNamespaceDefinition(classifierDefinition);
				if (result == null) result = caseMemberDefinition(classifierDefinition);
				if (result == null) result = caseSyntaxElement(classifierDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASS_DEFINITION: {
				ClassDefinition classDefinition = (ClassDefinition)theEObject;
				T result = caseClassDefinition(classDefinition);
				if (result == null) result = caseClassifierDefinition(classDefinition);
				if (result == null) result = caseNamespaceDefinition(classDefinition);
				if (result == null) result = caseMemberDefinition(classDefinition);
				if (result == null) result = caseSyntaxElement(classDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.TYPED_ELEMENT_DEFINITION: {
				TypedElementDefinition typedElementDefinition = (TypedElementDefinition)theEObject;
				T result = caseTypedElementDefinition(typedElementDefinition);
				if (result == null) result = caseAssignableElement(typedElementDefinition);
				if (result == null) result = caseSyntaxElement(typedElementDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.DATA_TYPE_DEFINITION: {
				DataTypeDefinition dataTypeDefinition = (DataTypeDefinition)theEObject;
				T result = caseDataTypeDefinition(dataTypeDefinition);
				if (result == null) result = caseClassifierDefinition(dataTypeDefinition);
				if (result == null) result = caseNamespaceDefinition(dataTypeDefinition);
				if (result == null) result = caseMemberDefinition(dataTypeDefinition);
				if (result == null) result = caseSyntaxElement(dataTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.PACKAGE_DEFINITION: {
				PackageDefinition packageDefinition = (PackageDefinition)theEObject;
				T result = casePackageDefinition(packageDefinition);
				if (result == null) result = caseNamespaceDefinition(packageDefinition);
				if (result == null) result = caseMemberDefinition(packageDefinition);
				if (result == null) result = caseSyntaxElement(packageDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.PROPERTY_DEFINITION: {
				PropertyDefinition propertyDefinition = (PropertyDefinition)theEObject;
				T result = casePropertyDefinition(propertyDefinition);
				if (result == null) result = caseMemberDefinition(propertyDefinition);
				if (result == null) result = caseSyntaxElement(propertyDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SIGNAL_DEFINITION: {
				SignalDefinition signalDefinition = (SignalDefinition)theEObject;
				T result = caseSignalDefinition(signalDefinition);
				if (result == null) result = caseClassifierDefinition(signalDefinition);
				if (result == null) result = caseNamespaceDefinition(signalDefinition);
				if (result == null) result = caseMemberDefinition(signalDefinition);
				if (result == null) result = caseSyntaxElement(signalDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ACTIVE_CLASS_DEFINITION: {
				ActiveClassDefinition activeClassDefinition = (ActiveClassDefinition)theEObject;
				T result = caseActiveClassDefinition(activeClassDefinition);
				if (result == null) result = caseClassDefinition(activeClassDefinition);
				if (result == null) result = caseClassifierDefinition(activeClassDefinition);
				if (result == null) result = caseNamespaceDefinition(activeClassDefinition);
				if (result == null) result = caseMemberDefinition(activeClassDefinition);
				if (result == null) result = caseSyntaxElement(activeClassDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ACTIVITY_DEFINITION: {
				ActivityDefinition activityDefinition = (ActivityDefinition)theEObject;
				T result = caseActivityDefinition(activityDefinition);
				if (result == null) result = caseClassifierDefinition(activityDefinition);
				if (result == null) result = caseNamespaceDefinition(activityDefinition);
				if (result == null) result = caseMemberDefinition(activityDefinition);
				if (result == null) result = caseSyntaxElement(activityDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ELEMENT_IMPORT_REFERENCE: {
				ElementImportReference elementImportReference = (ElementImportReference)theEObject;
				T result = caseElementImportReference(elementImportReference);
				if (result == null) result = caseImportReference(elementImportReference);
				if (result == null) result = caseSyntaxElement(elementImportReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.SIGNAL_RECEPTION_DEFINITION: {
				SignalReceptionDefinition signalReceptionDefinition = (SignalReceptionDefinition)theEObject;
				T result = caseSignalReceptionDefinition(signalReceptionDefinition);
				if (result == null) result = caseSignalDefinition(signalReceptionDefinition);
				if (result == null) result = caseClassifierDefinition(signalReceptionDefinition);
				if (result == null) result = caseNamespaceDefinition(signalReceptionDefinition);
				if (result == null) result = caseMemberDefinition(signalReceptionDefinition);
				if (result == null) result = caseSyntaxElement(signalReceptionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ENUMERATION_DEFINITION: {
				EnumerationDefinition enumerationDefinition = (EnumerationDefinition)theEObject;
				T result = caseEnumerationDefinition(enumerationDefinition);
				if (result == null) result = caseClassifierDefinition(enumerationDefinition);
				if (result == null) result = caseNamespaceDefinition(enumerationDefinition);
				if (result == null) result = caseMemberDefinition(enumerationDefinition);
				if (result == null) result = caseSyntaxElement(enumerationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.PACKAGE_IMPORT_REFERENCE: {
				PackageImportReference packageImportReference = (PackageImportReference)theEObject;
				T result = casePackageImportReference(packageImportReference);
				if (result == null) result = caseImportReference(packageImportReference);
				if (result == null) result = caseSyntaxElement(packageImportReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER: {
				ClassifierTemplateParameter classifierTemplateParameter = (ClassifierTemplateParameter)theEObject;
				T result = caseClassifierTemplateParameter(classifierTemplateParameter);
				if (result == null) result = caseClassifierDefinition(classifierTemplateParameter);
				if (result == null) result = caseNamespaceDefinition(classifierTemplateParameter);
				if (result == null) result = caseMemberDefinition(classifierTemplateParameter);
				if (result == null) result = caseSyntaxElement(classifierTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.FORMAL_PARAMETER: {
				FormalParameter formalParameter = (FormalParameter)theEObject;
				T result = caseFormalParameter(formalParameter);
				if (result == null) result = caseMemberDefinition(formalParameter);
				if (result == null) result = caseSyntaxElement(formalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.RECEPTION_DEFINITION: {
				ReceptionDefinition receptionDefinition = (ReceptionDefinition)theEObject;
				T result = caseReceptionDefinition(receptionDefinition);
				if (result == null) result = caseMemberDefinition(receptionDefinition);
				if (result == null) result = caseSyntaxElement(receptionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = caseDocumentedElement(member);
				if (result == null) result = caseSyntaxElement(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ANNOTATED_STATEMENT: {
				AnnotatedStatement annotatedStatement = (AnnotatedStatement)theEObject;
				T result = caseAnnotatedStatement(annotatedStatement);
				if (result == null) result = caseDocumentedElement(annotatedStatement);
				if (result == null) result = caseSyntaxElement(annotatedStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.BOUND_CLASSIFIER: {
				BoundClassifier boundClassifier = (BoundClassifier)theEObject;
				T result = caseBoundClassifier(boundClassifier);
				if (result == null) result = caseClassifierDefinition(boundClassifier);
				if (result == null) result = caseNamespaceDefinition(boundClassifier);
				if (result == null) result = caseMemberDefinition(boundClassifier);
				if (result == null) result = caseSyntaxElement(boundClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.RETURN_PARAMETER: {
				ReturnParameter returnParameter = (ReturnParameter)theEObject;
				T result = caseReturnParameter(returnParameter);
				if (result == null) result = caseFormalParameter(returnParameter);
				if (result == null) result = caseMemberDefinition(returnParameter);
				if (result == null) result = caseSyntaxElement(returnParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.NON_RETURN_PARAMETER: {
				NonReturnParameter nonReturnParameter = (NonReturnParameter)theEObject;
				T result = caseNonReturnParameter(nonReturnParameter);
				if (result == null) result = caseFormalParameter(nonReturnParameter);
				if (result == null) result = caseMemberDefinition(nonReturnParameter);
				if (result == null) result = caseSyntaxElement(nonReturnParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AlfPackage.ANY_TYPE: {
				AnyType anyType = (AnyType)theEObject;
				T result = caseAnyType(anyType);
				if (result == null) result = caseClassifierDefinition(anyType);
				if (result == null) result = caseNamespaceDefinition(anyType);
				if (result == null) result = caseMemberDefinition(anyType);
				if (result == null) result = caseSyntaxElement(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assigned Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assigned Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignedSource(AssignedSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Syntax Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Syntax Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSyntaxElement(SyntaxElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementReference(ElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalElementReference(InternalElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalElementReference(ExternalElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Enumeration Literal Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Enumeration Literal Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalEnumerationLiteralReference(ExternalEnumerationLiteralReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundElementReference(BoundElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedElement(DocumentedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Expansion Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Expansion Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceExpansionExpression(SequenceExpansionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignableElement(AssignableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignable Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignable Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignableElementReference(AssignableElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionReference(ExpressionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extent Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extent Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtentOrExpression(ExtentOrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedName(QualifiedName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureReference(FeatureReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameBinding(NameBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateBinding(TemplateBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Template Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedTemplateBinding(NamedTemplateBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Substitution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterSubstitution(TemplateParameterSubstitution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericUnaryExpression(NumericUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For All Or Exists Or One Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For All Or Exists Or One Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForAllOrExistsOrOneExpression(ForAllOrExistsOrOneExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Isolation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsolationExpression(IsolationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanUnaryExpression(BooleanUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cast Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCastExpression(CastExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positional Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positional Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionalTuple(PositionalTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTuple(Tuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExpression(NamedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Named Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputNamedExpression(InputNamedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvocationExpression(InvocationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Named Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Named Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputNamedExpression(OutputNamedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Left Hand Side</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeftHandSide(LeftHandSide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceAccessExpression(SequenceAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpression(StringLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpression(LiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Operation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceOperationExpression(SequenceOperationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Or Reject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Or Reject Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectOrRejectExpression(SelectOrRejectExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Extent Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassExtentExpression(ClassExtentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positional Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positional Template Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionalTemplateBinding(PositionalTemplateBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Logical Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalLogicalExpression(ConditionalLogicalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Operation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkOperationExpression(LinkOperationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityExpression(EqualityExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentExpression(AssignmentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalExpression(LogicalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Construction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Construction Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceConstructionExpression(SequenceConstructionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceElements(SequenceElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collect Or Iterate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collect Or Iterate Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectOrIterateExpression(CollectOrIterateExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Unique Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Unique Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsUniqueExpression(IsUniqueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arithmetic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithmeticExpression(ArithmeticExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Left Hand Side</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureLeftHandSide(FeatureLeftHandSide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Test Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalTestExpression(ConditionalTestExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Creation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceCreationExpression(InstanceCreationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAccessExpression(PropertyAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpression(NameExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bit String Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bit String Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBitStringUnaryExpression(BitStringUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Invocation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureInvocationExpression(FeatureInvocationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Invocation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorInvocationExpression(BehaviorInvocationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShiftExpression(ShiftExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unbounded Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unbounded Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnboundedLiteralExpression(UnboundedLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisExpression(ThisExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classification Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassificationExpression(ClassificationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Invocation Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperInvocationExpression(SuperInvocationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increment Or Decrement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increment Or Decrement Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncrementOrDecrementExpression(IncrementOrDecrementExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpression(BooleanLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedTuple(NamedTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Natural Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Natural Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaturalLiteralExpression(NaturalLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceRange(SequenceRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Left Hand Side</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameLeftHandSide(NameLeftHandSide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effective Left Hand Side</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effective Left Hand Side</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffectiveLeftHandSide(EffectiveLeftHandSide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Reduction Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Reduction Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceReductionExpression(SequenceReductionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Expression List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceExpressionList(SequenceExpressionList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpression(RelationalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Name Declaration Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalNameDeclarationStatement(LocalNameDeclarationStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignable Local Name Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignable Local Name Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignableLocalNameDeclaration(AssignableLocalNameDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Name List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedNameList(QualifiedNameList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Final Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonFinalClause(NonFinalClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoStatement(DoStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concurrent Clauses</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcurrentClauses(ConcurrentClauses object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classify Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifyStatement(ClassifyStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Variable Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopVariableDefinition(LoopVariableDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchClause(SwitchClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Line Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Line Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInLineStatement(InLineStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Accept Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAcceptStatement(AcceptStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Accept Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Accept Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAcceptBlock(AcceptBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyStatement(EmptyStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelNamespace(ModelNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceDefinition(NamespaceDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemberDefinition(MemberDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeAnnotation(StereotypeAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Value List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Value List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedValueList(TaggedValueList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedValue(TaggedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitDefinition(UnitDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportReference(ImportReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imported Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imported Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportedMember(ImportedMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteralName(EnumerationLiteralName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationDefinition(OperationDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationDefinition(AssociationDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierDefinition(ClassifierDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDefinition(ClassDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementDefinition(TypedElementDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDefinition(DataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageDefinition(PackageDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDefinition(PropertyDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignalDefinition(SignalDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Active Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Active Class Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActiveClassDefinition(ActiveClassDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityDefinition(ActivityDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Import Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementImportReference(ElementImportReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal Reception Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignalReceptionDefinition(SignalReceptionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationDefinition(EnumerationDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Import Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Import Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageImportReference(PackageImportReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierTemplateParameter(ClassifierTemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParameter(FormalParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reception Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reception Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceptionDefinition(ReceptionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotated Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotatedStatement(AnnotatedStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundClassifier(BoundClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnParameter(ReturnParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Return Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Return Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonReturnParameter(NonReturnParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // AlfSwitch
