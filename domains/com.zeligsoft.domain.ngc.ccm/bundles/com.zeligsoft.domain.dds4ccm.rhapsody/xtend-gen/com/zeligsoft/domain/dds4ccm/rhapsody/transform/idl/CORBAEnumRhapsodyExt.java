package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPEnumerationLiteral;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAEnum;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CORBAEnumRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CORBAEnum _importCorbaEnum(final IRPType source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CORBADomainNames.CORBAENUM, CORBAEnum.class);
    final CORBAEnum element = ((CORBAEnum) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Enumeration _asEnumeration = element.asEnumeration();
    this.typeCache.put(_fullPathName, _asEnumeration);
    IRPCollection _enumerationLiterals = source.getEnumerationLiterals();
    List _list = _enumerationLiterals.toList();
    final Procedure1<IRPEnumerationLiteral> _function = new Procedure1<IRPEnumerationLiteral>() {
        public void apply(final IRPEnumerationLiteral l) {
          CORBAEnumRhapsodyExt.this.mapLiteral(l, element);
        }
      };
    IterableExtensions.<IRPEnumerationLiteral>forEach(_list, _function);
    return element;
  }
  
  private void mapLiteral(final IRPEnumerationLiteral literal, final CORBAEnum enum_) {
    Enumeration _asEnumeration = enum_.asEnumeration();
    String _name = literal.getName();
    final EnumerationLiteral umlLiteral = _asEnumeration.createOwnedLiteral(_name);
    EList<Classifier> _classifiers = umlLiteral.getClassifiers();
    Enumeration _asEnumeration_1 = enum_.asEnumeration();
    _classifiers.add(_asEnumeration_1);
  }
  
  protected CORBAEnum _importCorbaEnum(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CORBAEnum importCorbaEnum(final IRPModelElement source, final Object context) {
    if (source instanceof IRPType) {
      return _importCorbaEnum((IRPType)source, context);
    } else if (source != null) {
      return _importCorbaEnum(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
