package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBATypeDef;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.DataType;

@SuppressWarnings("all")
public class CORBATypeDefRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBATypeDef _importCorbaTypeDef(final IRPType source, final Object context) {
    CORBATypeDef _xblockexpression = null;
    {
      final String name = source.getName();
      ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBATYPE_DEF, CORBATypeDef.class);
      final CORBATypeDef element = ((CORBATypeDef) _createZDLElement);
      String _fullPathName = source.getFullPathName();
      DataType _asDataType = element.asDataType();
      this.typeCache.put(_fullPathName, _asDataType);
      IRPClassifier _typedefBaseType = source.getTypedefBaseType();
      boolean _notEquals = (!Objects.equal(_typedefBaseType, null));
      if (_notEquals) {
        DataType _asDataType_1 = element.asDataType();
        IRPClassifier _typedefBaseType_1 = source.getTypedefBaseType();
        String _fullPathName_1 = _typedefBaseType_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBATYPE_DEF, 
          CORBADomainNames.CORBATYPE_DEF__TYPE, _asDataType_1, _fullPathName_1);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
      _xblockexpression = (element);
    }
    return _xblockexpression;
  }
  
  protected CORBATypeDef _importCorbaTypeDef(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBATypeDef importCorbaTypeDef(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaTypeDef((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaTypeDef(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
