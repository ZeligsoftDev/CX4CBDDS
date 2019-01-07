package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AssemblyImplementationRhapsodyExt {
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected AssemblyImplementation _importAssemblyImplementation(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.ASSEMBLY_IMPLEMENTATION, AssemblyImplementation.class);
    final AssemblyImplementation assembly = ((AssemblyImplementation) _createZDLElement);
    IRPCollection _nestedElements = source.getNestedElements();
    List _list = _nestedElements.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement el) {
          AssemblyImplementationRhapsodyExt.this._rhapsodyImportTraversal.map(el, assembly);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    IRPCollection _generalizations = source.getGeneralizations();
    List _list_1 = _generalizations.toList();
    final Procedure1<IRPGeneralization> _function_1 = new Procedure1<IRPGeneralization>() {
        public void apply(final IRPGeneralization g) {
          EObject _eObject = assembly.eObject();
          AssemblyImplementationRhapsodyExt.this._rhapsodyImportTraversal.mapGeneralization(g, _eObject);
        }
      };
    IterableExtensions.<IRPGeneralization>forEach(_list_1, _function_1);
    return assembly;
  }
  
  protected AssemblyImplementation _importAssemblyImplementation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public AssemblyImplementation importAssemblyImplementation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importAssemblyImplementation((IRPClass)source, context);
    } else if (source != null) {
      return _importAssemblyImplementation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
