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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainNamedElementOperations;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenDomainObjectOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getPresentationHint <em>Presentation Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getPresentationKind <em>Presentation Kind</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getVisibleModelType <em>Visible Model Type</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getUmlMetaattribute <em>Uml Metaattribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getDomainAttribute <em>Domain Attribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainStructuralFeatureImpl#getConcept <em>Concept</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenDomainStructuralFeatureImpl extends GenDomainNamedElementImpl
		implements GenDomainStructuralFeature {

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final int VISIBLE_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int READ_ONLY_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #getPresentationHint() <em>Presentation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationHint()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENTATION_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPresentationHint() <em>Presentation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationHint()
	 * @generated
	 * @ordered
	 */
	protected String presentationHint = PRESENTATION_HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresentationKind() <em>Presentation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationKind()
	 * @generated
	 * @ordered
	 */
	protected static final GenDomainAttributePresentationKind PRESENTATION_KIND_EDEFAULT = GenDomainAttributePresentationKind.OTHER;

	/**
	 * The cached value of the '{@link #getPresentationKind() <em>Presentation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationKind()
	 * @generated
	 * @ordered
	 */
	protected GenDomainAttributePresentationKind presentationKind = PRESENTATION_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibleModelType() <em>Visible Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleModelType()
	 * @generated
	 * @ordered
	 */
	protected static final GenDomainPresentationModelKind VISIBLE_MODEL_TYPE_EDEFAULT = GenDomainPresentationModelKind.ALL;

	/**
	 * The cached value of the '{@link #getVisibleModelType() <em>Visible Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleModelType()
	 * @generated
	 * @ordered
	 */
	protected GenDomainPresentationModelKind visibleModelType = VISIBLE_MODEL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 8000;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUmlMetaattribute() <em>Uml Metaattribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMetaattribute()
	 * @generated
	 * @ordered
	 */
	protected Property umlMetaattribute;

	/**
	 * The cached value of the '{@link #getDomainAttribute() <em>Domain Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainAttribute()
	 * @generated
	 * @ordered
	 */
	protected Property domainAttribute;

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
	protected static final int IS_RHAPSODY_SUPPRESSED_EFLAG = 1 << 10;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainStructuralFeatureImpl() {
		super();
		eFlags |= VISIBLE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_STRUCTURAL_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisible() {
		return (eFlags & VISIBLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = (eFlags & VISIBLE_EFLAG) != 0;
		if (newVisible)
			eFlags |= VISIBLE_EFLAG;
		else
			eFlags &= ~VISIBLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE,
					oldVisible, newVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return (eFlags & READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = (eFlags & READ_ONLY_EFLAG) != 0;
		if (newReadOnly)
			eFlags |= READ_ONLY_EFLAG;
		else
			eFlags &= ~READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY, oldReadOnly, newReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPresentationHint() {
		return presentationHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationHint(String newPresentationHint) {
		String oldPresentationHint = presentationHint;
		presentationHint = newPresentationHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT, oldPresentationHint,
					presentationHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainAttributePresentationKind getPresentationKind() {
		return presentationKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationKind(GenDomainAttributePresentationKind newPresentationKind) {
		GenDomainAttributePresentationKind oldPresentationKind = presentationKind;
		presentationKind = newPresentationKind == null ? PRESENTATION_KIND_EDEFAULT : newPresentationKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND, oldPresentationKind,
					presentationKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainPresentationModelKind getVisibleModelType() {
		return visibleModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleModelType(GenDomainPresentationModelKind newVisibleModelType) {
		GenDomainPresentationModelKind oldVisibleModelType = visibleModelType;
		visibleModelType = newVisibleModelType == null ? VISIBLE_MODEL_TYPE_EDEFAULT : newVisibleModelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE, oldVisibleModelType,
					visibleModelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER,
					oldOrder, order));
	}

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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE)) {
			return basicGetDomainAttribute();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject getOwner() {
		GenDomainObject owner = basicGetOwner();
		return owner != null && owner.eIsProxy() ? (GenDomainObject) eResolveProxy((InternalEObject) owner) : owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject basicGetOwner() {
		GenDomainConcept concept = getConcept();
		if (concept != null) {
			return concept;
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getUmlMetaattribute() {
		if (umlMetaattribute != null && umlMetaattribute.eIsProxy()) {
			InternalEObject oldUmlMetaattribute = (InternalEObject) umlMetaattribute;
			umlMetaattribute = (Property) eResolveProxy(oldUmlMetaattribute);
			if (umlMetaattribute != oldUmlMetaattribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE, oldUmlMetaattribute,
							umlMetaattribute));
			}
		}
		return umlMetaattribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetUmlMetaattribute() {
		return umlMetaattribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUmlMetaattribute(Property newUmlMetaattribute) {
		Property oldUmlMetaattribute = umlMetaattribute;
		umlMetaattribute = newUmlMetaattribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE, oldUmlMetaattribute,
					umlMetaattribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getDomainAttribute() {
		if (domainAttribute != null && domainAttribute.eIsProxy()) {
			InternalEObject oldDomainAttribute = (InternalEObject) domainAttribute;
			domainAttribute = (Property) eResolveProxy(oldDomainAttribute);
			if (domainAttribute != oldDomainAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE, oldDomainAttribute,
							domainAttribute));
			}
		}
		return domainAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetDomainAttribute() {
		return domainAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainAttribute(Property newDomainAttribute) {
		Property oldDomainAttribute = domainAttribute;
		domainAttribute = newDomainAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE, oldDomainAttribute,
					domainAttribute));
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
					ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED, oldIsRhapsodySuppressed,
					newIsRhapsodySuppressed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getConcept() {
		if (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT)
			return null;
		return (GenDomainConcept) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcept(GenDomainConcept newConcept, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newConcept, ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConcept(GenDomainConcept newConcept) {
		if (newConcept != eInternalContainer()
				|| (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT
						&& newConcept != null)) {
			if (EcoreUtil.isAncestor(this, newConcept))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConcept != null)
				msgs = ((InternalEObject) newConcept).eInverseAdd(this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE,
						GenDomainConcept.class, msgs);
			msgs = basicSetConcept(newConcept, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT,
					newConcept, newConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetConcept((GenDomainConcept) otherEnd, msgs);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			return basicSetConcept(null, msgs);
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
		switch (eContainerFeatureID()) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			return eInternalContainer().eInverseRemove(this, ZDLGenPackage.GEN_DOMAIN_CONCEPT__FEATURE,
					GenDomainConcept.class, msgs);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
			return isVisible();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
			return isReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
			return getPresentationHint();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
			return getPresentationKind();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
			return getVisibleModelType();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
			return getOrder();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE:
			if (resolve)
				return getUmlMetaattribute();
			return basicGetUmlMetaattribute();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE:
			if (resolve)
				return getDomainAttribute();
			return basicGetDomainAttribute();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED:
			return isRhapsodySuppressed();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			return getConcept();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
			setVisible((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
			setReadOnly((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
			setPresentationHint((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
			setPresentationKind((GenDomainAttributePresentationKind) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
			setVisibleModelType((GenDomainPresentationModelKind) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
			setOrder((Integer) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE:
			setUmlMetaattribute((Property) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE:
			setDomainAttribute((Property) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED:
			setIsRhapsodySuppressed((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			setConcept((GenDomainConcept) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
			setVisible(VISIBLE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
			setPresentationHint(PRESENTATION_HINT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
			setPresentationKind(PRESENTATION_KIND_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
			setVisibleModelType(VISIBLE_MODEL_TYPE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
			setOrder(ORDER_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE:
			setUmlMetaattribute((Property) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE:
			setDomainAttribute((Property) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED:
			setIsRhapsodySuppressed(IS_RHAPSODY_SUPPRESSED_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			setConcept((GenDomainConcept) null);
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
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
			return ((eFlags & VISIBLE_EFLAG) != 0) != VISIBLE_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
			return ((eFlags & READ_ONLY_EFLAG) != 0) != READ_ONLY_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
			return PRESENTATION_HINT_EDEFAULT == null ? presentationHint != null
					: !PRESENTATION_HINT_EDEFAULT.equals(presentationHint);
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
			return presentationKind != PRESENTATION_KIND_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
			return visibleModelType != VISIBLE_MODEL_TYPE_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
			return order != ORDER_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__UML_METAATTRIBUTE:
			return umlMetaattribute != null;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE:
			return domainAttribute != null;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__IS_RHAPSODY_SUPPRESSED:
			return ((eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0) != IS_RHAPSODY_SUPPRESSED_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT:
			return getConcept() != null;
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
		if (baseClass == GenDomainAttributePresentation.class) {
			switch (derivedFeatureID) {
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE;
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY;
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT;
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND;
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE;
			case ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER:
				return ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER;
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
		if (baseClass == GenDomainAttributePresentation.class) {
			switch (baseFeatureID) {
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE;
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__READ_ONLY;
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_HINT;
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__PRESENTATION_KIND;
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__VISIBLE_MODEL_TYPE;
			case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
				return ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__ORDER;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (visible: "); //$NON-NLS-1$
		result.append((eFlags & VISIBLE_EFLAG) != 0);
		result.append(", readOnly: "); //$NON-NLS-1$
		result.append((eFlags & READ_ONLY_EFLAG) != 0);
		result.append(", presentationHint: "); //$NON-NLS-1$
		result.append(presentationHint);
		result.append(", presentationKind: "); //$NON-NLS-1$
		result.append(presentationKind);
		result.append(", visibleModelType: "); //$NON-NLS-1$
		result.append(visibleModelType);
		result.append(", order: "); //$NON-NLS-1$
		result.append(order);
		result.append(", isRhapsodySuppressed: "); //$NON-NLS-1$
		result.append((eFlags & IS_RHAPSODY_SUPPRESSED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__DOMAIN_ATTRIBUTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_STRUCTURAL_FEATURE__CONCEPT);
	}

} //GenDomainStructuralFeatureImpl
