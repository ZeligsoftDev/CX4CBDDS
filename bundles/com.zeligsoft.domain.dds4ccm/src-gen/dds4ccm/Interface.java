/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Interface#getBase_Interface <em>Base Interface</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getInterface()
 * @model abstract="true"
 *        annotation="http://www.zeligsoft.com/zdl/2008/ZDL operation='ownedOperation'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Interface extends PortTypeable {
	/**
	 * Returns the value of the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Interface</em>' reference.
	 * @see #setBase_Interface(org.eclipse.uml2.uml.Interface)
	 * @see dds4ccm.DDS4CCMPackage#getInterface_Base_Interface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Interface getBase_Interface();

	/**
	 * Sets the value of the '{@link dds4ccm.Interface#getBase_Interface <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Interface</em>' reference.
	 * @see #getBase_Interface()
	 * @generated
	 */
	void setBase_Interface(org.eclipse.uml2.uml.Interface value);

} // Interface
