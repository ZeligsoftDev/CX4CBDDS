package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import java.util.List
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAField

class CORBAFieldRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAField importCorbaField(IRPAttribute source, Object context) {
    	val name = source.name
        val field = createZDLElement(context, name, CORBADomainNames::CORBAFIELD, typeof(CORBAField)) as CORBAField
        if(field != null){
            if(source.type != null){
            	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBAFIELD, 
            		CORBADomainNames::CORBATYPED__IDL_TYPE, 
            		field.asProperty, source.type.fullPathName))
            }
        }
        return field
    }
    
    def dispatch CORBAField importCorbaField(IRPModelElement source, Object context) {
    	
    }
    
}