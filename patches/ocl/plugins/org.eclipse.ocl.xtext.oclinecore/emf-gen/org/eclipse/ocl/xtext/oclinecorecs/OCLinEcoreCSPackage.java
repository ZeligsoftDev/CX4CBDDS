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
package org.eclipse.ocl.xtext.oclinecorecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSFactory
 * @model kind="package"
 * @generated
 */
public interface OCLinEcoreCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclinecorecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/OCLinEcoreCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclinecorecs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.xtext.oclinecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSPackage eINSTANCE = org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreConstraintCSImpl
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getOCLinEcoreConstraintCS()
	 * @generated
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS <em>OC Lin Ecore Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Constraint CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS
	 * @generated
	 */
	EClass getOCLinEcoreConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS#isIsCallable <em>Is Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Callable</em>'.
	 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS#isIsCallable()
	 * @see #getOCLinEcoreConstraintCS()
	 * @generated
	 */
	EAttribute getOCLinEcoreConstraintCS_IsCallable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclinecorecs.SysMLCS <em>Sys MLCS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sys MLCS</em>'.
	 * @see org.eclipse.ocl.xtext.oclinecorecs.SysMLCS
	 * @generated
	 */
	EClass getSysMLCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclinecorecs.SysMLCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.xtext.oclinecorecs.SysMLCS#getValue()
	 * @see #getSysMLCS()
	 * @generated
	 */
	EAttribute getSysMLCS_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLinEcoreCSFactory getOCLinEcoreCSFactory();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.SysMLCSImpl <em>Sys MLCS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.SysMLCSImpl
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getSysMLCS()
	 * @generated
	 */
	int SYS_MLCS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.TopLevelCSImpl
	 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 2;

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreConstraintCSImpl
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getOCLinEcoreConstraintCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_CONSTRAINT_CS = eINSTANCE.getOCLinEcoreConstraintCS();
		/**
		 * The meta object literal for the '<em><b>Is Callable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OC_LIN_ECORE_CONSTRAINT_CS__IS_CALLABLE = eINSTANCE.getOCLinEcoreConstraintCS_IsCallable();
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.SysMLCSImpl <em>Sys MLCS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.SysMLCSImpl
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getSysMLCS()
		 * @generated
		 */
		EClass SYS_MLCS = eINSTANCE.getSysMLCS();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYS_MLCS__VALUE = eINSTANCE.getSysMLCS_Value();
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclinecorecs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.TopLevelCSImpl
		 * @see org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

	}

} //OCLinEcoreCSPackage
