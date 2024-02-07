/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a namespace as an Alf unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getNamespaceName <em>Namespace Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#isIsModelLibrary <em>Is Model Library</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getAppliedProfile <em>Applied Profile</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition()
 * @model
 * @generated
 */
public interface UnitDefinition extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Namespace Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A declaration of the name of the namespace that contains this unit as a
	 * subunit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace Name</em>' containment reference.
	 * @see #setNamespaceName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_NamespaceName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getNamespaceName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getNamespaceName <em>Namespace Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Name</em>' containment reference.
	 * @see #getNamespaceName()
	 * @generated
	 */
	void setNamespaceName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.NamespaceDefinition#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The definition of the unit as a namespace.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(NamespaceDefinition)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_Definition()
	 * @see org.eclipse.papyrus.uml.alf.NamespaceDefinition#getUnit
	 * @model opposite="unit" containment="true" required="true"
	 * @generated
	 */
	NamespaceDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(NamespaceDefinition value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ImportReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.uml.alf.ImportReference#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of references to imported elements or packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Import</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_Import()
	 * @see org.eclipse.papyrus.uml.alf.ImportReference#getUnit
	 * @model opposite="unit" containment="true" ordered="false"
	 * @generated
	 */
	EList<ImportReference> getImport();

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the namespace denoted by the declared namespace name for
	 * the unit, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' reference.
	 * @see #setNamespace(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_Namespace()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                  if self.namespaceName = null then\n                    null\n                  else\n                    let referents = self.namespaceName.modelReferents() in\n                      if referents->size() = 1 then\n                        referents->any(true)\n                      else\n                        null\n                      endif\n                  endif'"
	 * @generated
	 */
	ElementReference getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#getNamespace <em>Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Model Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this unit definition is for a model library or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Model Library</em>' attribute.
	 * @see #setIsModelLibrary(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_IsModelLibrary()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n\n                /* TODO: Allow real stereotype application. \052/\n    self.annotation->exists(stereotypeName.pathName = \'ModelLibrary\')'"
	 * @generated
	 */
	boolean isIsModelLibrary();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.UnitDefinition#isIsModelLibrary <em>Is Model Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Model Library</em>' attribute.
	 * @see #isIsModelLibrary()
	 * @generated
	 */
	void setIsModelLibrary(boolean value);

	/**
	 * Returns the value of the '<em><b>Applied Profile</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The profiles applied to this unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Profile</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_AppliedProfile()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.definition.appliedProfiles()'"
	 * @generated
	 */
	EList<ElementReference> getAppliedProfile();

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.StereotypeAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The stereotype annotations on this unit definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getUnitDefinition_Annotation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<StereotypeAnnotation> getAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                  if self.isModelLibrary then\n                    self.import\n                  else\n                    self.import->union(self.implicitImports())\n                  endif'"
	 * @generated
	 */
	EList<ImportReference> imports();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                  Set{\'PrimitiveTypes\', \'PrimitiveBehaviors\', \'BasicInputOutput\', \n                      \'CollectionFunctions\', \'CollectionClasses\'}->\n                    collect(name | self.implicitImportFor(name))->asSet()'"
	 * @generated
	 */
	EList<ImportReference> implicitImports();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                  PackageImportReference {\n                    referentName = QualifiedName{\n                      nameBinding = Sequence{\n                        NameBinding{name = \'Alf\'},\n                        NameBinding{name = \'Library\'},\n                        NameBinding{name = name}\n                      }\n                    }\n                  }'"
	 * @generated
	 */
	ImportReference implicitImportFor(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a unit definition has a declared namespace name, then the containing
	 * namespace for the unit is the referent for that name.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean unitDefinitionNamespaceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declared namespace name for a unit definition, if any, must resolve
	 * to a UML namespace or an Alf unit definition. If it is an Alf unit
	 * definition, then it must have a stub for this unit definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.namespaceName <> null implies\n          let namespace = self.namespace in\n            namespace <> null and namespace.isNamespaceFor(self)'"
	 * @generated
	 */
	boolean unitDefinitionNamespace(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A unit definition is for a model library if its associated namespace
	 * definition has a stereotype annotation for the UML standard stereotype
	 * ModelLibrary.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean unitDefinitionIsModelLibraryDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unless the unit definition is a model library, it has private package
	 * import references for all the sub-packages of the Alf::Library package.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean unitDefinitionImplicitImports(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The profiles applied to a unit definition include any profiles applied
	 * to the containing namespace of the unit definition. If the unit
	 * definition is for a package, then the applied profiles for the unit
	 * definition also include the applied profiles for its associated package
	 * definition.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean unitDefinitionAppliedProfileDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // UnitDefinition
