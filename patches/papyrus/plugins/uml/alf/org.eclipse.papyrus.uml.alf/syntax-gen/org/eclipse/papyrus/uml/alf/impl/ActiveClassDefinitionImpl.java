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
import org.eclipse.papyrus.uml.alf.ActiveClassDefinition;
import org.eclipse.papyrus.uml.alf.ActivityDefinition;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ClassDefinition;
import org.eclipse.papyrus.uml.alf.ClassifierDefinition;
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Class Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ActiveClassDefinitionImpl#getClassifierBehavior <em>Classifier Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActiveClassDefinitionImpl extends ClassDefinitionImpl implements ActiveClassDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActiveClassDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getActiveClassDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityDefinition getClassifierBehavior() {
		return (ActivityDefinition)eGet(AlfPackage.eINSTANCE.getActiveClassDefinition_ClassifierBehavior(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifierBehavior(ActivityDefinition newClassifierBehavior) {
		eSet(AlfPackage.eINSTANCE.getActiveClassDefinition_ClassifierBehavior(), newClassifierBehavior);
	}

	/**
	 * The cached invocation delegate for the '{@link #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition) <em>Match For Stub</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #matchForStub(org.eclipse.papyrus.uml.alf.UnitDefinition)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MATCH_FOR_STUB_UNIT_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getActiveClassDefinition__MatchForStub__UnitDefinition()).getInvocationDelegate();

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
	 * The cached validation expression for the '{@link #activeClassDefinitionClassifierBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Active Class Definition Classifier Behavior</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #activeClassDefinitionClassifierBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVE_CLASS_DEFINITION_CLASSIFIER_BEHAVIOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      not self.isAbstract implies self.classifierBehavior <> null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean activeClassDefinitionClassifierBehavior(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getActiveClassDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getActiveClassDefinition__ActiveClassDefinitionClassifierBehavior__DiagnosticChain_Map(),
				 ACTIVE_CLASS_DEFINITION_CLASSIFIER_BEHAVIOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ACTIVE_CLASS_DEFINITION__ACTIVE_CLASS_DEFINITION_CLASSIFIER_BEHAVIOR);
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
				case AlfPackage.MEMBER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.ACTIVE_CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ClassifierDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.CLASSIFIER_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.ACTIVE_CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ClassDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION: return AlfPackage.ACTIVE_CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION;
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
			case AlfPackage.ACTIVE_CLASS_DEFINITION___MATCH_FOR_STUB__UNITDEFINITION:
				return matchForStub((UnitDefinition)arguments.get(0));
			case AlfPackage.ACTIVE_CLASS_DEFINITION___ACTIVE_CLASS_DEFINITION_CLASSIFIER_BEHAVIOR__DIAGNOSTICCHAIN_MAP:
				return activeClassDefinitionClassifierBehavior((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ActiveClassDefinitionImpl
