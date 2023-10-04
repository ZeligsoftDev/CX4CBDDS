/**
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUseFactory
 * @model kind="package"
 * @generated
 */
public interface UmlCollaborationUsePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlCollaborationUse";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/collaborationuse/xtext/UmlCollaborationUse";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlCollaborationUse";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlCollaborationUsePackage eINSTANCE = org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUsePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.CollaborationUseRuleImpl <em>Collaboration Use Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.CollaborationUseRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUsePackageImpl#getCollaborationUseRule()
	 * @generated
	 */
	int COLLABORATION_USE_RULE = 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_RULE__VISIBILITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_RULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_RULE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Collaboration Use Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.TypeRuleImpl <em>Type Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.TypeRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUsePackageImpl#getTypeRule()
	 * @generated
	 */
	int TYPE_RULE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE__PATH = UmlCommonPackage.TYPE_RULE__PATH;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE__TYPE = UmlCommonPackage.TYPE_RULE__TYPE;

	/**
	 * The number of structural features of the '<em>Type Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_RULE_FEATURE_COUNT = UmlCommonPackage.TYPE_RULE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule <em>Collaboration Use Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collaboration Use Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule
	 * @generated
	 */
	EClass getCollaborationUseRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getVisibility()
	 * @see #getCollaborationUseRule()
	 * @generated
	 */
	EAttribute getCollaborationUseRule_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getName()
	 * @see #getCollaborationUseRule()
	 * @generated
	 */
	EAttribute getCollaborationUseRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule#getType()
	 * @see #getCollaborationUseRule()
	 * @generated
	 */
	EReference getCollaborationUseRule_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule <em>Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule
	 * @generated
	 */
	EClass getTypeRule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlCollaborationUseFactory getUmlCollaborationUseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.CollaborationUseRuleImpl <em>Collaboration Use Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.CollaborationUseRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUsePackageImpl#getCollaborationUseRule()
		 * @generated
		 */
		EClass COLLABORATION_USE_RULE = eINSTANCE.getCollaborationUseRule();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLLABORATION_USE_RULE__VISIBILITY = eINSTANCE.getCollaborationUseRule_Visibility();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLLABORATION_USE_RULE__NAME = eINSTANCE.getCollaborationUseRule_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLABORATION_USE_RULE__TYPE = eINSTANCE.getCollaborationUseRule_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.TypeRuleImpl <em>Type Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.TypeRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl.UmlCollaborationUsePackageImpl#getTypeRule()
		 * @generated
		 */
		EClass TYPE_RULE = eINSTANCE.getTypeRule();

	}

} // UmlCollaborationUsePackage
