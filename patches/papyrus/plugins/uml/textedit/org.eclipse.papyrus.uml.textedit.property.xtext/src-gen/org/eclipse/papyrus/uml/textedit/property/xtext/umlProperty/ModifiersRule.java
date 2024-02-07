/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifiers Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifiersRule()
 * @model
 * @generated
 */
public interface ModifiersRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifiersRule_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModifierSpecification> getValues();

} // ModifiersRule
