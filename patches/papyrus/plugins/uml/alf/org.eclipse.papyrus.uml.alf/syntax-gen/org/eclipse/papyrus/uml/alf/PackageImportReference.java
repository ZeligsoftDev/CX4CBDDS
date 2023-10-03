/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An import reference to a package all of whose public members are to be imported.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPackageImportReference()
 * @model
 * @generated
 */
public interface PackageImportReference extends ImportReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the visible members of the referent package.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                       if self.referent = null then Set(Member){}\n                       else self.referent.visibleMembers()->collect(m | \n                         Member{\n                           visibility = self.visibility,\n                           definition = ImportedMember{name = m.name(), referent = m}\n                         }\n                       )->asSet()\n                      endif'"
	 * @generated
	 */
	EList<Member> importedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of a package import must be a package.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.referent <> null and self.referent.isPackage()'"
	 * @generated
	 */
	boolean packageImportReferenceReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PackageImportReference
