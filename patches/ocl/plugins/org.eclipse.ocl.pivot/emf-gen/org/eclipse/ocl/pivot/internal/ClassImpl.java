/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.ClassListeners;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedConstraints <em>Owned Constraints</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedBindings <em>Owned Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedSignature <em>Owned Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getUnspecializedElement <em>Unspecialized Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getExtenders <em>Extenders</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#isIsActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#isIsInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedBehaviors <em>Owned Behaviors</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedInvariants <em>Owned Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ClassImpl#getSuperClasses <em>Super Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl
extends TypeImpl
implements org.eclipse.ocl.pivot.Class {

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_FEATURE_COUNT = TypeImpl.TYPE_FEATURE_COUNT + 15;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_OPERATION_COUNT = TypeImpl.TYPE_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getOwnedConstraints() <em>Owned Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedConstraints;

	/**
	 * The cached value of the '{@link #getOwnedBindings() <em>Owned Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateBinding> ownedBindings;

	/**
	 * The cached value of the '{@link #getOwnedSignature() <em>Owned Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignature ownedSignature;

	/**
	 * The cached value of the '{@link #getUnspecializedElement() <em>Unspecialized Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnspecializedElement()
	 * @generated
	 * @ordered
	 */
	protected TemplateableElement unspecializedElement;

	/**
	 * The cached value of the '{@link #getExtenders() <em>Extenders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtenders()
	 * @generated
	 * @ordered
	 */
	protected EList<StereotypeExtender> extenders;

	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ABSTRACT_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isIsActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ACTIVE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsActive() <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsActive()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ACTIVE_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isIsInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INTERFACE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_INTERFACE_EFLAG = 1 << 10;

	/**
	 * The cached value of the '{@link #getOwnedBehaviors() <em>Owned Behaviors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBehaviors()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> ownedBehaviors;

	/**
	 * The cached value of the '{@link #getOwnedInvariants() <em>Owned Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedInvariants;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperations;

	/**
	 * The cached value of the '{@link #getOwnedProperties() <em>Owned Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedProperties;

	/**
	 * The cached value of the '{@link #getSuperClasses() <em>Super Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> superClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Constraint> getOwnedConstraints()
	{
		if (ownedConstraints == null)
		{
			ownedConstraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, 5);
		}
		return ownedConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateSignature getOwnedSignature()
	{
		return ownedSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSignature(TemplateSignature newOwnedSignature, NotificationChain msgs)
	{
		TemplateSignature oldOwnedSignature = ownedSignature;
		ownedSignature = newOwnedSignature;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 7, oldOwnedSignature, newOwnedSignature);
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
	public void setOwnedSignature(TemplateSignature newOwnedSignature)
	{
		if (newOwnedSignature != ownedSignature)
		{
			NotificationChain msgs = null;
			if (ownedSignature != null)
				msgs = ((InternalEObject)ownedSignature).eInverseRemove(this, 5, TemplateSignature.class, msgs);
			if (newOwnedSignature != null)
				msgs = ((InternalEObject)newOwnedSignature).eInverseAdd(this, 5, TemplateSignature.class, msgs);
			msgs = basicSetOwnedSignature(newOwnedSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 7, newOwnedSignature, newOwnedSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<TemplateBinding> getOwnedBindings()
	{
		if (ownedBindings == null)
		{
			ownedBindings = new EObjectContainmentWithInverseEList<TemplateBinding>(TemplateBinding.class, this, 6, 5);
		}
		return ownedBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnspecializedElement(TemplateableElement newUnspecializedElement)
	{
		TemplateableElement oldUnspecializedElement = unspecializedElement;
		unspecializedElement = newUnspecializedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, oldUnspecializedElement, unspecializedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<StereotypeExtender> getExtenders()
	{
		if (extenders == null)
		{
			extenders = new EObjectWithInverseResolvingEList<StereotypeExtender>(StereotypeExtender.class, this, 9, 4);
		}
		return extenders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInstanceClassName()
	{
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceClassName(String newInstanceClassName)
	{
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, oldInstanceClassName, instanceClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAbstract()
	{
		return (eFlags & IS_ABSTRACT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = (eFlags & IS_ABSTRACT_EFLAG) != 0;
		if (newIsAbstract) eFlags |= IS_ABSTRACT_EFLAG; else eFlags &= ~IS_ABSTRACT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, oldIsAbstract, newIsAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsActive()
	{
		return (eFlags & IS_ACTIVE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsActive(boolean newIsActive)
	{
		boolean oldIsActive = (eFlags & IS_ACTIVE_EFLAG) != 0;
		if (newIsActive) eFlags |= IS_ACTIVE_EFLAG; else eFlags &= ~IS_ACTIVE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, oldIsActive, newIsActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInterface()
	{
		return (eFlags & IS_INTERFACE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Constraint> getOwnedInvariants()
	{
		if (ownedInvariants == null)
		{
			ownedInvariants = new EObjectContainmentEList<Constraint>(Constraint.class, this, 15);
		}
		return ownedInvariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage()
	{
		if (eContainerFeatureID() != (18)) return null;
		return (org.eclipse.ocl.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPackage(org.eclipse.ocl.pivot.Package newOwningPackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningPackage, 18, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningPackage(org.eclipse.ocl.pivot.Package newOwningPackage)
	{
		if (newOwningPackage != eInternalContainer() || (eContainerFeatureID() != (18) && newOwningPackage != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPackage != null)
				msgs = ((InternalEObject)newOwningPackage).eInverseAdd(this, 9, org.eclipse.ocl.pivot.Package.class, msgs);
			msgs = basicSetOwningPackage(newOwningPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 18, newOwningPackage, newOwningPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case 6:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBindings()).basicAdd(otherEnd, msgs);
			case 7:
				if (ownedSignature != null)
					msgs = ((InternalEObject)ownedSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (7), null, msgs);
				return basicSetOwnedSignature((TemplateSignature)otherEnd, msgs);
			case 9:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtenders()).basicAdd(otherEnd, msgs);
			case 16:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case 17:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperties()).basicAdd(otherEnd, msgs);
			case 18:
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
			case 6:
				return ((InternalEList<?>)getOwnedBindings()).basicRemove(otherEnd, msgs);
			case 7:
				return basicSetOwnedSignature(null, msgs);
			case 9:
				return ((InternalEList<?>)getExtenders()).basicRemove(otherEnd, msgs);
			case 14:
				return ((InternalEList<?>)getOwnedBehaviors()).basicRemove(otherEnd, msgs);
			case 15:
				return ((InternalEList<?>)getOwnedInvariants()).basicRemove(otherEnd, msgs);
			case 16:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case 17:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case 18:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case 18:
				return eInternalContainer().eInverseRemove(this, 9, org.eclipse.ocl.pivot.Package.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateUniqueInvariantName(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "Class::UniqueInvariantName";
		try {
			/**
			 *
			 * inv UniqueInvariantName:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = ownedInvariants->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @NonNull List<Constraint> ownedInvariants = this.getOwnedInvariants();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_ownedInvariants = idResolver.createSetOfAll(PivotTables.SET_CLSSid_Constraint, ownedInvariants);
					/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(PivotTables.SET_CLSSid_Constraint);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedInvariants.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = true;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Constraint _1 = (@NonNull Constraint)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
						//
						if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
							result = false;
							break;			// Abort after second find
						}
						else {
							accumulator.add(name);
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
	@Override
	public void setIsInterface(boolean newIsInterface)
	{
		boolean oldIsInterface = (eFlags & IS_INTERFACE_EFLAG) != 0;
		if (newIsInterface) eFlags |= IS_INTERFACE_EFLAG; else eFlags &= ~IS_INTERFACE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 13, oldIsInterface, newIsInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Behavior> getOwnedBehaviors()
	{
		if (ownedBehaviors == null)
		{
			ownedBehaviors = new EObjectContainmentEList<Behavior>(Behavior.class, this, 14);
		}
		return ownedBehaviors;
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
				return getOwnedBindings();
			case 7:
				return getOwnedSignature();
			case 8:
				return getUnspecializedElement();
			case 9:
				return getExtenders();
			case 10:
				return getInstanceClassName();
			case 11:
				return isIsAbstract();
			case 12:
				return isIsActive();
			case 13:
				return isIsInterface();
			case 14:
				return getOwnedBehaviors();
			case 15:
				return getOwnedInvariants();
			case 16:
				return getOwnedOperations();
			case 17:
				return getOwnedProperties();
			case 18:
				return getOwningPackage();
			case 19:
				return getSuperClasses();
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
				getOwnedBindings().clear();
				getOwnedBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case 7:
				setOwnedSignature((TemplateSignature)newValue);
				return;
			case 8:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case 9:
				getExtenders().clear();
				getExtenders().addAll((Collection<? extends StereotypeExtender>)newValue);
				return;
			case 10:
				setInstanceClassName((String)newValue);
				return;
			case 11:
				setIsAbstract((Boolean)newValue);
				return;
			case 12:
				setIsActive((Boolean)newValue);
				return;
			case 13:
				setIsInterface((Boolean)newValue);
				return;
			case 14:
				getOwnedBehaviors().clear();
				getOwnedBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case 15:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 16:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case 17:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case 18:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case 19:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
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
				getOwnedBindings().clear();
				return;
			case 7:
				setOwnedSignature((TemplateSignature)null);
				return;
			case 8:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case 9:
				getExtenders().clear();
				return;
			case 10:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case 11:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case 12:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case 13:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case 14:
				getOwnedBehaviors().clear();
				return;
			case 15:
				getOwnedInvariants().clear();
				return;
			case 16:
				getOwnedOperations().clear();
				return;
			case 17:
				getOwnedProperties().clear();
				return;
			case 18:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case 19:
				getSuperClasses().clear();
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
				return ownedBindings != null && !ownedBindings.isEmpty();
			case 7:
				return ownedSignature != null;
			case 8:
				return unspecializedElement != null;
			case 9:
				return extenders != null && !extenders.isEmpty();
			case 10:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case 11:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case 12:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case 13:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case 14:
				return ownedBehaviors != null && !ownedBehaviors.isEmpty();
			case 15:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case 16:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case 17:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case 18:
				return getOwningPackage() != null;
			case 19:
				return superClasses != null && !superClasses.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Namespace.class)
		{
			switch (derivedFeatureID)
			{
				case 5: return 5;
				default: return -1;
			}
		}
		if (baseClass == TemplateableElement.class)
		{
			switch (derivedFeatureID)
			{
				case 6: return 4;
				case 7: return 5;
				case 8: return 6;
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
		if (baseClass == Namespace.class)
		{
			switch (baseFeatureID)
			{
				case 5: return 5;
				default: return -1;
			}
		}
		if (baseClass == TemplateableElement.class)
		{
			switch (baseFeatureID)
			{
				case 4: return 6;
				case 5: return 7;
				case 6: return 8;
				default: return -1;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return flattenedType();
			case 3:
				return isClass();
			case 4:
				return isTemplateParameter();
			case 5:
				return specializeIn((CallExp)arguments.get(0), (Type)arguments.get(1));
			case 6:
				return validateNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateUniqueInvariantName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	private TypeId typeId = null;
	private TypeId normalizedTypeId = null;
	private @Nullable ClassListeners<ClassListeners.IClassListener> classListeners = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitClass(this);
	}

	public synchronized void addClassListener(ClassListeners.@NonNull IClassListener classListener) {
		ClassListeners<ClassListeners.IClassListener> classListeners2 = classListeners;
		if (classListeners2 == null) {
			classListeners2 = classListeners = new ClassListeners<ClassListeners.IClassListener>();
		}
		classListeners2.addListener(classListener);
	}

	public @NonNull TypeId computeId() {
		return IdManager.getClassId(this);
	}

	/**
	 * @since 1.18
	 */
	public @NonNull TypeId computeNormalizedId() {
		return computeId();
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (type == this) {
			return this;
		}
		StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		CompleteInheritance thisInheritance = this.getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.getCommonInheritance(thatInheritance).getPivotClass();
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(this);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return ClassUtil.nonNullState(eClass().getName());
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getNormalizedType(@NonNull StandardLibrary standardLibrary) {
		try {
			return getInheritance(standardLibrary).getPivotClass();
		}
		catch (Throwable e) {
			return this;			// WIP FIXME should never happen
		}
	}

	@Override
	public @NonNull List<Operation> getOwnedOperations()
	{
		EList<Operation> ownedOperations2 = ownedOperations;
		if (ownedOperations2 == null)
		{
			ownedOperations2 = ownedOperations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, PivotPackage.Literals.CLASS__OWNED_OPERATIONS.getFeatureID(), PivotPackage.Literals.OPERATION__OWNING_CLASS.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didRemove(int index, Operation partialOperation) {
					assert partialOperation != null;
					if (classListeners != null) {
						classListeners.didRemoveOperation(partialOperation);
					}
				}

				@Override
				public NotificationChain inverseAdd(Operation partialOperation, NotificationChain notifications) {
					assert partialOperation != null;
					NotificationChain inverseAdd = super.inverseAdd(partialOperation, notifications);
					if (classListeners != null) {
						classListeners.didAddOperation(partialOperation);		// inverseAdd rather than didAdd so that eContainer is defined
					}
					return inverseAdd;
				}
			};
		}
		return ownedOperations2;
	}

	@Override
	public @NonNull List<Property> getOwnedProperties()
	{
		EList<Property> ownedProperties2 = ownedProperties;
		if (ownedProperties2 == null)
		{
			ownedProperties2 = ownedProperties = new EObjectContainmentWithInverseEList<Property>(Property.class, this, PivotPackage.Literals.CLASS__OWNED_PROPERTIES.getFeatureID(), PivotPackage.Literals.PROPERTY__OWNING_CLASS.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				protected void didRemove(int index, Property partialProperty) {
					assert partialProperty != null;
					if (classListeners != null) {
						classListeners.didRemoveProperty(partialProperty);
					}
				}

				@Override
				public NotificationChain inverseAdd(Property partialProperty, NotificationChain notifications) {
					assert partialProperty != null;
					NotificationChain inverseAdd = super.inverseAdd(partialProperty, notifications);
					if (classListeners != null) {
						classListeners.didAddProperty(partialProperty);		// inverseAdd rather than didAdd so that eContainer is defined
					}
					return inverseAdd;
				}
			};
		}
		return ownedProperties2;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses()
	{
		EList<org.eclipse.ocl.pivot.Class> superClasses2 = superClasses;
		if (superClasses2 == null)
		{
			superClasses2 = superClasses = new EObjectResolvingEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, PivotPackage.Literals.CLASS__SUPER_CLASSES.getFeatureID())
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void didAdd(int index, org.eclipse.ocl.pivot.Class partialClass) {
					assert partialClass != null;
					if (classListeners != null) {
						classListeners.didAddSuperClass(partialClass);
					}
				}

				@Override
				protected void didRemove(int index, org.eclipse.ocl.pivot.Class partialClass) {
					assert partialClass != null;
					if (classListeners != null) {
						classListeners.didRemoveSuperClass(partialClass);
					}
				}
			};
		}
		return superClasses2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsNotNull(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "Class::NameIsNotNull";
		try {
			/**
			 *
			 * inv NameIsNotNull:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = name <> null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.CLASS___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable String name = this.getName();
				final /*@NonInvalid*/ boolean result = name != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, PivotTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return ClassifierAllInstancesOperation.allInstances(executor, returnTypeId, this);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TypeId getNormalizedTypeId() {
		TypeId normalizedTypeId2 = normalizedTypeId;
		if (normalizedTypeId2 == null) {
			synchronized (this) {
				normalizedTypeId2 = normalizedTypeId;
				if (normalizedTypeId2 == null) {
					normalizedTypeId = normalizedTypeId2 = computeNormalizedId();
				}
			}
		}
		return normalizedTypeId2;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			synchronized (this) {
				typeId2 = typeId;
				if (typeId2 == null) {
					typeId = typeId2 = computeId();
				}
			}
		}
		return typeId2;
	}

	@Override
	public @NonNull TemplateParameters getTypeParameters() {
		return TemplateSignatureImpl.getTypeParameters(getOwnedSignature());
	}

	@Override
	public TemplateableElement getUnspecializedElement()
	{
		if (unspecializedElement == null) {
			for (TemplateBinding templateBinding : getOwnedBindings()) {
				TemplateSignature signature = templateBinding.getTemplateSignature();
				if (signature != null) {
					unspecializedElement = signature.getOwningElement();
					if (unspecializedElement != null) {
						break;
					}
				}
			}
		}
		return unspecializedElement;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class isClass() {
		return this;
	}

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public @Nullable TemplateParameter isTemplateParameter() {
		return null;
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		CompleteInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		CompleteInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupImplementation(standardLibrary, apparentOperation);
	}

	public synchronized void removeClassListener(ClassListeners.@NonNull IClassListener classListener) {
		ClassListeners<ClassListeners.IClassListener> classListeners2 = classListeners;
		if ((classListeners2 != null) && classListeners2.removeListener(classListener)) {
			classListeners = null;
		}
	}

	@Override
	public void setName(String newName) {
		String oldName = name;
		org.eclipse.ocl.pivot.Package owningPackage = getOwningPackage();
		if ((owningPackage instanceof PackageImpl) && (oldName != null) && !oldName.equals(newName)) {
			((PackageImpl)owningPackage).didRemoveClass(this);
		}
		super.setName(newName);
		if ((owningPackage instanceof PackageImpl) && (newName != null) && !newName.equals(oldName)) {
			((PackageImpl)owningPackage).didAddClass(this);
		}
	}

	@Override
	public @NonNull Type specializeIn(/*@NonNull*/ CallExp callExpr, @Nullable Type selfType) {
		assert callExpr != null;
		if (selfType != null) {
			TemplateSignature templateSignature = getOwnedSignature();
			if (templateSignature != null) {
				EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(callExpr);
				PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
				return metamodelManager.specializeType(this, callExpr, selfType, null);
			}
			List<TemplateBinding> templateBindings = getOwnedBindings();
			if ((templateBindings != null) && !templateBindings.isEmpty()) {
				EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(callExpr);
				PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
				return metamodelManager.specializeType(this, callExpr, selfType, null);
			}
		}
		return this;
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //ClassImpl
