package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAStruct;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAStructRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected CORBAStruct _importCorbaStruct(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBASTRUCT, CORBAStruct.class);
    final CORBAStruct element = ((CORBAStruct) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    DataType _asDataType = element.asDataType();
    this.typeCache.put(_fullPathName, _asDataType);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          CORBAStructRhapsodyExt.this._rhapsodyImportTraversal.map(e, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    return element;
  }
  
  protected CORBAStruct _importCorbaStruct(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAStruct importCorbaStruct(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaStruct((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaStruct(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
