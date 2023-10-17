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
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.InstanceSpecification;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.complete.PackageListeners;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getImportedPackages <em>Imported Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getOwnedClasses <em>Owned Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getOwnedInstances <em>Owned Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getOwnedProfileApplications <em>Owned Profile Applications</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PackageImpl#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageImpl
extends NamespaceImpl
implements org.eclipse.ocl.pivot.Package {

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_FEATURE_COUNT = NamespaceImpl.NAMESPACE_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_OPERATION_COUNT = NamespaceImpl.NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportedPackages() <em>Imported Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> importedPackages;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedClasses() <em>Owned Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> ownedClasses;

	/**
	 * The cached value of the '{@link #getOwnedInstances() <em>Owned Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSpecification> ownedInstances;

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
	 * The cached value of the '{@link #getOwnedProfileApplications() <em>Owned Profile Applications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProfileApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfileApplication> ownedProfileApplications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURIGen(String newURI) {
		String oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<org.eclipse.ocl.pivot.Package> getImportedPackages()
	{
		if (importedPackages == null)
		{
			importedPackages = new EObjectResolvingEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, 7);
		}
		return importedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<InstanceSpecification> getOwnedInstances()
	{
		if (ownedInstances == null)
		{
			ownedInstances = new EObjectContainmentWithInverseEList<InstanceSpecification>(InstanceSpecification.class, this, 10, 8);
		}
		return ownedInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		if (eContainerFeatureID() != (13)) return null;
		return (org.eclipse.ocl.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPackage(org.eclipse.ocl.pivot.Package newOwningPackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningPackage, 13, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningPackage(
			org.eclipse.ocl.pivot.Package newOwningPackage) {
		if (newOwningPackage != eInternalContainer() || (eContainerFeatureID() != (13) && newOwningPackage != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPackage != null)
				msgs = ((InternalEObject)newOwningPackage).eInverseAdd(this, 11, org.eclipse.ocl.pivot.Package.class, msgs);
			msgs = basicSetOwningPackage(newOwningPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 13, newOwningPackage, newOwningPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case 9:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClasses()).basicAdd(otherEnd, msgs);
			case 10:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedInstances()).basicAdd(otherEnd, msgs);
			case 11:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPackages()).basicAdd(otherEnd, msgs);
			case 12:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProfileApplications()).basicAdd(otherEnd, msgs);
			case 13:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.pivot.Package)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case 9:
				return ((InternalEList<?>)getOwnedClasses()).basicRemove(otherEnd, msgs);
			case 10:
				return ((InternalEList<?>)getOwnedInstances()).basicRemove(otherEnd, msgs);
			case 11:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
			case 12:
				return ((InternalEList<?>)getOwnedProfileApplications()).basicRemove(otherEnd, msgs);
			case 13:
				return basicSetOwningPackage(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case 13:
				return eInternalContainer().eInverseRemove(this, 11, org.eclipse.ocl.pivot.Package.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
				return getURI();
			case 7:
				return getImportedPackages();
			case 8:
				return getNsPrefix();
			case 9:
				return getOwnedClasses();
			case 10:
				return getOwnedInstances();
			case 11:
				return getOwnedPackages();
			case 12:
				return getOwnedProfileApplications();
			case 13:
				return getOwningPackage();
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
	public void eSet(int featureID, Object newValue) {
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
				setURI((String)newValue);
				return;
			case 7:
				getImportedPackages().clear();
				getImportedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case 8:
				setNsPrefix((String)newValue);
				return;
			case 9:
				getOwnedClasses().clear();
				getOwnedClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case 10:
				getOwnedInstances().clear();
				getOwnedInstances().addAll((Collection<? extends InstanceSpecification>)newValue);
				return;
			case 11:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case 12:
				getOwnedProfileApplications().clear();
				getOwnedProfileApplications().addAll((Collection<? extends ProfileApplication>)newValue);
				return;
			case 13:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
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
	public void eUnset(int featureID) {
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
				setURI(URI_EDEFAULT);
				return;
			case 7:
				getImportedPackages().clear();
				return;
			case 8:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case 9:
				getOwnedClasses().clear();
				return;
			case 10:
				getOwnedInstances().clear();
				return;
			case 11:
				getOwnedPackages().clear();
				return;
			case 12:
				getOwnedProfileApplications().clear();
				return;
			case 13:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
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
	public boolean eIsSet(int featureID) {
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
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case 7:
				return importedPackages != null && !importedPackages.isEmpty();
			case 8:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case 9:
				return ownedClasses != null && !ownedClasses.isEmpty();
			case 10:
				return ownedInstances != null && !ownedInstances.isEmpty();
			case 11:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case 12:
				return ownedProfileApplications != null && !ownedProfileApplications.isEmpty();
			case 13:
				return getOwningPackage() != null;
		}
		return eDynamicIsSet(featureID);
	}

	private PackageId packageId = null;
	private @Nullable PackageListeners<PackageListeners.IPackageListener> packageListeners = null;
	private boolean ignoreInvariants = false;		// FIXME Model this (used to suppress bad OMG UML 2.5 invariants)

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPackage(this);
	}

	public synchronized void addPackageListener(PackageListeners.@NonNull IPackageListener packageListener) {
		PackageListeners<PackageListeners.IPackageListener> packageListeners2 = packageListeners;
		if (packageListeners2 == null) {
			packageListeners2 = packageListeners = new PackageListeners<PackageListeners.IPackageListener>();
		}
		packageListeners2.addListener(packageListener);
	}

	public @Nullable PackageId basicGetPackageId() {
		return packageId;
	}

	protected void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (packageListeners != null) {
			packageListeners.didAddClass(partialClass);
		}
	}

	protected void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (packageListeners != null) {
			packageListeners.didAddPackage(partialPackage);
		}
	}

	protected void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (packageListeners != null) {
			packageListeners.didRemoveClass(partialClass);
		}
	}

	protected void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (packageListeners != null) {
			packageListeners.didRemovePackage(partialPackage);
		}
	}

	@Override
	public @Nullable EPackage getEPackage() {
		EObject eTarget = getESObject();
		return eTarget instanceof EPackage ? (EPackage) eTarget : null;
	}

	@Override

	public org.eclipse.ocl.pivot.@Nullable Class getOwnedClass(String className) {
		return NameUtil.getNameable(getOwnedClasses(), className);
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses()
	{
		EList<Class> ownedClasses2 = ownedClasses;
		if (ownedClasses2 == null)
		{
			ownedClasses2 = ownedClasses = new EObjectContainmentWithInverseEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, PivotPackage.Literals.PACKAGE__OWNED_CLASSES.getFeatureID(), PivotPackage.Literals.CLASS__OWNING_PACKAGE.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didRemove(int index, org.eclipse.ocl.pivot.Class partialClass) {
					assert partialClass != null;
					didRemoveClass(partialClass);
				}

				@Override
				public NotificationChain inverseAdd(org.eclipse.ocl.pivot.Class partialClass, NotificationChain notifications) {
					assert partialClass != null;
					NotificationChain inverseAdd = super.inverseAdd(partialClass, notifications);
					didAddClass(partialClass);
					return inverseAdd;
				}
			};
		}
		return ownedClasses2;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages()
	{
		EList<org.eclipse.ocl.pivot.Package> ownedPackages2 = ownedPackages;
		if (ownedPackages2 == null)
		{
			ownedPackages = ownedPackages2 = new EObjectContainmentWithInverseEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, PivotPackage.Literals.PACKAGE__OWNED_PACKAGES.getFeatureID(), PivotPackage.Literals.PACKAGE__OWNING_PACKAGE.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didRemove(int index, org.eclipse.ocl.pivot.Package partialPackage) {
					assert partialPackage != null;
					didRemovePackage(partialPackage);
				}

				@Override
				public NotificationChain inverseAdd(org.eclipse.ocl.pivot.Package partialPackage, NotificationChain notifications) {
					assert partialPackage != null;
					NotificationChain inverseAdd = super.inverseAdd(partialPackage, notifications);
					didAddPackage(partialPackage);
					return inverseAdd;
				}
			};
		}
		return ownedPackages2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ProfileApplication> getOwnedProfileApplications()
	{
		if (ownedProfileApplications == null)
		{
			ownedProfileApplications = new EObjectContainmentWithInverseEList<ProfileApplication>(ProfileApplication.class, this, 12, 6);
		}
		return ownedProfileApplications;
	}

	@Override
	public @NonNull PackageId getPackageId() {
		PackageId packageId2 = packageId;
		if (packageId2 == null) {
			packageId = packageId2 = IdManager.getPackageId(this);
		}
		return packageId2;
	}

	public boolean isIgnoreInvariants() {
		return ignoreInvariants;
	}

	public synchronized void removePackageListener(PackageListeners.@NonNull IPackageListener packageListener) {
		PackageListeners<PackageListeners.IPackageListener> packageListeners2 = packageListeners;
		if ((packageListeners2 != null) && packageListeners2.removeListener(packageListener)) {
			packageListeners = null;
		}
	}

	public void setIgnoreInvariants(boolean ignoreInvariants) {
		this.ignoreInvariants = ignoreInvariants;
	}

	@Override
	public void setName(String newName) {
		String oldName = name;
		EObject eContainer = eContainer();
		if ((oldName != null) && !oldName.equals(newName)) {
			if (eContainer instanceof ModelImpl) {
				((ModelImpl)eContainer).didRemovePackage(this);
			}
			else if (eContainer instanceof PackageImpl) {
				((PackageImpl)eContainer).didRemovePackage(this);
			}
		}
		super.setName(newName);
		if ((newName != null) && !newName.equals(oldName)) {
			if (eContainer instanceof ModelImpl) {
				((ModelImpl)eContainer).didAddPackage(this);
			}
			else if (eContainer instanceof PackageImpl) {
				((PackageImpl)eContainer).didAddPackage(this);
			}
		}
	}

	public void setPackageId(@NonNull PackageId packageId) {
		this.packageId = packageId;
	}

	@Override
	public void setURI(String newURI) {
		String oldURI = uri;
		EObject eContainer = eContainer();
		if ((oldURI != null) && !oldURI.equals(newURI)) {
			if (eContainer instanceof ModelImpl) {
				((ModelImpl)eContainer).didRemovePackage(this);
			}
			else if (eContainer instanceof PackageImpl) {
				((PackageImpl)eContainer).didRemovePackage(this);
			}
		}
		setURIGen(newURI);
		if ((packageId == null) && (newURI != null)) {
			setPackageId(IdManager.getPackageId(this));
		}
		if ((newURI != null) && !newURI.equals(oldURI)) {
			if (eContainer instanceof ModelImpl) {
				((ModelImpl)eContainer).didAddPackage(this);
			}
			else if (eContainer instanceof PackageImpl) {
				((PackageImpl)eContainer).didAddPackage(this);
			}
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //PackageImpl
