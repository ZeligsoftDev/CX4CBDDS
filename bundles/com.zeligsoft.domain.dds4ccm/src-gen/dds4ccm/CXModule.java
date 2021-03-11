/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CX Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.CXModule#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getCXModule()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL contents='packagedElement'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface CXModule extends CXNamedElement, Contained, CXModuleContained {
	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see dds4ccm.DDS4CCMPackage#getCXModule_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link dds4ccm.CXModule#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // CXModule
