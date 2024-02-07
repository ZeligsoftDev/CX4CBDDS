/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The left-hand side of an assignment expression. NOTE: The derivations for
 * the derived properties of LeftHandSide are specific to its various subclasses.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LeftHandSide#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LeftHandSide#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LeftHandSide#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLeftHandSide()
 * @model abstract="true"
 * @generated
 */
public interface LeftHandSide extends AssignableElement {
	/**
	 * Returns the value of the '<em><b>Assignment Before</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment Before</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the left-hand side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment Before</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLeftHandSide_AssignmentBefore()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentBefore();

	/**
	 * Returns the value of the '<em><b>Assignment After</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after the left-hand side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment After</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLeftHandSide_AssignmentAfter()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsAfter()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentAfter();

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the assignable element denoted by this left-hand side, if
	 * one exists (i.e., the left-hand side is not for the first assignment of a
	 * local name).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLeftHandSide_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.referent()'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LeftHandSide#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.index() <> element then self.assignmentBefore\n        else\n          let feature = self.feature() in\n            if feature = null then self.assignmentBefore\n            else feature.assignmentAfter\n            endif\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.index() <> null then self.index().assignmentAfter\n        else \n          let feature = self.feature() in\n            if feature = null then self.assignmentBefore\n            else feature.assignmentAfter\n            endif\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.LeftHandSide_type()'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent() in\n          if referent = null then null else referent.type() endif'"
	 * @generated
	 */
	ElementReference LeftHandSide_type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.LeftHandSide_upper()'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.index() <> null then 1\n        else\n          let referent = self.referent() in\n            if referent = null then 0 else referent.upper() endif\n        endif'"
	 * @generated
	 */
	BigInteger LeftHandSide_upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.LeftHandSide_lower()'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.index() <> null then 1\n        else\n          let referent = self.referent() in\n            if referent = null then 0 else referent.lower() endif\n        endif'"
	 * @generated
	 */
	BigInteger LeftHandSide_lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isDataValueUpdate() then self.localName()\n        else\n          self.feature().expression.oclAsType(NameExpression).name.unqualifiedName.toName()\n        endif'"
	 * @generated
	 */
	String assignedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String localName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Expression expression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature() in\n          feature <> null and\n          feature.expression.oclIsKindOf(NameExpression) and\n          let expression = feature.expression.oclAsType(NameExpression) in\n            expression.propertyAccess = null and\n            let name = expression.name.unqualifiedName.toName() in\n            let assignments = self.assignmentBefore->select(a | a.name = name) in\n              assignments->notEmpty() and \n              assignments->forAll(type <> null and type.isDataType())'"
	 * @generated
	 */
	boolean isDataValueUpdate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a left-hand side has an index, then the index expression must have a
	 * multiplicity upper bound no greater than 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.index() <> null implies self.index().upper <= 1'"
	 * @generated
	 */
	boolean leftHandSideIndexExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional expression that evaluates to an index into the values of an
	 * ordered sequence.
	 * property index : Expression[?] { composes };
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Expression index();

} // LeftHandSide
