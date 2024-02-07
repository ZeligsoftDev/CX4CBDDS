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
import org.eclipse.papyrus.uml.alf.ClassifyStatement;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.QualifiedNameList;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#getFromList <em>From List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#getToList <em>To List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#getFromClass <em>From Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#getToClass <em>To Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassifyStatementImpl#isIsReclassifyAll <em>Is Reclassify All</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifyStatementImpl extends StatementImpl implements ClassifyStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifyStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getClassifyStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getClassifyStatement_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getClassifyStatement_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedNameList getFromList() {
		return (QualifiedNameList)eGet(AlfPackage.eINSTANCE.getClassifyStatement_FromList(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromList(QualifiedNameList newFromList) {
		eSet(AlfPackage.eINSTANCE.getClassifyStatement_FromList(), newFromList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedNameList getToList() {
		return (QualifiedNameList)eGet(AlfPackage.eINSTANCE.getClassifyStatement_ToList(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToList(QualifiedNameList newToList) {
		eSet(AlfPackage.eINSTANCE.getClassifyStatement_ToList(), newToList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getFromClass() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getClassifyStatement_FromClass(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getToClass() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getClassifyStatement_ToClass(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsReclassifyAll() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getClassifyStatement_IsReclassifyAll(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReclassifyAll(boolean newIsReclassifyAll) {
		eSet(AlfPackage.eINSTANCE.getClassifyStatement_IsReclassifyAll(), newIsReclassifyAll);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentAfter() <em>Assignment After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENT_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassifyStatement__AssignmentAfter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentAfter() {
		try {
			return (EList<AssignedSource>)ASSIGNMENT_AFTER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #classifyStatementExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Classify Statement Expression</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classifyStatementExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFY_STATEMENT_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let type = self.expression.type in\n" +
		"          type <> null and type.isClass() and self.expression.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classifyStatementExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassifyStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassifyStatement__ClassifyStatementExpression__DiagnosticChain_Map(),
				 CLASSIFY_STATEMENT_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_EXPRESSION);
	}

	/**
	 * The cached validation expression for the '{@link #classifyStatementClassNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Classify Statement Class Names</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classifyStatementClassNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFY_STATEMENT_CLASS_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let fromNames = \n" +
		"          if self.fromList = null then Set(QualifiedName){}\n" +
		"          else self.fromList.name->asSet()\n" +
		"          endif\n" +
		"        in\n" +
		"        let toNames =\n" +
		"          if self.toList = null then Set(QualifiedName){}\n" +
		"          else self.toList.name->asSet()\n" +
		"          endif\n" +
		"        in\n" +
		"          fromNames->union(toNames)->forAll(name |\n" +
		"            let referent = name.referent->select(isClass()) in\n" +
		"              referent->size() = 1 and\n" +
		"              referent->forAll(not isTemplate())\n" +
		"          )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classifyStatementClassNames(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassifyStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassifyStatement__ClassifyStatementClassNames__DiagnosticChain_Map(),
				 CLASSIFY_STATEMENT_CLASS_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_CLASS_NAMES);
	}

	/**
	 * The cached validation expression for the '{@link #classifyStatementClasses(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Classify Statement Classes</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classifyStatementClasses(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFY_STATEMENT_CLASSES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let classes = self.fromClass->union(self.toClass) in\n" +
		"        let expressionType = self.expression.type in\n" +
		"          if expressionType = null then true\n" +
		"          else\n" +
		"            classes->\n" +
		"              forAll(not equals(expressionType) and conformsTo(expressionType)) and\n" +
		"            let parents : Bag(ElementReference) = classes.allParents()->\n" +
		"                select(not equals(expressionType) and conformsTo(expressionType)) \n" +
		"            in\n" +
		"              parents->forAll(countIn(parents) = 1)\n" +
		"          endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classifyStatementClasses(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassifyStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassifyStatement__ClassifyStatementClasses__DiagnosticChain_Map(),
				 CLASSIFY_STATEMENT_CLASSES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_CLASSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classifyStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classifyStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean classifyStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classifyStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean classifyStatementFromClassDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_FROM_CLASS_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classifyStatementFromClassDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean classifyStatementToClassDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASSIFY_STATEMENT__CLASSIFY_STATEMENT_TO_CLASS_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classifyStatementToClassDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.CLASSIFY_STATEMENT___ASSIGNMENT_AFTER:
				return assignmentAfter();
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return classifyStatementExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_CLASS_NAMES__DIAGNOSTICCHAIN_MAP:
				return classifyStatementClassNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_CLASSES__DIAGNOSTICCHAIN_MAP:
				return classifyStatementClasses((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return classifyStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return classifyStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_FROM_CLASS_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return classifyStatementFromClassDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASSIFY_STATEMENT___CLASSIFY_STATEMENT_TO_CLASS_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return classifyStatementToClassDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ClassifyStatementImpl
