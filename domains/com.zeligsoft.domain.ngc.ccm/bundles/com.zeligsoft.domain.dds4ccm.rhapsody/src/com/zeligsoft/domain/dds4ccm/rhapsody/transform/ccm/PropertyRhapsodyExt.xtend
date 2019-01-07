package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property
import java.util.List

class PropertyRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch Property importProperty(IRPAttribute source, Object context) {
    	var name = source.name
    	if(name.startsWith("edu_vanderbilt_dre")){
    		name = name.replaceAll("_", ".")
    	}
        val attr = createZDLElement(context, name, CCMNames::PROPERTY, typeof(Property)) as Property
        if(attr != null){
	        if(source.type != null){
	        	updateRequired.add(new ReferenceUpdateMetadata(CCMNames::PROPERTY, 
	        		CCMNames::PROPERTY__TYPE, 
	        		attr.asProperty, source.type.fullPathName))
	        }
        }
        return attr
    }
    
    def dispatch Property importProperty(IRPModelElement source, Object context) {
    }
}