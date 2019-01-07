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
import com.zeligsoft.domain.omg.corba.api.IDL.CORBATypeDef
import java.util.List

class CORBATypeDefRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache

	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    	
    @Inject extension DDS4CCMFactory
    
    def dispatch CORBATypeDef importCorbaTypeDef(IRPType source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBATYPE_DEF, typeof(CORBATypeDef)) as CORBATypeDef
        typeCache.put(source.fullPathName, element.asDataType)
        if(source.typedefBaseType != null){
        		updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBATYPE_DEF, 
        			CORBADomainNames::CORBATYPE_DEF__TYPE,
       				element.asDataType, source.typedefBaseType.fullPathName))
        }   
        element         
    }
    
    def dispatch CORBATypeDef importCorbaTypeDef(IRPModelElement source, Object context) {
    }
}