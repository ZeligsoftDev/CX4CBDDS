/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXValue#isCustom <em>Is Custom</em>}</li>
 *   <li>{@link dds4ccm.CXValue#isTruncatable <em>Is Truncatable</em>}</li>
 *   <li>{@link dds4ccm.CXValue#getBase_Interface <em>Base Interface</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXValue()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL isAbstract='isAbstract'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXValue extends Contained, CXClassifier, CXType {
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
	 * @see dds4ccm.DDS4CCMPackage#getCXValue_IsCustom()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCustom();

	/**
	 * Sets the value of the '{@link dds4ccm.CXValue#isCustom <em>Is Custom</em>}' attribute.
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
	 * @see dds4ccm.DDS4CCMPackage#getCXValue_IsTruncatable()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTruncatable();

	/**
	 * Sets the value of the '{@link dds4ccm.CXValue#isTruncatable <em>Is Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Truncatable</em>' attribute.
	 * @see #isTruncatable()
	 * @generated
	 */
	void setIsTruncatable(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Interface</em>' reference.
	 * @see #setBase_Interface(Interface)
	 * @see dds4ccm.DDS4CCMPackage#getCXValue_Base_Interface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getBase_Interface();

	/**
	 * Sets the value of the '{@link dds4ccm.CXValue#getBase_Interface <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Interface</em>' reference.
	 * @see #getBase_Interface()
	 * @generated
	 */
	void setBase_Interface(Interface value);

} // CXValue
