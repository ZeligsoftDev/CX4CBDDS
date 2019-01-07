package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

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
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class PropertyRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected Property _importProperty(final IRPAttribute source, final Object context) {
    String name = source.getName();
    boolean _startsWith = name.startsWith("edu_vanderbilt_dre");
    if (_startsWith) {
      String _replaceAll = name.replaceAll("_", ".");
      name = _replaceAll;
    }
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.PROPERTY, Property.class);
    final Property attr = ((Property) _createZDLElement);
    boolean _notEquals = (!Objects.equal(attr, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        org.eclipse.uml2.uml.Property _asProperty = attr.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.PROPERTY, 
          CCMNames.PROPERTY__TYPE, _asProperty, _fullPathName);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
    }
    return attr;
  }
  
  protected Property _importProperty(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public Property importProperty(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute) {
      return _importProperty((IRPAttribute)source, context);
    } else if (source != null) {
      return _importProperty(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
