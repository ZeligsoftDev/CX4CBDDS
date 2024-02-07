/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model of the common properties of the definition of a namespace in Alf.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamespaceDefinition()
 * @model
 * @generated
 */
public interface NamespaceDefinition extends MemberDefinition {
	/**
	 * Returns the value of the '<em><b>Owned Member</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.Member}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.Member#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The definitions of owned members of the namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Member</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamespaceDefinition_OwnedMember()
	 * @see org.eclipse.papyrus.uml.alf.Member#getNamespace
	 * @model opposite="namespace" containment="true"
	 * @generated
	 */
	EList<Member> getOwnedMember();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit for which this namespace is a definition, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit</em>' container reference.
	 * @see #setUnit(UnitDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamespaceDefinition_Unit()
	 * @see org.eclipse.papyrus.uml.alf.UnitDefinition#getDefinition
	 * @model opposite="definition" transient="false"
	 * @generated
	 */
	UnitDefinition getUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getUnit <em>Unit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' container reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(UnitDefinition value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.Member}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owned and imported members of a namespace definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamespaceDefinition_Member()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.membersCached()'"
	 * @generated
	 */
	EList<Member> getMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A namespace definition is its own current scope.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.toReference()'"
	 * @generated
	 */
	ElementReference currentScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The outer scope of a namespace definition is either the namespace
	 * definition that owns it as a member or the declared namespace of the
	 * unit that owns it or, if it has neither of these, then model scope.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.NamespaceDefinition_outerScope()'"
	 * @generated
	 */
	ElementReference outerScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let outerScope = self.MemberDefinition_outerScope() in\n          if outerScope <> null then\n            outerScope\n          else if self.unit = null then\n            null\n          else if unit.namespace = null then\n            self.modelNamespace().toReference()\n          else\n            unit.namespace\n          endif endif endif'"
	 * @generated
	 */
	ElementReference NamespaceDefinition_outerScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	NamespaceDefinition modelNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let outerScope = self.outerScope() in\n          if outerScope = null then\n            self.modelNamespace().toReference()\n          else\n            outerScope.modelScope()\n          endif'"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.member->select(m | m.definition.actualName() = name)->asSet()'"
	 * @generated
	 */
	EList<Member> resolveInScope(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.NamespaceDefinition_appliedProfiles()'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let outerScope = self.outerScope() in\n          if outerScope = null then null\n          else outerScope.appliedProfiles()\n          endif'"
	 * @generated
	 */
	EList<ElementReference> NamespaceDefinition_appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns any owned members that are formal parameters, excluding return parameters.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.ownedMember.definition->\n          select(oclIsKindOf(FormalParameter)).oclAsType(FormalParameter)->\n          reject(direction = \'return\')->asOrderedSet()'"
	 * @generated
	 */
	EList<FormalParameter> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns an owned member that is a return parameter, if any.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.NamespaceDefinition_returnParameter()'"
	 * @generated
	 */
	FormalParameter returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let returnParameters = self.ownedMember.definition->\n               select(oclIsKindOf(FormalParameter)).oclAsType(FormalParameter)->\n               select(direction = \'return\') \n            in\n              if returnParameters->isEmpty() then null\n              else returnParameters->any(true)\n              endif'"
	 * @generated
	 */
	FormalParameter NamespaceDefinition_returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let subunit = self.subunit in\n          if subunit = null or subunit.definition = null then self.ownedMember\n          else subunit.definition.ownedMember\n          endif'"
	 * @generated
	 */
	EList<Member> subunitOwnedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the annotation is @external.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NamespaceDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            self.annotation().stereotypeName.pathName = \'external\' or\n\n            /* TODO: Allow real stereotype application. \052/\n            self.annotation().stereotypeName.pathName = \'ModelLibrary\''"
	 * @generated
	 */
	boolean NamespaceDefinition_annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the members of this namespace definition that are template parameters.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            self.ownedMember.definition->select(oclIsKindOf(ClassifierTemplateParameter)).\n              oclAsType(ClassifierTemplateParameter)->asOrderedSet()'"
	 * @generated
	 */
	EList<ClassifierTemplateParameter> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return all the members of this namespace (at least all the owned and imported members).
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<Member> membersCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.NamespaceDefinition_members()'"
	 * @generated
	 */
	EList<Member> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.ownedMember->includingAll(self.importedMembers())->asOrderedSet()'"
	 * @generated
	 */
	EList<Member> NamespaceDefinition_members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the members imported into this namespace.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if self.unit = null then \n              Set(Member){}\n            else \n              self.importMembers(self.unit.imports().importedMembers()->asSet())\n            endif'"
	 * @generated
	 */
	EList<Member> importedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the subset of the given imported members that are actually imported into the namespace.
	 * This excludes hidden ones, i.e., those that have names that conflict with names of owned members,
	 * and also excludes elements that would have the same name when imported.
	 * <!-- end-model-doc -->
	 * @model ordered="false" importedMembersMany="true" importedMembersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            self.includeDistinguishableCaching(self.excludeCollisions(importedMembers))'"
	 * @generated
	 */
	EList<Member> importMembers(EList<Member> importedMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the subset of the given imported members that excludes any that would not be
	 * distinguishable from each other in this namespace.
	 * <!-- end-model-doc -->
	 * @model ordered="false" importedMembersMany="true" importedMembersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let remainingMembers = self.removeDuplicates(importedMembers) in\n              remainingMembers->reject(imp1 | \n                remainingMembers->exists(imp2 | imp1 <> imp2 and \n                  not imp1.definition.isDistinguishableFrom(imp2.definition)\n                )\n              )'"
	 * @generated
	 */
	EList<Member> excludeCollisions(EList<Member> importedMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Remove duplicate imported members that have the same referent
	 * (but leave one of them).
	 * <!-- end-model-doc -->
	 * @model ordered="false" importedMembersMany="true" importedMembersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            importedMembers->iterate(m1; result : Set(Member) = Set(Member){} | \n              if result->exists(m2 | m1.toReference().equals(m2.toReference())) then\n                result\n              else\n                result->including(m1)\n              endif\n            )'"
	 * @generated
	 */
	EList<Member> removeDuplicates(EList<Member> importedMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cache an intermediate value for member before caling includingDistinguishable,
	 * in order to avoid an infinite loop.
	 * <!-- end-model-doc -->
	 * @model ordered="false" importedMembersMany="true" importedMembersOrdered="false"
	 * @generated
	 */
	EList<Member> includeDistinguishableCaching(EList<Member> importedMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the subset of the given imported members that would be distinguishable
	 * from all owned members of this namespace.
	 * <!-- end-model-doc -->
	 * @model ordered="false" importedMembersMany="true" importedMembersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n             importedMembers->select(imp | self.ownedMember->forAll(m | \n               imp.definition.isDistinguishableFrom(m.definition)\n             ))'"
	 * @generated
	 */
	EList<Member> includeDistinguishable(EList<Member> importedMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the stub member the subunit for which has this namespace
	 * definition as its definition, if any. Note that, for an activity
	 * definition, the "stub" may be an external operation or activity.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n         let unit = self.unit in\n           if unit = null then null\n           else\n             let namespace = self.outerScope() in\n               if namespace = null then null\n               else namespace.stubFor(unit)\n               endif\n           endif'"
	 * @generated
	 */
	ElementReference stub();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n         if unit = null or unit.definition = null then null\n         else\n           let members = self.ownedMember.definition->select(m |\n             m.actualName() = unit.definition.actualName() and \n             m.isStub and m.matchForStub(unit)\n           ) in\n             if members->isEmpty() then null\n             else members->any(true).oclAsType(Member).toReference()\n             endif\n         endif'"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The members of a namespace definition include references to all owned members.
	 * Also, if the namespace definition has a unit with imports, then the members
	 * include imported members with referents to all imported elements.
	 * The imported elements and their visibility are determined as given in the
	 * UML Superstructure. The name of an imported member is the name of the
	 * imported element or its alias, if one has been given for it.
	 * Elements that would be indistinguishable from each other or from an owned
	 * member (as determined by the Member::isDistinguishableFrom operation) are not imported. .
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean namespaceDefinitionMemberDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The members of a namespace must be distinguishable as determined by the Member::isDistinguishableFrom operation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n          self.member->forAll(m1 | \n            self.member->forAll(m2 | \n              m1 = m2 or m1.definition.isDistinguishableFrom(m2.definition)\n            )\n          )'"
	 * @generated
	 */
	boolean namespaceDefinitionMemberDistinguishability(DiagnosticChain diagnostics, Map<Object, Object> context);

} // NamespaceDefinition
