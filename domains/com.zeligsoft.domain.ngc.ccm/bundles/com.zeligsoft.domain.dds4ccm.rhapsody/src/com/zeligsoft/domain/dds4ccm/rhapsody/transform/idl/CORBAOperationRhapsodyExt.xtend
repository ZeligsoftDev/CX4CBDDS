package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPOperation
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAOperation
import java.util.List

class CORBAOperationRhapsodyExt {
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch CORBAOperation importCorbaOperation(IRPOperation source, Object context) {
    	val name = source.name
        val parameters = source.arguments.toList
        val operation = createZDLElement(context, name, CORBADomainNames::CORBAOPERATION, typeof(CORBAOperation)) as CORBAOperation
        if(operation != null){
            parameters.forEach(IRPModelElement pkgE | pkgE.map(operation))
            if(source.returns != null){
            	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBAOPERATION, 
            		CORBADomainNames::CORBATYPED__IDL_TYPE, 
            		operation.asOperation, source.returns.fullPathName))
            }
        }
        return operation
    }
    
    def dispatch CORBAOperation importCorbaOperation(IRPModelElement source, Object context) {
    }
    
}