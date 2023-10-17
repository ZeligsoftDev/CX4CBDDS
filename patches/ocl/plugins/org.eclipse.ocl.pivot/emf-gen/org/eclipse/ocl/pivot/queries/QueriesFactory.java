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

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @since 1.18
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.queries.QueriesPackage
 * @generated
 */
public interface QueriesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueriesFactory eINSTANCE = org.eclipse.ocl.pivot.queries.impl.QueriesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Query Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Model</em>'.
	 * @generated
	 */
	@NonNull QueryModel createQueryModel();

	/**
	 * Returns a new object of class '<em>Query Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Result</em>'.
	 * @generated
	 */
	@NonNull QueryResult createQueryResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QueriesPackage getQueriesPackage();

} //QueriesFactory
