package com.zeligsoft.domain.dds4ccm.rhapsody.transform

import com.google.inject.Inject
import com.google.inject.name.Named
import com.telelogic.rhapsody.core.IRPPackage
import com.telelogic.rhapsody.core.IRPProject
import com.telelogic.rhapsody.core.RhapsodyAppServer
import com.zeligsoft.base.zdl.util.ZDLUtil
import com.zeligsoft.domain.dds4ccm.rhapsody.RhapsodyTraceabilityCache
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.DataCollector
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ConnectorUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.DeploymentValueUpdateRhapsodyExt
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.ReferenceUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.referencephase.RelationUpdateMetadata
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil
import com.zeligsoft.domain.idl3plus.IDL3PlusNames
import com.zeligsoft.domain.omg.corba.util.CORBAUtil
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.BehavioredClassifier
import org.eclipse.uml2.uml.Classifier
import org.eclipse.uml2.uml.ClassifierTemplateParameter
import org.eclipse.uml2.uml.ConnectableElement
import org.eclipse.uml2.uml.Interface
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.Type
import org.eclipse.uml2.uml.TypedElement

class RhapsodyImport {
    @Inject 
    @Named(RhapsodyImportModule::TYPE_CACHE_BINDING)
    private RhapsodyTraceabilityCache typeCache;
    
    @Inject
    @Named(RhapsodyImportModule::UPDATE_LIST_BINDING)
    private List<ReferenceUpdateMetadata> updateRequired;
    
    @Inject 
    @Named(RhapsodyImportModule::RELATION_UPDATE_LIST_BINDING)
    private List<RelationUpdateMetadata> relationUpdateRequired;
    
    @Inject 
    @Named(RhapsodyImportModule::CONNECTOR_UPDATE_LIST_BINDING)
    private List<ConnectorUpdateMetadata> connectorUpdateRequired;    

    @Inject 
    @Named(RhapsodyImportModule::DEPLOYMENT_UPDATE_LIST_BINDING)
    private List<DeploymentValueUpdateMetadata> deploymentUpdateRequired;    
        
    @Inject extension RhapsodyImportTraversal
    
    @Inject extension DeploymentValueUpdateRhapsodyExt
    
    def void importRhasodyModel(Package container) {
        val application = RhapsodyAppServer::activeRhapsodyApplication
        try {
            if(application != null) {
                val rhapsodyProject = application.activeProject;
                container.doImportRhapsodyModel(rhapsodyProject)
            }
        } finally {
            if (application != null) {
                //application.quit
            }
        }
    }
    
    def void importRhasodyModelWithRecordingProxies(Package container) {
        val application = RhapsodyAppServer::activeRhapsodyApplication
        try {
            if(application != null) {
            	val collector = new DataCollector()
                val rhapsodyProject = collector.proxy(application.activeProject) as IRPProject;
                container.doImportRhapsodyModel(rhapsodyProject)
                collector.dump("c:\\tmp\\RPData.xml")
            }
        } finally {
            if (application != null) {
            }
        }
    }
    
    def void importRhapsodyModel(Package container, IRhapsodyProjectLocationStrategy projectLocator) {
         try {
            val rhapsodyProject = projectLocator.getProject()
                container.doImportRhapsodyModel(rhapsodyProject)
        } finally {
        }
    	
    }
    
    def void importRhasodyModel2(Package container, Object project) {
        try {
            if(project instanceof IRPProject) {
                val rhapsodyProject = project as IRPProject
                container.doImportRhapsodyModel(rhapsodyProject)
            }
        } finally {
        }
    }
    
    def private void doImportRhapsodyModel(Package container, IRPProject rhapsodyProject){
        val packagesInProject = rhapsodyProject.packages.toList

        // Resolve all ZDL resources
        ZDLUtil::getZDLConcepts(container);
                        
        packagesInProject.forEach(IRPPackage pkg | map(pkg, container))
        
        processRequiredUpdates()
        
        DDS4CCMMigrationUtil::repairAllWorkerfunctions(container)
    }
    
    def private processRequiredUpdates() {
        updateRequired.forEach(metadata | metadata.processRequiredUpdate)
        relationUpdateRequired.forEach(metadata | metadata.processRelationRequiredUpdate)
        connectorUpdateRequired.forEach(metadata | metadata.processConnectorRequiredUpdate)
        deploymentUpdateRequired.forEach(metadata | metadata.processDeploymentRequiredUpdate)
        
    }
    
    def private processDeploymentRequiredUpdate(DeploymentValueUpdateMetadata metadata){
    	val element = metadata.element
    	val rhapsodyPart = metadata.rhapsodyDeploymentPart
        val value = rhapsodyPart.getTag(CXRhapsodyConstants::DEPLOYMENT_INSTANT_VALUE_TAG_NAME)
        if(value != null){
	        element.transformDeploymentValue(value, rhapsodyPart)
        }
    }
    
      
    def private processConnectorRequiredUpdate(ConnectorUpdateMetadata metadata) {
    	val sourceEnd = metadata.sourceEnd
    	val targetEnd = metadata.targetEnd
    	
    	val EObject sourceRole = typeCache.get(metadata.sourceRole)
    	sourceEnd.setRole(sourceRole as ConnectableElement)
   		val EObject targetRole = typeCache.get(metadata.targetRole)
    	targetEnd.setRole(targetRole as ConnectableElement)
        if(metadata.sourcePartWithPort != null){
	        val EObject sourcePart = typeCache.get(metadata.sourcePartWithPort)
	        sourceEnd.setPartWithPort(sourcePart as Property)
        }
        if(metadata.targetPartWithPort != null){
	        val EObject targetPart = typeCache.get(metadata.targetPartWithPort)
	        targetEnd.setPartWithPort(targetPart as Property)
	    }
    }
      
    def private processRelationRequiredUpdate(RelationUpdateMetadata metadata) {
        val EObject transformedType = typeCache.get(metadata.target)
        val source = metadata.source
        val type = metadata.type.name
        if(transformedType != null){
	        switch(type){
	        	case "Usage":
	        		(source as NamedElement).createUsage(transformedType as NamedElement)
	        	case "Dependency":
	        		(source as NamedElement).createDependency(transformedType as NamedElement)
	        	case "Generalization":
	        		(source as Classifier).createGeneralization(transformedType as Classifier)
	        	case "InterfaceRealization":
	        		(source as BehavioredClassifier).createInterfaceRealization("", transformedType as Interface)        		
	        	default:{}
	        }
        }
    }
        
    def private processRequiredUpdate(ReferenceUpdateMetadata metadata) {
    	var EObject transformedType = getTransformedType(metadata);

        if(transformedType != null) {
        	if(metadata.zdlConcept != null){
        		val value = ZDLUtil::getValue(metadata.rsaElement, metadata.zdlConcept, metadata.zdlFeature)
        		if(value instanceof List){
        			(value as List).add(transformedType)
        		}else{
	            	ZDLUtil::setValue(metadata.rsaElement, metadata.zdlConcept, metadata.zdlFeature, transformedType)
            	}
            }else if(metadata.rsaElement instanceof TypedElement && transformedType instanceof Type){
            	// setting members type
            	(metadata.rsaElement as TypedElement).setType(transformedType as Type)
            }
        }
    }
    
	def EObject getTransformedType(ReferenceUpdateMetadata metadata) {
		var EObject result = null
		val rhapsodyElement = metadata.rhapsodyElement
		
		if(IDL3PlusNames::PARAMETER_BINDING__TYPE_PARAMETER.equals(metadata.zdlFeature)){
			val split = rhapsodyElement.split("\\.")
			if(split.size != 2){
				return null
			}
			val templateModule = split.get(0);
			val rsaTemplateModule = typeCache.get(templateModule)
			if(rsaTemplateModule != null){
				val signature = ZDLUtil::getEValue(rsaTemplateModule,
				IDL3PlusNames::TEMPLATE_MODULE,
				IDL3PlusNames::TEMPLATE_MODULE__SIGNATURE);
				if(signature != null){
					val parameters = ZDLUtil::getValue(signature,
						IDL3PlusNames::TEMPLATE_SIGNATURE,
						IDL3PlusNames::TEMPLATE_SIGNATURE__TYPE_PARAMETER)
					for(ClassifierTemplateParameter p: parameters as List<ClassifierTemplateParameter>){
						val paramElement = p.ownedParameteredElement
						if(paramElement instanceof NamedElement){
							if(split.get(1).equals((paramElement as NamedElement).name)){
								return p
							}
						}
					}
				}
			}
		}else if(IDL3PlusNames::MODULE_BINDING__TEMPLATE.equals(metadata.zdlFeature)){
			val rsaTemplateModule = typeCache.get(rhapsodyElement)
			val signature = ZDLUtil::getEValue(rsaTemplateModule,
				IDL3PlusNames::TEMPLATE_MODULE,
				IDL3PlusNames::TEMPLATE_MODULE__SIGNATURE);
			return signature
		}
		
		result = typeCache.get(metadata.rhapsodyElement)
		
        if(result == null) {
        	var String corbaPrimitive = ""
        	if(rhapsodyElement.equals("void")){
        		corbaPrimitive = "CORBAVoid"
        	}
        	if(rhapsodyElement.startsWith("IDLPrimitives::")){
        		val split = rhapsodyElement.split("::")
        		corbaPrimitive = split.get(1)
        	}
        	if(corbaPrimitive != ""){
        		result = CORBAUtil::getCORBAPrimitiveType(metadata.rsaElement, corbaPrimitive)
        	}
		}
		if(result instanceof ClassifierTemplateParameter ){
			val param = result as ClassifierTemplateParameter;
			result = param.ownedParameteredElement
		}
		return result
	}

}