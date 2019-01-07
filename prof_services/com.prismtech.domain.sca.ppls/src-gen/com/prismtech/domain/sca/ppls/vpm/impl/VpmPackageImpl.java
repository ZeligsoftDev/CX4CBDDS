/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.impl;


import com.prismtech.domain.sca.ppls.vpm.Attribute;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.ConstrainedElement;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.vpm.VpmFactory;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue;
import com.prismtech.domain.sca.ppls.vpm.util.VpmValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VpmPackageImpl extends EPackageImpl implements VpmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointWithValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointWithSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vpModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationPointWithValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationPointWithSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settableAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

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
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VpmPackageImpl() {
		super(eNS_URI, VpmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VpmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VpmPackage init() {
		if (isInited) return (VpmPackage)EPackage.Registry.INSTANCE.getEPackage(VpmPackage.eNS_URI);

		// Obtain or create and register package
		VpmPackageImpl theVpmPackage = (VpmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VpmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VpmPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theVpmPackage.createPackageContents();

		// Initialize created meta-data
		theVpmPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theVpmPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return VpmValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theVpmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VpmPackage.eNS_URI, theVpmPackage);
		return theVpmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPoint() {
		return variationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariationPoint_Name() {
		return (EAttribute)variationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_ConstrainedElements() {
		return (EReference)variationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariationPoint_Id() {
		return (EAttribute)variationPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPointWithValue() {
		return variationPointWithValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPointWithSettings() {
		return variationPointWithSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstrainedElement() {
		return constrainedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstrainedElement_Name() {
		return (EAttribute)constrainedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstrainedElement_QualifiedName() {
		return (EAttribute)constrainedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainedElement_Attributes() {
		return (EReference)constrainedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Name() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVPModel() {
		return vpModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVPModel_Name() {
		return (EAttribute)vpModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVPModel_VariationPoints() {
		return (EReference)vpModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVPModel_Configurations() {
		return (EReference)vpModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVPModel_Source() {
		return (EAttribute)vpModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVPModel_QualifiedName() {
		return (EAttribute)vpModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationPoint() {
		return configurationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationPoint_Generate() {
		return (EAttribute)configurationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationPoint_Name() {
		return (EAttribute)configurationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationPoint_VariationPoint() {
		return (EReference)configurationPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationPointWithValue() {
		return configurationPointWithValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationPointWithValue_Value() {
		return (EAttribute)configurationPointWithValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationPointWithSettings() {
		return configurationPointWithSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationPointWithSettings_SettableAttributes() {
		return (EReference)configurationPointWithSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettableAttribute() {
		return settableAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettableAttribute_Name() {
		return (EAttribute)settableAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettableAttribute_Value() {
		return (EAttribute)settableAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_ConfigurationPoints() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Name() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_GenerateDescriptors() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmFactory getVpmFactory() {
		return (VpmFactory)getEFactoryInstance();
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
		vpModelEClass = createEClass(VP_MODEL);
		createEAttribute(vpModelEClass, VP_MODEL__NAME);
		createEReference(vpModelEClass, VP_MODEL__VARIATION_POINTS);
		createEReference(vpModelEClass, VP_MODEL__CONFIGURATIONS);
		createEAttribute(vpModelEClass, VP_MODEL__SOURCE);
		createEAttribute(vpModelEClass, VP_MODEL__QUALIFIED_NAME);

		variationPointEClass = createEClass(VARIATION_POINT);
		createEAttribute(variationPointEClass, VARIATION_POINT__NAME);
		createEReference(variationPointEClass, VARIATION_POINT__CONSTRAINED_ELEMENTS);
		createEAttribute(variationPointEClass, VARIATION_POINT__ID);

		variationPointWithValueEClass = createEClass(VARIATION_POINT_WITH_VALUE);

		variationPointWithSettingsEClass = createEClass(VARIATION_POINT_WITH_SETTINGS);

		constrainedElementEClass = createEClass(CONSTRAINED_ELEMENT);
		createEAttribute(constrainedElementEClass, CONSTRAINED_ELEMENT__NAME);
		createEAttribute(constrainedElementEClass, CONSTRAINED_ELEMENT__QUALIFIED_NAME);
		createEReference(constrainedElementEClass, CONSTRAINED_ELEMENT__ATTRIBUTES);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__NAME);

		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__CONFIGURATION_POINTS);
		createEAttribute(configurationEClass, CONFIGURATION__NAME);
		createEAttribute(configurationEClass, CONFIGURATION__GENERATE_DESCRIPTORS);

		configurationPointEClass = createEClass(CONFIGURATION_POINT);
		createEAttribute(configurationPointEClass, CONFIGURATION_POINT__GENERATE);
		createEAttribute(configurationPointEClass, CONFIGURATION_POINT__NAME);
		createEReference(configurationPointEClass, CONFIGURATION_POINT__VARIATION_POINT);

		configurationPointWithValueEClass = createEClass(CONFIGURATION_POINT_WITH_VALUE);
		createEAttribute(configurationPointWithValueEClass, CONFIGURATION_POINT_WITH_VALUE__VALUE);

		configurationPointWithSettingsEClass = createEClass(CONFIGURATION_POINT_WITH_SETTINGS);
		createEReference(configurationPointWithSettingsEClass, CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES);

		settableAttributeEClass = createEClass(SETTABLE_ATTRIBUTE);
		createEAttribute(settableAttributeEClass, SETTABLE_ATTRIBUTE__NAME);
		createEAttribute(settableAttributeEClass, SETTABLE_ATTRIBUTE__VALUE);
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
		variationPointWithValueEClass.getESuperTypes().add(this.getVariationPoint());
		variationPointWithSettingsEClass.getESuperTypes().add(this.getVariationPoint());
		configurationPointWithValueEClass.getESuperTypes().add(this.getConfigurationPoint());
		configurationPointWithSettingsEClass.getESuperTypes().add(this.getConfigurationPoint());

		// Initialize classes and features; add operations and parameters
		initEClass(vpModelEClass, VPModel.class, "VPModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVPModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, VPModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVPModel_VariationPoints(), this.getVariationPoint(), null, "variationPoints", null, 0, -1, VPModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVPModel_Configurations(), this.getConfiguration(), null, "configurations", null, 0, -1, VPModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVPModel_Source(), ecorePackage.getEString(), "source", null, 0, 1, VPModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVPModel_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, VPModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class, "VariationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariationPoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariationPoint_ConstrainedElements(), this.getConstrainedElement(), null, "constrainedElements", null, 0, -1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariationPoint_Id(), ecorePackage.getEString(), "id", "", 1, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationPointWithValueEClass, VariationPointWithValue.class, "VariationPointWithValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variationPointWithSettingsEClass, VariationPointWithSettings.class, "VariationPointWithSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constrainedElementEClass, ConstrainedElement.class, "ConstrainedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstrainedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConstrainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainedElement_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, ConstrainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstrainedElement_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ConstrainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_ConfigurationPoints(), this.getConfigurationPoint(), null, "configurationPoints", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Name(), ecorePackage.getEString(), "name", "VPModelConfig_", 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_GenerateDescriptors(), ecorePackage.getEBoolean(), "generateDescriptors", "false", 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationPointEClass, ConfigurationPoint.class, "ConfigurationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationPoint_Generate(), ecorePackage.getEBoolean(), "generate", "true", 0, 1, ConfigurationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationPoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConfigurationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationPoint_VariationPoint(), this.getVariationPoint(), null, "variationPoint", null, 1, 1, ConfigurationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationPointWithValueEClass, ConfigurationPointWithValue.class, "ConfigurationPointWithValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationPointWithValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConfigurationPointWithValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationPointWithSettingsEClass, ConfigurationPointWithSettings.class, "ConfigurationPointWithSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationPointWithSettings_SettableAttributes(), this.getSettableAttribute(), null, "settableAttributes", null, 0, -1, ConfigurationPointWithSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settableAttributeEClass, SettableAttribute.class, "SettableAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSettableAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, SettableAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettableAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, SettableAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/Java
		createJavaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });		
		addAnnotation
		  (configurationEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueConfigurationName ConfigurationNameNotEmpty ConfigurationFileNameContainsNoIllegalCharacters"
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";				
		addAnnotation
		  (configurationEClass, 
		   source, 
		   new String[] {
			 "UniqueConfigurationName", "\n\t\tConfiguration.allInstances()->forAll(pc | pc <> self implies pc.name <> self.name)",
			 "ConfigurationNameNotEmpty", "name.size() >0"
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/Java</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createJavaAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/Java";					
		addAnnotation
		  (configurationEClass, 
		   source, 
		   new String[] {
			 "ConfigurationFileNameContainsNoIllegalCharacters", "[a-zA-Z0-9_-]*"
		   });
	}

} //VpmPackageImpl
