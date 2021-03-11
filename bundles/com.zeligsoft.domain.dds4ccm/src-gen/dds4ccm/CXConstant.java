/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXConstant#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXConstant()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL default='default'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXConstant extends CXNamedElement, CXTyped {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see dds4ccm.DDS4CCMPackage#getCXConstant_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link dds4ccm.CXConstant#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // CXConstant
