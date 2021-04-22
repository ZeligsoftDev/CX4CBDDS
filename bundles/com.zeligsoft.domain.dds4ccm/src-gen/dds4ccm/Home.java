/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Home</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Home#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getHome()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL operation='ownedOperation' ownedAttribute='ownedAttribute' export='ownedMember' nestedClassifier='nestedClassifier' manages='clientDependency' property='ownedAttribute'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface Home extends CXNamedElement, WorkerFunctionIdentifiable, CXModuleContained, ManagesEnd {
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
	 * @see dds4ccm.DDS4CCMPackage#getHome_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link dds4ccm.Home#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // Home
