/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Element Reference</b></em>'.
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
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference()
 * @model
 * @generated
 */
public interface ExternalElementReference extends ElementReference {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced model element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference_Element()
	 * @model required="true"
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The alias for the model element, if this is a reference to an imported
	 * element with multiple names within a namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExternalElementReference_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ExternalElementReference#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element'"
	 * @generated
	 */
	EObject asUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamedElement() then null\n        else\n          Member{\n            visibility = self.visibility(), \n            definition = ImportedMember{name = self.name(), referent = self}\n          }\n        endif'"
	 * @generated
	 */
	Member asMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if member.isAlf() then member.isSameKindAs(self)\n        else\n          let other = member.asUml().oclAsType(uml::Element) in\n            self.element.oclIsKindOf(other.oclType()) or\n            other.oclIsKindOf(self.element.oclType())\n        endif'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::NamedElement)'"
	 * @generated
	 */
	boolean isNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Namespace)'"
	 * @generated
	 */
	boolean isNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isNamespace()'"
	 * @generated
	 */
	boolean isNamespaceFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isModelNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Package)'"
	 * @generated
	 */
	boolean isPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Profile)'"
	 * @generated
	 */
	boolean isProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::PackageableElement)'"
	 * @generated
	 */
	boolean isPackageableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Classifier)'"
	 * @generated
	 */
	boolean isClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isClassifier() and self.element.oclAsType(uml::Classifier).isAbstract'"
	 * @generated
	 */
	boolean isAbstractClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Association)'"
	 * @generated
	 */
	boolean isAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::DataType)'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Class) and not self.element.oclIsKindOf(uml::Behavior)'"
	 * @generated
	 */
	boolean isClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isClass() and self.element.oclAsType(uml::Class).isActive'"
	 * @generated
	 */
	boolean isActiveClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Signal)'"
	 * @generated
	 */
	boolean isSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Enumeration)'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Behavior)'"
	 * @generated
	 */
	boolean isBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Activity)'"
	 * @generated
	 */
	boolean isActivity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isBehavior() and\n          self.element.oclAsType(uml::Behavior).specification <> null'"
	 * @generated
	 */
	boolean isMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Reception)'"
	 * @generated
	 */
	boolean isReception();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::PrimitiveType)'"
	 * @generated
	 */
	boolean isPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Operation)'"
	 * @generated
	 */
	boolean isOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and \n        self.element.oclAsType(uml::Element).\n          getAppliedStereotype(\'StandardProfile::Create\') <> null'"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isOperation() and \n        self.element.oclAsType(uml::Element).\n          getAppliedStereotype(\'StandardProfile::Destroy\') <> null'"
	 * @generated
	 */
	boolean isDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Feature)'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Property)'"
	 * @generated
	 */
	boolean isProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isProperty() and \n        -- Note: Only association-owned ends are considered as association ends.\n        self.element.oclAsType(uml::Property).owningAssociation <> null'"
	 * @generated
	 */
	boolean isAssociationEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Parameter)'"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(uml::TemplateableElement) and\n        self.element.oclAsType(uml::TemplateableElement).isTemplate()'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::TemplateParameter)'"
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::ClassifierTemplateParameter)'"
	 * @generated
	 */
	boolean isClassifierTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.element.oclIsKindOf(uml::Classifier) and\n        self.element.oclAsType(uml::Classifier).templateParameter <> null'"
	 * @generated
	 */
	boolean isParameteredElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.umlTemplateBinding()->notEmpty()'"
	 * @generated
	 */
	boolean isTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::Stereotype)'"
	 * @generated
	 */
	boolean isStereotype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.element.oclIsKindOf(uml::EnumerationLiteral)'"
	 * @generated
	 */
	boolean isEnumerationLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isLoopVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isSequenceExpansionExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if alias <> null then\n          alias\n        else if self.element.oclIsKindOf(uml::NamedElement) then \n          self.element.oclAsType(uml::NamedElement).name\n        else if self.element.oclIsKindOf(uml::TemplateParameter) then\n          let parameteredElement = \n            self.element.oclAsType(uml::TemplateParameter).parameteredElement \n          in\n            if parameteredElement.oclIsKindOf(uml::NamedElement) then\n              parameteredElement.oclAsType(uml::NamedElement).name\n            else\n              null\n            endif\n        else\n          null\n        endif endif endif'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element.oclIsKindOf(uml::NamedElement) then \'\'\n        else\n          let visibility = self.element.oclAsType(uml::NamedElement).visibility in \n            if visibility = null then null\n            else if visibility = uml::VisibilityKind::public then \'public\'\n            else if visibility = uml::VisibilityKind::protected then \'protected\'\n            else if visibility = uml::VisibilityKind::private then \'private\'\n            else \'\'\n            endif endif endif endif\n        endif'"
	 * @generated
	 */
	String visibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then OrderedSet(ElementReference){}\n        else \n          self.element.oclAsType(uml::Namespace).ownedMember->\n            collect(m | ExternalElementReference{element = m})->asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> ownedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * (Workaround for a seeming OCL bug "unboxing" enumeration literals.)
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> enumerationMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then OrderedSet(ElementReference){}\n        else\n          let namespace = self.element.oclAsType(uml::Namespace) in\n          let members = \n            if self.isEnumeration() then\n              self.enumerationMembers()\n            else\n\t            namespace.member-> \n\t              collect(m | \n\t                let names = namespace.getNamesOfMember(m) in\n\t                  if names->isEmpty() then\n\t                    Bag{ExternalElementReference{element = m}}\n\t                  else\n\t                    names->collect(name | \n\t                      ExternalElementReference{alias = name, element = m}\n\t                    )\n\t                  endif\n\t              )\n            endif->asOrderedSet() in\n          let additionalMembers = self.additionalMembers() in\n            additionalMembers->appendAll(members)->\n              appendAll(self.templateParameters())\n        endif'"
	 * @generated
	 */
	EList<ElementReference> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isClassifier() then OrderedSet(ElementReference){}\n        else\n          -- This will collect the inherited members from the effective  \n          -- expanded bound elements of each parent that is a template binding. \n          self.parents()->select(isTemplateBinding())->asOrderedSet()->\n            collect(binding |\n              binding.oclAsType(ExternalElementReference).inherit(\n                binding.template().bind(binding.templateActuals()->asSequence()).\n                  members()->select(visibility() <> \'private\')\n              )\n            )->asOrderedSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> additionalMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inheritableMembersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- NOTE: This is used to reject operations that would be inherited\n        -- via a template binding, in the case that the template binding itself\n        -- has an operation that should hide the inheritable operation.\n        -- This is used in the Alf standard library implementation as a\n        -- substitute for redefinition of operations from template instantiation. \n        let ownedOperations = self.ownedMembers()->select(isOperation()) in\n          inheritableMembers->reject(inheritableMember |\n            ownedOperations->exists(not isDistinguishableFrom(inheritableMember))\n          )'"
	 * @generated
	 */
	EList<ElementReference> inherit(EList<ElementReference> inheritableMembers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tif not self.element.oclIsKindOf(uml::Class) then OrderedSet(ElementReference){}\n\t\telse\n\t       self.element.oclAsType(uml::Class).nestedClassifier->collect(e |\n\t           ExternalElementReference{element = e}\n\t       )->asOrderedSet()\n\t    endif'"
	 * @generated
	 */
	EList<ElementReference> nestedClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isClassifier() then OrderedSet(ElementReference){}\n        else if self.isAssociation() then \n        \tself.members()->select(isProperty())\n        else\n          self.element.oclAsType(uml::Classifier).allAttributes()->\n            collect(a | ExternalElementReference{element = a})->\n            asOrderedSet()\n        endif endif'"
	 * @generated
	 */
	EList<ElementReference> properties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tif not self.isAssociation() then OrderedSet(ElementReference){}\n\t\telse \n\t\t\tself.element.oclAsType(uml::Association).ownedEnd->\n            collect(e | ExternalElementReference{element = e})->\n            asOrderedSet()\n\t\tendif'"
	 * @generated
	 */
	EList<ElementReference> associationEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n--        if not self.isProperty() then null\n--        else self.element.oclAsType(uml::Property).opposite()\n--        endif;\n        if not self.isAssociationEnd() then null\n        else\n          let property = self.element.oclAsType(uml::Property) in\n            let association = property.association in\n            let ends = association.memberEnd in\n              if ends->size() <> 2 then null\n              else ExternalElementReference{element= ends->any(e | e <> property)}\n              endif\n        endif'"
	 * @generated
	 */
	ElementReference opposite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isReception() then\n          null\n        else\n          ExternalElementReference{\n            element = self.element.oclAsType(uml::Reception).signal\n          }\n        endif'"
	 * @generated
	 */
	ElementReference signal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isParameteredElement() then\n          ExternalElementReference{\n            element = self.element.oclAsType(uml::ParameterableElement).\n                        templateParameter.signature.template\n          }\n        else if self.element.oclIsKindOf(uml::NamedElement) then\n          let namespace = self.element.oclAsType(uml::NamedElement).namespace in\n            if namespace = null then\n              null\n            else\n              ExternalElementReference{element = namespace}\n            endif\n        else\n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference namespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tlet ownedParameters = \n\t        if self.isBehavior() then\n\t          self.element.oclAsType(uml::Behavior).ownedParameter\n\t        else if self.isOperation() then\n\t          self.element.oclAsType(uml::Operation).ownedParameter\n\t        else\n\t          OrderedSet{}\n\t        endif endif\n\t      in\n\t      \townedParameters->\n\t      \t\tcollect(parameter | ExternalElementReference{element = parameter})->\n\t      \t\tasOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> ownedParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.ownedParameters()->reject(direction() = \'return\')'"
	 * @generated
	 */
	EList<ElementReference> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let returnParameters = self.ownedParameters()->select(direction() = \'return\') \n        in\n          if returnParameters->isEmpty() then\n            null\n          else\n            returnParameters->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isOperation() then \n          self\n        else if self.isBehavior() then\n          let specification = self.element.oclAsType(uml::Behavior).specification in\n            if specification = null then null\n            else ExternalElementReference{element = specification}\n            endif\n        else \n          null\n        endif endif'"
	 * @generated
	 */
	ElementReference specification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isOperation() then Set(ElementReference){}\n        else\n          self.element.oclAsType(uml::Operation).redefinedOperation->\n            collect(op | ExternalElementReference{element = op})->asSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> redefinedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let templateBinding = self.umlTemplateBinding() in\n          if templateBinding = null or \n            templateBinding.asUml().oclAsType(uml::TemplateBinding).signature = null then\n            null\n          else\n            ExternalElementReference{\n              element = templateBinding.asUml().oclAsType(uml::TemplateBinding).signature.template\n            }\n          endif'"
	 * @generated
	 */
	ElementReference template();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(uml::TemplateableElement) then\n          let templateBindings = \n            self.element.oclAsType(uml::TemplateableElement).templateBinding \n          in\n            if templateBindings->notEmpty() then\n              ExternalElementReference{element = templateBindings->any(true)}\n            else if self.element.oclIsKindOf(uml::NamedElement) then\n              let templateBindings =\n                self.element.oclAsType(uml::NamedElement).clientDependency->select(\n                    oclIsKindOf(uml::Realization) and\n                    supplier->size() = 1 and\n                    supplier->forAll(oclIsKindOf(uml::TemplateableElement))\n                  )->collect(\n                    supplier.oclAsType(uml::TemplateableElement).templateBinding\n                  )\n              in\n                if templateBindings->isEmpty() then\n                  null\n                else\n                  ExternalElementReference{element = templateBindings->any(true)}\n                endif\n            else\n              null\n            endif endif\n        else\n          null\n        endif'"
	 * @generated
	 */
	ElementReference umlTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplate() then\n          self.element.oclAsType(uml::TemplateableElement).\n            ownedTemplateSignature.parameter->\n            collect(p | ExternalElementReference{element = p})->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplate() then\n          self.element.oclAsType(uml::TemplateableElement).\n            ownedTemplateSignature.parameter.parameteredElement->\n            collect(p | ExternalElementReference{element = p})->asOrderedSet()\n        else\n          OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> parameteredElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let t = self.umlTemplateBinding() in\n          if t = null then\n            OrderedSet(ElementReference){}\n          else\n            let templateBinding = t.asUml().oclAsType(uml::TemplateBinding) in\n            let parameterSubstitution = templateBinding.parameterSubstitution in\n              templateBinding.signature.parameter->collect(parameter |\n                parameterSubstitution->select(formal = parameter).actual\n              )->collect(actual |\n                ExternalElementReference{element = actual}\n              )->asOrderedSet()\n          endif'"
	 * @generated
	 */
	EList<ElementReference> templateActuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isParameter() then\n          let direction = self.element.oclAsType(uml::Parameter).direction in\n            if direction = uml::ParameterDirectionKind::_in then \'in\'\n            else if direction = uml::ParameterDirectionKind::_in then \'in\'\n            else if direction = uml::ParameterDirectionKind::out then \'out\'\n            else if direction = uml::ParameterDirectionKind::inout then \'inout\'\n            else if direction = uml::ParameterDirectionKind::return then \'return\'\n            else null\n            endif endif endif endif endif\n        else\n          null\n        endif'"
	 * @generated
	 */
	String direction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isAssociationEnd() then null\n        -- Note: Only owned ends are treated as association ends.\n        else ExternalElementReference{element = self.element.oclAsType(uml::Property).owningAssociation}\n        endif'"
	 * @generated
	 */
	ElementReference association();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isBehavior() then\n            let returnParameter = self.returnParameter() in\n              if returnParameter = null then null\n              else returnParameter.type()\n              endif\n        else\n          let type =\n            if self.element.oclIsKindOf(uml::TypedElement) then\n              self.element.oclAsType(uml::TypedElement).type\n            else if self.isOperation() then\n              self.element.oclAsType(uml::Operation).type\n            else if self.isEnumerationLiteral() then\n              self.element.oclAsType(uml::EnumerationLiteral).enumeration\n            else\n              null\n            endif endif endif\n          in\n            if type = null then null \n            else ExternalElementReference{element = type} endif\n        endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(uml::MultiplicityElement) then\n          self.element.oclAsType(uml::MultiplicityElement).lower\n        else\n          1\n       endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(uml::MultiplicityElement) then\n          self.element.oclAsType(uml::MultiplicityElement).upper.oclAsType(Integer)\n        else\n          1\n       endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(uml::MultiplicityElement) then\n          self.element.oclAsType(uml::MultiplicityElement).isOrdered\n        else\n          false\n       endif'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.element.oclIsKindOf(uml::MultiplicityElement) then\n          not self.element.oclAsType(uml::MultiplicityElement).isUnique\n        else\n          false\n       endif'"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isClassifier() then\n          self.element.oclAsType(uml::Classifier).general->\n            collect(g | ExternalElementReference{element = g})->asSet()\n        else if self.element.oclIsKindOf(uml::ClassifierTemplateParameter) then\n          self.element.oclAsType(uml::ClassifierTemplateParameter).constrainingClassifier->\n            collect(c | ExternalElementReference{element = c})->asSet()\n        else\n          Set(ElementReference){}\n        endif endif'"
	 * @generated
	 */
	EList<ElementReference> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let allParents = \n          if self.isClassifier() then \n            self.element.oclAsType(uml::Classifier).allParents()->asSet()\n          else if self.element.oclIsKindOf(uml::ClassifierTemplateParameter) then\n            let parents = \n              self.element.oclAsType(uml::ClassifierTemplateParameter).\n                constrainingClassifier \n            in\n              parents->union(parents.allParents())->asSet()\n          else\n            Set(uml::Classifier){}\n          endif endif\n        in\n          allParents->collect(p | ExternalElementReference{element = p})->asSet()'"
	 * @generated
	 */
	EList<ElementReference> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.element.oclIsKindOf(uml::BehavioredClassifier) then null\n        else\n          let classifierBehavior = \n            self.element.oclAsType(uml::BehavioredClassifier).classifierBehavior in\n            if classifierBehavior = null then null\n            else ExternalElementReference{element = classifierBehavior}\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference classifierBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isNamespace() then Set(ElementReference){}\n        else\n          self.element.oclAsType(uml::Namespace).getNearestPackage().\n            getAllAppliedProfiles()->\n            collect(e | ExternalElementReference{element = e})->asSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isBehavior() then null\n        else\n          let context = self.element.oclAsType(uml::Behavior).context in\n          \tif context <> null then ExternalElementReference{element = context}\n          \telse if self.element.oclAsType(uml::Behavior).isActive then self\n          \telse null\n          \tendif endif \n        endif'"
	 * @generated
	 */
	ElementReference activeClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\tif not self.isBehavior() then null\n\t\telse\n\t\t\tlet context = self.element.oclAsType(uml::Behavior).context in\n\t\t\t\tif context = null then self \n\t\t\t\telse ExternalElementReference{element = context} \n\t\t\t\tendif\n\t\tendif'"
	 * @generated
	 */
	ElementReference context();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other = null or\n        self.isClassifier() and \n        let otherType = other.asUml() in\n          otherType <> null and otherType.oclIsKindOf(uml::Type) and\n          self.element.oclAsType(uml::Classifier).conformsTo(otherType.oclAsType(uml::Type))'"
	 * @generated
	 */
	boolean conformsTo(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other <> null and \n        \t(other.asUml() = self.element and other.name() = self.name() or\n        \t other.isModelNamespace() and other.asAlf().oclAsType(ModelNamespace).context().asUml() = self.element)'"
	 * @generated
	 */
	boolean equals(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ExternalElementReference{element = self.element}'"
	 * @generated
	 */
	ElementReference copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isNamespace() then self\n        else null\n        endif'"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ExternalElementReference_resolvePathName(pathName)'"
	 * @generated
	 */
	EList<ElementReference> resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EXTERNAL
	 * <!-- end-model-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 * @generated
	 */
	EList<ElementReference> ExternalElementReference_resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(name() = name)->asSet()'"
	 * @generated
	 */
	EList<ElementReference> resolveInScope(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" stereotypeNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isProfile() then\n          self.element.oclAsType(uml::Package).ownedElement->\n            select(oclIsKindOf(uml::Stereotype) and oclAsType(uml::Stereotype).name = stereotypeName)->\n            collect(e | ExternalElementReference{element = e})->asSet()\n        else\n          Set(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> resolveStereotype(String stereotypeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	ElementReference stub();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let definition = unit.definition in\n          if not definition.oclIsKindOf(ActivityDefinition) then null\n          else\n            let name = definition.actualName() in\n            let referents = self.ownedMembers()->select(\n              isOperation() and (name = name() or name.startsWith(name() + \'$method$\')) or\n              isActiveBehavior() and (name = name() or name.startsWith(name() + \'$behavior$\')) or\n              isProperty() and name.startsWith(name() + \'$defaultValue$\') \n            ) in\n              if referents->isEmpty() then null\n              else referents->any(true)\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

} // ExternalElementReference
