/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to test the dynamic type of its operand.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#isIsDirect <em>Is Direct</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassificationExpression()
 * @model
 * @generated
 */
public interface ClassificationExpression extends UnaryExpression {
	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classifier to which the type name of the expression resolves.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassificationExpression_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referents = self.typeName.referent->select(isClassifier()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Direct</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the test is for the operand to have the given type directly or to only conform to the given type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Direct</em>' attribute.
	 * @see #setIsDirect(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassificationExpression_IsDirect()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operator = \'hastype\''"
	 * @generated
	 */
	boolean isIsDirect();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#isIsDirect <em>Is Direct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Direct</em>' attribute.
	 * @see #isIsDirect()
	 * @generated
	 */
	void setIsDirect(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the type that the operand is to be tested against.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassificationExpression_TypeName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassificationExpression#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.booleanType()'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand.lower'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='1'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classification expression is direct if its operator is "hastype".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classificationExpressionIsDirectDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of a classification expression is the classifier to which
	 * the type name resolves.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classificationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classification expression has type Boolean.
	 * (see the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classificationExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classification expression has a multiplicity lower bound that is the
	 * same as the lower bound of its operand expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classificationExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classification expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classificationExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type name in a classification expression must resolve to a non-template classifier.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent <> null and not self.referent.isTemplate()'"
	 * @generated
	 */
	boolean classificationExpressionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression of a classification expression must have a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand.upper = 1'"
	 * @generated
	 */
	boolean classificationExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ClassificationExpression
