/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.PositionalTemplateBinding;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Positional Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PositionalTemplateBindingImpl#getArgumentName <em>Argument Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PositionalTemplateBindingImpl extends TemplateBindingImpl implements PositionalTemplateBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PositionalTemplateBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getPositionalTemplateBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<QualifiedName> getArgumentName() {
		return (EList<QualifiedName>)eGet(AlfPackage.eINSTANCE.getPositionalTemplateBinding_ArgumentName(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toString()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPositionalTemplateBinding__ToString()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		try {
			return (String)TO_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #matches(org.eclipse.papyrus.uml.alf.ElementReference) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matches(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCHES_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPositionalTemplateBinding__Matches__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matches(ElementReference template) {
		try {
			return (Boolean)MATCHES_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{template}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #matches(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.QualifiedName) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matches(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.QualifiedName)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCHES_ELEMENT_REFERENCE_QUALIFIED_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPositionalTemplateBinding__Matches__ElementReference_QualifiedName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matches(ElementReference parameter, QualifiedName argumentName) {
		try {
			return (Boolean)MATCHES_ELEMENT_REFERENCE_QUALIFIED_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{parameter, argumentName}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #bindTo(org.eclipse.papyrus.uml.alf.ElementReference) <em>Bind To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #bindTo(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BIND_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPositionalTemplateBinding__BindTo__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> bindTo(ElementReference template) {
		try {
			return (EList<ElementReference>)BIND_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{template}));
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
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPositionalTemplateBinding__Copy()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding copy() {
		try {
			return (TemplateBinding)COPY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING___TO_STRING:
				return toString();
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING___MATCHES__ELEMENTREFERENCE:
				return matches((ElementReference)arguments.get(0));
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING___MATCHES__ELEMENTREFERENCE_QUALIFIEDNAME:
				return matches((ElementReference)arguments.get(0), (QualifiedName)arguments.get(1));
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING___BIND_TO__ELEMENTREFERENCE:
				return bindTo((ElementReference)arguments.get(0));
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING___COPY:
				return copy();
		}
		return super.eInvoke(operationID, arguments);
	}

} // PositionalTemplateBindingImpl
