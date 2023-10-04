/**
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Point Reference Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl#getEntry <em>Entry</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl.ConnectionPointReferenceRuleImpl#getExit <em>Exit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionPointReferenceRuleImpl extends MinimalEObjectImpl.Container implements ConnectionPointReferenceRule {
	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<Pseudostate> entry;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected EList<Pseudostate> exit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectionPointReferenceRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLConnectionPointReferencePackage.Literals.CONNECTION_POINT_REFERENCE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Pseudostate> getEntry() {
		if (entry == null) {
			entry = new EObjectResolvingEList<Pseudostate>(Pseudostate.class, this, UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__ENTRY);
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Pseudostate> getExit() {
		if (exit == null) {
			exit = new EObjectResolvingEList<Pseudostate>(Pseudostate.class, this, UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__EXIT);
		}
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__ENTRY:
			return getEntry();
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__EXIT:
			return getExit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__ENTRY:
			getEntry().clear();
			getEntry().addAll((Collection<? extends Pseudostate>) newValue);
			return;
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__EXIT:
			getExit().clear();
			getExit().addAll((Collection<? extends Pseudostate>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__ENTRY:
			getEntry().clear();
			return;
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__EXIT:
			getExit().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__ENTRY:
			return entry != null && !entry.isEmpty();
		case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE__EXIT:
			return exit != null && !exit.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ConnectionPointReferenceRuleImpl
