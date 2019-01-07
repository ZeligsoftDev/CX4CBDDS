package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBACase
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAUnion
import java.util.List

class CORBACaseRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBACase importCorbaCase(IRPAttribute source, CORBAUnion context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBACASE, typeof(CORBACase)) as CORBACase
        if(source.type != null){
        	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBACASE, 
        	CORBADomainNames::CORBATYPED__IDL_TYPE, 
        	element.asProperty, source.fullPathName))
        }
        return element
    }
    
    def dispatch CORBACase importCorbaCase(IRPModelElement source, Object context) {
    }
}