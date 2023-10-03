/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.NonReturnParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Return Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NonReturnParameterImpl extends FormalParameterImpl implements NonReturnParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonReturnParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNonReturnParameter();
	}

	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		return super.eInvoke(operationID, arguments);
	}
} // NonReturnParameterImpl
