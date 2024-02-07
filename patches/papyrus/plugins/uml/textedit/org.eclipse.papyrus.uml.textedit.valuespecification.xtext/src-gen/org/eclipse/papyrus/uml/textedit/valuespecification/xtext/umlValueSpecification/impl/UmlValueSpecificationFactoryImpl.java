/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationFactory;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlValueSpecificationFactoryImpl extends EFactoryImpl implements UmlValueSpecificationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlValueSpecificationFactory init() {
		try {
			UmlValueSpecificationFactory theUmlValueSpecificationFactory = (UmlValueSpecificationFactory) EPackage.Registry.INSTANCE.getEFactory(UmlValueSpecificationPackage.eNS_URI);
			if (theUmlValueSpecificationFactory != null) {
				return theUmlValueSpecificationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlValueSpecificationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlValueSpecificationFactoryImpl() {
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE:
			return createAbstractRule();
		case UmlValueSpecificationPackage.LITERAL_BOOLEAN_RULE:
			return createLiteralBooleanRule();
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE:
			return createLiteralIntegerOrUnlimitedNaturalRule();
		case UmlValueSpecificationPackage.LITERAL_REAL_RULE:
			return createLiteralRealRule();
		case UmlValueSpecificationPackage.LITERAL_NULL_RULE:
			return createLiteralNullRule();
		case UmlValueSpecificationPackage.LITERAL_STRING_RULE:
			return createLiteralStringRule();
		case UmlValueSpecificationPackage.UNDEFINED_RULE:
			return createUndefinedRule();
		case UmlValueSpecificationPackage.VISIBILITY_KIND:
			return createVisibilityKind();
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
	public AbstractRule createAbstractRule() {
		AbstractRuleImpl abstractRule = new AbstractRuleImpl();
		return abstractRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralBooleanRule createLiteralBooleanRule() {
		LiteralBooleanRuleImpl literalBooleanRule = new LiteralBooleanRuleImpl();
		return literalBooleanRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralIntegerOrUnlimitedNaturalRule createLiteralIntegerOrUnlimitedNaturalRule() {
		LiteralIntegerOrUnlimitedNaturalRuleImpl literalIntegerOrUnlimitedNaturalRule = new LiteralIntegerOrUnlimitedNaturalRuleImpl();
		return literalIntegerOrUnlimitedNaturalRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralRealRule createLiteralRealRule() {
		LiteralRealRuleImpl literalRealRule = new LiteralRealRuleImpl();
		return literalRealRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralNullRule createLiteralNullRule() {
		LiteralNullRuleImpl literalNullRule = new LiteralNullRuleImpl();
		return literalNullRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralStringRule createLiteralStringRule() {
		LiteralStringRuleImpl literalStringRule = new LiteralStringRuleImpl();
		return literalStringRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UndefinedRule createUndefinedRule() {
		UndefinedRuleImpl undefinedRule = new UndefinedRuleImpl();
		return undefinedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityKind createVisibilityKind() {
		VisibilityKindImpl visibilityKind = new VisibilityKindImpl();
		return visibilityKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlValueSpecificationPackage getUmlValueSpecificationPackage() {
		return (UmlValueSpecificationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlValueSpecificationPackage getPackage() {
		return UmlValueSpecificationPackage.eINSTANCE;
	}

} // UmlValueSpecificationFactoryImpl
