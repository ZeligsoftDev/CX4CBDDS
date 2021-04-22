/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Event#isCustom <em>Is Custom</em>}</li>
 *   <li>{@link dds4ccm.Event#isTruncatable <em>Is Truncatable</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getEvent()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL isAbstract='isAbstract' member='ownedAttribute' ownedAttribute='ownedAttribute'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Event extends CXNamedElement, Interface, CXModuleContained {
	/**
	 * Returns the value of the '<em><b>Is Custom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Custom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Custom</em>' attribute.
	 * @see #setIsCustom(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getEvent_IsCustom()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCustom();

	/**
	 * Sets the value of the '{@link dds4ccm.Event#isCustom <em>Is Custom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Custom</em>' attribute.
	 * @see #isCustom()
	 * @generated
	 */
	void setIsCustom(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Truncatable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Truncatable</em>' attribute.
	 * @see #setIsTruncatable(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getEvent_IsTruncatable()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTruncatable();

	/**
	 * Sets the value of the '{@link dds4ccm.Event#isTruncatable <em>Is Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Truncatable</em>' attribute.
	 * @see #isTruncatable()
	 * @generated
	 */
	void setIsTruncatable(boolean value);

} // Event
