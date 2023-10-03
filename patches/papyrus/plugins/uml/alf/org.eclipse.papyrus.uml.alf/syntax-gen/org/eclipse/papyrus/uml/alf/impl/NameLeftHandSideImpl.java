/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.math.BigInteger;
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
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.LeftHandSide;
import org.eclipse.papyrus.uml.alf.NameLeftHandSide;
import org.eclipse.papyrus.uml.alf.QualifiedName;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NameLeftHandSideImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NameLeftHandSideImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameLeftHandSideImpl extends LeftHandSideImpl implements NameLeftHandSide {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameLeftHandSideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNameLeftHandSide();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTarget() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getNameLeftHandSide_Target(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(QualifiedName newTarget) {
		eSet(AlfPackage.eINSTANCE.getNameLeftHandSide_Target(), newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIndex() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getNameLeftHandSide_Index(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(Expression newIndex) {
		eSet(AlfPackage.eINSTANCE.getNameLeftHandSide_Index(), newIndex);
	}

	/**
	 * The cached invocation delegate for the '{@link #target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #target()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TARGET__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Target()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate INDEX__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Index()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Referent()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #parameterReferent() <em>Parameter Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterReferent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__ParameterReferent()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference parameterReferent() {
		try {
			return (ElementReference)PARAMETER_REFERENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Type()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Upper()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Lower()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #oldAssignment() <em>Old Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #oldAssignment()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OLD_ASSIGNMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__OldAssignment()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource oldAssignment() {
		try {
			return (AssignedSource)OLD_ASSIGNMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Feature()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #expression() <em>Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #expression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Expression()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #primary() <em>Primary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #primary()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PRIMARY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__Primary()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #localName() <em>Local Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOCAL_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNameLeftHandSide__LocalName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String localName() {
		try {
			return (String)LOCAL_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean nameLeftHandSideAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nameLeftHandSideAssignmentAfterDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #nameLeftHandSideTargetAssignment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Left Hand Side Target Assignment</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nameLeftHandSideTargetAssignment(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LEFT_HAND_SIDE_TARGET_ASSIGNMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let referent = self.referent in\n" +
		"          if referent = null then true\n" +
		"          else if referent.isParameter() then\n" +
		"            referent.direction() <> 'in'\n" +
		"          else if referent.isProperty() then\n" +
		"            let expression = self.feature().expression in\n" +
		"              -- This condition ensures that there will be an assigned name\n" +
		"              -- for an assignment to an attribute of a data type.\n" +
		"              expression.type.isDataType() implies self.isDataValueUpdate()\n" +
		"          else\n" +
		"            not (referent.isLoopVariable() or\n" +
		"                 referent.isAnnotation() or\n" +
		"                 referent.isSequenceExpansionExpression()\n" +
		"            )\n" +
		"          endif endif endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideTargetAssignment(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNameLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNameLeftHandSide__NameLeftHandSideTargetAssignment__DiagnosticChain_Map(),
				 NAME_LEFT_HAND_SIDE_TARGET_ASSIGNMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TARGET_ASSIGNMENT);
	}

	/**
	 * The cached validation expression for the '{@link #nameLeftHandSideAssignmentsBefore(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Left Hand Side Assignments Before</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nameLeftHandSideAssignmentsBefore(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.index <> null implies \n" +
		"          (self.feature() <> null or self.oldAssignment() <> null)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNameLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNameLeftHandSide__NameLeftHandSideAssignmentsBefore__DiagnosticChain_Map(),
				 NAME_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nameLeftHandSideReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean nameLeftHandSideLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nameLeftHandSideLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean nameLeftHandSideUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nameLeftHandSideUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean nameLeftHandSideTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nameLeftHandSideTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #nameLeftHandSideTargetResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Left Hand Side Target Resolution</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nameLeftHandSideTargetResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LEFT_HAND_SIDE_TARGET_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.target().qualification <> null implies\n" +
		"        let referent = self.referent in\n" +
		"          referent <> null and referent.isParameter() or\n" +
		"          let feature = self.feature() in\n" +
		"            feature <> null and \n" +
		"              -- TODO: This should be a separate constraint.\n" +
		"              feature.expression.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideTargetResolution(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNameLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNameLeftHandSide__NameLeftHandSideTargetResolution__DiagnosticChain_Map(),
				 NAME_LEFT_HAND_SIDE_TARGET_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_TARGET_RESOLUTION);
	}

	/**
	 * The cached validation expression for the '{@link #nameLeftHandSideIndexedFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Left Hand Side Indexed Feature</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nameLeftHandSideIndexedFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LEFT_HAND_SIDE_INDEXED_FEATURE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.index() <> null implies\n" +
		"          let referent = self.referent in\n" +
		"            referent <> null and referent.isFeature() implies\n" +
		"              referent.isOrdered() and referent.isNonunique()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideIndexedFeature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNameLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNameLeftHandSide__NameLeftHandSideIndexedFeature__DiagnosticChain_Map(),
				 NAME_LEFT_HAND_SIDE_INDEXED_FEATURE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_INDEXED_FEATURE);
	}

	/**
	 * The cached validation expression for the '{@link #nameLeftHandSideNontemplateTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Name Left Hand Side Nontemplate Target</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nameLeftHandSideNontemplateTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LEFT_HAND_SIDE_NONTEMPLATE_TARGET_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.target.templateName = null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameLeftHandSideNontemplateTarget(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNameLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNameLeftHandSide__NameLeftHandSideNontemplateTarget__DiagnosticChain_Map(),
				 NAME_LEFT_HAND_SIDE_NONTEMPLATE_TARGET_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAME_LEFT_HAND_SIDE__NAME_LEFT_HAND_SIDE_NONTEMPLATE_TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.NAME_LEFT_HAND_SIDE___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.NAME_LEFT_HAND_SIDE___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.NAME_LEFT_HAND_SIDE___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == LeftHandSide.class) {
			switch (baseOperationID) {
				case AlfPackage.LEFT_HAND_SIDE___TYPE: return AlfPackage.NAME_LEFT_HAND_SIDE___TYPE;
				case AlfPackage.LEFT_HAND_SIDE___UPPER: return AlfPackage.NAME_LEFT_HAND_SIDE___UPPER;
				case AlfPackage.LEFT_HAND_SIDE___LOWER: return AlfPackage.NAME_LEFT_HAND_SIDE___LOWER;
				case AlfPackage.LEFT_HAND_SIDE___REFERENT: return AlfPackage.NAME_LEFT_HAND_SIDE___REFERENT;
				case AlfPackage.LEFT_HAND_SIDE___LOCAL_NAME: return AlfPackage.NAME_LEFT_HAND_SIDE___LOCAL_NAME;
				case AlfPackage.LEFT_HAND_SIDE___FEATURE: return AlfPackage.NAME_LEFT_HAND_SIDE___FEATURE;
				case AlfPackage.LEFT_HAND_SIDE___EXPRESSION: return AlfPackage.NAME_LEFT_HAND_SIDE___EXPRESSION;
				case AlfPackage.LEFT_HAND_SIDE___INDEX: return AlfPackage.NAME_LEFT_HAND_SIDE___INDEX;
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
			case AlfPackage.NAME_LEFT_HAND_SIDE___TARGET:
				return target();
			case AlfPackage.NAME_LEFT_HAND_SIDE___INDEX:
				return index();
			case AlfPackage.NAME_LEFT_HAND_SIDE___REFERENT:
				return referent();
			case AlfPackage.NAME_LEFT_HAND_SIDE___PARAMETER_REFERENT:
				return parameterReferent();
			case AlfPackage.NAME_LEFT_HAND_SIDE___TYPE:
				return type();
			case AlfPackage.NAME_LEFT_HAND_SIDE___UPPER:
				return upper();
			case AlfPackage.NAME_LEFT_HAND_SIDE___LOWER:
				return lower();
			case AlfPackage.NAME_LEFT_HAND_SIDE___OLD_ASSIGNMENT:
				return oldAssignment();
			case AlfPackage.NAME_LEFT_HAND_SIDE___FEATURE:
				return feature();
			case AlfPackage.NAME_LEFT_HAND_SIDE___EXPRESSION:
				return expression();
			case AlfPackage.NAME_LEFT_HAND_SIDE___PRIMARY:
				return primary();
			case AlfPackage.NAME_LEFT_HAND_SIDE___LOCAL_NAME:
				return localName();
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideAssignmentAfterDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_TARGET_ASSIGNMENT__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideTargetAssignment((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_TARGET_RESOLUTION__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideTargetResolution((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_INDEXED_FEATURE__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideIndexedFeature((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAME_LEFT_HAND_SIDE___NAME_LEFT_HAND_SIDE_NONTEMPLATE_TARGET__DIAGNOSTICCHAIN_MAP:
				return nameLeftHandSideNontemplateTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // NameLeftHandSideImpl
