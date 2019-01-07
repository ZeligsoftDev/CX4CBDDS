package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPort;
import com.telelogic.rhapsody.core.IRPTag;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ConnectorDefRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.DEPLOYMENT_UPDATE_LIST_BINDING)
  private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected ConnectorDef _importConnectorDef(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.CONNECTOR_DEF, ConnectorDef.class);
    final ConnectorDef connectorDef = ((ConnectorDef) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Component _asComponent = connectorDef.asComponent();
    this.typeCache.put(_fullPathName, _asComponent);
    this.populate(connectorDef, source);
    return connectorDef;
  }
  
  protected ConnectorDef _importConnectorDef(final IRPModelElement source, final Object context) {
    return null;
  }
  
  private boolean populate(final ConnectorDef self, final IRPClass source) {
    boolean _xblockexpression = false;
    {
      IRPCollection _generalizations = source.getGeneralizations();
      List _list = _generalizations.toList();
      final Procedure1<IRPGeneralization> _function = new Procedure1<IRPGeneralization>() {
          public void apply(final IRPGeneralization g) {
            EObject _eObject = self.eObject();
            ConnectorDefRhapsodyExt.this._rhapsodyImportTraversal.mapGeneralization(g, _eObject);
          }
        };
      IterableExtensions.<IRPGeneralization>forEach(_list, _function);
      IRPCollection _attributes = source.getAttributes();
      final List ownedAttributes = _attributes.toList();
      final Procedure1<IRPAttribute> _function_1 = new Procedure1<IRPAttribute>() {
          public void apply(final IRPAttribute e) {
            ConnectorDefRhapsodyExt.this._rhapsodyImportTraversal.map(e, self);
          }
        };
      IterableExtensions.<IRPAttribute>forEach(ownedAttributes, _function_1);
      IRPCollection _ports = source.getPorts();
      final List sourcePorts = _ports.toList();
      final Procedure1<IRPPort> _function_2 = new Procedure1<IRPPort>() {
          public void apply(final IRPPort sp) {
            ConnectorDefRhapsodyExt.this._rhapsodyImportTraversal.map(sp, self);
          }
        };
      IterableExtensions.<IRPPort>forEach(sourcePorts, _function_2);
      final IRPTag tag = source.getTag(CXRhapsodyConstants.DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(tag, null));
      if (_notEquals) {
        Component _asComponent = self.asComponent();
        DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asComponent, source);
        boolean _add = this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
        _xifexpression = _add;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public ConnectorDef importConnectorDef(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importConnectorDef((IRPClass)source, context);
    } else if (source != null) {
      return _importConnectorDef(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
