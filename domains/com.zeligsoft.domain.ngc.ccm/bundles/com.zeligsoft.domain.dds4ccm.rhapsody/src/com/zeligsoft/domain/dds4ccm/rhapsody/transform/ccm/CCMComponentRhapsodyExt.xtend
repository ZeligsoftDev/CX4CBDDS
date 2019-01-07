package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPGeneralization
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPPort
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.CCMComponent
import java.util.List

class CCMComponentRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;    
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch CCMComponent importCCMComponent(IRPClass source, Object context) {
        val name = source.name
    	val ccmComponent = createZDLElement(context, name, CCMNames::CCMCOMPONENT, typeof(CCMComponent)) as CCMComponent
        typeCache.put(source.fullPathName, ccmComponent.asComponent)
        
        ccmComponent.populateCCMComponent(source)
        
        return ccmComponent
    }
    
    def dispatch CCMComponent importCCMComponent(IRPModelElement source, Object context) {
    	return null
	}
	
    def private populateCCMComponent(CCMComponent self, IRPClass source) {
        // generals
        source.generalizations.toList.forEach(IRPGeneralization g | g.mapGeneralization(self.eObject))
        // owned attributes
        val ownedAttributes = source.attributes.toList
        ownedAttributes.forEach(IRPAttribute e | e.map(self))
        
        // owned ports
        val sourcePorts = source.ports.toList
        sourcePorts.forEach(IRPPort sp | sp.map(self))
        
        val tag = source.getTag(CXRhapsodyConstants::DEPLOYMENT_INSTANT_VALUE_TAG_NAME);
        if(tag != null){
        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(self.asComponent, source))
        }
    }
}