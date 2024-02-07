/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.DataTypeImpl#getBehavioralClass <em>Behavioral Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.DataTypeImpl#isIsSerializable <em>Is Serializable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.DataTypeImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeImpl
extends ClassImpl
implements DataType {

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_FEATURE_COUNT = ClassImpl.CLASS_FEATURE_COUNT + 3;
	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_OPERATION_COUNT = ClassImpl.CLASS_OPERATION_COUNT + 3;
	/**
	 * The cached value of the '{@link #getBehavioralClass() <em>Behavioral Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class behavioralClass;
	/**
	 * The default value of the '{@link #isIsSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SERIALIZABLE_EDEFAULT = true;
	/**
	 * The flag representing the value of the '{@link #isIsSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_SERIALIZABLE_EFLAG = 1 << 11;
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = ""; //$NON-NLS-1$
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
		eFlags |= IS_SERIALIZABLE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsSerializable(boolean newIsSerializable)
	{
		boolean oldIsSerializable = (eFlags & IS_SERIALIZABLE_EFLAG) != 0;
		if (newIsSerializable) eFlags |= IS_SERIALIZABLE_EFLAG; else eFlags &= ~IS_SERIALIZABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 21, oldIsSerializable, newIsSerializable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getBehavioralClass()
	{
		if (behavioralClass != null && behavioralClass.eIsProxy())
		{
			InternalEObject oldBehavioralClass = (InternalEObject)behavioralClass;
			behavioralClass = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldBehavioralClass);
			if (behavioralClass != oldBehavioralClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 20, oldBehavioralClass, behavioralClass));
			}
		}
		return behavioralClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetBehavioralClass()
	{
		return behavioralClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBehavioralClass(org.eclipse.ocl.pivot.Class newBehavioralClass)
	{
		org.eclipse.ocl.pivot.Class oldBehavioralClass = behavioralClass;
		behavioralClass = newBehavioralClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 20, oldBehavioralClass, behavioralClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsSerializable()
	{
		return (eFlags & IS_SERIALIZABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
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
			case 20:
				if (resolve) return getBehavioralClass();
				return basicGetBehavioralClass();
			case 21:
				return isIsSerializable();
			case 22:
				return getValue();
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
	public void eSet(int featureID, Object newValue)
	{
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
			case 20:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case 21:
				setIsSerializable((Boolean)newValue);
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
	public void eUnset(int featureID)
	{
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
			case 20:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case 21:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
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
			case 20:
				return behavioralClass != null;
			case 21:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case 22:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
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
			case 8:
				return validateBehavioralClassHasDistinctName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 9:
				return validateBehavioralClassIsPrimitiveType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 10:
				return validateBehavioralClassIsSuperClass((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return visitor.visitDataType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		if (eContainer() instanceof Library) {
			String name2 = name;
			if (name2 == null) {
				name2 = "";
			}
			return IdManager.getNsURIPackageId(PivotPackage.eNS_URI, PivotPackage.eNS_PREFIX, PivotPackage.eINSTANCE).getDataTypeId(name2, getTypeParameters().parametersSize());
		}
		else {
			Type behavioralType = getBehavioralClass();
			if ((behavioralType != null) && (behavioralType != this)) {
				//				return behavioralType.getTypeId();
			}
			return IdManager.getDataTypeId(this);
		}
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		org.eclipse.ocl.pivot.Class behavioralType = getBehavioralClass();
		return standardLibrary.getInheritance(behavioralType != null ? behavioralType : this);
	}

	/**
	 * @since 1.3
	 */
	@Override
	public String getValue() {
		return VALUE_EDEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateBehavioralClassHasDistinctName(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "DataType::BehavioralClassHasDistinctName";
		try {
			/**
			 *
			 * inv BehavioralClassHasDistinctName:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = behavioralClass <> null implies
			 *         superClasses->closure(superClasses)
			 *         ->forAll(b | b.name <> name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_HAS_DISTINCT_NAME__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class behavioralClass = this.getBehavioralClass();
					final /*@NonInvalid*/ boolean ne = behavioralClass != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_forAll;
						try {
							final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses = this.getSuperClasses();
							final /*@NonInvalid*/ @NonNull SetValue BOXED_superClasses = idResolver.createSetOfAll(PivotTables.SET_CLSSid_Class, superClasses);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, BOXED_superClasses);
							final @NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, PivotTables.SET_CLSSid_Class, PivotTables.SET_CLSSid_Class);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation()
							{
								/**
								 * superClasses
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object BOXED_superClasses, final /*@NonInvalid*/ @Nullable Object _1) {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class CAST_null = (org.eclipse.ocl.pivot.Class)_1;
									if (CAST_null == null) {
										throw new InvalidValueException("Null source for \'Class::superClasses\'");
									}
									final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses_0 = CAST_null.getSuperClasses();
									final /*@Thrown*/ @NonNull SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(PivotTables.SET_CLSSid_Class, superClasses_0);
									return BOXED_superClasses_0;
								}
							};
							final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, PivotTables.SET_CLSSid_Class, BODY_closure_0, BOXED_superClasses, ACC_closure_0);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
							/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
							@NonNull Iterator<Object> ITERATOR_b = closure.iterator();
							/*@Thrown*/ @Nullable Boolean forAll;
							while (true) {
								if (!ITERATOR_b.hasNext()) {
									if (accumulator == ValueUtil.TRUE_VALUE) {
										forAll = ValueUtil.TRUE_VALUE;
									}
									else {
										throw (InvalidValueException)accumulator;
									}
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class b = (org.eclipse.ocl.pivot.@NonNull Class)ITERATOR_b.next();
								/**
								 * b.name <> name
								 */
								final /*@NonInvalid*/ @Nullable String name = b.getName();
								final /*@NonInvalid*/ @Nullable String name_0 = this.getName();
								final /*@NonInvalid*/ boolean ne_0 = (name != null) ? !name.equals(name_0) : (name_0 != null);
								//
								if (!ne_0) {					// Normal unsuccessful body evaluation result
									forAll = ValueUtil.FALSE_VALUE;
									break;														// Stop immediately
								}
								else if (ne_0) {				// Normal successful body evaluation result
									;															// Carry on
								}
								else {															// Impossible badly typed result
									accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
								}
							}
							CAUGHT_forAll = forAll;
						}
						catch (Exception e) {
							CAUGHT_forAll = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_forAll == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_forAll instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_forAll;
							}
							if (CAUGHT_forAll == null) {
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
	public boolean validateBehavioralClassIsPrimitiveType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "DataType::BehavioralClassIsPrimitiveType";
		try {
			/**
			 *
			 * inv BehavioralClassIsPrimitiveType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = behavioralClass <> null implies
			 *         behavioralClass.oclIsKindOf(PrimitiveType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_IS_PRIMITIVE_TYPE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class behavioralClass = this.getBehavioralClass();
					final /*@NonInvalid*/ boolean ne = behavioralClass != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_PrimitiveType = idResolver.getClass(PivotTables.CLSSid_PrimitiveType, null);
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, behavioralClass, TYP_PrimitiveType).booleanValue();
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
	public boolean validateBehavioralClassIsSuperClass(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		final @NonNull String constraintName = "DataType::BehavioralClassIsSuperClass";
		try {
			/**
			 *
			 * inv BehavioralClassIsSuperClass:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = behavioralClass <> null implies
			 *         superClasses->includes(behavioralClass)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, PivotPackage.Literals.DATA_TYPE___VALIDATE_BEHAVIORAL_CLASS_IS_SUPER_CLASS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, PivotTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class behavioralClass = this.getBehavioralClass();
					final /*@NonInvalid*/ boolean ne = behavioralClass != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_includes;
						try {
							final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses = this.getSuperClasses();
							final /*@NonInvalid*/ @NonNull SetValue BOXED_superClasses = idResolver.createSetOfAll(PivotTables.SET_CLSSid_Class, superClasses);
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_superClasses, behavioralClass).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception e) {
							CAUGHT_includes = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_includes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_includes;
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

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (type instanceof DataType) {
			org.eclipse.ocl.pivot.Class behavioralClass = ((DataType)type).getBehavioralClass();
			if (behavioralClass != null) {
				type = behavioralClass;		// See Bug 574431 for discussion of this dodgy downcast
			}
		}
		return super.conformsTo(standardLibrary, type);
	}
} //DataTypeImpl
