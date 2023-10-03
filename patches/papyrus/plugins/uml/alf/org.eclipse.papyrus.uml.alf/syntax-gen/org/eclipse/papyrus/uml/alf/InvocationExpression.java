/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression denoting the invocation of a behavior or operation, or the
 * sending of a signal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsBehavior <em>Is Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsAssociationEnd <em>Is Association End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsOperation <em>Is Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsDestructor <em>Is Destructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsSignal <em>Is Signal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression()
 * @model abstract="true"
 * @generated
 */
public interface InvocationExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Is Behavior</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is a behavior invocation or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Behavior</em>' attribute.
	 * @see #setIsBehavior(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsBehavior()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='OutputNamedExpression' unique='false' upper='*'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent <> null and referent.isBehavior()'"
	 * @generated
	 */
	boolean isIsBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsBehavior <em>Is Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Behavior</em>' attribute.
	 * @see #isIsBehavior()
	 * @generated
	 */
	void setIsBehavior(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Association End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an association read or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Association End</em>' attribute.
	 * @see #setIsAssociationEnd(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsAssociationEnd()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent<> null and referent.isAssociationEnd()'"
	 * @generated
	 */
	boolean isIsAssociationEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsAssociationEnd <em>Is Association End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Association End</em>' attribute.
	 * @see #isIsAssociationEnd()
	 * @generated
	 */
	void setIsAssociationEnd(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For an invocation of a feature, the reference to that feature. This
	 * property is set for a feature invocation expression or for an expression
	 * initially parsed as a behavior invocation expression that disambiguates
	 * to a feature invocation expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(FeatureReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_Feature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.feature()'"
	 * @generated
	 */
	FeatureReference getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeatureReference value);

	/**
	 * Returns the value of the '<em><b>Is Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an operation call or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Operation</em>' attribute.
	 * @see #setIsOperation(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsOperation()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent<> null and referent.isOperation()'"
	 * @generated
	 */
	boolean isIsOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsOperation <em>Is Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Operation</em>' attribute.
	 * @see #isIsOperation()
	 * @generated
	 */
	void setIsOperation(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Destructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is an operation call, whether the operation is a destructor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Destructor</em>' attribute.
	 * @see #setIsDestructor(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsDestructor()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent<> null and referent.isDestructor()'"
	 * @generated
	 */
	boolean isIsDestructor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsDestructor <em>Is Destructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Destructor</em>' attribute.
	 * @see #isIsDestructor()
	 * @generated
	 */
	void setIsDestructor(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an implicit object destruction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Implicit</em>' attribute.
	 * @see #setIsImplicit(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsImplicit()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let feature = self.feature in\n          if feature = null then false\n          else\n            let nameBinding = feature.nameBinding in\n            let referent = self.referent in\n              nameBinding <> null and referent = null and\n              nameBinding.toName() = \'destroy\' and\n              nameBinding.binding = null\n          endif'"
	 * @generated
	 */
	boolean isIsImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsImplicit <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Implicit</em>' attribute.
	 * @see #isIsImplicit()
	 * @generated
	 */
	void setIsImplicit(boolean value);

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The behavior, operation or signal being invoked. The derivation of this
	 * property is specific to each kind of invocation expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='referentCached()'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element references to the parameters of the referent, in order.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_Parameter()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.parameterElements()'"
	 * @generated
	 */
	EList<ElementReference> getParameter();

	/**
	 * Returns the value of the '<em><b>Is Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is a signal send or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Signal</em>' attribute.
	 * @see #setIsSignal(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_IsSignal()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent <> null and referent.isSignal()'"
	 * @generated
	 */
	boolean isIsSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#isIsSignal <em>Is Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Signal</em>' attribute.
	 * @see #isIsSignal()
	 * @generated
	 */
	void setIsSignal(boolean value);

	/**
	 * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.Tuple#getInvocation <em>Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tuple for the invocation expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tuple</em>' containment reference.
	 * @see #setTuple(Tuple)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInvocationExpression_Tuple()
	 * @see org.eclipse.papyrus.uml.alf.Tuple#getInvocation
	 * @model opposite="invocation" containment="true" required="true"
	 * @generated
	 */
	Tuple getTuple();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getTuple <em>Tuple</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuple</em>' containment reference.
	 * @see #getTuple()
	 * @generated
	 */
	void setTuple(Tuple value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature() in\n          if feature <> null and self.tuple = element then feature.assignmentAfter\n          else self.assignmentBefore\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.InvocationExpression_type()'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent = null then null\n          else referent.type()\n          endif'"
	 * @generated
	 */
	ElementReference InvocationExpression_type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.InvocationExpression_upper()'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent = null then 0\n          else referent.upper()\n          endif'"
	 * @generated
	 */
	BigInteger InvocationExpression_upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.InvocationExpression_lower()'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent = null then 0\n          else referent.lower()\n          endif'"
	 * @generated
	 */
	BigInteger InvocationExpression_lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameter = self.parameter->select(p | p.name() = name) in\n          if parameter->isEmpty() then null\n          else parameter->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference parameterNamed(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameters = self.parameter in\n          if parameters->exists(direction() = \'return\') then\n            parameters->size()-1\n          else\n            parameters->size()\n          endif'"
	 * @generated
	 */
	BigInteger parameterCount();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" inputRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameter = self.parameterNamed(input.name) in\n        let direction = parameter.direction() in\n          (direction = \'in\' or direction = \'inout\') and\n          parameter.isAssignableFrom(input.expression)'"
	 * @generated
	 */
	boolean parameterIsAssignableFrom(InputNamedExpression input);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" outputRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameter = self.parameterNamed(output.name) in\n        let direction = parameter.direction() in\n        let lhs = output.leftHandSide in\n          direction = \'out\' and lhs.referent = null or\n          (direction = \'out\' or direction = \'inout\') and\n          output.expression.isAssignableFromElement(parameter)'"
	 * @generated
	 */
	boolean parameterIsAssignableTo(OutputNamedExpression output);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n        let currentScope = self.currentScope() in\n          referent <> null and referent.isConstructor() and currentScope <> null implies\n          let operation = currentScope.specification() in\n            operation.isConstructor() and\n            let statement = self.enclosingStatement() in\n              statement <> null and statement.oclIsKindOf(ExpressionStatement) and\n                let annotatedStatement = statement.owner() in\n                let owner = annotatedStatement.owner() in\n                  owner <> null implies owner.oclIsKindOf(Block) and\n                    let block = owner.oclAsType(Block) in\n                      block.enclosingStatement() = null and\n                      block.statement->notEmpty() and\n                      block.statement->at(1) = annotatedStatement and\n                      -- NOTE: This ensures that the invoked constructor is\n                      -- from the same class as the containing constructor.\n                      operation.namespace().equals(referent.namespace()) and\n                      -- NOTE: An alternative constructor invocation should\n                      -- only be allowed on \"this\".\n                      self.feature().expression.oclIsKindOf(ThisExpression)'"
	 * @generated
	 */
	boolean alternativeConstructorIsValid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model referentRequired="true"
	 * @generated
	 */
	ElementReference bindTemplateImplicitArguments(ElementReference referent, Expression primary);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model referentRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let allParameters = referent.parameters() in\n        let firstParameter =\n          if primary = null or allParameters->isEmpty() then null\n          else allParameters->first()\n          endif\n        in\n        let firstParameterType =\n          if firstParameter = null then null\n          else firstParameter.type()\n          endif\n        in\n        let primaryType =\n          if firstParameter = null then null\n          else self.effectiveType(firstParameter, primary)\n          endif\n        in\n        let parameters =\n          if firstParameter = null then allParameters\n          else allParameters->excluding(firstParameter)\n          endif\n        in\n        let templateArguments =\n          referent.parameteredElements()->collect(parameteredElement |\n            let inputTypes =\n              self.tuple.inputFor(parameters)->\n                select(input |\n                  let parameter = parameters->any(name() = input.name) in\n                    parameteredElement.equals(parameter.type())\n                )->\n                collect(input | \n                  let parameter = parameters->any(name() = input.name) in\n                    self.effectiveType(parameter, input.expression)\n                )->asSet()\n            in\n            let types =\n              if parameteredElement.equals(firstParameterType) then\n                inputTypes->including(primaryType)\n              else\n                inputTypes\n              endif\n            in\n            let commonAncestor = self.commonAncestor(types) in\n              if commonAncestor = null then AnyType{}.toReference()\n              else commonAncestor\n              endif\n          )\n        in\n          referent.bind(templateArguments)'"
	 * @generated
	 */
	ElementReference bindTemplateImplicitArguments1(ElementReference referent, Expression primary);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If collection conversion would be required, return the toSequence
	 * return type, rather than the expression type.
	 * <!-- end-model-doc -->
	 * @model required="true" parameterRequired="true" expressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = expression.type in\n        let parameterUpper = parameter.upper() in\n          if (parameterUpper = -1 or parameterUpper > 1) and\n                expression.upper = 1 and\n                type <> null and self.isCollectionClass(type) then\n            type.collectionArgument()\n          else\n            type\n          endif'"
	 * @generated
	 */
	ElementReference effectiveType(ElementReference parameter, Expression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns references to the elements that act as the parameters of the
	 * referent. If the referent is a behavior or operation, these are the owned
	 * parameters, in order. If the referent is an association end, then the
	 * parameters are the other association ends of the association of the
	 * referent end, which are treated as if they were in parameters. Otherwise
	 * (by default), they are any properties of the referent (e.g., signal
	 * attributes), which are treated as if they were in parameters. (This is
	 * defined as a helper operation, so that it can be overridden by subclasses
	 * of InvocationExpression, if necessary.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='InvocationExpression_parameterElements()'"
	 * @generated
	 */
	EList<ElementReference> parameterElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if self.isBehavior or self.isOperation then\n            referent.parameters()\n          else if self.isAssociationEnd then\n            let association = referent.association() in\n              association.associationEnds()->reject(equals(referent))->\n                collect(p | self.parameterFromPropertyWithMultiplicity(p, \'1\', \'1\'))->asOrderedSet()\n          else if referent <> null then\n              referent.properties()->\n                collect(p | self.parameterFromProperty(p))->asOrderedSet()   \n          else\n            OrderedSet(ElementReference){}\n          endif endif endif'"
	 * @generated
	 */
	EList<ElementReference> InvocationExpression_parameterElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" propertyRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.parameterFromPropertyWithMultiplicity(\n          property, \n          property.lower().toString(), \n          let upper = property.upper() in\n            if upper = -1 then \'*\'\n            else upper.toString()\n            endif\n        )'"
	 * @generated
	 */
	ElementReference parameterFromProperty(ElementReference property);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" propertyRequired="true" lowerRequired="true" upperRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        FormalParameter{\n            name = property.name(),\n            direction = \'in\',\n            typePart = TypedElementDefinition{\n              actualType = property.type(),\n              lowerBound = lower,\n              upperBound = upper\n            },\n            owner = property.namespace().asMember()\n        }.toReference()'"
	 * @generated
	 */
	ElementReference parameterFromPropertyWithMultiplicity(ElementReference property, String lower, String upper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference referentCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is a behavior invocation if its referent is a
	 * behavior.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsBehaviorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is an association end read if its referent is an
	 * association end.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsAssociationEndDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is an operation call if its referent is an
	 * operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsOperationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is a destructor call either implicitly or if it
	 * is an explicit operation call to a destructor operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsDestructorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is an implicit object destruction if it has a
	 * feature with the name "destroy" and no explicit referents.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsImplicitDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invocation expression is a signal send if its referent is a signal.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionIsSignalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters of an invocation expression are given by the result of the
	 * parameterElements helper operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionParameterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent of an invocationExpression is an operation or behavior
	 * with a return parameter, then the type of the expression is that of the
	 * return parameter (if any). If the referent is a classifier, then the type
	 * is the referent. If the referent is a property, then the type is that of
	 * the property. Otherwise the expression has no type.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent of an invocationExpression is an operation or behavior
	 * with a return parameter, then the upper bound of the expression is that
	 * of the return parameter. If the referent is a classifier, then the upper
	 * bound is 1. If the referent is a property, then the upper bound is that
	 * of the property. Otherwise the upper bound is 0.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent of an invocationExpression is an operation or behavior
	 * with a return parameter, then the lower bound of the expression is that
	 * of the return parameter. If the referent is a classifier, then the lower
	 * bound is 1. If the referent is a property, then the lower bound is that
	 * of the property. Otherwise the lower bound is 0.
	 * (see the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the target expression of the feature reference of
	 * an invocation expression (if any) are the same as the assignments before
	 * the invocation expression.
	 * (See the SyntaxElement::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean invocationExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after an invocation expression are the same as those
	 * after the tuple of the expression.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.tuple.assignmentsAfter()'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO: Add this constraint to the standard.
	 * if the referent is an implicit template binding, then all the template
	 * parameters must be for classifiers and the actuals conform to any
	 * constraining classifiers.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let referent = self.referent in\n        referent <> null implies\n          let template = referent.template() in\n            template <> null implies \n              let parameters = template.templateParameters() in\n              let actuals = referent.templateActuals() in\n                parameters->size() = actuals->size() and\n                parameters->size() <> 0 implies\n                  Sequence{1..parameters->size()}->forAll(i |\n                    let parameter = parameters->at(i) in\n                    let actual = actuals->at(i) in\n                      parameter.isClassifierTemplateParameter() and\n                      parameter.parents()->forAll(p | actual.conformsTo(p))\n                    )'"
	 * @generated
	 */
	boolean invocationExpressionTemplateParameters(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InvocationExpression
