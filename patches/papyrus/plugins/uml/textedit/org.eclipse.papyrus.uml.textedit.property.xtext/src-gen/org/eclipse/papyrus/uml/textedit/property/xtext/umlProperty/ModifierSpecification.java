/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifier Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getRedefines <em>Redefines</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getSubsets <em>Subsets</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification()
 * @model
 * @generated
 */
public interface ModifierSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierKind
	 * @see #setValue(ModifierKind)
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification_Value()
	 * @model
	 * @generated
	 */
	ModifierKind getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierKind
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ModifierKind value);

	/**
	 * Returns the value of the '<em><b>Redefines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefines</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Redefines</em>' containment reference.
	 * @see #setRedefines(RedefinesRule)
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification_Redefines()
	 * @model containment="true"
	 * @generated
	 */
	RedefinesRule getRedefines();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getRedefines <em>Redefines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Redefines</em>' containment reference.
	 * @see #getRedefines()
	 * @generated
	 */
	void setRedefines(RedefinesRule value);

	/**
	 * Returns the value of the '<em><b>Subsets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subsets</em>' containment reference.
	 * @see #setSubsets(SubsetsRule)
	 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getModifierSpecification_Subsets()
	 * @model containment="true"
	 * @generated
	 */
	SubsetsRule getSubsets();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification#getSubsets <em>Subsets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Subsets</em>' containment reference.
	 * @see #getSubsets()
	 * @generated
	 */
	void setSubsets(SubsetsRule value);

} // ModifierSpecification
