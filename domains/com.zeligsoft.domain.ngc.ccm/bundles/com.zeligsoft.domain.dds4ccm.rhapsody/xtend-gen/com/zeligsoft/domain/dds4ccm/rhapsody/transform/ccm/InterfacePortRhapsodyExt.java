package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPort;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;

@SuppressWarnings("all")
public class InterfacePortRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  private InterfacePort importInterfacePortHelper(final IRPPort source, final Component context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.INTERFACE_PORT, InterfacePort.class);
    final InterfacePort element = ((InterfacePort) _createZDLElement);
    final String sourceFullName = source.getFullPathName();
    final IRPClass contract = source.getContract();
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(contract, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _fullPathName = contract.getFullPathName();
      boolean _equals = _fullPathName.equals(sourceFullName);
      boolean _not = (!_equals);
      _and = (_notEquals && _not);
    }
    if (_and) {
      Port _asPort = element.asPort();
      IRPClass _contract = source.getContract();
      String _fullPathName_1 = _contract.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.INTERFACE_PORT, 
        ZMLMMNames.PORT__PORTTYPE, _asPort, _fullPathName_1);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    final int conjugated = source.getIsReversed();
    boolean _equals_1 = (conjugated == 1);
    if (_equals_1) {
      Port _asPort_1 = element.asPort();
      Boolean _valueOf = Boolean.valueOf(true);
      ZDLUtil.setValue(_asPort_1, CCMNames.INTERFACE_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED, _valueOf);
    }
    String _fullPathName_2 = source.getFullPathName();
    Port _asPort_2 = element.asPort();
    this.typeCache.put(_fullPathName_2, _asPort_2);
    return element;
  }
  
  protected InterfacePort _importInterfacePort(final IRPPort source, final StructuralRealization context) {
    Component _asComponent = context.asComponent();
    InterfacePort _importInterfacePortHelper = this.importInterfacePortHelper(source, _asComponent);
    return _importInterfacePortHelper;
  }
  
  protected InterfacePort _importInterfacePort(final IRPPort source, final ComponentInterface context) {
    Component _asComponent = context.asComponent();
    InterfacePort _importInterfacePortHelper = this.importInterfacePortHelper(source, _asComponent);
    return _importInterfacePortHelper;
  }
  
  protected InterfacePort _importInterfacePort(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public InterfacePort importInterfacePort(final IRPModelElement source, final Object context) {
    if (source instanceof IRPPort
         && context instanceof ComponentInterface) {
      return _importInterfacePort((IRPPort)source, (ComponentInterface)context);
    } else if (source instanceof IRPPort
         && context instanceof StructuralRealization) {
      return _importInterfacePort((IRPPort)source, (StructuralRealization)context);
    } else if (source != null
         && context != null) {
      return _importInterfacePort(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
