package com.zeligsoft.domain.dds4ccm.rhapsody.transform.idl3plus

import com.google.inject.Inject
import com.telelogic.rhapsody.core.IRPClass
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding
import com.google.inject.name.Named
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import java.util.List
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata

class ConnectorDefaultValueBindingRhapsodyExt {
    @Inject
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch ConnectorDefaultValueBinding importConnectorDefaultValueBinding(IRPClass source, Object context) {
        val name = source.name
    	val connectorDef = createZDLElement(context, name, IDL3PlusNames::CONNECTOR_DEFAULT_VALUE_BINDING, typeof(ConnectorDefaultValueBinding)) as ConnectorDefaultValueBinding
	    deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(connectorDef.asPackage, source))

        
        return connectorDef
    }
    
    def dispatch ConnectorDefaultValueBinding importConnectorDefaultValueBinding(IRPModelElement source, Object context) {
    	return null
	}
	
}