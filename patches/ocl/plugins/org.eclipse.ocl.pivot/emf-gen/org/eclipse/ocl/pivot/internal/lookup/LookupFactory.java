/**
 * Copyright (c) 2014, 2018 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.lookup;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.internal.lookup.LookupPackage
 * @generated
 */
public interface LookupFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LookupFactory eINSTANCE = org.eclipse.ocl.pivot.internal.lookup.impl.LookupFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment</em>'.
	 * @generated
	 */
	LookupEnvironment createLookupEnvironment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LookupPackage getLookupPackage();

} //LookupFactory
