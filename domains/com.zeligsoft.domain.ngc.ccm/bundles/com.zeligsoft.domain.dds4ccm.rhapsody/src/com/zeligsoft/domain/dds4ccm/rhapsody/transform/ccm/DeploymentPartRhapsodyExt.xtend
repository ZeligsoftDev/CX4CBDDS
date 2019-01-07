package com.zeligsoft.domain.dds4ccm.rhapsody.transform.ccm

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPAttribute
import com.telelogic.rhapsody.core.IRPDependency
import com.telelogic.rhapsody.core.IRPModelElement
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DDS4CCMFactory
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.util.RhapsodyZDLUtil
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.idl3plus.api.Deployment.PerPortConnectorTypeDeploymentPart
import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation
import com.zeligsoft.domain.zml.api.ZML_Deployments.ComponentDeploymentPart
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart
import com.zeligsoft.domain.zml.util.ZMLMMNames
import java.util.List
import org.eclipse.uml2.uml.Property

class DeploymentPartRhapsodyExt {
	
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    	
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;

    @Inject
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;
        
    @Inject extension DDS4CCMFactory
    @Inject extension RhapsodyZDLUtil
    
    def dispatch DeploymentPart importDeploymentPart(IRPAttribute source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, ZMLMMNames::DEPLOYMENT_PART, typeof(DeploymentPart)) as DeploymentPart
        if(element != null){
	        if(source.type != null){
	        	typeCache.put(source.fullPathName, element.asProperty)
	        	updateRequired.add(new ReferenceUpdateMetadata(null, null, 
	        		element.asProperty, source.type.fullPathName))
	        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(element.asProperty, source))
	        	source.dependencies.toList.forEach(IRPDependency d | d.importAllocation(element.asProperty))
	        }
        }
        
        return element
    }
    
    def void importAllocation(IRPDependency source, Property part){
    	if(!source.isZDLConcept(ZMLMMNames::ALLOCATION)){
    		return
    	}
    	val container = part.eContainer
    	val dependsOn = source.dependsOn
        val element = createZDLElement(container, "", ZMLMMNames::ALLOCATION, typeof(Allocation)) as Allocation
        element.asDependency.clients.add(part)
        if(dependsOn != null){
	    	updateRequired.add(new ReferenceUpdateMetadata(ZMLMMNames::ALLOCATION, ZMLMMNames::ALLOCATION__DEPLOYED_ON, 
	    		element.asDependency, dependsOn.fullPathName))
    	}
    }
    
    def dispatch ComponentDeploymentPart importDeploymentPart(IRPModelElement source, Object context) {
	}
    def dispatch ComponentDeploymentPart importComponentDeploymentPart(IRPAttribute source, Object context) {
    	val name = source.name
        val element = createZDLElement(context, name, ZMLMMNames::COMPONENT_DEPLOYMENT_PART, typeof(ComponentDeploymentPart)) as ComponentDeploymentPart
        if(element != null){
	        if(source.type != null){
	        	typeCache.put(source.fullPathName, element.asProperty)
	        	updateRequired.add(new ReferenceUpdateMetadata(null, null, 
	        		element.asProperty, source.type.fullPathName))
	        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(element.asProperty, source))
	        	source.dependencies.toList.forEach(IRPDependency d | d.importAllocation(element.asProperty))	        	
	        }
        }
        return element
    }
    
    def dispatch ComponentDeploymentPart importComponentDeploymentPart(IRPModelElement source, Object context) {
	}	
	
    def dispatch PerPortConnectorTypeDeploymentPart importPerPortDeploymentPart(IRPAttribute source, Object context) {
        val name = source.name
        val element = createZDLElement(context, name, IDL3PlusNames::PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART, 
        	typeof(PerPortConnectorTypeDeploymentPart)) as PerPortConnectorTypeDeploymentPart
        if(element != null){
	        if(source.type != null){
	        	typeCache.put(source.fullPathName, element.asProperty)
	        	updateRequired.add(new ReferenceUpdateMetadata(null, null, 
	        		element.asProperty, source.type.fullPathName))
	        	deploymentUpdateRequired.add(new DeploymentValueUpdateMetadata(element.asProperty, source))
	        	source.dependencies.toList.forEach(IRPDependency d | d.importAllocation(element.asProperty))	        	
	        }
        }
        return element
    }
    
    def dispatch PerPortConnectorTypeDeploymentPart importPerPortDeploymentPart(IRPModelElement source, Object context) {
	}	
}