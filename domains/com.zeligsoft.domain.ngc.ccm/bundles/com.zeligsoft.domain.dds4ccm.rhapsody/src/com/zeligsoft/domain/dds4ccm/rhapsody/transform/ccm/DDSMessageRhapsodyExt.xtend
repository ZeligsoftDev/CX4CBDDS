package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPType
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.DDSMessage
import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import java.util.List

class DDSMessageRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    	
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	private RhapsodyTraceabilityCache typeCache
	
    @Inject extension DDS4CCMFactory
 	@Inject extension RhapsodyImportTraversal    
    
    def dispatch DDSMessage importDDSMessage(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, DDS4CCMNames::DDSMESSAGE, typeof(DDSMessage)) as DDSMessage
        typeCache.put(source.fullPathName, element.asDataType)
        source.attributes.toList.forEach(IRPModelElement e | e.map(element))
        return element
    }
    
    def dispatch DDSMessage importDDSMessage(IRPModelElement source, Object context) {
    }
    
    def dispatch MessageField importMessageField(IRPAttribute source, DDSMessage context) {
    	val name = source.name
        val field = createZDLElement(context, name, DDS4CCMNames::MESSAGE_FIELD, typeof(MessageField)) as MessageField
        if(field != null){
            if(source.type != null){
            	updateRequired.add(new ReferenceUpdateMetadata(DDS4CCMNames::MESSAGE_FIELD, 
            		CORBADomainNames::CORBATYPED__IDL_TYPE, 
            		field.asProperty, source.type.fullPathName))
            }
        }
        return field
    }
    
    def dispatch MessageField importMessageField(IRPModelElement source, Object context) {
    	
    }    
}