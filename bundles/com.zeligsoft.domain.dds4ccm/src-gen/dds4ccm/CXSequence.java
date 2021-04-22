/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXSequence#getBounds <em>Bounds</em>}</li>
 *   <li>{@link dds4ccm.CXSequence#getBound <em>Bound</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXSequence()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXSequence extends CXTemplate, Contained, CXClassifierContained, CXModuleContained, CXType {
	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' containment reference.
	 * @see #setBounds(CXBound)
	 * @see dds4ccm.DDS4CCMPackage#getCXSequence_Bounds()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	CXBound getBounds();

	/**
	 * Sets the value of the '{@link dds4ccm.CXSequence#getBounds <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' containment reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(CXBound value);

	/**
	 * Returns the value of the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' attribute.
	 * @see #setBound(String)
	 * @see dds4ccm.DDS4CCMPackage#getCXSequence_Bound()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getBound();

	/**
	 * Sets the value of the '{@link dds4ccm.CXSequence#getBound <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' attribute.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(String value);

} // CXSequence
