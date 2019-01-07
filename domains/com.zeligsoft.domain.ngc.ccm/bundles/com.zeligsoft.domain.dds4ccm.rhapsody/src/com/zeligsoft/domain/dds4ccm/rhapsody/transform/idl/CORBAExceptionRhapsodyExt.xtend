package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.google.inject.name.Named
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException
import com.zeligsoft.domain.omg.corba.CORBADomainNames

class CORBAExceptionRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch CORBAException importCorbaException(IRPType source, Object context) {
    	val name = source.name
        val exception = createZDLElement(context, name, CORBADomainNames::CORBAEXCEPTION, typeof(CORBAException)) as CORBAException
        if(exception != null){
            typeCache.put(source.fullPathName, exception.asDataType)
        	source.attributes.toList.forEach(IRPModelElement field | field.map(exception))
        }
        return exception
    }
    
    def dispatch CORBAException importCorbaException(IRPModelElement source, Object context) {
    	
    }
    
}