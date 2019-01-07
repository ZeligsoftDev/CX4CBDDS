package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPLink;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPort;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ConnectorUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

@SuppressWarnings("all")
public class CCMConnectorRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.CONNECTOR_UPDATE_LIST_BINDING)
  private List<ConnectorUpdateMetadata> connectorUpdateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CCMConnector _importCCMConnector(final IRPLink source, final AssemblyImplementation context) {
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, "", CCMNames.CCMCONNECTOR, CCMConnector.class);
    final CCMConnector connector = ((CCMConnector) _createZDLElement);
    Connector _asConnector = connector.asConnector();
    String _name = source.getName();
    _asConnector.setName(_name);
    Connector _asConnector_1 = connector.asConnector();
    this.updateHelper(_asConnector_1, source, context);
    return connector;
  }
  
  protected CCMConnector _importCCMConnector(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected ConnectorStatusListenerConnection _importCSLConnection(final IRPLink source, final AssemblyImplementation context) {
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, "", DDS4CCMNames.CONNECTOR_STATUS_LISTENER_CONNECTION, ConnectorStatusListenerConnection.class);
    final ConnectorStatusListenerConnection connector = ((ConnectorStatusListenerConnection) _createZDLElement);
    Connector _asConnector = connector.asConnector();
    this.updateHelper(_asConnector, source, context);
    return connector;
  }
  
  protected ConnectorStatusListenerConnection _importCSLConnection(final IRPModelElement source, final Object context) {
    return null;
  }
  
  private Connector updateHelper(final Connector connector, final IRPLink source, final AssemblyImplementation context) {
    String sourceRole = null;
    String targetRole = null;
    String sourcePartWithPort = null;
    String targetPartWithPort = null;
    IRPPort _fromPort = source.getFromPort();
    boolean _notEquals = (!Objects.equal(_fromPort, null));
    if (_notEquals) {
      IRPPort _fromPort_1 = source.getFromPort();
      String _fullPathName = _fromPort_1.getFullPathName();
      sourceRole = _fullPathName;
      IRPInstance _from = source.getFrom();
      String _fullPathName_1 = _from.getFullPathName();
      sourcePartWithPort = _fullPathName_1;
    } else {
      IRPInstance _from_1 = source.getFrom();
      boolean _notEquals_1 = (!Objects.equal(_from_1, null));
      if (_notEquals_1) {
        IRPInstance _from_2 = source.getFrom();
        String _fullPathName_2 = _from_2.getFullPathName();
        sourceRole = _fullPathName_2;
      }
    }
    IRPPort _toPort = source.getToPort();
    boolean _notEquals_2 = (!Objects.equal(_toPort, null));
    if (_notEquals_2) {
      IRPPort _toPort_1 = source.getToPort();
      String _fullPathName_3 = _toPort_1.getFullPathName();
      targetRole = _fullPathName_3;
      IRPInstance _to = source.getTo();
      String _fullPathName_4 = _to.getFullPathName();
      targetPartWithPort = _fullPathName_4;
    } else {
      IRPInstance _to_1 = source.getTo();
      boolean _notEquals_3 = (!Objects.equal(_to_1, null));
      if (_notEquals_3) {
        IRPInstance _to_2 = source.getTo();
        String _fullPathName_5 = _to_2.getFullPathName();
        targetRole = _fullPathName_5;
      }
    }
    final ConnectorEnd sourceEnd = connector.createEnd();
    final ConnectorEnd targetEnd = connector.createEnd();
    ConnectorUpdateMetadata _connectorUpdateMetadata = new ConnectorUpdateMetadata(sourceEnd, sourceRole, sourcePartWithPort, targetEnd, targetRole, targetPartWithPort);
    this.connectorUpdateRequired.add(_connectorUpdateMetadata);
    return connector;
  }
  
  public CCMConnector importCCMConnector(final IRPModelElement source, final Object context) {
    if (source instanceof IRPLink
         && context instanceof AssemblyImplementation) {
      return _importCCMConnector((IRPLink)source, (AssemblyImplementation)context);
    } else if (source != null
         && context != null) {
      return _importCCMConnector(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public ConnectorStatusListenerConnection importCSLConnection(final IRPModelElement source, final Object context) {
    if (source instanceof IRPLink
         && context instanceof AssemblyImplementation) {
      return _importCSLConnection((IRPLink)source, (AssemblyImplementation)context);
    } else if (source != null
         && context != null) {
      return _importCSLConnection(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
