/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage
 * @generated
 */
public class ValidityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValidityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ValidityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValiditySwitch<@Nullable Adapter> modelSwitch =
		new ValiditySwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseAbstractNode(AbstractNode object) {
				return createAbstractNodeAdapter();
			}
			@Override
			public Adapter caseConstrainingNode(ConstrainingNode object) {
				return createConstrainingNodeAdapter();
			}
			@Override
			public Adapter caseLeafConstrainingNode(LeafConstrainingNode object) {
				return createLeafConstrainingNodeAdapter();
			}
			@Override
			public Adapter caseResult(Result object) {
				return createResultAdapter();
			}
			@Override
			public Adapter caseResultConstrainingNode(ResultConstrainingNode object) {
				return createResultConstrainingNodeAdapter();
			}
			@Override
			public Adapter caseResultSet(ResultSet object) {
				return createResultSetAdapter();
			}
			@Override
			public Adapter caseResultValidatableNode(ResultValidatableNode object) {
				return createResultValidatableNodeAdapter();
			}
			@Override
			public Adapter caseRootNode(RootNode object) {
				return createRootNodeAdapter();
			}
			@Override
			public Adapter caseRootConstrainingNode(RootConstrainingNode object) {
				return createRootConstrainingNodeAdapter();
			}
			@Override
			public Adapter caseRootValidatableNode(RootValidatableNode object) {
				return createRootValidatableNodeAdapter();
			}
			@Override
			public Adapter caseValidatableNode(ValidatableNode object) {
				return createValidatableNodeAdapter();
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
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode <em>Abstract Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode
	 * @generated
	 */
	public Adapter createAbstractNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode <em>Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode
	 * @generated
	 */
	public Adapter createConstrainingNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode <em>Leaf Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode
	 * @generated
	 */
	public Adapter createLeafConstrainingNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result
	 * @generated
	 */
	public Adapter createResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode <em>Result Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode
	 * @generated
	 */
	public Adapter createResultConstrainingNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet
	 * @generated
	 */
	public Adapter createResultSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode <em>Result Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode
	 * @generated
	 */
	public Adapter createResultValidatableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode
	 * @generated
	 */
	public Adapter createRootNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode <em>Root Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode
	 * @generated
	 */
	public Adapter createRootConstrainingNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode <em>Root Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode
	 * @generated
	 */
	public Adapter createRootValidatableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode <em>Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode
	 * @generated
	 */
	public Adapter createValidatableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ValidationAdapterFactory
