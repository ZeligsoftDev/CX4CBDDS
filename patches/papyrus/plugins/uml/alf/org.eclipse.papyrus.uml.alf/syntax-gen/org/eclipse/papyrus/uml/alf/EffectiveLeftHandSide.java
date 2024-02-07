/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effective Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.EffectiveLeftHandSide#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getEffectiveLeftHandSide()
 * @model
 * @generated
 */
public interface EffectiveLeftHandSide extends NameLeftHandSide {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getEffectiveLeftHandSide_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.EffectiveLeftHandSide#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.primary() in\n          if expression.oclIsKindOf(NameExpression) then\n            expression.oclAsType(NameExpression).name\n          else\n            null\n          endif'"
	 * @generated
	 */
	QualifiedName target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.expression.oclIsKindOf(SequenceAccessExpression) then\n          self.expression.oclAsType(SequenceAccessExpression).index\n        else\n          null\n        endif'"
	 * @generated
	 */
	Expression index();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let primary = self.primary() in\n          if expression.oclIsKindOf(NameExpression) then\n            expression.oclAsType(NameExpression).name.disambiguation\n          else if expression.oclIsKindOf(PropertyAccessExpression) then\n            expression.oclAsType(PropertyAccessExpression).featureReference\n          else\n            null\n          endif endif'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.expression.oclIsKindOf(SequenceAccessExpression) then\n          self.expression.oclAsType(SequenceAccessExpression).primary\n        else\n          expression\n        endif'"
	 * @generated
	 */
	Expression primary();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression'"
	 * @generated
	 */
	Expression expression();

} // EffectiveLeftHandSide
