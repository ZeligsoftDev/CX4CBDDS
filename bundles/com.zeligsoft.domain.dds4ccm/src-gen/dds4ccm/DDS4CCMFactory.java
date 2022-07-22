/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMPackage
 * @generated
 */
public interface DDS4CCMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DDS4CCMFactory eINSTANCE = dds4ccm.impl.DDS4CCMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Assembly Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assembly Implementation</em>'.
	 * @generated
	 */
	AssemblyImplementation createAssemblyImplementation();

	/**
	 * Returns a new object of class '<em>Structural Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Realization</em>'.
	 * @generated
	 */
	StructuralRealization createStructuralRealization();

	/**
	 * Returns a new object of class '<em>Home Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Home Implementation</em>'.
	 * @generated
	 */
	HomeImplementation createHomeImplementation();

	/**
	 * Returns a new object of class '<em>Manages Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manages Impl</em>'.
	 * @generated
	 */
	ManagesImpl createManagesImpl();

	/**
	 * Returns a new object of class '<em>Monolithic Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Monolithic Implementation</em>'.
	 * @generated
	 */
	MonolithicImplementation createMonolithicImplementation();

	/**
	 * Returns a new object of class '<em>Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation</em>'.
	 * @generated
	 */
	Implementation createImplementation();

	/**
	 * Returns a new object of class '<em>Worker Function Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Worker Function Identifiable</em>'.
	 * @generated
	 */
	WorkerFunctionIdentifiable createWorkerFunctionIdentifiable();

	/**
	 * Returns a new object of class '<em>CCM Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCM Part</em>'.
	 * @generated
	 */
	CCMPart createCCMPart();

	/**
	 * Returns a new object of class '<em>CCM Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCM Connector</em>'.
	 * @generated
	 */
	CCMConnector createCCMConnector();

	/**
	 * Returns a new object of class '<em>Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assembly Connector</em>'.
	 * @generated
	 */
	AssemblyConnector createAssemblyConnector();

	/**
	 * Returns a new object of class '<em>Component Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Interface</em>'.
	 * @generated
	 */
	ComponentInterface createComponentInterface();

	/**
	 * Returns a new object of class '<em>Message Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Port</em>'.
	 * @generated
	 */
	MessagePort createMessagePort();

	/**
	 * Returns a new object of class '<em>Port Typeable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Typeable</em>'.
	 * @generated
	 */
	PortTypeable createPortTypeable();

	/**
	 * Returns a new object of class '<em>Worker Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Worker Function</em>'.
	 * @generated
	 */
	WorkerFunction createWorkerFunction();

	/**
	 * Returns a new object of class '<em>Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Type</em>'.
	 * @generated
	 */
	PortType createPortType();

	/**
	 * Returns a new object of class '<em>Component Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Implementation</em>'.
	 * @generated
	 */
	ComponentImplementation createComponentImplementation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Port</em>'.
	 * @generated
	 */
	EventPort createEventPort();

	/**
	 * Returns a new object of class '<em>Conjugated Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conjugated Port</em>'.
	 * @generated
	 */
	ConjugatedPort createConjugatedPort();

	/**
	 * Returns a new object of class '<em>CCM Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCM Component</em>'.
	 * @generated
	 */
	CCMComponent createCCMComponent();

	/**
	 * Returns a new object of class '<em>CX Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Named Element</em>'.
	 * @generated
	 */
	CXNamedElement createCXNamedElement();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Home</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Home</em>'.
	 * @generated
	 */
	Home createHome();

	/**
	 * Returns a new object of class '<em>Manages</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manages</em>'.
	 * @generated
	 */
	Manages createManages();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	DDS4CCMModel createDDS4CCMModel();

	/**
	 * Returns a new object of class '<em>IDL3 Plus Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IDL3 Plus Model</em>'.
	 * @generated
	 */
	IDL3PlusModel createIDL3PlusModel();

	/**
	 * Returns a new object of class '<em>CCM Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCM Model</em>'.
	 * @generated
	 */
	CCMModel createCCMModel();

	/**
	 * Returns a new object of class '<em>CXW String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CXW String</em>'.
	 * @generated
	 */
	CXWString createCXWString();

	/**
	 * Returns a new object of class '<em>CX Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Bound</em>'.
	 * @generated
	 */
	CXBound createCXBound();

	/**
	 * Returns a new object of class '<em>CX Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Constant</em>'.
	 * @generated
	 */
	CXConstant createCXConstant();

	/**
	 * Returns a new object of class '<em>CX Anonymous Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Anonymous Array</em>'.
	 * @generated
	 */
	CXAnonymousArray createCXAnonymousArray();

	/**
	 * Returns a new object of class '<em>CX Anonymous Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Anonymous Sequence</em>'.
	 * @generated
	 */
	CXAnonymousSequence createCXAnonymousSequence();

	/**
	 * Returns a new object of class '<em>CX Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Array</em>'.
	 * @generated
	 */
	CXArray createCXArray();

	/**
	 * Returns a new object of class '<em>CX Boxed Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Boxed Value</em>'.
	 * @generated
	 */
	CXBoxedValue createCXBoxedValue();

	/**
	 * Returns a new object of class '<em>CX Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Case</em>'.
	 * @generated
	 */
	CXCase createCXCase();

	/**
	 * Returns a new object of class '<em>CX Union Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Union Field</em>'.
	 * @generated
	 */
	CXUnionField createCXUnionField();

	/**
	 * Returns a new object of class '<em>CX Constants</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Constants</em>'.
	 * @generated
	 */
	CXConstants createCXConstants();

	/**
	 * Returns a new object of class '<em>CX Default</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Default</em>'.
	 * @generated
	 */
	CXDefault createCXDefault();

	/**
	 * Returns a new object of class '<em>CX Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Enum</em>'.
	 * @generated
	 */
	CXEnum createCXEnum();

	/**
	 * Returns a new object of class '<em>CX Exception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Exception</em>'.
	 * @generated
	 */
	CXException createCXException();

	/**
	 * Returns a new object of class '<em>CX Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Interface</em>'.
	 * @generated
	 */
	CXInterface createCXInterface();

	/**
	 * Returns a new object of class '<em>CX Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Primitive</em>'.
	 * @generated
	 */
	CXPrimitive createCXPrimitive();

	/**
	 * Returns a new object of class '<em>CX Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Sequence</em>'.
	 * @generated
	 */
	CXSequence createCXSequence();

	/**
	 * Returns a new object of class '<em>CX String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX String</em>'.
	 * @generated
	 */
	CXString createCXString();

	/**
	 * Returns a new object of class '<em>CX Struct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Struct</em>'.
	 * @generated
	 */
	CXStruct createCXStruct();

	/**
	 * Returns a new object of class '<em>Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extensible</em>'.
	 * @generated
	 */
	Extensible createExtensible();

	/**
	 * Returns a new object of class '<em>CX Supports</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Supports</em>'.
	 * @generated
	 */
	CXSupports createCXSupports();

	/**
	 * Returns a new object of class '<em>CX Type Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Type Def</em>'.
	 * @generated
	 */
	CXTypeDef createCXTypeDef();

	/**
	 * Returns a new object of class '<em>CX Union</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Union</em>'.
	 * @generated
	 */
	CXUnion createCXUnion();

	/**
	 * Returns a new object of class '<em>CX Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Value</em>'.
	 * @generated
	 */
	CXValue createCXValue();

	/**
	 * Returns a new object of class '<em>CX Value Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Value Factory</em>'.
	 * @generated
	 */
	CXValueFactory createCXValueFactory();

	/**
	 * Returns a new object of class '<em>CX Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Module</em>'.
	 * @generated
	 */
	CXModule createCXModule();

	/**
	 * Returns a new object of class '<em>CX Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Attribute</em>'.
	 * @generated
	 */
	CXAttribute createCXAttribute();

	/**
	 * Returns a new object of class '<em>CX Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Operation</em>'.
	 * @generated
	 */
	CXOperation createCXOperation();

	/**
	 * Returns a new object of class '<em>CX Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Field</em>'.
	 * @generated
	 */
	CXField createCXField();

	/**
	 * Returns a new object of class '<em>CX Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CX Parameter</em>'.
	 * @generated
	 */
	CXParameter createCXParameter();

	/**
	 * Returns a new object of class '<em>State Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Member</em>'.
	 * @generated
	 */
	StateMember createStateMember();

	/**
	 * Returns a new object of class '<em>Connector Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Def</em>'.
	 * @generated
	 */
	ConnectorDef createConnectorDef();

	/**
	 * Returns a new object of class '<em>Connector Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Fragment</em>'.
	 * @generated
	 */
	ConnectorFragment createConnectorFragment();

	/**
	 * Returns a new object of class '<em>Fragment Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Implementation</em>'.
	 * @generated
	 */
	FragmentImplementation createFragmentImplementation();

	/**
	 * Returns a new object of class '<em>Fragment Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Assembly</em>'.
	 * @generated
	 */
	FragmentAssembly createFragmentAssembly();

	/**
	 * Returns a new object of class '<em>Connector Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Implementation</em>'.
	 * @generated
	 */
	ConnectorImplementation createConnectorImplementation();

	/**
	 * Returns a new object of class '<em>Connector Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Assembly</em>'.
	 * @generated
	 */
	ConnectorAssembly createConnectorAssembly();

	/**
	 * Returns a new object of class '<em>Fragment Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Part</em>'.
	 * @generated
	 */
	FragmentPart createFragmentPart();

	/**
	 * Returns a new object of class '<em>Typed Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Connector</em>'.
	 * @generated
	 */
	TypedConnector createTypedConnector();

	/**
	 * Returns a new object of class '<em>Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Parameter</em>'.
	 * @generated
	 */
	TypeParameter createTypeParameter();

	/**
	 * Returns a new object of class '<em>Template Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Module</em>'.
	 * @generated
	 */
	TemplateModule createTemplateModule();

	/**
	 * Returns a new object of class '<em>Module Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Instantiation</em>'.
	 * @generated
	 */
	ModuleInstantiation createModuleInstantiation();

	/**
	 * Returns a new object of class '<em>Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Binding</em>'.
	 * @generated
	 */
	ParameterBinding createParameterBinding();

	/**
	 * Returns a new object of class '<em>Template Module Alias</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Module Alias</em>'.
	 * @generated
	 */
	TemplateModuleAlias createTemplateModuleAlias();

	/**
	 * Returns a new object of class '<em>Module Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Binding</em>'.
	 * @generated
	 */
	ModuleBinding createModuleBinding();

	/**
	 * Returns a new object of class '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Signature</em>'.
	 * @generated
	 */
	TemplateSignature createTemplateSignature();

	/**
	 * Returns a new object of class '<em>Interface Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Port</em>'.
	 * @generated
	 */
	InterfacePort createInterfacePort();

	/**
	 * Returns a new object of class '<em>Native</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Native</em>'.
	 * @generated
	 */
	Native createNative();

	/**
	 * Returns a new object of class '<em>Data Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Space</em>'.
	 * @generated
	 */
	DataSpace createDataSpace();

	/**
	 * Returns a new object of class '<em>Topic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Topic</em>'.
	 * @generated
	 */
	Topic createTopic();

	/**
	 * Returns a new object of class '<em>Topic Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Topic Field</em>'.
	 * @generated
	 */
	TopicField createTopicField();

	/**
	 * Returns a new object of class '<em>history Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>history Qos Policy</em>'.
	 * @generated
	 */
	historyQosPolicy createhistoryQosPolicy();

	/**
	 * Returns a new object of class '<em>lifespan Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>lifespan Qos Policy</em>'.
	 * @generated
	 */
	lifespanQosPolicy createlifespanQosPolicy();

	/**
	 * Returns a new object of class '<em>Duration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duration</em>'.
	 * @generated
	 */
	Duration createDuration();

	/**
	 * Returns a new object of class '<em>ownership Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ownership Qos Policy</em>'.
	 * @generated
	 */
	ownershipQosPolicy createownershipQosPolicy();

	/**
	 * Returns a new object of class '<em>os Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>os Qos Policy</em>'.
	 * @generated
	 */
	osQosPolicy createosQosPolicy();

	/**
	 * Returns a new object of class '<em>wdl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>wdl Qos Policy</em>'.
	 * @generated
	 */
	wdlQosPolicy createwdlQosPolicy();

	/**
	 * Returns a new object of class '<em>rdl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rdl Qos Policy</em>'.
	 * @generated
	 */
	rdlQosPolicy createrdlQosPolicy();

	/**
	 * Returns a new object of class '<em>ud Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ud Qos Policy</em>'.
	 * @generated
	 */
	udQosPolicy createudQosPolicy();

	/**
	 * Returns a new object of class '<em>td Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>td Qos Policy</em>'.
	 * @generated
	 */
	tdQosPolicy createtdQosPolicy();

	/**
	 * Returns a new object of class '<em>tp Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>tp Qos Policy</em>'.
	 * @generated
	 */
	tpQosPolicy createtpQosPolicy();

	/**
	 * Returns a new object of class '<em>deadline Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>deadline Qos Policy</em>'.
	 * @generated
	 */
	deadlineQosPolicy createdeadlineQosPolicy();

	/**
	 * Returns a new object of class '<em>lb Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>lb Qos Policy</em>'.
	 * @generated
	 */
	lbQosPolicy createlbQosPolicy();

	/**
	 * Returns a new object of class '<em>tbf Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>tbf Qos Policy</em>'.
	 * @generated
	 */
	tbfQosPolicy createtbfQosPolicy();

	/**
	 * Returns a new object of class '<em>gd Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>gd Qos Policy</em>'.
	 * @generated
	 */
	gdQosPolicy creategdQosPolicy();

	/**
	 * Returns a new object of class '<em>ef Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ef Qos Policy</em>'.
	 * @generated
	 */
	efQosPolicy createefQosPolicy();

	/**
	 * Returns a new object of class '<em>rl Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>rl Qos Policy</em>'.
	 * @generated
	 */
	rlQosPolicy createrlQosPolicy();

	/**
	 * Returns a new object of class '<em>presentation Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>presentation Qos Policy</em>'.
	 * @generated
	 */
	presentationQosPolicy createpresentationQosPolicy();

	/**
	 * Returns a new object of class '<em>partition Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>partition Qos Policy</em>'.
	 * @generated
	 */
	partitionQosPolicy createpartitionQosPolicy();

	/**
	 * Returns a new object of class '<em>reliability Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>reliability Qos Policy</em>'.
	 * @generated
	 */
	reliabilityQosPolicy createreliabilityQosPolicy();

	/**
	 * Returns a new object of class '<em>ds Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ds Qos Policy</em>'.
	 * @generated
	 */
	dsQosPolicy createdsQosPolicy();

	/**
	 * Returns a new object of class '<em>liveliness Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>liveliness Qos Policy</em>'.
	 * @generated
	 */
	livelinessQosPolicy createlivelinessQosPolicy();

	/**
	 * Returns a new object of class '<em>durability Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>durability Qos Policy</em>'.
	 * @generated
	 */
	durabilityQosPolicy createdurabilityQosPolicy();

	/**
	 * Returns a new object of class '<em>do Qos Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>do Qos Policy</em>'.
	 * @generated
	 */
	doQosPolicy createdoQosPolicy();

	/**
	 * Returns a new object of class '<em>qos Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>qos Property</em>'.
	 * @generated
	 */
	qosProperty createqosProperty();

	/**
	 * Returns a new object of class '<em>DDS Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DDS Message</em>'.
	 * @generated
	 */
	DDSMessage createDDSMessage();

	/**
	 * Returns a new object of class '<em>Message Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Field</em>'.
	 * @generated
	 */
	MessageField createMessageField();

	/**
	 * Returns a new object of class '<em>Qo SProfile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qo SProfile</em>'.
	 * @generated
	 */
	QoSProfile createQoSProfile();

	/**
	 * Returns a new object of class '<em>Qo SEntity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qo SEntity</em>'.
	 * @generated
	 */
	QoSEntity createQoSEntity();

	/**
	 * Returns a new object of class '<em>Data Reader Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Reader Qo S</em>'.
	 * @generated
	 */
	DataReaderQoS createDataReaderQoS();

	/**
	 * Returns a new object of class '<em>Participant Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Participant Qo S</em>'.
	 * @generated
	 */
	ParticipantQoS createParticipantQoS();

	/**
	 * Returns a new object of class '<em>Publisher Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publisher Qo S</em>'.
	 * @generated
	 */
	PublisherQoS createPublisherQoS();

	/**
	 * Returns a new object of class '<em>Subscriber Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subscriber Qo S</em>'.
	 * @generated
	 */
	SubscriberQoS createSubscriberQoS();

	/**
	 * Returns a new object of class '<em>Topic Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Topic Qo S</em>'.
	 * @generated
	 */
	TopicQoS createTopicQoS();

	/**
	 * Returns a new object of class '<em>Data Writer Qo S</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Writer Qo S</em>'.
	 * @generated
	 */
	DataWriterQoS createDataWriterQoS();

	/**
	 * Returns a new object of class '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain</em>'.
	 * @generated
	 */
	Domain createDomain();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Node Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Instance</em>'.
	 * @generated
	 */
	NodeInstance createNodeInstance();

	/**
	 * Returns a new object of class '<em>Interconnect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interconnect</em>'.
	 * @generated
	 */
	Interconnect createInterconnect();

	/**
	 * Returns a new object of class '<em>Interconnect Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interconnect Instance</em>'.
	 * @generated
	 */
	InterconnectInstance createInterconnectInstance();

	/**
	 * Returns a new object of class '<em>Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bridge</em>'.
	 * @generated
	 */
	Bridge createBridge();

	/**
	 * Returns a new object of class '<em>Bridge Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bridge Instance</em>'.
	 * @generated
	 */
	BridgeInstance createBridgeInstance();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Requirement Satisfier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Satisfier</em>'.
	 * @generated
	 */
	RequirementSatisfier createRequirementSatisfier();

	/**
	 * Returns a new object of class '<em>Resource Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Property</em>'.
	 * @generated
	 */
	ResourceProperty createResourceProperty();

	/**
	 * Returns a new object of class '<em>Shared Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Resource</em>'.
	 * @generated
	 */
	SharedResource createSharedResource();

	/**
	 * Returns a new object of class '<em>Satisfier Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Satisfier Property</em>'.
	 * @generated
	 */
	SatisfierProperty createSatisfierProperty();

	/**
	 * Returns a new object of class '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement</em>'.
	 * @generated
	 */
	Requirement createRequirement();

	/**
	 * Returns a new object of class '<em>Deployment Plan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Plan</em>'.
	 * @generated
	 */
	DeploymentPlan createDeploymentPlan();

	/**
	 * Returns a new object of class '<em>Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment</em>'.
	 * @generated
	 */
	Deployment createDeployment();

	/**
	 * Returns a new object of class '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation</em>'.
	 * @generated
	 */
	Allocation createAllocation();

	/**
	 * Returns a new object of class '<em>Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Part</em>'.
	 * @generated
	 */
	DeploymentPart createDeploymentPart();

	/**
	 * Returns a new object of class '<em>Component Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Deployment Part</em>'.
	 * @generated
	 */
	ComponentDeploymentPart createComponentDeploymentPart();

	/**
	 * Returns a new object of class '<em>Build Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Build Configuration</em>'.
	 * @generated
	 */
	BuildConfiguration createBuildConfiguration();

	/**
	 * Returns a new object of class '<em>Configuration Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Slot</em>'.
	 * @generated
	 */
	ConfigurationSlot createConfigurationSlot();

	/**
	 * Returns a new object of class '<em>Target Assembly Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Assembly Connector</em>'.
	 * @generated
	 */
	TargetAssemblyConnector createTargetAssemblyConnector();

	/**
	 * Returns a new object of class '<em>Container Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Process</em>'.
	 * @generated
	 */
	ContainerProcess createContainerProcess();

	/**
	 * Returns a new object of class '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Type</em>'.
	 * @generated
	 */
	TemplateParameterType createTemplateParameterType();

	/**
	 * Returns a new object of class '<em>Extended Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Port Type</em>'.
	 * @generated
	 */
	ExtendedPortType createExtendedPortType();

	/**
	 * Returns a new object of class '<em>IDL File Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IDL File Specification</em>'.
	 * @generated
	 */
	IDLFileSpecification createIDLFileSpecification();

	/**
	 * Returns a new object of class '<em>IDL File Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IDL File Dependency</em>'.
	 * @generated
	 */
	IDLFileDependency createIDLFileDependency();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Connector Default Value Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Default Value Binding</em>'.
	 * @generated
	 */
	ConnectorDefaultValueBinding createConnectorDefaultValueBinding();

	/**
	 * Returns a new object of class '<em>IDL Include Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IDL Include Dependency</em>'.
	 * @generated
	 */
	IDLIncludeDependency createIDLIncludeDependency();

	/**
	 * Returns a new object of class '<em>Worker Function Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Worker Function Impl</em>'.
	 * @generated
	 */
	WorkerFunctionImpl createWorkerFunctionImpl();

	/**
	 * Returns a new object of class '<em>Connector Status Listener Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Status Listener Connection</em>'.
	 * @generated
	 */
	ConnectorStatusListenerConnection createConnectorStatusListenerConnection();

	/**
	 * Returns a new object of class '<em>Finder Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finder Operation</em>'.
	 * @generated
	 */
	FinderOperation createFinderOperation();

	/**
	 * Returns a new object of class '<em>Home Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Home Operation</em>'.
	 * @generated
	 */
	HomeOperation createHomeOperation();

	/**
	 * Returns a new object of class '<em>Factory Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Factory Operation</em>'.
	 * @generated
	 */
	FactoryOperation createFactoryOperation();

	/**
	 * Returns a new object of class '<em>Home Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Home Instance</em>'.
	 * @generated
	 */
	HomeInstance createHomeInstance();

	/**
	 * Returns a new object of class '<em>Hideable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hideable Element</em>'.
	 * @generated
	 */
	HideableElement createHideableElement();

	/**
	 * Returns a new object of class '<em>Per Port Connector Type Deployment Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Per Port Connector Type Deployment Part</em>'.
	 * @generated
	 */
	PerPortConnectorTypeDeploymentPart createPerPortConnectorTypeDeploymentPart();

	/**
	 * Returns a new object of class '<em>Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Definition</em>'.
	 * @generated
	 */
	DomainDefinition createDomainDefinition();

	/**
	 * Returns a new object of class '<em>Domain Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Deployment</em>'.
	 * @generated
	 */
	DomainDeployment createDomainDeployment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DDS4CCMPackage getDDS4CCMPackage();

} //DDS4CCMFactory
