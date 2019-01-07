package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPEnumerationLiteral
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAEnum

class CORBAEnumRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAEnum importCorbaEnum(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBAENUM, typeof(CORBAEnum)) as CORBAEnum
        typeCache.put(source.fullPathName, element.asEnumeration)
        source.enumerationLiterals.toList.forEach(IRPEnumerationLiteral l | l.mapLiteral(element))
        return element
    }
    
    def private void mapLiteral(IRPEnumerationLiteral literal, CORBAEnum enum){
    	val umlLiteral = enum.asEnumeration.createOwnedLiteral(literal.name)
    	umlLiteral.classifiers.add(enum.asEnumeration)
    	
    }
    
    def dispatch CORBAEnum importCorbaEnum(IRPModelElement source, Object context) {
    }
}