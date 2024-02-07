/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of an association, whose members must all be properties.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssociationDefinition()
 * @model
 * @generated
 */
public interface AssociationDefinition extends ClassifierDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this association definition
	 * considered as a classifier definition and the subunit is for an association definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                          self.ClassifierDefinition_matchForStub(unit) and\n                          unit.definition.oclIsKindOf(AssociationDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed for classifiers in general, an association
	 * definition allows an annotation for any stereotype whose metaclass is consistent with Association.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                          /* TODO: Handle association stereotype annotations. \052/\n                          self.ClassifierDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either an AssociationDefinition or an
	 * imported member whose referent is an AssociationDefinition or an Association.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isAssociation()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialization referents of an association definition must all be associations.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specializationReferent->forAll(isAssociation())'"
	 * @generated
	 */
	boolean associationDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AssociationDefinition
