/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element that is or has an assignable value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignableElement#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignableElement#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignableElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElement()
 * @model abstract="true"
 * @generated
 */
public interface AssignableElement extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statically determined upper bound of the multiplicity of this
	 * element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(BigInteger)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElement_Upper()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.upper()'"
	 * @generated
	 */
	BigInteger getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignableElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statically determined lower bound of the multiplicity of this
	 * element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(BigInteger)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElement_Lower()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.lower()'"
	 * @generated
	 */
	BigInteger getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignableElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the element that specifies the statically determined
	 * type for this element (if any).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElement_Type()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.typeCached()'"
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignableElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference typeCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.type = null and self.lower = 0 and self.upper = 0'"
	 * @generated
	 */
	boolean isNull();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                self.isAssignableFrom(\n                  AssignableElementReference{\n                    reference = element, owner = self.owner()\n                  }\n                )'"
	 * @generated
	 */
	boolean isAssignableFromElement(ElementReference element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" sourceRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        source = null or \n          self.isTypeConformantWith(source) and \n          self.isMultiplicityConformantWith(source)'"
	 * @generated
	 */
	boolean isAssignableFrom(AssignableElement source);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" sourceRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- Null conversion\n        source.isNull() or\n        \n        let sourceType = source.type in\n        \n          -- Type conformance\n          self.isConformantWithType(sourceType) or\n          \n          -- Collection conversion\n          sourceType <> null and self.isCollectionClass(sourceType) and\n          source.upper = 1 and (self.upper = -1 or self.upper > 1) and\n          self.isConformantWithType(sourceType.collectionArgument())'"
	 * @generated
	 */
	boolean isTypeConformantWith(AssignableElement source);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sourceTypeRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let targetType = self.type in\n          -- Untyped target is conformant with anything.\n          targetType = null or\n          \n          -- Untyped source is only assignable to untyped target.\n          sourceType <> null and (\n            \n          -- Basic type conformance.\n          sourceType.conformsTo(targetType) or\n          \n          -- Bit string conversion.\n          self.isIntegerType(sourceType) and self.isBitStringType(targetType)\n          )'"
	 * @generated
	 */
	boolean isConformantWithType(ElementReference sourceType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" sourceRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let targetUpper = self.upper in\n        let sourceUpper = source.upper in\n          targetUpper = -1 or targetUpper > 1 or\n          sourceUpper <> -1 and sourceUpper <= targetUpper'"
	 * @generated
	 */
	boolean isMultiplicityConformantWith(AssignableElement source);

} // AssignableElement
