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
import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.ContainerProcess
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata
import java.util.List

class ContainerProcessRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;    
        
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch ContainerProcess importContainerProcess(IRPClass source, Object context) {
        val name = source.name
        val cp = createZDLElement(context, name, CCMNames::CONTAINER_PROCESS, typeof(ContainerProcess)) as ContainerProcess
        typeCache.put(source.fullPathName, cp.asComponent)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(cp))
        val tag = source.getTag(CXRhapsodyConstants::DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
        if(tag != null){
        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(cp.asComponent, source))
        }
        return cp
    }
    
    def dispatch ContainerProcess importContainerProcess(IRPModelElement source, Object context) {
	}
}