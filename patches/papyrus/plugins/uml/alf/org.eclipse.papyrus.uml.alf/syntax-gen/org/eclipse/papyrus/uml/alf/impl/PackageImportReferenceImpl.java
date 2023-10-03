/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.PackageImportReference;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PackageImportReferenceImpl extends ImportReferenceImpl implements PackageImportReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImportReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getPackageImportReference();
	}

	/**
	 * The cached invocation delegate for the '{@link #importedMembers() <em>Imported Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #importedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IMPORTED_MEMBERS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageImportReference__ImportedMembers()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Member> importedMembers() {
		try {
			return (EList<Member>)IMPORTED_MEMBERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #packageImportReferenceReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Package Import Reference Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #packageImportReferenceReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_IMPORT_REFERENCE_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.referent <> null and self.referent.isPackage()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean packageImportReferenceReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getPackageImportReference(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getPackageImportReference__PackageImportReferenceReferent__DiagnosticChain_Map(),
				 PACKAGE_IMPORT_REFERENCE_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.PACKAGE_IMPORT_REFERENCE__PACKAGE_IMPORT_REFERENCE_REFERENT);
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
			case AlfPackage.PACKAGE_IMPORT_REFERENCE___IMPORTED_MEMBERS:
				return importedMembers();
			case AlfPackage.PACKAGE_IMPORT_REFERENCE___PACKAGE_IMPORT_REFERENCE_REFERENT__DIAGNOSTICCHAIN_MAP:
				return packageImportReferenceReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // PackageImportReferenceImpl
