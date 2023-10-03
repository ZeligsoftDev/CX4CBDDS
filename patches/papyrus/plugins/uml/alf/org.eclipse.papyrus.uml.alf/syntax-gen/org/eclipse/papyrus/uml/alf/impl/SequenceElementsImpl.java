/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.SequenceElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceElementsImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceElementsImpl#getLower <em>Lower</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SequenceElementsImpl extends SyntaxElementImpl implements SequenceElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSequenceElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getUpper() {
		return (BigInteger)eGet(AlfPackage.eINSTANCE.getSequenceElements_Upper(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(BigInteger newUpper) {
		eSet(AlfPackage.eINSTANCE.getSequenceElements_Upper(), newUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLower() {
		return (BigInteger)eGet(AlfPackage.eINSTANCE.getSequenceElements_Lower(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(BigInteger newLower) {
		eSet(AlfPackage.eINSTANCE.getSequenceElements_Lower(), newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean conformsTo(ElementReference type) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssignedSource> assignmentsAfter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upper() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lower() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.SEQUENCE_ELEMENTS___CONFORMS_TO__ELEMENTREFERENCE:
				return conformsTo((ElementReference)arguments.get(0));
			case AlfPackage.SEQUENCE_ELEMENTS___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.SEQUENCE_ELEMENTS___UPPER:
				return upper();
			case AlfPackage.SEQUENCE_ELEMENTS___LOWER:
				return lower();
		}
		return super.eInvoke(operationID, arguments);
	}

} // SequenceElementsImpl
