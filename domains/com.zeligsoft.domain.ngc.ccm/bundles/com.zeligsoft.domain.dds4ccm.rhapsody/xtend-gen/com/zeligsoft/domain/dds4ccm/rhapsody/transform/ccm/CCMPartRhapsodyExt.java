package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMPart;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.VisibilityKind;

@SuppressWarnings("all")
public class CCMPartRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected CCMPart _importCCMPart(final IRPInstance source, final AssemblyImplementation context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.CCMPART, CCMPart.class);
    final CCMPart ccmPart = ((CCMPart) _createZDLElement);
    Property _asProperty = ccmPart.asProperty();
    _asProperty.setIsComposite(true);
    Property _asProperty_1 = ccmPart.asProperty();
    _asProperty_1.setVisibility(VisibilityKind.PRIVATE_LITERAL);
    final IRPClassifier definition = source.getOtherClass();
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(definition, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _fullPathName = definition.getFullPathName();
      String _fullPathName_1 = source.getFullPathName();
      boolean _equals = _fullPathName.equals(_fullPathName_1);
      boolean _not = (!_equals);
      _and = (_notEquals && _not);
    }
    if (_and) {
      Property _asProperty_2 = ccmPart.asProperty();
      String _fullPathName_2 = definition.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.CCMPART, 
        ZMLMMNames.PART__DEFINITION, _asProperty_2, _fullPathName_2);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    String _fullPathName_3 = source.getFullPathName();
    Property _asProperty_3 = ccmPart.asProperty();
    this.typeCache.put(_fullPathName_3, _asProperty_3);
    return ccmPart;
  }
  
  protected CCMPart _importCCMPart(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public CCMPart importCCMPart(final IRPModelElement source, final Object context) {
    if (source instanceof IRPInstance
         && context instanceof AssemblyImplementation) {
      return _importCCMPart((IRPInstance)source, (AssemblyImplementation)context);
    } else if (source != null
         && context != null) {
      return _importCCMPart(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
