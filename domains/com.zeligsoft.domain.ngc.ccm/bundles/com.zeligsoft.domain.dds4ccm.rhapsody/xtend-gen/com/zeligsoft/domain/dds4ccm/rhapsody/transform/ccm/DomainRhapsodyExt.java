package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Domain;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Component;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DomainRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected Domain _importDomain(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.DOMAIN, Domain.class);
    final Domain domain = ((Domain) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Component _asComponent = domain.asComponent();
    this.typeCache.put(_fullPathName, _asComponent);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          DomainRhapsodyExt.this._rhapsodyImportTraversal.map(e, domain);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    IRPCollection _nestedElements = source.getNestedElements();
    final List packagedElements = _nestedElements.toList();
    final Procedure1<IRPModelElement> _function_1 = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement pkgE) {
          DomainRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, domain);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(packagedElements, _function_1);
    return domain;
  }
  
  protected Domain _importDomain(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public Domain importDomain(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importDomain((IRPClass)source, context);
    } else if (source != null) {
      return _importDomain(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
