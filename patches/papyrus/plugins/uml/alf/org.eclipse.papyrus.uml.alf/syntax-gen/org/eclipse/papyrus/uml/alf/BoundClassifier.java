/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A classifier resulting from the binding of a template to its actual
 * parameters.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BoundClassifier#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BoundClassifier#getActual <em>Actual</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundClassifier()
 * @model
 * @generated
 */
public interface BoundClassifier extends ClassifierDefinition {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundClassifier_Template()
	 * @model required="true"
	 * @generated
	 */
	ElementReference getTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BoundClassifier#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundClassifier_Actual()
	 * @model
	 * @generated
	 */
	EList<ElementReference> getActual();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        BoundElementReference{\n          referent = self.template,\n          namespace = self.template.namespace(),\n          templateBinding = InternalElementReference{element = self}\n        }'"
	 * @generated
	 */
	ElementReference toReference();

} // BoundClassifier
