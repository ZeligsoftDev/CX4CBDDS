/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXBound#getConstant <em>Constant</em>}</li>
 *   <li>{@link dds4ccm.CXBound#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXBound()
 * @model
 * @generated
 */
public interface CXBound extends EObject {
	/**
	 * Returns the value of the '<em><b>Constant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' reference.
	 * @see #setConstant(CXConstant)
	 * @see dds4ccm.DDS4CCMPackage#getCXBound_Constant()
	 * @model ordered="false"
	 * @generated
	 */
	CXConstant getConstant();

	/**
	 * Sets the value of the '{@link dds4ccm.CXBound#getConstant <em>Constant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' reference.
	 * @see #getConstant()
	 * @generated
	 */
	void setConstant(CXConstant value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see dds4ccm.DDS4CCMPackage#getCXBound_Value()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link dds4ccm.CXBound#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // CXBound
