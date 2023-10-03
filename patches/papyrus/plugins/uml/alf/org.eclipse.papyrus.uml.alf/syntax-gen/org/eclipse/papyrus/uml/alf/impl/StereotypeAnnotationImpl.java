/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
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
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.QualifiedNameList;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.TaggedValueList;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StereotypeAnnotationImpl#getTaggedValues <em>Tagged Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StereotypeAnnotationImpl#getNames <em>Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StereotypeAnnotationImpl#getStereotypeName <em>Stereotype Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StereotypeAnnotationImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StereotypeAnnotationImpl extends SyntaxElementImpl implements StereotypeAnnotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getStereotypeAnnotation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedValueList getTaggedValues() {
		return (TaggedValueList)eGet(AlfPackage.eINSTANCE.getStereotypeAnnotation_TaggedValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaggedValues(TaggedValueList newTaggedValues) {
		eSet(AlfPackage.eINSTANCE.getStereotypeAnnotation_TaggedValues(), newTaggedValues);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedNameList getNames() {
		return (QualifiedNameList)eGet(AlfPackage.eINSTANCE.getStereotypeAnnotation_Names(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNames(QualifiedNameList newNames) {
		eSet(AlfPackage.eINSTANCE.getStereotypeAnnotation_Names(), newNames);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getStereotypeName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getStereotypeAnnotation_StereotypeName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeName(QualifiedName newStereotypeName) {
		eSet(AlfPackage.eINSTANCE.getStereotypeAnnotation_StereotypeName(), newStereotypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getStereotype() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getStereotypeAnnotation_Stereotype(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(ElementReference newStereotype) {
		eSet(AlfPackage.eINSTANCE.getStereotypeAnnotation_Stereotype(), newStereotype);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationStereotypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_STEREOTYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "stereotypeAnnotationStereotypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #stereotypeAnnotationStereotypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Stereotype Annotation Stereotype Name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stereotypeAnnotationStereotypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_ANNOTATION_STEREOTYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                let name = self.stereotypeName.pathName in \n" +
		"                  name = 'apply' or name = 'primitive' or name = 'external' or\n" +
		"                  self.stereotype <> null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationStereotypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStereotypeAnnotation(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStereotypeAnnotation__StereotypeAnnotationStereotypeName__DiagnosticChain_Map(),
				 STEREOTYPE_ANNOTATION_STEREOTYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_STEREOTYPE_NAME);
	}

	/**
	 * The cached validation expression for the '{@link #stereotypeAnnotationApply(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Stereotype Annotation Apply</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stereotypeAnnotationApply(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_ANNOTATION_APPLY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                self.stereotypeName.pathName = 'apply' implies names->notEmpty()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationApply(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStereotypeAnnotation(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStereotypeAnnotation__StereotypeAnnotationApply__DiagnosticChain_Map(),
				 STEREOTYPE_ANNOTATION_APPLY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_APPLY);
	}

	/**
	 * The cached validation expression for the '{@link #stereotypeAnnotationPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Stereotype Annotation Primitive</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stereotypeAnnotationPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_ANNOTATION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                self.stereotypeName.pathName = 'primitive' implies\n" +
		"                  (self.taggedValues = null and self.names = null)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStereotypeAnnotation(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStereotypeAnnotation__StereotypeAnnotationPrimitive__DiagnosticChain_Map(),
				 STEREOTYPE_ANNOTATION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_PRIMITIVE);
	}

	/**
	 * The cached validation expression for the '{@link #stereotypeAnnotationExternal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Stereotype Annotation External</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #stereotypeAnnotationExternal(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_ANNOTATION_EXTERNAL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                self.stereotypeName.pathName = 'external' implies\n" +
		"                  (self.names = null and \n" +
		"                    (self.taggedValues = null or \n" +
		"                      self.taggedValues.taggedValue->size() = 1 and \n" +
		"                      self.taggedValues.taggedValue->exists(\n" +
		"                        name = 'file' and operator = null\n" +
		"                      )\n" +
		"                    )\n" +
		"                  )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationExternal(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStereotypeAnnotation(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStereotypeAnnotation__StereotypeAnnotationExternal__DiagnosticChain_Map(),
				 STEREOTYPE_ANNOTATION_EXTERNAL_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_EXTERNAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stereotypeAnnotationTaggedValues(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_TAGGED_VALUES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "stereotypeAnnotationTaggedValues", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean stereotypeAnnotationNames(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.STEREOTYPE_ANNOTATION__STEREOTYPE_ANNOTATION_NAMES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "stereotypeAnnotationNames", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final EOperation.Internal.InvocationDelegate APPLIED_PROFILES__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStereotypeAnnotation__AppliedProfiles()).getInvocationDelegate();

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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_STEREOTYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationStereotypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_STEREOTYPE_NAME__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationStereotypeName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_APPLY__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationApply((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_PRIMITIVE__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationPrimitive((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_EXTERNAL__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationExternal((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_TAGGED_VALUES__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationTaggedValues((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___STEREOTYPE_ANNOTATION_NAMES__DIAGNOSTICCHAIN_MAP:
				return stereotypeAnnotationNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STEREOTYPE_ANNOTATION___APPLIED_PROFILES:
				return appliedProfiles();
		}
		return super.eInvoke(operationID, arguments);
	}

} // StereotypeAnnotationImpl
