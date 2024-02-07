/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal.MetamodelManagerInternalExtension2;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotFlowAnalysisDeducerFromFalseVisitor;
import org.eclipse.ocl.pivot.utilities.PivotFlowAnalysisDeducerFromNullVisitor;
import org.eclipse.ocl.pivot.utilities.PivotFlowAnalysisDeducerFromTrueVisitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * The (static) FlowAnalysis of some context OCLExpression exploits the hierarchy of the encompassing AS expression to
 * identify expressions that are necessarily true/false when the context expression evaluates. For instance if the
 * context expression is at or below the elseExpression of some IfExp, then the conditionExpression of the IfExp is
 * necessarily true. Given a set of known true/false expressions, reverse evaluation of certain expressions allows
 * deduction that certain variables are null/not-null. This is then used to improve the precision of null safety guards.
 *
 * e.g. in "let x : Integer = ... in x <> null implies x.toString()" we do not want to diagnose that "x.toString()" is unsafe.
 *
 * An optimum implementation of this class might perform some very powerful/slow symbolic analyses. The current implementation
 * has useful but incomplete understanding of comparisons and Boolean operations. It lacks deep traversal of variables.

 * @since 1.3
 */
public class FlowAnalysis
{
	/**
	 * A deducer performs a reverse evaluation of an expression whose result is known and defined by the derived class.
	 * Each term is visited returning true/false/null according to whether the term
	 * confirms or contradicts or is unconstrained by the required result.
	 */
	protected static abstract class AbstractDeducer extends AbstractExtendingVisitor<@Nullable Boolean, @NonNull FlowAnalysis>
	{
		private @NonNull List<@NonNull OCLExpression> toBeDeduced = new ArrayList<>();
		private int alreadyDeducedIndex = 0;

		public AbstractDeducer(@NonNull FlowAnalysis flowAnalysis) {
			super(flowAnalysis);
		}

		public void addToBeDeduced(@NonNull OCLExpression object) {
			if (!toBeDeduced.contains(object)) {
				toBeDeduced.add(object);
			}
		}

		public boolean deduceNext() {
			if (alreadyDeducedIndex >= toBeDeduced.size()) {
				return false;
			}
			OCLExpression asExpression = toBeDeduced.get(alreadyDeducedIndex++);
			asExpression.accept(this);
			return true;
		}

		/**
		 * Return true if asExpression is-non-null using the prevailing state of the analysis - avoiding a potentially
		 * infinite recursion of nested analyses.
		 */
		protected boolean isAlreadyNonNull(@NonNull OCLExpression asExpression) {
			if (asExpression.isIsRequired()) {
				return true;
			}
			if (asExpression instanceof VariableExp) {
				VariableDeclaration referredVariable = PivotUtil.getReferredVariable((VariableExp)asExpression);
				Boolean nullOrNonNull = context.getVariable(referredVariable);
				return nullOrNonNull == Boolean.FALSE;
			}
			if (asExpression instanceof CallExp) {
				Boolean nullOrNonNull = context.getCallPath(asExpression);
				return nullOrNonNull == Boolean.FALSE;
			}
			return false;
		}

		/**
		 * Return true if asExpression is-null using the prevailing state of the analysis - avoiding a potentially
		 * infinite recursion of nested analyses.
		 */
		protected boolean isAlreadyNull(@NonNull OCLExpression asExpression) {
			if (asExpression instanceof NullLiteralExp) {
				return true;
			}
			if (asExpression instanceof VariableExp) {
				VariableDeclaration referredVariable = PivotUtil.getReferredVariable((VariableExp)asExpression);
				Boolean nullOrNonNull = context.getVariable(referredVariable);
				return nullOrNonNull == Boolean.TRUE;
			}
			if (asExpression instanceof CallExp) {
				Boolean nullOrNonNull = context.getCallPath(asExpression);
				return nullOrNonNull == Boolean.TRUE;
			}
			return false;
		}

		@Override
		public @Nullable Boolean visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @Nullable Boolean visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
			return null;
		}

		@Override
		public @Nullable Boolean visitNullLiteralExp(@NonNull NullLiteralExp object) {
			return null;
		}

		@Override
		public @Nullable Boolean visitOCLExpression(@NonNull OCLExpression object) {
			return null;
		}
	}

	protected static class CallPath
	{
		/**
		 * Return the non-null hashcode of an expression call-path, or null for an unsupported expression term.
		 */
		public static Integer computeHashCode(@NonNull OCLExpression object) {
			int hashCode = 1;
			for (OCLExpression pathExp = object; pathExp != null; pathExp = pathExp instanceof CallExp ? ((CallExp)pathExp).getOwnedSource() : null) {
				if (pathExp instanceof VariableExp) {
					VariableDeclaration variable = PivotUtil.getReferredVariable((VariableExp)pathExp);
					hashCode = 3 * hashCode + variable.hashCode();
					return hashCode;
				}
				else if (pathExp instanceof NavigationCallExp) {
					Property property = PivotUtil.getReferredProperty((NavigationCallExp)pathExp);
					hashCode = 3 * hashCode + property.hashCode();
				}
				else if (pathExp instanceof OperationCallExp) {
					Operation operation = PivotUtil.getReferredOperation((OperationCallExp)pathExp);
					hashCode = 3 * hashCode + operation.hashCode();
					// arguments ignored, so must be distinguished during hashline collision resolution
				}
				else {
					break;
				}
			}
			return null;
		}

		private final @NonNull List<@NonNull OCLExpression> callPath;
		private final boolean nullOrNonNull;

		protected CallPath(@NonNull List<@NonNull OCLExpression> callPath, boolean nullOrNonNull) {
			this.callPath = callPath;
			this.nullOrNonNull = nullOrNonNull;
		}

		protected boolean getNullOrNonNull() {
			return nullOrNonNull;
		}

		protected boolean isSamePathAs(@NonNull OCLExpression candidateObject) {
			int pathIndex = 0;
			Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration> firstVariable2secondVariable = new HashMap<>();
			for (OCLExpression candidateElement = candidateObject; candidateElement != null; candidateElement = candidateElement instanceof CallExp ? ((CallExp)candidateElement).getOwnedSource() : null) {
				if (pathIndex >= callPath.size()) {
					return false;
				}
				OCLExpression pathElement = callPath.get(pathIndex++);
				if (!isSameTerm(candidateElement, pathElement, firstVariable2secondVariable)) {
					return false;
				}
			}
			return true;
		}

		protected boolean isSameTerm(@NonNull OCLExpression firstExpression, @NonNull OCLExpression secondExpression,
				@NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration> firstVariable2secondVariable) {
			if (firstExpression instanceof BooleanLiteralExp) {
				if (!(secondExpression instanceof BooleanLiteralExp)) {
					return false;
				}
				if (((BooleanLiteralExp)firstExpression).isBooleanSymbol()
						!= ((BooleanLiteralExp)secondExpression).isBooleanSymbol()) {
					return false;
				}
			}
			else if (firstExpression instanceof CollectionLiteralExp) {
				if (!(secondExpression instanceof CollectionLiteralExp)) {
					return false;
				}
				CollectionLiteralExp firstCollectionLiteralExp = (CollectionLiteralExp)firstExpression;
				CollectionLiteralExp secondCollectionLiteralExp = (CollectionLiteralExp)secondExpression;
				if (firstCollectionLiteralExp.getKind() != secondCollectionLiteralExp.getKind()) {
					return false;
				}
				List<@NonNull CollectionLiteralPart> firstParts = PivotUtilInternal.getOwnedPartsList(firstCollectionLiteralExp);
				List<@NonNull CollectionLiteralPart> secondParts = PivotUtilInternal.getOwnedPartsList(secondCollectionLiteralExp);
				int iSize = firstParts.size();
				if (iSize != secondParts.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					CollectionLiteralPart firstCollectionLiteralPart = firstParts.get(i);
					CollectionLiteralPart secondCollectionLiteralPart = secondParts.get(i);
					if (firstCollectionLiteralPart instanceof CollectionItem) {
						if (!(secondCollectionLiteralPart instanceof CollectionItem)) {
							return false;
						}
						if (!isSameTerm(PivotUtil.getOwnedItem((CollectionItem)firstCollectionLiteralPart),
							PivotUtil.getOwnedItem((CollectionItem)secondCollectionLiteralPart), firstVariable2secondVariable)) {
							return false;
						}
					}
					else if (firstCollectionLiteralPart instanceof CollectionRange) {
						if (!(secondCollectionLiteralPart instanceof CollectionRange)) {
							return false;
						}
						if (!isSameTerm(PivotUtil.getOwnedFirst((CollectionRange)firstCollectionLiteralPart),
							PivotUtil.getOwnedFirst((CollectionRange)secondCollectionLiteralPart), firstVariable2secondVariable)) {
							return false;
						}
						if (!isSameTerm(PivotUtil.getOwnedLast((CollectionRange)firstCollectionLiteralPart),
							PivotUtil.getOwnedLast((CollectionRange)secondCollectionLiteralPart), firstVariable2secondVariable)) {
							return false;
						}
					}
					else {
						return false;
					}
				}
			}
			else if (firstExpression instanceof IfExp) {
				if (!(secondExpression instanceof IfExp)) {
					return false;
				}
				IfExp firstIfExp = (IfExp)firstExpression;
				IfExp secondIfExp = (IfExp)secondExpression;
				if (!isSameTerm(PivotUtil.getOwnedCondition(firstIfExp), PivotUtil.getOwnedCondition(secondIfExp), firstVariable2secondVariable))	{
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedThen(firstIfExp), PivotUtil.getOwnedThen(secondIfExp), firstVariable2secondVariable))	{
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedElse(firstIfExp), PivotUtil.getOwnedElse(secondIfExp), firstVariable2secondVariable))	{
					return false;
				}
			}
			else if (firstExpression instanceof IntegerLiteralExp) {
				if (!(secondExpression instanceof IntegerLiteralExp)) {
					return false;
				}
				if (((IntegerLiteralExp)firstExpression).getIntegerSymbol()
						!= ((IntegerLiteralExp)secondExpression).getIntegerSymbol()) {
					return false;
				}
			}
			else if (firstExpression instanceof IterateExp) {
				if (!(secondExpression instanceof IterateExp)) {
					return false;
				}
				IterateExp firstIterateExp = (IterateExp)firstExpression;
				IterateExp secondIterateExp = (IterateExp)secondExpression;
				if (firstIterateExp.getReferredIteration() != secondIterateExp.getReferredIteration()) {
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedSource(firstIterateExp), PivotUtil.getOwnedSource(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedBody(firstIterateExp), PivotUtil.getOwnedBody(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
				List<@NonNull Variable> firstIterators = PivotUtilInternal.getOwnedIteratorsList(firstIterateExp);
				List<@NonNull Variable> secondIterators = PivotUtilInternal.getOwnedIteratorsList(secondIterateExp);
				int iSize = firstIterators.size();
				if (iSize != secondIterators.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					if (!isSameVariable(firstIterators.get(i), secondIterators.get(i), firstVariable2secondVariable))	{
						return false;
					}
				}
				if (!isSameVariable(PivotUtil.getOwnedResult(firstIterateExp), PivotUtil.getOwnedResult(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
			}
			else if (firstExpression instanceof IterateExp) {
				if (!(secondExpression instanceof IterateExp)) {
					return false;
				}
				IterateExp firstIterateExp = (IterateExp)firstExpression;
				IterateExp secondIterateExp = (IterateExp)secondExpression;
				if (firstIterateExp.getReferredIteration() != secondIterateExp.getReferredIteration()) {
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedSource(firstIterateExp), PivotUtil.getOwnedSource(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
				List<@NonNull Variable> firstIterators = PivotUtilInternal.getOwnedIteratorsList(firstIterateExp);
				List<@NonNull Variable> secondIterators = PivotUtilInternal.getOwnedIteratorsList(secondIterateExp);
				int iSize = firstIterators.size();
				if (iSize != secondIterators.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					if (!isSameVariable(firstIterators.get(i), secondIterators.get(i), firstVariable2secondVariable))	{
						return false;
					}
				}
				if (!isSameVariable(PivotUtil.getOwnedResult(firstIterateExp), PivotUtil.getOwnedResult(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedBody(firstIterateExp), PivotUtil.getOwnedBody(secondIterateExp), firstVariable2secondVariable))	{
					return false;
				}
			}
			else if (firstExpression instanceof IteratorExp) {
				if (!(secondExpression instanceof IteratorExp)) {
					return false;
				}
				IteratorExp firstIteratorExp = (IteratorExp)firstExpression;
				IteratorExp secondIteratorExp = (IteratorExp)secondExpression;
				if (firstIteratorExp.getReferredIteration() != secondIteratorExp.getReferredIteration()) {
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedSource(firstIteratorExp), PivotUtil.getOwnedSource(secondIteratorExp), firstVariable2secondVariable))	{
					return false;
				}
				List<@NonNull Variable> firstIterators = PivotUtilInternal.getOwnedIteratorsList(firstIteratorExp);
				List<@NonNull Variable> secondIterators = PivotUtilInternal.getOwnedIteratorsList(secondIteratorExp);
				int iSize = firstIterators.size();
				if (iSize != secondIterators.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					if (!isSameVariable(firstIterators.get(i), secondIterators.get(i), firstVariable2secondVariable))	{
						return false;
					}
				}
				if (!isSameTerm(PivotUtil.getOwnedBody(firstIteratorExp), PivotUtil.getOwnedBody(secondIteratorExp), firstVariable2secondVariable))	{
					return false;
				}
			}
			else if (firstExpression instanceof LetExp) {
				if (!(secondExpression instanceof LetExp)) {
					return false;
				}
				LetExp firstLetExp = (LetExp)firstExpression;
				LetExp secondLetExp = (LetExp)secondExpression;
				if (!isSameVariable(PivotUtil.getOwnedVariable(firstLetExp), PivotUtil.getOwnedVariable(secondLetExp), firstVariable2secondVariable))	{
					return false;
				}
				if (!isSameTerm(PivotUtil.getOwnedIn(firstLetExp), PivotUtil.getOwnedIn(secondLetExp), firstVariable2secondVariable))	{
					return false;
				}
			}
			else if (firstExpression instanceof MapLiteralExp) {
				if (!(secondExpression instanceof MapLiteralExp)) {
					return false;
				}
				MapLiteralExp firstMapLiteralExp = (MapLiteralExp)firstExpression;
				MapLiteralExp secondMapLiteralExp = (MapLiteralExp)secondExpression;
				List<@NonNull MapLiteralPart> firstParts = PivotUtilInternal.getOwnedPartsList(firstMapLiteralExp);
				List<@NonNull MapLiteralPart> secondParts = PivotUtilInternal.getOwnedPartsList(secondMapLiteralExp);
				int iSize = firstParts.size();
				if (iSize != secondParts.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					MapLiteralPart firstPart = firstParts.get(i);
					MapLiteralPart secondPart = secondParts.get(i);
					if (firstPart.getOwnedKey()
							!= ((IntegerLiteralExp)secondExpression).getIntegerSymbol()) {
						return false;
					}
					if (!isSameTerm(PivotUtil.getOwnedKey(firstPart), PivotUtil.getOwnedKey(secondPart), firstVariable2secondVariable)) {
						return false;
					}
					if (!isSameTerm(PivotUtil.getOwnedValue(firstPart), PivotUtil.getOwnedValue(secondPart), firstVariable2secondVariable)) {
						return false;
					}
				}
			}
			else if (firstExpression instanceof NavigationCallExp) {
				if (!(secondExpression instanceof NavigationCallExp)) {
					return false;
				}
				if (PivotUtil.getReferredProperty((NavigationCallExp)firstExpression)
						!= PivotUtil.getReferredProperty((NavigationCallExp)secondExpression)) {
					return false;
				}
			}
			else if (firstExpression instanceof NullLiteralExp) {
				if (!(secondExpression instanceof NullLiteralExp)) {
					return false;
				}
			}
			else if (firstExpression instanceof OperationCallExp) {
				if (!(secondExpression instanceof OperationCallExp)) {
					return false;
				}
				OperationCallExp firstOperationCallExp = (OperationCallExp)firstExpression;
				OperationCallExp secondOperationCallExp = (OperationCallExp)secondExpression;
				if (firstOperationCallExp.getReferredOperation() != secondOperationCallExp.getReferredOperation()) {
					return false;
				}
				List<@NonNull OCLExpression> firstArguments = PivotUtilInternal.getOwnedArgumentsList(firstOperationCallExp);
				List<@NonNull OCLExpression> secondArguments = PivotUtilInternal.getOwnedArgumentsList(secondOperationCallExp);
				int iSize = firstArguments.size();
				if (iSize != secondArguments.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					if (!isSameTerm(firstArguments.get(i), secondArguments.get(i), firstVariable2secondVariable))	{
						return false;
					}
				}
			}
			else if (firstExpression instanceof RealLiteralExp) {
				if (!(secondExpression instanceof RealLiteralExp)) {
					return false;
				}
				if (((RealLiteralExp)firstExpression).getRealSymbol()
						!= ((RealLiteralExp)secondExpression).getRealSymbol()) {
					return false;
				}
			}
			else if (firstExpression instanceof ShadowExp) {
				if (!(secondExpression instanceof ShadowExp)) {
					return false;
				}
				ShadowExp firstShadowExp = (ShadowExp)firstExpression;
				ShadowExp secondShadowExp = (ShadowExp)secondExpression;
				if (firstShadowExp.getType() != secondShadowExp.getType()) {
					return false;
				}
				List<@NonNull ShadowPart> firstParts = PivotUtilInternal.getOwnedPartsList(firstShadowExp);
				List<@NonNull ShadowPart> secondParts = PivotUtilInternal.getOwnedPartsList(secondShadowExp);
				int iSize = firstParts.size();
				if (iSize != secondParts.size()) {
					return false;
				}
				for (int i = 0; i < iSize; i++) {
					ShadowPart firstPart = firstParts.get(i);
					ShadowPart secondPart = secondParts.get(i);
					if (firstPart.getReferredProperty() != secondPart.getReferredProperty()) {
						return false;
					}
					if (!isSameTerm(PivotUtil.getOwnedInit(firstPart), PivotUtil.getOwnedInit(secondPart), firstVariable2secondVariable)) {
						return false;
					}
				}
			}
			else if (firstExpression instanceof StringLiteralExp) {
				if (!(secondExpression instanceof StringLiteralExp)) {
					return false;
				}
				if (!((StringLiteralExp)firstExpression).getStringSymbol().equals(((StringLiteralExp)secondExpression).getStringSymbol())) {
					return false;
				}
			}
			else if (firstExpression instanceof TypeExp) {
				if (!(secondExpression instanceof TypeExp)) {
					return false;
				}
				if (((TypeExp)firstExpression).getReferredType()
						!= ((TypeExp)secondExpression).getReferredType()) {
					return false;
				}
			}
			else if (firstExpression instanceof UnlimitedNaturalLiteralExp) {
				if (!(secondExpression instanceof UnlimitedNaturalLiteralExp)) {
					return false;
				}
				if (((UnlimitedNaturalLiteralExp)firstExpression).getUnlimitedNaturalSymbol()
						!= ((UnlimitedNaturalLiteralExp)secondExpression).getUnlimitedNaturalSymbol()) {
					return false;
				}
			}
			else if (firstExpression instanceof VariableExp) {
				if (!(secondExpression instanceof VariableExp)) {
					return false;
				}
				VariableDeclaration firstVariable = ((VariableExp)firstExpression).getReferredVariable();
				VariableDeclaration knownSecondVariable = firstVariable2secondVariable.get(firstVariable);
				if (knownSecondVariable != null) {
					VariableDeclaration secondVariable = ((VariableExp)secondExpression).getReferredVariable();
					return knownSecondVariable == secondVariable;
				}
			}
			else {
				return false;
			}
			return true;
		}

		protected boolean isSameVariable(@NonNull Variable firstVariable, @NonNull Variable secondVariable,
				@NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration> firstVariable2secondVariable) {
			VariableDeclaration knownSecondVariable = firstVariable2secondVariable.get(firstVariable);
			if (knownSecondVariable != null) {
				return knownSecondVariable == secondVariable;
			}
			if (!isSameTerm(PivotUtil.getOwnedInit(firstVariable), PivotUtil.getOwnedInit(secondVariable), firstVariable2secondVariable)) {
				return false;
			}
			firstVariable2secondVariable.put(firstVariable, secondVariable);
			return true;
		}

		@Override
		public @NonNull String toString() {
			return callPath + " = " + nullOrNonNull;
		}
	}

	@Deprecated /* @deprecated Use MetamodelManagerInternalExtension2.getFlowAnalysis */
	public static @NonNull FlowAnalysis getFlowAnalysis(@NonNull EnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
		return ((MetamodelManagerInternalExtension2)environmentFactory.getMetamodelManager()).getFlowAnalysis(contextExpression);
	}

	/**
	 * Return the ancestor of contextExpression that shares the same FlowAnalysis as contextExpression
	 */
	public static @NonNull OCLExpression getControlExpression(@NonNull OCLExpression contextExpression) {
		OCLExpression eObject = contextExpression;
		for (EObject eContainer; (eContainer = eObject.eContainer()) instanceof OCLExpression; eObject = (OCLExpression)eContainer) {
			if (eContainer instanceof IfExp) {
				IfExp ifExp = (IfExp)eContainer;
				if (eObject == PivotUtil.getOwnedThen(ifExp)) {
					break;
				}
				else if (eObject == PivotUtil.getOwnedElse(ifExp)) {
					break;
				}
			}
			else if (eContainer instanceof LetExp) {
				LetExp letExp = (LetExp)eContainer;
				if (eObject == PivotUtil.getOwnedIn(letExp)) {
					break;
				}
			}
			else if (eContainer instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eContainer;
				OperationId operationId = PivotUtil.getReferredOperation(operationCallExp).getOperationId();
				if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_AND)) {
					if (eObject == PivotUtil.getOwnedSource(operationCallExp)) {
						break;
					}
					else if (eObject == PivotUtil.getOwnedArgument(operationCallExp, 0)) {
						break;
					}
				}
				else if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_IMPLIES)) {
					if (eObject == PivotUtil.getOwnedSource(operationCallExp)) {
						break;
					}
					else if (eObject == PivotUtil.getOwnedArgument(operationCallExp, 0)) {
						break;
					}
				}
			}
		}
		return eObject;
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull OCLExpression contextExpression;
	private @Nullable AbstractDeducer deducerFromFalse = null;
	private @Nullable AbstractDeducer deducerFromNonNull = null;
	private @Nullable AbstractDeducer deducerFromNull = null;
	private final @NonNull AbstractDeducer deducerFromTrue = createDeducerFromTrue();

	/*
	 *	Map from the hashCode of a CallPath for some access for which the null (true), non-null (false) state
	 *	is known to all CallPaths with the same hash.
	 */
	private @Nullable Map<@NonNull Integer, @NonNull List<@NonNull CallPath>> callPathHash2callPaths = null;

	/*
	 *	Map from a simple VariableDeclaration for which the null (true), non-null (false) state is known.
	 */
	private @Nullable Map<@NonNull Object, @Nullable Boolean> variable2nullOrNonNull = null;

	/**
	 * @since 1.7
	 */
	public FlowAnalysis(@NonNull EnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
		this.environmentFactory = environmentFactory;
		this.contextExpression = contextExpression;
		for (EObject eObject = contextExpression, eContainer = eObject.eContainer(); eContainer instanceof OCLExpression; eObject = eContainer, eContainer = eContainer.eContainer()) {
			if (eContainer instanceof IfExp) {
				IfExp ifExp = (IfExp)eContainer;
				if (eObject == PivotUtil.getOwnedThen(ifExp)) {
					addTrueExpression(PivotUtil.getOwnedCondition(ifExp));
				}
				else if (eObject == PivotUtil.getOwnedElse(ifExp)) {
					addFalseExpression(PivotUtil.getOwnedCondition(ifExp));
				}
			}
			else if (eContainer instanceof LetExp) {
				LetExp letExp = (LetExp)eContainer;
				Variable letVariable = PivotUtil.getOwnedVariable(letExp);
				OCLExpression initExpression = PivotUtil.getOwnedInit(letVariable);
				FlowAnalysis variableAnalysis = ((MetamodelManagerInternal.MetamodelManagerInternalExtension2)environmentFactory.getMetamodelManager()).getFlowAnalysis(initExpression);
				if (variableAnalysis.isNull(initExpression)) {
					setVariable(letVariable, true);
				}
				else if (variableAnalysis.isNonNull(initExpression)) {
					setVariable(letVariable, false);
				}
			}
			else if (eContainer instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eContainer;
				OperationId operationId = PivotUtil.getReferredOperation(operationCallExp).getOperationId();
				if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_AND)) {
					if (eObject == PivotUtil.getOwnedSource(operationCallExp)) {
						addTrueExpression(PivotUtil.getOwnedArgument(operationCallExp, 0));
					}
					else if (eObject == PivotUtil.getOwnedArgument(operationCallExp, 0)) {
						addTrueExpression(PivotUtil.getOwnedSource(operationCallExp));
					}
				}
				else if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_IMPLIES)) {
					if (eObject == PivotUtil.getOwnedSource(operationCallExp)) {
						addFalseExpression(PivotUtil.getOwnedArgument(operationCallExp, 0));
					}
					else if (eObject == PivotUtil.getOwnedArgument(operationCallExp, 0)) {
						addTrueExpression(PivotUtil.getOwnedSource(operationCallExp));
					}
				}
			}
		}
		while (true) {
			boolean gotOne = false;
			while (deducerFromTrue.deduceNext()) {
				gotOne = true;
			}
			AbstractDeducer deducerFromFalse2 = deducerFromFalse;
			if (deducerFromFalse2 != null) {
				while (deducerFromFalse2.deduceNext()) {
					gotOne = true;
				}
			}
			AbstractDeducer deducerFromNull2 = deducerFromNull;
			if (deducerFromNull2 != null) {
				while (deducerFromNull2.deduceNext()) {
					gotOne = true;
				}
			}
			AbstractDeducer deducerFromNonNull2 = deducerFromNonNull;
			if (deducerFromNonNull2 != null) {
				while (deducerFromNonNull2.deduceNext()) {
					gotOne = true;
				}
			}
			if (!gotOne) {
				break;
			}
		}
	}

	protected void addFalseExpression(@NonNull OCLExpression object) {
		AbstractDeducer deducerFromFalse2 = deducerFromFalse;
		if (deducerFromFalse2 == null) {
			deducerFromFalse2 = deducerFromFalse = createDeducerFromFalse();
		}
		deducerFromFalse2.addToBeDeduced(object);
	}

	protected void addNonNullExpression(@NonNull OCLExpression object) {
		AbstractDeducer deducerFromNonNull2 = deducerFromNonNull;
		if (deducerFromNonNull2 == null) {
			deducerFromNonNull2 = deducerFromNonNull = createDeducerFromNull(false);
		}
		deducerFromNonNull2.addToBeDeduced(object);
	}

	protected void addNullExpression(@NonNull OCLExpression object) {
		AbstractDeducer deducerFromNull2 = deducerFromNull;
		if (deducerFromNull2 == null) {
			deducerFromNull2 = deducerFromNull = createDeducerFromNull(true);
		}
		deducerFromNull2.addToBeDeduced(object);
	}

	/**
	 * @since 1.7
	 */
	protected @NonNull AbstractDeducer createDeducerFromFalse() {
		return new PivotFlowAnalysisDeducerFromFalseVisitor(this);
	}

	/**
	 * @since 1.7
	 */
	protected @NonNull AbstractDeducer createDeducerFromNull(boolean isNull) {
		return new PivotFlowAnalysisDeducerFromNullVisitor(this, isNull);
	}

	/**
	 * @since 1.7
	 */
	protected @NonNull AbstractDeducer createDeducerFromTrue() {
		return new PivotFlowAnalysisDeducerFromTrueVisitor(this);
	}

	protected void addTrueExpression(@NonNull OCLExpression object) {
		deducerFromTrue.addToBeDeduced(object);
	}

	protected @Nullable Boolean getCallPath(@NonNull OCLExpression object) {
		Integer hashCode = CallPath.computeHashCode(object);
		if (hashCode == null) {
			return null;
		}
		Map<@NonNull Integer, @NonNull List<@NonNull CallPath>> callPathHash2callPaths2 = callPathHash2callPaths;
		if (callPathHash2callPaths2 == null) {
			return null;
		}
		List<@NonNull CallPath> callPaths = callPathHash2callPaths2.get(hashCode);
		if (callPaths == null) {
			return null;
		}
		for (@NonNull CallPath callPath : callPaths) {
			if (callPath.isSamePathAs(object)) {
				return callPath.getNullOrNonNull();
			}
		}
		return null;
	}

	protected @Nullable Boolean getVariable(@NonNull VariableDeclaration variable) {
		Map<@NonNull Object, @Nullable Boolean> variable2nullOrNonNull2 = variable2nullOrNonNull;
		return variable2nullOrNonNull2 != null ? variable2nullOrNonNull2.get(variable) : null;
	}

	public boolean isNonNull(@NonNull OCLExpression asExpression) {
		try {
			return deducerFromTrue.isAlreadyNonNull(asExpression);
		}
		catch (Throwable e) {
			return false;
		}
	}

	public boolean isNull(@NonNull OCLExpression asExpression) {
		try {
			return deducerFromTrue.isAlreadyNull(asExpression);
		}
		catch (Throwable e) {
			return false;
		}
	}

	protected @Nullable Boolean setCallPath(@NonNull CallExp object, boolean isNull) {
		Integer hashCode = CallPath.computeHashCode(object);
		if (hashCode == null) {
			return null;
		}
		List<@NonNull OCLExpression> path = new ArrayList<>();
		for (OCLExpression pathExp = object; pathExp != null; pathExp = pathExp instanceof CallExp ? ((CallExp)pathExp).getOwnedSource() : null) {
			path.add(pathExp);
			if (pathExp instanceof VariableExp) {
				break;
			}
		}
		Map<@NonNull Integer, @NonNull List<@NonNull CallPath>> callPathHash2callPaths2 = callPathHash2callPaths;
		if (callPathHash2callPaths2 == null) {
			callPathHash2callPaths2 = callPathHash2callPaths = new HashMap<>();
		}
		List<@NonNull CallPath> callPaths = callPathHash2callPaths2.get(hashCode);
		if (callPaths == null) {
			callPaths = new ArrayList<>();
			callPathHash2callPaths2.put(hashCode, callPaths);
		}
		callPaths.add(new CallPath(path, isNull));
		return true;
	}

	protected boolean setVariable(@NonNull VariableDeclaration variable, boolean isNullOrNonNull) {
		Map<@NonNull Object, @Nullable Boolean> variable2nullOrNonNull2 = variable2nullOrNonNull;
		if (variable2nullOrNonNull2 == null) {
			variable2nullOrNonNull2 = variable2nullOrNonNull = new HashMap<>();
		}
		Boolean oldNullOrNonNull = variable2nullOrNonNull2.put(variable, isNullOrNonNull);
		if (oldNullOrNonNull == null) {
			return true;
		}
		return oldNullOrNonNull.booleanValue() == isNullOrNonNull;
	}
}
