/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Member#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Member#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Member#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Member#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMember()
 * @model
 * @generated
 */
public interface Member extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(MemberDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMember_Definition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MemberDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Member#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(MemberDefinition value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An indication of the visibility of the member outside of its namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see #setVisibility(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMember_Visibility()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='AnnotatedStatement'"
	 * @generated
	 */
	String getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Member#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getOwnedMember <em>Owned Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The namespace definition within which this member definition is nested, if any.
	 * (The namespace definitions for units are not physically nested within another
	 * Alf namespace definition.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see #setNamespace(NamespaceDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMember_Namespace()
	 * @see org.eclipse.papyrus.uml.alf.NamespaceDefinition#getOwnedMember
	 * @model opposite="ownedMember" transient="false"
	 * @generated
	 */
	NamespaceDefinition getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Member#getNamespace <em>Namespace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' container reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(NamespaceDefinition value);

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The stereotype annotations on this member definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getMember_Annotation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<StereotypeAnnotation> getAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.definition.toReference()'"
	 * @generated
	 */
	ElementReference toReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.visibility <> null then self.visibility\n        else if definition.oclIsKindOf(EnumerationLiteralName) then \'public\'\n        else \'package\'\n        endif endif'"
	 * @generated
	 */
	String visibility();

} // Member
