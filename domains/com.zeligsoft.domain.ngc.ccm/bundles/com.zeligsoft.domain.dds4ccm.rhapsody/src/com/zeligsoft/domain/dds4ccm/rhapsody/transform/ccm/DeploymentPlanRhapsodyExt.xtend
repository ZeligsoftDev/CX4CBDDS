package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.DeploymentPlan
import java.util.UUID
import com.zeligsoft.base.zdl.util.ZDLUtil

class DeploymentPlanRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch DeploymentPlan importDeploymentPlan(IRPClass source, Object context) {
        val name = source.name
        val dp = createZDLElement(context, name, CCMNames::DEPLOYMENT_PLAN, typeof(DeploymentPlan)) as DeploymentPlan
        val id = UUID::randomUUID.toString
        ZDLUtil::setValue(dp.asComponent, CCMNames::DEPLOYMENT_PLAN, CCMNames::DEPLOYMENT_PLAN__ID, id)
        typeCache.put(source.fullPathName, dp.asComponent)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(dp))
        
        return dp
    }
    
    def dispatch DeploymentPlan importDeploymentPlan(IRPModelElement source, Object context) {
	}
	
}