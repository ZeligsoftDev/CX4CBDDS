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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainReferenceImpl#getDomainReference <em>Domain Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainReferenceImpl extends GenDomainStructuralFeatureImpl implements GenDomainReference {

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected GenDomainConcept target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected GenDomainConcept source;

	/**
	 * The cached value of the '{@link #getDomainReference() <em>Domain Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainReference()
	 * @generated
	 * @ordered
	 */
	protected Association domainReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_REFERENCE;
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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE)) {
			return basicGetDomainReference();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getConcept() {
		if (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT)
			return null;
		return (GenDomainConcept) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcept(GenDomainConcept newConcept, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newConcept, ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT, msgs);
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (source != null && source != newConcept) {
				setSource(null);
			}
		}
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
				|| (eContainerFeatureID() != ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT && newConcept != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT,
					newConcept, newConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (GenDomainConcept) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(GenDomainConcept newTarget) {
		GenDomainConcept oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET, oldTarget,
					target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (GenDomainConcept) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(GenDomainConcept newSource) {
		GenDomainConcept oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE, oldSource,
					source));
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newSource != null) {
				GenDomainConcept concept = getConcept();
				if (newSource != concept) {
					setConcept(newSource);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association getDomainReference() {
		if (domainReference != null && domainReference.eIsProxy()) {
			InternalEObject oldDomainReference = (InternalEObject) domainReference;
			domainReference = (Association) eResolveProxy(oldDomainReference);
			if (domainReference != oldDomainReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE, oldDomainReference, domainReference));
			}
		}
		return domainReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association basicGetDomainReference() {
		return domainReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainReference(Association newDomainReference) {
		Association oldDomainReference = domainReference;
		domainReference = newDomainReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE,
					oldDomainReference, domainReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT:
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT:
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT:
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE:
			if (resolve)
				return getDomainReference();
			return basicGetDomainReference();
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET:
			setTarget((GenDomainConcept) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE:
			setSource((GenDomainConcept) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE:
			setDomainReference((Association) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET:
			setTarget((GenDomainConcept) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE:
			setSource((GenDomainConcept) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE:
			setDomainReference((Association) null);
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
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__CONCEPT:
			return getConcept() != null;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__TARGET:
			return target != null;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__SOURCE:
			return source != null;
		case ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE:
			return domainReference != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_REFERENCE__DOMAIN_REFERENCE);
	}

} //GenDomainReferenceImpl
