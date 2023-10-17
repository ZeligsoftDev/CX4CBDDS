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
package org.eclipse.ocl.pivot.values;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OclInvalidTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.values.UndefinedValueImpl;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * An InvalidValueException wraps an InvalidValue and is used to return the InvalidValue
 * to the caller. Exceptions are a
 * is thrown when an Invalid Value arises during
 * an evaluation, and when no EvaluationEnvironment is available to support
 * throwing an InvalidEvaluationException. When such an environment is
 * available the InvalidValueException is rethrown as an
 * InvalidEvaluationException.
 *
 * * @generated NOT
 */
public class InvalidValueException extends UndefinedValueImpl implements InvalidValue
{
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INVALID_VALUE;
	}

	/**
	 * @since 1.5
	 */
	public InvalidValueException(@NonNull Throwable exception, /*@NonNull*/ String message) {
		super(exception, message);
		assert !(exception instanceof InvalidValueException);
	}
	public InvalidValueException(@NonNull Exception exception, /*@NonNull*/ String message) {		// FIXME remove obsolete signature
		super(exception, message);
		assert !(exception instanceof InvalidValueException);
	}

	public InvalidValueException(/*@NonNull*/ String messageTemplate, Object... bindings) {
		super(messageTemplate, bindings);
	}

	/**
	 * @since 1.5
	 */
	public InvalidValueException(@NonNull Throwable e) {
		super(e, null);
		assert !(e instanceof InvalidValueException);
	}
	public InvalidValueException(@NonNull Exception e) {		// FIXME remove obsolete signature
		super(e, null);
		assert !(e instanceof InvalidValueException);
	}

	/**
	 * @since 1.5
	 */
	public InvalidValueException(@NonNull Throwable e, /*@NonNull*/ String messageTemplate, Object... bindings) {
		super(e, messageTemplate, bindings);
	}
	public InvalidValueException(@NonNull Exception e, /*@NonNull*/ String messageTemplate, Object... bindings) {
		super(e, messageTemplate, bindings);					// FIXME remove obsolete signature
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw this;
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw this;
	}

	@Override
	public @NonNull Double asDouble() {
		throw this;
	}

	@Override
	public @NonNull List<Object> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		throw this;
	}

	@Override
	public Element asElement() {
		throw this;
	}

	@Override
	public @NonNull Integer asInteger() {
		throw this;
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw this;
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		throw this;
	}

	@Override
	public @NonNull Number asNumber() {
		throw this;
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw this;
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw this;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw this;
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw this;
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw this;
	}

	@Override
	public @NonNull List<Object> asUnboxedObject(@NonNull IdResolver idResolver) {
		throw this;
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw this;
	}

	@Override
	public @NonNull LiteralExp createLiteralExp() {
		InvalidLiteralExp literalExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		literalExp.setName(getMessage());
		return literalExp;
	}

	@Override
	public boolean equals(Object obj) {
		throw this; //return obj instanceof InvalidValueException;
	}

	public @NonNull Type getType(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	@Override
	public @NonNull OclInvalidTypeId getTypeId() {
		return TypeId.OCL_INVALID;
	}

	@Override
	public int intValue() {
		toInvalidValue();		// throws rather than returns
		return 0;
	}

	@Override
	public int hashCode() {
		return 0x22222222;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	@Override
	public int oclHashCode() {
		return hashCode();
	}

	@Override
	public String toString() {
		if (this == ValueUtil.INVALID_VALUE) {
			return "invalid";
		}
		return super.toString();
	}

	//	@Override
	//	public String toString() {
	//		if (exception != null) {
	//			return Value.INVALID_NAME + "<" + exception.getMessage() + ">";
	//		}
	//		else {
	//			return exception.getMessage(); //Value.INVALID_NAME;
	//		}
	//	}
}
