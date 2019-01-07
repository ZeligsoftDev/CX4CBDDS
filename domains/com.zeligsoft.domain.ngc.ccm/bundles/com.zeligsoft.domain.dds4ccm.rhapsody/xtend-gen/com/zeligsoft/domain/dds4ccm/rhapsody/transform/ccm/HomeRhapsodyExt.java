package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPOperation;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FactoryOperation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.FinderOperation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class HomeRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected Home _importHome(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.HOME, Home.class);
    final Home home = ((Home) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Class _asClass = home.asClass();
    this.typeCache.put(_fullPathName, _asClass);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          HomeRhapsodyExt.this._rhapsodyImportTraversal.map(e, home);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    IRPCollection _operations = source.getOperations();
    List _list_1 = _operations.toList();
    final Procedure1<IRPModelElement> _function_1 = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          HomeRhapsodyExt.this._rhapsodyImportTraversal.map(e, home);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list_1, _function_1);
    IRPCollection _generalizations = source.getGeneralizations();
    List _list_2 = _generalizations.toList();
    final Procedure1<IRPGeneralization> _function_2 = new Procedure1<IRPGeneralization>() {
        public void apply(final IRPGeneralization g) {
          EObject _eObject = home.eObject();
          HomeRhapsodyExt.this._rhapsodyImportTraversal.mapGeneralization(g, _eObject);
        }
      };
    IterableExtensions.<IRPGeneralization>forEach(_list_2, _function_2);
    IRPCollection _dependencies = source.getDependencies();
    List _list_3 = _dependencies.toList();
    final Procedure1<IRPDependency> _function_3 = new Procedure1<IRPDependency>() {
        public void apply(final IRPDependency d) {
          HomeRhapsodyExt.this._rhapsodyImportTraversal.map(d, home);
        }
      };
    IterableExtensions.<IRPDependency>forEach(_list_3, _function_3);
    return home;
  }
  
  protected Home _importHome(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected FactoryOperation _importFactoryOperation(final IRPOperation source, final Home context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.FACTORY_OPERATION, FactoryOperation.class);
    final FactoryOperation op = ((FactoryOperation) _createZDLElement);
    IRPCollection _arguments = source.getArguments();
    final List parameters = _arguments.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement pkgE) {
          HomeRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, op);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(parameters, _function);
    return op;
  }
  
  protected FactoryOperation _importFactoryOperation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  protected FinderOperation _importFinderOperation(final IRPOperation source, final Home context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.FINDER_OPERATION, FinderOperation.class);
    final FinderOperation op = ((FinderOperation) _createZDLElement);
    IRPCollection _arguments = source.getArguments();
    final List parameters = _arguments.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement pkgE) {
          HomeRhapsodyExt.this._rhapsodyImportTraversal.map(pkgE, op);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(parameters, _function);
    return op;
  }
  
  protected FinderOperation _importFinderOperation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public Home importHome(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importHome((IRPClass)source, context);
    } else if (source != null) {
      return _importHome(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public FactoryOperation importFactoryOperation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPOperation
         && context instanceof Home) {
      return _importFactoryOperation((IRPOperation)source, (Home)context);
    } else if (source != null
         && context != null) {
      return _importFactoryOperation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
  
  public FinderOperation importFinderOperation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPOperation
         && context instanceof Home) {
      return _importFinderOperation((IRPOperation)source, (Home)context);
    } else if (source != null
         && context != null) {
      return _importFinderOperation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
