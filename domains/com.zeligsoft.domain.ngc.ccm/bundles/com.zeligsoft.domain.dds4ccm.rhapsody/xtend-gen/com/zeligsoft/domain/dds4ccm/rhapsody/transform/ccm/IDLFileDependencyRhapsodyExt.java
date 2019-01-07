package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileDependency;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

@SuppressWarnings("all")
public class IDLFileDependencyRhapsodyExt {
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  protected IDLFileDependency _importIDLFileDependency(final IRPDependency source, final CORBAModule context) {
    final IRPModelElement dependsOn = source.getDependsOn();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, "", DDS4CCMNames.IDLFILE_DEPENDENCY, IDLFileDependency.class);
    final IDLFileDependency element = ((IDLFileDependency) _createZDLElement);
    Dependency _asDependency = element.asDependency();
    EList<NamedElement> _clients = _asDependency.getClients();
    org.eclipse.uml2.uml.Package _asPackage = context.asPackage();
    _clients.add(_asPackage);
    boolean _notEquals = (!Objects.equal(dependsOn, null));
    if (_notEquals) {
      Dependency _asDependency_1 = element.asDependency();
      String _fullPathName = dependsOn.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(DDS4CCMNames.IDLFILE_DEPENDENCY, DDS4CCMNames.IDLFILE_DEPENDENCY__FILE, _asDependency_1, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    return element;
  }
  
  protected IDLFileDependency _importIDLFileDependency(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public IDLFileDependency importIDLFileDependency(final IRPModelElement source, final Object context) {
    if (source instanceof IRPDependency
         && context instanceof CORBAModule) {
      return _importIDLFileDependency((IRPDependency)source, (CORBAModule)context);
    } else if (source != null
         && context != null) {
      return _importIDLFileDependency(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
