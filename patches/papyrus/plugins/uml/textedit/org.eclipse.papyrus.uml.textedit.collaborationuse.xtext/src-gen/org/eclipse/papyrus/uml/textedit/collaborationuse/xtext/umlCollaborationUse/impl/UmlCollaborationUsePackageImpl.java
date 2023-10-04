/**
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUseFactory;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlCollaborationUsePackageImpl extends EPackageImpl implements UmlCollaborationUsePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collaborationUseRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass typeRuleEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlCollaborationUsePackageImpl() {
		super(eNS_URI, UmlCollaborationUseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link UmlCollaborationUsePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlCollaborationUsePackage init() {
		if (isInited)
			return (UmlCollaborationUsePackage) EPackage.Registry.INSTANCE.getEPackage(UmlCollaborationUsePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUmlCollaborationUsePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UmlCollaborationUsePackageImpl theUmlCollaborationUsePackage = registeredUmlCollaborationUsePackage instanceof UmlCollaborationUsePackageImpl ? (UmlCollaborationUsePackageImpl) registeredUmlCollaborationUsePackage
				: new UmlCollaborationUsePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		UmlCommonPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlCollaborationUsePackage.createPackageContents();

		// Initialize created meta-data
		theUmlCollaborationUsePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlCollaborationUsePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlCollaborationUsePackage.eNS_URI, theUmlCollaborationUsePackage);
		return theUmlCollaborationUsePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollaborationUseRule() {
		return collaborationUseRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCollaborationUseRule_Visibility() {
		return (EAttribute) collaborationUseRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCollaborationUseRule_Name() {
		return (EAttribute) collaborationUseRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollaborationUseRule_Type() {
		return (EReference) collaborationUseRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTypeRule() {
		return typeRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlCollaborationUseFactory getUmlCollaborationUseFactory() {
		return (UmlCollaborationUseFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		collaborationUseRuleEClass = createEClass(COLLABORATION_USE_RULE);
		createEAttribute(collaborationUseRuleEClass, COLLABORATION_USE_RULE__VISIBILITY);
		createEAttribute(collaborationUseRuleEClass, COLLABORATION_USE_RULE__NAME);
		createEReference(collaborationUseRuleEClass, COLLABORATION_USE_RULE__TYPE);

		typeRuleEClass = createEClass(TYPE_RULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UmlCommonPackage theUmlCommonPackage = (UmlCommonPackage) EPackage.Registry.INSTANCE.getEPackage(UmlCommonPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		typeRuleEClass.getESuperTypes().add(theUmlCommonPackage.getTypeRule());

		// Initialize classes and features; add operations and parameters
		initEClass(collaborationUseRuleEClass, CollaborationUseRule.class, "CollaborationUseRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollaborationUseRule_Visibility(), theUmlCommonPackage.getVisibilityKind(), "visibility", null, 0, 1, CollaborationUseRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCollaborationUseRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CollaborationUseRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollaborationUseRule_Type(), this.getTypeRule(), null, "type", null, 0, 1, CollaborationUseRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeRuleEClass, TypeRule.class, "TypeRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // UmlCollaborationUsePackageImpl
