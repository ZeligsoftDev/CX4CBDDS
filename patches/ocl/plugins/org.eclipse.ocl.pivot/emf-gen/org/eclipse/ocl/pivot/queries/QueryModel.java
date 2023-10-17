/**
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.queries;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A QueryModel aggregates multiple QueryResults as a saveable model
 * @since 1.18
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.queries.QueryModel#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryModel()
 * @model
 * @generated
 */
public interface QueryModel extends Model {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.queries.QueryResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.queries.QueriesPackage#getQueryModel_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryResult> getResults();

} // QueryModel
