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
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.ExpressionReference;
import org.eclipse.papyrus.uml.alf.SyntaxElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ExpressionReferenceImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionReferenceImpl extends ExpressionImpl implements ExpressionReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getExpressionReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getExpressionReference_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getExpressionReference_Expression(), newExpression);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__Upper()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isAddTarget(org.eclipse.papyrus.uml.alf.Expression) <em>Is Add Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddTarget(org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__IsAddTarget__Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddTarget(Expression targetExpression) {
		try {
			return (Boolean)IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{targetExpression}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore() <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__AssignmentsBefore()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExpressionReference__UpdateAssignments()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> updateAssignments() {
		try {
			return (EList<AssignedSource>)UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE: return AlfPackage.EXPRESSION_REFERENCE___ASSIGNMENTS_BEFORE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.EXPRESSION_REFERENCE___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.EXPRESSION_REFERENCE___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.EXPRESSION_REFERENCE___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.EXPRESSION_REFERENCE___UPDATE_ASSIGNMENTS;
				case AlfPackage.EXPRESSION___IS_ADD_TARGET__EXPRESSION: return AlfPackage.EXPRESSION_REFERENCE___IS_ADD_TARGET__EXPRESSION;
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
			case AlfPackage.EXPRESSION_REFERENCE___TYPE:
				return type();
			case AlfPackage.EXPRESSION_REFERENCE___LOWER:
				return lower();
			case AlfPackage.EXPRESSION_REFERENCE___UPPER:
				return upper();
			case AlfPackage.EXPRESSION_REFERENCE___IS_ADD_TARGET__EXPRESSION:
				return isAddTarget((Expression)arguments.get(0));
			case AlfPackage.EXPRESSION_REFERENCE___ASSIGNMENTS_BEFORE:
				return assignmentsBefore();
			case AlfPackage.EXPRESSION_REFERENCE___UPDATE_ASSIGNMENTS:
				return updateAssignments();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExpressionReferenceImpl
