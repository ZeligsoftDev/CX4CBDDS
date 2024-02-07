/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl#getOwnedMultiplicity <em>Owned Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl#getOwnedSubstitutions <em>Owned Substitutions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TemplateBindingCSImpl#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateBindingCSImpl extends ElementRefCSImpl implements TemplateBindingCS {
	/**
	 * The number of structural features of the '<em>Template Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_BINDING_CS_FEATURE_COUNT = ElementRefCSImpl.ELEMENT_REF_CS_FEATURE_COUNT + 3;
	/**
	 * The cached value of the '{@link #getOwnedMultiplicity() <em>Owned Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityCS ownedMultiplicity;
	/**
	 * The cached value of the '{@link #getOwnedSubstitutions() <em>Owned Substitutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubstitutions()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameterSubstitutionCS> ownedSubstitutions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.TEMPLATE_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MultiplicityCS getOwnedMultiplicity()
	{
		return ownedMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMultiplicity(MultiplicityCS newOwnedMultiplicity, NotificationChain msgs)
	{
		MultiplicityCS oldOwnedMultiplicity = ownedMultiplicity;
		ownedMultiplicity = newOwnedMultiplicity;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 3, oldOwnedMultiplicity, newOwnedMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedMultiplicity(MultiplicityCS newOwnedMultiplicity)
	{
		if (newOwnedMultiplicity != ownedMultiplicity)
		{
			NotificationChain msgs = null;
			if (ownedMultiplicity != null)
				msgs = ((InternalEObject)ownedMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			if (newOwnedMultiplicity != null)
				msgs = ((InternalEObject)newOwnedMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			msgs = basicSetOwnedMultiplicity(newOwnedMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, newOwnedMultiplicity, newOwnedMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedTypeRefCS getOwningElement() {
		if (eContainerFeatureID() != (5)) return null;
		return (TypedTypeRefCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningElement(TypedTypeRefCS newOwningElement, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningElement, 5, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningElement(TypedTypeRefCS newOwningElement)
	{
		if (newOwningElement != eInternalContainer() || (eContainerFeatureID() != (5) && newOwningElement != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningElement != null)
				msgs = ((InternalEObject)newOwningElement).eInverseAdd(this, 5, TypedTypeRefCS.class, msgs);
			msgs = basicSetOwningElement(newOwningElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, newOwningElement, newOwningElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TemplateParameterSubstitutionCS> getOwnedSubstitutions() {
		if (ownedSubstitutions == null)
		{
			ownedSubstitutions = new EObjectContainmentWithInverseEList<TemplateParameterSubstitutionCS>(TemplateParameterSubstitutionCS.class, this, 4, 6);
		}
		return ownedSubstitutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 4:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSubstitutions()).basicAdd(otherEnd, msgs);
			case 5:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningElement((TypedTypeRefCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 3:
				return basicSetOwnedMultiplicity(null, msgs);
			case 4:
				return ((InternalEList<?>)getOwnedSubstitutions()).basicRemove(otherEnd, msgs);
			case 5:
				return basicSetOwningElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case 5:
				return eInternalContainer().eInverseRemove(this, 5, TypedTypeRefCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case 3:
				return getOwnedMultiplicity();
			case 4:
				return getOwnedSubstitutions();
			case 5:
				return getOwningElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case 3:
				setOwnedMultiplicity((MultiplicityCS)newValue);
				return;
			case 4:
				getOwnedSubstitutions().clear();
				getOwnedSubstitutions().addAll((Collection<? extends TemplateParameterSubstitutionCS>)newValue);
				return;
			case 5:
				setOwningElement((TypedTypeRefCS)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case 3:
				setOwnedMultiplicity((MultiplicityCS)null);
				return;
			case 4:
				getOwnedSubstitutions().clear();
				return;
			case 5:
				setOwningElement((TypedTypeRefCS)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case 3:
				return ownedMultiplicity != null;
			case 4:
				return ownedSubstitutions != null && !ownedSubstitutions.isEmpty();
			case 5:
				return getOwningElement() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitTemplateBindingCS(this);
	}
} //TemplateBindingCSImpl
