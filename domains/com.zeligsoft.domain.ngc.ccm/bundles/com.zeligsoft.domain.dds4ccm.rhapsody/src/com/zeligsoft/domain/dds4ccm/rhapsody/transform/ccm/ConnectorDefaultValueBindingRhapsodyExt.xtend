package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImportTraversal
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding

class ConnectorDefaultValueBindingRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyImportTraversal
    
    def dispatch ConnectorDefaultValueBinding importConnectorDefaultValueBinding(IRPClass source, Object context) {
        val name = source.name
        val element = createZDLElement(context, name, IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING, typeof(ConnectorDefaultValueBinding)) as ConnectorDefaultValueBinding
        typeCache.put(source.fullPathName, element.asPackage)
        // attributes
        source.attributes.toList.forEach(IRPModelElement e | e.map(element))
        
        return element
    }
    
    def dispatch ConnectorDefaultValueBinding importConnectorDefaultValueBinding(IRPModelElement source, Object context) {
	}
	
}