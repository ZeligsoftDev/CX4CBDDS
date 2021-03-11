/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TemplateParameterSubstitution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ParameterBinding#getBase_TemplateParameterSubstitution <em>Base Template Parameter Substitution</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getParameterBinding()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL type='actual' typeParameter='formal'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ParameterBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Template Parameter Substitution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Template Parameter Substitution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Template Parameter Substitution</em>' reference.
	 * @see #setBase_TemplateParameterSubstitution(TemplateParameterSubstitution)
	 * @see dds4ccm.DDS4CCMPackage#getParameterBinding_Base_TemplateParameterSubstitution()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateParameterSubstitution getBase_TemplateParameterSubstitution();

	/**
	 * Sets the value of the '{@link dds4ccm.ParameterBinding#getBase_TemplateParameterSubstitution <em>Base Template Parameter Substitution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Template Parameter Substitution</em>' reference.
	 * @see #getBase_TemplateParameterSubstitution()
	 * @generated
	 */
	void setBase_TemplateParameterSubstitution(TemplateParameterSubstitution value);

} // ParameterBinding
