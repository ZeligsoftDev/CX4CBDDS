/**
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferenceFactory;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UMLConnectionPointReferenceFactoryImpl extends EFactoryImpl implements UMLConnectionPointReferenceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UMLConnectionPointReferenceFactory init() {
		try {
			UMLConnectionPointReferenceFactory theUMLConnectionPointReferenceFactory = (UMLConnectionPointReferenceFactory) EPackage.Registry.INSTANCE.getEFactory(UMLConnectionPointReferencePackage.eNS_URI);
			if (theUMLConnectionPointReferenceFactory != null) {
				return theUMLConnectionPointReferenceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLConnectionPointReferenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLConnectionPointReferenceFactoryImpl() {
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
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE:
			return createConnectionPointReferenceRule();
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
	public ConnectionPointReferenceRule createConnectionPointReferenceRule() {
		ConnectionPointReferenceRuleImpl connectionPointReferenceRule = new ConnectionPointReferenceRuleImpl();
		return connectionPointReferenceRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLConnectionPointReferencePackage getUMLConnectionPointReferencePackage() {
		return (UMLConnectionPointReferencePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLConnectionPointReferencePackage getPackage() {
		return UMLConnectionPointReferencePackage.eINSTANCE;
	}

} // UMLConnectionPointReferenceFactoryImpl
