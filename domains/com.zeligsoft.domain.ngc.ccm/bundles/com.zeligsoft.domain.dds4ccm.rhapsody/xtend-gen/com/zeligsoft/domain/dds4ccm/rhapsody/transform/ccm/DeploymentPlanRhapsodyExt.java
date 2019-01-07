package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.eclipse.uml2.uml.Component;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DeploymentPlanRhapsodyExt {
  @Inject
  @Named(value = RhapsodyImportModule.TYPE_CACHE_BINDING)
  private RhapsodyTraceabilityCache typeCache;
  
  @Inject
  private DDS4CCMFactory _dDS4CCMFactory;
  
  @Inject
  private RhapsodyImportTraversal _rhapsodyImportTraversal;
  
  protected DeploymentPlan _importDeploymentPlan(final IRPClass source, final Object context) {
    final String name = source.getName();
    ZObject _createZDLElement = this._dDS4CCMFactory.createZDLElement(context, name, CCMNames.DEPLOYMENT_PLAN, DeploymentPlan.class);
    final DeploymentPlan dp = ((DeploymentPlan) _createZDLElement);
    UUID _randomUUID = UUID.randomUUID();
    final String id = _randomUUID.toString();
    Component _asComponent = dp.asComponent();
    ZDLUtil.setValue(_asComponent, CCMNames.DEPLOYMENT_PLAN, CCMNames.DEPLOYMENT_PLAN__ID, id);
    String _fullPathName = source.getFullPathName();
    Component _asComponent_1 = dp.asComponent();
    this.typeCache.put(_fullPathName, _asComponent_1);
    IRPCollection _attributes = source.getAttributes();
    List _list = _attributes.toList();
    final Procedure1<IRPModelElement> _function = new Procedure1<IRPModelElement>() {
        public void apply(final IRPModelElement e) {
          DeploymentPlanRhapsodyExt.this._rhapsodyImportTraversal.map(e, dp);
        }
      };
    IterableExtensions.<IRPModelElement>forEach(_list, _function);
    return dp;
  }
  
  protected DeploymentPlan _importDeploymentPlan(final IRPModelElement source, final Object context) {
    return null;
  }
  
  public DeploymentPlan importDeploymentPlan(final IRPModelElement source, final Object context) {
    if (source instanceof IRPClass) {
      return _importDeploymentPlan((IRPClass)source, context);
    } else if (source != null) {
      return _importDeploymentPlan(source, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(source, context).toString());
    }
  }
}
