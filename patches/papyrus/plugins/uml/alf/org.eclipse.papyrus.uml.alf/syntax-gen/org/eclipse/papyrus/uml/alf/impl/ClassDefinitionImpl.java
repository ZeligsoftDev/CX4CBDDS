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
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ClassDefinition;
import org.eclipse.papyrus.uml.alf.ClassifierDefinition;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ClassDefinitionImpl extends ClassifierDefinitionImpl implements ClassDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getClassDefinition();
	}

	/**
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__MatchForStub__UnitDefinition()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__IsSameKindAs__ElementReference()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #needsDefaultConstructor() <em>Needs Default Constructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #needsDefaultConstructor()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NEEDS_DEFAULT_CONSTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__NeedsDefaultConstructor()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean needsDefaultConstructor() {
		try {
			return (Boolean)NEEDS_DEFAULT_CONSTRUCTOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #needsDefaultDestructor() <em>Needs Default Destructor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #needsDefaultDestructor()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NEEDS_DEFAULT_DESTRUCTOR__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__NeedsDefaultDestructor()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean needsDefaultDestructor() {
		try {
			return (Boolean)NEEDS_DEFAULT_DESTRUCTOR__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #inherit(org.eclipse.emf.common.util.EList) <em>Inherit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inherit(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INHERIT_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__Inherit__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> inherit(EList<Member> inheritableMembers) {
		try {
			return (EList<Member>)INHERIT_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{inheritableMembers}));
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
	public EList<Member> inheritCached(EList<Member> inheritableMembers) {
		BasicEList<Member> members = new BasicEList<Member>(this.NamespaceDefinition_members());
		members.addAllUnique(inheritableMembers);
		this.members = members;
		return this.ClassDefinition_inherit(inheritableMembers);
	}

	/**
	 * The cached invocation delegate for the '{@link #ClassDefinition_inherit(org.eclipse.emf.common.util.EList) <em>Class Definition inherit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ClassDefinition_inherit(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CLASS_DEFINITION_INHERIT_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassDefinition__ClassDefinition_inherit__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> ClassDefinition_inherit(EList<Member> inheritableMembers) {
		try {
			return (EList<Member>)CLASS_DEFINITION_INHERIT_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{inheritableMembers}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #classDefinitionSpecializationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Class Definition Specialization Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classDefinitionSpecializationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_DEFINITION_SPECIALIZATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.specializationReferent->forAll(isClass()) and\n" +
		"                      (self.specializationReferent->exists(isActiveClass())\n" +
		"                        implies self.oclIsKindOf(ActiveClassDefinition)\n" +
		"                      )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassDefinition__ClassDefinitionSpecializationReferent__DiagnosticChain_Map(),
				 CLASS_DEFINITION_SPECIALIZATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASS_DEFINITION__CLASS_DEFINITION_SPECIALIZATION_REFERENT);
	}

	/**
	 * The cached validation expression for the '{@link #classDefinitionAbstractMember(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Class Definition Abstract Member</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classDefinitionAbstractMember(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_DEFINITION_ABSTRACT_MEMBER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      if self.isAbstract then true\n" +
		"                      else \n" +
		"                        self.member.definition->select(oclIsKindOf(OperationDefinition)).\n" +
		"                          oclAsType(OperationDefinition)->forAll(not isAbstract)\n" +
		"                      endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classDefinitionAbstractMember(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassDefinition__ClassDefinitionAbstractMember__DiagnosticChain_Map(),
				 CLASS_DEFINITION_ABSTRACT_MEMBER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASS_DEFINITION__CLASS_DEFINITION_ABSTRACT_MEMBER);
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
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.CLASS_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				case AlfPackage.MEMBER_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.CLASS_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NamespaceDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.CLASS_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ClassifierDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.CLASSIFIER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				case AlfPackage.CLASSIFIER_DEFINITION___INHERIT__ELIST: return AlfPackage.CLASS_DEFINITION___INHERIT__ELIST;
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
			case AlfPackage.CLASS_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION:
				return matchForStub((UnitDefinition)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___NEEDS_DEFAULT_CONSTRUCTOR:
				return needsDefaultConstructor();
			case AlfPackage.CLASS_DEFINITION___NEEDS_DEFAULT_DESTRUCTOR:
				return needsDefaultDestructor();
			case AlfPackage.CLASS_DEFINITION___INHERIT__ELIST:
				return inherit((EList<Member>)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___INHERIT_CACHED__ELIST:
				return inheritCached((EList<Member>)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___CLASS_DEFINITION_INHERIT__ELIST:
				return ClassDefinition_inherit((EList<Member>)arguments.get(0));
			case AlfPackage.CLASS_DEFINITION___CLASS_DEFINITION_SPECIALIZATION_REFERENT__DIAGNOSTICCHAIN_MAP:
				return classDefinitionSpecializationReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASS_DEFINITION___CLASS_DEFINITION_ABSTRACT_MEMBER__DIAGNOSTICCHAIN_MAP:
				return classDefinitionAbstractMember((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ClassDefinitionImpl
