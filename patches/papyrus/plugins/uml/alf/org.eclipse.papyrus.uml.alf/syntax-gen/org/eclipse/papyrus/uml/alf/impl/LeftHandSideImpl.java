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
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.LeftHandSide;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LeftHandSideImpl#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LeftHandSideImpl#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LeftHandSideImpl#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LeftHandSideImpl extends AssignableElementImpl implements LeftHandSide {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeftHandSideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getLeftHandSide();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentBefore() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getLeftHandSide_AssignmentBefore(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentAfter() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getLeftHandSide_AssignmentAfter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReferent() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getLeftHandSide_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(ElementReference newReferent) {
		eSet(AlfPackage.eINSTANCE.getLeftHandSide_Referent(), newReferent);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__AssignmentsAfter()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__Type()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #LeftHandSide_type() <em>Left Hand Side type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LeftHandSide_type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LEFT_HAND_SIDE_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__LeftHandSide_type()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference LeftHandSide_type() {
		try {
			return (ElementReference)LEFT_HAND_SIDE_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__Upper()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #LeftHandSide_upper() <em>Left Hand Side upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LeftHandSide_upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LEFT_HAND_SIDE_UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__LeftHandSide_upper()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger LeftHandSide_upper() {
		try {
			return (BigInteger)LEFT_HAND_SIDE_UPPER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__Lower()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #LeftHandSide_lower() <em>Left Hand Side lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LeftHandSide_lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LEFT_HAND_SIDE_LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__LeftHandSide_lower()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger LeftHandSide_lower() {
		try {
			return (BigInteger)LEFT_HAND_SIDE_LOWER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference referent() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #assignedName() <em>Assigned Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignedName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNED_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__AssignedName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String assignedName() {
		try {
			return (String)ASSIGNED_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public String localName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference feature() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression expression() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #isDataValueUpdate() <em>Is Data Value Update</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataValueUpdate()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_DATA_VALUE_UPDATE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLeftHandSide__IsDataValueUpdate()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataValueUpdate() {
		try {
			return (Boolean)IS_DATA_VALUE_UPDATE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #leftHandSideIndexExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Left Hand Side Index Expression</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #leftHandSideIndexExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LEFT_HAND_SIDE_INDEX_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.index() <> null implies self.index().upper <= 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean leftHandSideIndexExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLeftHandSide__LeftHandSideIndexExpression__DiagnosticChain_Map(),
				 LEFT_HAND_SIDE_INDEX_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LEFT_HAND_SIDE__LEFT_HAND_SIDE_INDEX_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression index() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.LEFT_HAND_SIDE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.LEFT_HAND_SIDE___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.LEFT_HAND_SIDE___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.LEFT_HAND_SIDE___UPPER;
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
			case AlfPackage.LEFT_HAND_SIDE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.LEFT_HAND_SIDE___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.LEFT_HAND_SIDE___TYPE:
				return type();
			case AlfPackage.LEFT_HAND_SIDE___LEFT_HAND_SIDE_TYPE:
				return LeftHandSide_type();
			case AlfPackage.LEFT_HAND_SIDE___UPPER:
				return upper();
			case AlfPackage.LEFT_HAND_SIDE___LEFT_HAND_SIDE_UPPER:
				return LeftHandSide_upper();
			case AlfPackage.LEFT_HAND_SIDE___LOWER:
				return lower();
			case AlfPackage.LEFT_HAND_SIDE___LEFT_HAND_SIDE_LOWER:
				return LeftHandSide_lower();
			case AlfPackage.LEFT_HAND_SIDE___REFERENT:
				return referent();
			case AlfPackage.LEFT_HAND_SIDE___ASSIGNED_NAME:
				return assignedName();
			case AlfPackage.LEFT_HAND_SIDE___LOCAL_NAME:
				return localName();
			case AlfPackage.LEFT_HAND_SIDE___FEATURE:
				return feature();
			case AlfPackage.LEFT_HAND_SIDE___EXPRESSION:
				return expression();
			case AlfPackage.LEFT_HAND_SIDE___IS_DATA_VALUE_UPDATE:
				return isDataValueUpdate();
			case AlfPackage.LEFT_HAND_SIDE___LEFT_HAND_SIDE_INDEX_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return leftHandSideIndexExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LEFT_HAND_SIDE___INDEX:
				return index();
		}
		return super.eInvoke(operationID, arguments);
	}

} // LeftHandSideImpl
