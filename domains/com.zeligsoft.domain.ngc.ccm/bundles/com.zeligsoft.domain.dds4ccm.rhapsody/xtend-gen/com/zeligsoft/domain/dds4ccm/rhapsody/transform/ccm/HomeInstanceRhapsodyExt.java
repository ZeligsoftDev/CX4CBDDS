package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.HomeInstance;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;

@SuppressWarnings("all")
public class HomeInstanceRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected HomeInstance _importHomeInstance(final IRPInstance source, final AssemblyImplementation context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.HOME_INSTANCE, HomeInstance.class);
    final HomeInstance element = ((HomeInstance) _createZDLElement);
    Property _asProperty = element.asProperty();
    _asProperty.setIsComposite(true);
    final IRPClassifier definition = source.getOtherClass();
    boolean _notEquals = (!Objects.equal(definition, null));
    if (_notEquals) {
      Property _asProperty_1 = element.asProperty();
      String _fullPathName = definition.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.HOME_INSTANCE, 
        ZMLMMNames.PART__DEFINITION, _asProperty_1, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    return element;
  }
  
  protected HomeInstance _importHomeInstance(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public HomeInstance importHomeInstance(final IRPModelElement source, final Object context) {
    if (source instanceof IRPInstance
         && context instanceof AssemblyImplementation) {
      return _importHomeInstance((IRPInstance)source, (AssemblyImplementation)context);
    } else if (source != null
         && context != null) {
      return _importHomeInstance(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
