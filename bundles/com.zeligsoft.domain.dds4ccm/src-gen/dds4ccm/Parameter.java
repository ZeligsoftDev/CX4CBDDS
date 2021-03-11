/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Parameter#getBase_Parameter <em>Base Parameter</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getParameter()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Parameter extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Parameter</em>' reference.
	 * @see #setBase_Parameter(org.eclipse.uml2.uml.Parameter)
	 * @see dds4ccm.DDS4CCMPackage#getParameter_Base_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Parameter getBase_Parameter();

	/**
	 * Sets the value of the '{@link dds4ccm.Parameter#getBase_Parameter <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Parameter</em>' reference.
	 * @see #getBase_Parameter()
	 * @generated
	 */
	void setBase_Parameter(org.eclipse.uml2.uml.Parameter value);

} // Parameter
