/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of type names used to provide arguments for the parameters of a template.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTemplateBinding()
 * @model abstract="true"
 * @generated
 */
public interface TemplateBinding extends SyntaxElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" templateRequired="true"
	 * @generated
	 */
	boolean matches(ElementReference template);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	TemplateBinding copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" templateRequired="true"
	 * @generated
	 */
	EList<ElementReference> bindTo(ElementReference template);

} // TemplateBinding
