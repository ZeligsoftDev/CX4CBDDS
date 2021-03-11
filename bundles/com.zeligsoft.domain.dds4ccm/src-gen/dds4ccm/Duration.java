/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Duration#getSecond <em>Second</em>}</li>
 *   <li>{@link dds4ccm.Duration#getNanosecond <em>Nanosecond</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getDuration()
 * @model
 * @generated
 */
public interface Duration extends EObject {
	/**
	 * Returns the value of the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' attribute.
	 * @see #setSecond(int)
	 * @see dds4ccm.DDS4CCMPackage#getDuration_Second()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getSecond();

	/**
	 * Sets the value of the '{@link dds4ccm.Duration#getSecond <em>Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second</em>' attribute.
	 * @see #getSecond()
	 * @generated
	 */
	void setSecond(int value);

	/**
	 * Returns the value of the '<em><b>Nanosecond</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nanosecond</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nanosecond</em>' attribute.
	 * @see #setNanosecond(int)
	 * @see dds4ccm.DDS4CCMPackage#getDuration_Nanosecond()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getNanosecond();

	/**
	 * Sets the value of the '{@link dds4ccm.Duration#getNanosecond <em>Nanosecond</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nanosecond</em>' attribute.
	 * @see #getNanosecond()
	 * @generated
	 */
	void setNanosecond(int value);

} // Duration
