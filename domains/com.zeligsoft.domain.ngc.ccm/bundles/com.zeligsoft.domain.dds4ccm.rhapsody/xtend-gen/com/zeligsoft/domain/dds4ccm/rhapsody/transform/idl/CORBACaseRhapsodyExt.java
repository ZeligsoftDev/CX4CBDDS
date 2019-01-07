package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBACase;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAUnion;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;

@SuppressWarnings("all")
public class CORBACaseRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBACase _importCorbaCase(final IRPAttribute source, final CORBAUnion context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBACASE, CORBACase.class);
    final CORBACase element = ((CORBACase) _createZDLElement);
    IRPClassifier _type = source.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      Property _asProperty = element.asProperty();
      String _fullPathName = source.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBACASE, 
        CORBADomainNames.CORBATYPED__IDL_TYPE, _asProperty, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    return element;
  }
  
  protected CORBACase _importCorbaCase(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBACase importCorbaCase(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute
         && context instanceof CORBAUnion) {
      return _importCorbaCase((IRPAttribute)source, (CORBAUnion)context);
    } else if (source != null
         && context != null) {
      return _importCorbaCase(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
