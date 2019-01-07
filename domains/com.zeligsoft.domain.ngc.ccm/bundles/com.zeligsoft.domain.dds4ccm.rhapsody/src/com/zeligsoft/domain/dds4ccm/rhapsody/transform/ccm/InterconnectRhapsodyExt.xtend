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
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Interconnect
import java.util.List
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants

class InterconnectRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;        
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch Interconnect importInterconnect(IRPClass source, Object context) {
        val name = source.name
        val element = createZDLElement(context, name, CCMNames::INTERCONNECT, typeof(Interconnect)) as Interconnect
        typeCache.put(source.fullPathName, element.asComponent)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(element))
        val tag = source.getTag(CXRhapsodyConstants::DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
        if(tag != null){
        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(element.asComponent, source))
        }
        return element
    }
    
    def dispatch Interconnect importInterconnect(IRPModelElement source, Object context) {
	}
	
}