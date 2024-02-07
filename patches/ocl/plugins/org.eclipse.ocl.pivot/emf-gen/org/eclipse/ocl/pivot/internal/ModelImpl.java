/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.complete.ModelListeners;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ModelImpl#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ModelImpl#getOwnedImports <em>Owned Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ModelImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ModelImpl#getXmiidVersion <em>Xmiid Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends NamespaceImpl implements Model
{

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_FEATURE_COUNT = NamespaceImpl.NAMESPACE_FEATURE_COUNT + 4;
	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_OPERATION_COUNT = NamespaceImpl.NAMESPACE_OPERATION_COUNT + 0;
	/**
	 * The default value of the '{@link #getExternalURI() <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalURI()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExternalURI() <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalURI()
	 * @generated
	 * @ordered
	 */
	protected String externalURI = EXTERNAL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedImports() <em>Owned Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> ownedImports;
	/**
	 * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> ownedPackages;
	/**
	 * The default value of the '{@link #getXmiidVersion() <em>Xmiid Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @see #getXmiidVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Number XMIID_VERSION_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getInteger(), "0"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getXmiidVersion() <em>Xmiid Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @see #getXmiidVersion()
	 * @generated
	 * @ordered
	 */
	protected Number xmiidVersion = XMIID_VERSION_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.MODEL;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages()
	{
		EList<org.eclipse.ocl.pivot.Package> ownedPackages2 = ownedPackages;
		if (ownedPackages2 == null)
		{
			ownedPackages = ownedPackages2 = new EObjectContainmentEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, PivotPackage.Literals.MODEL__OWNED_PACKAGES.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void didAdd(int index, org.eclipse.ocl.pivot.Package partialPackage) {
					assert partialPackage != null;
					didAddPackage(partialPackage);
				}

				@Override
				protected void didRemove(int index, org.eclipse.ocl.pivot.Package partialPackage) {
					assert partialPackage != null;
					didRemovePackage(partialPackage);
				}
			};
		}
		return ownedPackages2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getXmiidVersion()
	{
		return xmiidVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.4
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXmiidVersion(Number newXmiidVersion)
	{
		Number oldXmiidVersion = xmiidVersion;
		xmiidVersion = newXmiidVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 9, oldXmiidVersion, xmiidVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExternalURI()
	{
		return externalURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalURIGen(String newExternalURI)
	{
		String oldExternalURI = externalURI;
		externalURI = newExternalURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldExternalURI, externalURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case 0:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case 5:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
			case 7:
				return ((InternalEList<?>)getOwnedImports()).basicRemove(otherEnd, msgs);
			case 8:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case 0:
				return getAnnotatingComments();
			case 1:
				return getOwnedAnnotations();
			case 2:
				return getOwnedComments();
			case 3:
				return getOwnedExtensions();
			case 4:
				return getName();
			case 5:
				return getOwnedConstraints();
			case 6:
				return getExternalURI();
			case 7:
				return getOwnedImports();
			case 8:
				return getOwnedPackages();
			case 9:
				return getXmiidVersion();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case 0:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 1:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case 2:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 3:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case 4:
				setName((String)newValue);
				return;
			case 5:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 6:
				setExternalURI((String)newValue);
				return;
			case 7:
				getOwnedImports().clear();
				getOwnedImports().addAll((Collection<? extends Import>)newValue);
				return;
			case 8:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case 9:
				setXmiidVersion((Number)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case 0:
				getAnnotatingComments().clear();
				return;
			case 1:
				getOwnedAnnotations().clear();
				return;
			case 2:
				getOwnedComments().clear();
				return;
			case 3:
				getOwnedExtensions().clear();
				return;
			case 4:
				setName(NAME_EDEFAULT);
				return;
			case 5:
				getOwnedConstraints().clear();
				return;
			case 6:
				setExternalURI(EXTERNAL_URI_EDEFAULT);
				return;
			case 7:
				getOwnedImports().clear();
				return;
			case 8:
				getOwnedPackages().clear();
				return;
			case 9:
				setXmiidVersion(XMIID_VERSION_EDEFAULT);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case 0:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case 1:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case 2:
				return ownedComments != null && !ownedComments.isEmpty();
			case 3:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 5:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case 6:
				return EXTERNAL_URI_EDEFAULT == null ? externalURI != null : !EXTERNAL_URI_EDEFAULT.equals(externalURI);
			case 7:
				return ownedImports != null && !ownedImports.isEmpty();
			case 8:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case 9:
				return XMIID_VERSION_EDEFAULT == null ? xmiidVersion != null : !XMIID_VERSION_EDEFAULT.equals(xmiidVersion);
		}
		return eDynamicIsSet(featureID);
	}

	private @Nullable ModelListeners<ModelListeners.IModelListener> rootListeners = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitModel(this);
	}

	public synchronized void addRootListener(ModelListeners.@NonNull IModelListener rootListener) {
		ModelListeners<ModelListeners.IModelListener> rootListeners2 = rootListeners;
		if (rootListeners2 == null) {
			rootListeners2 = rootListeners = new ModelListeners<ModelListeners.IModelListener>();
		}
		rootListeners2.addListener(rootListener);
	}

	protected void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (rootListeners != null) {
			rootListeners.didAddPackage(partialPackage);
		}
	}

	protected void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (rootListeners != null) {
			rootListeners.didRemovePackage(partialPackage);
		}
	}

	public synchronized void removeRootListener(ModelListeners.@NonNull IModelListener rootListener) {
		ModelListeners<ModelListeners.IModelListener> rootListeners2 = rootListeners;
		if ((rootListeners2 != null) && rootListeners2.removeListener(rootListener)) {
			rootListeners = null;
		}
	}

	@Override
	public void setExternalURI(String newExternalURI)
	{
		setExternalURIGen(newExternalURI);
		String newName;
		if (externalURI != null) {
			int lastIndex = externalURI.lastIndexOf("/");
			if (lastIndex > 0) {
				newName = externalURI.substring(lastIndex+1);
			}
			else {
				newName = externalURI;
			}
		}
		else {
			newName = null;
		}
		super.setName(newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Import> getOwnedImports()
	{
		if (ownedImports == null)
		{
			ownedImports = new EObjectContainmentEList<Import>(Import.class, this, 7);
		}
		return ownedImports;
	}

	@Override
	public void setName(String newName) {		// FIXME BUG 421716 remove Namedspace/NamedElement inheritance
		// name is a cached optimization of externalURI
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //RootImpl
