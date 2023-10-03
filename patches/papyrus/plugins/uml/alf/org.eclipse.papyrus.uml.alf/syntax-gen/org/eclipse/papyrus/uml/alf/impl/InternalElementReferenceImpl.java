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
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.InternalElementReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.UnitDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InternalElementReferenceImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalElementReferenceImpl extends ElementReferenceImpl implements InternalElementReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getInternalElementReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement getElement() {
		return (SyntaxElement)eGet(AlfPackage.eINSTANCE.getInternalElementReference_Element(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(SyntaxElement newElement) {
		eSet(AlfPackage.eINSTANCE.getInternalElementReference_Element(), newElement);
	}

	/**
	 * The cached invocation delegate for the '{@link #isAlf() <em>Is Alf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlf()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAlf()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAlf() {
		try {
			return (Boolean)IS_ALF__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #asAlf() <em>As Alf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #asAlf()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__AsAlf()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement asAlf() {
		try {
			return (SyntaxElement)AS_ALF__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #asMember() <em>As Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #asMember()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AS_MEMBER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__AsMember()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member asMember() {
		try {
			return (Member)AS_MEMBER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Same Kind As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsSameKindAs__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSameKindAs(ElementReference member) {
		try {
			return (Boolean)IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{member}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNamedElement() <em>Is Named Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNamedElement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NAMED_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsNamedElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamedElement() {
		try {
			return (Boolean)IS_NAMED_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNamespace() <em>Is Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsNamespace()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamespace() {
		try {
			return (Boolean)IS_NAMESPACE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNamespaceFor(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Is Namespace For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNamespaceFor(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NAMESPACE_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsNamespaceFor__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNamespaceFor(UnitDefinition unit) {
		try {
			return (Boolean)IS_NAMESPACE_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{unit}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isModelNamespace() <em>Is Model Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModelNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_MODEL_NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsModelNamespace()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isModelNamespace() {
		try {
			return (Boolean)IS_MODEL_NAMESPACE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isPackage() <em>Is Package</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPackage()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PACKAGE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsPackage()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackage() {
		try {
			return (Boolean)IS_PACKAGE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isProfile() <em>Is Profile</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProfile()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PROFILE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsProfile()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProfile() {
		try {
			return (Boolean)IS_PROFILE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isPackageableElement() <em>Is Packageable Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPackageableElement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PACKAGEABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsPackageableElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPackageableElement() {
		try {
			return (Boolean)IS_PACKAGEABLE_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isClassifier() <em>Is Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClassifier()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CLASSIFIER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsClassifier()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassifier() {
		try {
			return (Boolean)IS_CLASSIFIER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAbstractClassifier() <em>Is Abstract Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstractClassifier()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ABSTRACT_CLASSIFIER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAbstractClassifier()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstractClassifier() {
		try {
			return (Boolean)IS_ABSTRACT_CLASSIFIER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAssociation() <em>Is Association</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssociation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ASSOCIATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAssociation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssociation() {
		try {
			return (Boolean)IS_ASSOCIATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isDataType() <em>Is Data Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DATA_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsDataType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataType() {
		try {
			return (Boolean)IS_DATA_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isClass() <em>Is Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClass()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsClass()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClass() {
		try {
			return (Boolean)IS_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isActiveClass() <em>Is Active Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActiveClass()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVE_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsActiveClass()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActiveClass() {
		try {
			return (Boolean)IS_ACTIVE_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isSignal() <em>Is Signal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSignal()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SIGNAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsSignal()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSignal() {
		try {
			return (Boolean)IS_SIGNAL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isEnumeration() <em>Is Enumeration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumeration()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ENUMERATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsEnumeration()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumeration() {
		try {
			return (Boolean)IS_ENUMERATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isBehavior() <em>Is Behavior</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsBehavior()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBehavior() {
		try {
			return (Boolean)IS_BEHAVIOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isActivity() <em>Is Activity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActivity()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVITY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsActivity()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActivity() {
		try {
			return (Boolean)IS_ACTIVITY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isMethod() <em>Is Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMethod()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_METHOD__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsMethod()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMethod() {
		try {
			return (Boolean)IS_METHOD__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isReception() {
		try {
			return (Boolean)IS_RECEPTION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isPrimitiveType() <em>Is Primitive Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PRIMITIVE_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsPrimitiveType()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isReception() <em>Is Reception</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReception()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_RECEPTION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsReception()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimitiveType() {
		try {
			return (Boolean)IS_PRIMITIVE_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isOperation() <em>Is Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_OPERATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsOperation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperation() {
		try {
			return (Boolean)IS_OPERATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isConstructor() <em>Is Constructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstructor()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CONSTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsConstructor()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstructor() {
		try {
			return (Boolean)IS_CONSTRUCTOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isDestructor() <em>Is Destructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDestructor()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DESTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsDestructor()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDestructor() {
		try {
			return (Boolean)IS_DESTRUCTOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isFeature() <em>Is Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFeature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsFeature()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFeature() {
		try {
			return (Boolean)IS_FEATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isProperty() <em>Is Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProperty()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PROPERTY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsProperty()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProperty() {
		try {
			return (Boolean)IS_PROPERTY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAssociationEnd() <em>Is Association End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ASSOCIATION_END__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAssociationEnd()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssociationEnd() {
		try {
			return (Boolean)IS_ASSOCIATION_END__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isParameter() <em>Is Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameter() {
		try {
			return (Boolean)IS_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isTemplate() <em>Is Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsTemplate()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		try {
			return (Boolean)IS_TEMPLATE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isTemplateParameter() <em>Is Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsTemplateParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateParameter() {
		try {
			return (Boolean)IS_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isClassifierTemplateParameter() <em>Is Classifier Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClassifierTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_CLASSIFIER_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsClassifierTemplateParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassifierTemplateParameter() {
		try {
			return (Boolean)IS_CLASSIFIER_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isParameteredElement() <em>Is Parametered Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParameteredElement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETERED_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsParameteredElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameteredElement() {
		try {
			return (Boolean)IS_PARAMETERED_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isTemplateBinding() <em>Is Template Binding</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE_BINDING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsTemplateBinding()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateBinding() {
		try {
			return (Boolean)IS_TEMPLATE_BINDING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isEnumerationLiteral() {
		try {
			return (Boolean)IS_ENUMERATION_LITERAL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isLoopVariable() {
		try {
			return (Boolean)IS_LOOP_VARIABLE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isAnnotation() {
		try {
			return (Boolean)IS_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isSequenceExpansionExpression() {
		try {
			return (Boolean)IS_SEQUENCE_EXPANSION_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean isAnyType() {
		try {
			return (Boolean)IS_ANY_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isStereotype() <em>Is Stereotype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_STEREOTYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsStereotype()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isEnumerationLiteral() <em>Is Enumeration Literal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumerationLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ENUMERATION_LITERAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsEnumerationLiteral()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isLoopVariable() <em>Is Loop Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoopVariable()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_LOOP_VARIABLE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsLoopVariable()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isAnnotation() <em>Is Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAnnotation()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isSequenceExpansionExpression() <em>Is Sequence Expansion Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequenceExpansionExpression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SEQUENCE_EXPANSION_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsSequenceExpansionExpression()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #isAnyType() <em>Is Any Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ANY_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsAnyType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStereotype() {
		try {
			return (Boolean)IS_STEREOTYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #name() <em>Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #name()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Name()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String name() {
		try {
			return (String)NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #visibility() <em>Visibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #visibility()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate VISIBILITY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Visibility()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String visibility() {
		try {
			return (String)VISIBILITY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #ownedMembers() <em>Owned Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ownedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OWNED_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__OwnedMembers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> ownedMembers() {
		try {
			return (EList<ElementReference>)OWNED_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #members() <em>Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #members()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Members()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> members() {
		try {
			return (EList<ElementReference>)MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #nestedClassifiers() <em>Nested Classifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nestedClassifiers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NESTED_CLASSIFIERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__NestedClassifiers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> nestedClassifiers() {
		try {
			return (EList<ElementReference>)NESTED_CLASSIFIERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #opposite() <em>Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #opposite()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OPPOSITE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Opposite()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference opposite() {
		try {
			return (ElementReference)OPPOSITE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #signal() <em>Signal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #signal()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SIGNAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Signal()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference signal() {
		try {
			return (ElementReference)SIGNAL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #parameters() <em>Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameters()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Parameters()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> parameters() {
		try {
			return (EList<ElementReference>)PARAMETERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #returnParameter() <em>Return Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #returnParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RETURN_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ReturnParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference returnParameter() {
		try {
			return (ElementReference)RETURN_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #specification() <em>Specification</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #specification()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SPECIFICATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Specification()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference specification() {
		try {
			return (ElementReference)SPECIFICATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #redefinedOperaions() <em>Redefined Operaions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #redefinedOperaions()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REDEFINED_OPERAIONS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__RedefinedOperaions()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> redefinedOperaions() {
		try {
			return (EList<ElementReference>)REDEFINED_OPERAIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #namespace() <em>Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #namespace()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Namespace()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference namespace() {
		try {
			return (ElementReference)NAMESPACE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #template() <em>Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #template()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Template()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference template() {
		try {
			return (ElementReference)TEMPLATE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #templateParameters() <em>Template Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateParameters()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__TemplateParameters()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> templateParameters() {
		try {
			return (EList<ElementReference>)TEMPLATE_PARAMETERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #parameteredElements() <em>Parametered Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameteredElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETERED_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ParameteredElements()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> parameteredElements() {
		try {
			return (EList<ElementReference>)PARAMETERED_ELEMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #templateActuals() <em>Template Actuals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateActuals()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_ACTUALS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__TemplateActuals()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> templateActuals() {
		try {
			return (EList<ElementReference>)TEMPLATE_ACTUALS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #direction() <em>Direction</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #direction()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate DIRECTION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Direction()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String direction() {
		try {
			return (String)DIRECTION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #association() <em>Association</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #association()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSOCIATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Association()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference association() {
		try {
			return (ElementReference)ASSOCIATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Type()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference type() {
		try {
			return (ElementReference)TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Lower()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lower() {
		try {
			return (BigInteger)LOWER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Upper()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upper() {
		try {
			return (BigInteger)UPPER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isOrdered() <em>Is Ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ORDERED__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsOrdered()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		try {
			return (Boolean)IS_ORDERED__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNonunique() <em>Is Nonunique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonunique()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NONUNIQUE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__IsNonunique()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNonunique() {
		try {
			return (Boolean)IS_NONUNIQUE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #parents() <em>Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parents()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Parents()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> parents() {
		try {
			return (EList<ElementReference>)PARENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #allParents() <em>All Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allParents()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ALL_PARENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__AllParents()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> allParents() {
		try {
			return (EList<ElementReference>)ALL_PARENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #classifierBehavior() <em>Classifier Behavior</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classifierBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CLASSIFIER_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ClassifierBehavior()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference classifierBehavior() {
		try {
			return (ElementReference)CLASSIFIER_BEHAVIOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #appliedProfiles() <em>Applied Profiles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #appliedProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__AppliedProfiles()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> appliedProfiles() {
		try {
			return (EList<ElementReference>)APPLIED_PROFILES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #activeClass() <em>Active Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #activeClass()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ACTIVE_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ActiveClass()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference activeClass() {
		try {
			return (ElementReference)ACTIVE_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #context() <em>Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #context()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONTEXT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Context()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference context() {
		try {
			return (ElementReference)CONTEXT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #conformsTo(org.eclipse.papyrus.uml.alf.ElementReference) <em>Conforms To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #conformsTo(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ConformsTo__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean conformsTo(ElementReference other) {
		try {
			return (Boolean)CONFORMS_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{other}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #equals(org.eclipse.papyrus.uml.alf.ElementReference) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #equals(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EQUALS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Equals__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(ElementReference other) {
		try {
			return (Boolean)EQUALS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{other}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #copy()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Copy()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference copy() {
		try {
			return (ElementReference)COPY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #modelScope() <em>Model Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #modelScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MODEL_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ModelScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference modelScope() {
		try {
			return (ElementReference)MODEL_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolvePathName(java.lang.String) <em>Resolve Path Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolvePathName(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_PATH_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ResolvePathName__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolvePathName(String pathName) {
		try {
			return (EList<ElementReference>)RESOLVE_PATH_NAME_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{pathName}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveInScope(java.lang.String) <em>Resolve In Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveInScope(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ResolveInScope__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveInScope(String name) {
		try {
			return (EList<ElementReference>)RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveStereotypeName(java.lang.String) <em>Resolve Stereotype Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveStereotypeName(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_STEREOTYPE_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__ResolveStereotypeName__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveStereotypeName(String stereotypeName) {
		try {
			return (EList<ElementReference>)RESOLVE_STEREOTYPE_NAME_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{stereotypeName}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #stub() <em>Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stub()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STUB__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__Stub()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stub() {
		try {
			return (ElementReference)STUB__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Stub For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInternalElementReference__StubFor__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stubFor(UnitDefinition unit) {
		try {
			return (ElementReference)STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{unit}));
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
		if (baseClass == ElementReference.class) {
			switch (baseOperationID) {
				case AlfPackage.ELEMENT_REFERENCE___IS_ALF: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ALF;
				case AlfPackage.ELEMENT_REFERENCE___AS_ALF: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___AS_ALF;
				case AlfPackage.ELEMENT_REFERENCE___AS_MEMBER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___AS_MEMBER;
				case AlfPackage.ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMED_ELEMENT: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMED_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION;
				case AlfPackage.ELEMENT_REFERENCE___IS_MODEL_NAMESPACE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_MODEL_NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PACKAGE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PROFILE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PROFILE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASSIFIER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ASSOCIATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_DATA_TYPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_DATA_TYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVE_CLASS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ACTIVE_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___IS_SIGNAL: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SIGNAL;
				case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ENUMERATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_BEHAVIOR: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_BEHAVIOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVITY: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ACTIVITY;
				case AlfPackage.ELEMENT_REFERENCE___IS_METHOD: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_METHOD;
				case AlfPackage.ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_RECEPTION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_RECEPTION;
				case AlfPackage.ELEMENT_REFERENCE___IS_OPERATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_OPERATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_CONSTRUCTOR: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CONSTRUCTOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_DESTRUCTOR: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_DESTRUCTOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_FEATURE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_FEATURE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PROPERTY: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PROPERTY;
				case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION_END: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ASSOCIATION_END;
				case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_BINDING: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE_BINDING;
				case AlfPackage.ELEMENT_REFERENCE___IS_STEREOTYPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_STEREOTYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL;
				case AlfPackage.ELEMENT_REFERENCE___IS_LOOP_VARIABLE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_LOOP_VARIABLE;
				case AlfPackage.ELEMENT_REFERENCE___IS_ANNOTATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ANNOTATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION;
				case AlfPackage.ELEMENT_REFERENCE___IS_ANY_TYPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ANY_TYPE;
				case AlfPackage.ELEMENT_REFERENCE___NAME: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___NAME;
				case AlfPackage.ELEMENT_REFERENCE___VISIBILITY: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___VISIBILITY;
				case AlfPackage.ELEMENT_REFERENCE___OWNED_MEMBERS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___OWNED_MEMBERS;
				case AlfPackage.ELEMENT_REFERENCE___MEMBERS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___MEMBERS;
				case AlfPackage.ELEMENT_REFERENCE___NESTED_CLASSIFIERS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___NESTED_CLASSIFIERS;
				case AlfPackage.ELEMENT_REFERENCE___OPPOSITE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___OPPOSITE;
				case AlfPackage.ELEMENT_REFERENCE___SIGNAL: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___SIGNAL;
				case AlfPackage.ELEMENT_REFERENCE___PARAMETERS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARAMETERS;
				case AlfPackage.ELEMENT_REFERENCE___RETURN_PARAMETER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___RETURN_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___SPECIFICATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___SPECIFICATION;
				case AlfPackage.ELEMENT_REFERENCE___NAMESPACE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_PARAMETERS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE_PARAMETERS;
				case AlfPackage.ELEMENT_REFERENCE___PARAMETERED_ELEMENTS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARAMETERED_ELEMENTS;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_ACTUALS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE_ACTUALS;
				case AlfPackage.ELEMENT_REFERENCE___DIRECTION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___DIRECTION;
				case AlfPackage.ELEMENT_REFERENCE___ASSOCIATION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___ASSOCIATION;
				case AlfPackage.ELEMENT_REFERENCE___TYPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___TYPE;
				case AlfPackage.ELEMENT_REFERENCE___LOWER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___LOWER;
				case AlfPackage.ELEMENT_REFERENCE___UPPER: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___UPPER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ORDERED: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ORDERED;
				case AlfPackage.ELEMENT_REFERENCE___IS_NONUNIQUE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NONUNIQUE;
				case AlfPackage.ELEMENT_REFERENCE___PARENTS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARENTS;
				case AlfPackage.ELEMENT_REFERENCE___ALL_PARENTS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___ALL_PARENTS;
				case AlfPackage.ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR;
				case AlfPackage.ELEMENT_REFERENCE___CONTEXT: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___CONTEXT;
				case AlfPackage.ELEMENT_REFERENCE___APPLIED_PROFILES: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___APPLIED_PROFILES;
				case AlfPackage.ELEMENT_REFERENCE___ACTIVE_CLASS: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___ACTIVE_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___COPY: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___COPY;
				case AlfPackage.ELEMENT_REFERENCE___MODEL_SCOPE: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___MODEL_SCOPE;
				case AlfPackage.ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING;
				case AlfPackage.ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING;
				case AlfPackage.ELEMENT_REFERENCE___STUB: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___STUB;
				case AlfPackage.ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION: return AlfPackage.INTERNAL_ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ALF:
				return isAlf();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___AS_ALF:
				return asAlf();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___AS_MEMBER:
				return asMember();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMED_ELEMENT:
				return isNamedElement();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMESPACE:
				return isNamespace();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION:
				return isNamespaceFor((UnitDefinition)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_MODEL_NAMESPACE:
				return isModelNamespace();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PACKAGE:
				return isPackage();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PROFILE:
				return isProfile();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT:
				return isPackageableElement();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASSIFIER:
				return isClassifier();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER:
				return isAbstractClassifier();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ASSOCIATION:
				return isAssociation();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_DATA_TYPE:
				return isDataType();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASS:
				return isClass();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ACTIVE_CLASS:
				return isActiveClass();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SIGNAL:
				return isSignal();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ENUMERATION:
				return isEnumeration();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_BEHAVIOR:
				return isBehavior();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ACTIVITY:
				return isActivity();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_METHOD:
				return isMethod();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE:
				return isPrimitiveType();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_RECEPTION:
				return isReception();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_OPERATION:
				return isOperation();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CONSTRUCTOR:
				return isConstructor();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_DESTRUCTOR:
				return isDestructor();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_FEATURE:
				return isFeature();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PROPERTY:
				return isProperty();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ASSOCIATION_END:
				return isAssociationEnd();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PARAMETER:
				return isParameter();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE:
				return isTemplate();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER:
				return isClassifierTemplateParameter();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT:
				return isParameteredElement();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_TEMPLATE_BINDING:
				return isTemplateBinding();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_STEREOTYPE:
				return isStereotype();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL:
				return isEnumerationLiteral();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_LOOP_VARIABLE:
				return isLoopVariable();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ANNOTATION:
				return isAnnotation();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION:
				return isSequenceExpansionExpression();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ANY_TYPE:
				return isAnyType();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___NAME:
				return name();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___VISIBILITY:
				return visibility();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___OWNED_MEMBERS:
				return ownedMembers();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___MEMBERS:
				return members();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___NESTED_CLASSIFIERS:
				return nestedClassifiers();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___OPPOSITE:
				return opposite();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___SIGNAL:
				return signal();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARAMETERS:
				return parameters();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___RETURN_PARAMETER:
				return returnParameter();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___SPECIFICATION:
				return specification();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___REDEFINED_OPERAIONS:
				return redefinedOperaions();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___NAMESPACE:
				return namespace();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE:
				return template();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE_PARAMETERS:
				return templateParameters();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARAMETERED_ELEMENTS:
				return parameteredElements();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___TEMPLATE_ACTUALS:
				return templateActuals();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___DIRECTION:
				return direction();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___ASSOCIATION:
				return association();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___TYPE:
				return type();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___LOWER:
				return lower();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___UPPER:
				return upper();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_ORDERED:
				return isOrdered();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___IS_NONUNIQUE:
				return isNonunique();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___PARENTS:
				return parents();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___ALL_PARENTS:
				return allParents();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR:
				return classifierBehavior();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___APPLIED_PROFILES:
				return appliedProfiles();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___ACTIVE_CLASS:
				return activeClass();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___CONTEXT:
				return context();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE:
				return conformsTo((ElementReference)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE:
				return equals((ElementReference)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___COPY:
				return copy();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___MODEL_SCOPE:
				return modelScope();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING:
				return resolvePathName((String)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING:
				return resolveInScope((String)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___RESOLVE_STEREOTYPE_NAME__STRING:
				return resolveStereotypeName((String)arguments.get(0));
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___STUB:
				return stub();
			case AlfPackage.INTERNAL_ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION:
				return stubFor((UnitDefinition)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // InternalElementReferenceImpl
