package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.DDSMessage;
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DDSMessageRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected DDSMessage _importDDSMessage(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, DDS4CCMNames.DDSMESSAGE, DDSMessage.class);
    final DDSMessage element = ((DDSMessage) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    DataType _asDataType = element.asDataType();
    this.typeCache.put(_fullPathName, _asDataType);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          DDSMessageRhapsodyExt.this._rhapsodyImportTraversal.map(e, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    return element;
  }
  
  protected DDSMessage _importDDSMessage(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected MessageField _importMessageField(final IRPAttribute source, final DDSMessage context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, DDS4CCMNames.MESSAGE_FIELD, MessageField.class);
    final MessageField field = ((MessageField) _createZDLElement);
    boolean _notEquals = (!Objects.equal(field, null));
    if (_notEquals) {
      IRPClassifier _type = source.getType();
      boolean _notEquals_1 = (!Objects.equal(_type, null));
      if (_notEquals_1) {
        Property _asProperty = field.asProperty();
        IRPClassifier _type_1 = source.getType();
        String _fullPathName = _type_1.getFullPathName();
        ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(DDS4CCMNames.MESSAGE_FIELD, 
          CORBADomainNames.CORBATYPED__IDL_TYPE, _asProperty, _fullPathName);
        this.updateRequired.add(_referenceUpdateMetadata);
      }
    }
    return field;
  }
  
  protected MessageField _importMessageField(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public DDSMessage importDDSMessage(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importDDSMessage((IRPType)source, context);
    } else if (source != null) {
      return _importDDSMessage(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public MessageField importMessageField(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute
         && context instanceof DDSMessage) {
      return _importMessageField((IRPAttribute)source, (DDSMessage)context);
    } else if (source != null
         && context != null) {
      return _importMessageField(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
