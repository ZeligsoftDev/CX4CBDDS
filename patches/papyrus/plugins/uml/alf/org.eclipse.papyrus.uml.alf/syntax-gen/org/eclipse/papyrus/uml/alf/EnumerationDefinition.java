/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of an enumeration, whose members must all be enumeration literal names.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getEnumerationDefinition()
 * @model
 * @generated
 */
public interface EnumerationDefinition extends ClassifierDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this enumeration definition considered
	 * as a classifier definition and the subunit is for an enumeration definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        self.ClassifierDefinition_matchForStub(unit) and\n                        unit.definition.oclIsKindOf(EnumerationDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed for classifiers in general, an enumeration definition
	 * allows an annotation for any stereotype whose metaclass is consistent with Enumeration.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow enumeration stereotype annotations. \052/\n                        self.ClassifierDefinition_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either an EnumerationDefinition or an imported member
	 * whose referent is an EnumerationDefinition or an Enumeration.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isEnumeration()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialization referents of an enumeration definition must all be enumerations.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specializationReferent->forAll(isEnumeration())'"
	 * @generated
	 */
	boolean enumerationDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EnumerationDefinition
