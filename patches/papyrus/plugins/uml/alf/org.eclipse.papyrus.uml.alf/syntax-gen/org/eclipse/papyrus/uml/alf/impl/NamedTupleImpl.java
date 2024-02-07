/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.InputNamedExpression;
import org.eclipse.papyrus.uml.alf.NamedExpression;
import org.eclipse.papyrus.uml.alf.NamedTuple;
import org.eclipse.papyrus.uml.alf.OutputNamedExpression;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NamedTupleImpl#getNamedExpression <em>Named Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedTupleImpl extends TupleImpl implements NamedTuple {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedTupleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNamedTuple();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedExpression> getNamedExpression() {
		return (EList<NamedExpression>)eGet(AlfPackage.eINSTANCE.getNamedTuple_NamedExpression(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #size() <em>Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #size()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SIZE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTuple__Size()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger size() {
		try {
			return (BigInteger)SIZE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #inputFor(org.eclipse.emf.common.util.EList) <em>Input For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inputFor(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INPUT_FOR_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTuple__InputFor__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InputNamedExpression> inputFor(EList<ElementReference> parameters) {
		try {
			return (EList<InputNamedExpression>)INPUT_FOR_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{parameters}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #outputFor(org.eclipse.emf.common.util.EList) <em>Output For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outputFor(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTPUT_FOR_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTuple__OutputFor__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<OutputNamedExpression> outputFor(EList<ElementReference> parameters) {
		try {
			return (EList<OutputNamedExpression>)OUTPUT_FOR_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{parameters}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #outputForExpression(org.eclipse.papyrus.uml.alf.Expression) <em>Output For Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outputForExpression(org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTPUT_FOR_EXPRESSION_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamedTuple__OutputForExpression__Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputNamedExpression outputForExpression(Expression expression) {
		try {
			return (OutputNamedExpression)OUTPUT_FOR_EXPRESSION_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{expression}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #namedTupleArgumentNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Named Tuple Argument Names</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #namedTupleArgumentNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAMED_TUPLE_ARGUMENT_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let names = self.invocation.parameter.name() in\n" +
		"          self.namedExpression->forAll(names->includes(actualName())) and\n" +
		"          self.namedExpression->isUnique(actualName())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean namedTupleArgumentNames(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNamedTuple(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNamedTuple__NamedTupleArgumentNames__DiagnosticChain_Map(),
				 NAMED_TUPLE_ARGUMENT_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAMED_TUPLE__NAMED_TUPLE_ARGUMENT_NAMES);
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
			case AlfPackage.NAMED_TUPLE___SIZE:
				return size();
			case AlfPackage.NAMED_TUPLE___INPUT_FOR__ELIST:
				return inputFor((EList<ElementReference>)arguments.get(0));
			case AlfPackage.NAMED_TUPLE___OUTPUT_FOR__ELIST:
				return outputFor((EList<ElementReference>)arguments.get(0));
			case AlfPackage.NAMED_TUPLE___OUTPUT_FOR_EXPRESSION__EXPRESSION:
				return outputForExpression((Expression)arguments.get(0));
			case AlfPackage.NAMED_TUPLE___NAMED_TUPLE_ARGUMENT_NAMES__DIAGNOSTICCHAIN_MAP:
				return namedTupleArgumentNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // NamedTupleImpl
