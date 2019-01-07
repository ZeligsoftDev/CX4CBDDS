package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPLiteralSpecification
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.corba.CORBADomainNames
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstant
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants
import java.util.List

class CORBAConstantRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
	
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    	
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch CORBAConstant importCorbaConstant(IRPAttribute source, CORBAConstants context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBACONSTANT, typeof(CORBAConstant)) as CORBAConstant
        typeCache.put(source.fullPathName, element.asProperty)
        if(source.type != null){
        	updateRequired.add(new ReferenceUpdateMetadata(CORBADomainNames::CORBACONSTANT, 
        		CORBADomainNames::CORBATYPED__IDL_TYPE, 
        		element.asProperty, source.type.fullPathName))
        }
        val values = source.valueSpecifications.toList
        if(!values.empty){
        	values.get(0).mapDefault(element)
        	
        }
        return element
    }
    
    def private dispatch void mapDefault(IRPLiteralSpecification literal, CORBAConstant container){
    	val value = literal.value
    	ZDLUtil::setValue(container.asProperty, CORBADomainNames::CORBACONSTANT, CORBADomainNames::CORBACONSTANT__DEFAULT, value)
    }

    def private dispatch void mapDefault(Object literal, CORBAConstant container){
    	
    }
        
    def dispatch CORBAConstant importCorbaConstant(IRPModelElement source, Object context) {
    }
    
    def dispatch CORBAConstants importCorbaConstants(IRPClass source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, CORBADomainNames::CORBACONSTANTS, typeof(CORBAConstants)) as CORBAConstants
        typeCache.put(source.fullPathName, element.asClass)
        source.attributes.toList.forEach(IRPModelElement e | e.map(element))
        return element
    }
    
    def dispatch CORBAConstants importCorbaConstants(IRPModelElement source, Object context) {
    }
}