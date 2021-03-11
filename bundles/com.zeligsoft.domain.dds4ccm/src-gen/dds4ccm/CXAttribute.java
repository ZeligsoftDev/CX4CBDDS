/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXAttribute#getSetraises <em>Setraises</em>}</li>
 *   <li>{@link dds4ccm.CXAttribute#getGetraises <em>Getraises</em>}</li>
 *   <li>{@link dds4ccm.CXAttribute#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXAttribute()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL owner='owner' isReadOnly='isReadOnly'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXAttribute extends CXNamedElement, WorkerFunctionIdentifiable, CXTyped {
	/**
	 * Returns the value of the '<em><b>Setraises</b></em>' reference list.
	 * The list contents are of type {@link dds4ccm.CXException}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setraises</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setraises</em>' reference list.
	 * @see dds4ccm.DDS4CCMPackage#getCXAttribute_Setraises()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CXException> getSetraises();

	/**
	 * Returns the value of the '<em><b>Getraises</b></em>' reference list.
	 * The list contents are of type {@link dds4ccm.CXException}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Getraises</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Getraises</em>' reference list.
	 * @see dds4ccm.DDS4CCMPackage#getCXAttribute_Getraises()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CXException> getGetraises();

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see dds4ccm.DDS4CCMPackage#getCXAttribute_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link dds4ccm.CXAttribute#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // CXAttribute
