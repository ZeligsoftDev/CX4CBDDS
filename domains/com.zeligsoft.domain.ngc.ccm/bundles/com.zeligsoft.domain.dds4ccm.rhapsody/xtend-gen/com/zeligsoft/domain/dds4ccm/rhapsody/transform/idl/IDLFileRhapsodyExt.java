package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile;
import java.util.Arrays;

@SuppressWarnings("all")
public class IDLFileRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected IDLFile _importIDLFile(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.IDLFILE, IDLFile.class);
    final IDLFile idlfile = ((IDLFile) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Package _asPackage = idlfile.asPackage();
    this.typeCache.put(_fullPathName, _asPackage);
    return idlfile;
  }
  
  protected IDLFile _importIDLFile(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public IDLFile importIDLFile(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importIDLFile((IRPClass)source, context);
    } else if (source != null) {
      return _importIDLFile(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
