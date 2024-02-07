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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSFactory
 * @model kind="package"
 * @generated
 */
public interface OCLstdlibCSPackage
		extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclstdlibcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/OCLstdlibCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclstdlibcs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.xtext.oclstdlib";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSPackage eINSTANCE = org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaClassCSImpl <em>Java Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaClassCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaClassCS()
	 * @generated
	 */
	int JAVA_CLASS_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibConstraintCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibConstraintCS()
	 * @generated
	 */
	int LIB_CONSTRAINT_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibIterationCS()
	 * @generated
	 */
	int LIB_ITERATION_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOperationCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOperationCS()
	 * @generated
	 */
	int LIB_OPERATION_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOppositeCSImpl <em>Lib Opposite CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOppositeCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOppositeCS()
	 * @generated
	 */
	int LIB_OPPOSITE_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPropertyCS()
	 * @generated
	 */
	int LIB_PROPERTY_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaImplementationCSImpl <em>Java Implementation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaImplementationCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaImplementationCS()
	 * @generated
	 */
	int JAVA_IMPLEMENTATION_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibClassCS()
	 * @generated
	 */
	int LIB_CLASS_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibCoercionCSImpl <em>Lib Coercion CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibCoercionCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibCoercionCS()
	 * @generated
	 */
	int LIB_COERCION_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPackageCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPackageCS()
	 * @generated
	 */
	int LIB_PACKAGE_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibRootPackageCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibRootPackageCS()
	 * @generated
	 */
	int LIB_ROOT_PACKAGE_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.MetaclassNameCSImpl <em>Metaclass Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.MetaclassNameCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getMetaclassNameCS()
	 * @generated
	 */
	int METACLASS_NAME_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.PrecedenceCSImpl
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getPrecedenceCS()
	 * @generated
	 */
	int PRECEDENCE_CS = 12;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS <em>Java Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Class CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS
	 * @generated
	 */
	EClass getJavaClassCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS <em>Lib Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Class CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS
	 * @generated
	 */
	EClass getLibClassCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS#getMetaclassName <em>Metaclass Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass Name</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS#getMetaclassName()
	 * @see #getLibClassCS()
	 * @generated
	 */
	EReference getLibClassCS_MetaclassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS <em>Lib Coercion CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Coercion CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS
	 * @generated
	 */
	EClass getLibCoercionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS <em>Lib Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Constraint CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS
	 * @generated
	 */
	EClass getLibConstraintCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS <em>Lib Iteration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Iteration CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS
	 * @generated
	 */
	EClass getLibIterationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterators</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedIterators()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedIterators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedAccumulators <em>Owned Accumulators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulators</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#getOwnedAccumulators()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EReference getLibIterationCS_OwnedAccumulators();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsInvalidating <em>Is Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invalidating</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsInvalidating()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EAttribute getLibIterationCS_IsInvalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsValidating <em>Is Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Validating</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS#isIsValidating()
	 * @see #getLibIterationCS()
	 * @generated
	 */
	EAttribute getLibIterationCS_IsValidating();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS <em>Lib Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Operation CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS
	 * @generated
	 */
	EClass getLibOperationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedence</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#getPrecedence()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EReference getLibOperationCS_Precedence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS <em>Lib Opposite CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Opposite CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS
	 * @generated
	 */
	EClass getLibOppositeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsInvalidating <em>Is Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invalidating</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsInvalidating()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_IsInvalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsStatic()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_IsStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsValidating <em>Is Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Validating</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS#isIsValidating()
	 * @see #getLibOperationCS()
	 * @generated
	 */
	EAttribute getLibOperationCS_IsValidating();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS <em>Lib Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Package CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS
	 * @generated
	 */
	EClass getLibPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS#getOwnedPrecedences <em>Owned Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Precedences</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS#getOwnedPrecedences()
	 * @see #getLibPackageCS()
	 * @generated
	 */
	EReference getLibPackageCS_OwnedPrecedences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS <em>Lib Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Property CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS
	 * @generated
	 */
	EClass getLibPropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#isIsStatic()
	 * @see #getLibPropertyCS()
	 * @generated
	 */
	EAttribute getLibPropertyCS_IsStatic();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#getOwnedOpposite <em>Owned Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Opposite</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS#getOwnedOpposite()
	 * @see #getLibPropertyCS()
	 * @generated
	 */
	EReference getLibPropertyCS_OwnedOpposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS <em>Lib Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lib Root Package CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS
	 * @generated
	 */
	EClass getLibRootPackageCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS <em>Metaclass Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metaclass Name CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS
	 * @generated
	 */
	EClass getMetaclassNameCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS#getName()
	 * @see #getMetaclassNameCS()
	 * @generated
	 */
	EAttribute getMetaclassNameCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS <em>Java Implementation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Implementation CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS
	 * @generated
	 */
	EClass getJavaImplementationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS#getImplementation()
	 * @see #getJavaImplementationCS()
	 * @generated
	 */
	EReference getJavaImplementationCS_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS <em>Precedence CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence CS</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS
	 * @generated
	 */
	EClass getPrecedenceCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS#isIsRightAssociative <em>Is Right Associative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Right Associative</em>'.
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS#isIsRightAssociative()
	 * @see #getPrecedenceCS()
	 * @generated
	 */
	EAttribute getPrecedenceCS_IsRightAssociative();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLstdlibCSFactory getOCLstdlibCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaClassCSImpl <em>Java Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaClassCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaClassCS()
		 * @generated
		 */
		EClass JAVA_CLASS_CS = eINSTANCE.getJavaClassCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl <em>Lib Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibClassCS()
		 * @generated
		 */
		EClass LIB_CLASS_CS = eINSTANCE.getLibClassCS();

		/**
		 * The meta object literal for the '<em><b>Metaclass Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_CLASS_CS__METACLASS_NAME = eINSTANCE.getLibClassCS_MetaclassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibCoercionCSImpl <em>Lib Coercion CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibCoercionCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibCoercionCS()
		 * @generated
		 */
		EClass LIB_COERCION_CS = eINSTANCE.getLibCoercionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibConstraintCSImpl <em>Lib Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibConstraintCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibConstraintCS()
		 * @generated
		 */
		EClass LIB_CONSTRAINT_CS = eINSTANCE.getLibConstraintCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl <em>Lib Iteration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibIterationCS()
		 * @generated
		 */
		EClass LIB_ITERATION_CS = eINSTANCE.getLibIterationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ITERATORS = eINSTANCE.getLibIterationCS_OwnedIterators();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_ITERATION_CS__OWNED_ACCUMULATORS = eINSTANCE.getLibIterationCS_OwnedAccumulators();

		/**
		 * The meta object literal for the '<em><b>Is Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_ITERATION_CS__IS_INVALIDATING = eINSTANCE.getLibIterationCS_IsInvalidating();

		/**
		 * The meta object literal for the '<em><b>Is Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_ITERATION_CS__IS_VALIDATING = eINSTANCE.getLibIterationCS_IsValidating();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOperationCSImpl <em>Lib Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOperationCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOperationCS()
		 * @generated
		 */
		EClass LIB_OPERATION_CS = eINSTANCE.getLibOperationCS();

		/**
		 * The meta object literal for the '<em><b>Precedence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_OPERATION_CS__PRECEDENCE = eINSTANCE.getLibOperationCS_Precedence();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOppositeCSImpl <em>Lib Opposite CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibOppositeCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibOppositeCS()
		 * @generated
		 */
		EClass LIB_OPPOSITE_CS = eINSTANCE.getLibOppositeCS();

		/**
		 * The meta object literal for the '<em><b>Is Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__IS_INVALIDATING = eINSTANCE.getLibOperationCS_IsInvalidating();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__IS_STATIC = eINSTANCE.getLibOperationCS_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Is Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_OPERATION_CS__IS_VALIDATING = eINSTANCE.getLibOperationCS_IsValidating();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPackageCSImpl <em>Lib Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPackageCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPackageCS()
		 * @generated
		 */
		EClass LIB_PACKAGE_CS = eINSTANCE.getLibPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Precedences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_PACKAGE_CS__OWNED_PRECEDENCES = eINSTANCE.getLibPackageCS_OwnedPrecedences();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl <em>Lib Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibPropertyCS()
		 * @generated
		 */
		EClass LIB_PROPERTY_CS = eINSTANCE.getLibPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIB_PROPERTY_CS__IS_STATIC = eINSTANCE.getLibPropertyCS_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Owned Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIB_PROPERTY_CS__OWNED_OPPOSITE = eINSTANCE.getLibPropertyCS_OwnedOpposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibRootPackageCSImpl <em>Lib Root Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.LibRootPackageCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getLibRootPackageCS()
		 * @generated
		 */
		EClass LIB_ROOT_PACKAGE_CS = eINSTANCE.getLibRootPackageCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.MetaclassNameCSImpl <em>Metaclass Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.MetaclassNameCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getMetaclassNameCS()
		 * @generated
		 */
		EClass METACLASS_NAME_CS = eINSTANCE.getMetaclassNameCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METACLASS_NAME_CS__NAME = eINSTANCE.getMetaclassNameCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaImplementationCSImpl <em>Java Implementation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.JavaImplementationCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getJavaImplementationCS()
		 * @generated
		 */
		EClass JAVA_IMPLEMENTATION_CS = eINSTANCE.getJavaImplementationCS();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = eINSTANCE.getJavaImplementationCS_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.PrecedenceCSImpl <em>Precedence CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.PrecedenceCSImpl
		 * @see org.eclipse.ocl.xtext.oclstdlibcs.impl.OCLstdlibCSPackageImpl#getPrecedenceCS()
		 * @generated
		 */
		EClass PRECEDENCE_CS = eINSTANCE.getPrecedenceCS();

		/**
		 * The meta object literal for the '<em><b>Is Right Associative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECEDENCE_CS__IS_RIGHT_ASSOCIATIVE = eINSTANCE.getPrecedenceCS_IsRightAssociative();

	}

} //OCLstdlibCSPackage
