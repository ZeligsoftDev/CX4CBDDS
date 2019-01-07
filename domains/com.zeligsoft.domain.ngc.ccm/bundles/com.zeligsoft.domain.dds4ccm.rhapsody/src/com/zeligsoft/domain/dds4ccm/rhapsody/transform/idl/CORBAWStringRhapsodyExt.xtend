package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAWString

class CORBAWStringRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAWString importCorbaWString(IRPType source, Object context) {
    	val name = source.name
        val string = createZDLElement(context, name, CORBADomainNames::CORBAWSTRING, typeof(CORBAWString)) as CORBAWString
        typeCache.put(source.fullPathName, string.asDataType)
        return string
    }
    
    def dispatch CORBAWString importCorbaWString(IRPModelElement source, Object context) {
    }
}