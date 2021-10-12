/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dds4ccm.DDS4CCMFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='cxDDS4CCM'"
 *        annotation="http://www.zeligsoft.com/zdl/2008/ZDL ZMLMM::ZML_Core::Type='Classifier' ZMLMM::ZML_Deployments::DeploymentSpecification='Classifier' ZMLMM::ZML_Component::ConnectorEnd='ConnectorEnd' ZMLMM::ZML_Deployments::DeploymentTarget='Classifier' ZMLMM::ZML_Deployments::DeployableElement='Classifier' ZMLMM::ZML_Component::Operation='Operation' ZMLMM::ZML_Core::NamedElement='NamedElement' ZMLMM::ZML_Component::InterfaceRealization='InterfaceRealization' ZMLMM::ZML_Core::Namespace='Namespace'"
 *        annotation="CXMenuModel uri='platform:/plugin/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.toolingmodel'"
 * @generated
 */
public interface DDS4CCMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dds4ccm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.zeligsoft.com/domain/dds4ccm/2010/DDS4CCM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dds4ccm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DDS4CCMPackage eINSTANCE = dds4ccm.impl.DDS4CCMPackageImpl.init();

	/**
	 * The meta object id for the '{@link dds4ccm.impl.StructuralRealizationImpl <em>Structural Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.StructuralRealizationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getStructuralRealization()
	 * @generated
	 */
	int STRUCTURAL_REALIZATION = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_REALIZATION__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Structural Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_REALIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Structural Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_REALIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.AssemblyImplementationImpl <em>Assembly Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.AssemblyImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getAssemblyImplementation()
	 * @generated
	 */
	int ASSEMBLY_IMPLEMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_IMPLEMENTATION__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_IMPLEMENTATION__BASE_NAMED_ELEMENT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assembly Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_IMPLEMENTATION_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assembly Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_IMPLEMENTATION_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.HomeImplementationImpl <em>Home Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.HomeImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHomeImplementation()
	 * @generated
	 */
	int HOME_IMPLEMENTATION = 2;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_IMPLEMENTATION__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Home Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_IMPLEMENTATION_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Home Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_IMPLEMENTATION_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ManagesImplEndImpl <em>Manages Impl End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ManagesImplEndImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getManagesImplEnd()
	 * @generated
	 */
	int MANAGES_IMPL_END = 3;

	/**
	 * The number of structural features of the '<em>Manages Impl End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_IMPL_END_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Manages Impl End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_IMPL_END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ManagesImplImpl <em>Manages Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ManagesImplImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getManagesImpl()
	 * @generated
	 */
	int MANAGES_IMPL = 4;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_IMPL__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Manages Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_IMPL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Manages Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_IMPL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.MonolithicImplementationImpl <em>Monolithic Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.MonolithicImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getMonolithicImplementation()
	 * @generated
	 */
	int MONOLITHIC_IMPLEMENTATION = 5;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION__UUID = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION__CATEGORY = STRUCTURAL_REALIZATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION__BASE_NAMED_ELEMENT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Monolithic Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Monolithic Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONOLITHIC_IMPLEMENTATION_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 6;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.WorkerFunctionIdentifiableImpl <em>Worker Function Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.WorkerFunctionIdentifiableImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getWorkerFunctionIdentifiable()
	 * @generated
	 */
	int WORKER_FUNCTION_IDENTIFIABLE = 7;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IDENTIFIABLE__UUID = 0;

	/**
	 * The number of structural features of the '<em>Worker Function Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Worker Function Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IDENTIFIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPart()
	 * @generated
	 */
	int PART = 9;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CCMPartImpl <em>CCM Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CCMPartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCCMPart()
	 * @generated
	 */
	int CCM_PART = 8;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_PART__BASE_PROPERTY = PART__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_PART__BASE_NAMED_ELEMENT = PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CCM Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CCM Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_PART_OPERATION_COUNT = PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.AssemblyConnectorImpl <em>Assembly Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.AssemblyConnectorImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getAssemblyConnector()
	 * @generated
	 */
	int ASSEMBLY_CONNECTOR = 11;

	/**
	 * The feature id for the '<em><b>Port End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__PORT_END = 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR__BASE_CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLY_CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CCMConnectorImpl <em>CCM Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CCMConnectorImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCCMConnector()
	 * @generated
	 */
	int CCM_CONNECTOR = 10;

	/**
	 * The feature id for the '<em><b>Port End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_CONNECTOR__PORT_END = ASSEMBLY_CONNECTOR__PORT_END;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_CONNECTOR__BASE_CONNECTOR = ASSEMBLY_CONNECTOR__BASE_CONNECTOR;

	/**
	 * The number of structural features of the '<em>CCM Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_CONNECTOR_FEATURE_COUNT = ASSEMBLY_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCM Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_CONNECTOR_OPERATION_COUNT = ASSEMBLY_CONNECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TypedElementImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 13;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 12;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__WIRING = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ComponentInterfaceImpl <em>Component Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ComponentInterfaceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getComponentInterface()
	 * @generated
	 */
	int COMPONENT_INTERFACE = 14;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INTERFACE__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Component Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INTERFACE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_INTERFACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FlowPortImpl <em>Flow Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FlowPortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFlowPort()
	 * @generated
	 */
	int FLOW_PORT = 15;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__WIRING = PORT__WIRING;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The number of structural features of the '<em>Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.MessagePortImpl <em>Message Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.MessagePortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getMessagePort()
	 * @generated
	 */
	int MESSAGE_PORT = 16;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PORT__WIRING = PORT__WIRING;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The number of structural features of the '<em>Message Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Message Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PortTypeableImpl <em>Port Typeable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PortTypeableImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPortTypeable()
	 * @generated
	 */
	int PORT_TYPEABLE = 18;

	/**
	 * The number of structural features of the '<em>Port Typeable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPEABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Port Typeable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPEABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.InterfaceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 17;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__BASE_INTERFACE = PORT_TYPEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = PORT_TYPEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = PORT_TYPEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.WorkerFunctionImpl <em>Worker Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.WorkerFunctionImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getWorkerFunction()
	 * @generated
	 */
	int WORKER_FUNCTION = 19;

	/**
	 * The feature id for the '<em><b>Receiving Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__RECEIVING_PORT = 0;

	/**
	 * The feature id for the '<em><b>Port Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__PORT_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__BODY = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__UUID = 3;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__DELEGATE = 4;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION__BASE_OPERATION = 5;

	/**
	 * The number of structural features of the '<em>Worker Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Worker Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PortTypeImpl <em>Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PortTypeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__INVERSE = PORT_TYPEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__BASE_CLASS = PORT_TYPEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE_FEATURE_COUNT = PORT_TYPEABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE_OPERATION_COUNT = PORT_TYPEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ComponentImplementationImpl <em>Component Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ComponentImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getComponentImplementation()
	 * @generated
	 */
	int COMPONENT_IMPLEMENTATION = 21;

	/**
	 * The feature id for the '<em><b>Base Manifestation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION = 0;

	/**
	 * The number of structural features of the '<em>Component Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IMPLEMENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ParameterImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 22;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__BASE_PARAMETER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ModelImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 23;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__BASE_MODEL = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.EventPortImpl <em>Event Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.EventPortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getEventPort()
	 * @generated
	 */
	int EVENT_PORT = 24;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__WIRING = PORT__WIRING;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__IS_CONJUGATED = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConjugatedPortImpl <em>Conjugated Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConjugatedPortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConjugatedPort()
	 * @generated
	 */
	int CONJUGATED_PORT = 25;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUGATED_PORT__IS_CONJUGATED = 0;

	/**
	 * The number of structural features of the '<em>Conjugated Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUGATED_PORT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Conjugated Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUGATED_PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CCMComponentImpl <em>CCM Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CCMComponentImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCCMComponent()
	 * @generated
	 */
	int CCM_COMPONENT = 26;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_COMPONENT__BASE_COMPONENT = COMPONENT_INTERFACE__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_COMPONENT__BASE_NAMED_ELEMENT = COMPONENT_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CCM Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_COMPONENT_FEATURE_COUNT = COMPONENT_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CCM Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_COMPONENT_OPERATION_COUNT = COMPONENT_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ManagesEndImpl <em>Manages End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ManagesEndImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getManagesEnd()
	 * @generated
	 */
	int MANAGES_END = 27;

	/**
	 * The number of structural features of the '<em>Manages End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_END_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Manages End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXModuleContainedImpl <em>CX Module Contained</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXModuleContainedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXModuleContained()
	 * @generated
	 */
	int CX_MODULE_CONTAINED = 28;

	/**
	 * The number of structural features of the '<em>CX Module Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE_CONTAINED_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>CX Module Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE_CONTAINED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXNamedElementImpl <em>CX Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXNamedElementImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXNamedElement()
	 * @generated
	 */
	int CX_NAMED_ELEMENT = 29;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>CX Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CX Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXTypeImpl <em>CX Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXTypeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXType()
	 * @generated
	 */
	int CX_TYPE = 30;

	/**
	 * The number of structural features of the '<em>CX Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>CX Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.EventImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 31;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__BASE_INTERFACE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Custom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__IS_CUSTOM = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__IS_TRUNCATABLE = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.HomeImpl <em>Home</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.HomeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHome()
	 * @generated
	 */
	int HOME = 32;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__UUID = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__BASE_CLASS = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Home</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Home</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ManagesImpl <em>Manages</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ManagesImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getManages()
	 * @generated
	 */
	int MANAGES = 33;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES__BASE_DEPENDENCY = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Manages</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Manages</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGES_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CCMModelImpl <em>CCM Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CCMModelImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCCMModel()
	 * @generated
	 */
	int CCM_MODEL = 36;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_MODEL__BASE_MODEL = MODEL__BASE_MODEL;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_MODEL__BASE_NAMED_ELEMENT = MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CCM Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_MODEL_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CCM Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCM_MODEL_OPERATION_COUNT = MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.IDL3PlusModelImpl <em>IDL3 Plus Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.IDL3PlusModelImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getIDL3PlusModel()
	 * @generated
	 */
	int IDL3_PLUS_MODEL = 35;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL3_PLUS_MODEL__BASE_MODEL = CCM_MODEL__BASE_MODEL;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL3_PLUS_MODEL__BASE_NAMED_ELEMENT = CCM_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The number of structural features of the '<em>IDL3 Plus Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL3_PLUS_MODEL_FEATURE_COUNT = CCM_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IDL3 Plus Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL3_PLUS_MODEL_OPERATION_COUNT = CCM_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DDS4CCMModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DDS4CCMModelImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDDS4CCMModel()
	 * @generated
	 */
	int DDS4CCM_MODEL = 34;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__BASE_MODEL = IDL3_PLUS_MODEL__BASE_MODEL;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__BASE_NAMED_ELEMENT = IDL3_PLUS_MODEL__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Location Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__LOCATION_PREFIX = IDL3_PLUS_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__FIXED_HEADER = IDL3_PLUS_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fixed Footer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__FIXED_FOOTER = IDL3_PLUS_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL__MODEL_TYPE = IDL3_PLUS_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL_FEATURE_COUNT = IDL3_PLUS_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS4CCM_MODEL_OPERATION_COUNT = IDL3_PLUS_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXBoundedImpl <em>CX Bounded</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXBoundedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXBounded()
	 * @generated
	 */
	int CX_BOUNDED = 38;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED__BOUNDS = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED__BOUND = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CX Bounded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>CX Bounded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUNDED_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXWStringImpl <em>CXW String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXWStringImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXWString()
	 * @generated
	 */
	int CXW_STRING = 37;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING__BASE_NAMED_ELEMENT = CX_BOUNDED__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING__BOUNDS = CX_BOUNDED__BOUNDS;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING__BOUND = CX_BOUNDED__BOUND;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING__BASE_DATA_TYPE = CX_BOUNDED__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>CXW String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING_FEATURE_COUNT = CX_BOUNDED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CXW String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CXW_STRING_OPERATION_COUNT = CX_BOUNDED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXBoundImpl <em>CX Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXBoundImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXBound()
	 * @generated
	 */
	int CX_BOUND = 39;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUND__CONSTANT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUND__VALUE = 1;

	/**
	 * The number of structural features of the '<em>CX Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUND_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CX Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOUND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXConstantImpl <em>CX Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXConstantImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXConstant()
	 * @generated
	 */
	int CX_CONSTANT = 40;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANT__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANT__BASE_PROPERTY = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANT_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANT_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXTypedImpl <em>CX Typed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXTypedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXTyped()
	 * @generated
	 */
	int CX_TYPED = 41;

	/**
	 * The number of structural features of the '<em>CX Typed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPED_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>CX Typed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXClassifierContainedImpl <em>CX Classifier Contained</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXClassifierContainedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXClassifierContained()
	 * @generated
	 */
	int CX_CLASSIFIER_CONTAINED = 42;

	/**
	 * The number of structural features of the '<em>CX Classifier Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CLASSIFIER_CONTAINED_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>CX Classifier Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CLASSIFIER_CONTAINED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXAnonymousArrayImpl <em>CX Anonymous Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXAnonymousArrayImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXAnonymousArray()
	 * @generated
	 */
	int CX_ANONYMOUS_ARRAY = 43;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_ARRAY__BASE_DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>CX Anonymous Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_ARRAY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CX Anonymous Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXAnonymousSequenceImpl <em>CX Anonymous Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXAnonymousSequenceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXAnonymousSequence()
	 * @generated
	 */
	int CX_ANONYMOUS_SEQUENCE = 44;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_SEQUENCE__BASE_DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>CX Anonymous Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_SEQUENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CX Anonymous Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ANONYMOUS_SEQUENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXTemplateImpl <em>CX Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXTemplateImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXTemplate()
	 * @generated
	 */
	int CX_TEMPLATE = 46;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TEMPLATE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TEMPLATE__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TEMPLATE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TEMPLATE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXArrayImpl <em>CX Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXArrayImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXArray()
	 * @generated
	 */
	int CX_ARRAY = 45;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY__BASE_NAMED_ELEMENT = CX_TEMPLATE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY__BASE_DATA_TYPE = CX_TEMPLATE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY__BOUNDS = CX_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY__INDEX = CX_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CX Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY_FEATURE_COUNT = CX_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CX Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ARRAY_OPERATION_COUNT = CX_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ContainedImpl <em>Contained</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ContainedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getContained()
	 * @generated
	 */
	int CONTAINED = 47;

	/**
	 * The number of structural features of the '<em>Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Contained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXWrapperImpl <em>CX Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXWrapperImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXWrapper()
	 * @generated
	 */
	int CX_WRAPPER = 49;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_WRAPPER__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_WRAPPER__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_WRAPPER_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_WRAPPER_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXBoxedValueImpl <em>CX Boxed Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXBoxedValueImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXBoxedValue()
	 * @generated
	 */
	int CX_BOXED_VALUE = 48;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOXED_VALUE__BASE_NAMED_ELEMENT = CX_WRAPPER__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOXED_VALUE__BASE_DATA_TYPE = CX_WRAPPER__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>CX Boxed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOXED_VALUE_FEATURE_COUNT = CX_WRAPPER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CX Boxed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_BOXED_VALUE_OPERATION_COUNT = CX_WRAPPER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXUnionFieldImpl <em>CX Union Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXUnionFieldImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXUnionField()
	 * @generated
	 */
	int CX_UNION_FIELD = 51;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_FIELD__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_FIELD__BASE_PROPERTY = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Union Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_FIELD_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Union Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_FIELD_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXCaseImpl <em>CX Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXCaseImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXCase()
	 * @generated
	 */
	int CX_CASE = 50;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CASE__BASE_NAMED_ELEMENT = CX_UNION_FIELD__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CASE__BASE_PROPERTY = CX_UNION_FIELD__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CASE__LABEL = CX_UNION_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CASE_FEATURE_COUNT = CX_UNION_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CASE_OPERATION_COUNT = CX_UNION_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXConstantsImpl <em>CX Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXConstantsImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXConstants()
	 * @generated
	 */
	int CX_CONSTANTS = 52;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANTS__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANTS__BASE_CLASS = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANTS_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTANTS_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXConstructedImpl <em>CX Constructed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXConstructedImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXConstructed()
	 * @generated
	 */
	int CX_CONSTRUCTED = 53;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTRUCTED__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTRUCTED__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Constructed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTRUCTED_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Constructed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CONSTRUCTED_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXDefaultImpl <em>CX Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXDefaultImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXDefault()
	 * @generated
	 */
	int CX_DEFAULT = 54;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_DEFAULT__BASE_NAMED_ELEMENT = CX_UNION_FIELD__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_DEFAULT__BASE_PROPERTY = CX_UNION_FIELD__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>CX Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_DEFAULT_FEATURE_COUNT = CX_UNION_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CX Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_DEFAULT_OPERATION_COUNT = CX_UNION_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXEnumImpl <em>CX Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXEnumImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXEnum()
	 * @generated
	 */
	int CX_ENUM = 55;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ENUM__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ENUM__BASE_ENUMERATION = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ENUM_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ENUM_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXExceptionImpl <em>CX Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXExceptionImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXException()
	 * @generated
	 */
	int CX_EXCEPTION = 56;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_EXCEPTION__BASE_NAMED_ELEMENT = CX_CONSTRUCTED__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_EXCEPTION__BASE_DATA_TYPE = CX_CONSTRUCTED__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>CX Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_EXCEPTION_FEATURE_COUNT = CX_CONSTRUCTED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CX Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_EXCEPTION_OPERATION_COUNT = CX_CONSTRUCTED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXInterfaceImpl <em>CX Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXInterfaceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXInterface()
	 * @generated
	 */
	int CX_INTERFACE = 57;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE__BASE_INTERFACE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE__UUID = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE__IS_LOCAL = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Asynchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE__IS_ASYNCHRONOUS = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CX Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>CX Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_INTERFACE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXClassifierImpl <em>CX Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXClassifierImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXClassifier()
	 * @generated
	 */
	int CX_CLASSIFIER = 58;

	/**
	 * The number of structural features of the '<em>CX Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CLASSIFIER_FEATURE_COUNT = CX_MODULE_CONTAINED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CX Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_CLASSIFIER_OPERATION_COUNT = CX_MODULE_CONTAINED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXPrimitiveImpl <em>CX Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXPrimitiveImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXPrimitive()
	 * @generated
	 */
	int CX_PRIMITIVE = 59;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PRIMITIVE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PRIMITIVE__TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PRIMITIVE__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CX Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PRIMITIVE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CX Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PRIMITIVE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXSequenceImpl <em>CX Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXSequenceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXSequence()
	 * @generated
	 */
	int CX_SEQUENCE = 60;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE__BASE_NAMED_ELEMENT = CX_TEMPLATE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE__BASE_DATA_TYPE = CX_TEMPLATE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE__BOUNDS = CX_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE__BOUND = CX_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CX Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE_FEATURE_COUNT = CX_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CX Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SEQUENCE_OPERATION_COUNT = CX_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXStringImpl <em>CX String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXStringImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXString()
	 * @generated
	 */
	int CX_STRING = 61;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING__BASE_NAMED_ELEMENT = CX_BOUNDED__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING__BOUNDS = CX_BOUNDED__BOUNDS;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING__BOUND = CX_BOUNDED__BOUND;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING__BASE_DATA_TYPE = CX_BOUNDED__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>CX String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING_FEATURE_COUNT = CX_BOUNDED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CX String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRING_OPERATION_COUNT = CX_BOUNDED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXStructImpl <em>CX Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXStructImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXStruct()
	 * @generated
	 */
	int CX_STRUCT = 62;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRUCT__BASE_NAMED_ELEMENT = CX_CONSTRUCTED__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRUCT__BASE_DATA_TYPE = CX_CONSTRUCTED__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Extensibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRUCT__EXTENSIBILITY = CX_CONSTRUCTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRUCT_FEATURE_COUNT = CX_CONSTRUCTED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_STRUCT_OPERATION_COUNT = CX_CONSTRUCTED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ExtensibleImpl <em>Extensible</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ExtensibleImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getExtensible()
	 * @generated
	 */
	int EXTENSIBLE = 63;

	/**
	 * The feature id for the '<em><b>Extensibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE__EXTENSIBILITY = 0;

	/**
	 * The number of structural features of the '<em>Extensible</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Extensible</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXSupportsImpl <em>CX Supports</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXSupportsImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXSupports()
	 * @generated
	 */
	int CX_SUPPORTS = 64;

	/**
	 * The feature id for the '<em><b>Base Generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SUPPORTS__BASE_GENERALIZATION = 0;

	/**
	 * The number of structural features of the '<em>CX Supports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SUPPORTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CX Supports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_SUPPORTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXTypeDefImpl <em>CX Type Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXTypeDefImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXTypeDef()
	 * @generated
	 */
	int CX_TYPE_DEF = 65;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_DEF__BASE_NAMED_ELEMENT = CX_WRAPPER__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_DEF__BASE_DATA_TYPE = CX_WRAPPER__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_DEF__TYPE = CX_WRAPPER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Type Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_DEF_FEATURE_COUNT = CX_WRAPPER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Type Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_TYPE_DEF_OPERATION_COUNT = CX_WRAPPER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXUnionImpl <em>CX Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXUnionImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXUnion()
	 * @generated
	 */
	int CX_UNION = 66;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION__BASE_NAMED_ELEMENT = CX_CONSTRUCTED__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION__BASE_DATA_TYPE = CX_CONSTRUCTED__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Extensibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION__EXTENSIBILITY = CX_CONSTRUCTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_FEATURE_COUNT = CX_CONSTRUCTED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_UNION_OPERATION_COUNT = CX_CONSTRUCTED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXValueImpl <em>CX Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXValueImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXValue()
	 * @generated
	 */
	int CX_VALUE = 67;

	/**
	 * The feature id for the '<em><b>Is Custom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE__IS_CUSTOM = CONTAINED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Truncatable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE__IS_TRUNCATABLE = CONTAINED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE__BASE_INTERFACE = CONTAINED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CX Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE_FEATURE_COUNT = CONTAINED_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>CX Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE_OPERATION_COUNT = CONTAINED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXValueFactoryImpl <em>CX Value Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXValueFactoryImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXValueFactory()
	 * @generated
	 */
	int CX_VALUE_FACTORY = 68;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE_FACTORY__BASE_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>CX Value Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE_FACTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CX Value Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_VALUE_FACTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXModuleImpl <em>CX Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXModuleImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXModule()
	 * @generated
	 */
	int CX_MODULE = 69;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE__BASE_PACKAGE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_MODULE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXAttributeImpl <em>CX Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXAttributeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXAttribute()
	 * @generated
	 */
	int CX_ATTRIBUTE = 70;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE__UUID = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Setraises</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE__SETRAISES = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Getraises</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE__GETRAISES = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE__BASE_PROPERTY = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CX Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>CX Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_ATTRIBUTE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXOperationImpl <em>CX Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXOperationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXOperation()
	 * @generated
	 */
	int CX_OPERATION = 71;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION__UUID = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Idl Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION__IDL_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is One Way</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION__IS_ONE_WAY = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION__BASE_OPERATION = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CX Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>CX Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_OPERATION_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXFieldImpl <em>CX Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXFieldImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXField()
	 * @generated
	 */
	int CX_FIELD = 72;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD__BOUNDS = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD__BOUND = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD__BASE_PROPERTY = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CX Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>CX Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_FIELD_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.CXParameterImpl <em>CX Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.CXParameterImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXParameter()
	 * @generated
	 */
	int CX_PARAMETER = 73;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PARAMETER__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PARAMETER__BASE_PARAMETER = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CX Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PARAMETER_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CX Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CX_PARAMETER_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.StateMemberImpl <em>State Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.StateMemberImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getStateMember()
	 * @generated
	 */
	int STATE_MEMBER = 74;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MEMBER__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MEMBER__BASE_PROPERTY = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MEMBER_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>State Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MEMBER_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorDefImpl <em>Connector Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorDefImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorDef()
	 * @generated
	 */
	int CONNECTOR_DEF = 75;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEF__BASE_COMPONENT = COMPONENT_INTERFACE__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEF__BASE_NAMED_ELEMENT = COMPONENT_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connector Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEF_FEATURE_COUNT = COMPONENT_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Connector Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEF_OPERATION_COUNT = COMPONENT_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorFragmentImpl <em>Connector Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorFragmentImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorFragment()
	 * @generated
	 */
	int CONNECTOR_FRAGMENT = 76;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FRAGMENT__BASE_COMPONENT = COMPONENT_INTERFACE__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Connector Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FRAGMENT_FEATURE_COUNT = COMPONENT_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FRAGMENT_OPERATION_COUNT = COMPONENT_INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FragmentImplementationImpl <em>Fragment Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FragmentImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFragmentImplementation()
	 * @generated
	 */
	int FRAGMENT_IMPLEMENTATION = 77;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_IMPLEMENTATION__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Fragment Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_IMPLEMENTATION_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fragment Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_IMPLEMENTATION_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FragmentAssemblyImpl <em>Fragment Assembly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FragmentAssemblyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFragmentAssembly()
	 * @generated
	 */
	int FRAGMENT_ASSEMBLY = 78;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_ASSEMBLY__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Fragment Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_ASSEMBLY_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fragment Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_ASSEMBLY_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorImplementationImpl <em>Connector Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorImplementationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorImplementation()
	 * @generated
	 */
	int CONNECTOR_IMPLEMENTATION = 79;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_IMPLEMENTATION__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Connector Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_IMPLEMENTATION_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_IMPLEMENTATION_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorAssemblyImpl <em>Connector Assembly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorAssemblyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorAssembly()
	 * @generated
	 */
	int CONNECTOR_ASSEMBLY = 80;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_ASSEMBLY__BASE_COMPONENT = STRUCTURAL_REALIZATION__BASE_COMPONENT;

	/**
	 * The number of structural features of the '<em>Connector Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_ASSEMBLY_FEATURE_COUNT = STRUCTURAL_REALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_ASSEMBLY_OPERATION_COUNT = STRUCTURAL_REALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FragmentPartImpl <em>Fragment Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FragmentPartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFragmentPart()
	 * @generated
	 */
	int FRAGMENT_PART = 81;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_PART__BASE_PROPERTY = PART__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Fragment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fragment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_PART_OPERATION_COUNT = PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TypedConnectorImpl <em>Typed Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TypedConnectorImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTypedConnector()
	 * @generated
	 */
	int TYPED_CONNECTOR = 82;

	/**
	 * The feature id for the '<em><b>Port End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONNECTOR__PORT_END = ASSEMBLY_CONNECTOR__PORT_END;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONNECTOR__BASE_CONNECTOR = ASSEMBLY_CONNECTOR__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Connector Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONNECTOR__CONNECTOR_TYPE = ASSEMBLY_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONNECTOR_FEATURE_COUNT = ASSEMBLY_CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_CONNECTOR_OPERATION_COUNT = ASSEMBLY_CONNECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TypeParameterImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTypeParameter()
	 * @generated
	 */
	int TYPE_PARAMETER = 83;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Base Classifier Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TemplateModuleImpl <em>Template Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TemplateModuleImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTemplateModule()
	 * @generated
	 */
	int TEMPLATE_MODULE = 84;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE__BASE_PACKAGE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Template Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ModuleInstantiationImpl <em>Module Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ModuleInstantiationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getModuleInstantiation()
	 * @generated
	 */
	int MODULE_INSTANTIATION = 85;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_INSTANTIATION__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_INSTANTIATION__BASE_PACKAGE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_INSTANTIATION_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_INSTANTIATION_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ParameterBindingImpl <em>Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ParameterBindingImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getParameterBinding()
	 * @generated
	 */
	int PARAMETER_BINDING = 86;

	/**
	 * The feature id for the '<em><b>Base Template Parameter Substitution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION = 0;

	/**
	 * The number of structural features of the '<em>Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TemplateModuleAliasImpl <em>Template Module Alias</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TemplateModuleAliasImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTemplateModuleAlias()
	 * @generated
	 */
	int TEMPLATE_MODULE_ALIAS = 87;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE_ALIAS__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Template Module Alias</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE_ALIAS_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Template Module Alias</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_MODULE_ALIAS_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ModuleBindingImpl <em>Module Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ModuleBindingImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getModuleBinding()
	 * @generated
	 */
	int MODULE_BINDING = 88;

	/**
	 * The feature id for the '<em><b>Base Template Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_BINDING__BASE_TEMPLATE_BINDING = 0;

	/**
	 * The number of structural features of the '<em>Module Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_BINDING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Module Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TemplateSignatureImpl <em>Template Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TemplateSignatureImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTemplateSignature()
	 * @generated
	 */
	int TEMPLATE_SIGNATURE = 89;

	/**
	 * The feature id for the '<em><b>Base Template Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE = 0;

	/**
	 * The number of structural features of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Template Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SIGNATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.InterfacePortImpl <em>Interface Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.InterfacePortImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getInterfacePort()
	 * @generated
	 */
	int INTERFACE_PORT = 90;

	/**
	 * The feature id for the '<em><b>Wiring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__WIRING = MESSAGE_PORT__WIRING;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__BASE_PORT = MESSAGE_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__IS_CONJUGATED = MESSAGE_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__UUID = MESSAGE_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connector Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__CONNECTOR_TYPE = MESSAGE_PORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Asynchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__IS_ASYNCHRONOUS = MESSAGE_PORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has CSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT__HAS_CSL = MESSAGE_PORT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Interface Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_FEATURE_COUNT = MESSAGE_PORT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Interface Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_OPERATION_COUNT = MESSAGE_PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.NativeImpl <em>Native</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.NativeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getNative()
	 * @generated
	 */
	int NATIVE = 91;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE__BASE_DATA_TYPE = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Native</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Native</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DataSpaceImpl <em>Data Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DataSpaceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDataSpace()
	 * @generated
	 */
	int DATA_SPACE = 92;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SPACE__BASE_PROPERTY = PART__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SPACE__BASE_NAMED_ELEMENT = PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SPACE_FEATURE_COUNT = PART_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SPACE_OPERATION_COUNT = PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TopicImpl <em>Topic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TopicImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTopic()
	 * @generated
	 */
	int TOPIC = 93;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__KIND = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Topic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Topic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TopicFieldImpl <em>Topic Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TopicFieldImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTopicField()
	 * @generated
	 */
	int TOPIC_FIELD = 94;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_FIELD__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Topic Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_FIELD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Topic Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.qosPolicyImpl <em>qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.qosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getqosPolicy()
	 * @generated
	 */
	int QOS_POLICY = 95;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_POLICY__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_POLICY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_POLICY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.historyQosPolicyImpl <em>history Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.historyQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#gethistoryQosPolicy()
	 * @generated
	 */
	int HISTORY_QOS_POLICY = 96;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QOS_POLICY__DEPTH = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>history Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>history Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.lifespanQosPolicyImpl <em>lifespan Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.lifespanQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getlifespanQosPolicy()
	 * @generated
	 */
	int LIFESPAN_QOS_POLICY = 97;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFESPAN_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFESPAN_QOS_POLICY__DURATION = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>lifespan Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFESPAN_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>lifespan Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFESPAN_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DurationImpl <em>Duration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DurationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDuration()
	 * @generated
	 */
	int DURATION = 98;

	/**
	 * The feature id for the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION__SECOND = 0;

	/**
	 * The feature id for the '<em><b>Nanosecond</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION__NANOSECOND = 1;

	/**
	 * The number of structural features of the '<em>Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ownershipQosPolicyImpl <em>ownership Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ownershipQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getownershipQosPolicy()
	 * @generated
	 */
	int OWNERSHIP_QOS_POLICY = 99;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNERSHIP_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNERSHIP_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ownership Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNERSHIP_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ownership Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNERSHIP_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.osQosPolicyImpl <em>os Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.osQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getosQosPolicy()
	 * @generated
	 */
	int OS_QOS_POLICY = 100;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_QOS_POLICY__VALUE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>os Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>os Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.wdlQosPolicyImpl <em>wdl Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.wdlQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getwdlQosPolicy()
	 * @generated
	 */
	int WDL_QOS_POLICY = 101;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WDL_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Autodispose unregistered instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>wdl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WDL_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>wdl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WDL_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.rdlQosPolicyImpl <em>rdl Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.rdlQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getrdlQosPolicy()
	 * @generated
	 */
	int RDL_QOS_POLICY = 102;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RDL_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Autopurge nowriter samples delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Autopurge disposed samples delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>rdl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RDL_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>rdl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RDL_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.udQosPolicyImpl <em>ud Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.udQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getudQosPolicy()
	 * @generated
	 */
	int UD_QOS_POLICY = 103;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UD_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UD_QOS_POLICY__VALUE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ud Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UD_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ud Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UD_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.tdQosPolicyImpl <em>td Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.tdQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#gettdQosPolicy()
	 * @generated
	 */
	int TD_QOS_POLICY = 104;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_QOS_POLICY__VALUE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>td Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>td Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TD_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.tpQosPolicyImpl <em>tp Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.tpQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#gettpQosPolicy()
	 * @generated
	 */
	int TP_QOS_POLICY = 105;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_QOS_POLICY__VALUE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>tp Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>tp Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.deadlineQosPolicyImpl <em>deadline Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.deadlineQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getdeadlineQosPolicy()
	 * @generated
	 */
	int DEADLINE_QOS_POLICY = 106;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_QOS_POLICY__PERIOD = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>deadline Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>deadline Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.lbQosPolicyImpl <em>lb Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.lbQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getlbQosPolicy()
	 * @generated
	 */
	int LB_QOS_POLICY = 107;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LB_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LB_QOS_POLICY__DURATION = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>lb Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LB_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>lb Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LB_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.tbfQosPolicyImpl <em>tbf Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.tbfQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#gettbfQosPolicy()
	 * @generated
	 */
	int TBF_QOS_POLICY = 108;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBF_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Minimum separation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBF_QOS_POLICY__MINIMUM_SEPARATION = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>tbf Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBF_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>tbf Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBF_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.gdQosPolicyImpl <em>gd Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.gdQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getgdQosPolicy()
	 * @generated
	 */
	int GD_QOS_POLICY = 109;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GD_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GD_QOS_POLICY__VALUE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>gd Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GD_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>gd Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GD_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.efQosPolicyImpl <em>ef Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.efQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getefQosPolicy()
	 * @generated
	 */
	int EF_QOS_POLICY = 110;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Autoenable created entities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ef Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ef Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EF_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.rlQosPolicyImpl <em>rl Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.rlQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getrlQosPolicy()
	 * @generated
	 */
	int RL_QOS_POLICY = 111;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Max instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY__MAX_INSTANCES = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY__MAX_SAMPLES = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max samples per instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>rl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>rl Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RL_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.presentationQosPolicyImpl <em>presentation Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.presentationQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getpresentationQosPolicy()
	 * @generated
	 */
	int PRESENTATION_QOS_POLICY = 112;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Access scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY__ACCESS_SCOPE = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Coherent access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY__COHERENT_ACCESS = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ordered access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY__ORDERED_ACCESS = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>presentation Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>presentation Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.partitionQosPolicyImpl <em>partition Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.partitionQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getpartitionQosPolicy()
	 * @generated
	 */
	int PARTITION_QOS_POLICY = 113;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_QOS_POLICY__NAME = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>partition Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>partition Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.reliabilityQosPolicyImpl <em>reliability Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.reliabilityQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getreliabilityQosPolicy()
	 * @generated
	 */
	int RELIABILITY_QOS_POLICY = 114;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Max blocking time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>reliability Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>reliability Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELIABILITY_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.dsQosPolicyImpl <em>ds Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.dsQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getdsQosPolicy()
	 * @generated
	 */
	int DS_QOS_POLICY = 115;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Service cleanup delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__SERVICE_CLEANUP_DELAY = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>History kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__HISTORY_KIND = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__MAX_INSTANCES = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__MAX_SAMPLES = QOS_POLICY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max samples per instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE = QOS_POLICY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>History depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY__HISTORY_DEPTH = QOS_POLICY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>ds Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>ds Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DS_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.livelinessQosPolicyImpl <em>liveliness Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.livelinessQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getlivelinessQosPolicy()
	 * @generated
	 */
	int LIVELINESS_QOS_POLICY = 116;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVELINESS_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Lease duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVELINESS_QOS_POLICY__LEASE_DURATION = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVELINESS_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>liveliness Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVELINESS_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>liveliness Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVELINESS_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.durabilityQosPolicyImpl <em>durability Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.durabilityQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getdurabilityQosPolicy()
	 * @generated
	 */
	int DURABILITY_QOS_POLICY = 117;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURABILITY_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURABILITY_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>durability Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURABILITY_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>durability Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURABILITY_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.doQosPolicyImpl <em>do Qos Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.doQosPolicyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getdoQosPolicy()
	 * @generated
	 */
	int DO_QOS_POLICY = 118;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_QOS_POLICY__BASE_CLASS = QOS_POLICY__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_QOS_POLICY__KIND = QOS_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>do Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_QOS_POLICY_FEATURE_COUNT = QOS_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>do Qos Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_QOS_POLICY_OPERATION_COUNT = QOS_POLICY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.qosPropertyImpl <em>qos Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.qosPropertyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getqosProperty()
	 * @generated
	 */
	int QOS_PROPERTY = 119;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>qos Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>qos Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QOS_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DDSMessageImpl <em>DDS Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DDSMessageImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDDSMessage()
	 * @generated
	 */
	int DDS_MESSAGE = 120;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS_MESSAGE__BASE_NAMED_ELEMENT = CX_STRUCT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS_MESSAGE__BASE_DATA_TYPE = CX_STRUCT__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Extensibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS_MESSAGE__EXTENSIBILITY = CX_STRUCT__EXTENSIBILITY;

	/**
	 * The number of structural features of the '<em>DDS Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS_MESSAGE_FEATURE_COUNT = CX_STRUCT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>DDS Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDS_MESSAGE_OPERATION_COUNT = CX_STRUCT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.MessageFieldImpl <em>Message Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.MessageFieldImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getMessageField()
	 * @generated
	 */
	int MESSAGE_FIELD = 121;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD__BASE_NAMED_ELEMENT = CX_FIELD__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD__BOUNDS = CX_FIELD__BOUNDS;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD__BOUND = CX_FIELD__BOUND;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD__BASE_PROPERTY = CX_FIELD__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD__IS_KEY = CX_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Message Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD_FEATURE_COUNT = CX_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Message Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FIELD_OPERATION_COUNT = CX_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.QoSProfileImpl <em>Qo SProfile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.QoSProfileImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getQoSProfile()
	 * @generated
	 */
	int QO_SPROFILE = 122;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILE__FILENAME = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Qo SProfile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Qo SProfile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SPROFILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.QoSForEntityImpl <em>Qo SFor Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.QoSForEntityImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getQoSForEntity()
	 * @generated
	 */
	int QO_SFOR_ENTITY = 123;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SFOR_ENTITY__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Qo SFor Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SFOR_ENTITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Qo SFor Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SFOR_ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.QoSEntityImpl <em>Qo SEntity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.QoSEntityImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getQoSEntity()
	 * @generated
	 */
	int QO_SENTITY = 124;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SENTITY__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Qo SEntity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SENTITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Qo SEntity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QO_SENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DataReaderWriterQoSImpl <em>Data Reader Writer Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DataReaderWriterQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDataReaderWriterQoS()
	 * @generated
	 */
	int DATA_READER_WRITER_QO_S = 126;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_WRITER_QO_S__BASE_CLASS = QO_SFOR_ENTITY__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Data Reader Writer Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_WRITER_QO_S_FEATURE_COUNT = QO_SFOR_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Reader Writer Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_WRITER_QO_S_OPERATION_COUNT = QO_SFOR_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DataReaderQoSImpl <em>Data Reader Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DataReaderQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDataReaderQoS()
	 * @generated
	 */
	int DATA_READER_QO_S = 125;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_QO_S__BASE_CLASS = DATA_READER_WRITER_QO_S__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Data Reader Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_QO_S_FEATURE_COUNT = DATA_READER_WRITER_QO_S_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Reader Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_READER_QO_S_OPERATION_COUNT = DATA_READER_WRITER_QO_S_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ParticipantQoSImpl <em>Participant Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ParticipantQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getParticipantQoS()
	 * @generated
	 */
	int PARTICIPANT_QO_S = 127;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_QO_S__BASE_CLASS = QO_SFOR_ENTITY__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Participant Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_QO_S_FEATURE_COUNT = QO_SFOR_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Participant Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_QO_S_OPERATION_COUNT = QO_SFOR_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PublisherSubscriberQoSImpl <em>Publisher Subscriber Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PublisherSubscriberQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPublisherSubscriberQoS()
	 * @generated
	 */
	int PUBLISHER_SUBSCRIBER_QO_S = 129;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_SUBSCRIBER_QO_S__BASE_CLASS = QO_SFOR_ENTITY__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Publisher Subscriber Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_SUBSCRIBER_QO_S_FEATURE_COUNT = QO_SFOR_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Publisher Subscriber Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_SUBSCRIBER_QO_S_OPERATION_COUNT = QO_SFOR_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PublisherQoSImpl <em>Publisher Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PublisherQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPublisherQoS()
	 * @generated
	 */
	int PUBLISHER_QO_S = 128;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_QO_S__BASE_CLASS = PUBLISHER_SUBSCRIBER_QO_S__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Publisher Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_QO_S_FEATURE_COUNT = PUBLISHER_SUBSCRIBER_QO_S_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Publisher Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_QO_S_OPERATION_COUNT = PUBLISHER_SUBSCRIBER_QO_S_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.SubscriberQoSImpl <em>Subscriber Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.SubscriberQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getSubscriberQoS()
	 * @generated
	 */
	int SUBSCRIBER_QO_S = 130;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIBER_QO_S__BASE_CLASS = PUBLISHER_SUBSCRIBER_QO_S__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Subscriber Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIBER_QO_S_FEATURE_COUNT = PUBLISHER_SUBSCRIBER_QO_S_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Subscriber Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIBER_QO_S_OPERATION_COUNT = PUBLISHER_SUBSCRIBER_QO_S_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TopicQoSImpl <em>Topic Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TopicQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTopicQoS()
	 * @generated
	 */
	int TOPIC_QO_S = 131;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_QO_S__BASE_CLASS = QO_SFOR_ENTITY__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Topic Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_QO_S_FEATURE_COUNT = QO_SFOR_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Topic Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_QO_S_OPERATION_COUNT = QO_SFOR_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DataWriterQoSImpl <em>Data Writer Qo S</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DataWriterQoSImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDataWriterQoS()
	 * @generated
	 */
	int DATA_WRITER_QO_S = 132;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_WRITER_QO_S__BASE_CLASS = DATA_READER_WRITER_QO_S__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Data Writer Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_WRITER_QO_S_FEATURE_COUNT = DATA_READER_WRITER_QO_S_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Writer Qo S</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_WRITER_QO_S_OPERATION_COUNT = DATA_READER_WRITER_QO_S_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DomainImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 133;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__LABEL = 0;

	/**
	 * The feature id for the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__UUID = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__BASE_COMPONENT = 2;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.NodeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 134;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.NodeInstanceImpl <em>Node Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.NodeInstanceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getNodeInstance()
	 * @generated
	 */
	int NODE_INSTANCE = 135;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANCE__LABEL = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANCE__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANCE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_INSTANCE_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.InterconnectImpl <em>Interconnect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.InterconnectImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getInterconnect()
	 * @generated
	 */
	int INTERCONNECT = 136;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Interconnect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Interconnect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.InterconnectInstanceImpl <em>Interconnect Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.InterconnectInstanceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getInterconnectInstance()
	 * @generated
	 */
	int INTERCONNECT_INSTANCE = 137;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_INSTANCE__LABEL = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_INSTANCE__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interconnect Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_INSTANCE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Interconnect Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCONNECT_INSTANCE_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.BridgeImpl <em>Bridge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.BridgeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getBridge()
	 * @generated
	 */
	int BRIDGE = 138;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Bridge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Bridge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.BridgeInstanceImpl <em>Bridge Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.BridgeInstanceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getBridgeInstance()
	 * @generated
	 */
	int BRIDGE_INSTANCE = 139;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_INSTANCE__LABEL = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_INSTANCE__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bridge Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_INSTANCE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bridge Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_INSTANCE_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.RequirementSatisfierImpl <em>Requirement Satisfier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.RequirementSatisfierImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getRequirementSatisfier()
	 * @generated
	 */
	int REQUIREMENT_SATISFIER = 141;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SATISFIER__RESOURCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SATISFIER__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Requirement Satisfier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SATISFIER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Requirement Satisfier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SATISFIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ResourceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 140;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE_TYPE = REQUIREMENT_SATISFIER__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_CLASS = REQUIREMENT_SATISFIER__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = REQUIREMENT_SATISFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = REQUIREMENT_SATISFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ResourcePropertyImpl <em>Resource Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ResourcePropertyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getResourceProperty()
	 * @generated
	 */
	int RESOURCE_PROPERTY = 142;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROPERTY__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROPERTY_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROPERTY_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.SharedResourceImpl <em>Shared Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.SharedResourceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getSharedResource()
	 * @generated
	 */
	int SHARED_RESOURCE = 143;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCE__BASE_PROPERTY = RESOURCE_PROPERTY__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Shared Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCE_FEATURE_COUNT = RESOURCE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Shared Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCE_OPERATION_COUNT = RESOURCE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.SatisfierPropertyImpl <em>Satisfier Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.SatisfierPropertyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getSatisfierProperty()
	 * @generated
	 */
	int SATISFIER_PROPERTY = 144;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY__DYNAMIC = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY__KIND = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY__VALUE = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Satisfier Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Satisfier Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SATISFIER_PROPERTY_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.RequirementImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 145;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RESOURCE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DeploymentImpl <em>Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DeploymentImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDeployment()
	 * @generated
	 */
	int DEPLOYMENT = 147;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DeploymentPlanImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDeploymentPlan()
	 * @generated
	 */
	int DEPLOYMENT_PLAN = 146;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__BASE_COMPONENT = DEPLOYMENT__BASE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__ID = DEPLOYMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_FEATURE_COUNT = DEPLOYMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_OPERATION_COUNT = DEPLOYMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.AllocationImpl <em>Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.AllocationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getAllocation()
	 * @generated
	 */
	int ALLOCATION = 148;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.DeploymentPartImpl <em>Deployment Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.DeploymentPartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDeploymentPart()
	 * @generated
	 */
	int DEPLOYMENT_PART = 149;

	/**
	 * The feature id for the '<em><b>Nested Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__NESTED_PART = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__MODEL_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART__BASE_PROPERTY = 3;

	/**
	 * The number of structural features of the '<em>Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConfigurationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 150;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_INSTANCE_SPECIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ComponentDeploymentPartImpl <em>Component Deployment Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ComponentDeploymentPartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getComponentDeploymentPart()
	 * @generated
	 */
	int COMPONENT_DEPLOYMENT_PART = 151;

	/**
	 * The feature id for the '<em><b>Nested Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__NESTED_PART = DEPLOYMENT_PART__NESTED_PART;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__CONFIGURATION = DEPLOYMENT_PART__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__MODEL_ELEMENT = DEPLOYMENT_PART__MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__BASE_PROPERTY = DEPLOYMENT_PART__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Selected Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION = DEPLOYMENT_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION = DEPLOYMENT_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART_FEATURE_COUNT = DEPLOYMENT_PART_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DEPLOYMENT_PART_OPERATION_COUNT = DEPLOYMENT_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.BuildConfigurationImpl <em>Build Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.BuildConfigurationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getBuildConfiguration()
	 * @generated
	 */
	int BUILD_CONFIGURATION = 152;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_CONFIGURATION__BASE_CLASS = CONFIGURATION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_CONFIGURATION__BASE_INSTANCE_SPECIFICATION = CONFIGURATION__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Build Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Build Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConfigurationSlotImpl <em>Configuration Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConfigurationSlotImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConfigurationSlot()
	 * @generated
	 */
	int CONFIGURATION_SLOT = 153;

	/**
	 * The feature id for the '<em><b>Slot Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SLOT__SLOT_KIND = 0;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SLOT__BASE_SLOT = 1;

	/**
	 * The number of structural features of the '<em>Configuration Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SLOT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_SLOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TargetAssemblyConnectorImpl <em>Target Assembly Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TargetAssemblyConnectorImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTargetAssemblyConnector()
	 * @generated
	 */
	int TARGET_ASSEMBLY_CONNECTOR = 154;

	/**
	 * The feature id for the '<em><b>Port End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ASSEMBLY_CONNECTOR__PORT_END = ASSEMBLY_CONNECTOR__PORT_END;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ASSEMBLY_CONNECTOR__BASE_CONNECTOR = ASSEMBLY_CONNECTOR__BASE_CONNECTOR;

	/**
	 * The number of structural features of the '<em>Target Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ASSEMBLY_CONNECTOR_FEATURE_COUNT = ASSEMBLY_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Assembly Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ASSEMBLY_CONNECTOR_OPERATION_COUNT = ASSEMBLY_CONNECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ContainerProcessImpl <em>Container Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ContainerProcessImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getContainerProcess()
	 * @generated
	 */
	int CONTAINER_PROCESS = 155;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PROCESS__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Container Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PROCESS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PROCESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.TemplateParameterTypeImpl <em>Template Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.TemplateParameterTypeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTemplateParameterType()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_TYPE = 156;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__BASE_CLASS = CX_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__BASE_DATA_TYPE = CX_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE__BASE_INTERFACE = CX_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_FEATURE_COUNT = CX_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Template Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_TYPE_OPERATION_COUNT = CX_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ExtendedPortTypeImpl <em>Extended Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ExtendedPortTypeImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getExtendedPortType()
	 * @generated
	 */
	int EXTENDED_PORT_TYPE = 157;

	/**
	 * The feature id for the '<em><b>Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_PORT_TYPE__INVERSE = PORT_TYPE__INVERSE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_PORT_TYPE__BASE_CLASS = PORT_TYPE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_PORT_TYPE__BASE_NAMED_ELEMENT = PORT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extended Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_PORT_TYPE_FEATURE_COUNT = PORT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Extended Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_PORT_TYPE_OPERATION_COUNT = PORT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.IDLFileSpecificationImpl <em>IDL File Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.IDLFileSpecificationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getIDLFileSpecification()
	 * @generated
	 */
	int IDL_FILE_SPECIFICATION = 158;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_SPECIFICATION__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>IDL File Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IDL File Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.IDLFileDependencyImpl <em>IDL File Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.IDLFileDependencyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getIDLFileDependency()
	 * @generated
	 */
	int IDL_FILE_DEPENDENCY = 159;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_DEPENDENCY__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>IDL File Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IDL File Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_FILE_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PropertyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 160;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__BASE_PROPERTY = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorDefaultValueBindingImpl <em>Connector Default Value Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorDefaultValueBindingImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorDefaultValueBinding()
	 * @generated
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING = 161;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Connector Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Connector Default Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Connector Default Value Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFAULT_VALUE_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.IDLIncludeDependencyImpl <em>IDL Include Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.IDLIncludeDependencyImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getIDLIncludeDependency()
	 * @generated
	 */
	int IDL_INCLUDE_DEPENDENCY = 162;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_INCLUDE_DEPENDENCY__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>IDL Include Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_INCLUDE_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IDL Include Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDL_INCLUDE_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.WorkerFunctionImplImpl <em>Worker Function Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.WorkerFunctionImplImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getWorkerFunctionImpl()
	 * @generated
	 */
	int WORKER_FUNCTION_IMPL = 163;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR = 0;

	/**
	 * The number of structural features of the '<em>Worker Function Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IMPL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Worker Function Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FUNCTION_IMPL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.ConnectorStatusListenerConnectionImpl <em>Connector Status Listener Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.ConnectorStatusListenerConnectionImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConnectorStatusListenerConnection()
	 * @generated
	 */
	int CONNECTOR_STATUS_LISTENER_CONNECTION = 164;

	/**
	 * The feature id for the '<em><b>Port End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_STATUS_LISTENER_CONNECTION__PORT_END = CCM_CONNECTOR__PORT_END;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_STATUS_LISTENER_CONNECTION__BASE_CONNECTOR = CCM_CONNECTOR__BASE_CONNECTOR;

	/**
	 * The number of structural features of the '<em>Connector Status Listener Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_STATUS_LISTENER_CONNECTION_FEATURE_COUNT = CCM_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connector Status Listener Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_STATUS_LISTENER_CONNECTION_OPERATION_COUNT = CCM_CONNECTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.HomeOperationImpl <em>Home Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.HomeOperationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHomeOperation()
	 * @generated
	 */
	int HOME_OPERATION = 166;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION__BASE_NAMED_ELEMENT = CX_NAMED_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION__UUID = CX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION__BASE_OPERATION = CX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Home Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION_FEATURE_COUNT = CX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Home Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_OPERATION_OPERATION_COUNT = CX_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FinderOperationImpl <em>Finder Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FinderOperationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFinderOperation()
	 * @generated
	 */
	int FINDER_OPERATION = 165;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_OPERATION__BASE_NAMED_ELEMENT = HOME_OPERATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_OPERATION__UUID = HOME_OPERATION__UUID;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_OPERATION__BASE_OPERATION = HOME_OPERATION__BASE_OPERATION;

	/**
	 * The number of structural features of the '<em>Finder Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_OPERATION_FEATURE_COUNT = HOME_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Finder Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDER_OPERATION_OPERATION_COUNT = HOME_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.FactoryOperationImpl <em>Factory Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.FactoryOperationImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getFactoryOperation()
	 * @generated
	 */
	int FACTORY_OPERATION = 167;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION__BASE_NAMED_ELEMENT = HOME_OPERATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION__UUID = HOME_OPERATION__UUID;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION__BASE_OPERATION = HOME_OPERATION__BASE_OPERATION;

	/**
	 * The number of structural features of the '<em>Factory Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION_FEATURE_COUNT = HOME_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Factory Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION_OPERATION_COUNT = HOME_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.HomeInstanceImpl <em>Home Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.HomeInstanceImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHomeInstance()
	 * @generated
	 */
	int HOME_INSTANCE = 168;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_INSTANCE__BASE_PROPERTY = PART__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_INSTANCE__BASE_NAMED_ELEMENT = PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Home Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_INSTANCE_FEATURE_COUNT = PART_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Home Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_INSTANCE_OPERATION_COUNT = PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.HideableElementImpl <em>Hideable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.HideableElementImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHideableElement()
	 * @generated
	 */
	int HIDEABLE_ELEMENT = 169;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDEABLE_ELEMENT__BASE_NAMED_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Hideable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDEABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Hideable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDEABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dds4ccm.impl.PerPortConnectorTypeDeploymentPartImpl <em>Per Port Connector Type Deployment Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.impl.PerPortConnectorTypeDeploymentPartImpl
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPerPortConnectorTypeDeploymentPart()
	 * @generated
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART = 170;

	/**
	 * The feature id for the '<em><b>Nested Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART__NESTED_PART = DEPLOYMENT_PART__NESTED_PART;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART__CONFIGURATION = DEPLOYMENT_PART__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART__MODEL_ELEMENT = DEPLOYMENT_PART__MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART__BASE_PROPERTY = DEPLOYMENT_PART__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Per Port Connector Type Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART_FEATURE_COUNT = DEPLOYMENT_PART_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Per Port Connector Type Deployment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART_OPERATION_COUNT = DEPLOYMENT_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dds4ccm.ComponentCategory <em>Component Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.ComponentCategory
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getComponentCategory()
	 * @generated
	 */
	int COMPONENT_CATEGORY = 171;

	/**
	 * The meta object id for the '{@link dds4ccm.WiringKind <em>Wiring Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.WiringKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getWiringKind()
	 * @generated
	 */
	int WIRING_KIND = 172;

	/**
	 * The meta object id for the '{@link dds4ccm.ModelTypeEnum <em>Model Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.ModelTypeEnum
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getModelTypeEnum()
	 * @generated
	 */
	int MODEL_TYPE_ENUM = 173;

	/**
	 * The meta object id for the '{@link dds4ccm.CXPrimitiveKind <em>CX Primitive Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.CXPrimitiveKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getCXPrimitiveKind()
	 * @generated
	 */
	int CX_PRIMITIVE_KIND = 174;

	/**
	 * The meta object id for the '{@link dds4ccm.ExtensibilityKind <em>Extensibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.ExtensibilityKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getExtensibilityKind()
	 * @generated
	 */
	int EXTENSIBILITY_KIND = 175;

	/**
	 * The meta object id for the '{@link dds4ccm.TypeConstraint <em>Type Constraint</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.TypeConstraint
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTypeConstraint()
	 * @generated
	 */
	int TYPE_CONSTRAINT = 176;

	/**
	 * The meta object id for the '{@link dds4ccm.TopicKind <em>Topic Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.TopicKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getTopicKind()
	 * @generated
	 */
	int TOPIC_KIND = 177;

	/**
	 * The meta object id for the '{@link dds4ccm.HistoryQosPolicyKind <em>History Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getHistoryQosPolicyKind()
	 * @generated
	 */
	int HISTORY_QOS_POLICY_KIND = 178;

	/**
	 * The meta object id for the '{@link dds4ccm.OwnershipQosPolicyKind <em>Ownership Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.OwnershipQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getOwnershipQosPolicyKind()
	 * @generated
	 */
	int OWNERSHIP_QOS_POLICY_KIND = 179;

	/**
	 * The meta object id for the '{@link dds4ccm.PresentationQosPolicyAccessScopeKind <em>Presentation Qos Policy Access Scope Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.PresentationQosPolicyAccessScopeKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getPresentationQosPolicyAccessScopeKind()
	 * @generated
	 */
	int PRESENTATION_QOS_POLICY_ACCESS_SCOPE_KIND = 180;

	/**
	 * The meta object id for the '{@link dds4ccm.RealiabilityQosPolicyKind <em>Realiability Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.RealiabilityQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getRealiabilityQosPolicyKind()
	 * @generated
	 */
	int REALIABILITY_QOS_POLICY_KIND = 181;

	/**
	 * The meta object id for the '{@link dds4ccm.LivelinessQosPolicyKind <em>Liveliness Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.LivelinessQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getLivelinessQosPolicyKind()
	 * @generated
	 */
	int LIVELINESS_QOS_POLICY_KIND = 182;

	/**
	 * The meta object id for the '{@link dds4ccm.DurabilityQosPolicyKind <em>Durability Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.DurabilityQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDurabilityQosPolicyKind()
	 * @generated
	 */
	int DURABILITY_QOS_POLICY_KIND = 183;

	/**
	 * The meta object id for the '{@link dds4ccm.DestinationOrderQosPolicyKind <em>Destination Order Qos Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.DestinationOrderQosPolicyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getDestinationOrderQosPolicyKind()
	 * @generated
	 */
	int DESTINATION_ORDER_QOS_POLICY_KIND = 184;

	/**
	 * The meta object id for the '{@link dds4ccm.SatisfierPropertyKind <em>Satisfier Property Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.SatisfierPropertyKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getSatisfierPropertyKind()
	 * @generated
	 */
	int SATISFIER_PROPERTY_KIND = 185;

	/**
	 * The meta object id for the '{@link dds4ccm.ConfigurationSlotKind <em>Configuration Slot Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dds4ccm.ConfigurationSlotKind
	 * @see dds4ccm.impl.DDS4CCMPackageImpl#getConfigurationSlotKind()
	 * @generated
	 */
	int CONFIGURATION_SLOT_KIND = 186;


	/**
	 * Returns the meta object for class '{@link dds4ccm.AssemblyImplementation <em>Assembly Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Implementation</em>'.
	 * @see dds4ccm.AssemblyImplementation
	 * @generated
	 */
	EClass getAssemblyImplementation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.AssemblyImplementation#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.AssemblyImplementation#getBase_NamedElement()
	 * @see #getAssemblyImplementation()
	 * @generated
	 */
	EReference getAssemblyImplementation_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.StructuralRealization <em>Structural Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Realization</em>'.
	 * @see dds4ccm.StructuralRealization
	 * @generated
	 */
	EClass getStructuralRealization();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.StructuralRealization#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.StructuralRealization#getBase_Component()
	 * @see #getStructuralRealization()
	 * @generated
	 */
	EReference getStructuralRealization_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.HomeImplementation <em>Home Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Home Implementation</em>'.
	 * @see dds4ccm.HomeImplementation
	 * @generated
	 */
	EClass getHomeImplementation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ManagesImplEnd <em>Manages Impl End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manages Impl End</em>'.
	 * @see dds4ccm.ManagesImplEnd
	 * @generated
	 */
	EClass getManagesImplEnd();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ManagesImpl <em>Manages Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manages Impl</em>'.
	 * @see dds4ccm.ManagesImpl
	 * @generated
	 */
	EClass getManagesImpl();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ManagesImpl#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see dds4ccm.ManagesImpl#getBase_Dependency()
	 * @see #getManagesImpl()
	 * @generated
	 */
	EReference getManagesImpl_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link dds4ccm.MonolithicImplementation <em>Monolithic Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monolithic Implementation</em>'.
	 * @see dds4ccm.MonolithicImplementation
	 * @generated
	 */
	EClass getMonolithicImplementation();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.MonolithicImplementation#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see dds4ccm.MonolithicImplementation#getCategory()
	 * @see #getMonolithicImplementation()
	 * @generated
	 */
	EAttribute getMonolithicImplementation_Category();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.MonolithicImplementation#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.MonolithicImplementation#getBase_NamedElement()
	 * @see #getMonolithicImplementation()
	 * @generated
	 */
	EReference getMonolithicImplementation_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see dds4ccm.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.WorkerFunctionIdentifiable <em>Worker Function Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker Function Identifiable</em>'.
	 * @see dds4ccm.WorkerFunctionIdentifiable
	 * @generated
	 */
	EClass getWorkerFunctionIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.WorkerFunctionIdentifiable#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see dds4ccm.WorkerFunctionIdentifiable#getUuid()
	 * @see #getWorkerFunctionIdentifiable()
	 * @generated
	 */
	EAttribute getWorkerFunctionIdentifiable_Uuid();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CCMPart <em>CCM Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCM Part</em>'.
	 * @see dds4ccm.CCMPart
	 * @generated
	 */
	EClass getCCMPart();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CCMPart#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.CCMPart#getBase_NamedElement()
	 * @see #getCCMPart()
	 * @generated
	 */
	EReference getCCMPart_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see dds4ccm.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Part#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.Part#getBase_Property()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CCMConnector <em>CCM Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCM Connector</em>'.
	 * @see dds4ccm.CCMConnector
	 * @generated
	 */
	EClass getCCMConnector();

	/**
	 * Returns the meta object for class '{@link dds4ccm.AssemblyConnector <em>Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembly Connector</em>'.
	 * @see dds4ccm.AssemblyConnector
	 * @generated
	 */
	EClass getAssemblyConnector();

	/**
	 * Returns the meta object for the reference list '{@link dds4ccm.AssemblyConnector#getPortEnd <em>Port End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Port End</em>'.
	 * @see dds4ccm.AssemblyConnector#getPortEnd()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_PortEnd();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.AssemblyConnector#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see dds4ccm.AssemblyConnector#getBase_Connector()
	 * @see #getAssemblyConnector()
	 * @generated
	 */
	EReference getAssemblyConnector_Base_Connector();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see dds4ccm.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Port#getWiring <em>Wiring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wiring</em>'.
	 * @see dds4ccm.Port#getWiring()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Wiring();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Port#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see dds4ccm.Port#getBase_Port()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Base_Port();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see dds4ccm.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ComponentInterface <em>Component Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Interface</em>'.
	 * @see dds4ccm.ComponentInterface
	 * @generated
	 */
	EClass getComponentInterface();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ComponentInterface#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.ComponentInterface#getBase_Component()
	 * @see #getComponentInterface()
	 * @generated
	 */
	EReference getComponentInterface_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FlowPort <em>Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Port</em>'.
	 * @see dds4ccm.FlowPort
	 * @generated
	 */
	EClass getFlowPort();

	/**
	 * Returns the meta object for class '{@link dds4ccm.MessagePort <em>Message Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Port</em>'.
	 * @see dds4ccm.MessagePort
	 * @generated
	 */
	EClass getMessagePort();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see dds4ccm.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Interface#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see dds4ccm.Interface#getBase_Interface()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Base_Interface();

	/**
	 * Returns the meta object for class '{@link dds4ccm.PortTypeable <em>Port Typeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Typeable</em>'.
	 * @see dds4ccm.PortTypeable
	 * @generated
	 */
	EClass getPortTypeable();

	/**
	 * Returns the meta object for class '{@link dds4ccm.WorkerFunction <em>Worker Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker Function</em>'.
	 * @see dds4ccm.WorkerFunction
	 * @generated
	 */
	EClass getWorkerFunction();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.WorkerFunction#getReceivingPort <em>Receiving Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiving Port</em>'.
	 * @see dds4ccm.WorkerFunction#getReceivingPort()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EReference getWorkerFunction_ReceivingPort();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.WorkerFunction#getPortOperation <em>Port Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Operation</em>'.
	 * @see dds4ccm.WorkerFunction#getPortOperation()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EReference getWorkerFunction_PortOperation();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.WorkerFunction#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see dds4ccm.WorkerFunction#getBody()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EAttribute getWorkerFunction_Body();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.WorkerFunction#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see dds4ccm.WorkerFunction#getUuid()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EAttribute getWorkerFunction_Uuid();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.WorkerFunction#isDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delegate</em>'.
	 * @see dds4ccm.WorkerFunction#isDelegate()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EAttribute getWorkerFunction_Delegate();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.WorkerFunction#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see dds4ccm.WorkerFunction#getBase_Operation()
	 * @see #getWorkerFunction()
	 * @generated
	 */
	EReference getWorkerFunction_Base_Operation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Type</em>'.
	 * @see dds4ccm.PortType
	 * @generated
	 */
	EClass getPortType();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.PortType#getInverse <em>Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse</em>'.
	 * @see dds4ccm.PortType#getInverse()
	 * @see #getPortType()
	 * @generated
	 */
	EReference getPortType_Inverse();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.PortType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.PortType#getBase_Class()
	 * @see #getPortType()
	 * @generated
	 */
	EReference getPortType_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ComponentImplementation <em>Component Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Implementation</em>'.
	 * @see dds4ccm.ComponentImplementation
	 * @generated
	 */
	EClass getComponentImplementation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ComponentImplementation#getBase_Manifestation <em>Base Manifestation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Manifestation</em>'.
	 * @see dds4ccm.ComponentImplementation#getBase_Manifestation()
	 * @see #getComponentImplementation()
	 * @generated
	 */
	EReference getComponentImplementation_Base_Manifestation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see dds4ccm.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Parameter#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see dds4ccm.Parameter#getBase_Parameter()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see dds4ccm.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Model#getBase_Model <em>Base Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Model</em>'.
	 * @see dds4ccm.Model#getBase_Model()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Base_Model();

	/**
	 * Returns the meta object for class '{@link dds4ccm.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Port</em>'.
	 * @see dds4ccm.EventPort
	 * @generated
	 */
	EClass getEventPort();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConjugatedPort <em>Conjugated Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conjugated Port</em>'.
	 * @see dds4ccm.ConjugatedPort
	 * @generated
	 */
	EClass getConjugatedPort();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.ConjugatedPort#isConjugated <em>Is Conjugated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Conjugated</em>'.
	 * @see dds4ccm.ConjugatedPort#isConjugated()
	 * @see #getConjugatedPort()
	 * @generated
	 */
	EAttribute getConjugatedPort_IsConjugated();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CCMComponent <em>CCM Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCM Component</em>'.
	 * @see dds4ccm.CCMComponent
	 * @generated
	 */
	EClass getCCMComponent();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ManagesEnd <em>Manages End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manages End</em>'.
	 * @see dds4ccm.ManagesEnd
	 * @generated
	 */
	EClass getManagesEnd();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXModuleContained <em>CX Module Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Module Contained</em>'.
	 * @see dds4ccm.CXModuleContained
	 * @generated
	 */
	EClass getCXModuleContained();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXNamedElement <em>CX Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Named Element</em>'.
	 * @see dds4ccm.CXNamedElement
	 * @generated
	 */
	EClass getCXNamedElement();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXNamedElement#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.CXNamedElement#getBase_NamedElement()
	 * @see #getCXNamedElement()
	 * @generated
	 */
	EReference getCXNamedElement_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXType <em>CX Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Type</em>'.
	 * @see dds4ccm.CXType
	 * @generated
	 */
	EClass getCXType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see dds4ccm.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Event#isCustom <em>Is Custom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Custom</em>'.
	 * @see dds4ccm.Event#isCustom()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_IsCustom();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Event#isTruncatable <em>Is Truncatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Truncatable</em>'.
	 * @see dds4ccm.Event#isTruncatable()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_IsTruncatable();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Home <em>Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Home</em>'.
	 * @see dds4ccm.Home
	 * @generated
	 */
	EClass getHome();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Home#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.Home#getBase_Class()
	 * @see #getHome()
	 * @generated
	 */
	EReference getHome_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Manages <em>Manages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manages</em>'.
	 * @see dds4ccm.Manages
	 * @generated
	 */
	EClass getManages();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Manages#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see dds4ccm.Manages#getBase_Dependency()
	 * @see #getManages()
	 * @generated
	 */
	EReference getManages_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DDS4CCMModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see dds4ccm.DDS4CCMModel
	 * @generated
	 */
	EClass getDDS4CCMModel();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.DDS4CCMModel#getLocationPrefix <em>Location Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location Prefix</em>'.
	 * @see dds4ccm.DDS4CCMModel#getLocationPrefix()
	 * @see #getDDS4CCMModel()
	 * @generated
	 */
	EAttribute getDDS4CCMModel_LocationPrefix();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.DDS4CCMModel#getFixedHeader <em>Fixed Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Header</em>'.
	 * @see dds4ccm.DDS4CCMModel#getFixedHeader()
	 * @see #getDDS4CCMModel()
	 * @generated
	 */
	EAttribute getDDS4CCMModel_FixedHeader();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.DDS4CCMModel#getFixedFooter <em>Fixed Footer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Footer</em>'.
	 * @see dds4ccm.DDS4CCMModel#getFixedFooter()
	 * @see #getDDS4CCMModel()
	 * @generated
	 */
	EAttribute getDDS4CCMModel_FixedFooter();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.DDS4CCMModel#getModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see dds4ccm.DDS4CCMModel#getModelType()
	 * @see #getDDS4CCMModel()
	 * @generated
	 */
	EAttribute getDDS4CCMModel_ModelType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.IDL3PlusModel <em>IDL3 Plus Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDL3 Plus Model</em>'.
	 * @see dds4ccm.IDL3PlusModel
	 * @generated
	 */
	EClass getIDL3PlusModel();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CCMModel <em>CCM Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCM Model</em>'.
	 * @see dds4ccm.CCMModel
	 * @generated
	 */
	EClass getCCMModel();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CCMModel#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.CCMModel#getBase_NamedElement()
	 * @see #getCCMModel()
	 * @generated
	 */
	EReference getCCMModel_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXWString <em>CXW String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CXW String</em>'.
	 * @see dds4ccm.CXWString
	 * @generated
	 */
	EClass getCXWString();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXBounded <em>CX Bounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Bounded</em>'.
	 * @see dds4ccm.CXBounded
	 * @generated
	 */
	EClass getCXBounded();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.CXBounded#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see dds4ccm.CXBounded#getBounds()
	 * @see #getCXBounded()
	 * @generated
	 */
	EReference getCXBounded_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXBounded#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see dds4ccm.CXBounded#getBound()
	 * @see #getCXBounded()
	 * @generated
	 */
	EAttribute getCXBounded_Bound();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXBounded#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXBounded#getBase_DataType()
	 * @see #getCXBounded()
	 * @generated
	 */
	EReference getCXBounded_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXBound <em>CX Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Bound</em>'.
	 * @see dds4ccm.CXBound
	 * @generated
	 */
	EClass getCXBound();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXBound#getConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constant</em>'.
	 * @see dds4ccm.CXBound#getConstant()
	 * @see #getCXBound()
	 * @generated
	 */
	EReference getCXBound_Constant();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXBound#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.CXBound#getValue()
	 * @see #getCXBound()
	 * @generated
	 */
	EAttribute getCXBound_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXConstant <em>CX Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Constant</em>'.
	 * @see dds4ccm.CXConstant
	 * @generated
	 */
	EClass getCXConstant();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXConstant#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.CXConstant#getBase_Property()
	 * @see #getCXConstant()
	 * @generated
	 */
	EReference getCXConstant_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXTyped <em>CX Typed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Typed</em>'.
	 * @see dds4ccm.CXTyped
	 * @generated
	 */
	EClass getCXTyped();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXClassifierContained <em>CX Classifier Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Classifier Contained</em>'.
	 * @see dds4ccm.CXClassifierContained
	 * @generated
	 */
	EClass getCXClassifierContained();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXAnonymousArray <em>CX Anonymous Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Anonymous Array</em>'.
	 * @see dds4ccm.CXAnonymousArray
	 * @generated
	 */
	EClass getCXAnonymousArray();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXAnonymousArray#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXAnonymousArray#getBase_DataType()
	 * @see #getCXAnonymousArray()
	 * @generated
	 */
	EReference getCXAnonymousArray_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXAnonymousSequence <em>CX Anonymous Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Anonymous Sequence</em>'.
	 * @see dds4ccm.CXAnonymousSequence
	 * @generated
	 */
	EClass getCXAnonymousSequence();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXAnonymousSequence#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXAnonymousSequence#getBase_DataType()
	 * @see #getCXAnonymousSequence()
	 * @generated
	 */
	EReference getCXAnonymousSequence_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXArray <em>CX Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Array</em>'.
	 * @see dds4ccm.CXArray
	 * @generated
	 */
	EClass getCXArray();

	/**
	 * Returns the meta object for the containment reference list '{@link dds4ccm.CXArray#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bounds</em>'.
	 * @see dds4ccm.CXArray#getBounds()
	 * @see #getCXArray()
	 * @generated
	 */
	EReference getCXArray_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXArray#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see dds4ccm.CXArray#getIndex()
	 * @see #getCXArray()
	 * @generated
	 */
	EAttribute getCXArray_Index();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXTemplate <em>CX Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Template</em>'.
	 * @see dds4ccm.CXTemplate
	 * @generated
	 */
	EClass getCXTemplate();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXTemplate#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXTemplate#getBase_DataType()
	 * @see #getCXTemplate()
	 * @generated
	 */
	EReference getCXTemplate_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Contained <em>Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contained</em>'.
	 * @see dds4ccm.Contained
	 * @generated
	 */
	EClass getContained();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXBoxedValue <em>CX Boxed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Boxed Value</em>'.
	 * @see dds4ccm.CXBoxedValue
	 * @generated
	 */
	EClass getCXBoxedValue();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXWrapper <em>CX Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Wrapper</em>'.
	 * @see dds4ccm.CXWrapper
	 * @generated
	 */
	EClass getCXWrapper();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXWrapper#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXWrapper#getBase_DataType()
	 * @see #getCXWrapper()
	 * @generated
	 */
	EReference getCXWrapper_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXCase <em>CX Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Case</em>'.
	 * @see dds4ccm.CXCase
	 * @generated
	 */
	EClass getCXCase();

	/**
	 * Returns the meta object for the attribute list '{@link dds4ccm.CXCase#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Label</em>'.
	 * @see dds4ccm.CXCase#getLabel()
	 * @see #getCXCase()
	 * @generated
	 */
	EAttribute getCXCase_Label();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXUnionField <em>CX Union Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Union Field</em>'.
	 * @see dds4ccm.CXUnionField
	 * @generated
	 */
	EClass getCXUnionField();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXUnionField#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.CXUnionField#getBase_Property()
	 * @see #getCXUnionField()
	 * @generated
	 */
	EReference getCXUnionField_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXConstants <em>CX Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Constants</em>'.
	 * @see dds4ccm.CXConstants
	 * @generated
	 */
	EClass getCXConstants();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXConstants#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.CXConstants#getBase_Class()
	 * @see #getCXConstants()
	 * @generated
	 */
	EReference getCXConstants_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXConstructed <em>CX Constructed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Constructed</em>'.
	 * @see dds4ccm.CXConstructed
	 * @generated
	 */
	EClass getCXConstructed();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXConstructed#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXConstructed#getBase_DataType()
	 * @see #getCXConstructed()
	 * @generated
	 */
	EReference getCXConstructed_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXDefault <em>CX Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Default</em>'.
	 * @see dds4ccm.CXDefault
	 * @generated
	 */
	EClass getCXDefault();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXEnum <em>CX Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Enum</em>'.
	 * @see dds4ccm.CXEnum
	 * @generated
	 */
	EClass getCXEnum();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXEnum#getBase_Enumeration <em>Base Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Enumeration</em>'.
	 * @see dds4ccm.CXEnum#getBase_Enumeration()
	 * @see #getCXEnum()
	 * @generated
	 */
	EReference getCXEnum_Base_Enumeration();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXException <em>CX Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Exception</em>'.
	 * @see dds4ccm.CXException
	 * @generated
	 */
	EClass getCXException();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXInterface <em>CX Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Interface</em>'.
	 * @see dds4ccm.CXInterface
	 * @generated
	 */
	EClass getCXInterface();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXInterface#isLocal <em>Is Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Local</em>'.
	 * @see dds4ccm.CXInterface#isLocal()
	 * @see #getCXInterface()
	 * @generated
	 */
	EAttribute getCXInterface_IsLocal();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXInterface#isAsynchronous <em>Is Asynchronous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Asynchronous</em>'.
	 * @see dds4ccm.CXInterface#isAsynchronous()
	 * @see #getCXInterface()
	 * @generated
	 */
	EAttribute getCXInterface_IsAsynchronous();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXClassifier <em>CX Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Classifier</em>'.
	 * @see dds4ccm.CXClassifier
	 * @generated
	 */
	EClass getCXClassifier();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXPrimitive <em>CX Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Primitive</em>'.
	 * @see dds4ccm.CXPrimitive
	 * @generated
	 */
	EClass getCXPrimitive();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXPrimitive#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dds4ccm.CXPrimitive#getType()
	 * @see #getCXPrimitive()
	 * @generated
	 */
	EAttribute getCXPrimitive_Type();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXPrimitive#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.CXPrimitive#getBase_DataType()
	 * @see #getCXPrimitive()
	 * @generated
	 */
	EReference getCXPrimitive_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXSequence <em>CX Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Sequence</em>'.
	 * @see dds4ccm.CXSequence
	 * @generated
	 */
	EClass getCXSequence();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.CXSequence#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see dds4ccm.CXSequence#getBounds()
	 * @see #getCXSequence()
	 * @generated
	 */
	EReference getCXSequence_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXSequence#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see dds4ccm.CXSequence#getBound()
	 * @see #getCXSequence()
	 * @generated
	 */
	EAttribute getCXSequence_Bound();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXString <em>CX String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX String</em>'.
	 * @see dds4ccm.CXString
	 * @generated
	 */
	EClass getCXString();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXStruct <em>CX Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Struct</em>'.
	 * @see dds4ccm.CXStruct
	 * @generated
	 */
	EClass getCXStruct();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Extensible <em>Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extensible</em>'.
	 * @see dds4ccm.Extensible
	 * @generated
	 */
	EClass getExtensible();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Extensible#getExtensibility <em>Extensibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extensibility</em>'.
	 * @see dds4ccm.Extensible#getExtensibility()
	 * @see #getExtensible()
	 * @generated
	 */
	EAttribute getExtensible_Extensibility();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXSupports <em>CX Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Supports</em>'.
	 * @see dds4ccm.CXSupports
	 * @generated
	 */
	EClass getCXSupports();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXSupports#getBase_Generalization <em>Base Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Generalization</em>'.
	 * @see dds4ccm.CXSupports#getBase_Generalization()
	 * @see #getCXSupports()
	 * @generated
	 */
	EReference getCXSupports_Base_Generalization();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXTypeDef <em>CX Type Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Type Def</em>'.
	 * @see dds4ccm.CXTypeDef
	 * @generated
	 */
	EClass getCXTypeDef();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXTypeDef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see dds4ccm.CXTypeDef#getType()
	 * @see #getCXTypeDef()
	 * @generated
	 */
	EReference getCXTypeDef_Type();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXUnion <em>CX Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Union</em>'.
	 * @see dds4ccm.CXUnion
	 * @generated
	 */
	EClass getCXUnion();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXValue <em>CX Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Value</em>'.
	 * @see dds4ccm.CXValue
	 * @generated
	 */
	EClass getCXValue();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXValue#isCustom <em>Is Custom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Custom</em>'.
	 * @see dds4ccm.CXValue#isCustom()
	 * @see #getCXValue()
	 * @generated
	 */
	EAttribute getCXValue_IsCustom();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXValue#isTruncatable <em>Is Truncatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Truncatable</em>'.
	 * @see dds4ccm.CXValue#isTruncatable()
	 * @see #getCXValue()
	 * @generated
	 */
	EAttribute getCXValue_IsTruncatable();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXValue#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see dds4ccm.CXValue#getBase_Interface()
	 * @see #getCXValue()
	 * @generated
	 */
	EReference getCXValue_Base_Interface();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXValueFactory <em>CX Value Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Value Factory</em>'.
	 * @see dds4ccm.CXValueFactory
	 * @generated
	 */
	EClass getCXValueFactory();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXValueFactory#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see dds4ccm.CXValueFactory#getBase_Operation()
	 * @see #getCXValueFactory()
	 * @generated
	 */
	EReference getCXValueFactory_Base_Operation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXModule <em>CX Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Module</em>'.
	 * @see dds4ccm.CXModule
	 * @generated
	 */
	EClass getCXModule();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXModule#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see dds4ccm.CXModule#getBase_Package()
	 * @see #getCXModule()
	 * @generated
	 */
	EReference getCXModule_Base_Package();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXAttribute <em>CX Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Attribute</em>'.
	 * @see dds4ccm.CXAttribute
	 * @generated
	 */
	EClass getCXAttribute();

	/**
	 * Returns the meta object for the reference list '{@link dds4ccm.CXAttribute#getSetraises <em>Setraises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Setraises</em>'.
	 * @see dds4ccm.CXAttribute#getSetraises()
	 * @see #getCXAttribute()
	 * @generated
	 */
	EReference getCXAttribute_Setraises();

	/**
	 * Returns the meta object for the reference list '{@link dds4ccm.CXAttribute#getGetraises <em>Getraises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Getraises</em>'.
	 * @see dds4ccm.CXAttribute#getGetraises()
	 * @see #getCXAttribute()
	 * @generated
	 */
	EReference getCXAttribute_Getraises();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXAttribute#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.CXAttribute#getBase_Property()
	 * @see #getCXAttribute()
	 * @generated
	 */
	EReference getCXAttribute_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXOperation <em>CX Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Operation</em>'.
	 * @see dds4ccm.CXOperation
	 * @generated
	 */
	EClass getCXOperation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXOperation#getIdlType <em>Idl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Idl Type</em>'.
	 * @see dds4ccm.CXOperation#getIdlType()
	 * @see #getCXOperation()
	 * @generated
	 */
	EReference getCXOperation_IdlType();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXOperation#isOneWay <em>Is One Way</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is One Way</em>'.
	 * @see dds4ccm.CXOperation#isOneWay()
	 * @see #getCXOperation()
	 * @generated
	 */
	EAttribute getCXOperation_IsOneWay();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXOperation#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see dds4ccm.CXOperation#getBase_Operation()
	 * @see #getCXOperation()
	 * @generated
	 */
	EReference getCXOperation_Base_Operation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXField <em>CX Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Field</em>'.
	 * @see dds4ccm.CXField
	 * @generated
	 */
	EClass getCXField();

	/**
	 * Returns the meta object for the containment reference list '{@link dds4ccm.CXField#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bounds</em>'.
	 * @see dds4ccm.CXField#getBounds()
	 * @see #getCXField()
	 * @generated
	 */
	EReference getCXField_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.CXField#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see dds4ccm.CXField#getBound()
	 * @see #getCXField()
	 * @generated
	 */
	EAttribute getCXField_Bound();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXField#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.CXField#getBase_Property()
	 * @see #getCXField()
	 * @generated
	 */
	EReference getCXField_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.CXParameter <em>CX Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CX Parameter</em>'.
	 * @see dds4ccm.CXParameter
	 * @generated
	 */
	EClass getCXParameter();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.CXParameter#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see dds4ccm.CXParameter#getBase_Parameter()
	 * @see #getCXParameter()
	 * @generated
	 */
	EReference getCXParameter_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link dds4ccm.StateMember <em>State Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Member</em>'.
	 * @see dds4ccm.StateMember
	 * @generated
	 */
	EClass getStateMember();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.StateMember#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.StateMember#getBase_Property()
	 * @see #getStateMember()
	 * @generated
	 */
	EReference getStateMember_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorDef <em>Connector Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Def</em>'.
	 * @see dds4ccm.ConnectorDef
	 * @generated
	 */
	EClass getConnectorDef();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorFragment <em>Connector Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Fragment</em>'.
	 * @see dds4ccm.ConnectorFragment
	 * @generated
	 */
	EClass getConnectorFragment();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FragmentImplementation <em>Fragment Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Implementation</em>'.
	 * @see dds4ccm.FragmentImplementation
	 * @generated
	 */
	EClass getFragmentImplementation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FragmentAssembly <em>Fragment Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Assembly</em>'.
	 * @see dds4ccm.FragmentAssembly
	 * @generated
	 */
	EClass getFragmentAssembly();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorImplementation <em>Connector Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Implementation</em>'.
	 * @see dds4ccm.ConnectorImplementation
	 * @generated
	 */
	EClass getConnectorImplementation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorAssembly <em>Connector Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Assembly</em>'.
	 * @see dds4ccm.ConnectorAssembly
	 * @generated
	 */
	EClass getConnectorAssembly();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FragmentPart <em>Fragment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Part</em>'.
	 * @see dds4ccm.FragmentPart
	 * @generated
	 */
	EClass getFragmentPart();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TypedConnector <em>Typed Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Connector</em>'.
	 * @see dds4ccm.TypedConnector
	 * @generated
	 */
	EClass getTypedConnector();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TypedConnector#getConnectorType <em>Connector Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector Type</em>'.
	 * @see dds4ccm.TypedConnector#getConnectorType()
	 * @see #getTypedConnector()
	 * @generated
	 */
	EReference getTypedConnector_ConnectorType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TypeParameter <em>Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Parameter</em>'.
	 * @see dds4ccm.TypeParameter
	 * @generated
	 */
	EClass getTypeParameter();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.TypeParameter#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see dds4ccm.TypeParameter#getConstraint()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EAttribute getTypeParameter_Constraint();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TypeParameter#getBase_ClassifierTemplateParameter <em>Base Classifier Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Classifier Template Parameter</em>'.
	 * @see dds4ccm.TypeParameter#getBase_ClassifierTemplateParameter()
	 * @see #getTypeParameter()
	 * @generated
	 */
	EReference getTypeParameter_Base_ClassifierTemplateParameter();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TemplateModule <em>Template Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Module</em>'.
	 * @see dds4ccm.TemplateModule
	 * @generated
	 */
	EClass getTemplateModule();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TemplateModule#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see dds4ccm.TemplateModule#getBase_Package()
	 * @see #getTemplateModule()
	 * @generated
	 */
	EReference getTemplateModule_Base_Package();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ModuleInstantiation <em>Module Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Instantiation</em>'.
	 * @see dds4ccm.ModuleInstantiation
	 * @generated
	 */
	EClass getModuleInstantiation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ModuleInstantiation#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see dds4ccm.ModuleInstantiation#getBase_Package()
	 * @see #getModuleInstantiation()
	 * @generated
	 */
	EReference getModuleInstantiation_Base_Package();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ParameterBinding <em>Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Binding</em>'.
	 * @see dds4ccm.ParameterBinding
	 * @generated
	 */
	EClass getParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ParameterBinding#getBase_TemplateParameterSubstitution <em>Base Template Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Template Parameter Substitution</em>'.
	 * @see dds4ccm.ParameterBinding#getBase_TemplateParameterSubstitution()
	 * @see #getParameterBinding()
	 * @generated
	 */
	EReference getParameterBinding_Base_TemplateParameterSubstitution();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TemplateModuleAlias <em>Template Module Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Module Alias</em>'.
	 * @see dds4ccm.TemplateModuleAlias
	 * @generated
	 */
	EClass getTemplateModuleAlias();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ModuleBinding <em>Module Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Binding</em>'.
	 * @see dds4ccm.ModuleBinding
	 * @generated
	 */
	EClass getModuleBinding();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ModuleBinding#getBase_TemplateBinding <em>Base Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Template Binding</em>'.
	 * @see dds4ccm.ModuleBinding#getBase_TemplateBinding()
	 * @see #getModuleBinding()
	 * @generated
	 */
	EReference getModuleBinding_Base_TemplateBinding();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TemplateSignature <em>Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Signature</em>'.
	 * @see dds4ccm.TemplateSignature
	 * @generated
	 */
	EClass getTemplateSignature();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TemplateSignature#getBase_TemplateSignature <em>Base Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Template Signature</em>'.
	 * @see dds4ccm.TemplateSignature#getBase_TemplateSignature()
	 * @see #getTemplateSignature()
	 * @generated
	 */
	EReference getTemplateSignature_Base_TemplateSignature();

	/**
	 * Returns the meta object for class '{@link dds4ccm.InterfacePort <em>Interface Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Port</em>'.
	 * @see dds4ccm.InterfacePort
	 * @generated
	 */
	EClass getInterfacePort();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.InterfacePort#getConnectorType <em>Connector Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector Type</em>'.
	 * @see dds4ccm.InterfacePort#getConnectorType()
	 * @see #getInterfacePort()
	 * @generated
	 */
	EReference getInterfacePort_ConnectorType();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.InterfacePort#isAsynchronous <em>Is Asynchronous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Asynchronous</em>'.
	 * @see dds4ccm.InterfacePort#isAsynchronous()
	 * @see #getInterfacePort()
	 * @generated
	 */
	EAttribute getInterfacePort_IsAsynchronous();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.InterfacePort#isHasCSL <em>Has CSL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has CSL</em>'.
	 * @see dds4ccm.InterfacePort#isHasCSL()
	 * @see #getInterfacePort()
	 * @generated
	 */
	EAttribute getInterfacePort_HasCSL();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Native <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native</em>'.
	 * @see dds4ccm.Native
	 * @generated
	 */
	EClass getNative();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Native#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.Native#getBase_DataType()
	 * @see #getNative()
	 * @generated
	 */
	EReference getNative_Base_DataType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DataSpace <em>Data Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Space</em>'.
	 * @see dds4ccm.DataSpace
	 * @generated
	 */
	EClass getDataSpace();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.DataSpace#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.DataSpace#getBase_NamedElement()
	 * @see #getDataSpace()
	 * @generated
	 */
	EReference getDataSpace_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Topic <em>Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic</em>'.
	 * @see dds4ccm.Topic
	 * @generated
	 */
	EClass getTopic();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Topic#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see dds4ccm.Topic#getExpression()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_Expression();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Topic#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.Topic#getKind()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_Kind();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Topic#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.Topic#getBase_Class()
	 * @see #getTopic()
	 * @generated
	 */
	EReference getTopic_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TopicField <em>Topic Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic Field</em>'.
	 * @see dds4ccm.TopicField
	 * @generated
	 */
	EClass getTopicField();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TopicField#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.TopicField#getBase_Property()
	 * @see #getTopicField()
	 * @generated
	 */
	EReference getTopicField_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.qosPolicy <em>qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>qos Policy</em>'.
	 * @see dds4ccm.qosPolicy
	 * @generated
	 */
	EClass getqosPolicy();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.qosPolicy#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.qosPolicy#getBase_Class()
	 * @see #getqosPolicy()
	 * @generated
	 */
	EReference getqosPolicy_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.historyQosPolicy <em>history Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>history Qos Policy</em>'.
	 * @see dds4ccm.historyQosPolicy
	 * @generated
	 */
	EClass gethistoryQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.historyQosPolicy#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see dds4ccm.historyQosPolicy#getDepth()
	 * @see #gethistoryQosPolicy()
	 * @generated
	 */
	EAttribute gethistoryQosPolicy_Depth();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.historyQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.historyQosPolicy#getKind()
	 * @see #gethistoryQosPolicy()
	 * @generated
	 */
	EAttribute gethistoryQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.lifespanQosPolicy <em>lifespan Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>lifespan Qos Policy</em>'.
	 * @see dds4ccm.lifespanQosPolicy
	 * @generated
	 */
	EClass getlifespanQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.lifespanQosPolicy#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see dds4ccm.lifespanQosPolicy#getDuration()
	 * @see #getlifespanQosPolicy()
	 * @generated
	 */
	EReference getlifespanQosPolicy_Duration();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Duration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duration</em>'.
	 * @see dds4ccm.Duration
	 * @generated
	 */
	EClass getDuration();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Duration#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second</em>'.
	 * @see dds4ccm.Duration#getSecond()
	 * @see #getDuration()
	 * @generated
	 */
	EAttribute getDuration_Second();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Duration#getNanosecond <em>Nanosecond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nanosecond</em>'.
	 * @see dds4ccm.Duration#getNanosecond()
	 * @see #getDuration()
	 * @generated
	 */
	EAttribute getDuration_Nanosecond();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ownershipQosPolicy <em>ownership Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ownership Qos Policy</em>'.
	 * @see dds4ccm.ownershipQosPolicy
	 * @generated
	 */
	EClass getownershipQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.ownershipQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.ownershipQosPolicy#getKind()
	 * @see #getownershipQosPolicy()
	 * @generated
	 */
	EAttribute getownershipQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.osQosPolicy <em>os Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>os Qos Policy</em>'.
	 * @see dds4ccm.osQosPolicy
	 * @generated
	 */
	EClass getosQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.osQosPolicy#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.osQosPolicy#getValue()
	 * @see #getosQosPolicy()
	 * @generated
	 */
	EAttribute getosQosPolicy_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.wdlQosPolicy <em>wdl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>wdl Qos Policy</em>'.
	 * @see dds4ccm.wdlQosPolicy
	 * @generated
	 */
	EClass getwdlQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.wdlQosPolicy#isAutodispose_unregistered_instances <em>Autodispose unregistered instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autodispose unregistered instances</em>'.
	 * @see dds4ccm.wdlQosPolicy#isAutodispose_unregistered_instances()
	 * @see #getwdlQosPolicy()
	 * @generated
	 */
	EAttribute getwdlQosPolicy_Autodispose_unregistered_instances();

	/**
	 * Returns the meta object for class '{@link dds4ccm.rdlQosPolicy <em>rdl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rdl Qos Policy</em>'.
	 * @see dds4ccm.rdlQosPolicy
	 * @generated
	 */
	EClass getrdlQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.rdlQosPolicy#getAutopurge_nowriter_samples_delay <em>Autopurge nowriter samples delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Autopurge nowriter samples delay</em>'.
	 * @see dds4ccm.rdlQosPolicy#getAutopurge_nowriter_samples_delay()
	 * @see #getrdlQosPolicy()
	 * @generated
	 */
	EReference getrdlQosPolicy_Autopurge_nowriter_samples_delay();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.rdlQosPolicy#getAutopurge_disposed_samples_delay <em>Autopurge disposed samples delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Autopurge disposed samples delay</em>'.
	 * @see dds4ccm.rdlQosPolicy#getAutopurge_disposed_samples_delay()
	 * @see #getrdlQosPolicy()
	 * @generated
	 */
	EReference getrdlQosPolicy_Autopurge_disposed_samples_delay();

	/**
	 * Returns the meta object for class '{@link dds4ccm.udQosPolicy <em>ud Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ud Qos Policy</em>'.
	 * @see dds4ccm.udQosPolicy
	 * @generated
	 */
	EClass getudQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.udQosPolicy#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.udQosPolicy#getValue()
	 * @see #getudQosPolicy()
	 * @generated
	 */
	EAttribute getudQosPolicy_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.tdQosPolicy <em>td Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>td Qos Policy</em>'.
	 * @see dds4ccm.tdQosPolicy
	 * @generated
	 */
	EClass gettdQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.tdQosPolicy#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.tdQosPolicy#getValue()
	 * @see #gettdQosPolicy()
	 * @generated
	 */
	EAttribute gettdQosPolicy_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.tpQosPolicy <em>tp Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>tp Qos Policy</em>'.
	 * @see dds4ccm.tpQosPolicy
	 * @generated
	 */
	EClass gettpQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.tpQosPolicy#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.tpQosPolicy#getValue()
	 * @see #gettpQosPolicy()
	 * @generated
	 */
	EAttribute gettpQosPolicy_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.deadlineQosPolicy <em>deadline Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>deadline Qos Policy</em>'.
	 * @see dds4ccm.deadlineQosPolicy
	 * @generated
	 */
	EClass getdeadlineQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.deadlineQosPolicy#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Period</em>'.
	 * @see dds4ccm.deadlineQosPolicy#getPeriod()
	 * @see #getdeadlineQosPolicy()
	 * @generated
	 */
	EReference getdeadlineQosPolicy_Period();

	/**
	 * Returns the meta object for class '{@link dds4ccm.lbQosPolicy <em>lb Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>lb Qos Policy</em>'.
	 * @see dds4ccm.lbQosPolicy
	 * @generated
	 */
	EClass getlbQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.lbQosPolicy#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see dds4ccm.lbQosPolicy#getDuration()
	 * @see #getlbQosPolicy()
	 * @generated
	 */
	EReference getlbQosPolicy_Duration();

	/**
	 * Returns the meta object for class '{@link dds4ccm.tbfQosPolicy <em>tbf Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>tbf Qos Policy</em>'.
	 * @see dds4ccm.tbfQosPolicy
	 * @generated
	 */
	EClass gettbfQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.tbfQosPolicy#getMinimum_separation <em>Minimum separation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Minimum separation</em>'.
	 * @see dds4ccm.tbfQosPolicy#getMinimum_separation()
	 * @see #gettbfQosPolicy()
	 * @generated
	 */
	EReference gettbfQosPolicy_Minimum_separation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.gdQosPolicy <em>gd Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>gd Qos Policy</em>'.
	 * @see dds4ccm.gdQosPolicy
	 * @generated
	 */
	EClass getgdQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.gdQosPolicy#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.gdQosPolicy#getValue()
	 * @see #getgdQosPolicy()
	 * @generated
	 */
	EAttribute getgdQosPolicy_Value();

	/**
	 * Returns the meta object for class '{@link dds4ccm.efQosPolicy <em>ef Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ef Qos Policy</em>'.
	 * @see dds4ccm.efQosPolicy
	 * @generated
	 */
	EClass getefQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.efQosPolicy#isAutoenable_created_entities <em>Autoenable created entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autoenable created entities</em>'.
	 * @see dds4ccm.efQosPolicy#isAutoenable_created_entities()
	 * @see #getefQosPolicy()
	 * @generated
	 */
	EAttribute getefQosPolicy_Autoenable_created_entities();

	/**
	 * Returns the meta object for class '{@link dds4ccm.rlQosPolicy <em>rl Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>rl Qos Policy</em>'.
	 * @see dds4ccm.rlQosPolicy
	 * @generated
	 */
	EClass getrlQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.rlQosPolicy#getMax_instances <em>Max instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max instances</em>'.
	 * @see dds4ccm.rlQosPolicy#getMax_instances()
	 * @see #getrlQosPolicy()
	 * @generated
	 */
	EAttribute getrlQosPolicy_Max_instances();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.rlQosPolicy#getMax_samples <em>Max samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max samples</em>'.
	 * @see dds4ccm.rlQosPolicy#getMax_samples()
	 * @see #getrlQosPolicy()
	 * @generated
	 */
	EAttribute getrlQosPolicy_Max_samples();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.rlQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max samples per instance</em>'.
	 * @see dds4ccm.rlQosPolicy#getMax_samples_per_instance()
	 * @see #getrlQosPolicy()
	 * @generated
	 */
	EAttribute getrlQosPolicy_Max_samples_per_instance();

	/**
	 * Returns the meta object for class '{@link dds4ccm.presentationQosPolicy <em>presentation Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>presentation Qos Policy</em>'.
	 * @see dds4ccm.presentationQosPolicy
	 * @generated
	 */
	EClass getpresentationQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.presentationQosPolicy#getAccess_scope <em>Access scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access scope</em>'.
	 * @see dds4ccm.presentationQosPolicy#getAccess_scope()
	 * @see #getpresentationQosPolicy()
	 * @generated
	 */
	EAttribute getpresentationQosPolicy_Access_scope();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.presentationQosPolicy#isCoherent_access <em>Coherent access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coherent access</em>'.
	 * @see dds4ccm.presentationQosPolicy#isCoherent_access()
	 * @see #getpresentationQosPolicy()
	 * @generated
	 */
	EAttribute getpresentationQosPolicy_Coherent_access();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.presentationQosPolicy#isOrdered_access <em>Ordered access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered access</em>'.
	 * @see dds4ccm.presentationQosPolicy#isOrdered_access()
	 * @see #getpresentationQosPolicy()
	 * @generated
	 */
	EAttribute getpresentationQosPolicy_Ordered_access();

	/**
	 * Returns the meta object for class '{@link dds4ccm.partitionQosPolicy <em>partition Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>partition Qos Policy</em>'.
	 * @see dds4ccm.partitionQosPolicy
	 * @generated
	 */
	EClass getpartitionQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.partitionQosPolicy#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dds4ccm.partitionQosPolicy#getName()
	 * @see #getpartitionQosPolicy()
	 * @generated
	 */
	EAttribute getpartitionQosPolicy_Name();

	/**
	 * Returns the meta object for class '{@link dds4ccm.reliabilityQosPolicy <em>reliability Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>reliability Qos Policy</em>'.
	 * @see dds4ccm.reliabilityQosPolicy
	 * @generated
	 */
	EClass getreliabilityQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.reliabilityQosPolicy#getMax_blocking_time <em>Max blocking time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max blocking time</em>'.
	 * @see dds4ccm.reliabilityQosPolicy#getMax_blocking_time()
	 * @see #getreliabilityQosPolicy()
	 * @generated
	 */
	EReference getreliabilityQosPolicy_Max_blocking_time();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.reliabilityQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.reliabilityQosPolicy#getKind()
	 * @see #getreliabilityQosPolicy()
	 * @generated
	 */
	EAttribute getreliabilityQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.dsQosPolicy <em>ds Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ds Qos Policy</em>'.
	 * @see dds4ccm.dsQosPolicy
	 * @generated
	 */
	EClass getdsQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.dsQosPolicy#getService_cleanup_delay <em>Service cleanup delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service cleanup delay</em>'.
	 * @see dds4ccm.dsQosPolicy#getService_cleanup_delay()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EReference getdsQosPolicy_Service_cleanup_delay();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.dsQosPolicy#getHistory_kind <em>History kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>History kind</em>'.
	 * @see dds4ccm.dsQosPolicy#getHistory_kind()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EAttribute getdsQosPolicy_History_kind();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.dsQosPolicy#getMax_instances <em>Max instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max instances</em>'.
	 * @see dds4ccm.dsQosPolicy#getMax_instances()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EAttribute getdsQosPolicy_Max_instances();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.dsQosPolicy#getMax_samples <em>Max samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max samples</em>'.
	 * @see dds4ccm.dsQosPolicy#getMax_samples()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EAttribute getdsQosPolicy_Max_samples();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.dsQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max samples per instance</em>'.
	 * @see dds4ccm.dsQosPolicy#getMax_samples_per_instance()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EAttribute getdsQosPolicy_Max_samples_per_instance();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.dsQosPolicy#getHistory_depth <em>History depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>History depth</em>'.
	 * @see dds4ccm.dsQosPolicy#getHistory_depth()
	 * @see #getdsQosPolicy()
	 * @generated
	 */
	EAttribute getdsQosPolicy_History_depth();

	/**
	 * Returns the meta object for class '{@link dds4ccm.livelinessQosPolicy <em>liveliness Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>liveliness Qos Policy</em>'.
	 * @see dds4ccm.livelinessQosPolicy
	 * @generated
	 */
	EClass getlivelinessQosPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link dds4ccm.livelinessQosPolicy#getLease_duration <em>Lease duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lease duration</em>'.
	 * @see dds4ccm.livelinessQosPolicy#getLease_duration()
	 * @see #getlivelinessQosPolicy()
	 * @generated
	 */
	EReference getlivelinessQosPolicy_Lease_duration();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.livelinessQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.livelinessQosPolicy#getKind()
	 * @see #getlivelinessQosPolicy()
	 * @generated
	 */
	EAttribute getlivelinessQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.durabilityQosPolicy <em>durability Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>durability Qos Policy</em>'.
	 * @see dds4ccm.durabilityQosPolicy
	 * @generated
	 */
	EClass getdurabilityQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.durabilityQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.durabilityQosPolicy#getKind()
	 * @see #getdurabilityQosPolicy()
	 * @generated
	 */
	EAttribute getdurabilityQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.doQosPolicy <em>do Qos Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>do Qos Policy</em>'.
	 * @see dds4ccm.doQosPolicy
	 * @generated
	 */
	EClass getdoQosPolicy();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.doQosPolicy#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.doQosPolicy#getKind()
	 * @see #getdoQosPolicy()
	 * @generated
	 */
	EAttribute getdoQosPolicy_Kind();

	/**
	 * Returns the meta object for class '{@link dds4ccm.qosProperty <em>qos Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>qos Property</em>'.
	 * @see dds4ccm.qosProperty
	 * @generated
	 */
	EClass getqosProperty();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.qosProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.qosProperty#getBase_Property()
	 * @see #getqosProperty()
	 * @generated
	 */
	EReference getqosProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DDSMessage <em>DDS Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DDS Message</em>'.
	 * @see dds4ccm.DDSMessage
	 * @generated
	 */
	EClass getDDSMessage();

	/**
	 * Returns the meta object for class '{@link dds4ccm.MessageField <em>Message Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Field</em>'.
	 * @see dds4ccm.MessageField
	 * @generated
	 */
	EClass getMessageField();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.MessageField#isKey <em>Is Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Key</em>'.
	 * @see dds4ccm.MessageField#isKey()
	 * @see #getMessageField()
	 * @generated
	 */
	EAttribute getMessageField_IsKey();

	/**
	 * Returns the meta object for class '{@link dds4ccm.QoSProfile <em>Qo SProfile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qo SProfile</em>'.
	 * @see dds4ccm.QoSProfile
	 * @generated
	 */
	EClass getQoSProfile();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.QoSProfile#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see dds4ccm.QoSProfile#getFilename()
	 * @see #getQoSProfile()
	 * @generated
	 */
	EAttribute getQoSProfile_Filename();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.QoSProfile#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.QoSProfile#getBase_Class()
	 * @see #getQoSProfile()
	 * @generated
	 */
	EReference getQoSProfile_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.QoSForEntity <em>Qo SFor Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qo SFor Entity</em>'.
	 * @see dds4ccm.QoSForEntity
	 * @generated
	 */
	EClass getQoSForEntity();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.QoSForEntity#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.QoSForEntity#getBase_Class()
	 * @see #getQoSForEntity()
	 * @generated
	 */
	EReference getQoSForEntity_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.QoSEntity <em>Qo SEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qo SEntity</em>'.
	 * @see dds4ccm.QoSEntity
	 * @generated
	 */
	EClass getQoSEntity();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.QoSEntity#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.QoSEntity#getBase_Property()
	 * @see #getQoSEntity()
	 * @generated
	 */
	EReference getQoSEntity_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DataReaderQoS <em>Data Reader Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader Qo S</em>'.
	 * @see dds4ccm.DataReaderQoS
	 * @generated
	 */
	EClass getDataReaderQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DataReaderWriterQoS <em>Data Reader Writer Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reader Writer Qo S</em>'.
	 * @see dds4ccm.DataReaderWriterQoS
	 * @generated
	 */
	EClass getDataReaderWriterQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ParticipantQoS <em>Participant Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant Qo S</em>'.
	 * @see dds4ccm.ParticipantQoS
	 * @generated
	 */
	EClass getParticipantQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.PublisherQoS <em>Publisher Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher Qo S</em>'.
	 * @see dds4ccm.PublisherQoS
	 * @generated
	 */
	EClass getPublisherQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.PublisherSubscriberQoS <em>Publisher Subscriber Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher Subscriber Qo S</em>'.
	 * @see dds4ccm.PublisherSubscriberQoS
	 * @generated
	 */
	EClass getPublisherSubscriberQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.SubscriberQoS <em>Subscriber Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subscriber Qo S</em>'.
	 * @see dds4ccm.SubscriberQoS
	 * @generated
	 */
	EClass getSubscriberQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TopicQoS <em>Topic Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic Qo S</em>'.
	 * @see dds4ccm.TopicQoS
	 * @generated
	 */
	EClass getTopicQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DataWriterQoS <em>Data Writer Qo S</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Writer Qo S</em>'.
	 * @see dds4ccm.DataWriterQoS
	 * @generated
	 */
	EClass getDataWriterQoS();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see dds4ccm.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Domain#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see dds4ccm.Domain#getLabel()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_Label();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Domain#getUUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UUID</em>'.
	 * @see dds4ccm.Domain#getUUID()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_UUID();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Domain#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.Domain#getBase_Component()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see dds4ccm.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Node#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.Node#getBase_Component()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.NodeInstance <em>Node Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Instance</em>'.
	 * @see dds4ccm.NodeInstance
	 * @generated
	 */
	EClass getNodeInstance();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.NodeInstance#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see dds4ccm.NodeInstance#getLabel()
	 * @see #getNodeInstance()
	 * @generated
	 */
	EAttribute getNodeInstance_Label();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.NodeInstance#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.NodeInstance#getBase_Property()
	 * @see #getNodeInstance()
	 * @generated
	 */
	EReference getNodeInstance_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Interconnect <em>Interconnect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interconnect</em>'.
	 * @see dds4ccm.Interconnect
	 * @generated
	 */
	EClass getInterconnect();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Interconnect#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.Interconnect#getBase_Component()
	 * @see #getInterconnect()
	 * @generated
	 */
	EReference getInterconnect_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.InterconnectInstance <em>Interconnect Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interconnect Instance</em>'.
	 * @see dds4ccm.InterconnectInstance
	 * @generated
	 */
	EClass getInterconnectInstance();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.InterconnectInstance#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see dds4ccm.InterconnectInstance#getLabel()
	 * @see #getInterconnectInstance()
	 * @generated
	 */
	EAttribute getInterconnectInstance_Label();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.InterconnectInstance#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.InterconnectInstance#getBase_Property()
	 * @see #getInterconnectInstance()
	 * @generated
	 */
	EReference getInterconnectInstance_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Bridge <em>Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bridge</em>'.
	 * @see dds4ccm.Bridge
	 * @generated
	 */
	EClass getBridge();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Bridge#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.Bridge#getBase_Component()
	 * @see #getBridge()
	 * @generated
	 */
	EReference getBridge_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.BridgeInstance <em>Bridge Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bridge Instance</em>'.
	 * @see dds4ccm.BridgeInstance
	 * @generated
	 */
	EClass getBridgeInstance();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.BridgeInstance#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see dds4ccm.BridgeInstance#getLabel()
	 * @see #getBridgeInstance()
	 * @generated
	 */
	EAttribute getBridgeInstance_Label();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.BridgeInstance#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.BridgeInstance#getBase_Property()
	 * @see #getBridgeInstance()
	 * @generated
	 */
	EReference getBridgeInstance_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see dds4ccm.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link dds4ccm.RequirementSatisfier <em>Requirement Satisfier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Satisfier</em>'.
	 * @see dds4ccm.RequirementSatisfier
	 * @generated
	 */
	EClass getRequirementSatisfier();

	/**
	 * Returns the meta object for the attribute list '{@link dds4ccm.RequirementSatisfier#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resource Type</em>'.
	 * @see dds4ccm.RequirementSatisfier#getResourceType()
	 * @see #getRequirementSatisfier()
	 * @generated
	 */
	EAttribute getRequirementSatisfier_ResourceType();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.RequirementSatisfier#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.RequirementSatisfier#getBase_Class()
	 * @see #getRequirementSatisfier()
	 * @generated
	 */
	EReference getRequirementSatisfier_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ResourceProperty <em>Resource Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Property</em>'.
	 * @see dds4ccm.ResourceProperty
	 * @generated
	 */
	EClass getResourceProperty();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ResourceProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.ResourceProperty#getBase_Property()
	 * @see #getResourceProperty()
	 * @generated
	 */
	EReference getResourceProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.SharedResource <em>Shared Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Resource</em>'.
	 * @see dds4ccm.SharedResource
	 * @generated
	 */
	EClass getSharedResource();

	/**
	 * Returns the meta object for class '{@link dds4ccm.SatisfierProperty <em>Satisfier Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Satisfier Property</em>'.
	 * @see dds4ccm.SatisfierProperty
	 * @generated
	 */
	EClass getSatisfierProperty();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.SatisfierProperty#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see dds4ccm.SatisfierProperty#isDynamic()
	 * @see #getSatisfierProperty()
	 * @generated
	 */
	EAttribute getSatisfierProperty_Dynamic();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.SatisfierProperty#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see dds4ccm.SatisfierProperty#getKind()
	 * @see #getSatisfierProperty()
	 * @generated
	 */
	EAttribute getSatisfierProperty_Kind();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.SatisfierProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.SatisfierProperty#getValue()
	 * @see #getSatisfierProperty()
	 * @generated
	 */
	EAttribute getSatisfierProperty_Value();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.SatisfierProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.SatisfierProperty#getBase_Property()
	 * @see #getSatisfierProperty()
	 * @generated
	 */
	EReference getSatisfierProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see dds4ccm.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the reference list '{@link dds4ccm.Requirement#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property</em>'.
	 * @see dds4ccm.Requirement#getProperty()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Property();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Requirement#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Type</em>'.
	 * @see dds4ccm.Requirement#getResourceType()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ResourceType();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Requirement#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.Requirement#getBase_Class()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Plan</em>'.
	 * @see dds4ccm.DeploymentPlan
	 * @generated
	 */
	EClass getDeploymentPlan();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.DeploymentPlan#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see dds4ccm.DeploymentPlan#getId()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EAttribute getDeploymentPlan_Id();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment</em>'.
	 * @see dds4ccm.Deployment
	 * @generated
	 */
	EClass getDeployment();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Deployment#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.Deployment#getBase_Component()
	 * @see #getDeployment()
	 * @generated
	 */
	EReference getDeployment_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Allocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation</em>'.
	 * @see dds4ccm.Allocation
	 * @generated
	 */
	EClass getAllocation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Allocation#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see dds4ccm.Allocation#getBase_Dependency()
	 * @see #getAllocation()
	 * @generated
	 */
	EReference getAllocation_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link dds4ccm.DeploymentPart <em>Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Part</em>'.
	 * @see dds4ccm.DeploymentPart
	 * @generated
	 */
	EClass getDeploymentPart();

	/**
	 * Returns the meta object for the reference list '{@link dds4ccm.DeploymentPart#getNestedPart <em>Nested Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nested Part</em>'.
	 * @see dds4ccm.DeploymentPart#getNestedPart()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_NestedPart();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.DeploymentPart#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see dds4ccm.DeploymentPart#getConfiguration()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_Configuration();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.DeploymentPart#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see dds4ccm.DeploymentPart#getModelElement()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_ModelElement();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.DeploymentPart#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.DeploymentPart#getBase_Property()
	 * @see #getDeploymentPart()
	 * @generated
	 */
	EReference getDeploymentPart_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see dds4ccm.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Configuration#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.Configuration#getBase_Class()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Configuration#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see dds4ccm.Configuration#getBase_InstanceSpecification()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Base_InstanceSpecification();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ComponentDeploymentPart <em>Component Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Deployment Part</em>'.
	 * @see dds4ccm.ComponentDeploymentPart
	 * @generated
	 */
	EClass getComponentDeploymentPart();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ComponentDeploymentPart#getSelectedImplementation <em>Selected Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selected Implementation</em>'.
	 * @see dds4ccm.ComponentDeploymentPart#getSelectedImplementation()
	 * @see #getComponentDeploymentPart()
	 * @generated
	 */
	EReference getComponentDeploymentPart_SelectedImplementation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ComponentDeploymentPart#getImplementationConfiguration <em>Implementation Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Configuration</em>'.
	 * @see dds4ccm.ComponentDeploymentPart#getImplementationConfiguration()
	 * @see #getComponentDeploymentPart()
	 * @generated
	 */
	EReference getComponentDeploymentPart_ImplementationConfiguration();

	/**
	 * Returns the meta object for class '{@link dds4ccm.BuildConfiguration <em>Build Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Build Configuration</em>'.
	 * @see dds4ccm.BuildConfiguration
	 * @generated
	 */
	EClass getBuildConfiguration();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConfigurationSlot <em>Configuration Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Slot</em>'.
	 * @see dds4ccm.ConfigurationSlot
	 * @generated
	 */
	EClass getConfigurationSlot();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.ConfigurationSlot#getSlotKind <em>Slot Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slot Kind</em>'.
	 * @see dds4ccm.ConfigurationSlot#getSlotKind()
	 * @see #getConfigurationSlot()
	 * @generated
	 */
	EAttribute getConfigurationSlot_SlotKind();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ConfigurationSlot#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see dds4ccm.ConfigurationSlot#getBase_Slot()
	 * @see #getConfigurationSlot()
	 * @generated
	 */
	EReference getConfigurationSlot_Base_Slot();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TargetAssemblyConnector <em>Target Assembly Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Assembly Connector</em>'.
	 * @see dds4ccm.TargetAssemblyConnector
	 * @generated
	 */
	EClass getTargetAssemblyConnector();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ContainerProcess <em>Container Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Process</em>'.
	 * @see dds4ccm.ContainerProcess
	 * @generated
	 */
	EClass getContainerProcess();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ContainerProcess#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see dds4ccm.ContainerProcess#getBase_Component()
	 * @see #getContainerProcess()
	 * @generated
	 */
	EReference getContainerProcess_Base_Component();

	/**
	 * Returns the meta object for class '{@link dds4ccm.TemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Type</em>'.
	 * @see dds4ccm.TemplateParameterType
	 * @generated
	 */
	EClass getTemplateParameterType();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TemplateParameterType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.TemplateParameterType#getBase_Class()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EReference getTemplateParameterType_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TemplateParameterType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see dds4ccm.TemplateParameterType#getBase_DataType()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EReference getTemplateParameterType_Base_DataType();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.TemplateParameterType#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see dds4ccm.TemplateParameterType#getBase_Interface()
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	EReference getTemplateParameterType_Base_Interface();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ExtendedPortType <em>Extended Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Port Type</em>'.
	 * @see dds4ccm.ExtendedPortType
	 * @generated
	 */
	EClass getExtendedPortType();

	/**
	 * Returns the meta object for class '{@link dds4ccm.IDLFileSpecification <em>IDL File Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDL File Specification</em>'.
	 * @see dds4ccm.IDLFileSpecification
	 * @generated
	 */
	EClass getIDLFileSpecification();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.IDLFileSpecification#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see dds4ccm.IDLFileSpecification#getBase_Class()
	 * @see #getIDLFileSpecification()
	 * @generated
	 */
	EReference getIDLFileSpecification_Base_Class();

	/**
	 * Returns the meta object for class '{@link dds4ccm.IDLFileDependency <em>IDL File Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDL File Dependency</em>'.
	 * @see dds4ccm.IDLFileDependency
	 * @generated
	 */
	EClass getIDLFileDependency();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.IDLFileDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see dds4ccm.IDLFileDependency#getBase_Dependency()
	 * @see #getIDLFileDependency()
	 * @generated
	 */
	EReference getIDLFileDependency_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link dds4ccm.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see dds4ccm.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link dds4ccm.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dds4ccm.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.Property#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see dds4ccm.Property#getBase_Property()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorDefaultValueBinding <em>Connector Default Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Default Value Binding</em>'.
	 * @see dds4ccm.ConnectorDefaultValueBinding
	 * @generated
	 */
	EClass getConnectorDefaultValueBinding();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ConnectorDefaultValueBinding#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see dds4ccm.ConnectorDefaultValueBinding#getDefinition()
	 * @see #getConnectorDefaultValueBinding()
	 * @generated
	 */
	EReference getConnectorDefaultValueBinding_Definition();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ConnectorDefaultValueBinding#getConnectorInstance <em>Connector Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector Instance</em>'.
	 * @see dds4ccm.ConnectorDefaultValueBinding#getConnectorInstance()
	 * @see #getConnectorDefaultValueBinding()
	 * @generated
	 */
	EReference getConnectorDefaultValueBinding_ConnectorInstance();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.ConnectorDefaultValueBinding#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see dds4ccm.ConnectorDefaultValueBinding#getBase_Package()
	 * @see #getConnectorDefaultValueBinding()
	 * @generated
	 */
	EReference getConnectorDefaultValueBinding_Base_Package();

	/**
	 * Returns the meta object for class '{@link dds4ccm.IDLIncludeDependency <em>IDL Include Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDL Include Dependency</em>'.
	 * @see dds4ccm.IDLIncludeDependency
	 * @generated
	 */
	EClass getIDLIncludeDependency();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.IDLIncludeDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see dds4ccm.IDLIncludeDependency#getBase_Dependency()
	 * @see #getIDLIncludeDependency()
	 * @generated
	 */
	EReference getIDLIncludeDependency_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link dds4ccm.WorkerFunctionImpl <em>Worker Function Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker Function Impl</em>'.
	 * @see dds4ccm.WorkerFunctionImpl
	 * @generated
	 */
	EClass getWorkerFunctionImpl();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.WorkerFunctionImpl#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Behavior</em>'.
	 * @see dds4ccm.WorkerFunctionImpl#getBase_OpaqueBehavior()
	 * @see #getWorkerFunctionImpl()
	 * @generated
	 */
	EReference getWorkerFunctionImpl_Base_OpaqueBehavior();

	/**
	 * Returns the meta object for class '{@link dds4ccm.ConnectorStatusListenerConnection <em>Connector Status Listener Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Status Listener Connection</em>'.
	 * @see dds4ccm.ConnectorStatusListenerConnection
	 * @generated
	 */
	EClass getConnectorStatusListenerConnection();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FinderOperation <em>Finder Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finder Operation</em>'.
	 * @see dds4ccm.FinderOperation
	 * @generated
	 */
	EClass getFinderOperation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.HomeOperation <em>Home Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Home Operation</em>'.
	 * @see dds4ccm.HomeOperation
	 * @generated
	 */
	EClass getHomeOperation();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.HomeOperation#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see dds4ccm.HomeOperation#getBase_Operation()
	 * @see #getHomeOperation()
	 * @generated
	 */
	EReference getHomeOperation_Base_Operation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.FactoryOperation <em>Factory Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Factory Operation</em>'.
	 * @see dds4ccm.FactoryOperation
	 * @generated
	 */
	EClass getFactoryOperation();

	/**
	 * Returns the meta object for class '{@link dds4ccm.HomeInstance <em>Home Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Home Instance</em>'.
	 * @see dds4ccm.HomeInstance
	 * @generated
	 */
	EClass getHomeInstance();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.HomeInstance#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.HomeInstance#getBase_NamedElement()
	 * @see #getHomeInstance()
	 * @generated
	 */
	EReference getHomeInstance_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.HideableElement <em>Hideable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hideable Element</em>'.
	 * @see dds4ccm.HideableElement
	 * @generated
	 */
	EClass getHideableElement();

	/**
	 * Returns the meta object for the reference '{@link dds4ccm.HideableElement#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see dds4ccm.HideableElement#getBase_NamedElement()
	 * @see #getHideableElement()
	 * @generated
	 */
	EReference getHideableElement_Base_NamedElement();

	/**
	 * Returns the meta object for class '{@link dds4ccm.PerPortConnectorTypeDeploymentPart <em>Per Port Connector Type Deployment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Per Port Connector Type Deployment Part</em>'.
	 * @see dds4ccm.PerPortConnectorTypeDeploymentPart
	 * @generated
	 */
	EClass getPerPortConnectorTypeDeploymentPart();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.ComponentCategory <em>Component Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Component Category</em>'.
	 * @see dds4ccm.ComponentCategory
	 * @generated
	 */
	EEnum getComponentCategory();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.WiringKind <em>Wiring Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Wiring Kind</em>'.
	 * @see dds4ccm.WiringKind
	 * @generated
	 */
	EEnum getWiringKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.ModelTypeEnum <em>Model Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Type Enum</em>'.
	 * @see dds4ccm.ModelTypeEnum
	 * @generated
	 */
	EEnum getModelTypeEnum();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.CXPrimitiveKind <em>CX Primitive Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>CX Primitive Kind</em>'.
	 * @see dds4ccm.CXPrimitiveKind
	 * @generated
	 */
	EEnum getCXPrimitiveKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.ExtensibilityKind <em>Extensibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extensibility Kind</em>'.
	 * @see dds4ccm.ExtensibilityKind
	 * @generated
	 */
	EEnum getExtensibilityKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.TypeConstraint <em>Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Constraint</em>'.
	 * @see dds4ccm.TypeConstraint
	 * @generated
	 */
	EEnum getTypeConstraint();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.TopicKind <em>Topic Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Topic Kind</em>'.
	 * @see dds4ccm.TopicKind
	 * @generated
	 */
	EEnum getTopicKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.HistoryQosPolicyKind <em>History Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>History Qos Policy Kind</em>'.
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @generated
	 */
	EEnum getHistoryQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.OwnershipQosPolicyKind <em>Ownership Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ownership Qos Policy Kind</em>'.
	 * @see dds4ccm.OwnershipQosPolicyKind
	 * @generated
	 */
	EEnum getOwnershipQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.PresentationQosPolicyAccessScopeKind <em>Presentation Qos Policy Access Scope Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Presentation Qos Policy Access Scope Kind</em>'.
	 * @see dds4ccm.PresentationQosPolicyAccessScopeKind
	 * @generated
	 */
	EEnum getPresentationQosPolicyAccessScopeKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.RealiabilityQosPolicyKind <em>Realiability Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Realiability Qos Policy Kind</em>'.
	 * @see dds4ccm.RealiabilityQosPolicyKind
	 * @generated
	 */
	EEnum getRealiabilityQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.LivelinessQosPolicyKind <em>Liveliness Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Liveliness Qos Policy Kind</em>'.
	 * @see dds4ccm.LivelinessQosPolicyKind
	 * @generated
	 */
	EEnum getLivelinessQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.DurabilityQosPolicyKind <em>Durability Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Durability Qos Policy Kind</em>'.
	 * @see dds4ccm.DurabilityQosPolicyKind
	 * @generated
	 */
	EEnum getDurabilityQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.DestinationOrderQosPolicyKind <em>Destination Order Qos Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Destination Order Qos Policy Kind</em>'.
	 * @see dds4ccm.DestinationOrderQosPolicyKind
	 * @generated
	 */
	EEnum getDestinationOrderQosPolicyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.SatisfierPropertyKind <em>Satisfier Property Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Satisfier Property Kind</em>'.
	 * @see dds4ccm.SatisfierPropertyKind
	 * @generated
	 */
	EEnum getSatisfierPropertyKind();

	/**
	 * Returns the meta object for enum '{@link dds4ccm.ConfigurationSlotKind <em>Configuration Slot Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Configuration Slot Kind</em>'.
	 * @see dds4ccm.ConfigurationSlotKind
	 * @generated
	 */
	EEnum getConfigurationSlotKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DDS4CCMFactory getDDS4CCMFactory();

} //DDS4CCMPackage
