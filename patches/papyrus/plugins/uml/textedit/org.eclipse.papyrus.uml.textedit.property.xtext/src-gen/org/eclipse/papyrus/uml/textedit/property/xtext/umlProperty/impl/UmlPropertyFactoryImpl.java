/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BooleanLiterals;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BooleanValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.IntValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierKind;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.NoValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.NullValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RealValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.StringValue;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyFactory;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.Value;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityKind;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlPropertyFactoryImpl extends EFactoryImpl implements UmlPropertyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlPropertyFactory init() {
		try {
			UmlPropertyFactory theUmlPropertyFactory = (UmlPropertyFactory) EPackage.Registry.INSTANCE.getEFactory(UmlPropertyPackage.eNS_URI);
			if (theUmlPropertyFactory != null) {
				return theUmlPropertyFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlPropertyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlPropertyFactoryImpl() {
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
		case UmlPropertyPackage.PROPERTY_RULE:
			return createPropertyRule();
		case UmlPropertyPackage.VISIBILITY_RULE:
			return createVisibilityRule();
		case UmlPropertyPackage.TYPE_RULE:
			return createTypeRule();
		case UmlPropertyPackage.QUALIFIED_NAME:
			return createQualifiedName();
		case UmlPropertyPackage.MULTIPLICITY_RULE:
			return createMultiplicityRule();
		case UmlPropertyPackage.BOUND_SPECIFICATION:
			return createBoundSpecification();
		case UmlPropertyPackage.MODIFIERS_RULE:
			return createModifiersRule();
		case UmlPropertyPackage.MODIFIER_SPECIFICATION:
			return createModifierSpecification();
		case UmlPropertyPackage.REDEFINES_RULE:
			return createRedefinesRule();
		case UmlPropertyPackage.SUBSETS_RULE:
			return createSubsetsRule();
		case UmlPropertyPackage.DEFAULT_VALUE_RULE:
			return createDefaultValueRule();
		case UmlPropertyPackage.VALUE:
			return createValue();
		case UmlPropertyPackage.INT_VALUE:
			return createIntValue();
		case UmlPropertyPackage.STRING_VALUE:
			return createStringValue();
		case UmlPropertyPackage.BOOLEAN_VALUE:
			return createBooleanValue();
		case UmlPropertyPackage.REAL_VALUE:
			return createRealValue();
		case UmlPropertyPackage.NULL_VALUE:
			return createNullValue();
		case UmlPropertyPackage.NO_VALUE:
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
		case UmlPropertyPackage.VISIBILITY_KIND:
			return createVisibilityKindFromString(eDataType, initialValue);
		case UmlPropertyPackage.MODIFIER_KIND:
			return createModifierKindFromString(eDataType, initialValue);
		case UmlPropertyPackage.BOOLEAN_LITERALS:
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
		case UmlPropertyPackage.VISIBILITY_KIND:
			return convertVisibilityKindToString(eDataType, instanceValue);
		case UmlPropertyPackage.MODIFIER_KIND:
			return convertModifierKindToString(eDataType, instanceValue);
		case UmlPropertyPackage.BOOLEAN_LITERALS:
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
	public PropertyRule createPropertyRule() {
		PropertyRuleImpl propertyRule = new PropertyRuleImpl();
		return propertyRule;
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
	public TypeRule createTypeRule() {
		TypeRuleImpl typeRule = new TypeRuleImpl();
		return typeRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualifiedName createQualifiedName() {
		QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiplicityRule createMultiplicityRule() {
		MultiplicityRuleImpl multiplicityRule = new MultiplicityRuleImpl();
		return multiplicityRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BoundSpecification createBoundSpecification() {
		BoundSpecificationImpl boundSpecification = new BoundSpecificationImpl();
		return boundSpecification;
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
	public RedefinesRule createRedefinesRule() {
		RedefinesRuleImpl redefinesRule = new RedefinesRuleImpl();
		return redefinesRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubsetsRule createSubsetsRule() {
		SubsetsRuleImpl subsetsRule = new SubsetsRuleImpl();
		return subsetsRule;
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
	public VisibilityKind createVisibilityKindFromString(EDataType eDataType, String initialValue) {
		VisibilityKind result = VisibilityKind.get(initialValue);
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
	public String convertVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public UmlPropertyPackage getUmlPropertyPackage() {
		return (UmlPropertyPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlPropertyPackage getPackage() {
		return UmlPropertyPackage.eINSTANCE;
	}

} // UmlPropertyFactoryImpl
