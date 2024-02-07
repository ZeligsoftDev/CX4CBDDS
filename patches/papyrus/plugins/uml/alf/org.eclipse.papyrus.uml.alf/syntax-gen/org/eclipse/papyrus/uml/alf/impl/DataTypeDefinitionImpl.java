/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ClassifierDefinition;
import org.eclipse.papyrus.uml.alf.DataTypeDefinition;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.NamespaceDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DataTypeDefinitionImpl extends ClassifierDefinitionImpl implements DataTypeDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getDataTypeDefinition();
	}

	/**
	 * The cached invocation delegate for the '{@link #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Match For Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getDataTypeDefinition__MatchForStub__UnitDefinition()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getDataTypeDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Same Kind As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getDataTypeDefinition__IsSameKindAs__ElementReference()).getInvocationDelegate();

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
	 * The cached validation expression for the '{@link #dataTypeDefinitionPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Type Definition Primitive</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #dataTypeDefinitionPrimitive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_DEFINITION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.isPrimitive implies self.ownedMember->isEmpty()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean dataTypeDefinitionPrimitive(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getDataTypeDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getDataTypeDefinition__DataTypeDefinitionPrimitive__DiagnosticChain_Map(),
				 DATA_TYPE_DEFINITION_PRIMITIVE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.DATA_TYPE_DEFINITION__DATA_TYPE_DEFINITION_PRIMITIVE);
	}

	/**
	 * The cached validation expression for the '{@link #dataTypeDefinitionSpecializationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Type Definition Specialization Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #dataTypeDefinitionSpecializationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_DEFINITION_SPECIALIZATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.specializationReferent->forAll(isDataType())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean dataTypeDefinitionSpecializationReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getDataTypeDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getDataTypeDefinition__DataTypeDefinitionSpecializationReferent__DiagnosticChain_Map(),
				 DATA_TYPE_DEFINITION_SPECIALIZATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.DATA_TYPE_DEFINITION__DATA_TYPE_DEFINITION_SPECIALIZATION_REFERENT);
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
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.DATA_TYPE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.DATA_TYPE_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				case AlfPackage.MEMBER_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.DATA_TYPE_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == NamespaceDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.NAMESPACE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.DATA_TYPE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ClassifierDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.CLASSIFIER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.DATA_TYPE_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
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
			case AlfPackage.DATA_TYPE_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION:
				return matchForStub((UnitDefinition)arguments.get(0));
			case AlfPackage.DATA_TYPE_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.DATA_TYPE_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.DATA_TYPE_DEFINITION___DATA_TYPE_DEFINITION_PRIMITIVE__DIAGNOSTICCHAIN_MAP:
				return dataTypeDefinitionPrimitive((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.DATA_TYPE_DEFINITION___DATA_TYPE_DEFINITION_SPECIALIZATION_REFERENT__DIAGNOSTICCHAIN_MAP:
				return dataTypeDefinitionSpecializationReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // DataTypeDefinitionImpl
