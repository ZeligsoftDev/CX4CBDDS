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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionLiteralExpImpl#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionLiteralExpImpl
extends LiteralExpImpl
implements CollectionLiteralExp {

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Collection Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_LITERAL_EXP_OPERATION_COUNT = LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 5;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.COLLECTION;

	/**
	 * The offset of the flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_DEFAULT = KIND_EDEFAULT.ordinal() << KIND_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link CollectionKind Collection Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final CollectionKind[] KIND_EFLAG_VALUES = CollectionKind.values();

	/**
	 * The flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG = 0x7 << KIND_EFLAG_OFFSET;

	/**
	 * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPart> ownedParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionKind getKind() {
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(CollectionKind newKind) {
		CollectionKind oldKind = KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
		if (newKind == null) newKind = KIND_EDEFAULT;
		eFlags = eFlags & ~KIND_EFLAG | newKind.ordinal() << KIND_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 9, oldKind, newKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<CollectionLiteralPart> getOwnedParts()
	{
		if (ownedParts == null)
		{
			ownedParts = new EObjectContainmentEList<CollectionLiteralPart>(CollectionLiteralPart.class, this, 10);
		}
		return ownedParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollectionKindIsConcrete(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "CollectionLiteralExp::CollectionKindIsConcrete";
		try {
			/**
			 *
			 * inv CollectionKindIsConcrete:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = kind <> CollectionKind::Collection
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull CollectionKind kind = this.getKind();
				final /*@NonInvalid*/ @NonNull EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
				final /*@NonInvalid*/ boolean result = BOXED_kind != PivotTables.ELITid_Collection;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSetKindIsSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "CollectionLiteralExp::SetKindIsSet";
		try {
			/**
			 *
			 * inv SetKindIsSet:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = kind = CollectionKind::Set implies
			 *         type.oclIsKindOf(SetType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull CollectionKind kind = this.getKind();
					final /*@NonInvalid*/ @NonNull EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
					final /*@NonInvalid*/ boolean eq = BOXED_kind == PivotTables.ELITid_Set;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!eq) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_SetType = idResolver.getClass(PivotTables.CLSSid_SetType, null);
							final /*@NonInvalid*/ @Nullable Type type = this.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_SetType).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							result = ValueUtil.FALSE_VALUE;
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
	public boolean validateOrderedSetKindIsOrderedSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "CollectionLiteralExp::OrderedSetKindIsOrderedSet";
		try {
			/**
			 *
			 * inv OrderedSetKindIsOrderedSet:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = kind = CollectionKind::OrderedSet implies
			 *         type.oclIsKindOf(OrderedSetType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull CollectionKind kind = this.getKind();
					final /*@NonInvalid*/ @NonNull EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
					final /*@NonInvalid*/ boolean eq = BOXED_kind == PivotTables.ELITid_OrderedSet;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!eq) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_OrderedSetType = idResolver.getClass(PivotTables.CLSSid_OrderedSetType, null);
							final /*@NonInvalid*/ @Nullable Type type = this.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_OrderedSetType).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							result = ValueUtil.FALSE_VALUE;
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
	public boolean validateSequenceKindIsSequence(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "CollectionLiteralExp::SequenceKindIsSequence";
		try {
			/**
			 *
			 * inv SequenceKindIsSequence:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = kind = CollectionKind::Sequence implies
			 *         type.oclIsKindOf(SequenceType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull CollectionKind kind = this.getKind();
					final /*@NonInvalid*/ @NonNull EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
					final /*@NonInvalid*/ boolean eq = BOXED_kind == PivotTables.ELITid_Sequence;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!eq) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_SequenceType = idResolver.getClass(PivotTables.CLSSid_SequenceType, null);
							final /*@NonInvalid*/ @Nullable Type type = this.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_SequenceType).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							result = ValueUtil.FALSE_VALUE;
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
	public boolean validateBagKindIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "CollectionLiteralExp::BagKindIsBag";
		try {
			/**
			 *
			 * inv BagKindIsBag:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = kind = CollectionKind::Bag implies
			 *         type.oclIsKindOf(BagType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull CollectionKind kind = this.getKind();
					final /*@NonInvalid*/ @NonNull EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(ClassUtil.nonNullState(kind.getName()));
					final /*@NonInvalid*/ boolean eq = BOXED_kind == PivotTables.ELITid_Bag;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!eq) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_BagType = idResolver.getClass(PivotTables.CLSSid_BagType, null);
							final /*@NonInvalid*/ @Nullable Type type = this.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_BagType).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							result = ValueUtil.FALSE_VALUE;
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
			case 10:
				return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
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
				return getKind();
			case 10:
				return getOwnedParts();
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
				setKind((CollectionKind)newValue);
				return;
			case 10:
				getOwnedParts().clear();
				getOwnedParts().addAll((Collection<? extends CollectionLiteralPart>)newValue);
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
				setKind(KIND_EDEFAULT);
				return;
			case 10:
				getOwnedParts().clear();
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
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case 10:
				return ownedParts != null && !ownedParts.isEmpty();
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
				return validateBagKindIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateCollectionKindIsConcrete((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 8:
				return validateOrderedSetKindIsOrderedSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 9:
				return validateSequenceKindIsSequence((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 10:
				return validateSetKindIsSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return visitor.visitCollectionLiteralExp(this);
	}
} //CollectionLiteralExpImpl
