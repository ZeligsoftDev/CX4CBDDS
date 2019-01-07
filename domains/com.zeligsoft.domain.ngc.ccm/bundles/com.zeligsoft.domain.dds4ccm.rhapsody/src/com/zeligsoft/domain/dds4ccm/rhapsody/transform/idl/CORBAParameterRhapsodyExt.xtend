package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPArgument
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter
import java.util.List

class CORBAParameterRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBAParameter importCorbaParameter(IRPArgument source, Object context) {
    	val name = source.name
        val param = createZDLElement(context, name, CORBADomainNames::CORBAPARAMETER, typeof(CORBAParameter)) as CORBAParameter
        if(param != null){
            if(source.type != null){
            	val fullPath = source.type.fullPathName
            	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBAPARAMETER, 
            	CORBADomainNames::CORBATYPED__IDL_TYPE, 
            	param.asParameter, fullPath))
            }
        // TODO: set direction
    	}
    	return param
    }
    
    def dispatch CORBAParameter importCorbaParameter(IRPModelElement source, Object context) {
    
    }
}