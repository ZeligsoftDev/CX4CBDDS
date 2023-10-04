/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.MultiplicityRuleImpl#getBounds <em>Bounds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicityRuleImpl extends MinimalEObjectImpl.Container implements MultiplicityRule {
	/**
	 * The cached value of the '{@link #getBounds() <em>Bounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBounds()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundSpecification> bounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiplicityRuleImpl() {
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
		return UmlPropertyPackage.Literals.MULTIPLICITY_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<BoundSpecification> getBounds() {
		if (bounds == null) {
			bounds = new EObjectContainmentEList<BoundSpecification>(BoundSpecification.class, this, UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS);
		}
		return bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS:
			return ((InternalEList<?>) getBounds()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS:
			return getBounds();
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
		case UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS:
			getBounds().clear();
			getBounds().addAll((Collection<? extends BoundSpecification>) newValue);
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
		case UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS:
			getBounds().clear();
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
		case UmlPropertyPackage.MULTIPLICITY_RULE__BOUNDS:
			return bounds != null && !bounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // MultiplicityRuleImpl
