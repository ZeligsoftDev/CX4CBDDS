/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.util;

import com.prismtech.domain.sca.ppls.vpm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage
 * @generated
 */
public class VpmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VpmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = VpmPackage.eINSTANCE;
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
	protected VpmSwitch<Adapter> modelSwitch =
		new VpmSwitch<Adapter>() {
			@Override
			public Adapter caseVPModel(VPModel object) {
				return createVPModelAdapter();
			}
			@Override
			public Adapter caseVariationPoint(VariationPoint object) {
				return createVariationPointAdapter();
			}
			@Override
			public Adapter caseVariationPointWithValue(VariationPointWithValue object) {
				return createVariationPointWithValueAdapter();
			}
			@Override
			public Adapter caseVariationPointWithSettings(VariationPointWithSettings object) {
				return createVariationPointWithSettingsAdapter();
			}
			@Override
			public Adapter caseConstrainedElement(ConstrainedElement object) {
				return createConstrainedElementAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigurationPoint(ConfigurationPoint object) {
				return createConfigurationPointAdapter();
			}
			@Override
			public Adapter caseConfigurationPointWithValue(ConfigurationPointWithValue object) {
				return createConfigurationPointWithValueAdapter();
			}
			@Override
			public Adapter caseConfigurationPointWithSettings(ConfigurationPointWithSettings object) {
				return createConfigurationPointWithSettingsAdapter();
			}
			@Override
			public Adapter caseSettableAttribute(SettableAttribute object) {
				return createSettableAttributeAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPoint
	 * @generated
	 */
	public Adapter createVariationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue <em>Variation Point With Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPointWithValue
	 * @generated
	 */
	public Adapter createVariationPointWithValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings <em>Variation Point With Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.VariationPointWithSettings
	 * @generated
	 */
	public Adapter createVariationPointWithSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConstrainedElement
	 * @generated
	 */
	public Adapter createConstrainedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.VPModel <em>VP Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.VPModel
	 * @generated
	 */
	public Adapter createVPModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint <em>Configuration Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint
	 * @generated
	 */
	public Adapter createConfigurationPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue <em>Configuration Point With Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue
	 * @generated
	 */
	public Adapter createConfigurationPointWithValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings <em>Configuration Point With Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings
	 * @generated
	 */
	public Adapter createConfigurationPointWithSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.SettableAttribute <em>Settable Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.SettableAttribute
	 * @generated
	 */
	public Adapter createSettableAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.prismtech.domain.sca.ppls.vpm.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.prismtech.domain.sca.ppls.vpm.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
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

} //VpmAdapterFactory
