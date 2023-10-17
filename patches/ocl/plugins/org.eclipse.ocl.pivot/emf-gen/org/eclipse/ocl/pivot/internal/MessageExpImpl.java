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
import org.eclipse.ocl.pivot.CallOperationAction;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.SendSignalAction;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MessageExpImpl#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MessageExpImpl#getOwnedCalledOperation <em>Owned Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MessageExpImpl#getOwnedSentSignal <em>Owned Sent Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MessageExpImpl#getOwnedTarget <em>Owned Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageExpImpl
		extends OCLExpressionImpl
		implements MessageExp {

	/**
	 * The number of structural features of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_EXP_FEATURE_COUNT = OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Message Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_EXP_OPERATION_COUNT = OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getOwnedArguments() <em>Owned Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> ownedArguments;

	/**
	 * The cached value of the '{@link #getOwnedCalledOperation() <em>Owned Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCalledOperation()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction ownedCalledOperation;

	/**
	 * The cached value of the '{@link #getOwnedSentSignal() <em>Owned Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSentSignal()
	 * @generated
	 * @ordered
	 */
	protected SendSignalAction ownedSentSignal;

	/**
	 * The cached value of the '{@link #getOwnedTarget() <em>Owned Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTarget()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.MESSAGE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedTarget() {
		return ownedTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTarget(OCLExpression newOwnedTarget, NotificationChain msgs)
	{
		OCLExpression oldOwnedTarget = ownedTarget;
		ownedTarget = newOwnedTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 12, oldOwnedTarget, newOwnedTarget);
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
	public void setOwnedTarget(OCLExpression newOwnedTarget) {
		if (newOwnedTarget != ownedTarget)
		{
			NotificationChain msgs = null;
			if (ownedTarget != null)
				msgs = ((InternalEObject)ownedTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			if (newOwnedTarget != null)
				msgs = ((InternalEObject)newOwnedTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			msgs = basicSetOwnedTarget(newOwnedTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, newOwnedTarget, newOwnedTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<OCLExpression> getOwnedArguments()
	{
		if (ownedArguments == null)
		{
			ownedArguments = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, 9);
		}
		return ownedArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallOperationAction getOwnedCalledOperation() {
		return ownedCalledOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCalledOperation(CallOperationAction newOwnedCalledOperation, NotificationChain msgs)
	{
		CallOperationAction oldOwnedCalledOperation = ownedCalledOperation;
		ownedCalledOperation = newOwnedCalledOperation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 10, oldOwnedCalledOperation, newOwnedCalledOperation);
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
	public void setOwnedCalledOperation(CallOperationAction newOwnedCalledOperation)
	{
		if (newOwnedCalledOperation != ownedCalledOperation)
		{
			NotificationChain msgs = null;
			if (ownedCalledOperation != null)
				msgs = ((InternalEObject)ownedCalledOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (10), null, msgs);
			if (newOwnedCalledOperation != null)
				msgs = ((InternalEObject)newOwnedCalledOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (10), null, msgs);
			msgs = basicSetOwnedCalledOperation(newOwnedCalledOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, newOwnedCalledOperation, newOwnedCalledOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SendSignalAction getOwnedSentSignal() {
		return ownedSentSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSentSignal(SendSignalAction newOwnedSentSignal, NotificationChain msgs)
	{
		SendSignalAction oldOwnedSentSignal = ownedSentSignal;
		ownedSentSignal = newOwnedSentSignal;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 11, oldOwnedSentSignal, newOwnedSentSignal);
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
	public void setOwnedSentSignal(SendSignalAction newOwnedSentSignal)
	{
		if (newOwnedSentSignal != ownedSentSignal)
		{
			NotificationChain msgs = null;
			if (ownedSentSignal != null)
				msgs = ((InternalEObject)ownedSentSignal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (11), null, msgs);
			if (newOwnedSentSignal != null)
				msgs = ((InternalEObject)newOwnedSentSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (11), null, msgs);
			msgs = basicSetOwnedSentSignal(newOwnedSentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, newOwnedSentSignal, newOwnedSentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOneCallOrOneSend(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "MessageExp::OneCallOrOneSend";
		try {
			/**
			 *
			 * inv OneCallOrOneSend:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = ownedCalledOperation->size() +
			 *         ownedSentSignal->size() = 1
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.MESSAGE_EXP___VALIDATE_ONE_CALL_OR_ONE_SEND__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable CallOperationAction ownedCalledOperation = this.getOwnedCalledOperation();
					final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PivotTables.SET_CLSSid_CallOperationAction, ownedCalledOperation);
					final /*@Thrown*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet);
					final /*@NonInvalid*/ @Nullable SendSignalAction ownedSentSignal = this.getOwnedSentSignal();
					final /*@Thrown*/ @NonNull SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, PivotTables.SET_CLSSid_SendSignalAction, ownedSentSignal);
					final /*@Thrown*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(oclAsSet_0);
					if (size_0 instanceof InvalidValueException) {
						throw (InvalidValueException)size_0;
					}
					final /*@Thrown*/ @NonNull IntegerValue sum = (@Nullable IntegerValue)NumericPlusOperation.INSTANCE.evaluate(size, size_0);
					final /*@Thrown*/ boolean result = sum.equals(PivotTables.INT_1);
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
	public boolean validateTargetIsNotACollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "MessageExp::TargetIsNotACollection";
		try {
			/**
			 *
			 * inv TargetIsNotACollection:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = not ownedTarget.type.oclIsKindOf(CollectionType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.MESSAGE_EXP___VALIDATE_TARGET_IS_NOT_ACOLLECTION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(PivotTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression ownedTarget = this.getOwnedTarget();
						final /*@NonInvalid*/ @Nullable Type type = ownedTarget.getType();
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
						CAUGHT_oclIsKindOf = oclIsKindOf;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
					}
					if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_oclIsKindOf;
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.FALSE_VALUE;
						}
						else {
							result = null;
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
			case 9:
				return ((InternalEList<?>)getOwnedArguments()).basicRemove(otherEnd, msgs);
			case 10:
				return basicSetOwnedCalledOperation(null, msgs);
			case 11:
				return basicSetOwnedSentSignal(null, msgs);
			case 12:
				return basicSetOwnedTarget(null, msgs);
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
				return getOwnedArguments();
			case 10:
				return getOwnedCalledOperation();
			case 11:
				return getOwnedSentSignal();
			case 12:
				return getOwnedTarget();
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
				getOwnedArguments().clear();
				getOwnedArguments().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case 10:
				setOwnedCalledOperation((CallOperationAction)newValue);
				return;
			case 11:
				setOwnedSentSignal((SendSignalAction)newValue);
				return;
			case 12:
				setOwnedTarget((OCLExpression)newValue);
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
				getOwnedArguments().clear();
				return;
			case 10:
				setOwnedCalledOperation((CallOperationAction)null);
				return;
			case 11:
				setOwnedSentSignal((SendSignalAction)null);
				return;
			case 12:
				setOwnedTarget((OCLExpression)null);
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
				return ownedArguments != null && !ownedArguments.isEmpty();
			case 10:
				return ownedCalledOperation != null;
			case 11:
				return ownedSentSignal != null;
			case 12:
				return ownedTarget != null;
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
				return validateOneCallOrOneSend((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateTargetIsNotACollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMessageExp(this);
	}
} //MessageExpImpl
