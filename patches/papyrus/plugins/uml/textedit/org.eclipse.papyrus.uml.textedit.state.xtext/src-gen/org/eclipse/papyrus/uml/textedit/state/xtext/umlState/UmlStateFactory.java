/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage
 * @generated
 */
public interface UmlStateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlStateFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl.UmlStateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State Rule</em>'.
	 * @generated
	 */
	StateRule createStateRule();

	/**
	 * Returns a new object of class '<em>Submachine Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Submachine Rule</em>'.
	 * @generated
	 */
	SubmachineRule createSubmachineRule();

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
	 * Returns a new object of class '<em>Entry Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Entry Rule</em>'.
	 * @generated
	 */
	EntryRule createEntryRule();

	/**
	 * Returns a new object of class '<em>Do Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Do Rule</em>'.
	 * @generated
	 */
	DoRule createDoRule();

	/**
	 * Returns a new object of class '<em>Exit Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Exit Rule</em>'.
	 * @generated
	 */
	ExitRule createExitRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlStatePackage getUmlStatePackage();

} // UmlStateFactory
