/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanLiterals;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.IntValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NoValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NullValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.StringValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortFactory;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.Value;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlPortFactoryImpl extends EFactoryImpl implements UmlPortFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlPortFactory init() {
		try {
			UmlPortFactory theUmlPortFactory = (UmlPortFactory) EPackage.Registry.INSTANCE.getEFactory(UmlPortPackage.eNS_URI);
			if (theUmlPortFactory != null) {
				return theUmlPortFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlPortFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlPortFactoryImpl() {
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
		case UmlPortPackage.PORT_RULE:
			return createPortRule();
		case UmlPortPackage.VISIBILITY_RULE:
			return createVisibilityRule();
		case UmlPortPackage.TYPE_RULE:
			return createTypeRule();
		case UmlPortPackage.QUALIFIED_NAME:
			return createQualifiedName();
		case UmlPortPackage.MULTIPLICITY_RULE:
			return createMultiplicityRule();
		case UmlPortPackage.BOUND_SPECIFICATION:
			return createBoundSpecification();
		case UmlPortPackage.MODIFIERS_RULE:
			return createModifiersRule();
		case UmlPortPackage.MODIFIER_SPECIFICATION:
			return createModifierSpecification();
		case UmlPortPackage.REDEFINES_RULE:
			return createRedefinesRule();
		case UmlPortPackage.SUBSETS_RULE:
			return createSubsetsRule();
		case UmlPortPackage.DEFAULT_VALUE_RULE:
			return createDefaultValueRule();
		case UmlPortPackage.VALUE:
			return createValue();
		case UmlPortPackage.INT_VALUE:
			return createIntValue();
		case UmlPortPackage.STRING_VALUE:
			return createStringValue();
		case UmlPortPackage.BOOLEAN_VALUE:
			return createBooleanValue();
		case UmlPortPackage.REAL_VALUE:
			return createRealValue();
		case UmlPortPackage.NULL_VALUE:
			return createNullValue();
		case UmlPortPackage.NO_VALUE:
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
		case UmlPortPackage.VISIBILITY_KIND:
			return createVisibilityKindFromString(eDataType, initialValue);
		case UmlPortPackage.MODIFIER_KIND:
			return createModifierKindFromString(eDataType, initialValue);
		case UmlPortPackage.BOOLEAN_LITERALS:
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
		case UmlPortPackage.VISIBILITY_KIND:
			return convertVisibilityKindToString(eDataType, instanceValue);
		case UmlPortPackage.MODIFIER_KIND:
			return convertModifierKindToString(eDataType, instanceValue);
		case UmlPortPackage.BOOLEAN_LITERALS:
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
	public PortRule createPortRule() {
		PortRuleImpl portRule = new PortRuleImpl();
		return portRule;
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
	public UmlPortPackage getUmlPortPackage() {
		return (UmlPortPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlPortPackage getPackage() {
		return UmlPortPackage.eINSTANCE;
	}

} // UmlPortFactoryImpl
