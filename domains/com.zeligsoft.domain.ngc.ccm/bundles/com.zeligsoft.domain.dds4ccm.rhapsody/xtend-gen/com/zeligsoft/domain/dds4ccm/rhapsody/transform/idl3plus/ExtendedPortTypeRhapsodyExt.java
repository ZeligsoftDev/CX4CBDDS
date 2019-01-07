package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPStereotype;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.ExtendedPortType;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExtendedPortTypeRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.RELATION_UPDATE_LIST_BINDING)
  private List<RelationUpdateMetadata> relationUpdateCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected ExtendedPortType _importExtendedPortType(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.EXTENDED_PORT_TYPE, ExtendedPortType.class);
    final ExtendedPortType porttype = ((ExtendedPortType) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    org.eclipse.uml2.uml.Class _asClass = porttype.asClass();
    this.typeCache.put(_fullPathName, _asClass);
    IRPCollection _generalizations = source.getGeneralizations();
    List _list = _generalizations.toList();
    final Procedure1<IRPGeneralization> _function = new Procedure1<IRPGeneralization>() {
        public void apply(final IRPGeneralization r) {
          ExtendedPortTypeRhapsodyExt.this.mapRelation(r, porttype);
        }
      };
    IterableExtensions.<IRPGeneralization>forEach(_list, _function);
    IRPCollection _dependencies = source.getDependencies();
    List _list_1 = _dependencies.toList();
    final Procedure1<IRPDependency> _function_1 = new Procedure1<IRPDependency>() {
        public void apply(final IRPDependency d) {
          ExtendedPortTypeRhapsodyExt.this.mapDependency(d, porttype);
        }
      };
    IterableExtensions.<IRPDependency>forEach(_list_1, _function_1);
    IRPCollection _attributes = source.getAttributes();
    List _list_2 = _attributes.toList();
    final Procedure1<IRPAttribute> _function_2 = new Procedure1<IRPAttribute>() {
        public void apply(final IRPAttribute a) {
          ExtendedPortTypeRhapsodyExt.this._rhapsodyImportTraversal.map(a, porttype);
        }
      };
    IterableExtensions.<IRPAttribute>forEach(_list_2, _function_2);
    return porttype;
  }
  
  private void mapRelation(final IRPGeneralization gen, final ExtendedPortType container) {
    final IRPClassifier base = gen.getBaseClass();
    boolean _notEquals = (!Objects.equal(base, null));
    if (_notEquals) {
      final String other = base.getFullPathName();
      org.eclipse.uml2.uml.Class _asClass = container.asClass();
      EClass _interfaceRealization = UMLPackage.eINSTANCE.getInterfaceRealization();
      RelationUpdateMetadata _relationUpdateMetadata = new RelationUpdateMetadata(_asClass, other, _interfaceRealization);
      this.relationUpdateCache.add(_relationUpdateMetadata);
    }
  }
  
  private void mapDependency(final IRPDependency dependency, final ExtendedPortType container) {
    IRPCollection _stereotypes = dependency.getStereotypes();
    List _list = _stereotypes.toList();
    final Procedure1<IRPStereotype> _function = new Procedure1<IRPStereotype>() {
        public void apply(final IRPStereotype st) {
          ExtendedPortTypeRhapsodyExt.this.mapDependency(st, dependency, container);
        }
      };
    IterableExtensions.<IRPStereotype>forEach(_list, _function);
  }
  
  private void mapDependency(final IRPStereotype st, final IRPDependency dependency, final ExtendedPortType container) {
    final String name = st.getName();
    boolean _equals = Objects.equal(name, "Usage");
    if (_equals) {
      IRPModelElement _dependsOn = dependency.getDependsOn();
      final String other = _dependsOn.getFullPathName();
      org.eclipse.uml2.uml.Class _asClass = container.asClass();
      EClass _usage = UMLPackage.eINSTANCE.getUsage();
      RelationUpdateMetadata _relationUpdateMetadata = new RelationUpdateMetadata(_asClass, other, _usage);
      this.relationUpdateCache.add(_relationUpdateMetadata);
    }
  }
  
  protected ExtendedPortType _importExtendedPortType(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public ExtendedPortType importExtendedPortType(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importExtendedPortType((IRPClass)source, context);
    } else if (source != null) {
      return _importExtendedPortType(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
