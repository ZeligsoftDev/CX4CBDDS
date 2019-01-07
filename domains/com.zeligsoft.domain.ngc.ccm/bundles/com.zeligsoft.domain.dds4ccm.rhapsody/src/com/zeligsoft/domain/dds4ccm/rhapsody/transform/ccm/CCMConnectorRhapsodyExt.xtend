package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPLink
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ConnectorStatusListenerConnection
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ConnectorUpdateMetadata
import com.zeligsoft.domain.omg.ccm.CCMNames
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.AssemblyImplementation
import com.zeligsoft.domain.omg.ccm.api.CCM_Implementation.CCMConnector
import java.util.List
import org.eclipse.uml2.uml.Connector

class CCMConnectorRhapsodyExt {
    @Inject 
    @Named(RhapsodyImportModule::CONNECTOR_UPDATE_LIST_BINDING)
    private List<ConnectorUpdateMetadata> connectorUpdateRequired;
    
    @Inject extension DDS4CCMFactory
    
    def dispatch CCMConnector importCCMConnector(IRPLink source, AssemblyImplementation context) {
        val connector = createZDLElement(context, "", CCMNames::CCMCONNECTOR, typeof(CCMConnector)) as CCMConnector
        connector.asConnector.setName(source.name);
    	connector.asConnector.updateHelper(source, context)
        
        return connector
    }
    
    def dispatch CCMConnector importCCMConnector(IRPModelElement source, Object context) {
	}
	
    def dispatch ConnectorStatusListenerConnection importCSLConnection(IRPLink source, AssemblyImplementation context) {
        val connector = createZDLElement(context, "", DDS4CCMNames::CONNECTOR_STATUS_LISTENER_CONNECTION, typeof(ConnectorStatusListenerConnection)) as ConnectorStatusListenerConnection
    	connector.asConnector.updateHelper(source, context)
        
        return connector
    }
    
    def dispatch ConnectorStatusListenerConnection importCSLConnection(IRPModelElement source, Object context) {
	}	
	
	def private updateHelper(Connector connector, IRPLink source, AssemblyImplementation context){
        var String sourceRole = null
        var String targetRole = null
        var String sourcePartWithPort = null
        var String targetPartWithPort = null
        
        if(source.fromPort != null){
        	sourceRole = source.fromPort.fullPathName
        	sourcePartWithPort = source.from.fullPathName
        }else if(source.from != null){
        	sourceRole = source.from.fullPathName
        }
        if(source.toPort != null){
        	targetRole = source.toPort.fullPathName
        	targetPartWithPort = source.to.fullPathName
        }else if(source.to != null){
        	targetRole = source.to.fullPathName
        }

        val sourceEnd = connector.createEnd
        val targetEnd = connector.createEnd
        connectorUpdateRequired.add(new ConnectorUpdateMetadata(sourceEnd, sourceRole, sourcePartWithPort,
	        		targetEnd, targetRole, targetPartWithPort))
        
        return connector
    }
}