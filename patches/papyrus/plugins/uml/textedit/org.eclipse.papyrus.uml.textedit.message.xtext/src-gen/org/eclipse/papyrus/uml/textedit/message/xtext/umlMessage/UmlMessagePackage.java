/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessageFactory
 * @model kind="package"
 * @generated
 */
public interface UmlMessagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlMessage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/message/xtext/UmlMessage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlMessage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlMessagePackage eINSTANCE = org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.UmlMessagePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.MessageRuleImpl <em>Message Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.MessageRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.UmlMessagePackageImpl#getMessageRule()
	 * @generated
	 */
	int MESSAGE_RULE = 0;

	/**
	 * The feature id for the '<em><b>Sequence Term</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MESSAGE_RULE__SEQUENCE_TERM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MESSAGE_RULE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Message Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MESSAGE_RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl <em>Sequence Term Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.UmlMessagePackageImpl#getSequenceTermRule()
	 * @generated
	 */
	int SEQUENCE_TERM_RULE = 1;

	/**
	 * The feature id for the '<em><b>Sequencial Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER = 0;

	/**
	 * The feature id for the '<em><b>Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TERM_RULE__SEQUENCE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Recurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TERM_RULE__RECURRENCE = 2;

	/**
	 * The number of structural features of the '<em>Sequence Term Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TERM_RULE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule <em>Message Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Message Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule
	 * @generated
	 */
	EClass getMessageRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getSequenceTerm <em>Sequence Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sequence Term</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getSequenceTerm()
	 * @see #getMessageRule()
	 * @generated
	 */
	EReference getMessageRule_SequenceTerm();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getName()
	 * @see #getMessageRule()
	 * @generated
	 */
	EAttribute getMessageRule_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule <em>Sequence Term Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sequence Term Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule
	 * @generated
	 */
	EClass getSequenceTermRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequencialOrder <em>Sequencial Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sequencial Order</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequencialOrder()
	 * @see #getSequenceTermRule()
	 * @generated
	 */
	EAttribute getSequenceTermRule_SequencialOrder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequenceName <em>Sequence Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sequence Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequenceName()
	 * @see #getSequenceTermRule()
	 * @generated
	 */
	EAttribute getSequenceTermRule_SequenceName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getRecurrence <em>Recurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Recurrence</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getRecurrence()
	 * @see #getSequenceTermRule()
	 * @generated
	 */
	EAttribute getSequenceTermRule_Recurrence();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlMessageFactory getUmlMessageFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.MessageRuleImpl <em>Message Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.MessageRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.UmlMessagePackageImpl#getMessageRule()
		 * @generated
		 */
		EClass MESSAGE_RULE = eINSTANCE.getMessageRule();

		/**
		 * The meta object literal for the '<em><b>Sequence Term</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MESSAGE_RULE__SEQUENCE_TERM = eINSTANCE.getMessageRule_SequenceTerm();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MESSAGE_RULE__NAME = eINSTANCE.getMessageRule_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl <em>Sequence Term Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.UmlMessagePackageImpl#getSequenceTermRule()
		 * @generated
		 */
		EClass SEQUENCE_TERM_RULE = eINSTANCE.getSequenceTermRule();

		/**
		 * The meta object literal for the '<em><b>Sequencial Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER = eINSTANCE.getSequenceTermRule_SequencialOrder();

		/**
		 * The meta object literal for the '<em><b>Sequence Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SEQUENCE_TERM_RULE__SEQUENCE_NAME = eINSTANCE.getSequenceTermRule_SequenceName();

		/**
		 * The meta object literal for the '<em><b>Recurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SEQUENCE_TERM_RULE__RECURRENCE = eINSTANCE.getSequenceTermRule_Recurrence();

	}

} // UmlMessagePackage
