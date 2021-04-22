/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.MessageField#isKey <em>Is Key</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getMessageField()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL idlType='type'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface MessageField extends CXField {
	/**
	 * Returns the value of the '<em><b>Is Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Key</em>' attribute.
	 * @see #setIsKey(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getMessageField_IsKey()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isKey();

	/**
	 * Sets the value of the '{@link dds4ccm.MessageField#isKey <em>Is Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Key</em>' attribute.
	 * @see #isKey()
	 * @generated
	 */
	void setIsKey(boolean value);

} // MessageField
