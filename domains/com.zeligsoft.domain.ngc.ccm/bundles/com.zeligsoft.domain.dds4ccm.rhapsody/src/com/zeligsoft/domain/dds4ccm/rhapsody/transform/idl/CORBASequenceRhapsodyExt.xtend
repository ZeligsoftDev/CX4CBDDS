package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBASequence
import java.util.List
import com.telelogic.rhapsody.core.IRPAttribute

class CORBASequenceRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBASequence importCorbaSequence(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBASEQUENCE, typeof(CORBASequence)) as CORBASequence
        val memberAttr = element.asDataType.createOwnedAttribute("members", null)
        memberAttr.setLower(0)
        memberAttr.setUpper(-1)         
        typeCache.put(source.fullPathName, element.asDataType)
        if(source.typedefBaseType != null){
    		updateRequired.add(new ReferenceUpdateMetadata(null, 
    			null, 
   				memberAttr, source.typedefBaseType.fullPathName))
        }else{
        	val attrs = source.attributes.toList.filter(IRPAttribute att | "members".equals(att.name))
        	if(attrs.size == 1 && attrs.head.type != null){
        		updateRequired.add(new ReferenceUpdateMetadata(null, 
        			null, 
       				memberAttr, attrs.head.type.fullPathName))
        	}
        } 
        return element       
    }
    
    def dispatch CORBASequence importCorbaSequence(IRPModelElement source, Object context) {
    }
}