/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Port;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelFactory;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemvueModelPackageImpl extends EPackageImpl implements SystemvueModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemvueModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum implementationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum implementationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeNameTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType directionTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType implementationObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType implementationTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeNameObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeNameTypeObjectEDataType = null;

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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SystemvueModelPackageImpl() {
		super(eNS_URI, SystemvueModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SystemvueModelPackage init() {
		if (isInited) return (SystemvueModelPackage)EPackage.Registry.INSTANCE.getEPackage(SystemvueModelPackage.eNS_URI);

		// Obtain or create and register package
		SystemvueModelPackageImpl theSystemvueModelPackage = (SystemvueModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SystemvueModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SystemvueModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSystemvueModelPackage.createPackageContents();

		// Initialize created meta-data
		theSystemvueModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSystemvueModelPackage.freeze();

		return theSystemvueModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HeaderFile() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Parameter() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Port() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SystemvueModel() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderFile() {
		return headerFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderFile_Name() {
		return (EAttribute)headerFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Description() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Implementation() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_MemberName() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_SizeName() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_TypeName() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_BusSize() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Description() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Direction() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Implementation() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_MemberName() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Name() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Rate() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_RateVariableName() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_TypeName() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemvueModel() {
		return systemvueModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemvueModel_Group() {
		return (EAttribute)systemvueModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemvueModel_Parameter() {
		return (EReference)systemvueModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemvueModel_HeaderFile() {
		return (EReference)systemvueModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemvueModel_Port() {
		return (EReference)systemvueModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemvueModel_Description() {
		return (EAttribute)systemvueModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemvueModel_Name() {
		return (EAttribute)systemvueModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemvueModel_Namespace() {
		return (EAttribute)systemvueModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemvueModel_TypeName() {
		return (EAttribute)systemvueModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionType() {
		return directionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImplementation() {
		return implementationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImplementationType() {
		return implementationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeName() {
		return typeNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeNameType() {
		return typeNameTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDirectionTypeObject() {
		return directionTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImplementationObject() {
		return implementationObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImplementationTypeObject() {
		return implementationTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeNameObject() {
		return typeNameObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeNameTypeObject() {
		return typeNameTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemvueModelFactory getSystemvueModelFactory() {
		return (SystemvueModelFactory)getEFactoryInstance();
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
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HEADER_FILE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARAMETER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PORT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SYSTEMVUE_MODEL);

		headerFileEClass = createEClass(HEADER_FILE);
		createEAttribute(headerFileEClass, HEADER_FILE__NAME);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__DESCRIPTION);
		createEAttribute(parameterEClass, PARAMETER__IMPLEMENTATION);
		createEAttribute(parameterEClass, PARAMETER__MEMBER_NAME);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__SIZE_NAME);
		createEAttribute(parameterEClass, PARAMETER__TYPE_NAME);

		portEClass = createEClass(PORT);
		createEAttribute(portEClass, PORT__BUS_SIZE);
		createEAttribute(portEClass, PORT__DESCRIPTION);
		createEAttribute(portEClass, PORT__DIRECTION);
		createEAttribute(portEClass, PORT__IMPLEMENTATION);
		createEAttribute(portEClass, PORT__MEMBER_NAME);
		createEAttribute(portEClass, PORT__NAME);
		createEAttribute(portEClass, PORT__RATE);
		createEAttribute(portEClass, PORT__RATE_VARIABLE_NAME);
		createEAttribute(portEClass, PORT__TYPE_NAME);

		systemvueModelEClass = createEClass(SYSTEMVUE_MODEL);
		createEAttribute(systemvueModelEClass, SYSTEMVUE_MODEL__GROUP);
		createEReference(systemvueModelEClass, SYSTEMVUE_MODEL__PARAMETER);
		createEReference(systemvueModelEClass, SYSTEMVUE_MODEL__HEADER_FILE);
		createEReference(systemvueModelEClass, SYSTEMVUE_MODEL__PORT);
		createEAttribute(systemvueModelEClass, SYSTEMVUE_MODEL__DESCRIPTION);
		createEAttribute(systemvueModelEClass, SYSTEMVUE_MODEL__NAME);
		createEAttribute(systemvueModelEClass, SYSTEMVUE_MODEL__NAMESPACE);
		createEAttribute(systemvueModelEClass, SYSTEMVUE_MODEL__TYPE_NAME);

		// Create enums
		directionTypeEEnum = createEEnum(DIRECTION_TYPE);
		implementationEEnum = createEEnum(IMPLEMENTATION);
		implementationTypeEEnum = createEEnum(IMPLEMENTATION_TYPE);
		typeNameEEnum = createEEnum(TYPE_NAME);
		typeNameTypeEEnum = createEEnum(TYPE_NAME_TYPE);

		// Create data types
		directionTypeObjectEDataType = createEDataType(DIRECTION_TYPE_OBJECT);
		implementationObjectEDataType = createEDataType(IMPLEMENTATION_OBJECT);
		implementationTypeObjectEDataType = createEDataType(IMPLEMENTATION_TYPE_OBJECT);
		typeNameObjectEDataType = createEDataType(TYPE_NAME_OBJECT);
		typeNameTypeObjectEDataType = createEDataType(TYPE_NAME_TYPE_OBJECT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HeaderFile(), this.getHeaderFile(), null, "headerFile", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Parameter(), this.getParameter(), null, "parameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Port(), this.getPort(), null, "port", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SystemvueModel(), this.getSystemvueModel(), null, "systemvueModel", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(headerFileEClass, HeaderFile.class, "HeaderFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeaderFile_Name(), theXMLTypePackage.getAnySimpleType(), "name", null, 1, 1, HeaderFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Description(), theXMLTypePackage.getAnySimpleType(), "description", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Implementation(), this.getImplementation(), "implementation", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_MemberName(), theXMLTypePackage.getAnySimpleType(), "memberName", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Name(), theXMLTypePackage.getAnySimpleType(), "name", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_SizeName(), theXMLTypePackage.getAnySimpleType(), "sizeName", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_TypeName(), this.getTypeName(), "typeName", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPort_BusSize(), theXMLTypePackage.getAnySimpleType(), "busSize", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Description(), theXMLTypePackage.getAnySimpleType(), "description", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Direction(), this.getDirectionType(), "direction", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Implementation(), this.getImplementationType(), "implementation", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_MemberName(), theXMLTypePackage.getAnySimpleType(), "memberName", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Name(), theXMLTypePackage.getAnySimpleType(), "name", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Rate(), theXMLTypePackage.getAnySimpleType(), "rate", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_RateVariableName(), theXMLTypePackage.getAnySimpleType(), "rateVariableName", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_TypeName(), this.getTypeNameType(), "typeName", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemvueModelEClass, SystemvueModel.class, "SystemvueModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemvueModel_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, SystemvueModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemvueModel_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, SystemvueModel.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSystemvueModel_HeaderFile(), this.getHeaderFile(), null, "headerFile", null, 0, -1, SystemvueModel.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSystemvueModel_Port(), this.getPort(), null, "port", null, 0, -1, SystemvueModel.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemvueModel_Description(), theXMLTypePackage.getAnySimpleType(), "description", null, 0, 1, SystemvueModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemvueModel_Name(), theXMLTypePackage.getAnySimpleType(), "name", null, 1, 1, SystemvueModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemvueModel_Namespace(), theXMLTypePackage.getAnySimpleType(), "namespace", null, 0, 1, SystemvueModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemvueModel_TypeName(), theXMLTypePackage.getAnySimpleType(), "typeName", null, 0, 1, SystemvueModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(directionTypeEEnum, DirectionType.class, "DirectionType");
		addEEnumLiteral(directionTypeEEnum, DirectionType.INPUT);
		addEEnumLiteral(directionTypeEEnum, DirectionType.OUTPUT);

		initEEnum(implementationEEnum, Implementation.class, "Implementation");
		addEEnumLiteral(implementationEEnum, Implementation.SCALAR);
		addEEnumLiteral(implementationEEnum, Implementation.ARRAY);
		addEEnumLiteral(implementationEEnum, Implementation.ENUMERATION);

		initEEnum(implementationTypeEEnum, ImplementationType.class, "ImplementationType");
		addEEnumLiteral(implementationTypeEEnum, ImplementationType.SCALAR);
		addEEnumLiteral(implementationTypeEEnum, ImplementationType.ARRAY);
		addEEnumLiteral(implementationTypeEEnum, ImplementationType.CIRCULAR_BUFFER);
		addEEnumLiteral(implementationTypeEEnum, ImplementationType.CIRCULAR_BUFFER_BUS);

		initEEnum(typeNameEEnum, TypeName.class, "TypeName");
		addEEnumLiteral(typeNameEEnum, TypeName.INT);
		addEEnumLiteral(typeNameEEnum, TypeName.DOUBLE);
		addEEnumLiteral(typeNameEEnum, TypeName.COMPLEX_DOUBLE);
		addEEnumLiteral(typeNameEEnum, TypeName.CHAR);

		initEEnum(typeNameTypeEEnum, TypeNameType.class, "TypeNameType");
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.INT);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.BOOL);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.FLOAT);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.DOUBLE);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.STD_COMPLEX_DOUBLE);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.STD_COMPLEX_FLOAT);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_BOOL);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_INT);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_DOUBLE);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_STD_COMPLEX_DOUBLE);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_FLOAT);
		addEEnumLiteral(typeNameTypeEEnum, TypeNameType.AGILENT_EESOF_MATRIX_STD_COMPLEX_FLOAT);

		// Initialize data types
		initEDataType(directionTypeObjectEDataType, DirectionType.class, "DirectionTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(implementationObjectEDataType, Implementation.class, "ImplementationObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(implementationTypeObjectEDataType, ImplementationType.class, "ImplementationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeNameObjectEDataType, TypeName.class, "TypeNameObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeNameTypeObjectEDataType, TypeNameType.class, "TypeNameTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });		
		addAnnotation
		  (directionTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "direction_._type"
		   });		
		addAnnotation
		  (directionTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "direction_._type:Object",
			 "baseType", "direction_._type"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_HeaderFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "header_file",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_SystemvueModel(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "systemvue_model",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (headerFileEClass, 
		   source, 
		   new String[] {
			 "name", "header_file",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getHeaderFile_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (implementationEEnum, 
		   source, 
		   new String[] {
			 "name", "implementation"
		   });		
		addAnnotation
		  (implementationObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "implementation:Object",
			 "baseType", "implementation"
		   });		
		addAnnotation
		  (implementationTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "implementation_._type"
		   });		
		addAnnotation
		  (implementationTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "implementation_._type:Object",
			 "baseType", "implementation_._type"
		   });		
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "name", "parameter",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getParameter_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_MemberName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "member_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_SizeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "size_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_TypeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (portEClass, 
		   source, 
		   new String[] {
			 "name", "port",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPort_BusSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "bus_size",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_Direction(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "direction",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_MemberName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "member_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_Rate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_RateVariableName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rate_variable_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPort_TypeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (systemvueModelEClass, 
		   source, 
		   new String[] {
			 "name", "systemvue_model",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSystemvueModel_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getSystemvueModel_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });		
		addAnnotation
		  (getSystemvueModel_HeaderFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "header_file",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });		
		addAnnotation
		  (getSystemvueModel_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });		
		addAnnotation
		  (getSystemvueModel_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSystemvueModel_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSystemvueModel_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSystemvueModel_TypeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type_name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (typeNameEEnum, 
		   source, 
		   new String[] {
			 "name", "type_name"
		   });		
		addAnnotation
		  (typeNameObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "type_name:Object",
			 "baseType", "type_name"
		   });		
		addAnnotation
		  (typeNameTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "type_name_._type"
		   });		
		addAnnotation
		  (typeNameTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "type_name_._type:Object",
			 "baseType", "type_name_._type"
		   });
	}

} //SystemvueModelPackageImpl
