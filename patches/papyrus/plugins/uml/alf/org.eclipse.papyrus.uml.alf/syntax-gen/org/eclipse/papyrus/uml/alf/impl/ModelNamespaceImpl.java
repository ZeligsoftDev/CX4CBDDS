/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfFactory;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.ExternalElementReference;
import org.eclipse.papyrus.uml.alf.ImportedMember;
import org.eclipse.papyrus.uml.alf.InternalElementReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.Model;
import org.eclipse.papyrus.uml.alf.ModelNamespace;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.PackageDefinition;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ModelNamespaceImpl extends PackageDefinitionImpl implements ModelNamespace {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelNamespaceImpl() {
		super();
	}

	static protected Member asMember(ElementReference reference) {
		ImportedMember importedMember = AlfFactory.eINSTANCE.createImportedMember();
		importedMember.setName(reference.name());
		importedMember.setReferent(reference);
		Member member = AlfFactory.eINSTANCE.createMember();
		member.setVisibility("public");
		member.setDefinition(importedMember);
		return member;
	}

	private Namespace contextNamespace = null;

	private String modelUnitName = null;
	private NamespaceDefinition modelUnitNamespace = null;
	private Member modelUnitMember = null;

	public void setContextNamespace(Namespace namespace) {
		this.contextNamespace = namespace;
		if (namespace == null || namespace.getName() == null) {
			this.setName(null);
		} else {
			this.setName("'" + namespace.getName().replace("\\", "\\\\").replace("'", "\\'") + "'");
		}
	}

	public Namespace getContextNamespace() {
		if (this.contextNamespace == null) {
			this.setContextNamespace(new Model());
		}
		return this.contextNamespace;
	}

	public void setModelUnit(NamespaceDefinition namespace) {
		if (namespace != this.modelUnitNamespace) {
			this.modelUnitNamespace = namespace;
			this.modelUnitName = namespace.getName();
			final InternalElementReference reference = AlfFactory.eINSTANCE.createInternalElementReference();
			reference.setElement(namespace);
			this.modelUnitMember = asMember(reference);
			this.getOwnedMember().clear();
		}
	}

	public Member addOwnedMember(MemberDefinition definition) {
		final EList<Member> ownedMembers = this.getOwnedMember();

		final String name = definition.getName();
		for (Member member : ownedMembers) {
			if (member.getDefinition().getName().equals(name)) {
				return member;
			}
		}

		final Member member = AlfFactory.eINSTANCE.createMember();
		member.setDefinition(definition);
		ownedMembers.add(member);
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getModelNamespace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ElementReference context() {
		ExternalElementReference reference = AlfFactory.eINSTANCE.createExternalElementReference();
		reference.setElement(this.getContextNamespace());
		return reference;
	}

	/**
	 * The cached invocation delegate for the '{@link #outerScope() <em>Outer Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outerScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate OUTER_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__OuterScope()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #modelScope() <em>Model Scope</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #modelScope()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MODEL_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__ModelScope()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #qualifiedName() <em>Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate QUALIFIED_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__QualifiedName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName qualifiedName() {
		try {
			return (QualifiedName)QUALIFIED_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_IN_SCOPE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__ResolveInScope__String()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Member> resolveInRoot(String name) {
		EList<Member> members = new BasicEList<Member>();
		if (name != null && name.equals(this.modelUnitName)) {
			members.add(this.modelUnitMember);
		} else {
			// NOTE: Use Alf name resolution implementation, because the Papyrus implementation
			// doesn't handle name hiding correctly.
			ExternalElementReference namespace = AlfFactory.eINSTANCE.createExternalElementReference();
			namespace.setElement(this.getContextNamespace());
	        for (ElementReference reference : namespace.resolve(name)) {
	        	members.add(asMember(reference));
	        }
//			for (ElementReference reference : this.resolvePathName(name)) {
//				members.add(asMember(reference));
//			}
		}
		return members;
	}

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
	 * 
	 * @generated NOT
	 */
	public EList<ElementReference> ModelNamespace_appliedProfiles() {
		EList<ElementReference> profiles = new BasicEList<ElementReference>();
		org.eclipse.uml2.uml.Package nearestPackage = this.getContextNamespace().getNearestPackage();
		if (nearestPackage != null) {
			for (org.eclipse.uml2.uml.Profile appliedProfile : nearestPackage.getAllAppliedProfiles()) {
				ExternalElementReference reference =
						AlfFactory.eINSTANCE.createExternalElementReference();
				reference.setElement(appliedProfile);
				profiles.add(reference);
			}
		}
		return profiles;
	}

	/**
	 * @generated NOT
	 */
	public EList<ElementReference> resolvePathName(final String pathName) {
		return resolvePathName(pathName, this.getContextNamespace().getModel());
	}

	public static EList<ElementReference> resolvePathName(
			final String pathName, final Namespace context) {
		final EList<ElementReference> references = new BasicEList<ElementReference>();
		final Collection<org.eclipse.uml2.uml.NamedElement> elements =
				NameResolutionUtils.getNamedElements(
						pathName, context,
						UMLPackage.Literals.NAMED_ELEMENT);
		for (org.eclipse.uml2.uml.NamedElement element : elements) {
			final ExternalElementReference reference = AlfFactory.eINSTANCE.createExternalElementReference();
			reference.setElement(element);
			references.add(reference);
		}
		return references;
	}

	/**
	 * The cached invocation delegate for the '{@link #resolveAssociationEnd(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String) <em>Resolve Association End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolveAssociationEnd(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_ASSOCIATION_END_ELEMENT_REFERENCE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__ResolveAssociationEnd__ElementReference_String()).getInvocationDelegate();

	/**
	 * The cached invocation delegate for the '{@link #appliedProfiles() <em>Applied Profiles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #appliedProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__AppliedProfiles()).getInvocationDelegate();

	/**
	 * The cached invocation delegate for the '{@link #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Stub For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stubFor(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STUB_FOR_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getModelNamespace__StubFor__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> resolveAssociationEnd(ElementReference oppositeEndType, String name) {
		try {
			return (EList<ElementReference>)RESOLVE_ASSOCIATION_END_ELEMENT_REFERENCE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{oppositeEndType, name}));
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
		if (baseClass == MemberDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.MEMBER_DEFINITION___OUTER_SCOPE: return AlfPackage.MODEL_NAMESPACE___OUTER_SCOPE;
				case AlfPackage.MEMBER_DEFINITION___QUALIFIED_NAME: return AlfPackage.MODEL_NAMESPACE___QUALIFIED_NAME;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NamespaceDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.NAMESPACE_DEFINITION___OUTER_SCOPE: return AlfPackage.MODEL_NAMESPACE___OUTER_SCOPE;
				case AlfPackage.NAMESPACE_DEFINITION___MODEL_SCOPE: return AlfPackage.MODEL_NAMESPACE___MODEL_SCOPE;
				case AlfPackage.NAMESPACE_DEFINITION___RESOLVE_IN_SCOPE__STRING: return AlfPackage.MODEL_NAMESPACE___RESOLVE_IN_SCOPE__STRING;
				case AlfPackage.NAMESPACE_DEFINITION___APPLIED_PROFILES: return AlfPackage.MODEL_NAMESPACE___APPLIED_PROFILES;
				case AlfPackage.NAMESPACE_DEFINITION___STUB_FOR__UNITDEFINITION: return AlfPackage.MODEL_NAMESPACE___STUB_FOR__UNITDEFINITION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == PackageDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.PACKAGE_DEFINITION___APPLIED_PROFILES: return AlfPackage.MODEL_NAMESPACE___APPLIED_PROFILES;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.MODEL_NAMESPACE___CONTEXT:
				return context();
			case AlfPackage.MODEL_NAMESPACE___OUTER_SCOPE:
				return outerScope();
			case AlfPackage.MODEL_NAMESPACE___MODEL_SCOPE:
				return modelScope();
			case AlfPackage.MODEL_NAMESPACE___QUALIFIED_NAME:
				return qualifiedName();
			case AlfPackage.MODEL_NAMESPACE___RESOLVE_IN_SCOPE__STRING:
				return resolveInScope((String)arguments.get(0));
			case AlfPackage.MODEL_NAMESPACE___RESOLVE_IN_ROOT__STRING:
				return resolveInRoot((String)arguments.get(0));
			case AlfPackage.MODEL_NAMESPACE___RESOLVE_PATH_NAME__STRING:
				return resolvePathName((String)arguments.get(0));
			case AlfPackage.MODEL_NAMESPACE___RESOLVE_ASSOCIATION_END__ELEMENTREFERENCE_STRING:
				return resolveAssociationEnd((ElementReference)arguments.get(0), (String)arguments.get(1));
			case AlfPackage.MODEL_NAMESPACE___APPLIED_PROFILES:
				return appliedProfiles();
			case AlfPackage.MODEL_NAMESPACE___STUB_FOR__UNITDEFINITION:
				return stubFor((UnitDefinition)arguments.get(0));
			case AlfPackage.MODEL_NAMESPACE___MODEL_NAMESPACE_APPLIED_PROFILES:
				return ModelNamespace_appliedProfiles();
		}
		return super.eInvoke(operationID, arguments);
	}

} // ModelNamespaceImpl
