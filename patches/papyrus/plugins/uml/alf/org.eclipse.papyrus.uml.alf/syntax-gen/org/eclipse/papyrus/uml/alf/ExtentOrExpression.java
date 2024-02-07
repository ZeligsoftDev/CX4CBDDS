/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extent Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The target of a sequence operation, reduction or expansion expression,
 * which may be either a primary expression or a class name denoting the class
 * extent.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getNonNameExpression <em>Non Name Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExtentOrExpression()
 * @model
 * @generated
 */
public interface ExtentOrExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target is a qualified name, then that name, before it is
	 * disambiguated into either a name expression or a class name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExtentOrExpression_Name()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effective expression for the target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExtentOrExpression_Expression()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.nonNameExpression <> null then self.nonNameExpression\n        else if self.name.referent->exists(isClass()) then\n          ClassExtentExpression{\n            className = self.name.copy(),\n            owner = self\n          }\n        else\n          NameExpression{\n            name = self.name.copy(),\n            owner = self\n          }\n        endif endif'"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Non Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target primary expression, if it is not a qualified name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Name Expression</em>' containment reference.
	 * @see #setNonNameExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExtentOrExpression_NonNameExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getNonNameExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExtentOrExpression#getNonNameExpression <em>Non Name Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Name Expression</em>' containment reference.
	 * @see #getNonNameExpression()
	 * @generated
	 */
	void setNonNameExpression(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" targetExpressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.enclosingExpression().isAddTarget(targetExpression)'"
	 * @generated
	 */
	boolean isAddTarget(Expression targetExpression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effective expression for the target is the parsed primary expression,
	 * if the target is not a qualified name, a name expression, if the target
	 * is a qualified name other than a class name, or a class extent expression,
	 * if the target is the qualified name of a class.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean extentOrExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let expression = self.expression in\n        expression.oclIsKindOf(ClassExtentExpression) implies\n          expression.oclAsType(ClassExtentExpression).validateClassExtentExpressionExtentType()'"
	 * @generated
	 */
	boolean extentOrExpressionExtentType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let expression = self.expression in\n        expression.oclIsKindOf(NameExpression) implies\n          expression.oclAsType(NameExpression).validateNameExpressionResolution()'"
	 * @generated
	 */
	boolean extentOrExpressionResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ExtentOrExpression
