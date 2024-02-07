/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of an operation, with any formal parameters defined as owned members.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#getRedefinition <em>Redefinition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#getRedefinedOperation <em>Redefined Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsConstructor <em>Is Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsDestructor <em>Is Destructor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition()
 * @model
 * @generated
 */
public interface OperationDefinition extends NamespaceDefinition {
	/**
	 * Returns the value of the '<em><b>Redefinition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The names of other operations that are redefined by the operation being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefinition</em>' containment reference.
	 * @see #setRedefinition(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_Redefinition()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedNameList getRedefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OperationDefinition#getRedefinition <em>Redefinition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefinition</em>' containment reference.
	 * @see #getRedefinition()
	 * @generated
	 */
	void setRedefinition(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operation being defined is abstract.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_IsAbstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of statements that defines the behavior of the operation (empty for a stub).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_Body()
	 * @model containment="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OperationDefinition#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Redefined Operation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined Operation</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_RedefinedOperation()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.redefinition <> null then \n          -- NOTE: The current scope for the redefinition qualifed name list is\n          -- defined to be the outer scope of the class of the operation. This\n          -- prevents an infinite loop in resolving the members of the class,\n          -- relying on the fact that redefined operations can not be members of\n          -- the class with the redefinition.\n          self.redefinition.name.referent->asSet()\n        else\n          let owner = self.containingMember().namespace.oclAsType(ClassDefinition) in \n            owner.specializationReferent.members()->\n              select(m | m.visibility() <> \'private\' and not self.isDistinguishableFrom(m.asMember().definition))->\n              asSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> getRedefinedOperation();

	/**
	 * Returns the value of the '<em><b>Is Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this operation definition is for a constructor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Constructor</em>' attribute.
	 * @see #setIsConstructor(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_IsConstructor()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.annotation()->exists(stereotypeName.pathName = \'Create\')'"
	 * @generated
	 */
	boolean isIsConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsConstructor <em>Is Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Constructor</em>' attribute.
	 * @see #isIsConstructor()
	 * @generated
	 */
	void setIsConstructor(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Destructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this operation definition is for a destructor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Destructor</em>' attribute.
	 * @see #setIsDestructor(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getOperationDefinition_IsDestructor()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.annotation()->exists(stereotypeName.pathName = \'Destroy\')'"
	 * @generated
	 */
	boolean isIsDestructor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.OperationDefinition#isIsDestructor <em>Is Destructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Destructor</em>' attribute.
	 * @see #isIsDestructor()
	 * @generated
	 */
	void setIsDestructor(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the body of an operation definition include an
	 * assigned source for each parameter of the activity definition. The
	 * source for out parameters is actually null, however, to indicate that it
	 * has not been assigned yet (but that the name should not otherwise be used
	 * as a local name).
	 * <!-- end-model-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.body <> element then Set(AssignedSource){}\n        else\n          self.parameters()->collect(parameter |\n            AssignedSource{\n              name = parameter.actualName(),\n              source = if parameter.direction = \'out\' then null else parameter endif,\n              type = parameter.typePart.type,\n              upper = parameter.typePart.upper,\n              lower = parameter.typePart.lower\n            }\n          )->asSet()\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Operation.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                    /* TODO: Allow operation stereotype annotations. \052/\n                    annotation.stereotypeName.pathName = \'Create\' or\n                    annotation.stereotypeName.pathName = \'Destroy\' or\n                    self.NamespaceDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace definition associated with the given unit definition must be
	 * an activity definition with no template parameters. In addition, the subunit
	 * definition must have formal parameters that match each of the formal parameters
	 * of the stub definition, in order. Two formal parameters match if they have
	 * the same direction, name, multiplicity bounds, ordering, uniqueness and type
	 * reference. If this operation definition is a constructor, then it is considered
	 * to have an implicit return parameter, following any other formal parameters,
	 * with the same type as the class of the operation definition and a multiplicity of 1..1.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let definition = unit.definition in\n          definition.oclIsKindOf(ActivityDefinition) and\n          definition.templateParameters()->isEmpty() and\n          let operationParameters = self.parameters() in\n          let activityParameters = definition.parameters() in\n            operationParameters->size() = activityParameters->size() and \n            Sequence{1 .. operationParameters->size()}->forAll(i | \n              operationParameters->at(i).matches(activityParameters->at(i))\n            ) and\n          let operationReturnParameter = self.returnParameter() in\n          let activityReturnParameter = definition.returnParameter() in\n            operationReturnParameter = null and activityReturnParameter = null or\n            operationReturnParameter <> null and \n              operationReturnParameter.matches(activityReturnParameter)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either an OperationDefinition or an
	 * imported member whose referent is an OperationDefinition or an Operation,
	 * and the formal parameters of this operation definition match, in order,
	 * the parameters of the other operation definition or operation. In this
	 * context, matching means the same name and type (per UML Superstructure,
	 * Subclause 7.3.5). A constructor operation without an explicit return parameter
	 * is considered to implicitly have a return parameter, following any other
	 * formal parameters, of the same type as the owner of the constructor operation.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        member.isOperation() and self.parametersMatchNameType(member)'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns whether the parameters of this operation definition match the parameters of another operation
	 * in direction, name, multiplicity bounds, ordering, uniqueness and type.
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameters = self.parameters() in\n        let otherParameters = other.parameters() in\n          parameters->size() = otherParameters->size() and\n          Sequence{1..parameters->size()}->forAll(i |\n            parameters->at(i).matchesElement(otherParameters->at(i))\n          ) and\n        let returnParameter = self.returnParameter() in\n        let otherReturnParameter = other.returnParameter() in\n          returnParameter = null and otherReturnParameter = null or\n          returnParameter <> null and returnParameter.matchesElement(otherReturnParameter)'"
	 * @generated
	 */
	boolean parametersMatch(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns whether the parameters of this operation definition match the parameters of another operation
	 * in name and type only.
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameters = self.parameters() in\n        let otherParameters = other.parameters() in\n          parameters->size() = otherParameters->size() and\n          Sequence{1..parameters->size()}->forAll(i |\n            parameters->at(i).matchesNameType(otherParameters->at(i))\n          ) and\n        let returnParameter = self.returnParameter() in\n        let otherReturnParameter = other.returnParameter() in\n          returnParameter = null and otherReturnParameter = null or\n          returnParameter <> null and returnParameter.matchesType(otherReturnParameter)'"
	 * @generated
	 */
	boolean parametersMatchNameType(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the return parameter for this operation. If the operation is a constructor, a
	 * formal parameter is created to represent its implicit return parameter.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isConstructor then \n          let namespace = self.containingMember().namespace.toReference() in\n          let returnType =\n            if not namespace.isTemplate() then namespace\n            else\n              namespace.bind(\n                namespace.parameteredElements()->asSequence()\n              )\n            endif\n          in\n            FormalParameter{\n              direction = \'return\', \n              name = \'\', \n              typePart = TypedElementDefinition{\n                actualType = returnType\n              }\n            }\n        else\n          self.NamespaceDefinition_returnParameter()\n        endif'"
	 * @generated
	 */
	FormalParameter returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the specialization referents for the owning class definition of this operation definition.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let namespace = self.containingMember().namespace in \n          if namespace.oclIsKindOf(ClassDefinition) then \n            namespace.oclAsType(ClassDefinition).specializationReferent->asSet()\n          else \n            Set{}\n          endif'"
	 * @generated
	 */
	EList<ElementReference> specializationReferents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace for an operation definition must be a class definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.containingMember().namespace.oclIsKindOf(ClassDefinition)'"
	 * @generated
	 */
	boolean operationDefinitionNamespace(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an operation definition has a redefinition list, its redefined operations
	 * are the referent operations of the names in the redefinition list for the
	 * operation definition. Otherwise, the redefined operations are any operations
	 * that would otherwise be indistinguishable from the operation being defined
	 * in this operation definition.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean operationDefinitionRedefinedOperationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each name in the redefinition list of an operation definition must have a
	 * single referent that is an operation. This operation must be a non-private
	 * operation that is a member of a specialization referent of the class
	 * definition of the operation definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.redefinition = null or\n                      self.redefinition.name->forAll(\n                        referent->size() = 1 and \n                        referent->forAll(\n                          visibility() <> \'private\' and \n                          containedIn(self.specializationReferents().members()) and \n                          isOperation()\n                        )\n                      )'"
	 * @generated
	 */
	boolean operationDefinitionRedefinition(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The redefined operations of an operation definition must have formal parameters
	 * that match each of the formal parameters of this operation definition, in order.
	 * Two formal parameters match if they have the same direction, name, multiplicity
	 * bounds, ordering, uniqueness and type reference.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.redefinedOperation->forAll(op | self.parametersMatch(op))'"
	 * @generated
	 */
	boolean operationDefinitionRedefinedOperations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An operation definition is a feature.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean operationDefinitionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An operation definition is a constructor if it has a @Create annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean operationDefinitionIsConstructorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An operation definition is a destructor if it has a @Destroy annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean operationDefinitionIsDestructorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An operation definition cannot be both a constructor and a destructor.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      not (self.isConstructor and self.isDestructor)'"
	 * @generated
	 */
	boolean operationDefinitionConstructorDestructor(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an operation definition is a constructor, any redefined operation for it must also be a constructor.
	 * The body of a constructor may contain an alternative constructor invocation for another constructor
	 * in the same class or super constructor invocations for constructors in immediate superclasses.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.isConstructor implies\n                        ( self.redefinedOperation->forAll(isConstructor)) and\n                          -- NOTE: The following condition is added.\n                          -- A constructor may not have an explicit return type.\n                          not self.ownedMember.definition->exists(\n                            oclIsKindOf(FormalParameter) and \n                            oclAsType(FormalParameter).direction = \'return\'\n                        )'"
	 * @generated
	 */
	boolean operationDefinitionConstructor(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an operation definition is a destructor, any redefined operation for it must also be a destructor.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.isDestructor implies\n                        self.redefinedOperation->forAll(isDestructor)'"
	 * @generated
	 */
	boolean operationDefinitionDestructor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OperationDefinition
