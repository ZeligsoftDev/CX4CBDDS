package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import java.util.Arrays;

@SuppressWarnings("all")
public class IDLFileSpecificationRhapsodyExt {
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  protected IDLFileSpecification _importIDLFileSpecification(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, DDS4CCMNames.IDLFILE_SPECIFICATION, IDLFileSpecification.class);
    final IDLFileSpecification element = ((IDLFileSpecification) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Class _asClass = element.asClass();
    this.typeCache.put(_fullPathName, _asClass);
    return element;
  }
  
  protected IDLFileSpecification _importIDLFileSpecification(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public IDLFileSpecification importIDLFileSpecification(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importIDLFileSpecification((IRPClass)source, context);
    } else if (source != null) {
      return _importIDLFileSpecification(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
