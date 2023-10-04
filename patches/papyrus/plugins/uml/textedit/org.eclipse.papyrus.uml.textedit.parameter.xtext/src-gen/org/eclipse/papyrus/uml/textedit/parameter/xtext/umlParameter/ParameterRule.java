/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#isTypeUndefined <em>Type Undefined</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule()
 * @model
 * @generated
 */
public interface ParameterRule extends EObject {
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
	 * @see #setVisibility(VisibilityRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Visibility()
	 * @model containment="true"
	 * @generated
	 */
	VisibilityRule getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Visibility</em>' containment reference.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityRule value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Direction</em>' containment reference.
	 * @see #setDirection(DirectionRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Direction()
	 * @model containment="true"
	 * @generated
	 */
	DirectionRule getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Direction</em>' containment reference.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionRule value);

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
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}' attribute.
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
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeRule getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeRule value);

	/**
	 * Returns the value of the '<em><b>Type Undefined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Undefined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Undefined</em>' attribute.
	 * @see #setTypeUndefined(boolean)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_TypeUndefined()
	 * @model
	 * @generated
	 */
	boolean isTypeUndefined();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#isTypeUndefined <em>Type Undefined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type Undefined</em>' attribute.
	 * @see #isTypeUndefined()
	 * @generated
	 */
	void setTypeUndefined(boolean value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(MultiplicityRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Multiplicity()
	 * @model containment="true"
	 * @generated
	 */
	MultiplicityRule getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityRule value);

	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifiers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Modifiers</em>' containment reference.
	 * @see #setModifiers(ModifiersRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Modifiers()
	 * @model containment="true"
	 * @generated
	 */
	ModifiersRule getModifiers();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Modifiers</em>' containment reference.
	 * @see #getModifiers()
	 * @generated
	 */
	void setModifiers(ModifiersRule value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(EffectRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Effect()
	 * @model containment="true"
	 * @generated
	 */
	EffectRule getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(EffectRule value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(DefaultValueRule)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	DefaultValueRule getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(DefaultValueRule value);

} // ParameterRule
