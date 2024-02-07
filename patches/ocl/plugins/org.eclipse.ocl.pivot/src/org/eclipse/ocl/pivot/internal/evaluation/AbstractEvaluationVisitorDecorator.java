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

package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociationClassCallExp;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MessageExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StateExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

/**
 * A visitor that decorates another {@link EvaluationVisitor}, to intercept
 * invocations of the <code>visitXxx(...)</code> methods.  By default, every
 * visitation is simply delegated to the decorated visitor.  Subclasses may
 * extend these delegations with any additional behaviour that is required,
 * even replacing calls to the delegate where necessary.
 * <p>
 * This class works together with the {@link AbstractEvaluationVisitor} to
 * ensure that recursive <code>visitXxx()</code> calls are correctly intercepted
 * by me (and not just implemented within the decorated visitor).  Moreover,
 * this works with decorators nested to any depth.
 * </p>
 */
public abstract class AbstractEvaluationVisitorDecorator<EV extends EvaluationVisitor> extends AbstractExtendingVisitor<Object, Object> implements EvaluationVisitor {

	protected final @NonNull EV delegate;

	protected AbstractEvaluationVisitorDecorator(@NonNull EV decorated) {
		super(Object.class);						// Useless dummy object as context
		assert decorated != null : "cannot decorate a null visitor"; //$NON-NLS-1$

		this.delegate = decorated;

		decorated.setUndecoratedVisitor(this);
	}

	/** @deprecated Evaluator no longer nests */
	@Deprecated
	@Override
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return delegate.createNestedEvaluator();
	}

	/** @deprecated Evaluator no longer nests
	 * @since 1.1*/
	@Deprecated
	@Override
	public void dispose() {
		delegate.dispose();
	}

	/**
	 * Delegates to my decorated visitor.
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull OCLExpression body) {
		return delegate.evaluate(body);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @NonNull CompleteEnvironment getCompleteEnvironment() {
		return delegate.getCompleteEnvironment();
	}

	/**
	 * Obtains the visitor that I decorate.
	 *
	 * @return my decorated visitor
	 */
	protected final @NonNull EV getDelegate() {
		return delegate;
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getDiagnosticSeverity(int severityPreference, @Nullable Object resultValue) {
		return delegate.getDiagnosticSeverity(severityPreference, resultValue);
	}

	/**
	 * Obtains my delegate's environment.
	 */
	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return delegate.getEnvironmentFactory();
	}

	/**
	 * Obtains my delegate's evaluation environment.
	 */
	@Override
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return delegate.getEvaluationEnvironment();
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @NonNull EvaluationVisitor getEvaluator() {
		return delegate.getEvaluator();
	}

	//	@Override
	//	public @NonNull Executor getExecutor() {
	//		return delegate.getExecutor();
	//	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @Nullable EvaluationLogger getLogger() {
		return delegate.getLogger();
	}

	/** @deprecated moved to Executor
	 * @since 1.1*/
	@Override
	@Deprecated
	public @NonNull MetamodelManager getMetamodelManager() {
		return delegate.getMetamodelManager();
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public @NonNull ModelManager getModelManager() {
		return delegate.getModelManager();
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Monitor getMonitor() {
		return delegate.getMonitor();
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return delegate.getRegexPattern(regex);
	}

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	public int getSeverity(@Nullable Object validationKey) {
		return delegate.getSeverity(validationKey);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value) {
		return delegate.getStaticTypeOf(value);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @Nullable Object @NonNull ... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value,	@NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	/**
	 * Delegates to my decorated visitor.
	 * @since 1.1
	 */
	@Override
	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	/**
	 * Delegates to my decorated visitor.
	 * @since 1.1
	 */
	@Override
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	/** @deprecated moved to Evaluator
	 * @since 1.1*/
	@Deprecated
	@Override
	public void setLogger(@Nullable EvaluationLogger logger) {
		delegate.setLogger(logger);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public void setMonitor(@Nullable Monitor monitor) {
		delegate.setMonitor(monitor);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		delegate.setUndecoratedVisitor(evaluationVisitor);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitConstraint(@NonNull Constraint constraint) {
		return delegate.visitConstraint(constraint);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitAssociationClassCallExp(
			@NonNull AssociationClassCallExp callExp) {
		return delegate.visitAssociationClassCallExp(callExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp literalExp) {
		return delegate.visitBooleanLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitCollectionItem(@NonNull CollectionItem item) {
		return delegate.visitCollectionItem(item);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp literalExp) {
		return delegate.visitCollectionLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitCollectionRange(@NonNull CollectionRange range) {
		return delegate.visitCollectionRange(range);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp literalExp) {
		return delegate.visitEnumLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		return delegate.visitExpressionInOCL(expression);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitIfExp(@NonNull IfExp ifExp) {
		return delegate.visitIfExp(ifExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp literalExp) {
		return delegate.visitIntegerLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp literalExp) {
		return delegate.visitInvalidLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitLetExp(@NonNull LetExp letExp) {
		return delegate.visitLetExp(letExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public @Nullable Object visitMapLiteralExp(@NonNull MapLiteralExp literalExp) {
		return delegate.visitMapLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public @Nullable Object visitMapLiteralPart(@NonNull MapLiteralPart range) {
		return delegate.visitMapLiteralPart(range);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitMessageExp(@NonNull MessageExp messageExp) {
		return delegate.visitMessageExp(messageExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp literalExp) {
		return delegate.visitNullLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitOperationCallExp(@NonNull OperationCallExp callExp) {
		return delegate.visitOperationCallExp(callExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp callExp) {
		return delegate.visitOppositePropertyCallExp(callExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp callExp) {
		return delegate.visitPropertyCallExp(callExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp literalExp) {
		return delegate.visitRealLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitShadowExp(@NonNull ShadowExp shadowExp) {
		return delegate.visitShadowExp(shadowExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitStateExp(@NonNull StateExp stateExp) {
		return delegate.visitStateExp(stateExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp literalExp) {
		return delegate.visitStringLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp literalExp) {
		return delegate.visitTupleLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitTupleLiteralPart(@NonNull TupleLiteralPart part) {
		return delegate.visitTupleLiteralPart(part);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitTypeExp(@NonNull TypeExp typeExp) {
		return delegate.visitTypeExp(typeExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitUnlimitedNaturalLiteralExp(
			@NonNull UnlimitedNaturalLiteralExp literalExp) {
		return delegate.visitUnlimitedNaturalLiteralExp(literalExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp unspecExp) {
		return delegate.visitUnspecifiedValueExp(unspecExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitVariable(@NonNull Variable variable) {
		return delegate.visitVariable(variable);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visitVariableExp(@NonNull VariableExp variableExp) {
		return delegate.visitVariableExp(variableExp);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	@Override
	public Object visiting(@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}
}
