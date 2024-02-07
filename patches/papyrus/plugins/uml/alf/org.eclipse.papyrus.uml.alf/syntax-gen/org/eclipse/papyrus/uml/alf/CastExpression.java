/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to filter values by type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.CastExpression#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.CastExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.CastExpression#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getCastExpression()
 * @model
 * @generated
 */
public interface CastExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression of the cast expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getCastExpression_Operand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.CastExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(Expression value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The named type of the cast expression (if any)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getCastExpression_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.CastExpression#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Is Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the cast expression has an empty type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Any</em>' attribute.
	 * @see #setIsAny(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getCastExpression_IsAny()
	 * @model
	 * @generated
	 */
	boolean isIsAny();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.CastExpression#isIsAny <em>Is Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any</em>' attribute.
	 * @see #isIsAny()
	 * @generated
	 */
	void setIsAny(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.typeName = null then null\n        else\n          let referents = self.typeName.referent->\n                select(isClassifier() and not isTemplate()) in\n            if referents->size() <> 1 then null\n            else referents->any(true)\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference type();

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
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand.upper'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a cast expression is the referent of the given type name (if
	 * there is one).
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean castExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A cast expression has a multiplicity lower bound of 0.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean castExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A cast expression has a multiplicity upper bound that is the same as the
	 * upper bound of its operand expression.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean castExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the cast expression has a type name, then it must resolve to a
	 * non-template classifier.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.typeName <> null implies self.type <> null'"
	 * @generated
	 */
	boolean castExpressionTypeResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the operand of a cast expression are the same as
	 * those before the cast expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean castExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a cast expression are the same as those after its
	 * operand expression.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // CastExpression
