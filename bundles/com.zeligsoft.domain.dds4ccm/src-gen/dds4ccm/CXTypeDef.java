/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXTypeDef#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXTypeDef()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXTypeDef extends CXWrapper, CXClassifierContained, CXModuleContained, CXType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CXType)
	 * @see dds4ccm.DDS4CCMPackage#getCXTypeDef_Type()
	 * @model ordered="false"
	 * @generated
	 */
	CXType getType();

	/**
	 * Sets the value of the '{@link dds4ccm.CXTypeDef#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CXType value);

} // CXTypeDef
