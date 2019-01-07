/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.util;

import com.prismtech.domain.sca.ppls.vpm.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage
 * @generated
 */
public class VpmValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final VpmValidator INSTANCE = new VpmValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.prismtech.domain.sca.ppls.vpm"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return VpmPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case VpmPackage.VP_MODEL:
				return validateVPModel((VPModel)value, diagnostics, context);
			case VpmPackage.VARIATION_POINT:
				return validateVariationPoint((VariationPoint)value, diagnostics, context);
			case VpmPackage.VARIATION_POINT_WITH_VALUE:
				return validateVariationPointWithValue((VariationPointWithValue)value, diagnostics, context);
			case VpmPackage.VARIATION_POINT_WITH_SETTINGS:
				return validateVariationPointWithSettings((VariationPointWithSettings)value, diagnostics, context);
			case VpmPackage.CONSTRAINED_ELEMENT:
				return validateConstrainedElement((ConstrainedElement)value, diagnostics, context);
			case VpmPackage.ATTRIBUTE:
				return validateAttribute((Attribute)value, diagnostics, context);
			case VpmPackage.CONFIGURATION:
				return validateConfiguration((Configuration)value, diagnostics, context);
			case VpmPackage.CONFIGURATION_POINT:
				return validateConfigurationPoint((ConfigurationPoint)value, diagnostics, context);
			case VpmPackage.CONFIGURATION_POINT_WITH_VALUE:
				return validateConfigurationPointWithValue((ConfigurationPointWithValue)value, diagnostics, context);
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS:
				return validateConfigurationPointWithSettings((ConfigurationPointWithSettings)value, diagnostics, context);
			case VpmPackage.SETTABLE_ATTRIBUTE:
				return validateSettableAttribute((SettableAttribute)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariationPoint(VariationPoint variationPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variationPoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariationPointWithValue(VariationPointWithValue variationPointWithValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variationPointWithValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariationPointWithSettings(VariationPointWithSettings variationPointWithSettings, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variationPointWithSettings, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstrainedElement(ConstrainedElement constrainedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constrainedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVPModel(VPModel vpModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(vpModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigurationPoint(ConfigurationPoint configurationPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(configurationPoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigurationPointWithValue(ConfigurationPointWithValue configurationPointWithValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(configurationPointWithValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfigurationPointWithSettings(ConfigurationPointWithSettings configurationPointWithSettings, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(configurationPointWithSettings, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSettableAttribute(SettableAttribute settableAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(settableAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(configuration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validateConfiguration_UniqueConfigurationName(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validateConfiguration_ConfigurationNameNotEmpty(configuration, diagnostics, context);
		if (result || diagnostics != null) result &= validateConfiguration_ConfigurationFileNameContainsNoIllegalCharacters(configuration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the UniqueConfigurationName constraint of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONFIGURATION__UNIQUE_CONFIGURATION_NAME__EEXPRESSION = "\n" +
		"\t\tConfiguration.allInstances()->forAll(pc | pc <> self implies pc.name <> self.name)";

	/**
	 * Validates the UniqueConfigurationName constraint of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration_UniqueConfigurationName(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(VpmPackage.Literals.CONFIGURATION,
				 configuration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "UniqueConfigurationName",
				 CONFIGURATION__UNIQUE_CONFIGURATION_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the ConfigurationNameNotEmpty constraint of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONFIGURATION__CONFIGURATION_NAME_NOT_EMPTY__EEXPRESSION = "name.size() >0";

	/**
	 * Validates the ConfigurationNameNotEmpty constraint of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConfiguration_ConfigurationNameNotEmpty(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(VpmPackage.Literals.CONFIGURATION,
				 configuration,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "ConfigurationNameNotEmpty",
				 CONFIGURATION__CONFIGURATION_NAME_NOT_EMPTY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the ConfigurationFileNameContainsNoIllegalCharacters constraint of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * Verifies that the Configuration's name does not contain any illegal characters which would prevent proper 
	 * model and descriptors project generation. Only alphanumeric characters, hyphen and underscores are permitted. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateConfiguration_ConfigurationFileNameContainsNoIllegalCharacters(Configuration configuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean containsIllegalCharacters = configuration.getName().matches("[a-zA-Z0-9_-]*"); //$NON-NLS-1$
		if (!containsIllegalCharacters) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "ConfigurationFileNameContainsNoIllegalCharacters", getObjectLabel(configuration, context) },
						 new Object[] { configuration },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //VpmValidator
