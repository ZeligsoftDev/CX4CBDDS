/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterFactory
 * @model kind="package"
 * @generated
 */
public interface UmlParameterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlParameter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/parameter/xtext/UmlParameter";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlParameter";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlParameterPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl <em>Parameter Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getParameterRule()
	 * @generated
	 */
	int PARAMETER_RULE = 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__VISIBILITY = 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Type Undefined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__TYPE_UNDEFINED = 4;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__MULTIPLICITY = 5;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__MODIFIERS = 6;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__EFFECT = 7;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE__DEFAULT_VALUE = 8;

	/**
	 * The number of structural features of the '<em>Parameter Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RULE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifiersRule()
	 * @generated
	 */
	int MODIFIERS_RULE = 1;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODIFIERS_RULE__VALUES = 0;

	/**
	 * The number of structural features of the '<em>Modifiers Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODIFIERS_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierSpecification()
	 * @generated
	 */
	int MODIFIER_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODIFIER_SPECIFICATION__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Modifier Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODIFIER_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.VisibilityRuleImpl <em>Visibility Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.VisibilityRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getVisibilityRule()
	 * @generated
	 */
	int VISIBILITY_RULE = 3;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_RULE__VISIBILITY = 0;

	/**
	 * The number of structural features of the '<em>Visibility Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DirectionRuleImpl <em>Direction Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DirectionRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getDirectionRule()
	 * @generated
	 */
	int DIRECTION_RULE = 4;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTION_RULE__DIRECTION = 0;

	/**
	 * The number of structural features of the '<em>Direction Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTION_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectRule()
	 * @generated
	 */
	int EFFECT_RULE = 5;

	/**
	 * The feature id for the '<em><b>Effect Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EFFECT_RULE__EFFECT_KIND = 0;

	/**
	 * The number of structural features of the '<em>Effect Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EFFECT_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DefaultValueRuleImpl <em>Default Value Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DefaultValueRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getDefaultValueRule()
	 * @generated
	 */
	int DEFAULT_VALUE_RULE = 6;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_RULE__DEFAULT = 0;

	/**
	 * The number of structural features of the '<em>Default Value Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 7;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.IntValueImpl <em>Int Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.IntValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getIntValue()
	 * @generated
	 */
	int INT_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Literal Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INT_VALUE__LITERAL_INTEGER = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.StringValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Literal String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__LITERAL_STRING = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.BooleanValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 10;

	/**
	 * The feature id for the '<em><b>Literal Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__LITERAL_BOOLEAN = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.RealValueImpl <em>Real Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.RealValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getRealValue()
	 * @generated
	 */
	int REAL_VALUE = 11;

	/**
	 * The feature id for the '<em><b>Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE__INTEGER = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE__FRACTION = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NullValueImpl <em>Null Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NullValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getNullValue()
	 * @generated
	 */
	int NULL_VALUE = 12;

	/**
	 * The number of structural features of the '<em>Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NULL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NoValueImpl <em>No Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NoValueImpl
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getNoValue()
	 * @generated
	 */
	int NO_VALUE = 13;

	/**
	 * The number of structural features of the '<em>No Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NO_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierKind()
	 * @generated
	 */
	int MODIFIER_KIND = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectKind()
	 * @generated
	 */
	int EFFECT_KIND = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals <em>Boolean Literals</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getBooleanLiterals()
	 * @generated
	 */
	int BOOLEAN_LITERALS = 16;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule <em>Parameter Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Parameter Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule
	 * @generated
	 */
	EClass getParameterRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Visibility();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Direction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName()
	 * @see #getParameterRule()
	 * @generated
	 */
	EAttribute getParameterRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#isTypeUndefined <em>Type Undefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type Undefined</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#isTypeUndefined()
	 * @see #getParameterRule()
	 * @generated
	 */
	EAttribute getParameterRule_TypeUndefined();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Modifiers</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Modifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Effect</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_Effect();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDefaultValue()
	 * @see #getParameterRule()
	 * @generated
	 */
	EReference getParameterRule_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule <em>Modifiers Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Modifiers Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule
	 * @generated
	 */
	EClass getModifiersRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule#getValues()
	 * @see #getModifiersRule()
	 * @generated
	 */
	EReference getModifiersRule_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification <em>Modifier Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Modifier Specification</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification
	 * @generated
	 */
	EClass getModifierSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification#getValue()
	 * @see #getModifierSpecification()
	 * @generated
	 */
	EAttribute getModifierSpecification_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule <em>Visibility Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Visibility Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule
	 * @generated
	 */
	EClass getVisibilityRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule#getVisibility()
	 * @see #getVisibilityRule()
	 * @generated
	 */
	EAttribute getVisibilityRule_Visibility();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule <em>Direction Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Direction Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule
	 * @generated
	 */
	EClass getDirectionRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule#getDirection()
	 * @see #getDirectionRule()
	 * @generated
	 */
	EAttribute getDirectionRule_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule <em>Effect Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Effect Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule
	 * @generated
	 */
	EClass getEffectRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind <em>Effect Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Effect Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind()
	 * @see #getEffectRule()
	 * @generated
	 */
	EAttribute getEffectRule_EffectKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule <em>Default Value Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Default Value Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule
	 * @generated
	 */
	EClass getDefaultValueRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule#getDefault()
	 * @see #getDefaultValueRule()
	 * @generated
	 */
	EReference getDefaultValueRule_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Int Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue
	 * @generated
	 */
	EClass getIntValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue#getLiteralInteger <em>Literal Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Literal Integer</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue#getLiteralInteger()
	 * @see #getIntValue()
	 * @generated
	 */
	EAttribute getIntValue_LiteralInteger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue#getLiteralString <em>Literal String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Literal String</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.StringValue#getLiteralString()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_LiteralString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue#getLiteralBoolean <em>Literal Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Literal Boolean</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanValue#getLiteralBoolean()
	 * @see #getBooleanValue()
	 * @generated
	 */
	EAttribute getBooleanValue_LiteralBoolean();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Real Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue#getInteger <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Integer</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue#getInteger()
	 * @see #getRealValue()
	 * @generated
	 */
	EAttribute getRealValue_Integer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue#getFraction <em>Fraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Fraction</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.RealValue#getFraction()
	 * @see #getRealValue()
	 * @generated
	 */
	EAttribute getRealValue_Fraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Null Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NullValue
	 * @generated
	 */
	EClass getNullValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NoValue <em>No Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>No Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.NoValue
	 * @generated
	 */
	EClass getNoValue();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Modifier Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
	 * @generated
	 */
	EEnum getModifierKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Effect Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
	 * @generated
	 */
	EEnum getEffectKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals <em>Boolean Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Boolean Literals</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals
	 * @generated
	 */
	EEnum getBooleanLiterals();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlParameterFactory getUmlParameterFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl <em>Parameter Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getParameterRule()
		 * @generated
		 */
		EClass PARAMETER_RULE = eINSTANCE.getParameterRule();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__VISIBILITY = eINSTANCE.getParameterRule_Visibility();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__DIRECTION = eINSTANCE.getParameterRule_Direction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PARAMETER_RULE__NAME = eINSTANCE.getParameterRule_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__TYPE = eINSTANCE.getParameterRule_Type();

		/**
		 * The meta object literal for the '<em><b>Type Undefined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PARAMETER_RULE__TYPE_UNDEFINED = eINSTANCE.getParameterRule_TypeUndefined();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__MULTIPLICITY = eINSTANCE.getParameterRule_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__MODIFIERS = eINSTANCE.getParameterRule_Modifiers();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__EFFECT = eINSTANCE.getParameterRule_Effect();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER_RULE__DEFAULT_VALUE = eINSTANCE.getParameterRule_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifiersRule()
		 * @generated
		 */
		EClass MODIFIERS_RULE = eINSTANCE.getModifiersRule();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODIFIERS_RULE__VALUES = eINSTANCE.getModifiersRule_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierSpecification()
		 * @generated
		 */
		EClass MODIFIER_SPECIFICATION = eINSTANCE.getModifierSpecification();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODIFIER_SPECIFICATION__VALUE = eINSTANCE.getModifierSpecification_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.VisibilityRuleImpl <em>Visibility Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.VisibilityRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getVisibilityRule()
		 * @generated
		 */
		EClass VISIBILITY_RULE = eINSTANCE.getVisibilityRule();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISIBILITY_RULE__VISIBILITY = eINSTANCE.getVisibilityRule_Visibility();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DirectionRuleImpl <em>Direction Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DirectionRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getDirectionRule()
		 * @generated
		 */
		EClass DIRECTION_RULE = eINSTANCE.getDirectionRule();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIRECTION_RULE__DIRECTION = eINSTANCE.getDirectionRule_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectRule()
		 * @generated
		 */
		EClass EFFECT_RULE = eINSTANCE.getEffectRule();

		/**
		 * The meta object literal for the '<em><b>Effect Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EFFECT_RULE__EFFECT_KIND = eINSTANCE.getEffectRule_EffectKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DefaultValueRuleImpl <em>Default Value Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.DefaultValueRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getDefaultValueRule()
		 * @generated
		 */
		EClass DEFAULT_VALUE_RULE = eINSTANCE.getDefaultValueRule();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFAULT_VALUE_RULE__DEFAULT = eINSTANCE.getDefaultValueRule_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.IntValueImpl <em>Int Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.IntValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getIntValue()
		 * @generated
		 */
		EClass INT_VALUE = eINSTANCE.getIntValue();

		/**
		 * The meta object literal for the '<em><b>Literal Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute INT_VALUE__LITERAL_INTEGER = eINSTANCE.getIntValue_LiteralInteger();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.StringValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Literal String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_VALUE__LITERAL_STRING = eINSTANCE.getStringValue_LiteralString();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.BooleanValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Literal Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE__LITERAL_BOOLEAN = eINSTANCE.getBooleanValue_LiteralBoolean();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.RealValueImpl <em>Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.RealValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getRealValue()
		 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the '<em><b>Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REAL_VALUE__INTEGER = eINSTANCE.getRealValue_Integer();

		/**
		 * The meta object literal for the '<em><b>Fraction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REAL_VALUE__FRACTION = eINSTANCE.getRealValue_Fraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NullValueImpl <em>Null Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NullValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getNullValue()
		 * @generated
		 */
		EClass NULL_VALUE = eINSTANCE.getNullValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NoValueImpl <em>No Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.NoValueImpl
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getNoValue()
		 * @generated
		 */
		EClass NO_VALUE = eINSTANCE.getNoValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierKind()
		 * @generated
		 */
		EEnum MODIFIER_KIND = eINSTANCE.getModifierKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectKind()
		 * @generated
		 */
		EEnum EFFECT_KIND = eINSTANCE.getEffectKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals <em>Boolean Literals</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.BooleanLiterals
		 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getBooleanLiterals()
		 * @generated
		 */
		EEnum BOOLEAN_LITERALS = eINSTANCE.getBooleanLiterals();

	}

} // UmlParameterPackage
