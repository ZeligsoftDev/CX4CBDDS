/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extensible</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Extensible#getExtensibility <em>Extensibility</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getExtensible()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Extensible extends EObject {
	/**
	 * Returns the value of the '<em><b>Extensibility</b></em>' attribute.
	 * The default value is <code>"Final"</code>.
	 * The literals are from the enumeration {@link dds4ccm.ExtensibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensibility</em>' attribute.
	 * @see dds4ccm.ExtensibilityKind
	 * @see #setExtensibility(ExtensibilityKind)
	 * @see dds4ccm.DDS4CCMPackage#getExtensible_Extensibility()
	 * @model default="Final" required="true" ordered="false"
	 * @generated
	 */
	ExtensibilityKind getExtensibility();

	/**
	 * Sets the value of the '{@link dds4ccm.Extensible#getExtensibility <em>Extensibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extensibility</em>' attribute.
	 * @see dds4ccm.ExtensibilityKind
	 * @see #getExtensibility()
	 * @generated
	 */
	void setExtensibility(ExtensibilityKind value);

} // Extensible
