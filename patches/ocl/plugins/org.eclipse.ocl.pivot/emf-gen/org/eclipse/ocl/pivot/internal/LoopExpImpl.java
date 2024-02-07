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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LoopExpImpl#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LoopExpImpl#getOwnedCoIterators <em>Owned Co Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LoopExpImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LoopExpImpl#getReferredIteration <em>Referred Iteration</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoopExpImpl
extends CallExpImpl
implements LoopExp {

	/**
	 * The number of structural features of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_EXP_FEATURE_COUNT = CallExpImpl.CALL_EXP_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_EXP_OPERATION_COUNT = CallExpImpl.CALL_EXP_OPERATION_COUNT + 7;

	/**
	 * The cached value of the '{@link #getOwnedBody() <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedBody;

	/**
	 * The cached value of the '{@link #getOwnedCoIterators() <em>Owned Co Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @see #getOwnedCoIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<IteratorVariable> ownedCoIterators;

	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> ownedIterators;

	/**
	 * The cached value of the '{@link #getReferredIteration() <em>Referred Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredIteration()
	 * @generated
	 * @ordered
	 */
	protected Iteration referredIteration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.LOOP_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedBody() {
		return ownedBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBody(OCLExpression newOwnedBody, NotificationChain msgs)
	{
		OCLExpression oldOwnedBody = ownedBody;
		ownedBody = newOwnedBody;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 12, oldOwnedBody, newOwnedBody);
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
	public void setOwnedBody(OCLExpression newOwnedBody) {
		if (newOwnedBody != ownedBody)
		{
			NotificationChain msgs = null;
			if (ownedBody != null)
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IteratorVariable> getOwnedCoIterators()
	{
		if (ownedCoIterators == null)
		{
			ownedCoIterators = new EObjectContainmentEList<IteratorVariable>(IteratorVariable.class, this, 13);
		}
		return ownedCoIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Variable> getOwnedIterators()
	{
		if (ownedIterators == null)
		{
			ownedIterators = new EObjectContainmentEList<Variable>(Variable.class, this, 14);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iteration getReferredIteration()
	{
		if (referredIteration != null && referredIteration.eIsProxy())
		{
			InternalEObject oldReferredIteration = (InternalEObject)referredIteration;
			referredIteration = (Iteration)eResolveProxy(oldReferredIteration);
			if (referredIteration != oldReferredIteration)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 15, oldReferredIteration, referredIteration));
			}
		}
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration basicGetReferredIteration()
	{
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredIteration(Iteration newReferredIteration)
	{
		Iteration oldReferredIteration = referredIteration;
		referredIteration = newReferredIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 15, oldReferredIteration, referredIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMatchingMapCoIterators(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::MatchingMapCoIterators";
		try {
			/**
			 *
			 * inv MatchingMapCoIterators:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = ownedSource?.type.oclIsKindOf(MapType) implies
			 *         self.ownedCoIterators->size() = 0 or
			 *         self.ownedCoIterators->size() =
			 *         self.ownedIterators->size()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_MATCHING_MAP_CO_ITERATORS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<IteratorVariable> ownedCoIterators_0 = this.getOwnedCoIterators();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedCoIterators_0 = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_IteratorVariable, ownedCoIterators_0);
					final /*@NonInvalid*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedCoIterators_0);
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_MapType_0 = idResolver.getClass(PivotTables.CLSSid_MapType, null);
						final /*@NonInvalid*/ @Nullable OCLExpression ownedSource = this.getOwnedSource();
						final /*@NonInvalid*/ @NonNull Object type = ownedSource == null;
						/*@Thrown*/ @Nullable Type safe_type_source;
						if (type == Boolean.TRUE) {
							safe_type_source = null;
						}
						else {
							assert ownedSource != null;
							final /*@Thrown*/ @Nullable Type type_0 = ownedSource.getType();
							safe_type_source = type_0;
						}
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source, TYP_MapType_0).booleanValue();
						CAUGHT_oclIsKindOf = oclIsKindOf;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean eq = size_0.equals(PivotTables.INT_0);
						final /*@NonInvalid*/ @Nullable Boolean or;
						if (eq) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull List<Variable> ownedIterators = this.getOwnedIterators();
							final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
							final /*@NonInvalid*/ @NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
							final /*@NonInvalid*/ boolean eq_0 = size_0.equals(size_1);
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
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							if (or == null) {
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
	public boolean validateMatchingOrderedCollectionCoIterators(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::MatchingOrderedCollectionCoIterators";
		try {
			/**
			 *
			 * inv MatchingOrderedCollectionCoIterators:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = ownedSource?.type.oclIsKindOf(OrderedSetType) or
			 *         ownedSource?.type.oclIsKindOf(SequenceType) implies
			 *         self.ownedCoIterators->size() = 0 or
			 *         self.ownedCoIterators->size() =
			 *         self.ownedIterators->size()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_MATCHING_ORDERED_COLLECTION_CO_ITERATORS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<IteratorVariable> ownedCoIterators_0 = this.getOwnedCoIterators();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedCoIterators_0 = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_IteratorVariable, ownedCoIterators_0);
					final /*@NonInvalid*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedCoIterators_0);
					/*@Caught*/ @Nullable Object CAUGHT_or;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OrderedSetType_0 = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
							final /*@NonInvalid*/ @Nullable OCLExpression ownedSource = this.getOwnedSource();
							final /*@NonInvalid*/ @NonNull Object type = ownedSource == null;
							/*@Thrown*/ @Nullable Type safe_type_source;
							if (type == Boolean.TRUE) {
								safe_type_source = null;
							}
							else {
								assert ownedSource != null;
								final /*@Thrown*/ @Nullable Type type_0 = ownedSource.getType();
								safe_type_source = type_0;
							}
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source, TYP_OrderedSetType_0).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean or;
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_SequenceType_0 = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
								final /*@NonInvalid*/ @Nullable OCLExpression ownedSource_0 = this.getOwnedSource();
								final /*@NonInvalid*/ @NonNull Object type_1 = ownedSource_0 == null;
								/*@Thrown*/ @Nullable Type safe_type_source_0;
								if (type_1 == Boolean.TRUE) {
									safe_type_source_0 = null;
								}
								else {
									assert ownedSource_0 != null;
									final /*@Thrown*/ @Nullable Type type_2 = ownedSource_0.getType();
									safe_type_source_0 = type_2;
								}
								final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source_0, TYP_SequenceType_0).booleanValue();
								CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
							}
							catch (Exception e) {
								CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_oclIsKindOf_0 == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf;
								}
								if (CAUGHT_oclIsKindOf_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf_0;
								}
								or = ValueUtil.FALSE_VALUE;
							}
						}
						CAUGHT_or = or;
					}
					catch (Exception e) {
						CAUGHT_or = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_or == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean eq = size_0.equals(PivotTables.INT_0);
						final /*@NonInvalid*/ @Nullable Boolean or_0;
						if (eq) {
							or_0 = ValueUtil.TRUE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull List<Variable> ownedIterators = this.getOwnedIterators();
							final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
							final /*@NonInvalid*/ @NonNull IntegerValue size_1 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedIterators);
							final /*@NonInvalid*/ boolean eq_0 = size_0.equals(size_1);
							if (eq_0) {
								or_0 = ValueUtil.TRUE_VALUE;
							}
							else {
								or_0 = ValueUtil.FALSE_VALUE;
							}
						}
						if (or_0 == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if ((CAUGHT_or == null) || (or_0 == null)) {
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
	public boolean validateNoCoInitializers(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::NoCoInitializers";
		try {
			/**
			 *
			 * inv NoCoInitializers:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = self.ownedCoIterators?->forAll(
			 *           ownedInit->isEmpty())
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_NO_CO_INITIALIZERS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<IteratorVariable> ownedCoIterators = this.getOwnedCoIterators();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedCoIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_IteratorVariable, ownedCoIterators);
					final /*@Thrown*/ @NonNull OrderedSetValue safe_forAll_sources = (@Nullable OrderedSetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedCoIterators, (Object)null);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR__1 = safe_forAll_sources.iterator();
					/*@Thrown*/ @Nullable Boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							if (accumulator == ValueUtil.TRUE_VALUE) {
								result = ValueUtil.TRUE_VALUE;
							}
							else {
								throw (InvalidValueException)accumulator;
							}
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull IteratorVariable _1 = (@NonNull IteratorVariable)ITERATOR__1.next();
						/**
						 * ownedInit->isEmpty()
						 */
						/*@Caught*/ @NonNull Object CAUGHT_isEmpty;
						try {
							final /*@NonInvalid*/ @Nullable OCLExpression ownedInit = _1.getOwnedInit();
							final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PivotTables.SET_CLSSid_OCLExpression, ownedInit);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(oclAsSet).booleanValue();
							CAUGHT_isEmpty = isEmpty;
						}
						catch (Exception e) {
							CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
						}
						//
						if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							result = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (CAUGHT_isEmpty == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (CAUGHT_isEmpty instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = CAUGHT_isEmpty;									// Cache an exception failure
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
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
	public boolean validateSourceIsCollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv SourceIsCollection: true
		 */
		return ValueUtil.TRUE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceIsIterable(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::SourceIsIterable";
		try {
			/**
			 *
			 * inv SourceIsIterable:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = ownedSource?.type.oclIsKindOf(IterableType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_SOURCE_IS_ITERABLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_IterableType = idResolver.getClass(PivotTables.CLSSid_IterableType, null);
					final /*@NonInvalid*/ @Nullable OCLExpression ownedSource = this.getOwnedSource();
					final /*@NonInvalid*/ @NonNull Object type = ownedSource == null;
					/*@Thrown*/ @Nullable Type safe_type_source;
					if (type == Boolean.TRUE) {
						safe_type_source = null;
					}
					else {
						assert ownedSource != null;
						final /*@Thrown*/ @Nullable Type type_0 = ownedSource.getType();
						safe_type_source = type_0;
					}
					final /*@Thrown*/ boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source, TYP_IterableType).booleanValue();
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
	public boolean validateNoInitializers(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::NoInitializers";
		try {
			/**
			 *
			 * inv NoInitializers:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = self.ownedIterators->forAll(
			 *           ownedInit->isEmpty())
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Variable> ownedIterators = this.getOwnedIterators();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, ownedIterators);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedIterators.iterator();
					/*@Thrown*/ @Nullable Boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							if (accumulator == ValueUtil.TRUE_VALUE) {
								result = ValueUtil.TRUE_VALUE;
							}
							else {
								throw (InvalidValueException)accumulator;
							}
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Variable _1 = (@NonNull Variable)ITERATOR__1.next();
						/**
						 * ownedInit->isEmpty()
						 */
						/*@Caught*/ @NonNull Object CAUGHT_isEmpty;
						try {
							final /*@NonInvalid*/ @Nullable OCLExpression ownedInit = _1.getOwnedInit();
							final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PivotTables.SET_CLSSid_OCLExpression, ownedInit);
							final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(oclAsSet).booleanValue();
							CAUGHT_isEmpty = isEmpty;
						}
						catch (Exception e) {
							CAUGHT_isEmpty = ValueUtil.createInvalidValue(e);
						}
						//
						if (CAUGHT_isEmpty == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							result = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (CAUGHT_isEmpty == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (CAUGHT_isEmpty instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = CAUGHT_isEmpty;									// Cache an exception failure
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
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
	public boolean validateNoNotOrderedCollectionCoIterators(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "LoopExp::NoNotOrderedCollectionCoIterators";
		try {
			/**
			 *
			 * inv NoNotOrderedCollectionCoIterators:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = ownedSource?.type.oclIsKindOf(BagType) or
			 *         ownedSource?.type.oclIsKindOf(SetType) implies
			 *         self.ownedCoIterators->isEmpty()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.LOOP_EXP___VALIDATE_NO_NOT_ORDERED_COLLECTION_CO_ITERATORS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_or;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_BagType_0 = idResolver.getClass(PivotTables.CLSSid_BagType, null);
							final /*@NonInvalid*/ @Nullable OCLExpression ownedSource = this.getOwnedSource();
							final /*@NonInvalid*/ @NonNull Object type = ownedSource == null;
							/*@Thrown*/ @Nullable Type safe_type_source;
							if (type == Boolean.TRUE) {
								safe_type_source = null;
							}
							else {
								assert ownedSource != null;
								final /*@Thrown*/ @Nullable Type type_0 = ownedSource.getType();
								safe_type_source = type_0;
							}
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source, TYP_BagType_0).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean or;
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_SetType_0 = idResolver.getClass(PivotTables.CLSSid_SetType, null);
								final /*@NonInvalid*/ @Nullable OCLExpression ownedSource_0 = this.getOwnedSource();
								final /*@NonInvalid*/ @NonNull Object type_1 = ownedSource_0 == null;
								/*@Thrown*/ @Nullable Type safe_type_source_0;
								if (type_1 == Boolean.TRUE) {
									safe_type_source_0 = null;
								}
								else {
									assert ownedSource_0 != null;
									final /*@Thrown*/ @Nullable Type type_2 = ownedSource_0.getType();
									safe_type_source_0 = type_2;
								}
								final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, safe_type_source_0, TYP_SetType_0).booleanValue();
								CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
							}
							catch (Exception e) {
								CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_oclIsKindOf_0 == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf;
								}
								if (CAUGHT_oclIsKindOf_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf_0;
								}
								or = ValueUtil.FALSE_VALUE;
							}
						}
						CAUGHT_or = or;
					}
					catch (Exception e) {
						CAUGHT_or = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_or == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull List<IteratorVariable> ownedCoIterators = this.getOwnedCoIterators();
						final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedCoIterators = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_IteratorVariable, ownedCoIterators);
						final /*@NonInvalid*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(BOXED_ownedCoIterators).booleanValue();
						if (isEmpty) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if (CAUGHT_or == null) {
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
				return basicSetOwnedSource(null, msgs);
			case 12:
				return basicSetOwnedBody(null, msgs);
			case 13:
				return ((InternalEList<?>)getOwnedCoIterators()).basicRemove(otherEnd, msgs);
			case 14:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
				return getTypeValue();
			case 9:
				return isIsImplicit();
			case 10:
				return isIsSafe();
			case 11:
				return getOwnedSource();
			case 12:
				return getOwnedBody();
			case 13:
				return getOwnedCoIterators();
			case 14:
				return getOwnedIterators();
			case 15:
				if (resolve) return getReferredIteration();
				return basicGetReferredIteration();
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
				setTypeValue((Type)newValue);
				return;
			case 9:
				setIsImplicit((Boolean)newValue);
				return;
			case 10:
				setIsSafe((Boolean)newValue);
				return;
			case 11:
				setOwnedSource((OCLExpression)newValue);
				return;
			case 12:
				setOwnedBody((OCLExpression)newValue);
				return;
			case 13:
				getOwnedCoIterators().clear();
				getOwnedCoIterators().addAll((Collection<? extends IteratorVariable>)newValue);
				return;
			case 14:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends Variable>)newValue);
				return;
			case 15:
				setReferredIteration((Iteration)newValue);
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
				setTypeValue((Type)null);
				return;
			case 9:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
				return;
			case 10:
				setIsSafe(IS_SAFE_EDEFAULT);
				return;
			case 11:
				setOwnedSource((OCLExpression)null);
				return;
			case 12:
				setOwnedBody((OCLExpression)null);
				return;
			case 13:
				getOwnedCoIterators().clear();
				return;
			case 14:
				getOwnedIterators().clear();
				return;
			case 15:
				setReferredIteration((Iteration)null);
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
				return typeValue != null;
			case 9:
				return ((eFlags & IS_IMPLICIT_EFLAG) != 0) != IS_IMPLICIT_EDEFAULT;
			case 10:
				return ((eFlags & IS_SAFE_EFLAG) != 0) != IS_SAFE_EDEFAULT;
			case 11:
				return ownedSource != null;
			case 12:
				return ownedBody != null;
			case 13:
				return ownedCoIterators != null && !ownedCoIterators.isEmpty();
			case 14:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case 15:
				return referredIteration != null;
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
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case 3:
				return isNonNull();
			case 4:
				return isNull();
			case 5:
				return validateTypeIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 6:
				return validateSafeSourceCanBeNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateSafeSourceCannotBeMap((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 8:
				return validateTypeIsNotInvalid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 9:
				return validateMatchingMapCoIterators((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 10:
				return validateMatchingOrderedCollectionCoIterators((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 11:
				return validateNoCoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 12:
				return validateNoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 13:
				return validateNoNotOrderedCollectionCoIterators((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 14:
				return validateSourceIsCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 15:
				return validateSourceIsIterable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLoopExp(this);
	}
} //LoopExpImpl
