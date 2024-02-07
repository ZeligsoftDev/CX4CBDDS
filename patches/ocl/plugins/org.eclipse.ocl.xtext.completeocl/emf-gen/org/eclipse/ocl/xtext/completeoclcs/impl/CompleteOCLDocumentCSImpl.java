/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.impl.NamespaceCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.util.CompleteOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedContexts <em>Owned Contexts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.CompleteOCLDocumentCSImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompleteOCLDocumentCSImpl
		extends NamespaceCSImpl
		implements CompleteOCLDocumentCS {

	/**
	 * The number of structural features of the '<em>Complete OCL Document CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_OCL_DOCUMENT_CS_FEATURE_COUNT = NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getOwnedImports() <em>Owned Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> ownedImports;

	/**
	 * The cached value of the '{@link #getOwnedContexts() <em>Owned Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<ContextDeclCS> ownedContexts;

	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageDeclarationCS> ownedPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteOCLDocumentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.COMPLETE_OCL_DOCUMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportCS> getOwnedImports()
	{
		if (ownedImports == null)
		{
			ownedImports = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0);
		}
		return ownedImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PackageDeclarationCS> getOwnedPackages() {
		if (ownedPackages == null)
		{
			ownedPackages = new EObjectContainmentEList<PackageDeclarationCS>(PackageDeclarationCS.class, this, NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2);
		}
		return ownedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContextDeclCS> getOwnedContexts() {
		if (ownedContexts == null)
		{
			ownedContexts = new EObjectContainmentEList<ContextDeclCS>(ContextDeclCS.class, this, NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1);
		}
		return ownedContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedImports()).basicRemove(otherEnd, msgs);
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedContexts()).basicRemove(otherEnd, msgs);
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0:
				return getOwnedImports();
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1:
				return getOwnedContexts();
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2:
				return getOwnedPackages();
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
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0:
				getOwnedImports().clear();
				getOwnedImports().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1:
				getOwnedContexts().clear();
				getOwnedContexts().addAll((Collection<? extends ContextDeclCS>)newValue);
				return;
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends PackageDeclarationCS>)newValue);
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
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0:
				getOwnedImports().clear();
				return;
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1:
				getOwnedContexts().clear();
				return;
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2:
				getOwnedPackages().clear();
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
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0:
				return ownedImports != null && !ownedImports.isEmpty();
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 1:
				return ownedContexts != null && !ownedContexts.isEmpty();
			case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 2:
				return ownedPackages != null && !ownedPackages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (derivedFeatureID)
			{
				case NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0: return 5;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (baseFeatureID)
			{
				case 5: return NamespaceCSImpl.NAMESPACE_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof CompleteOCLCSVisitor) {
			return (R) ((CompleteOCLCSVisitor<?>)visitor).visitCompleteOCLDocumentCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Overridden to ensure that librarty and import declarations preceed other content.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> eContents() {
		EList<EObject> result = eProperties().getEContents();
		if (result == null) {
			result = CS2AS.computeRootContainmentFeatures(this);
			eBasicProperties().setEContents(result);
		}
		return result;
	}
} //DocumentCSImpl
