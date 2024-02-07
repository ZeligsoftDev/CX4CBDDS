/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a package, all of whose members must be packageable elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.PackageDefinition#getAppliedProfile <em>Applied Profile</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPackageDefinition()
 * @model
 * @generated
 */
public interface PackageDefinition extends NamespaceDefinition {
	/**
	 * Returns the value of the '<em><b>Applied Profile</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The profiles applied (directly) to this package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Profile</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getPackageDefinition_AppliedProfile()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let applications : Set(StereotypeAnnotation) = \n          self.annotation()->select(stereotypeName.pathName = \'apply\') \n        in\n          applications.names.name.referent->select(isProfile())->asSet()'"
	 * @generated
	 */
	EList<ElementReference> getAppliedProfile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean allowPackageOnly();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to the annotations allowed on any namespace definition, a package definition
	 * allows @apply annotations plus any stereotype whose metaclass is consistent with Package.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow package stereotype annotations. \052/\n                        self.NamespaceDefinition_annotationAllowed(annotation) or\n                        annotation.stereotypeName.pathName = \'apply\' or\n                        annotation.stereotypeName.pathName = \'ModelLibrary\''"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true of the namespace definition associated with the given unit definition is a package definition.
	 * <!-- end-model-doc -->
	 * @model required="true" unitRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='unit.definition.oclIsKindOf(PackageDefinition)'"
	 * @generated
	 */
	boolean matchForStub(UnitDefinition unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either a PackageDefinition or an imported member whose referent is a PackageDefinition or a Package.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isPackage()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied profiles of a package definition are the profiles listed in any @apply annotations on the package.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean packageDefinitionAppliedProfileDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return all profiles applied in this package, any containing package or in the model scope.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.appliedProfile->union(self.NamespaceDefinition_appliedProfiles())'"
	 * @generated
	 */
	EList<ElementReference> appliedProfiles();

} // PackageDefinition
