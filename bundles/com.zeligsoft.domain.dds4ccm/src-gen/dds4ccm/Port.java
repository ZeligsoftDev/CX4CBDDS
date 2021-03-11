/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Port#getWiring <em>Wiring</em>}</li>
 *   <li>{@link dds4ccm.Port#getBase_Port <em>Base Port</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getPort()
 * @model abstract="true"
 *        annotation="http://www.zeligsoft.com/zdl/2008/ZDL isExternal='isService' porttype='type'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Port extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Wiring</b></em>' attribute.
	 * The default value is <code>"connector"</code>.
	 * The literals are from the enumeration {@link dds4ccm.WiringKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wiring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wiring</em>' attribute.
	 * @see dds4ccm.WiringKind
	 * @see #setWiring(WiringKind)
	 * @see dds4ccm.DDS4CCMPackage#getPort_Wiring()
	 * @model default="connector" required="true" ordered="false"
	 * @generated
	 */
	WiringKind getWiring();

	/**
	 * Sets the value of the '{@link dds4ccm.Port#getWiring <em>Wiring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wiring</em>' attribute.
	 * @see dds4ccm.WiringKind
	 * @see #getWiring()
	 * @generated
	 */
	void setWiring(WiringKind value);

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(org.eclipse.uml2.uml.Port)
	 * @see dds4ccm.DDS4CCMPackage#getPort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Port getBase_Port();

	/**
	 * Sets the value of the '{@link dds4ccm.Port#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(org.eclipse.uml2.uml.Port value);

} // Port
