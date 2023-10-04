/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage
 * @generated
 */
public interface UmlCommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlCommonFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.UmlCommonFactoryImpl.init();

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
	 * Returns a new object of class '<em>Type Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Type Rule</em>'.
	 * @generated
	 */
	TypeRule createTypeRule();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlCommonPackage getUmlCommonPackage();

} // UmlCommonFactory
