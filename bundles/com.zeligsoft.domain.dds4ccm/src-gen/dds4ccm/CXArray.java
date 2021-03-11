/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXArray#getBounds <em>Bounds</em>}</li>
 *   <li>{@link dds4ccm.CXArray#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXArray()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXArray extends CXTemplate, Contained, CXClassifierContained, CXModuleContained, CXType {
	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' containment reference list.
	 * The list contents are of type {@link dds4ccm.CXBound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' containment reference list.
	 * @see dds4ccm.DDS4CCMPackage#getCXArray_Bounds()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<CXBound> getBounds();

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(String)
	 * @see dds4ccm.DDS4CCMPackage#getCXArray_Index()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getIndex();

	/**
	 * Sets the value of the '{@link dds4ccm.CXArray#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(String value);

} // CXArray
