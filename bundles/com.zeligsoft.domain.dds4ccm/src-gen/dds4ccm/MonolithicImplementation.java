/**
 */
package dds4ccm;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monolithic Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.MonolithicImplementation#getCategory <em>Category</em>}</li>
 *   <li>{@link dds4ccm.MonolithicImplementation#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getMonolithicImplementation()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL name='name'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface MonolithicImplementation extends StructuralRealization, WorkerFunctionIdentifiable, Implementation, ManagesImplEnd {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link dds4ccm.ComponentCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see dds4ccm.ComponentCategory
	 * @see #setCategory(ComponentCategory)
	 * @see dds4ccm.DDS4CCMPackage#getMonolithicImplementation_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ComponentCategory getCategory();

	/**
	 * Sets the value of the '{@link dds4ccm.MonolithicImplementation#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see dds4ccm.ComponentCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(ComponentCategory value);

	/**
	 * Returns the value of the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Named Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Named Element</em>' reference.
	 * @see #setBase_NamedElement(NamedElement)
	 * @see dds4ccm.DDS4CCMPackage#getMonolithicImplementation_Base_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getBase_NamedElement();

	/**
	 * Sets the value of the '{@link dds4ccm.MonolithicImplementation#getBase_NamedElement <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Named Element</em>' reference.
	 * @see #getBase_NamedElement()
	 * @generated
	 */
	void setBase_NamedElement(NamedElement value);

} // MonolithicImplementation
