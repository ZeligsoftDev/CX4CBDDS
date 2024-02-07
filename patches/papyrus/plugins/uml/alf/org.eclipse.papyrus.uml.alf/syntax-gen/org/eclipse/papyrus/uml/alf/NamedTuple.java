/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A tuple in which the arguments are matched to parameters by name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NamedTuple#getNamedExpression <em>Named Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamedTuple()
 * @model
 * @generated
 */
public interface NamedTuple extends Tuple {
	/**
	 * Returns the value of the '<em><b>Named Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.NamedExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expressions for this tuple paired with the corresponding
	 * parameter names.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Named Expression</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNamedTuple_NamedExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NamedExpression> getNamedExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.namedExpression->size()'"
	 * @generated
	 */
	BigInteger size();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        parameters->select(\n          let direction = direction() in\n            direction = \'in\' or direction = \'inout\' \n        )->collect(parameter |\n          let parameterName = parameter.name() in\n          let arguments = self.namedExpression->select(actualName() = parameterName) in\n            if arguments->isEmpty() then\n              InputNamedExpression{\n                name = parameterName,\n                expression = SequenceConstructionExpression{\n                  hasMultiplicity = true\n                },\n                owner = self\n              }\n            else\n              let argument : NamedExpression = arguments->any(true) in\n                InputNamedExpression{\n                  name = parameterName,\n                  expression = argument.expression,\n                  index = argument.index,\n                  owner = self\n                }\n            endif\n        )->asSet()'"
	 * @generated
	 */
	EList<InputNamedExpression> inputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parametersMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        parameters->select(parameter |\n          let direction = parameter.direction() in\n            -- NOTE: This allows missing arguments for out parameters.\n            direction = \'out\' and \n              self.namedExpression->exists(actualName() = parameter.name()) or\n            direction = \'inout\' \n        )->collect(parameter |\n          let parameterName = parameter.name() in\n          let arguments = self.namedExpression->select(actualName() = parameterName) in\n            if arguments->isEmpty() then\n              -- NOTE: This will cause an error for a missing argument for\n              -- an inout parameter.\n              OutputNamedExpression{\n                name = parameterName,\n                expression = SequenceConstructionExpression{\n                  hasMultiplicity = true\n                },\n                owner = self\n              }\n            else\n              let argument : NamedExpression = arguments->any(true) in\n                OutputNamedExpression{\n                  name = parameterName,\n                  index = argument.index,\n                  expression = argument.expression,\n                  owner = self\n                }\n            endif\n        )->asSet()'"
	 * @generated
	 */
	EList<OutputNamedExpression> outputFor(EList<ElementReference> parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model expressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tlet arguments = self.namedExpression->select(a | a.expression = expression) in\n\t\t\t\t\tif arguments->isEmpty() then null\n\t\t\t\t\telse\n\t\t\t\t\t\tlet argument = arguments->any(true) in\n\t\t\t\t\t\t\tOutputNamedExpression{\n\t\t\t\t\t\t\t\tname = argument.name,\n\t\t\t\t\t\t\t\tindex = argument.index,\n\t\t\t\t\t\t\t\texpression = expression,\n\t\t\t\t\t\t\t\towner = self\n\t\t\t\t\t\t\t}\n\t\t\t\t\tendif'"
	 * @generated
	 */
	OutputNamedExpression outputForExpression(Expression expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of a named expression of a named tuple must be the name of a
	 * parameter of the invocation the tuple is for. No two named expressions
	 * may have the same name.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let names = self.invocation.parameter.name() in\n          self.namedExpression->forAll(names->includes(actualName())) and\n          self.namedExpression->isUnique(actualName())'"
	 * @generated
	 */
	boolean namedTupleArgumentNames(DiagnosticChain diagnostics, Map<Object, Object> context);

} // NamedTuple
