/**
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage
 * @generated
 */
public interface UmlCollaborationUseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlCollaborationUseFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Collaboration Use Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collaboration Use Rule</em>'.
	 * @generated
	 */
	CollaborationUseRule createCollaborationUseRule();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlCollaborationUsePackage getUmlCollaborationUsePackage();

} // UmlCollaborationUseFactory
