/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedSubsetEObjectEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainBlockOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getRelations <em>Relation</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getClassifiers <em>Classifier</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getDomainBlock <em>Domain Block</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getImports <em>Import</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#getMerges <em>Merge</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#isRsmStereotypesSuppressed <em>Rsm Stereotypes Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#isRsmStereotypesUIReadOnly <em>Rsm Stereotypes UI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainBlockImpl#isRsmStereotypesPropertiesUIReadOnly <em>Rsm Stereotypes Properties UI Read Only</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainBlockImpl extends GenDomainPackageableElementImpl implements GenDomainBlock {

	/**
	 * The cached value of the '{@link #getRelations() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainBlockRelation> relations;

	/**
	 * The cached value of the '{@link #getClassifiers() <em>Classifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainClassifier> classifiers;

	/**
	 * The cached value of the '{@link #getDomainBlock() <em>Domain Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBlock()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package domainBlock;

	/**
	 * The default value of the '{@link #isRsmStereotypesSuppressed() <em>Rsm Stereotypes Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesSuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RSM_STEREOTYPES_SUPPRESSED_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isRsmStereotypesSuppressed() <em>Rsm Stereotypes Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesSuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final int RSM_STEREOTYPES_SUPPRESSED_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isRsmStereotypesUIReadOnly() <em>Rsm Stereotypes UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RSM_STEREOTYPES_UI_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRsmStereotypesUIReadOnly() <em>Rsm Stereotypes UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int RSM_STEREOTYPES_UI_READ_ONLY_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isRsmStereotypesPropertiesUIReadOnly() <em>Rsm Stereotypes Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesPropertiesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRsmStereotypesPropertiesUIReadOnly() <em>Rsm Stereotypes Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRsmStereotypesPropertiesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG = 1 << 10;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainBlockImpl() {
		super();
		eFlags |= RSM_STEREOTYPES_SUPPRESSED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainObject> getOwnedObjects() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainObject> ownedObjects = (EList<GenDomainObject>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			if (ownedObjects == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT,
						ownedObjects = new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
								ZDLGenPackage.GEN_DOMAIN_BLOCK__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_DOMAIN_BLOCK__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER,
			ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getDomainElement() {
		NamedElement domainElement = basicGetDomainElement();
		return domainElement != null && domainElement.eIsProxy()
				? (NamedElement) eResolveProxy((InternalEObject) domainElement)
				: domainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement basicGetDomainElement() {
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK)) {
			return basicGetDomainBlock();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainClassifier> getClassifiers() {
		if (classifiers == null) {
			classifiers = new EObjectContainmentEList<GenDomainClassifier>(GenDomainClassifier.class, this,
					ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER);
		}
		return classifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainClassifier getClassifier(String name) {
		return getClassifier(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainClassifier getClassifier(String name, boolean ignoreCase, EClass eClass) {
		classifierLoop: for (GenDomainClassifier classifier : getClassifiers()) {
			if (eClass != null && !eClass.isInstance(classifier))
				continue classifierLoop;
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(classifier.getName()) : name.equals(classifier.getName())))
				continue classifierLoop;
			return classifier;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainBlockRelation> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList<GenDomainBlockRelation>(GenDomainBlockRelation.class, this,
					ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package getDomainBlock() {
		if (domainBlock != null && domainBlock.eIsProxy()) {
			InternalEObject oldDomainBlock = (InternalEObject) domainBlock;
			domainBlock = (org.eclipse.uml2.uml.Package) eResolveProxy(oldDomainBlock);
			if (domainBlock != oldDomainBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK, oldDomainBlock, domainBlock));
			}
		}
		return domainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetDomainBlock() {
		return domainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainBlock(org.eclipse.uml2.uml.Package newDomainBlock) {
		org.eclipse.uml2.uml.Package oldDomainBlock = domainBlock;
		domainBlock = newDomainBlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK,
					oldDomainBlock, domainBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<GenDomainBlockImport> getImports() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainBlockImport> result = (EList<GenDomainBlockImport>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__IMPORT);
			if (result == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__IMPORT,
						result = new DerivedSubsetEObjectEList<GenDomainBlockImport>(GenDomainBlockImport.class, this,
								ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT, IMPORT_ESUPERSETS));
			}
			return result;
		}
		return new DerivedSubsetEObjectEList<GenDomainBlockImport>(GenDomainBlockImport.class, this,
				ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT, IMPORT_ESUPERSETS);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getImports() <em>Import</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected static final int[] IMPORT_ESUPERSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<GenDomainBlockMerge> getMerges() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainBlockMerge> result = (EList<GenDomainBlockMerge>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__MERGE);
			if (result == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_BLOCK__MERGE,
						result = new DerivedSubsetEObjectEList<GenDomainBlockMerge>(GenDomainBlockMerge.class, this,
								ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE, MERGE_ESUPERSETS));
			}
			return result;
		}
		return new DerivedSubsetEObjectEList<GenDomainBlockMerge>(GenDomainBlockMerge.class, this,
				ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE, MERGE_ESUPERSETS);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getMerges() <em>Merge</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMerges()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MERGE_ESUPERSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRsmStereotypesSuppressed() {
		return (eFlags & RSM_STEREOTYPES_SUPPRESSED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRsmStereotypesSuppressed(boolean newRsmStereotypesSuppressed) {
		boolean oldRsmStereotypesSuppressed = (eFlags & RSM_STEREOTYPES_SUPPRESSED_EFLAG) != 0;
		if (newRsmStereotypesSuppressed)
			eFlags |= RSM_STEREOTYPES_SUPPRESSED_EFLAG;
		else
			eFlags &= ~RSM_STEREOTYPES_SUPPRESSED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED, oldRsmStereotypesSuppressed,
					newRsmStereotypesSuppressed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRsmStereotypesUIReadOnly() {
		return (eFlags & RSM_STEREOTYPES_UI_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRsmStereotypesUIReadOnly(boolean newRsmStereotypesUIReadOnly) {
		boolean oldRsmStereotypesUIReadOnly = (eFlags & RSM_STEREOTYPES_UI_READ_ONLY_EFLAG) != 0;
		if (newRsmStereotypesUIReadOnly)
			eFlags |= RSM_STEREOTYPES_UI_READ_ONLY_EFLAG;
		else
			eFlags &= ~RSM_STEREOTYPES_UI_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY, oldRsmStereotypesUIReadOnly,
					newRsmStereotypesUIReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRsmStereotypesPropertiesUIReadOnly() {
		return (eFlags & RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRsmStereotypesPropertiesUIReadOnly(boolean newRsmStereotypesPropertiesUIReadOnly) {
		boolean oldRsmStereotypesPropertiesUIReadOnly = (eFlags & RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG) != 0;
		if (newRsmStereotypesPropertiesUIReadOnly)
			eFlags |= RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG;
		else
			eFlags &= ~RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY,
					oldRsmStereotypesPropertiesUIReadOnly, newRsmStereotypesPropertiesUIReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainClassifier> allClassifiers(GenAllDomainCassifiersMode mode) {
		return GenDomainBlockOperations.allClassifiers(this, mode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			return ((InternalEList<?>) getRelations()).basicRemove(otherEnd, msgs);
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			return ((InternalEList<?>) getClassifiers()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			return getRelations();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			return getClassifiers();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK:
			if (resolve)
				return getDomainBlock();
			return basicGetDomainBlock();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT:
			return getImports();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE:
			return getMerges();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED:
			return isRsmStereotypesSuppressed();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY:
			return isRsmStereotypesUIReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY:
			return isRsmStereotypesPropertiesUIReadOnly();
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			getRelations().clear();
			getRelations().addAll((Collection<? extends GenDomainBlockRelation>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			getClassifiers().clear();
			getClassifiers().addAll((Collection<? extends GenDomainClassifier>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK:
			setDomainBlock((org.eclipse.uml2.uml.Package) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED:
			setRsmStereotypesSuppressed((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY:
			setRsmStereotypesUIReadOnly((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY:
			setRsmStereotypesPropertiesUIReadOnly((Boolean) newValue);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			getRelations().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			getClassifiers().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK:
			setDomainBlock((org.eclipse.uml2.uml.Package) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED:
			setRsmStereotypesSuppressed(RSM_STEREOTYPES_SUPPRESSED_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY:
			setRsmStereotypesUIReadOnly(RSM_STEREOTYPES_UI_READ_ONLY_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY:
			setRsmStereotypesPropertiesUIReadOnly(RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EDEFAULT);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION:
			return relations != null && !relations.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER:
			return classifiers != null && !classifiers.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK:
			return domainBlock != null;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__IMPORT:
			return !getImports().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__MERGE:
			return !getMerges().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_SUPPRESSED:
			return ((eFlags & RSM_STEREOTYPES_SUPPRESSED_EFLAG) != 0) != RSM_STEREOTYPES_SUPPRESSED_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_UI_READ_ONLY:
			return ((eFlags & RSM_STEREOTYPES_UI_READ_ONLY_EFLAG) != 0) != RSM_STEREOTYPES_UI_READ_ONLY_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_BLOCK__RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY:
			return ((eFlags
					& RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG) != 0) != RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (rsmStereotypesSuppressed: "); //$NON-NLS-1$
		result.append((eFlags & RSM_STEREOTYPES_SUPPRESSED_EFLAG) != 0);
		result.append(", rsmStereotypesUIReadOnly: "); //$NON-NLS-1$
		result.append((eFlags & RSM_STEREOTYPES_UI_READ_ONLY_EFLAG) != 0);
		result.append(", rsmStereotypesPropertiesUIReadOnly: "); //$NON-NLS-1$
		result.append((eFlags & RSM_STEREOTYPES_PROPERTIES_UI_READ_ONLY_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK__CLASSIFIER)
				|| eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK__RELATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_BLOCK__DOMAIN_BLOCK);
	}

} //GenDomainBlockImpl
