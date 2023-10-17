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

package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.library.EvaluatorMultipleIterationManager;
import org.eclipse.ocl.pivot.library.EvaluatorMultipleMapIterationManager;
import org.eclipse.ocl.pivot.library.EvaluatorSingleIterationManager;
import org.eclipse.ocl.pivot.library.EvaluatorSingleMapIterationManager;
import org.eclipse.ocl.pivot.library.LibraryBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.library.LibraryOperation.LibraryOperationExtension;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerRange;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * An evaluation visitor implementation for OCL expressions.
 * @since 1.1
 */
public class BasicEvaluationVisitor extends AbstractEvaluationVisitor
{
	public static boolean isSimpleRange(@NonNull CollectionLiteralExp cl) {
		List<CollectionLiteralPart> partsList = cl.getOwnedParts();
		int size = partsList.size();
		if (size == 1) {
			CollectionLiteralPart part = partsList.get(0);
			return part instanceof CollectionRange;
		}
		return false;
	}

	/**
	 * Constructor
	 *
	 * @param evalEnv
	 *            an evaluation environment (map of variable names to values)
	 */
	public BasicEvaluationVisitor(@NonNull ExecutorInternal executor) {
		super(executor);
	}

	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return this;
	}

	/** @deprecated Evaluator no longer nest and so no longer dispose */
	@Deprecated
	@Override
	public void dispose() {}

	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		Object value = ((Element) body).accept(undecoratedVisitor);
		assert ValueUtil.isBoxed(value);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
		return value;
	}

	/** @deprecated No longer used */
	@Deprecated
	public @NonNull LibraryFeature lookupImplementation(org.eclipse.ocl.pivot.@NonNull Class dynamicType, @NonNull Operation staticOperation) {
		CompleteInheritance inheritance = environmentFactory.getMetamodelManager().getInheritance(dynamicType);
		return inheritance.getPivotClass().lookupImplementation(standardLibrary, staticOperation);
	}

	@Override
	public Object safeVisit(@Nullable Visitable v) {
		if (v == null) {
			throw new InvalidValueException("null expression");
		}
		try {
			Executor executor = ThreadLocalExecutor.basicGetExecutor();
			ExecutorInternal interpretedExecutor = executor != null? executor.basicGetInterpretedExecutor() :  null;
			assert context == interpretedExecutor : "ThreadLocalExecutor's executor must be configured to support EMF API.";
			Object result = v.accept(undecoratedVisitor);
			assert ValueUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			return result;
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		} catch (AssertionError e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		}
	}


	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 *
	@Override
    public Object visitAssociationClassCallExp(@NonNull AssociationClassCallExp ae) {
		Object context = ae.getOwnedSource().accept(undecoratedVisitor);

//		if ((context == null) || ValuesUtil.isUndefined(context)) {
//			return evaluationEnvironment.throwInvalidEvaluation("Undefined context for AssociationClassCall", ae);
//		}
//		context = ValuesUtil.asValidValue(context);
		// evaluate attribute on source value
		return evaluationEnvironment.navigateAssociationClass(
			ae.getReferredAssociationClass(),
			ae.getNavigationSource(),
			context);
	} */

	/**
	 * Callback for a BooleanLiteralExp visit.
	 *
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp booleanLiteralExp) {
		boolean value = booleanLiteralExp.isBooleanSymbol();
		return value;
	}

	@Override
	public Object visitCollectionItem(@NonNull CollectionItem item) {
		throw new UnsupportedOperationException("evaluation of CollectionItem"); //$NON-NLS-1$
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		List<CollectionLiteralPart> parts = cl.getOwnedParts();
		CollectionType type = (CollectionType) cl.getType();
		boolean isOrdered = type.isOrdered();
		if (isOrdered && isSimpleRange(cl)) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OCLExpression first = collRange.getOwnedFirst();
			OCLExpression last = collRange.getOwnedLast();
			Object firstVal = first.accept(undecoratedVisitor);
			Object lastVal = last.accept(undecoratedVisitor);
			IntegerValue firstInteger = ValueUtil.asIntegerValue(firstVal);
			IntegerValue lastInteger = ValueUtil.asIntegerValue(lastVal);
			// construct a lazy integer list for the range
			CollectionTypeId typeId = type.getTypeId();
			IntegerRange range = ValueUtil.createRange(firstInteger, lastInteger);
			if (type.isUnique()) {
				return ValueUtil.createOrderedSetRange(typeId, range);
			}
			else {
				return ValueUtil.createSequenceRange(typeId, range);
			}
		} else
		{
			List<Object> orderedResults = new ArrayList<Object>();
			Set<Object> uniqueResults = type.isUnique() ? new HashSet<Object>() : null;
			// not a sequence or not a simple range
			for (CollectionLiteralPart part : parts) {
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OCLExpression itemExp = item.getOwnedItem();
					Object itemVal = itemExp.accept(undecoratedVisitor);
					//					Object itemValue = ValuesUtil.asValidValue(itemVal);
					if ((uniqueResults == null) || uniqueResults.add(itemVal)) {
						orderedResults.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OCLExpression first = range.getOwnedFirst();
					OCLExpression last = range.getOwnedLast();

					Object firstVal = first.accept(undecoratedVisitor);
					Object lastVal = last.accept(undecoratedVisitor);
					IntegerValue firstInteger = ValueUtil.asIntegerValue(firstVal);
					IntegerValue lastInteger = ValueUtil.asIntegerValue(lastVal);
					Integer firstInt = firstInteger.asInteger();
					Integer lastInt = lastInteger.asInteger();
					// TODO: enhance IntegerRangeList to support multiple ranges
					// add values between first and last inclusive
					if (firstInt <= lastInt) {
						for (int i = firstInt; true; i++) {
							IntegerValue integerValue = ValueUtil.integerValueOf(i);
							if ((uniqueResults == null) || uniqueResults.add(integerValue)) {
								orderedResults.add(integerValue);
							}
							if (i >= lastInt) {
								break;
							}
						}
					}
				} // end of collection range

			} // end of parts iterator
			return idResolver.createCollectionOfAll(type.isOrdered(), type.isUnique(), ClassUtil.nonNullModel(type.getElementType()).getTypeId(), orderedResults);
		} // end of not-simple range case
	} // end of Set, OrderedSet, Bag Literals

	@Override
	public Object visitCollectionRange(@NonNull CollectionRange range) {
		throw new UnsupportedOperationException("evaluation of CollectionRange"); //$NON-NLS-1$
	}

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 *
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp el) {
		EnumerationLiteral enumLiteral = el.getReferredLiteral();
		assert enumLiteral != null;
		return enumLiteral.getEnumerationLiteralId();
	}

	//	private static int depth = 0;
	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		if (isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		//		Object object = getEvaluationEnvironment().getValueOf(expression.getContextVariable());
		//		System.out.println(++depth + " " + expression.getContextVariable() + " = " + object + "\n\t" + expression);
		//		try {
		Object result = safeVisit(expression.getOwnedBody());
		//			System.out.println(depth + "\t=> " + result);
		return result;
		//		}
		//		catch (RuntimeException e) {
		//			System.out.println(depth + "\t=> " + e);
		//			throw e;
		//		}
		//		finally {
		//			--depth;
		//		}
	}

	/**
	 * Callback for an IfExp visit.
	 */
	@Override
	public Object visitIfExp(@NonNull IfExp ifExp) {
		OCLExpression condition = ifExp.getOwnedCondition();
		Object acceptedValue = condition.accept(undecoratedVisitor);
		Object evaluatedCondition = ValueUtil.asBoolean(acceptedValue);
		OCLExpression expression = null;
		if (evaluatedCondition == ValueUtil.TRUE_VALUE) {
			expression = ifExp.getOwnedThen();
		}
		else {
			expression = ifExp.getOwnedElse();
		}
		return expression.accept(undecoratedVisitor);
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 *
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp integerLiteralExp) {
		Number integerSymbol = integerLiteralExp.getIntegerSymbol();
		return integerSymbol != null ? ValueUtil.integerValueOf(integerSymbol) : null;
	}

	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp invalidLiteralExp) {
		throw ValueUtil.INVALID_VALUE;
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
	public Object visitIterateExp(@NonNull IterateExp iterateExp) {
		if (isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		Iteration staticIteration = ClassUtil.nonNullModel(iterateExp.getReferredIteration());
		OCLExpression source = iterateExp.getOwnedSource();
		Object acceptedValue = source.accept(undecoratedVisitor);
		IterableValue sourceValue = ValueUtil.asIterableValue(acceptedValue);
		if (iterateExp.isIsSafe()) {
			if (sourceValue instanceof MapValue) {
				throw new InvalidValueException(PivotMessages.MapValueForbidden);
			}
			sourceValue = sourceValue.excluding(null);
		}
		org.eclipse.ocl.pivot.Class dynamicSourceType = idResolver.getClass(sourceValue.getTypeId(), null);
		LibraryIteration implementation = (LibraryIteration) dynamicSourceType.lookupImplementation(standardLibrary, staticIteration);
		/*		Operation dynamicIteration = metamodelManager.getDynamicOperation((org.eclipse.ocl.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation1;
		try {
			implementation = (LibraryIteration) metamodelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Object result = null;
		try {
			Variable accumulator = iterateExp.getOwnedResult();
			Object initValue = accumulator.getOwnedInit().accept(undecoratedVisitor);
			//			if ((initValue == null) || ValuesUtil.isUndefined(initValue)) {
			//				return evaluationEnvironment.throwInvalidEvaluation(null, iterateExp, initValue, EvaluatorMessages.UndefinedInitializer);
			//			}
			//			initValue = ValuesUtil.asValidValue(initValue);
			IterationManager iterationManager;
			VariableDeclaration accumulatorVariable = accumulator;
			OCLExpression body = ClassUtil.nonNullModel(iterateExp.getOwnedBody());
			List<@NonNull Variable> iterators = PivotUtilInternal.getOwnedIteratorsList(iterateExp);
			int iSize = iterators.size();
			if (sourceValue instanceof MapValue) {
				List<IteratorVariable> coIterators = iterateExp.getOwnedCoIterators();
				if (iSize == 1) {
					VariableDeclaration keyIterator = ClassUtil.nonNullModel(iterators.get(0));
					VariableDeclaration valueIterator = coIterators.size() >= 1 ? coIterators.get(0) : null;
					iterationManager = new EvaluatorSingleMapIterationManager(context, iterateExp, body, (MapValue)sourceValue, accumulatorVariable, initValue, keyIterator, valueIterator);

				}
				else {
					@NonNull VariableDeclaration[] keyIterators = new @NonNull VariableDeclaration[iSize];
					@Nullable VariableDeclaration[] valueIterators = new @Nullable VariableDeclaration[iSize];
					for (int i = 0; i < iSize; i++) {
						keyIterators[i] = iterators.get(i);
						valueIterators[i] = i < coIterators.size() ? coIterators.get(i) : null;
					}
					iterationManager = new EvaluatorMultipleMapIterationManager(context, iterateExp, body, (MapValue)sourceValue, accumulatorVariable, initValue, keyIterators, valueIterators);
				}
			}
			else {
				if (iSize == 1) {
					VariableDeclaration firstIterator = ClassUtil.nonNullModel(iterators.get(0));
					iterationManager = new EvaluatorSingleIterationManager(context, iterateExp, body, (CollectionValue)sourceValue, accumulatorVariable, initValue, firstIterator, null);
				}
				else {
					VariableDeclaration[] variables = new VariableDeclaration[iSize];
					for (int i = 0; i < iSize; i++) {
						variables[i] = iterators.get(i);
					}
					iterationManager = new EvaluatorMultipleIterationManager(context, iterateExp, body, (CollectionValue)sourceValue, accumulatorVariable, initValue, variables);
				}
			}
			result = implementation.evaluateIteration(iterationManager);
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, StringUtil.bind(PivotMessagesInternal.FailedToEvaluate_ERROR_, staticIteration, sourceValue, iterateExp));	// FIXME dymamicIteration throughout
		}
		catch (AssertionError e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, StringUtil.bind(PivotMessagesInternal.FailedToEvaluate_ERROR_, staticIteration, sourceValue, iterateExp));	// FIXME dymamicIteration throughout
		}
		return result;
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
	public Object visitIteratorExp(@NonNull IteratorExp iteratorExp) {
		if (isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		Iteration staticIteration = ClassUtil.nonNullModel(iteratorExp.getReferredIteration());
		IterableValue sourceValue;
		//		try {
		OCLExpression source = iteratorExp.getOwnedSource();
		Object sourceVal = source.accept(undecoratedVisitor);
		//			if (sourceVal == null) {
		//				return evaluationEnvironment.throwInvalidEvaluation("null iterator source");
		//			}
		sourceValue = ValueUtil.asIterableValue(sourceVal);
		if (iteratorExp.isIsSafe()) {
			if (sourceValue instanceof MapValue) {
				throw new InvalidValueException(PivotMessages.MapValueForbidden);
			}
			sourceValue = sourceValue.excluding(null);
		}
		//		} catch (InvalidValueException e) {
		//			return evaluationEnvironment.throwInvalidEvaluation(e);
		//		}
		org.eclipse.ocl.pivot.Class dynamicSourceType = idResolver.getClass(sourceValue.getTypeId(), null);
		LibraryIteration.LibraryIterationExtension implementation = (LibraryIteration.LibraryIterationExtension) dynamicSourceType.lookupImplementation(standardLibrary, staticIteration);
		/*		Operation dynamicIteration = metamodelManager.getDynamicOperation((org.eclipse.ocl.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation;
		try {
			implementation = (LibraryIteration) metamodelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Object result = null;
		try {
			IterationManager iterationManager;
			OCLExpression body = PivotUtil.getOwnedBody(iteratorExp);
			Type iterationType = PivotUtil.getType(iteratorExp);//.behavioralType();
			Type bodyType = PivotUtil.getType(body);//.behavioralType();
			Object accumulatorValue = implementation.createAccumulatorValue(context, iterationType.getTypeId(), bodyType.getTypeId());
			List<@NonNull Variable> iterators = PivotUtilInternal.getOwnedIteratorsList(iteratorExp);
			int iSize = iterators.size();
			List<IteratorVariable> coIterators = iteratorExp.getOwnedCoIterators();
			int coSize = coIterators.size();
			if (sourceValue instanceof MapValue) {
				if (iSize == 1) {
					VariableDeclaration keyIterator = ClassUtil.nonNullModel(iterators.get(0));
					VariableDeclaration valueIterator = coIterators.size() >= 1 ? coIterators.get(0) : null;
					iterationManager = new EvaluatorSingleMapIterationManager(context, iteratorExp, body, (MapValue)sourceValue, null, accumulatorValue, keyIterator, valueIterator);

				}
				else {
					@NonNull VariableDeclaration[] keyIterators = new @NonNull VariableDeclaration[iSize];
					@Nullable VariableDeclaration[] valueIterators = new @Nullable VariableDeclaration[iSize];
					for (int i = 0; i < iSize; i++) {
						keyIterators[i] = iterators.get(i);
						valueIterators[i] = i < coIterators.size() ? coIterators.get(i) : null;
					}
					iterationManager = new EvaluatorMultipleMapIterationManager(context, iteratorExp, body, (MapValue)sourceValue, null, accumulatorValue, keyIterators, valueIterators);
				}
			}
			else {
				if (iSize == 1) {
					VariableDeclaration firstIterator = ClassUtil.nonNullModel(iterators.get(0));
					VariableDeclaration indexIterator = coIterators.size() >= 1 ? coIterators.get(0) : null;
					iterationManager = new EvaluatorSingleIterationManager(context, iteratorExp, body, (CollectionValue)sourceValue, null, accumulatorValue, firstIterator, indexIterator);
				}
				else {
					@NonNull VariableDeclaration[] variables = new @NonNull VariableDeclaration[iSize];
					@Nullable VariableDeclaration[] coVariables = new @Nullable VariableDeclaration[iSize];
					for (int i = 0; i < iSize; i++) {
						variables[i] = iterators.get(i);
						coVariables[i] = i < coSize ? coIterators.get(i) : null;
					}
					iterationManager = new EvaluatorMultipleIterationManager(context, iteratorExp, body, (CollectionValue)sourceValue, null, accumulatorValue, variables, coVariables);
				}
			}
			result = implementation.evaluateIteration(iterationManager);
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, staticIteration, sourceValue, iteratorExp);
		}
		catch (AssertionError e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, staticIteration, sourceValue, iteratorExp);
		}
		return result;
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
	public Object visitLetExp(@NonNull LetExp letExp) {
		OCLExpression expression = letExp.getOwnedIn();		// Never null when valid
		Variable variable = letExp.getOwnedVariable();		// Never null when valid
		assert variable != null;
		Object value;
		try {
			value = variable.accept(undecoratedVisitor);
		}
		catch (EvaluationHaltedException e) {
			throw e;
		}
		catch (InvalidValueException e) {
			value = e;
		}
		//		value = ValuesUtil.asValue(value);
		assert expression != null;
		EvaluationEnvironment nestedEvaluationEnvironment = context.pushEvaluationEnvironment(expression, (TypedElement)letExp);
		nestedEvaluationEnvironment.add(variable, value);
		try {
			return expression.accept(undecoratedVisitor);
		}
		finally {
			context.popEvaluationEnvironment();
			//			nestedVisitor.dispose();
		}
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
	public Object visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		List<MapLiteralPart> parts = mapLiteralExp.getOwnedParts();
		MapType type = (MapType) PivotUtil.getType(mapLiteralExp);
		Map<Object, Object> mapEntries = new HashMap<Object, Object>();
		for (MapLiteralPart part : parts) {
			OCLExpression key = part.getOwnedKey();
			OCLExpression value = part.getOwnedValue();
			Object keyVal = key.accept(undecoratedVisitor);
			Object valueVal = value.accept(undecoratedVisitor);
			mapEntries.put(keyVal, valueVal);
		}
		return idResolver.createMapOfAll((MapTypeId)type.getTypeId(), mapEntries);
	}

	@Override
	public Object visitMessageExp(@NonNull MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
		/*        T targetResult = safeVisit(messageExp.getTarget());
        List<T> argumentResults;
        List<OCLExpression> arguments = messageExp.getArgument();
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OCLExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }
        return handleMessageExp(messageExp, targetResult, argumentResults);
		 */	}

	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return null;
	}

	/**
	 * Callback for an OperationCallExp visit.
	 */
	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		if (isCanceled()) {
			throw new EvaluationHaltedException("Canceled");
		}
		Operation apparentOperation = operationCallExp.getReferredOperation();
		assert apparentOperation != null;
		boolean isValidating = apparentOperation.isIsValidating();
		//
		//	Resolve source value catching invalid values for validating operations.
		//
		OCLExpression source = operationCallExp.getOwnedSource();
		Object sourceValue;
		if (source == null) {							// Static functions may have null source
			sourceValue = null;
		}
		else if (!isValidating) {
			sourceValue = source.accept(undecoratedVisitor);
		}
		else {
			try {
				sourceValue = source.accept(undecoratedVisitor);
				assert ValueUtil.isBoxed(sourceValue);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			}
			catch (EvaluationHaltedException e) {
				throw e;
			}
			catch (InvalidValueException e) {
				sourceValue = e;	// FIXME ?? propagate part of environment
			}
		}
		//
		//	Safe navigation of null source return null.
		//
		if (operationCallExp.isIsSafe()) {
			if (sourceValue == null) {
				return null;
			}
			if (sourceValue instanceof MapValue) {
				throw new InvalidValueException(PivotMessages.MapValueForbidden);
			}
			if (sourceValue instanceof CollectionValue) {
				sourceValue = ((CollectionValue)sourceValue).excluding(null);
			}
		}
		Operation actualOperation;
		if (apparentOperation.isIsStatic()) {
			actualOperation = apparentOperation;
		}
		else {
			assert source != null;
			org.eclipse.ocl.pivot.Class actualSourceType = idResolver.getStaticTypeOfValue(source.getType(), sourceValue);
			List<Parameter> ownedParameters = apparentOperation.getOwnedParameters();
			if (ownedParameters.size() == 1) {
				Parameter onlyParameter = ownedParameters.get(0);
				Type onlyType = onlyParameter.getType();
				if (onlyType == standardLibrary.getOclSelfType()) {
					List<@NonNull OCLExpression> arguments = ClassUtil.nullFree(operationCallExp.getOwnedArguments());
					Object onlyArgument = arguments.get(0).accept(undecoratedVisitor);
					org.eclipse.ocl.pivot.Class actualArgType = idResolver.getStaticTypeOfValue(onlyType, onlyArgument);
					actualSourceType = (org.eclipse.ocl.pivot.Class)actualSourceType.getCommonType(idResolver, actualArgType);
					// FIXME direct evaluate using second argument
					actualOperation = actualSourceType.lookupActualOperation(standardLibrary, apparentOperation);
					LibraryBinaryOperation.LibraryBinaryOperationExtension implementation = (LibraryBinaryOperation.LibraryBinaryOperationExtension) environmentFactory.getMetamodelManager().getImplementation(actualOperation);
					try {
						Object result = implementation.evaluate(context, operationCallExp.getTypeId(), sourceValue, onlyArgument);
						assert !(result instanceof NullValue);
						return result;
					}
					catch (InvalidValueException e) {
						throw e;
					}
					catch (Exception e) {
						// This is a backstop. Library operations should catch their own exceptions
						//  and produce a better reason as a result.
						throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceValue), operationCallExp);
					}
					catch (AssertionError e) {
						// This is a backstop. Library operations should catch their own exceptions
						//  and produce a better reason as a result.
						throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceValue), operationCallExp);
					}
				}
			}
			actualOperation = actualSourceType.lookupActualOperation(standardLibrary, apparentOperation);
		}
		LibraryOperation.LibraryOperationExtension implementation = (LibraryOperationExtension) environmentFactory.getMetamodelManager().getImplementation(actualOperation);
		try {
			Object result = implementation.dispatch(context, operationCallExp, sourceValue);
			assert !(result instanceof NullValue);
			return result;
		}
		catch (InvalidValueException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceValue), operationCallExp);
		}
		catch (AssertionError e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, apparentOperation, ILabelGenerator.Registry.INSTANCE.labelFor(sourceValue), operationCallExp);
		}
	}

	/**
	 * Callback for an OppositePropertyCallExp visit.
	 */
	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		Property oppositeReferredProperty = oppositePropertyCallExp.getReferredProperty();
		Property referredProperty = oppositeReferredProperty.getOpposite();
		//		assert referredProperty != null;
		//		return evaluatePropertyCallExp(oppositePropertyCallExp, referredProperty);
		if (referredProperty != null) {
			OCLExpression source = oppositePropertyCallExp.getOwnedSource();
			if (source != null) {
				Object sourceValue = source.accept(undecoratedVisitor);
				if (sourceValue != null) {
					return context.internalExecuteNavigationCallExp(oppositePropertyCallExp, referredProperty, sourceValue);
				}
			}
		}
		return null;
	}

	/**
	 * Callback for a PropertyCallExp visit.
	 */
	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp propertyCallExp) {
		Property referredProperty = propertyCallExp.getReferredProperty();
		//		assert referredProperty != null;
		//		return evaluatePropertyCallExp(propertyCallExp, referredProperty);
		if (referredProperty != null) {
			OCLExpression source = propertyCallExp.getOwnedSource();
			if (source != null) {
				Object sourceValue = source.accept(undecoratedVisitor);
				return context.internalExecuteNavigationCallExp(propertyCallExp, referredProperty, sourceValue);
			}
		}
		return null;
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 *
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp realLiteralExp) {
		Number realSymbol = realLiteralExp.getRealSymbol();
		return realSymbol != null ? ValueUtil.realValueOf(realSymbol) : null;
	}

	@Override
	public Object visitShadowExp(@NonNull ShadowExp ce) {
		return context.internalExecuteShadowExp(ce);
	}

	@Override
	public Object visitStateExp(@NonNull StateExp s) {
		return s.getReferredState();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 *
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp stringLiteralExp) {
		String value = stringLiteralExp.getStringSymbol();
		if (value == null) {
			throw new InvalidValueException("Invalid String Value", stringLiteralExp);
		}
		return value;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 *
	 * @param tl
	 *            tuple literal expression
	 * @return String
	 */
	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp tl) {
		Type type = ClassUtil.nonNullModel(tl.getType());
		Map<@NonNull TuplePartId, @Nullable Object> propertyValues = new HashMap<@NonNull TuplePartId, @Nullable Object>();
		for (@NonNull TupleLiteralPart part : ClassUtil.nullFree(tl.getOwnedParts())) {
			// Set the tuple field with the value of the init expression
			propertyValues.put(ClassUtil.nonNull(part.getPartId()), part.accept(undecoratedVisitor));
		}
		//		TupleType tupleType = metamodelManager.getTupleType(type.getName(), propertyValues.keySet());
		return ValueUtil.createTupleValue(((TupleType) type).getTupleTypeId(), propertyValues);
	}

	@Override
	public Object visitTupleLiteralPart(@NonNull TupleLiteralPart tp) {
		return tp.getOwnedInit().accept(undecoratedVisitor);
	}

	/**
	 * Callback for a TypeExp visit.
	 */
	@Override
	public Object visitTypeExp(@NonNull TypeExp t) {
		return t.getReferredType();
	}

	/**
	 * Callback for an UnlimitedNaturalLiteralExp visit.
	 *
	 * @return the value of the natural literal as a java.lang.Integer.
	 */
	@Override
	public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp) {
		Number unlimitedNaturalSymbol = unlimitedNaturalLiteralExp.getUnlimitedNaturalSymbol();
		if (unlimitedNaturalSymbol == null) {
			return null;
		}
		if (unlimitedNaturalSymbol instanceof Unlimited) {
			return ValueUtil.UNLIMITED_VALUE;
		}
		if (unlimitedNaturalSymbol instanceof UnlimitedNaturalValue) {
			return unlimitedNaturalSymbol;
		}
		IntegerValue integerValue = ValueUtil.integerValueOf(unlimitedNaturalSymbol);
		if (integerValue.signum() < 0) {
			if (integerValue == ValueUtil.integerValueOf(-1)) {
				return ValueUtil.UNLIMITED_VALUE;
			}
		}
		return integerValue.asUnlimitedNaturalValue();
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	@Override
	public Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for a Variable visit.
	 */
	@Override
	public Object visitVariable(@NonNull Variable variable) {
		// return the initial (only) value
		OCLExpression initExp = variable.getOwnedInit();
		if (initExp == null) {
			throw new InvalidValueException("Uninitialized variable", variable);
		}
		else {
			return initExp.accept(undecoratedVisitor);
		}
	}

	/**
	 * Callback for a VariableExp visit.
	 *
	 * @param variableExp
	 *            the variable expression
	 * @return the value of the variable
	 */
	@Override
	public Object visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration variableDeclaration = variableExp.getReferredVariable();
		if (variableDeclaration == null) {
			throw new InvalidValueException("Undefined variable", null, null, variableExp);
		}
		Object value = context.getValueOf(variableDeclaration);
		if (value instanceof InvalidValueException) {
			throw (InvalidValueException)value;
		}
		else {
			return value;
		}
	}

	@Override
	public Object visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}
}
