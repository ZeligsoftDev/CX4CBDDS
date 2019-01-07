package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPInstanceValue;
import com.telelogic.rhapsody.core.IRPLiteralSpecification;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.IRPTag;
import com.telelogic.rhapsody.core.IRPUnit;
import com.telelogic.rhapsody.core.IRPValueSpecification;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.DDSMessage;
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.AssemblyImplementationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMComponentRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMConnectorRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.CCMPartRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ContainerProcessRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DDSMessageRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DeploymentPartRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DeploymentPlanRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.DomainRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeImplementationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeInstanceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeManagesDependencyRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.HomeRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.IDLFileDependencyRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.IDLFileSpecificationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterconnectInstanceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterconnectRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.InterfacePortRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.MonolithicImplementationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.NodeInstanceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.NodeRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.PropertyRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ResourcePropertyRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.ResourceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm.SatisfierPropertyRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAArrayRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAAttributeRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBACaseRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAConstantRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAEnumRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAExceptionRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAFieldRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAInterfaceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAModuleRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAOperationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAParameterRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBASequenceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAStringRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAStructRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBATypeDefRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAUnionRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl.CORBAWStringRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ConnectorDefRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ConnectorDefaultValueBindingRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.DataSpaceRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ExtendedPortTypeRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.ModuleInstantiationRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus.TemplateModuleRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding;
import com.zeligsoft.domain.idl3plus.api.Connectors.DataSpace;
import com.zeligsoft.domain.idl3plus.api.Deployment.PerPortConnectorTypeDeploymentPart;
import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.ExtendedPortType;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FactoryOperation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FinderOperation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.ContainerProcess;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeInstance;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Domain;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Interconnect;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.InterconnectInstance;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Node;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.NodeInstance;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.ResourceProperty;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAArray;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBACase;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstant;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAEnum;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAField;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAOperation;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBASequence;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAString;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAStruct;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBATypeDef;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAUnion;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAWString;
import com.zeligsoft.domain.zml.api.ZML_Deployments.ComponentDeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RhapsodyImportTraversal {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.RELATION_UPDATE_LIST_BINDING)
  private List<RelationUpdateMetadata> relationUpdateCache;
  
  @Inject
  private RhapsodyZDLUtil _rhapsodyZDLUtil;
  
  @Inject
  private CORBAModuleRhapsodyExt _cORBAModuleRhapsodyExt;
  
  @Inject
  private CCMComponentRhapsodyExt _cCMComponentRhapsodyExt;
  
  @Inject
  private CORBAInterfaceRhapsodyExt _cORBAInterfaceRhapsodyExt;
  
  @Inject
  private CORBAOperationRhapsodyExt _cORBAOperationRhapsodyExt;
  
  @Inject
  private CORBAStringRhapsodyExt _cORBAStringRhapsodyExt;
  
  @Inject
  private CORBAStructRhapsodyExt _cORBAStructRhapsodyExt;
  
  @Inject
  private CORBASequenceRhapsodyExt _cORBASequenceRhapsodyExt;
  
  @Inject
  private CORBACaseRhapsodyExt _cORBACaseRhapsodyExt;
  
  @Inject
  private CORBAEnumRhapsodyExt _cORBAEnumRhapsodyExt;
  
  @Inject
  private CORBAFieldRhapsodyExt _cORBAFieldRhapsodyExt;
  
  @Inject
  private CORBAParameterRhapsodyExt _cORBAParameterRhapsodyExt;
  
  @Inject
  private CORBATypeDefRhapsodyExt _cORBATypeDefRhapsodyExt;
  
  @Inject
  private CORBAUnionRhapsodyExt _cORBAUnionRhapsodyExt;
  
  @Inject
  private CORBAWStringRhapsodyExt _cORBAWStringRhapsodyExt;
  
  @Inject
  private CORBAArrayRhapsodyExt _cORBAArrayRhapsodyExt;
  
  @Inject
  private CORBAAttributeRhapsodyExt _cORBAAttributeRhapsodyExt;
  
  @Inject
  private CORBAConstantRhapsodyExt _cORBAConstantRhapsodyExt;
  
  @Inject
  private CORBAExceptionRhapsodyExt _cORBAExceptionRhapsodyExt;
  
  @Inject
  private AssemblyImplementationRhapsodyExt _assemblyImplementationRhapsodyExt;
  
  @Inject
  private InterfacePortRhapsodyExt _interfacePortRhapsodyExt;
  
  @Inject
  private HomeRhapsodyExt _homeRhapsodyExt;
  
  @Inject
  private DDSMessageRhapsodyExt _dDSMessageRhapsodyExt;
  
  @Inject
  private ConnectorDefRhapsodyExt _connectorDefRhapsodyExt;
  
  @Inject
  private ExtendedPortTypeRhapsodyExt _extendedPortTypeRhapsodyExt;
  
  @Inject
  private TemplateModuleRhapsodyExt _templateModuleRhapsodyExt;
  
  @Inject
  private ModuleInstantiationRhapsodyExt _moduleInstantiationRhapsodyExt;
  
  @Inject
  private CCMPartRhapsodyExt _cCMPartRhapsodyExt;
  
  @Inject
  private HomeImplementationRhapsodyExt _homeImplementationRhapsodyExt;
  
  @Inject
  private MonolithicImplementationRhapsodyExt _monolithicImplementationRhapsodyExt;
  
  @Inject
  private HomeInstanceRhapsodyExt _homeInstanceRhapsodyExt;
  
  @Inject
  private CCMConnectorRhapsodyExt _cCMConnectorRhapsodyExt;
  
  @Inject
  private DataSpaceRhapsodyExt _dataSpaceRhapsodyExt;
  
  @Inject
  private DomainRhapsodyExt _domainRhapsodyExt;
  
  @Inject
  private NodeRhapsodyExt _nodeRhapsodyExt;
  
  @Inject
  private ResourceRhapsodyExt _resourceRhapsodyExt;
  
  @Inject
  private NodeInstanceRhapsodyExt _nodeInstanceRhapsodyExt;
  
  @Inject
  private ResourcePropertyRhapsodyExt _resourcePropertyRhapsodyExt;
  
  @Inject
  private SatisfierPropertyRhapsodyExt _satisfierPropertyRhapsodyExt;
  
  @Inject
  private DeploymentPlanRhapsodyExt _deploymentPlanRhapsodyExt;
  
  @Inject
  private ContainerProcessRhapsodyExt _containerProcessRhapsodyExt;
  
  @Inject
  private DeploymentPartRhapsodyExt _deploymentPartRhapsodyExt;
  
  @Inject
  private PropertyRhapsodyExt _propertyRhapsodyExt;
  
  @Inject
  private ConnectorDefaultValueBindingRhapsodyExt _connectorDefaultValueBindingRhapsodyExt;
  
  @Inject
  private IDLFileSpecificationRhapsodyExt _iDLFileSpecificationRhapsodyExt;
  
  @Inject
  private IDLFileDependencyRhapsodyExt _iDLFileDependencyRhapsodyExt;
  
  @Inject
  private InterconnectRhapsodyExt _interconnectRhapsodyExt;
  
  @Inject
  private InterconnectInstanceRhapsodyExt _interconnectInstanceRhapsodyExt;
  
  @Inject
  private HomeManagesDependencyRhapsodyExt _homeManagesDependencyRhapsodyExt;
  
  public void map(final IRPModelElement self, final Object container) {
    ZObject result = null;
    String _zdlConcept = this._rhapsodyZDLUtil.zdlConcept(self);
    final String _switchValue = _zdlConcept;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.CONNECTOR_DEF)) {
        _matched=true;
        ConnectorDef _importConnectorDef = this._connectorDefRhapsodyExt.importConnectorDef(self, container);
        result = _importConnectorDef;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.EXTENDED_PORT_TYPE)) {
        _matched=true;
        ExtendedPortType _importExtendedPortType = this._extendedPortTypeRhapsodyExt.importExtendedPortType(self, container);
        result = _importExtendedPortType;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.TEMPLATE_MODULE)) {
        _matched=true;
        TemplateModule _importTemplateModule = this._templateModuleRhapsodyExt.importTemplateModule(self, container);
        result = _importTemplateModule;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.MODULE_INSTANTIATION)) {
        _matched=true;
        ModuleInstantiation _importModuleInstantiation = this._moduleInstantiationRhapsodyExt.importModuleInstantiation(self, container);
        result = _importModuleInstantiation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.TEMPLATE_MODULE)) {
        _matched=true;
        TemplateModule _importTemplateModule_1 = this._templateModuleRhapsodyExt.importTemplateModule(self, container);
        result = _importTemplateModule_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.DATA_SPACE)) {
        _matched=true;
        DataSpace _importDataSpace = this._dataSpaceRhapsodyExt.importDataSpace(self, container);
        result = _importDataSpace;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
        _matched=true;
        ConnectorDefaultValueBinding _importConnectorDefaultValueBinding = this._connectorDefaultValueBindingRhapsodyExt.importConnectorDefaultValueBinding(self, container);
        result = _importConnectorDefaultValueBinding;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
        _matched=true;
        PerPortConnectorTypeDeploymentPart _importPerPortDeploymentPart = this._deploymentPartRhapsodyExt.importPerPortDeploymentPart(self, container);
        result = _importPerPortDeploymentPart;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.CCMCOMPONENT)) {
        _matched=true;
        CCMComponent _importCCMComponent = this._cCMComponentRhapsodyExt.importCCMComponent(self, container);
        result = _importCCMComponent;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.INTERFACE_PORT)) {
        _matched=true;
        InterfacePort _importInterfacePort = this._interfacePortRhapsodyExt.importInterfacePort(self, container);
        result = _importInterfacePort;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.ASSEMBLY_IMPLEMENTATION)) {
        _matched=true;
        AssemblyImplementation _importAssemblyImplementation = this._assemblyImplementationRhapsodyExt.importAssemblyImplementation(self, container);
        result = _importAssemblyImplementation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.HOME)) {
        _matched=true;
        Home _importHome = this._homeRhapsodyExt.importHome(self, container);
        result = _importHome;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.FACTORY_OPERATION)) {
        _matched=true;
        FactoryOperation _importFactoryOperation = this._homeRhapsodyExt.importFactoryOperation(self, container);
        result = _importFactoryOperation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.FINDER_OPERATION)) {
        _matched=true;
        FinderOperation _importFinderOperation = this._homeRhapsodyExt.importFinderOperation(self, container);
        result = _importFinderOperation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.CCMPART)) {
        _matched=true;
        CCMPart _importCCMPart = this._cCMPartRhapsodyExt.importCCMPart(self, container);
        result = _importCCMPart;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.MONOLITHIC_IMPLEMENTATION)) {
        _matched=true;
        MonolithicImplementation _importMonolithicImplementation = this._monolithicImplementationRhapsodyExt.importMonolithicImplementation(self, container);
        result = _importMonolithicImplementation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.HOME_INSTANCE)) {
        _matched=true;
        HomeInstance _importHomeInstance = this._homeInstanceRhapsodyExt.importHomeInstance(self, container);
        result = _importHomeInstance;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.MANAGES)) {
        _matched=true;
        Manages _importManagesDependency = this._homeManagesDependencyRhapsodyExt.importManagesDependency(self, container);
        result = _importManagesDependency;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.HOME_IMPLEMENTATION)) {
        _matched=true;
        HomeImplementation _importHomeImplementation = this._homeImplementationRhapsodyExt.importHomeImplementation(self, container);
        result = _importHomeImplementation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.CCMCONNECTOR)) {
        _matched=true;
        CCMConnector _importCCMConnector = this._cCMConnectorRhapsodyExt.importCCMConnector(self, container);
        result = _importCCMConnector;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.DOMAIN)) {
        _matched=true;
        Domain _importDomain = this._domainRhapsodyExt.importDomain(self, container);
        result = _importDomain;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.NODE)) {
        _matched=true;
        Node _importNode = this._nodeRhapsodyExt.importNode(self, container);
        result = _importNode;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.RESOURCE)) {
        _matched=true;
        Resource _importResource = this._resourceRhapsodyExt.importResource(self, container);
        result = _importResource;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.NODE_INSTANCE)) {
        _matched=true;
        NodeInstance _importNodeInstance = this._nodeInstanceRhapsodyExt.importNodeInstance(self, container);
        result = _importNodeInstance;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.RESOURCE_PROPERTY)) {
        _matched=true;
        ResourceProperty _importResourceProperty = this._resourcePropertyRhapsodyExt.importResourceProperty(self, container);
        result = _importResourceProperty;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.SATISFIER_PROPERTY)) {
        _matched=true;
        SatisfierProperty _importSatisfierProperty = this._satisfierPropertyRhapsodyExt.importSatisfierProperty(self, container);
        result = _importSatisfierProperty;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.DEPLOYMENT_PLAN)) {
        _matched=true;
        DeploymentPlan _importDeploymentPlan = this._deploymentPlanRhapsodyExt.importDeploymentPlan(self, container);
        result = _importDeploymentPlan;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.CONTAINER_PROCESS)) {
        _matched=true;
        ContainerProcess _importContainerProcess = this._containerProcessRhapsodyExt.importContainerProcess(self, container);
        result = _importContainerProcess;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
        _matched=true;
        ComponentDeploymentPart _importComponentDeploymentPart = this._deploymentPartRhapsodyExt.importComponentDeploymentPart(self, container);
        result = _importComponentDeploymentPart;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ZMLMMNames.DEPLOYMENT_PART)) {
        _matched=true;
        DeploymentPart _importDeploymentPart = this._deploymentPartRhapsodyExt.importDeploymentPart(self, container);
        result = _importDeploymentPart;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.PROPERTY)) {
        _matched=true;
        Property _importProperty = this._propertyRhapsodyExt.importProperty(self, container);
        result = _importProperty;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.INTERCONNECT)) {
        _matched=true;
        Interconnect _importInterconnect = this._interconnectRhapsodyExt.importInterconnect(self, container);
        result = _importInterconnect;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CCMNames.INTERCONNECT_INSTANCE)) {
        _matched=true;
        InterconnectInstance _importInterconnectInstance = this._interconnectInstanceRhapsodyExt.importInterconnectInstance(self, container);
        result = _importInterconnectInstance;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,DDS4CCMNames.DDSMESSAGE)) {
        _matched=true;
        DDSMessage _importDDSMessage = this._dDSMessageRhapsodyExt.importDDSMessage(self, container);
        result = _importDDSMessage;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,DDS4CCMNames.MESSAGE_FIELD)) {
        _matched=true;
        MessageField _importMessageField = this._dDSMessageRhapsodyExt.importMessageField(self, container);
        result = _importMessageField;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,DDS4CCMNames.CONNECTOR_STATUS_LISTENER_CONNECTION)) {
        _matched=true;
        ConnectorStatusListenerConnection _importCSLConnection = this._cCMConnectorRhapsodyExt.importCSLConnection(self, container);
        result = _importCSLConnection;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,DDS4CCMNames.IDLFILE_SPECIFICATION)) {
        _matched=true;
        IDLFileSpecification _importIDLFileSpecification = this._iDLFileSpecificationRhapsodyExt.importIDLFileSpecification(self, container);
        result = _importIDLFileSpecification;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,DDS4CCMNames.IDLFILE_DEPENDENCY)) {
        _matched=true;
        IDLFileDependency _importIDLFileDependency = this._iDLFileDependencyRhapsodyExt.importIDLFileDependency(self, container);
        result = _importIDLFileDependency;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAMODULE)) {
        _matched=true;
        this._cORBAModuleRhapsodyExt.importPackageOrModule(self, container);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAINTERFACE)) {
        _matched=true;
        CORBAInterface _importCorbaInterface = this._cORBAInterfaceRhapsodyExt.importCorbaInterface(self, container);
        result = _importCorbaInterface;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAOPERATION)) {
        _matched=true;
        CORBAOperation _importCorbaOperation = this._cORBAOperationRhapsodyExt.importCorbaOperation(self, container);
        result = _importCorbaOperation;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAARRAY)) {
        _matched=true;
        CORBAArray _importCorbaArray = this._cORBAArrayRhapsodyExt.importCorbaArray(self, container);
        result = _importCorbaArray;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBASEQUENCE)) {
        _matched=true;
        CORBASequence _importCorbaSequence = this._cORBASequenceRhapsodyExt.importCorbaSequence(self, container);
        result = _importCorbaSequence;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBASTRUCT)) {
        _matched=true;
        CORBAStruct _importCorbaStruct = this._cORBAStructRhapsodyExt.importCorbaStruct(self, container);
        result = _importCorbaStruct;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAEXCEPTION)) {
        _matched=true;
        CORBAException _importCorbaException = this._cORBAExceptionRhapsodyExt.importCorbaException(self, container);
        result = _importCorbaException;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAATTRIBUTE)) {
        _matched=true;
        CORBAAttribute _importCorbaAttribute = this._cORBAAttributeRhapsodyExt.importCorbaAttribute(self, container);
        result = _importCorbaAttribute;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAENUM)) {
        _matched=true;
        CORBAEnum _importCorbaEnum = this._cORBAEnumRhapsodyExt.importCorbaEnum(self, container);
        result = _importCorbaEnum;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAFIELD)) {
        _matched=true;
        CORBAField _importCorbaField = this._cORBAFieldRhapsodyExt.importCorbaField(self, container);
        result = _importCorbaField;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAWSTRING)) {
        _matched=true;
        CORBAWString _importCorbaWString = this._cORBAWStringRhapsodyExt.importCorbaWString(self, container);
        result = _importCorbaWString;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBACASE)) {
        _matched=true;
        CORBACase _importCorbaCase = this._cORBACaseRhapsodyExt.importCorbaCase(self, container);
        result = _importCorbaCase;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBACONSTANT)) {
        _matched=true;
        CORBAConstant _importCorbaConstant = this._cORBAConstantRhapsodyExt.importCorbaConstant(self, container);
        result = _importCorbaConstant;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBACONSTANTS)) {
        _matched=true;
        CORBAConstants _importCorbaConstants = this._cORBAConstantRhapsodyExt.importCorbaConstants(self, container);
        result = _importCorbaConstants;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAPARAMETER)) {
        _matched=true;
        CORBAParameter _importCorbaParameter = this._cORBAParameterRhapsodyExt.importCorbaParameter(self, container);
        result = _importCorbaParameter;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBATYPE_DEF)) {
        _matched=true;
        CORBATypeDef _importCorbaTypeDef = this._cORBATypeDefRhapsodyExt.importCorbaTypeDef(self, container);
        result = _importCorbaTypeDef;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBAUNION)) {
        _matched=true;
        CORBAUnion _importCorbaUnion = this._cORBAUnionRhapsodyExt.importCorbaUnion(self, container);
        result = _importCorbaUnion;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,CORBADomainNames.CORBASTRING)) {
        _matched=true;
        CORBAString _importCorbaString = this._cORBAStringRhapsodyExt.importCorbaString(self, container);
        result = _importCorbaString;
      }
    }
    if (!_matched) {
      if ((self instanceof IRPPackage)) {
        final int isRef = ((IRPPackage) self).isReferenceUnit();
        boolean _or = false;
        boolean _notEquals = (isRef != 1);
        if (_notEquals) {
          _or = true;
        } else {
          boolean _and = false;
          boolean _equals = (isRef == 1);
          if (!_equals) {
            _and = false;
          } else {
            boolean _or_1 = false;
            String _name = self.getName();
            boolean _equals_1 = _name.equals("DDS_DCPS");
            if (_equals_1) {
              _or_1 = true;
            } else {
              String _name_1 = self.getName();
              boolean _equals_2 = _name_1.equals("CCM_PSAT");
              _or_1 = (_equals_1 || _equals_2);
            }
            _and = (_equals && _or_1);
          }
          _or = (_notEquals || _and);
        }
        if (_or) {
          this._cORBAModuleRhapsodyExt.importPackageOrModule(((IRPPackage) self), container);
        }
      }
    }
    boolean _notEquals_1 = (!Objects.equal(result, null));
    if (_notEquals_1) {
      final EObject eObj = result.eObject();
      IRPCollection _allTags = self.getAllTags();
      List _list = _allTags.toList();
      final Procedure1<IRPTag> _function = new Procedure1<IRPTag>() {
          public void apply(final IRPTag t) {
            RhapsodyImportTraversal.this.mapTag(t, eObj);
          }
        };
      IterableExtensions.<IRPTag>forEach(_list, _function);
    }
  }
  
  public void mapGeneralization(final IRPGeneralization gen, final EObject container) {
    IRPClassifier _baseClass = gen.getBaseClass();
    final String other = _baseClass.getFullPathName();
    EClass _generalization = UMLPackage.eINSTANCE.getGeneralization();
    RelationUpdateMetadata _relationUpdateMetadata = new RelationUpdateMetadata(container, other, _generalization);
    this.relationUpdateCache.add(_relationUpdateMetadata);
  }
  
  private void mapTag(final IRPTag tag, final EObject element) {
    final Set<org.eclipse.uml2.uml.Class> concepts = ZDLUtil.getAllZDLConcepts(element);
    String name = tag.getName();
    String _name = tag.getName();
    final int index = _name.indexOf("_");
    boolean _greaterThan = (index > 0);
    if (_greaterThan) {
      String _name_1 = tag.getName();
      String _substring = _name_1.substring(0, index);
      name = _substring;
    }
    final String tagName = name;
    final Procedure1<org.eclipse.uml2.uml.Class> _function = new Procedure1<org.eclipse.uml2.uml.Class>() {
        public void apply(final org.eclipse.uml2.uml.Class c) {
          EList<org.eclipse.uml2.uml.Property> _attributes = c.getAttributes();
          final Function1<org.eclipse.uml2.uml.Property,Boolean> _function = new Function1<org.eclipse.uml2.uml.Property,Boolean>() {
              public Boolean apply(final org.eclipse.uml2.uml.Property a) {
                String _name = a.getName();
                boolean _equals = Objects.equal(_name, tagName);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<org.eclipse.uml2.uml.Property> _filter = IterableExtensions.<org.eclipse.uml2.uml.Property>filter(_attributes, _function);
          final Procedure1<org.eclipse.uml2.uml.Property> _function_1 = new Procedure1<org.eclipse.uml2.uml.Property>() {
              public void apply(final org.eclipse.uml2.uml.Property p) {
                String _qualifiedName = c.getQualifiedName();
                RhapsodyImportTraversal.this.mapTag(p, tag, element, _qualifiedName);
              }
            };
          IterableExtensions.<org.eclipse.uml2.uml.Property>forEach(_filter, _function_1);
        }
      };
    IterableExtensions.<org.eclipse.uml2.uml.Class>forEach(concepts, _function);
  }
  
  private void mapTag(final org.eclipse.uml2.uml.Property property, final IRPTag tag, final EObject element, final String zdlConcept) {
    IRPCollection _valueSpecifications = tag.getValueSpecifications();
    final List valueList = _valueSpecifications.toList();
    final Procedure1<IRPValueSpecification> _function = new Procedure1<IRPValueSpecification>() {
        public void apply(final IRPValueSpecification spec) {
          RhapsodyImportTraversal.this.mapTagHelper(spec, tag, element, zdlConcept, property);
        }
      };
    IterableExtensions.<IRPValueSpecification>forEach(valueList, _function);
  }
  
  private void _mapTagHelper(final IRPInstanceValue spec, final IRPTag tag, final EObject element, final String zdlConcept, final org.eclipse.uml2.uml.Property property) {
    boolean _isComposite = property.isComposite();
    if (_isComposite) {
      final Type type = property.getType();
      String _name = property.getName();
      final Object value = ZDLUtil.getValue(element, zdlConcept, _name);
      String _name_1 = property.getName();
      String _qualifiedName = type.getQualifiedName();
      final EObject compositeValue = ZDLUtil.createZDLConcept(element, zdlConcept, _name_1, _qualifiedName);
      boolean _isMultivalued = property.isMultivalued();
      if (_isMultivalued) {
        ((List) value).add(compositeValue);
      } else {
        String _name_2 = property.getName();
        ZDLUtil.setValue(element, zdlConcept, _name_2, compositeValue);
      }
      String _name_3 = tag.getName();
      String[] _split = _name_3.split("_");
      final String attribute = ((List<String>)Conversions.doWrapArray(_split)).get(1);
      String _qualifiedName_1 = type.getQualifiedName();
      IRPModelElement _value = spec.getValue();
      String _fullPathName = _value.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(_qualifiedName_1, attribute, compositeValue, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    } else {
      String _name_4 = property.getName();
      IRPModelElement _value_1 = spec.getValue();
      String _fullPathName_1 = _value_1.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata_1 = new ReferenceUpdateMetadata(zdlConcept, _name_4, element, _fullPathName_1);
      this.updateRequired.add(_referenceUpdateMetadata_1);
    }
  }
  
  private void _mapTagHelper(final IRPLiteralSpecification spec, final IRPTag tag, final EObject element, final String zdlConcept, final org.eclipse.uml2.uml.Property property) {
    Type _type = property.getType();
    if ((_type instanceof Enumeration)) {
      final String literalValue = spec.getValue();
      Type _type_1 = property.getType();
      final String enumName = _type_1.getQualifiedName();
      final EnumerationLiteral literal = ZDLUtil.getZDLEnumLiteral(element, enumName, literalValue);
      boolean _notEquals = (!Objects.equal(literal, null));
      if (_notEquals) {
        String _name = property.getName();
        ZDLUtil.setValue(element, zdlConcept, _name, literal);
      }
      return;
    }
    Type _type_2 = property.getType();
    boolean _not = (!(_type_2 instanceof PrimitiveType));
    if (_not) {
      return;
    }
    String _name_1 = property.getName();
    Object value = ZDLUtil.getValue(element, zdlConcept, _name_1);
    Object specValue = spec.getValue();
    final IRPClassifier tagType = tag.getType();
    final String type = tagType.getName();
    boolean _equals = type.equals("RhpBoolean");
    if (_equals) {
      String _string = specValue.toString();
      boolean _parseBoolean = Boolean.parseBoolean(_string);
      specValue = Boolean.valueOf(_parseBoolean);
    }
    boolean _isComposite = property.isComposite();
    boolean _not_1 = (!_isComposite);
    if (_not_1) {
      boolean _isMultivalued = property.isMultivalued();
      if (_isMultivalued) {
        ((List) value).add(specValue);
      } else {
        String _name_2 = property.getName();
        ZDLUtil.setValue(element, zdlConcept, _name_2, specValue);
      }
    } else {
    }
  }
  
  private void _mapTagHelper(final IRPValueSpecification spec, final IRPClassifier tagType, final EObject element, final String zdlConcept, final org.eclipse.uml2.uml.Property property) {
  }
  
  private void mapTagHelper(final IRPValueSpecification spec, final IRPUnit tag, final EObject element, final String zdlConcept, final org.eclipse.uml2.uml.Property property) {
    if (spec instanceof IRPInstanceValue
         && tag instanceof IRPTag) {
      _mapTagHelper((IRPInstanceValue)spec, (IRPTag)tag, element, zdlConcept, property);
      return;
    } else if (spec instanceof IRPLiteralSpecification
         && tag instanceof IRPTag) {
      _mapTagHelper((IRPLiteralSpecification)spec, (IRPTag)tag, element, zdlConcept, property);
      return;
    } else if (spec != null
         && tag instanceof IRPClassifier) {
      _mapTagHelper(spec, (IRPClassifier)tag, element, zdlConcept, property);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(spec, tag, element, zdlConcept, property).toString());
    }
  }
}
