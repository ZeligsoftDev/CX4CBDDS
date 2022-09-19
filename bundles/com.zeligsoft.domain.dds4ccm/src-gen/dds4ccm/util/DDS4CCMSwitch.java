/**
 */
package dds4ccm.util;

import dds4ccm.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage
 * @generated
 */
public class DDS4CCMSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DDS4CCMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDS4CCMSwitch() {
		if (modelPackage == null) {
			modelPackage = DDS4CCMPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DDS4CCMPackage.ASSEMBLY_IMPLEMENTATION: {
				AssemblyImplementation assemblyImplementation = (AssemblyImplementation)theEObject;
				T result = caseAssemblyImplementation(assemblyImplementation);
				if (result == null) result = caseStructuralRealization(assemblyImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.STRUCTURAL_REALIZATION: {
				StructuralRealization structuralRealization = (StructuralRealization)theEObject;
				T result = caseStructuralRealization(structuralRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HOME_IMPLEMENTATION: {
				HomeImplementation homeImplementation = (HomeImplementation)theEObject;
				T result = caseHomeImplementation(homeImplementation);
				if (result == null) result = caseStructuralRealization(homeImplementation);
				if (result == null) result = caseManagesImplEnd(homeImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MANAGES_IMPL_END: {
				ManagesImplEnd managesImplEnd = (ManagesImplEnd)theEObject;
				T result = caseManagesImplEnd(managesImplEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MANAGES_IMPL: {
				ManagesImpl managesImpl = (ManagesImpl)theEObject;
				T result = caseManagesImpl(managesImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MONOLITHIC_IMPLEMENTATION: {
				MonolithicImplementation monolithicImplementation = (MonolithicImplementation)theEObject;
				T result = caseMonolithicImplementation(monolithicImplementation);
				if (result == null) result = caseStructuralRealization(monolithicImplementation);
				if (result == null) result = caseWorkerFunctionIdentifiable(monolithicImplementation);
				if (result == null) result = caseImplementation(monolithicImplementation);
				if (result == null) result = caseManagesImplEnd(monolithicImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.IMPLEMENTATION: {
				Implementation implementation = (Implementation)theEObject;
				T result = caseImplementation(implementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE: {
				WorkerFunctionIdentifiable workerFunctionIdentifiable = (WorkerFunctionIdentifiable)theEObject;
				T result = caseWorkerFunctionIdentifiable(workerFunctionIdentifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CCM_PART: {
				CCMPart ccmPart = (CCMPart)theEObject;
				T result = caseCCMPart(ccmPart);
				if (result == null) result = casePart(ccmPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PART: {
				Part part = (Part)theEObject;
				T result = casePart(part);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CCM_CONNECTOR: {
				CCMConnector ccmConnector = (CCMConnector)theEObject;
				T result = caseCCMConnector(ccmConnector);
				if (result == null) result = caseAssemblyConnector(ccmConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR: {
				AssemblyConnector assemblyConnector = (AssemblyConnector)theEObject;
				T result = caseAssemblyConnector(assemblyConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseTypedElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.COMPONENT_INTERFACE: {
				ComponentInterface componentInterface = (ComponentInterface)theEObject;
				T result = caseComponentInterface(componentInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FLOW_PORT: {
				FlowPort flowPort = (FlowPort)theEObject;
				T result = caseFlowPort(flowPort);
				if (result == null) result = casePort(flowPort);
				if (result == null) result = caseTypedElement(flowPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MESSAGE_PORT: {
				MessagePort messagePort = (MessagePort)theEObject;
				T result = caseMessagePort(messagePort);
				if (result == null) result = casePort(messagePort);
				if (result == null) result = caseTypedElement(messagePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				T result = caseInterface(interface_);
				if (result == null) result = casePortTypeable(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PORT_TYPEABLE: {
				PortTypeable portTypeable = (PortTypeable)theEObject;
				T result = casePortTypeable(portTypeable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.WORKER_FUNCTION: {
				WorkerFunction workerFunction = (WorkerFunction)theEObject;
				T result = caseWorkerFunction(workerFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PORT_TYPE: {
				PortType portType = (PortType)theEObject;
				T result = casePortType(portType);
				if (result == null) result = casePortTypeable(portType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION: {
				ComponentImplementation componentImplementation = (ComponentImplementation)theEObject;
				T result = caseComponentImplementation(componentImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.EVENT_PORT: {
				EventPort eventPort = (EventPort)theEObject;
				T result = caseEventPort(eventPort);
				if (result == null) result = casePort(eventPort);
				if (result == null) result = caseConjugatedPort(eventPort);
				if (result == null) result = caseTypedElement(eventPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONJUGATED_PORT: {
				ConjugatedPort conjugatedPort = (ConjugatedPort)theEObject;
				T result = caseConjugatedPort(conjugatedPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CCM_COMPONENT: {
				CCMComponent ccmComponent = (CCMComponent)theEObject;
				T result = caseCCMComponent(ccmComponent);
				if (result == null) result = caseComponentInterface(ccmComponent);
				if (result == null) result = caseCXNamedElement(ccmComponent);
				if (result == null) result = caseCXModuleContained(ccmComponent);
				if (result == null) result = caseCXType(ccmComponent);
				if (result == null) result = caseManagesEnd(ccmComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MANAGES_END: {
				ManagesEnd managesEnd = (ManagesEnd)theEObject;
				T result = caseManagesEnd(managesEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_MODULE_CONTAINED: {
				CXModuleContained cxModuleContained = (CXModuleContained)theEObject;
				T result = caseCXModuleContained(cxModuleContained);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_NAMED_ELEMENT: {
				CXNamedElement cxNamedElement = (CXNamedElement)theEObject;
				T result = caseCXNamedElement(cxNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_TYPE: {
				CXType cxType = (CXType)theEObject;
				T result = caseCXType(cxType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseCXNamedElement(event);
				if (result == null) result = caseInterface(event);
				if (result == null) result = caseCXModuleContained(event);
				if (result == null) result = casePortTypeable(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HOME: {
				Home home = (Home)theEObject;
				T result = caseHome(home);
				if (result == null) result = caseCXNamedElement(home);
				if (result == null) result = caseWorkerFunctionIdentifiable(home);
				if (result == null) result = caseCXModuleContained(home);
				if (result == null) result = caseManagesEnd(home);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MANAGES: {
				Manages manages = (Manages)theEObject;
				T result = caseManages(manages);
				if (result == null) result = caseCXNamedElement(manages);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DDS4CCM_MODEL: {
				DDS4CCMModel dds4CCMModel = (DDS4CCMModel)theEObject;
				T result = caseDDS4CCMModel(dds4CCMModel);
				if (result == null) result = caseIDL3PlusModel(dds4CCMModel);
				if (result == null) result = caseCCMModel(dds4CCMModel);
				if (result == null) result = caseModel(dds4CCMModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.IDL3_PLUS_MODEL: {
				IDL3PlusModel idl3PlusModel = (IDL3PlusModel)theEObject;
				T result = caseIDL3PlusModel(idl3PlusModel);
				if (result == null) result = caseCCMModel(idl3PlusModel);
				if (result == null) result = caseModel(idl3PlusModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CCM_MODEL: {
				CCMModel ccmModel = (CCMModel)theEObject;
				T result = caseCCMModel(ccmModel);
				if (result == null) result = caseModel(ccmModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CXW_STRING: {
				CXWString cxwString = (CXWString)theEObject;
				T result = caseCXWString(cxwString);
				if (result == null) result = caseCXBounded(cxwString);
				if (result == null) result = caseCXClassifierContained(cxwString);
				if (result == null) result = caseCXType(cxwString);
				if (result == null) result = caseCXNamedElement(cxwString);
				if (result == null) result = caseCXModuleContained(cxwString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_BOUNDED: {
				CXBounded cxBounded = (CXBounded)theEObject;
				T result = caseCXBounded(cxBounded);
				if (result == null) result = caseCXNamedElement(cxBounded);
				if (result == null) result = caseCXModuleContained(cxBounded);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_BOUND: {
				CXBound cxBound = (CXBound)theEObject;
				T result = caseCXBound(cxBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CONSTANT: {
				CXConstant cxConstant = (CXConstant)theEObject;
				T result = caseCXConstant(cxConstant);
				if (result == null) result = caseCXNamedElement(cxConstant);
				if (result == null) result = caseCXTyped(cxConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_TYPED: {
				CXTyped cxTyped = (CXTyped)theEObject;
				T result = caseCXTyped(cxTyped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CLASSIFIER_CONTAINED: {
				CXClassifierContained cxClassifierContained = (CXClassifierContained)theEObject;
				T result = caseCXClassifierContained(cxClassifierContained);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_ANONYMOUS_ARRAY: {
				CXAnonymousArray cxAnonymousArray = (CXAnonymousArray)theEObject;
				T result = caseCXAnonymousArray(cxAnonymousArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_ANONYMOUS_SEQUENCE: {
				CXAnonymousSequence cxAnonymousSequence = (CXAnonymousSequence)theEObject;
				T result = caseCXAnonymousSequence(cxAnonymousSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_ARRAY: {
				CXArray cxArray = (CXArray)theEObject;
				T result = caseCXArray(cxArray);
				if (result == null) result = caseCXTemplate(cxArray);
				if (result == null) result = caseContained(cxArray);
				if (result == null) result = caseCXClassifierContained(cxArray);
				if (result == null) result = caseCXModuleContained(cxArray);
				if (result == null) result = caseCXType(cxArray);
				if (result == null) result = caseCXNamedElement(cxArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_TEMPLATE: {
				CXTemplate cxTemplate = (CXTemplate)theEObject;
				T result = caseCXTemplate(cxTemplate);
				if (result == null) result = caseCXNamedElement(cxTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONTAINED: {
				Contained contained = (Contained)theEObject;
				T result = caseContained(contained);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_BOXED_VALUE: {
				CXBoxedValue cxBoxedValue = (CXBoxedValue)theEObject;
				T result = caseCXBoxedValue(cxBoxedValue);
				if (result == null) result = caseCXWrapper(cxBoxedValue);
				if (result == null) result = caseCXNamedElement(cxBoxedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_WRAPPER: {
				CXWrapper cxWrapper = (CXWrapper)theEObject;
				T result = caseCXWrapper(cxWrapper);
				if (result == null) result = caseCXNamedElement(cxWrapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CASE: {
				CXCase cxCase = (CXCase)theEObject;
				T result = caseCXCase(cxCase);
				if (result == null) result = caseCXUnionField(cxCase);
				if (result == null) result = caseCXNamedElement(cxCase);
				if (result == null) result = caseCXTyped(cxCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_UNION_FIELD: {
				CXUnionField cxUnionField = (CXUnionField)theEObject;
				T result = caseCXUnionField(cxUnionField);
				if (result == null) result = caseCXNamedElement(cxUnionField);
				if (result == null) result = caseCXTyped(cxUnionField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CONSTANTS: {
				CXConstants cxConstants = (CXConstants)theEObject;
				T result = caseCXConstants(cxConstants);
				if (result == null) result = caseCXNamedElement(cxConstants);
				if (result == null) result = caseCXClassifierContained(cxConstants);
				if (result == null) result = caseCXModuleContained(cxConstants);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CONSTRUCTED: {
				CXConstructed cxConstructed = (CXConstructed)theEObject;
				T result = caseCXConstructed(cxConstructed);
				if (result == null) result = caseCXNamedElement(cxConstructed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_DEFAULT: {
				CXDefault cxDefault = (CXDefault)theEObject;
				T result = caseCXDefault(cxDefault);
				if (result == null) result = caseCXUnionField(cxDefault);
				if (result == null) result = caseCXNamedElement(cxDefault);
				if (result == null) result = caseCXTyped(cxDefault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_ENUM: {
				CXEnum cxEnum = (CXEnum)theEObject;
				T result = caseCXEnum(cxEnum);
				if (result == null) result = caseCXNamedElement(cxEnum);
				if (result == null) result = caseContained(cxEnum);
				if (result == null) result = caseCXClassifierContained(cxEnum);
				if (result == null) result = caseCXModuleContained(cxEnum);
				if (result == null) result = caseCXType(cxEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_EXCEPTION: {
				CXException cxException = (CXException)theEObject;
				T result = caseCXException(cxException);
				if (result == null) result = caseCXConstructed(cxException);
				if (result == null) result = caseContained(cxException);
				if (result == null) result = caseCXClassifierContained(cxException);
				if (result == null) result = caseCXModuleContained(cxException);
				if (result == null) result = caseCXType(cxException);
				if (result == null) result = caseCXNamedElement(cxException);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_INTERFACE: {
				CXInterface cxInterface = (CXInterface)theEObject;
				T result = caseCXInterface(cxInterface);
				if (result == null) result = caseCXNamedElement(cxInterface);
				if (result == null) result = caseInterface(cxInterface);
				if (result == null) result = caseWorkerFunctionIdentifiable(cxInterface);
				if (result == null) result = caseContained(cxInterface);
				if (result == null) result = caseCXClassifier(cxInterface);
				if (result == null) result = caseCXType(cxInterface);
				if (result == null) result = casePortTypeable(cxInterface);
				if (result == null) result = caseCXModuleContained(cxInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_CLASSIFIER: {
				CXClassifier cxClassifier = (CXClassifier)theEObject;
				T result = caseCXClassifier(cxClassifier);
				if (result == null) result = caseCXModuleContained(cxClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_PRIMITIVE: {
				CXPrimitive cxPrimitive = (CXPrimitive)theEObject;
				T result = caseCXPrimitive(cxPrimitive);
				if (result == null) result = caseCXNamedElement(cxPrimitive);
				if (result == null) result = caseContained(cxPrimitive);
				if (result == null) result = caseCXType(cxPrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_SEQUENCE: {
				CXSequence cxSequence = (CXSequence)theEObject;
				T result = caseCXSequence(cxSequence);
				if (result == null) result = caseCXTemplate(cxSequence);
				if (result == null) result = caseContained(cxSequence);
				if (result == null) result = caseCXClassifierContained(cxSequence);
				if (result == null) result = caseCXModuleContained(cxSequence);
				if (result == null) result = caseCXType(cxSequence);
				if (result == null) result = caseCXNamedElement(cxSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_STRING: {
				CXString cxString = (CXString)theEObject;
				T result = caseCXString(cxString);
				if (result == null) result = caseCXBounded(cxString);
				if (result == null) result = caseCXClassifierContained(cxString);
				if (result == null) result = caseCXType(cxString);
				if (result == null) result = caseCXNamedElement(cxString);
				if (result == null) result = caseCXModuleContained(cxString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_STRUCT: {
				CXStruct cxStruct = (CXStruct)theEObject;
				T result = caseCXStruct(cxStruct);
				if (result == null) result = caseCXConstructed(cxStruct);
				if (result == null) result = caseExtensible(cxStruct);
				if (result == null) result = caseContained(cxStruct);
				if (result == null) result = caseCXClassifierContained(cxStruct);
				if (result == null) result = caseCXModuleContained(cxStruct);
				if (result == null) result = caseCXType(cxStruct);
				if (result == null) result = caseCXNamedElement(cxStruct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.EXTENSIBLE: {
				Extensible extensible = (Extensible)theEObject;
				T result = caseExtensible(extensible);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_SUPPORTS: {
				CXSupports cxSupports = (CXSupports)theEObject;
				T result = caseCXSupports(cxSupports);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_TYPE_DEF: {
				CXTypeDef cxTypeDef = (CXTypeDef)theEObject;
				T result = caseCXTypeDef(cxTypeDef);
				if (result == null) result = caseCXWrapper(cxTypeDef);
				if (result == null) result = caseCXClassifierContained(cxTypeDef);
				if (result == null) result = caseCXModuleContained(cxTypeDef);
				if (result == null) result = caseCXType(cxTypeDef);
				if (result == null) result = caseCXNamedElement(cxTypeDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_UNION: {
				CXUnion cxUnion = (CXUnion)theEObject;
				T result = caseCXUnion(cxUnion);
				if (result == null) result = caseCXConstructed(cxUnion);
				if (result == null) result = caseExtensible(cxUnion);
				if (result == null) result = caseContained(cxUnion);
				if (result == null) result = caseCXClassifierContained(cxUnion);
				if (result == null) result = caseCXModuleContained(cxUnion);
				if (result == null) result = caseCXType(cxUnion);
				if (result == null) result = caseCXNamedElement(cxUnion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_VALUE: {
				CXValue cxValue = (CXValue)theEObject;
				T result = caseCXValue(cxValue);
				if (result == null) result = caseContained(cxValue);
				if (result == null) result = caseCXClassifier(cxValue);
				if (result == null) result = caseCXType(cxValue);
				if (result == null) result = caseCXModuleContained(cxValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_VALUE_FACTORY: {
				CXValueFactory cxValueFactory = (CXValueFactory)theEObject;
				T result = caseCXValueFactory(cxValueFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_MODULE: {
				CXModule cxModule = (CXModule)theEObject;
				T result = caseCXModule(cxModule);
				if (result == null) result = caseCXNamedElement(cxModule);
				if (result == null) result = caseContained(cxModule);
				if (result == null) result = caseCXModuleContained(cxModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_ATTRIBUTE: {
				CXAttribute cxAttribute = (CXAttribute)theEObject;
				T result = caseCXAttribute(cxAttribute);
				if (result == null) result = caseCXNamedElement(cxAttribute);
				if (result == null) result = caseWorkerFunctionIdentifiable(cxAttribute);
				if (result == null) result = caseCXTyped(cxAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_OPERATION: {
				CXOperation cxOperation = (CXOperation)theEObject;
				T result = caseCXOperation(cxOperation);
				if (result == null) result = caseCXNamedElement(cxOperation);
				if (result == null) result = caseWorkerFunctionIdentifiable(cxOperation);
				if (result == null) result = caseCXTyped(cxOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_FIELD: {
				CXField cxField = (CXField)theEObject;
				T result = caseCXField(cxField);
				if (result == null) result = caseCXNamedElement(cxField);
				if (result == null) result = caseCXTyped(cxField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CX_PARAMETER: {
				CXParameter cxParameter = (CXParameter)theEObject;
				T result = caseCXParameter(cxParameter);
				if (result == null) result = caseCXNamedElement(cxParameter);
				if (result == null) result = caseCXTyped(cxParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.STATE_MEMBER: {
				StateMember stateMember = (StateMember)theEObject;
				T result = caseStateMember(stateMember);
				if (result == null) result = caseCXNamedElement(stateMember);
				if (result == null) result = caseCXTyped(stateMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_DEF: {
				ConnectorDef connectorDef = (ConnectorDef)theEObject;
				T result = caseConnectorDef(connectorDef);
				if (result == null) result = caseComponentInterface(connectorDef);
				if (result == null) result = caseCXNamedElement(connectorDef);
				if (result == null) result = caseCXModuleContained(connectorDef);
				if (result == null) result = caseCXType(connectorDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_FRAGMENT: {
				ConnectorFragment connectorFragment = (ConnectorFragment)theEObject;
				T result = caseConnectorFragment(connectorFragment);
				if (result == null) result = caseComponentInterface(connectorFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FRAGMENT_IMPLEMENTATION: {
				FragmentImplementation fragmentImplementation = (FragmentImplementation)theEObject;
				T result = caseFragmentImplementation(fragmentImplementation);
				if (result == null) result = caseStructuralRealization(fragmentImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FRAGMENT_ASSEMBLY: {
				FragmentAssembly fragmentAssembly = (FragmentAssembly)theEObject;
				T result = caseFragmentAssembly(fragmentAssembly);
				if (result == null) result = caseStructuralRealization(fragmentAssembly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_IMPLEMENTATION: {
				ConnectorImplementation connectorImplementation = (ConnectorImplementation)theEObject;
				T result = caseConnectorImplementation(connectorImplementation);
				if (result == null) result = caseStructuralRealization(connectorImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_ASSEMBLY: {
				ConnectorAssembly connectorAssembly = (ConnectorAssembly)theEObject;
				T result = caseConnectorAssembly(connectorAssembly);
				if (result == null) result = caseStructuralRealization(connectorAssembly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FRAGMENT_PART: {
				FragmentPart fragmentPart = (FragmentPart)theEObject;
				T result = caseFragmentPart(fragmentPart);
				if (result == null) result = casePart(fragmentPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TYPED_CONNECTOR: {
				TypedConnector typedConnector = (TypedConnector)theEObject;
				T result = caseTypedConnector(typedConnector);
				if (result == null) result = caseAssemblyConnector(typedConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TYPE_PARAMETER: {
				TypeParameter typeParameter = (TypeParameter)theEObject;
				T result = caseTypeParameter(typeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TEMPLATE_MODULE: {
				TemplateModule templateModule = (TemplateModule)theEObject;
				T result = caseTemplateModule(templateModule);
				if (result == null) result = caseCXNamedElement(templateModule);
				if (result == null) result = caseCXModuleContained(templateModule);
				if (result == null) result = caseCXType(templateModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MODULE_INSTANTIATION: {
				ModuleInstantiation moduleInstantiation = (ModuleInstantiation)theEObject;
				T result = caseModuleInstantiation(moduleInstantiation);
				if (result == null) result = caseCXNamedElement(moduleInstantiation);
				if (result == null) result = caseCXModuleContained(moduleInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PARAMETER_BINDING: {
				ParameterBinding parameterBinding = (ParameterBinding)theEObject;
				T result = caseParameterBinding(parameterBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TEMPLATE_MODULE_ALIAS: {
				TemplateModuleAlias templateModuleAlias = (TemplateModuleAlias)theEObject;
				T result = caseTemplateModuleAlias(templateModuleAlias);
				if (result == null) result = caseCXNamedElement(templateModuleAlias);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MODULE_BINDING: {
				ModuleBinding moduleBinding = (ModuleBinding)theEObject;
				T result = caseModuleBinding(moduleBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TEMPLATE_SIGNATURE: {
				TemplateSignature templateSignature = (TemplateSignature)theEObject;
				T result = caseTemplateSignature(templateSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.INTERFACE_PORT: {
				InterfacePort interfacePort = (InterfacePort)theEObject;
				T result = caseInterfacePort(interfacePort);
				if (result == null) result = caseMessagePort(interfacePort);
				if (result == null) result = caseConjugatedPort(interfacePort);
				if (result == null) result = caseWorkerFunctionIdentifiable(interfacePort);
				if (result == null) result = casePort(interfacePort);
				if (result == null) result = caseTypedElement(interfacePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.NATIVE: {
				Native native_ = (Native)theEObject;
				T result = caseNative(native_);
				if (result == null) result = caseCXNamedElement(native_);
				if (result == null) result = caseCXClassifierContained(native_);
				if (result == null) result = caseCXModuleContained(native_);
				if (result == null) result = caseCXType(native_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DATA_SPACE: {
				DataSpace dataSpace = (DataSpace)theEObject;
				T result = caseDataSpace(dataSpace);
				if (result == null) result = casePart(dataSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TOPIC: {
				Topic topic = (Topic)theEObject;
				T result = caseTopic(topic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TOPIC_FIELD: {
				TopicField topicField = (TopicField)theEObject;
				T result = caseTopicField(topicField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.QOS_POLICY: {
				qosPolicy qosPolicy = (qosPolicy)theEObject;
				T result = caseqosPolicy(qosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HISTORY_QOS_POLICY: {
				historyQosPolicy historyQosPolicy = (historyQosPolicy)theEObject;
				T result = casehistoryQosPolicy(historyQosPolicy);
				if (result == null) result = caseqosPolicy(historyQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.LIFESPAN_QOS_POLICY: {
				lifespanQosPolicy lifespanQosPolicy = (lifespanQosPolicy)theEObject;
				T result = caselifespanQosPolicy(lifespanQosPolicy);
				if (result == null) result = caseqosPolicy(lifespanQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DURATION: {
				Duration duration = (Duration)theEObject;
				T result = caseDuration(duration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.OWNERSHIP_QOS_POLICY: {
				ownershipQosPolicy ownershipQosPolicy = (ownershipQosPolicy)theEObject;
				T result = caseownershipQosPolicy(ownershipQosPolicy);
				if (result == null) result = caseqosPolicy(ownershipQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.OS_QOS_POLICY: {
				osQosPolicy osQosPolicy = (osQosPolicy)theEObject;
				T result = caseosQosPolicy(osQosPolicy);
				if (result == null) result = caseqosPolicy(osQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.WDL_QOS_POLICY: {
				wdlQosPolicy wdlQosPolicy = (wdlQosPolicy)theEObject;
				T result = casewdlQosPolicy(wdlQosPolicy);
				if (result == null) result = caseqosPolicy(wdlQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.RDL_QOS_POLICY: {
				rdlQosPolicy rdlQosPolicy = (rdlQosPolicy)theEObject;
				T result = caserdlQosPolicy(rdlQosPolicy);
				if (result == null) result = caseqosPolicy(rdlQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.UD_QOS_POLICY: {
				udQosPolicy udQosPolicy = (udQosPolicy)theEObject;
				T result = caseudQosPolicy(udQosPolicy);
				if (result == null) result = caseqosPolicy(udQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TD_QOS_POLICY: {
				tdQosPolicy tdQosPolicy = (tdQosPolicy)theEObject;
				T result = casetdQosPolicy(tdQosPolicy);
				if (result == null) result = caseqosPolicy(tdQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TP_QOS_POLICY: {
				tpQosPolicy tpQosPolicy = (tpQosPolicy)theEObject;
				T result = casetpQosPolicy(tpQosPolicy);
				if (result == null) result = caseqosPolicy(tpQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DEADLINE_QOS_POLICY: {
				deadlineQosPolicy deadlineQosPolicy = (deadlineQosPolicy)theEObject;
				T result = casedeadlineQosPolicy(deadlineQosPolicy);
				if (result == null) result = caseqosPolicy(deadlineQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.LB_QOS_POLICY: {
				lbQosPolicy lbQosPolicy = (lbQosPolicy)theEObject;
				T result = caselbQosPolicy(lbQosPolicy);
				if (result == null) result = caseqosPolicy(lbQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TBF_QOS_POLICY: {
				tbfQosPolicy tbfQosPolicy = (tbfQosPolicy)theEObject;
				T result = casetbfQosPolicy(tbfQosPolicy);
				if (result == null) result = caseqosPolicy(tbfQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.GD_QOS_POLICY: {
				gdQosPolicy gdQosPolicy = (gdQosPolicy)theEObject;
				T result = casegdQosPolicy(gdQosPolicy);
				if (result == null) result = caseqosPolicy(gdQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.EF_QOS_POLICY: {
				efQosPolicy efQosPolicy = (efQosPolicy)theEObject;
				T result = caseefQosPolicy(efQosPolicy);
				if (result == null) result = caseqosPolicy(efQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.RL_QOS_POLICY: {
				rlQosPolicy rlQosPolicy = (rlQosPolicy)theEObject;
				T result = caserlQosPolicy(rlQosPolicy);
				if (result == null) result = caseqosPolicy(rlQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PRESENTATION_QOS_POLICY: {
				presentationQosPolicy presentationQosPolicy = (presentationQosPolicy)theEObject;
				T result = casepresentationQosPolicy(presentationQosPolicy);
				if (result == null) result = caseqosPolicy(presentationQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PARTITION_QOS_POLICY: {
				partitionQosPolicy partitionQosPolicy = (partitionQosPolicy)theEObject;
				T result = casepartitionQosPolicy(partitionQosPolicy);
				if (result == null) result = caseqosPolicy(partitionQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY: {
				reliabilityQosPolicy reliabilityQosPolicy = (reliabilityQosPolicy)theEObject;
				T result = casereliabilityQosPolicy(reliabilityQosPolicy);
				if (result == null) result = caseqosPolicy(reliabilityQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DS_QOS_POLICY: {
				dsQosPolicy dsQosPolicy = (dsQosPolicy)theEObject;
				T result = casedsQosPolicy(dsQosPolicy);
				if (result == null) result = caseqosPolicy(dsQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY: {
				livelinessQosPolicy livelinessQosPolicy = (livelinessQosPolicy)theEObject;
				T result = caselivelinessQosPolicy(livelinessQosPolicy);
				if (result == null) result = caseqosPolicy(livelinessQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DURABILITY_QOS_POLICY: {
				durabilityQosPolicy durabilityQosPolicy = (durabilityQosPolicy)theEObject;
				T result = casedurabilityQosPolicy(durabilityQosPolicy);
				if (result == null) result = caseqosPolicy(durabilityQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DO_QOS_POLICY: {
				doQosPolicy doQosPolicy = (doQosPolicy)theEObject;
				T result = casedoQosPolicy(doQosPolicy);
				if (result == null) result = caseqosPolicy(doQosPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.QOS_PROPERTY: {
				qosProperty qosProperty = (qosProperty)theEObject;
				T result = caseqosProperty(qosProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DDS_MESSAGE: {
				DDSMessage ddsMessage = (DDSMessage)theEObject;
				T result = caseDDSMessage(ddsMessage);
				if (result == null) result = caseCXStruct(ddsMessage);
				if (result == null) result = caseCXConstructed(ddsMessage);
				if (result == null) result = caseExtensible(ddsMessage);
				if (result == null) result = caseContained(ddsMessage);
				if (result == null) result = caseCXClassifierContained(ddsMessage);
				if (result == null) result = caseCXModuleContained(ddsMessage);
				if (result == null) result = caseCXType(ddsMessage);
				if (result == null) result = caseCXNamedElement(ddsMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.MESSAGE_FIELD: {
				MessageField messageField = (MessageField)theEObject;
				T result = caseMessageField(messageField);
				if (result == null) result = caseCXField(messageField);
				if (result == null) result = caseCXNamedElement(messageField);
				if (result == null) result = caseCXTyped(messageField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.QO_SPROFILE: {
				QoSProfile qoSProfile = (QoSProfile)theEObject;
				T result = caseQoSProfile(qoSProfile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.QO_SFOR_ENTITY: {
				QoSForEntity qoSForEntity = (QoSForEntity)theEObject;
				T result = caseQoSForEntity(qoSForEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.QO_SENTITY: {
				QoSEntity qoSEntity = (QoSEntity)theEObject;
				T result = caseQoSEntity(qoSEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DATA_READER_QO_S: {
				DataReaderQoS dataReaderQoS = (DataReaderQoS)theEObject;
				T result = caseDataReaderQoS(dataReaderQoS);
				if (result == null) result = caseDataReaderWriterQoS(dataReaderQoS);
				if (result == null) result = caseQoSForEntity(dataReaderQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DATA_READER_WRITER_QO_S: {
				DataReaderWriterQoS dataReaderWriterQoS = (DataReaderWriterQoS)theEObject;
				T result = caseDataReaderWriterQoS(dataReaderWriterQoS);
				if (result == null) result = caseQoSForEntity(dataReaderWriterQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PARTICIPANT_QO_S: {
				ParticipantQoS participantQoS = (ParticipantQoS)theEObject;
				T result = caseParticipantQoS(participantQoS);
				if (result == null) result = caseQoSForEntity(participantQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PUBLISHER_QO_S: {
				PublisherQoS publisherQoS = (PublisherQoS)theEObject;
				T result = casePublisherQoS(publisherQoS);
				if (result == null) result = casePublisherSubscriberQoS(publisherQoS);
				if (result == null) result = caseQoSForEntity(publisherQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PUBLISHER_SUBSCRIBER_QO_S: {
				PublisherSubscriberQoS publisherSubscriberQoS = (PublisherSubscriberQoS)theEObject;
				T result = casePublisherSubscriberQoS(publisherSubscriberQoS);
				if (result == null) result = caseQoSForEntity(publisherSubscriberQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.SUBSCRIBER_QO_S: {
				SubscriberQoS subscriberQoS = (SubscriberQoS)theEObject;
				T result = caseSubscriberQoS(subscriberQoS);
				if (result == null) result = casePublisherSubscriberQoS(subscriberQoS);
				if (result == null) result = caseQoSForEntity(subscriberQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TOPIC_QO_S: {
				TopicQoS topicQoS = (TopicQoS)theEObject;
				T result = caseTopicQoS(topicQoS);
				if (result == null) result = caseQoSForEntity(topicQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DATA_WRITER_QO_S: {
				DataWriterQoS dataWriterQoS = (DataWriterQoS)theEObject;
				T result = caseDataWriterQoS(dataWriterQoS);
				if (result == null) result = caseDataReaderWriterQoS(dataWriterQoS);
				if (result == null) result = caseQoSForEntity(dataWriterQoS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DOMAIN: {
				Domain domain = (Domain)theEObject;
				T result = caseDomain(domain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.NODE_INSTANCE: {
				NodeInstance nodeInstance = (NodeInstance)theEObject;
				T result = caseNodeInstance(nodeInstance);
				if (result == null) result = caseTypedElement(nodeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.INTERCONNECT: {
				Interconnect interconnect = (Interconnect)theEObject;
				T result = caseInterconnect(interconnect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.INTERCONNECT_INSTANCE: {
				InterconnectInstance interconnectInstance = (InterconnectInstance)theEObject;
				T result = caseInterconnectInstance(interconnectInstance);
				if (result == null) result = caseTypedElement(interconnectInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.BRIDGE: {
				Bridge bridge = (Bridge)theEObject;
				T result = caseBridge(bridge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.BRIDGE_INSTANCE: {
				BridgeInstance bridgeInstance = (BridgeInstance)theEObject;
				T result = caseBridgeInstance(bridgeInstance);
				if (result == null) result = caseTypedElement(bridgeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseRequirementSatisfier(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.REQUIREMENT_SATISFIER: {
				RequirementSatisfier requirementSatisfier = (RequirementSatisfier)theEObject;
				T result = caseRequirementSatisfier(requirementSatisfier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.RESOURCE_PROPERTY: {
				ResourceProperty resourceProperty = (ResourceProperty)theEObject;
				T result = caseResourceProperty(resourceProperty);
				if (result == null) result = caseTypedElement(resourceProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.SHARED_RESOURCE: {
				SharedResource sharedResource = (SharedResource)theEObject;
				T result = caseSharedResource(sharedResource);
				if (result == null) result = caseResourceProperty(sharedResource);
				if (result == null) result = caseTypedElement(sharedResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.SATISFIER_PROPERTY: {
				SatisfierProperty satisfierProperty = (SatisfierProperty)theEObject;
				T result = caseSatisfierProperty(satisfierProperty);
				if (result == null) result = caseTypedElement(satisfierProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.REQUIREMENT: {
				Requirement requirement = (Requirement)theEObject;
				T result = caseRequirement(requirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DEPLOYMENT_PLAN: {
				DeploymentPlan deploymentPlan = (DeploymentPlan)theEObject;
				T result = caseDeploymentPlan(deploymentPlan);
				if (result == null) result = caseDeployment(deploymentPlan);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DEPLOYMENT: {
				Deployment deployment = (Deployment)theEObject;
				T result = caseDeployment(deployment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.ALLOCATION: {
				Allocation allocation = (Allocation)theEObject;
				T result = caseAllocation(allocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DEPLOYMENT_PART: {
				DeploymentPart deploymentPart = (DeploymentPart)theEObject;
				T result = caseDeploymentPart(deploymentPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART: {
				ComponentDeploymentPart componentDeploymentPart = (ComponentDeploymentPart)theEObject;
				T result = caseComponentDeploymentPart(componentDeploymentPart);
				if (result == null) result = caseDeploymentPart(componentDeploymentPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.BUILD_CONFIGURATION: {
				BuildConfiguration buildConfiguration = (BuildConfiguration)theEObject;
				T result = caseBuildConfiguration(buildConfiguration);
				if (result == null) result = caseConfiguration(buildConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONFIGURATION_SLOT: {
				ConfigurationSlot configurationSlot = (ConfigurationSlot)theEObject;
				T result = caseConfigurationSlot(configurationSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TARGET_ASSEMBLY_CONNECTOR: {
				TargetAssemblyConnector targetAssemblyConnector = (TargetAssemblyConnector)theEObject;
				T result = caseTargetAssemblyConnector(targetAssemblyConnector);
				if (result == null) result = caseAssemblyConnector(targetAssemblyConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONTAINER_PROCESS: {
				ContainerProcess containerProcess = (ContainerProcess)theEObject;
				T result = caseContainerProcess(containerProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.TEMPLATE_PARAMETER_TYPE: {
				TemplateParameterType templateParameterType = (TemplateParameterType)theEObject;
				T result = caseTemplateParameterType(templateParameterType);
				if (result == null) result = caseCXType(templateParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.EXTENDED_PORT_TYPE: {
				ExtendedPortType extendedPortType = (ExtendedPortType)theEObject;
				T result = caseExtendedPortType(extendedPortType);
				if (result == null) result = casePortType(extendedPortType);
				if (result == null) result = caseCXNamedElement(extendedPortType);
				if (result == null) result = caseCXModuleContained(extendedPortType);
				if (result == null) result = caseCXType(extendedPortType);
				if (result == null) result = casePortTypeable(extendedPortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.IDL_FILE_SPECIFICATION: {
				IDLFileSpecification idlFileSpecification = (IDLFileSpecification)theEObject;
				T result = caseIDLFileSpecification(idlFileSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.IDL_FILE_DEPENDENCY: {
				IDLFileDependency idlFileDependency = (IDLFileDependency)theEObject;
				T result = caseIDLFileDependency(idlFileDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseTypedElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING: {
				ConnectorDefaultValueBinding connectorDefaultValueBinding = (ConnectorDefaultValueBinding)theEObject;
				T result = caseConnectorDefaultValueBinding(connectorDefaultValueBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.IDL_INCLUDE_DEPENDENCY: {
				IDLIncludeDependency idlIncludeDependency = (IDLIncludeDependency)theEObject;
				T result = caseIDLIncludeDependency(idlIncludeDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL: {
				WorkerFunctionImpl workerFunctionImpl = (WorkerFunctionImpl)theEObject;
				T result = caseWorkerFunctionImpl(workerFunctionImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.CONNECTOR_STATUS_LISTENER_CONNECTION: {
				ConnectorStatusListenerConnection connectorStatusListenerConnection = (ConnectorStatusListenerConnection)theEObject;
				T result = caseConnectorStatusListenerConnection(connectorStatusListenerConnection);
				if (result == null) result = caseCCMConnector(connectorStatusListenerConnection);
				if (result == null) result = caseAssemblyConnector(connectorStatusListenerConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FINDER_OPERATION: {
				FinderOperation finderOperation = (FinderOperation)theEObject;
				T result = caseFinderOperation(finderOperation);
				if (result == null) result = caseHomeOperation(finderOperation);
				if (result == null) result = caseCXNamedElement(finderOperation);
				if (result == null) result = caseWorkerFunctionIdentifiable(finderOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HOME_OPERATION: {
				HomeOperation homeOperation = (HomeOperation)theEObject;
				T result = caseHomeOperation(homeOperation);
				if (result == null) result = caseCXNamedElement(homeOperation);
				if (result == null) result = caseWorkerFunctionIdentifiable(homeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.FACTORY_OPERATION: {
				FactoryOperation factoryOperation = (FactoryOperation)theEObject;
				T result = caseFactoryOperation(factoryOperation);
				if (result == null) result = caseHomeOperation(factoryOperation);
				if (result == null) result = caseCXNamedElement(factoryOperation);
				if (result == null) result = caseWorkerFunctionIdentifiable(factoryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HOME_INSTANCE: {
				HomeInstance homeInstance = (HomeInstance)theEObject;
				T result = caseHomeInstance(homeInstance);
				if (result == null) result = casePart(homeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.HIDEABLE_ELEMENT: {
				HideableElement hideableElement = (HideableElement)theEObject;
				T result = caseHideableElement(hideableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART: {
				PerPortConnectorTypeDeploymentPart perPortConnectorTypeDeploymentPart = (PerPortConnectorTypeDeploymentPart)theEObject;
				T result = casePerPortConnectorTypeDeploymentPart(perPortConnectorTypeDeploymentPart);
				if (result == null) result = caseDeploymentPart(perPortConnectorTypeDeploymentPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DOMAIN_DEFINITION: {
				DomainDefinition domainDefinition = (DomainDefinition)theEObject;
				T result = caseDomainDefinition(domainDefinition);
				if (result == null) result = caseDomain(domainDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DDS4CCMPackage.DOMAIN_DEPLOYMENT: {
				DomainDeployment domainDeployment = (DomainDeployment)theEObject;
				T result = caseDomainDeployment(domainDeployment);
				if (result == null) result = caseDeployment(domainDeployment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyImplementation(AssemblyImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Realization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralRealization(StructuralRealization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomeImplementation(HomeImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manages Impl End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manages Impl End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagesImplEnd(ManagesImplEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manages Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manages Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagesImpl(ManagesImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monolithic Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monolithic Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonolithicImplementation(MonolithicImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementation(Implementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Worker Function Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Worker Function Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkerFunctionIdentifiable(WorkerFunctionIdentifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCM Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCM Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCMPart(CCMPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePart(Part object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCM Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCM Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCMConnector(CCMConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyConnector(AssemblyConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentInterface(ComponentInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowPort(FlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessagePort(MessagePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Typeable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Typeable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortTypeable(PortTypeable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Worker Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Worker Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkerFunction(WorkerFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortType(PortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentImplementation(ComponentImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventPort(EventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conjugated Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conjugated Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConjugatedPort(ConjugatedPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCM Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCM Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCMComponent(CCMComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manages End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manages End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagesEnd(ManagesEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Module Contained</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Module Contained</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXModuleContained(CXModuleContained object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXNamedElement(CXNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXType(CXType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHome(Home object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manages</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manages</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManages(Manages object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDDS4CCMModel(DDS4CCMModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDL3 Plus Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDL3 Plus Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDL3PlusModel(IDL3PlusModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCM Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCM Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCMModel(CCMModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CXW String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CXW String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXWString(CXWString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Bounded</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Bounded</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXBounded(CXBounded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXBound(CXBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXConstant(CXConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Typed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Typed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXTyped(CXTyped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Classifier Contained</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Classifier Contained</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXClassifierContained(CXClassifierContained object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Anonymous Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Anonymous Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXAnonymousArray(CXAnonymousArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Anonymous Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Anonymous Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXAnonymousSequence(CXAnonymousSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXArray(CXArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXTemplate(CXTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contained</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contained</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContained(Contained object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Boxed Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Boxed Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXBoxedValue(CXBoxedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXWrapper(CXWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXCase(CXCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Union Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Union Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXUnionField(CXUnionField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Constants</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Constants</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXConstants(CXConstants object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Constructed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Constructed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXConstructed(CXConstructed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Default</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Default</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXDefault(CXDefault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXEnum(CXEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXException(CXException object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXInterface(CXInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXClassifier(CXClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXPrimitive(CXPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXSequence(CXSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXString(CXString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXStruct(CXStruct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensible(Extensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Supports</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Supports</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXSupports(CXSupports object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Type Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Type Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXTypeDef(CXTypeDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Union</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Union</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXUnion(CXUnion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXValue(CXValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Value Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Value Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXValueFactory(CXValueFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXModule(CXModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXAttribute(CXAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXOperation(CXOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXField(CXField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CX Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CX Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCXParameter(CXParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMember(StateMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorDef(ConnectorDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorFragment(ConnectorFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentImplementation(FragmentImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Assembly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentAssembly(FragmentAssembly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorImplementation(ConnectorImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Assembly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorAssembly(ConnectorAssembly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentPart(FragmentPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedConnector(TypedConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeParameter(TypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateModule(TemplateModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleInstantiation(ModuleInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterBinding(ParameterBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Module Alias</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Module Alias</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateModuleAlias(TemplateModuleAlias object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleBinding(ModuleBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateSignature(TemplateSignature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfacePort(InterfacePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Native</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Native</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNative(Native object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSpace(DataSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Topic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Topic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopic(Topic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Topic Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Topic Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopicField(TopicField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseqosPolicy(qosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>history Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>history Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casehistoryQosPolicy(historyQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>lifespan Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>lifespan Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caselifespanQosPolicy(lifespanQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDuration(Duration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ownership Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ownership Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseownershipQosPolicy(ownershipQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>os Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>os Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseosQosPolicy(osQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>wdl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>wdl Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casewdlQosPolicy(wdlQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rdl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rdl Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserdlQosPolicy(rdlQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ud Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ud Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseudQosPolicy(udQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>td Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>td Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetdQosPolicy(tdQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>tp Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>tp Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetpQosPolicy(tpQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>deadline Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>deadline Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedeadlineQosPolicy(deadlineQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>lb Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>lb Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caselbQosPolicy(lbQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>tbf Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>tbf Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casetbfQosPolicy(tbfQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>gd Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>gd Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casegdQosPolicy(gdQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ef Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ef Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseefQosPolicy(efQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>rl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>rl Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caserlQosPolicy(rlQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>presentation Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>presentation Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepresentationQosPolicy(presentationQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>partition Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>partition Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casepartitionQosPolicy(partitionQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>reliability Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>reliability Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casereliabilityQosPolicy(reliabilityQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ds Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ds Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedsQosPolicy(dsQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>liveliness Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>liveliness Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caselivelinessQosPolicy(livelinessQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>durability Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>durability Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedurabilityQosPolicy(durabilityQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>do Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>do Qos Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedoQosPolicy(doQosPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>qos Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>qos Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseqosProperty(qosProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DDS Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DDS Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDDSMessage(DDSMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageField(MessageField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qo SProfile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qo SProfile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQoSProfile(QoSProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qo SFor Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qo SFor Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQoSForEntity(QoSForEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qo SEntity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qo SEntity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQoSEntity(QoSEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderQoS(DataReaderQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Reader Writer Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reader Writer Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReaderWriterQoS(DataReaderWriterQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipantQoS(ParticipantQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publisher Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publisher Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublisherQoS(PublisherQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publisher Subscriber Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publisher Subscriber Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublisherSubscriberQoS(PublisherSubscriberQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subscriber Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subscriber Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubscriberQoS(SubscriberQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Topic Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Topic Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopicQoS(TopicQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Writer Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Writer Qo S</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataWriterQoS(DataWriterQoS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeInstance(NodeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interconnect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interconnect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterconnect(Interconnect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interconnect Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interconnect Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterconnectInstance(InterconnectInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBridge(Bridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bridge Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bridge Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBridgeInstance(BridgeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Satisfier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Satisfier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementSatisfier(RequirementSatisfier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceProperty(ResourceProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSharedResource(SharedResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Satisfier Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Satisfier Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSatisfierProperty(SatisfierProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Plan</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Plan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentPlan(DeploymentPlan object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeployment(Deployment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocation(Allocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentPart(DeploymentPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Deployment Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentDeploymentPart(ComponentDeploymentPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Build Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Build Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildConfiguration(BuildConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationSlot(ConfigurationSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Assembly Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetAssemblyConnector(TargetAssemblyConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerProcess(ContainerProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterType(TemplateParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedPortType(ExtendedPortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDL File Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDL File Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDLFileSpecification(IDLFileSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDL File Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDL File Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDLFileDependency(IDLFileDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Default Value Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Default Value Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorDefaultValueBinding(ConnectorDefaultValueBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDL Include Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDL Include Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDLIncludeDependency(IDLIncludeDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Worker Function Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Worker Function Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkerFunctionImpl(WorkerFunctionImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Status Listener Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Status Listener Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorStatusListenerConnection(ConnectorStatusListenerConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Finder Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Finder Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinderOperation(FinderOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomeOperation(HomeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Factory Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Factory Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFactoryOperation(FactoryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomeInstance(HomeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hideable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hideable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHideableElement(HideableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Per Port Connector Type Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Per Port Connector Type Deployment Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerPortConnectorTypeDeploymentPart(PerPortConnectorTypeDeploymentPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainDefinition(DomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Deployment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainDeployment(DomainDeployment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DDS4CCMSwitch
