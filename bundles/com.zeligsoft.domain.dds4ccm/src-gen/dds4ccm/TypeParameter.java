/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.ClassifierTemplateParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.TypeParameter#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link dds4ccm.TypeParameter#getBase_ClassifierTemplateParameter <em>Base Classifier Template Parameter</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getTypeParameter()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface TypeParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * The literals are from the enumeration {@link dds4ccm.TypeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see dds4ccm.TypeConstraint
	 * @see #setConstraint(TypeConstraint)
	 * @see dds4ccm.DDS4CCMPackage#getTypeParameter_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TypeConstraint getConstraint();

	/**
	 * Sets the value of the '{@link dds4ccm.TypeParameter#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see dds4ccm.TypeConstraint
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(TypeConstraint value);

	/**
	 * Returns the value of the '<em><b>Base Classifier Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Classifier Template Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Classifier Template Parameter</em>' reference.
	 * @see #setBase_ClassifierTemplateParameter(ClassifierTemplateParameter)
	 * @see dds4ccm.DDS4CCMPackage#getTypeParameter_Base_ClassifierTemplateParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ClassifierTemplateParameter getBase_ClassifierTemplateParameter();

	/**
	 * Sets the value of the '{@link dds4ccm.TypeParameter#getBase_ClassifierTemplateParameter <em>Base Classifier Template Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Classifier Template Parameter</em>' reference.
	 * @see #getBase_ClassifierTemplateParameter()
	 * @generated
	 */
	void setBase_ClassifierTemplateParameter(ClassifierTemplateParameter value);

} // TypeParameter
