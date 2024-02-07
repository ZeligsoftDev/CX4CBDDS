/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.ast;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Bernd Kolb
 * @author Dennis Huebner
 * @author Patrick Schoenbach
 * @author Achim Demelt
 * @author Jan Koehnlein
 * @author Karsten Thoms
 */
public class Check extends SyntaxElement {

	private final Identifier type;

	private boolean errorSeverity = true;

	private final Expression msg;

	private final Expression constraint;

	private final Expression guard;

	private final Identifier feature;

	public Check(final Identifier type, final Identifier f, final Expression guard, final boolean errorSeverity, final Expression msg,
			final Expression constraint) {
		this.type = type;
		feature = f;
		this.guard = guard;
		this.errorSeverity = errorSeverity;
		this.msg = msg;
		this.constraint = constraint;
	}

	public final void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx;
		try {
			if (_ctx.getCallback() != null) {
				if (!_ctx.getCallback().pre(this, _ctx)) {
					return;
				}
			}
			final String typeName = type.toString();
			final Type toCheck = _ctx.getTypeForName(typeName);
			if (toCheck == null) {
				issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Type not found: " + typeName, this));
				return;
			}
			if (feature != null) {
				final String featureName = feature.toString();
				Property property = toCheck.getProperty(featureName);
				if (property == null) {
					issues.add(new AnalysationIssue(AnalysationIssue.FEATURE_NOT_FOUND, "Couldn't find property '" + featureName + "' for type '"
							+ typeName + "'", this));
					return;
				}
			}

			_ctx = _ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, toCheck));
			if (guard != null) {
				Type guardType = null;
				try {
					guardType = guard.analyze(_ctx, issues);
				} catch (RuntimeException ex) {
					_ctx.handleRuntimeException(ex, this, null);
				}
				if (guardType == null) {
					return;
				}
				if (!guardType.equals(_ctx.getBooleanType())) {
					issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Boolean expected! (is " + guardType.getName() + ")", guard));
				}
			}

			Type constraintType = null;
			try {
				constraintType = constraint.analyze(_ctx, issues);
			} catch (RuntimeException ex) {
				_ctx.handleRuntimeException(ex, this, null);
			}
			if (constraintType == null) {
				return;
			}
			if (!constraintType.equals(_ctx.getBooleanType())) {
				issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Boolean expected! (is " + constraintType.getName() + ")",
						constraint));
			}

			try {
				msg.analyze(_ctx, issues);
			} catch (RuntimeException ex) {
				_ctx.handleRuntimeException(ex, this, null);
			}
		} finally {
			if (_ctx.getCallback() != null) {
				_ctx.getCallback().post(this, _ctx, null);
			}
		}
	}

	/**
	 * Executes the check.
	 * 
	 * @param ctx
	 *            The current execution context
	 * @param colToCheck
	 *            Collection of objects on which the check is evaluated
	 * @param issues
	 *            Errors and warnings are reported to this instance
	 * @param warnIfNothingChecked
	 *            <code>true</code>: If this check is not evaluated for any elements an warning will be added to <tt>issues</tt>
	 */
	public void validate(final ExecutionContext ctx, final Collection<?> colToCheck, final Issues issues, final boolean warnIfNothingChecked) {
		ExecutionContext _ctx = ctx;
		try {
			if (_ctx.getCallback() != null) {
				if (!_ctx.getCallback().pre(this, _ctx)) {
					return;
				}
			}
			// get the type for which the check should be evaluated
			final String typeName = type.toString();
			final Type typeToCheck = _ctx.getTypeForName(typeName);
			// The type is unknown => exit with exception
			if (typeToCheck == null) {
				throw new EvaluationException("Type not found : " + typeName, this, _ctx);
			}

			// will be set to true when check is evaluated for any object
			boolean someObjectFound = false;
			for (Object o : colToCheck) {
				// Object matches the type the check is declared for
				if (typeToCheck.isInstance(o)) {
					someObjectFound = true;
					try {
						// create a new execution context for evaluation
						_ctx = _ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, o));
						// check the guard condition; do not evaluate if guard
						// is
						// evaluated to false
						if (process(_ctx)) {
							Object result = null;
							try {
								result = constraint.evaluate(_ctx);
							} catch (RuntimeException e) {
								addIssueForException(issues, e, o);
							}

							// check result must be of Boolean type
							if ((result != null) && !(result instanceof Boolean)) {
								throw new EvaluationException("Boolean expected! ( was " + result.getClass().getName() + ")", this, _ctx);
							}

							// add issue if result of the check is false
							final Boolean r = (Boolean) result;
							if (Boolean.FALSE.equals(r)) {
								// get the error message
								Object msgResult = null;
								try {
									msgResult = msg.evaluate(_ctx);
								} catch (RuntimeException e) {
									addIssueForException(issues, e, o);
								}

								String stringResult = "Message evaluation returned null";
								if (msgResult != null) {
									stringResult = msgResult.toString();
								}
								// Involved property e.g. test::Bean#property
								String propertyName = null;
								if (feature != null) {
									String featureValue = feature.toString();
									Property property = typeToCheck.getProperty(featureValue);
									if (property == null) {
										throw new EvaluationException("Property " + featureValue + " for Type " + typeToCheck + " not found!", this,
												_ctx);
									}
									propertyName = property.getName();
								}
								if (errorSeverity) {
									issues.addError(null, stringResult, o, propertyName, null, Collections.emptyList());
								} else {
									issues.addWarning(null, stringResult, o, propertyName, null, Collections.emptyList());
								}
							}
						}
					} catch (final NullPointerException npe) {
						final Object msgResult = msg.evaluate(_ctx);
						String stringResult = "Message evaluation returned null";
						if (msgResult != null) {
							stringResult = msgResult.toString();
						}
						if (errorSeverity) {
							issues.addError(stringResult + " (NPE in constraint evaluation)", o);
						} else {
							issues.addWarning(stringResult + " (NPE in constraint evaluation)", o);
						}
					}
				}
			}
			if (warnIfNothingChecked && (!someObjectFound)) {
				issues.addWarning("The constraint did not match any model elements. Context: " + type.toString() + ", message: " + msg);
			}
		} finally {
			if (_ctx.getCallback() != null) {
				_ctx.getCallback().post(this, _ctx, null);
			}
		}
	}

	protected void addIssueForException(final Issues issues, final Exception exception, final Object element) {
		issues.addError(null, exception.getMessage(), element, exception, Collections.emptyList());
	}

	private boolean process(final ExecutionContext ctx) {
		if (guard != null) {
			final Object result = guard.evaluate(ctx);
			return (result instanceof Boolean) && ((Boolean) result).booleanValue();
		}
		return true;
	}

	@Override
	public String toString() {
		return type + " " + msg;
	}

	public boolean isErrorCheck() {
		return errorSeverity;
	}

	public Expression getConstraint() {
		return constraint;
	}

	public Expression getGuard() {
		return guard;
	}

	public Expression getMsg() {
		return msg;
	}

	public Identifier getType() {
		return type;
	}

}
