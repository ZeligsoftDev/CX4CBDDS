/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage
 * @generated
 */
public class UmlStateAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlStatePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlStateAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlStatePackage.eINSTANCE;
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
	protected UmlStateSwitch<Adapter> modelSwitch = new UmlStateSwitch<Adapter>() {
		@Override
		public Adapter caseStateRule(StateRule object) {
			return createStateRuleAdapter();
		}

		@Override
		public Adapter caseSubmachineRule(SubmachineRule object) {
			return createSubmachineRuleAdapter();
		}

		@Override
		public Adapter caseQualifiedName(QualifiedName object) {
			return createQualifiedNameAdapter();
		}

		@Override
		public Adapter caseEntryRule(EntryRule object) {
			return createEntryRuleAdapter();
		}

		@Override
		public Adapter caseDoRule(DoRule object) {
			return createDoRuleAdapter();
		}

		@Override
		public Adapter caseExitRule(ExitRule object) {
			return createExitRuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule <em>State Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule
	 * @generated
	 */
	public Adapter createStateRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule <em>Submachine Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule
	 * @generated
	 */
	public Adapter createSubmachineRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName
	 * @generated
	 */
	public Adapter createQualifiedNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule <em>Entry Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule
	 * @generated
	 */
	public Adapter createEntryRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule <em>Do Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule
	 * @generated
	 */
	public Adapter createDoRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule <em>Exit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule
	 * @generated
	 */
	public Adapter createExitRuleAdapter() {
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

} // UmlStateAdapterFactory
