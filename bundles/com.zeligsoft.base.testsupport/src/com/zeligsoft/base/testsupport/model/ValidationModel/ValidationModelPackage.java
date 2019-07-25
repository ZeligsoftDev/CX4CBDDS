/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.testsupport.model.ValidationModel;

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
 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelFactory
 * @model kind="package"
 * @generated
 */
public interface ValidationModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ValidationModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.prismtech.com/2011/validationmodel/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "validationmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValidationModelPackage eINSTANCE = com.zeligsoft.base.testsupport.model.ValidationModel.impl.ValidationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.impl.UnitTestImpl <em>Unit Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.UnitTestImpl
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.ValidationModelPackageImpl#getUnitTest()
	 * @generated
	 */
	int UNIT_TEST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__ID = 1;

	/**
	 * The feature id for the '<em><b>Is Tested</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__IS_TESTED = 2;

	/**
	 * The number of structural features of the '<em>Unit Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.impl.TestContainerImpl <em>Test Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.TestContainerImpl
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.ValidationModelPackageImpl#getTestContainer()
	 * @generated
	 */
	int TEST_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER__TESTS = 0;

	/**
	 * The number of structural features of the '<em>Test Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest <em>Unit Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Test</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest
	 * @generated
	 */
	EClass getUnitTest();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getName()
	 * @see #getUnitTest()
	 * @generated
	 */
	EAttribute getUnitTest_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getId()
	 * @see #getUnitTest()
	 * @generated
	 */
	EAttribute getUnitTest_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#isIsTested <em>Is Tested</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Tested</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#isIsTested()
	 * @see #getUnitTest()
	 * @generated
	 */
	EAttribute getUnitTest_IsTested();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer <em>Test Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Container</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer
	 * @generated
	 */
	EClass getTestContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tests</em>'.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer#getTests()
	 * @see #getTestContainer()
	 * @generated
	 */
	EReference getTestContainer_Tests();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ValidationModelFactory getValidationModelFactory();

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
		 * The meta object literal for the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.impl.UnitTestImpl <em>Unit Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.UnitTestImpl
		 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.ValidationModelPackageImpl#getUnitTest()
		 * @generated
		 */
		EClass UNIT_TEST = eINSTANCE.getUnitTest();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TEST__NAME = eINSTANCE.getUnitTest_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TEST__ID = eINSTANCE.getUnitTest_Id();

		/**
		 * The meta object literal for the '<em><b>Is Tested</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TEST__IS_TESTED = eINSTANCE.getUnitTest_IsTested();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.impl.TestContainerImpl <em>Test Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.TestContainerImpl
		 * @see com.zeligsoft.base.testsupport.model.ValidationModel.impl.ValidationModelPackageImpl#getTestContainer()
		 * @generated
		 */
		EClass TEST_CONTAINER = eINSTANCE.getTestContainer();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CONTAINER__TESTS = eINSTANCE.getTestContainer_Tests();

	}

} //ValidationModelPackage
