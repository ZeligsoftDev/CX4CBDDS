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
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.PackageDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PackageDefinitionImpl#getAppliedProfile <em>Applied Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageDefinitionImpl extends NamespaceDefinitionImpl implements PackageDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getPackageDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getAppliedProfile() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getPackageDefinition_AppliedProfile(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #allowPackageOnly() <em>Allow Package Only</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allowPackageOnly()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ALLOW_PACKAGE_ONLY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageDefinition__AllowPackageOnly()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean allowPackageOnly() {
		try {
			return (Boolean)ALLOW_PACKAGE_ONLY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		try {
			return (Boolean)ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Match For Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageDefinition__MatchForStub__UnitDefinition()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matchForStub(UnitDefinition unit) {
		try {
			return (Boolean)MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{unit}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Same Kind As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageDefinition__IsSameKindAs__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSameKindAs(ElementReference member) {
		try {
			return (Boolean)IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{member}));
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
	public boolean packageDefinitionAppliedProfileDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PACKAGE_DEFINITION__PACKAGE_DEFINITION_APPLIED_PROFILE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "packageDefinitionAppliedProfileDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached invocation delegate for the '{@link #appliedProfiles() <em>Applied Profiles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #appliedProfiles()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPackageDefinition__AppliedProfiles()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> appliedProfiles() {
		try {
			return (EList<ElementReference>)APPLIED_PROFILES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MemberDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.PACKAGE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.PACKAGE_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				case AlfPackage.MEMBER_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.PACKAGE_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NamespaceDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.NAMESPACE_DEFINITION___APPLIED_PROFILES: return AlfPackage.PACKAGE_DEFINITION___APPLIED_PROFILES;
				case AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.PACKAGE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case AlfPackage.PACKAGE_DEFINITION___ALLOW_PACKAGE_ONLY:
				return allowPackageOnly();
			case AlfPackage.PACKAGE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.PACKAGE_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION:
				return matchForStub((UnitDefinition)arguments.get(0));
			case AlfPackage.PACKAGE_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.PACKAGE_DEFINITION___PACKAGE_DEFINITION_APPLIED_PROFILE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return packageDefinitionAppliedProfileDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PACKAGE_DEFINITION___APPLIED_PROFILES:
				return appliedProfiles();
		}
		return super.eInvoke(operationID, arguments);
	}

} // PackageDefinitionImpl
