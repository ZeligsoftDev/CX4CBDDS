/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.ImportReference;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getNamespaceName <em>Namespace Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#isIsModelLibrary <em>Is Model Library</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getAppliedProfile <em>Applied Profile</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.UnitDefinitionImpl#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitDefinitionImpl extends DocumentedElementImpl implements UnitDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getUnitDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getNamespaceName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getUnitDefinition_NamespaceName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceName(QualifiedName newNamespaceName) {
		eSet(AlfPackage.eINSTANCE.getUnitDefinition_NamespaceName(), newNamespaceName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceDefinition getDefinition() {
		return (NamespaceDefinition)eGet(AlfPackage.eINSTANCE.getUnitDefinition_Definition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(NamespaceDefinition newDefinition) {
		eSet(AlfPackage.eINSTANCE.getUnitDefinition_Definition(), newDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ImportReference> getImport() {
		return (EList<ImportReference>)eGet(AlfPackage.eINSTANCE.getUnitDefinition_Import(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getNamespace() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getUnitDefinition_Namespace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(ElementReference newNamespace) {
		eSet(AlfPackage.eINSTANCE.getUnitDefinition_Namespace(), newNamespace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsModelLibrary() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getUnitDefinition_IsModelLibrary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsModelLibrary(boolean newIsModelLibrary) {
		eSet(AlfPackage.eINSTANCE.getUnitDefinition_IsModelLibrary(), newIsModelLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getAppliedProfile() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getUnitDefinition_AppliedProfile(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StereotypeAnnotation> getAnnotation() {
		return (EList<StereotypeAnnotation>)eGet(AlfPackage.eINSTANCE.getUnitDefinition_Annotation(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #imports() <em>Imports</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #imports()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPORTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getUnitDefinition__Imports()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ImportReference> imports() {
		try {
			return (EList<ImportReference>)IMPORTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #implicitImports() <em>Implicit Imports</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #implicitImports()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPLICIT_IMPORTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getUnitDefinition__ImplicitImports()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ImportReference> implicitImports() {
		try {
			return (EList<ImportReference>)IMPLICIT_IMPORTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #implicitImportFor(java.lang.String) <em>Implicit Import For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #implicitImportFor(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPLICIT_IMPORT_FOR_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getUnitDefinition__ImplicitImportFor__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportReference implicitImportFor(String name) {
		try {
			return (ImportReference)IMPLICIT_IMPORT_FOR_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unitDefinitionNamespaceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.UNIT_DEFINITION__UNIT_DEFINITION_NAMESPACE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "unitDefinitionNamespaceDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #unitDefinitionNamespace(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Unit Definition Namespace</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #unitDefinitionNamespace(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_DEFINITION_NAMESPACE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.namespaceName <> null implies\n" +
		"          let namespace = self.namespace in\n" +
		"            namespace <> null and namespace.isNamespaceFor(self)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unitDefinitionNamespace(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getUnitDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getUnitDefinition__UnitDefinitionNamespace__DiagnosticChain_Map(),
				 UNIT_DEFINITION_NAMESPACE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.UNIT_DEFINITION__UNIT_DEFINITION_NAMESPACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unitDefinitionIsModelLibraryDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.UNIT_DEFINITION__UNIT_DEFINITION_IS_MODEL_LIBRARY_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "unitDefinitionIsModelLibraryDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unitDefinitionImplicitImports(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.UNIT_DEFINITION__UNIT_DEFINITION_IMPLICIT_IMPORTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "unitDefinitionImplicitImports", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unitDefinitionAppliedProfileDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.UNIT_DEFINITION__UNIT_DEFINITION_APPLIED_PROFILE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "unitDefinitionAppliedProfileDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.UNIT_DEFINITION___IMPORTS:
				return imports();
			case AlfPackage.UNIT_DEFINITION___IMPLICIT_IMPORTS:
				return implicitImports();
			case AlfPackage.UNIT_DEFINITION___IMPLICIT_IMPORT_FOR__STRING:
				return implicitImportFor((String)arguments.get(0));
			case AlfPackage.UNIT_DEFINITION___UNIT_DEFINITION_NAMESPACE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return unitDefinitionNamespaceDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.UNIT_DEFINITION___UNIT_DEFINITION_NAMESPACE__DIAGNOSTICCHAIN_MAP:
				return unitDefinitionNamespace((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.UNIT_DEFINITION___UNIT_DEFINITION_IS_MODEL_LIBRARY_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return unitDefinitionIsModelLibraryDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.UNIT_DEFINITION___UNIT_DEFINITION_IMPLICIT_IMPORTS__DIAGNOSTICCHAIN_MAP:
				return unitDefinitionImplicitImports((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.UNIT_DEFINITION___UNIT_DEFINITION_APPLIED_PROFILE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return unitDefinitionAppliedProfileDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // UnitDefinitionImpl
