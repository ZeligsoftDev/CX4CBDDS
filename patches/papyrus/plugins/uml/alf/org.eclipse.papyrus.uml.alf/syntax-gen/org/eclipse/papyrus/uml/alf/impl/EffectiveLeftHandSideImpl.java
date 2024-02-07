/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.EffectiveLeftHandSide;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.LeftHandSide;
import org.eclipse.papyrus.uml.alf.NameLeftHandSide;
import org.eclipse.papyrus.uml.alf.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effective Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.EffectiveLeftHandSideImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EffectiveLeftHandSideImpl extends NameLeftHandSideImpl implements EffectiveLeftHandSide {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffectiveLeftHandSideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getEffectiveLeftHandSide();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getEffectiveLeftHandSide_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getEffectiveLeftHandSide_Expression(), newExpression);
	}

	/**
	 * The cached invocation delegate for the '{@link #target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #target()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TARGET__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getEffectiveLeftHandSide__Target()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName target() {
		try {
			return (QualifiedName)TARGET__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #index() <em>Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #index()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INDEX__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getEffectiveLeftHandSide__Index()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression index() {
		try {
			return (Expression)INDEX__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #feature() <em>Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #feature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getEffectiveLeftHandSide__Feature()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference feature() {
		try {
			return (FeatureReference)FEATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #primary() <em>Primary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #primary()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PRIMARY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getEffectiveLeftHandSide__Primary()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression primary() {
		try {
			return (Expression)PRIMARY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #expression() <em>Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #expression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getEffectiveLeftHandSide__Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression expression() {
		try {
			return (Expression)EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
		if (baseClass == LeftHandSide.class) {
			switch (baseOperationID) {
				case AlfPackage.LEFT_HAND_SIDE___FEATURE: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___FEATURE;
				case AlfPackage.LEFT_HAND_SIDE___EXPRESSION: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___EXPRESSION;
				case AlfPackage.LEFT_HAND_SIDE___INDEX: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___INDEX;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NameLeftHandSide.class) {
			switch (baseOperationID) {
				case AlfPackage.NAME_LEFT_HAND_SIDE___TARGET: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___TARGET;
				case AlfPackage.NAME_LEFT_HAND_SIDE___INDEX: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___INDEX;
				case AlfPackage.NAME_LEFT_HAND_SIDE___FEATURE: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___FEATURE;
				case AlfPackage.NAME_LEFT_HAND_SIDE___EXPRESSION: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___EXPRESSION;
				case AlfPackage.NAME_LEFT_HAND_SIDE___PRIMARY: return AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___PRIMARY;
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
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___TARGET:
				return target();
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___INDEX:
				return index();
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___FEATURE:
				return feature();
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___PRIMARY:
				return primary();
			case AlfPackage.EFFECTIVE_LEFT_HAND_SIDE___EXPRESSION:
				return expression();
		}
		return super.eInvoke(operationID, arguments);
	}

} // EffectiveLeftHandSideImpl
