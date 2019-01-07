package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Manages;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

@SuppressWarnings("all")
public class HomeManagesDependencyRhapsodyExt {
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  protected Manages _importManagesDependency(final IRPDependency source, final Home context) {
    final IRPModelElement dependsOn = source.getDependsOn();
    EObject _eObject = context.eObject();
    final EObject container = this.getOwningPackage(_eObject);
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(container, "", CCMNames.MANAGES, Manages.class);
    final Manages element = ((Manages) _createZDLElement);
    Dependency _asDependency = element.asDependency();
    EList<NamedElement> _clients = _asDependency.getClients();
    org.eclipse.uml2.uml.Class _asClass = context.asClass();
    _clients.add(_asClass);
    boolean _notEquals = (!Objects.equal(dependsOn, null));
    if (_notEquals) {
      Dependency _asDependency_1 = element.asDependency();
      String _fullPathName = dependsOn.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.MANAGES, CCMNames.MANAGES__COMPONENT, _asDependency_1, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    return element;
  }
  
  protected Manages _importManagesDependency(final IRPModelElement source, final Object context) {
    return null;
  }
  
  private EObject getOwningPackage(final EObject source) {
    if ((source instanceof org.eclipse.uml2.uml.Package)) {
      return source;
    }
    final EObject owner = source.eContainer();
    return this.getOwningPackage(owner);
  }
  
  public Manages importManagesDependency(final IRPModelElement source, final Object context) {
    if (source instanceof IRPDependency
         && context instanceof Home) {
      return _importManagesDependency((IRPDependency)source, (Home)context);
    } else if (source != null
         && context != null) {
      return _importManagesDependency(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
