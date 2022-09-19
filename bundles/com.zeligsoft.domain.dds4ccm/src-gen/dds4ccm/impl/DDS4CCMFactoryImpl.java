/**
 */
package dds4ccm.impl;

import dds4ccm.*;
import dds4ccm.ManagesImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DDS4CCMFactoryImpl extends EFactoryImpl implements DDS4CCMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DDS4CCMFactory init() {
		try {
			DDS4CCMFactory theDDS4CCMFactory = (DDS4CCMFactory)EPackage.Registry.INSTANCE.getEFactory(DDS4CCMPackage.eNS_URI);
			if (theDDS4CCMFactory != null) {
				return theDDS4CCMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DDS4CCMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDS4CCMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DDS4CCMPackage.ASSEMBLY_IMPLEMENTATION: return createAssemblyImplementation();
			case DDS4CCMPackage.STRUCTURAL_REALIZATION: return createStructuralRealization();
			case DDS4CCMPackage.HOME_IMPLEMENTATION: return createHomeImplementation();
			case DDS4CCMPackage.MANAGES_IMPL: return createManagesImpl();
			case DDS4CCMPackage.MONOLITHIC_IMPLEMENTATION: return createMonolithicImplementation();
			case DDS4CCMPackage.IMPLEMENTATION: return createImplementation();
			case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE: return createWorkerFunctionIdentifiable();
			case DDS4CCMPackage.CCM_PART: return createCCMPart();
			case DDS4CCMPackage.CCM_CONNECTOR: return createCCMConnector();
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR: return createAssemblyConnector();
			case DDS4CCMPackage.COMPONENT_INTERFACE: return createComponentInterface();
			case DDS4CCMPackage.MESSAGE_PORT: return createMessagePort();
			case DDS4CCMPackage.PORT_TYPEABLE: return createPortTypeable();
			case DDS4CCMPackage.WORKER_FUNCTION: return createWorkerFunction();
			case DDS4CCMPackage.PORT_TYPE: return createPortType();
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION: return createComponentImplementation();
			case DDS4CCMPackage.PARAMETER: return createParameter();
			case DDS4CCMPackage.MODEL: return createModel();
			case DDS4CCMPackage.EVENT_PORT: return createEventPort();
			case DDS4CCMPackage.CONJUGATED_PORT: return createConjugatedPort();
			case DDS4CCMPackage.CCM_COMPONENT: return createCCMComponent();
			case DDS4CCMPackage.CX_NAMED_ELEMENT: return createCXNamedElement();
			case DDS4CCMPackage.EVENT: return createEvent();
			case DDS4CCMPackage.HOME: return createHome();
			case DDS4CCMPackage.MANAGES: return createManages();
			case DDS4CCMPackage.DDS4CCM_MODEL: return createDDS4CCMModel();
			case DDS4CCMPackage.IDL3_PLUS_MODEL: return createIDL3PlusModel();
			case DDS4CCMPackage.CCM_MODEL: return createCCMModel();
			case DDS4CCMPackage.CXW_STRING: return createCXWString();
			case DDS4CCMPackage.CX_BOUND: return createCXBound();
			case DDS4CCMPackage.CX_CONSTANT: return createCXConstant();
			case DDS4CCMPackage.CX_ANONYMOUS_ARRAY: return createCXAnonymousArray();
			case DDS4CCMPackage.CX_ANONYMOUS_SEQUENCE: return createCXAnonymousSequence();
			case DDS4CCMPackage.CX_ARRAY: return createCXArray();
			case DDS4CCMPackage.CX_BOXED_VALUE: return createCXBoxedValue();
			case DDS4CCMPackage.CX_CASE: return createCXCase();
			case DDS4CCMPackage.CX_UNION_FIELD: return createCXUnionField();
			case DDS4CCMPackage.CX_CONSTANTS: return createCXConstants();
			case DDS4CCMPackage.CX_DEFAULT: return createCXDefault();
			case DDS4CCMPackage.CX_ENUM: return createCXEnum();
			case DDS4CCMPackage.CX_EXCEPTION: return createCXException();
			case DDS4CCMPackage.CX_INTERFACE: return createCXInterface();
			case DDS4CCMPackage.CX_PRIMITIVE: return createCXPrimitive();
			case DDS4CCMPackage.CX_SEQUENCE: return createCXSequence();
			case DDS4CCMPackage.CX_STRING: return createCXString();
			case DDS4CCMPackage.CX_STRUCT: return createCXStruct();
			case DDS4CCMPackage.EXTENSIBLE: return createExtensible();
			case DDS4CCMPackage.CX_SUPPORTS: return createCXSupports();
			case DDS4CCMPackage.CX_TYPE_DEF: return createCXTypeDef();
			case DDS4CCMPackage.CX_UNION: return createCXUnion();
			case DDS4CCMPackage.CX_VALUE: return createCXValue();
			case DDS4CCMPackage.CX_VALUE_FACTORY: return createCXValueFactory();
			case DDS4CCMPackage.CX_MODULE: return createCXModule();
			case DDS4CCMPackage.CX_ATTRIBUTE: return createCXAttribute();
			case DDS4CCMPackage.CX_OPERATION: return createCXOperation();
			case DDS4CCMPackage.CX_FIELD: return createCXField();
			case DDS4CCMPackage.CX_PARAMETER: return createCXParameter();
			case DDS4CCMPackage.STATE_MEMBER: return createStateMember();
			case DDS4CCMPackage.CONNECTOR_DEF: return createConnectorDef();
			case DDS4CCMPackage.CONNECTOR_FRAGMENT: return createConnectorFragment();
			case DDS4CCMPackage.FRAGMENT_IMPLEMENTATION: return createFragmentImplementation();
			case DDS4CCMPackage.FRAGMENT_ASSEMBLY: return createFragmentAssembly();
			case DDS4CCMPackage.CONNECTOR_IMPLEMENTATION: return createConnectorImplementation();
			case DDS4CCMPackage.CONNECTOR_ASSEMBLY: return createConnectorAssembly();
			case DDS4CCMPackage.FRAGMENT_PART: return createFragmentPart();
			case DDS4CCMPackage.TYPED_CONNECTOR: return createTypedConnector();
			case DDS4CCMPackage.TYPE_PARAMETER: return createTypeParameter();
			case DDS4CCMPackage.TEMPLATE_MODULE: return createTemplateModule();
			case DDS4CCMPackage.MODULE_INSTANTIATION: return createModuleInstantiation();
			case DDS4CCMPackage.PARAMETER_BINDING: return createParameterBinding();
			case DDS4CCMPackage.TEMPLATE_MODULE_ALIAS: return createTemplateModuleAlias();
			case DDS4CCMPackage.MODULE_BINDING: return createModuleBinding();
			case DDS4CCMPackage.TEMPLATE_SIGNATURE: return createTemplateSignature();
			case DDS4CCMPackage.INTERFACE_PORT: return createInterfacePort();
			case DDS4CCMPackage.NATIVE: return createNative();
			case DDS4CCMPackage.DATA_SPACE: return createDataSpace();
			case DDS4CCMPackage.TOPIC: return createTopic();
			case DDS4CCMPackage.TOPIC_FIELD: return createTopicField();
			case DDS4CCMPackage.HISTORY_QOS_POLICY: return createhistoryQosPolicy();
			case DDS4CCMPackage.LIFESPAN_QOS_POLICY: return createlifespanQosPolicy();
			case DDS4CCMPackage.DURATION: return createDuration();
			case DDS4CCMPackage.OWNERSHIP_QOS_POLICY: return createownershipQosPolicy();
			case DDS4CCMPackage.OS_QOS_POLICY: return createosQosPolicy();
			case DDS4CCMPackage.WDL_QOS_POLICY: return createwdlQosPolicy();
			case DDS4CCMPackage.RDL_QOS_POLICY: return createrdlQosPolicy();
			case DDS4CCMPackage.UD_QOS_POLICY: return createudQosPolicy();
			case DDS4CCMPackage.TD_QOS_POLICY: return createtdQosPolicy();
			case DDS4CCMPackage.TP_QOS_POLICY: return createtpQosPolicy();
			case DDS4CCMPackage.DEADLINE_QOS_POLICY: return createdeadlineQosPolicy();
			case DDS4CCMPackage.LB_QOS_POLICY: return createlbQosPolicy();
			case DDS4CCMPackage.TBF_QOS_POLICY: return createtbfQosPolicy();
			case DDS4CCMPackage.GD_QOS_POLICY: return creategdQosPolicy();
			case DDS4CCMPackage.EF_QOS_POLICY: return createefQosPolicy();
			case DDS4CCMPackage.RL_QOS_POLICY: return createrlQosPolicy();
			case DDS4CCMPackage.PRESENTATION_QOS_POLICY: return createpresentationQosPolicy();
			case DDS4CCMPackage.PARTITION_QOS_POLICY: return createpartitionQosPolicy();
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY: return createreliabilityQosPolicy();
			case DDS4CCMPackage.DS_QOS_POLICY: return createdsQosPolicy();
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY: return createlivelinessQosPolicy();
			case DDS4CCMPackage.DURABILITY_QOS_POLICY: return createdurabilityQosPolicy();
			case DDS4CCMPackage.DO_QOS_POLICY: return createdoQosPolicy();
			case DDS4CCMPackage.QOS_PROPERTY: return createqosProperty();
			case DDS4CCMPackage.DDS_MESSAGE: return createDDSMessage();
			case DDS4CCMPackage.MESSAGE_FIELD: return createMessageField();
			case DDS4CCMPackage.QO_SPROFILE: return createQoSProfile();
			case DDS4CCMPackage.QO_SENTITY: return createQoSEntity();
			case DDS4CCMPackage.DATA_READER_QO_S: return createDataReaderQoS();
			case DDS4CCMPackage.PARTICIPANT_QO_S: return createParticipantQoS();
			case DDS4CCMPackage.PUBLISHER_QO_S: return createPublisherQoS();
			case DDS4CCMPackage.SUBSCRIBER_QO_S: return createSubscriberQoS();
			case DDS4CCMPackage.TOPIC_QO_S: return createTopicQoS();
			case DDS4CCMPackage.DATA_WRITER_QO_S: return createDataWriterQoS();
			case DDS4CCMPackage.DOMAIN: return createDomain();
			case DDS4CCMPackage.NODE: return createNode();
			case DDS4CCMPackage.NODE_INSTANCE: return createNodeInstance();
			case DDS4CCMPackage.INTERCONNECT: return createInterconnect();
			case DDS4CCMPackage.INTERCONNECT_INSTANCE: return createInterconnectInstance();
			case DDS4CCMPackage.BRIDGE: return createBridge();
			case DDS4CCMPackage.BRIDGE_INSTANCE: return createBridgeInstance();
			case DDS4CCMPackage.RESOURCE: return createResource();
			case DDS4CCMPackage.REQUIREMENT_SATISFIER: return createRequirementSatisfier();
			case DDS4CCMPackage.RESOURCE_PROPERTY: return createResourceProperty();
			case DDS4CCMPackage.SHARED_RESOURCE: return createSharedResource();
			case DDS4CCMPackage.SATISFIER_PROPERTY: return createSatisfierProperty();
			case DDS4CCMPackage.REQUIREMENT: return createRequirement();
			case DDS4CCMPackage.DEPLOYMENT_PLAN: return createDeploymentPlan();
			case DDS4CCMPackage.DEPLOYMENT: return createDeployment();
			case DDS4CCMPackage.ALLOCATION: return createAllocation();
			case DDS4CCMPackage.DEPLOYMENT_PART: return createDeploymentPart();
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART: return createComponentDeploymentPart();
			case DDS4CCMPackage.BUILD_CONFIGURATION: return createBuildConfiguration();
			case DDS4CCMPackage.CONFIGURATION_SLOT: return createConfigurationSlot();
			case DDS4CCMPackage.TARGET_ASSEMBLY_CONNECTOR: return createTargetAssemblyConnector();
			case DDS4CCMPackage.CONTAINER_PROCESS: return createContainerProcess();
			case DDS4CCMPackage.TEMPLATE_PARAMETER_TYPE: return createTemplateParameterType();
			case DDS4CCMPackage.EXTENDED_PORT_TYPE: return createExtendedPortType();
			case DDS4CCMPackage.IDL_FILE_SPECIFICATION: return createIDLFileSpecification();
			case DDS4CCMPackage.IDL_FILE_DEPENDENCY: return createIDLFileDependency();
			case DDS4CCMPackage.PROPERTY: return createProperty();
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING: return createConnectorDefaultValueBinding();
			case DDS4CCMPackage.IDL_INCLUDE_DEPENDENCY: return createIDLIncludeDependency();
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL: return createWorkerFunctionImpl();
			case DDS4CCMPackage.CONNECTOR_STATUS_LISTENER_CONNECTION: return createConnectorStatusListenerConnection();
			case DDS4CCMPackage.FINDER_OPERATION: return createFinderOperation();
			case DDS4CCMPackage.HOME_OPERATION: return createHomeOperation();
			case DDS4CCMPackage.FACTORY_OPERATION: return createFactoryOperation();
			case DDS4CCMPackage.HOME_INSTANCE: return createHomeInstance();
			case DDS4CCMPackage.HIDEABLE_ELEMENT: return createHideableElement();
			case DDS4CCMPackage.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART: return createPerPortConnectorTypeDeploymentPart();
			case DDS4CCMPackage.DOMAIN_DEFINITION: return createDomainDefinition();
			case DDS4CCMPackage.DOMAIN_DEPLOYMENT: return createDomainDeployment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DDS4CCMPackage.COMPONENT_CATEGORY:
				return createComponentCategoryFromString(eDataType, initialValue);
			case DDS4CCMPackage.WIRING_KIND:
				return createWiringKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.MODEL_TYPE_ENUM:
				return createModelTypeEnumFromString(eDataType, initialValue);
			case DDS4CCMPackage.CX_PRIMITIVE_KIND:
				return createCXPrimitiveKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.EXTENSIBILITY_KIND:
				return createExtensibilityKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.TYPE_CONSTRAINT:
				return createTypeConstraintFromString(eDataType, initialValue);
			case DDS4CCMPackage.TOPIC_KIND:
				return createTopicKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.HISTORY_QOS_POLICY_KIND:
				return createHistoryQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.OWNERSHIP_QOS_POLICY_KIND:
				return createOwnershipQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND:
				return createPresentationQosPolicyAccessScopeKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.REALIABILITY_QOS_POLICY_KIND:
				return createRealiabilityQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY_KIND:
				return createLivelinessQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.DURABILITY_QOS_POLICY_KIND:
				return createDurabilityQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.DESTINATION_ORDER_QOS_POLICY_KIND:
				return createDestinationOrderQosPolicyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.SATISFIER_PROPERTY_KIND:
				return createSatisfierPropertyKindFromString(eDataType, initialValue);
			case DDS4CCMPackage.CONFIGURATION_SLOT_KIND:
				return createConfigurationSlotKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DDS4CCMPackage.COMPONENT_CATEGORY:
				return convertComponentCategoryToString(eDataType, instanceValue);
			case DDS4CCMPackage.WIRING_KIND:
				return convertWiringKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.MODEL_TYPE_ENUM:
				return convertModelTypeEnumToString(eDataType, instanceValue);
			case DDS4CCMPackage.CX_PRIMITIVE_KIND:
				return convertCXPrimitiveKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.EXTENSIBILITY_KIND:
				return convertExtensibilityKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.TYPE_CONSTRAINT:
				return convertTypeConstraintToString(eDataType, instanceValue);
			case DDS4CCMPackage.TOPIC_KIND:
				return convertTopicKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.HISTORY_QOS_POLICY_KIND:
				return convertHistoryQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.OWNERSHIP_QOS_POLICY_KIND:
				return convertOwnershipQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND:
				return convertPresentationQosPolicyAccessScopeKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.REALIABILITY_QOS_POLICY_KIND:
				return convertRealiabilityQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY_KIND:
				return convertLivelinessQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.DURABILITY_QOS_POLICY_KIND:
				return convertDurabilityQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.DESTINATION_ORDER_QOS_POLICY_KIND:
				return convertDestinationOrderQosPolicyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.SATISFIER_PROPERTY_KIND:
				return convertSatisfierPropertyKindToString(eDataType, instanceValue);
			case DDS4CCMPackage.CONFIGURATION_SLOT_KIND:
				return convertConfigurationSlotKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyImplementation createAssemblyImplementation() {
		AssemblyImplementationImpl assemblyImplementation = new AssemblyImplementationImpl();
		return assemblyImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuralRealization createStructuralRealization() {
		StructuralRealizationImpl structuralRealization = new StructuralRealizationImpl();
		return structuralRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomeImplementation createHomeImplementation() {
		HomeImplementationImpl homeImplementation = new HomeImplementationImpl();
		return homeImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ManagesImpl createManagesImpl() {
		ManagesImplImpl managesImpl = new ManagesImplImpl();
		return managesImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MonolithicImplementation createMonolithicImplementation() {
		MonolithicImplementationImpl monolithicImplementation = new MonolithicImplementationImpl();
		return monolithicImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Implementation createImplementation() {
		ImplementationImpl implementation = new ImplementationImpl();
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkerFunctionIdentifiable createWorkerFunctionIdentifiable() {
		WorkerFunctionIdentifiableImpl workerFunctionIdentifiable = new WorkerFunctionIdentifiableImpl();
		return workerFunctionIdentifiable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CCMPart createCCMPart() {
		CCMPartImpl ccmPart = new CCMPartImpl();
		return ccmPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CCMConnector createCCMConnector() {
		CCMConnectorImpl ccmConnector = new CCMConnectorImpl();
		return ccmConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyConnector createAssemblyConnector() {
		AssemblyConnectorImpl assemblyConnector = new AssemblyConnectorImpl();
		return assemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInterface createComponentInterface() {
		ComponentInterfaceImpl componentInterface = new ComponentInterfaceImpl();
		return componentInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MessagePort createMessagePort() {
		MessagePortImpl messagePort = new MessagePortImpl();
		return messagePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortTypeable createPortTypeable() {
		PortTypeableImpl portTypeable = new PortTypeableImpl();
		return portTypeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkerFunction createWorkerFunction() {
		WorkerFunctionImpl workerFunction = new WorkerFunctionImpl();
		return workerFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortType createPortType() {
		PortTypeImpl portType = new PortTypeImpl();
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentImplementation createComponentImplementation() {
		ComponentImplementationImpl componentImplementation = new ComponentImplementationImpl();
		return componentImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventPort createEventPort() {
		EventPortImpl eventPort = new EventPortImpl();
		return eventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConjugatedPort createConjugatedPort() {
		ConjugatedPortImpl conjugatedPort = new ConjugatedPortImpl();
		return conjugatedPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CCMComponent createCCMComponent() {
		CCMComponentImpl ccmComponent = new CCMComponentImpl();
		return ccmComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXNamedElement createCXNamedElement() {
		CXNamedElementImpl cxNamedElement = new CXNamedElementImpl();
		return cxNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Home createHome() {
		HomeImpl home = new HomeImpl();
		return home;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Manages createManages() {
		dds4ccm.impl.ManagesImpl manages = new dds4ccm.impl.ManagesImpl();
		return manages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DDS4CCMModel createDDS4CCMModel() {
		DDS4CCMModelImpl dds4CCMModel = new DDS4CCMModelImpl();
		return dds4CCMModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDL3PlusModel createIDL3PlusModel() {
		IDL3PlusModelImpl idl3PlusModel = new IDL3PlusModelImpl();
		return idl3PlusModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CCMModel createCCMModel() {
		CCMModelImpl ccmModel = new CCMModelImpl();
		return ccmModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXWString createCXWString() {
		CXWStringImpl cxwString = new CXWStringImpl();
		return cxwString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXBound createCXBound() {
		CXBoundImpl cxBound = new CXBoundImpl();
		return cxBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXConstant createCXConstant() {
		CXConstantImpl cxConstant = new CXConstantImpl();
		return cxConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXAnonymousArray createCXAnonymousArray() {
		CXAnonymousArrayImpl cxAnonymousArray = new CXAnonymousArrayImpl();
		return cxAnonymousArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXAnonymousSequence createCXAnonymousSequence() {
		CXAnonymousSequenceImpl cxAnonymousSequence = new CXAnonymousSequenceImpl();
		return cxAnonymousSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXArray createCXArray() {
		CXArrayImpl cxArray = new CXArrayImpl();
		return cxArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXBoxedValue createCXBoxedValue() {
		CXBoxedValueImpl cxBoxedValue = new CXBoxedValueImpl();
		return cxBoxedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXCase createCXCase() {
		CXCaseImpl cxCase = new CXCaseImpl();
		return cxCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXUnionField createCXUnionField() {
		CXUnionFieldImpl cxUnionField = new CXUnionFieldImpl();
		return cxUnionField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXConstants createCXConstants() {
		CXConstantsImpl cxConstants = new CXConstantsImpl();
		return cxConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXDefault createCXDefault() {
		CXDefaultImpl cxDefault = new CXDefaultImpl();
		return cxDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXEnum createCXEnum() {
		CXEnumImpl cxEnum = new CXEnumImpl();
		return cxEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXException createCXException() {
		CXExceptionImpl cxException = new CXExceptionImpl();
		return cxException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXInterface createCXInterface() {
		CXInterfaceImpl cxInterface = new CXInterfaceImpl();
		return cxInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXPrimitive createCXPrimitive() {
		CXPrimitiveImpl cxPrimitive = new CXPrimitiveImpl();
		return cxPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXSequence createCXSequence() {
		CXSequenceImpl cxSequence = new CXSequenceImpl();
		return cxSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXString createCXString() {
		CXStringImpl cxString = new CXStringImpl();
		return cxString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXStruct createCXStruct() {
		CXStructImpl cxStruct = new CXStructImpl();
		return cxStruct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Extensible createExtensible() {
		ExtensibleImpl extensible = new ExtensibleImpl();
		return extensible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXSupports createCXSupports() {
		CXSupportsImpl cxSupports = new CXSupportsImpl();
		return cxSupports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXTypeDef createCXTypeDef() {
		CXTypeDefImpl cxTypeDef = new CXTypeDefImpl();
		return cxTypeDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXUnion createCXUnion() {
		CXUnionImpl cxUnion = new CXUnionImpl();
		return cxUnion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXValue createCXValue() {
		CXValueImpl cxValue = new CXValueImpl();
		return cxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXValueFactory createCXValueFactory() {
		CXValueFactoryImpl cxValueFactory = new CXValueFactoryImpl();
		return cxValueFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXModule createCXModule() {
		CXModuleImpl cxModule = new CXModuleImpl();
		return cxModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXAttribute createCXAttribute() {
		CXAttributeImpl cxAttribute = new CXAttributeImpl();
		return cxAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXOperation createCXOperation() {
		CXOperationImpl cxOperation = new CXOperationImpl();
		return cxOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXField createCXField() {
		CXFieldImpl cxField = new CXFieldImpl();
		return cxField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXParameter createCXParameter() {
		CXParameterImpl cxParameter = new CXParameterImpl();
		return cxParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMember createStateMember() {
		StateMemberImpl stateMember = new StateMemberImpl();
		return stateMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorDef createConnectorDef() {
		ConnectorDefImpl connectorDef = new ConnectorDefImpl();
		return connectorDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorFragment createConnectorFragment() {
		ConnectorFragmentImpl connectorFragment = new ConnectorFragmentImpl();
		return connectorFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FragmentImplementation createFragmentImplementation() {
		FragmentImplementationImpl fragmentImplementation = new FragmentImplementationImpl();
		return fragmentImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FragmentAssembly createFragmentAssembly() {
		FragmentAssemblyImpl fragmentAssembly = new FragmentAssemblyImpl();
		return fragmentAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorImplementation createConnectorImplementation() {
		ConnectorImplementationImpl connectorImplementation = new ConnectorImplementationImpl();
		return connectorImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorAssembly createConnectorAssembly() {
		ConnectorAssemblyImpl connectorAssembly = new ConnectorAssemblyImpl();
		return connectorAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FragmentPart createFragmentPart() {
		FragmentPartImpl fragmentPart = new FragmentPartImpl();
		return fragmentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedConnector createTypedConnector() {
		TypedConnectorImpl typedConnector = new TypedConnectorImpl();
		return typedConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeParameter createTypeParameter() {
		TypeParameterImpl typeParameter = new TypeParameterImpl();
		return typeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateModule createTemplateModule() {
		TemplateModuleImpl templateModule = new TemplateModuleImpl();
		return templateModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModuleInstantiation createModuleInstantiation() {
		ModuleInstantiationImpl moduleInstantiation = new ModuleInstantiationImpl();
		return moduleInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterBinding createParameterBinding() {
		ParameterBindingImpl parameterBinding = new ParameterBindingImpl();
		return parameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateModuleAlias createTemplateModuleAlias() {
		TemplateModuleAliasImpl templateModuleAlias = new TemplateModuleAliasImpl();
		return templateModuleAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModuleBinding createModuleBinding() {
		ModuleBindingImpl moduleBinding = new ModuleBindingImpl();
		return moduleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateSignature createTemplateSignature() {
		TemplateSignatureImpl templateSignature = new TemplateSignatureImpl();
		return templateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfacePort createInterfacePort() {
		InterfacePortImpl interfacePort = new InterfacePortImpl();
		return interfacePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Native createNative() {
		NativeImpl native_ = new NativeImpl();
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSpace createDataSpace() {
		DataSpaceImpl dataSpace = new DataSpaceImpl();
		return dataSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Topic createTopic() {
		TopicImpl topic = new TopicImpl();
		return topic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopicField createTopicField() {
		TopicFieldImpl topicField = new TopicFieldImpl();
		return topicField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public historyQosPolicy createhistoryQosPolicy() {
		historyQosPolicyImpl historyQosPolicy = new historyQosPolicyImpl();
		return historyQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public lifespanQosPolicy createlifespanQosPolicy() {
		lifespanQosPolicyImpl lifespanQosPolicy = new lifespanQosPolicyImpl();
		return lifespanQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration createDuration() {
		DurationImpl duration = new DurationImpl();
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ownershipQosPolicy createownershipQosPolicy() {
		ownershipQosPolicyImpl ownershipQosPolicy = new ownershipQosPolicyImpl();
		return ownershipQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public osQosPolicy createosQosPolicy() {
		osQosPolicyImpl osQosPolicy = new osQosPolicyImpl();
		return osQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public wdlQosPolicy createwdlQosPolicy() {
		wdlQosPolicyImpl wdlQosPolicy = new wdlQosPolicyImpl();
		return wdlQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public rdlQosPolicy createrdlQosPolicy() {
		rdlQosPolicyImpl rdlQosPolicy = new rdlQosPolicyImpl();
		return rdlQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public udQosPolicy createudQosPolicy() {
		udQosPolicyImpl udQosPolicy = new udQosPolicyImpl();
		return udQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public tdQosPolicy createtdQosPolicy() {
		tdQosPolicyImpl tdQosPolicy = new tdQosPolicyImpl();
		return tdQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public tpQosPolicy createtpQosPolicy() {
		tpQosPolicyImpl tpQosPolicy = new tpQosPolicyImpl();
		return tpQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public deadlineQosPolicy createdeadlineQosPolicy() {
		deadlineQosPolicyImpl deadlineQosPolicy = new deadlineQosPolicyImpl();
		return deadlineQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public lbQosPolicy createlbQosPolicy() {
		lbQosPolicyImpl lbQosPolicy = new lbQosPolicyImpl();
		return lbQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public tbfQosPolicy createtbfQosPolicy() {
		tbfQosPolicyImpl tbfQosPolicy = new tbfQosPolicyImpl();
		return tbfQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public gdQosPolicy creategdQosPolicy() {
		gdQosPolicyImpl gdQosPolicy = new gdQosPolicyImpl();
		return gdQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public efQosPolicy createefQosPolicy() {
		efQosPolicyImpl efQosPolicy = new efQosPolicyImpl();
		return efQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public rlQosPolicy createrlQosPolicy() {
		rlQosPolicyImpl rlQosPolicy = new rlQosPolicyImpl();
		return rlQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public presentationQosPolicy createpresentationQosPolicy() {
		presentationQosPolicyImpl presentationQosPolicy = new presentationQosPolicyImpl();
		return presentationQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public partitionQosPolicy createpartitionQosPolicy() {
		partitionQosPolicyImpl partitionQosPolicy = new partitionQosPolicyImpl();
		return partitionQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public reliabilityQosPolicy createreliabilityQosPolicy() {
		reliabilityQosPolicyImpl reliabilityQosPolicy = new reliabilityQosPolicyImpl();
		return reliabilityQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public dsQosPolicy createdsQosPolicy() {
		dsQosPolicyImpl dsQosPolicy = new dsQosPolicyImpl();
		return dsQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public livelinessQosPolicy createlivelinessQosPolicy() {
		livelinessQosPolicyImpl livelinessQosPolicy = new livelinessQosPolicyImpl();
		return livelinessQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public durabilityQosPolicy createdurabilityQosPolicy() {
		durabilityQosPolicyImpl durabilityQosPolicy = new durabilityQosPolicyImpl();
		return durabilityQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public doQosPolicy createdoQosPolicy() {
		doQosPolicyImpl doQosPolicy = new doQosPolicyImpl();
		return doQosPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public qosProperty createqosProperty() {
		qosPropertyImpl qosProperty = new qosPropertyImpl();
		return qosProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DDSMessage createDDSMessage() {
		DDSMessageImpl ddsMessage = new DDSMessageImpl();
		return ddsMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MessageField createMessageField() {
		MessageFieldImpl messageField = new MessageFieldImpl();
		return messageField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QoSProfile createQoSProfile() {
		QoSProfileImpl qoSProfile = new QoSProfileImpl();
		return qoSProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QoSEntity createQoSEntity() {
		QoSEntityImpl qoSEntity = new QoSEntityImpl();
		return qoSEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataReaderQoS createDataReaderQoS() {
		DataReaderQoSImpl dataReaderQoS = new DataReaderQoSImpl();
		return dataReaderQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParticipantQoS createParticipantQoS() {
		ParticipantQoSImpl participantQoS = new ParticipantQoSImpl();
		return participantQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PublisherQoS createPublisherQoS() {
		PublisherQoSImpl publisherQoS = new PublisherQoSImpl();
		return publisherQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubscriberQoS createSubscriberQoS() {
		SubscriberQoSImpl subscriberQoS = new SubscriberQoSImpl();
		return subscriberQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopicQoS createTopicQoS() {
		TopicQoSImpl topicQoS = new TopicQoSImpl();
		return topicQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataWriterQoS createDataWriterQoS() {
		DataWriterQoSImpl dataWriterQoS = new DataWriterQoSImpl();
		return dataWriterQoS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeInstance createNodeInstance() {
		NodeInstanceImpl nodeInstance = new NodeInstanceImpl();
		return nodeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interconnect createInterconnect() {
		InterconnectImpl interconnect = new InterconnectImpl();
		return interconnect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterconnectInstance createInterconnectInstance() {
		InterconnectInstanceImpl interconnectInstance = new InterconnectInstanceImpl();
		return interconnectInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bridge createBridge() {
		BridgeImpl bridge = new BridgeImpl();
		return bridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BridgeInstance createBridgeInstance() {
		BridgeInstanceImpl bridgeInstance = new BridgeInstanceImpl();
		return bridgeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementSatisfier createRequirementSatisfier() {
		RequirementSatisfierImpl requirementSatisfier = new RequirementSatisfierImpl();
		return requirementSatisfier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceProperty createResourceProperty() {
		ResourcePropertyImpl resourceProperty = new ResourcePropertyImpl();
		return resourceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SharedResource createSharedResource() {
		SharedResourceImpl sharedResource = new SharedResourceImpl();
		return sharedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SatisfierProperty createSatisfierProperty() {
		SatisfierPropertyImpl satisfierProperty = new SatisfierPropertyImpl();
		return satisfierProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Deployment createDeployment() {
		DeploymentImpl deployment = new DeploymentImpl();
		return deployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Allocation createAllocation() {
		AllocationImpl allocation = new AllocationImpl();
		return allocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeploymentPart createDeploymentPart() {
		DeploymentPartImpl deploymentPart = new DeploymentPartImpl();
		return deploymentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentDeploymentPart createComponentDeploymentPart() {
		ComponentDeploymentPartImpl componentDeploymentPart = new ComponentDeploymentPartImpl();
		return componentDeploymentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuildConfiguration createBuildConfiguration() {
		BuildConfigurationImpl buildConfiguration = new BuildConfigurationImpl();
		return buildConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurationSlot createConfigurationSlot() {
		ConfigurationSlotImpl configurationSlot = new ConfigurationSlotImpl();
		return configurationSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetAssemblyConnector createTargetAssemblyConnector() {
		TargetAssemblyConnectorImpl targetAssemblyConnector = new TargetAssemblyConnectorImpl();
		return targetAssemblyConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainerProcess createContainerProcess() {
		ContainerProcessImpl containerProcess = new ContainerProcessImpl();
		return containerProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateParameterType createTemplateParameterType() {
		TemplateParameterTypeImpl templateParameterType = new TemplateParameterTypeImpl();
		return templateParameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedPortType createExtendedPortType() {
		ExtendedPortTypeImpl extendedPortType = new ExtendedPortTypeImpl();
		return extendedPortType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDLFileSpecification createIDLFileSpecification() {
		IDLFileSpecificationImpl idlFileSpecification = new IDLFileSpecificationImpl();
		return idlFileSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDLFileDependency createIDLFileDependency() {
		IDLFileDependencyImpl idlFileDependency = new IDLFileDependencyImpl();
		return idlFileDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorDefaultValueBinding createConnectorDefaultValueBinding() {
		ConnectorDefaultValueBindingImpl connectorDefaultValueBinding = new ConnectorDefaultValueBindingImpl();
		return connectorDefaultValueBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDLIncludeDependency createIDLIncludeDependency() {
		IDLIncludeDependencyImpl idlIncludeDependency = new IDLIncludeDependencyImpl();
		return idlIncludeDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public dds4ccm.WorkerFunctionImpl createWorkerFunctionImpl() {
		WorkerFunctionImplImpl workerFunctionImpl = new WorkerFunctionImplImpl();
		return workerFunctionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorStatusListenerConnection createConnectorStatusListenerConnection() {
		ConnectorStatusListenerConnectionImpl connectorStatusListenerConnection = new ConnectorStatusListenerConnectionImpl();
		return connectorStatusListenerConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FinderOperation createFinderOperation() {
		FinderOperationImpl finderOperation = new FinderOperationImpl();
		return finderOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomeOperation createHomeOperation() {
		HomeOperationImpl homeOperation = new HomeOperationImpl();
		return homeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FactoryOperation createFactoryOperation() {
		FactoryOperationImpl factoryOperation = new FactoryOperationImpl();
		return factoryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HomeInstance createHomeInstance() {
		HomeInstanceImpl homeInstance = new HomeInstanceImpl();
		return homeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HideableElement createHideableElement() {
		HideableElementImpl hideableElement = new HideableElementImpl();
		return hideableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PerPortConnectorTypeDeploymentPart createPerPortConnectorTypeDeploymentPart() {
		PerPortConnectorTypeDeploymentPartImpl perPortConnectorTypeDeploymentPart = new PerPortConnectorTypeDeploymentPartImpl();
		return perPortConnectorTypeDeploymentPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainDefinition createDomainDefinition() {
		DomainDefinitionImpl domainDefinition = new DomainDefinitionImpl();
		return domainDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainDeployment createDomainDeployment() {
		DomainDeploymentImpl domainDeployment = new DomainDeploymentImpl();
		return domainDeployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentCategory createComponentCategoryFromString(EDataType eDataType, String initialValue) {
		ComponentCategory result = ComponentCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComponentCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WiringKind createWiringKindFromString(EDataType eDataType, String initialValue) {
		WiringKind result = WiringKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWiringKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeEnum createModelTypeEnumFromString(EDataType eDataType, String initialValue) {
		ModelTypeEnum result = ModelTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CXPrimitiveKind createCXPrimitiveKindFromString(EDataType eDataType, String initialValue) {
		CXPrimitiveKind result = CXPrimitiveKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCXPrimitiveKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibilityKind createExtensibilityKindFromString(EDataType eDataType, String initialValue) {
		ExtensibilityKind result = ExtensibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExtensibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeConstraint createTypeConstraintFromString(EDataType eDataType, String initialValue) {
		TypeConstraint result = TypeConstraint.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeConstraintToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicKind createTopicKindFromString(EDataType eDataType, String initialValue) {
		TopicKind result = TopicKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTopicKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryQosPolicyKind createHistoryQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		HistoryQosPolicyKind result = HistoryQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHistoryQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnershipQosPolicyKind createOwnershipQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		OwnershipQosPolicyKind result = OwnershipQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOwnershipQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationQosPolicyAccessScopeKind createPresentationQosPolicyAccessScopeKindFromString(EDataType eDataType, String initialValue) {
		PresentationQosPolicyAccessScopeKind result = PresentationQosPolicyAccessScopeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPresentationQosPolicyAccessScopeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealiabilityQosPolicyKind createRealiabilityQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		RealiabilityQosPolicyKind result = RealiabilityQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealiabilityQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LivelinessQosPolicyKind createLivelinessQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		LivelinessQosPolicyKind result = LivelinessQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLivelinessQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DurabilityQosPolicyKind createDurabilityQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		DurabilityQosPolicyKind result = DurabilityQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDurabilityQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DestinationOrderQosPolicyKind createDestinationOrderQosPolicyKindFromString(EDataType eDataType, String initialValue) {
		DestinationOrderQosPolicyKind result = DestinationOrderQosPolicyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDestinationOrderQosPolicyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SatisfierPropertyKind createSatisfierPropertyKindFromString(EDataType eDataType, String initialValue) {
		SatisfierPropertyKind result = SatisfierPropertyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSatisfierPropertyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationSlotKind createConfigurationSlotKindFromString(EDataType eDataType, String initialValue) {
		ConfigurationSlotKind result = ConfigurationSlotKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConfigurationSlotKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DDS4CCMPackage getDDS4CCMPackage() {
		return (DDS4CCMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DDS4CCMPackage getPackage() {
		return DDS4CCMPackage.eINSTANCE;
	}

} //DDS4CCMFactoryImpl
