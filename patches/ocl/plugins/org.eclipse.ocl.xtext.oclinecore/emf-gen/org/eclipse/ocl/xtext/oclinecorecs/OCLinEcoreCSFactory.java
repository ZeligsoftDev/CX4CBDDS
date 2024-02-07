/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecorecs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage
 * @generated
 */
public interface OCLinEcoreCSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSFactory eINSTANCE = org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>OC Lin Ecore Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OC Lin Ecore Constraint CS</em>'.
	 * @generated
	 */
	OCLinEcoreConstraintCS createOCLinEcoreConstraintCS();

	/**
	 * Returns a new object of class '<em>Sys MLCS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sys MLCS</em>'.
	 * @generated
	 */
	SysMLCS createSysMLCS();

	/**
	 * Returns a new object of class '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level CS</em>'.
	 * @generated
	 */
	TopLevelCS createTopLevelCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLinEcoreCSPackage getOCLinEcoreCSPackage();

} //OCLinEcoreCSFactory
