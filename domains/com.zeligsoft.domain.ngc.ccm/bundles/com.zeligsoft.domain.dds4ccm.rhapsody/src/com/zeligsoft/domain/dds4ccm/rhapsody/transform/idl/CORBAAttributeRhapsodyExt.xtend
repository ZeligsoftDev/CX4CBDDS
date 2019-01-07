package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute
import java.util.List

class CORBAAttributeRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAAttribute importCorbaAttribute(IRPAttribute source, Object context) {
    	var name = source.name
    	if(name.startsWith("edu_vanderbilt_dre")){
    		name = name.replaceAll("_", ".")
    	}
        val attr = createZDLElement(context, name, CORBADomainNames::CORBAATTRIBUTE, typeof(CORBAAttribute)) as CORBAAttribute
        if(attr != null){
	        if(source.type != null){
	        	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBAATTRIBUTE, 
	        		CORBADomainNames::CORBATYPED__IDL_TYPE, 
	        		attr.asProperty, source.type.fullPathName))
	        }
        }
        return attr
    }
    
    def dispatch CORBAAttribute importCorbaAttribute(IRPModelElement source, Object context) {
    }
}