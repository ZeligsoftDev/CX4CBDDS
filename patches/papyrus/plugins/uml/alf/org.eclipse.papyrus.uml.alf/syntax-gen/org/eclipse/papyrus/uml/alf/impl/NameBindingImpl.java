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
import org.eclipse.papyrus.uml.alf.NameBinding;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NameBindingImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NameBindingImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameBindingImpl extends SyntaxElementImpl implements NameBinding {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNameBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding getBinding() {
		return (TemplateBinding)eGet(AlfPackage.eINSTANCE.getNameBinding_Binding(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(TemplateBinding newBinding) {
		eSet(AlfPackage.eINSTANCE.getNameBinding_Binding(), newBinding);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(AlfPackage.eINSTANCE.getNameBinding_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(AlfPackage.eINSTANCE.getNameBinding_Name(), newName);
	}

	/**
	 * The cached invocation delegate for the '{@link #toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toString()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__ToString()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #toName() <em>To Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__ToName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toName() {
		try {
			return (String)TO_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #process(java.lang.String) <em>Process</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #process(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PROCESS_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__Process__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String process(String s) {
		try {
			return (String)PROCESS_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{s}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #escape(java.lang.String) <em>Escape</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #escape(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ESCAPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__Escape__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String escape(String s) {
		try {
			return (String)ESCAPE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{s}));
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
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__Copy()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameBinding copy() {
		try {
			return (NameBinding)COPY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #toQualifiedName(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>To Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toQualifiedName(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_QUALIFIED_NAME_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__ToQualifiedName__SyntaxElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName toQualifiedName(SyntaxElement owner) {
		try {
			return (QualifiedName)TO_QUALIFIED_NAME_SYNTAX_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{owner}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #toQualifiedNameWith(org.eclipse.papyrus.uml.alf.NameBinding, org.eclipse.papyrus.uml.alf.SyntaxElement) <em>To Qualified Name With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toQualifiedNameWith(org.eclipse.papyrus.uml.alf.NameBinding, org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_QUALIFIED_NAME_WITH_NAME_BINDING_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameBinding__ToQualifiedNameWith__NameBinding_SyntaxElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName toQualifiedNameWith(NameBinding other, SyntaxElement owner) {
		try {
			return (QualifiedName)TO_QUALIFIED_NAME_WITH_NAME_BINDING_SYNTAX_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{other, owner}));
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
			case AlfPackage.NAME_BINDING___TO_STRING:
				return toString();
			case AlfPackage.NAME_BINDING___TO_NAME:
				return toName();
			case AlfPackage.NAME_BINDING___PROCESS__STRING:
				return process((String)arguments.get(0));
			case AlfPackage.NAME_BINDING___ESCAPE__STRING:
				return escape((String)arguments.get(0));
			case AlfPackage.NAME_BINDING___COPY:
				return copy();
			case AlfPackage.NAME_BINDING___TO_QUALIFIED_NAME__SYNTAXELEMENT:
				return toQualifiedName((SyntaxElement)arguments.get(0));
			case AlfPackage.NAME_BINDING___TO_QUALIFIED_NAME_WITH__NAMEBINDING_SYNTAXELEMENT:
				return toQualifiedNameWith((NameBinding)arguments.get(0), (SyntaxElement)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // NameBindingImpl
