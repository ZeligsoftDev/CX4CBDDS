/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage
 * @generated
 */
public class UmlValueSpecificationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlValueSpecificationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlValueSpecificationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlValueSpecificationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UmlValueSpecificationSwitch<Adapter> modelSwitch = new UmlValueSpecificationSwitch<Adapter>() {
		@Override
		public Adapter caseAbstractRule(AbstractRule object) {
			return createAbstractRuleAdapter();
		}

		@Override
		public Adapter caseLiteralBooleanRule(LiteralBooleanRule object) {
			return createLiteralBooleanRuleAdapter();
		}

		@Override
		public Adapter caseLiteralIntegerOrUnlimitedNaturalRule(LiteralIntegerOrUnlimitedNaturalRule object) {
			return createLiteralIntegerOrUnlimitedNaturalRuleAdapter();
		}

		@Override
		public Adapter caseLiteralRealRule(LiteralRealRule object) {
			return createLiteralRealRuleAdapter();
		}

		@Override
		public Adapter caseLiteralNullRule(LiteralNullRule object) {
			return createLiteralNullRuleAdapter();
		}

		@Override
		public Adapter caseLiteralStringRule(LiteralStringRule object) {
			return createLiteralStringRuleAdapter();
		}

		@Override
		public Adapter caseUndefinedRule(UndefinedRule object) {
			return createUndefinedRuleAdapter();
		}

		@Override
		public Adapter caseVisibilityKind(VisibilityKind object) {
			return createVisibilityKindAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule
	 * @generated
	 */
	public Adapter createAbstractRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule <em>Literal Boolean Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule
	 * @generated
	 */
	public Adapter createLiteralBooleanRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule <em>Literal Integer Or Unlimited Natural Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule
	 * @generated
	 */
	public Adapter createLiteralIntegerOrUnlimitedNaturalRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule <em>Literal Real Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule
	 * @generated
	 */
	public Adapter createLiteralRealRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule <em>Literal Null Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule
	 * @generated
	 */
	public Adapter createLiteralNullRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule <em>Literal String Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule
	 * @generated
	 */
	public Adapter createLiteralStringRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule <em>Undefined Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule
	 * @generated
	 */
	public Adapter createUndefinedRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind
	 * @generated
	 */
	public Adapter createVisibilityKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // UmlValueSpecificationAdapterFactory
