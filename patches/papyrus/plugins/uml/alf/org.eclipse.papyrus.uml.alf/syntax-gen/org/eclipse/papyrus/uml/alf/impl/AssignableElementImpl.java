/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.math.BigInteger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.ElementReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignableElementImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignableElementImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignableElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AssignableElementImpl extends SyntaxElementImpl implements AssignableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected AssignableElementImpl() {
		super();
		this.registerCaching();
	}

	public void clear() {
		this.type = null;
		this.typeNotResolved = true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAssignableElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getUpper() {
		return (BigInteger)eGet(AlfPackage.eINSTANCE.getAssignableElement_Upper(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(BigInteger newUpper) {
		eSet(AlfPackage.eINSTANCE.getAssignableElement_Upper(), newUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLower() {
		return (BigInteger)eGet(AlfPackage.eINSTANCE.getAssignableElement_Lower(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(BigInteger newLower) {
		eSet(AlfPackage.eINSTANCE.getAssignableElement_Lower(), newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getType() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getAssignableElement_Type(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ElementReference newType) {
		eSet(AlfPackage.eINSTANCE.getAssignableElement_Type(), newType);
	}

	private ElementReference type = null;
	private boolean typeNotResolved = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ElementReference typeCached() {
		if (this.typeNotResolved) {
			this.type = this.type();
			this.typeNotResolved = false;
		}
		return this.type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference type() {
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
	public BigInteger upper() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #isNull() <em>Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNull()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NULL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsNull()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNull() {
		try {
			return (Boolean)IS_NULL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAssignableFromElement(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Assignable From Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssignableFromElement(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ASSIGNABLE_FROM_ELEMENT_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsAssignableFromElement__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssignableFromElement(ElementReference element) {
		try {
			return (Boolean)IS_ASSIGNABLE_FROM_ELEMENT_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAssignableFrom(org.eclipse.papyrus.uml.alf.AssignableElement) <em>Is Assignable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssignableFrom(org.eclipse.papyrus.uml.alf.AssignableElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ASSIGNABLE_FROM_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsAssignableFrom__AssignableElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssignableFrom(AssignableElement source) {
		try {
			return (Boolean)IS_ASSIGNABLE_FROM_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{source}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isTypeConformantWith(org.eclipse.papyrus.uml.alf.AssignableElement) <em>Is Type Conformant With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypeConformantWith(org.eclipse.papyrus.uml.alf.AssignableElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_TYPE_CONFORMANT_WITH_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsTypeConformantWith__AssignableElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeConformantWith(AssignableElement source) {
		try {
			return (Boolean)IS_TYPE_CONFORMANT_WITH_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{source}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isConformantWithType(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Conformant With Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConformantWithType(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CONFORMANT_WITH_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsConformantWithType__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConformantWithType(ElementReference sourceType) {
		try {
			return (Boolean)IS_CONFORMANT_WITH_TYPE_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{sourceType}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isMultiplicityConformantWith(org.eclipse.papyrus.uml.alf.AssignableElement) <em>Is Multiplicity Conformant With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiplicityConformantWith(org.eclipse.papyrus.uml.alf.AssignableElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_MULTIPLICITY_CONFORMANT_WITH_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignableElement__IsMultiplicityConformantWith__AssignableElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiplicityConformantWith(AssignableElement source) {
		try {
			return (Boolean)IS_MULTIPLICITY_CONFORMANT_WITH_ASSIGNABLE_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{source}));
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.ASSIGNABLE_ELEMENT___TYPE_CACHED:
				return typeCached();
			case AlfPackage.ASSIGNABLE_ELEMENT___TYPE:
				return type();
			case AlfPackage.ASSIGNABLE_ELEMENT___LOWER:
				return lower();
			case AlfPackage.ASSIGNABLE_ELEMENT___UPPER:
				return upper();
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_NULL:
				return isNull();
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_ASSIGNABLE_FROM_ELEMENT__ELEMENTREFERENCE:
				return isAssignableFromElement((ElementReference)arguments.get(0));
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_ASSIGNABLE_FROM__ASSIGNABLEELEMENT:
				return isAssignableFrom((AssignableElement)arguments.get(0));
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_TYPE_CONFORMANT_WITH__ASSIGNABLEELEMENT:
				return isTypeConformantWith((AssignableElement)arguments.get(0));
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_CONFORMANT_WITH_TYPE__ELEMENTREFERENCE:
				return isConformantWithType((ElementReference)arguments.get(0));
			case AlfPackage.ASSIGNABLE_ELEMENT___IS_MULTIPLICITY_CONFORMANT_WITH__ASSIGNABLEELEMENT:
				return isMultiplicityConformantWith((AssignableElement)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // AssignableElementImpl
