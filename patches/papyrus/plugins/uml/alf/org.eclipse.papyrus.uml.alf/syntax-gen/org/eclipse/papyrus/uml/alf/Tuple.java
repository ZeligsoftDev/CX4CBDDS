/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of expressions used to provide the arguments for an invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Tuple#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Tuple#getInvocation <em>Invocation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Tuple#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTuple()
 * @model abstract="true"
 * @generated
 */
public interface Tuple extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.InputNamedExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expressions from this tuple, matched to the input parameters
	 * (direction in and inout) of the invocation. An empty sequence construction
	 * expression is included for any input parameter that is not explicitly
	 * matched in the tuple.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTuple_Input()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.inputCached()'"
	 * @generated
	 */
	EList<InputNamedExpression> getInput();

	/**
	 * Returns the value of the '<em><b>Invocation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.InvocationExpression#getTuple <em>Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The invocation expression of which this tuple is a part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Invocation</em>' container reference.
	 * @see #setInvocation(InvocationExpression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTuple_Invocation()
	 * @see org.eclipse.papyrus.uml.alf.InvocationExpression#getTuple
	 * @model opposite="tuple" required="true" transient="false"
	 * @generated
	 */
	InvocationExpression getInvocation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Tuple#getInvocation <em>Invocation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation</em>' container reference.
	 * @see #getInvocation()
	 * @generated
	 */
	void setInvocation(InvocationExpression value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.OutputNamedExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expressions from this tuple, matched to the output parameters
	 * (direction inout and out) of the invocation. An empty sequence construction
	 * expression is included for any output parameter that is not explicitly
	 * matched in the tuple.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTuple_Output()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.outputCached()'"
	 * @generated
	 */
	EList<OutputNamedExpression> getOutput();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger size();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<InputNamedExpression> inputCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.inputFor(self.invocation.parameter)'"
	 * @generated
	 */
	EList<InputNamedExpression> input();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 * @generated
	 */
	EList<InputNamedExpression> inputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<OutputNamedExpression> outputCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.outputFor(self.invocation.parameter)'"
	 * @generated
	 */
	EList<OutputNamedExpression> output();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 * @generated
	 */
	EList<OutputNamedExpression> outputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model expressionRequired="true"
	 * @generated
	 */
	OutputNamedExpression outputForExpression(Expression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n--        let assignmentsBefore = self.assignmentsBefore() in\n--          if not element.oclIsKindOf(NameExpression) then assignmentsBefore\n--          else\n--            let output = self.outputForExpression(element.oclAsType(NameExpression)) in\n--              if output = null then assignmentsBefore\n--              else self.updateFor(assignmentsBefore, output)\n--              endif\n--          endif;\n        self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignments1 = self.updateAll(\n          self.assignmentsBefore(),\n          self.input.expression->union(self.output.expression).newAssignments()->asSet()\n        ) in\n        let assignments2 = self.output->iterate(\n          output, assignments : Set(AssignedSource) = assignments1 |\n          self.updateFor(assignments, output)\n        ) in\n          self.updateAll(\n            assignments2,\n            self.output->reject(leftHandSide = null)->\n              collect(output : OutputNamedExpression | \n                assignments2->select(name = output.leftHandSide.assignedName())\n              )->\n              reject(isParallelLocalName).copy(self.invocation, null)->asSet()\n           )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignmentsBefore = self.assignmentsBefore() in\n          self.assignmentsAfter()->select(isNew(assignmentsBefore()))'"
	 * @generated
	 */
	EList<AssignedSource> newAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" assignmentsMany="true" assignmentsOrdered="false" outputRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let parameter = self.invocation.parameterNamed(output.name) in\n          if parameter = null or parameter.direction() <> \'out\' then \n            assignments\n          else\n            let lhs = output.leftHandSide in\n              if lhs = null or lhs.localName() = null or lhs.index() <> null or \n                assignments->exists(name = lhs.localName()) then \n                assignments\n              else\n                AssignedSource{\n                  name = lhs.localName(),\n                  source = self,\n                  type = parameter.type(),\n                  lower = 0,\n                  upper = if parameter.upper() = 1 then 1 else -1 endif\n                }.update(assignments)\n              endif\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> updateFor(EList<AssignedSource> assignments, OutputNamedExpression output);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A tuple has the same number of inputs as its invocation has input
	 * parameters. For each input parameter, the tuple has a corresponding input
	 * with the same name as the parameter and an expression that is the
	 * matching argument from the tuple, or an empty sequence construction
	 * expression if there is no matching argument.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean tupleInputDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A tuple has the same number of outputs as its invocation has output
	 * parameters. For each output parameter, the tuple has a corresponding
	 * output with the same name as the parameter and an expression that is the
	 * matching argument from the tuple, or an empty sequence construction
	 * expression if there is no matching argument.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean tupleOutputDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An input parameter may only have a null argument if it has a multiplicity
	 * lower bound of 0.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.input->forAll(\n          expression.isNull() implies \n            self.invocation.parameterNamed(name).lower() = 0\n        )'"
	 * @generated
	 */
	boolean tupleNullInputs(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An output parameter may only have a null argument if it is an out parameter.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.output->forAll(\n          expression.isNull() implies \n            self.invocation.parameterNamed(name).direction() = \'out\'\n        )'"
	 * @generated
	 */
	boolean tupleOutputs(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before each expression in a tuple are the same as the
	 * assignments before the tuple, except in the case of a name expression
	 * that defines a new local name, in which case the assigned source for the
	 * new name is included in the assignments before the name expression. (Note
	 * that the assigned source for a new name is included before the name
	 * expression so that the nameExpressionResolution constraint is not
	 * violated.) The assignments before the tuple are the same as the
	 * assignments after the feature reference of the invocation of the tuple,
	 * if the invocation has one, or otherwise the assignments before the
	 * invocation.
	 * 
	 * CHANGE: An assignment before is NOT given to a name expression that
	 * that defines a local name. Instead the nameExpressionResolution
	 * constraint has been modified. (This avoids a potential infinite recursion
	 * in InvocationExpression::bindTemplateImplicitArguments().)
	 * 
	 * (See also the InvocationExpression::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean tupleAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A name may be assigned in at most one argument expression of a tuple.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.input.expression->union(self.output.expression).\n          newAssignments()->isUnique(name)'"
	 * @generated
	 */
	boolean tupleAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Tuple
