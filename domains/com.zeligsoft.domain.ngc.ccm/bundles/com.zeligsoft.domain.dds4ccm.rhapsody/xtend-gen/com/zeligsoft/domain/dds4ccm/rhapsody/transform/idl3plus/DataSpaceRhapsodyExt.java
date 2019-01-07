package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus;

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
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.DataSpace;
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.VisibilityKind;

@SuppressWarnings("all")
public class DataSpaceRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected DataSpace _importDataSpace(final IRPInstance source, final AssemblyImplementation context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, IDL3PlusNames.DATA_SPACE, DataSpace.class);
    final DataSpace dataSpace = ((DataSpace) _createZDLElement);
    Property _asProperty = dataSpace.asProperty();
    _asProperty.setIsComposite(true);
    Property _asProperty_1 = dataSpace.asProperty();
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
      Property _asProperty_2 = dataSpace.asProperty();
      String _fullPathName_2 = definition.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(IDL3PlusNames.DATA_SPACE, 
        IDL3PlusNames.DATA_SPACE__CONNECTOR_TYPE, _asProperty_2, _fullPathName_2);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    String _fullPathName_3 = source.getFullPathName();
    Property _asProperty_3 = dataSpace.asProperty();
    this.typeCache.put(_fullPathName_3, _asProperty_3);
    return dataSpace;
  }
  
  protected DataSpace _importDataSpace(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public DataSpace importDataSpace(final IRPModelElement source, final Object context) {
    if (source instanceof IRPInstance
         && context instanceof AssemblyImplementation) {
      return _importDataSpace((IRPInstance)source, (AssemblyImplementation)context);
    } else if (source != null
         && context != null) {
      return _importDataSpace(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
