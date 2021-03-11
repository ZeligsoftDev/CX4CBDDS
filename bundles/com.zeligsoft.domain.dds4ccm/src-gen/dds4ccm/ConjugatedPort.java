/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conjugated Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ConjugatedPort#isConjugated <em>Is Conjugated</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getConjugatedPort()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ConjugatedPort extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Conjugated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Conjugated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Conjugated</em>' attribute.
	 * @see #setIsConjugated(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getConjugatedPort_IsConjugated()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isConjugated();

	/**
	 * Sets the value of the '{@link dds4ccm.ConjugatedPort#isConjugated <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Conjugated</em>' attribute.
	 * @see #isConjugated()
	 * @generated
	 */
	void setIsConjugated(boolean value);

} // ConjugatedPort
