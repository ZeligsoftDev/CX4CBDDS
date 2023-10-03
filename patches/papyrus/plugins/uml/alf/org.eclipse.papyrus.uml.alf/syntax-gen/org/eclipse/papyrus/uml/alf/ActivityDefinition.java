/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of an activity, with any formal parameters defined as owned members.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ActivityDefinition#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getActivityDefinition()
 * @model
 * @generated
 */
public interface ActivityDefinition extends ClassifierDefinition {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of statements that defines the behavior of the activity (empty for a stub).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getActivityDefinition_Body()
	 * @model containment="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ActivityDefinition#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the body of an activity definition include an
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
	 * This is necessary because, for Xtext parsing, ActiveClassDefinition::classifierBehavior is
	 * composite and the classifierBehavior is not also added as a member of its active class.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                                let owner = self.oclContainer() in\n                                  if owner.oclIsKindOf(ActiveClassDefinition) and \n                                    owner.oclAsType(ActiveClassDefinition).classifierBehavior = self then\n                                    owner.oclAsType(ActiveClassDefinition).toReference()\n                                  else\n                                    self.NamespaceDefinition_outerScope()\n                                  endif'"
	 * @generated
	 */
	ElementReference outerScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed for classifiers in general, an activity definition allows
	 * @primitive annotations and any stereotype whose metaclass is consistent with Activity.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow activity stereotype annotations. \052/\n                        self.ClassifierDefinition_annotationAllowed(annotation) or\n                        annotation.stereotypeName.pathName = \'primitive\''"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this activity definition considered
	 * as a classifier definition and the subunit is for an activity definition. In addition,
	 * the subunit definition must have formal parameters that match each of the formal parameters
	 * of the stub definition, in order. Two formal parameters match if they have the same
	 * direction, name, multiplicity bounds, ordering, uniqueness and type reference.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                                self.ClassifierDefinition_matchForStub(unit) and\n                                let definition = unit.definition in\n                                  definition.oclIsKindOf(ActivityDefinition) and\n                                  let parameters = self.parameters() in\n                                  let otherParameters = definition.parameters() in\n                                    parameters->size() = otherParameters->size() and \n                                    Sequence{1 .. parameters->size()}->forAll(i | \n                                      parameters->at(i).matches(otherParameters->at(i))\n                                    ) and\n                                  let returnParameter = self.returnParameter() in\n                                  let otherReturnParameter = definition.returnParameter() in\n                                    returnParameter = null and otherReturnParameter = null or\n                                    returnParameter <> null and returnParameter.matches(otherReturnParameter)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either an ActivityDefinition or an
	 * imported member whose referent is an ActivityDefinition or an Activity.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isActivity()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An activity definition may not have a specialization list.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specialization = null'"
	 * @generated
	 */
	boolean activityDefinitionSpecialization(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an activity definition is primitive, then it must have a body that is empty.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.isPrimitive implies self.body = null'"
	 * @generated
	 */
	boolean activityDefinitionPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ActivityDefinition
