package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ConnectorDefaultValueBindingRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected ConnectorDefaultValueBinding _importConnectorDefaultValueBinding(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING, ConnectorDefaultValueBinding.class);
    final ConnectorDefaultValueBinding element = ((ConnectorDefaultValueBinding) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Package _asPackage = element.asPackage();
    this.typeCache.put(_fullPathName, _asPackage);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          ConnectorDefaultValueBindingRhapsodyExt.this._rhapsodyImportTraversal.map(e, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    return element;
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
