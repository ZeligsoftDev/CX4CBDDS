/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The common properties of the definitions of typed elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsNonunique <em>Is Nonunique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsSequence <em>Is Sequence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getActualType <em>Actual Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsAny <em>Is Any</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsMultiplicity <em>Is Multiplicity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition()
 * @model
 * @generated
 */
public interface TypedElementDefinition extends AssignableElement {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The string image of the literal given to specify the lower bound of the
	 * multiplicity of the element being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_LowerBound()
	 * @model
	 * @generated
	 */
	String getLowerBound();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(String value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The string image of the literal given to specify the upper bound of the
	 * multiplicity of the element being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_UpperBound()
	 * @model default="1" required="true"
	 * @generated
	 */
	String getUpperBound();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(String value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the element being defined is ordered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_IsOrdered()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Nonunique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the element being defined is non-unique.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Nonunique</em>' attribute.
	 * @see #setIsNonunique(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_IsNonunique()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsNonunique();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsNonunique <em>Is Nonunique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Nonunique</em>' attribute.
	 * @see #isIsNonunique()
	 * @generated
	 */
	void setIsNonunique(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the type of the element being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Actual Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Type</em>' reference.
	 * @see #setActualType(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_ActualType()
	 * @model
	 * @generated
	 */
	ElementReference getActualType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#getActualType <em>Actual Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Type</em>' reference.
	 * @see #getActualType()
	 * @generated
	 */
	void setActualType(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the element being defined has an empty type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Any</em>' attribute.
	 * @see #setIsAny(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_IsAny()
	 * @model
	 * @generated
	 */
	boolean isIsAny();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsAny <em>Is Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any</em>' attribute.
	 * @see #isIsAny()
	 * @generated
	 */
	void setIsAny(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Sequence</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the element being defined is a sequence (and hence both ordered
	 * and non-unique).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Sequence</em>' attribute.
	 * @see #setIsSequence(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_IsSequence()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsSequence();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsSequence <em>Is Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sequence</em>' attribute.
	 * @see #isIsSequence()
	 * @generated
	 */
	void setIsSequence(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the element being defined has multiplicity specified as 0..*
	 * using the shortand multiplicity indicator "[]".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Multiplicity</em>' attribute.
	 * @see #setIsMultiplicity(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTypedElementDefinition_IsMultiplicity()
	 * @model
	 * @generated
	 */
	boolean isIsMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TypedElementDefinition#isIsMultiplicity <em>Is Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multiplicity</em>' attribute.
	 * @see #isIsMultiplicity()
	 * @generated
	 */
	void setIsMultiplicity(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isOrdered or self.isSequence'"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isNonunique or self.isSequence'"
	 * @generated
	 */
	boolean isNonunique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the lower bound string image of a typed element definition is not empty,
	 * then the integer lower bound is the integer value of the lower bound string.
	 * Otherwise the lower bound is equal to the upper bound, unless the upper bound
	 * is unbounded, in which case the lower bound is 0.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean typedElementDefinitionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unlimited natural upper bound value is the unlimited natural value of
	 * the upper bound string (with "*" representing the unbounded value).
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean typedElementDefinitionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a typed element definition is the single classifier referent
	 * of the type name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean typedElementDefinitionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type name of a typed element definition must have a single classifier
	 * referent. This referent may not be a template.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    self.typeName = null or self.type <> null and not self.type.isTemplate()'"
	 * @generated
	 */
	boolean typedElementDefinitionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    if self.actualType <> null then\n      self.actualType\n    else if self.typeName = null then\n      null\n    else\n      let types = self.typeName.referent->select(isClassifier()) in \n        if types->size() <> 1 then\n          null\n        else\n          types->any(true)\n        endif\n    endif endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    if self.lowerBound <> null then\n      self.lowerBound.toInteger()\n    else if self.isMultiplicity or self.upperBound = \'*\' then\n      0\n    else\n      self.upper\n    endif endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    if self.isMultiplicity or self.upperBound = \'*\' then\n      -1\n    else \n      self.upperBound.toInteger()\n    endif'"
	 * @generated
	 */
	BigInteger upper();

} // TypedElementDefinition
