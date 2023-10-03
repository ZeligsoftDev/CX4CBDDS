/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ReturnParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Return Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ReturnParameterImpl extends FormalParameterImpl implements ReturnParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getReturnParameter();
	}

	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		return super.eInvoke(operationID, arguments);
	}
} // ReturnParameterImpl
