package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPTag;
import com.telelogic.rhapsody.core.RhapsodyAppServer;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.DataCollector;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.IRhapsodyProjectLocationStrategy;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ConnectorUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateRhapsodyExt;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RhapsodyImport {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.RELATION_UPDATE_LIST_BINDING)
  private List<RelationUpdateMetadata> relationUpdateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.CONNECTOR_UPDATE_LIST_BINDING)
  private List<ConnectorUpdateMetadata> connectorUpdateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.DEPLOYMENT_UPDATE_LIST_BINDING)
  private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  @Inject
  private DeploymentValueUpdateRhapsodyExt _deploymentValueUpdateRhapsodyExt;
  
  public void importRhasodyModel(final org.eclipse.uml2.uml.Package container) {
    final IRPApplication application = RhapsodyAppServer.getActiveRhapsodyApplication();
    try {
      boolean _notEquals = (!Objects.equal(application, null));
      if (_notEquals) {
        final IRPProject rhapsodyProject = application.activeProject();
        this.doImportRhapsodyModel(container, rhapsodyProject);
      }
    } finally {
      boolean _notEquals_1 = (!Objects.equal(application, null));
      if (_notEquals_1) {
      }
    }
  }
  
  public void importRhasodyModelWithRecordingProxies(final org.eclipse.uml2.uml.Package container) {
    final IRPApplication application = RhapsodyAppServer.getActiveRhapsodyApplication();
    try {
      boolean _notEquals = (!Objects.equal(application, null));
      if (_notEquals) {
        DataCollector _dataCollector = new DataCollector();
        final DataCollector collector = _dataCollector;
        IRPProject _activeProject = application.activeProject();
        Object _proxy = collector.proxy(_activeProject);
        final IRPProject rhapsodyProject = ((IRPProject) _proxy);
        this.doImportRhapsodyModel(container, rhapsodyProject);
        collector.dump("c:\\tmp\\RPData.xml");
      }
    } finally {
      boolean _notEquals_1 = (!Objects.equal(application, null));
      if (_notEquals_1) {
      }
    }
  }
  
  public void importRhapsodyModel(final org.eclipse.uml2.uml.Package container, final IRhapsodyProjectLocationStrategy projectLocator) {
    try {
      final IRPProject rhapsodyProject = projectLocator.getProject();
      this.doImportRhapsodyModel(container, rhapsodyProject);
    } finally {
    }
  }
  
  public void importRhasodyModel2(final org.eclipse.uml2.uml.Package container, final Object project) {
    try {
      if ((project instanceof IRPProject)) {
        final IRPProject rhapsodyProject = ((IRPProject) project);
        this.doImportRhapsodyModel(container, rhapsodyProject);
      }
    } finally {
    }
  }
  
  private void doImportRhapsodyModel(final org.eclipse.uml2.uml.Package container, final IRPProject rhapsodyProject) {
    IRPCollection _packages = rhapsodyProject.getPackages();
    final List packagesInProject = _packages.toList();
    ZDLUtil.getZDLConcepts(container);
    final Procedure1<IRPPackage> _function = new Procedure1<IRPPackage>() {
        public void apply(final IRPPackage pkg) {
          RhapsodyImport.this._rhapsodyImportTraversal.map(pkg, container);
        }
      };
    IterableExtensions.<IRPPackage>forEach(packagesInProject, _function);
    this.processRequiredUpdates();
    DDS4CCMMigrationUtil.repairAllWorkerfunctions(container);
  }
  
  private void processRequiredUpdates() {
    final Procedure1<ReferenceUpdateMetadata> _function = new Procedure1<ReferenceUpdateMetadata>() {
        public void apply(final ReferenceUpdateMetadata metadata) {
          RhapsodyImport.this.processRequiredUpdate(metadata);
        }
      };
    IterableExtensions.<ReferenceUpdateMetadata>forEach(this.updateRequired, _function);
    final Procedure1<RelationUpdateMetadata> _function_1 = new Procedure1<RelationUpdateMetadata>() {
        public void apply(final RelationUpdateMetadata metadata) {
          RhapsodyImport.this.processRelationRequiredUpdate(metadata);
        }
      };
    IterableExtensions.<RelationUpdateMetadata>forEach(this.relationUpdateRequired, _function_1);
    final Procedure1<ConnectorUpdateMetadata> _function_2 = new Procedure1<ConnectorUpdateMetadata>() {
        public void apply(final ConnectorUpdateMetadata metadata) {
          RhapsodyImport.this.processConnectorRequiredUpdate(metadata);
        }
      };
    IterableExtensions.<ConnectorUpdateMetadata>forEach(this.connectorUpdateRequired, _function_2);
    final Procedure1<DeploymentValueUpdateMetadata> _function_3 = new Procedure1<DeploymentValueUpdateMetadata>() {
        public void apply(final DeploymentValueUpdateMetadata metadata) {
          RhapsodyImport.this.processDeploymentRequiredUpdate(metadata);
        }
      };
    IterableExtensions.<DeploymentValueUpdateMetadata>forEach(this.deploymentUpdateRequired, _function_3);
  }
  
  private void processDeploymentRequiredUpdate(final DeploymentValueUpdateMetadata metadata) {
    final EObject element = metadata.getElement();
    final IRPModelElement rhapsodyPart = metadata.getRhapsodyDeploymentPart();
    final IRPTag value = rhapsodyPart.getTag(CXRhapsodyConstants.DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      this._deploymentValueUpdateRhapsodyExt.transformDeploymentValue(element, value, rhapsodyPart);
    }
  }
  
  private void processConnectorRequiredUpdate(final ConnectorUpdateMetadata metadata) {
    try {
      final ConnectorEnd sourceEnd = metadata.getSourceEnd();
      final ConnectorEnd targetEnd = metadata.getTargetEnd();
      String _sourceRole = metadata.getSourceRole();
      final EObject sourceRole = this.typeCache.get(_sourceRole);
      sourceEnd.setRole(((ConnectableElement) sourceRole));
      String _targetRole = metadata.getTargetRole();
      final EObject targetRole = this.typeCache.get(_targetRole);
      targetEnd.setRole(((ConnectableElement) targetRole));
      String _sourcePartWithPort = metadata.getSourcePartWithPort();
      boolean _notEquals = (!Objects.equal(_sourcePartWithPort, null));
      if (_notEquals) {
        String _sourcePartWithPort_1 = metadata.getSourcePartWithPort();
        final EObject sourcePart = this.typeCache.get(_sourcePartWithPort_1);
        sourceEnd.setPartWithPort(((Property) sourcePart));
      }
      String _targetPartWithPort = metadata.getTargetPartWithPort();
      boolean _notEquals_1 = (!Objects.equal(_targetPartWithPort, null));
      if (_notEquals_1) {
        String _targetPartWithPort_1 = metadata.getTargetPartWithPort();
        final EObject targetPart = this.typeCache.get(_targetPartWithPort_1);
        targetEnd.setPartWithPort(((Property) targetPart));
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private DirectedRelationship processRelationRequiredUpdate(final RelationUpdateMetadata metadata) {
    try {
      DirectedRelationship _xblockexpression = null;
      {
        String _target = metadata.getTarget();
        final EObject transformedType = this.typeCache.get(_target);
        final EObject source = metadata.getSource();
        EClass _type = metadata.getType();
        final String type = _type.getName();
        DirectedRelationship _xifexpression = null;
        boolean _notEquals = (!Objects.equal(transformedType, null));
        if (_notEquals) {
          DirectedRelationship _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(type,"Usage")) {
              _matched=true;
              Usage _createUsage = ((NamedElement) source).createUsage(((NamedElement) transformedType));
              _switchResult = _createUsage;
            }
          }
          if (!_matched) {
            if (Objects.equal(type,"Dependency")) {
              _matched=true;
              Dependency _createDependency = ((NamedElement) source).createDependency(((NamedElement) transformedType));
              _switchResult = _createDependency;
            }
          }
          if (!_matched) {
            if (Objects.equal(type,"Generalization")) {
              _matched=true;
              Generalization _createGeneralization = ((Classifier) source).createGeneralization(((Classifier) transformedType));
              _switchResult = _createGeneralization;
            }
          }
          if (!_matched) {
            if (Objects.equal(type,"InterfaceRealization")) {
              _matched=true;
              InterfaceRealization _createInterfaceRealization = ((BehavioredClassifier) source).createInterfaceRealization("", ((Interface) transformedType));
              _switchResult = _createInterfaceRealization;
            }
          }
          if (!_matched) {
            _switchResult = null;
          }
          _xifexpression = _switchResult;
        }
        _xblockexpression = (_xifexpression);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean processRequiredUpdate(final ReferenceUpdateMetadata metadata) {
    boolean _xblockexpression = false;
    {
      EObject transformedType = this.getTransformedType(metadata);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(transformedType, null));
      if (_notEquals) {
        boolean _xifexpression_1 = false;
        String _zdlConcept = metadata.zdlConcept();
        boolean _notEquals_1 = (!Objects.equal(_zdlConcept, null));
        if (_notEquals_1) {
          boolean _xblockexpression_1 = false;
          {
            EObject _rsaElement = metadata.rsaElement();
            String _zdlConcept_1 = metadata.zdlConcept();
            String _zdlFeature = metadata.zdlFeature();
            final Object value = ZDLUtil.getValue(_rsaElement, _zdlConcept_1, _zdlFeature);
            boolean _xifexpression_2 = false;
            if ((value instanceof List)) {
              boolean _add = ((List) value).add(transformedType);
              _xifexpression_2 = _add;
            } else {
              EObject _rsaElement_1 = metadata.rsaElement();
              String _zdlConcept_2 = metadata.zdlConcept();
              String _zdlFeature_1 = metadata.zdlFeature();
              ZDLUtil.setValue(_rsaElement_1, _zdlConcept_2, _zdlFeature_1, transformedType);
            }
            _xblockexpression_1 = (_xifexpression_2);
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          boolean _and = false;
          EObject _rsaElement = metadata.rsaElement();
          if (!(_rsaElement instanceof TypedElement)) {
            _and = false;
          } else {
            _and = ((_rsaElement instanceof TypedElement) && (transformedType instanceof Type));
          }
          if (_and) {
            EObject _rsaElement_1 = metadata.rsaElement();
            ((TypedElement) _rsaElement_1).setType(((Type) transformedType));
          }
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public EObject getTransformedType(final ReferenceUpdateMetadata metadata) {
    try {
      EObject result = null;
      final String rhapsodyElement = metadata.rhapsodyElement();
      String _zdlFeature = metadata.zdlFeature();
      boolean _equals = IDL3PlusNames.PARAMETER_BINDING__TYPE_PARAMETER.equals(_zdlFeature);
      if (_equals) {
        final String[] split = rhapsodyElement.split("\\.");
        int _size = ((List<String>)Conversions.doWrapArray(split)).size();
        boolean _notEquals = (_size != 2);
        if (_notEquals) {
          return null;
        }
        final String templateModule = ((List<String>)Conversions.doWrapArray(split)).get(0);
        final Element rsaTemplateModule = this.typeCache.get(templateModule);
        boolean _notEquals_1 = (!Objects.equal(rsaTemplateModule, null));
        if (_notEquals_1) {
          final EObject signature = ZDLUtil.getEValue(rsaTemplateModule, 
            IDL3PlusNames.TEMPLATE_MODULE, 
            IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);
          boolean _notEquals_2 = (!Objects.equal(signature, null));
          if (_notEquals_2) {
            final Object parameters = ZDLUtil.getValue(signature, 
              IDL3PlusNames.TEMPLATE_SIGNATURE, 
              IDL3PlusNames.TEMPLATE_SIGNATURE__TYPE_PARAMETER);
            for (final ClassifierTemplateParameter p : ((List<ClassifierTemplateParameter>) parameters)) {
              {
                final ParameterableElement paramElement = p.getOwnedParameteredElement();
                if ((paramElement instanceof NamedElement)) {
                  String _get = ((List<String>)Conversions.doWrapArray(split)).get(1);
                  String _name = ((NamedElement) paramElement).getName();
                  boolean _equals_1 = _get.equals(_name);
                  if (_equals_1) {
                    return p;
                  }
                }
              }
            }
          }
        }
      } else {
        String _zdlFeature_1 = metadata.zdlFeature();
        boolean _equals_1 = IDL3PlusNames.MODULE_BINDING__TEMPLATE.equals(_zdlFeature_1);
        if (_equals_1) {
          final Element rsaTemplateModule_1 = this.typeCache.get(rhapsodyElement);
          final EObject signature_1 = ZDLUtil.getEValue(rsaTemplateModule_1, 
            IDL3PlusNames.TEMPLATE_MODULE, 
            IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);
          return signature_1;
        }
      }
      String _rhapsodyElement = metadata.rhapsodyElement();
      Element _get = this.typeCache.get(_rhapsodyElement);
      result = _get;
      boolean _equals_2 = Objects.equal(result, null);
      if (_equals_2) {
        String corbaPrimitive = "";
        boolean _equals_3 = rhapsodyElement.equals("void");
        if (_equals_3) {
          corbaPrimitive = "CORBAVoid";
        }
        boolean _startsWith = rhapsodyElement.startsWith("IDLPrimitives::");
        if (_startsWith) {
          final String[] split_1 = rhapsodyElement.split("::");
          String _get_1 = ((List<String>)Conversions.doWrapArray(split_1)).get(1);
          corbaPrimitive = _get_1;
        }
        boolean _notEquals_3 = (!Objects.equal(corbaPrimitive, ""));
        if (_notEquals_3) {
          EObject _rsaElement = metadata.rsaElement();
          EObject _cORBAPrimitiveType = CORBAUtil.getCORBAPrimitiveType(_rsaElement, corbaPrimitive);
          result = _cORBAPrimitiveType;
        }
      }
      if ((result instanceof ClassifierTemplateParameter)) {
        final ClassifierTemplateParameter param = ((ClassifierTemplateParameter) result);
        ParameterableElement _ownedParameteredElement = param.getOwnedParameteredElement();
        result = _ownedParameteredElement;
      }
      return result;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
