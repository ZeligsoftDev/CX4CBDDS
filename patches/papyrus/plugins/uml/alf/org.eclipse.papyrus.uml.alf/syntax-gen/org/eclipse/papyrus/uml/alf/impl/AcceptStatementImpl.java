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

import org.eclipse.papyrus.uml.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;

import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accept Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AcceptStatementImpl#getAcceptBlock <em>Accept Block</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AcceptStatementImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AcceptStatementImpl#isIsSimple <em>Is Simple</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AcceptStatementImpl extends StatementImpl implements AcceptStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AcceptStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAcceptStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AcceptBlock> getAcceptBlock() {
		return (EList<AcceptBlock>)eGet(AlfPackage.eINSTANCE.getAcceptStatement_AcceptBlock(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getBehavior() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getAcceptStatement_Behavior(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(ElementReference newBehavior) {
		eSet(AlfPackage.eINSTANCE.getAcceptStatement_Behavior(), newBehavior);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSimple() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAcceptStatement_IsSimple(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSimple(boolean newIsSimple) {
		eSet(AlfPackage.eINSTANCE.getAcceptStatement_IsSimple(), newIsSimple);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsAfter() <em>Assignments After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAcceptStatement__AssignmentsAfter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsAfter() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference effectiveBehavior() {
		return this.effectiveBehavior_();
	}

	/**
	 * The cached invocation delegate for the '{@link #effectiveBehavior_() <em>Effective Behavior </em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #effectiveBehavior_()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EFFECTIVE_BEHAVIOR___EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAcceptStatement__EffectiveBehavior_()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference effectiveBehavior_() {
		try {
			return (ElementReference)EFFECTIVE_BEHAVIOR___EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #acceptStatementContext(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Accept Statement Context</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #acceptStatementContext(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACCEPT_STATEMENT_CONTEXT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      let behavior = self.effectiveBehavior() in\n" +
		"                        behavior <> null and behavior.isActiveBehavior()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementContext(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAcceptStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAcceptStatement__AcceptStatementContext__DiagnosticChain_Map(),
				 ACCEPT_STATEMENT_CONTEXT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_CONTEXT);
	}

	/**
	 * The cached validation expression for the '{@link #acceptStatementSignals(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Accept Statement Signals</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #acceptStatementSignals(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACCEPT_STATEMENT_SIGNALS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      let signals : Bag(ElementReference) = self.acceptBlock.signal in\n" +
		"                      let behavior = self.effectiveBehavior() in\n" +
		"                      let activeClass = \n" +
		"                        if behavior = null then null \n" +
		"                        else behavior.activeClass() \n" +
		"                        endif \n" +
		"                      in\n" +
		"                        signals->forAll(s | signals->select(equals(s))->size() = 1) and\n" +
		"                        (activeClass = null or  -- Let the acceptStatementContext constraint catch a null active class.\n" +
		"                            signals->forAll(containedIn(self.receivedSignals(activeClass))))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementSignals(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAcceptStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAcceptStatement__AcceptStatementSignals__DiagnosticChain_Map(),
				 ACCEPT_STATEMENT_SIGNALS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_SIGNALS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ElementReference> receivedSignals(ElementReference activeClass) {
		return this.receivedSignals_(activeClass);
	}

	/**
	 * The cached invocation delegate for the '{@link #receivedSignals_(org.eclipse.papyrus.uml.alf.ElementReference) <em>Received Signals </em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #receivedSignals_(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RECEIVED_SIGNALS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAcceptStatement__ReceivedSignals___ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> receivedSignals_(ElementReference activeClass) {
		try {
			return (EList<ElementReference>)RECEIVED_SIGNALS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{activeClass}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #acceptStatementNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Accept Statement Names</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #acceptStatementNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACCEPT_STATEMENT_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      let namesBefore = self.assignmentBefore.name in\n" +
		"                        self.acceptBlock.actualName()->excludesAll(namesBefore)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementNames(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAcceptStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAcceptStatement__AcceptStatementNames__DiagnosticChain_Map(),
				 ACCEPT_STATEMENT_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementSimpleAcceptLocalName(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_SIMPLE_ACCEPT_LOCAL_NAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementSimpleAcceptLocalName", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean acceptStatementCompoundAcceptLocalName(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_COMPOUND_ACCEPT_LOCAL_NAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementCompoundAcceptLocalName", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean acceptStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean acceptStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #acceptStatementNewAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Accept Statement New Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #acceptStatementNewAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACCEPT_STATEMENT_NEW_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      if self.acceptBlock->size() = 1 then true\n" +
		"                      else\n" +
		"                        let namesBefore = self.assignmentBefore.name in\n" +
		"                        let newNames : Bag(String) = \n" +
		"                          self.acceptBlock.block.newAssignments().name in\n" +
		"                          newNames->forAll(name | \n" +
		"                            namesBefore->excludes(name) implies \n" +
		"                            newNames->count(name) = self.acceptBlock->size()\n" +
		"                          )\n" +
		"                      endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementNewAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAcceptStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAcceptStatement__AcceptStatementNewAssignments__DiagnosticChain_Map(),
				 ACCEPT_STATEMENT_NEW_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_NEW_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean acceptStatementIsSimpleDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_IS_SIMPLE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementIsSimpleDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean acceptStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ACCEPT_STATEMENT__ACCEPT_STATEMENT_ENCLOSED_STATEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "acceptStatementEnclosedStatements", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER: return AlfPackage.ACCEPT_STATEMENT___ASSIGNMENTS_AFTER;
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
			case AlfPackage.ACCEPT_STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.ACCEPT_STATEMENT___EFFECTIVE_BEHAVIOR:
				return effectiveBehavior();
			case AlfPackage.ACCEPT_STATEMENT___EFFECTIVE_BEHAVIOR_:
				return effectiveBehavior_();
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_CONTEXT__DIAGNOSTICCHAIN_MAP:
				return acceptStatementContext((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_SIGNALS__DIAGNOSTICCHAIN_MAP:
				return acceptStatementSignals((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___RECEIVED_SIGNALS__ELEMENTREFERENCE:
				return receivedSignals((ElementReference)arguments.get(0));
			case AlfPackage.ACCEPT_STATEMENT___RECEIVED_SIGNALS____ELEMENTREFERENCE:
				return receivedSignals_((ElementReference)arguments.get(0));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_NAMES__DIAGNOSTICCHAIN_MAP:
				return acceptStatementNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_SIMPLE_ACCEPT_LOCAL_NAME__DIAGNOSTICCHAIN_MAP:
				return acceptStatementSimpleAcceptLocalName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_COMPOUND_ACCEPT_LOCAL_NAME__DIAGNOSTICCHAIN_MAP:
				return acceptStatementCompoundAcceptLocalName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return acceptStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return acceptStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_NEW_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return acceptStatementNewAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_IS_SIMPLE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return acceptStatementIsSimpleDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACCEPT_STATEMENT___ACCEPT_STATEMENT_ENCLOSED_STATEMENTS__DIAGNOSTICCHAIN_MAP:
				return acceptStatementEnclosedStatements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // AcceptStatementImpl
