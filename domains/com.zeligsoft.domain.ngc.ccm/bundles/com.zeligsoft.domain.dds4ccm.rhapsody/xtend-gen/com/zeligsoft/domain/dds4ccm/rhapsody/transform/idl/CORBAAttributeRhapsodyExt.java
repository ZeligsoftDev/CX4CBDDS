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
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;

@SuppressWarnings("all")
public class CORBAAttributeRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBAAttribute _importCorbaAttribute(final IRPAttribute source, final Object context) {
    String name = source.getName();
    boolean _startsWith = name.startsWith("edu_vanderbilt_dre");
    if (_startsWith) {
      String _replaceAll = name.replaceAll("_", ".");
      name = _replaceAll;
    }
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAATTRIBUTE, CORBAAttribute.class);
    final CORBAAttribute attr = ((CORBAAttribute) _createZDLElement);
    boolean _notEquals = (!Objects.equal(attr, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        Property _asProperty = attr.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBAATTRIBUTE, 
          CORBADomainNames.CORBATYPED__IDL_TYPE, _asProperty, _fullPathName);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
    }
    return attr;
  }
  
  protected CORBAAttribute _importCorbaAttribute(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAAttribute importCorbaAttribute(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute) {
      return _importCorbaAttribute((IRPAttribute)source, context);
    } else if (source != null) {
      return _importCorbaAttribute(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
