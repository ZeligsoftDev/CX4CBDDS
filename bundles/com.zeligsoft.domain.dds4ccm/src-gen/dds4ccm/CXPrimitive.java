/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Primitive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXPrimitive#getType <em>Type</em>}</li>
 *   <li>{@link dds4ccm.CXPrimitive#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXPrimitive()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXPrimitive extends CXNamedElement, Contained, CXType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link dds4ccm.CXPrimitiveKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see dds4ccm.CXPrimitiveKind
	 * @see #setType(CXPrimitiveKind)
	 * @see dds4ccm.DDS4CCMPackage#getCXPrimitive_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CXPrimitiveKind getType();

	/**
	 * Sets the value of the '{@link dds4ccm.CXPrimitive#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see dds4ccm.CXPrimitiveKind
	 * @see #getType()
	 * @generated
	 */
	void setType(CXPrimitiveKind value);

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see dds4ccm.DDS4CCMPackage#getCXPrimitive_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link dds4ccm.CXPrimitive#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // CXPrimitive
