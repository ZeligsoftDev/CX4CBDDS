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
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource

class ResourceRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch Resource importResource(IRPClass source, Object context) {
        val name = source.name
        val resource = createZDLElement(context, name, CCMNames::RESOURCE, typeof(Resource)) as Resource
        typeCache.put(source.fullPathName, resource.asClass)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(resource))
        
        return resource
    }
    
    def dispatch Resource importResource(IRPModelElement source, Object context) {
	}
	
}