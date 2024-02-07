/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getVisibility <em>Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getInstanceSpecification <em>Instance Specification</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getUndefined <em>Undefined</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule()
 * @model
 * @generated
 */
public interface AbstractRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Visibility</em>' containment reference.
	 * @see #setVisibility(VisibilityKind)
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule_Visibility()
	 * @model containment="true"
	 * @generated
	 */
	VisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getVisibility <em>Visibility</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Visibility</em>' containment reference.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityKind value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instance Specification</em>' reference.
	 * @see #setInstanceSpecification(InstanceSpecification)
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule_InstanceSpecification()
	 * @model
	 * @generated
	 */
	InstanceSpecification getInstanceSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getInstanceSpecification <em>Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Instance Specification</em>' reference.
	 * @see #getInstanceSpecification()
	 * @generated
	 */
	void setInstanceSpecification(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(EObject)
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule_Value()
	 * @model containment="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Undefined</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Undefined</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Undefined</em>' containment reference.
	 * @see #setUndefined(UndefinedRule)
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#getAbstractRule_Undefined()
	 * @model containment="true"
	 * @generated
	 */
	UndefinedRule getUndefined();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getUndefined <em>Undefined</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Undefined</em>' containment reference.
	 * @see #getUndefined()
	 * @generated
	 */
	void setUndefined(UndefinedRule value);

} // AbstractRule
