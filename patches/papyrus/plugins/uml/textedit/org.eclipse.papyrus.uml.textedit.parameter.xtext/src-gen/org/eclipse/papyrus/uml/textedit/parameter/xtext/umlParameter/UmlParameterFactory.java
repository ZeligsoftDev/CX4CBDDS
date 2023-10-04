/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage
 * @generated
 */
public interface UmlParameterFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlParameterFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Parameter Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Parameter Rule</em>'.
	 * @generated
	 */
	ParameterRule createParameterRule();

	/**
	 * Returns a new object of class '<em>Modifiers Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Modifiers Rule</em>'.
	 * @generated
	 */
	ModifiersRule createModifiersRule();

	/**
	 * Returns a new object of class '<em>Modifier Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Modifier Specification</em>'.
	 * @generated
	 */
	ModifierSpecification createModifierSpecification();

	/**
	 * Returns a new object of class '<em>Visibility Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Visibility Rule</em>'.
	 * @generated
	 */
	VisibilityRule createVisibilityRule();

	/**
	 * Returns a new object of class '<em>Direction Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Direction Rule</em>'.
	 * @generated
	 */
	DirectionRule createDirectionRule();

	/**
	 * Returns a new object of class '<em>Effect Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Effect Rule</em>'.
	 * @generated
	 */
	EffectRule createEffectRule();

	/**
	 * Returns a new object of class '<em>Default Value Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Value Rule</em>'.
	 * @generated
	 */
	DefaultValueRule createDefaultValueRule();

	/**
	 * Returns a new object of class '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Value</em>'.
	 * @generated
	 */
	Value createValue();

	/**
	 * Returns a new object of class '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Int Value</em>'.
	 * @generated
	 */
	IntValue createIntValue();

	/**
	 * Returns a new object of class '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>String Value</em>'.
	 * @generated
	 */
	StringValue createStringValue();

	/**
	 * Returns a new object of class '<em>Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Boolean Value</em>'.
	 * @generated
	 */
	BooleanValue createBooleanValue();

	/**
	 * Returns a new object of class '<em>Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Real Value</em>'.
	 * @generated
	 */
	RealValue createRealValue();

	/**
	 * Returns a new object of class '<em>Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Null Value</em>'.
	 * @generated
	 */
	NullValue createNullValue();

	/**
	 * Returns a new object of class '<em>No Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>No Value</em>'.
	 * @generated
	 */
	NoValue createNoValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlParameterPackage getUmlParameterPackage();

} // UmlParameterFactory
