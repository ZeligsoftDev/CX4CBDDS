/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.BoundElementReference;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.UnitDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BoundElementReferenceImpl#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BoundElementReferenceImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BoundElementReferenceImpl#getTemplateBinding <em>Template Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundElementReferenceImpl extends ElementReferenceImpl implements BoundElementReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getBoundElementReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReferent() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getBoundElementReference_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(ElementReference newReferent) {
		eSet(AlfPackage.eINSTANCE.getBoundElementReference_Referent(), newReferent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getNamespace() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getBoundElementReference_Namespace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(ElementReference newNamespace) {
		eSet(AlfPackage.eINSTANCE.getBoundElementReference_Namespace(), newNamespace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getTemplateBinding() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getBoundElementReference_TemplateBinding(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateBinding(ElementReference newTemplateBinding) {
		eSet(AlfPackage.eINSTANCE.getBoundElementReference_TemplateBinding(), newTemplateBinding);
	}

	/**
	 * The cached invocation delegate for the '{@link #isUml() <em>Is Uml</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUml()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_UML__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsUml()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUml() {
		try {
			return (Boolean)IS_UML__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isAlf() <em>Is Alf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlf()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsAlf()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #asUml() <em>As Uml</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #asUml()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AS_UML__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AsUml()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject asUml() {
		try {
			return (EObject)AS_UML__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate AS_ALF__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AsAlf()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate AS_MEMBER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AsMember()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsSameKindAs__ElementReference()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_NAMED_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsNamedElement()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsNamespace()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_NAMESPACE_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsNamespaceFor__UnitDefinition()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_MODEL_NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsModelNamespace()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PACKAGE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsPackage()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PROFILE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsProfile()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PACKAGEABLE_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsPackageableElement()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_CLASSIFIER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsClassifier()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ABSTRACT_CLASSIFIER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsAbstractClassifier()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ASSOCIATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsAssociation()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_DATA_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsDataType()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsClass()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVE_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsActiveClass()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_SIGNAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsSignal()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ENUMERATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsEnumeration()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsBehavior()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVITY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsActivity()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_METHOD__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsMethod()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isPrimitiveType() <em>Is Primitive Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_PRIMITIVE_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsPrimitiveType()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isReception() <em>Is Reception</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReception()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_RECEPTION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsReception()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isOperation() <em>Is Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_OPERATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsOperation()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_CONSTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsConstructor()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_DESTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsDestructor()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsFeature()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PROPERTY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsProperty()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ASSOCIATION_END__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsAssociationEnd()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsParameter()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsTemplate()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsTemplateParameter()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_CLASSIFIER_TEMPLATE_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsClassifierTemplateParameter()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETERED_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsParameteredElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isStereotype() <em>Is Stereotype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_STEREOTYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsStereotype()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isEnumerationLiteral() <em>Is Enumeration Literal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnumerationLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ENUMERATION_LITERAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsEnumerationLiteral()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isLoopVariable() <em>Is Loop Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoopVariable()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_LOOP_VARIABLE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsLoopVariable()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isAnnotation() <em>Is Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsAnnotation()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isSequenceExpansionExpression() <em>Is Sequence Expansion Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequenceExpansionExpression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SEQUENCE_EXPANSION_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsSequenceExpansionExpression()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isDistinguishableFrom(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Distinguishable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DISTINGUISHABLE_FROM_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsDistinguishableFrom__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinguishableFrom(ElementReference other) {
		try {
			return (Boolean)IS_DISTINGUISHABLE_FROM_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{other}));
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
	protected static final EOperation.Internal.InvocationDelegate NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Name()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate VISIBILITY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Visibility()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate OWNED_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__OwnedMembers()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Members()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate NESTED_CLASSIFIERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__NestedClassifiers()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #properties() <em>Properties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #properties()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PROPERTIES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Properties()).getInvocationDelegate();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> properties() {
		try {
			return (EList<ElementReference>)PROPERTIES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #associationEnds() <em>Association Ends</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #associationEnds()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AssociationEnds()).getInvocationDelegate();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> associationEnds() {
		try {
			return (EList<ElementReference>)ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate OPPOSITE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Opposite()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate SIGNAL__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Signal()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Parameters()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate RETURN_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ReturnParameter()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate SPECIFICATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Specification()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #redefinedOperations() <em>Redefined Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #redefinedOperations()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REDEFINED_OPERATIONS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__RedefinedOperations()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> redefinedOperations() {
		try {
			return (EList<ElementReference>)REDEFINED_OPERATIONS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Namespace()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Template()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__TemplateParameters()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate PARAMETERED_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ParameteredElements()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isTemplateBinding() <em>Is Template Binding</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_TEMPLATE_BINDING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsTemplateBinding()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #templateActuals() <em>Template Actuals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateActuals()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_ACTUALS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__TemplateActuals()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate DIRECTION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Direction()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate ASSOCIATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Association()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Upper()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_ORDERED__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsOrdered()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_NONUNIQUE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsNonunique()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate PARENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Parents()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate ALL_PARENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AllParents()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate CLASSIFIER_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ClassifierBehavior()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__AppliedProfiles()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #reference() <em>Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #reference()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Reference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference reference() {
		try {
			return (ElementReference)REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #templateBinding() <em>Template Binding</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateBinding()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_BINDING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__TemplateBinding()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference templateBinding() {
		try {
			return (ElementReference)TEMPLATE_BINDING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate ACTIVE_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ActiveClass()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate CONTEXT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Context()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isActiveBehavior() <em>Is Active Behavior</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActiveBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ACTIVE_BEHAVIOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__IsActiveBehavior()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActiveBehavior() {
		try {
			return (Boolean)IS_ACTIVE_BEHAVIOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ConformsTo__ElementReference()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate EQUALS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Equals__ElementReference()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Copy()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate MODEL_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ModelScope()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_PATH_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ResolvePathName__String()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ResolveInScope__String()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #resolveStereotype(java.lang.String) <em>Resolve Stereotype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveStereotype(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_STEREOTYPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__ResolveStereotype__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveStereotype(String stereotypeName) {
		try {
			return (EList<ElementReference>)RESOLVE_STEREOTYPE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{stereotypeName}));
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
	protected static final EOperation.Internal.InvocationDelegate STUB__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__Stub()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__StubFor__UnitDefinition()).getInvocationDelegate();

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
	 * 
	 * @generated NOT
	 */
	public ElementReference boundReferenceTo(ElementReference element) {
		return this.boundReferenceTo1(element);
	}

	/**
	 * The cached invocation delegate for the '{@link #boundReferenceTo1(org.eclipse.papyrus.uml.alf.ElementReference) <em>Bound Reference To1</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #boundReferenceTo1(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BOUND_REFERENCE_TO1_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__BoundReferenceTo1__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference boundReferenceTo1(ElementReference element) {
		try {
			return (ElementReference)BOUND_REFERENCE_TO1_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #boundReferencesTo(org.eclipse.emf.common.util.EList) <em>Bound References To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #boundReferencesTo(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BOUND_REFERENCES_TO_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBoundElementReference__BoundReferencesTo__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> boundReferencesTo(EList<ElementReference> elements) {
		try {
			return (EList<ElementReference>)BOUND_REFERENCES_TO_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{elements}));
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
				case AlfPackage.ELEMENT_REFERENCE___IS_UML: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_UML;
				case AlfPackage.ELEMENT_REFERENCE___IS_ALF: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ALF;
				case AlfPackage.ELEMENT_REFERENCE___AS_UML: return AlfPackage.BOUND_ELEMENT_REFERENCE___AS_UML;
				case AlfPackage.ELEMENT_REFERENCE___AS_ALF: return AlfPackage.BOUND_ELEMENT_REFERENCE___AS_ALF;
				case AlfPackage.ELEMENT_REFERENCE___AS_MEMBER: return AlfPackage.BOUND_ELEMENT_REFERENCE___AS_MEMBER;
				case AlfPackage.ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMED_ELEMENT: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMED_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION;
				case AlfPackage.ELEMENT_REFERENCE___IS_MODEL_NAMESPACE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_MODEL_NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PACKAGE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PROFILE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PROFILE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASSIFIER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ASSOCIATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_DATA_TYPE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DATA_TYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASS: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVE_CLASS: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVE_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___IS_SIGNAL: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SIGNAL;
				case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ENUMERATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_BEHAVIOR: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_BEHAVIOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVITY: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVITY;
				case AlfPackage.ELEMENT_REFERENCE___IS_METHOD: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_METHOD;
				case AlfPackage.ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_RECEPTION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_RECEPTION;
				case AlfPackage.ELEMENT_REFERENCE___IS_OPERATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_OPERATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_CONSTRUCTOR: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CONSTRUCTOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_DESTRUCTOR: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DESTRUCTOR;
				case AlfPackage.ELEMENT_REFERENCE___IS_FEATURE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_FEATURE;
				case AlfPackage.ELEMENT_REFERENCE___IS_PROPERTY: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PROPERTY;
				case AlfPackage.ELEMENT_REFERENCE___IS_ASSOCIATION_END: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ASSOCIATION_END;
				case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETER: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT;
				case AlfPackage.ELEMENT_REFERENCE___IS_TEMPLATE_BINDING: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE_BINDING;
				case AlfPackage.ELEMENT_REFERENCE___IS_STEREOTYPE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_STEREOTYPE;
				case AlfPackage.ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL;
				case AlfPackage.ELEMENT_REFERENCE___IS_LOOP_VARIABLE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_LOOP_VARIABLE;
				case AlfPackage.ELEMENT_REFERENCE___IS_ANNOTATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ANNOTATION;
				case AlfPackage.ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION;
				case AlfPackage.ELEMENT_REFERENCE___IS_DISTINGUISHABLE_FROM__ELEMENTREFERENCE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DISTINGUISHABLE_FROM__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___NAME: return AlfPackage.BOUND_ELEMENT_REFERENCE___NAME;
				case AlfPackage.ELEMENT_REFERENCE___VISIBILITY: return AlfPackage.BOUND_ELEMENT_REFERENCE___VISIBILITY;
				case AlfPackage.ELEMENT_REFERENCE___OWNED_MEMBERS: return AlfPackage.BOUND_ELEMENT_REFERENCE___OWNED_MEMBERS;
				case AlfPackage.ELEMENT_REFERENCE___MEMBERS: return AlfPackage.BOUND_ELEMENT_REFERENCE___MEMBERS;
				case AlfPackage.ELEMENT_REFERENCE___NESTED_CLASSIFIERS: return AlfPackage.BOUND_ELEMENT_REFERENCE___NESTED_CLASSIFIERS;
				case AlfPackage.ELEMENT_REFERENCE___PROPERTIES: return AlfPackage.BOUND_ELEMENT_REFERENCE___PROPERTIES;
				case AlfPackage.ELEMENT_REFERENCE___ASSOCIATION_ENDS: return AlfPackage.BOUND_ELEMENT_REFERENCE___ASSOCIATION_ENDS;
				case AlfPackage.ELEMENT_REFERENCE___OPPOSITE: return AlfPackage.BOUND_ELEMENT_REFERENCE___OPPOSITE;
				case AlfPackage.ELEMENT_REFERENCE___SIGNAL: return AlfPackage.BOUND_ELEMENT_REFERENCE___SIGNAL;
				case AlfPackage.ELEMENT_REFERENCE___PARAMETERS: return AlfPackage.BOUND_ELEMENT_REFERENCE___PARAMETERS;
				case AlfPackage.ELEMENT_REFERENCE___RETURN_PARAMETER: return AlfPackage.BOUND_ELEMENT_REFERENCE___RETURN_PARAMETER;
				case AlfPackage.ELEMENT_REFERENCE___SPECIFICATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___SPECIFICATION;
				case AlfPackage.ELEMENT_REFERENCE___REDEFINED_OPERATIONS: return AlfPackage.BOUND_ELEMENT_REFERENCE___REDEFINED_OPERATIONS;
				case AlfPackage.ELEMENT_REFERENCE___NAMESPACE: return AlfPackage.BOUND_ELEMENT_REFERENCE___NAMESPACE;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE: return AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_PARAMETERS: return AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_PARAMETERS;
				case AlfPackage.ELEMENT_REFERENCE___PARAMETERED_ELEMENTS: return AlfPackage.BOUND_ELEMENT_REFERENCE___PARAMETERED_ELEMENTS;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_ACTUALS: return AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_ACTUALS;
				case AlfPackage.ELEMENT_REFERENCE___DIRECTION: return AlfPackage.BOUND_ELEMENT_REFERENCE___DIRECTION;
				case AlfPackage.ELEMENT_REFERENCE___ASSOCIATION: return AlfPackage.BOUND_ELEMENT_REFERENCE___ASSOCIATION;
				case AlfPackage.ELEMENT_REFERENCE___TYPE: return AlfPackage.BOUND_ELEMENT_REFERENCE___TYPE;
				case AlfPackage.ELEMENT_REFERENCE___LOWER: return AlfPackage.BOUND_ELEMENT_REFERENCE___LOWER;
				case AlfPackage.ELEMENT_REFERENCE___UPPER: return AlfPackage.BOUND_ELEMENT_REFERENCE___UPPER;
				case AlfPackage.ELEMENT_REFERENCE___IS_ORDERED: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ORDERED;
				case AlfPackage.ELEMENT_REFERENCE___IS_NONUNIQUE: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NONUNIQUE;
				case AlfPackage.ELEMENT_REFERENCE___PARENTS: return AlfPackage.BOUND_ELEMENT_REFERENCE___PARENTS;
				case AlfPackage.ELEMENT_REFERENCE___ALL_PARENTS: return AlfPackage.BOUND_ELEMENT_REFERENCE___ALL_PARENTS;
				case AlfPackage.ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR: return AlfPackage.BOUND_ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR;
				case AlfPackage.ELEMENT_REFERENCE___CONTEXT: return AlfPackage.BOUND_ELEMENT_REFERENCE___CONTEXT;
				case AlfPackage.ELEMENT_REFERENCE___APPLIED_PROFILES: return AlfPackage.BOUND_ELEMENT_REFERENCE___APPLIED_PROFILES;
				case AlfPackage.ELEMENT_REFERENCE___REFERENCE: return AlfPackage.BOUND_ELEMENT_REFERENCE___REFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___TEMPLATE_BINDING: return AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_BINDING;
				case AlfPackage.ELEMENT_REFERENCE___ACTIVE_CLASS: return AlfPackage.BOUND_ELEMENT_REFERENCE___ACTIVE_CLASS;
				case AlfPackage.ELEMENT_REFERENCE___IS_ACTIVE_BEHAVIOR: return AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVE_BEHAVIOR;
				case AlfPackage.ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE: return AlfPackage.BOUND_ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE: return AlfPackage.BOUND_ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE;
				case AlfPackage.ELEMENT_REFERENCE___COPY: return AlfPackage.BOUND_ELEMENT_REFERENCE___COPY;
				case AlfPackage.ELEMENT_REFERENCE___MODEL_SCOPE: return AlfPackage.BOUND_ELEMENT_REFERENCE___MODEL_SCOPE;
				case AlfPackage.ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING: return AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING;
				case AlfPackage.ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING: return AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING;
				case AlfPackage.ELEMENT_REFERENCE___RESOLVE_STEREOTYPE__STRING: return AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_STEREOTYPE__STRING;
				case AlfPackage.ELEMENT_REFERENCE___STUB: return AlfPackage.BOUND_ELEMENT_REFERENCE___STUB;
				case AlfPackage.ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION: return AlfPackage.BOUND_ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_UML:
				return isUml();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ALF:
				return isAlf();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___AS_UML:
				return asUml();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___AS_ALF:
				return asAlf();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___AS_MEMBER:
				return asMember();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMED_ELEMENT:
				return isNamedElement();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMESPACE:
				return isNamespace();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NAMESPACE_FOR__UNITDEFINITION:
				return isNamespaceFor((UnitDefinition)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_MODEL_NAMESPACE:
				return isModelNamespace();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PACKAGE:
				return isPackage();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PROFILE:
				return isProfile();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PACKAGEABLE_ELEMENT:
				return isPackageableElement();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASSIFIER:
				return isClassifier();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ABSTRACT_CLASSIFIER:
				return isAbstractClassifier();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ASSOCIATION:
				return isAssociation();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DATA_TYPE:
				return isDataType();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASS:
				return isClass();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVE_CLASS:
				return isActiveClass();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SIGNAL:
				return isSignal();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ENUMERATION:
				return isEnumeration();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_BEHAVIOR:
				return isBehavior();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVITY:
				return isActivity();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_METHOD:
				return isMethod();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PRIMITIVE_TYPE:
				return isPrimitiveType();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_RECEPTION:
				return isReception();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_OPERATION:
				return isOperation();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CONSTRUCTOR:
				return isConstructor();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DESTRUCTOR:
				return isDestructor();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_FEATURE:
				return isFeature();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PROPERTY:
				return isProperty();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ASSOCIATION_END:
				return isAssociationEnd();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PARAMETER:
				return isParameter();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE:
				return isTemplate();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_CLASSIFIER_TEMPLATE_PARAMETER:
				return isClassifierTemplateParameter();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_PARAMETERED_ELEMENT:
				return isParameteredElement();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_STEREOTYPE:
				return isStereotype();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ENUMERATION_LITERAL:
				return isEnumerationLiteral();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_LOOP_VARIABLE:
				return isLoopVariable();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ANNOTATION:
				return isAnnotation();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_SEQUENCE_EXPANSION_EXPRESSION:
				return isSequenceExpansionExpression();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_DISTINGUISHABLE_FROM__ELEMENTREFERENCE:
				return isDistinguishableFrom((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___NAME:
				return name();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___VISIBILITY:
				return visibility();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___OWNED_MEMBERS:
				return ownedMembers();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___MEMBERS:
				return members();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___NESTED_CLASSIFIERS:
				return nestedClassifiers();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___PROPERTIES:
				return properties();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___ASSOCIATION_ENDS:
				return associationEnds();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___OPPOSITE:
				return opposite();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___SIGNAL:
				return signal();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___PARAMETERS:
				return parameters();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___RETURN_PARAMETER:
				return returnParameter();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___SPECIFICATION:
				return specification();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___REDEFINED_OPERATIONS:
				return redefinedOperations();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___NAMESPACE:
				return namespace();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE:
				return template();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_PARAMETERS:
				return templateParameters();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___PARAMETERED_ELEMENTS:
				return parameteredElements();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_TEMPLATE_BINDING:
				return isTemplateBinding();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_ACTUALS:
				return templateActuals();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___DIRECTION:
				return direction();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___ASSOCIATION:
				return association();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___TYPE:
				return type();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___LOWER:
				return lower();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___UPPER:
				return upper();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ORDERED:
				return isOrdered();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_NONUNIQUE:
				return isNonunique();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___PARENTS:
				return parents();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___ALL_PARENTS:
				return allParents();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___CLASSIFIER_BEHAVIOR:
				return classifierBehavior();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___APPLIED_PROFILES:
				return appliedProfiles();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___REFERENCE:
				return reference();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___TEMPLATE_BINDING:
				return templateBinding();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___ACTIVE_CLASS:
				return activeClass();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___CONTEXT:
				return context();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___IS_ACTIVE_BEHAVIOR:
				return isActiveBehavior();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___CONFORMS_TO__ELEMENTREFERENCE:
				return conformsTo((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___EQUALS__ELEMENTREFERENCE:
				return equals((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___COPY:
				return copy();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___MODEL_SCOPE:
				return modelScope();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_PATH_NAME__STRING:
				return resolvePathName((String)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_IN_SCOPE__STRING:
				return resolveInScope((String)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___RESOLVE_STEREOTYPE__STRING:
				return resolveStereotype((String)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___STUB:
				return stub();
			case AlfPackage.BOUND_ELEMENT_REFERENCE___STUB_FOR__UNITDEFINITION:
				return stubFor((UnitDefinition)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___BOUND_REFERENCE_TO__ELEMENTREFERENCE:
				return boundReferenceTo((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___BOUND_REFERENCE_TO1__ELEMENTREFERENCE:
				return boundReferenceTo1((ElementReference)arguments.get(0));
			case AlfPackage.BOUND_ELEMENT_REFERENCE___BOUND_REFERENCES_TO__ELIST:
				return boundReferencesTo((EList<ElementReference>)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // BoundElementReferenceImpl
