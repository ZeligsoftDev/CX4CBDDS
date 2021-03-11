/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker Function Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.WorkerFunctionIdentifiable#getUuid <em>Uuid</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getWorkerFunctionIdentifiable()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface WorkerFunctionIdentifiable extends EObject {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see dds4ccm.DDS4CCMPackage#getWorkerFunctionIdentifiable_Uuid()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link dds4ccm.WorkerFunctionIdentifiable#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

} // WorkerFunctionIdentifiable
