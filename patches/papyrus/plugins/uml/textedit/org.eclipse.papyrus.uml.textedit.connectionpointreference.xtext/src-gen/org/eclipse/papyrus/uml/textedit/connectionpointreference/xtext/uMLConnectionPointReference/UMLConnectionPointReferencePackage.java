/**
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferenceFactory
 * @model kind="package"
 * @generated
 */
public interface UMLConnectionPointReferencePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "uMLConnectionPointReference";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/connectionpointreference/xtext/UMLConnectionPointReference";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "uMLConnectionPointReference";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UMLConnectionPointReferencePackage eINSTANCE = org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.UMLConnectionPointReferencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl <em>Connection Point Reference Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.UMLConnectionPointReferencePackageImpl#getConnectionPointReferenceRule()
	 * @generated
	 */
	int CONNECTION_POINT_REFERENCE_RULE = 0;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE_RULE__ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE_RULE__EXIT = 1;

	/**
	 * The number of structural features of the '<em>Connection Point Reference Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTION_POINT_REFERENCE_RULE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule <em>Connection Point Reference Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Connection Point Reference Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule
	 * @generated
	 */
	EClass getConnectionPointReferenceRule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Entry</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getEntry()
	 * @see #getConnectionPointReferenceRule()
	 * @generated
	 */
	EReference getConnectionPointReferenceRule_Entry();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Exit</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getExit()
	 * @see #getConnectionPointReferenceRule()
	 * @generated
	 */
	EReference getConnectionPointReferenceRule_Exit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UMLConnectionPointReferenceFactory getUMLConnectionPointReferenceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl <em>Connection Point Reference Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.UMLConnectionPointReferencePackageImpl#getConnectionPointReferenceRule()
		 * @generated
		 */
		EClass CONNECTION_POINT_REFERENCE_RULE = eINSTANCE.getConnectionPointReferenceRule();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE_RULE__ENTRY = eINSTANCE.getConnectionPointReferenceRule_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONNECTION_POINT_REFERENCE_RULE__EXIT = eINSTANCE.getConnectionPointReferenceRule_Exit();

	}

} // UMLConnectionPointReferencePackage
