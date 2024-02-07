/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Extent Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to obtain the objects in the extent of a class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassExtentExpression#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassExtentExpression()
 * @model
 * @generated
 */
public interface ClassExtentExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the class whose extent is to be obtained.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Name</em>' containment reference.
	 * @see #setClassName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassExtentExpression_ClassName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassExtentExpression#getClassName <em>Class Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' containment reference.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.className.referent->select(isClass()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='-1'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='0'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a class extent expression is the given class.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classExtentExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of a class expression is *.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classExtentExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of a class extent expression is 0.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classExtentExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The given type name must resolve to a non-template class.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.validateClassExtentExpressionExtentType()'"
	 * @generated
	 */
	boolean classExtentExpressionExtentType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.type <> null and not self.type.isTemplate()'"
	 * @generated
	 */
	boolean validateClassExtentExpressionExtentType();

} // ClassExtentExpression
