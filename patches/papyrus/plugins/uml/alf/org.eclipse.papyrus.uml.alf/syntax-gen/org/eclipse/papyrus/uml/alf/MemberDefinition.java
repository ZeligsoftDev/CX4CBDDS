/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model of the common properties of the definition of a member of a namespace in Alf.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsStub <em>Is Stub</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsFeature <em>Is Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsPrimitive <em>Is Primitive</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsExternal <em>Is External</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.MemberDefinition#getSubunit <em>Subunit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition()
 * @model abstract="true"
 * @generated
 */
public interface MemberDefinition extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the member.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_Name()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='StereotypeAnnotation'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Stub</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this member definition is a stub for a subunit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Stub</em>' attribute.
	 * @see #setIsStub(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_IsStub()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='StereotypeAnnotation'"
	 * @generated
	 */
	boolean isIsStub();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsStub <em>Is Stub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Stub</em>' attribute.
	 * @see #isIsStub()
	 * @generated
	 */
	void setIsStub(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this member is a feature of a classifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Feature</em>' attribute.
	 * @see #setIsFeature(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_IsFeature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='StereotypeAnnotation'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isFeature()'"
	 * @generated
	 */
	boolean isIsFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsFeature <em>Is Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Feature</em>' attribute.
	 * @see #isIsFeature()
	 * @generated
	 */
	void setIsFeature(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this member is a primitive or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Primitive</em>' attribute.
	 * @see #setIsPrimitive(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_IsPrimitive()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='StereotypeAnnotation' unique='false' upper='*'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.annotation().stereotypeName->exists(pathName = \'primitive\')'"
	 * @generated
	 */
	boolean isIsPrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsPrimitive <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primitive</em>' attribute.
	 * @see #isIsPrimitive()
	 * @generated
	 */
	void setIsPrimitive(boolean value);

	/**
	 * Returns the value of the '<em><b>Is External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this member is external or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is External</em>' attribute.
	 * @see #setIsExternal(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_IsExternal()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.annotation().stereotypeName->exists(pathName = \'external\')'"
	 * @generated
	 */
	boolean isIsExternal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#isIsExternal <em>Is External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is External</em>' attribute.
	 * @see #isIsExternal()
	 * @generated
	 */
	void setIsExternal(boolean value);

	/**
	 * Returns the value of the '<em><b>Subunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The subunit corresponding to the member, if the member is a stub.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subunit</em>' reference.
	 * @see #setSubunit(UnitDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMemberDefinition_Subunit()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='null'"
	 * @generated
	 */
	UnitDefinition getSubunit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.MemberDefinition#getSubunit <em>Subunit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subunit</em>' reference.
	 * @see #getSubunit()
	 * @generated
	 */
	void setSubunit(UnitDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let container = self.oclContainer() in \n              if container.oclIsKindOf(Member) then \n                container.oclAsType(Member).annotation\n              else if container.oclIsKindOf(UnitDefinition) then \n                container.oclAsType(UnitDefinition).annotation\n              else if container.oclIsKindOf(MemberDefinition) then\n                container.oclAsType(MemberDefinition).annotation()\n              else \n                Set{}\n              endif endif endif'"
	 * @generated
	 */
	EList<StereotypeAnnotation> annotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            NameBinding{name = self.name}.toName()'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.MemberDefinition_outerScope()'"
	 * @generated
	 */
	ElementReference outerScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let container = self.containingMember() in\n              if container <> null then\n                let namespace = container.namespace in\n                  if namespace = null then null else namespace.toReference() endif\n              else\n                null\n              endif'"
	 * @generated
	 */
	ElementReference MemberDefinition_outerScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if self.name = null then\n              null\n            else\n              let nameBinding = NameBinding{name = self.name} in\n              let outerScope = self.outerScope() in\n                if outerScope = null then\n                  QualifiedName{nameBinding = nameBinding}\n                else\n                  let qualificationName = outerScope.qualifiedName() in\n                  if qualificationName = null then\n                    null\n                  else\n                    QualifiedName{\n                      nameBinding = qualificationName.nameBinding->append(nameBinding)\n                    }\n                  endif\n                endif\n            endif'"
	 * @generated
	 */
	QualifiedName qualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      let container = self.oclContainer() in\n                        if container.oclIsKindOf(Member) then\n                          let namespace = container.oclAsType(Member).namespace in\n                            if namespace = null then null\n                            else namespace.toReference()\n                            endif\n                        else if container.oclIsKindOf(NamespaceDefinition) then\n                          container.oclAsType(NamespaceDefinition).toReference()\n                        else if container.oclIsKindOf(UnitDefinition) then\n                          container.oclAsType(UnitDefinition).namespace\n                        else if container.oclIsKindOf(MemberDefinition) then\n                          -- NOTE: This is a workaround to handle an Xtext\n                          -- editor bug in which the syntax tree is built wrong.\n                          container.oclAsType(MemberDefinition).namespaceReference()\n                        else\n                          null\n                        endif endif endif endif'"
	 * @generated
	 */
	ElementReference namespaceReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	Member addToModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true of the given stereotype annotation is allowed for this kind
	 * of element.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true of the given unit definition is a legal match for this
	 * member as a stub. By default, always returns false.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if this member is distinguishable from the given member. Two
	 * members are distinguishable if their names are different or the they are of
	 * different kinds (as determined by the isSameKindAs operation). However, in
	 * any case that the UML Superstructure considers two names to be distinguishable
	 * if they are different, an Alf implementation may instead impose the stronger
	 * requirement that the names not be conflicting.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='MemberDefinition_isDistinguishableFrom(member)'"
	 * @generated
	 */
	boolean isDistinguishableFrom(MemberDefinition member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.actualName() <> member.actualName() or not self.isSameKindAs(member.toReference())'"
	 * @generated
	 */
	boolean MemberDefinition_isDistinguishableFrom(MemberDefinition member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if this member is of the same kind as the given member.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template parameters associated with this member. (Only a namespace
	 * definition can actually have template parameters.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='OrderedSet{}'"
	 * @generated
	 */
	EList<ClassifierTemplateParameter> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if this member is a template.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.templateParameters()->notEmpty()'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if this member is a feature. By default is is not.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All stereotype annotations for a member must be allowed, as determined using the stereotypeAllowed operation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.annotation()->forAll(a | self.annotationAllowed(a))'"
	 * @generated
	 */
	boolean memberAnnotations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A member is primitive if it has a @primitive annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean memberIsPrimitiveDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A member is external if it has an @external derivation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean memberIsExternalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a member is external then it must be a stub.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.isExternal implies self.isStub'"
	 * @generated
	 */
	boolean memberExternal(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a member is a stub and is not external, then there must be a single subunit with the same qualified name as the stub that matches the stub, as determined by the matchForStub operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean memberStub(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the member is a stub and is not external, then its corresponding subunit is a unit definition with the same fully qualified name as the stub.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean memberSubunitDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a member is a stub, then the it must not have any stereotype annotations that are the same as its subunit. Two stereotype annotations are the same if they are for the same stereotype.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean memberStubStereotypes(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a member is primitive, then it may not be a stub and it may not have any owned members that are template parameters.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.isPrimitive implies not self.isStub and not self.isTemplate()'"
	 * @generated
	 */
	boolean memberPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is a workaround for an Xtext editor problem in which a reparsed
	 * subtree may be put in the wrong container.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let container = self.oclContainer() in\n          if container = null then null\n          else if container.oclIsKindOf(Member) then \n            container.oclAsType(Member)\n          else if container.oclIsKindOf(MemberDefinition) then \n            container.oclAsType(MemberDefinition).containingMember()\n          else \n            null\n          endif endif endif'"
	 * @generated
	 */
	Member containingMember();

} // MemberDefinition
