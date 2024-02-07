/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a model element, either directly or via its Alf abstract
 * syntax representation. (NOTE: The definitions of all the helper operations
 * of ElementReference are specific to its subclasses.)
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getElementReference()
 * @model abstract="true"
 * @generated
 */
public interface ElementReference extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isAlf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	EObject asUml();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	SyntaxElement asAlf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Member asMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 * @generated
	 */
	boolean isNamespaceFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isModelNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isPackageableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAbstractClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isActiveClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isActivity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isReception();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAssociationEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isClassifierTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isParameteredElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isStereotype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isEnumerationLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isLoopVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isSequenceExpansionExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isAnyType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let member = self.asMember() in\n        let otherMember = other.asMember() in\n          if member = null or otherMember = null then true\n          else\n            member.definition.isDistinguishableFrom(otherMember.definition)\n          endif'"
	 * @generated
	 */
	boolean isDistinguishableFrom(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        AssignableElementReference{\n          reference = self, owner = element.owner()\n        }.isAssignableFrom(element)'"
	 * @generated
	 */
	boolean isAssignableFrom(AssignableElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n--        let templateActuals = self.templateActuals() in\n--          if templateActuals->isEmpty() then null\n--          else templateActuals->first()\n--          endif;\n        let toSequenceOperation = self.resolve(\'toSequence\')->select(\n          isOperation() and parameters()->size() = 0 and returnParameter() <> null\n        ) in\n          if toSequenceOperation->size() <> 1 then null\n          else toSequenceOperation->any(true).type()\n          endif'"
	 * @generated
	 */
	ElementReference collectionArgument();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String visibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> ownedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(visibility() = null or visibility() = \'public\')->asSet()'"
	 * @generated
	 */
	EList<ElementReference> visibleMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> nestedClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(isProperty())'"
	 * @generated
	 */
	EList<ElementReference> properties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(isAssociationEnd())'"
	 * @generated
	 */
	EList<ElementReference> associationEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference opposite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.members()->select(isReception())->asSet()'"
	 * @generated
	 */
	EList<ElementReference> receptions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference signal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference specification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> redefinedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference namespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference template();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> parameteredElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ElementReference> templateActuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String direction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference association();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference classifierBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference context();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = self.template() in\n          if template = null then self\n          else template\n          endif'"
	 * @generated
	 */
	ElementReference base();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self'"
	 * @generated
	 */
	ElementReference reference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	ElementReference templateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" actualsUnique="false" actualsMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        BoundClassifier{\n          name = self.boundElementName(actuals),\n          template = self,\n          actual = actuals\n        }.addToModel().toReference()'"
	 * @generated
	 */
	ElementReference bind(EList<ElementReference> actuals);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" actualsUnique="false" actualsMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        actuals->iterate(\n          actual, s : String = \'$$\' + self.boundPathName() + \'__\' |\n          s + if actual = null then \'any\' else actual.boundPathName() endif + \'_\'\n        ) + \'_\''"
	 * @generated
	 */
	String boundElementName(EList<ElementReference> actuals);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isModelNamespace() then \'\'\n        else\n          let template = self.template() in\n            if template = null then\n              let namespace = self.namespace() in\n              let name = if self.name() = null then \'\' else self.name() endif in\n                if namespace = null or namespace.isModelNamespace() then name\n                else namespace.boundPathName() + \'$\' + name\n                endif\n            else\n              template.boundElementName(self.templateActuals()->asSequence())\n            endif\n        endif'"
	 * @generated
	 */
	String boundPathName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isModelNamespace() then\n          QualifiedName{nameBinding = OrderedSet(NameBinding){}}\n        else\n          let template = self.template() in\n            if template = null then\n              let namespace = self.namespace() in\n              let qualifiedName =\n                if namespace = null then null \n                else namespace.qualifiedName() endif in\n              let name = self.name() in\n              let nameBinding = NameBinding{\n                name = if name = null then \'\' else name endif\n              } in\n                if qualifiedName = null then\n                  QualifiedName{nameBinding = OrderedSet{nameBinding}}\n                else\n                  QualifiedName{\n                    nameBinding = qualifiedName.nameBinding->append(nameBinding)\n                  }\n                endif\n            else\n              let templateName = template.qualifiedName() in\n              let nameBindings = templateName.nameBinding in\n              let n = nameBindings->size() in\n                if n = 0 then\n                  templateName\n                else\n                  let templateBinding = PositionalTemplateBinding{\n                    argumentName = self.templateActuals()->\n                      collect(templateActual | \n                        if templateActual = null then \n                          QualifiedName{nameBinding = OrderedSet(NameBinding){}}\n                        else \n                          templateActual.qualifiedName() \n                        endif\n                      )\n                  } in\n                  let name = self.name() in\n                  let nameBinding = NameBinding{\n                    name = if name = null then \'\' else name endif,\n                    binding = templateBinding\n                  } in\n                  if n = 1 then\n                    QualifiedName{nameBinding = OrderedSet{nameBinding}}\n                  else\n                    QualifiedName{\n                      nameBinding =\n                        nameBindings->subOrderedSet(1,n-1)->append(nameBinding)\n                    }\n                  endif\n                endif\n          endif\n          endif'"
	 * @generated
	 */
	QualifiedName qualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the active class corresponding to an activity, if any.
	 * This is either the activity itself, if it is active, or the class that
	 * has the activity as a classifier behavior.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	ElementReference activeClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.activeClass() <> null'"
	 * @generated
	 */
	boolean isActiveBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean conformsTo(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean equals(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" referencesUnique="false" referencesMany="true" referencesOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='references->exists(equals(self))'"
	 * @generated
	 */
	boolean containedIn(EList<ElementReference> references);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" referencesUnique="false" referencesMany="true" referencesOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='references->select(equals(self))->size()'"
	 * @generated
	 */
	BigInteger countIn(EList<ElementReference> references);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" referencesUnique="false" referencesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if references->isEmpty() then 0\n        else\n          let indices = \n            Sequence{1..references->size()}->select(i | self.equals(references->at(i)))\n          in\n            if indices->isEmpty() then 0\n            else indices->first()\n            endif\n        endif'"
	 * @generated
	 */
	BigInteger positionIn(EList<ElementReference> references);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ElementReference copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 * @generated
	 */
	EList<ElementReference> resolvePathName(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let members = self.resolveInScope(name) in\n        let outerScope = self.namespace() in\n          if outerScope = null then\n            members\n          else\n            members->union(\n              outerScope.resolve(name)->select(m1 | \n                members->forAll(m2 | \n                  m1.isDistinguishableFrom(m2)\n                )\n              )\n            )\n          endif'"
	 * @generated
	 */
	EList<ElementReference> resolve(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 * @generated
	 */
	EList<ElementReference> resolveInScope(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" stereotypeNameRequired="true"
	 * @generated
	 */
	EList<ElementReference> resolveStereotype(String stereotypeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let members = self.resolveInScope(name) in\n          -- Note: If this namespace is the same as or a containing scope of the \n          -- given namespace, or if the given namespace is null, then all members \n          -- of this namespace are visible.\n          if namespace = null or\n             self.equals(namespace) or\n             self.containsMember(namespace) then\n            members\n          else\n             members->select(visibility() = \'public\' or \n                self.allowPackageOnly() and visibility() = \'package\'\n             )\n          endif'"
	 * @generated
	 */
	EList<ElementReference> resolveVisible(String name, ElementReference namespace);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" oppositeEndTypeRequired="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.members()->\n          -- Note: Only association-owned ends are considered as association ends.\n          select(isAssociation() and (properties()->size() = 2)).associationEnds()->\n          select(associationEnd |\n              let opposite = associationEnd.opposite() in\n                opposite <> null and\n                oppositeEndType.conformsTo(opposite.type()) and\n                  name = associationEnd.name()\n          )->asSet()\n        in\n          let outerScope = self.namespace() in\n            if outerScope = null then referents\n            else\n              let hiddenNames = referents.name() in\n                referents->union(\n                  outerScope.resolveAssociationEnd(oppositeEndType, name)->\n                  reject(outerReferent | hiddenNames->includes(outerReferent.name()))\n              )\n            endif'"
	 * @generated
	 */
	EList<ElementReference> resolveAssociationEnd(ElementReference oppositeEndType, String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        member = null or\n          let namespace = member.namespace() in\n            namespace <> null and\n              (self.equals(namespace) or\n                self.containsMember(namespace))'"
	 * @generated
	 */
	boolean containsMember(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='not self.isPackage()'"
	 * @generated
	 */
	boolean allowPackageOnly();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference stub();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unitRequired="true"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tif not self.isConstructor() then null\n\t\t\t\telse\n          let classReferent = self.namespace() in\n            if not classReferent.isAbstractClassifier() then\n              self\n            else\n              -- Check for an \"Impl\" package.\n              let namespaceReferent = classReferent.namespace() in\n                if namespaceReferent = null then null\n                else\n                  let template = classReferent.template() in\n                  let className = classReferent.name() in\n                  let operationName = self.name() in\n                  let implClassReferent = \n                    namespaceReferent.ownedMembers()->\n                    select(name() = \'Impl\' and isPackage()).\n                    ownedMembers()->\n                    select(name() = className and isClass())\n                  in\n                  let boundClassReferent =\n                    if classReferent.template() = null or\n                      implClassReferent->exists(not isTemplate()) then \n                      implClassReferent\n                    else \n                      -- TODO: Check that template parameters match.\n                      implClassReferent.bind(\n                        classReferent.templateActuals()->asSequence()\n                      )\n                    endif\n                  in\n                  let implOperationReferent =\n                    boundClassReferent.ownedMembers()->\n                    select(name() = operationName and isOperation())\n                  in\n                    if implOperationReferent->size() <> 1 then null\n                    else implOperationReferent->any(true)\n                    endif\n                endif\n            endif\n\t\t\t\tendif'"
	 * @generated
	 */
	ElementReference constructorReference();

} // ElementReference
