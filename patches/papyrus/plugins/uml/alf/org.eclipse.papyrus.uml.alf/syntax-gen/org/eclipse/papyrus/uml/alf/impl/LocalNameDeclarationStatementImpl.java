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
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Name Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#isHasMultiplicity <em>Has Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LocalNameDeclarationStatementImpl#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocalNameDeclarationStatementImpl extends StatementImpl implements LocalNameDeclarationStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected LocalNameDeclarationStatementImpl() {
		super();
		this.registerCaching();
	}

	public void clear() {
		super.clear();
		this.type = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getLocalNameDeclarationStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMultiplicity() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_HasMultiplicity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMultiplicity(boolean newHasMultiplicity) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_HasMultiplicity(), newHasMultiplicity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTypeName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_TypeName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(QualifiedName newTypeName) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_TypeName(), newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getType() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Type(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ElementReference newType) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Type(), newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAny() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_IsAny(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAny(boolean newIsAny) {
		eSet(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_IsAny(), newIsAny);
	}

	/**
	 * The cached invocation delegate for the '{@link #actualName() <em>Actual Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #actualName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ACTUAL_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__ActualName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String actualName() {
		try {
			return (String)ACTUAL_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsAfter() <em>Assignments After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__AssignmentsAfter()).getInvocationDelegate();

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
	 * @generated
	 */
	public boolean localNameDeclarationStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "localNameDeclarationStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #localNameDeclarationStatementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Local Name Declaration Statement Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localNameDeclarationStatementType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_NAME_DECLARATION_STATEMENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.typeName <> null implies \n" +
		"          self.type <> null and not self.type.isTemplate()\n" +
		"          and AssignableLocalNameDeclaration{localNameDeclaration = self}.\n" +
		"            isAssignableFrom(self.expression)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localNameDeclarationStatementType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__LocalNameDeclarationStatementType__DiagnosticChain_Map(),
				 LOCAL_NAME_DECLARATION_STATEMENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_TYPE);
	}

	/**
	 * The cached validation expression for the '{@link #localNameDeclarationStatementLocalName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Local Name Declaration Statement Local Name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localNameDeclarationStatementLocalName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_NAME_DECLARATION_STATEMENT_LOCAL_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"            not self.expression.assignmentBefore->exists(a | a.name = self.actualName()) and\n" +
		"            not self.expression.assignmentAfter->exists(a | a.name = self.actualName())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localNameDeclarationStatementLocalName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__LocalNameDeclarationStatementLocalName__DiagnosticChain_Map(),
				 LOCAL_NAME_DECLARATION_STATEMENT_LOCAL_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_LOCAL_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localNameDeclarationStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "localNameDeclarationStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #localNameDeclarationStatementExpressionMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Local Name Declaration Statement Expression Multiplicity</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localNameDeclarationStatementExpressionMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_NAME_DECLARATION_STATEMENT_EXPRESSION_MULTIPLICITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "(not self.hasMultiplicity) implies self.expression.upper <=1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localNameDeclarationStatementExpressionMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLocalNameDeclarationStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__LocalNameDeclarationStatementExpressionMultiplicity__DiagnosticChain_Map(),
				 LOCAL_NAME_DECLARATION_STATEMENT_EXPRESSION_MULTIPLICITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_EXPRESSION_MULTIPLICITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localNameDeclarationStatementTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOCAL_NAME_DECLARATION_STATEMENT__LOCAL_NAME_DECLARATION_STATEMENT_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "localNameDeclarationStatementTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	private ElementReference type = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ElementReference typeCached() {
		if (this.type == null) {
			this.type = this.type();
		}
		return this.type;
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLocalNameDeclarationStatement__Type()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER: return AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___ASSIGNMENTS_AFTER;
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
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___ACTUAL_NAME:
				return actualName();
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_LOCAL_NAME__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementLocalName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_EXPRESSION_MULTIPLICITY__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementExpressionMultiplicity((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___LOCAL_NAME_DECLARATION_STATEMENT_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return localNameDeclarationStatementTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___TYPE_CACHED:
				return typeCached();
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT___TYPE:
				return type();
		}
		return super.eInvoke(operationID, arguments);
	}

} // LocalNameDeclarationStatementImpl
