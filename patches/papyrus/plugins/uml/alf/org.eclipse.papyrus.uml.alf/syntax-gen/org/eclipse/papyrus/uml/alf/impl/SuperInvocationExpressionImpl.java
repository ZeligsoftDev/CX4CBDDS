/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.SuperInvocationExpression;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SuperInvocationExpressionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SuperInvocationExpressionImpl extends InvocationExpressionImpl implements SuperInvocationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperInvocationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSuperInvocationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTarget() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getSuperInvocationExpression_Target(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(QualifiedName newTarget) {
		eSet(AlfPackage.eINSTANCE.getSuperInvocationExpression_Target(), newTarget);
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSuperInvocationExpression__Referent()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference referent() {
		try {
			return (ElementReference)REFERENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSuperInvocationExpression__Feature()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #context() <em>Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #context()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CONTEXT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSuperInvocationExpression__Context()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "superInvocationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "superInvocationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #superInvocationExpressionQualification(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Super Invocation Expression Qualification</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #superInvocationExpressionQualification(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_INVOCATION_EXPRESSION_QUALIFICATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.target = null or\n" +
		"        let qualification = self.target.qualification in\n" +
		"          qualification <> null implies\n" +
		"            let superclass = qualification.referent->select(isClass()) in\n" +
		"            let context = self.context() in\n" +
		"              superclass->size() = 1 and context <> null and\n" +
		"              superclass->forAll(containedIn(context.parents()->asBag()))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionQualification(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSuperInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSuperInvocationExpression__SuperInvocationExpressionQualification__DiagnosticChain_Map(),
				 SUPER_INVOCATION_EXPRESSION_QUALIFICATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_QUALIFICATION);
	}

	/**
	 * The cached validation expression for the '{@link #superInvocationExpressionImplicitTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Super Invocation Expression Implicit Target</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #superInvocationExpressionImplicitTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_INVOCATION_EXPRESSION_IMPLICIT_TARGET_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.target = null implies\n" +
		"          let referent = self.referent in\n" +
		"          let context = self.context() in\n" +
		"            referent <> null and referent.isConstructor() and\n" +
		"            context <> null and context.parents()->size() = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionImplicitTarget(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSuperInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSuperInvocationExpression__SuperInvocationExpressionImplicitTarget__DiagnosticChain_Map(),
				 SUPER_INVOCATION_EXPRESSION_IMPLICIT_TARGET_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_IMPLICIT_TARGET);
	}

	/**
	 * The cached validation expression for the '{@link #superInvocationExpressionConstructorCall(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Super Invocation Expression Constructor Call</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #superInvocationExpressionConstructorCall(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_INVOCATION_EXPRESSION_CONSTRUCTOR_CALL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let referent = self.referent in\n" +
		"        let context = self.context() in\n" +
		"          referent <> null and referent.isConstructor() and context <> null implies\n" +
		"          let operation = self.currentScope().specification() in\n" +
		"            operation.isConstructor() and\n" +
		"            let statement = self.enclosingStatement() in\n" +
		"              statement <> null and statement.oclIsKindOf(ExpressionStatement) and\n" +
		"                let annotatedStatement = statement.owner() in\n" +
		"                let owner = annotatedStatement.owner() in\n" +
		"                  owner <> null implies owner.oclIsKindOf(Block) and\n" +
		"                    let block = owner.oclAsType(Block) in\n" +
		"                      block.enclosingStatement() = null and\n" +
		"                      let classReference = referent.namespace() in\n" +
		"                      let i = block.statement->indexOf(annotatedStatement) in\n" +
		"                        i = 1 or\n" +
		"                        block.statement->subOrderedSet(1, i-1).statement->forAll(\n" +
		"                          oclIsKindOf(ExpressionStatement) and\n" +
		"                          let expression = oclAsType(ExpressionStatement).expression in\n" +
		"                            expression.oclIsKindOf(SuperInvocationExpression) and\n" +
		"                            -- NOTE: This checks to ensure that no previous\n" +
		"                            -- super-constructor invocation is for the same\n" +
		"                            -- superclass\n" +
		"                            not expression.oclAsType(SuperInvocationExpression).\n" +
		"                              referent.namespace().equals(classReference)\n" +
		"                        )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionConstructorCall(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSuperInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSuperInvocationExpression__SuperInvocationExpressionConstructorCall__DiagnosticChain_Map(),
				 SUPER_INVOCATION_EXPRESSION_CONSTRUCTOR_CALL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_CONSTRUCTOR_CALL);
	}

	/**
	 * The cached validation expression for the '{@link #superInvocationExpressionDestructorCall(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Super Invocation Expression Destructor Call</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #superInvocationExpressionDestructorCall(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_INVOCATION_EXPRESSION_DESTRUCTOR_CALL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let referent = self.referent in\n" +
		"          referent <> null and referent.isDestructor() implies\n" +
		"            let operation = self.currentScope() in\n" +
		"              operation <> null and operation.isDestructor()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionDestructorCall(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSuperInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSuperInvocationExpression__SuperInvocationExpressionDestructorCall__DiagnosticChain_Map(),
				 SUPER_INVOCATION_EXPRESSION_DESTRUCTOR_CALL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_DESTRUCTOR_CALL);
	}

	/**
	 * The cached validation expression for the '{@link #superInvocationExpressionOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Super Invocation Expression Operation</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #superInvocationExpressionOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_INVOCATION_EXPRESSION_OPERATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.referent <> null and\n" +
		"        -- TODO: Remove this check once overloading resolution is implemented.\n" +
		"        self.tuple.size() <= self.parameterCount() and\n" +
		"        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n" +
		"        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean superInvocationExpressionOperation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSuperInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSuperInvocationExpression__SuperInvocationExpressionOperation__DiagnosticChain_Map(),
				 SUPER_INVOCATION_EXPRESSION_OPERATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SUPER_INVOCATION_EXPRESSION__SUPER_INVOCATION_EXPRESSION_OPERATION);
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
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___CONTEXT:
				return context();
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_QUALIFICATION__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionQualification((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_IMPLICIT_TARGET__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionImplicitTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_CONSTRUCTOR_CALL__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionConstructorCall((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_DESTRUCTOR_CALL__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionDestructorCall((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SUPER_INVOCATION_EXPRESSION___SUPER_INVOCATION_EXPRESSION_OPERATION__DIAGNOSTICCHAIN_MAP:
				return superInvocationExpressionOperation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SuperInvocationExpressionImpl
