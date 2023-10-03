/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to create a new instance of a class or data type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#isIsConstructorless <em>Is Constructorless</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#isIsObjectCreation <em>Is Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#getConstructor <em>Constructor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInstanceCreationExpression()
 * @model
 * @generated
 */
public interface InstanceCreationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Is Constructorless</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is a constructorless object creation expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Constructorless</em>' attribute.
	 * @see #setIsConstructorless(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInstanceCreationExpression_IsConstructorless()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PropertyAccessExpression'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent <> null and referent.isClass()'"
	 * @generated
	 */
	boolean isIsConstructorless();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#isIsConstructorless <em>Is Constructorless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Constructorless</em>' attribute.
	 * @see #isIsConstructorless()
	 * @generated
	 */
	void setIsConstructorless(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Object Creation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an object creation expression or a data value creation
	 * expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Object Creation</em>' attribute.
	 * @see #setIsObjectCreation(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInstanceCreationExpression_IsObjectCreation()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PropertyAccessExpression' unique='false' upper='*'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referent = self.referent in\n          referent = null or not referent.isDataType()'"
	 * @generated
	 */
	boolean isIsObjectCreation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#isIsObjectCreation <em>Is Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Object Creation</em>' attribute.
	 * @see #isIsObjectCreation()
	 * @generated
	 */
	void setIsObjectCreation(boolean value);

	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the class constructor operation to be invoked or the name of
	 * a class or data type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constructor</em>' containment reference.
	 * @see #setConstructor(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getInstanceCreationExpression_Constructor()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getConstructor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.InstanceCreationExpression#getConstructor <em>Constructor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' containment reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.constructor = null then null\n        else\n          let referents = self.constructor.referent in\n          let classReferents = referents->select(isClass()) in\n          let dataTypeReferents = referents->select(isDataType()) in\n            if dataTypeReferents->size() = 1 and classReferents->isEmpty() then\n              dataTypeReferents->any(true)\n            else if dataTypeReferents->notEmpty() then\n              null\n            else\n              -- TODO: Handle operation overloading.\n              let operationReferents =\n                if classReferents->size() <> 1 then\n                  referents->select(isOperation())\n                else \n                  let name = self.constructor.unqualifiedName.toName() in\n                    classReferents->any(true).ownedMembers()->\n                      select(name() = name and isOperation())\n                endif\n              in\n                if operationReferents->size() = 1 and\n                    operationReferents->forAll(isConstructor()) then\n                  operationReferents->any(true).constructorReference()\n                else if classReferents->size() = 1 then\n                  classReferents->any(true)\n                else\n                  null\n                endif endif\n            endif endif\n        endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent <> null and referent.isClassifier() then referent\n          else self.InvocationExpression_type()\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent <> null and referent.isClassifier() then 1\n          else self.InvocationExpression_lower()\n          endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent <> null and referent.isClassifier() then 1\n          else self.InvocationExpression_upper()\n          endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An instance creation expression is an object creation if its referent is
	 * not a data type.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean instanceCreationExpressionIsObjectCreationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An instance creation expression is constructorless if its referent is a
	 * class.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean instanceCreationExpressionIsConstructorlessDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of an instance creation expression is normally the
	 * constructor operation, class or data type to which the constructor name
	 * resolves. However, if the referent is an operation whose class is
	 * abstract or is a class that is itself abstract, and there is an
	 * associated Impl class constructor, then the referent is the Impl class
	 * constructor.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean instanceCreationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no feature for an instance creation expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean instanceCreationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The constructor name must resolve to a constructor operation (that is
	 * compatible with the tuple argument expressions), a class or a data type,
	 * but not both a class and a data type.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          referent <> null and\n            (referent.isDataType() or referent.isClass() or referent.isOperation())'"
	 * @generated
	 */
	boolean instanceCreationExpressionConstructor(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the expression is constructorless, then its tuple must be empty and
	 * the referent class must not have any owned operations that are constructors.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isConstructorless implies \n          self.tuple.size() = 0 and \n            not self.referent.ownedMembers()->exists(isConstructor())'"
	 * @generated
	 */
	boolean instanceCreationExpressionConstructorlessLegality(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an instance creation expression is a data value creation (not an
	 * object creation), then the tuple argument expressions are matched with
	 * the attributes of the named type.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- TODO: Once overloading resolution is implemented, change this to only\n        -- be for data value creation.\n        self.tuple.size() <= self.parameterCount() and\n        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))'"
	 * @generated
	 */
	boolean instanceCreationExpressionDataTypeCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent of an instance creation expression is an operation, then
	 * the class of that operation must not be abstract. Otherwise, the referent
	 * is a class or data type, which must not be abstract.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n        let classReferent =\n          if referent <> null and referent.isOperation() then \n            referent.namespace()\n          else\n            referent\n          endif\n        in\n          referent <> null and not referent.isAbstractClassifier()'"
	 * @generated
	 */
	boolean instanceCreationExpressionReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the parameters of a constructor operation or the attributes of a
	 * data type, or an empty set for a constructorless instance creation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isConstructorless then OrderedSet(ElementReference){}\n        else self.InvocationExpression_parameterElements()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> parameterElements();

} // InstanceCreationExpression
