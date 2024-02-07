/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.ExtentOrExpression;
import org.eclipse.papyrus.uml.alf.QualifiedName;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extent Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ExtentOrExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ExtentOrExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ExtentOrExpressionImpl#getNonNameExpression <em>Non Name Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtentOrExpressionImpl extends ExpressionImpl implements ExtentOrExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtentOrExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getExtentOrExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getExtentOrExpression_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(QualifiedName newName) {
		eSet(AlfPackage.eINSTANCE.getExtentOrExpression_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getExtentOrExpression_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getExtentOrExpression_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getNonNameExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getExtentOrExpression_NonNameExpression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonNameExpression(Expression newNonNameExpression) {
		eSet(AlfPackage.eINSTANCE.getExtentOrExpression_NonNameExpression(), newNonNameExpression);
	}

	/**
	 * The cached invocation delegate for the '{@link #isAddTarget(org.eclipse.papyrus.uml.alf.Expression) <em>Is Add Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddTarget(org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getExtentOrExpression__IsAddTarget__Expression()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean extentOrExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_EXPRESSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "extentOrExpressionExpressionDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #extentOrExpressionExtentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Extent Or Expression Extent Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #extentOrExpressionExtentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENT_OR_EXPRESSION_EXTENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      let expression = self.expression in\n" +
		"        expression.oclIsKindOf(ClassExtentExpression) implies\n" +
		"          expression.oclAsType(ClassExtentExpression).validateClassExtentExpressionExtentType()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean extentOrExpressionExtentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getExtentOrExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getExtentOrExpression__ExtentOrExpressionExtentType__DiagnosticChain_Map(),
				 EXTENT_OR_EXPRESSION_EXTENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_EXTENT_TYPE);
	}

	/**
	 * The cached validation expression for the '{@link #extentOrExpressionResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Extent Or Expression Resolution</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #extentOrExpressionResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENT_OR_EXPRESSION_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      let expression = self.expression in\n" +
		"        expression.oclIsKindOf(NameExpression) implies\n" +
		"          expression.oclAsType(NameExpression).validateNameExpressionResolution()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean extentOrExpressionResolution(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getExtentOrExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getExtentOrExpression__ExtentOrExpressionResolution__DiagnosticChain_Map(),
				 EXTENT_OR_EXPRESSION_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.EXTENT_OR_EXPRESSION__EXTENT_OR_EXPRESSION_RESOLUTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___IS_ADD_TARGET__EXPRESSION: return AlfPackage.EXTENT_OR_EXPRESSION___IS_ADD_TARGET__EXPRESSION;
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
			case AlfPackage.EXTENT_OR_EXPRESSION___IS_ADD_TARGET__EXPRESSION:
				return isAddTarget((Expression)arguments.get(0));
			case AlfPackage.EXTENT_OR_EXPRESSION___EXTENT_OR_EXPRESSION_EXPRESSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return extentOrExpressionExpressionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.EXTENT_OR_EXPRESSION___EXTENT_OR_EXPRESSION_EXTENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return extentOrExpressionExtentType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.EXTENT_OR_EXPRESSION___EXTENT_OR_EXPRESSION_RESOLUTION__DIAGNOSTICCHAIN_MAP:
				return extentOrExpressionResolution((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ExtentOrExpressionImpl
