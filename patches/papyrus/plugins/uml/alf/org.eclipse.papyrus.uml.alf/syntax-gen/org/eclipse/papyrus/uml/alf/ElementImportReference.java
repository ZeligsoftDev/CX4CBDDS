/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An import reference to a single element to be imported into a unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ElementImportReference#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getElementImportReference()
 * @model
 * @generated
 */
public interface ElementImportReference extends ImportReference {
	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The alias to be used as the name for the imported element in the importing unit?s namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getElementImportReference_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ElementImportReference#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the set of all imported members.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.referent = null then\n          Set(Member){}\n        else\n          Set{Member{\n            visibility = self.visibility,\n            definition = ImportedMember{\n              name = if self.alias = null then self.referent.name() else self.alias endif,\n              referent = self.referent\n            }\n          }}\n        endif'"
	 * @generated
	 */
	EList<Member> importedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of an element import reference must be a packageable element.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.referent <>null and self.referent.isPackageableElement()'"
	 * @generated
	 */
	boolean elementImportReferenceReferent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ElementImportReference
