package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPTag;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Interconnect;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Component;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class InterconnectRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  @Named(value = RhapsodyImportModule.DEPLOYMENT_UPDATE_LIST_BINDING)
  private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected Interconnect _importInterconnect(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.INTERCONNECT, Interconnect.class);
    final Interconnect element = ((Interconnect) _createZDLElement);
    String _fullPathName = source.getFullPathName();
    Component _asComponent = element.asComponent();
    this.typeCache.put(_fullPathName, _asComponent);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          InterconnectRhapsodyExt.this._rhapsodyImportTraversal.map(e, element);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    final IRPTag tag = source.getTag(CXRhapsodyConstants.DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
    boolean _notEquals = (!Objects.equal(tag, null));
    if (_notEquals) {
      Component _asComponent_1 = element.asComponent();
      DeploymentValueUpdateMetadata _deploymentValueUpdateMetadata = new DeploymentValueUpdateMetadata(_asComponent_1, source);
      this.deploymentUpdateRequired.add(_deploymentValueUpdateMetadata);
    }
    return element;
  }
  
  protected Interconnect _importInterconnect(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public Interconnect importInterconnect(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importInterconnect((IRPClass)source, context);
    } else if (source != null) {
      return _importInterconnect(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
