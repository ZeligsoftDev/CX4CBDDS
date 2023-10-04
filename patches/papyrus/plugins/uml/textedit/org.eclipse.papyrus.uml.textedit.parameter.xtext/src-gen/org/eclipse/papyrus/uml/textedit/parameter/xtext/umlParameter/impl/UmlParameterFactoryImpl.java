/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NoValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NullValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterFactory;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.Value;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlParameterFactoryImpl extends EFactoryImpl implements UmlParameterFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlParameterFactory init() {
		try {
			UmlParameterFactory theUmlParameterFactory = (UmlParameterFactory) EPackage.Registry.INSTANCE.getEFactory(UmlParameterPackage.eNS_URI);
			if (theUmlParameterFactory != null) {
				return theUmlParameterFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlParameterFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlParameterFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UmlParameterPackage.PARAMETER_RULE:
			return createParameterRule();
		case UmlParameterPackage.MODIFIERS_RULE:
			return createModifiersRule();
		case UmlParameterPackage.MODIFIER_SPECIFICATION:
			return createModifierSpecification();
		case UmlParameterPackage.VISIBILITY_RULE:
			return createVisibilityRule();
		case UmlParameterPackage.DIRECTION_RULE:
			return createDirectionRule();
		case UmlParameterPackage.EFFECT_RULE:
			return createEffectRule();
		case UmlParameterPackage.DEFAULT_VALUE_RULE:
			return createDefaultValueRule();
		case UmlParameterPackage.VALUE:
			return createValue();
		case UmlParameterPackage.INT_VALUE:
			return createIntValue();
		case UmlParameterPackage.STRING_VALUE:
			return createStringValue();
		case UmlParameterPackage.BOOLEAN_VALUE:
			return createBooleanValue();
		case UmlParameterPackage.REAL_VALUE:
			return createRealValue();
		case UmlParameterPackage.NULL_VALUE:
			return createNullValue();
		case UmlParameterPackage.NO_VALUE:
			return createNoValue();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case UmlParameterPackage.MODIFIER_KIND:
			return createModifierKindFromString(eDataType, initialValue);
		case UmlParameterPackage.EFFECT_KIND:
			return createEffectKindFromString(eDataType, initialValue);
		case UmlParameterPackage.BOOLEAN_LITERALS:
			return createBooleanLiteralsFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case UmlParameterPackage.MODIFIER_KIND:
			return convertModifierKindToString(eDataType, instanceValue);
		case UmlParameterPackage.EFFECT_KIND:
			return convertEffectKindToString(eDataType, instanceValue);
		case UmlParameterPackage.BOOLEAN_LITERALS:
			return convertBooleanLiteralsToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterRule createParameterRule() {
		ParameterRuleImpl parameterRule = new ParameterRuleImpl();
		return parameterRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifiersRule createModifiersRule() {
		ModifiersRuleImpl modifiersRule = new ModifiersRuleImpl();
		return modifiersRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifierSpecification createModifierSpecification() {
		ModifierSpecificationImpl modifierSpecification = new ModifierSpecificationImpl();
		return modifierSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityRule createVisibilityRule() {
		VisibilityRuleImpl visibilityRule = new VisibilityRuleImpl();
		return visibilityRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DirectionRule createDirectionRule() {
		DirectionRuleImpl directionRule = new DirectionRuleImpl();
		return directionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectRule createEffectRule() {
		EffectRuleImpl effectRule = new EffectRuleImpl();
		return effectRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultValueRule createDefaultValueRule() {
		DefaultValueRuleImpl defaultValueRule = new DefaultValueRuleImpl();
		return defaultValueRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IntValue createIntValue() {
		IntValueImpl intValue = new IntValueImpl();
		return intValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringValue createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanValue createBooleanValue() {
		BooleanValueImpl booleanValue = new BooleanValueImpl();
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealValue createRealValue() {
		RealValueImpl realValue = new RealValueImpl();
		return realValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NullValue createNullValue() {
		NullValueImpl nullValue = new NullValueImpl();
		return nullValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NoValue createNoValue() {
		NoValueImpl noValue = new NoValueImpl();
		return noValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifierKind createModifierKindFromString(EDataType eDataType, String initialValue) {
		ModifierKind result = ModifierKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertModifierKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectKind createEffectKindFromString(EDataType eDataType, String initialValue) {
		EffectKind result = EffectKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertEffectKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanLiterals createBooleanLiteralsFromString(EDataType eDataType, String initialValue) {
		BooleanLiterals result = BooleanLiterals.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBooleanLiteralsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlParameterPackage getUmlParameterPackage() {
		return (UmlParameterPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlParameterPackage getPackage() {
		return UmlParameterPackage.eINSTANCE;
	}

} // UmlParameterFactoryImpl
