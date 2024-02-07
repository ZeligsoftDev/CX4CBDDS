/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
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
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.InputNamedExpression;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.OutputNamedExpression;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.Tuple;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TupleImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TupleImpl#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TupleImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TupleImpl extends SyntaxElementImpl implements Tuple {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TupleImpl() {
		super();
		this.registerCaching();
	}

	public void clear()
	{
		super.clear();
		this.inputs = null;
		this.outputs = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getTuple();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InputNamedExpression> getInput() {
		return (EList<InputNamedExpression>)eGet(AlfPackage.eINSTANCE.getTuple_Input(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationExpression getInvocation() {
		return (InvocationExpression)eGet(AlfPackage.eINSTANCE.getTuple_Invocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocation(InvocationExpression newInvocation) {
		eSet(AlfPackage.eINSTANCE.getTuple_Invocation(), newInvocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<OutputNamedExpression> getOutput() {
		return (EList<OutputNamedExpression>)eGet(AlfPackage.eINSTANCE.getTuple_Output(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger size() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private EList<InputNamedExpression> inputs = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<InputNamedExpression> inputCached() {
		if (this.inputs == null) {
			this.inputs = this.input();
		}
		return this.inputs;
	}

	/**
	 * The cached invocation delegate for the '{@link #input() <em>Input</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #input()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INPUT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__Input()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InputNamedExpression> input() {
		try {
			return (EList<InputNamedExpression>)INPUT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public EList<InputNamedExpression> inputFor(EList<ElementReference> parameters) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private EList<OutputNamedExpression> outputs = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<OutputNamedExpression> outputCached() {
		if (this.outputs == null) {
			this.outputs = this.output();
		}
		return this.outputs;
	}

	/**
	 * The cached invocation delegate for the '{@link #output() <em>Output</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #output()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTPUT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__Output()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<OutputNamedExpression> output() {
		try {
			return (EList<OutputNamedExpression>)OUTPUT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public EList<OutputNamedExpression> outputFor(EList<ElementReference> parameters) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputNamedExpression outputForExpression(Expression expression) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore(SyntaxElement element) {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
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
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__AssignmentsAfter()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #newAssignments() <em>New Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #newAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NEW_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__NewAssignments()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #updateFor(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.uml.alf.OutputNamedExpression) <em>Update For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateFor(org.eclipse.emf.common.util.EList, org.eclipse.papyrus.uml.alf.OutputNamedExpression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_FOR_ELIST_OUTPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTuple__UpdateFor__EList_OutputNamedExpression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> updateFor(EList<AssignedSource> assignments, OutputNamedExpression output) {
		try {
			return (EList<AssignedSource>)UPDATE_FOR_ELIST_OUTPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{assignments, output}));
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
	public boolean tupleInputDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TUPLE__TUPLE_INPUT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "tupleInputDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean tupleOutputDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TUPLE__TUPLE_OUTPUT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "tupleOutputDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #tupleNullInputs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Tuple Null Inputs</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #tupleNullInputs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TUPLE_NULL_INPUTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.input->forAll(\n" +
		"          expression.isNull() implies \n" +
		"            self.invocation.parameterNamed(name).lower() = 0\n" +
		"        )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean tupleNullInputs(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getTuple(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getTuple__TupleNullInputs__DiagnosticChain_Map(),
				 TUPLE_NULL_INPUTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.TUPLE__TUPLE_NULL_INPUTS);
	}

	/**
	 * The cached validation expression for the '{@link #tupleOutputs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Tuple Outputs</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #tupleOutputs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TUPLE_OUTPUTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.output->forAll(\n" +
		"          expression.isNull() implies \n" +
		"            self.invocation.parameterNamed(name).direction() = 'out'\n" +
		"        )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean tupleOutputs(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getTuple(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getTuple__TupleOutputs__DiagnosticChain_Map(),
				 TUPLE_OUTPUTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.TUPLE__TUPLE_OUTPUTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean tupleAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TUPLE__TUPLE_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "tupleAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #tupleAssignmentsAfter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Tuple Assignments After</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #tupleAssignmentsAfter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TUPLE_ASSIGNMENTS_AFTER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.input.expression->union(self.output.expression).\n" +
		"          newAssignments()->isUnique(name)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean tupleAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getTuple(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getTuple__TupleAssignmentsAfter__DiagnosticChain_Map(),
				 TUPLE_ASSIGNMENTS_AFTER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.TUPLE__TUPLE_ASSIGNMENTS_AFTER);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.TUPLE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
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
			case AlfPackage.TUPLE___SIZE:
				return size();
			case AlfPackage.TUPLE___INPUT_CACHED:
				return inputCached();
			case AlfPackage.TUPLE___INPUT:
				return input();
			case AlfPackage.TUPLE___INPUT_FOR__ELIST:
				return inputFor((EList<ElementReference>)arguments.get(0));
			case AlfPackage.TUPLE___OUTPUT_CACHED:
				return outputCached();
			case AlfPackage.TUPLE___OUTPUT:
				return output();
			case AlfPackage.TUPLE___OUTPUT_FOR__ELIST:
				return outputFor((EList<ElementReference>)arguments.get(0));
			case AlfPackage.TUPLE___OUTPUT_FOR_EXPRESSION__EXPRESSION:
				return outputForExpression((Expression)arguments.get(0));
			case AlfPackage.TUPLE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.TUPLE___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.TUPLE___NEW_ASSIGNMENTS:
				return newAssignments();
			case AlfPackage.TUPLE___UPDATE_FOR__ELIST_OUTPUTNAMEDEXPRESSION:
				return updateFor((EList<AssignedSource>)arguments.get(0), (OutputNamedExpression)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_INPUT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return tupleInputDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_OUTPUT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return tupleOutputDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_NULL_INPUTS__DIAGNOSTICCHAIN_MAP:
				return tupleNullInputs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_OUTPUTS__DIAGNOSTICCHAIN_MAP:
				return tupleOutputs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return tupleAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TUPLE___TUPLE_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return tupleAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // TupleImpl
