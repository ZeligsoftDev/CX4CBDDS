/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specification of the elements of a sequence using a list of expressions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpressionList#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpressionList()
 * @model
 * @generated
 */
public interface SequenceExpressionList extends SequenceElements {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of expressions whose values determine the elements of the sequence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpressionList_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each expression in the list must have a multiplicity upper bound of no
	 * more than 1. The type of each expression in the list must conform to
	 * the given type (with allowance for bit string conversion).
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element->forAll(element |\n          let elementType = element.type in\n            element.upper <= 1 and \n              (type = null or elementType <> null and\n                (elementType.conformsTo(type) or\n                 self.isIntegerType(elementType) and self.isBitStringType(type)\n                )\n              )\n        )'"
	 * @generated
	 */
	boolean conformsTo(ElementReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element->includes(element) or \n          self.element->first() = element then\n          self.assignmentsBefore()\n        else\n          let i = self.element->indexOf(element) in\n            self.element->at(i-1).assignmentAfter\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element->last().assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.lower->sum()'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let upperBounds = self.element.upper in\n          if upperBounds->includes(-1) then -1\n          else upperBounds->sum()\n          endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of the elements of a sequence expression
	 * list is given by the sum of the lower bounds of each of the expressions
	 * in the list.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceExpressionListLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of the elements of a sequence expression
	 * list is given by the sum of the upper bounds of each of the expressions
	 * in the list. If any of the expressions in the list have an unbounded
	 * upper bound, then the sequence expression list also has an unbounded
	 * upper bound.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceExpressionListUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SequenceExpressionList
