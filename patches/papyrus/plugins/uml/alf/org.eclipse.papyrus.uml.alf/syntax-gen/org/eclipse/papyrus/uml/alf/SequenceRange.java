/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specification of the elements of a sequence as a range of integers.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceRange#getRangeLower <em>Range Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceRange#getRangeUpper <em>Range Upper</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceRange()
 * @model
 * @generated
 */
public interface SequenceRange extends SequenceElements {
	/**
	 * Returns the value of the '<em><b>Range Lower</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression whose value gives the lower bound for the range.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range Lower</em>' containment reference.
	 * @see #setRangeLower(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceRange_RangeLower()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRangeLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceRange#getRangeLower <em>Range Lower</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Lower</em>' containment reference.
	 * @see #getRangeLower()
	 * @generated
	 */
	void setRangeLower(Expression value);

	/**
	 * Returns the value of the '<em><b>Range Upper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression whose value gives the upper bound for the range.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range Upper</em>' containment reference.
	 * @see #setRangeUpper(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceRange_RangeUpper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRangeUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceRange#getRangeUpper <em>Range Upper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Upper</em>' containment reference.
	 * @see #getRangeUpper()
	 * @generated
	 */
	void setRangeUpper(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The lower and upper range expressions must have type Integer.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let rangeLowerType = self.rangeLower.type in\n        let rangeUpperType = self.rangeUpper.type in\n          rangeLowerType <> null and self.isIntegerType(rangeLowerType) and\n          rangeUpperType <> null and self.isIntegerType(rangeUpperType)'"
	 * @generated
	 */
	boolean conformsTo(ElementReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.updateAll(\n          self.updateAll(\n            self.assignmentsBefore(),\n            self.rangeLower.assignmentAfter\n          ),\n          self.rangeUpper.assignmentAfter\n        )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='-1'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='0'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of a sequence range is 0.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceRangeLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of a sequence range is * (since it is not
	 * possible, in general, to statically determine a more constrained upper
	 * bound).
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceRangeUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Both expressions in a sequence range must have a multiplicity upper bound
	 * of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.rangeLower.upper = 1 and self.rangeUpper.upper = 1'"
	 * @generated
	 */
	boolean sequenceRangeExpressionMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A local name may be defined or reassigned in at most one of the
	 * expressions of a sequence range.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                          self.rangeLower.newAssignments().name->\n                            excludesAll(self.rangeUpper.newAssignments().name)'"
	 * @generated
	 */
	boolean sequenceRangeAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SequenceRange
