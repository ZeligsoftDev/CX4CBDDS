package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBASequence;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CORBASequenceRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBASequence _importCorbaSequence(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBASEQUENCE, CORBASequence.class);
    final CORBASequence element = ((CORBASequence) _createZDLElement);
    DataType _asDataType = element.asDataType();
    final Property memberAttr = _asDataType.createOwnedAttribute("members", null);
    memberAttr.setLower(0);
    int _minus = (-1);
    memberAttr.setUpper(_minus);
    String _fullPathName = source.getFullPathName();
    DataType _asDataType_1 = element.asDataType();
    this.typeCache.put(_fullPathName, _asDataType_1);
    IRPClassifier _typedefBaseType = source.getTypedefBaseType();
    boolean _notEquals = (!Objects.equal(_typedefBaseType, null));
    if (_notEquals) {
      IRPClassifier _typedefBaseType_1 = source.getTypedefBaseType();
      String _fullPathName_1 = _typedefBaseType_1.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(null, 
        null, memberAttr, _fullPathName_1);
      this.updateRequired.add(_referenceUpdateMetadata);
    } else {
      IRPCollection _attributes = source.getAttributes();
      List _list = _attributes.toList();
      final Function1<IRPAttribute,Boolean> _function = new Function1<IRPAttribute,Boolean>() {
          public Boolean apply(final IRPAttribute att) {
            String _name = att.getName();
            boolean _equals = "members".equals(_name);
            return Boolean.valueOf(_equals);
          }
        };
      final Iterable<IRPAttribute> attrs = IterableExtensions.<IRPAttribute>filter(_list, _function);
      boolean _and = false;
      int _size = IterableExtensions.size(attrs);
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        IRPAttribute _head = IterableExtensions.<IRPAttribute>head(attrs);
        IRPClassifier _type = _head.getType();
        boolean _notEquals_1 = (!Objects.equal(_type, null));
        _and = (_equals && _notEquals_1);
      }
      if (_and) {
        IRPAttribute _head_1 = IterableExtensions.<IRPAttribute>head(attrs);
        IRPClassifier _type_1 = _head_1.getType();
        String _fullPathName_2 = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata_1 = new ReferenceUpdateMetadata(null, 
          null, memberAttr, _fullPathName_2);
        this.updateRequired.add(_referenceUpdateMetadata_1);
      }
    }
    return element;
  }
  
  protected CORBASequence _importCorbaSequence(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBASequence importCorbaSequence(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaSequence((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaSequence(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
