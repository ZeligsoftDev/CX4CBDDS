/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage
 * @generated
 */
public interface UmlValueSpecificationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlValueSpecificationFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Abstract Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Abstract Rule</em>'.
	 * @generated
	 */
	AbstractRule createAbstractRule();

	/**
	 * Returns a new object of class '<em>Literal Boolean Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Boolean Rule</em>'.
	 * @generated
	 */
	LiteralBooleanRule createLiteralBooleanRule();

	/**
	 * Returns a new object of class '<em>Literal Integer Or Unlimited Natural Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Integer Or Unlimited Natural Rule</em>'.
	 * @generated
	 */
	LiteralIntegerOrUnlimitedNaturalRule createLiteralIntegerOrUnlimitedNaturalRule();

	/**
	 * Returns a new object of class '<em>Literal Real Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Real Rule</em>'.
	 * @generated
	 */
	LiteralRealRule createLiteralRealRule();

	/**
	 * Returns a new object of class '<em>Literal Null Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Null Rule</em>'.
	 * @generated
	 */
	LiteralNullRule createLiteralNullRule();

	/**
	 * Returns a new object of class '<em>Literal String Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal String Rule</em>'.
	 * @generated
	 */
	LiteralStringRule createLiteralStringRule();

	/**
	 * Returns a new object of class '<em>Undefined Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Undefined Rule</em>'.
	 * @generated
	 */
	UndefinedRule createUndefinedRule();

	/**
	 * Returns a new object of class '<em>Visibility Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Visibility Kind</em>'.
	 * @generated
	 */
	VisibilityKind createVisibilityKind();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlValueSpecificationPackage getUmlValueSpecificationPackage();

} // UmlValueSpecificationFactory
