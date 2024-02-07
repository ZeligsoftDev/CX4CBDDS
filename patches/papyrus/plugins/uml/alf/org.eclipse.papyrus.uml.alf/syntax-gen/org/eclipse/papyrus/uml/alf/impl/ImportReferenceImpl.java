/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.ImportReference;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ImportReferenceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ImportReferenceImpl#getReferentName <em>Referent Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ImportReferenceImpl#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ImportReferenceImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ImportReferenceImpl extends SyntaxElementImpl implements ImportReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getImportReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibility() {
		return (String)eGet(AlfPackage.eINSTANCE.getImportReference_Visibility(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(String newVisibility) {
		eSet(AlfPackage.eINSTANCE.getImportReference_Visibility(), newVisibility);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getReferentName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getImportReference_ReferentName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferentName(QualifiedName newReferentName) {
		eSet(AlfPackage.eINSTANCE.getImportReference_ReferentName(), newReferentName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReferent() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getImportReference_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(ElementReference newReferent) {
		eSet(AlfPackage.eINSTANCE.getImportReference_Referent(), newReferent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitDefinition getUnit() {
		return (UnitDefinition)eGet(AlfPackage.eINSTANCE.getImportReference_Unit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(UnitDefinition newUnit) {
		eSet(AlfPackage.eINSTANCE.getImportReference_Unit(), newUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Member> importedMembers() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean importReferenceReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.IMPORT_REFERENCE__IMPORT_REFERENCE_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "importReferenceReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #importReferenceReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Import Reference Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #importReferenceReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_REFERENCE_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                  self.referent <> null and\n" +
		"                  let visibility = self.referent.visibility() in \n" +
		"                    visibility = null or visibility = 'public'";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean importReferenceReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getImportReference(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getImportReference__ImportReferenceReferent__DiagnosticChain_Map(),
				 IMPORT_REFERENCE_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.IMPORT_REFERENCE__IMPORT_REFERENCE_REFERENT);
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
			case AlfPackage.IMPORT_REFERENCE___IMPORTED_MEMBERS:
				return importedMembers();
			case AlfPackage.IMPORT_REFERENCE___IMPORT_REFERENCE_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return importReferenceReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.IMPORT_REFERENCE___IMPORT_REFERENCE_REFERENT__DIAGNOSTICCHAIN_MAP:
				return importReferenceReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ImportReferenceImpl
