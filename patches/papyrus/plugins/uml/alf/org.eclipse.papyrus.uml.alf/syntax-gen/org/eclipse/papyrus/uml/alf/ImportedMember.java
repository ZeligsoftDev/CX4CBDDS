/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Member</b></em>'.
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
 *   <li>{@link org.eclipse.papyrus.uml.alf.ImportedMember#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportedMember()
 * @model
 * @generated
 */
public interface ImportedMember extends MemberDefinition {
	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportedMember_Referent()
	 * @model required="true"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ImportedMember#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.name'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent'"
	 * @generated
	 */
	ElementReference toReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns false. (Imported members do not have annotations.)
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the given member is not an imported member, then return the result of
	 * checking whether the given member is the same kind as this member. Else,
	 * if the element of the referent for this member is an Alf member, then
	 * return the result of checking whether that element is the same kind as the
	 * given member. Else, if the element of the referent for the given member is
	 * an Alf member, then return the result of checking whether that element is
	 * the same kind as this member. Else, the referents for both this and the
	 * given member are UML elements, so return the result of checking their
	 * distinguishability according to the rules of the UML superstructure.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isSameKindAs(member)'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the referent of this imported member is a feature.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent.isFeature()'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An imported element is not a stub.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='not self.isStub'"
	 * @generated
	 */
	boolean importedMemberNotStub(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An imported element is a feature if its referent is a feature.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean importedMemberIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ImportedMember
