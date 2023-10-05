/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationFactory
 * @model kind="package"
 * @generated
 */
public interface UmlValueSpecificationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlValueSpecification";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/valuespecification/xtext/UmlValueSpecification";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlValueSpecification";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlValueSpecificationPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getAbstractRule()
	 * @generated
	 */
	int ABSTRACT_RULE = 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__VISIBILITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__INSTANCE_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Undefined</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__UNDEFINED = 4;

	/**
	 * The number of structural features of the '<em>Abstract Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralBooleanRuleImpl <em>Literal Boolean Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralBooleanRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralBooleanRule()
	 * @generated
	 */
	int LITERAL_BOOLEAN_RULE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_RULE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal Boolean Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl <em>Literal Integer Or Unlimited Natural Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralIntegerOrUnlimitedNaturalRule()
	 * @generated
	 */
	int LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Unlimited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED = 1;

	/**
	 * The number of structural features of the '<em>Literal Integer Or Unlimited Natural Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralRealRuleImpl <em>Literal Real Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralRealRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralRealRule()
	 * @generated
	 */
	int LITERAL_REAL_RULE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_RULE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal Real Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralNullRuleImpl <em>Literal Null Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralNullRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralNullRule()
	 * @generated
	 */
	int LITERAL_NULL_RULE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_RULE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal Null Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_NULL_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralStringRuleImpl <em>Literal String Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralStringRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralStringRule()
	 * @generated
	 */
	int LITERAL_STRING_RULE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_RULE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal String Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UndefinedRuleImpl <em>Undefined Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UndefinedRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getUndefinedRule()
	 * @generated
	 */
	int UNDEFINED_RULE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_RULE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Undefined Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl <em>Visibility Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getVisibilityKind()
	 * @generated
	 */
	int VISIBILITY_KIND = 7;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_KIND__PUBLIC = 0;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_KIND__PRIVATE = 1;

	/**
	 * The feature id for the '<em><b>Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_KIND__PROTECTED = 2;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_KIND__PACKAGE = 3;

	/**
	 * The number of structural features of the '<em>Visibility Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_KIND_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule
	 * @generated
	 */
	EClass getAbstractRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getVisibility()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EReference getAbstractRule_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getName()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EAttribute getAbstractRule_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getInstanceSpecification <em>Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Instance Specification</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getInstanceSpecification()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EReference getAbstractRule_InstanceSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getValue()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EReference getAbstractRule_Value();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getUndefined <em>Undefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Undefined</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule#getUndefined()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EReference getAbstractRule_Undefined();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule <em>Literal Boolean Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal Boolean Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule
	 * @generated
	 */
	EClass getLiteralBooleanRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule#getValue()
	 * @see #getLiteralBooleanRule()
	 * @generated
	 */
	EAttribute getLiteralBooleanRule_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule <em>Literal Integer Or Unlimited Natural Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal Integer Or Unlimited Natural Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule
	 * @generated
	 */
	EClass getLiteralIntegerOrUnlimitedNaturalRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule#getValue()
	 * @see #getLiteralIntegerOrUnlimitedNaturalRule()
	 * @generated
	 */
	EAttribute getLiteralIntegerOrUnlimitedNaturalRule_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule#getUnlimited <em>Unlimited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unlimited</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule#getUnlimited()
	 * @see #getLiteralIntegerOrUnlimitedNaturalRule()
	 * @generated
	 */
	EAttribute getLiteralIntegerOrUnlimitedNaturalRule_Unlimited();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule <em>Literal Real Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal Real Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule
	 * @generated
	 */
	EClass getLiteralRealRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule#getValue()
	 * @see #getLiteralRealRule()
	 * @generated
	 */
	EAttribute getLiteralRealRule_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule <em>Literal Null Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal Null Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule
	 * @generated
	 */
	EClass getLiteralNullRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule#getValue()
	 * @see #getLiteralNullRule()
	 * @generated
	 */
	EAttribute getLiteralNullRule_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule <em>Literal String Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal String Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule
	 * @generated
	 */
	EClass getLiteralStringRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule#getValue()
	 * @see #getLiteralStringRule()
	 * @generated
	 */
	EAttribute getLiteralStringRule_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule <em>Undefined Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Undefined Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule
	 * @generated
	 */
	EClass getUndefinedRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule#getValue()
	 * @see #getUndefinedRule()
	 * @generated
	 */
	EAttribute getUndefinedRule_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Visibility Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind
	 * @generated
	 */
	EClass getVisibilityKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPublic <em>Public</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Public</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPublic()
	 * @see #getVisibilityKind()
	 * @generated
	 */
	EAttribute getVisibilityKind_Public();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPrivate()
	 * @see #getVisibilityKind()
	 * @generated
	 */
	EAttribute getVisibilityKind_Private();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getProtected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Protected</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getProtected()
	 * @see #getVisibilityKind()
	 * @generated
	 */
	EAttribute getVisibilityKind_Protected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind#getPackage()
	 * @see #getVisibilityKind()
	 * @generated
	 */
	EAttribute getVisibilityKind_Package();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlValueSpecificationFactory getUmlValueSpecificationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getAbstractRule()
		 * @generated
		 */
		EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_RULE__VISIBILITY = eINSTANCE.getAbstractRule_Visibility();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_RULE__NAME = eINSTANCE.getAbstractRule_Name();

		/**
		 * The meta object literal for the '<em><b>Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_RULE__INSTANCE_SPECIFICATION = eINSTANCE.getAbstractRule_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_RULE__VALUE = eINSTANCE.getAbstractRule_Value();

		/**
		 * The meta object literal for the '<em><b>Undefined</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_RULE__UNDEFINED = eINSTANCE.getAbstractRule_Undefined();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralBooleanRuleImpl <em>Literal Boolean Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralBooleanRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralBooleanRule()
		 * @generated
		 */
		EClass LITERAL_BOOLEAN_RULE = eINSTANCE.getLiteralBooleanRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_BOOLEAN_RULE__VALUE = eINSTANCE.getLiteralBooleanRule_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl <em>Literal Integer Or Unlimited Natural Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralIntegerOrUnlimitedNaturalRule()
		 * @generated
		 */
		EClass LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE = eINSTANCE.getLiteralIntegerOrUnlimitedNaturalRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE = eINSTANCE.getLiteralIntegerOrUnlimitedNaturalRule_Value();

		/**
		 * The meta object literal for the '<em><b>Unlimited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED = eINSTANCE.getLiteralIntegerOrUnlimitedNaturalRule_Unlimited();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralRealRuleImpl <em>Literal Real Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralRealRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralRealRule()
		 * @generated
		 */
		EClass LITERAL_REAL_RULE = eINSTANCE.getLiteralRealRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_REAL_RULE__VALUE = eINSTANCE.getLiteralRealRule_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralNullRuleImpl <em>Literal Null Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralNullRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralNullRule()
		 * @generated
		 */
		EClass LITERAL_NULL_RULE = eINSTANCE.getLiteralNullRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_NULL_RULE__VALUE = eINSTANCE.getLiteralNullRule_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralStringRuleImpl <em>Literal String Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralStringRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getLiteralStringRule()
		 * @generated
		 */
		EClass LITERAL_STRING_RULE = eINSTANCE.getLiteralStringRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LITERAL_STRING_RULE__VALUE = eINSTANCE.getLiteralStringRule_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UndefinedRuleImpl <em>Undefined Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UndefinedRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getUndefinedRule()
		 * @generated
		 */
		EClass UNDEFINED_RULE = eINSTANCE.getUndefinedRule();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNDEFINED_RULE__VALUE = eINSTANCE.getUndefinedRule_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl <em>Visibility Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl
		 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.UmlValueSpecificationPackageImpl#getVisibilityKind()
		 * @generated
		 */
		EClass VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

		/**
		 * The meta object literal for the '<em><b>Public</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISIBILITY_KIND__PUBLIC = eINSTANCE.getVisibilityKind_Public();

		/**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISIBILITY_KIND__PRIVATE = eINSTANCE.getVisibilityKind_Private();

		/**
		 * The meta object literal for the '<em><b>Protected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISIBILITY_KIND__PROTECTED = eINSTANCE.getVisibilityKind_Protected();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VISIBILITY_KIND__PACKAGE = eINSTANCE.getVisibilityKind_Package();

	}

} // UmlValueSpecificationPackage
