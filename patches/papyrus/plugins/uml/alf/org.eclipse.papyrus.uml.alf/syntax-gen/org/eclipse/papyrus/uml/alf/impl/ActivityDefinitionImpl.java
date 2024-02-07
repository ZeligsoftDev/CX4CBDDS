/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.ActivityDefinition;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.papyrus.uml.alf.ClassifierDefinition;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ActivityDefinitionImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityDefinitionImpl extends ClassifierDefinitionImpl implements ActivityDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getActivityDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBody() {
		return (Block)eGet(AlfPackage.eINSTANCE.getActivityDefinition_Body(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Block newBody) {
		eSet(AlfPackage.eINSTANCE.getActivityDefinition_Body(), newBody);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActivityDefinition__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #outerScope() <em>Outer Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outerScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTER_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActivityDefinition__OuterScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference outerScope() {
		try {
			return (ElementReference)OUTER_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActivityDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		try {
			return (Boolean)ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Match For Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActivityDefinition__MatchForStub__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matchForStub(UnitDefinition unit) {
		try {
			return (Boolean)MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{unit}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Same Kind As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActivityDefinition__IsSameKindAs__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSameKindAs(ElementReference member) {
		try {
			return (Boolean)IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{member}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #activityDefinitionSpecialization(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Activity Definition Specialization</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #activityDefinitionSpecialization(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVITY_DEFINITION_SPECIALIZATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.specialization = null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean activityDefinitionSpecialization(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getActivityDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getActivityDefinition__ActivityDefinitionSpecialization__DiagnosticChain_Map(),
				 ACTIVITY_DEFINITION_SPECIALIZATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACTIVITY_DEFINITION__ACTIVITY_DEFINITION_SPECIALIZATION);
	}

	/**
	 * The cached validation expression for the '{@link #activityDefinitionPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Activity Definition Primitive</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #activityDefinitionPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVITY_DEFINITION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.isPrimitive implies self.body = null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean activityDefinitionPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getActivityDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getActivityDefinition__ActivityDefinitionPrimitive__DiagnosticChain_Map(),
				 ACTIVITY_DEFINITION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACTIVITY_DEFINITION__ACTIVITY_DEFINITION_PRIMITIVE);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.ACTIVITY_DEFINITION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == MemberDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.MEMBER_DEFINITION___OUTER_SCOPE: return AlfPackage.ACTIVITY_DEFINITION___OUTER_SCOPE;
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.ACTIVITY_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.ACTIVITY_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				case AlfPackage.MEMBER_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.ACTIVITY_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NamespaceDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.NAMESPACE_DEFINITION___OUTER_SCOPE: return AlfPackage.ACTIVITY_DEFINITION___OUTER_SCOPE;
				case AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.ACTIVITY_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ClassifierDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.CLASSIFIER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.ACTIVITY_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
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
			case AlfPackage.ACTIVITY_DEFINITION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.ACTIVITY_DEFINITION___OUTER_SCOPE:
				return outerScope();
			case AlfPackage.ACTIVITY_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.ACTIVITY_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION:
				return matchForStub((UnitDefinition)arguments.get(0));
			case AlfPackage.ACTIVITY_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.ACTIVITY_DEFINITION___ACTIVITY_DEFINITION_SPECIALIZATION__DIAGNOSTICCHAIN_MAP:
				return activityDefinitionSpecialization((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ACTIVITY_DEFINITION___ACTIVITY_DEFINITION_PRIMITIVE__DIAGNOSTICCHAIN_MAP:
				return activityDefinitionPrimitive((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ActivityDefinitionImpl
