package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

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
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAInterfaceRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected CORBAInterface _importCorbaInterface(final IRPClass source, final Object context) {
    final String name = source.getName();
    IRPCollection _nestedElements = source.getNestedElements();
    final List nestedElements = _nestedElements.toList();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAINTERFACE, CORBAInterface.class);
    final CORBAInterface interface_ = ((CORBAInterface) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Interface _asInterface = interface_.asInterface();
    this.typeCache.put(_fullPathName, _asInterface);
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          CORBAInterfaceRhapsodyExt.this._rhapsodyImportTraversal.map(e, interface_);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(nestedElements, _function);
    return interface_;
  }
  
  protected CORBAInterface _importCorbaInterface(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAInterface importCorbaInterface(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importCorbaInterface((IRPClass)source, context);
    } else if (source != null) {
      return _importCorbaInterface(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
