/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage
 * @generated
 */
public interface OCLstdlibCSFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSFactory eINSTANCE = org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Class CS</em>'.
	 * @generated
	 */
	JavaClassCS createJavaClassCS();

	/**
	 * Returns a new object of class '<em>Lib Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Class CS</em>'.
	 * @generated
	 */
	LibClassCS createLibClassCS();

	/**
	 * Returns a new object of class '<em>Lib Coercion CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Coercion CS</em>'.
	 * @generated
	 */
	LibCoercionCS createLibCoercionCS();

	/**
	 * Returns a new object of class '<em>Lib Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Constraint CS</em>'.
	 * @generated
	 */
	LibConstraintCS createLibConstraintCS();

	/**
	 * Returns a new object of class '<em>Lib Iteration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Iteration CS</em>'.
	 * @generated
	 */
	LibIterationCS createLibIterationCS();

	/**
	 * Returns a new object of class '<em>Lib Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Operation CS</em>'.
	 * @generated
	 */
	LibOperationCS createLibOperationCS();

	/**
	 * Returns a new object of class '<em>Lib Opposite CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Opposite CS</em>'.
	 * @generated
	 */
	LibOppositeCS createLibOppositeCS();

	/**
	 * Returns a new object of class '<em>Lib Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Package CS</em>'.
	 * @generated
	 */
	LibPackageCS createLibPackageCS();

	/**
	 * Returns a new object of class '<em>Lib Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Property CS</em>'.
	 * @generated
	 */
	LibPropertyCS createLibPropertyCS();

	/**
	 * Returns a new object of class '<em>Lib Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Root Package CS</em>'.
	 * @generated
	 */
	LibRootPackageCS createLibRootPackageCS();

	/**
	 * Returns a new object of class '<em>Metaclass Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metaclass Name CS</em>'.
	 * @generated
	 */
	MetaclassNameCS createMetaclassNameCS();

	/**
	 * Returns a new object of class '<em>Precedence CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedence CS</em>'.
	 * @generated
	 */
	PrecedenceCS createPrecedenceCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLstdlibCSPackage getOCLstdlibCSPackage();

} //OCLstdlibCSTFactory
