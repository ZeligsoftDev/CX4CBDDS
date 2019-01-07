package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAUnion

class CORBAUnionRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAUnion importCorbaUnion(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBAUNION, typeof(CORBAUnion)) as CORBAUnion
        typeCache.put(source.fullPathName, element.asDataType)
        return element
    }
    
    def dispatch CORBAUnion importCorbaUnion(IRPModelElement source, Object context) {
    }
}