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
import org.eclipse.papyrus.uml.alf.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.TemplateBinding;
import org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NamedTemplateBindingImpl#getSubstitution <em>Substitution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedTemplateBindingImpl extends TemplateBindingImpl implements NamedTemplateBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedTemplateBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNamedTemplateBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TemplateParameterSubstitution> getSubstitution() {
		return (EList<TemplateParameterSubstitution>)eGet(AlfPackage.eINSTANCE.getNamedTemplateBinding_Substitution(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toString()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTemplateBinding__ToString()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate MATCHES_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTemplateBinding__Matches__ElementReference()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #matchesParameter(org.eclipse.papyrus.uml.alf.ElementReference) <em>Matches Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matchesParameter(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCHES_PARAMETER_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTemplateBinding__MatchesParameter__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matchesParameter(ElementReference parameter) {
		try {
			return (Boolean)MATCHES_PARAMETER_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{parameter}));
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
	protected static final EOperation.Internal.InvocationDelegate BIND_TO_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTemplateBinding__BindTo__ElementReference()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTemplateBinding__Copy()).getInvocationDelegate();

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
			case AlfPackage.NAMED_TEMPLATE_BINDING___TO_STRING:
				return toString();
			case AlfPackage.NAMED_TEMPLATE_BINDING___MATCHES__ELEMENTREFERENCE:
				return matches((ElementReference)arguments.get(0));
			case AlfPackage.NAMED_TEMPLATE_BINDING___MATCHES_PARAMETER__ELEMENTREFERENCE:
				return matchesParameter((ElementReference)arguments.get(0));
			case AlfPackage.NAMED_TEMPLATE_BINDING___BIND_TO__ELEMENTREFERENCE:
				return bindTo((ElementReference)arguments.get(0));
			case AlfPackage.NAMED_TEMPLATE_BINDING___COPY:
				return copy();
		}
		return super.eInvoke(operationID, arguments);
	}

} // NamedTemplateBindingImpl
