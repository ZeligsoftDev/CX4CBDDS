/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.BoundClassifier;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.SyntaxElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BoundClassifierImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BoundClassifierImpl#getActual <em>Actual</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundClassifierImpl extends ClassifierDefinitionImpl implements BoundClassifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getBoundClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getTemplate() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getBoundClassifier_Template(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(ElementReference newTemplate) {
		eSet(AlfPackage.eINSTANCE.getBoundClassifier_Template(), newTemplate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getActual() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getBoundClassifier_Actual(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #toReference() <em>To Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toReference()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundClassifier__ToReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference toReference() {
		try {
			return (ElementReference)TO_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SyntaxElement.class) {
			switch (baseOperationID) {
				case AlfPackage.SYNTAX_ELEMENT___TO_REFERENCE: return AlfPackage.BOUND_CLASSIFIER___TO_REFERENCE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		return super.eInvoke(operationID, arguments);
	}

} // BoundClassifierImpl
