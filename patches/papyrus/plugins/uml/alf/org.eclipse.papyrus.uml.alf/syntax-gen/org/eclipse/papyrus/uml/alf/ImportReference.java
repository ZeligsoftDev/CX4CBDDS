/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an element or package to be imported into a unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ImportReference#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ImportReference#getReferentName <em>Referent Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ImportReference#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ImportReference#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportReference()
 * @model abstract="true"
 * @generated
 */
public interface ImportReference extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An indication of the visibility of the import.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see #setVisibility(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportReference_Visibility()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ImportedMember' unique='false' upper='*'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ImportedMember' unique='false' upper='*'"
	 * @generated
	 */
	String getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ImportReference#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(String value);

	/**
	 * Returns the value of the '<em><b>Referent Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the element or package to be imported.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent Name</em>' containment reference.
	 * @see #setReferentName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportReference_ReferentName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getReferentName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ImportReference#getReferentName <em>Referent Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent Name</em>' containment reference.
	 * @see #getReferentName()
	 * @generated
	 */
	void setReferentName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the imported element denoted by the given qualified name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportReference_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                    let referents = self.referentName.modelReferents() in \n                      if referents->size() = 1 then referents->any(true)\n                      else null\n                      endif'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ImportReference#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unit that is making this import reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit</em>' container reference.
	 * @see #setUnit(UnitDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getImportReference_Unit()
	 * @see org.eclipse.papyrus.uml.alf.UnitDefinition#getImport
	 * @model opposite="import" required="true" transient="false"
	 * @generated
	 */
	UnitDefinition getUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ImportReference#getUnit <em>Unit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' container reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(UnitDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the set of all imported members.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Member> importedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of an import reference is the element denoted by the
	 * referent name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean importReferenceReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent name of an import reference must resolve to a single element
	 * with public or empty visibility.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                  self.referent <> null and\n                  let visibility = self.referent.visibility() in \n                    visibility = null or visibility = \'public\''"
	 * @generated
	 */
	boolean importReferenceReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ImportReference
