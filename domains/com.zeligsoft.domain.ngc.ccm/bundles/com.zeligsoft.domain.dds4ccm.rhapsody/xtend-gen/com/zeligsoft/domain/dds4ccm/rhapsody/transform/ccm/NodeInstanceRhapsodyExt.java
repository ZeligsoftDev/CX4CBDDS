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
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.NodeInstance;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.VisibilityKind;

@SuppressWarnings("all")
public class NodeInstanceRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.UPDATE_LIST_BINDING)
  private List<ReferenceUpdateMetadata> updateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  protected NodeInstance _importNodeInstance(final IRPInstance source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.NODE_INSTANCE, NodeInstance.class);
    final NodeInstance nodeInstance = ((NodeInstance) _createZDLElement);
    Property _asProperty = nodeInstance.asProperty();
    _asProperty.setIsComposite(true);
    Property _asProperty_1 = nodeInstance.asProperty();
    _asProperty_1.setVisibility(VisibilityKind.PRIVATE_LITERAL);
    final IRPClassifier definition = source.getOtherClass();
    boolean _notEquals = (!Objects.equal(definition, null));
    if (_notEquals) {
      Property _asProperty_2 = nodeInstance.asProperty();
      String _fullPathName = definition.getFullPathName();
      ReferenceUpdateMetadata _referenceUpdateMetadata = new ReferenceUpdateMetadata(CCMNames.NODE_INSTANCE, 
        CCMNames.NODE_INSTANCE__TYPE, _asProperty_2, _fullPathName);
      this.updateRequired.add(_referenceUpdateMetadata);
    }
    String _fullPathName_1 = source.getFullPathName();
    Property _asProperty_3 = nodeInstance.asProperty();
    this.typeCache.put(_fullPathName_1, _asProperty_3);
    return nodeInstance;
  }
  
  protected NodeInstance _importNodeInstance(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public NodeInstance importNodeInstance(final IRPModelElement source, final Object context) {
    if (source instanceof IRPInstance) {
      return _importNodeInstance((IRPInstance)source, context);
    } else if (source != null) {
      return _importNodeInstance(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
