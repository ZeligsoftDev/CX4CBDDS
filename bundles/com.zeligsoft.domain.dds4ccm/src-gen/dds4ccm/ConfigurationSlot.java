/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ConfigurationSlot#getSlotKind <em>Slot Kind</em>}</li>
 *   <li>{@link dds4ccm.ConfigurationSlot#getBase_Slot <em>Base Slot</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getConfigurationSlot()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ConfigurationSlot extends EObject {
	/**
	 * Returns the value of the '<em><b>Slot Kind</b></em>' attribute.
	 * The default value is <code>"additive"</code>.
	 * The literals are from the enumeration {@link dds4ccm.ConfigurationSlotKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Kind</em>' attribute.
	 * @see dds4ccm.ConfigurationSlotKind
	 * @see #setSlotKind(ConfigurationSlotKind)
	 * @see dds4ccm.DDS4CCMPackage#getConfigurationSlot_SlotKind()
	 * @model default="additive" required="true" ordered="false"
	 * @generated
	 */
	ConfigurationSlotKind getSlotKind();

	/**
	 * Sets the value of the '{@link dds4ccm.ConfigurationSlot#getSlotKind <em>Slot Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Kind</em>' attribute.
	 * @see dds4ccm.ConfigurationSlotKind
	 * @see #getSlotKind()
	 * @generated
	 */
	void setSlotKind(ConfigurationSlotKind value);

	/**
	 * Returns the value of the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Slot</em>' reference.
	 * @see #setBase_Slot(Slot)
	 * @see dds4ccm.DDS4CCMPackage#getConfigurationSlot_Base_Slot()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Slot getBase_Slot();

	/**
	 * Sets the value of the '{@link dds4ccm.ConfigurationSlot#getBase_Slot <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Slot</em>' reference.
	 * @see #getBase_Slot()
	 * @generated
	 */
	void setBase_Slot(Slot value);

} // ConfigurationSlot
