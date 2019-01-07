package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Deployment.PerPortConnectorTypeDeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation;
import com.zeligsoft.domain.zml.api.ZML_Deployments.ComponentDeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DeploymentPartRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.DEPLOYMENT_UPDATE_LIST_BINDING)
  private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyZDLUtil _rhapsodyZDLUtil;
  
  protected DeploymentPart _importDeploymentPart(final IRPAttribute source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, ZMLMMNames.DEPLOYMENT_PART, DeploymentPart.class);
    final DeploymentPart element = ((DeploymentPart) _createZDLElement);
    boolean _notEquals = (!Objects.equal(element, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        String _fullPathName = source.getFullPathName();
        Property _asProperty = element.asProperty();
        this.typeCache.put(_fullPathName, _asProperty);
        Property _asProperty_1 = element.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName_1 = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(null, null, _asProperty_1, _fullPathName_1);
        this.updateRequired.add(_referenceUpdateMetadata);
        Property _asProperty_2 = element.asProperty();
        DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asProperty_2, source);
        this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
        IRPCollection _dependencies = source.getDependencies();
        List _list = _dependencies.toList();
        final Procedure1<IRPDependency> _function = new Procedure1<IRPDependency>() {
            public void apply(final IRPDependency d) {
              Property _asProperty = element.asProperty();
              DeploymentPartRhapsodyExt.this.importAllocation(d, _asProperty);
            }
          };
        IterableExtensions.<IRPDependency>forEach(_list, _function);
      }
    }
    return element;
  }
  
  public void importAllocation(final IRPDependency source, final Property part) {
    boolean _isZDLConcept = this._rhapsodyZDLUtil.isZDLConcept(source, ZMLMMNames.ALLOCATION);
    boolean _not = (!_isZDLConcept);
    if (_not) {
      return;
    }
    final EObject container = part.eContainer();
    final IRPModelElement dependsOn = source.getDependsOn();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(container, "", ZMLMMNames.ALLOCATION, Allocation.class);
    final Allocation element = ((Allocation) _createZDLElement);
    Dependency _asDependency = element.asDependency();
    EList<NamedElement> _clients = _asDependency.getClients();
    _clients.add(part);
    boolean _notEquals = (!Objects.equal(dependsOn, null));
    if (_notEquals) {
      Dependency _asDependency_1 = element.asDependency();
      String _fullPathName = dependsOn.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(ZMLMMNames.ALLOCATION, ZMLMMNames.ALLOCATION__DEPLOYED_ON, _asDependency_1, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
  }
  
  protected ComponentDeploymentPart _importDeploymentPart(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected ComponentDeploymentPart _importComponentDeploymentPart(final IRPAttribute source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, ZMLMMNames.COMPONENT_DEPLOYMENT_PART, ComponentDeploymentPart.class);
    final ComponentDeploymentPart element = ((ComponentDeploymentPart) _createZDLElement);
    boolean _notEquals = (!Objects.equal(element, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        String _fullPathName = source.getFullPathName();
        Property _asProperty = element.asProperty();
        this.typeCache.put(_fullPathName, _asProperty);
        Property _asProperty_1 = element.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName_1 = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(null, null, _asProperty_1, _fullPathName_1);
        this.updateRequired.add(_referenceUpdateMetadata);
        Property _asProperty_2 = element.asProperty();
        DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asProperty_2, source);
        this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
        IRPCollection _dependencies = source.getDependencies();
        List _list = _dependencies.toList();
        final Procedure1<IRPDependency> _function = new Procedure1<IRPDependency>() {
            public void apply(final IRPDependency d) {
              Property _asProperty = element.asProperty();
              DeploymentPartRhapsodyExt.this.importAllocation(d, _asProperty);
            }
          };
        IterableExtensions.<IRPDependency>forEach(_list, _function);
      }
    }
    return element;
  }
  
  protected ComponentDeploymentPart _importComponentDeploymentPart(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected PerPortConnectorTypeDeploymentPart _importPerPortDeploymentPart(final IRPAttribute source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART, 
      PerPortConnectorTypeDeploymentPart.class);
    final PerPortConnectorTypeDeploymentPart element = ((PerPortConnectorTypeDeploymentPart) _createZDLElement);
    boolean _notEquals = (!Objects.equal(element, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        String _fullPathName = source.getFullPathName();
        Property _asProperty = element.asProperty();
        this.typeCache.put(_fullPathName, _asProperty);
        Property _asProperty_1 = element.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName_1 = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(null, null, _asProperty_1, _fullPathName_1);
        this.updateRequired.add(_referenceUpdateMetadata);
        Property _asProperty_2 = element.asProperty();
        DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asProperty_2, source);
        this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
        IRPCollection _dependencies = source.getDependencies();
        List _list = _dependencies.toList();
        final Procedure1<IRPDependency> _function = new Procedure1<IRPDependency>() {
            public void apply(final IRPDependency d) {
              Property _asProperty = element.asProperty();
              DeploymentPartRhapsodyExt.this.importAllocation(d, _asProperty);
            }
          };
        IterableExtensions.<IRPDependency>forEach(_list, _function);
      }
    }
    return element;
  }
  
  protected PerPortConnectorTypeDeploymentPart _importPerPortDeploymentPart(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public DeploymentPart importDeploymentPart(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute) {
      return _importDeploymentPart((IRPAttribute)source, context);
    } else if (source != null) {
      return _importDeploymentPart(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public ComponentDeploymentPart importComponentDeploymentPart(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute) {
      return _importComponentDeploymentPart((IRPAttribute)source, context);
    } else if (source != null) {
      return _importComponentDeploymentPart(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public PerPortConnectorTypeDeploymentPart importPerPortDeploymentPart(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute) {
      return _importPerPortDeploymentPart((IRPAttribute)source, context);
    } else if (source != null) {
      return _importPerPortDeploymentPart(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
