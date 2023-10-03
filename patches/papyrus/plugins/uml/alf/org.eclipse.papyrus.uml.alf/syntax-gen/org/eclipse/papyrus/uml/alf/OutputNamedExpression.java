/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Named Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A named argument expression for an output parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OutputNamedExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOutputNamedExpression()
 * @model
 * @generated
 */
public interface OutputNamedExpression extends InputNamedExpression {
	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expression considered as an assignment left-hand side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' reference.
	 * @see #setLeftHandSide(LeftHandSide)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOutputNamedExpression_LeftHandSide()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n          if self.expression <> null and self.hasLegalExpression() then\n            EffectiveLeftHandSide{\n              expression = self.expression,\n              owner = self\n            }\n          else\n            null\n          endif'"
	 * @generated
	 */
	LeftHandSide getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OutputNamedExpression#getLeftHandSide <em>Left Hand Side</em>}' reference.
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
	 * <!-- begin-model-doc -->
	 * The equivalent left-hand side for an output named expression depends on
	 * the kind of expression. If the expression is a name expression with no
	 * disambiguation, then the left-hand side is a name left-hand side with the
	 * name from the name expression. If the expression is a name expression
	 * that disambiguates to a feature reference, then the left-hand side is a
	 * feature left-hand side for that feature reference. If the expression is a
	 * property access expression, then the left-hand side is a feature left-hand
	 * side for the feature reference of the property access expression. If the
	 * expression is a sequence access expression, then the left-hand side is a
	 * name left-hand side or feature left-hand side, as above, depending on
	 * whether the primary expression of the sequence access expression is a
	 * name expression or property access expression, and an index given by the
	 * index expression of the sequence access expression. Otherwise the left-
	 * hand side is empty.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean outputNamedExpressionLeftHandSideDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument for an output parameter must be either be null, a name
	 * expression, a property access expression, or a sequence access expression
	 * whose primary expression is a name expression or a property access
	 * expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression = null or self.hasLegalExpression()'"
	 * @generated
	 */
	boolean outputNamedExpressionForm(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let primary =\n          if self.expression.oclIsKindOf(SequenceAccessExpression) then\n            self.expression.oclAsType(SequenceAccessExpression).primary\n          else\n            self.expression\n          endif\n        in\n          primary.oclIsKindOf(NameExpression) or \n          primary.oclIsKindOf(PropertyAccessExpression)'"
	 * @generated
	 */
	boolean hasLegalExpression();

} // OutputNamedExpression
