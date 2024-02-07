/**
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage
 * @generated
 */
public class UmlCollaborationUseAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlCollaborationUsePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlCollaborationUseAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlCollaborationUsePackage.eINSTANCE;
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
	protected UmlCollaborationUseSwitch<Adapter> modelSwitch = new UmlCollaborationUseSwitch<Adapter>() {
		@Override
		public Adapter caseCollaborationUseRule(CollaborationUseRule object) {
			return createCollaborationUseRuleAdapter();
		}

		@Override
		public Adapter caseTypeRule(TypeRule object) {
			return createTypeRuleAdapter();
		}

		@Override
		public Adapter caseUmlCommon_TypeRule(org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule object) {
			return createUmlCommon_TypeRuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule <em>Collaboration Use Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule
	 * @generated
	 */
	public Adapter createCollaborationUseRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule <em>Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule
	 * @generated
	 */
	public Adapter createTypeRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule <em>Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule
	 * @generated
	 */
	public Adapter createUmlCommon_TypeRuleAdapter() {
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

} // UmlCollaborationUseAdapterFactory
