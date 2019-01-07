package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAStruct

class CORBAStructRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject extension DDS4CCMFactory
 	@Inject extension RhapsodyImportTraversal    
    
    def dispatch CORBAStruct importCorbaStruct(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBASTRUCT, typeof(CORBAStruct)) as CORBAStruct
        typeCache.put(source.fullPathName, element.asDataType)
        source.attributes.toList.forEach(IRPModelElement e | e.map(element))
        return element
    }
    
    def dispatch CORBAStruct importCorbaStruct(IRPModelElement source, Object context) {
    }
}