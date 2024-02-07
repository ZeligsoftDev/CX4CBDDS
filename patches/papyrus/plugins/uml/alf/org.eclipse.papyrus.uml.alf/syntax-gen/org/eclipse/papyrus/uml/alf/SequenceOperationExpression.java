/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to invoke a behavior as if it was an operation on a target sequence as a whole.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression()
 * @model
 * @generated
 */
public interface SequenceOperationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression or class name whose value is gives the sequence to be
	 * operated on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' containment reference.
	 * @see #setPrimary(ExtentOrExpression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression_Primary()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExtentOrExpression getPrimary();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getPrimary <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' containment reference.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(ExtentOrExpression value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name of the behavior being invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #setOperation(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression_Operation()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Is Collection Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the primary expression requires collection conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #setIsCollectionConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression_IsCollectionConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let expression = self.primary.expression in\n          expression <> null and expression.upper = 1 and\n          let type = expression.type in\n            type <> null and self.isCollectionClass(type)'"
	 * @generated
	 */
	boolean isIsCollectionConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #isIsCollectionConversion()
	 * @generated
	 */
	void setIsCollectionConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether type primary expression requires BitString conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n        let firstParameter = self.firstParameter() in\n        let expression = self.primary.expression in\n          referent <> null and firstParameter <> null and expression <> null and\n          let parameterType = firstParameter.type() in\n          let primaryType =\n            if self.isCollectionConversion then\n              expression.type.collectionArgument()\n            else\n              expression.type\n            endif\n          in\n            parameterType <> null and self.isBitStringType(parameterType) and\n            primaryType <> null and self.isIntegerType(primaryType)'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #isIsBitStringConversion()
	 * @generated
	 */
	void setIsBitStringConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effective left-hand side corresponding to the primary expression, if
	 * the sequence operation is ?in place? (that is, has a first parameter with
	 * direction inout).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' reference.
	 * @see #setLeftHandSide(LeftHandSide)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceOperationExpression_LeftHandSide()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let expression = self.primary.expression in\n        let firstParameter = self.firstParameter() in\n          if expression = null or firstParameter = null or \n            firstParameter.direction() <> \'inout\' then\n            null\n          else\n            EffectiveLeftHandSide{\n              expression = expression,\n              owner = self\n            }\n          endif'"
	 * @generated
	 */
	LeftHandSide getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceOperationExpression#getLeftHandSide <em>Left Hand Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
	void setLeftHandSide(LeftHandSide value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.operation.referent in\n          if referents->select(isBehavior())->size() <> 1 then null\n          else\n            let referent = referents->any(isBehavior()) in\n              if referent.isTemplate() then \n                self.bindTemplateImplicitArguments(\n                  referent, self.primary.expression\n                )\n              else referent\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" targetExpressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let collectionFunctionAdd = self.collectionFunctionAdd() in\n          if collectionFunctionAdd = null then false\n          else\n            collectionFunctionAdd.containedIn(self.operation.referent->asBag()) and\n            /* Note: This works even if the target expression is the\n             * derived name expression of an ExtentOrExpression element.\n             \052/\n            targetExpression.owner() = self.primary \n          endif'"
	 * @generated
	 */
	boolean isAddTarget(Expression targetExpression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent = null then null\n          else\n            let parameters = referent.parameters() in\n              if parameters->isEmpty() then null\n              else parameters->first()\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference firstParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tlet firstParameter = self.firstParameter() in\n\t\t\t\t\tOutputNamedExpression{\n\t\t\t\t\t\tname = if firstParameter = null then null else firstParameter.name() endif,\n\t\t\t\t\t\texpression = self.primary.expression,\n\t\t\t\t\t\tindex = null,\n\t\t\t\t\t\towner = self.tuple\n\t\t\t\t\t}'"
	 * @generated
	 */
	OutputNamedExpression firstArgument();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent for a sequence operation expression is the behavior named by
	 * the operation for the expression.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no feature for a sequence operation expression.
	 * (See the feature() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There must be a single behavior that is a resolution of the operation
	 * qualified name of a sequence operation expression with a least one
	 * parameter, whose first parameter has direction in or inout, has
	 * multiplicity [0..*] and to which the target primary expression is
	 * assignable.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameter = self.firstParameter() in\n          parameter <> null and\n            let direction = parameter.direction() in\n            let expression = self.primary.expression in\n              (direction = \'in\' or direction = \'inout\') and\n              parameter.lower() = 0 and parameter.upper() = -1 and\n              expression <> null implies parameter.isAssignableFrom(expression)'"
	 * @generated
	 */
	boolean sequenceOperationExpressionOperationReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the first parameter of the referent has direction inout, then the
	 * parameter type must have the same type as the primary expression, the
	 * primary expression must have the form of a left-hand side and, if the
	 * equivalent left-hand side is for a local name, that name must already
	 * exist.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.primary.expression in\n        let parameter = self.firstParameter() in\n          expression <> null and parameter <> null and \n          parameter.direction() = \'inout\' implies\n            let lhs = self.leftHandSide in\n              lhs <> null and \n              let assignedName = lhs.assignedName() in\n                (assignedName <> null implies \n                  self.assignmentBefore->exists(name = assignedName)\n                ) and\n                let expressionType = self.type in\n                let type = parameter.type() in\n                  type <> null and type.equals(expressionType) or\n                  type = null and expressionType = null'"
	 * @generated
	 */
	boolean sequenceOperationExpressionTargetCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of an input argument expression of a sequence operation
	 * parameter must be assignable to its corresponding parameter. The type of
	 * an output parameter must be assignable to its corresponding argument
	 * expression. (Note that this implies that the type of an argument
	 * expression for an inout parameter must be the same as the type of that
	 * parameter.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.referent <> null implies\n          (self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n           self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))\n          )'"
	 * @generated
	 */
	boolean sequenceOperationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the primary expression of a sequence operation
	 * expression are the same as the assignments before the sequence operation
	 * expression.
	 * (See the InvocationExpression::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Collection conversion is required if the type of the primary expression
	 * of a sequence operation expression is a collection class and the
	 * multiplicity upper bound of the primary expression is 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BitString conversion is required if type of the first parameter of the
	 * referent of a sequence operation expression is BitString and either the
	 * type of its primary expression is Integer or collection conversion is
	 * required and the type of its primary expression is a collection class
	 * whose argument type is Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A local name that is assigned in the primary expression of a sequence
	 * operation expression may not be assigned in any expression in the tuple
	 * of the sequence operation expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.primary.expression in\n          expression <> null implies\n            expression.newAssignments().name->\n              excludesAll(self.tuple.newAssignments().name)'"
	 * @generated
	 */
	boolean sequenceOperationExpressionAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the operation of a sequence operation expression has a first
	 * parameter whose direction is inout, then the effective left-hand side for
	 * the expression is constructed as follows: If the primary is a name
	 * expression, then the left-hand side is a name left-hand side with the
	 * name from the name expression as its target. If the primary is a property
	 * access expression, then the left-hand side is a feature left hand side
	 * with the feature reference from the property access expression as its
	 * feature. If the primary is a sequence access expression whose primary is
	 * a name expression or a property access expression, then the left-hand
	 * side is constructed from the primary of the sequence access expression as
	 * given previously and the index of the sequence access expression becomes
	 * the index of the left-hand side.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceOperationExpressionLeftHandSideDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a sequence operation expression include those made
	 * in the primary expression and those made in the tuple and, for an "in
	 * place" operation (one whose first parameter is inout), that made by the
	 * sequence operation expression itself.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.primary.expression in\n        let firstParameter = self.firstParameter() in\n        let assignments1 =\n          if expression = null then self.assignmentBefore\n          else expression.assignmentAfter\n          endif\n        in\n        let assignments2 =\n          self.updateAll(assignments1, self.tuple.assignmentsAfter())\n        in\n          if firstParameter = null or firstParameter.direction() <> \'inout\' then\n            assignments2\n          else\n            let oldAssignment = self.assignmentBefore->\n              select(name = self.leftHandSide.assignedName())\n            in\n              if oldAssignment->isEmpty() or oldAssignment->forAll(isParallelLocalName) then\n                assignments2\n              else\n                oldAssignment->any(true).copy(self, null).update(assignments2)\n              endif\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the list of parameter elements from the superclass operation,
	 * with the first parameter removed (since the argument for the first
	 * parameter is given by the primary expression of a sequence operation
	 * expression, not in its tuple).
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameters = self.InvocationExpression_parameterElements() in\n          if parameters->size() < 2 then OrderedSet(ElementReference){}\n          else parameters->subOrderedSet(2, parameters->size())\n          endif'"
	 * @generated
	 */
	EList<ElementReference> parameterElements();

} // SequenceOperationExpression
