/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A direct reference to a UML model element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InternalElementReference#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInternalElementReference()
 * @model
 * @generated
 */
public interface InternalElementReference extends ElementReference {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Alf syntax element that represents the referenced model element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(SyntaxElement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInternalElementReference_Element()
	 * @model required="true"
	 * @generated
	 */
	SyntaxElement getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InternalElementReference#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(SyntaxElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isAlf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element'"
	 * @generated
	 */
	SyntaxElement asAlf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(Member) then self.element.oclAsType(Member)\n        else if self.element.oclIsKindOf(MemberDefinition) then\n          let container = self.element.oclContainer() in\n            if container.oclIsKindOf(Member) then container.oclAsType(Member)\n            else null\n            endif\n        else null\n        endif endif'"
	 * @generated
	 */
	Member asMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(MemberDefinition) and\n        self.element.oclAsType(MemberDefinition).isSameKindAs(member)'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(MemberDefinition)'"
	 * @generated
	 */
	boolean isNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(NamespaceDefinition)'"
	 * @generated
	 */
	boolean isNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isNamespace() and self.stubFor(unit) <> null'"
	 * @generated
	 */
	boolean isNamespaceFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(ModelNamespace)'"
	 * @generated
	 */
	boolean isModelNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(PackageDefinition)'"
	 * @generated
	 */
	boolean isPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(Member) and\n        not self.element.oclIsKindOf(FormalParameter) and\n        not self.element.oclIsKindOf(ClassifierTemplateParameter) and\n        not self.isFeature()'"
	 * @generated
	 */
	boolean isPackageableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(ClassifierDefinition)'"
	 * @generated
	 */
	boolean isClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isAbstractClassifier()\n          else\n            self.isClassifier() and \n            self.element.oclAsType(ClassifierDefinition).isAbstract\n          endif'"
	 * @generated
	 */
	boolean isAbstractClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isAssociation()\n          else\n            self.element.oclIsKindOf(AssociationDefinition)\n          endif'"
	 * @generated
	 */
	boolean isAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isDataType()\n          else\n            self.element.oclIsKindOf(DataTypeDefinition)\n          endif'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isClass()\n          else\n            self.element.oclIsKindOf(ClassDefinition)\n          endif'"
	 * @generated
	 */
	boolean isClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isActiveClass()\n          else\n            self.element.oclIsKindOf(ActiveClassDefinition)\n          endif'"
	 * @generated
	 */
	boolean isActiveClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isSignal()\n          else\n            self.element.oclIsKindOf(SignalDefinition) or\n            self.element.oclIsKindOf(SignalReceptionDefinition)\n          endif'"
	 * @generated
	 */
	boolean isSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isEnumeration()\n          else\n            self.element.oclIsKindOf(EnumerationDefinition)\n          endif'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isBehavior()\n          else\n            self.element.oclIsKindOf(ActivityDefinition)\n          endif'"
	 * @generated
	 */
	boolean isBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isActivity()\n          else\n            self.element.oclIsKindOf(ActivityDefinition)\n          endif'"
	 * @generated
	 */
	boolean isActivity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isActivity() and \n          let stub = self.stub() in\n            -- The case of the stub being a property covers the case of an\n            -- activity used in the default value of an external property.\n            stub <> null and (stub.isOperation() or stub.isProperty())'"
	 * @generated
	 */
	boolean isMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.isReception()\n          else\n            self.element.oclIsKindOf(ReceptionDefinition) or\n            self.element.oclIsKindOf(SignalReceptionDefinition)\n          endif'"
	 * @generated
	 */
	boolean isReception();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(OperationDefinition)'"
	 * @generated
	 */
	boolean isOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and\n        self.element.oclAsType(OperationDefinition).isConstructor'"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and\n        self.element.oclAsType(OperationDefinition).isDestructor'"
	 * @generated
	 */
	boolean isDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(MemberDefinition) and \n        self.element.oclAsType(MemberDefinition).isFeature'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(PropertyDefinition)'"
	 * @generated
	 */
	boolean isProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isProperty() and\n        self.asMember().namespace.oclIsKindOf(AssociationDefinition)'"
	 * @generated
	 */
	boolean isAssociationEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(FormalParameter)'"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(MemberDefinition) and\n        self.element.oclAsType(MemberDefinition).isTemplate()'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(ClassifierTemplateParameter)'"
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(ClassifierTemplateParameter)'"
	 * @generated
	 */
	boolean isClassifierTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(ClassifierTemplateParameter)'"
	 * @generated
	 */
	boolean isParameteredElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(BoundClassifier)'"
	 * @generated
	 */
	boolean isTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(EnumerationLiteralName)'"
	 * @generated
	 */
	boolean isEnumerationLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(LoopVariableDefinition)'"
	 * @generated
	 */
	boolean isLoopVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(Annotation)'"
	 * @generated
	 */
	boolean isAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(SequenceExpansionExpression)'"
	 * @generated
	 */
	boolean isSequenceExpansionExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(AnyType)'"
	 * @generated
	 */
	boolean isAnyType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isStereotype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamedElement() then null\n        else self.element.oclAsType(MemberDefinition).actualName()\n        endif'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let member = self.asMember() in\n          if member = null then null\n          else member.visibility()\n          endif'"
	 * @generated
	 */
	String visibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isNamespace() then \n          self.element.oclAsType(NamespaceDefinition).ownedMember.toReference()->\n            asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> ownedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isNamespace() then \n          self.element.oclAsType(NamespaceDefinition).member.toReference()->\n            asOrderedSet()\n        else \n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tif not self.element.oclIsKindOf(ModelNamespace) then OrderedSet(ElementReference){}\n\t\telse\n\t\t\tself.element.oclAsType(ModelNamespace).context().nestedClassifiers()\n\t\tendif'"
	 * @generated
	 */
	EList<ElementReference> nestedClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isProperty() then null\n        else\n          let member = self.asMember() in\n            if member = null then null\n            else\n              let owner = member.owner() in\n                if not owner.oclIsKindOf(AssociationDefinition) then null\n                else\n                  let ends = owner.oclAsType(AssociationDefinition).ownedMember in\n                    if ends->size() <> 2 then null\n                    else ends->any(e | e <> member).oclAsType(Member).toReference()\n                    endif\n                endif\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference opposite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let element = self.element in\n          if element.oclIsKindOf(ReceptionDefinition) then\n            element.oclAsType(ReceptionDefinition).signal\n          else if element.oclIsKindOf(SignalReceptionDefinition) then\n            element.oclAsType(SignalReceptionDefinition).toReference()\n          else\n            null\n          endif endif'"
	 * @generated
	 */
	ElementReference signal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.parameters()\n          else if self.isBehavior() or self.isOperation() then\n            self.element.oclAsType(NamespaceDefinition).parameters().toReference()->asOrderedSet()\n          else\n            OrderedSet(ElementReference){}\n          endif endif'"
	 * @generated
	 */
	EList<ElementReference> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.returnParameter()\n          else if self.isBehavior() or self.isOperation() then\n            let returnParameter = self.element.oclAsType(NamespaceDefinition).returnParameter() in\n              if returnParameter = null then\n                null\n              else\n                returnParameter.toReference()\n              endif\n          else\n            null\n          endif endif'"
	 * @generated
	 */
	ElementReference returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isOperation() then \n          self\n        else if self.isBehavior() then\n          self.element.oclAsType(NamespaceDefinition).stub()\n        else \n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference specification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isOperation() then Set(ElementReference){}\n        else self.oclAsType(OperationDefinition).redefinedOperation\n        endif'"
	 * @generated
	 */
	EList<ElementReference> redefinedOperaions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isModelNamespace() then\n        \tself.element.oclAsType(ModelNamespace).context().namespace()\n        else if self.element.oclIsKindOf(MemberDefinition) then\n          self.element.oclAsType(MemberDefinition).outerScope()\n        else\n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference namespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplateBinding() then\n          self.element.oclAsType(BoundClassifier).template\n        else\n          null\n        endif'"
	 * @generated
	 */
	ElementReference template();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplate() then\n          self.element.oclAsType(ClassifierDefinition).templateParameters().toReference()->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.templateParameters()'"
	 * @generated
	 */
	EList<ElementReference> parameteredElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplateBinding() then\n          self.element.oclAsType(BoundClassifier).actual->collect (actual |\n            if actual.isAnyType() then null else actual endif\n          )->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> templateActuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isParameter() then\n          self.element.oclAsType(FormalParameter).direction\n        else\n          null\n        endif'"
	 * @generated
	 */
	String direction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isAssociationEnd() then null\n        else self.namespace()\n        endif'"
	 * @generated
	 */
	ElementReference association();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProperty() then\n          self.element.oclAsType(PropertyDefinition).typePart.type\n        else if self.isParameter() then\n          self.element.oclAsType(FormalParameter).typePart.type\n        else if self.isBehavior() or self.isOperation() then\n          let returnParameter = self.returnParameter() in\n            if returnParameter = null then null\n            else returnParameter.type()\n            endif\n        else if self.isEnumerationLiteral() then\n          self.namespace()\n        else\n          null\n        endif endif endif endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProperty() then\n          self.element.oclAsType(PropertyDefinition).typePart.lower\n        else if self.isParameter() then\n          self.element.oclAsType(FormalParameter).typePart.lower\n        else\n          1\n        endif endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProperty() then\n          self.element.oclAsType(PropertyDefinition).typePart.upper\n        else if self.isParameter() then\n          self.element.oclAsType(FormalParameter).typePart.upper\n        else\n          1\n        endif endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProperty() then\n          self.element.oclAsType(PropertyDefinition).typePart.isOrdered()\n        else if self.isParameter() then\n          self.element.oclAsType(FormalParameter).typePart.isOrdered()\n        else\n          false\n        endif endif'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProperty() then\n          self.element.oclAsType(PropertyDefinition).typePart.isNonunique()\n        else if self.isParameter() then\n          self.element.oclAsType(FormalParameter).typePart.isNonunique()\n        else\n          false\n        endif endif'"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isClassifier() then\n          self.element.oclAsType(ClassifierDefinition).specializationReferent->asSet()\n        else\n          Set(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isClassifier() then\n          self.element.removeDuplicateElements(\n            self->closure(parents())->excluding(self)->asBag()\n          )->asSet()\n        else\n          Set(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isActiveClass() then null\n        else\n          let classifierBehavior = \n            self.element.oclAsType(ActiveClassDefinition).classifierBehavior in\n            if classifierBehavior = null then null\n            else classifierBehavior.toReference()\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference classifierBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then Set(ElementReference){}\n        else self.element.oclAsType(NamespaceDefinition).appliedProfiles()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isActivity() then null\n        else\n        \tlet stub = self.stub() in\n        \t\t-- This will also work is the stub is external.\n\t        \tif stub <> null then stub.activeClass()\n\t        \telse\n\t            \tlet namespace = self.namespace() in\n\t\t\t            if namespace = null or \n\t\t\t              not self.equals(namespace.classifierBehavior()) then null\n\t\t\t            else namespace\n\t\t\t            endif\n\t\t\t    endif\n        endif'"
	 * @generated
	 */
	ElementReference activeClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tif not self.isActivity() then null\n\t\telse\n\t\t\tlet stub = self.stub() in\n\t\t\tlet namespace = if stub = null then self.namespace() else stub.namespace() endif in\n\t\t\t\tif namespace = null or \n\t\t\t\t\tnamespace.nestedClassifiers()->exists(name() = self.name()) then null\n\n\t\t\t\t-- Note: This can only happen for a namespace that is an\n\t\t\t\t-- external element reference.\n\t\t\t\telse if namespace.isBehavior() then namespace.context()\n\n\t\t\t\telse namespace\n\t\t\t\tendif endif\n\t\tendif'"
	 * @generated
	 */
	ElementReference context();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other = null or\n        self.isClassifier() and (self.equals(other) or\n        self.element.oclAsType(ClassifierDefinition).\n          specializationReferent->exists(conformsTo(other)))'"
	 * @generated
	 */
	boolean conformsTo(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tother <> null and (other.asAlf() = self.element or \n\t\t\tself.isModelNamespace() and other.asUml() = self.element.oclAsType(ModelNamespace).context().asUml())'"
	 * @generated
	 */
	boolean equals(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='InternalElementReference{element = self.element}'"
	 * @generated
	 */
	ElementReference copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then null\n        else self.element.oclAsType(NamespaceDefinition).modelScope()\n        endif'"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element.oclIsKindOf(ModelNamespace) then\n          Set(ElementReference){}\n        else\n          self.element.oclAsType(ModelNamespace).resolvePathName(pathName)\n        endif'"
	 * @generated
	 */
	EList<ElementReference> resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template <> null then\n            template.resolveInScope(name)\n          else if not self.isNamespace() then Set(ElementReference){}\n          else \n            self.element.oclAsType(NamespaceDefinition).resolveInScope(name).\n              toReference()->asSet()\n          endif endif'"
	 * @generated
	 */
	EList<ElementReference> resolveInScope(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" stereotypeNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Set(ElementReference){}'"
	 * @generated
	 */
	EList<ElementReference> resolveStereotypeName(String stereotypeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then null\n        else self.element.oclAsType(NamespaceDefinition).stub()\n        endif'"
	 * @generated
	 */
	ElementReference stub();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then null\n        else self.element.oclAsType(NamespaceDefinition).stubFor(unit)\n        endif'"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

} // InternalElementReference
