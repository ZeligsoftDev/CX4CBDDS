/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.StructuralRealization#getBase_Component <em>Base Component</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getStructuralRealization()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL worker='ownedOperation' part='part' workerImpl='ownedBehavior' ownedPort='ownedAttribute' interface='superClass' connector='ownedConnector'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface StructuralRealization extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' reference.
	 * @see #setBase_Component(Component)
	 * @see dds4ccm.DDS4CCMPackage#getStructuralRealization_Base_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getBase_Component();

	/**
	 * Sets the value of the '{@link dds4ccm.StructuralRealization#getBase_Component <em>Base Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' reference.
	 * @see #getBase_Component()
	 * @generated
	 */
	void setBase_Component(Component value);

} // StructuralRealization
