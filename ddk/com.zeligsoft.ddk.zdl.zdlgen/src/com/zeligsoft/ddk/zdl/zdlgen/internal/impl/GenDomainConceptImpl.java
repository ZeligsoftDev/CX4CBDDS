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

import com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedSubsetEObjectEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenu;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalettable;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainConceptOperations;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Gen Domain Concept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getMenu <em>Menu</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getFeatures <em>Feature</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getDomainConcept <em>Domain Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getUmlMetaclasses <em>Uml Metaclass</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getReferences <em>Reference</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getAttributes <em>Attribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#isRSMSuppressed <em>Is RSM Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyMetaclass <em>Rhapsody Metaclass</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyStereotypeName <em>Rhapsody Stereotype Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyAddNews <em>Rhapsody Add New</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyAddNewConcepts <em>Rhapsody Add New Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyDisplayName <em>Rhapsody Display Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getRhapsodyToAddNews <em>Rhapsody To Add New</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getOverrides <em>Override</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainConceptImpl#getGeneralizations <em>Generalization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainConceptImpl extends GenDomainClassifierImpl implements GenDomainConcept {

	/**
	 * The cached value of the '{@link #getMenu() <em>Menu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenu()
	 * @generated
	 * @ordered
	 */
	protected GenMenu menu;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Feature</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainStructuralFeature> features;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final GenDomainConceptCategory CATEGORY_EDEFAULT = GenDomainConceptCategory.ABSTRACT;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected GenDomainConceptCategory category = CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomainConcept() <em>Domain Concept</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDomainConcept()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class domainConcept;

	/**
	 * The cached value of the '{@link #getUmlMetaclasses() <em>Uml Metaclass</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMetaclasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.uml2.uml.Class> umlMetaclasses;

	/**
	 * The default value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected String iconUri = ICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isRSMSuppressed() <em>Is RSM Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMSuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RSM_SUPPRESSED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRSMSuppressed() <em>Is RSM Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMSuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSM_SUPPRESSED_EFLAG = 1 << 8;

	/**
	 * The flag representing whether the Is RSM Suppressed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSM_SUPPRESSED_ESETFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isRSMUIReadOnly() <em>Is RSMUI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RSMUI_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRSMUIReadOnly() <em>Is RSMUI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSMUI_READ_ONLY_EFLAG = 1 << 10;

	/**
	 * The flag representing whether the Is RSMUI Read Only attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSMUI_READ_ONLY_ESETFLAG = 1 << 11;

	/**
	 * The default value of the '{@link #isRSMPropertiesUIReadOnly() <em>Is RSM Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMPropertiesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RSM_PROPERTIES_UI_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRSMPropertiesUIReadOnly() <em>Is RSM Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRSMPropertiesUIReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG = 1 << 12;

	/**
	 * The flag representing whether the Is RSM Properties UI Read Only attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG = 1 << 13;

	/**
	 * The default value of the '{@link #isRhapsodySuppressed() <em>Is Rhapsody Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRhapsodySuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RHAPSODY_SUPPRESSED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRhapsodySuppressed() <em>Is Rhapsody Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRhapsodySuppressed()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RHAPSODY_SUPPRESSED_EFLAG = 1 << 14;

	/**
	 * The default value of the '{@link #getRhapsodyMetaclass() <em>Rhapsody Metaclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyMetaclass()
	 * @generated
	 * @ordered
	 */
	protected static final String RHAPSODY_METACLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRhapsodyMetaclass() <em>Rhapsody Metaclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyMetaclass()
	 * @generated
	 * @ordered
	 */
	protected String rhapsodyMetaclass = RHAPSODY_METACLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRhapsodyStereotypeName() <em>Rhapsody Stereotype Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyStereotypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String RHAPSODY_STEREOTYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRhapsodyStereotypeName() <em>Rhapsody Stereotype Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyStereotypeName()
	 * @generated
	 * @ordered
	 */
	protected String rhapsodyStereotypeName = RHAPSODY_STEREOTYPE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRhapsodyAddNews() <em>Rhapsody Add New</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyAddNews()
	 * @generated
	 * @ordered
	 */
	protected EList<String> rhapsodyAddNews;

	/**
	 * The cached value of the '{@link #getRhapsodyAddNewConcepts() <em>Rhapsody Add New Concept</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyAddNewConcepts()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainConcept> rhapsodyAddNewConcepts;

	/**
	 * The default value of the '{@link #getRhapsodyDisplayName() <em>Rhapsody Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String RHAPSODY_DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRhapsodyDisplayName() <em>Rhapsody Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String rhapsodyDisplayName = RHAPSODY_DISPLAY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRhapsodyToAddNews() <em>Rhapsody To Add New</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyToAddNews()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainConcept> rhapsodyToAddNews;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Override</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected EList<GenAttributeOverride> overrides;

	/**
	 * The cached value of the '{@link #getGeneralizations() <em>Generalization</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainGeneralization> generalizations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainConceptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
								ZDLGenPackage.GEN_DOMAIN_CONCEPT__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_DOMAIN_CONCEPT__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE,
			ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement basicGetDomainElement() {
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT)) {
			return basicGetDomainConcept();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConceptCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(GenDomainConceptCategory newCategory) {
		GenDomainConceptCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY,
					oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainStructuralFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<GenDomainStructuralFeature>(
					GenDomainStructuralFeature.class, this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainStructuralFeature getFeature(String name) {
		return getFeature(name, false, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainStructuralFeature getFeature(String name, boolean ignoreCase, EClass eClass) {
		featureLoop: for (GenDomainStructuralFeature feature : getFeatures()) {
			if (eClass != null && !eClass.isInstance(feature))
				continue featureLoop;
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(feature.getName()) : name.equals(feature.getName())))
				continue featureLoop;
			return feature;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainGeneralization> getGeneralizations() {
		if (generalizations == null) {
			generalizations = new EObjectContainmentWithInverseEList<GenDomainGeneralization>(
					GenDomainGeneralization.class, this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION,
					ZDLGenPackage.GEN_DOMAIN_GENERALIZATION__SPECIFIC);
		}
		return generalizations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getDomainConcept() {
		if (domainConcept != null && domainConcept.eIsProxy()) {
			InternalEObject oldDomainConcept = (InternalEObject) domainConcept;
			domainConcept = (org.eclipse.uml2.uml.Class) eResolveProxy(oldDomainConcept);
			if (domainConcept != oldDomainConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT, oldDomainConcept, domainConcept));
			}
		}
		return domainConcept;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetDomainConcept() {
		return domainConcept;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainConcept(org.eclipse.uml2.uml.Class newDomainConcept) {
		org.eclipse.uml2.uml.Class oldDomainConcept = domainConcept;
		domainConcept = newDomainConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT,
					oldDomainConcept, domainConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.uml2.uml.Class> getUmlMetaclasses() {
		if (umlMetaclasses == null) {
			umlMetaclasses = new EObjectResolvingEList<org.eclipse.uml2.uml.Class>(org.eclipse.uml2.uml.Class.class,
					this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__UML_METACLASS);
		}
		return umlMetaclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getUmlMetaclass(String name) {
		return getUmlMetaclass(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getUmlMetaclass(String name, boolean ignoreCase, EClass eClass) {
		umlMetaclassLoop: for (org.eclipse.uml2.uml.Class umlMetaclass : getUmlMetaclasses()) {
			if (eClass != null && !eClass.isInstance(umlMetaclass))
				continue umlMetaclassLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(umlMetaclass.getName())
					: name.equals(umlMetaclass.getName())))
				continue umlMetaclassLoop;
			return umlMetaclass;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainConcept> getGenerals() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<GenDomainConcept> result = (EList<GenDomainConcept>) cache.get(this,
					ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__GENERAL);
			if (result == null) {
				cache.put(this, ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__GENERAL,
						result = GenDomainConceptOperations.getGenerals(this));
			}
			return result;
		}
		return GenDomainConceptOperations.getGenerals(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getGeneral(String name) {
		return getGeneral(name, false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getGeneral(String name, boolean ignoreCase) {
		generalLoop: for (GenDomainConcept general : getGenerals()) {
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(general.getName()) : name.equals(general.getName())))
				continue generalLoop;
			return general;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<GenDomainReference> getReferences() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainReference> result = (EList<GenDomainReference>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__REFERENCE);
			if (result == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__REFERENCE,
						result = new DerivedSubsetEObjectEList<GenDomainReference>(GenDomainReference.class, this,
								ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE, REFERENCE_ESUPERSETS));
			}
			return result;
		}
		return new DerivedSubsetEObjectEList<GenDomainReference>(GenDomainReference.class, this,
				ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE, REFERENCE_ESUPERSETS);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getReferences() <em>Reference</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected static final int[] REFERENCE_ESUPERSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainReference getReference(String name) {
		return getReference(name, false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainReference getReference(String name, boolean ignoreCase) {
		referenceLoop: for (GenDomainReference reference : getReferences()) {
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(reference.getName()) : name.equals(reference.getName())))
				continue referenceLoop;
			return reference;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<GenDomainAttribute> getAttributes() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainAttribute> result = (EList<GenDomainAttribute>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__ATTRIBUTE);
			if (result == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__ATTRIBUTE,
						result = new DerivedSubsetEObjectEList<GenDomainAttribute>(GenDomainAttribute.class, this,
								ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE, ATTRIBUTE_ESUPERSETS));
			}
			return result;
		}
		return new DerivedSubsetEObjectEList<GenDomainAttribute>(GenDomainAttribute.class, this,
				ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE, ATTRIBUTE_ESUPERSETS);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getAttributes() <em>Attribute</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final int[] ATTRIBUTE_ESUPERSETS = new int[] { ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainAttribute getAttribute(String name) {
		return getAttribute(name, false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainAttribute getAttribute(String name, boolean ignoreCase) {
		attributeLoop: for (GenDomainAttribute attribute : getAttributes()) {
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(attribute.getName()) : name.equals(attribute.getName())))
				continue attributeLoop;
			return attribute;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconUri() {
		return iconUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconUri(String newIconUri) {
		String oldIconUri = iconUri;
		iconUri = newIconUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI,
					oldIconUri, iconUri));
	}

	@Override
	public boolean isRSMSuppressed() {
		if (!isSetIsRSMSuppressed() && (getBlock() != null)) {
			// inherit default from block
			return getBlock().isRsmStereotypesSuppressed();
		}

		return isRSMSuppressedGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRSMSuppressedGen() {
		return (eFlags & IS_RSM_SUPPRESSED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRSMSuppressed(boolean newIsRSMSuppressed) {
		boolean oldIsRSMSuppressed = (eFlags & IS_RSM_SUPPRESSED_EFLAG) != 0;
		if (newIsRSMSuppressed)
			eFlags |= IS_RSM_SUPPRESSED_EFLAG;
		else
			eFlags &= ~IS_RSM_SUPPRESSED_EFLAG;
		boolean oldIsRSMSuppressedESet = (eFlags & IS_RSM_SUPPRESSED_ESETFLAG) != 0;
		eFlags |= IS_RSM_SUPPRESSED_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED,
					oldIsRSMSuppressed, newIsRSMSuppressed, !oldIsRSMSuppressedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRSMSuppressed() {
		boolean oldIsRSMSuppressed = (eFlags & IS_RSM_SUPPRESSED_EFLAG) != 0;
		boolean oldIsRSMSuppressedESet = (eFlags & IS_RSM_SUPPRESSED_ESETFLAG) != 0;
		if (IS_RSM_SUPPRESSED_EDEFAULT)
			eFlags |= IS_RSM_SUPPRESSED_EFLAG;
		else
			eFlags &= ~IS_RSM_SUPPRESSED_EFLAG;
		eFlags &= ~IS_RSM_SUPPRESSED_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED,
					oldIsRSMSuppressed, IS_RSM_SUPPRESSED_EDEFAULT, oldIsRSMSuppressedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRSMSuppressed() {
		return (eFlags & IS_RSM_SUPPRESSED_ESETFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isRSMUIReadOnly() {
		if (!isSetIsRSMUIReadOnly() && (getBlock() != null)) {
			// inherit default from block
			return getBlock().isRsmStereotypesUIReadOnly();
		}

		return isRSMUIReadOnlyGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRSMUIReadOnlyGen() {
		return (eFlags & IS_RSMUI_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRSMUIReadOnly(boolean newIsRSMUIReadOnly) {
		boolean oldIsRSMUIReadOnly = (eFlags & IS_RSMUI_READ_ONLY_EFLAG) != 0;
		if (newIsRSMUIReadOnly)
			eFlags |= IS_RSMUI_READ_ONLY_EFLAG;
		else
			eFlags &= ~IS_RSMUI_READ_ONLY_EFLAG;
		boolean oldIsRSMUIReadOnlyESet = (eFlags & IS_RSMUI_READ_ONLY_ESETFLAG) != 0;
		eFlags |= IS_RSMUI_READ_ONLY_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY,
					oldIsRSMUIReadOnly, newIsRSMUIReadOnly, !oldIsRSMUIReadOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRSMUIReadOnly() {
		boolean oldIsRSMUIReadOnly = (eFlags & IS_RSMUI_READ_ONLY_EFLAG) != 0;
		boolean oldIsRSMUIReadOnlyESet = (eFlags & IS_RSMUI_READ_ONLY_ESETFLAG) != 0;
		if (IS_RSMUI_READ_ONLY_EDEFAULT)
			eFlags |= IS_RSMUI_READ_ONLY_EFLAG;
		else
			eFlags &= ~IS_RSMUI_READ_ONLY_EFLAG;
		eFlags &= ~IS_RSMUI_READ_ONLY_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY, oldIsRSMUIReadOnly,
					IS_RSMUI_READ_ONLY_EDEFAULT, oldIsRSMUIReadOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRSMUIReadOnly() {
		return (eFlags & IS_RSMUI_READ_ONLY_ESETFLAG) != 0;
	}

	@Override
	public boolean isRSMPropertiesUIReadOnly() {
		if (!isSetIsRSMPropertiesUIReadOnly() && (getBlock() != null)) {
			// inherit default from block
			return getBlock().isRsmStereotypesPropertiesUIReadOnly();
		}

		return isRSMPropertiesUIReadOnlyGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRSMPropertiesUIReadOnlyGen() {
		return (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRSMPropertiesUIReadOnly(boolean newIsRSMPropertiesUIReadOnly) {
		boolean oldIsRSMPropertiesUIReadOnly = (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG) != 0;
		if (newIsRSMPropertiesUIReadOnly)
			eFlags |= IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG;
		else
			eFlags &= ~IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG;
		boolean oldIsRSMPropertiesUIReadOnlyESet = (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG) != 0;
		eFlags |= IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY, oldIsRSMPropertiesUIReadOnly,
					newIsRSMPropertiesUIReadOnly, !oldIsRSMPropertiesUIReadOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRSMPropertiesUIReadOnly() {
		boolean oldIsRSMPropertiesUIReadOnly = (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG) != 0;
		boolean oldIsRSMPropertiesUIReadOnlyESet = (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG) != 0;
		if (IS_RSM_PROPERTIES_UI_READ_ONLY_EDEFAULT)
			eFlags |= IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG;
		else
			eFlags &= ~IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG;
		eFlags &= ~IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY, oldIsRSMPropertiesUIReadOnly,
					IS_RSM_PROPERTIES_UI_READ_ONLY_EDEFAULT, oldIsRSMPropertiesUIReadOnlyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRSMPropertiesUIReadOnly() {
		return (eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRhapsodySuppressed() {
		return (eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRhapsodySuppressed(boolean newIsRhapsodySuppressed) {
		boolean oldIsRhapsodySuppressed = (eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0;
		if (newIsRhapsodySuppressed)
			eFlags |= IS_RHAPSODY_SUPPRESSED_EFLAG;
		else
			eFlags &= ~IS_RHAPSODY_SUPPRESSED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED, oldIsRhapsodySuppressed,
					newIsRhapsodySuppressed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRhapsodyMetaclass() {
		return rhapsodyMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyMetaclass(String newRhapsodyMetaclass) {
		String oldRhapsodyMetaclass = rhapsodyMetaclass;
		rhapsodyMetaclass = newRhapsodyMetaclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS,
					oldRhapsodyMetaclass, rhapsodyMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRhapsodyStereotypeName() {
		return rhapsodyStereotypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyStereotypeName(String newRhapsodyStereotypeName) {
		String oldRhapsodyStereotypeName = rhapsodyStereotypeName;
		rhapsodyStereotypeName = newRhapsodyStereotypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME, oldRhapsodyStereotypeName,
					rhapsodyStereotypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRhapsodyAddNews() {
		if (rhapsodyAddNews == null) {
			rhapsodyAddNews = new EDataTypeUniqueEList<String>(String.class, this,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW);
		}
		return rhapsodyAddNews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenDomainConcept> getRhapsodyAddNewConcepts() {
		if (rhapsodyAddNewConcepts == null) {
			rhapsodyAddNewConcepts = new EObjectResolvingEList<GenDomainConcept>(GenDomainConcept.class, this,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT);
		}
		return rhapsodyAddNewConcepts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept getRhapsodyAddNewConcept(String name) {
		return getRhapsodyAddNewConcept(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept getRhapsodyAddNewConcept(String name, boolean ignoreCase) {
		rhapsodyAddNewConceptLoop: for (GenDomainConcept rhapsodyAddNewConcept : getRhapsodyAddNewConcepts()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(rhapsodyAddNewConcept.getName())
					: name.equals(rhapsodyAddNewConcept.getName())))
				continue rhapsodyAddNewConceptLoop;
			return rhapsodyAddNewConcept;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRhapsodyDisplayName() {
		return rhapsodyDisplayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyDisplayName(String newRhapsodyDisplayName) {
		String oldRhapsodyDisplayName = rhapsodyDisplayName;
		rhapsodyDisplayName = newRhapsodyDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME, oldRhapsodyDisplayName,
					rhapsodyDisplayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenDomainConcept> getRhapsodyToAddNews() {
		if (rhapsodyToAddNews == null) {
			rhapsodyToAddNews = new EObjectResolvingEList<GenDomainConcept>(GenDomainConcept.class, this,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW);
		}
		return rhapsodyToAddNews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept getRhapsodyToAddNew(String name) {
		return getRhapsodyToAddNew(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept getRhapsodyToAddNew(String name, boolean ignoreCase) {
		rhapsodyToAddNewLoop: for (GenDomainConcept rhapsodyToAddNew : getRhapsodyToAddNews()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(rhapsodyToAddNew.getName())
					: name.equals(rhapsodyToAddNew.getName())))
				continue rhapsodyToAddNewLoop;
			return rhapsodyToAddNew;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenAttributeOverride> getOverrides() {
		if (overrides == null) {
			overrides = new EObjectContainmentEList<GenAttributeOverride>(GenAttributeOverride.class, this,
					ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE);
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenu getMenu() {
		if (menu != null && menu.eIsProxy()) {
			InternalEObject oldMenu = (InternalEObject) menu;
			menu = (GenMenu) eResolveProxy(oldMenu);
			if (menu != oldMenu) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU,
							oldMenu, menu));
			}
		}
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenMenu basicGetMenu() {
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMenu(GenMenu newMenu) {
		GenMenu oldMenu = menu;
		menu = newMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU, oldMenu,
					menu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainConcept> allGenerals() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<GenDomainConcept> result = (EList<GenDomainConcept>) cache.get(this,
					ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT.getEOperations().get(0));
			if (result == null) {
				cache.put(this, ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT.getEOperations().get(0),
						result = GenDomainConceptOperations.allGenerals(this));
			}
			return result;
		}
		return GenDomainConceptOperations.allGenerals(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainConcept> allSpecifics() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<GenDomainConcept> result = (EList<GenDomainConcept>) cache.get(this,
					ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT.getEOperations().get(1));
			if (result == null) {
				cache.put(this, ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT.getEOperations().get(1),
						result = GenDomainConceptOperations.allSpecifics(this));
			}
			return result;
		}
		return GenDomainConceptOperations.allSpecifics(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFeatures()).basicAdd(otherEnd, msgs);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGeneralizations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			return ((InternalEList<?>) getOverrides()).basicRemove(otherEnd, msgs);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			return ((InternalEList<?>) getGeneralizations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU:
			if (resolve)
				return getMenu();
			return basicGetMenu();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			return getFeatures();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY:
			return getCategory();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT:
			if (resolve)
				return getDomainConcept();
			return basicGetDomainConcept();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__UML_METACLASS:
			return getUmlMetaclasses();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERAL:
			return getGenerals();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE:
			return getReferences();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE:
			return getAttributes();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI:
			return getIconUri();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED:
			return isRSMSuppressed();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY:
			return isRSMUIReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY:
			return isRSMPropertiesUIReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED:
			return isRhapsodySuppressed();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS:
			return getRhapsodyMetaclass();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME:
			return getRhapsodyStereotypeName();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW:
			return getRhapsodyAddNews();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT:
			return getRhapsodyAddNewConcepts();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME:
			return getRhapsodyDisplayName();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW:
			return getRhapsodyToAddNews();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			return getOverrides();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			return getGeneralizations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU:
			setMenu((GenMenu) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends GenDomainStructuralFeature>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY:
			setCategory((GenDomainConceptCategory) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT:
			setDomainConcept((org.eclipse.uml2.uml.Class) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__UML_METACLASS:
			getUmlMetaclasses().clear();
			getUmlMetaclasses().addAll((Collection<? extends org.eclipse.uml2.uml.Class>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI:
			setIconUri((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED:
			setIsRSMSuppressed((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY:
			setIsRSMUIReadOnly((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY:
			setIsRSMPropertiesUIReadOnly((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED:
			setIsRhapsodySuppressed((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS:
			setRhapsodyMetaclass((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME:
			setRhapsodyStereotypeName((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW:
			getRhapsodyAddNews().clear();
			getRhapsodyAddNews().addAll((Collection<? extends String>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT:
			getRhapsodyAddNewConcepts().clear();
			getRhapsodyAddNewConcepts().addAll((Collection<? extends GenDomainConcept>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME:
			setRhapsodyDisplayName((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW:
			getRhapsodyToAddNews().clear();
			getRhapsodyToAddNews().addAll((Collection<? extends GenDomainConcept>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			getOverrides().clear();
			getOverrides().addAll((Collection<? extends GenAttributeOverride>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			getGeneralizations().clear();
			getGeneralizations().addAll((Collection<? extends GenDomainGeneralization>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU:
			setMenu((GenMenu) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			getFeatures().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT:
			setDomainConcept((org.eclipse.uml2.uml.Class) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__UML_METACLASS:
			getUmlMetaclasses().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI:
			setIconUri(ICON_URI_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED:
			unsetIsRSMSuppressed();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY:
			unsetIsRSMUIReadOnly();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY:
			unsetIsRSMPropertiesUIReadOnly();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED:
			setIsRhapsodySuppressed(IS_RHAPSODY_SUPPRESSED_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS:
			setRhapsodyMetaclass(RHAPSODY_METACLASS_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME:
			setRhapsodyStereotypeName(RHAPSODY_STEREOTYPE_NAME_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW:
			getRhapsodyAddNews().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT:
			getRhapsodyAddNewConcepts().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME:
			setRhapsodyDisplayName(RHAPSODY_DISPLAY_NAME_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW:
			getRhapsodyToAddNews().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			getOverrides().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			getGeneralizations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU:
			return menu != null;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE:
			return features != null && !features.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT:
			return domainConcept != null;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__UML_METACLASS:
			return umlMetaclasses != null && !umlMetaclasses.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERAL:
			return !getGenerals().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__REFERENCE:
			return !getReferences().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ATTRIBUTE:
			return !getAttributes().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__ICON_URI:
			return ICON_URI_EDEFAULT == null ? iconUri != null : !ICON_URI_EDEFAULT.equals(iconUri);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_SUPPRESSED:
			return isSetIsRSMSuppressed();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSMUI_READ_ONLY:
			return isSetIsRSMUIReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RSM_PROPERTIES_UI_READ_ONLY:
			return isSetIsRSMPropertiesUIReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__IS_RHAPSODY_SUPPRESSED:
			return ((eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0) != IS_RHAPSODY_SUPPRESSED_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_METACLASS:
			return RHAPSODY_METACLASS_EDEFAULT == null ? rhapsodyMetaclass != null
					: !RHAPSODY_METACLASS_EDEFAULT.equals(rhapsodyMetaclass);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_STEREOTYPE_NAME:
			return RHAPSODY_STEREOTYPE_NAME_EDEFAULT == null ? rhapsodyStereotypeName != null
					: !RHAPSODY_STEREOTYPE_NAME_EDEFAULT.equals(rhapsodyStereotypeName);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW:
			return rhapsodyAddNews != null && !rhapsodyAddNews.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_ADD_NEW_CONCEPT:
			return rhapsodyAddNewConcepts != null && !rhapsodyAddNewConcepts.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_DISPLAY_NAME:
			return RHAPSODY_DISPLAY_NAME_EDEFAULT == null ? rhapsodyDisplayName != null
					: !RHAPSODY_DISPLAY_NAME_EDEFAULT.equals(rhapsodyDisplayName);
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__RHAPSODY_TO_ADD_NEW:
			return rhapsodyToAddNews != null && !rhapsodyToAddNews.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__OVERRIDE:
			return overrides != null && !overrides.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION:
			return generalizations != null && !generalizations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == GenMenuTarget.class) {
			switch (derivedFeatureID) {
			case ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU:
				return ZDLGenPackage.GEN_MENU_TARGET__MENU;
			default:
				return -1;
			}
		}
		if (baseClass == GenPalettable.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GenMenuTarget.class) {
			switch (baseFeatureID) {
			case ZDLGenPackage.GEN_MENU_TARGET__MENU:
				return ZDLGenPackage.GEN_DOMAIN_CONCEPT__MENU;
			default:
				return -1;
			}
		}
		if (baseClass == GenPalettable.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", iconUri: "); //$NON-NLS-1$
		result.append(iconUri);
		result.append(", isRSMSuppressed: "); //$NON-NLS-1$
		if ((eFlags & IS_RSM_SUPPRESSED_ESETFLAG) != 0)
			result.append((eFlags & IS_RSM_SUPPRESSED_EFLAG) != 0);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", isRSMUIReadOnly: "); //$NON-NLS-1$
		if ((eFlags & IS_RSMUI_READ_ONLY_ESETFLAG) != 0)
			result.append((eFlags & IS_RSMUI_READ_ONLY_EFLAG) != 0);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", isRSMPropertiesUIReadOnly: "); //$NON-NLS-1$
		if ((eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_ESETFLAG) != 0)
			result.append((eFlags & IS_RSM_PROPERTIES_UI_READ_ONLY_EFLAG) != 0);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", isRhapsodySuppressed: "); //$NON-NLS-1$
		result.append((eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0);
		result.append(", rhapsodyMetaclass: "); //$NON-NLS-1$
		result.append(rhapsodyMetaclass);
		result.append(", rhapsodyStereotypeName: "); //$NON-NLS-1$
		result.append(rhapsodyStereotypeName);
		result.append(", rhapsodyAddNew: "); //$NON-NLS-1$
		result.append(rhapsodyAddNews);
		result.append(", rhapsodyDisplayName: "); //$NON-NLS-1$
		result.append(rhapsodyDisplayName);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE)
				|| eIsSet(ZDLGenPackage.GEN_DOMAIN_CONCEPT__GENERALIZATION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_CONCEPT__DOMAIN_CONCEPT);
	}

} // GenDomainConceptImpl
