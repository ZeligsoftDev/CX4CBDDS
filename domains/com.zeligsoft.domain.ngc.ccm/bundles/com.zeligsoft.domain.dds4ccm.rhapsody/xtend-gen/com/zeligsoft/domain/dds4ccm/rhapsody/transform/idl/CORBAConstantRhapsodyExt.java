package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPLiteralSpecification;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstant;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAConstantRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected CORBAConstant _importCorbaConstant(final IRPAttribute source, final CORBAConstants context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBACONSTANT, CORBAConstant.class);
    final CORBAConstant element = ((CORBAConstant) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Property _asProperty = element.asProperty();
    this.typeCache.put(_fullPathName, _asProperty);
    IRPClassifier _type = source.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      Property _asProperty_1 = element.asProperty();
      IRPClassifier _type_1 = source.getType();
      String _fullPathName_1 = _type_1.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CORBADomainNames.CORBACONSTANT, 
        CORBADomainNames.CORBATYPED__IDL_TYPE, _asProperty_1, _fullPathName_1);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    IRPCollection _valueSpecifications = source.getValueSpecifications();
    final List values = _valueSpecifications.toList();
    boolean _isEmpty = values.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Object _get = values.get(0);
      this.mapDefault(_get, element);
    }
    return element;
  }
  
  private void _mapDefault(final IRPLiteralSpecification literal, final CORBAConstant container) {
    final String value = literal.getValue();
    Property _asProperty = container.asProperty();
    ZDLUtil.setValue(_asProperty, CORBADomainNames.CORBACONSTANT, CORBADomainNames.CORBACONSTANT__DEFAULT, value);
  }
  
  private void _mapDefault(final Object literal, final CORBAConstant container) {
  }
  
  protected CORBAConstant _importCorbaConstant(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected CORBAConstants _importCorbaConstants(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBACONSTANTS, CORBAConstants.class);
    final CORBAConstants element = ((CORBAConstants) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Class _asClass = element.asClass();
    this.typeCache.put(_fullPathName, _asClass);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          CORBAConstantRhapsodyExt.this._rhapsodyImportTraversal.map(e, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    return element;
  }
  
  protected CORBAConstants _importCorbaConstants(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAConstant importCorbaConstant(final IRPModelElement source, final Object context) {
    if (source instanceof IRPAttribute
         && context instanceof CORBAConstants) {
      return _importCorbaConstant((IRPAttribute)source, (CORBAConstants)context);
    } else if (source != null
         && context != null) {
      return _importCorbaConstant(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  private void mapDefault(final Object literal, final CORBAConstant container) {
    if (literal instanceof IRPLiteralSpecification) {
      _mapDefault((IRPLiteralSpecification)literal, container);
      return;
    } else if (literal != null) {
      _mapDefault(literal, container);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(literal, container).toString());
    }
  }
  
  public CORBAConstants importCorbaConstants(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importCorbaConstants((IRPClass)source, context);
    } else if (source != null) {
      return _importCorbaConstants(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
