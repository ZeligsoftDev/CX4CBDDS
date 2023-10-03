/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TemplateParameterSubstitutionImpl#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TemplateParameterSubstitutionImpl#getArgumentName <em>Argument Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TemplateParameterSubstitutionImpl#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateParameterSubstitutionImpl extends SyntaxElementImpl implements TemplateParameterSubstitution {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getTemplateParameterSubstitution();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterName() {
		return (String)eGet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_ParameterName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterName(String newParameterName) {
		eSet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_ParameterName(), newParameterName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getArgumentName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_ArgumentName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentName(QualifiedName newArgumentName) {
		eSet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_ArgumentName(), newArgumentName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReferent() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(ElementReference newReferent) {
		eSet(AlfPackage.eINSTANCE.getTemplateParameterSubstitution_Referent(), newReferent);
	}

	/**
	 * The cached invocation delegate for the '{@link #actualParameterName() <em>Actual Parameter Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #actualParameterName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ACTUAL_PARAMETER_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTemplateParameterSubstitution__ActualParameterName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String actualParameterName() {
		try {
			return (String)ACTUAL_PARAMETER_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #toString()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TO_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTemplateParameterSubstitution__ToString()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #copy()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTemplateParameterSubstitution__Copy()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterSubstitution copy() {
		try {
			return (TemplateParameterSubstitution)COPY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION___ACTUAL_PARAMETER_NAME:
				return actualParameterName();
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION___TO_STRING:
				return toString();
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION___COPY:
				return copy();
		}
		return super.eInvoke(operationID, arguments);
	}

} // TemplateParameterSubstitutionImpl
