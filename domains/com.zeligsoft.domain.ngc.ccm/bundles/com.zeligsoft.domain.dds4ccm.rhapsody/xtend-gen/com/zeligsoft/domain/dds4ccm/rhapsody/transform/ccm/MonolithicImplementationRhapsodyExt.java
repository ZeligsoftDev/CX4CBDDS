package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.MonolithicImplementation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class MonolithicImplementationRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.RELATION_UPDATE_LIST_BINDING)
  private List<RelationUpdateMetadata> relationUpdateCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected MonolithicImplementation _importMonolithicImplementation(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.MONOLITHIC_IMPLEMENTATION, MonolithicImplementation.class);
    final MonolithicImplementation element = ((MonolithicImplementation) _createZDLElement);
    IRPCollection _generalizations = source.getGeneralizations();
    List _list = _generalizations.toList();
    final Procedure1<IRPGeneralization> _function = new Procedure1<IRPGeneralization>() {
        public void apply(final IRPGeneralization g) {
          MonolithicImplementationRhapsodyExt.this.mapRelation(g, element);
        }
      };
    IterableExtensions.<IRPGeneralization>forEach(_list, _function);
    return element;
  }
  
  protected MonolithicImplementation _importMonolithicImplementation(final IRPModelElement source, final Object context) {
    return null;
  }
  
  private void mapRelation(final IRPGeneralization gen, final MonolithicImplementation container) {
    final IRPClassifier base = gen.getBaseClass();
    boolean _notEquals = (!Objects.equal(base, null));
    if (_notEquals) {
      final String other = base.getFullPathName();
      Component _asComponent = container.asComponent();
      EClass _generalization = UMLPackage.eINSTANCE.getGeneralization();
      RelationUpdateMetadata _relationUpdateMetadata = new RelationUpdateMetadata(_asComponent, other, _generalization);
      this.relationUpdateCache.add(_relationUpdateMetadata);
    }
  }
  
  public MonolithicImplementation importMonolithicImplementation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importMonolithicImplementation((IRPClass)source, context);
    } else if (source != null) {
      return _importMonolithicImplementation(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
