/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A syntax element synthesized in an abstract syntax tree, along with any additional information determined during static semantic analysis.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SyntaxElement#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSyntaxElement()
 * @model abstract="true"
 * @generated
 */
public interface SyntaxElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element to consider the owner of this element, if this element
	 * does not have a composite container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(SyntaxElement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSyntaxElement_Owner()
	 * @model
	 * @generated
	 */
	SyntaxElement getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SyntaxElement#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SyntaxElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return a reference to this element.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='InternalElementReference{element = self}'"
	 * @generated
	 */
	ElementReference toReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the owner of this element.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='SyntaxElement_owner()'"
	 * @generated
	 */
	SyntaxElement owner();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let container = self.oclContainer() in\n          if container = null or not container.oclIsKindOf(SyntaxElement) then\n            self.owner\n          else\n            container.oclAsType(SyntaxElement)\n          endif'"
	 * @generated
	 */
	SyntaxElement SyntaxElement_owner();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the current scope for this element. By default, this is the current
	 * scope of the owner of this element, if any.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.SyntaxElement_currentScope()'"
	 * @generated
	 */
	ElementReference currentScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let owner = self.owner() in\n          if owner = null then null\n          else owner.currentScope()\n          endif'"
	 * @generated
	 */
	ElementReference SyntaxElement_currentScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the enclosing statement for this element, if there is one.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let owner = self.owner() in\n          if owner = null or owner.oclIsKindOf(MemberDefinition) then null\n          else if owner.oclIsKindOf(Statement) then owner.oclAsType(Statement)\n          else owner.enclosingStatement()\n          endif endif'"
	 * @generated
	 */
	Statement enclosingStatement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the enclosing expression for this element, if there is one.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let owner = self.owner() in\n          if owner = null or owner.oclIsKindOf(MemberDefinition) or\n            owner.oclIsKindOf(Statement) then null\n          else if owner.oclIsKindOf(Expression) then owner.oclAsType(Expression)\n          else owner.enclosingExpression()\n          endif endif'"
	 * @generated
	 */
	Expression enclosingExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the assignments before this element, as appropriate.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.SyntaxElement_assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<AssignedSource> SyntaxElement_assignmentsBefore();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let owner = self.owner() in\n          if owner = null then Set(AssignedSource){}\n          else owner.assignmentsBefore(self)\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> SyntaxElement_assignmentsBefore_base();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the assignments before the given subelement of this element,
	 * if any, as appropriate. (By default, by default they are are the
	 * assignments before this element.)
	 * <!-- end-model-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Update the initial set of assignments with all the assigned sources in
	 * newAssignments.
	 * <!-- end-model-doc -->
	 * @model ordered="false" assignmentsMany="true" assignmentsOrdered="false" newAssignmentsMany="true" newAssignmentsOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        newAssignments->iterate(\n          assignment, updatedAssignments : Set(AssignedSource) = assignments |\n          assignment.update(updatedAssignments)\n        )'"
	 * @generated
	 */
	EList<AssignedSource> updateAll(EList<AssignedSource> assignments, EList<AssignedSource> newAssignments);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the effective common ancestor of a set of classifiers.
	 * <!-- end-model-doc -->
	 * @model classifiersMany="true" classifiersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if classifiers->isEmpty() or classifiers->exists(c | c = null) then null\n        else\n          let classifierSet = self.removeDuplicateElements(classifiers->asBag()) in\n            if classifierSet->size() = 1 then classifierSet->any(true)\n            else\n              let ancestors = self.commonAncestors(classifierSet) in\n              let parents = ancestors.allParents() in\n                self.commonAncestor(ancestors->reject(containedIn(parents)))\n            endif \n        endif'"
	 * @generated
	 */
	ElementReference commonAncestor(EList<ElementReference> classifiers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" classifiersMany="true" classifiersOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let ancestors : Bag(ElementReference) = \n          classifiers.allParents()->union(classifiers) in\n          self.removeDuplicateElements(\n            ancestors->select(countIn(ancestors) = classifiers->size())\n          )'"
	 * @generated
	 */
	EList<ElementReference> commonAncestors(EList<ElementReference> classifiers);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementsUnique="false" elementsMany="true" elementsOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        elements->iterate(e, bag : Bag(ElementReference) = Bag{} |\n          if e.containedIn(bag) then bag\n          else bag->including(e)\n          endif\n        )->asSet()'"
	 * @generated
	 */
	EList<ElementReference> removeDuplicateElements(EList<ElementReference> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" pathNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let currentScope = self.currentScope() in\n          if currentScope = null then Set(ElementReference){}\n          else\n            let modelScope = currentScope.modelScope() in\n              if modelScope = null then Set(ElementReference){}\n              else modelScope.resolvePathName(\'Alf::Library::\' + pathName)\n              endif\n          endif'"
	 * @generated
	 */
	EList<ElementReference> resolveInLibrary(String pathName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNameRequired="true"
	 * @generated
	 */
	ElementReference primitiveType(String typeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.resolveInLibrary(\'PrimitiveTypes::\' + typeName)->\n            select(isPrimitiveType()) in\n          if referents->isEmpty() then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference primitiveType_(String typeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'Boolean\')'"
	 * @generated
	 */
	ElementReference booleanType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.booleanType())'"
	 * @generated
	 */
	boolean isBooleanType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'Integer\')'"
	 * @generated
	 */
	ElementReference integerType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.integerType())'"
	 * @generated
	 */
	boolean isIntegerType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'String\')'"
	 * @generated
	 */
	ElementReference stringType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.stringType())'"
	 * @generated
	 */
	boolean isStringType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'UnlimitedNatural\')'"
	 * @generated
	 */
	ElementReference unlimitedNaturalType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.unlimitedNaturalType())'"
	 * @generated
	 */
	boolean isUnlimitedNaturalType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'BitString\')'"
	 * @generated
	 */
	ElementReference bitStringType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.bitStringType())'"
	 * @generated
	 */
	boolean isBitStringType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primitiveType(\'Natural\')'"
	 * @generated
	 */
	ElementReference naturalType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='element <> null and element.conformsTo(self.naturalType())'"
	 * @generated
	 */
	boolean isNaturalType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isIntegerType(element) or \n            self.isUnlimitedNaturalType(element) or \n            self.isNaturalType(element)'"
	 * @generated
	 */
	boolean isNumericType(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.resolveInLibrary(\'CollectionFunctions::add\')->\n            select(isBehavior()) in\n          if referents->isEmpty() then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference collectionFunctionAdd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let template = element.template() in\n          template <> null and\n            let collectionClasses = self.resolveInLibrary(\'CollectionClasses\') in\n              collectionClasses->notEmpty() and\n                collectionClasses->any(true).equals(template.namespace())'"
	 * @generated
	 */
	boolean isCollectionClass(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isCollectionClass(element) and \n        self.isIntegerType(element.collectionArgument())'"
	 * @generated
	 */
	boolean isIntegerCollectionClass(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isCollectionClass(element) and \n        self.isBitStringType(element.collectionArgument())'"
	 * @generated
	 */
	boolean isBitStringCollectionClass(ElementReference element);

} // SyntaxElement
