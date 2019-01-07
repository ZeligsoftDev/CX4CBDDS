package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.google.inject.name.Named
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache

class IDLFileSpecificationRhapsodyExt {
    @Inject extension DDS4CCMFactory
    
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
        
    def dispatch IDLFileSpecification importIDLFileSpecification(IRPClass source, Object context) {
        val name = source.name
    	val element = createZDLElement(context, name, DDS4CCMNames::IDLFILE_SPECIFICATION, typeof(IDLFileSpecification)) as IDLFileSpecification
        typeCache.put(source.fullPathName, element.asClass)
        return element
    }
    
    def dispatch IDLFileSpecification importIDLFileSpecification(IRPModelElement source, Object context) {
	} 
}