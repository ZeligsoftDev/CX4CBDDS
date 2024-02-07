/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Named Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A pairing of an input parameter name and an argument expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression()
 * @model
 * @generated
 */
public interface InputNamedExpression extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameter name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An expression whose value gives an index into an ordered parameter.
	 * (This is only used in link operation expressions.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' reference.
	 * @see #setIndex(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression_Index()
	 * @model
	 * @generated
	 */
	Expression getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#getIndex <em>Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Expression value);

	/**
	 * Returns the value of the '<em><b>Is Collection Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the argument expression requires collection conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #setIsCollectionConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression_IsCollectionConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let parameter = self.tuple().invocation.parameterNamed(self.name) in\n        \tparameter <> null and\n        \tlet parameterType = parameter.type() in\n\t          parameterType <> null and self.expression.type <> null and\n\t          self.isCollectionClass(parameterType) and \n\t            not self.isCollectionClass(self.expression.type)'"
	 * @generated
	 */
	boolean isIsCollectionConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #isIsCollectionConversion()
	 * @generated
	 */
	void setIsCollectionConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the argument expression requires bit string conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInputNamedExpression_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let parameter = self.tuple().invocation.parameterNamed(self.name) in\n        \tparameter <> null and\n        \tlet parameterType = parameter.type() in\n\t          parameterType <> null and self.expression <> null and\n\t          (self.isBitStringType(parameterType) or \n\t            self.isBitStringCollectionClass(parameterType)) and \n\t          not self.isBitStringType(self.expression.type)'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InputNamedExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #isIsBitStringConversion()
	 * @generated
	 */
	void setIsBitStringConversion(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.owner().oclAsType(_\'Tuple\')'"
	 * @generated
	 */
	Tuple tuple();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Collection conversion is required if the type of the corresponding
	 * parameter is a collection class and the type of the argument expression
	 * is not.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean namedExpressionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bit string conversion is required if the type of the type of the
	 * corresponding parameter is BitString, or a collection class instantiated
	 * with a BitString type, and the type of the argument expression is not
	 * BitString.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean namedExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InputNamedExpression
