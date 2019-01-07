package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDLFileSupport.IDLFile

class IDLFileRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch IDLFile importIDLFile(IRPClass source, Object context) {
        val name = source.name
        val idlfile = createZDLElement(context, name, CORBADomainNames::IDLFILE, typeof(IDLFile)) as IDLFile
        typeCache.put(source.fullPathName, idlfile.asPackage)
        
        return idlfile
    }
    
    def dispatch IDLFile importIDLFile(IRPModelElement source, Object context) {
	}
}