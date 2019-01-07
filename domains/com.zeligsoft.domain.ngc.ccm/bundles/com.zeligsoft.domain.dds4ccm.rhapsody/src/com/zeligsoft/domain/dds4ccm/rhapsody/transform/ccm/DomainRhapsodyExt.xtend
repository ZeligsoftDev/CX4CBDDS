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
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Domain

class DomainRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch Domain importDomain(IRPClass source, Object context) {
        val name = source.name
        val domain = createZDLElement(context, name, CCMNames::DOMAIN, typeof(Domain)) as Domain
        typeCache.put(source.fullPathName, domain.asComponent)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(domain))
        val packagedElements = source.nestedElements.toList
        packagedElements.forEach(IRPModelElement pkgE | pkgE.map(domain))
        
        return domain
    }
    
    def dispatch Domain importDomain(IRPModelElement source, Object context) {
	}
	
}