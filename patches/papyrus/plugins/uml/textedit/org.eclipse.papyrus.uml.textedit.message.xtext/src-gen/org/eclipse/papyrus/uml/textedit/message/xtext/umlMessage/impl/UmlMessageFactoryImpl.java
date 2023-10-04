/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessageFactory;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlMessageFactoryImpl extends EFactoryImpl implements UmlMessageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlMessageFactory init() {
		try {
			UmlMessageFactory theUmlMessageFactory = (UmlMessageFactory) EPackage.Registry.INSTANCE.getEFactory(UmlMessagePackage.eNS_URI);
			if (theUmlMessageFactory != null) {
				return theUmlMessageFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlMessageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlMessageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UmlMessagePackage.MESSAGE_RULE:
			return createMessageRule();
		case UmlMessagePackage.SEQUENCE_TERM_RULE:
			return createSequenceTermRule();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MessageRule createMessageRule() {
		MessageRuleImpl messageRule = new MessageRuleImpl();
		return messageRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SequenceTermRule createSequenceTermRule() {
		SequenceTermRuleImpl sequenceTermRule = new SequenceTermRuleImpl();
		return sequenceTermRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlMessagePackage getUmlMessagePackage() {
		return (UmlMessagePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlMessagePackage getPackage() {
		return UmlMessagePackage.eINSTANCE;
	}

} // UmlMessageFactoryImpl
