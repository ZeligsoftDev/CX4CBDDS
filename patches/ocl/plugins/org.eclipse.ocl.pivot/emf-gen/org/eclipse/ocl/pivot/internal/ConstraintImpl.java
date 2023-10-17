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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getConstrainedElements <em>Constrained Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#isIsCallable <em>Is Callable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getOwnedSpecification <em>Owned Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getOwningPostContext <em>Owning Post Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getOwningPreContext <em>Owning Pre Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getOwningState <em>Owning State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getOwningTransition <em>Owning Transition</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ConstraintImpl#getRedefinedConstraints <em>Redefined Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl
extends NamedElementImpl
implements Constraint {

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRAINT_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONSTRAINT_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getConstrainedElements() <em>Constrained Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> constrainedElements;

	/**
	 * The default value of the '{@link #isIsCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCallable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CALLABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCallable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_CALLABLE_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getOwnedSpecification() <em>Owned Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSpecification()
	 * @generated
	 * @ordered
	 */
	protected LanguageExpression ownedSpecification;

	/**
	 * The cached value of the '{@link #getRedefinedConstraints() <em>Redefined Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> redefinedConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<Element> getConstrainedElements()
	{
		if (constrainedElements == null)
		{
			constrainedElements = new EObjectResolvingEList<Element>(Element.class, this, 5);
		}
		return constrainedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LanguageExpression getOwnedSpecification() {
		return ownedSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSpecification(LanguageExpression newOwnedSpecification, NotificationChain msgs)
	{
		LanguageExpression oldOwnedSpecification = ownedSpecification;
		ownedSpecification = newOwnedSpecification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 8, oldOwnedSpecification, newOwnedSpecification);
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
	public void setOwnedSpecification(LanguageExpression newOwnedSpecification)
	{
		if (newOwnedSpecification != ownedSpecification)
		{
			NotificationChain msgs = null;
			if (ownedSpecification != null)
				msgs = ((InternalEObject)ownedSpecification).eInverseRemove(this, 10, LanguageExpression.class, msgs);
			if (newOwnedSpecification != null)
				msgs = ((InternalEObject)newOwnedSpecification).eInverseAdd(this, 10, LanguageExpression.class, msgs);
			msgs = basicSetOwnedSpecification(newOwnedSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, newOwnedSpecification, newOwnedSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOwningPostContext()
	{
		if (eContainerFeatureID() != (9)) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPostContext(Operation newOwningPostContext, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningPostContext, 9, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningPostContext(Operation newOwningPostContext)
	{
		if (newOwningPostContext != eInternalContainer() || (eContainerFeatureID() != (9) && newOwningPostContext != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningPostContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPostContext != null)
				msgs = ((InternalEObject)newOwningPostContext).eInverseAdd(this, 21, Operation.class, msgs);
			msgs = basicSetOwningPostContext(newOwningPostContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 9, newOwningPostContext, newOwningPostContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOwningPreContext()
	{
		if (eContainerFeatureID() != (10)) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPreContext(Operation newOwningPreContext, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningPreContext, 10, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningPreContext(Operation newOwningPreContext)
	{
		if (newOwningPreContext != eInternalContainer() || (eContainerFeatureID() != (10) && newOwningPreContext != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningPreContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPreContext != null)
				msgs = ((InternalEObject)newOwningPreContext).eInverseAdd(this, 22, Operation.class, msgs);
			msgs = basicSetOwningPreContext(newOwningPreContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, newOwningPreContext, newOwningPreContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCallable(boolean newIsCallable)
	{
		boolean oldIsCallable = (eFlags & IS_CALLABLE_EFLAG) != 0;
		if (newIsCallable) eFlags |= IS_CALLABLE_EFLAG; else eFlags &= ~IS_CALLABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 7, oldIsCallable, newIsCallable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getOwningState()
	{
		if (eContainerFeatureID() != (11)) return null;
		return (State)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningState(State newOwningState, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningState, 11, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningState(State newOwningState)
	{
		if (newOwningState != eInternalContainer() || (eContainerFeatureID() != (11) && newOwningState != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningState != null)
				msgs = ((InternalEObject)newOwningState).eInverseAdd(this, 20, State.class, msgs);
			msgs = basicSetOwningState(newOwningState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, newOwningState, newOwningState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transition getOwningTransition()
	{
		if (eContainerFeatureID() != (12)) return null;
		return (Transition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransition(Transition newOwningTransition, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTransition, 12, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransition(Transition newOwningTransition)
	{
		if (newOwningTransition != eInternalContainer() || (eContainerFeatureID() != (12) && newOwningTransition != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTransition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransition != null)
				msgs = ((InternalEObject)newOwningTransition).eInverseAdd(this, 8, Transition.class, msgs);
			msgs = basicSetOwningTransition(newOwningTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, newOwningTransition, newOwningTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Constraint> getRedefinedConstraints()
	{
		if (redefinedConstraints == null)
		{
			redefinedConstraints = new EObjectResolvingEList<Constraint>(Constraint.class, this, 13);
		}
		return redefinedConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateBooleanValued(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "Constraint::BooleanValued";
		try {
			/**
			 *
			 * inv BooleanValued:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedSpecification <> null and ownedSpecification.type <> null implies ownedSpecification.type = Boolean or ownedSpecification.type = OclVoid
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.CONSTRAINT___VALIDATE_BOOLEAN_VALUED__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @NonNull BooleanType TYP_Boolean_0 = (@NonNull BooleanType)idResolver.getClass(TypeId.BOOLEAN, null);
					final /*@NonInvalid*/ @NonNull VoidType TYP_OclVoid = (@NonNull VoidType)idResolver.getClass(TypeId.OCL_VOID, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull LanguageExpression ownedSpecification_0 = this.getOwnedSpecification();
					final /*@NonInvalid*/ @Nullable Type type_0 = ownedSpecification_0.getType();
					final /*@NonInvalid*/ @Nullable Boolean and;
					final /*@NonInvalid*/ boolean ne = type_0 != null;
					and = ne;
					final /*@Thrown*/ @Nullable Boolean result;
					if (and == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean eq = (type_0 != null) ? (type_0.getTypeId() == TYP_Boolean_0.getTypeId()) : false;
						final /*@NonInvalid*/ @Nullable Boolean or;
						if (eq) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ boolean eq_0 = (type_0 != null) ? (type_0.getTypeId() == TYP_OclVoid.getTypeId()) : false;
							if (eq_0) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								or = ValueUtil.FALSE_VALUE;
							}
						}
						if (or == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if ((and == null) || (or == null)) {
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
	@Override
	public boolean validateUniqueName(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv UniqueName: true
		 */
		return ValueUtil.TRUE_VALUE;
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
			case 8:
				if (ownedSpecification != null)
					msgs = ((InternalEObject)ownedSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (8), null, msgs);
				return basicSetOwnedSpecification((LanguageExpression)otherEnd, msgs);
			case 9:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPostContext((Operation)otherEnd, msgs);
			case 10:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPreContext((Operation)otherEnd, msgs);
			case 11:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningState((State)otherEnd, msgs);
			case 12:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTransition((Transition)otherEnd, msgs);
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
			case 8:
				return basicSetOwnedSpecification(null, msgs);
			case 9:
				return basicSetOwningPostContext(null, msgs);
			case 10:
				return basicSetOwningPreContext(null, msgs);
			case 11:
				return basicSetOwningState(null, msgs);
			case 12:
				return basicSetOwningTransition(null, msgs);
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
			case 9:
				return eInternalContainer().eInverseRemove(this, 21, Operation.class, msgs);
			case 10:
				return eInternalContainer().eInverseRemove(this, 22, Operation.class, msgs);
			case 11:
				return eInternalContainer().eInverseRemove(this, 20, State.class, msgs);
			case 12:
				return eInternalContainer().eInverseRemove(this, 8, Transition.class, msgs);
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
				return getConstrainedElements();
			case 6:
				return getContext();
			case 7:
				return isIsCallable();
			case 8:
				return getOwnedSpecification();
			case 9:
				return getOwningPostContext();
			case 10:
				return getOwningPreContext();
			case 11:
				return getOwningState();
			case 12:
				return getOwningTransition();
			case 13:
				return getRedefinedConstraints();
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
				getConstrainedElements().clear();
				getConstrainedElements().addAll((Collection<? extends Element>)newValue);
				return;
			case 7:
				setIsCallable((Boolean)newValue);
				return;
			case 8:
				setOwnedSpecification((LanguageExpression)newValue);
				return;
			case 9:
				setOwningPostContext((Operation)newValue);
				return;
			case 10:
				setOwningPreContext((Operation)newValue);
				return;
			case 11:
				setOwningState((State)newValue);
				return;
			case 12:
				setOwningTransition((Transition)newValue);
				return;
			case 13:
				getRedefinedConstraints().clear();
				getRedefinedConstraints().addAll((Collection<? extends Constraint>)newValue);
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
				getConstrainedElements().clear();
				return;
			case 7:
				setIsCallable(IS_CALLABLE_EDEFAULT);
				return;
			case 8:
				setOwnedSpecification((LanguageExpression)null);
				return;
			case 9:
				setOwningPostContext((Operation)null);
				return;
			case 10:
				setOwningPreContext((Operation)null);
				return;
			case 11:
				setOwningState((State)null);
				return;
			case 12:
				setOwningTransition((Transition)null);
				return;
			case 13:
				getRedefinedConstraints().clear();
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
				return constrainedElements != null && !constrainedElements.isEmpty();
			case 6:
				return getContext() != null;
			case 7:
				return ((eFlags & IS_CALLABLE_EFLAG) != 0) != IS_CALLABLE_EDEFAULT;
			case 8:
				return ownedSpecification != null;
			case 9:
				return getOwningPostContext() != null;
			case 10:
				return getOwningPreContext() != null;
			case 11:
				return getOwningState() != null;
			case 12:
				return getOwningTransition() != null;
			case 13:
				return redefinedConstraints != null && !redefinedConstraints.isEmpty();
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return validateBooleanValued((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 3:
				return validateUniqueName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitConstraint(this);
	}

	@Override
	public Namespace getContext() {
		for (EObject context = eContainer(); context != null; context = context.eContainer()) {
			if (context instanceof Namespace) {
				return (Namespace) context;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCallable()
	{
		return (eFlags & IS_CALLABLE_EFLAG) != 0;
	}

	public boolean isSetContext() {
		return getContext() != null;
	}


	@Override
	public String toString()
	{
		return super.toString();
	}
} //ConstraintImpl
