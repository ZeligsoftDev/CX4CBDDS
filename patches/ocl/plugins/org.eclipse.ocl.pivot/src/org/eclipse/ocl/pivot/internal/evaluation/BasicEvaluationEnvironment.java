/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.Option;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.osgi.util.NLS;

/**
 * Basic implementation of the {@link EvaluationEnvironment} interface,
 * providing some useful common behaviors.  Implementors of metamodel-specific
 * environments are encourage to extend this class rather than implement
 * an evaluation environment "from scratch."
 *
 * @author Christian W. Damus (cdamus)
 */
public class BasicEvaluationEnvironment extends AbstractCustomizable implements EvaluationEnvironment.EvaluationEnvironmentExtension
{
	/**
	 * @since 1.1
	 */
	protected final @NonNull ExecutorInternal executor;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @Nullable EvaluationEnvironment parent;					// parent in environment hierarchy, null at root
	protected final @NonNull NamedElement executableObject;
	/**
	 * @since 1.3
	 */
	protected final @Nullable Object caller;
	/**
	 * @since 1.1
	 * @deprecated use caller
	 */
	@Deprecated
	protected final @Nullable OCLExpression callingObject;
	private final @NonNull Map<TypedElement, Object> variableValues = new HashMap<TypedElement, Object>();
	/** @deprecated use an executor */
	@Deprecated
	protected final @NonNull ModelManager modelManager;

	/** @deprecated use an executor */
	@Deprecated
	public BasicEvaluationEnvironment(@NonNull EnvironmentFactory environmentFactory, @NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		this(((EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension)environmentFactory).createExecutor(modelManager), executableObject);
	}

	/**
	 * @since 1.1
	 */
	public BasicEvaluationEnvironment(@NonNull ExecutorInternal executor, @NonNull NamedElement executableObject) {
		this.executor = executor;
		this.environmentFactory = executor.getEnvironmentFactory();
		this.parent = null;
		this.executableObject = executableObject;
		this.caller = null;
		this.callingObject = null;
		this.modelManager = executor.getModelManager();
	}

	/** @deprecated supply a callingObject */
	@Deprecated
	public BasicEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		this((EvaluationEnvironment.EvaluationEnvironmentExtension)parent, executableObject, null);
	}

	/**
	 * @since 1.3
	 */
	public BasicEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension parent, @NonNull NamedElement executableObject, @Nullable Object caller) {
		this.executor = parent.getExecutor();
		this.environmentFactory = parent.getEnvironmentFactory();
		this.parent = parent;
		this.executableObject = executableObject;
		this.caller = caller;
		this.callingObject = caller instanceof OCLExpression ? (OCLExpression)caller : null;
		this.modelManager = executor.getModelManager();
	}

	/**
	 * @since 1.1
	 * @deprecated use TypedElement argument.
	 */
	@Deprecated
	public BasicEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension parent, @NonNull NamedElement executableObject, @Nullable OCLExpression caller) {
		this(parent, executableObject, (TypedElement)caller);
	}

	/**
	 * Adds the supplied referredVariable and value binding to the environment
	 *
	 * @param referredVariable
	 *            the referredVariable to add
	 * @param value
	 *            the associated binding
	 */
	@Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
		if (variableValues.containsKey(referredVariable)) {
			Object oldValue = variableValues.get(referredVariable);
			if ((oldValue != value) && ((oldValue == null) || !oldValue.equals(value))) {
				String message = NLS.bind(
					PivotMessagesInternal.BindingExist_ERROR_,
					referredVariable,
					oldValue);
				throw new IllegalArgumentException(message);
			}
		}
		variableValues.put(referredVariable, value);
	}

	/**
	 * Clears the environment of variables.
	 */
	@Override
	public void clear() {
		variableValues.clear();
	}

	/**
	 * Dispose of any owned objects.
	 */
	@Override
	public void dispose() {}

	/**
	 * Implements the interface method by testing whether I am an instance of
	 * the requested adapter type.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> @Nullable T getAdapter(java.lang.Class<T> adapterType) {
		if (adapterType.isInstance(this)) {
			return (T) this;
		}
		return null;
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull NamedElement getExecutableObject() {
		return executableObject;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull ExecutorInternal getExecutor() {
		return executor;
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull ModelManager getModelManager() {
		return executor.getModelManager();
	}

	@Override
	public @Nullable EvaluationEnvironment getParent() {
		return parent;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public EvaluationEnvironment.@Nullable EvaluationEnvironmentExtension getParentEvaluationEnvironment() {
		return (EvaluationEnvironment.EvaluationEnvironmentExtension)parent;
	}

	@Override
	public <@Nullable T> T getValue(@NonNull Option<T> option) {
		@SuppressWarnings("unchecked")
		T result = (T) getOptions().get(option);

		if (result == null) {
			EvaluationEnvironment parent2 = parent;
			result = (parent2 != null) ? parent2.getValue(option) : option.getDefaultValue();
		}
		return result;
	}

	/**
	 * Returns the value associated with the supplied referredVariable
	 *
	 * @param referredVariable
	 *            the referredVariable whose value is to be returned
	 * @return the value associated with the referredVariable
	 */
	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
		Object object = variableValues.get(referredVariable);
		if (object == null) {
			if (!variableValues.containsKey(referredVariable)) {
				EvaluationEnvironment parent2 = parent;
				if (parent2 != null) {
					object = parent2.getValueOf(referredVariable);
				}
				else {
					throw new InvalidValueException("Undefined Variable " + referredVariable);
				}
			}
		}
		return object;
	}

	@Override
	public @NonNull Set<TypedElement> getVariables() {
		return variableValues.keySet();
	}

	/**
	 * Removes the supplied referredVariable and binding from the environment (if it exists)
	 * and returns it.
	 *
	 * @param referredVariable
	 *            the referredVariable to remove
	 * @return the value associated with the removed referredVariable
	 */
	@Override
	public @Nullable Object remove(@NonNull TypedElement referredVariable) {
		return variableValues.remove(referredVariable);
	}

	/**
	 * Replaces the current value of the supplied referredVariable with the supplied value.
	 *
	 * @param referredVariable
	 *            the referredVariable
	 * @param value
	 *            the new value
	 */
	@Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
		variableValues.put(referredVariable, value);
	}

	/**
	 * Returns a string representation of the bindings
	 */
	@Override
	public String toString() {
		return variableValues.toString();
	}
}
