/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.annotations.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.annotations.ASLibrary_EPackage;
import org.eclipse.ocl.pivot.annotations.ASMetamodel_EPackage;
import org.eclipse.ocl.pivot.annotations.Collection_EClass;
import org.eclipse.ocl.pivot.annotations.Collection_EPackage;
import org.eclipse.ocl.pivot.annotations.Collection_ETypedElement;
import org.eclipse.ocl.pivot.annotations.Ecore_OCL_EClassifier;
import org.eclipse.ocl.pivot.annotations.Ecore_OCL_EOperation;
import org.eclipse.ocl.pivot.annotations.Ecore_OCL_EStructuralFeature;
import org.eclipse.ocl.pivot.annotations.Import_EPackage;
import org.eclipse.ocl.pivot.annotations.MetaAnnotation_EAnnotation;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsFactory;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PivotAnnotationsPackageImpl extends EPackageImpl implements PivotAnnotationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asLibrary_EPackageEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asMetamodel_EPackageEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collection_EClassEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collection_EPackageEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collection_ETypedElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecore_OCL_EClassifierEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecore_OCL_EOperationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecore_OCL_EStructuralFeatureEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass import_EPackageEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaAnnotation_EAnnotationEClass = null;
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
	 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PivotAnnotationsPackageImpl() {
		super(eNS_URI, PivotAnnotationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PivotAnnotationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PivotAnnotationsPackage init() {
		if (isInited) return (PivotAnnotationsPackage)EPackage.Registry.INSTANCE.getEPackage(PivotAnnotationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPivotAnnotationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PivotAnnotationsPackageImpl thePivotAnnotationsPackage = registeredPivotAnnotationsPackage instanceof PivotAnnotationsPackageImpl ? (PivotAnnotationsPackageImpl)registeredPivotAnnotationsPackage : new PivotAnnotationsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thePivotAnnotationsPackage.createPackageContents();

		// Initialize created meta-data
		thePivotAnnotationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePivotAnnotationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PivotAnnotationsPackage.eNS_URI, thePivotAnnotationsPackage);
		return thePivotAnnotationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getASLibrary_EPackage() {
		return asLibrary_EPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getASMetamodel_EPackage() {
		return asMetamodel_EPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollection_EClass() {
		return collection_EClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollection_EClass_NullFree() {
		return (EAttribute)collection_EClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollection_EPackage() {
		return collection_EPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollection_EPackage_NullFree() {
		return (EAttribute)collection_EPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollection_ETypedElement() {
		return collection_ETypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCollection_ETypedElement_NullFree() {
		return (EAttribute)collection_ETypedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEcore_OCL_EClassifier() {
		return ecore_OCL_EClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEcore_OCL_EOperation() {
		return ecore_OCL_EOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcore_OCL_EOperation_Body() {
		return (EAttribute)ecore_OCL_EOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEcore_OCL_EStructuralFeature() {
		return ecore_OCL_EStructuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEcore_OCL_EStructuralFeature_Derivation() {
		return (EAttribute)ecore_OCL_EStructuralFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImport_EPackage() {
		return import_EPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaAnnotation_EAnnotation() {
		return metaAnnotation_EAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PivotAnnotationsFactory getPivotAnnotationsFactory() {
		return (PivotAnnotationsFactory)getEFactoryInstance();
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
		asLibrary_EPackageEClass = createEClass(0);

		asMetamodel_EPackageEClass = createEClass(1);

		collection_EClassEClass = createEClass(2);
		createEAttribute(collection_EClassEClass, 0);

		collection_EPackageEClass = createEClass(3);
		createEAttribute(collection_EPackageEClass, 0);

		collection_ETypedElementEClass = createEClass(4);
		createEAttribute(collection_ETypedElementEClass, 0);

		ecore_OCL_EClassifierEClass = createEClass(5);

		ecore_OCL_EOperationEClass = createEClass(6);
		createEAttribute(ecore_OCL_EOperationEClass, 0);

		ecore_OCL_EStructuralFeatureEClass = createEClass(7);
		createEAttribute(ecore_OCL_EStructuralFeatureEClass, 0);

		import_EPackageEClass = createEClass(8);

		metaAnnotation_EAnnotationEClass = createEClass(9);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(asLibrary_EPackageEClass, ASLibrary_EPackage.class, "ASLibrary_EPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(asMetamodel_EPackageEClass, ASMetamodel_EPackage.class, "ASMetamodel_EPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collection_EClassEClass, Collection_EClass.class, "Collection_EClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollection_EClass_NullFree(), ecorePackage.getEBoolean(), "nullFree", null, 0, 1, Collection_EClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collection_EPackageEClass, Collection_EPackage.class, "Collection_EPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollection_EPackage_NullFree(), ecorePackage.getEBoolean(), "nullFree", null, 0, 1, Collection_EPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collection_ETypedElementEClass, Collection_ETypedElement.class, "Collection_ETypedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollection_ETypedElement_NullFree(), ecorePackage.getEBoolean(), "nullFree", null, 0, 1, Collection_ETypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecore_OCL_EClassifierEClass, Ecore_OCL_EClassifier.class, "Ecore_OCL_EClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ecore_OCL_EOperationEClass, Ecore_OCL_EOperation.class, "Ecore_OCL_EOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEcore_OCL_EOperation_Body(), ecorePackage.getEString(), "body", null, 1, 1, Ecore_OCL_EOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecore_OCL_EStructuralFeatureEClass, Ecore_OCL_EStructuralFeature.class, "Ecore_OCL_EStructuralFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEcore_OCL_EStructuralFeature_Derivation(), ecorePackage.getEString(), "derivation", null, 1, 1, Ecore_OCL_EStructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(import_EPackageEClass, Import_EPackage.class, "Import_EPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaAnnotation_EAnnotationEClass, MetaAnnotation_EAnnotation.class, "MetaAnnotation_EAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/MetaAnnotation
		createMetaAnnotationAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/MetaAnnotation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMetaAnnotationAnnotations() {
		String source = "http://www.eclipse.org/OCL/MetaAnnotation";
		addAnnotation
		  (asLibrary_EPackageEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EPackage")
		   });
		addAnnotation
		  (asMetamodel_EPackageEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EPackage")
		   });
		addAnnotation
		  (collection_EClassEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EClass")
		   });
		addAnnotation
		  (collection_EPackageEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EPackage")
		   });
		addAnnotation
		  (collection_ETypedElementEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//ETypedElement")
		   });
		addAnnotation
		  (ecore_OCL_EClassifierEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EClassifier")
		   });
		addAnnotation
		  (ecore_OCL_EOperationEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EOperation")
		   });
		addAnnotation
		  (ecore_OCL_EStructuralFeatureEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EStructuralFeature")
		   });
		addAnnotation
		  (import_EPackageEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EPackage")
		   });
		addAnnotation
		  (metaAnnotation_EAnnotationEClass,
		   source,
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EClass")
		   });
	}

} //AnnotationsPackageImpl
