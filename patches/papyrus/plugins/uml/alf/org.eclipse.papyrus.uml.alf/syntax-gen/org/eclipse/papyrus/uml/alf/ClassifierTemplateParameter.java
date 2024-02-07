/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a classifier template parameter, which acts as a classifier within the definition of the template.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifierTemplateParameter()
 * @model
 * @generated
 */
public interface ClassifierTemplateParameter extends ClassifierDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations are not allowed on classifier template parameters.
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
	 * Returns false. (Classifier template parameters cannot be stubs.)
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='not self.isStub'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is a classifier template parameter.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isClassifierTemplateParameter()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Two template parameters match if they have same names and the same
	 * specialization referents.
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        self.actualName() = other.actualName() and\n                        self.specializationReferent->size() = other.specializationReferent->size() and\n                        self.specializationReferent->forAll(containedIn(other.specializationReferent->asBag()))'"
	 * @generated
	 */
	boolean matches(ClassifierTemplateParameter other);

} // ClassifierTemplateParameter
