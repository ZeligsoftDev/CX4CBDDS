/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.IntValue;
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
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.Value;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage
 * @generated
 */
public class UmlPortAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlPortPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlPortAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlPortPackage.eINSTANCE;
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
	protected UmlPortSwitch<Adapter> modelSwitch = new UmlPortSwitch<Adapter>() {
		@Override
		public Adapter casePortRule(PortRule object) {
			return createPortRuleAdapter();
		}

		@Override
		public Adapter caseVisibilityRule(VisibilityRule object) {
			return createVisibilityRuleAdapter();
		}

		@Override
		public Adapter caseTypeRule(TypeRule object) {
			return createTypeRuleAdapter();
		}

		@Override
		public Adapter caseQualifiedName(QualifiedName object) {
			return createQualifiedNameAdapter();
		}

		@Override
		public Adapter caseMultiplicityRule(MultiplicityRule object) {
			return createMultiplicityRuleAdapter();
		}

		@Override
		public Adapter caseBoundSpecification(BoundSpecification object) {
			return createBoundSpecificationAdapter();
		}

		@Override
		public Adapter caseModifiersRule(ModifiersRule object) {
			return createModifiersRuleAdapter();
		}

		@Override
		public Adapter caseModifierSpecification(ModifierSpecification object) {
			return createModifierSpecificationAdapter();
		}

		@Override
		public Adapter caseRedefinesRule(RedefinesRule object) {
			return createRedefinesRuleAdapter();
		}

		@Override
		public Adapter caseSubsetsRule(SubsetsRule object) {
			return createSubsetsRuleAdapter();
		}

		@Override
		public Adapter caseDefaultValueRule(DefaultValueRule object) {
			return createDefaultValueRuleAdapter();
		}

		@Override
		public Adapter caseValue(Value object) {
			return createValueAdapter();
		}

		@Override
		public Adapter caseIntValue(IntValue object) {
			return createIntValueAdapter();
		}

		@Override
		public Adapter caseStringValue(StringValue object) {
			return createStringValueAdapter();
		}

		@Override
		public Adapter caseBooleanValue(BooleanValue object) {
			return createBooleanValueAdapter();
		}

		@Override
		public Adapter caseRealValue(RealValue object) {
			return createRealValueAdapter();
		}

		@Override
		public Adapter caseNullValue(NullValue object) {
			return createNullValueAdapter();
		}

		@Override
		public Adapter caseNoValue(NoValue object) {
			return createNoValueAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule <em>Port Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule
	 * @generated
	 */
	public Adapter createPortRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityRule <em>Visibility Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityRule
	 * @generated
	 */
	public Adapter createVisibilityRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule <em>Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule
	 * @generated
	 */
	public Adapter createTypeRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName
	 * @generated
	 */
	public Adapter createQualifiedNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule <em>Multiplicity Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule
	 * @generated
	 */
	public Adapter createMultiplicityRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification <em>Bound Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification
	 * @generated
	 */
	public Adapter createBoundSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule <em>Modifiers Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule
	 * @generated
	 */
	public Adapter createModifiersRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification <em>Modifier Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification
	 * @generated
	 */
	public Adapter createModifierSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule <em>Redefines Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule
	 * @generated
	 */
	public Adapter createRedefinesRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule <em>Subsets Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule
	 * @generated
	 */
	public Adapter createSubsetsRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule <em>Default Value Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule
	 * @generated
	 */
	public Adapter createDefaultValueRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.IntValue
	 * @generated
	 */
	public Adapter createIntValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.StringValue
	 * @generated
	 */
	public Adapter createStringValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue
	 * @generated
	 */
	public Adapter createBooleanValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue
	 * @generated
	 */
	public Adapter createRealValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NullValue
	 * @generated
	 */
	public Adapter createNullValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NoValue <em>No Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NoValue
	 * @generated
	 */
	public Adapter createNoValueAdapter() {
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

} // UmlPortAdapterFactory
