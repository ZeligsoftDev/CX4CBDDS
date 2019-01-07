package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface

class CORBAInterfaceRhapsodyExt {
	@Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch CORBAInterface importCorbaInterface(IRPClass source, Object context) {
    	val name = source.name
        val nestedElements = source.nestedElements.toList
        val interface = createZDLElement(context, name, CORBADomainNames::CORBAINTERFACE, typeof(CORBAInterface)) as CORBAInterface
        typeCache.put(source.fullPathName, interface.asInterface)
        nestedElements.forEach(IRPModelElement e | e.map(interface))
        return interface
    }
    
    def dispatch CORBAInterface importCorbaInterface(IRPModelElement source, Object context) {
    }
}