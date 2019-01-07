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
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeImplementation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class HomeImplementationRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.RELATION_UPDATE_LIST_BINDING)
  private List<RelationUpdateMetadata> relationUpdateCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected HomeImplementation _importHomeImplementation(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.HOME_IMPLEMENTATION, HomeImplementation.class);
    final HomeImplementation element = ((HomeImplementation) _createZDLElement);
    IRPCollection _generalizations = source.getGeneralizations();
    List _list = _generalizations.toList();
    final Procedure1<IRPGeneralization> _function = new Procedure1<IRPGeneralization>() {
        public void apply(final IRPGeneralization g) {
          HomeImplementationRhapsodyExt.this.mapRelation(g, element);
        }
      };
    IterableExtensions.<IRPGeneralization>forEach(_list, _function);
    return element;
  }
  
  protected HomeImplementation _importHomeImplementation(final IRPModelElement source, final HomeImplementation context) {
    return null;
  }
  
  private void mapRelation(final IRPGeneralization gen, final HomeImplementation container) {
    final IRPClassifier base = gen.getBaseClass();
    boolean _notEquals = (!Objects.equal(base, null));
    if (_notEquals) {
      IRPClassifier _baseClass = gen.getBaseClass();
      final String other = _baseClass.getFullPathName();
      Component _asComponent = container.asComponent();
      EClass _generalization = UMLPackage.eINSTANCE.getGeneralization();
      RelationUpdateMetadata _relationUpdateMetadata = new RelationUpdateMetadata(_asComponent, other, _generalization);
      this.relationUpdateCache.add(_relationUpdateMetadata);
    }
  }
  
  public HomeImplementation importHomeImplementation(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass
         && context != null) {
      return _importHomeImplementation((IRPClass)source, context);
    } else if (source != null
         && context instanceof HomeImplementation) {
      return _importHomeImplementation(source, (HomeImplementation)context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
