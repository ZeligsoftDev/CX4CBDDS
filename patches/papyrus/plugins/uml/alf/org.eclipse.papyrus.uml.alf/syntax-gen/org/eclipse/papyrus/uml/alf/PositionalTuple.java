/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Positional Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A tuple in which the arguments are matched to parameters in order by position.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PositionalTuple#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPositionalTuple()
 * @model
 * @generated
 */
public interface PositionalTuple extends Tuple {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expressions for this tuple, to be matched by position to the invocation parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPositionalTuple_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression->size()'"
	 * @generated
	 */
	BigInteger size();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if parameters->isEmpty() then Set(InputNamedExpression){}\n        else\n          Set{1..parameters->size()}->select(i |\n            let direction = parameters->at(i).direction() in\n              direction = \'in\' or direction = \'inout\'                    \n          )->collect(i : Integer | \n            InputNamedExpression{\n              name = parameters->at(i).name(),\n              expression = \n                if i <= self.size() then\n                  self.expression->at(i)\n                else\n                  SequenceConstructionExpression{\n                    hasMultiplicity = true,\n                    owner = self\n                  }\n                endif,\n              owner = self\n            }\n          )->asSet()\n        endif'"
	 * @generated
	 */
	EList<InputNamedExpression> inputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if parameters->isEmpty() then Set(OutputNamedExpression){}\n        else\n          Set{1..parameters->size()}->select(i |\n            let direction = parameters->at(i).direction() in\n              -- NOTE: This allows missing arguments for out parameters.\n              direction = \'out\' and i <= self.size() or \n              direction = \'inout\'              \n          )->collect(i : Integer | \n            OutputNamedExpression{\n              name = parameters->at(i).name(),\n              expression = \n                if i <= self.size() then\n                  self.expression->at(i)\n                else\n                  -- NOTE: This will cause an error for missing arguments for \n                  -- inout parameters.\n                  SequenceConstructionExpression{\n                    hasMultiplicity = true,\n                    owner = self\n                  }\n                endif,\n              owner = self\n            }\n          )->asSet()\n        endif'"
	 * @generated
	 */
	EList<OutputNamedExpression> outputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model expressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\t\tif self.expression->excludes(expression) then null\n\t\t\t\t\telse\n\t\t\t\t\t\tlet i = self.expression->indexOf(expression) in\n\t\t\t\t\t\tlet parameter = self.invocation.parameter->at(i) in\n\t\t\t\t\t\t\tOutputNamedExpression{\n\t\t\t\t\t\t\t\tname = parameter.name(),\n\t\t\t\t\t\t\t\texpression = expression,\n\t\t\t\t\t\t\t\towner = self\n\t\t\t\t\t\t\t}\n\t\t\t\t\tendif'"
	 * @generated
	 */
	OutputNamedExpression outputForExpression(Expression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A positional tuple must not have more arguments than the invocation it is for has parameters.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.size() <= self.invocation.parameterCount()'"
	 * @generated
	 */
	boolean positionalTupleArguments(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PositionalTuple
