package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
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
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAExceptionRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected CORBAException _importCorbaException(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAEXCEPTION, CORBAException.class);
    final CORBAException exception = ((CORBAException) _createZDLElement);
    boolean _notEquals = (!Objects.equal(exception, null));
    if (_notEquals) {
      String _fullPathName = source.getFullPathName();
      DataType _asDataType = exception.asDataType();
      this.typeCache.put(_fullPathName, _asDataType);
      IRPCollection _attributes = source.getAttributes();
      List _list = _attributes.toList();
      final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
          public void apply(final IRPModelElement field) {
            CORBAExceptionRhapsodyExt.this._rhapsodyImportTraversal.map(field, exception);
          }
        };
      IterableExtensions.<IRPModelElement>forEach(_list, _function);
    }
    return exception;
  }
  
  protected CORBAException _importCorbaException(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAException importCorbaException(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaException((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaException(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
