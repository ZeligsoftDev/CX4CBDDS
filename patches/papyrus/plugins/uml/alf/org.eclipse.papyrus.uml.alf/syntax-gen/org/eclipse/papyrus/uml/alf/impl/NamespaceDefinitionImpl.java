/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
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
import org.eclipse.papyrus.uml.alf.ClassifierTemplateParameter;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.FormalParameter;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;
import org.eclipse.papyrus.uml.alf.validation.ModelNamespaceFacade;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NamespaceDefinitionImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NamespaceDefinitionImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NamespaceDefinitionImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamespaceDefinitionImpl extends MemberDefinitionImpl implements NamespaceDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected NamespaceDefinitionImpl() {
		super();
		this.registerCaching();
	}

	@Override
	public void clear() {
		super.clear();
		this.members = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNamespaceDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> getOwnedMember() {
		return (EList<Member>)eGet(AlfPackage.eINSTANCE.getNamespaceDefinition_OwnedMember(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitDefinition getUnit() {
		return (UnitDefinition)eGet(AlfPackage.eINSTANCE.getNamespaceDefinition_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(UnitDefinition newUnit) {
		eSet(AlfPackage.eINSTANCE.getNamespaceDefinition_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> getMember() {
		return (EList<Member>)eGet(AlfPackage.eINSTANCE.getNamespaceDefinition_Member(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #currentScope() <em>Current Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #currentScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CURRENT_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__CurrentScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference currentScope() {
		try {
			return (ElementReference)CURRENT_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public NamespaceDefinition modelNamespace() {
		return ModelNamespaceFacade.getInstance().modelNamespaceFor(this);
	}

	/**
	 * The cached invocation delegate for the '{@link #outerScope() <em>Outer Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outerScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTER_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__OuterScope()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #NamespaceDefinition_outerScope() <em>Namespace Definition outer Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NamespaceDefinition_outerScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE_DEFINITION_OUTER_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinition_outerScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference NamespaceDefinition_outerScope() {
		try {
			return (ElementReference)NAMESPACE_DEFINITION_OUTER_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #modelScope() <em>Model Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #modelScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MODEL_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ModelScope()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference modelScope() {
		try {
			return (ElementReference)MODEL_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveInScope(java.lang.String) <em>Resolve In Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveInScope(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ResolveInScope__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> resolveInScope(String name) {
		try {
			return (EList<Member>)RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #appliedProfiles() <em>Applied Profiles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #appliedProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__AppliedProfiles()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> appliedProfiles() {
		try {
			return (EList<ElementReference>)APPLIED_PROFILES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #NamespaceDefinition_appliedProfiles() <em>Namespace Definition applied Profiles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NamespaceDefinition_appliedProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE_DEFINITION_APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinition_appliedProfiles()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> NamespaceDefinition_appliedProfiles() {
		try {
			return (EList<ElementReference>)NAMESPACE_DEFINITION_APPLIED_PROFILES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #parameters() <em>Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameters()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__Parameters()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FormalParameter> parameters() {
		try {
			return (EList<FormalParameter>)PARAMETERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #returnParameter() <em>Return Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #returnParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RETURN_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ReturnParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter returnParameter() {
		try {
			return (FormalParameter)RETURN_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #NamespaceDefinition_returnParameter() <em>Namespace Definition return Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NamespaceDefinition_returnParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE_DEFINITION_RETURN_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinition_returnParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter NamespaceDefinition_returnParameter() {
		try {
			return (FormalParameter)NAMESPACE_DEFINITION_RETURN_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #subunitOwnedMembers() <em>Subunit Owned Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #subunitOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate SUBUNIT_OWNED_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__SubunitOwnedMembers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> subunitOwnedMembers() {
		try {
			return (EList<Member>)SUBUNIT_OWNED_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #NamespaceDefinition_annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Namespace Definition annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NamespaceDefinition_annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE_DEFINITION_ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinition_annotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NamespaceDefinition_annotationAllowed(StereotypeAnnotation annotation) {
		try {
			return (Boolean)NAMESPACE_DEFINITION_ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #templateParameters() <em>Template Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #templateParameters()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TEMPLATE_PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__TemplateParameters()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassifierTemplateParameter> templateParameters() {
		try {
			return (EList<ClassifierTemplateParameter>)TEMPLATE_PARAMETERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	protected EList<Member> members = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Member> membersCached() {
		if (this.members == null) {
			this.members = this.members();
		}
		return this.members;
	}

	/**
	 * The cached invocation delegate for the '{@link #members() <em>Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #members()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__Members()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> members() {
		try {
			return (EList<Member>)MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #NamespaceDefinition_members() <em>Namespace Definition members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NamespaceDefinition_members()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NAMESPACE_DEFINITION_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinition_members()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> NamespaceDefinition_members() {
		try {
			return (EList<Member>)NAMESPACE_DEFINITION_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #importedMembers() <em>Imported Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #importedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPORTED_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ImportedMembers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> importedMembers() {
		try {
			return (EList<Member>)IMPORTED_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #importMembers(org.eclipse.emf.common.util.EList) <em>Import Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #importMembers(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPORT_MEMBERS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ImportMembers__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> importMembers(EList<Member> importedMembers) {
		try {
			return (EList<Member>)IMPORT_MEMBERS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{importedMembers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #excludeCollisions(org.eclipse.emf.common.util.EList) <em>Exclude Collisions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #excludeCollisions(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EXCLUDE_COLLISIONS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__ExcludeCollisions__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> excludeCollisions(EList<Member> importedMembers) {
		try {
			return (EList<Member>)EXCLUDE_COLLISIONS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{importedMembers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #removeDuplicates(org.eclipse.emf.common.util.EList) <em>Remove Duplicates</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #removeDuplicates(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REMOVE_DUPLICATES_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__RemoveDuplicates__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> removeDuplicates(EList<Member> importedMembers) {
		try {
			return (EList<Member>)REMOVE_DUPLICATES_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{importedMembers}));
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
	public EList<Member> includeDistinguishableCaching(EList<Member> importedMembers) {
		this.members = new BasicEList<Member>(this.getOwnedMember());
		this.members.addAll(importedMembers);
		return this.includeDistinguishable(importedMembers);
	}

	/**
	 * The cached invocation delegate for the '{@link #includeDistinguishable(org.eclipse.emf.common.util.EList) <em>Include Distinguishable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #includeDistinguishable(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INCLUDE_DISTINGUISHABLE_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__IncludeDistinguishable__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> includeDistinguishable(EList<Member> importedMembers) {
		try {
			return (EList<Member>)INCLUDE_DISTINGUISHABLE_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{importedMembers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #stub() <em>Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stub()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STUB__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__Stub()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stub() {
		try {
			return (ElementReference)STUB__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Stub For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNamespaceDefinition__StubFor__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference stubFor(UnitDefinition unit) {
		try {
			return (ElementReference)STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{unit}));
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
	public boolean namespaceDefinitionMemberDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NAMESPACE_DEFINITION__NAMESPACE_DEFINITION_MEMBER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "namespaceDefinitionMemberDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #namespaceDefinitionMemberDistinguishability(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Namespace Definition Member Distinguishability</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #namespaceDefinitionMemberDistinguishability(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_DEFINITION_MEMBER_DISTINGUISHABILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"          self.member->forAll(m1 | \n" +
		"            self.member->forAll(m2 | \n" +
		"              m1 = m2 or m1.definition.isDistinguishableFrom(m2.definition)\n" +
		"            )\n" +
		"          )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean namespaceDefinitionMemberDistinguishability(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNamespaceDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNamespaceDefinition__NamespaceDefinitionMemberDistinguishability__DiagnosticChain_Map(),
				 NAMESPACE_DEFINITION_MEMBER_DISTINGUISHABILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NAMESPACE_DEFINITION__NAMESPACE_DEFINITION_MEMBER_DISTINGUISHABILITY);
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
				case AlfPackage.SYNTAX_ELEMENT___CURRENT_SCOPE: return AlfPackage.NAMESPACE_DEFINITION___CURRENT_SCOPE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == MemberDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.MEMBER_DEFINITION___OUTER_SCOPE: return AlfPackage.NAMESPACE_DEFINITION___OUTER_SCOPE;
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___TEMPLATE_PARAMETERS: return AlfPackage.NAMESPACE_DEFINITION___TEMPLATE_PARAMETERS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		if (operationID == AlfPackage.NAMESPACE_DEFINITION___INCLUDE_DISTINGUISHABLE_CACHING__ELIST &&
				!(arguments.get(0) instanceof EList<?>)) {
			return this.includeDistinguishableCaching(new BasicEList<Member>((Collection<? extends Member>) arguments.get(0)));
		} else {
			return this.eInvokeGen(operationID, arguments);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Object eInvokeGen(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.NAMESPACE_DEFINITION___CURRENT_SCOPE:
				return currentScope();
			case AlfPackage.NAMESPACE_DEFINITION___OUTER_SCOPE:
				return outerScope();
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_OUTER_SCOPE:
				return NamespaceDefinition_outerScope();
			case AlfPackage.NAMESPACE_DEFINITION___MODEL_NAMESPACE:
				return modelNamespace();
			case AlfPackage.NAMESPACE_DEFINITION___MODEL_SCOPE:
				return modelScope();
			case AlfPackage.NAMESPACE_DEFINITION___RESOLVE_IN_SCOPE__STRING:
				return resolveInScope((String)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___APPLIED_PROFILES:
				return appliedProfiles();
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_APPLIED_PROFILES:
				return NamespaceDefinition_appliedProfiles();
			case AlfPackage.NAMESPACE_DEFINITION___PARAMETERS:
				return parameters();
			case AlfPackage.NAMESPACE_DEFINITION___RETURN_PARAMETER:
				return returnParameter();
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_RETURN_PARAMETER:
				return NamespaceDefinition_returnParameter();
			case AlfPackage.NAMESPACE_DEFINITION___SUBUNIT_OWNED_MEMBERS:
				return subunitOwnedMembers();
			case AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return NamespaceDefinition_annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___TEMPLATE_PARAMETERS:
				return templateParameters();
			case AlfPackage.NAMESPACE_DEFINITION___MEMBERS_CACHED:
				return membersCached();
			case AlfPackage.NAMESPACE_DEFINITION___MEMBERS:
				return members();
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_MEMBERS:
				return NamespaceDefinition_members();
			case AlfPackage.NAMESPACE_DEFINITION___IMPORTED_MEMBERS:
				return importedMembers();
			case AlfPackage.NAMESPACE_DEFINITION___IMPORT_MEMBERS__ELIST:
				return importMembers((EList<Member>)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___EXCLUDE_COLLISIONS__ELIST:
				return excludeCollisions((EList<Member>)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___REMOVE_DUPLICATES__ELIST:
				return removeDuplicates((EList<Member>)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___INCLUDE_DISTINGUISHABLE_CACHING__ELIST:
				return includeDistinguishableCaching((EList<Member>)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___INCLUDE_DISTINGUISHABLE__ELIST:
				return includeDistinguishable((EList<Member>)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___STUB:
				return stub();
			case AlfPackage.NAMESPACE_DEFINITION___STUB_FOR__UNITDEFINITION:
				return stubFor((UnitDefinition)arguments.get(0));
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_MEMBER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return namespaceDefinitionMemberDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NAMESPACE_DEFINITION___NAMESPACE_DEFINITION_MEMBER_DISTINGUISHABILITY__DIAGNOSTICCHAIN_MAP:
				return namespaceDefinitionMemberDistinguishability((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // NamespaceDefinitionImpl
