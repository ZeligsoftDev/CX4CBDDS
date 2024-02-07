/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an element as bound within a template instantiation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getTemplateBinding <em>Template Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundElementReference()
 * @model
 * @generated
 */
public interface BoundElementReference extends ElementReference {
	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referent</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundElementReference_Referent()
	 * @model required="true"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' reference.
	 * @see #setNamespace(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundElementReference_Namespace()
	 * @model
	 * @generated
	 */
	ElementReference getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getNamespace <em>Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Template Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Binding</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Binding</em>' reference.
	 * @see #setTemplateBinding(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBoundElementReference_TemplateBinding()
	 * @model required="true"
	 * @generated
	 */
	ElementReference getTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BoundElementReference#getTemplateBinding <em>Template Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Binding</em>' reference.
	 * @see #getTemplateBinding()
	 * @generated
	 */
	void setTemplateBinding(ElementReference value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.asMember()'"
	 * @generated
	 */
	SyntaxElement asAlf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        Member{\n          visibility = self.visibility(),\n          definition = ImportedMember{\n            name = self.name(),\n            referent = self.referent\n          }\n        }'"
	 * @generated
	 */
	Member asMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isSameKindAs(member)'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isNamespace()'"
	 * @generated
	 */
	boolean isNamespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isPackage()'"
	 * @generated
	 */
	boolean isPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isProfile()'"
	 * @generated
	 */
	boolean isProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isPackageableElement()'"
	 * @generated
	 */
	boolean isPackageableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isClassifier()'"
	 * @generated
	 */
	boolean isClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isAbstractClassifier()'"
	 * @generated
	 */
	boolean isAbstractClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isAssociation()'"
	 * @generated
	 */
	boolean isAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isDataType()'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isClass()'"
	 * @generated
	 */
	boolean isClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isActiveClass()'"
	 * @generated
	 */
	boolean isActiveClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isSignal()'"
	 * @generated
	 */
	boolean isSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isEnumeration()'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isBehavior()'"
	 * @generated
	 */
	boolean isBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isActivity()'"
	 * @generated
	 */
	boolean isActivity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isMethod()'"
	 * @generated
	 */
	boolean isMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isPrimitiveType()'"
	 * @generated
	 */
	boolean isPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isReception()'"
	 * @generated
	 */
	boolean isReception();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isOperation()'"
	 * @generated
	 */
	boolean isOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isConstructor()'"
	 * @generated
	 */
	boolean isConstructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isDestructor()'"
	 * @generated
	 */
	boolean isDestructor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isFeature()'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isProperty()'"
	 * @generated
	 */
	boolean isProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isAssociationEnd()'"
	 * @generated
	 */
	boolean isAssociationEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isParameter()'"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplateBinding() then\n          self.templateBinding.isTemplate()\n        else\n          self.referent.isTemplate()\n        endif'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isClassifierTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isParameteredElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isStereotype()'"
	 * @generated
	 */
	boolean isStereotype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isEnumerationLiteral()'"
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
	 * @model required="true" otherRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isDistinguishableFrom(other)'"
	 * @generated
	 */
	boolean isDistinguishableFrom(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.name()'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.visibility()'"
	 * @generated
	 */
	String visibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferencesTo(\n          self.referent.ownedMembers()->reject(isTemplateParameter())\n        )->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> ownedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferencesTo(\n          self.referent.members()->reject(isTemplateParameter())\n        )->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> members();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.boundReferencesTo(self.referent.nestedClassifiers())->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> nestedClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.boundReferencesTo(self.referent.properties())->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> properties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.boundReferencesTo(self.referent.associationEnds())->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> associationEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferenceTo(self.referent.opposite())'"
	 * @generated
	 */
	ElementReference opposite();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferenceTo(self.referent.signal())'"
	 * @generated
	 */
	ElementReference signal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferencesTo(self.referent.parameters())->asOrderedSet()'"
	 * @generated
	 */
	EList<ElementReference> parameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferenceTo(self.referent.returnParameter())'"
	 * @generated
	 */
	ElementReference returnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferenceTo(self.referent.specification())'"
	 * @generated
	 */
	ElementReference specification();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.redefinedOperations()'"
	 * @generated
	 */
	EList<ElementReference> redefinedOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.namespace <> null then self.namespace\n        else\n          let namespace = self.referent.namespace() in\n            if self.template() <> null then namespace\n            else self.boundReferenceTo(namespace)\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference namespace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplateBinding() then self.referent\n        else null\n        endif'"
	 * @generated
	 */
	ElementReference template();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='OrderedSet(ElementReference){}'"
	 * @generated
	 */
	EList<ElementReference> templateParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='OrderedSet(ElementReference){}'"
	 * @generated
	 */
	EList<ElementReference> parameteredElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.templateBinding.template().equals(self.referent)'"
	 * @generated
	 */
	boolean isTemplateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isTemplateBinding() then self.templateBinding.templateActuals()\n        else OrderedSet(ElementReference){}\n        endif'"
	 * @generated
	 */
	EList<ElementReference> templateActuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.direction()'"
	 * @generated
	 */
	String direction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isAssociationEnd() then self.namespace()\n        else null\n        endif'"
	 * @generated
	 */
	ElementReference association();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = self.referent.type() in\n          -- This handles the special case of a constructor of a template class\n          -- that has that class directly as its return type, rather than a\n          -- template binding for it.\n          if self.isConstructor() and \n            self.templateBinding.template().equals(type) then\n            type.bind(self.templateBinding.templateActuals()->asSequence())\n          else\n            self.boundReferenceTo(type)\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.lower()'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.upper()'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isOrdered()'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isNonunique()'"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferencesTo(self.referent.parents()->asOrderedSet())->asSet()'"
	 * @generated
	 */
	EList<ElementReference> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.boundReferencesTo(self.referent.allParents()->asOrderedSet())->asSet()'"
	 * @generated
	 */
	EList<ElementReference> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.classifierBehavior()'"
	 * @generated
	 */
	ElementReference classifierBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.appliedProfiles()'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent'"
	 * @generated
	 */
	ElementReference reference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.templateBinding'"
	 * @generated
	 */
	ElementReference templateBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isActivity() then self\n        else null\n        endif'"
	 * @generated
	 */
	ElementReference activeClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.boundReferenceTo(self.referent.context())'"
	 * @generated
	 */
	ElementReference context();

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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other = null or\n        self.isClassifier() and (self.equals(other) or\n        self.parents()->exists(conformsTo(other)))'"
	 * @generated
	 */
	boolean conformsTo(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        other <> null and\n        other.oclIsKindOf(BoundElementReference) and\n        self.templateBinding.equals(other.templateBinding()) and\n        self.referent.equals(other.oclAsType(BoundElementReference).referent)'"
	 * @generated
	 */
	boolean equals(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        BoundElementReference{\n          referent = self.referent,\n          namespace = self.namespace,\n          templateBinding = self.templateBinding\n        }'"
	 * @generated
	 */
	ElementReference copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.modelScope()'"
	 * @generated
	 */
	ElementReference modelScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Set(ElementReference){}'"
	 * @generated
	 */
	EList<ElementReference> resolvePathName(String pathName);

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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Set(ElementReference){}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	ElementReference stubFor(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference boundReferenceTo(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if element = null then null\n        else if not element.isNamedElement() then element\n        else if element.isTemplateBinding() then\n          let actuals = self.boundReferencesTo(element.templateActuals()) in\n            element.template().bind(actuals)\n        else if element.isParameteredElement() then\n          let parameters = \n            self.templateBinding.template().parameteredElements()->asSequence() in\n          let i = element.positionIn(parameters) in\n            if i > 0 then\n              self.templateBinding.templateActuals()->at(i)\n            else\n              element\n            endif\n        else\n          let elementTemplateBinding = element.templateBinding() in\n            if elementTemplateBinding = null then \n              if self.referent.equals(element.namespace()) then\n                BoundElementReference{\n                  referent = element,\n                  namespace = self,\n                  templateBinding = self.templateBinding\n                  }\n              else if self.templateBinding.template().containsMember(element) then\n                BoundElementReference{\n                  referent = element,\n                  namespace = null,\n                  templateBinding = self.templateBinding\n                }\n              else\n                element\n              endif endif\n            else if not elementTemplateBinding.equals(self.templateBinding) then\n              BoundElementReference{\n                referent = element.reference(),\n                namespace = null,\n                templateBinding = \n                  self.boundReferenceTo(elementTemplateBinding).templateBinding()\n              }\n            else\n              element\n            endif endif\n        endif endif endif endif'"
	 * @generated
	 */
	ElementReference boundReferenceTo1(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" elementsMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='elements->collect(element | self.boundReferenceTo(element))'"
	 * @generated
	 */
	EList<ElementReference> boundReferencesTo(EList<ElementReference> elements);

} // BoundElementReference
