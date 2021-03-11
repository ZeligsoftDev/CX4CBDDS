/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Manifestation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ComponentImplementation#getBase_Manifestation <em>Base Manifestation</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getComponentImplementation()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL structuralRealization='utilizedElement' implementation='client'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ComponentImplementation extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Manifestation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Manifestation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Manifestation</em>' reference.
	 * @see #setBase_Manifestation(Manifestation)
	 * @see dds4ccm.DDS4CCMPackage#getComponentImplementation_Base_Manifestation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Manifestation getBase_Manifestation();

	/**
	 * Sets the value of the '{@link dds4ccm.ComponentImplementation#getBase_Manifestation <em>Base Manifestation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Manifestation</em>' reference.
	 * @see #getBase_Manifestation()
	 * @generated
	 */
	void setBase_Manifestation(Manifestation value);

} // ComponentImplementation
