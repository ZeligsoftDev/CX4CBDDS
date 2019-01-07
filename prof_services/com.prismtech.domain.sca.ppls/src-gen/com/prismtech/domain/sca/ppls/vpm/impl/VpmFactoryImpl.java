/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.impl;

import com.prismtech.domain.sca.ppls.vpm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VpmFactoryImpl extends EFactoryImpl implements VpmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VpmFactory init() {
		try {
			VpmFactory theVpmFactory = (VpmFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.prismtech.com/2012/vpm"); 
			if (theVpmFactory != null) {
				return theVpmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VpmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VpmPackage.VP_MODEL: return createVPModel();
			case VpmPackage.VARIATION_POINT: return createVariationPoint();
			case VpmPackage.VARIATION_POINT_WITH_VALUE: return createVariationPointWithValue();
			case VpmPackage.VARIATION_POINT_WITH_SETTINGS: return createVariationPointWithSettings();
			case VpmPackage.CONSTRAINED_ELEMENT: return createConstrainedElement();
			case VpmPackage.ATTRIBUTE: return createAttribute();
			case VpmPackage.CONFIGURATION: return createConfiguration();
			case VpmPackage.CONFIGURATION_POINT: return createConfigurationPoint();
			case VpmPackage.CONFIGURATION_POINT_WITH_VALUE: return createConfigurationPointWithValue();
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS: return createConfigurationPointWithSettings();
			case VpmPackage.SETTABLE_ATTRIBUTE: return createSettableAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint createVariationPoint() {
		VariationPointImpl variationPoint = new VariationPointImpl();
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPointWithValue createVariationPointWithValue() {
		VariationPointWithValueImpl variationPointWithValue = new VariationPointWithValueImpl();
		return variationPointWithValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPointWithSettings createVariationPointWithSettings() {
		VariationPointWithSettingsImpl variationPointWithSettings = new VariationPointWithSettingsImpl();
		return variationPointWithSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainedElement createConstrainedElement() {
		ConstrainedElementImpl constrainedElement = new ConstrainedElementImpl();
		return constrainedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VPModel createVPModel() {
		VPModelImpl vpModel = new VPModelImpl();
		return vpModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPoint createConfigurationPoint() {
		ConfigurationPointImpl configurationPoint = new ConfigurationPointImpl();
		return configurationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPointWithValue createConfigurationPointWithValue() {
		ConfigurationPointWithValueImpl configurationPointWithValue = new ConfigurationPointWithValueImpl();
		return configurationPointWithValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationPointWithSettings createConfigurationPointWithSettings() {
		ConfigurationPointWithSettingsImpl configurationPointWithSettings = new ConfigurationPointWithSettingsImpl();
		return configurationPointWithSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettableAttribute createSettableAttribute() {
		SettableAttributeImpl settableAttribute = new SettableAttributeImpl();
		return settableAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmPackage getVpmPackage() {
		return (VpmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VpmPackage getPackage() {
		return VpmPackage.eINSTANCE;
	}

} //VpmFactoryImpl
