/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getAssociationClass <em>Association Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getDefaultValueString <em>Default Value String</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#isIsVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getRedefinedProperties <em>Redefined Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.PropertyImpl#getSubsettedProperty <em>Subsetted Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyImpl
extends FeatureImpl
implements Property {

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_FEATURE_COUNT = FeatureImpl.FEATURE_FEATURE_COUNT + 19;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_OPERATION_COUNT = FeatureImpl.FEATURE_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getAssociationClass() <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass associationClass;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected Object defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValueString() <em>Default Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueString()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValueString() <em>Default Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueString()
	 * @generated
	 * @ordered
	 */
	protected String defaultValueString = DEFAULT_VALUE_STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsComposite()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COMPOSITE_EFLAG = 1 << 10;

	/**
	 * The default value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DERIVED_EFLAG = 1 << 11;

	/**
	 * The default value of the '{@link #isIsID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsID()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ID_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsID()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ID_EFLAG = 1 << 12;

	/**
	 * The default value of the '{@link #isIsImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMPLICIT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_IMPLICIT_EFLAG = 1 << 13;

	/**
	 * The default value of the '{@link #isIsReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_READ_ONLY_EFLAG = 1 << 14;

	/**
	 * The default value of the '{@link #isIsResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RESOLVE_PROXIES_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isIsResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RESOLVE_PROXIES_EFLAG = 1 << 15;

	/**
	 * The default value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransient()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_TRANSIENT_EFLAG = 1 << 16;

	/**
	 * The default value of the '{@link #isIsUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNSETTABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_UNSETTABLE_EFLAG = 1 << 17;

	/**
	 * The default value of the '{@link #isIsVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VOLATILE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_VOLATILE_EFLAG = 1 << 18;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> keys;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected Property opposite;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected LanguageExpression ownedExpression;

	/**
	 * The cached value of the '{@link #getRedefinedProperties() <em>Redefined Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> redefinedProperties;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * The cached value of the '{@link #getSubsettedProperty() <em>Subsetted Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsettedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> subsettedProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
		eFlags |= IS_RESOLVE_PROXIES_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssociationClass getAssociationClass()
	{
		if (associationClass != null && associationClass.eIsProxy())
		{
			InternalEObject oldAssociationClass = (InternalEObject)associationClass;
			associationClass = (AssociationClass)eResolveProxy(oldAssociationClass);
			if (associationClass != oldAssociationClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 11, oldAssociationClass, associationClass));
			}
		}
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetAssociationClass()
	{
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationClass(AssociationClass newAssociationClass, NotificationChain msgs)
	{
		AssociationClass oldAssociationClass = associationClass;
		associationClass = newAssociationClass;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 11, oldAssociationClass, newAssociationClass);
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
	public void setAssociationClass(AssociationClass newAssociationClass)
	{
		if (newAssociationClass != associationClass)
		{
			NotificationChain msgs = null;
			if (associationClass != null)
				msgs = ((InternalEObject)associationClass).eInverseRemove(this, 20, AssociationClass.class, msgs);
			if (newAssociationClass != null)
				msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, 20, AssociationClass.class, msgs);
			msgs = basicSetAssociationClass(newAssociationClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, newAssociationClass, newAssociationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsReadOnly(boolean newIsReadOnly) {
		boolean oldIsReadOnly = (eFlags & IS_READ_ONLY_EFLAG) != 0;
		if (newIsReadOnly) eFlags |= IS_READ_ONLY_EFLAG; else eFlags &= ~IS_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 18, oldIsReadOnly, newIsReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsResolveProxies()
	{
		return (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsComposite(boolean newIsComposite) {
		boolean oldIsComposite = (eFlags & IS_COMPOSITE_EFLAG) != 0;
		if (newIsComposite) eFlags |= IS_COMPOSITE_EFLAG; else eFlags &= ~IS_COMPOSITE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 14, oldIsComposite, newIsComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDerived()
	{
		return (eFlags & IS_DERIVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = (eFlags & IS_DERIVED_EFLAG) != 0;
		if (newIsDerived) eFlags |= IS_DERIVED_EFLAG; else eFlags &= ~IS_DERIVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 15, oldIsDerived, newIsDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsID()
	{
		return (eFlags & IS_ID_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getOpposite() {
		if (opposite != null && opposite.eIsProxy())
		{
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (Property)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 24, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpposite(Property newOpposite) {
		Property oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 24, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LanguageExpression getOwnedExpression()
	{
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(LanguageExpression newOwnedExpression, NotificationChain msgs)
	{
		LanguageExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 25, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(LanguageExpression newOwnedExpression)
	{
		if (newOwnedExpression != ownedExpression)
		{
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (25), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (25), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 25, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsImplicit(boolean newIsImplicit)
	{
		boolean oldIsImplicit = (eFlags & IS_IMPLICIT_EFLAG) != 0;
		if (newIsImplicit) eFlags |= IS_IMPLICIT_EFLAG; else eFlags &= ~IS_IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 17, oldIsImplicit, newIsImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsReadOnly()
	{
		return (eFlags & IS_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getDefaultValue()
	{
		String defaultValueString2 = defaultValueString;
		if ((defaultValue == null) && (defaultValueString2 != null)) {
			TypeId typeId = getTypeId();
			if (typeId instanceof EnumerationId) {
				defaultValue = NameUtil.getNameable(((Enumeration)type).getOwnedLiterals(), defaultValueString2);
				if (defaultValue == null) {
					throw new IllegalStateException("Unknown enumeration literal'" + defaultValueString2 + "' for '" + typeId + "'");
				}
			}
			else if (typeId == TypeId.BOOLEAN) {
				defaultValue = Boolean.valueOf(defaultValueString2);
			}
			else if (typeId == TypeId.STRING) {
				defaultValue = defaultValueString2;
			}
			else if (typeId == TypeId.REAL) {
				defaultValue = ValueUtil.realValueOf(defaultValueString2);
			}
			else if (typeId == TypeId.INTEGER) {
				defaultValue = ValueUtil.integerValueOf(defaultValueString2);
			}
			else if (typeId == TypeId.UNLIMITED_NATURAL) {
				defaultValue = ValueUtil.unlimitedNaturalValueOf(defaultValueString2);
			}
			else {
				defaultValue = null;		// FIXME ?? caller's responsibility to help by providing a ResourceSet etc.
			}
		}
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDefaultValue(Object newDefaultValue)
	{
		Object oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (newDefaultValue != oldDefaultValue) {
			String newDefaultValueString = null;
			if (newDefaultValue instanceof String) {
				newDefaultValueString = (String)newDefaultValue;
			}
			else if (newDefaultValue instanceof Boolean) {
				newDefaultValueString = newDefaultValue.toString();
			}
			else if (newDefaultValue instanceof Value) {
				newDefaultValueString = newDefaultValue.toString();
			}
			else if (newDefaultValue instanceof EnumerationLiteral) {
				newDefaultValueString = ((EnumerationLiteral)newDefaultValue).getName();
			}
			else if (newDefaultValue instanceof EObject) {
				URI uri = EcoreUtil.getURI((EObject)newDefaultValue);
				newDefaultValueString = uri.toString(); 		// FIXME resolve to parent base URI
			}
			else {
				newDefaultValueString = newDefaultValue.toString();
			}
			setDefaultValueStringGen(newDefaultValueString);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultValueString()
	{
		return defaultValueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValueStringGen(String newDefaultValueString)
	{
		String oldDefaultValueString = defaultValueString;
		defaultValueString = newDefaultValueString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 13, oldDefaultValueString, defaultValueString));
	}
	@Override
	public void setDefaultValueString(String newDefaultValueString)
	{
		String oldDefaultValueString = defaultValueString;
		setDefaultValueStringGen(newDefaultValueString);
		if ((oldDefaultValueString != defaultValueString) && ((oldDefaultValueString == null) || !oldDefaultValueString.equals(defaultValueString))) {
			defaultValue = null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsComposite()
	{
		return (eFlags & IS_COMPOSITE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsID(boolean newIsID)
	{
		boolean oldIsID = (eFlags & IS_ID_EFLAG) != 0;
		if (newIsID) eFlags |= IS_ID_EFLAG; else eFlags &= ~IS_ID_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 16, oldIsID, newIsID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsImplicit()
	{
		return (eFlags & IS_IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Property> getKeys()
	{
		if (keys == null)
		{
			keys = new EObjectResolvingEList<Property>(Property.class, this, 23);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsResolveProxies(boolean newIsResolveProxies)
	{
		boolean oldIsResolveProxies = (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
		if (newIsResolveProxies) eFlags |= IS_RESOLVE_PROXIES_EFLAG; else eFlags &= ~IS_RESOLVE_PROXIES_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 19, oldIsResolveProxies, newIsResolveProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTransient()
	{
		return (eFlags & IS_TRANSIENT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTransient(boolean newIsTransient)
	{
		boolean oldIsTransient = (eFlags & IS_TRANSIENT_EFLAG) != 0;
		if (newIsTransient) eFlags |= IS_TRANSIENT_EFLAG; else eFlags &= ~IS_TRANSIENT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 20, oldIsTransient, newIsTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnsettable()
	{
		return (eFlags & IS_UNSETTABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnsettable(boolean newIsUnsettable)
	{
		boolean oldIsUnsettable = (eFlags & IS_UNSETTABLE_EFLAG) != 0;
		if (newIsUnsettable) eFlags |= IS_UNSETTABLE_EFLAG; else eFlags &= ~IS_UNSETTABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 21, oldIsUnsettable, newIsUnsettable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsVolatile()
	{
		return (eFlags & IS_VOLATILE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsVolatile(boolean newIsVolatile)
	{
		boolean oldIsVolatile = (eFlags & IS_VOLATILE_EFLAG) != 0;
		if (newIsVolatile) eFlags |= IS_VOLATILE_EFLAG; else eFlags &= ~IS_VOLATILE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 22, oldIsVolatile, newIsVolatile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Property> getSubsettedProperty()
	{
		if (subsettedProperty == null)
		{
			subsettedProperty = new EObjectResolvingEList<Property>(Property.class, this, 29);
		}
		return subsettedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty()
	{
		if (referredProperty != null && referredProperty.eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 28, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty()
	{
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty)
	{
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 28, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAttribute(final Property p)
	{
		/**
		 *
		 * let container : OclElement[?] = oclContainer()
		 * in
		 *   container.oclIsKindOf(Class) and
		 *   container.oclAsType(Class)
		 *   .ownedProperties->includes(self)
		 */
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable Object container = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
		try {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Class_0 = idResolver.getClass(PivotTables.CLSSid_Class, null);
			final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, container, TYP_Class_0).booleanValue();
			CAUGHT_oclIsKindOf = oclIsKindOf;
		}
		catch (Exception e) {
			CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		}
		final /*@Thrown*/ @Nullable Boolean and;
		if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
			and = ValueUtil.FALSE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_includes;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Class_1 = idResolver.getClass(PivotTables.CLSSid_Class, null);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class oclAsType = (org.eclipse.ocl.pivot.@NonNull Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, container, TYP_Class_1);
				final /*@Thrown*/ @NonNull List<Property> ownedProperties = oclAsType.getOwnedProperties();
				final /*@Thrown*/ @NonNull OrderedSetValue BOXED_ownedProperties = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Property, ownedProperties);
				final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedProperties, this).booleanValue();
				CAUGHT_includes = includes;
			}
			catch (Exception e) {
				CAUGHT_includes = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_includes == ValueUtil.FALSE_VALUE) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_oclIsKindOf;
				}
				if (CAUGHT_includes instanceof InvalidValueException) {
					throw (InvalidValueException)CAUGHT_includes;
				}
				and = ValueUtil.TRUE_VALUE;
			}
		}
		if (and == null) {
			throw new InvalidValueException("Null body for \'pivot::Property::isAttribute(Property[1]) : Boolean[1]\'");
		}
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleDefaultExpression(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "Property::CompatibleDefaultExpression";
		try {
			/**
			 *
			 * inv CompatibleDefaultExpression:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedExpression <> null and
			 *         ownedExpression.oclAsType(ExpressionInOCL).ownedBody <> null implies
			 *         CompatibleBody(ownedExpression)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.PROPERTY___VALIDATE_COMPATIBLE_DEFAULT_EXPRESSION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ @Nullable LanguageExpression ownedExpression = this.getOwnedExpression();
						final /*@NonInvalid*/ boolean ne = ownedExpression != null;
						final /*@Thrown*/ @Nullable Boolean and;
						if (!ne) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_ne_0;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ExpressionInOCL_0 = idResolver.getClass(PivotTables.CLSSid_ExpressionInOCL, null);
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull ExpressionInOCL oclAsType = (@NonNull ExpressionInOCL)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ownedExpression, TYP_ExpressionInOCL_0);
								final /*@Thrown*/ @Nullable OCLExpression ownedBody = oclAsType.getOwnedBody();
								final /*@Thrown*/ boolean ne_0 = ownedBody != null;
								CAUGHT_ne_0 = ne_0;
							}
							catch (Exception e) {
								CAUGHT_ne_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_ne_0 == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_ne_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_ne_0;
								}
								and = ValueUtil.TRUE_VALUE;
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_CompatibleBody;
						try {
							final /*@NonInvalid*/ @Nullable LanguageExpression ownedExpression_1 = this.getOwnedExpression();
							final /*@Thrown*/ boolean CompatibleBody = this.CompatibleBody(ownedExpression_1);
							CAUGHT_CompatibleBody = CompatibleBody;
						}
						catch (Exception e) {
							CAUGHT_CompatibleBody = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_CompatibleBody == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if (CAUGHT_CompatibleBody instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_CompatibleBody;
							}
							if (CAUGHT_and == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, PivotTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
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
			case 11:
				if (associationClass != null)
					msgs = ((InternalEObject)associationClass).eInverseRemove(this, 20, AssociationClass.class, msgs);
				return basicSetAssociationClass((AssociationClass)otherEnd, msgs);
			case 26:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClass((org.eclipse.ocl.pivot.Class)otherEnd, msgs);
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
			case 11:
				return basicSetAssociationClass(null, msgs);
			case 25:
				return basicSetOwnedExpression(null, msgs);
			case 26:
				return basicSetOwningClass(null, msgs);
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
			case 26:
				return eInternalContainer().eInverseRemove(this, 17, org.eclipse.ocl.pivot.Class.class, msgs);
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
				return isIsMany();
			case 6:
				return isIsRequired();
			case 7:
				if (resolve) return getType();
				return basicGetType();
			case 8:
				return getImplementation();
			case 9:
				return getImplementationClass();
			case 10:
				return isIsStatic();
			case 11:
				if (resolve) return getAssociationClass();
				return basicGetAssociationClass();
			case 12:
				return getDefaultValue();
			case 13:
				return getDefaultValueString();
			case 14:
				return isIsComposite();
			case 15:
				return isIsDerived();
			case 16:
				return isIsID();
			case 17:
				return isIsImplicit();
			case 18:
				return isIsReadOnly();
			case 19:
				return isIsResolveProxies();
			case 20:
				return isIsTransient();
			case 21:
				return isIsUnsettable();
			case 22:
				return isIsVolatile();
			case 23:
				return getKeys();
			case 24:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case 25:
				return getOwnedExpression();
			case 26:
				return getOwningClass();
			case 27:
				return getRedefinedProperties();
			case 28:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case 29:
				return getSubsettedProperty();
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
			case 6:
				setIsRequired((Boolean)newValue);
				return;
			case 7:
				setType((Type)newValue);
				return;
			case 8:
				setImplementation((LibraryFeature)newValue);
				return;
			case 9:
				setImplementationClass((String)newValue);
				return;
			case 10:
				setIsStatic((Boolean)newValue);
				return;
			case 11:
				setAssociationClass((AssociationClass)newValue);
				return;
			case 12:
				setDefaultValue(newValue);
				return;
			case 13:
				setDefaultValueString((String)newValue);
				return;
			case 14:
				setIsComposite((Boolean)newValue);
				return;
			case 15:
				setIsDerived((Boolean)newValue);
				return;
			case 16:
				setIsID((Boolean)newValue);
				return;
			case 17:
				setIsImplicit((Boolean)newValue);
				return;
			case 18:
				setIsReadOnly((Boolean)newValue);
				return;
			case 19:
				setIsResolveProxies((Boolean)newValue);
				return;
			case 20:
				setIsTransient((Boolean)newValue);
				return;
			case 21:
				setIsUnsettable((Boolean)newValue);
				return;
			case 22:
				setIsVolatile((Boolean)newValue);
				return;
			case 23:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Property>)newValue);
				return;
			case 24:
				setOpposite((Property)newValue);
				return;
			case 25:
				setOwnedExpression((LanguageExpression)newValue);
				return;
			case 26:
				setOwningClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case 27:
				getRedefinedProperties().clear();
				getRedefinedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case 28:
				setReferredProperty((Property)newValue);
				return;
			case 29:
				getSubsettedProperty().clear();
				getSubsettedProperty().addAll((Collection<? extends Property>)newValue);
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
			case 6:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case 7:
				setType((Type)null);
				return;
			case 8:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case 9:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case 10:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case 11:
				setAssociationClass((AssociationClass)null);
				return;
			case 12:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case 13:
				setDefaultValueString(DEFAULT_VALUE_STRING_EDEFAULT);
				return;
			case 14:
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case 15:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case 16:
				setIsID(IS_ID_EDEFAULT);
				return;
			case 17:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
				return;
			case 18:
				setIsReadOnly(IS_READ_ONLY_EDEFAULT);
				return;
			case 19:
				setIsResolveProxies(IS_RESOLVE_PROXIES_EDEFAULT);
				return;
			case 20:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case 21:
				setIsUnsettable(IS_UNSETTABLE_EDEFAULT);
				return;
			case 22:
				setIsVolatile(IS_VOLATILE_EDEFAULT);
				return;
			case 23:
				getKeys().clear();
				return;
			case 24:
				setOpposite((Property)null);
				return;
			case 25:
				setOwnedExpression((LanguageExpression)null);
				return;
			case 26:
				setOwningClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case 27:
				getRedefinedProperties().clear();
				return;
			case 28:
				setReferredProperty((Property)null);
				return;
			case 29:
				getSubsettedProperty().clear();
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
				return isIsMany() != IS_MANY_EDEFAULT;
			case 6:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case 7:
				return type != null;
			case 8:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case 9:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case 10:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case 11:
				return associationClass != null;
			case 12:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case 13:
				return DEFAULT_VALUE_STRING_EDEFAULT == null ? defaultValueString != null : !DEFAULT_VALUE_STRING_EDEFAULT.equals(defaultValueString);
			case 14:
				return ((eFlags & IS_COMPOSITE_EFLAG) != 0) != IS_COMPOSITE_EDEFAULT;
			case 15:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case 16:
				return ((eFlags & IS_ID_EFLAG) != 0) != IS_ID_EDEFAULT;
			case 17:
				return ((eFlags & IS_IMPLICIT_EFLAG) != 0) != IS_IMPLICIT_EDEFAULT;
			case 18:
				return ((eFlags & IS_READ_ONLY_EFLAG) != 0) != IS_READ_ONLY_EDEFAULT;
			case 19:
				return ((eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0) != IS_RESOLVE_PROXIES_EDEFAULT;
			case 20:
				return ((eFlags & IS_TRANSIENT_EFLAG) != 0) != IS_TRANSIENT_EDEFAULT;
			case 21:
				return ((eFlags & IS_UNSETTABLE_EFLAG) != 0) != IS_UNSETTABLE_EDEFAULT;
			case 22:
				return ((eFlags & IS_VOLATILE_EFLAG) != 0) != IS_VOLATILE_EDEFAULT;
			case 23:
				return keys != null && !keys.isEmpty();
			case 24:
				return opposite != null;
			case 25:
				return ownedExpression != null;
			case 26:
				return getOwningClass() != null;
			case 27:
				return redefinedProperties != null && !redefinedProperties.isEmpty();
			case 28:
				return referredProperty != null;
			case 29:
				return subsettedProperty != null && !subsettedProperty.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case 3:
				return validateNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 4:
				return validateTypeIsNotInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 5:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 6:
				return isAttribute((Property)arguments.get(0));
			case 7:
				return validateCompatibleDefaultExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitProperty(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getOwningClass() {
		if (eContainerFeatureID() != (26)) return null;
		return (org.eclipse.ocl.pivot.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClass(org.eclipse.ocl.pivot.Class newOwningClass, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningClass, 26, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClass(org.eclipse.ocl.pivot.Class newOwningClass)
	{
		if (newOwningClass != eInternalContainer() || (eContainerFeatureID() != (26) && newOwningClass != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClass != null)
				msgs = ((InternalEObject)newOwningClass).eInverseAdd(this, 17, org.eclipse.ocl.pivot.Class.class, msgs);
			msgs = basicSetOwningClass(newOwningClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 26, newOwningClass, newOwningClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Property> getRedefinedProperties()
	{
		if (redefinedProperties == null)
		{
			redefinedProperties = new EObjectResolvingEList<Property>(Property.class, this, 27);
		}
		return redefinedProperties;
	}

	@Override
	public @Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		org.eclipse.ocl.pivot.Class owningType = getOwningClass();
		if (owningType != null) {
			return standardLibrary.getInheritance(owningType);
		}
		else {
			return null;
		}
	}

	private PropertyId propertyId = null;

	@Override
	public @NonNull PropertyId getPropertyId() {
		PropertyId propertyId2 = propertyId;
		if (propertyId2 == null) {
			synchronized (this) {
				propertyId2 = propertyId;
				if (propertyId2 == null) {
					String name = ClassUtil.nonNullModel(getName());
					TypeId typeId = getOwningClass().getTypeId();
					propertyId = propertyId2 = typeId.getPropertyId(name);
				}
			}
		}
		return propertyId2;
	}

	@Override
	public void initValue(@NonNull Object objectValue, @Nullable Object ecoreValue) {
		assert ValueUtil.isEcore(ecoreValue);
		EObject eTarget = getESObject();
		if (eTarget instanceof EStructuralFeature) {
			EStructuralFeature eFeature = (EStructuralFeature) eTarget;
			EObject eObject = ValueUtil.asNavigableObject(objectValue, eFeature, null);
			eObject.eSet(eFeature, ecoreValue);
			return;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public void unloaded(@NonNull ASResource asResource) {
		super.unloaded(asResource);
		Property asOpposite = basicGetOpposite();
		if (asOpposite != null) {
			Resource eResource = asOpposite.eResource();
			if ((eResource != null) && (eResource != asResource)) {
				asOpposite.setOwningClass(null);
			}
			asOpposite.setType(null);
			asOpposite.setOpposite(null);
			setOpposite(null);
		}
		setType(null);				// Easier to set them all than just the base_xxx ones
	}
} //PropertyImpl
