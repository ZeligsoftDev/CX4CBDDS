package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.ResourceProperty
import java.util.List

class ResourcePropertyRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch ResourceProperty importResourceProperty(IRPAttribute source, Object context) {
    	val name = source.name
        val attr = createZDLElement(context, name, CCMNames::RESOURCE_PROPERTY, typeof(ResourceProperty)) as ResourceProperty
        if(attr != null){
	        if(source.type != null){
	        	updateRequired.add(new ReferenceUpdateMetadata(CCMNames::RESOURCE_PROPERTY, 
	        		CCMNames::RESOURCE_PROPERTY__TYPE, 
	        		attr.asProperty, source.type.fullPathName))
	        }
        }
        return attr
    }
    
    def dispatch ResourceProperty importResourceProperty(IRPModelElement source, Object context) {
    }
}