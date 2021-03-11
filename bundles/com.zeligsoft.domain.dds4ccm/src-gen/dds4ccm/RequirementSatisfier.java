/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Satisfier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.RequirementSatisfier#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link dds4ccm.RequirementSatisfier#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getRequirementSatisfier()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL property='ownedAttribute'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface RequirementSatisfier extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' attribute list.
	 * @see dds4ccm.DDS4CCMPackage#getRequirementSatisfier_ResourceType()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	EList<String> getResourceType();

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see dds4ccm.DDS4CCMPackage#getRequirementSatisfier_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link dds4ccm.RequirementSatisfier#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // RequirementSatisfier
