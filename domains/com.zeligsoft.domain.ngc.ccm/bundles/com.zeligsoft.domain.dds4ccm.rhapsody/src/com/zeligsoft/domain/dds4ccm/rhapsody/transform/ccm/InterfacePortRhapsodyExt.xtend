package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPModelElement
import com.telelogic.rhapsody.core.IRPPort
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List
import org.eclipse.uml2.uml.Component
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.base.zdl.util.ZDLUtil

class InterfacePortRhapsodyExt {
	@Inject
	@Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
	RhapsodyTraceabilityCache typeCache
		
	@Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def private InterfacePort importInterfacePortHelper(IRPPort source, Component context) {
        val name = source.name
        val element = createZDLElement(context, name, CCMNames::INTERFACE_PORT, typeof(InterfacePort)) as InterfacePort
        
        val sourceFullName = source.fullPathName
        val contract = source.contract
        if(contract != null && !contract.fullPathName.equals(sourceFullName)){
        	updateRequired.add(new ReferenceUpdateMetadata(CCMNames::INTERFACE_PORT, 
        		ZMLMMNames::PORT__PORTTYPE, 
        		element.asPort, source.contract.fullPathName))
        }
        val conjugated = source.isReversed
        if(conjugated == 1){
        	ZDLUtil::setValue(element.asPort, CCMNames::INTERFACE_PORT, ZMLMMNames::CONJUGATED_PORT__IS_CONJUGATED, Boolean::valueOf(true))
        }
        typeCache.put(source.fullPathName, element.asPort)
        
        return element
    }
    
    def dispatch InterfacePort importInterfacePort(IRPPort source, StructuralRealization context) {
        
        importInterfacePortHelper(source, context.asComponent)
    }
    
    def dispatch InterfacePort importInterfacePort(IRPPort source, ComponentInterface context) {
        
        importInterfacePortHelper(source, context.asComponent)
    }       
    
    def dispatch InterfacePort importInterfacePort(IRPModelElement source, Object context) {
	}
	
}