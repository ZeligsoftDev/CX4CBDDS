/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.TemplateSignature#getBase_TemplateSignature <em>Base Template Signature</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getTemplateSignature()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL typeParameter='ownedParameter'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface TemplateSignature extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Template Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Template Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Template Signature</em>' reference.
	 * @see #setBase_TemplateSignature(org.eclipse.uml2.uml.TemplateSignature)
	 * @see dds4ccm.DDS4CCMPackage#getTemplateSignature_Base_TemplateSignature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.TemplateSignature getBase_TemplateSignature();

	/**
	 * Sets the value of the '{@link dds4ccm.TemplateSignature#getBase_TemplateSignature <em>Base Template Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Template Signature</em>' reference.
	 * @see #getBase_TemplateSignature()
	 * @generated
	 */
	void setBase_TemplateSignature(org.eclipse.uml2.uml.TemplateSignature value);

} // TemplateSignature
