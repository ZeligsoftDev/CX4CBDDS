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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;

/**
 * An OCL constraint or query.  The query is validated for correctness
 * when it is created.  The query can subsequently be evaluated on a single
 * object or on multiple objects in one operation.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public interface Query
{
	/**
	 * Evaluates the query on a boxedObject. The query must be a boolean valued
	 * constraint.
	 * 
	 * @param boxedObject an <code>Object</code> or <code>null</code> if the query
	 *     does not require an OCL 'self' context
	 * @return boolean <code>true</code> or <code>false</code> according to
	 *     whether the constraint is met
	 */
	public boolean checkBoxed(@Nullable Object boxedObject);
		
	/**
	 * Evaluates the query on an ecoreObject. The query must be a boolean valued
	 * constraint.
	 * 
	 * @param ecoreObject an <code>Object</code> or <code>null</code> if the query
	 *     does not require an OCL 'self' context
	 * @return boolean <code>true</code> or <code>false</code> according to
	 *     whether the constraint is met
	 */
	public boolean checkEcore(@Nullable Object ecoreObject); 

	/**
	* Determines whether all of the boxedObjects satisfy the query.
	* The query must be a boolean-valued constraint.
	* 
	* @param boxedObjects a list of objects to evaluate the constraint on
	* @return <code>true</code> if all of the <code>objects</code> satisfy
	*     the constraint (including the trivial case of an empty input list);
	*     <code>false</code>, otherwise
	*/
	public boolean checkBoxed(@NonNull Iterable<?> boxedObjects); 

	/**
	* Determines whether all of the ecoreObjects satisfy the query.
	* The query must be a boolean-valued constraint.
	* 
	* @param ecoreObjects a list of objects to evaluate the constraint on
	* @return <code>true</code> if all of the <code>objects</code> satisfy
	*     the constraint (including the trivial case of an empty input list);
	*     <code>false</code>, otherwise
	*/
	public boolean checkEcore(@NonNull Iterable<?> ecoreObjects); 

	/**
	 * Evaluates the query on the boxedObject to return a boxedResult.
	 */
	public @Nullable Object evaluateBoxed(@Nullable Object boxedObject);

	/**
	 * Evaluates the query on each of boxedObjects to return a list of boxedResults.
	 */
	public @NonNull List<?> evaluateBoxed(@NonNull Iterable<?> boxedObjects);
	
	/**
	 * Evaluates the query on the ecoreObject to return an ecoreResult using Integer/Double for numerics.
	 */
	public @Nullable Object evaluateEcore(@Nullable Object ecoreObject) throws EvaluationException;
	
	/**
	 * Evaluates the query on the ecoreObject to return an ecoreResult coerced, if non-null, to instanceClass.
	 */
	public @Nullable Object evaluateEcore(@Nullable Class<?> instanceClass, @Nullable Object ecoreObject) throws EvaluationException;

	/**
	 * Evaluates the query on each of ecoreObjects to return a list of ecoreResults using Integer/Double for numerics.
	 */
	public @NonNull EList<?> evaluateEcore(@NonNull Iterable<?> ecoreObjects);

	/**
	 * Evaluates the query on each of ecoreObjects to return a list of ecoreResults coerced, if non-null, to instanceClass.
	 */
	public @NonNull EList<?> evaluateEcore(@Nullable Class<?> instanceClass, @NonNull Iterable<?> ecoreObjects);

	/**
	 * Evaluates the query on the unboxedObject to return an unboxedResult.
	 */
	public @Nullable Object evaluateUnboxed(@Nullable Object unboxedObject);

	/**
	 * Obtains the evaluation environment that I use to evaluate OCL expressions. The EvaluationEnvironment
	 * is created lazily to suit the first evaluation and thereafter may be reused for the same query expression
	 * on many different objects. The associated ModelManager is obtained from the OCL that created this query,
	 * unless null in which case it is also created lazily to suit the first evaluation.
	 * 
	 * @return my environment
	 */
	@NonNull EvaluationEnvironment getEvaluationEnvironment(@Nullable Object unboxedObject);
	
	/**
	 * Obtains the expression that I evaluate (or check as a boolean constraint).
	 * 
	 * @return my OCL expression
	 */
	@NonNull OCLExpression getExpression();

	/**
	 * <p>
	 * Obtains the {@link OCL} that created me.
	 * </p>
	 * 
	 * @return my originating <tt>OCL</tt> instance
	 */
	@NonNull OCL getOCL();

	/**
	 * Translates the query back to an OCL text string.
	 * 
	 * @return the text of the OCL query expression
	 */
	public String queryText();

	/**
	 * Determines the subset of ecoreObjects that do not satisfy the
	 * query.  The query must be a boolean valued constraint.
	 * 
	 * @param ecoreObjects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      do not satisfy the constraint
	 */
	public @NonNull <T> List<T> rejectEcore(@NonNull Iterable<T> ecoreObjects);
		
	/**
	 * Obtains the OCL result type of the query.  This may be a classifier
	 * in the user model, or it may represent a pre-defined OCL data type
	 * such as {@link StandardLibrary#getBooleanType() Boolean}.
	 * 
	 * @return the query's result type
	 */
	public Type resultType();

	/**
	 * Determines the subset of ecoreObjects that satisfy the query.
	 * The query must be a boolean valued constraint.
	 * 
	 * @param ecoreObjects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      satisfy the constraint
	 */
	public @NonNull <T> List<T> selectEcore(@NonNull Iterable<T> ecoreObjects);
}

