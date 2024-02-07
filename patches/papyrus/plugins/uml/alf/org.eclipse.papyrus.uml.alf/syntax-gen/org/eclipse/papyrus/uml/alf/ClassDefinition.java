/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a class, whose members may be properties, operations, signals or signal receptions.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassDefinition()
 * @model
 * @generated
 */
public interface ClassDefinition extends ClassifierDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed for classifiers in general, a class definition allows an
	 * annotation for any stereotype whose metaclass is consistent with Class.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    /* TODO: Allow class stereotype annotations. \052/\n    self.ClassifierDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this class definition considered as a
	 * classifier definition and the subunit is for a class definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                          self.ClassifierDefinition_matchForStub(unit) and\n                          /* NOTE: Cannot be an ActiveClassDefinition. \052/\n                          unit.definition.oclIsTypeOf(ClassDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either a ClassDefinition or an imported member whose referent is a ClassDefinition or a Class.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isClass()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks whether this class needs to have a default constructor added.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        not self.ownedMember.definition->exists(\n          oclIsKindOf(OperationDefinition) and \n          oclAsType(OperationDefinition).isConstructor\n        )'"
	 * @generated
	 */
	boolean needsDefaultConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks whether this class needs to have a default destructor added.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        not self.ownedMember.definition->exists(\n          oclIsKindOf(OperationDefinition) and \n          oclAsType(OperationDefinition).isDestructor\n        )'"
	 * @generated
	 */
	boolean needsDefaultDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inheritableMembersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.inheritCached(inheritableMembers)'"
	 * @generated
	 */
	EList<Member> inherit(EList<Member> inheritableMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL: Caches intermediate members computation to avoid infinite loops.
	 * <!-- end-model-doc -->
	 * @model inheritableMembersMany="true"
	 * @generated
	 */
	EList<Member> inheritCached(EList<Member> inheritableMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inheritableMembersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let ownedOperations = self.subunitOwnedMembers().definition->\n          select(oclIsKindOf(OperationDefinition)).oclAsType(OperationDefinition)\n        in\n          inheritableMembers->reject(inheritableMember |\n            ownedOperations->exists(operation |\n              inheritableMember.toReference().\n                containedIn(operation.redefinedOperation->asBag()) or\n              not operation.isDistinguishableFrom(inheritableMember.definition)\n            )\n          )'"
	 * @generated
	 */
	EList<Member> ClassDefinition_inherit(EList<Member> inheritableMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialization referents of a class definition must all be classes.
	 * A class definition may not have any referents that are active classes unless
	 * this is an active class definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specializationReferent->forAll(isClass()) and\n                      (self.specializationReferent->exists(isActiveClass())\n                        implies self.oclIsKindOf(ActiveClassDefinition)\n                      )'"
	 * @generated
	 */
	boolean classDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a class definition is not abstract, then no member operations (owned or inherited)
	 * of the class definition may be abstract.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      if self.isAbstract then true\n                      else \n                        self.member.definition->select(oclIsKindOf(OperationDefinition)).\n                          oclAsType(OperationDefinition)->forAll(not isAbstract)\n                      endif'"
	 * @generated
	 */
	boolean classDefinitionAbstractMember(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ClassDefinition
