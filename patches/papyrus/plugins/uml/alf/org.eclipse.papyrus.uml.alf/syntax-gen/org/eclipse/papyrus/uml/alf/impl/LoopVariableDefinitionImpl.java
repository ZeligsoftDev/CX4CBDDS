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
import org.eclipse.papyrus.uml.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#isTypeIsInferred <em>Type Is Inferred</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#isIsFirst <em>Is First</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LoopVariableDefinitionImpl#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoopVariableDefinitionImpl extends SyntaxElementImpl implements LoopVariableDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopVariableDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getLoopVariableDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariable() {
		return (String)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Variable(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(String newVariable) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Variable(), newVariable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression1() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression1(Expression newExpression1) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression1(), newExpression1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression2() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression2(Expression newExpression2) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression2(), newExpression2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTypeName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_TypeName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(QualifiedName newTypeName) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_TypeName(), newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeIsInferred() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_TypeIsInferred(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeIsInferred(boolean newTypeIsInferred) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_TypeIsInferred(), newTypeIsInferred);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollectionConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsCollectionConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollectionConversion(boolean newIsCollectionConversion) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsCollectionConversion(), newIsCollectionConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getType() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Type(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ElementReference newType) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_Type(), newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFirst() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsFirst(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFirst(boolean newIsFirst) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsFirst(), newIsFirst);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentBefore() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_AssignmentBefore(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentAfter() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_AssignmentAfter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAny() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsAny(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAny(boolean newIsAny) {
		eSet(AlfPackage.eINSTANCE.getLoopVariableDefinition_IsAny(), newIsAny);
	}

	/**
	 * The cached invocation delegate for the '{@link #actualName() <em>Actual Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #actualName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ACTUAL_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLoopVariableDefinition__ActualName()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #newAssignments() <em>New Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #newAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NEW_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLoopVariableDefinition__NewAssignments()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> newAssignments() {
		try {
			return (EList<AssignedSource>)NEW_ASSIGNMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean loopVariableDefinitionAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_ASSIGNMENT_AFTER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "loopVariableDefinitionAssignmentAfterDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean loopVariableDefinitionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "loopVariableDefinitionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #loopVariableDefinitionRangeExpressions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Loop Variable Definition Range Expressions</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #loopVariableDefinitionRangeExpressions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOOP_VARIABLE_DEFINITION_RANGE_EXPRESSIONS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        if self.expression2 = null then true\n" +
		"        else\n" +
		"          let type1 = self.expression1.type in\n" +
		"          let type2 = self.expression2.type in\n" +
		"            type1 <> null and self.isIntegerType(type) and self.expression1.upper = 1 and\n" +
		"            type2 <> null and self.isIntegerType(type) and self.expression2.upper = 1 and\n" +
		"            expression1.newAssignments().name->excludesAll(expression2.newAssignments().name)\n" +
		"        endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionRangeExpressions(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLoopVariableDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLoopVariableDefinition__LoopVariableDefinitionRangeExpressions__DiagnosticChain_Map(),
				 LOOP_VARIABLE_DEFINITION_RANGE_EXPRESSIONS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_RANGE_EXPRESSIONS);
	}

	/**
	 * The cached validation expression for the '{@link #loopVariableDefinitionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Loop Variable Definition Type Name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #loopVariableDefinitionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOOP_VARIABLE_DEFINITION_TYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        if self.typeName = null then true\n" +
		"        else\n" +
		"          let referents = self.typeName.referent->select(isClassifier()) in\n" +
		"            referents->size() = 1 and not referents->exists(isTemplate())\n" +
		"        endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLoopVariableDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLoopVariableDefinition__LoopVariableDefinitionTypeName__DiagnosticChain_Map(),
				 LOOP_VARIABLE_DEFINITION_TYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_TYPE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "loopVariableDefinitionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #loopVariableDefinitionDeclaredType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Loop Variable Definition Declared Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #loopVariableDefinitionDeclaredType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOOP_VARIABLE_DEFINITION_DECLARED_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        if self.typeIsInferred then true\n" +
		"        else self.expression1.type.conformsTo(self.type)\n" +
		"        endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionDeclaredType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLoopVariableDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLoopVariableDefinition__LoopVariableDefinitionDeclaredType__DiagnosticChain_Map(),
				 LOOP_VARIABLE_DEFINITION_DECLARED_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_DECLARED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "loopVariableDefinitionIsCollectionConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #loopVariableDefinitionVariable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Loop Variable Definition Variable</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #loopVariableDefinitionVariable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LOOP_VARIABLE_DEFINITION_VARIABLE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.expression1.assignmentAfter.name->excludes(self.actualName()) and\n" +
		"        self.expression2 <> null implies\n" +
		"          self.expression2.assignmentAfter.name->excludes(self.actualName())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean loopVariableDefinitionVariable(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLoopVariableDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLoopVariableDefinition__LoopVariableDefinitionVariable__DiagnosticChain_Map(),
				 LOOP_VARIABLE_DEFINITION_VARIABLE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LOOP_VARIABLE_DEFINITION__LOOP_VARIABLE_DEFINITION_VARIABLE);
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
			case AlfPackage.LOOP_VARIABLE_DEFINITION___ACTUAL_NAME:
				return actualName();
			case AlfPackage.LOOP_VARIABLE_DEFINITION___NEW_ASSIGNMENTS:
				return newAssignments();
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_ASSIGNMENT_AFTER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionAssignmentAfterDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_RANGE_EXPRESSIONS__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionRangeExpressions((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_TYPE_NAME__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionTypeName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_DECLARED_TYPE__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionDeclaredType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionIsCollectionConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LOOP_VARIABLE_DEFINITION___LOOP_VARIABLE_DEFINITION_VARIABLE__DIAGNOSTICCHAIN_MAP:
				return loopVariableDefinitionVariable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // LoopVariableDefinitionImpl
