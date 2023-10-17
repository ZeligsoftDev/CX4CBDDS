/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.IndentingLogger;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;

/**
 * @since 1.1
 */
public abstract class AbstractExecutor implements ExecutorInternal.ExecutorInternalExtension
{

	// This is the same as HashMap's default initial capacity
	private static final int DEFAULT_REGEX_CACHE_LIMIT = 16;

	// this is the same as HashMap's default load factor
	private static final float DEFAULT_REGEX_CACHE_LOAD_FACTOR = 0.75f;

	protected final EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory;
	/**
	 * @deprecated implement modelManager in derived class
	 */
	@Deprecated
	protected final ModelManager modelManager;
	private /*@LazyNonNull*/ EvaluationEnvironment.EvaluationEnvironmentExtension rootEvaluationEnvironment = null;
	private /*@LazyNonNull*/ EvaluationEnvironment.EvaluationEnvironmentExtension evaluationEnvironment = null;
	private /*@LazyNonNull*/ EvaluationVisitor.EvaluationVisitorExtension evaluationVisitor;
	/**
	 * @since 1.3
	 */
	protected final IdResolver.@NonNull IdResolverExtension idResolver;

	/**
	 * Lazily-created cache of reusable regex patterns to avoid
	 * repeatedly parsing the same regexes.
	 */
	private /*@LazyNonNull*/ Map<@NonNull String, @NonNull Pattern> regexPatterns = null;

	private EvaluationLogger logger = IndentingLogger.OUT;

	/**
	 * Lazily created cache of the results of cacheable operation call evaluations.
	 */
	private /*@LazyNonNull*/ EvaluationCache evaluationCache = null;

	/**
	 * Lazily created cache of the shadow objects.
	 */
	private /*@LazyNonNull*/ ShadowCache shadowCache = null;

	/**
	 * @since 1.7
	 */
	public static int CONSTRUCTION_COUNT = 0;

	protected AbstractExecutor(EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory) {
		CONSTRUCTION_COUNT++;
		this.environmentFactory = environmentFactory;
		this.modelManager = null;
		this.idResolver = (IdResolverExtension)environmentFactory.getIdResolver();
	//	System.out.println("Create " + NameUtil.debugSimpleName(this));
	}

	/**
	 * @deprecated implement modelManager in derived class
	 */
	@Deprecated
	protected AbstractExecutor(EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory, @NonNull ModelManager modelManager) {
		CONSTRUCTION_COUNT++;
		this.environmentFactory = environmentFactory;
		this.modelManager = modelManager;
		this.idResolver = (IdResolverExtension)environmentFactory.getIdResolver();
	}

	@Override
	public void add(@NonNull TypedElement referredVariable, @Nullable Object value) {
		evaluationEnvironment.add(referredVariable, value);
	}

	/**
	 * @since 1.3
	 */
	protected @NonNull EvaluationCache createEvaluationCache() {
		return new EvaluationCache(this);
	}

	protected EvaluationVisitor.@NonNull EvaluationVisitorExtension createEvaluationVisitor() {
		EvaluationVisitor.EvaluationVisitorExtension result = new BasicEvaluationVisitor(this);

		if (environmentFactory.isEvaluationTracingEnabled()) {
			// decorate the evaluation visitor with tracing support
			result = new TracingEvaluationVisitor(result);
		}

		return result;
	}

	/**
	 * Creates (on demand) the regular-expression matcher cache. The default
	 * implementation creates an access-ordered LRU cache with a limit of 16
	 * entries. Subclasses may override to create a map with whatever different
	 * performance characteristics may be required.
	 *
	 * @return the new regular-expression matcher cache
	 *
	 * @see #getRegexPattern(String)
	 */
	protected @NonNull Map<@NonNull String, @NonNull Pattern> createRegexCache() {
		return new java.util.LinkedHashMap<@NonNull String, @NonNull Pattern>(
				DEFAULT_REGEX_CACHE_LIMIT, DEFAULT_REGEX_CACHE_LOAD_FACTOR, true) {

			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(
					Map.Entry<@NonNull String, @NonNull Pattern> eldest) {
				return size() > DEFAULT_REGEX_CACHE_LIMIT;
			}
		};
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull ExecutorInternal basicGetInterpretedExecutor() {
		return this;
	}

	/**
	 * @since 1.3
	 */
	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		return new BasicEvaluationEnvironment(evaluationEnvironment, executableObject, caller);
	}

	/**
	 * @deprecated use Element argument
	 */
	@Deprecated
	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable OCLExpression callingObject) {
		return createNestedEvaluationEnvironment(evaluationEnvironment, executableObject, (TypedElement)callingObject);
	}

	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override
	public @NonNull Evaluator createNestedEvaluator() {
		return this;
	}

	protected EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new BasicEvaluationEnvironment(this, executableObject);
	}

	@Override
	public void dispose() {
		resetCaches();
	}

	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return evaluationVisitor.evaluate(body);
	}

//	@Override
//	protected void finalize() throws Throwable {
//		System.out.println("Finalize " + NameUtil.debugSimpleName(this));
//		super.finalize();
//	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object getCachedEvaluationResult(LibraryOperation.@NonNull LibraryOperationExtension2 implementation,
			@NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
		EvaluationCache evaluationCache2 = evaluationCache;
		if (evaluationCache2 == null) {
			evaluationCache2 = evaluationCache = createEvaluationCache();
		}
		return evaluationCache2.getCachedEvaluationResult(implementation, caller, sourceAndArgumentValues);
	}

	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return environmentFactory.getCompleteEnvironment();
	}

	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
		if (resultValue == null) {
			return Diagnostic.ERROR;
		}
		else if (resultValue instanceof InvalidValueException) {
			return Diagnostic.CANCEL;
		}
		else {
			return severityPreference;
		}
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @NonNull EvaluationCache getEvaluationCache() {
		EvaluationCache evaluationCache2 = evaluationCache;
		if (evaluationCache2 == null) {
			evaluationCache2 = evaluationCache = createEvaluationCache();
		}
		return evaluationCache2;
	}

	@Override
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return ClassUtil.nonNullState(evaluationEnvironment);
	}

	@Override
	public EvaluationVisitor.@NonNull EvaluationVisitorExtension getEvaluationVisitor() {
		EvaluationVisitor.EvaluationVisitorExtension evaluationVisitor2 = evaluationVisitor;
		if (evaluationVisitor2 == null) {
			evaluationVisitor = evaluationVisitor2 = createEvaluationVisitor();
		}
		return evaluationVisitor2;
	}

	//	@Override
	//	public @NonNull ExecutorInternal getExecutor() {
	//		return this;
	//	}

	@Override
	public IdResolver.@NonNull IdResolverExtension getIdResolver() {
		return idResolver;
	}

	@Override
	public @Nullable EvaluationLogger getLogger() {
		return logger;
	}

	@Override
	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	/**
	 * Return a cached matcher for a give regular expression.
	 */
	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		if (regexPatterns == null) {
			synchronized (this) {
				if (regexPatterns == null) {
					regexPatterns = createRegexCache();
				}
			}
		}
		synchronized (regexPatterns) {
			Pattern pattern = regexPatterns.get(regex);
			if (pattern == null) {
				//				System.out.println("Compile " + regex);
				pattern = Pattern.compile(regex);
				assert pattern != null;
				regexPatterns.put(regex, pattern);
			}
			//			else {
			//				System.out.println("Re-use " + regex);
			//			}
			return pattern;
		}
	}

	@Override
	public @NonNull EvaluationEnvironment getRootEvaluationEnvironment() {
		return ClassUtil.nonNullState(rootEvaluationEnvironment);
	}

	@Override
	public int getSeverity(@Nullable Object validationKey) {
		StatusCodes.Severity severity = environmentFactory.getSeverity(validationKey);
		return severity != null ? severity.getStatusCode() : StatusCodes.WARNING;
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	@Override
	@Deprecated /* @deprecated getStaticTypeOfValue to enable TemplateParameters to be resolved */
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value) {
		return idResolver.getStaticTypeOf(value);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @Nullable Object @NonNull ... values) {
		return idResolver.getStaticTypeOf(value, values);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return idResolver.getStaticTypeOf(value, values);
	}

	/**
	 * @since 1.7
	 */
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOfValue(@Nullable Type staticType, @Nullable Object value) {
		return idResolver.getStaticTypeOfValue(staticType, value);
	}

	@Override
	public @Nullable Object getValueOf(@NonNull TypedElement referredVariable) {
		return evaluationEnvironment.getValueOf(referredVariable);
	}

	@Override
	public @NonNull EvaluationEnvironment initializeEvaluationEnvironment(@NonNull NamedElement executableObject) {
		EvaluationEnvironment.EvaluationEnvironmentExtension rootEvaluationEnvironment = createRootEvaluationEnvironment(executableObject);
		setRootEvaluationEnvironment(rootEvaluationEnvironment);
		return rootEvaluationEnvironment;
	}

	@Override
	public @Nullable Object internalExecuteNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty, @Nullable Object sourceValue) {
		if (navigationCallExp.isIsSafe() && (sourceValue == null)) {
			return null;
		}
		MetamodelManagerInternal.MetamodelManagerInternalExtension metamodelManager = environmentFactory.getMetamodelManager();
		LibraryProperty.LibraryPropertyExtension implementation = (LibraryProperty.LibraryPropertyExtension)metamodelManager.getImplementation(navigationCallExp, sourceValue, referredProperty);
		try {
			return implementation.evaluate(this, navigationCallExp.getTypeId(), sourceValue);
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, referredProperty, sourceValue, navigationCallExp);
		}
		catch (AssertionError e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, referredProperty, sourceValue, navigationCallExp);
		}
	}

	/**
	 * @since 1.3
	 */
	@Override
	public Object internalExecuteOperationCallExp(@NonNull OperationCallExp operationCallExp, @Nullable Object @NonNull [] sourceAndArgumentValues) {
		Operation apparentOperation = operationCallExp.getReferredOperation();
		assert apparentOperation != null;
		//
		//	Resolve source type.
		//
		Type actualSourceType = null;
		if (!apparentOperation.isIsStatic()) {
			Type sourceType = operationCallExp.getOwnedSource().getType();
			actualSourceType = idResolver.getStaticTypeOfValue(sourceType, sourceAndArgumentValues[0]);
		}
		//
		//	Refine source type to common type of source and a first OclSelf argument.
		//
		List<Parameter> asParameters = apparentOperation.getOwnedParameters();
		if (asParameters.size() == 1) {
			Type parameterType = asParameters.get(0).getType();
			if ((parameterType instanceof SelfType) && (actualSourceType != null)) {
				Type actualArgType = idResolver.getStaticTypeOfValue(parameterType, sourceAndArgumentValues[1]);
				actualSourceType = actualSourceType.getCommonType(idResolver, actualArgType);
			}
		}
		//
		//	Resolve dynamic/actual operation and implementation
		//
		Operation actualOperation;
		org.eclipse.ocl.pivot.Class actualSourceClass = null;
		StandardLibraryInternal standardLibrary = environmentFactory.getStandardLibrary();
		if (actualSourceType != null) {
			actualSourceClass = actualSourceType.isClass();
			if (actualSourceClass == null)  {
				TemplateParameter templateParameter = actualSourceType.isTemplateParameter();
				if (templateParameter != null) {
					actualSourceClass = PivotUtil.getLowerBound(templateParameter, standardLibrary.getOclAnyType());
				}
			}
		}
		if (actualSourceClass != null) {
			actualOperation = actualSourceClass.lookupActualOperation(standardLibrary, apparentOperation);
		}
		else {
			actualOperation = apparentOperation;
		}
		LibraryOperation.LibraryOperationExtension2 implementation = (LibraryOperation.LibraryOperationExtension2) environmentFactory.getMetamodelManager().getImplementation(actualOperation);
		//
		//	Dispatch operation
		//
		try {
			Object result = implementation.evaluate(this, operationCallExp, sourceAndArgumentValues);
			assert !(result instanceof NullValue);
			return result;
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceAndArgumentValues[0]), operationCallExp);
		}
		catch (AssertionError e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceAndArgumentValues[0]), operationCallExp);
		}
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object internalExecuteShadowExp(@NonNull ShadowExp asShadowExp) {
		if (shadowCache == null) {
			shadowCache = new ShadowCache(this);
		}
		org.eclipse.ocl.pivot.Class asClass = ClassUtil.nonNullState(asShadowExp.getType());
		//		String value = asShadowExp.getValue();
		Object object;
		//		if (value == null) {
		List<ShadowPart> asShadowParts = asShadowExp.getOwnedParts();
		int iMax = asShadowParts.size();
		@Nullable Object @NonNull [] values = new @Nullable Object[iMax];
		for (int i = 0 ; i < iMax; i++) {
			ShadowPart asShadowPart = asShadowParts.get(i);
			assert asShadowPart != null;
			values[i] = asShadowPart;
		}
		Arrays.sort(values, new Comparator<@Nullable Object>()
		{
			@Override
			public int compare(@Nullable Object o1, @Nullable Object o2) {
				ShadowPart s1 = (ShadowPart)o1;
				ShadowPart s2 = (ShadowPart)o2;
				assert (s1 != null) && (s2 != null);
				Property p1 = s1.getReferredProperty();
				Property p2 = s2.getReferredProperty();
				String n1 = p1.getName();
				String n2 = p2.getName();
				return ClassUtil.safeCompareTo(n1, n2);
			}
		});
		@NonNull Property @NonNull [] asProperties = new @NonNull Property[iMax];
		for (int i = 0 ; i < iMax; i++) {
			ShadowPart asShadowPart = (ShadowPart) values[i];
			assert asShadowPart != null;
			Property asProperty = asShadowPart.getReferredProperty();
			assert asProperty != null;
			asProperties[i] = asProperty;
			Object boxedValue = null;
			OCLExpression initExpression = asShadowPart.getOwnedInit();
			if (initExpression != null) {
				boxedValue = getEvaluationVisitor().evaluate(initExpression);
			}
			values[i] = boxedValue;
		}
		if (asClass instanceof DataType) {
			object = asClass.createInstance(String.valueOf(values[0]));
		}
		else {
			object = shadowCache.getCachedShadowObject(asClass, asProperties, values);
		}
		//		}
		//		else {
		//			object = asClass.createInstance(value);
		//		}
		return object;
		//		return object != null ? ValueUtil.createObjectValue(type.getTypeId(), object) : null;
	}

	@Override
	public boolean isCanceled() {
		return evaluationVisitor.isCanceled();
	}

	@Override
	public void popEvaluationEnvironment() {
		evaluationEnvironment = ClassUtil.nonNullState(evaluationEnvironment.getParentEvaluationEnvironment());
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @NonNull EvaluationEnvironment pushEvaluationEnvironment(@NonNull NamedElement executableObject, @Nullable Object caller) {
		EvaluationEnvironment.EvaluationEnvironmentExtension evaluationEnvironment2 = ClassUtil.nonNullState(evaluationEnvironment);
		EvaluationEnvironment.EvaluationEnvironmentExtension nestedEvaluationEnvironment = createNestedEvaluationEnvironment(evaluationEnvironment2, executableObject, caller);
		evaluationEnvironment = nestedEvaluationEnvironment;
		return nestedEvaluationEnvironment;
	}

	/**
	 * @deprecated use TypedElement argument
	 */
	@Deprecated
	@Override
	public @NonNull EvaluationEnvironment pushEvaluationEnvironment(@NonNull NamedElement executableObject, @Nullable OCLExpression callingObject) {
		return pushEvaluationEnvironment(executableObject, (TypedElement)callingObject);
	}

	@Override
	public void replace(@NonNull TypedElement referredVariable, @Nullable Object value) {
		evaluationEnvironment.replace(referredVariable, value);
	}

	/**
	 * @since 1.3
	 */
	@Override
	public void resetCaches() {
		if (evaluationCache != null) {
			evaluationCache.dispose();
			evaluationCache = null;
		}
		if (shadowCache != null) {
			shadowCache.dispose();
			shadowCache = null;
		}
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		evaluationVisitor.setCanceled(isCanceled);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public void setInterpretedExecutor(@Nullable ExecutorInternal executorInternal) {
		throw new IllegalStateException("Interpreted executors do not nest");
	}

	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		this.logger = logger;
	}

	protected void setRootEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment) {
		assert this.rootEvaluationEnvironment == null;
		this.rootEvaluationEnvironment = evaluationEnvironment;
		this.evaluationEnvironment = evaluationEnvironment;
	}
}
