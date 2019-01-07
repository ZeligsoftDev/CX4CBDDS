package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPArgument;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Parameter;

@SuppressWarnings("all")
public class CORBAParameterRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBAParameter _importCorbaParameter(final IRPArgument source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAPARAMETER, CORBAParameter.class);
    final CORBAParameter param = ((CORBAParameter) _createZDLElement);
    boolean _notEquals = (!Objects.equal(param, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        IRPClassifier _type_1 = source.getType();
        final String fullPath = _type_1.getFullPathName();
        Parameter _asParameter = param.asParameter();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBAPARAMETER, 
          CORBADomainNames.CORBATYPED__IDL_TYPE, _asParameter, fullPath);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
    }
    return param;
  }
  
  protected CORBAParameter _importCorbaParameter(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAParameter importCorbaParameter(final IRPModelElement source, final Object context) {
    if (source instanceof IRPArgument) {
      return _importCorbaParameter((IRPArgument)source, context);
    } else if (source != null) {
      return _importCorbaParameter(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
