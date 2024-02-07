/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a data type, whose members must all be properties.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getDataTypeDefinition()
 * @model
 * @generated
 */
public interface DataTypeDefinition extends ClassifierDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given unit definition matches this data type definition
	 * considered as a classifier definition and the subunit is for a data type
	 * definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        self.ClassifierDefinition_matchForStub(unit) and\n                        unit.definition.oclIsKindOf(DataTypeDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed for classifiers in general, a data type
	 * definition allows @primitive annotations plus any stereotype whose metaclass is consistent with DataType.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow data type stereotype annotations. \052/\n                        self.ClassifierDefinition_annotationAllowed(annotation) or\n                        annotation.stereotypeName.pathName = \'primitive\''"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either a DataTypeDefinition or an imported member
	 * whose referent is a DataTypeDefinition or a DataType.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isDataType()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a data type is primitive, then it may not have any owned members.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.isPrimitive implies self.ownedMember->isEmpty()'"
	 * @generated
	 */
	boolean dataTypeDefinitionPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specialization referents of a data type definition must all be data types.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.specializationReferent->forAll(isDataType())'"
	 * @generated
	 */
	boolean dataTypeDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataTypeDefinition
