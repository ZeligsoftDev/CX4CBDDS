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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainSpecializationOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Specialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getDomainConcepts <em>Domain Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getPluginName <em>Plugin Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getDomainModelLibraries <em>Domain Model Library</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getModelLibraryNamesPackage <em>Model Library Names Package</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getModelLibrarySourceFolder <em>Model Library Source Folder</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getMenuModelResource <em>Menu Model Resource</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getCodeGenTarget <em>Code Gen Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getRhapsodyJavaProject <em>Rhapsody Java Project</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getRhapsodyJDTJavaLibrary <em>Rhapsody JDT Java Library</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getExcludedPaletteItems <em>Excluded Palette Item</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getIncludedUMLMeni <em>Included UML Menus</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getDomainBlocks <em>Domain Block</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainSpecializationImpl#getElementtypeConfigurationContainerUri <em>Elementtype Configuration Container Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainSpecializationImpl extends GenDomainPackageableElementImpl implements GenDomainSpecialization {

	/**
	 * The cached value of the '{@link #getDomainSpecialization() <em>Domain Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecialization()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class domainSpecialization;

	/**
	 * The default value of the '{@link #getPluginName() <em>Plugin Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginName()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginName() <em>Plugin Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginName()
	 * @generated
	 * @ordered
	 */
	protected String pluginName = PLUGIN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomainModelLibraries() <em>Domain Model Library</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainModelLibraryReference> domainModelLibraries;

	/**
	 * The default value of the '{@link #getModelLibraryNamesPackage() <em>Model Library Names Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelLibraryNamesPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_LIBRARY_NAMES_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelLibraryNamesPackage() <em>Model Library Names Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelLibraryNamesPackage()
	 * @generated
	 * @ordered
	 */
	protected String modelLibraryNamesPackage = MODEL_LIBRARY_NAMES_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelLibrarySourceFolder() <em>Model Library Source Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelLibrarySourceFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_LIBRARY_SOURCE_FOLDER_EDEFAULT = "src"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getModelLibrarySourceFolder() <em>Model Library Source Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelLibrarySourceFolder()
	 * @generated
	 * @ordered
	 */
	protected String modelLibrarySourceFolder = MODEL_LIBRARY_SOURCE_FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMenuModelResource() <em>Menu Model Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenuModelResource()
	 * @generated
	 * @ordered
	 */
	protected static final String MENU_MODEL_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMenuModelResource() <em>Menu Model Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenuModelResource()
	 * @generated
	 * @ordered
	 */
	protected String menuModelResource = MENU_MODEL_RESOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodeGenTarget() <em>Code Gen Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeGenTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_GEN_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodeGenTarget() <em>Code Gen Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeGenTarget()
	 * @generated
	 * @ordered
	 */
	protected String codeGenTarget = CODE_GEN_TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getRhapsodyJavaProject() <em>Rhapsody Java Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyJavaProject()
	 * @generated
	 * @ordered
	 */
	protected static final String RHAPSODY_JAVA_PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRhapsodyJavaProject() <em>Rhapsody Java Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyJavaProject()
	 * @generated
	 * @ordered
	 */
	protected String rhapsodyJavaProject = RHAPSODY_JAVA_PROJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRhapsodyJDTJavaLibrary() <em>Rhapsody JDT Java Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyJDTJavaLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final String RHAPSODY_JDT_JAVA_LIBRARY_EDEFAULT = "RHAPSODY_API"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRhapsodyJDTJavaLibrary() <em>Rhapsody JDT Java Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyJDTJavaLibrary()
	 * @generated
	 * @ordered
	 */
	protected String rhapsodyJDTJavaLibrary = RHAPSODY_JDT_JAVA_LIBRARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExcludedPaletteItems() <em>Excluded Palette Item</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedPaletteItems()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteItem> excludedPaletteItems;

	/**
	 * The cached value of the '{@link #getIncludedUMLMeni() <em>Included UML Menus</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedUMLMeni()
	 * @generated
	 * @ordered
	 */
	protected EList<GenUMLMenu> includedUMLMeni;

	/**
	 * The cached value of the '{@link #getDomainBlocks() <em>Domain Block</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<GenDomainBlockReference> domainBlocks;

	/**
	 * The default value of the '{@link #getElementtypeConfigurationContainerUri() <em>Elementtype Configuration Container Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementtypeConfigurationContainerUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENTTYPE_CONFIGURATION_CONTAINER_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementtypeConfigurationContainerUri() <em>Elementtype Configuration Container Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementtypeConfigurationContainerUri()
	 * @generated
	 * @ordered
	 */
	protected String elementtypeConfigurationContainerUri = ELEMENTTYPE_CONFIGURATION_CONTAINER_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainSpecializationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION;
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
								ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] {
			ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY,
			ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK };

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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION)) {
			return basicGetDomainSpecialization();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainBlockReference> getDomainBlocks() {
		if (domainBlocks == null) {
			domainBlocks = new EObjectContainmentWithInverseEList<GenDomainBlockReference>(
					GenDomainBlockReference.class, this, ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK,
					ZDLGenPackage.GEN_DOMAIN_BLOCK_REFERENCE__DOMAIN_SPECIALIZATION);
		}
		return domainBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementtypeConfigurationContainerUri() {
		return elementtypeConfigurationContainerUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementtypeConfigurationContainerUri(String newElementtypeConfigurationContainerUri) {
		String oldElementtypeConfigurationContainerUri = elementtypeConfigurationContainerUri;
		elementtypeConfigurationContainerUri = newElementtypeConfigurationContainerUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI,
					oldElementtypeConfigurationContainerUri, elementtypeConfigurationContainerUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUniqueName(GenDomainClassifier classifier) {
		return GenDomainSpecializationOperations.getUniqueName(this, classifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainClassifier> allClassifiers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<GenDomainClassifier> result = (EList<GenDomainClassifier>) cache.get(this,
					ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION.getEOperations().get(1));
			if (result == null) {
				cache.put(this, ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION.getEOperations().get(1),
						result = GenDomainSpecializationOperations.allClassifiers(this));
			}
			return result;
		}
		return GenDomainSpecializationOperations.allClassifiers(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExcluded(GenPaletteItem item) {
		return GenDomainSpecializationOperations.isExcluded(this, item);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDomainModelLibraries()).basicAdd(otherEnd,
					msgs);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDomainBlocks()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getDomainSpecialization() {
		if (domainSpecialization != null && domainSpecialization.eIsProxy()) {
			InternalEObject oldDomainSpecialization = (InternalEObject) domainSpecialization;
			domainSpecialization = (org.eclipse.uml2.uml.Class) eResolveProxy(oldDomainSpecialization);
			if (domainSpecialization != oldDomainSpecialization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION, oldDomainSpecialization,
							domainSpecialization));
			}
		}
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetDomainSpecialization() {
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainSpecialization(org.eclipse.uml2.uml.Class newDomainSpecialization) {
		org.eclipse.uml2.uml.Class oldDomainSpecialization = domainSpecialization;
		domainSpecialization = newDomainSpecialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION, oldDomainSpecialization,
					domainSpecialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Collect all of the <em>GenDomainConcept</em> in the <em>GenDomainSpecialization</em> 
	 * be traversing all of the GenDomainBlocks that are referenced.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainConcept> getDomainConcepts() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<GenDomainConcept> result = (EList<GenDomainConcept>) cache.get(this,
					ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT);
			if (result == null) {
				cache.put(this, ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT,
						result = GenDomainSpecializationOperations.getDomainConcepts(this));
			}
			return result;
		}
		return GenDomainSpecializationOperations.getDomainConcepts(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getDomainConcept(String name) {
		return getDomainConcept(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getDomainConcept(String name, boolean ignoreCase) {
		domainConceptLoop: for (GenDomainConcept domainConcept : getDomainConcepts()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(domainConcept.getName())
					: name.equals(domainConcept.getName())))
				continue domainConceptLoop;
			return domainConcept;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluginName() {
		return pluginName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginName(String newPluginName) {
		String oldPluginName = pluginName;
		pluginName = newPluginName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME,
					oldPluginName, pluginName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainModelLibraryReference> getDomainModelLibraries() {
		if (domainModelLibraries == null) {
			domainModelLibraries = new EObjectContainmentWithInverseEList<GenDomainModelLibraryReference>(
					GenDomainModelLibraryReference.class, this,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION);
		}
		return domainModelLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelLibraryNamesPackage() {
		return modelLibraryNamesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelLibraryNamesPackage(String newModelLibraryNamesPackage) {
		String oldModelLibraryNamesPackage = modelLibraryNamesPackage;
		modelLibraryNamesPackage = newModelLibraryNamesPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE, oldModelLibraryNamesPackage,
					modelLibraryNamesPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelLibrarySourceFolder() {
		return modelLibrarySourceFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelLibrarySourceFolder(String newModelLibrarySourceFolder) {
		String oldModelLibrarySourceFolder = modelLibrarySourceFolder;
		modelLibrarySourceFolder = newModelLibrarySourceFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER, oldModelLibrarySourceFolder,
					modelLibrarySourceFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMenuModelResource() {
		return menuModelResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMenuModelResource(String newMenuModelResource) {
		String oldMenuModelResource = menuModelResource;
		menuModelResource = newMenuModelResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE, oldMenuModelResource,
					menuModelResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION,
					oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodeGenTarget() {
		return codeGenTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeGenTarget(String newCodeGenTarget) {
		String oldCodeGenTarget = codeGenTarget;
		codeGenTarget = newCodeGenTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET, oldCodeGenTarget, codeGenTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRhapsodyJavaProject() {
		return rhapsodyJavaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyJavaProject(String newRhapsodyJavaProject) {
		String oldRhapsodyJavaProject = rhapsodyJavaProject;
		rhapsodyJavaProject = newRhapsodyJavaProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT, oldRhapsodyJavaProject,
					rhapsodyJavaProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRhapsodyJDTJavaLibrary() {
		return rhapsodyJDTJavaLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyJDTJavaLibrary(String newRhapsodyJDTJavaLibrary) {
		String oldRhapsodyJDTJavaLibrary = rhapsodyJDTJavaLibrary;
		rhapsodyJDTJavaLibrary = newRhapsodyJDTJavaLibrary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY, oldRhapsodyJDTJavaLibrary,
					rhapsodyJDTJavaLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteItem> getExcludedPaletteItems() {
		if (excludedPaletteItems == null) {
			excludedPaletteItems = new EObjectResolvingEList<GenPaletteItem>(GenPaletteItem.class, this,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM);
		}
		return excludedPaletteItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteItem getExcludedPaletteItem(String name) {
		return getExcludedPaletteItem(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteItem getExcludedPaletteItem(String name, boolean ignoreCase, EClass eClass) {
		excludedPaletteItemLoop: for (GenPaletteItem excludedPaletteItem : getExcludedPaletteItems()) {
			if (eClass != null && !eClass.isInstance(excludedPaletteItem))
				continue excludedPaletteItemLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(excludedPaletteItem.getName())
					: name.equals(excludedPaletteItem.getName())))
				continue excludedPaletteItemLoop;
			return excludedPaletteItem;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenUMLMenu> getIncludedUMLMeni() {
		if (includedUMLMeni == null) {
			includedUMLMeni = new EObjectResolvingEList<GenUMLMenu>(GenUMLMenu.class, this,
					ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS);
		}
		return includedUMLMeni;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			return ((InternalEList<?>) getDomainModelLibraries()).basicRemove(otherEnd, msgs);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			return ((InternalEList<?>) getDomainBlocks()).basicRemove(otherEnd, msgs);
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
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION:
			if (resolve)
				return getDomainSpecialization();
			return basicGetDomainSpecialization();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT:
			return getDomainConcepts();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME:
			return getPluginName();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME:
			return getResourceName();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			return getDomainModelLibraries();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE:
			return getModelLibraryNamesPackage();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER:
			return getModelLibrarySourceFolder();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE:
			return getMenuModelResource();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION:
			return getVersion();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET:
			return getCodeGenTarget();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT:
			return getRhapsodyJavaProject();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY:
			return getRhapsodyJDTJavaLibrary();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM:
			return getExcludedPaletteItems();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS:
			return getIncludedUMLMeni();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			return getDomainBlocks();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI:
			return getElementtypeConfigurationContainerUri();
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
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((org.eclipse.uml2.uml.Class) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME:
			setPluginName((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME:
			setResourceName((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			getDomainModelLibraries().clear();
			getDomainModelLibraries().addAll((Collection<? extends GenDomainModelLibraryReference>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE:
			setModelLibraryNamesPackage((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER:
			setModelLibrarySourceFolder((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE:
			setMenuModelResource((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION:
			setVersion((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET:
			setCodeGenTarget((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT:
			setRhapsodyJavaProject((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY:
			setRhapsodyJDTJavaLibrary((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM:
			getExcludedPaletteItems().clear();
			getExcludedPaletteItems().addAll((Collection<? extends GenPaletteItem>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS:
			getIncludedUMLMeni().clear();
			getIncludedUMLMeni().addAll((Collection<? extends GenUMLMenu>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			getDomainBlocks().clear();
			getDomainBlocks().addAll((Collection<? extends GenDomainBlockReference>) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI:
			setElementtypeConfigurationContainerUri((String) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((org.eclipse.uml2.uml.Class) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME:
			setPluginName(PLUGIN_NAME_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME:
			setResourceName(RESOURCE_NAME_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			getDomainModelLibraries().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE:
			setModelLibraryNamesPackage(MODEL_LIBRARY_NAMES_PACKAGE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER:
			setModelLibrarySourceFolder(MODEL_LIBRARY_SOURCE_FOLDER_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE:
			setMenuModelResource(MENU_MODEL_RESOURCE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET:
			setCodeGenTarget(CODE_GEN_TARGET_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT:
			setRhapsodyJavaProject(RHAPSODY_JAVA_PROJECT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY:
			setRhapsodyJDTJavaLibrary(RHAPSODY_JDT_JAVA_LIBRARY_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM:
			getExcludedPaletteItems().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS:
			getIncludedUMLMeni().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			getDomainBlocks().clear();
			return;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI:
			setElementtypeConfigurationContainerUri(ELEMENTTYPE_CONFIGURATION_CONTAINER_URI_EDEFAULT);
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
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION:
			return domainSpecialization != null;
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT:
			return !getDomainConcepts().isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__PLUGIN_NAME:
			return PLUGIN_NAME_EDEFAULT == null ? pluginName != null : !PLUGIN_NAME_EDEFAULT.equals(pluginName);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RESOURCE_NAME:
			return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY:
			return domainModelLibraries != null && !domainModelLibraries.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_NAMES_PACKAGE:
			return MODEL_LIBRARY_NAMES_PACKAGE_EDEFAULT == null ? modelLibraryNamesPackage != null
					: !MODEL_LIBRARY_NAMES_PACKAGE_EDEFAULT.equals(modelLibraryNamesPackage);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MODEL_LIBRARY_SOURCE_FOLDER:
			return MODEL_LIBRARY_SOURCE_FOLDER_EDEFAULT == null ? modelLibrarySourceFolder != null
					: !MODEL_LIBRARY_SOURCE_FOLDER_EDEFAULT.equals(modelLibrarySourceFolder);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__MENU_MODEL_RESOURCE:
			return MENU_MODEL_RESOURCE_EDEFAULT == null ? menuModelResource != null
					: !MENU_MODEL_RESOURCE_EDEFAULT.equals(menuModelResource);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__VERSION:
			return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__CODE_GEN_TARGET:
			return CODE_GEN_TARGET_EDEFAULT == null ? codeGenTarget != null
					: !CODE_GEN_TARGET_EDEFAULT.equals(codeGenTarget);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JAVA_PROJECT:
			return RHAPSODY_JAVA_PROJECT_EDEFAULT == null ? rhapsodyJavaProject != null
					: !RHAPSODY_JAVA_PROJECT_EDEFAULT.equals(rhapsodyJavaProject);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__RHAPSODY_JDT_JAVA_LIBRARY:
			return RHAPSODY_JDT_JAVA_LIBRARY_EDEFAULT == null ? rhapsodyJDTJavaLibrary != null
					: !RHAPSODY_JDT_JAVA_LIBRARY_EDEFAULT.equals(rhapsodyJDTJavaLibrary);
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__EXCLUDED_PALETTE_ITEM:
			return excludedPaletteItems != null && !excludedPaletteItems.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__INCLUDED_UML_MENUS:
			return includedUMLMeni != null && !includedUMLMeni.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK:
			return domainBlocks != null && !domainBlocks.isEmpty();
		case ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__ELEMENTTYPE_CONFIGURATION_CONTAINER_URI:
			return ELEMENTTYPE_CONFIGURATION_CONTAINER_URI_EDEFAULT == null
					? elementtypeConfigurationContainerUri != null
					: !ELEMENTTYPE_CONFIGURATION_CONTAINER_URI_EDEFAULT.equals(elementtypeConfigurationContainerUri);
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
		result.append(" (pluginName: "); //$NON-NLS-1$
		result.append(pluginName);
		result.append(", resourceName: "); //$NON-NLS-1$
		result.append(resourceName);
		result.append(", modelLibraryNamesPackage: "); //$NON-NLS-1$
		result.append(modelLibraryNamesPackage);
		result.append(", modelLibrarySourceFolder: "); //$NON-NLS-1$
		result.append(modelLibrarySourceFolder);
		result.append(", menuModelResource: "); //$NON-NLS-1$
		result.append(menuModelResource);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(", codeGenTarget: "); //$NON-NLS-1$
		result.append(codeGenTarget);
		result.append(", rhapsodyJavaProject: "); //$NON-NLS-1$
		result.append(rhapsodyJavaProject);
		result.append(", rhapsodyJDTJavaLibrary: "); //$NON-NLS-1$
		result.append(rhapsodyJDTJavaLibrary);
		result.append(", elementtypeConfigurationContainerUri: "); //$NON-NLS-1$
		result.append(elementtypeConfigurationContainerUri);
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
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_MODEL_LIBRARY)
				|| eIsSet(ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_BLOCK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_SPECIALIZATION__DOMAIN_SPECIALIZATION);
	}

} //GenDomainSpecializationImpl
