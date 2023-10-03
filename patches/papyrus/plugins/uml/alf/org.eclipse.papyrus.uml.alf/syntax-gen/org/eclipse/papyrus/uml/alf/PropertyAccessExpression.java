/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression comprising a reference to a structural feature.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyAccessExpression#getFeatureReference <em>Feature Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PropertyAccessExpression#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyAccessExpression()
 * @model
 * @generated
 */
public interface PropertyAccessExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Feature Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to a structural feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Reference</em>' containment reference.
	 * @see #setFeatureReference(FeatureReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyAccessExpression_FeatureReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeatureReference getFeatureReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyAccessExpression#getFeatureReference <em>Feature Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Reference</em>' containment reference.
	 * @see #getFeatureReference()
	 * @generated
	 */
	void setFeatureReference(FeatureReference value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced structural feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPropertyAccessExpression_Feature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referents = self.featureReference.referent->select(isProperty()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.PropertyAccessExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature in\n          if feature = null then null\n          else feature.type()\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature in\n          if feature = null then 0\n          else if feature.upper() = -1 or \n            self.featureReference.expression.upper = -1 then -1\n          else feature.upper() * self.featureReference.expression.upper\n          endif endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature in\n          if feature = null then 0\n          else feature.lower() * self.featureReference.expression.lower\n          endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feature of a property access expression is the structural feature to
	 * which its feature reference resolves.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyAccessExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a property access expression is the type of the referenced
	 * feature.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyAccessExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of a property access expression is given by
	 * the product of the multiplicity upper bounds of the referenced feature
	 * and the target expression.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyAccessExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of a property access expression is given by
	 * the product of the multiplicity lower bounds of the referenced feature
	 * and the target expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyAccessExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feature reference for a property access expression must resolve to a
	 * single structural feature.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.feature <> null'"
	 * @generated
	 */
	boolean propertyAccessExpressionFeatureResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expression of the feature reference of a
	 * property access expression are the same as before the property access
	 * expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean propertyAccessExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a property access expression are the same as those
	 * after the target expression of its feature reference.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.featureReference.expression.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // PropertyAccessExpression
