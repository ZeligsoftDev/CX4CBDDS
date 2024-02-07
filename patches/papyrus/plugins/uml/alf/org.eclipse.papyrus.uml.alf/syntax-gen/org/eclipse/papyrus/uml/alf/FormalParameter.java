/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A typed element definition for the formal parameter of an activity or operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FormalParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FormalParameter#getTypePart <em>Type Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFormalParameter()
 * @model
 * @generated
 */
public interface FormalParameter extends MemberDefinition {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The default value is <code>"return"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An indication of the direction of the parameter being defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see #setDirection(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFormalParameter_Direction()
	 * @model default="return" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ReceptionDefinition'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ReceptionDefinition'"
	 * @generated
	 */
	String getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FormalParameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(String value);

	/**
	 * Returns the value of the '<em><b>Type Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Part</em>' containment reference.
	 * @see #setTypePart(TypedElementDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFormalParameter_TypePart()
	 * @model containment="true"
	 * @generated
	 */
	TypedElementDefinition getTypePart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FormalParameter#getTypePart <em>Type Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Part</em>' containment reference.
	 * @see #getTypePart()
	 * @generated
	 */
	void setTypePart(TypedElementDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The current scope for a formal parameter is the outer scope
	 * of the namespace definition that owns it.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.oclContainer().oclContainer().oclAsType(NamespaceDefinition).toReference()'"
	 * @generated
	 */
	ElementReference currentScope();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Parameter.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow formal parameter stereoype annotations. \052/\n                        false'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is a FormalParameter.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isParameter()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Two formal parameters match if they have the same direction, name,
	 * multiplicity bounds, ordering, uniqueness and type reference.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        other <> null and\n                        self.direction = other.direction and \n                        self.actualName() = other.actualName() and \n                        self.typePart.lower = other.typePart.lower and \n                        self.typePart.upper = other.typePart.upper and\n                        self.typePart.isOrdered() = other.typePart.isOrdered() and\n                        self.typePart.isNonunique() = other.typePart.isNonunique() and \n                        let type = self.typePart.type in\n                        let otherType = other.typePart.type in\n                          type = null and otherType = null or \n                          type <> null and type.equals(otherType)'"
	 * @generated
	 */
	boolean matches(FormalParameter other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        self.matchesNameType(other) and\n                        self.direction = other.direction() and \n                        self.typePart.lower = other.lower() and \n                        self.typePart.upper = other.upper() and\n                        self.typePart.isOrdered() = other.isOrdered() and\n                        self.typePart.isNonunique() = other.isNonunique()'"
	 * @generated
	 */
	boolean matchesElement(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                       self.matchesType(other) and\n                       self.actualName() = other.name()'"
	 * @generated
	 */
	boolean matchesNameType(ElementReference other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                                other <> null and\n                                let type = self.typePart.type in\n                                let otherType = other.type() in\n                                  type = null and otherType = null or\n                                  type <> null and type.equals(otherType)'"
	 * @generated
	 */
	boolean matchesType(ElementReference other);

} // FormalParameter
