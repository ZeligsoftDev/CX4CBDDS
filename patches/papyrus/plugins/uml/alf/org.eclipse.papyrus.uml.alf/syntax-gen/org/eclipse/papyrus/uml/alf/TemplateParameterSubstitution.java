/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specification of the substitution of an argument type name for a template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getArgumentName <em>Argument Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTemplateParameterSubstitution()
 * @model
 * @generated
 */
public interface TemplateParameterSubstitution extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Name</em>' attribute.
	 * @see #setParameterName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTemplateParameterSubstitution_ParameterName()
	 * @model required="true"
	 * @generated
	 */
	String getParameterName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getParameterName <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Name</em>' attribute.
	 * @see #getParameterName()
	 * @generated
	 */
	void setParameterName(String value);

	/**
	 * Returns the value of the '<em><b>Argument Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the argument type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument Name</em>' containment reference.
	 * @see #setArgumentName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTemplateParameterSubstitution_ArgumentName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getArgumentName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getArgumentName <em>Argument Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Name</em>' containment reference.
	 * @see #getArgumentName()
	 * @generated
	 */
	void setArgumentName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referent</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTemplateParameterSubstitution_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n            let referents = argumentName.referent in \n              if referents->size() <> 1 or not referents->forAll(isClassifier()) then null\n              else referents->any(true)\n              endif'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution#getReferent <em>Referent</em>}' reference.
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
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NameBinding{name = self.parameterName}.toName()'"
	 * @generated
	 */
	String actualParameterName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.parameterName + \'=>\' + argumentName.pathName'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='TemplateParameterSubstitution{\n            parameterName = self.parameterName,\n            argumentName = if self.argumentName = null then null else self.argumentName.copy() endif\n          }'"
	 * @generated
	 */
	TemplateParameterSubstitution copy();

} // TemplateParameterSubstitution
