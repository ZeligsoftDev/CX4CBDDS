/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.DataSpace#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getDataSpace()
 * @model annotation="uml2.extensions suppressed='true'"
 *        annotation="http://www.zeligsoft.com/zdl/2008/ZDL connectorType='type'"
 * @generated
 */
public interface DataSpace extends Part {
	/**
	 * Returns the value of the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Named Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Named Element</em>' reference.
	 * @see #setBase_NamedElement(NamedElement)
	 * @see dds4ccm.DDS4CCMPackage#getDataSpace_Base_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getBase_NamedElement();

	/**
	 * Sets the value of the '{@link dds4ccm.DataSpace#getBase_NamedElement <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Named Element</em>' reference.
	 * @see #getBase_NamedElement()
	 * @generated
	 */
	void setBase_NamedElement(NamedElement value);

} // DataSpace
