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
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.NameBinding;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;
import org.eclipse.papyrus.uml.alf.validation.ModelNamespaceFacade;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#isIsAmbiguous <em>Is Ambiguous</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#isIsFeatureReference <em>Is Feature Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getQualification <em>Qualification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getDisambiguation <em>Disambiguation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getNameBinding <em>Name Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getUnqualifiedName <em>Unqualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.QualifiedNameImpl#getTemplateName <em>Template Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameImpl extends SyntaxElementImpl implements QualifiedName {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected QualifiedNameImpl() {
		super();
		this.registerCaching();
	}

	public void clear() {
		super.clear();
		this.referents = null;
		this.disambiguation = null;
		this.notDisambiguated = true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getQualifiedName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAmbiguous() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getQualifiedName_IsAmbiguous(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAmbiguous(boolean newIsAmbiguous) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_IsAmbiguous(), newIsAmbiguous);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathName() {
		return (String)eGet(AlfPackage.eINSTANCE.getQualifiedName_PathName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(String newPathName) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_PathName(), newPathName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFeatureReference() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getQualifiedName_IsFeatureReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFeatureReference(boolean newIsFeatureReference) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_IsFeatureReference(), newIsFeatureReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getQualificationGen() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getQualifiedName_Qualification(), true);
	}

	private QualifiedName qualification = null;

	public QualifiedName getQualification() {
		if (this.qualification == null) {
			this.qualification = this.getQualificationGen();
		}
		return this.qualification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualification(QualifiedName newQualification) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_Qualification(), newQualification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference getDisambiguation() {
		return (FeatureReference)eGet(AlfPackage.eINSTANCE.getQualifiedName_Disambiguation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisambiguation(FeatureReference newDisambiguation) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_Disambiguation(), newDisambiguation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NameBinding> getNameBinding() {
		return (EList<NameBinding>)eGet(AlfPackage.eINSTANCE.getQualifiedName_NameBinding(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getReferent() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getQualifiedName_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameBinding getUnqualifiedName() {
		return (NameBinding)eGet(AlfPackage.eINSTANCE.getQualifiedName_UnqualifiedName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnqualifiedName(NameBinding newUnqualifiedName) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_UnqualifiedName(), newUnqualifiedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTemplateName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getQualifiedName_TemplateName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateName(QualifiedName newTemplateName) {
		eSet(AlfPackage.eINSTANCE.getQualifiedName_TemplateName(), newTemplateName);
	}

	/**
	 * The cached invocation delegate for the '{@link #copy() <em>Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #copy()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate COPY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getQualifiedName__Copy()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName copy() {
		try {
			return (QualifiedName)COPY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #addName(java.lang.String) <em>Add Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #addName(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ADD_NAME_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getQualifiedName__AddName__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName addName(String name) {
		try {
			return (QualifiedName)ADD_NAME_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #addNameBindings(org.eclipse.emf.common.util.EList) <em>Add Name Bindings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #addNameBindings(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ADD_NAME_BINDINGS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getQualifiedName__AddNameBindings__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName addNameBindings(EList<NameBinding> nameBindings) {
		try {
			return (QualifiedName)ADD_NAME_BINDINGS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{nameBindings}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ElementReference> modelReferents() {
		return ModelNamespaceFacade.getInstance().resolveInModelScope(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean qualifiedNameUnqualifiedNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_UNQUALIFIED_NAME_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameUnqualifiedNameDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNamePathNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_PATH_NAME_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNamePathNameDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameIsFeatureReferenceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_IS_FEATURE_REFERENCE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameIsFeatureReferenceDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameQualificationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_QUALIFICATION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameQualificationDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameDisambiguationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_DISAMBIGUATION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameDisambiguationDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameLocalName(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_LOCAL_NAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameLocalName", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameNonLocalUnqualifiedName(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_NON_LOCAL_UNQUALIFIED_NAME,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameNonLocalUnqualifiedName", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean qualifiedNameQualifiedResolution(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_QUALIFIED_RESOLUTION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameQualifiedResolution", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #qualifiedNameTemplateBinding(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Qualified Name Template Binding</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedNameTemplateBinding(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_TEMPLATE_BINDING_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      self.templateName <> null implies\n" +
		"        let templates = self.templateName.referent in \n" +
		"          templates->size() = 1 and \n" +
		"          templates->forAll(template | \n" +
		"            template.isTemplate() and \n" +
		"            self.unqualifiedName.binding.matches(template)\n" +
		"          )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean qualifiedNameTemplateBinding(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getQualifiedName(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getQualifiedName__QualifiedNameTemplateBinding__DiagnosticChain_Map(),
				 QUALIFIED_NAME_TEMPLATE_BINDING_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_TEMPLATE_BINDING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean qualifiedNameTemplateNameDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.QUALIFIED_NAME__QUALIFIED_NAME_TEMPLATE_NAME_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "qualifiedNameTemplateNameDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	private FeatureReference disambiguation = null;
	private boolean notDisambiguated = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureReference disambiguationCached() {
		if (this.notDisambiguated) {
			this.disambiguation = this.disambiguation();
			this.notDisambiguated = false;
		}
		return this.disambiguation;
	}

	/**
	 * The cached invocation delegate for the '{@link #disambiguation() <em>Disambiguation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #disambiguation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate DISAMBIGUATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getQualifiedName__Disambiguation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference disambiguation() {
		try {
			return (FeatureReference)DISAMBIGUATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	private EList<ElementReference> referents = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ElementReference> referentCached() {
		if (this.referents == null) {
			this.referents = this.referent();
		}
		return this.referents;
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getQualifiedName__Referent()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> referent() {
		try {
			return (EList<ElementReference>)REFERENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.QUALIFIED_NAME___COPY:
				return copy();
			case AlfPackage.QUALIFIED_NAME___ADD_NAME__STRING:
				return addName((String)arguments.get(0));
			case AlfPackage.QUALIFIED_NAME___ADD_NAME_BINDINGS__ELIST:
				return addNameBindings((EList<NameBinding>)arguments.get(0));
			case AlfPackage.QUALIFIED_NAME___MODEL_REFERENTS:
				return modelReferents();
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_UNQUALIFIED_NAME_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameUnqualifiedNameDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_PATH_NAME_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNamePathNameDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_IS_FEATURE_REFERENCE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameIsFeatureReferenceDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_QUALIFICATION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameQualificationDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_DISAMBIGUATION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameDisambiguationDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_LOCAL_NAME__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameLocalName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_NON_LOCAL_UNQUALIFIED_NAME__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameNonLocalUnqualifiedName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_QUALIFIED_RESOLUTION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameQualifiedResolution((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_TEMPLATE_BINDING__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameTemplateBinding((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___QUALIFIED_NAME_TEMPLATE_NAME_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return qualifiedNameTemplateNameDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.QUALIFIED_NAME___DISAMBIGUATION_CACHED:
				return disambiguationCached();
			case AlfPackage.QUALIFIED_NAME___DISAMBIGUATION:
				return disambiguation();
			case AlfPackage.QUALIFIED_NAME___REFERENT_CACHED:
				return referentCached();
			case AlfPackage.QUALIFIED_NAME___REFERENT:
				return referent();
		}
		return super.eInvoke(operationID, arguments);
	}

} // QualifiedNameImpl
