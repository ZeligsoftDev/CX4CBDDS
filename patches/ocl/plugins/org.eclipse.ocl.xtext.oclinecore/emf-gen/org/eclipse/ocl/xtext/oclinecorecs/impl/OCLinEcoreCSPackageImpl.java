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
package org.eclipse.ocl.xtext.oclinecorecs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.impl.AnnotationElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSFactory;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.xtext.oclinecorecs.SysMLCS;
import org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSPackageImpl extends EPackageImpl implements OCLinEcoreCSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ocLinEcoreConstraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sysMLCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLinEcoreCSPackageImpl() {
		super(eNS_URI, OCLinEcoreCSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link OCLinEcoreCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLinEcoreCSPackage init() {
		if (isInited) return (OCLinEcoreCSPackage)EPackage.Registry.INSTANCE.getEPackage(OCLinEcoreCSPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOCLinEcoreCSPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OCLinEcoreCSPackageImpl theOCLinEcoreCSPackage = registeredOCLinEcoreCSPackage instanceof OCLinEcoreCSPackageImpl ? (OCLinEcoreCSPackageImpl)registeredOCLinEcoreCSPackage : new OCLinEcoreCSPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCLinEcoreCSPackage.createPackageContents();

		// Initialize created meta-data
		theOCLinEcoreCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLinEcoreCSPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLinEcoreCSPackage.eNS_URI, theOCLinEcoreCSPackage);
		return theOCLinEcoreCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOCLinEcoreConstraintCS()
	{
		return ocLinEcoreConstraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOCLinEcoreConstraintCS_IsCallable()
	{
		return (EAttribute)ocLinEcoreConstraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSysMLCS()
	{
		return sysMLCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSysMLCS_Value()
	{
		return (EAttribute)sysMLCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopLevelCS()
	{
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLinEcoreCSFactory getOCLinEcoreCSFactory()
	{
		return (OCLinEcoreCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ocLinEcoreConstraintCSEClass = createEClass(0);
		createEAttribute(ocLinEcoreConstraintCSEClass, ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0);

		sysMLCSEClass = createEClass(1);
		createEAttribute(sysMLCSEClass, AnnotationElementCSImpl.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0);

		topLevelCSEClass = createEClass(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ocLinEcoreConstraintCSEClass.getESuperTypes().add(theBaseCSPackage.getConstraintCS());
		sysMLCSEClass.getESuperTypes().add(theBaseCSPackage.getAnnotationElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());

		// Initialize classes and features; add operations and parameters
		initEClass(ocLinEcoreConstraintCSEClass, OCLinEcoreConstraintCS.class, "OCLinEcoreConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLinEcoreConstraintCS_IsCallable(), ecorePackage.getEBoolean(), "isCallable", null, 0, 1, OCLinEcoreConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sysMLCSEClass, SysMLCS.class, "SysMLCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSysMLCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, SysMLCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OCLinEcoreCSPackageImpl
