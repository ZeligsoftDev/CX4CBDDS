/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to assign a value to a local name, parameter or property.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsIndexed <em>Is Indexed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsArithmetic <em>Is Arithmetic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsLogical <em>Is Logical</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsShift <em>Is Shift</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsConcatenation <em>Is Concatenation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsDefinition <em>Is Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsFeature <em>Is Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsDataValueUpdate <em>Is Data Value Update</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression()
 * @model
 * @generated
 */
public interface AssignmentExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The image of the assignment operator used in the expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The left-hand side of the assignment, to which a value is to be assigned.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #setLeftHandSide(LeftHandSide)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_LeftHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSide getLeftHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
	void setLeftHandSide(LeftHandSide value);

	/**
	 * Returns the value of the '<em><b>Right Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The right-hand side expression of the assignment, which produces the value being assigned.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Right Hand Side</em>' containment reference.
	 * @see #setRightHandSide(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_RightHandSide()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getRightHandSide();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Hand Side</em>' containment reference.
	 * @see #getRightHandSide()
	 * @generated
	 */
	void setRightHandSide(Expression value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side is a name, then the new assigned source for that name.
	 * (Note: This also includes assignments to parameters and local names that
	 * are the source of data value updates.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment</em>' reference.
	 * @see #setAssignment(AssignedSource)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_Assignment()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n          let name = self.leftHandSide.assignedName() in\n            if name = null then null\n            else if self.isDefinition then\n              AssignedSource{\n                name = name,\n                source = self,\n                type = self.rightHandSide.type,\n                lower = 0,\n                upper = if self.rightHandSide.upper = 1 then 1 else -1 endif\n              }\n            else\n              let assignments = self.assignmentBefore->select(a | a.name = name) in\n                if assignments->isEmpty() then null\n                else\n                  let oldAssignment = assignments->any(true) in\n                    AssignedSource{\n                      name = name,\n                      source = self,\n                      type = oldAssignment.type,\n                      lower = oldAssignment.lower,\n                      upper = oldAssignment.upper\n                  }\n                endif\n            endif endif'"
	 * @generated
	 */
	AssignedSource getAssignment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getAssignment <em>Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' reference.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(AssignedSource value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side is a feature, then the referent for that feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_Feature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let feature = self.leftHandSide.feature() in\n          if feature = null then null\n          else\n            let referents = feature.referent in\n              if referents->isEmpty() then null\n              else referents->any(true)\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Indexed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side is a feature, whether it has an index or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Indexed</em>' attribute.
	 * @see #setIsIndexed(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsIndexed()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.leftHandSide.index() <> null'"
	 * @generated
	 */
	boolean isIsIndexed();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsIndexed <em>Is Indexed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Indexed</em>' attribute.
	 * @see #isIsIndexed()
	 * @generated
	 */
	void setIsIndexed(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Arithmetic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is a compound assignment, whether the compound assignment
	 * operator is arithmetic or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Arithmetic</em>' attribute.
	 * @see #setIsArithmetic(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsArithmetic()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='Set{\'+=\', \'-=\', \'*=\', \'/=\', \'%=\'}->includes(self.operator)'"
	 * @generated
	 */
	boolean isIsArithmetic();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsArithmetic <em>Is Arithmetic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Arithmetic</em>' attribute.
	 * @see #isIsArithmetic()
	 * @generated
	 */
	void setIsArithmetic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Logical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Logical</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Logical</em>' attribute.
	 * @see #setIsLogical(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsLogical()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='Set{\'&=\', \'|=\', \'^=\'}->includes(self.operator)'"
	 * @generated
	 */
	boolean isIsLogical();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsLogical <em>Is Logical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Logical</em>' attribute.
	 * @see #isIsLogical()
	 * @generated
	 */
	void setIsLogical(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Shift</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Shift</em>' attribute.
	 * @see #setIsShift(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsShift()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='Set{\'<<=\', \'>>=\', \'>>>=\'}->includes(self.operator)'"
	 * @generated
	 */
	boolean isIsShift();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsShift <em>Is Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Shift</em>' attribute.
	 * @see #isIsShift()
	 * @generated
	 */
	void setIsShift(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Concatenation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Concatenation</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Concatenation</em>' attribute.
	 * @see #setIsConcatenation(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsConcatenation()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operator = \'+=\''"
	 * @generated
	 */
	boolean isIsConcatenation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsConcatenation <em>Is Concatenation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Concatenation</em>' attribute.
	 * @see #isIsConcatenation()
	 * @generated
	 */
	void setIsConcatenation(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this assignment is the definition of a new local name or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Definition</em>' attribute.
	 * @see #setIsDefinition(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsDefinition()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isSimple and not self.isIndexed and \n                self.leftHandSide.referent = null and self.leftHandSide.localName() <> null'"
	 * @generated
	 */
	boolean isIsDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsDefinition <em>Is Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Definition</em>' attribute.
	 * @see #isIsDefinition()
	 * @generated
	 */
	void setIsDefinition(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is a simple assignment or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Simple</em>' attribute.
	 * @see #setIsSimple(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsSimple()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operator = \'=\''"
	 * @generated
	 */
	boolean isIsSimple();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsSimple <em>Is Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Simple</em>' attribute.
	 * @see #isIsSimple()
	 * @generated
	 */
	void setIsSimple(boolean value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is a compound assignment, then the effective expression used to
	 * obtain the original value of the left-hand side to be updated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_Expression()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.leftHandSide.expression()'"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Is Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the left-hand side is a feature or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Feature</em>' attribute.
	 * @see #setIsFeature(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsFeature()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	boolean isIsFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsFeature <em>Is Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Feature</em>' attribute.
	 * @see #isIsFeature()
	 * @generated
	 */
	void setIsFeature(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Data Value Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this assignment updates an attribute of a data value held in a
	 * local name or parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Data Value Update</em>' attribute.
	 * @see #setIsDataValueUpdate(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsDataValueUpdate()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.leftHandSide.isDataValueUpdate()'"
	 * @generated
	 */
	boolean isIsDataValueUpdate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsDataValueUpdate <em>Is Data Value Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Data Value Update</em>' attribute.
	 * @see #isIsDataValueUpdate()
	 * @generated
	 */
	void setIsDataValueUpdate(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Collection Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether collection conversion is required for this assignment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #setIsCollectionConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsCollectionConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let lhsType = self.leftHandSide.type in\n        let rhsType = self.rightHandSide.type in\n          lhsType <> null and rhsType <> null and\n          not self.isCollectionClass(lhsType) and\n          self.isCollectionClass(rhsType) and \n          self.rightHandSide.upper = 1'"
	 * @generated
	 */
	boolean isIsCollectionConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsCollectionConversion <em>Is Collection Conversion</em>}' attribute.
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
	 * Whether BitString conversion is required for this assignment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignmentExpression_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let lhsType = self.leftHandSide.type in\n        let rhsType = self.type in -- Note: This works for both simple and compound assignments.assignment.\n          rhsType <> null and lhsType <> null and self.isBitStringType(lhsType) and\n          (self.isIntegerType(rhsType) or\n            self.isCollectionConversion and self.isIntegerCollectionClass(rhsType)\n          )'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignmentExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isSimple then self.rightHandSide.type\n        else self.leftHandSide.type\n        endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.rightHandSide.upper'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isSimple then self.rightHandSide.lower\n        else self.leftHandSide.lower\n        endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if element = self.leftHandSide then self.rightHandSide.assignmentAfter\n        else self.assignmentBefore\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment expression is a simple assignment if the assignment
	 * operator is "=".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsSimpleDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment expression is an arithmetic assignment if its operator is a
	 * compound assignment operator for an arithmetic operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsArithmeticDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment expression is a definition if it is a simple assignment and
	 * its left hand side is a local name for which there is no assignment
	 * before the expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsDefinitionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The left hand side of an assignment expression is a feature if it is a
	 * kind of FeatureLeftHandSide.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The left hand side of an assignment expression is indexed if it has an index.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsIndexedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment expression is a data value update if its left hand side is
	 * an attribute of a data value held in a local name or parameter.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsDataValueUpdateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The new assigned source for an assignment to a local name is the
	 * assignment expression. If the assignment is a definition, then the type
	 * is given by the right hand side, the multiplicity upper bound is 1 if the
	 * upper bound of the right hand side is 1 and otherwise * and the
	 * multiplicity lower bound is 0. Otherwise, the type is the same as the
	 * left-hand side and the multiplicity is also the same as the left-hand
	 * side, if the left-hand side is not indexed, and is * if it is indexed.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionAssignmentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side of an assignment expression is a feature, then the
	 * feature of the assignment is the referent of the left-hand side.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a compound assignment, the effective expression is the left-hand side
	 * treated as a name expression, property access expression or sequence
	 * access expression, as appropriate for evaluation to obtain the original
	 * value to be updated.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A simple assignment expression has the same type as its right-hand side
	 * expression. A compound assignment expression has the same type as its
	 * left-hand side.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment expression has the same multiplicity upper bound as its
	 * right-hand side expression.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A simple assignment expression has the same multiplicity lower bound as
	 * its right-hand side expression. A compound assignment expression has the
	 * same multiplicity as its left-hand side.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side of a simple assignment is not a new local name, and
	 * the right-hand side is not null, then the left-hand side must either be
	 * untyped or have a type that conforms to the type of the right-hand side
	 * expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        (self.isSimple and not self.isDefinition) implies\n          self.leftHandSide.isTypeConformantWith(self.rightHandSide)'"
	 * @generated
	 */
	boolean assignmentExpressionSimpleAssignmentTypeConformance(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the left-hand side of a simple assignment is not a new local name and
	 * the multiplicity upper bound of the left-hand side is less than or equal
	 * to 1, then the multiplicity upper bound of the right-hand side cannot be
	 * greater than that of the left-hand side.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        (self.isSimple and not self.isDefinition) implies\n          self.leftHandSide.isMultiplicityConformantWith(self.rightHandSide)'"
	 * @generated
	 */
	boolean assignmentExpressionSimpleAssignmentMultiplicityConformance(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a compound assignment, if the operator is an arithmetic operator,
	 * then either the left-hand side and the right-hand side both have type
	 * Integer or they both have type String and the operator is +. If the
	 * operator is a logical operator, then either the left-hand side and the
	 * right-hand side both have type Boolean or Bit String or the left-hand
	 * side has type Bit String and the right-hand side has type Integer. If the
	 * operator is a shift operator, then the left-hand side must have type
	 * BitString and the right-hand side must have type Integer.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    not self.isSimple implies\n      let lhsType = self.leftHandSide.type in\n      let rhsType = self.rightHandSide.type in\n        lhsType <> null and rhsType <> null and\n          (self.isArithmetic and \n            self.isIntegerType(lhsType) and self.isIntegerType(rhsType) or\n           self.isLogical and\n            (self.isBooleanType(lhsType) and self.isBooleanType(rhsType) or\n             self.isBitStringType(lhsType) and \n              (self.isBitStringType(rhsType) or self.isIntegerType(rhsType))\n            ) or\n           self.isShift and\n            self.isBitStringType(lhsType) and self.isIntegerType(rhsType) or\n           self.isConcatenation and\n            self.isStringType(lhsType) and self.isStringType(rhsType)\n          )'"
	 * @generated
	 */
	boolean assignmentExpressionCompoundAssignmentTypeConformance(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a compound assignment, both the left-hand and right-hand sides must
	 * have a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='(not self.isSimple) implies \n                (self.leftHandSide.upper = 1 and self.rightHandSide.upper = 1)'"
	 * @generated
	 */
	boolean assignmentExpressionCompoundAssignmentMultiplicityConformance(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned source of a name before the right-hand side expression of an
	 * assignment expression is the same as the assigned source before the
	 * assignment expression. The assigned source of a name before the left-hand
	 * side is the assigned source after the right-hand side expression.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment requires collection conversion if the type of the
	 * right-hand side is a collection class and its multiplicity upper bound
	 * is 1, and the type of the left-hand side is not a collection class.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An assignment requires BitString conversion if the type of the left-hand
	 * side is BitString and either the type of the right-hand side is Integer
	 * or collection conversion is required and the type of the right-hand side
	 * is a collection class whose argument type is Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean assignmentExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an assignment expression has a feature with a primary expression whose
	 * type is a data type, then the assignment expression must be a data value
	 * update.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.leftHandSide.feature() in\n          feature <> null implies\n            let type = feature.expression.type in\n              (type <> null and type.isDataType()) implies\n                self.isDataValueUpdate'"
	 * @generated
	 */
	boolean assignmentExpressionDataValueUpdateLegality(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after an assignment expression are the assignments after
	 * the left-hand side, updated by the assignment from the assignment
	 * expression, if any.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignment = self.assignment in\n          if assignment = null then self.leftHandSide.assignmentAfter\n          else assignment.update(self.leftHandSide.assignmentAfter)\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // AssignmentExpression
