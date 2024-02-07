/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage
 * @generated
 */
public interface UmlPortFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlPortFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Port Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Port Rule</em>'.
	 * @generated
	 */
	PortRule createPortRule();

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
	 * Returns a new object of class '<em>Type Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Type Rule</em>'.
	 * @generated
	 */
	TypeRule createTypeRule();

	/**
	 * Returns a new object of class '<em>Qualified Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Qualified Name</em>'.
	 * @generated
	 */
	QualifiedName createQualifiedName();

	/**
	 * Returns a new object of class '<em>Multiplicity Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multiplicity Rule</em>'.
	 * @generated
	 */
	MultiplicityRule createMultiplicityRule();

	/**
	 * Returns a new object of class '<em>Bound Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Bound Specification</em>'.
	 * @generated
	 */
	BoundSpecification createBoundSpecification();

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
	 * Returns a new object of class '<em>Redefines Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Redefines Rule</em>'.
	 * @generated
	 */
	RedefinesRule createRedefinesRule();

	/**
	 * Returns a new object of class '<em>Subsets Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Subsets Rule</em>'.
	 * @generated
	 */
	SubsetsRule createSubsetsRule();

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
	UmlPortPackage getUmlPortPackage();

} // UmlPortFactory
