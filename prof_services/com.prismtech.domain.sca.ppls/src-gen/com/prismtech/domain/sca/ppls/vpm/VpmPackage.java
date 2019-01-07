/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;

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
 * @see com.prismtech.domain.sca.ppls.vpm.VpmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface VpmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vpm"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.prismtech.com/2012/vpm"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vpm"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VpmPackage eINSTANCE = com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 1;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithValueImpl <em>Variation Point With Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithValueImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPointWithValue()
	 * @generated
	 */
	int VARIATION_POINT_WITH_VALUE = 2;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithSettingsImpl <em>Variation Point With Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithSettingsImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPointWithSettings()
	 * @generated
	 */
	int VARIATION_POINT_WITH_SETTINGS = 3;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConstrainedElementImpl <em>Constrained Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConstrainedElementImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConstrainedElement()
	 * @generated
	 */
	int CONSTRAINED_ELEMENT = 4;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.AttributeImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 5;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VPModelImpl <em>VP Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VPModelImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVPModel()
	 * @generated
	 */
	int VP_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL__VARIATION_POINTS = 1;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL__CONFIGURATIONS = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL__SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL__QUALIFIED_NAME = 4;

	/**
	 * The number of structural features of the '<em>VP Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VP_MODEL_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Constrained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__CONSTRAINED_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__ID = 2;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_VALUE__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Constrained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_VALUE__CONSTRAINED_ELEMENTS = VARIATION_POINT__CONSTRAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_VALUE__ID = VARIATION_POINT__ID;

	/**
	 * The number of structural features of the '<em>Variation Point With Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_VALUE_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_SETTINGS__NAME = VARIATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Constrained Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_SETTINGS__CONSTRAINED_ELEMENTS = VARIATION_POINT__CONSTRAINED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_SETTINGS__ID = VARIATION_POINT__ID;

	/**
	 * The number of structural features of the '<em>Variation Point With Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_WITH_SETTINGS_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_ELEMENT__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_ELEMENT__ATTRIBUTES = 2;

	/**
	 * The number of structural features of the '<em>Constrained Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl <em>Configuration Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPoint()
	 * @generated
	 */
	int CONFIGURATION_POINT = 7;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithValueImpl <em>Configuration Point With Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithValueImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPointWithValue()
	 * @generated
	 */
	int CONFIGURATION_POINT_WITH_VALUE = 8;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithSettingsImpl <em>Configuration Point With Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithSettingsImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPointWithSettings()
	 * @generated
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS = 9;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.SettableAttributeImpl <em>Settable Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.SettableAttributeImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getSettableAttribute()
	 * @generated
	 */
	int SETTABLE_ATTRIBUTE = 10;

	/**
	 * The meta object id for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl
	 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 6;

	/**
	 * The feature id for the '<em><b>Configuration Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIGURATION_POINTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Generate Descriptors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__GENERATE_DESCRIPTORS = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT__GENERATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT__VARIATION_POINT = 2;

	/**
	 * The number of structural features of the '<em>Configuration Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_VALUE__GENERATE = CONFIGURATION_POINT__GENERATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_VALUE__NAME = CONFIGURATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_VALUE__VARIATION_POINT = CONFIGURATION_POINT__VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_VALUE__VALUE = CONFIGURATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configuration Point With Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_VALUE_FEATURE_COUNT = CONFIGURATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS__GENERATE = CONFIGURATION_POINT__GENERATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS__NAME = CONFIGURATION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Variation Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS__VARIATION_POINT = CONFIGURATION_POINT__VARIATION_POINT;

	/**
	 * The feature id for the '<em><b>Settable Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES = CONFIGURATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configuration Point With Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_POINT_WITH_SETTINGS_FEATURE_COUNT = CONFIGURATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTABLE_ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTABLE_ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Settable Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTABLE_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPoint#getName()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EAttribute getVariationPoint_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getConstrainedElements <em>Constrained Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constrained Elements</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPoint#getConstrainedElements()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_ConstrainedElements();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPoint#getId()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EAttribute getVariationPoint_Id();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue <em>Variation Point With Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point With Value</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue
	 * @generated
	 */
	EClass getVariationPointWithValue();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings <em>Variation Point With Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point With Settings</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings
	 * @generated
	 */
	EClass getVariationPointWithSettings();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Element</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConstrainedElement
	 * @generated
	 */
	EClass getConstrainedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getName()
	 * @see #getConstrainedElement()
	 * @generated
	 */
	EAttribute getConstrainedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getQualifiedName()
	 * @see #getConstrainedElement()
	 * @generated
	 */
	EAttribute getConstrainedElement_QualifiedName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConstrainedElement#getAttributes()
	 * @see #getConstrainedElement()
	 * @generated
	 */
	EReference getConstrainedElement_Attributes();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.VPModel <em>VP Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VP Model</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel
	 * @generated
	 */
	EClass getVPModel();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.VPModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel#getName()
	 * @see #getVPModel()
	 * @generated
	 */
	EAttribute getVPModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.VPModel#getVariationPoints <em>Variation Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variation Points</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel#getVariationPoints()
	 * @see #getVPModel()
	 * @generated
	 */
	EReference getVPModel_VariationPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.VPModel#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel#getConfigurations()
	 * @see #getVPModel()
	 * @generated
	 */
	EReference getVPModel_Configurations();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.VPModel#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel#getSource()
	 * @see #getVPModel()
	 * @generated
	 */
	EAttribute getVPModel_Source();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.VPModel#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel#getQualifiedName()
	 * @see #getVPModel()
	 * @generated
	 */
	EAttribute getVPModel_QualifiedName();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint <em>Configuration Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Point</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint
	 * @generated
	 */
	EClass getConfigurationPoint();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#isGenerate <em>Generate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#isGenerate()
	 * @see #getConfigurationPoint()
	 * @generated
	 */
	EAttribute getConfigurationPoint_Generate();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getName()
	 * @see #getConfigurationPoint()
	 * @generated
	 */
	EAttribute getConfigurationPoint_Name();

	/**
	 * Returns the meta object for the reference '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getVariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variation Point</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getVariationPoint()
	 * @see #getConfigurationPoint()
	 * @generated
	 */
	EReference getConfigurationPoint_VariationPoint();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue <em>Configuration Point With Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Point With Value</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue
	 * @generated
	 */
	EClass getConfigurationPointWithValue();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue#getValue()
	 * @see #getConfigurationPointWithValue()
	 * @generated
	 */
	EAttribute getConfigurationPointWithValue_Value();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings <em>Configuration Point With Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Point With Settings</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings
	 * @generated
	 */
	EClass getConfigurationPointWithSettings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings#getSettableAttributes <em>Settable Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settable Attributes</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings#getSettableAttributes()
	 * @see #getConfigurationPointWithSettings()
	 * @generated
	 */
	EReference getConfigurationPointWithSettings_SettableAttributes();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.SettableAttribute <em>Settable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settable Attribute</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.SettableAttribute
	 * @generated
	 */
	EClass getSettableAttribute();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.SettableAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.SettableAttribute#getName()
	 * @see #getSettableAttribute()
	 * @generated
	 */
	EAttribute getSettableAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.SettableAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.SettableAttribute#getValue()
	 * @see #getSettableAttribute()
	 * @generated
	 */
	EAttribute getSettableAttribute_Value();

	/**
	 * Returns the meta object for class '{@link com.prismtech.domain.sca.ppls.vpm.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.prismtech.domain.sca.ppls.vpm.Configuration#getConfigurationPoints <em>Configuration Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration Points</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Configuration#getConfigurationPoints()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigurationPoints();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.prismtech.domain.sca.ppls.vpm.Configuration#isGenerateDescriptors <em>Generate Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Descriptors</em>'.
	 * @see com.prismtech.domain.sca.ppls.vpm.Configuration#isGenerateDescriptors()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_GenerateDescriptors();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VpmFactory getVpmFactory();

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
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_POINT__NAME = eINSTANCE.getVariationPoint_Name();

		/**
		 * The meta object literal for the '<em><b>Constrained Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__CONSTRAINED_ELEMENTS = eINSTANCE.getVariationPoint_ConstrainedElements();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_POINT__ID = eINSTANCE.getVariationPoint_Id();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithValueImpl <em>Variation Point With Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithValueImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPointWithValue()
		 * @generated
		 */
		EClass VARIATION_POINT_WITH_VALUE = eINSTANCE.getVariationPointWithValue();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithSettingsImpl <em>Variation Point With Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VariationPointWithSettingsImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVariationPointWithSettings()
		 * @generated
		 */
		EClass VARIATION_POINT_WITH_SETTINGS = eINSTANCE.getVariationPointWithSettings();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConstrainedElementImpl <em>Constrained Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConstrainedElementImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConstrainedElement()
		 * @generated
		 */
		EClass CONSTRAINED_ELEMENT = eINSTANCE.getConstrainedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINED_ELEMENT__NAME = eINSTANCE.getConstrainedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINED_ELEMENT__QUALIFIED_NAME = eINSTANCE.getConstrainedElement_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_ELEMENT__ATTRIBUTES = eINSTANCE.getConstrainedElement_Attributes();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.AttributeImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.VPModelImpl <em>VP Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VPModelImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getVPModel()
		 * @generated
		 */
		EClass VP_MODEL = eINSTANCE.getVPModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VP_MODEL__NAME = eINSTANCE.getVPModel_Name();

		/**
		 * The meta object literal for the '<em><b>Variation Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VP_MODEL__VARIATION_POINTS = eINSTANCE.getVPModel_VariationPoints();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VP_MODEL__CONFIGURATIONS = eINSTANCE.getVPModel_Configurations();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VP_MODEL__SOURCE = eINSTANCE.getVPModel_Source();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VP_MODEL__QUALIFIED_NAME = eINSTANCE.getVPModel_QualifiedName();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl <em>Configuration Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPoint()
		 * @generated
		 */
		EClass CONFIGURATION_POINT = eINSTANCE.getConfigurationPoint();

		/**
		 * The meta object literal for the '<em><b>Generate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_POINT__GENERATE = eINSTANCE.getConfigurationPoint_Generate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_POINT__NAME = eINSTANCE.getConfigurationPoint_Name();

		/**
		 * The meta object literal for the '<em><b>Variation Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_POINT__VARIATION_POINT = eINSTANCE.getConfigurationPoint_VariationPoint();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithValueImpl <em>Configuration Point With Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithValueImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPointWithValue()
		 * @generated
		 */
		EClass CONFIGURATION_POINT_WITH_VALUE = eINSTANCE.getConfigurationPointWithValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_POINT_WITH_VALUE__VALUE = eINSTANCE.getConfigurationPointWithValue_Value();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithSettingsImpl <em>Configuration Point With Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithSettingsImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfigurationPointWithSettings()
		 * @generated
		 */
		EClass CONFIGURATION_POINT_WITH_SETTINGS = eINSTANCE.getConfigurationPointWithSettings();

		/**
		 * The meta object literal for the '<em><b>Settable Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES = eINSTANCE.getConfigurationPointWithSettings_SettableAttributes();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.SettableAttributeImpl <em>Settable Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.SettableAttributeImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getSettableAttribute()
		 * @generated
		 */
		EClass SETTABLE_ATTRIBUTE = eINSTANCE.getSettableAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTABLE_ATTRIBUTE__NAME = eINSTANCE.getSettableAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTABLE_ATTRIBUTE__VALUE = eINSTANCE.getSettableAttribute_Value();

		/**
		 * The meta object literal for the '{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl
		 * @see com.prismtech.domain.sca.ppls.vpm.impl.VpmPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configuration Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIGURATION_POINTS = eINSTANCE.getConfiguration_ConfigurationPoints();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Generate Descriptors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__GENERATE_DESCRIPTORS = eINSTANCE.getConfiguration_GenerateDescriptors();

	}

} //VpmPackage
