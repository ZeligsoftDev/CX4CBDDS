/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ModuleBinding#getBase_TemplateBinding <em>Base Template Binding</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getModuleBinding()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL parameterBinding='parameterSubstitution' boundElement='boundElement' template='signature'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ModuleBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Template Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Template Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Template Binding</em>' reference.
	 * @see #setBase_TemplateBinding(TemplateBinding)
	 * @see dds4ccm.DDS4CCMPackage#getModuleBinding_Base_TemplateBinding()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TemplateBinding getBase_TemplateBinding();

	/**
	 * Sets the value of the '{@link dds4ccm.ModuleBinding#getBase_TemplateBinding <em>Base Template Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Template Binding</em>' reference.
	 * @see #getBase_TemplateBinding()
	 * @generated
	 */
	void setBase_TemplateBinding(TemplateBinding value);

} // ModuleBinding
