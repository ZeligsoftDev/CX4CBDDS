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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.internal.lookup.LookupFactory
 * @generated
 */
public interface LookupPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lookup"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/Lookup"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lookup"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LookupPackage eINSTANCE = org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.internal.lookup.impl.LookupEnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupEnvironmentImpl
	 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getLookupEnvironment()
	 * @generated
	 */
	int LOOKUP_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Named Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT__NAMED_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT__PARENT_ENV = 1;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Add Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION = 0;

	/**
	 * The operation id for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = 1;

	/**
	 * The operation id for the '<em>Has Final Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT = 2;

	/**
	 * The operation id for the '<em>Get Executor</em>' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___GET_EXECUTOR = 3;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.evaluation.Executor
	 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 1;

	/**
	 * The number of structural features of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment
	 * @generated
	 */
	EClass getLookupEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getNamedElements()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_NamedElements();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Env</em>'.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getParentEnv()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_ParentEnv();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElements(java.util.Collection) <em>Add Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElements(java.util.Collection)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElements__Collection();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElement(org.eclipse.ocl.pivot.NamedElement) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#addElement(org.eclipse.ocl.pivot.NamedElement)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElement__NamedElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#hasFinalResult() <em>Has Final Result</em>}' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Final Result</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#hasFinalResult()
	 * @generated
	 */
	EOperation getLookupEnvironment__HasFinalResult();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getExecutor() <em>Get Executor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Executor</em>' operation.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getExecutor()
	 * @generated
	 */
	EOperation getLookupEnvironment__GetExecutor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executor</em>'.
	 * @see org.eclipse.ocl.pivot.evaluation.Executor
	 * @generated
	 */
	EClass getExecutor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LookupFactory getLookupFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * @noimplement This interface is not intended to be implemented by clients.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.lookup.impl.LookupEnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupEnvironmentImpl
		 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getLookupEnvironment()
		 * @generated
		 */
		EClass LOOKUP_ENVIRONMENT = eINSTANCE.getLookupEnvironment();

		/**
		 * The meta object literal for the '<em><b>Named Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP_ENVIRONMENT__NAMED_ELEMENTS = eINSTANCE.getLookupEnvironment_NamedElements();

		/**
		 * The meta object literal for the '<em><b>Parent Env</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP_ENVIRONMENT__PARENT_ENV = eINSTANCE.getLookupEnvironment_ParentEnv();

		/**
		 * The meta object literal for the '<em><b>Add Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION = eINSTANCE.getLookupEnvironment__AddElements__Collection();

		/**
		 * The meta object literal for the '<em><b>Add Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = eINSTANCE.getLookupEnvironment__AddElement__NamedElement();

		/**
		 * The meta object literal for the '<em><b>Has Final Result</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT = eINSTANCE.getLookupEnvironment__HasFinalResult();

		/**
		 * The meta object literal for the '<em><b>Get Executor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___GET_EXECUTOR = eINSTANCE.getLookupEnvironment__GetExecutor();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
		 * <!-- begin-user-doc -->
		 * @since 1.1
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.evaluation.Executor
		 * @see org.eclipse.ocl.pivot.internal.lookup.impl.LookupPackageImpl#getExecutor()
		 * @generated
		 */
		EClass EXECUTOR = eINSTANCE.getExecutor();

	}

} //LookupPackage
