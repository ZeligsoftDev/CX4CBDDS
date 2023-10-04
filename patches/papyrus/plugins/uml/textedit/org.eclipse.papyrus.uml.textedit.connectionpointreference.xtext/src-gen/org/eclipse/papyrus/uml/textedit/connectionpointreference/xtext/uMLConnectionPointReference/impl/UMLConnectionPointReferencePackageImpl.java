/**
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferenceFactory;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UMLConnectionPointReferencePackageImpl extends EPackageImpl implements UMLConnectionPointReferencePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass connectionPointReferenceRuleEClass = null;

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
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLConnectionPointReferencePackageImpl() {
		super(eNS_URI, UMLConnectionPointReferenceFactory.eINSTANCE);
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
	 * This method is used to initialize {@link UMLConnectionPointReferencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLConnectionPointReferencePackage init() {
		if (isInited)
			return (UMLConnectionPointReferencePackage) EPackage.Registry.INSTANCE.getEPackage(UMLConnectionPointReferencePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUMLConnectionPointReferencePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UMLConnectionPointReferencePackageImpl theUMLConnectionPointReferencePackage = registeredUMLConnectionPointReferencePackage instanceof UMLConnectionPointReferencePackageImpl
				? (UMLConnectionPointReferencePackageImpl) registeredUMLConnectionPointReferencePackage
				: new UMLConnectionPointReferencePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUMLConnectionPointReferencePackage.createPackageContents();

		// Initialize created meta-data
		theUMLConnectionPointReferencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMLConnectionPointReferencePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLConnectionPointReferencePackage.eNS_URI, theUMLConnectionPointReferencePackage);
		return theUMLConnectionPointReferencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConnectionPointReferenceRule() {
		return connectionPointReferenceRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConnectionPointReferenceRule_Entry() {
		return (EReference) connectionPointReferenceRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConnectionPointReferenceRule_Exit() {
		return (EReference) connectionPointReferenceRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLConnectionPointReferenceFactory getUMLConnectionPointReferenceFactory() {
		return (UMLConnectionPointReferenceFactory) getEFactoryInstance();
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
		connectionPointReferenceRuleEClass = createEClass(CONNECTION_POINT_REFERENCE_RULE);
		createEReference(connectionPointReferenceRuleEClass, CONNECTION_POINT_REFERENCE_RULE__ENTRY);
		createEReference(connectionPointReferenceRuleEClass, CONNECTION_POINT_REFERENCE_RULE__EXIT);
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
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(connectionPointReferenceRuleEClass, ConnectionPointReferenceRule.class, "ConnectionPointReferenceRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionPointReferenceRule_Entry(), theUMLPackage.getPseudostate(), null, "entry", null, 0, -1, ConnectionPointReferenceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionPointReferenceRule_Exit(), theUMLPackage.getPseudostate(), null, "exit", null, 0, -1, ConnectionPointReferenceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // UMLConnectionPointReferencePackageImpl
