package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class ConnectorDefaultValueBindingRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.DEPLOYMENT_UPDATE_LIST_BINDING)
  private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected ConnectorDefaultValueBinding _importConnectorDefaultValueBinding(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING, ConnectorDefaultValueBinding.class);
    final ConnectorDefaultValueBinding connectorDef = ((ConnectorDefaultValueBinding) _createZDLElement);
    org.eclipse.uml2.uml.Package _asPackage = connectorDef.asPackage();
    DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asPackage, source);
    this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
    return connectorDef;
  }
  
  protected ConnectorDefaultValueBinding _importConnectorDefaultValueBinding(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public ConnectorDefaultValueBinding importConnectorDefaultValueBinding(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importConnectorDefaultValueBinding((IRPClass)source, context);
    } else if (source != null) {
      return _importConnectorDefaultValueBinding(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
