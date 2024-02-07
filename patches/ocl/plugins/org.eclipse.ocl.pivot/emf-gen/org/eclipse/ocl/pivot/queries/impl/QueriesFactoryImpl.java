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
package org.eclipse.ocl.pivot.queries.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.queries.QueriesFactory;
import org.eclipse.ocl.pivot.queries.QueriesPackage;
import org.eclipse.ocl.pivot.queries.QueryModel;
import org.eclipse.ocl.pivot.queries.QueryResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @since 1.18
 * <!-- end-user-doc -->
 * @generated
 */
public class QueriesFactoryImpl extends EFactoryImpl implements QueriesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueriesFactory init() {
		try {
			QueriesFactory theQueriesFactory = (QueriesFactory)EPackage.Registry.INSTANCE.getEFactory(QueriesPackage.eNS_URI);
			if (theQueriesFactory != null) {
				return theQueriesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QueriesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueriesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case 0: return createQueryModel();
			case 1: return createQueryResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull QueryModel createQueryModel() {
		QueryModelImpl queryModel = new QueryModelImpl();
		return queryModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull QueryResult createQueryResult() {
		QueryResultImpl queryResult = new QueryResultImpl();
		return queryResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueriesPackage getQueriesPackage() {
		return (QueriesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QueriesPackage getPackage() {
		return QueriesPackage.eINSTANCE;
	}

} //QueriesFactoryImpl
