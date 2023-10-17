/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;

/**
 * A utility object that provides OCL syntax completion suggestions for OCL
 * expressions and convenient API for parsing OCL constraint expressions without
 * the encumbrance of context declarations.  The latter is most useful for
 * processing OCL constraints and expressions embedded in the user model, where
 * the context is implied by the placement of the constraint in the model.
 * <p>
 * An OCL helper is created by the {@link OCL#createOCLHelper(EObject)} factory method.
 * </p><p>
 * <b>Note</b> that this interface is not intended to be implemented
 * by clients.
 * </p>
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
public interface OCLHelper
{
	/**
	 * Obtains my OCL context classifier as a classifier.
	 * 
	 * @return my context classifier (never <code>null</code>)
	 */
	@Nullable Type getContextClass();

	/**
	 * Obtains my context operation, if my environment is an operation context.
	 * 
	 * @return my context operation, or <code>null</code> if there is only a
	 *     classifier or attribute context
	 */
	@Nullable Operation getContextOperation();

	/**
	 * Obtains my context attribute, if my environment is an attribute context.
	 * 
	 * @return my context attribute, or <code>null</code> if there is only a
	 *     classifier or operation context
	 */
	@Nullable Property getContextProperty();
	
    /**
     * Obtains the OCL instance that created me.  Note that many of the generic
     * type parameter bindings will not be known, so clients should keep track
     * of the OCL instance themselves where that is a problem.
     * 
     * @return the OCL instance that created me
     */
    @NonNull OCL getOCL();
    
	/**
	 * Queries whether I validate the expressions that I parse.  Validation
	 * applies more well-formedness checks than are implied by parsing, especially
	 * because parsing supports partial (incomplete) expressions for syntax
	 * completion.  Validation adds some amount of processing, which is not
	 * necessary in all cases.
	 * 
	 * @return whether I validate the expressions that I parse.  Validation is
	 *    on by default
	 */
//	boolean isValidating();
	
	/**
	 * Sets whether I should validate the expressions that I parse.
	 * 
	 * @param validating whether I should validate parsed expressions
	 */
//	void setValidating(boolean validating);

    /**
     * Creates a query expression in the current classifier context.  This may
     * be specified, for example, as an expression value in the model.
     * 
     * @param expression the expression (without any context declaration).
     *    This expression can have any result type; it needs not be a boolean
     * 
     * @return the query expression
     * 
     * @throws ParserException if the <code>expression</code> fails to parse
     */
	@NonNull ExpressionInOCL createQuery(@NonNull String expression) throws ParserException;

    /**
     * Creates a constraint of the specified kind, by parsing the given
     * expression.  In the case of additional attribute or operation definition
     * constraints, the expression must be prefixed by the signature of the
     * feature as follows:
     * <blockquote><pre>
     *     <i>attribute-name</i> : <i>type</i> = <i>expr</i>
     * </pre></blockquote>
     * <blockquote><pre>
     *     <i>operation-name</i>(<i>parameters?</i>) : <i>type</i> = <i>expr</i>
     * </pre></blockquote>
     *  
     * @param kind the kind of constraint to create
     * @param expression the constraint body
     * @return the constraint
     * 
     * @throws ParserException on failure to parse the constraint
     */
//    Constraint createConstraint(ConstraintKind kind, String expression) throws ParserException;
    
	/**
	 * Creates an invariant constraint in the current classifier context.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the invariant constraint
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	@NonNull ExpressionInOCL createInvariant(@NonNull String expression) throws ParserException;

	/**
	 * Creates an operation precondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the precondition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
    @NonNull ExpressionInOCL createPrecondition(@NonNull String expression) throws ParserException;

	/**
	 * Creates an operation postcondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the postcondition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	@NonNull ExpressionInOCL createPostcondition(@NonNull String expression) throws ParserException;

	/**
	 * Creates an operation body.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  Ordinarily, this is an expression of the same type
	 *    as the operation, specifying the value of the operation.
	 *    Alternatively, this may be a boolean-valued expression phrased like
	 *    a post-condition (according to the well-formedness rules of UML
	 *    constraints)
	 * 
	 * @return the body condition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	@NonNull ExpressionInOCL createBodyCondition(@NonNull String expression) throws ParserException;

	/**
	 * Creates a property initial value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the initial value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the initial value expression
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 */
//	Constraint createInitialValueExpression(@NonNull String expression) throws ParserException;

	/**
	 * Creates a property derived value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the derived value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the derived value expression
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 */
	@NonNull ExpressionInOCL createDerivedValueExpression(@NonNull String expression) throws ParserException;

	/**
	 * Defines an additional operation in the context classifier,
	 * for use in formulating OCL queries and constraints.  This is a
	 * "def expression", taking the form of:
	 * <blockquote><pre>
	 *     <i>operation-name</i>(<i>parameters?</i>) : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * 
	 * @param defExpression the definition expression (without any other context
	 *    declaration).
	 * @return the newly defined operation
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
//	Operation defineOperation(@NonNull String defExpression) throws ParserException;

	/**
	 * Defines an additional attribute in the context classifier,
	 * for use in formulating OCL queries and constraints.  This is a
	 * "def expression", taking the form of:
	 * <blockquote><pre>
	 *     <i>attribute-name</i> : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * 
	 * @param defExpression the definition expression (without any other context
	 *    declaration).
	 * @return the newly defined attribute
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
//	Property defineProperty(@NonNull String defExpression) throws ParserException;
    
    /**
     * Obtains problems, if any, found in parsing the last OCL constraint or
     * query expression.
     * 
     * @return parsing problems or <code>null</code> if all was OK
     */
//    Diagnostic getProblems();
}